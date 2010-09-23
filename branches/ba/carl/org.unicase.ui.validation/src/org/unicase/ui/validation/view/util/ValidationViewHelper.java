/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.view.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.dialogs.ListDialog;
import org.unicase.ui.validation.Activator;
import org.unicase.ui.validation.refactoring.RefactoringStrategy;
import org.unicase.ui.validation.view.filters.ValidationFilter;
import org.unicase.ui.validation.view.providers.RefactoringStrategyLabelProvider;

/**
 * Helper for the validation view.
 * 
 * @author pfeifferc
 */
public final class ValidationViewHelper {

	/**
	 * The validation filters.
	 */
	private static List<ValidationFilter> validationFilters;

	private ValidationViewHelper() {
		// nothing to do here
	}

	/**
	 * @return the {@link ValidationFilter} list from the extension point
	 */
	public static List<ValidationFilter> getFiltersFromExtensionPoint() {
		if (validationFilters != null) {
			return validationFilters;
		}
		List<ValidationFilter> validationFilters = new ArrayList<ValidationFilter>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.validation.filters");
		for (IConfigurationElement element : config) {
			try {
				Object object = element.createExecutableExtension("filter");
				if (object instanceof ValidationFilter) {
					ValidationFilter validationFilter = (ValidationFilter) object;
					if (validationFilter.init()) {
						validationFilters.add(validationFilter);
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		ValidationViewHelper.validationFilters = validationFilters;
		return validationFilters;
	}

	/**
	 * @return the list of {@link RefactoringStrategy}s
	 */
	public static ArrayList<RefactoringStrategy> getGroupRefactoringStrategiesFromExtensionPoint() {
		ArrayList<RefactoringStrategy> refactoringStrategies = new ArrayList<RefactoringStrategy>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.validation.refactoring.strategies");
		for (IConfigurationElement element : config) {
			try {
				String applicableForClass = element.getAttribute("applicableFor");
				String id = element.getAttribute("id");
				String name = element.getAttribute("name");
				String description = element.getAttribute("description");
				if (applicableForClass.equals("org.unicase.constraint.group")) {
					final Object object = element.createExecutableExtension("strategy");
					RefactoringStrategy strategy = (RefactoringStrategy) object;
					strategy.setDescription(description);
					strategy.setId(id);
					strategy.setName(name);
					refactoringStrategies.add(strategy);
				}
			} catch (CoreException e) {
				Activator.getDefault().logException(e);
			}
		}
		return refactoringStrategies;
	}

	/**
	 * @param constraintStatus the {@link IConstraintStatus}
	 * @return the list of {@link RefactoringStrategy}s
	 */
	public static ArrayList<RefactoringStrategy> getRefactoringStrategiesFromExtensionPoint(
		IConstraintStatus constraintStatus) {
		ArrayList<RefactoringStrategy> refactoringStrategies = new ArrayList<RefactoringStrategy>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.validation.refactoring.strategies");
		EStructuralFeature invalidStructuralFeature = extractInvalidFeatureFrom(constraintStatus);
		if (invalidStructuralFeature == null) {
			return refactoringStrategies;
		}
		for (IConfigurationElement element : config) {
			try {
				RefactoringStrategy anyRefactoringStrategy = null;
				String applicableForClass = element.getAttribute("applicableFor");
				String id = element.getAttribute("id");
				String name = element.getAttribute("name");
				String description = element.getAttribute("description");
				String constraintId = constraintStatus.getConstraint().getDescriptor().getId();
				if (applicableForClass.equals(constraintId)) {
					final Object object = element.createExecutableExtension("strategy");
					RefactoringStrategy strategy = (RefactoringStrategy) object;
					strategy.setConstraintStatus(constraintStatus);
					strategy.setDescription(description);
					strategy.setId(id);
					strategy.setName(name);
					strategy.setInvalidEObject(constraintStatus.getTarget());
					strategy.setInvalidStructuralFeature(invalidStructuralFeature);
					refactoringStrategies.add(strategy);
				} else if (applicableForClass.equals("org.unicase.constraint.generic.all")) {
					final Object object = element.createExecutableExtension("strategy");
					anyRefactoringStrategy = (RefactoringStrategy) object;
					anyRefactoringStrategy.setConstraintStatus(constraintStatus);
					anyRefactoringStrategy.setDescription(description);
					anyRefactoringStrategy.setInvalidEObject(constraintStatus.getTarget());
					anyRefactoringStrategy.setId(id);
					anyRefactoringStrategy.setName(name);
					anyRefactoringStrategy.setInvalidStructuralFeature(invalidStructuralFeature);
				}
				if (refactoringStrategies.size() == 0 && anyRefactoringStrategy != null) {
					refactoringStrategies.add(anyRefactoringStrategy);
				}
			} catch (CoreException e) {
				Activator.getDefault().logException(e);
			}
		}
		return refactoringStrategies;
	}

	private static EStructuralFeature extractInvalidFeatureFrom(IConstraintStatus constraintStatus) {
		for (EObject eObject : constraintStatus.getResultLocus()) {
			if (eObject instanceof EStructuralFeature) {
				return (EStructuralFeature) eObject;
			}
		}
		return null;
	}

	/**
	 * Begins the {@link RefactoringStrategy}.
	 * 
	 * @param shell the {@link Shell}
	 * @param tableItem the {@link TableItem}
	 */
	public static void performRefactoring(Shell shell, TableItem tableItem) {
		IConstraintStatus constraintStatus = (IConstraintStatus) tableItem.getData();
		List<?> abstractRefactoringStrategies = ValidationViewHelper
			.getRefactoringStrategiesFromExtensionPoint(constraintStatus);
		if (abstractRefactoringStrategies.isEmpty()) {
			return;
		}
		RefactoringStrategy refactoringStrategy = null;
		if (abstractRefactoringStrategies.size() == 1) {
			refactoringStrategy = (RefactoringStrategy) abstractRefactoringStrategies.get(0);
		} else {
			// otherwise show list dialog
			ListDialog listDialog = new ListDialog(shell);
			listDialog.setInput(abstractRefactoringStrategies);
			listDialog.setLabelProvider(new RefactoringStrategyLabelProvider());
			listDialog.setContentProvider(new ArrayContentProvider());
			listDialog.setTitle("Choose a refactoring strategy");
			listDialog.open();
			Object[] result = listDialog.getResult();
			if (result != null && result.length > 0) {
				refactoringStrategy = (RefactoringStrategy) result[0];
			}
		}
		if (refactoringStrategy != null) {
			refactoringStrategy.setShell(shell);
			refactoringStrategy.startRefactoring();
		}
	}
}
