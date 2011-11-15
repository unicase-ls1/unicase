package org.unicase.ui.visualization.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.WorkbenchPart;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.ui.navigator.TreeView;
import org.unicase.workspace.ProjectSpace;

/**
 * A util class for visualization purposes.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class VisualizationUtil {
	
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
			viewer.setSelection(new TreeSelection(((TreeSelection) viewer.getSelection()).getPaths()[0].createChildPath(obj)), true);
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
}
