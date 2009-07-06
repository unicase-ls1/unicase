package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;



public class PropertiesForm extends Form {
	
	private EObject input;
	private Composite body;
	private StackLayout stackLayout;
	private ProjectComposite projectComposite;
	private GroupComposite groupComposite;
	private UserComposite userComposite;
	private AdminBroker adminBroker;
	private OrgUnitManagementGUI orgUnitMgmtGUI;
	
	public static EObject dragNDropObject;
	public static String dragSource = "";
	

	public PropertiesForm(Composite parent, int style, AdminBroker adminBroker, OrgUnitManagementGUI orgUnitManagementGUI) {
		super(parent,  style);
		
		body = this.getBody();
		stackLayout = new StackLayout();
		body.setLayout(stackLayout);
		this.adminBroker= adminBroker;
		this.orgUnitMgmtGUI = orgUnitManagementGUI;
		initComposites();
		
		
	}

	private void initComposites() {
		projectComposite = new ProjectComposite(body, SWT.NONE, adminBroker, orgUnitMgmtGUI);
		groupComposite = new GroupComposite(body, SWT.NONE, adminBroker, orgUnitMgmtGUI);
		userComposite = new UserComposite(body, SWT.NONE, adminBroker, orgUnitMgmtGUI);
	
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
			ACGroup group;
			try {
				group = (ACGroup)adminBroker.getOrgUnit(((ACGroup)input).getId());
				title = "Group: " + group.getName();
				stackLayout.topControl = groupComposite;
				groupComposite.updateControls(group);
			} catch (EmfStoreException e) {
				// ZH Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (input instanceof ACUser){
			ACUser user;
			try {
				user = (ACUser)adminBroker.getOrgUnit(((ACUser) input).getId());
				title = "User: " + user.getName();
				stackLayout.topControl = userComposite;
				userComposite.updateControls(user);
			} catch (EmfStoreException e) {
				// ZH Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(input == null){
			((FormContents)stackLayout.topControl).updateControls(null);
		}
		body.layout();
		this.setText(title);
		this.input = input;

	}
	
		
	public EObject getCurrentInput(){
		return input;
	}

		
}
