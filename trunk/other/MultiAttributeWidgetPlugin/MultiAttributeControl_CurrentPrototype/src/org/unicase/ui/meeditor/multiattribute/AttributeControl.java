package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * Represents a general single field for a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 */
abstract class AttributeControl implements ModifyListener, MouseListener {
	protected MultiAttributeControl parentItem;
	protected Composite fieldComposite;
	protected ImageHyperlink button;
	protected boolean emptyField = true;
	
	protected void createDeleteButton() {
		button = new ImageHyperlink(fieldComposite, SWT.TOP);
		button.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		button.addMouseListener(this);
		fieldComposite.layout();
	}
	
	protected void createAddButton() {
		button = new ImageHyperlink(fieldComposite, SWT.TOP);
		button.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));
		button.addMouseListener(this);
	}
	

	/**
	 * Creates the layout for one single field.
	 * 
	 * @return
	 * 			Returns the composite.
	 */
	protected void createCompositeLayout() {
		fieldComposite = parentItem.getToolkit().createComposite(parentItem.composite, parentItem.style);
		GridLayout fieldLayout = new GridLayout(2, false);
		fieldLayout.verticalSpacing = 0;
		fieldComposite.setLayout(fieldLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(fieldComposite);
	}
	
	@Override
	public abstract void modifyText(ModifyEvent e); // still duplicated code, but better solution?!

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// nothing
	}

	@Override
	public void mouseDown(MouseEvent e) {
		// nothing
	}

	@Override
	public abstract void mouseUp(MouseEvent e); // still duplicated code, but better solution?!
}
