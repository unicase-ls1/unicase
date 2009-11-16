/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.snippets;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.onpositive.richtexteditor.viewer.IRichDocumentListener;
import com.onpositive.richtexteditor.viewer.RichTextViewer;
import com.onpositive.richtexteditor.viewer.undo.RichDocumentChange;

/**
 * @author kor
 *
 */
public class BrowserSample  {	

	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Shell shell = new Shell(SWT.SHELL_TRIM);
		shell.setLayout(new GridLayout(2, true));
		final RichTextViewer richTextViewer = new RichTextViewer(shell, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 1;
		gridData.minimumWidth = 200;
		gridData.minimumHeight = 400;
		richTextViewer.getControl().setLayoutData(gridData);		
		final Browser browser = new Browser(shell, SWT.BORDER );
		GridData gridData1 = new GridData(GridData.FILL_BOTH);
		gridData1.horizontalSpan = 1;
		gridData1.minimumWidth = 200;
		gridData1.minimumHeight = 400;
		browser.setLayoutData(gridData1);				
		richTextViewer.addRichDocumentListener(new IRichDocumentListener(){

			public void documentAboutToBeChanged(DocumentEvent event) {				
			}

			public void documentChanged(DocumentEvent event,
					RichDocumentChange change) {
				String s =richTextViewer.getLayerManager().getSerializedString();
				browser.setText(s);		
			}
			
		});		
		Display display = shell.getDisplay();
		shell.pack();
		shell.open();
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();		
	}

}
