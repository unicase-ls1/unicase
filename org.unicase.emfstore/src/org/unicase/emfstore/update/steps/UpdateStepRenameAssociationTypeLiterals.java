package org.unicase.emfstore.update.steps;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osgi.framework.Version;
import org.unicase.emfstore.update.UpdateStepTransformFeature;
import org.unicase.model.ModelElement;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.ClassesPackage;

/**
 * @author schroech
 *
 */
public class UpdateStepRenameAssociationTypeLiterals extends
		UpdateStepTransformFeature {

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStepTransformFeature#getFeatureName()
	*/
	@Override
	public String getFeatureName() {
		return "type";
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStepTransformFeature#updateFeature(org.unicase.model.ModelElement, org.eclipse.emf.ecore.EStructuralFeature)
	*/
	@Override
	public int updateFeature(ModelElement modelElement,
			EStructuralFeature feature) {
		int numberOfUpdates = 1;
		
		AssociationType featureValue = (AssociationType) modelElement.eGet(feature);
		if (featureValue == AssociationType.AGGREGATION_OLD) {
			modelElement.eSet(feature, AssociationType.AGGREGATION);
		}else if (featureValue == AssociationType.DIRECTED_ASSOCIATION_OLD) {
			modelElement.eSet(feature, AssociationType.DIRECTED_ASSOCIATION);
		}else if (featureValue == AssociationType.UNDIRECTED_ASSOCIATION_OLD) {
			modelElement.eSet(feature, AssociationType.UNDIRECTED_ASSOCIATION);
		}else if (featureValue == AssociationType.COMPOSITION_OLD) {
			modelElement.eSet(feature, AssociationType.COMPOSITION);
		}else{
			numberOfUpdates--;
		}
		
		return numberOfUpdates;
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStepTransformClass#getTransformableEClass()
	*/
	@Override
	public EClass getTransformableEClass() {
		return ClassesPackage.eINSTANCE.getAssociation();
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStep#getSourceVersion()
	*/
	public Version getSourceVersion() {
		return new Version("0.0.5");
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStep#getTargetVersion()
	*/
	public Version getTargetVersion() {
		return new Version("0.0.6");
	}

	/**
	* {@inheritDoc}
	* @see org.unicase.emfstore.update.UpdateStep#getTitle()
	*/
	public String getTitle() {
		return "Rename association type literals";
	}

}
