/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.validation.providers;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintFilter;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ITraversalStrategy.Flat;
import org.eclipse.emf.validation.service.ITraversalStrategy.Recursive;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.ui.common.util.ValidationClientSelector;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.common.validation.constraints.DynamicRuleConstraint;
import org.unicase.ui.common.validation.listeners.ValidationListener;
import org.unicase.ui.common.validation.preferences.ValidationPreferenceConstants;

/**
 * The validation result provider offers methods to register and unregister as a listener to constraint violation
 * changes, and initializes, maintains and provides the results of the live and batch validation runs.
 * 
 * @author pfeifferc
 */
public class ValidationResultProvider extends EContentAdapter {

	/**
	 * The {@link IBatchValidator} validates any given {@link EObject}.
	 */
	private IBatchValidator batchValidator;

	/**
	 * The {@link ILiveValidator} validates any given {@link Notification}.
	 */
	private ILiveValidator liveValidator;

	/**
	 * The root {@link EObject}, or the project.
	 */
	private EObject rootElement;

	/**
	 * The {@link ValidationListener}s.
	 */
	private Map<EObject, Set<ValidationListener>> validationListeners;

	/**
	 * The {@link IConstraintStatus}es.
	 */
	private Map<EObject, Set<IConstraintStatus>> violationsMap;

	/**
	 * Recursive traversal.
	 */
	private Recursive recursiveStrategy;

	/**
	 * Flat traversal.
	 */
	private Flat flatStrategy;

	/**
	 * The constructor call initializes the internal result set of model elements and respective constraint violations.
	 */
	public ValidationResultProvider() {
		// initialize caches
		this.violationsMap = new HashMap<EObject, Set<IConstraintStatus>>();
		this.validationListeners = new HashMap<EObject, Set<ValidationListener>>();
	}

	/**
	 * This method initializes the cache with the given root {@link EObject}.
	 * 
	 * @param rootElement the root {@link EObject}
	 */
	public synchronized void init(EObject rootElement) {
		this.setRootElement(rootElement);
		// dynamic rules
		update(validateSimple(getRootElement(), true));
		// static rules
		update(extractConstraintStatiFrom(validateBatch(getRootElement(), true)));
		rootElement.eAdapters().add(this);
	}

	/**
	 * This method updates the violations map.
	 * 
	 * @param constraintStati to add to the map
	 */
	protected synchronized void update(Set<IConstraintStatus> constraintStati) {
		for (IConstraintStatus constraintStatus : constraintStati) {
			update(constraintStatus);
		}
	}

	/**
	 * This method extracts the {@link IConstraintStatus} from a multi {@link IStatus}.
	 * 
	 * @param stat the {@link IStatus}
	 * @return the extracted {@link ConstraintStatus}es.
	 */
	protected Set<IConstraintStatus> extractConstraintStatiFrom(IStatus stat) {
		Set<IConstraintStatus> constraintStati = new HashSet<IConstraintStatus>();
		if (stat.isMultiStatus()) {
			for (IStatus status : stat.getChildren()) {
				constraintStati.add((IConstraintStatus) status);
			}
		} else if (stat instanceof IConstraintStatus) {
			constraintStati.add((IConstraintStatus) stat);
		}
		return constraintStati;
	}

	/**
	 * This method is called when changes occur that need to trigger a complete re-evaluation of the constraints on the
	 * model elements.
	 */
	public void reinit() {
		violationsMap.clear();
		updateNotify(validateSimple(getRootElement(), true), new HashSet<EObject>());
		updateNotify(extractConstraintStatiFrom(validateBatch(getRootElement(), true)), new HashSet<EObject>());
	}

	/**
	 * This method updates the {@link IConstraintStatus}es and notifies the {@link ValidationListener}s.
	 * 
	 * @param constraintStati the result of the validation run
	 * @param toNotify {@link EObject} to notify
	 */
	private synchronized void updateNotify(Set<IConstraintStatus> constraintStati, Set<EObject> toNotify) {
		for (IConstraintStatus constraintStatus : constraintStati) {
			update(constraintStatus);
			toNotify.add(constraintStatus.getTarget());
		}
		for (EObject eObject : toNotify) {
			notifyListeners(eObject, getViolations(eObject));
		}
	}

