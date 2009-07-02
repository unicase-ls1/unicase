package org.unicase.linkrecommendationevaluation.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.util.EventUtil;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class EvaluationView extends ViewPart {
	private TableViewer viewer;
	private Action doubleClickAction;

	private String[] elements;
	
	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return elements;
		}
	}
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		@Override
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public EvaluationView() {
		elements = new String[] { "Start Evaluation"};
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.unicase.linkRecommendationEvaluation.viewer");

		doubleClickAction = new StartEvaluationAction();

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}


	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
		
	class StartEvaluationAction extends Action{
		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection)selection).getFirstElement();
			
			if(obj == elements[0]) {
				EList<ProjectSpace> all = WorkspaceManager.getInstance().getCurrentWorkspace()
					.getProjectSpaces();
				
				String text = "";
				for(ProjectSpace project : all) {
					//if(element.eClass())
					text += project.getProjectName()+" ";
					TreeIterator<EObject> tree = project.eAllContents();
					while(tree.hasNext()) {
						EObject projObj = tree.next();
						if(projObj instanceof ModelElement) {
							if(projObj instanceof ActionItem) {
								ActionItem element = (ActionItem) projObj;
								text += "\n"+element.getName()+": ";
							}
						}
					}
				}
				showMessage(text);
			}else{
				showMessage("Double-click detected on "+obj.toString());
			}
		}
		
		private void showMessage(String message) {
			MessageDialog.openInformation(
				viewer.getControl().getShell(),
				"Evaluation View",
				message);
		}
	}
}

