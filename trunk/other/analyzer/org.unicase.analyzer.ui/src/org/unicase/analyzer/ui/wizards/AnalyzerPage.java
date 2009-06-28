/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author liya
 *
 */
public class AnalyzerPage extends WizardPage {

	private static final String PAGE_TITLE = "Registered Analyzers";
	private static final String PAGE_DESCRIPTION = "Choose the analyzer.";
	private boolean canFlipToNextPage;

	protected AnalyzerPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		canFlipToNextPage = false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		
		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
	    gl.numColumns = ncol;
	    composite.setLayout(gl);
	    IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint =
		    registry.getExtensionPoint("org.unicase.analyzer.analyzer");
		IExtension[] extensions = extensionPoint.getExtensions();
		
		// For each extension ...
		 for (int i = 0; i < extensions.length; i++) {           
		     IExtension extension = extensions[i];
		     IConfigurationElement[] elements = 
		          extension.getConfigurationElements();
		        // For each member of the extension ...
		 for (int j = 0; j < elements.length; j++) {
		     IConfigurationElement element = elements[j];
		     Button analyzerButton = new Button(composite, SWT.RADIO);
		     analyzerButton.setText(element.getAttribute("class"));
			 gd = new GridData(GridData.FILL_HORIZONTAL);
			 gd.horizontalSpan = ncol;
			 analyzerButton.setLayoutData(gd);
			 analyzerButton.setSelection(false);
			 if(analyzerButton.getSelection()){
				 canFlipToNextPage = true;
			 }
		    }
		}
		setControl(composite);
		setPageComplete(true);

	}
	
	@Override
	public boolean canFlipToNextPage(){
//		return canFlipToNextPage;
		return true;
	}

	@Override
	public IWizardPage getNextPage() {		
		return super.getNextPage();
	}
}
