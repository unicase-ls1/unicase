package org.unicase.model.testspec.ui.test.tablecontrol;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecPackage;
import org.unicase.model.testspec.provider.TestStepInputItemProvider;
import org.unicase.model.testspec.provider.TestStepOutputItemProvider;
import org.unicase.model.testspec.provider.TestspecItemProviderAdapterFactory;
import org.unicase.model.testspec.ui.editor.commands.ChangeTestStepParameterCommand;
import org.unicase.model.testspec.ui.editor.commands.CreateNewTestStepParameterCommand;
import org.unicase.model.testspec.ui.editor.commands.DeleteMultipleMECommand;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepParameterTableContentProvider;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepParameterTableLabelProvider;
import org.unicase.ui.common.decorators.OverlayImageDescriptor;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * Control for the dynamic table of input parameter of test steps.
 * 
 * @author Sharon Friedrich
 * 
 */
public class TestStepParameterControl extends StubAbstractMEControl {
    /**
     * Priority of control.
     * 
     * Indicates with which priority this control shall be used.
     */
    private static final int PRIORITY = 2;
    /**
     * Constant text.
     */
    private static final String REFERENCE_INPUT_NAME = "input";
    private static final String REFERENCE_OUTPUT_NAME = "output";
    private static final String TOOLTIP_TEXT_INPUT = "Input Parameter";
    private static final String TOOLTIP_TEXT_OUTPUT = "Output Parameter";
    /**
     * Button constant text.
     */
    private static final String ADD_BUTTON_BEGINNING_TEXT = "Add new ";
    private static final String DEL_BUTTON_BEGINNING_TEXT = "Delete selected ";
    private static final String DEL_BUTTON_ENDING_TEXT = "(s)";

    /**
     * Button Image.
     */
    private static final String TESTSTEPINPUT_IMG_LOCATOR = "full/obj16/TestStepInput";
    private static final String TESTSTEPOUTPUT_IMG_LOCATOR = "full/obj16/TestStepOutput";
    private static final int ADD_BUTTON = 1;
    private static final int DELETE_BUTTON = 2;
    private static final String EXCEPTION_IMG_NOT_FOUND = "Referenced image could not be found";
    private static final String EXCEPTION_IMG_NOT_CREATED = "Button image could not be created";
    /**
     * Column constant titles.
     */
    private static final String[] VISIBLE_COLUMN_TITLES = { "Name", "Type",
            "Range" };
    private static final String COLUMN_TITLE_ID = "ID";
    /**
     * Column index.
     */
    private static final int COLUMN_ID = 3;
    /**
     * Column width.
     */
    private static final int[] COLUMN_WIDTH = { 135, 135, 135 };

    private EReference eReference;
    private IItemPropertyDescriptor descriptor;
    private AdapterImpl eAdapter;
    private TableViewer parameterTable;

    /**
     * Constructor.
     * 
     */
    public TestStepParameterControl(String featureName) {
        super(featureName);
    }

    /**
     * Creates the control.
     * 
     * @param parent
     *            - surrounding composite
     * @param style
     *            - style that should be used
     * @return control - table control
     */
    public Control createControl(final Composite parent, final int style) {
        this.descriptor = getItemPropertyDescriptor();
        this.eReference = (EReference) descriptor.getFeature(getModelElement());

        eAdapter = new AdapterImpl() {
            @Override
            public void notifyChanged(Notification msg) {
                if (msg.getFeature() != null
                        && msg.getFeature().equals(eReference)) {
                    parameterTable.refresh();
                }
                super.notifyChanged(msg);
            }
        };
        getModelElement().eAdapters().add(eAdapter);

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
         * 10 rows in the table can be shown and the remaining can be shown by
         * scrolling
         */
        ScrolledComposite scrolledComposite = new ScrolledComposite(section,
                SWT.V_SCROLL | SWT.H_SCROLL);
        /* Create composite which will contain the table */
        Composite tableComposite = getToolkit().createComposite(
                scrolledComposite);
        tableComposite.setLayout(new GridLayout());

        /* Create table */
        createTable(tableComposite);
        /* Create an editor for the table cells */
        createEditor();
        /* Table composite shall be shown in the scrollable composite */
        scrolledComposite.setContent(tableComposite);
        /*
         * Table composite shall fill the whole vertical space of the scrollable
         * composite
         */
        scrolledComposite.setExpandVertical(true);
        /*
         * Table composite shall fill the whole horizontal space of the
         * scrollable composite
         */
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setMinSize(tableComposite.computeSize(SWT.DEFAULT,
                SWT.DEFAULT));

        section.setClient(scrolledComposite);
        return section;
    }

