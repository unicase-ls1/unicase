/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.DataAnalyzer;

/**
 * @author liya
 *
 */
public class AnalyzerPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Registered Analyzers";
	private static final String PAGE_DESCRIPTION = "Choose the analyzer.";
	private List<Button> analyzerButton = new ArrayList<Button>();
	private boolean canFlipToNextPage;
	private ArrayList<DataAnalyzer> analyzers;


	/**
	 * @param pageName Name of the page
	 */
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
	    
	    AnalyzerConfiguration conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
	    analyzers = new ArrayList<DataAnalyzer>();
	    
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
		     final IConfigurationElement element = elements[j];
		     int count = i*elements.length + j;
		     Button button = new Button(composite, SWT.CHECK);
		     button.setText(element.getAttribute("class"));
			 gd = new GridData(GridData.FILL_HORIZONTAL);
			 gd.horizontalSpan = ncol;
			 button.setLayoutData(gd);
			 if(conf.getAnalyzerName() != null){
				 if(conf.getAnalyzerName().equals(button.getText())){
					 button.setSelection(true);
				 }
			 }else{
				 button.setSelection(false);
			 }			 
			 analyzerButton.add(button);
			// analyzerButton.get(count).addListener(SWT.CHECK, this);
			 analyzerButton.get(count).addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {
					widgetSelected(e);
					
				}

				public void widgetSelected(SelectionEvent e) {
					try {
						DataAnalyzer analyzer = (DataAnalyzer)element.createExecutableExtension("class");
						analyzers.add(analyzer);
						canFlipToNextPage = true;
						getWizard().getContainer().updateButtons();

					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}
				 
			 });
		    }
		}
		
		setCanFlipToNextPage(isPageComplete());
		setControl(composite);
		setPageComplete(true);

	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isPageComplete() {
		//final ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
		for(final Button button : analyzerButton){
			if(button.getSelection()){
	
				try {
					//Class c = Class.forName(button.getText());			
					//DataAnalyzer analyzer = (DataAnalyzer) c.getConstructors()[0].newInstance();
					final ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard)getWizard();
					//analyzers.add(analyzer);
					wizard.setAnalyzers(analyzers);
					
					TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.unicase.EditingDomain");
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							
							//TODO should set a list of analyzer names
							wizard.getAnalyzerConfig().setAnalyzerName(button.getText());
						}
					});

				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage(){
		return canFlipToNextPage;
	}
	
    /**
     * @param canFlipToNextPage true if can flip to next page
     */	
	public void setCanFlipToNextPage(boolean canFlipToNextPage) {
		this.canFlipToNextPage = canFlipToNextPage;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */

	@Override
	public IWizardPage getNextPage() {	
		setCanFlipToNextPage(isPageComplete());
		return super.getNextPage();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(event.widget instanceof Button){
			if(((Button) event.widget).getSelection()) {
				canFlipToNextPage = true;
			}
		}
		getWizard().getContainer().updateButtons();
	}
}
