package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * String implementation of a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 */
public class StringMultiAttributeControl extends MultiAttributeControl {

	// CONSTANTS
	protected static String EMPTY_VALUE = new String("");
	
	//essential references
	private MultiAttributeController<String> dataManipulator;
	protected Control emptyField; // or the bottom one if isFull() && isEditable()
	private PersonalListener personalListener = new PersonalListener(); // see inner class
	
	@Override
	protected void createDataStructures(EStructuralFeature feature) {
		EDataTypeEList<String> storedValues = (EDataTypeEList<String>) getModelElement().eGet(feature);
		dataManipulator = new MultiAttributeController<String>(this, storedValues);
	}

	@Override
	protected void createSingleField(Object contentObj) { // still duplicated code, but better solution?!
		assert(contentObj instanceof String);
		String content = (String) contentObj;
		StringAttributeControl f = new StringAttributeControl(this, dataManipulator, content);
		//f.fieldComposite = createCompositeLayout();	
		//f.value = content;
		//f.widget = getToolkit().createText(f.fieldComposite, content, style | SWT.SINGLE);
		//f.widget.addModifyListener(f);
		f.widget.addKeyListener(personalListener);
		//f.button = new ImageHyperlink(f.fieldComposite, SWT.TOP);
		//f.button.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		//f.button.addMouseListener(f);
		if (!isEditable) {
			f.widget.setEditable(false);
		}
		//GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(f.widget);
	}
	

	@Override
	protected void createSingleField() { // still duplicated code, but better solution?!
		StringAttributeControl f = new StringAttributeControl(this, dataManipulator);
		//f.fieldComposite = createCompositeLayout();	
		//f.value = EMPTY_VALUE;
		//f.widget = getToolkit().createText(f.fieldComposite, EMPTY_VALUE, style | SWT.SINGLE);
		//f.widget.addModifyListener(f);
		f.widget.addKeyListener(personalListener);
		//f.button = new ImageHyperlink(f.fieldComposite, SWT.TOP);
		//f.button.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		//f.button.addMouseListener(f);
		//f.button.setVisible(false);
		if (!isEditable) {
			f.widget.setEditable(false);
		}
		emptyField = f.widget;
		//GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(f.widget);
	}
	
	/**
	 * Implements specific listeners for this type's widget in general,
	 * no single field specific listener!
	 */
	private class PersonalListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == 13) { //ENTER
				emptyField.setFocus();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// nothing
		}
	}

	@Override
	public Object[] getAllStoredElements() {
		return dataManipulator.getAllStoredElements();
	}

}
