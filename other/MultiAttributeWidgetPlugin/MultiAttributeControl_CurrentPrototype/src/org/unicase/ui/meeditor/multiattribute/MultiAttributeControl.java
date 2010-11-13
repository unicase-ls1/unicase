package org.unicase.ui.meeditor.multiattribute;

import java.awt.Color;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;


/**
 * Represents a multi-attribute-item for the editor of an EMFCP model element.
 * <p>
 * FEATURES:
 * <p>
 * * Changes are applied whenever a field is modified, then:
 * 		immediate storage of any change in the model data and
 * 		immediate redrawing of the widget (always n+1 fields for n entries so
 * 			a new one can be added easily)
 * <p>
 * * Limited to $upperBound$ entries if it is != -1.
 * <p>
 * * Non-changeable attributes are handled correctly.
 * <p>
 * * When a duplicate is entered, this is also handled in the GUI.
 * <p>
 * 
 * Note that some of the features have to be implemented in a concrete class.
 * See description of abstract methods for further information.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
public abstract class MultiAttributeControl extends AbstractMEControl {
	// CONSTANTS
	protected static int PRIORITY = 2;
	
	// state attributes
	protected int style;
	protected int upperBound;
	protected boolean isEditable;
	protected boolean allowDuplicates = false;
	
	//essential references
	protected Composite composite;
	protected GridLayout gridLayout;
	

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		
		if (feature instanceof ETypedElementImpl) {
			ETypedElementImpl attr = (ETypedElementImpl) feature;
			upperBound = attr.getUpperBound();
			if (upperBound == -1 || upperBound > 1) {
				return PRIORITY;
			}
			else {
				return DO_NOT_RENDER;
			}
		}
		return DO_NOT_RENDER;
	}
	

	@Override
	public Control createControl(final Composite parent, int style) {
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(getModelElement());
		createDataStructures(feature);
		
		// set state
		this.style = style;
		isEditable = getItemPropertyDescriptor().canSetProperty(getModelElement());
		//allowDuplicates = !isUnique?? how to implement it?
		
		// create composite structure
		composite = getToolkit().createComposite(parent, style | SWT.BORDER);
		configureGridLayout();
		composite.setLayout(gridLayout);
		
		// re-set upper bound... needed because canRender() was called in an other instance
		upperBound = feature.getUpperBound();
		
		initializeWidget();
		return composite;
	}
	
	/**
	 * Creates the lists for stored values and fields needed.
	 * 
	 * @param feature
	 * 			Reference to the feature of this model element.
	 */
	protected abstract void createDataStructures(EStructuralFeature feature);
		

	/**
	 * Configures the GridLayout.
	 */
	private void configureGridLayout() {
		gridLayout = new GridLayout(1, true);
		gridLayout.verticalSpacing = 0;
	}
	
	/**
	 * Creates, draws and fills all fields needed to display the attribute's data.
	 */
	protected void initializeWidget() {
		for (Object i : getAllStoredElements()) {
			createSingleField(i);
		}
		if (!isFull() && isEditable) {
			createSingleField();
		}
		// make sure it is drawn correctly
		refreshWidget();
	}
	

	/**
	 * Redraws the widget with correct layout.
	 */
	protected void refreshWidget() {
		composite.layout(); // fields are drawn, but overall size is not always accordingly changed
		// layout of whole editor adapts to new widget content - how??
		composite.getParent().layout();
		//composite.getParent().getParent().layout();
	}
	
	/**
	 * Checks if this widget is full.
	 * 
	 * @return
	 * 			Returns true if full, false otherwise.
	 */
	protected boolean isFull() {
		return ((getAllStoredElements().length >= upperBound) && upperBound!=-1);
	}

	/**
	 * Creates one new field within the widget.
	 * <p>
	 * Implement a widget that can display a single attribute of this type and make sure
	 * it features suitable Listeners (immediately store data and always call refreshWidget()
	 * after changes; also make sure there is always a new empty field if the upper bound isn't reached
	 * when the former empty field is filled with data; handle duplicates). Deny editing of field if
	 * the attribute is non-changeable.
	 * <p>
	 * Call this method without any parameter for an empty field!
	 * 
	 * @param content
	 * 			The data to be displayed in the new field; make sure it is the right type
	 * 			and cast it accordingly in your implementation.
	 */
	protected abstract void createSingleField(Object content);
	
	/**
	 * Creates one new empty field within the widget.
	 * 
	 * See description of createSingleField(Object content) for further information on implementation details.
	 */
	protected abstract void createSingleField();
	
	/**
	 * Returns all elements of this attribute as Object array. Needed for
	 * some superclass methods.
	 * 
	 * @return
	 * 			Returns the array.
	 */
	public abstract Object[] getAllStoredElements();
	
}
