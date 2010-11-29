package org.unicase.xmi.structure;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;

/**
 * This class represents a container for multiple projects
 * @author Markus, Matti
 *
 */
public abstract class XMIECPContainer implements XMIECPProject {

	public ECPWorkspace getWorkspace() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setWorkspace(ECPWorkspace value) {
		// TODO Auto-generated method stub

	}

	public boolean contains(EObject eObject) {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<EObject> getAllModelElement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isNonDomainElement(EObject eObject) {
		// TODO Auto-generated method stub
		return false;
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void addECPProjectListener(ECPProjectListener listener) {
		// TODO Auto-generated method stub

	}

	public void removeECPProjectListener(ECPProjectListener listener) {
		// TODO Auto-generated method stub

	}

	public void projectChanged() {
		// TODO Auto-generated method stub

	}

	public void projectDeleted() {
		// TODO Auto-generated method stub

	}

	public void modelelementDeleted(EObject eobject) {
		// TODO Auto-generated method stub

	}

	public EObject getRootObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRootObject(EObject value) {
		// TODO Auto-generated method stub

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

	public Object eGet(EStructuralFeature arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eGet(EStructuralFeature arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eInvoke(EOperation arg0, EList<?> arg1) throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eIsSet(EStructuralFeature arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void eSet(EStructuralFeature arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void eUnset(EStructuralFeature arg0) {
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

	public void eNotify(Notification arg0) {
		// TODO Auto-generated method stub

	}

	public void eSetDeliver(boolean arg0) {
		// TODO Auto-generated method stub

	}

	public Collection<EObject> getAllModelElements() {
		// TODO Auto-generated method stub
		return null;
	}

	public EditingDomain getEditingDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAssociationClassElement(EObject eObject) {
		// TODO Auto-generated method stub
		return false;
	}

	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public MetaModelElementContext getMetaModelElementContext() {
		// TODO Auto-generated method stub
		return null;
	}

}
