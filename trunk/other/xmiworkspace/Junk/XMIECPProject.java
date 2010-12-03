package org.unicase.xmi.workspace;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPProjectImpl;

public class XMIECPProject extends ECPProjectImpl {

	private final EditingDomain domain;
	private final EObject root;
	private HashSet<EObject> result;
	
	/**
	 * Constructor.
	 * @param domain editing domain
	 * @param root root of project
	 */
	public XMIECPProject(EditingDomain domain, EObject root) {
		this.domain = domain;
		this.root = root;
		setRootObject(root);		
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#contains(org.eclipse.emf.ecore.EObject)
	 */
	public boolean contains(EObject eObject) {
		return getAllModelElements().contains(eObject);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#dispose()
	 */
	public void dispose() {
		//do nothing
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getAllModelElement()
	 */
	public Collection<EObject> getAllModelElement() {
		return getAllModelElements();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass, org.eclipse.emf.common.util.BasicEList)
	 */
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz,
			BasicEList<EObject> basicEList) {
		HashSet<EObject> result = new HashSet<EObject>();
		for (EObject eObject: getAllModelElements()) {
			if (clazz.isInstance(eObject)) {
				result.add(eObject);
			}
		}
		return result;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getMetaModelElementContext()
	 */
	public MetaModelElementContext getMetaModelElementContext() {
		return new XMIMetaModelElementContext();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#isNonDomainElement(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isNonDomainElement(EObject eObject) {
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.common.ECPModelelementContext#getAllModelElements()
	 */
	public Collection<EObject> getAllModelElements() {
		result = new HashSet<EObject>();
		TreeIterator<EObject> eAllContents = root.eAllContents();
		while (eAllContents.hasNext()) {
			result.add(eAllContents.next());
		}
		return result;
		
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.common.ECPModelelementContext#getEditingDomain()
	 */
	public EditingDomain getEditingDomain() {
		return domain;
	}

	//TODO check whether needed
	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		return null;
	}

	//TODO check whether needed
	public boolean isAssociationClassElement(EObject eObject) {
		return false;
	}

}
