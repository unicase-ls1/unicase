package org.unicase.xmlcreator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;

/**
 * Utility class to simplify the printing process. All methods should be accessed in a static way.
 * 
 * @author mharut
 */
public final class XMLCreatorUtil {

	/**
	 * Private constructor. All methods should be accessed in a static way.
	 */
	private XMLCreatorUtil() {
		// nothing to do
	}

	/**
	 * Prints the ecore definition for all {@link EPackage EPackages} in <code>packages</code> by using
	 * <code>writer</code>. The root element will be named after <code>rootName</code>.
	 * 
	 * @param writer the writer to use for the printing process
	 * @param packages a collection of EPackages to print
	 * @param rootName the name of the root element
	 * @see #printEcore(PrintWriter, Collection)
	 */
	public static void printEcore(PrintWriter writer, Collection<EPackage> packages, String rootName) {
		EMFXMLWriter xmlWriter = new EMFDefinitionXMLWriter(writer, rootName);
		for (EPackage ePackage : packages) {
			xmlWriter.print(ePackage);
		}
		xmlWriter.close();
	}

	/**
	 * Prints the ecore definition for all {@link EPackage EPackages} in <code>packages</code> by using
	 * <code>writer</code>. The root element will be named <code>ecore-definition</code>.<br>
	 * This is equivalent to <code>printEcore(writer, packages, "ecore-definition")</code>.
	 * 
	 * @param writer the writer to use for the printing process
	 * @param packages a collection of EPackages to print
	 * @see #printEcore(PrintWriter, Collection, String)
	 */
	public static void printEcore(PrintWriter writer, Collection<EPackage> packages) {
		printEcore(writer, packages, "ecore-definition");
	}

	/**
	 * Prints the model instance of <code>root</code> by using <code>writer</code>. Only elements whose {@link EClass}
	 * appears in one of the <code>packages</code> will be printed. The XML root element will be named after
	 * <code>rootName</code>.
	 * 
	 * @param writer the writer to use for the printing process
	 * @param packages a collection of {@link EPackage EPackages} to filter the elements to print
	 * @param root the root EObject that shall be printed to the XML file
	 * @param rootName the name of the XML root element
	 * @see #printModel(PrintWriter, Collection, EObject)
	 */
	public static void printModel(PrintWriter writer, Collection<EPackage> packages, EObject root, String rootName) {
		EMFXMLWriter xmlWriter = new EMFModelXMLWriter(writer, rootName, packages);
		xmlWriter.print(root);
		xmlWriter.close();
	}

	/**
	 * Prints the model instance of <code>root</code> by using <code>writer</code>. Only elements whose {@link EClass}
	 * appears in one of the <code>packages</code> will be printed.<br>
	 * This method call is equivalent to <code>printModel(writer, packages, root, "model-instance")</code>.
	 * 
	 * @param writer the writer to use for the printing process
	 * @param packages a collection of {@link EPackage EPackages} to filter the elements to print
	 * @param root the root EObject that shall be printed to the XML file
	 * @see #printModel(PrintWriter, Collection, EObject, String)
	 */
	public static void printModel(PrintWriter writer, Collection<EPackage> packages, EObject root) {
		printModel(writer, packages, root, "model-instance");
	}

	/**
	 * Prints both, the ecore definition and the model instance for a collection of {@link EPackage EPackages}.<br>
	 * This method call is equivalent to<br>
	 * <code>printEcore(ecoreWriter, packages, ecoreRootName);<br>
	 * printModel(modelWriter, packages, root, modelRootName);</code>
	 * 
	 * @param ecoreWriter the {@link PrintWriter} for the ecore definition
	 * @param modelWriter the {@link PrintWriter} for the model instance
	 * @param packages a collection of {@link EPackage} to print and to use for filtering
	 * @param root the root {@link EObject} of the model instance
	 * @param ecoreRootName the XML root element's name of the ecore definition
	 * @param modelRootName the XML root element's name of the model instance
	 * @see #printEcore(PrintWriter, Collection, String)
	 * @see #printModel(PrintWriter, Collection, EObject, String)
	 * @see #printEcoreAndModel(PrintWriter, PrintWriter, Collection, EObject)
	 */
	public static void printEcoreAndModel(PrintWriter ecoreWriter, PrintWriter modelWriter,
		Collection<EPackage> packages, EObject root, String ecoreRootName, String modelRootName) {
		printEcore(ecoreWriter, packages, ecoreRootName);
		printModel(modelWriter, packages, root, modelRootName);
	}

	/**
	 * Prints both, the ecore definition and the model instance for a collection of {@link EPackage EPackages}.<br>
	 * This method call is equivalent to<br>
	 * <code>printEcore(ecoreWriter, packages, "ecore-definition");<br>
	 * printModel(modelWriter, packages, root, "model-instance");</code>
	 * 
	 * @param ecoreWriter the {@link PrintWriter} for the ecore definition
	 * @param modelWriter the {@link PrintWriter} for the model instance
	 * @param packages a collection of {@link EPackage} to print and to use for filtering
	 * @param root the root {@link EObject} of the model instance
	 * @see #printEcore(PrintWriter, Collection, String)
	 * @see #printModel(PrintWriter, Collection, EObject, String)
	 * @see #printEcoreAndModel(PrintWriter, PrintWriter, Collection, EObject, String, String)
	 */
	public static void printEcoreAndModel(PrintWriter ecoreWriter, PrintWriter modelWriter,
		Collection<EPackage> packages, EObject root) {
		printEcore(ecoreWriter, packages, "ecore-definition");
		printModel(modelWriter, packages, root, "model-instance");
	}

	/**
	 * Creates and returns a {@link PrintWriter} that will write to the {@link File} <code>file</code>. If the file
	 * doesn't exist yet, it is created here. The returned print writer can be used for all of the printing methods.
	 * 
	 * @param file the File to create the print writer for
	 * @return a new print writer that will write to the file
	 * @throws IOException if creating the file or the print writer failed
	 */
	public static PrintWriter fileToPrintWriter(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream out = new FileOutputStream(file);
		return new PrintWriter(out);
	}

	/**
	 * Retrieves all {@link EPackage EPackages} for a collection of NS-URIs by making use of the {@link Registry
	 * EPackage-Registry}.
	 * 
	 * @param URIs a collection of NS-URIs of the EPackages
	 * @return all EPackages belonging to <code>URIs</code>
	 * @see #getEPackagesFromURI(String[])
	 */
	public static List<EPackage> getEPackagesFromURI(Collection<String> URIs) {
		List<EPackage> result = new LinkedList<EPackage>();
		Registry registry = Registry.INSTANCE;
		for (String nsURI : URIs) {
			result.add(registry.getEPackage(nsURI));
		}
		return result;
	}

	/**
	 * Retrieves all {@link EPackage EPackages} for an array of NS-URIs by making use of the {@link Registry
	 * EPackage-Registry}.
	 * 
	 * @param URIs an array of NS-URIs of the EPackages
	 * @return all EPackages belonging to <code>URIs</code>
	 * @see #getEPackagesFromURI(Collection)
	 */
	public static List<EPackage> getEPackagesFromURI(String[] URIs) {
		List<EPackage> result = new LinkedList<EPackage>();
		Registry registry = Registry.INSTANCE;
		for (int i = 0; i < URIs.length; i++) {
			result.add(registry.getEPackage(URIs[i]));
		}
		return result;
	}

}
