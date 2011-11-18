package org.unicase.ui.visualization.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.WorkbenchPart;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.ui.navigator.TreeView;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.ui.views.scm.SCMContentProvider;
import org.unicase.workspace.ui.views.scm.SCMLabelProvider;

/**
 * A util class for visualization purposes.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class VisualizationUtil {
	
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
	
	/**
	 * Open an {@link EObject} in the editor. Needed because of the AWT integration to manually set an active {@link WorkbenchPart}. 
	 * 
	 * @param obj The Object to open.
	 * @param part The active part. If null, it receives it static from the {@link PlatformUI}. 
	 */
	public static void openModelElement(EObject obj, WorkbenchPart part){		
		final MEEditorInput input = new MEEditorInput((ModelElement) obj);
		try {
			if(part == null){
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, MEEditor.ID, true);
			} else {
				part.getSite().getWorkbenchWindow().getActivePage().openEditor(input, MEEditor.ID, true);
			}
		} catch (PartInitException e) {								
			e.printStackTrace();
		}
	}
	
	/**
	 * Set the selection of the navigator.
	 * 
	 * @param obj The Object to select.
	 * @param isLinked Should it really be selected?
	 */
	public static void setNavigatorSelection(EObject obj, boolean isLinked){
		if(isLinked){
			TreeViewer viewer = TreeView.getTreeViewer();
			viewer.setSelection(new TreeSelection(new TreeSelection(new TreePath(new Object[]{obj})).getPaths()[0].createChildPath(obj)), true);
		}
	}
	
	/**
	 * Resolves the {@link ProjectSpace} of an {@link EObject}.
	 * 
	 * @param obj The {@link EObject} to search the {@link ProjectSpace} for.
	 * @return The {@link ProjectSpace}, which contains the {@link EObject}.
	 */
	public static ProjectSpace getProjectSpace(EObject obj){
		EObject container = obj.eContainer();
		return container instanceof ProjectSpace ? (ProjectSpace) container : getProjectSpace(container);
	}	

	
	/**
	 * Receive the changed elements of a {@link ProjectSpace} in a . Asks the user to set the version.
	 * 
	 * @param projectSpace The {@link ProjectSpace} to search in.
	 * @return The changed elements.
	 */
	public static List<EObject> getChangedElements(ProjectSpace projectSpace){
		HistoryInfo info = showVersionHistory(projectSpace);
		if(info == null) return Collections.emptyList();
		selectedHistoryInfo = null;
		return getChangedElements(projectSpace, info);	
	}
	
	/**
	 * Temporary variable. Necessary to assign in inner dialog definition.
	 */
	private static HistoryInfo selectedHistoryInfo;
	
	/**
	 * Shows the Historyversion, to select one {@link HistoryInfo}.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @return The selected {@link HistoryInfo} or <code>null</code> if cancel is pressed or nothing is selected.
	 */
	private static HistoryInfo showVersionHistory(final ProjectSpace projectSpace){
		
		Dialog dialog = new Dialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell()) {
		    @Override
		    protected Control createDialogArea(Composite p) {
		    	// init ui with viewer
		    	Composite composite = new Composite(p, SWT.NONE);
		    	composite.setLayout(new GridLayout());
		    	ScrolledComposite sc = new ScrolledComposite(composite, SWT.H_SCROLL | SWT.V_SCROLL);
		    	sc.setLayoutData(new GridData(500,400)); 
		    	
		    	TreeViewer viewer = new TreeViewer(sc, SWT.NONE);
		        
		        viewer.getControl().setSize(500, 400);
		        sc.setContent(viewer.getControl());
		        
		        // set the providers of the the viewer
		        SCMLabelProvider labelProvider = new SCMLabelProvider(projectSpace.getProject());
				viewer.setLabelProvider(labelProvider);
		        SCMContentProvider.Detailed contentProvider = new SCMContentProvider.Detailed(viewer);
				viewer.setContentProvider(contentProvider);
		        
		        List<HistoryInfo> infos = getHistoryInfos(projectSpace);
		        List<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		        for (HistoryInfo historyInfo : infos) {
		        	ChangePackage changePackage = historyInfo.getChangePackage();
		        	if(null != changePackage){
		        		changePackages.add(historyInfo.getChangePackage());
		        	}
				}
		        
		        ChangePackageVisualizationHelper changePackageVisualizationHelper = new ChangePackageVisualizationHelper(changePackages, projectSpace.getProject());
				labelProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
				contentProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
				
				// set the input
		        viewer.setInput(infos);
		        
		        // set a selection listener to save the current selection
		        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
					
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						TreeNode treeNode = (TreeNode) ((IStructuredSelection) event.getSelection()).getFirstElement();
						Object value = treeNode.getValue();
						if(value instanceof HistoryInfo) selectedHistoryInfo = (HistoryInfo) value;
					}
				});
		        
		        return composite;
		    }
		};
		    
		if (dialog.open() == Dialog.OK) return selectedHistoryInfo;		
		return null;					
	}
		
	/**
	 * Receive all {@link HistoryInfo}s of a {@link ProjectSpace}.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @return The {@link HistoryInfo}s of the {@link ProjectSpace}.
	 */
	private static List<HistoryInfo> getHistoryInfos(final ProjectSpace projectSpace){
		
		final List<HistoryInfo> infos = new ArrayList<HistoryInfo>();
		
		try {
			new ServerRequestCommandHandler() {
				
				@Override
				protected Object run() throws EmfStoreException {
					Usersession usersession = projectSpace.getUsersession();
					usersession.logIn();
					infos.addAll(usersession.getHistoryInfo(projectSpace.getProjectId(), getQuery(projectSpace)));									
					return null;
				}
			}.execute(new ExecutionEvent());
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return infos;	
	}
	
	/**
	 * 
	 * Receive all changed elements of a {@link HistoryInfo}.
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search in.
	 * @param info The {@link HistoryInfo} where to get the changes from.
	 * @return The {@link EObject}s, which are changed in this version.
	 */
	private static List<EObject> getChangedElements(ProjectSpace projectSpace, HistoryInfo info){		
		ChangePackage changePackage = info.getChangePackage();
		
		// this condition occurs when the initial commit happens (there are no changes as 
		// everything is new)
		if(null == changePackage){
			return Collections.emptyList();
		}
		ChangePackageVisualizationHelper cpvh = new ChangePackageVisualizationHelper(Arrays.asList(changePackage), projectSpace.getProject());
		
		final ArrayList<EObject> elements = new ArrayList<EObject>();
		
		for(AbstractOperation a : changePackage.getOperations()){									
			elements.add(cpvh.getModelElement(a.getModelElementId()));
		}	
		return elements;
	}
	
	/**
	 * Receive a {@link HistoryQuery} to query for the {@link HistoryInfo}s.
	 * 
	 * 
	 * @param projectSpace The {@link ProjectSpace} where to search.
	 * @return A Query which searches all versions.
	 * @throws EmfStoreException
	 */
	private static HistoryQuery getQuery(ProjectSpace projectSpace) throws EmfStoreException {
		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();
		
		int end = projectSpace.resolveVersionSpec(VersionSpec.HEAD_VERSION).getIdentifier();			
		int start = 0;
		
		PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		source.setIdentifier(start);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		target.setIdentifier(end);
		query.setSource(source);
		query.setTarget(target);
		query.setIncludeChangePackage(true);		
		
		return query;
	}
}
