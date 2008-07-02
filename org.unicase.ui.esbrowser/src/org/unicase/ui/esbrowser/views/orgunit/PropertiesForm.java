package org.unicase.ui.esbrowser.views.orgunit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.workspace.WorkspaceManager;



public class PropertiesForm extends Form {
	
	private Group grpAttributes, grpList;
	private EObject input;
	private List<IItemPropertyDescriptor> simpleAttributes = new ArrayList<IItemPropertyDescriptor>();;
	private FormToolkit toolkit;
	private TransactionalEditingDomain editingDomain;
	private StackLayout stackLayout;
	private ProjectComposite projectComposite;
	private GroupComposite groupComposite;
	private UserComposite userComposite;
	
	public static EObject dragNDropObject;
	

	public PropertiesForm(Composite parent, int style) {
		super(parent,  style);
		this.toolkit = new FormToolkit(parent.getDisplay());
		this.editingDomain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
		stackLayout = new StackLayout();
		this.getBody().setLayout(stackLayout);
		initComposites();
		
		
	}

	private void initComposites() {
		projectComposite = new ProjectComposite(this.getBody(), SWT.NONE);
		groupComposite = new GroupComposite(this.getBody(), SWT.NONE);
		userComposite = new UserComposite(this.getBody(), SWT.NONE);
	
		stackLayout.topControl = projectComposite;
			
	}

	public void setInput(EObject input) {
		String title = "";
		if (input instanceof ProjectInfo){
			ProjectInfo projectInfo = (ProjectInfo)input;
			title = "Project: " + projectInfo.getName();
			stackLayout.topControl = projectComposite;
			projectComposite.updateControls(projectInfo);
			
			
		}else if(input instanceof ACGroup){
			ACGroup group = (ACGroup)input;
			title = "Group: " + group.getName();
			stackLayout.topControl = groupComposite;
			groupComposite.updateControls(group);
			
		}else if (input instanceof ACUser){
			ACUser user = (ACUser) input;
			title = "User: " + user.getName();
			stackLayout.topControl = userComposite;
			userComposite.updateControls(user);
		}
		this.getBody().layout();
		this.setText(title);
		this.input = input;

	}

		
}
