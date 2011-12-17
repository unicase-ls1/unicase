package org.unicase.ui.visualization.views;

import java.awt.Frame;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
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
	
	private Composite parent;		
	private SashForm sashHor;
	
	private HashMap<String, UnicaseView> views;
	private HashMap<String, Frame> frames;
	private HashMap<String, UnicaseTree> trees;
	
	private final String LEFT = "left";
	private final String RIGHT_UP_LEFT = "rightUpLeft";
	private final String RIGHT_UP_RIGHT = "rightUpRight";
	private final String RIGHT_DOWN_LEFT = "rightDownLeft";
	private final String RIGHT_DOWN_RIGHT = "rightDownRight";
	
	private final String MAIN_TREE = "mainTree";
	private final String VERSION_1_TREE = "version1Tree";
	private final String VERSION_2_TREE = "version2Tree";
	
	private List<String> locators;
	private List<String> treeIdentifier;
				
	/**
	 * Register the {@link SelectionListener}, to listen on Navigator selection.
	 * Also inits the UI.
	 */
	@Override
	public void createPartControl(Composite parent) {	
		this.parent = parent;
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
					((UnicaseView)views.get(LEFT)).selectNode(trees.get(MAIN_TREE).getNodes().get(eObj));	
				}
			}
		});
		
		views = new HashMap<String, UnicaseView>();	
		frames = new HashMap<String, Frame>();
		trees = new HashMap<String, UnicaseTree>();
					
		updateUIStructure(false);
	}
	
	/**
	 * Updates the UI Structure. Differs between the normal one version and the two versions view.
	 * 
	 * @param twoVersions Display two versions?
	 */
	private void updateUIStructure(boolean twoVersions){
		// remove old controls 
		for(Control c : parent.getChildren()) c.dispose();
		
		// add new general structure
		sashHor = new SashForm(parent, SWT.HORIZONTAL);		
		frames.put(LEFT, SWT_AWT.new_Frame(new Composite(sashHor, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
		
		// differ between two and one version
		if(twoVersions){
			SashForm sashVerRight = new SashForm(sashHor, SWT.VERTICAL);
			SashForm sashVerRightHorUp = new SashForm(sashVerRight, SWT.HORIZONTAL);
			SashForm sashVerRightHorDown = new SashForm(sashVerRight, SWT.HORIZONTAL);
			
			frames.put(RIGHT_UP_LEFT, SWT_AWT.new_Frame(new Composite(sashVerRightHorUp, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
			frames.put(RIGHT_UP_RIGHT, SWT_AWT.new_Frame(new Composite(sashVerRightHorUp, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
				
			frames.put(RIGHT_DOWN_LEFT, SWT_AWT.new_Frame(new Composite(sashVerRightHorDown, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
			frames.put(RIGHT_DOWN_RIGHT, SWT_AWT.new_Frame(new Composite(sashVerRightHorDown, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
						
			locators = Arrays.asList(new String[]{LEFT, RIGHT_UP_LEFT, RIGHT_UP_RIGHT, RIGHT_DOWN_LEFT, RIGHT_DOWN_RIGHT});
			treeIdentifier = Arrays.asList(new String[]{MAIN_TREE, VERSION_1_TREE, VERSION_2_TREE});
		} else {
			frames.put(RIGHT_DOWN_LEFT, SWT_AWT.new_Frame(new Composite(sashHor, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
			
			locators = Arrays.asList(new String[]{LEFT, RIGHT_DOWN_LEFT});
			treeIdentifier = Arrays.asList(new String[]{MAIN_TREE});
		}
		
		// re-layout the view
		parent.layout();
	}
	
	/**
	 * Resets the view completely.
	 */
	public void reset(){
		updateUIStructure(false);
		forceSetProject(currentProjectSpace);
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
		UnicaseTree tree = new UnicaseTree(new UnicaseNode(projectSpace));
		trees.put(MAIN_TREE, tree);
		
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
	 * Show two different versions of a project.
	 */
	public void showTwoVersionsView(){
		updateUIStructure(true);
		final VisualizationView vv = this;
		try {
			new ServerRequestCommandHandler() {
				
				@Override
				protected Object run() throws EmfStoreException {
					List<HistoryInfo> infos = trees.get(MAIN_TREE).getHistoryInfos();
					if(infos.size() != 2) return null;					
										
					UnicaseTree tree = VisualizationUtil.getRevertedUnicaseTree(currentProjectSpace, infos.get(0).getPrimerySpec());
					trees.put(VERSION_1_TREE, tree);
					views.put(RIGHT_UP_LEFT, UnicaseSunburstView.createUnicaseSunburstView(tree, vv));
					
					tree = VisualizationUtil.getRevertedUnicaseTree(currentProjectSpace, infos.get(1).getPrimerySpec());
					trees.put(VERSION_2_TREE, tree);
					views.put(RIGHT_UP_RIGHT, UnicaseSunburstView.createUnicaseSunburstView(tree, vv));
					
					updateView();								
					return null;
				}
			}.execute(new ExecutionEvent());
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Show a {@link UnicaseTree}, filtered by type.
	 * 
	 * @param eClassTypes The type to filter. Set to null to show non filtered tree.
	 */
	public void showFiltered(List<EClass> eClassTypes){
		for(String s : treeIdentifier) trees.put(s, getValidTree(s).getFilteredUnicaseTree(eClassTypes));		
		setViews();
		updateView();
	}
		
	/**
	 * Set the currently selected {@link UnicaseNode}.
	 * 
	 * @param node The {@link UnicaseNode}, which is selected.
	 */
	public void setSelectedNode(UnicaseNode node){
		views.put(RIGHT_DOWN_LEFT, new UnicaseHyperbolicView(getValidTree(VERSION_1_TREE), node));
		views.put(RIGHT_DOWN_RIGHT, new UnicaseHyperbolicView(getValidTree(VERSION_2_TREE), node));
		for(UnicaseView view : views.values()) view.selectNode(node);
		updateView();
	}
	
	/**
	 * Reload and update all views.
	 */
	private void setViews(){
		views.put(LEFT, UnicaseSunburstView.createUnicaseSunburstView(trees.get(MAIN_TREE), this));
		views.put(RIGHT_UP_LEFT, UnicaseSunburstView.createUnicaseSunburstView(getValidTree(VERSION_1_TREE), this));
		views.put(RIGHT_UP_RIGHT, UnicaseSunburstView.createUnicaseSunburstView(getValidTree(VERSION_2_TREE), this));
	}
	
	/**
	 * Returns a not null tree. 
	 * 
	 * @param identifier The identifier to identify the tree.
	 * @return The {@link UnicaseTree}, which is identified by the identifier or the main tree if it is null.
	 */
	private UnicaseTree getValidTree(String identifier){
		return trees.get(identifier) == null ? trees.get(MAIN_TREE) : trees.get(identifier);
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
		parent.setFocus();
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
