/*******************************************************************************
 * Copyright (c) 2007 Tom Seidel, Spirit Link GmbH
 * All rights reserved.
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

import org.unicase.ui.meeditor.mecontrols.richtext.dialogs.ImageDialog;
import org.unicase.ui.meeditor.mecontrols.richtext.dialogs.TableDialog;
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
public class InsertEditTableAction extends Action implements Listener {

    private HtmlComposer composer = null;
    private String cellpadding = null;
    private String cellspacing = null;
    private String align = null;
    private String clazz = null;
    private String style = null;
    private String id =  null;
    
    public InsertEditTableAction(HtmlComposer composer) {
        super("", IAction.AS_CHECK_BOX);
        setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("org.unicase.ui.meeditor", "tiny_mce/jscripts/tiny_mce/plugins/table/images/table.gif"));
        this.composer = composer;
        this.composer.addListener(EventConstants.TABLE, this);
    }



    /* (non-Javadoc)
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
        TableDialog dialog = new TableDialog(
                this.composer.getShell(),
                this.cellpadding,
                this.cellspacing,
                this.clazz,
                this.style,
                this.id,
                this.align);
        if (dialog.open() == IDialogConstants.OK_ID) {
            this.composer.execute(JavaScriptCommands.INSERT_EDIT_TABLE(
                    dialog.getCellpadding(),
                    dialog.getCellspacing(),
                    dialog.getAlign(),
                    dialog.getClazz(),
                    dialog.getStyle(), 
                    dialog.getId()));
        
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
     */
    public void handleEvent(Event event) {
        Properties evtProps = (Properties) event.data;
        if (event.type != EventConstants.ALL && ComposerStatus.SELECTED.equals(evtProps.getProperty(PropertyConstants.STATUS))) {
            setChecked(true);
            this.cellpadding = evtProps.getProperty("cellpadding"); //$NON-NLS-1$
            this.cellspacing = evtProps.getProperty("cellspacing"); //$NON-NLS-1$
            this.align = evtProps.getProperty("align"); //$NON-NLS-1$
            this.clazz = evtProps.getProperty("class"); //$NON-NLS-1$
            this.id = evtProps.getProperty("id"); //$NON-NLS-1$
            this.style = evtProps.getProperty("style"); //$NON-NLS-1$
        } else {
            setChecked(false);
            this.cellpadding = null;
            this.cellspacing = null;
            this.align = null;
            this.clazz = null;
            this.id = null;
            this.style = null;
        }
    }

}
