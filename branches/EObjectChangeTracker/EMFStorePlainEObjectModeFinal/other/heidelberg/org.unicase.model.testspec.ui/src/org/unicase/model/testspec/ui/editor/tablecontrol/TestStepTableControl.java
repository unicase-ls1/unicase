package org.unicase.model.testspec.ui.editor.tablecontrol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.testspec.TestCase;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecPackage;
import org.unicase.model.testspec.ui.editor.commands.ChangeTestStepParameterCommand;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepTreeContentProvider;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepTreeLabelProvider;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * Control for the dynamic tree of test steps in the test protocol view.
 * 
 * @author Sharon Friedrich
 * 
 */
public class TestStepTableControl extends AbstractMEControl {
    /**
     * Priority of control.
     * 
     * Indicates with which priority this control shall be used.
     */
    private static final int PRIORITY = 2;

    /**
     * Constant text.
     */
    private static final String REFERENCE_TEST_STEP_NAME = "testSteps";
    /**
     * Button constant text.
     */
    private static final String EXPAND_BUTTON_TOOLTIP = "Expand all";
    private static final String COLLAPSE_BUTTON_TOOLTIP = "Collapse all";
    /**
     * Column constant titles.
     */
    private static final String COLUMN_TITLE_ID = "ID";
    private static final String COLUMN_TITLE_ELEMENT_TYPE = "Element Type";
    private static final String[] VISIBLE_COLUMN_TITLES = { "Name", "Type",
            "Range", "Value" };
    /**
     * Constant element types.
     */
    private static final String ELEMENT_TYPE_TESTSTEP = "TestStep";
    private static final String ELEMENT_TYPE_TESTSTEPINPUT = "TestStepInput";
    private static final String ELEMENT_TYPE_TESTSTEPOUTPUT = "TestStepOutput";
    /**
     * Constant table column index.
     */
    private static final int COLUMN_VALUE = 3;
    private static final int COLUMN_ID = 4;
    private static final int COLUMN_ELEMENT_TYPE = 5;
    /**
     * Column width.
     */
    private static final int[] COLUMN_WIDTH = { 260, 210, 210, 210 };
    /**
     * Button image.
     */
    public static final String PLUGIN_ID = "org.unicase.model.testspec.ui";
    public static final String COLLAPSE_PATH = "icons/collapse_all.gif";
    public static final String EXPAND_PATH = "icons/expand_all.gif";

    private IItemPropertyDescriptor descriptor;
    private TreeViewer testStepTableViewer;
    private ModelElementChangeListener modelElementChangeListener;
    private TreeEditor editor;
    private Composite treeComposite;
    private ScrolledComposite scrolledComposite;

    /**
     * Constructor.
     * 
     */
    public TestStepTableControl() {
        super();
    }

