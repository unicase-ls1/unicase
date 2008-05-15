package org.unicase.emfstore;

import java.io.File;

public class ServerConfiguration {

	public final static String RESOURCE_STORAGE = "ResourceStorage";
	
	public final static String DEFAULT_RESOURCE_STORAGE = "org.unicase.emfstore.storage.TeneoStorage";
		
	public static String getConfDirectory() {
		StringBuffer sb = new StringBuffer();
		sb.append(".");
		sb.append(File.separatorChar);
		sb.append("conf");
		sb.append(File.separatorChar);
		return sb.toString();
	}
	
	public static String getConfFile() {
		return getConfDirectory()+"es.properties";
	}
}
