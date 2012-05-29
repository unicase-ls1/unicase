/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.codegeneration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.converter.ConverterPlugin;
import org.eclipse.emf.converter.util.ConverterUtil;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.importer.ModelImporter;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ecore.importer.UMLImporter;
import org.eclipse.uml2.uml.ecore.importer.UMLImporterPlugin;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This {@link UMLImporter} extension will generate {@link EPackage EPackages} for a list of {@link Package
 * UML-Packages}. Unlike the UML importer, this importer only requires the actual packages instead of URIs to the
 * corresponding UML resource files containing the packages.
 * 
 * @author mharut
 */
public class PapyrusImporter extends UMLImporter {

	private Collection<org.eclipse.uml2.uml.Package> packages;

	/**
	 * Creates a new importer instance with the UML packages that should be converted to {@link EPackage EPackages}.
	 * 
	 * @param packages the UML packages that should be converted
	 */
	public PapyrusImporter(Collection<org.eclipse.uml2.uml.Package> packages) {
		this.packages = packages;
	}

	@Override
	public String getID() {
		return "org.unicase.papyrus.importer";
	}

	@Override
	protected Diagnostic doComputeEPackages(Monitor monitor) {
		Diagnostic diagnostic = Diagnostic.OK_INSTANCE;

		monitor.beginTask(UML2Util.EMPTY_STRING, 1);

		BasicDiagnostic diagnostics = new BasicDiagnostic(ConverterPlugin.ID, ConverterUtil.ACTION_DEFAULT,
			UMLImporterPlugin.INSTANCE.getString("_UI_ProblemsEncounteredProcessing_message"), //$NON-NLS-1$
			null);

		Map<Object, Object> context = new HashMap<Object, Object>();
		context.put(org.eclipse.uml2.common.util.UML2Util.QualifiedTextProvider.class,
			UMLUtil.QualifiedTextProvider.DEFAULT);

		@SuppressWarnings("unchecked")
		Collection<EPackage> ePackages = (Collection<EPackage>) new Papyrus2EcoreConverter().convert(packages, options,
			diagnostics, context);
		getEPackages().addAll(ePackages);

		monitor.done();

		if (Diagnostic.INFO < diagnostics.getSeverity()) {
			diagnostic = diagnostics;
		}

		if (Diagnostic.ERROR > diagnostics.getSeverity()) {
			adjustEPackages(monitor);
		}

		return diagnostic;
	}

	/**
	 * Converter that will convert Papyrus models to corresponding ecore packages.
	 * 
	 * @author mharut
	 */
	public class Papyrus2EcoreConverter extends UMLUtil.UML2EcoreConverter {

		@Override
		protected void processEcoreTaggedValues(EPackage ePackage, Element element, Map<String, String> options,
			DiagnosticChain diagnostics, Map<Object, Object> context) {

			super.processEcoreTaggedValues(ePackage, element, options, diagnostics, context);

			Stereotype ePackageStereotype = getAppliedEcoreStereotype(element, UMLUtil.STEREOTYPE__E_PACKAGE);

			if (null != ePackageStereotype) {
				ModelImporter.EPackageImportInfo ePackageInfo = getEPackageImportInfo(ePackage);

				if (element.hasValue(ePackageStereotype, UMLUtil.TAG_DEFINITION__BASE_PACKAGE)) {

					StringBuffer basePackage = new StringBuffer();

					for (StringTokenizer stringTokenizer = new StringTokenizer((String) element.getValue(
						ePackageStereotype, UMLUtil.TAG_DEFINITION__BASE_PACKAGE), "."); stringTokenizer //$NON-NLS-1$
						.hasMoreTokens();) {

						basePackage.append(CodeGenUtil.safeName(stringTokenizer.nextToken()));

						if (stringTokenizer.hasMoreTokens()) {
							basePackage.append('.');
						}
					}

					ePackageInfo.setBasePackage(basePackage.toString());
				}

				if (element.hasValue(ePackageStereotype, UMLUtil.TAG_DEFINITION__PREFIX)) {

					ePackageInfo.setPrefix((String) element
						.getValue(ePackageStereotype, UMLUtil.TAG_DEFINITION__PREFIX));
				}
			}
		}
	}

}
