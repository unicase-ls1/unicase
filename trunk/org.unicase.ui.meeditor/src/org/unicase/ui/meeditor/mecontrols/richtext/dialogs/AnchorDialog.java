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
package org.unicase.ui.meeditor.mecontrols.richtext.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class AnchorDialog extends TitleAreaDialog {

    private String name = null;
    private Text anchorText;

    /**
     * @param parentShell
     * @param name
     */
    public AnchorDialog(Shell parentShell, String name) {
        super(parentShell);
        this.name = name != null ? name : ""; //$NON-NLS-1$
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Insert/Edit Anchor");
        
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        setTitle("Insert/Edit Anchor");
        setMessage("Specify the name of your anchor.");
        Composite comp = new Composite((Composite) super.createDialogArea(parent), SWT.NONE);
        comp.setLayout(new GridLayout(2,false));
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        comp.setLayoutData(gd);
        
        Label srcLabel = new Label(comp, SWT.NONE);
        srcLabel.setText("Name");
        gd = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
        gd.widthHint = 100;
        srcLabel.setLayoutData(gd);
        
        this.anchorText = new Text(comp, SWT.BORDER);
        this.anchorText.setText(this.name);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.anchorText.setLayoutData(gd);
        
        return comp;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    @Override
    protected void okPressed() {
        this.name = this.anchorText.getText();
        super.okPressed();
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    
}
