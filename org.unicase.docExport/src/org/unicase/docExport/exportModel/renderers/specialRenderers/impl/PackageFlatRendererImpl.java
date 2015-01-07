/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.model.classes.Package;
import org.unicase.model.classes.PackageElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Package Flat Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PackageFlatRendererImpl extends ModelElementRendererImpl implements PackageFlatRenderer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageFlatRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.PACKAGE_FLAT_RENDERER;
	}

	// begin custom code
	@Override
	protected void doRender(EObject eObject, UCompositeSection parent) {

		ArrayList<Package> allPackages = getAllPackagesRecursivly((Package) eObject);

		for (Package packageElement : allPackages) {
			renderPackage(parent, packageElement);
		}

	}

	private void renderPackage(UCompositeSection parent, Package uPackage) {
		USection section = new USection("Package " + getLongPackageName(uPackage).toString(), getTemplate()
			.getLayoutOptions().getModelElementTextOption());
		parent.add(section);
		section.getBoxModel().setMarginTop(10);
		section.getBoxModel().setMarginBottom(5);
		section.getSectionOption().setLeaveOutPreviousSectionNumbering(true);
		section.getSectionOption().setSectionNumberingStyle(SectionNumberingStyle.NONE);

		UParagraph desc = new UParagraph(DocumentExport.cleanFormatedText(uPackage.getDescription()), getTemplate()
			.getLayoutOptions().getDefaultTextOption());
		section.add(desc);
		desc.getBoxModel().setMarginTop(0);
		desc.getBoxModel().setMarginBottom(10);

		for (PackageElement packageElement : uPackage.getContainedPackageElements()) {
			if (!(packageElement instanceof Package)) {
				getTemplate().getModelElementRendererNotNull(packageElement.eClass(), template).render(packageElement,
					section);
			}
		}
	}

	private StringBuffer getLongPackageName(Package uPackage) {
		StringBuffer ret = new StringBuffer();
		ret.insert(0, uPackage.getName());
		if (uPackage.getParentPackage() != null) {
			ret.insert(0, getLongPackageName(uPackage.getParentPackage()) + ".");
		}

		return ret;
	}

	private ArrayList<Package> getAllPackagesRecursivly(Package uPackage) {
		ArrayList<Package> subPackages = new ArrayList<Package>();
		subPackages.add(uPackage);

		for (PackageElement subPackage : uPackage.getContainedPackageElements()) {
			if (subPackage instanceof Package) {
				subPackages.addAll(getAllPackagesRecursivly((Package) subPackage));
			}
		}

		return subPackages;
	}
	// end custom code

} // PackageFlatRendererImpl
