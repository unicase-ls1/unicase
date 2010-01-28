package org.unicase.cutpaste.handlers;

import java.awt.datatransfer.*;
import java.io.*;

import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.metamodel.ModelElement;

public class ClipObjectTransferable implements Transferable {
	ModelElement me;
	

ClipObjectTransferable(ModelElement me) {
		this.me = me;
}

public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException
{
	if (dataFlavor.toString().equals("class=ClipObjectTransferable")) {
		return me;
	}
	else
		throw new UnsupportedFlavorException(dataFlavor);
}

public DataFlavor[] getTransferDataFlavors() {
	DataFlavor[] df = new DataFlavor[1];
	try {
		df[0] = new DataFlavor("class=ClipObjectTransferable");
		}
	catch (Exception e) {
		MessageDialog.openInformation(
			null,
			"w@iglt info_box",
			e.toString());
	}
	return df;
}

public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
	if (dataFlavor.toString().equals("class=ClipObjectTransferable"))
		return true;
	else
		return false;
	}
}