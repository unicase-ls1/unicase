/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.common;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.changetracking.exceptions.ErrorInModelException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Main utility class of the changetracking plug-in.
 * 
 * @author jfinis
 * 
 */
public final class ChangeTrackingUtil {

	private static final String ERROR_RELEASE_HAS_NO_STREAM = "No stream is assigned to the release.";
	private static final String ERROR_STREAM_HAS_NO_REPO_STREAM = "The stream %s of the release has not associated a repository stream.";
	private static final String ERROR_RELEASE_STREAM_IS_MISSING_LOCATION = "The repository stream '%s' which is associated with the stream of the release has no repository location.";

	private ChangeTrackingUtil() {}

	/**
	 * Adds a model element to a project, relative to another model element: The
	 * model element tree is walked upwards from the model element until a place
	 * where the new model element can be inserted is found.
	 * 
	 * @param toAdd model element to add
	 * @param relativeTo target model element
	 * @param wrapInUnicaseCommand if true, the operation will be wrapped in a
	 *            unicase command.
	 */
	public static void addToProjectRelative(final EObject toAdd, final EObject relativeTo, boolean wrapInUnicaseCommand) {
		if (wrapInUnicaseCommand) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					addToProjectRelative(toAdd, relativeTo, false);
				}
			};
		} else {
			if (!placeRelative(toAdd, relativeTo)) {
				Project p = ModelUtil.getProject(relativeTo);
				if (p != null) {
					p.addModelElement(toAdd);
				}
			}
		}

	}

	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public static EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.isInstance(newMEInstance)) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}

	/**
	 * Places a model element in a project, relative to another one.
	 * 
	 * @param newMEInstance model element to be placed
	 * @param parent target model eleent.
	 * @return whether the model element could be placed in the project.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean placeRelative(final EObject newMEInstance, EObject parent) {
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if (ref != null) {
			Object r = parent.eGet(ref);
			if (ref.isMany()) {
				((EList) r).add(newMEInstance);
				return true;
			}
			return false;
		} else if (parent.eContainer() != null) {
			return placeRelative(newMEInstance, parent.eContainer());
		} else {
			return false;
		}

	}

	/**
	 * Places a model element "in" another one. I.e. it is checked if the target
	 * model element has a containment reference which can contain the new model
	 * element.
	 * 
	 * @param newMEInstance model element to be placed
	 * @param parent target for the model element
	 * @return whether the model element could be placed in the model element
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean putInto(final EObject newMEInstance, EObject parent) {
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if (ref != null) {
			Object r = parent.eGet(ref);
			if (ref.isMany()) {
				((EList) r).add(newMEInstance);
				return true;
			}
			return false;
		} else {
			return false;
		}

	}

	/**
	 * Returns the repository stream associated to a release by following the
	 * link chain release -> stream -> repository stream.
	 * 
	 * If one of the elements of the chain is missing, an ErrorInModelException
	 * is thrown.
	 * 
	 * @param release release
	 * @return the release's repository stream
	 * @throws ErrorInModelException if the release is not connected to a
	 *             repository stream.
	 */
	public static RepositoryStream getRepoStreamOfRelease(Release release) throws ErrorInModelException {
		// Release has a stream assigned?
		Stream stream = release.getStream();
		if (stream == null) {
			throw new ErrorInModelException(ERROR_RELEASE_HAS_NO_STREAM);
		}

		// Stream has a repository stream?
		RepositoryStream repoStream = stream.getRepositoryStream();
		if (repoStream == null) {
			throw new ErrorInModelException(new PrintfFormat(ERROR_STREAM_HAS_NO_REPO_STREAM).sprintf(stream.getName()));
		}

		return repoStream;
	}

	/**
	 * Returns the repository location associated to a release by following the
	 * link chain release -> stream -> repository stream -> repository location.
	 * 
	 * If one of the elements of the chain is missing, an ErrorInModelException
	 * is thrown.
	 * 
	 * @param release release
	 * @return the release's repository location
	 * @throws ErrorInModelException if the release is not connected to a
	 *             repository location.
	 */
	public static RepositoryLocation getRepoLocationOfRelease(Release release) throws ErrorInModelException {
		RepositoryStream repoStream = getRepoStreamOfRelease(release);

		// Repo stream has a location?
		RepositoryLocation releaseStreamLocation = repoStream.getLocation();
		if (releaseStreamLocation == null) {
			throw new ErrorInModelException(new PrintfFormat(ERROR_RELEASE_STREAM_IS_MISSING_LOCATION).sprintf(repoStream.getName()));
		}

		return releaseStreamLocation;
	}

}
