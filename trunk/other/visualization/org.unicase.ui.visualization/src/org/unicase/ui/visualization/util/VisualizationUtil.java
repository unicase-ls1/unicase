package org.unicase.ui.visualization.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.part.WorkbenchPart;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
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
	 * Receive the changed elements of a {@link ProjectSpace} in a . Asks the user to set the version.
	 * 
	 * @param projectSpace The {@link ProjectSpace} to search in.
	 * @return The changed elements.
	 */
	public static List<EObject> getChangedElements(ProjectSpace projectSpace){		
		ListDialog dialog = new ListDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		
		dialog.setTitle("History");
		dialog.setMessage("Choose a version");		
		dialog.setContentProvider(ArrayContentProvider.getInstance());
		
		final SCMLabelProvider lp = new SCMLabelProvider(projectSpace.getProject());
		
		dialog.setLabelProvider(new ILabelProvider() {
			@Override
			public String getText(Object element) {
				return lp.getText(new TreeNode(element));			
			}
			
			@Override
			public void removeListener(ILabelProviderListener listener) {}			
			@Override
			public boolean isLabelProperty(Object element, String property) {return false;}			
			@Override
			public void dispose() {}			
			@Override
			public void addListener(ILabelProviderListener listener) {}
			@Override
			public Image getImage(Object element) {
				return lp.getImage(new TreeNode(element));
			}
			
		});
		dialog.setInput(getHistoryInfos(projectSpace));		
		
		if (dialog.open() == Dialog.OK) {
		    HistoryInfo info = (HistoryInfo) dialog.getResult()[0];
		    return getChangedElements(projectSpace, info);
		}
		
		return Collections.emptyList();
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
		
		// TODO find out first version dynamically
		int start = 2;
		
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
