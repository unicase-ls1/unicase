package org.unicase.emfstore.update;

import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Version;
import org.unicase.model.bug.BugPackage;

/**
 * @author schroech
 *
 */
public class UpdateStepRenameAssignedTo extends UpdateStepRenameFeature {

	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getSourceFeatureName()
	 */
	@Override
	public String getSourceFeatureName() {
		return "assignedTo";
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getTargetFeatureName()
	 */
	@Override
	public String getTargetFeatureName() {
		return "assignee";
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#getTransformableEClass()
	 */
	@Override
	public EClass getTransformableEClass() {
		return BugPackage.eINSTANCE.getBugReport();
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	 */
	public Version getSourceVersion() {
		return new Version("0.0.1");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	 */
	public Version getTargetVersion() {
		return new Version("0.0.2");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTitle()
	 */
	public String getTitle() {
		return "Rename assigned to";
	}

}
