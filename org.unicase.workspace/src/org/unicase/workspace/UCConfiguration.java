package org.unicase.workspace;

import java.io.File;

public class UCConfiguration {
	
	public static String getWorkspaceDirectory() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		sb.append(".unicase");
		sb.append(File.separatorChar);
		try {
			File workspace = new File(sb.toString());
			if (!workspace.exists()) {
				workspace.mkdir();
			}
		} catch (Exception e) {
			//FIXME MK
			e.printStackTrace();
		}
		return sb.toString();
	}
}
