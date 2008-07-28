package org.unicase.ui.stem.views;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;

public class WorkPackageViewerDropAdapter extends
		EditingDomainViewerDropAdapter implements DropTargetListener {

	public WorkPackageViewerDropAdapter(EditingDomain domain, Viewer viewer) {
		super(domain, viewer);
	}

	@Override
	public void dragEnter(DropTargetEvent event) {
		viewer.getControl().setFocus();
		super.dragEnter(event);
	}

	@Override
	public void dragLeave(DropTargetEvent event) {
		// TODO Auto-generated method stub
		super.dragLeave(event);
	}

	@Override
	public void dragOperationChanged(DropTargetEvent event) {
		// TODO Auto-generated method stub
		super.dragOperationChanged(event);
	}

	@Override
	public void dragOver(DropTargetEvent event) {
		// TODO Auto-generated method stub
		super.dragOver(event);
	}

	@Override
	public void drop(DropTargetEvent event) {
		Widget item = event.item;
		final Object data = item.getData();
		final Collection<?> dragSource = getDragSource(event);
		if (data instanceof WorkPackage) {
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						protected void doExecute() {
							for (Object object : dragSource) {
								if (object instanceof ModelElement) {
									addMEinWorkPackage((ModelElement) object,
											(WorkPackage) data);
								}
							}
						}
					});

		}
		// super.drop(event);
	}

	protected void addMEinWorkPackage(ModelElement me, WorkPackage workPackage) {
		EList<WorkPackage> workPackages = me.getProject()
				.getAllModelElementsbyClass(
						TaskPackage.eINSTANCE.getWorkPackage(),
						new BasicEList<WorkPackage>());
		if (me instanceof WorkItem) {
			workPackage.getContainedWorkItems().add((WorkItem) me);
		} else {
			ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
			ai.setName("new action item");
			ai.getAnnotatedModelElements().add(me);
			ai.setContainingWorkpackage(workPackage);
			MEEditorInput input = new MEEditorInput(ai);
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().openEditor(input, MEEditor.ID,
								true);
			} catch (PartInitException e) {
				ErrorDialog.openError(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), "Error", e
						.getMessage(), e.getStatus());
			}
		}

	}

	@Override
	public void dropAccept(DropTargetEvent event) {
		Widget item = event.item;
		super.dropAccept(event);
	}

	@Override
	protected Collection<?> extractDragSource(Object object) {
		// TODO Auto-generated method stub
		return super.extractDragSource(object);
	}

	@Override
	protected Object extractDropTarget(Widget item) {
		// TODO Auto-generated method stub
		return super.extractDropTarget(item);
	}

	@Override
	protected int getAutoFeedback() {
		// TODO Auto-generated method stub
		return super.getAutoFeedback();
	}

	@Override
	protected Collection<?> getDragSource(DropTargetEvent event) {
		// TODO Auto-generated method stub
		return super.getDragSource(event);
	}

	@Override
	protected float getLocation(DropTargetEvent event) {
		// TODO Auto-generated method stub
		return super.getLocation(event);
	}

	@Override
	protected void helper(DropTargetEvent event) {
		// TODO Auto-generated method stub
		super.helper(event);
	}

}
