package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Interface for all ME controls.
 * 
 * @author helming
 * 
 */
public interface MEControl {

	/**
	 * Creates and renders the control in the parent composite.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            the style for rendering
	 * @return the control
	 */
	public Control createControl(Composite parent, int style);

}
