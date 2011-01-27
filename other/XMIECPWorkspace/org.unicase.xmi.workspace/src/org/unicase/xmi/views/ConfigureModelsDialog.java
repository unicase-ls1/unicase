package org.unicase.xmi.views;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.util.UnicaseUtil;
import org.unicase.xmi.commands.ConfigureModelsHandler;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;

/**
 * Userinterface to ask which models should be used by the project.
 * @author matti, markus
 *
 */
public class ConfigureModelsDialog extends TitleAreaDialog {

	/**
	 * Handler which invoked the dialog
	 */
	private final ConfigureModelsHandler handler;
	
	/**
	 * Title of the dialog
	 */
	protected String dialogTitle;
	
	/**
	 * Message of the dialog
	 */
	protected String dialogMessage;
	
	/**
	 * Holding the models to register.
	 */
	private XmiListViewer viewer;

	/**
	 * The project associated with the chosen models.
	 */
	private final XMIECPFileProject project;

	/**
	 * Creates a new Dialog to configure the models of a project.
	 * @param parentShell Shell in which the Dialog is created.
	 * @param handler Handler that started the dialog.
	 * @param project The associated project for the dialog.
	 */
	public ConfigureModelsDialog(Shell parentShell, ConfigureModelsHandler handler, XMIECPFileProject project) {
		super(parentShell);
		this.handler = handler;
		this.project = project;
		
		this.dialogTitle = "Configure Models";
		this.dialogMessage = "Please select the models for your project from the list.";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// new composite with a grid layout
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// set title and message
		setTitle(dialogTitle);
		setMessage(dialogMessage);
		
		// create selection area
		viewer = new XmiListViewer(contents);
		
		// add all models to the viewer
		Iterator<EClass> iterator = UnicaseUtil.getAllModelElementEClasses().iterator();
		
		List<String> alreadyAdded = new ArrayList<String>();
		
		while(iterator.hasNext()) {
			EClass next = iterator.next();
			String epackage = next.getEPackage().getNsPrefix();
			
			if(!alreadyAdded.contains(epackage)) {
				viewer.add(epackage);
				alreadyAdded.add(epackage);
			}
		}
		
		// get the registered models and mark them
		MetaModelElementContext context = project.getMetaModelElementContext();
		if(context instanceof XMIMetaModelElementContext) {
			XMIMetaModelElementContext xmiContext = (XMIMetaModelElementContext) context;
			List<String> models = xmiContext.getModels();
			viewer.setSelection(new StructuredSelection(models));
		}
		
		// Set layout in general
		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(1).margins(
				defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void okPressed() {
		handler.setModelList(viewer.listGetSelection());
		close();
	}
}