	/**
	 * This method updates the status of the violations.
	 * 
	 * @param constraintStatus {@link IConstraintStatus} that is to be updated
	 * @return the {@link IConstraintStatus}
	 */
	private void update(IConstraintStatus constraintStatus) {
		EObject target = constraintStatus.getTarget();
		Set<IConstraintStatus> constraintStati = violationsMap.get(target);
		if (constraintStati == null) {
			constraintStati = new HashSet<IConstraintStatus>();
			violationsMap.put(target, constraintStati);
		}
		constraintStati.add(constraintStatus);
	}

	/**
	 * This method notifies the {@link ValidationResultProvider}'s listeners upon changes of the element's violations.
	 * 
	 * @param eObject to notify about
	 * @param constraintStati the {@link IConstraintStatus} for the change
	 */
	private void notifyListeners(EObject eObject, Set<IConstraintStatus> constraintStati) {
		Set<ValidationListener> set = new HashSet<ValidationListener>();
		if (validationListeners.get(getRootElement()) != null) {
			set.addAll(validationListeners.get(getRootElement()));
		}
		if (validationListeners.get(eObject) != null) {
			set.addAll(validationListeners.get(eObject));
		}
		for (ValidationListener validationListener : set) {
			validationListener.objectValidated(getRootElement(), eObject, constraintStati);
		}
	}

	/**
	 * This method registers a {@link ValidationListener}, so that it will be notified upon any constraint changes for
	 * the specific {@link EObject}.
	 * 
	 * @param eObject for which the constraint violations updates are to be informed about
	 * @param validationListener for the updates
	 */
	public void registerListener(EObject eObject, ValidationListener validationListener) {
		addViolationListener(eObject, validationListener);
	}

	/**
	 * This method registers a {@link ValidationListener}, so that it will be notified upon any constraint changes for
	 * the specific {@link EObject}s.
	 * 
	 * @param eObjects for which the constraint violations updates are to be informed about
	 * @param validationListener for the updates
	 */
	public void registerListener(List<EObject> eObjects, ValidationListener validationListener) {
		for (EObject eObject : eObjects) {
			addViolationListener(eObject, validationListener);
		}
	}

	/**
	 * This method registers a root {@link EObject} {@link ValidationListener}, so that it will be notified upon any
	 * constraint changes.
	 * 
	 * @param validationListener for the updates
	 * @return the EObject root for which the listener was registerd
	 */
	public EObject registerListener(ValidationListener validationListener) {
		addViolationListener(getRootElement(), validationListener);
		return getRootElement();
	}

	/**
	 * This method unregisters a {@link ValidationListener} from the {@link ValidationResultProvider}.
	 * 
	 * @param eObject to unregister for
	 * @param validationListener to be unregisted
	 */
	public void unregisterListener(EObject eObject, ValidationListener validationListener) {
		removeViolationListener(eObject, validationListener);
	}

	/**
	 * This method unregisters the {@link ValidationListener} for the root {@link EObject} from the
	 * {@link ValidationResultProvider}.
	 * 
	 * @param validationListener to be unregistered
	 */
	public void unregisterListener(ValidationListener validationListener) {
		removeViolationListener(getRootElement(), validationListener);
	}

	/**
	 * Helper method for adding violation listeners.
	 * 
	 * @param eObject to add the {@link ValidationListener} for
	 * @param validationListener to add
	 */
	private void addViolationListener(EObject eObject, ValidationListener validationListener) {
		Set<ValidationListener> elementViolationListeners = validationListeners.get(eObject);
		if (elementViolationListeners == null) {
			elementViolationListeners = new HashSet<ValidationListener>();
		}
		elementViolationListeners.add(validationListener);
		validationListeners.put(eObject, elementViolationListeners);
	}

