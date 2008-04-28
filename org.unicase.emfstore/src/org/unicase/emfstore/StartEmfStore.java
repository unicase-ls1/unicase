package org.unicase.emfstore;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class StartEmfStore implements IApplication {

	public Object start(IApplicationContext context) throws Exception {
		
		System.out.println("Server is running...");

		System.out.println("Server stopped.");
		return IApplication.EXIT_OK;
	}

	public void stop() {
		System.out.println("Server stopped abnormally.");

	}

}
