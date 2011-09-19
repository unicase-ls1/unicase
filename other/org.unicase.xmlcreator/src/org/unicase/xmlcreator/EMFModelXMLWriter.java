package org.unicase.xmlcreator;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class provides the possibility to print an EMF model instance to XML. Printing an {@link EObject} will print all
 * of its attributes, contents and references as well as its container, if existent.
 * 
 * @author mharut
 */
public class EMFModelXMLWriter extends EMFXMLWriter {

	/**
	 * Collection of all involved {@link EPackage EPackages}. Only EObjects whose EClasses appear in one of these
	 * packages will be printed.
	 */
	private Collection<EPackage> packages;

	/**
	 * All {@link EClass EClasses} that are allowed to be printed, i.e. that are contained in one of the
	 * {@link EPackage EPackages} of {@link #packages}.
	 */
	private List<EClass> allowedEClasses;

	/**
	 * Map from an {@link EObject} to its ID (see {@link #getID(EObject)}.
	 */
	private Map<EObject, String> objectToID;

	/**
	 * Constructor to assign the print writer, the root's name and the involved {@link EPackage EPackages}. The writer
	 * will be automatically initialized when calling this constructor.
	 * 
	 * @param out the {@link PrintWriter} that does the printing
	 * @param rootName the name of the XML's root element
	 * @param packages the involved packages (only EObjects whose EClasses appear in one of these packages will be
	 *            printed).
	 * @see EMFXMLWriter#init()
	 */
	public EMFModelXMLWriter(PrintWriter out, String rootName, Collection<EPackage> packages) {
		super(out, rootName);
		this.packages = packages;
		objectToID = new LinkedHashMap<EObject, String>();
		allowedEClasses = new LinkedList<EClass>();
		computeAllAllowedClasses(packages);
		init();
	}

	/**
	 * Computes all {@link EClass EClasses} that appear in a collection of {@link EPackage EPackages} and its
	 * sub-packages.
	 * 
	 * @param allowedPackages the EPackages to compute the allowed EClasses for
	 * @see #addAllowedClasses(EPackage)
	 */
	private void computeAllAllowedClasses(Collection<EPackage> allowedPackages) {
		for (EPackage ePackage : allowedPackages) {
			addAllowedClasses(ePackage);
		}
	}