    /**
     * Create buttons in the toolbar for adding & deleting parameters.
     * 
     * @param toolbar
     *            - toolbar where the buttons shall be displayed
     */
    private void createButtons(ToolBar toolbar) {
        final int classifier;
        String toolTipText = "";
        /* Contains the table input parameters? */
        if (this.eReference.getName().equals(REFERENCE_INPUT_NAME)) {
            classifier = TestspecPackage.TEST_STEP_INPUT;
            toolTipText = TOOLTIP_TEXT_INPUT;
            /* Or contains the table output parameters? */
        } else if (this.eReference.getName().equals(REFERENCE_OUTPUT_NAME)) {
            classifier = TestspecPackage.TEST_STEP_OUTPUT;
            toolTipText = TOOLTIP_TEXT_OUTPUT;
            /* Should not happen */
        } else {
            return;
        }
        /* Create add button */
        ToolItem addButton = new ToolItem(toolbar, SWT.PUSH);
        final Image addButtonImage = createButtonImage(ADD_BUTTON);
        addButton.setImage(addButtonImage);
        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new CreateNewTestStepParameterCommand(getModelElement(),
                        classifier).run();
            }
        });
        /* Image has to be explicitly disposed */
        addButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                addButtonImage.dispose();
            }
        });
        addButton.setToolTipText(ADD_BUTTON_BEGINNING_TEXT + toolTipText);

        /* Create delete button */
        ToolItem deleteButton = new ToolItem(toolbar, SWT.PUSH);
        final Image deleteButtonImage = createButtonImage(DELETE_BUTTON);
        deleteButton.setImage(deleteButtonImage);
        deleteButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (parameterTable != null) {
                    /* Get all selected rows */
                    TableItem[] selectedRows = parameterTable.getTable()
                            .getSelection();
                    /*
                     * Get the corresponding parameters and save them in an
                     * array list
                     */
                    ArrayList<ModelElement> testStepParameterToDelete = new ArrayList<ModelElement>();
                    for (int i = 0; i < selectedRows.length; i++) {
                        /*
                         * Get the ID of the test step parameter of the current
                         * row
                         */
                        String parameterID = selectedRows[i].getText(COLUMN_ID);
                        /* Get the parameter with this ID */
                        TestStep testStep = (TestStep) getModelElement();
                        /* Shall input parameters be deleted? */
                        if (eReference.getName().equals(REFERENCE_INPUT_NAME)) {
                            TestStepInput selectedInput = testStep
                                    .getInputByIdentifier(parameterID);
                            /* Was an input parameter with the given ID found? */
                            if (selectedInput != null) {
                                /*
                                 * Add to the list of input parameters to be
                                 * deleted
                                 */
                                testStepParameterToDelete
                                        .add((ModelElement) selectedInput);
                            }
                            /* Or output parameters? */
                        } else if (eReference.getName().equals(
                                REFERENCE_OUTPUT_NAME)) {
                            TestStepOutput selectedOutput = testStep
                                    .getOutputByIdentifier(parameterID);
                            /* Was an input parameter with the given ID found? */
                            if (selectedOutput != null) {
                                /*
                                 * Add to the list of input parameters to be
                                 * deleted
                                 */
                                testStepParameterToDelete
                                        .add((ModelElement) selectedOutput);
                            }
                        }
                    }
                    /* Delete all selected input parameters */
                    new DeleteMultipleMECommand(testStepParameterToDelete)
                            .run();
                }
            }
        });
        /* Image has to be explicitly disposed */
        deleteButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                deleteButtonImage.dispose();
            }
        });
        deleteButton.setToolTipText(DEL_BUTTON_BEGINNING_TEXT + toolTipText
                + DEL_BUTTON_ENDING_TEXT);
    }

    /**
     * Creates the image of the add and delete button.
     * 
     * @param buttonType
     *            - add or delete button
     * @return image - button image
     */
    private Image createButtonImage(final int buttonType) {
        /* Get image of the test step parameter */
        Image testParameterImage = null;
        /* Test step parameter is an input parameter */
        if (this.eReference.getName().equals(REFERENCE_INPUT_NAME)) {
            TestStepInputItemProvider testStepInputItemProvider = (TestStepInputItemProvider) new TestspecItemProviderAdapterFactory()
                    .createTestStepInputAdapter();
            testParameterImage = ExtendedImageRegistry.getInstance()
                    .getImageDescriptor(
                            testStepInputItemProvider
                                    .getImage(TESTSTEPINPUT_IMG_LOCATOR))
                    .createImage();
            /* Test step parameter is an output parameter */
        } else {
            TestStepOutputItemProvider testStepOutputItemProvider = (TestStepOutputItemProvider) new TestspecItemProviderAdapterFactory()
                    .createTestStepOutputAdapter();
            testParameterImage = ExtendedImageRegistry.getInstance()
                    .getImageDescriptor(
                            testStepOutputItemProvider
                                    .getImage(TESTSTEPOUTPUT_IMG_LOCATOR))
                    .createImage();
        }
        /* Image of the test step parameter could not be found */
        if (testParameterImage == null) {
            throw new RuntimeException(EXCEPTION_IMG_NOT_FOUND);
        }
        /* Get overlay image of the button */
        ImageDescriptor overlayImage;
        if (buttonType == ADD_BUTTON) {
            overlayImage = org.unicase.ui.common.Activator
                    .getImageDescriptor("icons/add_overlay.png");
        } else {
            overlayImage = org.unicase.ui.common.Activator
                    .getImageDescriptor("icons/delete_overlay.png");
        }
        /* Overlay image could not be found */
        if (overlayImage == null) {
            throw new RuntimeException(EXCEPTION_IMG_NOT_FOUND);
        }
        /* Create combined image for button */
        OverlayImageDescriptor overlayImageDescriptor = new OverlayImageDescriptor(
                testParameterImage, overlayImage,
                OverlayImageDescriptor.LOWER_RIGHT);
        if (overlayImageDescriptor == null) {
            throw new RuntimeException(EXCEPTION_IMG_NOT_CREATED);
        }
        return overlayImageDescriptor.createImage();
    }

    /**
     * Creates the dynamic table of test step parameters.
     * 
     * @param tableComposite
     *            - surrounding composite
     */
    private void createTable(Composite tableComposite) {
        parameterTable = new TableViewer(tableComposite, SWT.MULTI
                | SWT.FULL_SELECTION);
        Table table = parameterTable.getTable();
        /* Set maximum height of the table to 10 rows */
        GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
        data.heightHint = 10 * table.getItemHeight() + 10;
        table.setLayoutData(data);
        /* Table header and lines shall be visible */
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        /* Create columns */
        createColumns();
        /* Set provider of the table viewer */
        parameterTable
                .setContentProvider(new TestStepParameterTableContentProvider());
        parameterTable
                .setLabelProvider(new TestStepParameterTableLabelProvider());
        /* Fill table cells with content */
        /* Shall input parameters be displayed in the table? */
        if (eReference.getName().equals(REFERENCE_INPUT_NAME)) {
            parameterTable.setInput(((TestStep) getModelElement()).getInput());
            /* Or output parameters? */
        } else if (eReference.getName().equals(REFERENCE_OUTPUT_NAME)) {
            parameterTable.setInput(((TestStep) getModelElement()).getOutput());
        }
    }

    /**
     * Creates the columns in the dynamic table.
     * 
     */
    private void createColumns() {
        /* Columns for name, type and range */
        for (int i = 0; i < VISIBLE_COLUMN_TITLES.length; i++) {
            TableViewerColumn column = new TableViewerColumn(parameterTable,
                    SWT.NONE);
            column.getColumn().setText(VISIBLE_COLUMN_TITLES[i]);
            column.getColumn().setMoveable(false);
            column.getColumn().setResizable(true);
            column.getColumn().setWidth(COLUMN_WIDTH[i]);
        }
        /* Hidden column for the ID of the test step parameter */
        TableViewerColumn hiddenColumn = new TableViewerColumn(parameterTable,
                SWT.NONE);
        hiddenColumn.getColumn().setText(COLUMN_TITLE_ID);
        hiddenColumn.getColumn().setMoveable(false);
        hiddenColumn.getColumn().setResizable(false);
        hiddenColumn.getColumn().setWidth(0);
    }

    /**
     * Creates an editor that will be used for table cell editing.
     * 
     */
    private void createEditor() {
        final TableEditor editor = new TableEditor(parameterTable.getTable());
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        /* Editor shall be "activated" when the user double-clicks on a cell */
        parameterTable.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent event) {
                /* Dispose any existing editor */
                Control oldEditor = editor.getEditor();
                if (oldEditor != null) {
                    oldEditor.dispose();
                }
                /* Determine the point where the user double-clicked */
                Point clickedPoint = new Point(event.x, event.y);
                /* Determine the row */
                final TableItem tableItem = parameterTable.getTable().getItem(
                        clickedPoint);
                if (tableItem != null) {
                    /* Determine the column */
                    int tempColumn = -1;
                    for (int i = 0; i < parameterTable.getTable()
                            .getColumnCount(); i++) {
                        Rectangle cell = tableItem.getBounds(i);
                        if (cell.contains(clickedPoint)) {
                            /* Column found */
                            tempColumn = i;
                            break;
                        }
                    }
                    /*
                     * Save text in temp variable in case that editing is
                     * cancelled
                     */
                    final String oldText = tableItem.getText(tempColumn);
                    /* Create Text object for editor that holds the cell values */
                    final Text text = new Text(parameterTable.getTable(),
                            SWT.NONE);
                    /* Put text from cell into the Text control */
                    text.setText(tableItem.getText(tempColumn));
                    /* Select the text in the cell for editing */
                    text.selectAll();
                    /* Set focus to the Text control */
                    text.setFocus();
                    /* Determine minimum width of the editor */
                    editor.minimumWidth = text.getBounds().width;
                    /* Set Text control into the editor */
                    editor.setEditor(text, tableItem, tempColumn);
                    /* Only the id column is not editable */
                    if (tempColumn != COLUMN_ID) {
                        /*
                         * Add modify listener that saves the changed values to
                         * the corresponding model element.
                         */
                        /*
                         * Column variable must be final because it is otherwise
                         * not visible to the modifyText method
                         */
                        final int finalColumn = tempColumn;
                        /* Stop editing when ENTER or ESC is pressed */
                        text.addKeyListener(new KeyListener() {
                            @Override
                            public void keyPressed(KeyEvent event) {
                                switch (event.keyCode) {
                                /* Cancel editing without saving */
                                case SWT.ESC:
                                    tableItem.setText(finalColumn, oldText);
                                    text.dispose();
                                    parameterTable.getTable().setFocus();
                                    break;
                                /* Stop editing with saving */
                                case SWT.CR:
                                    saveChanges(tableItem, finalColumn);
                                    text.dispose();
                                    parameterTable.getTable().setFocus();
                                    break;
                                }
                            }

                            @Override
                            public void keyReleased(KeyEvent e) {
                                /* Nothing to do */
                            }
                        });
                        /* Save changes when focus is lost */
                        text.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                /* Nothing to do */
                            }

                            @Override
                            public void focusLost(FocusEvent e) {
                                saveChanges(tableItem, finalColumn);
                                text.dispose();
                            }
                        });
                        /* Put text from Text control back into the cell */
                        text.addModifyListener(new ModifyListener() {
                            public void modifyText(ModifyEvent event) {
                                tableItem.setText(finalColumn, text.getText());
                            }
                        });
                    }
                }
            }
        });
    }

    /**
     * Save the changed values of an attribute of an input or output parameter.
     * 
     * @param tableItem
     *            - row where changes occurred
     * @param columnIndex
     *            - index of the column where changes occurred
     */
    public void saveChanges(TableItem tableItem, int columnIndex) {
        /* Was an input parameter changed? */
        if (eReference.getName().equals(REFERENCE_INPUT_NAME)) {
            TestStepInput changedInput = ((TestStep) getModelElement())
                    .getInputByIdentifier(tableItem.getText(COLUMN_ID));
            /*
             * Was an input parameter with the given ID found?
             */
            if (changedInput != null) {
                new ChangeTestStepParameterCommand(changedInput, tableItem
                        .getText(columnIndex), columnIndex, null).run();
            }
            /* Or an output parameter ? */
        } else if (eReference.getName().equals(REFERENCE_OUTPUT_NAME)) {
            TestStepOutput changedOutput = ((TestStep) getModelElement())
                    .getOutputByIdentifier(tableItem.getText(COLUMN_ID));
            /*
             * Was an output parameter with the given ID found?
             */
            if (changedOutput != null) {
                new ChangeTestStepParameterCommand(changedOutput, tableItem
                        .getText(columnIndex), columnIndex, null).run();
            }
        }
    }

    /**
     * Focus on dynamic table.
     */
    public void setFocus() {
        parameterTable.getControl().setFocus();
    }

    /**
     * Specifies that the dynamic table shall be shown for input and output
     * parameters.
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
        Object feature = itemPropertyDescriptor.getFeature(modelElement);
        /* Shall input or output parameter be displayed? */
        if (feature instanceof EReference) {
            if (((EReference) feature).getName().equals(REFERENCE_INPUT_NAME)
                    || ((EReference) feature).getName().equals(
                            REFERENCE_OUTPUT_NAME)) {
                return PRIORITY;
            }
        }
        return AbstractMEControl.DO_NOT_RENDER;
    }

    /**
     * Dispose method.
     */
    @Override
    public void dispose() {
        getModelElement().eAdapters().remove(eAdapter);
        parameterTable.getTable().dispose();
        super.dispose();
    }
}
