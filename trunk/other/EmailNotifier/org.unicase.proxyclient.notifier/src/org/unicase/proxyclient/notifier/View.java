/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
import org.unicase.proxyclient.notifier.client.NotificationProxyClientException;
import org.unicase.proxyclient.notifier.client.NotifierProxyClient;

/**
 * @author staudta
 */
public class View extends ViewPart {
	
	/**
	 * ID of the view. NPC GUI will be opened by this ID.
	 */
	public static final String ID = "org.unicase.proxyclient.notifier.client.view";
	
	/**
	 * This is a callback that will allow us to create the viewer and initialize it.
	 * @param parent the composite parent
	 */
	public void createPartControl(Composite parent) {
		final Label label = new Label(parent, SWT.PUSH);
		IStatus status = new Status(Status.INFO, Activator.getDefault().getBundle().getSymbolicName(), "Starting Notification Proxy Client");
		addEntryToUILog(status, label);
		// adds a listener to the log
		Activator.getDefault().getLog().addLogListener( new ILogListener() {
			public void logging(final IStatus status, final String plugin) {
				// needed for changing swt ui from an different thread
				Runnable r = new Runnable(){
					public void run(){
						addEntryToUILog(status, label);
					}
				};
				
				label.getDisplay().asyncExec(r);
			}
		} );
		
		try {
			new NotifierProxyClient().run();
		
		} catch (NotificationProxyClientException e) {
			Activator.logException(e);
		}
	}
	
	private void addEntryToUILog(final IStatus status, final Label label) {
		final String oldText = label.getText();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		String date = sdf.format(new Date());
		String severity = null;
		if( status.getSeverity() == IStatus.INFO ) {
			severity = "INFO";
		} else if( status.getSeverity() == IStatus.WARNING ) {
			severity = "Warning";
		} else if( status.getSeverity() == IStatus.ERROR ) {
			severity = "Error";
		} else if( status.getSeverity() == IStatus.OK ) {
			severity = "OK";
		} else if( status.getSeverity() == IStatus.CANCEL ) {
			severity = "Cancel";
		} else {
			severity = "Unknown";
		}
		
		final String newMessageEntry = severity + " - " +date + ": " +status.getMessage();
		if( oldText.equals("") ) {
			label.setText(newMessageEntry);
			
		} else {
			label.setText( oldText + "\n" + newMessageEntry );
		}

	}
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}