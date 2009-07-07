/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.unicase.analyzer.AnalyzerFactory;
import org.unicase.analyzer.DataAnalyzer;

/**
 * @author liya
 *
 */
public class AnalyzerPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Registered Analyzers";
	private static final String PAGE_DESCRIPTION = "Choose the analyzer.";
	private List<Button> analyzerButton = new ArrayList<Button>();
	//private boolean canFlipToNextPage;

	/**
	 * @param pageName Name of the page
	 */
	protected AnalyzerPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		//canFlipToNextPage = false;
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
		     int count = i*elements.length + j;
		     Button button = new Button(composite, SWT.RADIO);
		     button.setText(element.getAttribute("class"));
			 gd = new GridData(GridData.FILL_HORIZONTAL);
			 gd.horizontalSpan = ncol;
			 button.setLayoutData(gd);
			 button.setSelection(false);			 
			 analyzerButton.add(button);
			 analyzerButton.get(count).addListener(SWT.SELECTED, this);
		    }
		}
		setControl(composite);
		setPageComplete(true);

	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage(){
//		return canFlipToNextPage;
		return true;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {	
		for(Button button : analyzerButton){
			if(button.getSelection()){
				try {
					Class c = Class.forName(button.getText());			
					DataAnalyzer analyzer;
					analyzer = (DataAnalyzer) c.getConstructors()[0].newInstance();
					ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard)getWizard();
					//FIXME analyzer can not be set
//					wizard.getAnalyzerConfig().setAnalyzerClass(analyzer);
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		return super.getNextPage();
	}

	public void handleEvent(Event event) {
	}
}
