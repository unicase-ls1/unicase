package org.unicase.emfstore.update.steps;

import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Version;
import org.unicase.emfstore.update.UpdateStepRenameFeature;
import org.unicase.model.task.TaskPackage;

/**
 * @author schroech
 */
public class UpdateStepWorkPackageDueDate extends UpdateStepRenameFeature {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getSourceFeatureName()
	 */
	@Override
	public String getSourceFeatureName() {
		return "endDate";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getTargetFeatureName()
	 */
	@Override
	public String getTargetFeatureName() {
		return "dueDate";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#getTransformableEClass()
	 */
	@Override
	public EClass getTransformableEClass() {
		return TaskPackage.eINSTANCE.getWorkPackage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	 */
	public Version getSourceVersion() {
		return new Version("0.2.9");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	 */
	public Version getTargetVersion() {
		return new Version("0.2.10");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.update.UpdateStep#getTitle()
	 */
	public String getTitle() {
		return "Rename Workpackage endDate to dueDate";
	}

}
