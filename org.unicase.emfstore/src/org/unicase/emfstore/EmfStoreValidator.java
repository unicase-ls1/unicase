/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

/**
 * Validates the serverspace in three different ways. First it resolves all proxies, then checks whether all ME have ids
 * and it is checked whether the changes generate the corret projectstate.
 * 
 * @author wesendon
 */
public class EmfStoreValidator {

	private final ServerSpace serverSpace;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace serverspace
	 */
	public EmfStoreValidator(ServerSpace serverSpace) {
		this.serverSpace = serverSpace;
	}

	/**
	 * Option for resolving all proxies.
	 */
	public static final int RESOLVEALL = 1;

	/**
	 * Option for checking all modelelementids in projecstate and changes.
	 */
	public static final int MODELELEMENTID = 2;

	/**
	 * Option for the change test. All changes will be applied and then compared with the actual projecstate.
	 */
	public static final int PROJECTGENERATION = 4;

	private long timeMillis;

	/**
	 * Runs the validation. You can configure the validation by a bitmask, therefore use the value: {@link #RESOLVEALL},
	 * {@link #MODELELEMENTID} and {@link #PROJECTGENERATION}.
	 * 
	 * @param options options
	 * @param throwException allows you to prevent that an exception is thrown if validation failes
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void validate(int options, boolean throwException) throws FatalEmfStoreException {
		boolean errors = true;
		if ((options & RESOLVEALL) == RESOLVEALL) {
			errors = errors && validateResolveAll();
		}
		if ((options & MODELELEMENTID) == MODELELEMENTID) {
			errors = errors && validateModelelementId();
		}
		if ((options & PROJECTGENERATION) == PROJECTGENERATION) {
			errors = errors && validateProjectGeneration();
		}

		if (errors && throwException) {
			throw new FatalEmfStoreException("Validation failed.");
		}
	}

	/**
	 * Runs the validation. You can configure the validation by a bitmask, therefore use the value: {@link #RESOLVEALL},
	 * {@link #MODELELEMENTID} and {@link #PROJECTGENERATION}.
	 * 
	 * @param options options
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void validate(int options) throws FatalEmfStoreException {
		validate(options, true);
	}

	private boolean validateResolveAll() {
		start("Resolving all elements...");
		EcoreUtil.resolveAll(serverSpace.eResource().getResourceSet());
		EList<Diagnostic> errors = new BasicEList<Diagnostic>();
		EList<Resource> resources = serverSpace.eResource().getResourceSet().getResources();
		for (Resource currentResource : resources) {
			errors.addAll(currentResource.getErrors());
		}
		errors(errors);
		stop();
		return errors.size() > 0;
	}

	private boolean validateModelelementId() {
		start("Checking ModelElementIds...");
		List<String> errors = new ArrayList<String>();
		for (ProjectHistory projectHistory : serverSpace.getProjects()) {
			for (Version version : projectHistory.getVersions()) {
				if (version.getChanges() != null) {
					for (AbstractOperation ao : version.getChanges().getOperations()) {
						if (ao.getModelElementId() == null || ao.getModelElementId().getId() == null) {
							errors.add("ChangeOperation has no ModelElementId in project: "
								+ projectHistory.getProjectId() + " version: "
								+ version.getPrimarySpec().getIdentifier());
						}
					}
				}
				if (version.getProjectState() != null) {
					for (ModelElement me : version.getProjectState().getAllModelElements()) {
						if (me.getModelElementId() == null || me.getModelElementId().getId() == null) {
							errors.add("ModelElement has no ModelElementId in project: "
								+ projectHistory.getProjectId() + " version: "
								+ version.getPrimarySpec().getIdentifier());
						}
					}
				}
			}
		}
		errors(errors);
		stop();
		return errors.size() > 0;
	}

	private boolean validateProjectGeneration() {
		start("Project generation compare ...");
		List<String> errors = new ArrayList<String>();
		for (ProjectHistory history : serverSpace.getProjects()) {
			history = (ProjectHistory) EcoreUtil.copy(history);
			Project state = null;

			for (Version version : history.getVersions()) {
				if (version.getProjectState() != null && state == null) {
					state = (Project) EcoreUtil.copy(version.getProjectState());
				} else {

					version.getChanges().apply(state);

					if (version.getProjectState() != null) {
						int[] compare = linearCompare(version.getProjectState(), state);
						if (compare[0] == 0) {
							errors.add("project compare of project " + history.getProjectId().getId()
								+ " not equal in version " + version.getPrimarySpec().getIdentifier());
						}
						state = (Project) EcoreUtil.copy(version.getProjectState());
					}
				}
			}
		}
		errors(errors);
		stop();
		return errors.size() > 0;
	}

	private void start(String str) {
		timeMillis = System.currentTimeMillis();
		System.out.println("Validation: " + str);
	}

	private void stop() {
		System.out.println("Validation took: " + (System.currentTimeMillis() - timeMillis) + " ms\n");
	}

	private void errors(Collection<? extends Object> errorList) {
		System.out.println("Errors: " + errorList.size());
		for (Object obj : errorList) {
			System.out.println(obj);
		}
	}

	private static int[] linearCompare(Project projectA, Project projectB) {
		int[] result = new int[5];
		final int areEqual = 0;
		final int differencePosition = 1;
		final int character = 2;
		final int lineNum = 3;
		final int colNum = 4;
		result[areEqual] = 1;
		String stringA = "";
		String stringB = "";

		try {
			stringA = SerializationUtil.eObjectToString(projectA);
			stringB = SerializationUtil.eObjectToString(projectB);
		} catch (RMISerializationException e) {
			e.printStackTrace();
		}

		int length = Math.min(stringA.length(), stringB.length());
		for (int index = 0; index < length; index++) {
			if (stringA.charAt(index) != stringB.charAt(index)) {
				result[areEqual] = 0;
				result[differencePosition] = index;
				result[character] = stringA.charAt(index);
				int lineNumber = getLineNum(stringA, index);
				result[lineNum] = lineNumber;
				result[colNum] = getColNum(stringA, index);
				break;
			}
		}
		return result;
	}

	private static int getColNum(String stringA, int index) {
		int lineNum = 1;
		int pos = index;
		int j = 0;
		for (int i = 0; i < index; i++) {
			j++;
			if (stringA.charAt(i) == '\n') {
				lineNum++;
				pos -= j;
				j = 0;
			}
		}
		return pos;
	}

	private static int getLineNum(String stringA, int index) {
		int lineNum = 1;
		for (int i = 0; i < index; i++) {
			if (stringA.charAt(i) == '\n') {
				lineNum++;
			}
		}
		return lineNum;
	}

}
