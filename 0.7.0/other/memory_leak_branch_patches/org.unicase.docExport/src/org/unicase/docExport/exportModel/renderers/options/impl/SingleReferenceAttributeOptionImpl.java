/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Single Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class SingleReferenceAttributeOptionImpl extends ReferenceAttributeOptionImpl implements
	SingleReferenceAttributeOption {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SingleReferenceAttributeOptionImpl() {
		super();
		referenceOption = OptionsFactory.eINSTANCE.createReferenceOption();
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_OPTION;
	}

} // SingleReferenceAttributeOptionImpl
