package org.unicase.uiModeling.diagram;

import org.eclipse.draw2d.geometry.Dimension;
import org.unicase.uiModeling.Button;
import org.unicase.uiModeling.Image;
import org.unicase.uiModeling.Label;
import org.unicase.uiModeling.Text;
import org.unicase.uiModeling.TextField;
import org.unicase.uiModeling.Window;

/**
 * This class provides access to certain constants required for UI Modeling diagrams.
 * 
 * @author mharut
 */
public final class UiModelingConstants {

	/**
	 * Private constructor. Every constant should be accessed statically.
	 */
	private UiModelingConstants() {
		// nothing to do
	}

	/**
	 * Default size for general elements in UI Modeling diagrams whose size can't be determined properly.
	 */
	public static final Dimension DEFAULT_SIZE = new Dimension(40, 40);
	/**
	 * Default size for {@link Button} elements in UI Modeling diagrams.
	 */
	public static final Dimension BUTTON_SIZE = new Dimension(60, 35);
	/**
	 * Default size for {@link Image} elements in UI Modeling diagrams.
	 */
	public static final Dimension IMAGE_SIZE = new Dimension(150, 125);
	/**
	 * Default size for {@link Label} elements in UI Modeling diagrams.
	 */
	public static final Dimension LABEL_SIZE = new Dimension(60, 20);
	/**
	 * Default size for {@link Text} elements in UI Modeling diagrams.
	 */
	public static final Dimension TEXT_SIZE = new Dimension(60, 20);
	/**
	 * Default size for {@link TextField} elements in UI Modeling diagrams.
	 */
	public static final Dimension TEXT_FIELD_SIZE = new Dimension(60, 20);
	/**
	 * Default size for {@link Window} elements in UI Modeling diagrams.
	 */
	public static final Dimension WINDOW_SIZE = new Dimension(400, 200);

}
