package org.unicase.proxyclient.notifier.email;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.InvalidFileFormatException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class MailerTester {
	
	private MailerInfo info;
	
	@Before
	public void before() throws InvalidFileFormatException, IOException, BackingStoreException {
		String workspaceDirectory = org.unicase.workspace.Configuration.getWorkspaceDirectory();
		String propertyFile = workspaceDirectory + "notifierProxyClient.ini";

		Ini ini = new Ini(new File(propertyFile));
		IniPreferences iniPreferences = new IniPreferences( ini );
        for(String section: iniPreferences.childrenNames() ) {
    		final String host = iniPreferences.node( section ).get("SMTPhost", null);
    		final int port = iniPreferences.node( section ).getInt("SMTPport", 0);
    		final String user = iniPreferences.node( section ).get("SMTPuser", null);
    		final String password = iniPreferences.node( section ).get("SMTPpassword", null);
    		final boolean useSSL = iniPreferences.node( section ).getBoolean("SMTPuseSSL", false);
    		final String sender = iniPreferences.node( section ).get("SMTPsender", null);
    		
    		info = new MailerInfo(host, port, user, password, useSSL, sender);
    		break;
        }
	}
	
	@Test
	public void testMail() {
		Mailer mailer = new Mailer(info);
		boolean ok = mailer.send("adrian@staudts.eu", "TestMail", "Nachricht");
		assertTrue( ok );
	}
	
}
