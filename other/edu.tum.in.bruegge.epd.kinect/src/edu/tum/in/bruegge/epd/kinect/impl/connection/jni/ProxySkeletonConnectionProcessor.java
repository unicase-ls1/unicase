package edu.tum.in.bruegge.epd.kinect.impl.connection.jni;

import java.io.File;
import java.io.IOException;

import edu.tum.in.bruegge.epd.kinect.impl.ConnectionProcessor;

import microsoftkinectwrapper.KinectHandler;
import net.sf.jni4net.Bridge;

public class ProxySkeletonConnectionProcessor extends ConnectionProcessor {

	private boolean run = false;

	private KinectHandler kinectHandlerProxy;
	
	public void init() {
		try {
			Bridge.init();
			Bridge.LoadAndRegisterAssemblyFrom(new File("lib/MicrosoftKinectWrapper.j4n.dll"));
		} catch (IOException ioe) {
			// TODO: handle exception
		}
		
		this.kinectHandlerProxy = new KinectHandler();
	}
	
	@Override
	public void run() {
		super.run();

		this.run = true;

		while (this.run) {
			String input = this.kinectHandlerProxy.getSkeleton();
			if (input != null) {
				String[] inputParts = input.split("\\*");
				
				System.out.println("Skeleton: " + inputParts);
				this.inputDataHandler.handleSkeletonInput(inputParts[0]);
			}
		}
	}

	public void shutdown() {
		this.run = false;
	}
	
	public void startSkeletonTracking() {
		String result = this.kinectHandlerProxy.setUpAndRun();
		System.out.println("Result: " + result);
	}
	
	public void testSkeletonTracking() {
		String result = this.kinectHandlerProxy.testSkeletonTracking();
		System.out.println("Result: " + result);
	}
}
