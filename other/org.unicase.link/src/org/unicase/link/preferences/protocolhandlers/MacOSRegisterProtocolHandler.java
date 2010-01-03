package org.unicase.link.preferences.protocolhandlers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MacOSRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	@Override
	public void registerProtocolHandler() {
		String startUpJar;
		try {
			startUpJar = getStartUpJar();
			String libDir = startUpJar.substring(0, startUpJar.lastIndexOf(File.separatorChar));
			String zipFile = libDir + File.separator + "URLHandler.zip";
			unzip(zipFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unzip(String filePath) {
		Enumeration entries;
		ZipFile zipFile;

		// TODO: check whether file exists

		try {
			zipFile = new ZipFile(filePath);

			entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String extractDir = filePath.substring(0, filePath.lastIndexOf(File.separator));

				if (entry.isDirectory()) {
					// Assume directories are stored parents first then children.
					System.err.println("Extracting directory: " + entry.getName());
					// This is not robust, just for demonstration purposes.
					(new File(extractDir + File.separator + entry.getName())).mkdir();
					continue;
				}

				System.err.println("Extracting file: " + entry.getName());

				copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(extractDir
					+ File.separator + entry.getName())));
			}

			zipFile.close();
		} catch (IOException ioe) {
			System.err.println("Unhandled exception:");
			ioe.printStackTrace();
			return;
		}
	}

	public final void copyInputStream(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int len;

		while ((len = in.read(buffer)) >= 0)
			out.write(buffer, 0, len);

		in.close();
		out.close();
	}
}
