/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;

/**
 * Utility class for ModelElements.
 * @author koegel
 *
 */
public final class ModelUtil {
	
	private static final URI VIRTUAL_URI = URI.createURI("virtualUnicaseUri");
	
	/**
	 * Private constructor.
	 */
	private ModelUtil() {
		//nothing to do
	}
	
	/**
	 * Clone the model element. 
	 * The model element id will be the same in the clone.
	 * @param modelElement the model element to clone
	 * @return a clone
	 */
	public static ModelElement clone(ModelElement modelElement) {
		EObject copy = EcoreUtil.copy(modelElement);
		return (ModelElement) copy;
	}

	/**
	 * Copy a model element.
	 * The new model element has a new unique id.
	 * @param modelElement the model element
	 * @return a copy of the given model element
	 */
	public static ModelElement copy(ModelElement modelElement) {
		ModelElement copy = (ModelElement) EcoreUtil.copy(modelElement);
		//reset id
		ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
		copy.setIdentifier(modelElementId.getId());
		//FIXME what about the containment tree is it copied, do we have to change ids too?
		return copy;
	}
	
	/**
	 * Clone a project. Clones all model elements in the project.
	 * @param project the project
	 * @return a clone of the project.
	 */
	public static Project clone(Project project) {
		EObject copy = EcoreUtil.copy(project);
		return (Project) copy;
	}
	
	/**
	 * Clone the model element id. 
	 * 
	 * @param modelElementId the model element id to clone
	 * @return a clone
	 */
	public static ModelElementId clone(ModelElementId modelElementId) {
		EObject copy = EcoreUtil.copy(modelElementId);
		return (ModelElementId) copy;
	}
	
	/**
	 * Compares to projects. Two projects are equal if all model elements are equal.
	 * @param projectA the first project
	 * @param projectB the second project
	 * @return true if the projects are equal
	 */
	public static boolean areEqual(Project projectA, Project projectB) {
		String stringA;
		String stringB;
		try {
			stringA = eObjectToString(projectA);
			stringB = eObjectToString(projectB);
		} catch (SerializationException e) {
			return false;
		}
		return stringA.equals(stringB);
		
	}
	
	/**
	 * Converts an EObject to a String.
	 * 
	 * @param object
	 *            the eObject
	 * @return String representation of the EObject
	 * @throws SerializationException
	 *             if a serialization problem occurs
	 */
	public static String eObjectToString(EObject object) throws SerializationException {
		if (object == null) {
			return null;
		}
		Resource res = (new ResourceSetImpl()).createResource(VIRTUAL_URI);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		res.getContents().add(EcoreUtil.copy(object));
		try {
			res.save(out, null);
		} catch (IOException e) {
			throw new SerializationException(e);
		}
		return out.toString();
	}

	/**
	 * Converts a String to an EObject. Note: String must be the result of
	 * {@link SerializationUtil#eObjectToString(EObject)}
	 * 
	 * @param object
	 *            the String representation of the EObject
	 * @return the deserialized EObject
	 * @throws SerializationException
	 *             if deserialization fails
	 */
	public static EObject stringToEObject(String object)
			throws SerializationException {
		if (object == null) {
			return null;
		}
		Resource res = (new ResourceSetImpl()).createResource(VIRTUAL_URI);
		try {
			res.load(new ByteArrayInputStream(object.getBytes("UTF-8")), null);
		} catch (UnsupportedEncodingException e) {
			throw new SerializationException(e);
		} catch (IOException e) {
			throw new SerializationException(e);
		}

		EObject result = res.getContents().get(0);
		res.getContents().remove(result);
		return result;
	}
}
