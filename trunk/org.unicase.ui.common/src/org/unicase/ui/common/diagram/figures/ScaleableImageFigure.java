package org.unicase.ui.common.diagram.figures;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class ScaleableImageFigure extends ImageFigure {	
	static Image img;
	
	public ScaleableImageFigure(String bundle, String path) {
 	  super(img=ImageDescriptor.createFromURL(FileLocator.find(Platform
				.getBundle(bundle), new Path(path), null)).createImage(),0);
 	  this.setAlignment(PositionConstants.NORTH_WEST);
    }
	@Override
	public Image getImage()
	{
		Image scaled = new Image(img.getDevice(),
		        img.getImageData().scaledTo(this.getBounds().width,this.getBounds().height));
		return scaled;
	} 
}