	/**
	 * Helper method for removing violation listeners.
	 * 
	 * @param eObject to remove the {@link ValidationListener} for
	 * @param validationListener to remove
	 */
	public void removeViolationListener(EObject eObject, ValidationListener validationListener) {
		Set<ValidationListener> elementViolationListeners = validationListeners.get(eObject);
		if (elementViolationListeners != null) {
			elementViolationListeners.remove(validationListener);
		}
		validationListeners.put(eObject, elementViolationListeners);
	}

	/**
	 * This method returns all validation results for the project. If there are none, it will return an empty set but
	 * never null.
	 * 
	 * @return the entire result set
	 */
	public Set<IConstraintStatus> getViolations() {
		Set<IConstraintStatus> ret = new HashSet<IConstraintStatus>();
		for (Set<IConstraintStatus> constraintStati : violationsMap.values()) {
			if (constraintStati != null) {
				ret.addAll(constraintStati);
			}
		}
		return ret;
	}

	/**
	 * This method returns the result of the validation for a specific {@link EObject}.
	 * 
	 * @param eObject for which to return the result
	 * @return the result of the validation for the {@link EObject} or for the root {@link EObject} if the
	 *         {@link EObject} was null
	 */
	public Set<IConstraintStatus> getViolations(EObject eObject) {
		Set<IConstraintStatus> constraintStati = new HashSet<IConstraintStatus>();
		if (violationsMap.get(eObject) != null) {
			constraintStati.addAll(violationsMap.get(eObject));
		}
		return constraintStati;
	}

	/**
	 * This method returns the result of the validation for a specific {@link EObject} and its contents.
	 * 
	 * @param root for which to return the result
	 * @return the result of the validation for the {@link EObject} and its contents
	 */
	public Set<IConstraintStatus> getViolationsRecursively(EObject root) {
		Set<IConstraintStatus> constraintStati = new HashSet<IConstraintStatus>();
		if (root == null) {
			root = getRootElement();
		}
		if (violationsMap.get(root) != null) {
			constraintStati.addAll(violationsMap.get(root));
		}
		TreeIterator<EObject> treeIterator = root.eAllContents();
		while (treeIterator.hasNext()) {
			EObject next = treeIterator.next();
			if (next != null) {
				Set<IConstraintStatus> violationSet = violationsMap.get(next);
				if (violationSet != null) {
					constraintStati.addAll(violationSet);
				}
			}
		}
		return constraintStati;
	}

	/**
	 * This method checks if the {@link EStructuralFeature} of the {@link EObject} is invalid.
	 * 
	 * @param eObject to be checked for
	 * @param structuralFeature to be checked for
	 * @return the {@link IConstraintStatus} if the {@link EStructuralFeature} is invalid, else null
	 */
	public Set<IConstraintStatus> getConstraintStatiForInvalidEStructuralFeature(EObject eObject,
		EStructuralFeature structuralFeature) {
		Set<IConstraintStatus> stat = getViolations(eObject);
		Set<IConstraintStatus> constraintStati = new HashSet<IConstraintStatus>();
		if (stat.isEmpty()) {
			return null;
		}
		for (IConstraintStatus constraintStatus : stat) {
			if (constraintStatus.getResultLocus().contains(structuralFeature)) {
				constraintStati.add(constraintStatus);
			}
		}
		return constraintStati;
	}

