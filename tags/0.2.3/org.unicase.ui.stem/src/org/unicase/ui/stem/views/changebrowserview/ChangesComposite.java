/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.changebrowserview;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.ui.stem.views.ChangesTreeComposite;

/**.
 * This class provides contents of ChangeBrowserView's browser tab.
 * It just contains an instance of ChangeTreeComposite
 * 
 * @author Hodaie
 *
 */
public class ChangesComposite extends Composite {

	private ChangePackage input;
	private ChangesTreeComposite changesTree;

	/**.
	 * Constructor
	 * @param parent parent
	 * @param style  style
	 */
	public ChangesComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();
		
	}


	private void createTree() {
		changesTree = new ChangesTreeComposite(this, SWT.BORDER);
		changesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setInput(input);		
	}

	/**
	 * set input to changes tree shwon on composite.
	 * @param changePackage the new {@link ChangePackage}
	 */
	public void setInput(ChangePackage changePackage) {
		this.input = changePackage;
		ArrayList<ChangePackage> packages = new ArrayList<ChangePackage>();
		packages.add(input);
		changesTree.setInput(packages);	
	}

}
