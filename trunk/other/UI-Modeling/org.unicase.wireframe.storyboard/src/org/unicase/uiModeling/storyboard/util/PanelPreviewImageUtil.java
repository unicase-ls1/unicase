package org.unicase.uiModeling.storyboard.util;

import java.io.ByteArrayInputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.graphics.Image;

public final class PanelPreviewImageUtil {

	private static final CopyToImageUtil IMAGE_UTIL = new CopyToImageUtil();

	/**
	 * Private constructor: all methods should be accessed statically
	 */
	private PanelPreviewImageUtil() {
		// nothing to do
	}

	/**
	 * Creates a preview image for a GMF diagram and returns it as an SWT image.
	 * 
	 * @param diagram the {@link Diagram} to create the image for
	 * @param preferencesHint the {@link PreferencesHint} to use for image creation
	 * @return the SWT {@link Image} as a PNG file
	 * @see ImageFileFormat#PNG
	 */
	public static Image getImage(Diagram diagram, PreferencesHint preferencesHint) {
		try {
			byte[] bytes = IMAGE_UTIL.copyToImageByteArray(diagram, Integer.MAX_VALUE, Integer.MAX_VALUE,
				ImageFileFormat.PNG, new NullProgressMonitor(), preferencesHint, false);
			Image image = new Image(DisplayUtils.getDisplay(), new ByteArrayInputStream(bytes));
			return image;
		} catch (CoreException e) {
			ModelUtil.logException("Creating preview image for UI Modeling panel failed!", e);
			return null;
		}
	}

}
