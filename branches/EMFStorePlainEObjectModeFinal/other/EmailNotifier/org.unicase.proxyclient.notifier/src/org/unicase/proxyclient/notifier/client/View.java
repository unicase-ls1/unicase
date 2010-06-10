package org.unicase.proxyclient.notifier.client;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class View extends ViewPart {
	public static final String ID = "org.unicase.proxyclient.notifier.client.view";

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		Label label = new Label(parent, SWT.PUSH);
		label.setText("Starting proxy client.");
		
		try {
			System.out.println( "proxy starten" );
			new NotifierProxyClientEntryPoint().run();
		
		} catch (Exception e) {
			label.setText( e.getMessage() );
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}