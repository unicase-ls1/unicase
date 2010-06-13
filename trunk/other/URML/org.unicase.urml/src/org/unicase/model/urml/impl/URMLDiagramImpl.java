/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.impl;

import org.eclipse.emf.ecore.EClass;

import org.unicase.model.diagram.impl.MEDiagramImpl;

import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URML Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class URMLDiagramImpl extends MEDiagramImpl implements URMLDiagram {
	@Override
	public String getType() {
		return "Urml";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected URMLDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrmlPackage.Literals.URML_DIAGRAM;
	}

} //URMLDiagramImpl
