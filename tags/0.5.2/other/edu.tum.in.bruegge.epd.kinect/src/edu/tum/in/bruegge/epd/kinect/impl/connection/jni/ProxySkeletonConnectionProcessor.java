package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import microsoftkinectwrapper.KinectHandler;
import net.sf.jni4net.Bridge;
import edu.tum.in.bruegge.epd.kinect.impl.ConnectionProcessor;
import edu.tum.in.bruegge.epd.kinect.impl.SkeletonParser;

public class ProxySkeletonConnectionProcessor extends ConnectionProcessor {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	private boolean run = false;

	private KinectHandler kinectHandlerProxy;
	
	public void init() {
		try {
			File dll = new File("lib/MicrosoftKinectWrapper.j4n.dll");
			if (!dll.exists()) {
				URL dllUrl = this.getClass().getResource("/MicrosoftKinectWrapper.j4n.dll");
				dll = new File(dllUrl.toURI());
			}
			
			Bridge.init();
			Bridge.LoadAndRegisterAssemblyFrom(dll);
		} catch (IOException ioe) {
			logger.log(Level.SEVERE, ioe.getLocalizedMessage(), ioe);
		} catch (URISyntaxException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		
		this.kinectHandlerProxy = new KinectHandler();
		this.kinectHandlerProxy.setUpAndRun(); // Ignoring the return value "Setup Done!"
	}
	
	@Override
	public void run() {
		logger.info("Starting skeleton tracking");
		
		this.run = true;
		while (this.run) {
			doRun();
		}
		
		logger.info("Shutting down.");
	}

	public void shutdown() {
		logger.info("Shutdown requested.");
		this.run = false;
	}
	
	private void doRun() {
		String input = this.kinectHandlerProxy.getSkeleton(); // This seems to be non-blocking
		if (input != null) {
			// The parts are separated with a '*'.
			String[] inputParts = input.split("\\*");
			if (input.contains(SkeletonParser.SKELETON_KEYWORD)) { // Found skeleton
				for (int i = 0; i < inputParts.length; i++) {
					if (inputParts[i].contains(SkeletonParser.SKELETON_KEYWORD)) {
						this.connectionDataHandler.handleSkeletonInput(inputParts[i]);
						break; // TODO Do we want all skeleton frames collected in 50ms or only one frame?
					}
				}
			} else { // Lost skeleton
				this.connectionDataHandler.handleSkeletonInput(inputParts[0]);
			}
		}

		// Sleep for 50ms - give Kinect some time to collect skeleton data
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
	}
}
