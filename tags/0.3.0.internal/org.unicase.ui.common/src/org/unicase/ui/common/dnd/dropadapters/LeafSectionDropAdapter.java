package org.unicase.ui.common.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;

/**
 * This is the drop adapter for LeafSections.
 * 
 * @author Hodaie
 */
public class LeafSectionDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public LeafSectionDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.model.ModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {
		ModelElement dropee = source.get(0);
		if (!(dropee instanceof Annotation)) {
			super.drop(event, target, source);
		} else {
			((LeafSection) target).getModelElements().addAll(source);
		}

	}

	/**
	 * {@inheritDoc} You cannot drop a Section (Composite- or LeafSection) on a LeafSection.
	 */
	@Override
	protected boolean hasThisContainmentReference(EObject target, EClass refType) {
		if (DocumentPackage.eINSTANCE.getSection().isSuperTypeOf(refType)) {
			return false;
		} else {
			return super.hasThisContainmentReference(target, refType);
		}

	}

}
