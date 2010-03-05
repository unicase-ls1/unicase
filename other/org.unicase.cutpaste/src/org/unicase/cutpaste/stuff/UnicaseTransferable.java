package org.unicase.cutpaste.stuff;

import java.awt.datatransfer.*;
import java.awt.image.BufferedImage;
import java.io.*;
import org.unicase.metamodel.ModelElement;

public class UnicaseTransferable implements Transferable {
	
	private ModelElement me;
	private DataFlavor[] dfs;
	
public UnicaseTransferable(ModelElement me) {
		this.me = me;
		try{dfs = new DataFlavor[] {new DataFlavor(org.unicase.metamodel.ModelElement.class, "UnicaseModelElement"), DataFlavor.stringFlavor, DataFlavor.imageFlavor
			};
		}
		catch (Exception e){
			e.printStackTrace();
		};
}

public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException
{
	if (dataFlavor.equals(dfs[0])) return me; 
	else if (dataFlavor.equals(dfs[1])) return me.toString(); 
	else if (dataFlavor.equals(dfs[2])) return toPicture(me); 
		
	return null;
}

public DataFlavor[] getTransferDataFlavors(){
		return dfs;
}

public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
	for (DataFlavor df : dfs){
		if (dataFlavor == df) return true;
	}	
	return false;
}

private BufferedImage toPicture(ModelElement me){
	// this could be an icon extractor method for me, or a diagram rendering method, etc.
	// for now it returns a 50x50 px black image for every me
	return new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
	}
}