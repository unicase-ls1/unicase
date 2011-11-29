package org.unicase.ui.visualization.views;

import java.awt.Frame;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.ui.visualization.tree.UnicaseHyperbolicView;
import org.unicase.ui.visualization.tree.UnicaseNode;
import org.unicase.ui.visualization.tree.UnicaseSunburstView;
import org.unicase.ui.visualization.tree.UnicaseTree;
import org.unicase.ui.visualization.tree.UnicaseView;
import org.unicase.ui.visualization.util.VisualizationUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.observers.OperationListener;

import ch.randelshofer.tree.sunburst.SunburstTree;

/**
 * 
 * This view displays a visualization of the unicase projects.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class VisualizationView extends ViewPart { 

	private UnicaseView view;
	private UnicaseView referenceView;
	private ProjectSpace currentProjectSpace;
	private UnicaseTree tree;
	private Frame mainFrame;
	private Frame referenceFrame;
	private SashForm sash;
	
	/**
	 * The different available viewtypes.
	 */
	public static enum ViewTypes {SUNBURST, HYPERBOLIC}
				
	/**
	 * Register the {@link SelectionListener}, to listen on Navigator selection.
	 */
	@Override
	public void createPartControl(Composite parent) {		
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {				
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				// check for project, build a tree and show it
				if (obj instanceof ProjectSpace) {										
					setProject((ProjectSpace) obj);	
					
				// check for other EObject and select the node in the visualization
				} else if(obj instanceof EObject){
					EObject eObj = (EObject)obj;										
					setProject(VisualizationUtil.getProjectSpace(eObj));										
					((UnicaseView)view).selectNode(tree.getNodes().get(eObj));	
				}
			}
		});
		
		sash = new SashForm(parent, SWT.HORIZONTAL);
		mainFrame = SWT_AWT.new_Frame(new Composite(sash, SWT.EMBEDDED | SWT.NO_BACKGROUND));
		referenceFrame = SWT_AWT.new_Frame(new Composite(sash, SWT.EMBEDDED | SWT.NO_BACKGROUND));		
	}
		
	/**
	 * Sets a {@link ProjectSpace}, when it is not already set.
	 * See {@link #forceSetProject(ProjectSpace)} to force the setting.
	 * 
	 * @param projectSpace The ProjectSpace to set.
	 */
	public void setProject(ProjectSpace projectSpace){
		if(projectSpace.equals(currentProjectSpace)) return;		
		forceSetProject(projectSpace);
	}
	
	/**
	 * Forces setting a {@link ProjectSpace}.
	 * 
	 * @param projectSpace
	 */
	public void forceSetProject(ProjectSpace projectSpace){
		if(currentProjectSpace != null)	currentProjectSpace.removeOperationListener(operationListener);
		projectSpace.addOperationListener(operationListener);
			
		currentProjectSpace = projectSpace;
		tree = new UnicaseTree(new UnicaseNode(projectSpace));
		showSunburstTreeView();	
	}
	
	/**
	 * The {@link OperationListener}, which listens to the project, 
	 * to update the view on changes.
	 */
	private OperationListener operationListener = new OperationListener() {
		
		@Override
		public void operationUnDone(AbstractOperation operation) {
			forceSetProject(currentProjectSpace);
		}
		
		@Override
		public void operationExecuted(AbstractOperation operation) {
			forceSetProject(currentProjectSpace);
		}
	};
		
	/**
	 * Show a SunbustView and update the UI.
	 */
	public void showSunburstTreeView(){		
		view = new UnicaseSunburstView(tree, new SunburstTree(tree.getRoot(), tree.getInfo()), this);
		referenceView = new UnicaseHyperbolicView(tree, new UnicaseNode(""));
		updateView();
    }
	
	/**
	 * Show a HyperbolicView and update the UI.
	 */
	public void showHyperbolicTreeView(){
		view = new UnicaseHyperbolicView(tree);		
		updateView();
    }
	
	public void setSelectedNode(UnicaseNode node){
		referenceView = new UnicaseHyperbolicView(tree, node.getReferenceNode());
		updateView();
	}
	
	/**
	 * Update the UI.
	 */
	public void updateView() {		
		mainFrame.removeAll();
		mainFrame.add(view.getView());
		referenceFrame.removeAll();
		referenceFrame.add(referenceView.getView());		
		mainFrame.validate();
		referenceFrame.validate();
	}
	
	/**
	 * Set focus to the main composite.
	 */
	@Override
	public void setFocus() {
		sash.setFocus();
	}

	/**
	 * Get the {@link UnicaseView}.
	 *  
	 * @return the current {@link UnicaseView}.
	 */
	public UnicaseView getView() {
		return view;
	}
}
