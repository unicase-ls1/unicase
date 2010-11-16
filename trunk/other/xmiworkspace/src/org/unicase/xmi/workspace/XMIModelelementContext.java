package org.unicase.xmi.workspace;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.metamodel.AssociationClassElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.workspace.Configuration;

public class XMIModelelementContext extends ModelElementContext implements ProjectChangeObserver  {

	private final Project project;
	private EObject modelelement;
	
	public XMIModelelementContext(EObject me) {
		project = ModelUtil.getProject(me);
		project.addProjectChangeObserver(this);
		this.modelelement = me;
	}
	
	@Override
	public boolean contains(EObject eObject) {
		Project p = ModelUtil.getProject(eObject);
		if (p != null) {
			return p.equals(project);
		}

		return false;
	}

	@Override
	public void dispose() {
		project.removeProjectChangeObserver(this);
	}

	@Override
	public Collection<EObject> getAllModelElements() {
		Collection<EObject> ret = new BasicEList<EObject>();
		ret.addAll(project.getAllModelElements());
		return ret;
	}

	@Override
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, boolean association) {
		Collection<EObject> ret = new BasicEList<EObject>();
		for (EObject element : project.getAllModelElements()) {
			if (association || !isAssociationClassElement(element)) {
				ret.add(element);
			}
		}
		return ret;
	}

	@Override
	public EditingDomain getEditingDomain() {
		return Configuration.getEditingDomain();
	}

	@Override
	public boolean isNonDomainElement(EObject eObject) {
		return (eObject instanceof NonDomainElement);
	}

	@Override
	public void modelElementAdded(Project project, EObject modelElement) {
		// Do nothing.
		
	}

	@Override
	public void modelElementRemoved(Project project, EObject modelElement) {
		if (modelElement.equals(this.modelelement)) {
			modelElementDeleted();
		}
	}

	@Override
	public void notify(Notification notification, Project project, EObject modelElement) {
		// Do nothing.
	}

	@Override
	public void projectDeleted(Project project) {
		contextDeleted();
	}

	@Override
	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		if (isAssociationClassElement(eObject)) {
			AssociationClassElement ace = (AssociationClassElement) eObject;
			return new ECPAssociationClassElement(ace.getSourceFeature(), ace.getTargetFeature(), ace
				.getAssociationFeatures());
		}
		return null;
	}

	@Override
	public boolean isAssociationClassElement(EObject eObject) {
		return (eObject instanceof AssociationClassElement);
	}
	
	@Override
	public MetaModelElementContext getMetaModelElementContext() {
		return XMIMetaModelElementContext.getInstance();
	}

}
