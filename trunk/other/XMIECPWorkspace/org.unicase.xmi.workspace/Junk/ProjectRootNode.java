package org.unicase.xmi.workspace;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public class ProjectRootNode extends EObjectImpl implements EObject {

	/**
	 * Elements of the first level of an xmi-project.
	 */
	EList<EObject> elements;
	
	/**
	 * Creates a new root node dummy to reference the first level of a xmi-project.
	 */
	public ProjectRootNode() {
		super();
		elements = new BasicEList<EObject>();
	}
	
	/**
	 * Returns a list of all elements
	 * @return List of all elements referenced by the root node.
	 */
	public EList<EObject> getElements() {
		return elements;
	}
}
