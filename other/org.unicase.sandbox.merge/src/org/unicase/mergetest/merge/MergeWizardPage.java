/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.conflicts.AttributeConflict;
import org.unicase.mergetest.merge.conflict.conflicts.SingleReferenceConflict;
import org.unicase.mergetest.merge.ui.DecisionBox;
import org.unicase.metamodel.Project;

/**
 * Represents the main page of the merge wizard.
 * 
 * @author wesendon
 */
public class MergeWizardPage extends WizardPage {

	
	
	public  static final String PAGE_NAME = "Resolve Conflicts";
	
	private ArrayList<DecisionBox> decisionBoxes;
	private DecisionManager decisionManager;

	/**
	 * Default constructor.
	 * 
	 * @param pageName
	 *            page name
	 * @param myChangePackage
	 * @param theirChangePackages
	 * @param project
	 */
	protected MergeWizardPage(DecisionManager decisionManager) {
		super(PAGE_NAME);
		this.decisionManager = decisionManager;
		setTitle("First Merge Page");
		setDescription("This wizard will lead you through the process of merging.");
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(final Composite parent) {
		parent.setLayout(new FillLayout());

//		
//		createTopBar(container);
//		
		
		final ScrolledComposite scrolledComposite = new ScrolledComposite(parent,
				SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_BLUE));

		final Composite client = new Composite(scrolledComposite, SWT.NONE);
		client.setLayout(new GridLayout());
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		client.setLayoutData(gridData);

		ColorSwitcher colorSwitcher = new ColorSwitcher();

		decisionBoxes = new ArrayList<DecisionBox>();
		for (Conflict conflict : decisionManager.getConflicts()) {
			decisionBoxes.add(new DecisionBox(client, decisionManager,colorSwitcher.getColor(), conflict));
		}

		debugButton(client);

		scrolledComposite.setContent(client);
		
		Point computeSize = parent.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		computeSize.x = parent.getBounds().width;
		scrolledComposite.setMinSize(computeSize);

//		scrolledComposite.addControlListener(new ControlListener() {
//			public void controlResized(ControlEvent e) {
//				Point computeSize = scrolledComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
//				computeSize.x = parent.getBounds().width;
//				scrolledComposite.setMinSize(computeSize);
//			}
//			public void controlMoved(ControlEvent e) {
//				
//			}
//		});

		setControl(parent);
	}

	private void createTopBar(Composite parent) {
		Composite row = new Composite(parent, SWT.NONE);
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		row.setLayout(new RowLayout(SWT.HORIZONTAL));
		Label label = new Label(row, SWT.None);
		label.setText("Hier kommt viel hin");
		
	}

	//
	// DEBUG
	//

	private void debugButton(final Composite composite) {
		Composite debugBox = new Composite(composite, SWT.BORDER_SOLID);
		debugBox.setLayout(new GridLayout());
		Label label = new Label(debugBox, SWT.NONE);
		label.setText("Open Debug");
		Button button = new Button(debugBox, SWT.NONE);
		button.setText("Open");
		button.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				new DebugView(composite.getShell()).open();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				new DebugView(composite.getShell()).open();
			}
		});
	}

	private final class ColorSwitcher {
		private boolean color = false;

		public Color getColor() {
			color = !color;
			return (color) ? Display.getCurrent().getSystemColor(
					SWT.COLOR_WHITE) : new Color(Display.getCurrent(), 240,
					250, 254);
		}
	}

	private final class DebugView extends TitleAreaDialog {

		public DebugView(Shell shell) {
			super(shell);
			setShellStyle(this.getShellStyle() | SWT.RESIZE);

		}

		@Override
		protected Control createDialogArea(Composite parent) {
			super.setTitle("adsgfpaidfhg adogh aüodhf gahfd g");
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, true));
			composite
					.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			ListViewer listViewer = new ListViewer(composite, SWT.SINGLE
					| SWT.V_SCROLL | SWT.H_SCROLL);
			listViewer.getList().setLayoutData(
					new GridData(SWT.FILL, SWT.FILL, true, true));
			listViewer.setContentProvider(new DebugContentProvider());
			listViewer.setLabelProvider(new DebugLabelProvider(true));
			listViewer.setInput(new Object());

			ListViewer listViewer2 = new ListViewer(composite, SWT.SINGLE
					| SWT.V_SCROLL | SWT.H_SCROLL);
			listViewer2.getList().setLayoutData(
					new GridData(SWT.FILL, SWT.FILL, true, true));
			listViewer2.setContentProvider(new DebugContentProvider());

			listViewer2.setLabelProvider(new DebugLabelProvider(false));
			listViewer2.setInput(new Object());

			return parent;
		}

		private final class DebugLabelProvider extends LabelProvider {
			private final boolean myOp;

			public DebugLabelProvider(boolean b) {
				super();
				this.myOp = b;
			}

			@Override
			public String getText(Object element) {
				String res = "";
				if (element instanceof Conflict) {
					if (myOp) {
						// res = ((Conflict)
						// element).getTheirOperation().toString();
					} else {
						// res = ((Conflict)
						// element).getMyOperation().toString();
					}
				}
				return res;
			}
		}

		private final class DebugContentProvider implements
				IStructuredContentProvider {
			public Object[] getElements(Object inputElement) {
				return decisionManager.getConflicts().toArray();
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		}
	}
}
