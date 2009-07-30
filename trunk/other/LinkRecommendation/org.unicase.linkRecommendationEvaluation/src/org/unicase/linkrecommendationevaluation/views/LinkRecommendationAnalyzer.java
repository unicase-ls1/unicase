package org.unicase.linkrecommendationevaluation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.linkrecommendation.RecommendationManager;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.task.TaskPackage;

public class LinkRecommendationAnalyzer implements DataAnalyzer{
	
	private List<EReference> relevantReferences;
	private Double threshold;
	
	public void LinkRecommendationAnalyzer(){
		//Thats how to get a reference
		// Have one place where you define all relevant reference for the evaluation
		//like this
		relevantReferences = new ArrayList<EReference>();
		
		relevantReferences.add(ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements());
		threshold = 0.1;
	}
	
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Approach1PrecisionLinkTypeA");
		names.add("Approach1RecallLinkTypeA");
		names.add("Approach1PrecisionLinkTypeB");
		names.add("Approach1RecallLinkTypeB");
		//Build based on relevant links and approaches
		return null;
	}

	public List<Object> getValue(ProjectAnalysisData data) {
//		EList<ChangePackage> changePackages = data.getChangePackages();
//		List<AbstractOperation> operations = new ArrayList<AbstractOperation>();
//		for(ChangePackage changePackage: changePackages){
//			
//			operations.addAll(changePackage.getOperations());
//		}
//		for(AbstractOperation operation: operations){
//			if(operation instanceof ReferenceOperation);
//		}
//		
		List<Object> results = new ArrayList<Object>();
		results.add("foo");
		results.add("bar");
		
		Project project = data.getProjectState();
		EList<ModelElement> allModelElements = project.getAllModelElements();
		
		for(ModelElement modelElement: allModelElements){
			List<EReference> refs = modelElement.eClass().getEReferences();
			
			for(EReference eReference : refs) {
				if (!relevantReferences.contains(eReference)) {
					continue;
				}
				
				Object existing = modelElement.eGet(eReference);
				List<ModelElement> correctMEs = new ArrayList<ModelElement>();
				
				if (existing instanceof EList) {
					EList<ModelElement> eList = (EList<ModelElement>) existing;
					correctMEs.addAll(eList);
				} else if (existing instanceof EObject) {
					ModelElement eObject = (ModelElement) existing;
					correctMEs.add(eObject);
				}
				
				EClass clazz = eReference.getEReferenceType();
				Collection<ModelElement> candidates = modelElement.getProject().getAllModelElementsbyClass(clazz,
					new BasicEList<ModelElement>());
				
				Map<ModelElement, Double>relevanceMap = RecommendationManager.getInstance().getMatchMap(modelElement, candidates);
				
				double foundAndRec =0, foundNotRec =0;
				for(ModelElement el : correctMEs) {
					Double val = relevanceMap.get(el);
					if(val!=null && val>=threshold) {
						foundAndRec++;
					}
					else {
						foundNotRec++;
					}	
				}
				//TODO: relevance map. size is wrong, just take elements above threshold.
				double precision = foundAndRec/relevanceMap.size();
				double recall = foundAndRec/candidates.size();
				
				results.add(precision);
				results.add(recall);
			}
		}
		
		return results;
	}
	
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		
	}

	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}

	public boolean isExportOnce() {
		// TODO Auto-generated method stub
		return false;
	}	
}
