package org.unicase.ui.visualization.views;

import java.awt.Frame;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.visualization.tree.UnicaseHyperbolicView;
import org.unicase.ui.visualization.tree.UnicaseNode;
import org.unicase.ui.visualization.tree.UnicaseSunburstView;
import org.unicase.ui.visualization.tree.UnicaseTree;
import org.unicase.ui.visualization.tree.UnicaseView;
import org.unicase.ui.visualization.util.VisualizationUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.observers.OperationListener;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;

/**
 * 
 * This view displays a visualization of the unicase projects.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class VisualizationView extends ViewPart { 
	
	private ProjectSpace currentProjectSpace;
	private UnicaseTree tree;
	private UnicaseTree treeSpec1;
	private UnicaseTree treeSpec2;
		
	private SashForm sashHor;
		
	private HashMap<String, UnicaseView> views;
	private HashMap<String, Frame> frames;
	
	private final String LEFT = "left";
	private final String RIGHT_UP_LEFT = "rightUpLeft";
	private final String RIGHT_UP_RIGHT = "rightUpRight";
	private final String RIGHT_DOWN_LEFT = "rightDownLeft";
	private final String RIGHT_DOWN_RIGHT = "rightDownRight";
	
	private List<String> locators;
				
	/**
	 * Register the {@link SelectionListener}, to listen on Navigator selection.
	 * Also inits the UI.
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
					((UnicaseView)views.get(LEFT)).selectNode(tree.getNodes().get(eObj));	
				}
			}
		});
		
		views = new HashMap<String, UnicaseView>();	
		frames = new HashMap<String, Frame>();
		
		sashHor = new SashForm(parent, SWT.HORIZONTAL);		
		
		frames.put(LEFT, SWT_AWT.new_Frame(new Composite(sashHor, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
		
		SashForm sashVerRight = new SashForm(sashHor, SWT.VERTICAL);
		SashForm sashVerRightHorUp = new SashForm(sashVerRight, SWT.HORIZONTAL);
		SashForm sashVerRightHorDown = new SashForm(sashVerRight, SWT.HORIZONTAL);
		
		frames.put(RIGHT_UP_LEFT, SWT_AWT.new_Frame(new Composite(sashVerRightHorUp, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
		frames.put(RIGHT_UP_RIGHT, SWT_AWT.new_Frame(new Composite(sashVerRightHorUp, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
			
		frames.put(RIGHT_DOWN_LEFT, SWT_AWT.new_Frame(new Composite(sashVerRightHorDown, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
		frames.put(RIGHT_DOWN_RIGHT, SWT_AWT.new_Frame(new Composite(sashVerRightHorDown, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
					
		locators = Arrays.asList(new String[]{LEFT, RIGHT_UP_LEFT, RIGHT_UP_RIGHT, RIGHT_DOWN_LEFT, RIGHT_DOWN_RIGHT});
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
		
		for(String locator : locators) views.put(locator, UnicaseSunburstView.createUnicaseSunburstView(tree, this));
		setSelectedNode((UnicaseNode) tree.getRoot());
		updateView();
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
	 * Show to different versions of a project.
	 */
	public void showTwoVersionsView(){
		final VisualizationView vv = this;
		try {
			new ServerRequestCommandHandler() {
				
				@Override
				protected Object run() throws EmfStoreException {
					List<HistoryInfo> infos = tree.getHistoryInfos();
					if(infos.size() != 2) return null;					
											
					PrimaryVersionSpec spec = infos.get(0).getPrimerySpec();
					treeSpec1 = new UnicaseTree(new UnicaseNode(VisualizationUtil.getRevertedProjectSpace(currentProjectSpace, spec)));
					treeSpec1.addInfo("Version: " + spec.getIdentifier());
					
					spec = infos.get(1).getPrimerySpec();
					treeSpec2 = new UnicaseTree(new UnicaseNode(VisualizationUtil.getRevertedProjectSpace(currentProjectSpace, spec)));
					treeSpec2.addInfo("Version: " + spec.getIdentifier());
										
					views.put(RIGHT_UP_LEFT, UnicaseSunburstView.createUnicaseSunburstView(treeSpec1, vv));
					views.put(RIGHT_UP_RIGHT, UnicaseSunburstView.createUnicaseSunburstView(treeSpec2, vv));
					
					updateView();								
					return null;
				}
			}.execute(new ExecutionEvent());
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Set the currently selected {@link UnicaseNode}.
	 * 
	 * @param node The {@link UnicaseNode}, which is selected.
	 */
	public void setSelectedNode(UnicaseNode node){
		for(UnicaseView view : views.values()) view.selectNode(node);
		views.put(RIGHT_DOWN_LEFT, new UnicaseHyperbolicView(treeSpec1 == null ? tree : treeSpec1, node));
		views.put(RIGHT_DOWN_RIGHT, new UnicaseHyperbolicView(treeSpec2 == null ? tree : treeSpec2, node));
		updateView();
	}
	
	/**
	 * Update the UI.
	 */
	public void updateView() {	
		for(String locator : locators){
			Frame f = frames.get(locator);
			f.removeAll();
			f.add(views.get(locator).getView());
			f.validate();
		}
	}
	
	/**
	 * Repaints and updates all views.
	 */
	public void repaintAndUpdateViews(){
		for(UnicaseView view : views.values()) view.repaintView();
		updateView();
	}
	
	/**
	 * Set focus to the main composite.
	 */
	@Override
	public void setFocus() {
		sashHor.setFocus();
	}

	/**
	 * Get the {@link UnicaseView}.
	 *  
	 * @return the current {@link UnicaseView}.
	 */
	public UnicaseView getView() {
		return views.get(LEFT);
	}
	
	/**
	 * Get all Views. 
	 * 
	 * @return All {@link UnicaseView}s.
	 */
	public Collection<UnicaseView> getViews(){
		return views.values();
	}
}