	/**
	 * This method checks if the {@link EStructuralFeature} of the {@link EObject} is invalid.
	 * 
	 * @param eObject to be checked for
	 * @param structuralFeature to be checked for
	 * @return true if the {@link EStructuralFeature} is invalid, else false
	 */
	public boolean isEStructuralFeatureInvalid(EObject eObject, EStructuralFeature structuralFeature) {
		Set<IConstraintStatus> stat = getViolations(eObject);
		if (stat.isEmpty()) {
			return false;
		}
		for (IConstraintStatus constraintStatus : stat) {
			if (constraintStatus.getResultLocus().contains(structuralFeature)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The validate batch method validates the given {@link EObject} regarding possible violations of model constraints.
	 * A recursive traversal strategy will include the object's contained elements, while a flat traversal strategy will
	 * only validate the given {@link EObject}.
	 * 
	 * @param eObject to validate
	 * @param recursive the traversal strategy to use
	 * @return the result of the validation
	 */
	protected synchronized IStatus validateBatch(EObject eObject, boolean recursive) {
		if (PreferenceHelper.getPreference(ValidationPreferenceConstants.VALIDATION_ENABLED, "true").equals("false")) {
			return new Status(0, "org.unicase.validation", "Validation deactivated");
		}
		if (batchValidator == null) {
			batchValidator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
			batchValidator.setIncludeLiveConstraints(true);
			batchValidator.addConstraintFilter(new IConstraintFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.emf.validation.service.IConstraintFilter#accept(org.eclipse.emf.validation.service.IConstraintDescriptor,
				 *      org.eclipse.emf.ecore.EObject)
				 */
				public boolean accept(IConstraintDescriptor constraint, EObject target) {
					return PreferenceHelper.getPreference(
						"org.unicase.validation.constraint." + constraint.getId() + ".enabled", "true").equals("true");
				}
			});
			recursiveStrategy = new Recursive();
			flatStrategy = new Flat();
		}
		if (recursive) {
			batchValidator.setTraversalStrategy(recursiveStrategy);
		} else {
			batchValidator.setTraversalStrategy(flatStrategy);
		}
		ValidationClientSelector.setRunning(true);
		IStatus status = batchValidator.validate(eObject);
		ValidationClientSelector.setRunning(false);
		return status;
	}

	/**
	 * The validate live method validates the given {@link Notification} in case of changes in {@link EObject}s.
	 * 
	 * @param notification to validate
	 * @return the result of the validation
	 */
	protected synchronized IStatus validateLive(Notification notification) {
		if (PreferenceHelper.getPreference(ValidationPreferenceConstants.VALIDATION_ENABLED, "true").equals("false")) {
			return new Status(0, "org.unicase.validation", "Validation deactivated");
		}
		if (liveValidator == null) {
			liveValidator = ModelValidationService.getInstance().newValidator(EvaluationMode.LIVE);
			liveValidator.addConstraintFilter(new IConstraintFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.emf.validation.service.IConstraintFilter#accept(org.eclipse.emf.validation.service.IConstraintDescriptor,
				 *      org.eclipse.emf.ecore.EObject)
				 */
				public boolean accept(IConstraintDescriptor constraint, EObject target) {
					return PreferenceHelper.getPreference(
						"org.unicase.validation.constraint." + constraint.getId() + ".enabled", "true").equals("true");
				}
			});
			recursiveStrategy = new Recursive();
			flatStrategy = new Flat();
		}
		ValidationClientSelector.setRunning(true);
		IStatus status = liveValidator.validate(notification);
		ValidationClientSelector.setRunning(false);
		return status;
	}

	/**
	 * This method validates {@link EObject}s based on dynamic validation rules.
	 * 
	 * @param target the root {@link EObject} to validate for
	 * @param recursive if to validate the direct and indirect contents of the {@link EObject} too
	 * @return the {@link IConstraintStatus} {@link Set}
	 */
	protected Set<IConstraintStatus> validateSimple(EObject target, boolean recursive) {
		Set<IConstraintStatus> constraintStati = new HashSet<IConstraintStatus>();
		if (PreferenceHelper.getPreference(ValidationPreferenceConstants.VALIDATION_ENABLED, "true").equals("false")) {
			return constraintStati;
		}
		IModelConstraint dynamicRuleConstraint = new DynamicRuleConstraint();
		EList<EObject> eObjects = new BasicEList<EObject>();
		if (recursive) {
			TreeIterator<EObject> eAllContents = target.eAllContents();
			while (eAllContents.hasNext()) {
				eObjects.add(eAllContents.next());
			}
			eObjects.add(target);
		} else {
			eObjects.add(target);
		}
		for (EObject eObject : eObjects) {
			for (EStructuralFeature structuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
				String className = eObject.eClass().getInstanceTypeName();
				String feature = structuralFeature.getName();
				String key = (className + "." + feature).toLowerCase();
				String preference = PreferenceHelper.getPreference(key, "ignore");
				if (preference.equals("ignore")) {
					continue;
				}
				int level = 0;
				if (preference.equals("error")) {
					level = 4;
				} else if (preference.equals("warning")) {
					level = 2;
				} else if (preference.equals("info")) {
					level = 1;
				}
				Object value = eObject.eGet(structuralFeature);
				boolean nullString = value instanceof String && value.equals("");
				boolean emptyList = (value instanceof Collection<?> && ((Collection<?>) value).isEmpty());
				if (value == null || nullString || emptyList) {
					Set<EObject> resultLocus = new HashSet<EObject>();
					resultLocus.add(structuralFeature);
					IConstraintStatus constraintStatus = new ConstraintStatus(dynamicRuleConstraint, eObject, level, 0,
						"The feature \"" + structuralFeature.getName() + "\" is not set.", resultLocus);
					constraintStati.add(constraintStatus);
				}
			}
		}
		return constraintStati;
	}

	/**
	 * This method returns the maximum {@link ConstraintSeverity} found in a {@link Set} of {@link IConstraintStatus}.
	 * 
	 * @param violationSet containing the {@link IConstraintStatus}
	 * @return the maximum {@link ConstraintSeverity}
	 */
	public ConstraintSeverity getMaximumSeverity(Set<IConstraintStatus> violationSet) {
		int constraintSeverity = 0;
		for (IConstraintStatus constraintStatus : violationSet) {
			if (constraintStatus.getSeverity() > constraintSeverity) {
				constraintSeverity = constraintStatus.getSeverity();
			}
			if (constraintSeverity == 4) {
				break;
			}
		}
		switch (constraintSeverity) {
		case (0):
			return ConstraintSeverity.NULL;
		case (1):
			return ConstraintSeverity.INFO;
		case (2):
			return ConstraintSeverity.WARNING;
		case (4):
			return ConstraintSeverity.ERROR;
		default:
			return ConstraintSeverity.NULL;
		}
	}

	/**
	 * @return the {@link ValidationListener}s
	 */
	public Map<EObject, Set<ValidationListener>> getValidationListeners() {
		return validationListeners;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public synchronized void notifyChanged(Notification notification) {
		Set<EObject> toBeChecked = new HashSet<EObject>();
		if (checkContainmentTreeForRootElement(notification, notification.getNotifier())) {
			toBeChecked.add((EObject) notification.getNotifier());
		}
		if (checkContainmentTreeForRootElement(notification, notification.getNewValue())) {
			toBeChecked.add((EObject) notification.getNewValue());
		}
		if (checkContainmentTreeForRootElement(notification, notification.getFeature())) {
			toBeChecked.add((EObject) notification.getFeature());
		}
		for (EObject eObject : toBeChecked) {
			handleValidation(notification, getRootElement(), eObject);
		}
	}

	/**
	 * This method notifies the {@link ValidationResultProvider} of a change in a single {@link EObject}.
	 * 
	 * @param notification the {@link Notification}
	 * @param target the changed {@link EObject}.
	 */
	public void notifyChanged(Notification notification, EObject target) {
		if (checkContainmentTreeForRootElement(notification, target)) {
			handleValidation(notification, getRootElement(), target);
		}
	}

	/**
	 * This method traverses through the {@link EObject} containment hierarchy to find the root {@link EObject}.
	 * 
	 * @param notification to check the root element for
	 * @param toBeChecked the object to be checked
	 * @param true if the root was found
	 */
	private boolean checkContainmentTreeForRootElement(Notification notification, Object toBeChecked) {
		if (toBeChecked instanceof EObject) {
			return ValidationResultProviderRegistry.getInstance().retrieveRoot((EObject) toBeChecked) != null;
		}
		return false;
	}

	/**
	 * This method handles the notification.
	 * 
	 * @param notification the {@link Notification} of the EMF framework
	 * @param rootElement the root {@link EObject}
	 * @param target the target {@link EObject}
	 */
	protected synchronized void handleValidation(Notification notification, EObject rootElement, EObject target) {
		if ((target != rootElement && target.eContainer() == null)
			|| (notification != null && (notification.getEventType() == 4 || notification.getEventType() == 6))) {
			handleRemoved(target);
		} else {
			handleChanged(target);
		}
	}

	/**
	 * This method handles removed {@link EObject}s.
	 * 
	 * @param target {@link EObject} that was removed
	 */
	protected void handleChanged(EObject target) {
		Set<IConstraintStatus> newViolations = extractConstraintStatiFrom(validateBatch(target, false));
		newViolations.addAll(validateSimple(target, false));
		violationsMap.put(target, newViolations);
		if (!newViolations.isEmpty()) {
			notifyListeners(target, getViolations(target));
		} else {
			notifyListeners(target, null);
		}
	}

	/**
	 * This method handles removed {@link EObject}s.
	 * 
	 * @param target the removed {@link EObject}
	 */
	protected void handleAdded(EObject target) {
		Set<IConstraintStatus> newViolations = extractConstraintStatiFrom(validateBatch(target, false));
		newViolations.addAll(validateSimple(target, false));
		violationsMap.put(target, newViolations);
		if (!newViolations.isEmpty()) {
			IConstraintDescriptor constraintDescriptor = newViolations.iterator().next().getConstraint()
				.getDescriptor();
			String preference = PreferenceHelper.getPreference("org.unicase.validation.constraint."
				+ constraintDescriptor.getId() + ".enabled", "true");
			if (preference.equals("true")) {
				notifyListeners(target, getViolations(target));
			}
		}
	}

	/**
	 * This method handles removed {@link EObject}s.
	 * 
	 * @param target the removed {@link EObject}
	 */
	protected void handleRemoved(EObject target) {
		violationsMap.put(target, null);
		Map<EObject, Set<ValidationListener>> validationListeners = this.validationListeners;
		notifyListeners(target, null);
		validationListeners.remove(target);
	}

	/**
	 * The model element {@link EClass}es.
	 */
	private static Set<EClass> modelElementEClasses;

	/**
	 * Retrieve all EClasses from the Ecore package registry that are model element subclasses.
	 * 
	 * @return a set of EClasses
	 */
	public static Set<EClass> getAllModelElementEClasses() {
		if (modelElementEClasses != null) {
			return new HashSet<EClass>(modelElementEClasses);
		}
		Set<EClass> result = new HashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : new HashSet<Entry<String, Object>>(registry.entrySet())) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.addAll(getAllModelElementEClasses(ePackage));
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
			}
			// END SUPRESS CATCH EXCEPTION

		}
		modelElementEClasses = result;
		return result;
	}

	/**
	 * Retrieve all EClasses from the Ecore package that are model element subclasses.
	 * 
	 * @param ePackage the package to get the classes from
	 * @return a set of EClasses
	 */
	private static Set<EClass> getAllModelElementEClasses(EPackage ePackage) {
		return ModelUtil.getAllModelElementEClasses();
		// Set<EClass> result = new HashSet<EClass>();
		// for (EPackage subPackage : ePackage.getESubpackages()) {
		// result.addAll(getAllModelElementEClasses(subPackage));
		// }
		// for (EClassifier classifier : ePackage.getEClassifiers()) {
		// if (classifier instanceof EClass) {
		// EClass subEClass = (EClass) classifier;
		// if (MetamodelPackage.eINSTANCE.getModelElement().isSuperTypeOf(subEClass)) {
		// result.add(subEClass);
		// }
		// }
		// }
		// return result;
	}

	/**
	 * Get the root element registered for.
	 * 
	 * @return the root {@link EObject}
	 */
	public EObject getRootElement() {
		return rootElement;
	}

	/**
	 * @param rootElement the rootElement to set
	 */
	public void setRootElement(EObject rootElement) {
		this.rootElement = rootElement;
	}
}
