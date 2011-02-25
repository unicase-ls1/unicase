/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.git;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.jdt.configuration.ConfigurationFactory;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.SimpleVersionMapping;
import org.unicase.emfstore.jdt.eclipseworkspace.IFileEntryTuple;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreUtil;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.unicase.emfstore.jdt.exception.CommitCannotCompleteException;
import org.unicase.emfstore.jdt.exception.EObjectNotFoundException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.metamodel.ModelElementId;
import org.unicase.workspace.ModifiedModelElementsCache;
import org.unicase.workspace.ProjectSpace;

/**
 * Creates a VersionMapping for the new committed file. This will create only a SimpleVersionMapping because the next
 * revision id is not predictable.
 * 
 * @author Adrian Staudt
 */
public final class GitVersionMappingCreator {

	private GitVersionMappingCreator() {
	}

	/**
	 * Returns the current simple version mapping with the new revision of the EMF Store.
	 * 
	 * @param feTuple An tuple that holds the information for the file and the entry.
	 * @return The new simple version mapping.
	 * @throws CommitCannotCompleteException Will be thrown if the commit cannot be completed.
	 */
	public static SimpleVersionMapping getVM(IFileEntryTuple feTuple) throws CommitCannotCompleteException {

		boolean isEObjectDirty;
		try {
			StructuredEMFStoreURI structuredEMFStoreURI = ConfigurationManager.getEMFStoreURI(feTuple.getEntry());
			ProjectSpace projectSpace = ProjectSpaceUtil.getProjectSpace(structuredEMFStoreURI.getProjectID());
			try {
				EObject eObject = ProjectSpaceUtil.getEObject(structuredEMFStoreURI);
				ModelElementId modelElementId = projectSpace.getProject().getModelElementId(eObject);

				ModifiedModelElementsCache modifiedModelElementsCache = projectSpace.getModifiedModelElementsCache();
				isEObjectDirty = modifiedModelElementsCache.isModelElementDirty(modelElementId);

			} catch (EObjectNotFoundException e) {
				// EObject has been probably rejected
				// EMF Store version will only increase if projectSpace is dirty
				isEObjectDirty = projectSpace.isDirty();
			}

			int currentProjectSpaceRevision = EMFStoreUtil.getLocalProjectSpaceRevision(projectSpace);
			SimpleVersionMapping simpleVersionMapping = ConfigurationFactory.eINSTANCE.createSimpleVersionMapping();
			if (!isEObjectDirty) {
				simpleVersionMapping.setEMFStoreRevision(currentProjectSpaceRevision);
			} else {
				simpleVersionMapping.setEMFStoreRevision(currentProjectSpaceRevision + 1);
			}

			return simpleVersionMapping;

		} catch (ProjectSpaceNotFoundException e) {
			throw new CommitCannotCompleteException(e);
		}
	}
}
