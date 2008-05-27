package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.MEEditorInput;

public class MEHyperLinkAdapter extends HyperlinkAdapter implements
		IHyperlinkListener {

	ModelElement me;
	
	public MEHyperLinkAdapter(ModelElement me) {
		super();
		this.me = me;
	}

	@Override
	public void linkActivated(HyperlinkEvent event) {
		MEEditorInput input = new MEEditorInput(me);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, "org.unicase.ui.meeditor",true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.linkActivated(event);
	}

}
