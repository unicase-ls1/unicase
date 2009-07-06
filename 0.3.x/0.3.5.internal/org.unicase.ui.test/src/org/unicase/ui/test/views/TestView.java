/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.test.TestProjectGenerator;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author Hodaie This the view for model tests. The view contains a list of all available model test on the left. On
 *         the right pane the user can set the parameters of selected test. Currently there is only one test available.
 */
public class TestView extends ViewPart {

	private Label lblNumOfEachME;
	private Label lblRandomSeed;
	private Label lblProjectWidth;
	private Label lblProjectDepth;
	private Label lblMaxNumOfManyRefs;
	private Label lblMaxNumOfMEsInLeafSection;
	private Label lblNumOfMEsToOpen;

	private Text txtNumOfEachME;
	private Text txtRandomSeed;
	private Text txtProjectWidth;
	private Text txtProjectDepth;
	private Text txtMaxNumOfManyRefs;
	private Text txtMaxNumOfMEsInLeafSection;
	private Text txtNumOfMEsToOpen;

	private SashForm sash;
	private Group testsGroup, testParamsGroup;
	private Table testsTable;

	/**
	 * . constructor
	 */
	public TestView() {

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		sash = new SashForm(parent, SWT.HORIZONTAL);

		createTestsGroup();
		createTestParamsGroup();

		sash.setWeights(setSashWidgets());

		// fill list of tests
		setTests();

	}

	private void setTests() {
		TableItem item1 = new TableItem(testsTable, SWT.NONE);
		item1.setText("Test project generator");

	}

	private void createTestsGroup() {
		testsGroup = new Group(sash, SWT.NONE);
		testsGroup.setText("tests");
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		testsGroup.setLayout(gridLayout);

		testsTable = new Table(testsGroup, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 2;
		testsTable.setLayoutData(gridData);
		testsTable.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
			}
		});

		Button btnRun = new Button(testsGroup, SWT.PUSH);
		btnRun.setText("Run");
		btnRun.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				runTest();

			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}

		});

	}

	private void runTest() {

		int numOfEachME = Integer.parseInt(txtNumOfEachME.getText());
		int randomSeed = Integer.parseInt(txtRandomSeed.getText());
		int projectWidth = Integer.parseInt(txtProjectWidth.getText());
		int projectDepth = Integer.parseInt(txtProjectDepth.getText());
		int maxNumOfManyRefs = Integer.parseInt(txtMaxNumOfManyRefs.getText());
		int maxNumOfMEsInLeafSection = Integer.parseInt(txtMaxNumOfMEsInLeafSection.getText());
		int numOfMEsToOpen = Integer.parseInt(txtNumOfMEsToOpen.getText());

		TestProjectGenerator testProjectGenerator = new TestProjectGenerator(numOfEachME, randomSeed, projectWidth,
			projectDepth, maxNumOfManyRefs, maxNumOfMEsInLeafSection);
		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		testProjectGenerator.generateProjectIntoWorkspace(currentWorkspace);

		if (numOfMEsToOpen > 0) {
			testProjectGenerator.openSomeModelElements(numOfMEsToOpen);
		}

		MessageDialog.openInformation(this.getSite().getShell(), "Project Generation completed", "Generated "
			+ testProjectGenerator.getMECount() + " model elements.");
	}

	private void createTestParamsGroup() {

		testParamsGroup = new Group(sash, SWT.None);
		testParamsGroup.setText("test parameters");
		testParamsGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		testParamsGroup.setLayout(new GridLayout(3, true));

		lblNumOfEachME = new Label(testParamsGroup, SWT.None);
		lblNumOfEachME.setText("Number of each ME:");
		txtNumOfEachME = new Text(testParamsGroup, SWT.BORDER);
		txtNumOfEachME.setText("5");
		GridData gridData1 = new GridData(GridData.FILL_HORIZONTAL);
		gridData1.horizontalSpan = 2;
		txtNumOfEachME.setLayoutData(gridData1);

		lblRandomSeed = new Label(testParamsGroup, SWT.None);
		lblRandomSeed.setText("Random seed:");
		txtRandomSeed = new Text(testParamsGroup, SWT.BORDER);
		txtRandomSeed.setText("1334566732");
		GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
		gridData2.horizontalSpan = 2;
		txtRandomSeed.setLayoutData(gridData2);

		lblProjectWidth = new Label(testParamsGroup, SWT.None);
		lblProjectWidth.setText("Project width:");
		txtProjectWidth = new Text(testParamsGroup, SWT.BORDER);
		txtProjectWidth.setText("2");
		GridData gridData3 = new GridData(GridData.FILL_HORIZONTAL);
		gridData3.horizontalSpan = 2;
		txtProjectWidth.setLayoutData(gridData3);

		lblProjectDepth = new Label(testParamsGroup, SWT.None);
		lblProjectDepth.setText("Project depth:");
		txtProjectDepth = new Text(testParamsGroup, SWT.BORDER);
		txtProjectDepth.setText("2");
		GridData gridData4 = new GridData(GridData.FILL_HORIZONTAL);
		gridData4.horizontalSpan = 2;
		txtProjectDepth.setLayoutData(gridData4);

		lblMaxNumOfManyRefs = new Label(testParamsGroup, SWT.None);
		lblMaxNumOfManyRefs.setText("Max no. of many references:");
		txtMaxNumOfManyRefs = new Text(testParamsGroup, SWT.BORDER);
		txtMaxNumOfManyRefs.setText("5");
		GridData gridData5 = new GridData(GridData.FILL_HORIZONTAL);
		gridData5.horizontalSpan = 2;
		txtMaxNumOfManyRefs.setLayoutData(gridData5);

		lblMaxNumOfMEsInLeafSection = new Label(testParamsGroup, SWT.None);
		lblMaxNumOfMEsInLeafSection.setText("Max no. of MEs in LeafSection:");
		txtMaxNumOfMEsInLeafSection = new Text(testParamsGroup, SWT.BORDER);
		txtMaxNumOfMEsInLeafSection.setText("10");
		GridData gridData6 = new GridData(GridData.FILL_HORIZONTAL);
		gridData6.horizontalSpan = 2;
		txtMaxNumOfMEsInLeafSection.setLayoutData(gridData6);

		lblNumOfMEsToOpen = new Label(testParamsGroup, SWT.None);
		lblNumOfMEsToOpen.setText("No. of MEs to open:");
		txtNumOfMEsToOpen = new Text(testParamsGroup, SWT.BORDER);
		txtNumOfMEsToOpen.setText("0");
		GridData gridData7 = new GridData(GridData.FILL_HORIZONTAL);
		gridData7.horizontalSpan = 2;
		txtNumOfMEsToOpen.setLayoutData(gridData7);

		testParamsGroup.pack();

	}

	private int[] setSashWidgets() {
		return new int[] { 50, 50 };
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		testsTable.select(0);

	}

}
