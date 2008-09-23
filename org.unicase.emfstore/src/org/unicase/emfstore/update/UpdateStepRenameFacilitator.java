package org.unicase.emfstore.update;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.rationale.RationalePackage;

/**
 * @author schroech
 *
 */
public class UpdateStepRenameFacilitator extends UpdateStepRenameFeature{ 
	
	

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTitle()
	 */
	public String getTitle(){
		return "Assignable transformation";
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	 */
	public org.osgi.framework.Version getSourceVersion() {
		return new org.osgi.framework.Version("0.0.1");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	 */
	public org.osgi.framework.Version getTargetVersion() {
		return new org.osgi.framework.Version("0.0.2");
	}

	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getSourceFeatureName()
	 */
	@Override
	public String getSourceFeatureName() {
		return "facilitator";
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
		return RationalePackage.eINSTANCE.getIssue();
	}


}
