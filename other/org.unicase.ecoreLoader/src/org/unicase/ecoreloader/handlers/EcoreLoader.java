/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecoreloader.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.Package;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.util.UnicaseCommandWithParameterAndResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The EcoreLoader to load ecore files in Unicase.
 * 
 * @author weiglt
 */

// Flo: geh erstmal davon aus dass da Klassen, Packages, Attribute und Operationen drin stehen

public final class EcoreLoader extends AbstractHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "ecore File (*.ecore)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ecore", "*.*" };

	/**
	 * Executes the EcoreLoader.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	@SuppressWarnings("null")
	public Object execute(ExecutionEvent event) throws ExecutionException {

		assert (ActionHelper.getSelectedModelElement() instanceof LeafSection); // propertytester:
		// org.unicase.ecoreLoader.testers.allowedLocation
		final LeafSection leafsection = (LeafSection) ActionHelper.getSelectedModelElement();
		final String packageName;

		final String absoluteFileName = showOpenFileDialog();

		if (absoluteFileName == null) {
			System.out.println("Loading Error.");
		}
		FileReader fileIn = null;
		try {
			fileIn = new FileReader(absoluteFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fileIn);
		try {
			reader.readLine(); // btw, equals approx reader.skip(41);
			if (reader.readLine().substring(1, 6).equals("ecore")) { // now thats my first ugly hack - or is it?
				System.out.println("Looks like you loaded a valid ecore File." + '\n');
			} else {
				System.out.println("ERROR no valid ecore File.");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// maybe an alternative:
		// org.eclipse.emf.ecore.xmi.util.XMLProcessor p = new org.eclipse.emf.ecore.xmi.util.XMLProcessor();

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder theDocBuilder = dbf.newDocumentBuilder();
			File file = new File(absoluteFileName);

			if (file.exists()) {
				Document doc = theDocBuilder.parse(file);
				Element eDoc = doc.getDocumentElement();

				System.out.println("Root element: " + eDoc.getNodeName() + '\n');
				packageName = eDoc.getAttribute("name");

				NodeList eClassifiersList = eDoc.getElementsByTagName("eClassifiers");

				System.out.println("Number of Elements detected: " + eClassifiersList.getLength() + '\n');

				Package p = null;

				if (eClassifiersList != null && eClassifiersList.getLength() > 0) { // Create Package

					p = new UnicaseCommandWithParameterAndResult<Package, Package>() {
						@Override
						protected Package doRun(Package p) {
							p = org.unicase.model.classes.ClassesFactory.eINSTANCE.createPackage();
							p.setName(packageName);
							leafsection.getModelElements().add(p);
							return p;
						}
					}.run(p);

					for (int i = 0; i < eClassifiersList.getLength(); i++) { // Create Package Contents

						Node packageContent = eClassifiersList.item(i);
						final String packageElement = packageContent.getAttributes().getNamedItem("xsi:type")
							.getNodeValue().substring(6);
						final String packageElementName = packageContent.getAttributes().getNamedItem("name")
							.getNodeValue();
						System.out.print("Detected new Element " + packageElement + " " + packageElementName);

						if (packageElement.equals("EClass")) {
							Class c = new UnicaseCommandWithParameterAndResult<Class, Package>() {
								@Override
								protected Class doRun(Package p) {
									Class c = null;
									c = org.unicase.model.classes.ClassesFactory.eINSTANCE.createClass();
									c.setName(packageElementName);
									c.setParentPackage(p);

									return c;
								}
							}.run(p);

							if (packageContent.getNodeType() == Node.ELEMENT_NODE) {

								Element e = (Element) packageContent;
								NodeList eStructuralFeatureList = e.getElementsByTagName("eStructuralFeatures");
								System.out.println(" has " + eStructuralFeatureList.getLength() + " attributes:");

								for (int j = 0; j < eStructuralFeatureList.getLength(); j++) { // Create Contents
									// Attributes

									NamedNodeMap map = eStructuralFeatureList.item(j).getAttributes();

									final String contentElement = map.getNamedItem("xsi:type").getNodeValue()
										.substring(6);
									final String contentElementName = map.getNamedItem("name").getNodeValue();

									System.out.print("  " + contentElement + contentElementName);

									if (contentElement.equals("EAttribute")) {
										Attribute a = new UnicaseCommandWithParameterAndResult<Attribute, Class>() {
											@Override
											protected Attribute doRun(Class c) {
												Attribute a = null;
												a = org.unicase.model.classes.ClassesFactory.eINSTANCE
													.createAttribute();
												a.setName(contentElementName);
												a.setDefiningClass(c);
												return a;
											}
										}.run(c);
									}
								}
								System.out.println('\n');
							}
						}
					}
				}

			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private String showOpenFileDialog() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
		dialog.setFilterNames(EcoreLoader.FILTER_NAMES);
		dialog.setFilterExtensions(EcoreLoader.FILTER_EXTS);
		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		final File file = new File(dialog.getFilterPath(), dialog.getFileName());

		return file.getAbsolutePath();
	}
}
