/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * @author 32kda
 * Needed for showing hyperlink insertion dialog
 */
public class HyperlinkDialog extends Dialog
{
	protected String nameLabelString = Messages.HyperlinkDialog_Label;
	protected String urlLabelString = Messages.HyperlinkDialog_URL;
	protected String dialogTitle = Messages.HyperlinkDialog_TITLE;
	
	protected String name, url;
	
	protected Label nameLabel, urlLabel;
	protected Text nameText, urlText;
	
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#create()
	 */
	public void create()
	{
		super.create();
		validate();
	}
	
	/**
	 * Basic constructor
	 * @param parent parent window
	 */
	public HyperlinkDialog(Shell parent) 
	{
	    super(parent);		    
	}
	
	
	protected Control createDialogArea(Composite parent)
	{
		getShell().setText(dialogTitle);
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(4, false);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
	    nameLabel = new Label(composite, SWT.NULL);
	    nameLabel.setText(nameLabelString);

	    nameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
	    gridData.horizontalSpan = 3;
	    nameText.setLayoutData(gridData);
	    ModifyListener listener = new ModifyListener(){

			
			public void modifyText(ModifyEvent e) {
				validate();
			}
	    	
	    };
		nameText.addModifyListener(listener);
	    urlLabel = new Label(composite, SWT.NULL);
	    urlLabel.setText(urlLabelString);

	    urlText = new Text(composite, SWT.SINGLE | SWT.BORDER);
	    urlText.setLayoutData(gridData);
	    urlText.addModifyListener(listener);
		applyDialogFont(composite);
		return composite;
	}
	
	protected void validate() {
		String name = nameText.getText().trim();
		String label= urlText.getText().trim();
		if (name.length()==0||label.length()==0){
			getButton(Dialog.OK).setEnabled(false);
			return;
		}
		getButton(Dialog.OK).setEnabled(true);
	}

	
	/**
	 * @return name label string
	 */
	public String getNameLabelString()
	{
		return nameLabelString;
	}

	
	/**
	 * @param nameLabelString name label string to set
	 */
	public void setNameLabelString(String nameLabelString)
	{
		this.nameLabelString = nameLabelString;
	}

	
	/**
	 * @return url label string
	 */
	public String getUrlLabelString()
	{
		return urlLabelString;
	}

	/**
	 * @param urlLabelString url label string to set
	 */
	public void setUrlLabelString(String urlLabelString)
	{
		this.urlLabelString = urlLabelString;
	}

	
	/**
	 * @return name of link
	 */
	public String getName()
	{		
		return name;
	}

	
	/**
	 * @param name initial name for link to set
	 */
	public void setName(String name)
	{
		nameText.setText(name);
		this.name = name;
	}

	
	/**
	 * @return url of the link
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @param url initial url for link to set
	 */
	public void setUrl(String url)
	{
		urlText.setText(url);
		this.url = url;
	}
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	public boolean close()
	{
		name = nameText.getText();
		url = urlText.getText();
		return super.close();
	}

}
 