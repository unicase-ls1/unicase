/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

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
	private List<IConfigurationElement> extendedAnalyzers;
	private AnalyzerConfiguration conf;
	private TransactionalEditingDomain editingDomain;

	/**
	 * @param pageName Name of the page
	 */
	protected AnalyzerPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		extendedAnalyzers = new ArrayList<IConfigurationElement>();
		canFlipToNextPage = false;
		editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
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
		     extendedAnalyzers.add(element);
		     Button button = new Button(composite, SWT.CHECK);
		     button.setText(element.getAttribute("class"));
			 gd = new GridData(GridData.FILL_HORIZONTAL);
			 gd.horizontalSpan = ncol;
			 button.setLayoutData(gd);
			 
			 button.addListener(SWT.Selection, this);
			 analyzerButton.add(button);
		    }
		}
		
		setCanFlipToNextPage(isPageComplete());
		setControl(composite);
//		setPageComplete(true);

	}
	
	/**
	 * Initialize this page editing domain.
	 */
	public void init(){
		conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();
		
		 for(Button button : analyzerButton){
			 if(conf.getAnalyzerName() != null){				
				 if(conf.getAnalyzerName().equals(button.getText())){
					 button.setSelection(true);
				 }
			 }else{
				 button.setSelection(false);
			 }	
		 }
	}
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		//final ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
		for(final Button button : analyzerButton){
			if(button.getSelection()){
				return true;
			}
		}
		return super.isPageComplete();
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
		
		for(final Button button : analyzerButton){
			int i = analyzerButton.indexOf(button);
			if(button.getSelection()){
	
				try {
					DataAnalyzer analyzer = (DataAnalyzer)extendedAnalyzers.get(i).createExecutableExtension("class");
					final ProjectAnalyzerWizard wizard = (ProjectAnalyzerWizard)getWizard();
					// Not add the same analyzer into the analyzer list
					boolean add = true;
					for(DataAnalyzer ana : analyzers){
						if( ana.getClass().equals(analyzer.getClass()) ){
							add = false;
						}
					}
					if(add){
						analyzers.add(analyzer);
					}
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
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		final IteratorPage page = (IteratorPage) super.getNextPage();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				page.init();
			}
		});
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
