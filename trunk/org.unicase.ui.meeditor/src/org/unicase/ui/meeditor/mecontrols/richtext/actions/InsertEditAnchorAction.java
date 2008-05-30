/*******************************************************************************
 * Copyright (c) 2006 Tom Seidel, Spirit Link GmbH
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *     Tom Seidel - initial API and implementation
 *******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.richtext.actions;

import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.unicase.ui.meeditor.mecontrols.richtext.dialogs.AnchorDialog;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.AllActionConstants;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.ComposerStatus;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.EventConstants;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.HtmlComposer;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.JavaScriptCommands;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.PropertyConstants;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class InsertEditAnchorAction extends Action implements Listener {

    private HtmlComposer composer = null;

    private String name = null;

    public InsertEditAnchorAction(HtmlComposer composer) {
        super("", IAction.AS_CHECK_BOX);
        setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("org.unicase.ui.meeditor", "tiny_mce/jscripts/tiny_mce/themes/advanced/images/anchor.gif"));
        this.composer = composer;
        this.composer.addListener(EventConstants.ANCHOR, this);
    }



    /* (non-Javadoc)
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
        AnchorDialog dialog = new AnchorDialog(this.composer.getShell(),this.name);
        if (dialog.open() == IDialogConstants.OK_ID) {
            this.composer.execute(JavaScriptCommands.INSERT_ANCHOR(dialog.getName()));
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
     */
    public void handleEvent(Event event) {
        Properties evtProps = (Properties) event.data;
        if (event.type != EventConstants.ALL) {
            setChecked(true);
            this.name = evtProps.getProperty(PropertyConstants.NAME);
        }
        else if (evtProps.getProperty(PropertyConstants.COMMAND).equals(AllActionConstants.RESET_ALL)) {
            setChecked(false);
            this.name = ""; //$NON-NLS-1$
        }
    }

}
