/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.tableview.viewer;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

/**
 * 
 * @author Hodaie
 * 
 *         This class displays a checkbox image for columns representing boolean
 *         attributes.
 * 
 */
public class TableViewBooleanLabelProvider extends OwnerDrawLabelProvider
		implements ILabelProvider {

	private IItemPropertyDescriptor propertyDescriptor;

	private static final String CHECKED_KEY = "CHECKED";
	private static final String UNCHECK_KEY = "UNCHECKED";

	/**
	 * .
	 * 
	 * @param viewer
	 *            The ColumnViwer, on which a checkbox for boolean attribute is
	 *            shown.
	 * @param propertyDescriptor
	 *            An IItemPropertyDescriptor to query the boolean value of
	 *            attribute.
	 */
	public TableViewBooleanLabelProvider(ColumnViewer viewer,
			IItemPropertyDescriptor propertyDescriptor) {

		this.propertyDescriptor = propertyDescriptor;

		// create images of a checked and an unchecked checkbox
		if (JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY) == null) {
			JFaceResources.getImageRegistry().put(UNCHECK_KEY,
					makeShot(viewer.getControl().getShell(), false));
			JFaceResources.getImageRegistry().put(CHECKED_KEY,
					makeShot(viewer.getControl().getShell(), true));

		}

	}

	/**
	 * We need images of a checked and unchecked checkbox. These are created
	 * using this method, so that they look native on different platforms. The
	 * trick here is, to create a temporary checkbox, and make an image of it.
	 * 
	 * @param Shell
	 *            shell
	 * @param Boolean
	 *            type
	 * @return Image image
	 */
	private Image makeShot(Shell shell, boolean type) {
		Shell s = new Shell(shell, SWT.NO_TRIM);
		Button b = new Button(s, SWT.CHECK);
		b.setSelection(type);
		Point bsize = b.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		b.setSize(bsize);
		b.setLocation(0, 0);
		s.setSize(bsize);
		s.open();
		GC gc = new GC(b);
		Image image = new Image(shell.getDisplay(), bsize.x, bsize.y);
		gc.copyArea(image, 0, 0);
		gc.dispose();
		s.close();
		return image;
	}

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Image getImage(Object element) {
		if (isChecked(element)) {
			return JFaceResources.getImageRegistry().getDescriptor(CHECKED_KEY)
					.createImage();
		} else {
			return JFaceResources.getImageRegistry().getDescriptor(UNCHECK_KEY)
					.createImage();
		}
	}

	/**
	 * ({@inheritDoc})
	 * 
	 * Boolean attributes are shown using a checkbox image. Therefore getText()
	 * returns null.
	 */
	public String getText(Object element) {
		return "";
	}

	/**
	 * ({@inheritDoc})
	 * 
	 * This returns the value of boolean attribute.
	 * 
	 * @param element
	 * @return
	 */
	protected boolean isChecked(Object element) {
		Boolean result;
		if (propertyDescriptor.isPropertySet(element)) {
			ItemPropertyDescriptor.PropertyValueWrapper valueWrapper = (ItemPropertyDescriptor.PropertyValueWrapper) propertyDescriptor
					.getPropertyValue(element);
			result = (Boolean) valueWrapper.getEditableValue(element);
		} else {
			result = new Boolean(false);
		}

		return result;
	}

	/**
	 * ({@inheritDoc})
	 * 
	 * This changes table row height. The default height is too narrow to show
	 * the checkebox gracefully.
	 */
	@Override
	protected void measure(Event event, Object element) {

		TableItem item = (TableItem) event.item;
		int rowHeight = TableView.ROW_HEIGHT;

		event.setBounds(new Rectangle(event.x, event.y, item.getBounds().width,
				rowHeight));

	}

	/**
	 * . ({@inheritDoc})
	 * 
	 * I had to draw the checkbox image in center of table cell myself. This is
	 * because the checkbox was drawn left aligned. And changing the
	 * tableColumn.setAlignment(SWT.CENTER) did not have any effects.
	 * 
	 */
	@Override
	protected void paint(Event event, Object element) {
		Image img = getImage(element);

		if (img != null) {
			Rectangle bounds = ((TableItem) event.item).getBounds(event.index);
			Rectangle imgBounds = img.getBounds();
			bounds.width /= 2;
			bounds.width -= imgBounds.width / 2;
			bounds.height /= 2;
			bounds.height -= imgBounds.height / 2;

			int x = bounds.width > 0 ? bounds.x + bounds.width : bounds.x;
			int y = bounds.height > 0 ? bounds.y + bounds.height : bounds.y;

			event.gc.drawImage(img, x, y);
		}

	}

}
