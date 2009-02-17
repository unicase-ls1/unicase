package org.unicase.ui.common.diagram.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.common.util.CollectionFilter;

public class DynamicViewDescriptorAdapter implements IAdaptable {

	private EditPart editPart;
	private View view;
	private EObject object;
	private final ViewDescriptor viewDescriptor;
	private final DiagramEditPart host;

	/**
	 * @param object The object which should be adapted
	 * @param host The {@link DiagramEditPart} which will be asked for the {@link View} of the object
	 */
	public DynamicViewDescriptorAdapter(ViewDescriptor viewDescriptor, DiagramEditPart host) {
		if (viewDescriptor == null) {
			throw new IllegalArgumentException();
		}
		
		if (host == null) {
			throw new IllegalArgumentException();
		}
		
		this.viewDescriptor = viewDescriptor;
		this.host = host;
	}

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * @param adapter the adapter class to look up
	 * @return a object castable to the given class, or the view of the {@link EditPart} associated with the object in
	 *         the context of the host
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter.isInstance(getView())) {
			return getView();
		}

		if (adapter.isInstance(getEditPart())) {
			return getEditPart();
		}

		if (adapter.isInstance(getObject())) {
			return getObject();
		}

		if (adapter.isInstance(this)) {
			return this;
		}

		return null;
	}

	/**
	 * @return The host
	 */
	public DiagramEditPart getHost() {
		return host;
	}

	/**
	 * @return The object
	 */
	public EObject getObject() {
		if (object == null) {
			if (getView() != null) {
				object = (EObject) viewDescriptor.getElementAdapter().getAdapter(EObject.class);	
			}
		}
		
		return object;
	}

	/**
	 * @return The view
	 */
	public View getView() {
		if (view == null) {
			view = (View) viewDescriptor.getAdapter(View.class);
		}
		return view;
	}

	/**
	 * @return The editpart
	 */
	public EditPart getEditPart() {
		if (editPart == null) {
			if (getObject() != null) {
				Set<EditPart> editParts = EditPartUtility.findEditParts(getHost(), Collections.singleton(getObject()));
				List<ShapeNodeEditPart> shapeNodeEditParts = CollectionFilter
				.filter(editParts, ShapeNodeEditPart.class);

				List<ConnectionEditPart> connectionEditParts = CollectionFilter.filter(editParts,
					ConnectionEditPart.class);

				if (shapeNodeEditParts.size() > 0) {
					editPart = shapeNodeEditParts.get(0);
				} else if (connectionEditParts.size() > 0) {
					editPart = connectionEditParts.get(0);
				}	
			}	
		}
		return editPart;
	}


}