    /**
     * Creates the control.
     * 
     * @param parent
     *            - surrounding composite
     * @param style
     *            - style that should be used
     * @return control - tree control
     */
    public Control createControl(final Composite parent, final int style) {
        this.descriptor = getItemPropertyDescriptor();

        /* Create section */
        Section section = getToolkit().createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        /* Create toolbar with add and delete button */
        ToolBar toolbar = new ToolBar(section, SWT.FLAT | SWT.HORIZONTAL);
        /* Define hand cursor for toolbar */
        final Cursor handCursor = new Cursor(Display.getCurrent(),
                SWT.CURSOR_HAND);
        toolbar.setCursor(handCursor);
        /* Dispose cursor */
        toolbar.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                if (!handCursor.isDisposed()) {
                    handCursor.dispose();
                }
            }
        });
        /* Create buttons */
        createButtons(toolbar);

        section.setTextClient(toolbar);
        section.setText(descriptor.getDisplayName(getModelElement()));

        /*
         * Create composite which will be scrollable so that only a maximum of
         * 10 items in the tree can be shown and the remaining can be shown by
         * scrolling
         */
        scrolledComposite = new ScrolledComposite(section, SWT.V_SCROLL
                | SWT.H_SCROLL);
        /* Create composite which will contain the tree */
        treeComposite = getToolkit().createComposite(scrolledComposite);
        treeComposite.setLayout(new GridLayout());
        /* Create tree */
        createTableTree(treeComposite);
        /* Create an editor for the table cells */
        createEditor();

        /* Tree composite shall be shown in the scrollable composite */
        scrolledComposite.setContent(treeComposite);
        /*
         * Tree composite shall fill the whole vertical space of the scrollable
         * composite
         */
        scrolledComposite.setExpandVertical(true);
        /*
         * Tree composite shall fill the whole horizontal space of the
         * scrollable composite
         */
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setMinSize(treeComposite.computeSize(SWT.DEFAULT,
                SWT.DEFAULT));

        section.setClient(scrolledComposite);

        /* Create listener that observes changes in relevant elements */
        createChangeListener();

        return section;
    }

    /**
     * Create buttons in the toolbar for expanding & collapsing the tree in the
     * table.
     * 
     * @param toolbar
     *            - toolbar where the buttons shall be displayed
     */
    private void createButtons(ToolBar toolbar) {
        /* Expand All Button */
        ToolItem expandAllButton = new ToolItem(toolbar, SWT.PUSH);
        final Image expandAllImage = org.unicase.ui.common.Activator
                .imageDescriptorFromPlugin(PLUGIN_ID, EXPAND_PATH)
                .createImage();
        expandAllButton.setImage(expandAllImage);
        expandAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                for (int i = 0; i < testStepTableViewer.getTree()
                        .getItemCount(); i++) {
                    testStepTableViewer.getTree().getItem(i).setExpanded(true);
                }
                testStepTableViewer.refresh();
            }
        });
        /* Image has to be explicitly disposed */
        expandAllButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                expandAllImage.dispose();
            }
        });
        expandAllButton.setToolTipText(EXPAND_BUTTON_TOOLTIP);

        /* Collapse All Button */
        ToolItem collapseAllButton = new ToolItem(toolbar, SWT.PUSH);
        final Image collapseAllImage = org.unicase.ui.common.Activator
                .imageDescriptorFromPlugin(PLUGIN_ID, COLLAPSE_PATH)
                .createImage();
        collapseAllButton.setImage(collapseAllImage);
        collapseAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                for (int i = 0; i < testStepTableViewer.getTree()
                        .getItemCount(); i++) {
                    testStepTableViewer.getTree().getItem(i).setExpanded(false);
                }
                testStepTableViewer.refresh();
            }
        });
        /* Image has to be explicitly disposed */
        collapseAllButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                collapseAllImage.dispose();
            }
        });
        collapseAllButton.setToolTipText(COLLAPSE_BUTTON_TOOLTIP);
    }

    /**
     * Creates the dynamic tree of test steps with input and output parameter.
     * 
     * @param treeComposite
     *            - surrounding composite
     */
    private void createTableTree(Composite treeComposite) {
        testStepTableViewer = new TreeViewer(treeComposite, SWT.MULTI
                | SWT.FULL_SELECTION | SWT.WRAP);
        Tree testStepsTree = testStepTableViewer.getTree();
        /* Set maximum height of the table to 10 rows */
        GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
        data.heightHint = 10 * testStepsTree.getItemHeight() + 10;
        testStepsTree.setLayoutData(data);
        /* Column titles and lines shall be visible */
        testStepsTree.setHeaderVisible(true);
        testStepsTree.setLinesVisible(true);
        /* Create columns */
        createColumns();
        /* Set provider of the tree viewer */
        testStepTableViewer
                .setContentProvider(new TestStepTreeContentProvider());
        testStepTableViewer.setLabelProvider(new TestStepTreeLabelProvider(
                (TestProtocol) getModelElement()));
        /* Fill tree with content */
        TestCase tc = ((TestProtocol) getModelElement()).getTestCase();
        if (tc != null) {
            testStepTableViewer.setInput(tc.getStep());
        } else {
            testStepTableViewer.setInput(null);
        }
    }

    /**
     * Creates the columns in the dynamic tree.
     * 
     * 
     */
    private void createColumns() {
        /* Columns for name, type, range and value */
        for (int i = 0; i < VISIBLE_COLUMN_TITLES.length; i++) {
            TreeViewerColumn column = new TreeViewerColumn(testStepTableViewer,
                    SWT.LEFT);
            column.getColumn().setText(VISIBLE_COLUMN_TITLES[i]);
            column.getColumn().setMoveable(false);
            column.getColumn().setResizable(true);
            column.getColumn().setWidth(COLUMN_WIDTH[i]);
        }

        /* Hidden column for the ID of the test step and test step parameters */
        TreeViewerColumn hiddenColumn = new TreeViewerColumn(
                testStepTableViewer, SWT.LEFT);
        hiddenColumn.getColumn().setText(COLUMN_TITLE_ID);
        hiddenColumn.getColumn().setMoveable(false);
        hiddenColumn.getColumn().setResizable(false);
        hiddenColumn.getColumn().setWidth(0);

        /*
         * Hidden column for the type of element (TestStep, TestStepInput,
         * TestStepOutput) that is displayed.
         */
        TreeViewerColumn hiddenColumn2 = new TreeViewerColumn(
                testStepTableViewer, SWT.LEFT);
        hiddenColumn2.getColumn().setText(COLUMN_TITLE_ELEMENT_TYPE);
        hiddenColumn2.getColumn().setMoveable(false);
        hiddenColumn2.getColumn().setResizable(false);
        hiddenColumn2.getColumn().setWidth(0);
    }

    /**
     * Creates an editor that will be used for editing the value column.
     * 
     */
    private void createEditor() {
        TestCase tc = ((TestProtocol) getModelElement()).getTestCase();
        if (tc != null) {
            editor = new TreeEditor(testStepTableViewer.getTree());
            editor.horizontalAlignment = SWT.LEFT;
            editor.grabHorizontal = true;
            /*
             * Editor shall be "activated" when the user double-clicks on a cell
             * of the value column
             */
            testStepTableViewer.getTree().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseDown(MouseEvent event) {
                    if (event.count == 2) {
                        /* Only proceed if left mouse button was clicked */
                        if (event.button == 1) {
                            /* Dispose any existing editor */
                            Control oldEditor = editor.getEditor();
                            if (oldEditor != null) {
                                oldEditor.dispose();
                            }
                            /* Determine the point where the user double-clicked */
                            Point clickedPoint = new Point(event.x, event.y);
                            /* Determine the row */
                            final TreeItem treeItem = testStepTableViewer.getTree()
                                    .getItem(clickedPoint);
                            if (treeItem != null) {
                                /* Determine the column */
                                int tempColumn = -1;
                                for (int i = 0; i < testStepTableViewer.getTree()
                                        .getColumnCount(); i++) {
                                    Rectangle cell = treeItem.getBounds(i);
                                    if (cell.contains(clickedPoint)) {
                                        /* Column found */
                                        tempColumn = i;
                                        break;
                                    }
                                }
                                /*
                                 * Only the value column can be edited and only for
                                 * input or output parameters
                                 */
                                if (tempColumn == COLUMN_VALUE
                                        && (!treeItem.getText(COLUMN_ELEMENT_TYPE)
                                                .equals(ELEMENT_TYPE_TESTSTEP))) {
                                    /*
                                     * Save text in temp variable in case that editing
                                     * is cancelled
                                     */
                                    final String oldText = treeItem.getText(tempColumn);
                                    /*
                                     * Create Text object for editor that holds the cell
                                     * values
                                     */
                                    final Text text = new Text(testStepTableViewer
                                            .getTree(), SWT.NONE);
                                    /* Put text from cell into the Text control */
                                    text.setText(treeItem.getText(tempColumn));
                                    /* Select the text in the cell for editing */
                                    text.selectAll();
                                    /* Set focus to the Text control */
                                    text.setFocus();
                                    /* Determine minimum width of the editor */
                                    editor.minimumWidth = text.getBounds().width;
                                    /* Set Text control into the editor */
                                    editor.setEditor(text, treeItem, tempColumn);
        
                                    /*
                                     * Add modify listener that saves the changed values
                                     * to the corresponding model element.
                                     */
                                    /*
                                     * Column variable must be final because it is
                                     * otherwise not visible to the modifyText method
                                     */
                                    final int finalColumn = tempColumn;
                                    /* Stop editing when ENTER or ESC is pressed */
                                    text.addKeyListener(new KeyListener() {
                                        public void keyPressed(KeyEvent event) {
                                            switch (event.keyCode) {
                                            /* Cancel editing without saving */
                                            case SWT.ESC:
                                                treeItem.setText(finalColumn, oldText);
                                                text.dispose();
                                                testStepTableViewer.getTree()
                                                        .setFocus();
                                                break;
                                            /* Stop editing with saving */
                                            case SWT.CR:
                                                saveChanges(treeItem, finalColumn);
                                                text.dispose();
                                                testStepTableViewer.getTree()
                                                        .setFocus();
                                                break;
                                            }
                                        }
        
                                        public void keyReleased(KeyEvent e) {
                                            /* Nothing to do */
                                        }
                                    });
                                    /* Save changes when focus is lost */
                                    text.addFocusListener(new FocusListener() {
                                        public void focusGained(FocusEvent e) {
                                            /* Nothing to do */
                                        }
        
                                        public void focusLost(FocusEvent e) {
                                            saveChanges(treeItem, finalColumn);
                                            /* On a PC with Mac OS is a bug. This method is called
                                             * even though there was no focus lost
                                             */
                                            String os = System.getProperty("os.name").toLowerCase();
                                            if (os.indexOf("mac") == -1) {
                                                text.dispose();
                                            }
                                        }
                                    });
                                    /* Put text from Text control back into the cell */
                                    text.addModifyListener(new ModifyListener() {
                                        public void modifyText(ModifyEvent event) {
                                            treeItem.setText(finalColumn, text
                                                    .getText());
        
                                        }
                                    });
                                    /*
                                     * If a row showing a test step is double-clicked,
                                     * open test step
                                     */
                                } else if (treeItem.getText(COLUMN_ELEMENT_TYPE)
                                        .equals(ELEMENT_TYPE_TESTSTEP)) {
                                    TestStep testStep = (TestStep) ((TestProtocol) getModelElement())
                                            .getTestCase().getTestStepByIdentifier(
                                                    treeItem.getText(COLUMN_ID));
                                    ActionHelper.openModelElement(testStep, this
                                            .getClass().getName());
                                    /*
                                     * If a column in a row that shows a test step input
                                     * or test step output, which is not the value
                                     * column, is double-clicked, open corresponding
                                     * test step.
                                     */
                                } else if (tempColumn != COLUMN_VALUE
                                        && (!treeItem.getText(COLUMN_ELEMENT_TYPE)
                                                .equals(ELEMENT_TYPE_TESTSTEP))) {
                                    /* Was an input parameter selected? */
                                    TestStep[] testSteps = (TestStep[]) ((TestProtocol) getModelElement())
                                            .getTestCase().getStep().toArray();
                                    if (treeItem.getText(COLUMN_ELEMENT_TYPE).equals(
                                            ELEMENT_TYPE_TESTSTEPINPUT)) {
                                        TestStepInput selectedInput = null;
                                        for (int i = 0; i < testSteps.length; i++) {
                                            selectedInput = testSteps[i]
                                                    .getInputByIdentifier(treeItem
                                                            .getText(COLUMN_ID));
                                            if (selectedInput != null) {
                                                break;
                                            }
                                        }
                                        /*
                                         * Was an input parameter with the given ID
                                         * found?
                                         */
                                        if (selectedInput != null) {
                                            /* Open test step view */
                                            ActionHelper.openModelElement(selectedInput
                                                    .getTestStep(), this.getClass()
                                                    .getName());
                                        }
                                        /* Or an output parameter ? */
                                    } else if (treeItem.getText(COLUMN_ELEMENT_TYPE)
                                            .equals(ELEMENT_TYPE_TESTSTEPOUTPUT)) {
                                        TestStepOutput selectedOutput = null;
                                        for (int i = 0; i < testSteps.length; i++) {
                                            selectedOutput = testSteps[i]
                                                    .getOutputByIdentifier(treeItem
                                                            .getText(COLUMN_ID));
                                            if (selectedOutput != null) {
                                                break;
                                            }
                                        }
                                        /*
                                         * Was an output parameter with the given ID
                                         * found?
                                         */
                                        if (selectedOutput != null) {
                                            /* Open test step view */
                                            ActionHelper.openModelElement(
                                                    selectedOutput.getTestStep(), this
                                                            .getClass().getName());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /**
     * Save the changed values of the value attribute of an input or output
     * parameter.
     * 
     * @param tableItem
     *            - row where changes occurred
     * @param columnIndex
     *            - index of the column where changes occurred
     */
    public void saveChanges(TreeItem treeItem, int columnIndex) {
        /* Was an input parameter changed? */
        TestStep[] testSteps = (TestStep[]) ((TestProtocol) getModelElement())
                .getTestCase().getStep().toArray();
        if (treeItem.getText(COLUMN_ELEMENT_TYPE).equals(
                ELEMENT_TYPE_TESTSTEPINPUT)) {
            TestStepInput changedInput = null;
            for (int i = 0; i < testSteps.length; i++) {
                changedInput = testSteps[i].getInputByIdentifier(treeItem
                        .getText(COLUMN_ID));
                if (changedInput != null) {
                    break;
                }
            }
            /*
             * Was an input parameter with the given ID found?
             */
            if (changedInput != null) {
                new ChangeTestStepParameterCommand(changedInput, treeItem
                        .getText(columnIndex), columnIndex,
                        (TestProtocol) getModelElement()).run();
            }
            /* Or an output parameter ? */
        } else if (treeItem.getText(COLUMN_ELEMENT_TYPE).equals(
                ELEMENT_TYPE_TESTSTEPOUTPUT)) {
            TestStepOutput changedOutput = null;
            for (int i = 0; i < testSteps.length; i++) {
                changedOutput = testSteps[i].getOutputByIdentifier(treeItem
                        .getText(COLUMN_ID));
                if (changedOutput != null) {
                    break;
                }
            }
            /*
             * Was an output parameter with the given ID found?
             */
            if (changedOutput != null) {
                new ChangeTestStepParameterCommand(changedOutput, treeItem
                        .getText(columnIndex), columnIndex,
                        (TestProtocol) getModelElement()).run();
            }
        }
    }

    /**
     * Create change listener to observe elements.
     * 
     * The following changes need to be observed: Test Protocol link to Test
     * Case Test Case links to Test Steps Test Steps names Test Steps links to
     * input and output parameter Attributes of input and output parameter
     * 
     * The tree needs to be updated accordingly.
     * 
     */
    public void createChangeListener() {
        modelElementChangeListener = new ModelElementChangeListener() {
            public void onChange(Notification notification) {
                /*
                 * Value of an attribute of an input or output parameter was
                 * changed
                 */
                if ((notification.getNotifier() instanceof TestStepInput || notification
                        .getNotifier() instanceof TestStepOutput)
                        && notification.getEventType() == Notification.SET) {
                    testStepTableViewer.refresh();
                }
                /* A test step was changed */
                if (notification.getNotifier() instanceof TestStep) {
                    int eventType = notification.getEventType();
                    if (eventType == Notification.SET) {
                        /* Name was changed */
                        if (notification.getFeatureID(TestStep.class) == TestspecPackage.TEST_STEP__NAME) {
                            testStepTableViewer.refresh();
                        }
                    }
                    /* Input or output parameter was added */
                    if (eventType == Notification.ADD) {
                        testStepTableViewer.refresh();
                        Object newValue = notification.getNewValue();
                        if (newValue != null
                                && (newValue instanceof TestStepInput || newValue instanceof TestStepOutput)) {
                            ((ModelElement) newValue)
                                    .addModelElementChangeListener(this);
                        }
                    }
                    /* Input or output parameter(s) was/were deleted */
                    if (eventType == Notification.REMOVE
                            || eventType == Notification.REMOVE_MANY) {
                        testStepTableViewer.refresh();
                        Object oldValue = notification.getOldValue();
                        if (oldValue != null
                                && (oldValue instanceof TestStepInput || oldValue instanceof TestStepOutput)) {
                            ((ModelElement) oldValue)
                                    .removeModelElementChangeListener(this);
                        }
                    }
                }
                /* Links to test steps of a test case changed */
                if (notification.getNotifier() instanceof TestCase) {
                    int eventType = notification.getEventType();
                    /* Link(s) added */
                    if (eventType == Notification.ADD
                            || eventType == Notification.ADD_MANY) {
                        testStepTableViewer.refresh();
                        Object newValue = notification.getNewValue();
                        if (newValue != null && newValue instanceof TestStep) {
                            ((TestStep) newValue)
                                    .addModelElementChangeListener(this);
                            /* Add change listener for all input parameters */
                            TestStepInput[] testStepInput = (TestStepInput[]) ((TestStep) newValue)
                                    .getInput().toArray();
                            for (int i = 0; i < testStepInput.length; i++) {
                                testStepInput[i]
                                        .addModelElementChangeListener(this);
                            }
                            /* Add change listener for all output parameters */
                            TestStepOutput[] testStepOutput = (TestStepOutput[]) ((TestStep) newValue)
                                    .getOutput().toArray();
                            for (int j = 0; j < testStepOutput.length; j++) {
                                testStepOutput[j]
                                        .addModelElementChangeListener(this);
                            }
                        }
                        /* Link removed */
                    } else if (eventType == Notification.REMOVE
                            || eventType == Notification.REMOVE_MANY) {
                        testStepTableViewer.refresh();
                        Object oldValue = notification.getOldValue();
                        if (oldValue != null && oldValue instanceof TestStep) {
                            ((ModelElement) oldValue)
                                    .removeModelElementChangeListener(this);
                            /* Remove change listener from all input parameters */
                            TestStepInput[] testStepInput = (TestStepInput[]) ((TestStep) oldValue)
                                    .getInput().toArray();
                            for (int i = 0; i < testStepInput.length; i++) {
                                testStepInput[i]
                                        .removeModelElementChangeListener(this);
                            }
                            /* Remove change listener from all output parameters */
                            TestStepOutput[] testStepOutput = (TestStepOutput[]) ((TestStep) oldValue)
                                    .getOutput().toArray();
                            for (int j = 0; j < testStepOutput.length; j++) {
                                testStepOutput[j]
                                        .removeModelElementChangeListener(this);
                            }
                        }
                    }
                }
                /* Link to test case of a test protocol changed */
                if (notification.getNotifier() instanceof TestProtocol) {
                    switch (notification.getEventType()) {
                    case Notification.SET:
                        if (notification.getFeatureID(TestProtocol.class) == TestspecPackage.TEST_PROTOCOL__TEST_CASE) {
                            /*
                             * Empty tree and fill it with new values if
                             * necessary
                             */
                            if (testStepTableViewer.getTree() != null) {
                                testStepTableViewer.getTree().dispose();
                            }
                            if (editor != null) {
                                editor.dispose();
                            }
                            /* Create tree */
                            createTableTree(treeComposite);
                            /* Create an editor for the table cells */
                            createEditor();
                            treeComposite.layout(true);
                            scrolledComposite.layout(true);
                            /* Update change listeners */
                            Object oldValue = notification.getOldValue();
                            if (oldValue != null
                                    && oldValue instanceof TestCase) {
                                removeChangeListener((TestCase) oldValue);
                            }
                            Object newValue = notification.getNewValue();
                            if (newValue != null
                                    && newValue instanceof TestCase) {
                                addChangeListener((TestCase) newValue);
                            }
                        }
                        break;
                    }
                }
            }

            public void onRuntimeExceptionInListener(RuntimeException exception) {
                /* Nothing to do */
            }
        };
        /* Add change listener */
        /* Test protocol */
        getModelElement().addModelElementChangeListener(
                modelElementChangeListener);
        /* Other elements */
        addChangeListener(((TestProtocol) getModelElement()).getTestCase());
    }

    /**
     * Add of change listeners.
     * 
     * @param tc
     *            - test case linked to test protocol
     */
    public void addChangeListener(TestCase tc) {
        if (tc != null) {
            /* Test case */
            tc.addModelElementChangeListener(modelElementChangeListener);
            for (int i = 0; i < tc.getStep().size(); i++) {
                TestStep ts = tc.getStep().get(i);
                /* Test steps */
                ts.addModelElementChangeListener(modelElementChangeListener);
                /* Input parameter */
                for (int j = 0; j < ts.getInput().size(); j++) {
                    ts.getInput().get(j).addModelElementChangeListener(
                            modelElementChangeListener);
                }
                /* Output parameter */
                for (int k = 0; k < ts.getOutput().size(); k++) {
                    ts.getOutput().get(k).addModelElementChangeListener(
                            modelElementChangeListener);
                }
            }
        }
    }

    /**
     * Remove change listeners.
     * 
     * @param tc
     *            - test case which was linked to the test protocol
     */
    public void removeChangeListener(TestCase tc) {
        if (tc != null) {
            /* Test case */
            tc.removeModelElementChangeListener(modelElementChangeListener);
            for (int i = 0; i < tc.getStep().size(); i++) {
                TestStep ts = tc.getStep().get(i);
                /* Test steps */
                ts.removeModelElementChangeListener(modelElementChangeListener);
                /* Input parameter */
                for (int j = 0; j < ts.getInput().size(); j++) {
                    ts.getInput().get(j).removeModelElementChangeListener(
                            modelElementChangeListener);
                }
                /* Output parameter */
                for (int k = 0; k < ts.getOutput().size(); k++) {
                    ts.getOutput().get(k).removeModelElementChangeListener(
                            modelElementChangeListener);
                }
            }
        }
    }

    /**
     * Focus on dynamic tree.
     */
    public void setFocus() {
        testStepTableViewer.getControl().setFocus();
    }

    /**
     * Specifies that the dynamic tree shall be shown for test steps in the test
     * protocol view.
     * 
     * @param itemPropertyDescriptor
     *            - of the model element
     * @param modelElement
     *            - considered model element
     * @return priority to use this control
     */
    @Override
    public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
            ModelElement modelElement) {
        if (modelElement instanceof TestProtocol) {
            Object feature = itemPropertyDescriptor.getFeature(modelElement);
            if (feature instanceof EReference) {
                if (((EReference) feature).getName().equals(
                        REFERENCE_TEST_STEP_NAME)) {
                    return PRIORITY;
                }
            }
        }
        return AbstractMEControl.DO_NOT_RENDER;
    }

    /**
     * Dispose method.
     */
    @Override
    public void dispose() {
        getModelElement().removeModelElementChangeListener(
                modelElementChangeListener);
        removeChangeListener(((TestProtocol) getModelElement()).getTestCase());
        testStepTableViewer.getTree().dispose();
        editor.dispose();
        treeComposite.dispose();
        scrolledComposite.dispose();
        super.dispose();
    }
}
