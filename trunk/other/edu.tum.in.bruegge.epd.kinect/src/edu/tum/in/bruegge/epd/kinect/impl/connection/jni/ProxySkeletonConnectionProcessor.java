package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Logger;

import microsoftkinectwrapper.KinectHandler;
import net.sf.jni4net.Bridge;
import edu.tum.in.bruegge.epd.kinect.impl.ConnectionProcessor;
import edu.tum.in.bruegge.epd.kinect.impl.SkeletonParser;

public class ProxySkeletonConnectionProcessor extends ConnectionProcessor {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private boolean run = false;

	private KinectHandler kinectHandlerProxy;
	
	public void init() {
		try {
			Bridge.init();
			URL url = this.getClass().getResource("/MicrosoftKinectWrapper.j4n.dll");
			Bridge.LoadAndRegisterAssemblyFrom(new File(url.toURI()));
		} catch (IOException ioe) {
			// TODO: handle exception
			ioe.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.kinectHandlerProxy = new KinectHandler();
	}
	
	@Override
	public void run() {
		logger.info("Starting skeleton tracking");
		super.run();

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
						this.inputDataHandler.handleSkeletonInput(inputParts[i]);
						break; // TODO Do we want all skeleton frames collected in 50ms or only one frame?
					}
				}
			} else { // Lost skeleton
				this.inputDataHandler.handleSkeletonInput(inputParts[0]);
			}
		}

		// Sleep for 50ms - give Kinect some time to collect skeleton data
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startSkeletonTracking() {
		logger.info("Initializing skeleton tracking");
		this.kinectHandlerProxy.setUpAndRun(); // Ignoring the return value "Setup Done!"
	}
	
	public void testSkeletonTracking() {
		logger.info("Testing skeleton tracking");
		String result = this.kinectHandlerProxy.testSkeletonTracking();
		System.out.println("Result: " + result);
	}
}
