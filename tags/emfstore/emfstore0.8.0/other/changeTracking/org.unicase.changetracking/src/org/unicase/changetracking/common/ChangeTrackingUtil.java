package org.unicase.changetracking.common;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.util.UnicaseCommand;

public class ChangeTrackingUtil {
	
	
	public static void addToProjectRelative(final EObject toAdd, final EObject relativeTo, boolean wrapInUnicaseCommand) {
		if(wrapInUnicaseCommand){
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					addToProjectRelative(toAdd, relativeTo, false);
				}
			};
		} else {
			if(!placeRelative(toAdd,relativeTo)){
				Project p = ModelUtil.getProject(relativeTo);
				if(p != null){
					p.addModelElement(toAdd);
				}
			}
		}
	
		
	}
	
	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public static EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.isInstance(newMEInstance)) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}
	
	private static boolean placeRelative(final EObject newMEInstance, EObject parent){
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if(ref != null){
			Object r = parent.eGet(ref);
			if(ref.isMany()){
				((EList)r).add(newMEInstance);
				return true;
			}
			return false;
		} else if(parent.eContainer() != null){
			return placeRelative(newMEInstance,parent.eContainer());
		} else {
			return false;
		}
		
	}
	
	public static boolean putInto(final EObject newMEInstance, EObject parent){
		EReference ref = getPossibleContainingReference(newMEInstance, parent);
		if(ref != null){
			Object r = parent.eGet(ref);
			if(ref.isMany()){
				((EList)r).add(newMEInstance);
				return true;
			}
			return false;
		} else {
			return false;
		}
		
	}
}
