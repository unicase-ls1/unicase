package org.unicase.workspace;

public class PrimaryVersionSpec extends VersionSpec {
	
	private static final String HEAD = "HEAD";
	private String spec;
	
	private PrimaryVersionSpec(String spec) {
		this.spec=spec;
	}
	
	public static PrimaryVersionSpec getHEADSpec() {
		return new PrimaryVersionSpec(HEAD);
	}
}
