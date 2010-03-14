package org.unicase.rap.ui.labelproviders;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;

/**
 * A specific ColumnLabelProvider for the display of features of Checkable instances. For the
 * TaskPackage.Literals.CHECKABLE__CHECKED feature, it returns images of CheckBoxes. For the
 * {@link ModelPackage.Literals.MODEL_ELEMENT__NAME} feature, it uses a {@link DecoratingLabelProvider} to return a
 * decorated image consisting of a symbol corresponding to the model element type and possible decorations.
 * 
 * @author Florian Schneider
 * @author Jonas Helming
 * @author Fatih Ulusoy
 */
public class GenericColumnLabelProvider extends ColumnLabelProvider {
	/**
	 * The feature.
	 */
	private EStructuralFeature feature;
	private DecoratingLabelProvider decoratingLabelProvider;

	/**
	 * Creates a specific ColumnLabelProvider for the display of features of Checkable instances.
	 * 
	 * @param feature the feature that this provider shall return a label for
	 */
	public GenericColumnLabelProvider(ILabelProvider labelProvider,EStructuralFeature feature) {
		super();
		this.feature = feature;
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench()
				.getDecoratorManager();
		decoratingLabelProvider = new DecoratingLabelProvider(labelProvider,
				decoratorManager.getLabelDecorator());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (!(element instanceof EObject)) {
			return "";
		}

		EObject eObject = (EObject) element;
		if (feature instanceof EReference) {
			return extractTextFromEReference(eObject);
		} else if (feature instanceof EAttribute) {
			return extractTextFromEAttribute(eObject);
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	private String extractTextFromEReference(EObject item) {
		Object value = item.eGet(feature);
		if (value == null) {
			return "";
		}

		// TODO: Is it possible to filter projects by use of EStruturalFeature?
		// Meanwhile this clause does its work..
		if (item instanceof ProjectSpace) {
			ProjectSpace p = (ProjectSpace) item;
			return p.getProjectName();
		}
		
		if (feature.isMany()) {
			EList<EObject> eList = (EList<EObject>) value;
			
			return decoratingLabelProvider.getText(eList.get(0));
		} else {
			// TODO: label-provider can't return the text of ERefrence items??
			// This solution is not good. it needs to be fixed. but, at least it works.
			String text = "";
			if(value instanceof UnicaseModelElement) {
				UnicaseModelElement element = (UnicaseModelElement) value;
				text = element.getName();
				
				
			} 
		
			return text;
		}
	}

	private String extractTextFromEAttribute(EObject item) {
		Object value = item.eGet(feature);
		if (value != null) {
			return value.toString();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		Image image = null;
		if (this.getFeature().equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME)) {
			image = decoratingLabelProvider.getImage(element);
			decoratingLabelProvider.getLabelDecorator().decorateImage(image, element);
		}
		return image;
	}

	/**
	 * get the feature.
	 * 
	 * @return the feature.
	 */
	public EStructuralFeature getFeature() {
		return feature;
	}
}
