package org.unicase.cutpaste.stuff;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.image.BufferedImage;
import java.io.*;
import org.unicase.metamodel.ModelElement;

public class UnicaseTransferable implements Transferable {
	
	private ModelElement me;
	private DataFlavor[] providedFlavors;
	
public UnicaseTransferable(ModelElement me) {
		this.me = me;
		try{providedFlavors = new DataFlavor[] {new DataFlavor(org.unicase.metamodel.ModelElement.class, "UnicaseModelElement"), DataFlavor.stringFlavor, DataFlavor.imageFlavor};
		}
		catch (Exception e){
			e.printStackTrace();
		};
}

public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException
{
	if (dataFlavor.equals(providedFlavors[0])) return me; 
	else if (dataFlavor.equals(providedFlavors[1])) return me.toString(); 
	else if (dataFlavor.equals(providedFlavors[2])) return toImage(me); 
		
	return null;
}

public DataFlavor[] getTransferDataFlavors(){
		return providedFlavors;
}

public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
	for (DataFlavor providedFlavor : providedFlavors){
		if (dataFlavor.equals(providedFlavor)) return true;
	}	
	return false;
}

private BufferedImage toImage(ModelElement me){
	// this could be an icon extractor method for me, or a diagram rendering method, etc.
	// for now it returns <see current code>
	final Dimension QVGA = new Dimension(320, 240);
	final Dimension WUXGA = new Dimension(1920,1280);
	Dimension thumbnail = QVGA;
	Dimension resolutionLimit = WUXGA;
	BufferedImage screenshot = null;
	BufferedImage resizedScreenshot = null;
	try
	{
	   Toolkit toolkit = Toolkit.getDefaultToolkit();
	   Robot robot = new Robot();
	   screenshot = robot.createScreenCapture(new Rectangle(butNotLargerThan(resolutionLimit, toolkit.getScreenSize())));
	   resizedScreenshot = new BufferedImage(thumbnail.width, thumbnail.height, BufferedImage.TYPE_INT_ARGB); 
	   Graphics2D g = resizedScreenshot.createGraphics();
	   g.drawImage(screenshot, 0, 0, thumbnail.width, thumbnail.height, null);
	   g.dispose();
	}
	catch(AWTException e){
		e.printStackTrace();
	}
	return resizedScreenshot;
}

private Dimension butNotLargerThan(Dimension required, Dimension given){
	if (given.width>required.width) given.setSize(required.width, given.height);
	if (given.height>required.height) given.setSize(given.width, required.height);
	return given;
}
}