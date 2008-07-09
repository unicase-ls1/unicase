package org.unicase.ui.navigator;

import java.util.Collection;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.Widget;
import org.unicase.model.ModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;

public class TreeViewerDropAdapter extends EditingDomainViewerDropAdapter
		implements DropTargetListener {

	public TreeViewerDropAdapter(EditingDomain domain, Viewer viewer) {
		super(domain, viewer);
		
	}

	@Override
	public void drop(DropTargetEvent event) {
		Widget item = event.item;
		final Object target = item.getData();
		final Collection<?> dragSource = getDragSource(event);
		if (target instanceof LeafSection) {
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						protected void doExecute() {
							for (Object object : dragSource) {
								if (object instanceof ModelElement) {
									addMEtoLeafSection((ModelElement) object, (LeafSection)target);
								}
							}
						}
					});

		}else if(target instanceof CompositeSection){
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						protected void doExecute() {
							for (Object object : dragSource) {
								if (object instanceof Section) {
									addSectiontoCompositeSection((Section) object, (CompositeSection)target);
								}
							}
						}
					});
		}
		
	}

	protected void addSectiontoCompositeSection(Section section, CompositeSection compositeSection) {
		compositeSection.getSubsections().add(section);
		this.viewer.refresh();
		
	}

	private void addMEtoLeafSection(ModelElement me, LeafSection leafSection) {
		leafSection.getModelElements().add(me);
		this.viewer.refresh();
		
	}
	
		
}
