package org.unicase.cutpaste.stuff;

import java.awt.datatransfer.*;
import java.io.*;
import org.unicase.metamodel.ModelElement;

public class UnicaseTransferable implements Transferable {
	ModelElement me;
	
public UnicaseTransferable(ModelElement me) {
		this.me = me;
}

public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException
{
	if (dataFlavor == DataFlavor.stringFlavor) return dataFlavor.getMimeType(); 
	else if (dataFlavor == DataFlavor.javaFileListFlavor) return me; 
	return null;
}

public DataFlavor[] getTransferDataFlavors() {
	return new DataFlavor[0];
}

public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
	return false;

}
}