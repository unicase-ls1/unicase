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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.Enumeration;
import org.unicase.model.classes.Method;
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

// note:
// Method seems not to be exported by ecore-generator, use hacked example "hardcoreTestPackage.ecore" in this package

public final class EcoreLoader extends AbstractHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "ecore File (*.ecore)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ecore", "*.*" };

	private static final String TRAVERSED = "traversed", TREEKNOT = "eSubpackages", TREECONTENT = "eClassifiers";

	/**
	 * Executes the EcoreLoader.
	 * 
	 * @param event The MouseClick Event
	 * @return null
	 * @throws ExecutionException ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// propertytester:org.unicase.ecoreLoader.testers.allowedLocation allows us to
		assert (ActionHelper.getSelectedModelElement() instanceof LeafSection);

		final LeafSection leafsection = (LeafSection) ActionHelper.getSelectedModelElement();
		final String packageName;

		final String absoluteFileName = showOpenFileDialog();

		if (absoluteFileName == null) {
			return null;
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
			if (!reader.readLine().substring(1, 6).equals("ecore")) {
				MessageDialog.openError(null, "Invalid File", "Ecore file could not be loaded.");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// maybe an alternative:
		// org.eclipse.emf.ecore.xmi.util.XMLProcessor p = new org.eclipse.emf.ecore.xmi.util.XMLProcessor();

		File file = null;
		DocumentBuilder theDocBuilder = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			theDocBuilder = dbf.newDocumentBuilder();
			file = new File(absoluteFileName);

			if (!file.exists()) {
				return null;
			}

			Document doc = theDocBuilder.parse(file);
			Element root = doc.getDocumentElement();

			System.out.println("Root element: " + root.getNodeName() + '\n');
			packageName = root.getAttribute("name");

			Package p = createMasterPackage(leafsection, packageName);
			initSynchronizedDFS(root, p);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void initSynchronizedDFS(Node root, Package masterpackage) {
		root.setUserData(TRAVERSED, true, null);
		traverse(root.getFirstChild(), masterpackage);
	}

	private void traverse(Node n, Package p) {
		if (hasTraversableSiblings(n)) {
			if (hasBeenTraversed(n)) {
				traverse(n.getNextSibling(), p);
			} else {
				if (n.getNodeName().equals(TREECONTENT)) {
					n.setUserData(TRAVERSED, true, null);
					resourceCreator(n, p);
					traverse(n.getNextSibling(), p);
				} else if (n.getNodeName().equals(TREEKNOT) && n.hasChildNodes()) {
					traverse(n.getFirstChild(), subPackageCreator(n, p));
				} else if (n.getNodeName().equals(TREEKNOT) && !n.hasChildNodes()) {
					n.setUserData(TRAVERSED, true, null);
					subPackageCreator(n, p);
					traverse(n.getNextSibling(), p);
				}
				// if we cannot detect type of knot, get next
				n.setUserData(TRAVERSED, true, null);
				traverse(n.getNextSibling(), p);
			}
		} else // hasNoTraversableSiblings
		{
			// since all children have been traversed the parent is dead now
			// especially, the parent has already been created during the downwards path
			n.getParentNode().setUserData(TRAVERSED, true, null);
			traverse(n.getParentNode(), p.getParentPackage());
		}
	}

	private void resourceCreator(Node node, Package p) {

		final String packageElement = node.getAttributes().getNamedItem("xsi:type").getNodeValue().substring(6);
		final String packageElementName = node.getAttributes().getNamedItem("name").getNodeValue();
		System.out.println("Created new Element " + packageElement + " " + packageElementName);

		if (packageElement.equals("EClass")) {

			Class c = createClass(p, packageElementName);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element e = (Element) node;
				NodeList eStructuralFeatureList = e.getElementsByTagName("eStructuralFeatures");

				if (eStructuralFeatureList.getLength() > 0) {
					System.out.println(" has " + eStructuralFeatureList.getLength() + " attributes:");
				}

				for (int j = 0; j < eStructuralFeatureList.getLength(); j++) { // Create Attributes

					NamedNodeMap map = eStructuralFeatureList.item(j).getAttributes();
					final String contentElement = map.getNamedItem("xsi:type").getNodeValue().substring(6);
					final String contentElementName = map.getNamedItem("name").getNodeValue();

					System.out.println("  -  " + contentElement + " " + contentElementName);

					if (contentElement.equals("EAttribute")) {
						createAttribute(c, contentElementName);
					} else if (contentElement.equals("Method")) {
						createMethod(c, contentElementName);
					}
				}
			}
		}
		if (packageElement.equals("EEnum")) {

			@SuppressWarnings("unused")
			Enumeration en = createEnumeration(p, packageElementName);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element e = (Element) node;
				NodeList eStructuralFeatureList = e.getElementsByTagName("eStructuralFeatures");

				if (eStructuralFeatureList.getLength() > 0) {
					System.out.println(" has " + eStructuralFeatureList.getLength() + " attributes:");
				}

				for (int j = 0; j < eStructuralFeatureList.getLength(); j++) { // Create Attributes

					NamedNodeMap map = eStructuralFeatureList.item(j).getAttributes();
					final String contentElement = map.getNamedItem("xsi:type").getNodeValue().substring(6);
					final String contentElementName = map.getNamedItem("name").getNodeValue();

					System.out.print("  " + contentElement + " " + contentElementName);
				}
			}
		}
	}

	private Package subPackageCreator(final Node node, final Package pp) {

		final String packageElementName = node.getAttributes().getNamedItem("name").getNodeValue();

		Package p = null;
		p = new UnicaseCommandWithParameterAndResult<Package, Package>() {

			@Override
			protected Package doRun(Package p) {
				p = org.unicase.model.classes.ClassesFactory.eINSTANCE.createPackage();
				p.setName(packageElementName);
				p.setParentPackage(pp);
				return p;
			}
		}.run(p);
		System.out.println("Created new Subpackage " + packageElementName);
		return p;
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

	private Package createMasterPackage(final LeafSection leafsection, final String packageName) {
		Package p = null;
		p = new UnicaseCommandWithParameterAndResult<Package, Package>() {

			@Override
			protected Package doRun(Package p) {
				p = org.unicase.model.classes.ClassesFactory.eINSTANCE.createPackage();
				p.setName(packageName);
				leafsection.getModelElements().add(p);
				return p;
			}
		}.run(p);
		return p;
	}

	private Class createClass(final Package p, final String packageElementName) {
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
		return c;
	}

	private Enumeration createEnumeration(final Package p, final String packageElementName) {
		Enumeration e = new UnicaseCommandWithParameterAndResult<Enumeration, Package>() {
			@Override
			protected Enumeration doRun(Package p) {
				Enumeration e = null;
				e = org.unicase.model.classes.ClassesFactory.eINSTANCE.createEnumeration();
				e.setName(packageElementName);
				e.setParentPackage(p);
				return e;
			}
		}.run(p);
		return e;
	}

	private Attribute createAttribute(final Class c, final String contentElementName) {
		Attribute a = new UnicaseCommandWithParameterAndResult<Attribute, Class>() {
			@Override
			protected Attribute doRun(Class c) {
				Attribute a = null;
				a = org.unicase.model.classes.ClassesFactory.eINSTANCE.createAttribute();
				a.setName(contentElementName);
				a.setDefiningClass(c);
				return a;
			}
		}.run(c);
		return a;
	}

	private Method createMethod(final Class c, final String contentElementName) {
		Method m = new UnicaseCommandWithParameterAndResult<Method, Class>() {
			@Override
			protected Method doRun(Class c) {
				Method m = null;
				m = org.unicase.model.classes.ClassesFactory.eINSTANCE.createMethod();
				m.setName(contentElementName);
				m.setDefiningClass(c);
				return m;
			}
		}.run(c);
		return m;
	}

	private boolean hasTraversableSiblings(Node n) {
		Node temp = n;
		do {
			temp = temp.getNextSibling();
			if (temp == null) {
				return false;
			}
			if (!hasBeenTraversed(temp)) {
				return true;
			}
		} while (!n.isSameNode(temp));
		return false;
	}

	private boolean hasBeenTraversed(Node n) {
		if (n.getUserData(TRAVERSED) instanceof Boolean) {
			if ((Boolean) n.getUserData(TRAVERSED)) {
				return true;
			}
		}
		return false;
	}
}
