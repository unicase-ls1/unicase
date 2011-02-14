/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.orga.impl;

import org.eclipse.emf.ecore.EClass;

import org.unicase.model.diagram.impl.MEDiagramImpl;

import org.unicase.model.orga.OrgDiagram;
import org.unicase.model.orga.OrgaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Org Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrgDiagramImpl extends MEDiagramImpl implements OrgDiagram {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrgDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrgaPackage.Literals.ORG_DIAGRAM;
	}
	
	@Override
    public String getType() {
        return "Orga";
    }
} //OrgDiagramImpl
