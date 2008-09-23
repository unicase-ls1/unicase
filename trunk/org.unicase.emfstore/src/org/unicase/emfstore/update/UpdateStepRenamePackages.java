package org.unicase.emfstore.update;

import org.eclipse.emf.ecore.EClass;
import org.osgi.framework.Version;
import org.unicase.model.component.ComponentPackage;

/**
 * @author schroech
 *
 */
public class UpdateStepRenamePackages extends UpdateStepRenameFeature {

	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getSourceFeatureName()
	 */
	@Override
	public String getSourceFeatureName() {
		return "packages";
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepRenameFeature#getTargetFeatureName()
	 */
	@Override
	public String getTargetFeatureName() {
		return "subsystems";
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#getTransformableEClass()
	 */
	@Override
	public EClass getTransformableEClass() {
		return ComponentPackage.eINSTANCE.getComponent();
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	 */
	public Version getSourceVersion() {
		return new Version("0.0.3.beta");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	 */
	public Version getTargetVersion() {
		return new Version("0.0.4.beta");
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStep#getTitle()
	 */
	public String getTitle() {
		return "Rename packages";
	}

}
