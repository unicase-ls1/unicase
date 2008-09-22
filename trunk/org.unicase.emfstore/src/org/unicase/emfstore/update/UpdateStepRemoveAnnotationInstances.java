package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osgi.framework.Version;
import org.unicase.model.Annotation;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.impl.CommentImpl;

public class UpdateStepRemoveAnnotationInstances extends UpdateStepImpl {

	public Version getSourceVersion() {
		return new Version("0.0.2.beta");
	}

	public Version getTargetVersion() {
		return new Version("0.0.3.beta");
	}

	public String getTitle() {
		return "Remove Annotation Instances";
	}

	@Override
	public int updateProjectState(Project state) {
		int numberOfUpdatedItems =  super.updateProjectState(state);
		
		EList<Annotation> allAnnotations = state.getAllModelElementsbyClass(ModelPackage.eINSTANCE.getAnnotation(), 
				new BasicEList<Annotation>());
		
		for (Annotation annotation : allAnnotations) {
			Comment newComment = RationaleFactory.eINSTANCE.createComment();
			
			EList<EStructuralFeature> structuralFeatures = annotation.eClass().getEStructuralFeatures();
			for (EStructuralFeature structuralFeature : structuralFeatures) {
				int featureID = structuralFeature.getFeatureID();
				if (featureID != ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER) {
					newComment.eSet(structuralFeature, annotation.eGet(structuralFeature));
				}
			}
			
			numberOfUpdatedItems ++; 
		}
		
		return numberOfUpdatedItems;
	}

}
