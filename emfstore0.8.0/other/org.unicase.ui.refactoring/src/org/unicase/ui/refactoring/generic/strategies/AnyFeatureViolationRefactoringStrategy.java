/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.generic.strategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.MESuggestedSelectionDialog;
import org.unicase.ui.refactoring.generic.strategies.dialogs.AnyFeatureViolationRefactoringDialog;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * An {@link UnicaseRefactoringStrategy} for arbitrary features.
 * 
 * @author pfeifferc
 */
public class AnyFeatureViolationRefactoringStrategy extends UnicaseRefactoringStrategy {

	private AnyFeatureViolationRefactoringDialog abstractRefactoringDialog;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		if(getFirstInvalidStructuralFeature() == null) {
			return RefactoringResult.ABORT;
		}
		EStructuralFeature structuralFeature = getFirstInvalidStructuralFeature();
		if(structuralFeature instanceof EReference) {
			openDialog(structuralFeature);
			return RefactoringResult.SUCCESS_CREATE;
		}
		abstractRefactoringDialog = new AnyFeatureViolationRefactoringDialog(getShell(), this);
		abstractRefactoringDialog.create();
		abstractRefactoringDialog.setTitle("Please set a valid value or reference");
		abstractRefactoringDialog.setMessage(getConstraintStati().iterator().next().getMessage());
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}

	@SuppressWarnings("unchecked")
	private void openDialog(EStructuralFeature structuralFeature) {
		UnicaseModelElement modelElement = (UnicaseModelElement) getInvalidEObject();
		EReference eReference = (EReference) structuralFeature;
		EClass clazz = eReference.getEReferenceType();
		Collection<EObject> allElements = new EMFStoreModelelementContext(modelElement).getAllModelElementsbyClass(clazz);
		allElements.remove(modelElement);
		Object object = modelElement.eGet(eReference);

		EList<EObject> eList = null;
		EObject eObject = null;

		// don't the instances that are already linked
		if (eReference.isMany() && object instanceof EList<?>) {
			eList = (EList<EObject>) object;
			for (EObject ref : eList) {
				allElements.remove(ref);
			}
		} else if (!eReference.isMany() && object instanceof EObject) {
			eObject = (EObject) object;
			allElements.remove(eObject);
		}

		// don't show contained elements for inverse containment references
		if (eReference.isContainer()) {
			allElements.removeAll(modelElement.eContents());
		}

		// take care of circular references
		if (eReference.isContainment()) {
			Iterator<EObject> iter = allElements.iterator();
			while (iter.hasNext()) {
				EObject me = iter.next();
				if (EcoreUtil.isAncestor(me, modelElement)) {
					iter.remove();
				}
			}
		}

		MESuggestedSelectionDialog dlg = new MESuggestedSelectionDialog(getName(), getDescription(), true,
				modelElement, eReference, allElements);

		if (dlg.open() == Window.OK) {
			if (eReference.isMany()) {
				Object[] results = dlg.getResult();
				ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell());
				progressDialog.open();
				progressDialog.getProgressMonitor().beginTask("Adding references...", results.length * 10);
				List<EObject> list = new ArrayList<EObject>();
				for (Object result : results) {
					if (result instanceof EObject) {
						list.add((EObject) result);
						progressDialog.getProgressMonitor().worked(10);
					}
				}
				eList.addAll(list);

				progressDialog.getProgressMonitor().done();
				progressDialog.close();
			} else {
				Object result = dlg.getFirstResult();
				if (result instanceof EObject) {
					modelElement.eSet(eReference, result);
				}
			}
		}
	}
}