	/**
	 * Adds all {@link EClass EClasses} that appear in an {@link EPackage} to {@link #allowedEClasses}.
	 * 
	 * @param ePackage the EPackage to add the EClasses for
	 */
	private void addAllowedClasses(EPackage ePackage) {
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			// only add EClasses
			if (classifier instanceof EClass) {
				allowedEClasses.add((EClass) classifier);
			}
		}
		// include classes from sub-packages
		computeAllAllowedClasses(ePackage.getESubpackages());
	}

	/**
	 * Prints the <code>packages</code> attribute to the root element. This attribute displays all of the involved
	 * {@link EPackage EPackages} (see {@link #packages}).
	 */
	@Override
	protected void printRootAttributes() {
		// build a string containing all the involved package prefixes
		StringBuilder packagePrefixes = new StringBuilder();
		String separator = "";
		for (EPackage ePackage : packages) {
			packagePrefixes.append(separator);
			separator = ", ";
			packagePrefixes.append(ePackage.getNsPrefix());
		}

		// print the 'packages' attribute
		out.print(" packages=\"" + escape(packagePrefixes.toString()) + "\"");
	}

	/**
	 * Prints an {@link EObject} as an instance in XML. This includes its class, its id (see {@link #getID(EObject)}),
	 * all its attributes, its container, all its contents and all its cross-references. This method can be called
	 * multiple times to print multiple elements.
	 */
	@Override
	public void print(EObject eObject) {
		// only print allowed classes
		EClass eClass = eObject.eClass();
		if (isForbidden(eClass)) {
			return;
		}

		// begin of class: print class name and id
		addWhitespace();
		out.print("<instance class=\"" + escape(eClass.getName()) + "\" ");
		out.println("id=\"" + getID(eObject) + "\">");
		whitespaceCounter += 2;

		printAttributes(eObject);

		printContainer(eObject);

		printContents(eObject);

		printReferences(eObject);

		// end of class
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</instance>");
	}

	/**
	 * Prints all {@link EAttribute EAttributes} for an {@link EObject}. Also print attributes that are not set.
	 * 
	 * @param eObject the EObject to print attributes for
	 */
	private void printAttributes(EObject eObject) {
		EClass eClass = eObject.eClass();

		// begin of attributes
		addWhitespace();
		out.print("<attributes ");
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			out.print(escape(attribute.getName()) + "=\"");
			Object value = eObject.eGet(attribute, true);
			if (value != null) {
				out.print(escape(value.toString()) + "\" ");
			} else {
				out.print("null\" ");
			}
		}

		// end of attributes
		out.println("/>");
	}

	/**
	 * Prints the container of an {@link EObject}. This includes its type, its id (see {@link #getID(EObject)}) and its
	 * reference. The reference will be the container-reference if existent and the containment-reference otherwise.
	 * 
	 * @param eObject the EObject to print the container for
	 */
	private void printContainer(EObject eObject) {
		// only print existing containers
		EObject container = eObject.eContainer();
		if (container != null) {

			// only print allowed EClasses
			EClass containerClass = container.eClass();
			if (isForbidden(containerClass)) {
				return;
			}

			// begin of container: print container class name and id
			addWhitespace();
			out.print("<container type=\"" + escape(containerClass.getName()) + "\" ");
			out.print("id=\"" + escape(getID(container)) + "\" ");

			// does the container feature exist?
			if (eObject.eContainmentFeature().getEOpposite() != null) {
				// if so, print it
				out.print("container-reference=\"" + escape(eObject.eContainmentFeature().getEOpposite().getName())
					+ "\"");

			} else {
				// otherwise print the containment feature
				out.print("containment-reference=\"" + escape(eObject.eContainmentFeature().getName()) + "\"");
			}

			// end of container
			out.println("/>");
		}
	}

	/**
	 * Prints all the contents of an {@link EObject}. This includes all the references, their types and names and the
	 * corresponding values. Only references that are set will be printed.
	 * 
	 * @param eObject the EObject to print contents for
	 */
	private void printContents(EObject eObject) {
		EClass eClass = eObject.eClass();

		// begin of contents
		addWhitespace();
		out.println("<contents>");
		whitespaceCounter += 2;

		// print contents for every reference
		for (EReference containment : eClass.getEAllContainments()) {
			// only print references that are set
			if (eObject.eIsSet(containment)) {

				// begin containment-reference: print type and name
				addWhitespace();
				out.print("<reference type=\"" + escape(containment.getEReferenceType().getName()) + "\" ");
				out.println("name=\"" + escape(containment.getName()) + "\">");
				whitespaceCounter += 2;

				// is the reference's multiplicity > 1 ?
				if (containment.isMany()) {
					List<EObject> containments = (List<EObject>) eObject.eGet(containment, true);
					// print all referenced objects, if its class is allowed
					for (EObject referencedObject : containments) {
						if (!isForbidden(referencedObject.eClass())) {
							print(referencedObject);
						}
					}
				} else {
					// multiplicity = 1 -> print the object only if its class is allowed
					EObject referencedObject = (EObject) eObject.eGet(containment, true);
					if (!isForbidden(referencedObject.eClass())) {
						print(referencedObject);
					}
				}

				// end of containment-reference
				whitespaceCounter -= 2;
				addWhitespace();
				out.println("</reference>");
			}

		}

		// end of contents
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</contents>");
	}

	/**
	 * Prints all cross-references for an {@link EObject}. This includes each reference's type, its name and its
	 * value(s). Only references that are set will be printed.
	 * 
	 * @param eObject the EObject to print cross-references for
	 */
	private void printReferences(EObject eObject) {
		EClass eClass = eObject.eClass();

		// begin of cross-references
		addWhitespace();
		out.println("<cross-references>");
		whitespaceCounter += 2;

		for (EReference reference : eClass.getEAllReferences()) {

			// ignore container/containment references
			if (reference.isContainer() || reference.isContainment()) {
				continue;
			}

			// only print references that are set
			if (eObject.eIsSet(reference)) {

				// begin of reference: print type and name
				addWhitespace();
				out.print("<reference type=\"" + escape(reference.getEReferenceType().getName()) + "\" ");
				out.print("name=\"" + escape(reference.getName()) + "\"");

				// is the reference's multiplicity > 1 ?
				if (reference.isMany()) {
					out.println(">");
					whitespaceCounter += 2;

					List<EObject> referencedObjects = (List<EObject>) eObject.eGet(reference, true);
					for (EObject referencedObject : referencedObjects) {

						// only print allowed classes
						if (isForbidden(referencedObject.eClass())) {
							continue;
						}

						// begin of cross-reference entry: print class and ID
						addWhitespace();
						out.print("<entry ");
						out.print("class=\"" + escape(referencedObject.eClass().getName()) + "\" ");
						out.print("id=\"" + escape(getID(referencedObject)) + "\" ");

						// end of cross-reference entry
						out.println("/>");
					}
					// end of reference
					whitespaceCounter -= 2;
					addWhitespace();
					out.println("</reference>");
				} else {
					// multiplicity = 1 -> print the object's class and ID only if its class is allowed
					EObject referencedObject = (EObject) eObject.eGet(reference, true);
					if (isForbidden(referencedObject.eClass())) {
						continue;
					}
					out.print(" class=\"" + escape(referencedObject.eClass().getName()) + "\" ");
					out.print("id=\"" + escape(getID(referencedObject)) + "\" ");

					// end of reference
					out.println("/>");
				}
			}
		}

		// end of cross-references
		whitespaceCounter -= 2;
		addWhitespace();
		out.println("</cross-references>");
	}

	/**
	 * Retrieves an ID for an {@link EObject}. To do so, this method tries to obtain an ID by calling
	 * {@link EcoreUtil#getID(EObject)}. If this method returns <code>null</code>, {@link EcoreUtil#generateUUID()} is
	 * called. Either way, the result is stored in {@link #objectToID} for future use.
	 * 
	 * @param eObject the EObject to get an ID for
	 * @return an ID for eObject
	 */
	private String getID(EObject eObject) {
		// try to obtain stored IDs
		String result = objectToID.get(eObject);

		if (result == null) {
			// no ID was stored -> try to get it from the object
			result = EcoreUtil.getID(eObject);

			if (result == null) {
				// object has no ID attribute -> generate a new ID
				result = EcoreUtil.generateUUID();
			}

			// store the ID
			objectToID.put(eObject, result);
		}

		return result;
	}

	/**
	 * Decides whether an {@link EClass} is forbidden, i.e. if it mustn't be printed. To do so, this method takes
	 * {@link #allowedEClasses} into account.
	 * 
	 * @param eClass the EClass in question
	 * @return whether <code>eClass</code> is forbidden or not
	 */
	private boolean isForbidden(EClass eClass) {
		return !allowedEClasses.contains(eClass);
	}

}
