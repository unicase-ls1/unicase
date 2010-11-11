package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * Integer implementation of a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 */
public class IntegerMultiAttributeControl extends MultiAttributeControl {

	// CONSTANTS
	protected static int EMPTY_VALUE = new Integer(0);
	//private static int SIZE_LIMIT = 10000000;
	
	// essential references
	private MultiAttributeController<Integer> dataManipulator;

	@Override
	protected void createDataStructures(EStructuralFeature feature) {
		EDataTypeEList<Integer> storedValues = (EDataTypeEList<Integer>) getModelElement().eGet(feature);
		dataManipulator = new MultiAttributeController<Integer>(this, storedValues);
	}

	@Override
	protected void createSingleField(Object contentObj) {
		assert(contentObj instanceof Integer);
		int content = (Integer) contentObj;
		IntegerAttributeControl f = new IntegerAttributeControl(this, dataManipulator, content);
		//f.fieldComposite = createCompositeLayout();	
		//f.value = content;
		//f.widget = new Spinner (f.fieldComposite, style | SWT.SINGLE);
		//f.widget.setValues(content, -SIZE_LIMIT, SIZE_LIMIT, 0, 1, 1);
		//f.widget.addModifyListener(f);
		//f.deleteButton = new ImageHyperlink(f.fieldComposite, SWT.TOP);
		//f.deleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		//f.deleteButton.addMouseListener(f);
		if (!isEditable) {
			f.widget.setEnabled(false);
		}
		//GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(f.widget);
	}

	@Override
	protected void createSingleField() {
		IntegerAttributeControl f = new IntegerAttributeControl(this, dataManipulator);
		//f.fieldComposite = createCompositeLayout();	
		//f.value = EMPTY_VALUE;
		//f.widget = new Spinner (f.fieldComposite, style | SWT.SINGLE);
		//f.widget.setValues(EMPTY_VALUE, -SIZE_LIMIT, SIZE_LIMIT, 0, 1, 1);
		//f.widget.addModifyListener(f);
		//f.deleteButton = new ImageHyperlink(f.fieldComposite, SWT.TOP);
		//f.deleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		//f.deleteButton.addMouseListener(f);
		//f.deleteButton.setVisible(false);
		if (!isEditable) {
			f.widget.setEnabled(false);
		}
		//GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(f.widget);
	}

	@Override
	public Object[] getAllStoredElements() {
		return dataManipulator.getAllStoredElements();
	}

}
