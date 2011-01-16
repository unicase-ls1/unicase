package org.unicase.changetracking.ui.createChangePackage;


import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.ImageAndTextLabel;
import org.unicase.changetracking.ui.dialogs.AttacheeSelectionDialog;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.ui.navigator.ContentProvider;

public class ChooseNameAndDescriptionPage extends WizardPage{

	private static final String ERROR_MESSAGE = "Choose a name, short and long description for your change package. They will be used in the created branch, commit and model elements.";
	private ChangeTrackingRelease release;
	private ImageAndTextLabel workItemLabel;
	private ILabelProvider labelProvider;
	private Composite composite;
	private Text nameInput;
	private Text shortDescInput;
	private Text longDescInput;
	private boolean validInput = true;
	private Map<String, Ref> refNames;
	
	public String getSelectedName(){
		return nameInput.getText();
	}
	
	public String getSelectedShortDescription(){
		return shortDescInput.getText();
	}
	
	public String getSelectedLongDescription(){
		return longDescInput.getText();
	}
	
	protected ChooseNameAndDescriptionPage(String pageName, String title,
			ImageDescriptor titleImage, Repository repo) {
		super(pageName, title, titleImage);
		
		refNames = repo.getAllRefs();
		
		
	}

	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).margins(10, 10).spacing(5, 5).applyTo(composite);
		setControl(composite);
		
		//Layout datas
		GridDataFactory fillAll = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true);
		GridDataFactory fillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false);
		GridDataFactory notFillOneColLayout = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(false, false);
		int textStyleBits = SWT.BORDER;
		int descriptionStyleBits = SWT.NONE;
		
		//Listeners
		ModifyListener updateListener = new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				updateFields();
				
			}
		}; 
		
		
		//First line
		Label label = new Label(composite, descriptionStyleBits);
		label.setText("Name:");
		notFillOneColLayout.applyTo(label);
		nameInput = new Text(composite, textStyleBits);
		fillOneColLayout.applyTo(nameInput);
		nameInput.addModifyListener(updateListener);
		
		//Second line
		label = new Label(composite, descriptionStyleBits);
		label.setText("Short Description:");
		notFillOneColLayout.applyTo(label);
		shortDescInput = new Text(composite, textStyleBits);
		fillOneColLayout.applyTo(shortDescInput);
		shortDescInput.addModifyListener(updateListener);
		
		//Third line
		label = new Label(composite, descriptionStyleBits);
		label.setText("Long Description:");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(label);
		longDescInput = new Text(composite, textStyleBits | SWT.MULTI);
		fillAll.applyTo(longDescInput);
		longDescInput.addModifyListener(updateListener);

		updateFields();
	}
	
	private static final Pattern EMPTY_PATTERN = Pattern.compile("\\s*");
	private static final Pattern DISALLOWED_PATTERN = Pattern.compile("(\\\\)|(\\/)");
	
	private boolean isEmpty(Text input){
		return EMPTY_PATTERN.matcher(input.getText()).matches();
	}

	private void updateFields() {
		if (isEmpty(nameInput) || isEmpty(shortDescInput) || isEmpty(longDescInput)){

			setMessage(ERROR_MESSAGE,DialogPage.ERROR);
			if (validInput){
				validInput = false;
				((CreateChangePackageWizard) getWizard()).setFinishable(false);
			}
		} else if (!isNameValid()){
			setMessage("The name contains invalid characters",DialogPage.ERROR);
			if(validInput){
				validInput = false;
				((CreateChangePackageWizard) getWizard()).setFinishable(false);
			}
		} else if (isNameUsed()){
			setMessage("The name is already used by a branch in the repository",DialogPage.ERROR);
			if(validInput){
				validInput = false;
				((CreateChangePackageWizard) getWizard()).setFinishable(false);
			}
		} else {
			setMessage("",DialogPage.NONE);
			if (!validInput){
				validInput = true;
				((CreateChangePackageWizard) getWizard()).setFinishable(true);
			}
		}

	}

	private boolean isNameValid() {
		return !DISALLOWED_PATTERN.matcher(nameInput.getText()).find();
	}

	private boolean isNameUsed() {
		String text = nameInput.getText();
		if(refNames.containsKey(text)||refNames.containsKey("refs/heads/" + text)){
			return true;
		}
		return false;
	}

	
	
	
	

}
