package de.tum.kinect.api.poc;

public class JNiCallBackExample {

	static {
		System.loadLibrary("CPPLib");
	}

	public native void initConfig(JNiCallBackExample kinectSpeechObj,
			String[] string);

	public void callBack(String args) {
		System.out.println("[Java] Reply from C++ layer : " + args);
	}

	public static void main(String[] args) {
		System.out.println("[Java] Init Configuration");
		JNiCallBackExample jniExample = new JNiCallBackExample();
		jniExample.initConfig(jniExample, new String[] { "Open Resource",
				"Debug", "Step Into" });
	}
}
