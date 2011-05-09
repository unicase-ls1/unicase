package org.unicase.model.testspec.ui.editor.tablecontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.testspec.TestCase;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecPackage;
import org.unicase.model.testspec.provider.TestStepInputItemProvider;
import org.unicase.model.testspec.provider.TestStepOutputItemProvider;
import org.unicase.model.testspec.provider.TestspecItemProviderAdapterFactory;
import org.unicase.model.testspec.ui.editor.commands.ChangeTestStepParameterCommand;
import org.unicase.model.testspec.ui.editor.commands.ChangeTextCommand;
import org.unicase.model.testspec.ui.editor.commands.CreateNewTestStepCommand;
import org.unicase.model.testspec.ui.editor.commands.CreateNewTestStepParameterCommand;
import org.unicase.model.testspec.ui.editor.commands.DeleteMultipleMECommand;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepParameterTableContentProvider;
import org.unicase.model.testspec.ui.editor.tableprovider.TestStepParameterTableLabelProvider;
import org.unicase.ui.common.decorators.OverlayImageDescriptor;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

public class TestCaseTableControl extends AbstractMEControl{


	/**
     * Priority of control.
     * 
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
    private static final String[] VISIBLE_COLUMN_TITLES = { "Name", "Type", "Range"};
    private static final String COLUMN_TITLE_ID = "ID";
    
    /**
     * Column index.
     */
    
    private static final int COLUMN_ID = 3;
    /**
     * Column width.
     */
    private static final int[] COLUMN_WIDTH = { 140, 135, 135 };

    private EReference eReference;
    private IItemPropertyDescriptor descriptor;
    private AdapterImpl eAdapter;
    private TableViewer parameterTable;
    private HashSet<ExpandItem> itemSet;
    private int itemHeight = 0;
    
    
    
    /**
     * Constructor.
     * 
     * 
     */
    public TestCaseTableControl() {
        super();
    }

    /**
     * Creates the control.
     * 
     * @param parent
     *            - surrounding composite
     * @param style
     *            - style that should be used
     * @return control - table control
     * 
     */
    public Control createControl(final Composite parent, final int style) {
       
    	

        Section section = getToolkit().createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
     
        ToolBar toolbar = new ToolBar(section, SWT.FLAT | SWT.HORIZONTAL);
        
        
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

		
        section.setTextClient(toolbar);
        section.setText("Steps");
        
       
        ScrolledComposite scrolledComposite = new ScrolledComposite(section,
                SWT.H_SCROLL);
        
        
        
        
        Composite tableComposite = getToolkit().createComposite(
                scrolledComposite);
        tableComposite.setLayout(new FillLayout());
        tableComposite.setBounds(scrolledComposite.getBounds());
        
        Color bgWhite = tableComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE);		
        
                
    	final Image deletionImage = tableComposite.getDisplay().getSystemImage(SWT.ICON_ERROR);

    	ExpandBar bar = new ExpandBar(tableComposite, SWT.NONE);
        bar.setBackground(bgWhite);
       
        //Get the contained TestSteps of the TestCase and sort them
        ModelElement test = getModelElement();
        Set<TestStep> containedSteps = new HashSet<TestStep>();   
        Set<ModelElement> containedElements = test.getAllContainedModelElements();
        
        for(ModelElement element : containedElements){
        	if (element instanceof TestStep){

            	containedSteps.add((TestStep) element);
            	
        	}
        }
        
        /*Create an ExpandBar with Tables for every linked TestStep*/
        
        Object[] stepArray = containedSteps.toArray(); 
        Arrays.sort(stepArray, new StepComparator());			
        ArrayList<TestStep> stepList = new ArrayList<TestStep>();       
        for (int i=0; i < stepArray.length; i++) {
          	Object element = stepArray[i];
        	if (element instanceof TestStep){
          		TestStep step = (TestStep) element;
          		stepList.add(step);
          	}		        		
    	}
      
        createStepItems(bar, stepList, tableComposite);
        
        scrolledComposite.setContent(tableComposite);
        scrolledComposite.setExpandVertical(true); 
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setMinSize(tableComposite.computeSize(SWT.DEFAULT,
                SWT.DEFAULT));
        scrolledComposite.setExpandVertical(true);
        scrolledComposite.getVerticalBar();
        
        int minHeight = stepList.size() * itemHeight;
        scrolledComposite.setMinHeight(minHeight + 150);
       
        
        section.setClient(scrolledComposite);
        createStepButtons(toolbar, deletionImage, bar, tableComposite, section);
        createExpandButtons(toolbar);
     
        
         return section;
    }

    
    
    /**
     * @author chen
     * 
     * Creates the dynamic table of test step input parameters.
     * 
     * 
     * @param tableComposite
     *            - surrounding composite
     */
    private void createInputTable(Composite inputComposite, TestStep step) {
        parameterTable = new TableViewer(inputComposite, SWT.MULTI
                | SWT.FULL_SELECTION);
        Table table = parameterTable.getTable();
        /* Set maximum height of the table to 10 rows */
        
        
        GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
        data.heightHint = 10 * table.getItemHeight() + 10;
        data.grabExcessHorizontalSpace = true;
       
        
        table.setLayoutData(data);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        createColumns(inputComposite, parameterTable);
        
        
        
        
        
        /* Set provider of the table viewer */
        parameterTable
                .setContentProvider(new TestStepParameterTableContentProvider());
        parameterTable
                .setLabelProvider(new TestStepParameterTableLabelProvider());
        /* Fill table cells with content */
        /* Display input parameters in the table */
        parameterTable.setInput(step.getInput());
        createEditor(parameterTable);
       
        
        //create a String-array, that contains the stepIdentifier and the type of table (input or output)
        String[] tableInfo = new String[2];
        tableInfo[0] = step.getIdentifier();
        tableInfo[1] = "input";
        table.setData(tableInfo);
        
    }
    
    
    
    
    
    
    private void createOutputTable(Composite outputComposite, TestStep step) {
        parameterTable = new TableViewer(outputComposite, SWT.MULTI
                | SWT.FULL_SELECTION);
        Table table = parameterTable.getTable();
        /* Set maximum height of the table to 10 rows */
        
        GridLayout tableLayout = new GridLayout();
        tableLayout.marginWidth = 0;
        tableLayout.marginLeft = 0;
        table.setLayout(tableLayout);
        
        GridData data = new GridData();
        
        data.heightHint = 10 * table.getItemHeight() + 10;
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;  
        table.setLayoutData(data);
        
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        createColumns(outputComposite, parameterTable);
        parameterTable
                .setContentProvider(new TestStepParameterTableContentProvider());
        parameterTable
                .setLabelProvider(new TestStepParameterTableLabelProvider());
        /* Fill table cells with content */
        /* Display output parameters in the table? */
        parameterTable.setInput(step.getOutput());
        createEditor(parameterTable);
       
        
        
        //create a String-array, that contains the stepIdentifier and the type of table (input or output)
        String[] tableInfo = new String[2];
        tableInfo[0] = step.getIdentifier();
        tableInfo[1] = "output";
        table.setData(tableInfo);
       }
    
    
    public Image createOutputButtonImage(final int buttonType){
    	 /* Get image of the test step parameter */
        Image testParameterImage = null;
        TestStepOutputItemProvider testStepOutputItemProvider = (TestStepOutputItemProvider) new TestspecItemProviderAdapterFactory()
                    .createTestStepOutputAdapter();
            testParameterImage = ExtendedImageRegistry.getInstance()
                    .getImageDescriptor(
                            testStepOutputItemProvider
                                    .getImage(TESTSTEPOUTPUT_IMG_LOCATOR))
                    .createImage();
        
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
    

    public Image createInputButtonImage(final int buttonType){
        Image testParameterImage = null;
        TestStepInputItemProvider testStepInputItemProvider = (TestStepInputItemProvider) new TestspecItemProviderAdapterFactory()
                    .createTestStepInputAdapter();
            testParameterImage = ExtendedImageRegistry.getInstance()
                    .getImageDescriptor(
                            testStepInputItemProvider
                                    .getImage(TESTSTEPINPUT_IMG_LOCATOR))
                    .createImage();
            /* Test step parameter is an output parameter */
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
     * Creates the columns in the dynamic table.
     * 
     */
    private void createColumns(final Composite paramComp, TableViewer parameterTable) {
        /* Columns for name, type and range */
    
        final Table table = parameterTable.getTable();
        
    	
    	
    	final Set<TableViewerColumn> columnSet = new HashSet<TableViewerColumn>();
        for (int i = 0; i < VISIBLE_COLUMN_TITLES.length; i++) {
            TableViewerColumn column = new TableViewerColumn(parameterTable,
                    SWT.NONE);
           
            column.getColumn().setText(VISIBLE_COLUMN_TITLES[i]);
            column.getColumn().setMoveable(true);
            column.getColumn().setResizable(true);
            column.getColumn().setWidth(COLUMN_WIDTH[i]);
            columnSet.add(column);
            
        }
        
        //Add a controlListener for resizing the tables
        paramComp.addControlListener(new ControlAdapter() {	
        	 public void controlResized(ControlEvent e) {
        	      Rectangle area = paramComp.getClientArea();
        	      Point preferredSize = table.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        	      int width = area.width - 2*table.getBorderWidth();
        	      if (preferredSize.y > area.height + table.getHeaderHeight()) {
        	        Point vBarSize = table.getVerticalBar().getSize();
        	        width -= vBarSize.x;
        	      }
        	      Point oldSize = table.getSize();
        	      if (oldSize.x > area.width) {
        	          for (TableViewerColumn column : columnSet) {
        	    		  column.getColumn().setWidth((width/3));
					}
        	        
        	        
        	        table.setSize(area.width, area.height);
        	      } else {
        	        table.setSize(area.width, area.height);
      	    	  for (TableViewerColumn column : columnSet) {
    	    		  column.getColumn().setWidth((width/3));
				}
        	      }
        	    }
        	  });
        
        
        
        
        /* Hidden column for the ID of the test step parameter */
       
        TableViewerColumn hiddenColumn = new TableViewerColumn(parameterTable,
                SWT.NONE);
        hiddenColumn.getColumn().setText(COLUMN_TITLE_ID);
        hiddenColumn.getColumn().setMoveable(false);
        hiddenColumn.getColumn().setResizable(false);
        hiddenColumn.getColumn().setWidth(0);
   
   
        
        
    }

   
    
    private void createEditor(final TableViewer table) {
        final TableEditor editor = new TableEditor(table.getTable());
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        /* Editor is activated when the user double-clicks on a cell */
        table.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent event) {
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
                    final TableItem tableItem = table.getTable().getItem(
                            clickedPoint);
                    if (tableItem != null) {
                        /* Determine the column */
                        int tempColumn = -1;
                        for (int i = 0; i < table.getTable()
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
                        final Text text = new Text(table.getTable(),
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
                                public void keyPressed(KeyEvent event) {
                                    switch (event.keyCode) {
                                    /* Cancel editing without saving */
                                    case SWT.ESC:
                                        tableItem.setText(finalColumn, oldText);
                                        text.dispose();
                                        table.getTable().setFocus();
                                        break;
                                    /* Stop editing with saving */
                                    case SWT.CR:
                                        saveChanges(tableItem, finalColumn);
                                        text.dispose();
                                        table.getTable().setFocus();
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
            }
        });
    }
    
    
    
    
    /*
     * Create an ExpandItem for every linked TestStep
     *  
     */
    public void createStepItems(ExpandBar bar, ArrayList<TestStep> linkedSteps,
    		Composite tableComposite ){
    		itemSet = new HashSet<ExpandItem>();
    	for (final TestStep step : linkedSteps){
        	
        	String stepID = step.getIdentifier();
        	
        	
        	
        	Composite stepComposite = getToolkit().createComposite(bar);
        	GridLayout stepLayout = new GridLayout();
        	stepLayout.marginWidth = 0;
        	stepLayout.marginHeight = 0;
        	
        	stepComposite.setLayout(stepLayout);
        	GridData stepData = new GridData();
        	stepData.grabExcessHorizontalSpace = true;
        	stepData.grabExcessVerticalSpace = true;
        	stepComposite.setLayoutData(stepData);
    		
    		Composite newTableComposite = new Composite(stepComposite, SWT.NONE);
    		
    		GridLayout tableLayout = new GridLayout();
    		tableLayout.numColumns = 2;
    		tableLayout.makeColumnsEqualWidth = true;
    		tableLayout.marginWidth = 0;
    		tableLayout.marginLeft = 5;
    		tableLayout.marginRight = 5;
    		tableLayout.marginHeight = 0;
    		tableLayout.marginBottom = 5;
    		tableLayout.marginTop = 10;
    		newTableComposite.setLayout(tableLayout);
    		GridData tableData = new GridData();
        	tableData.grabExcessHorizontalSpace = true;
        	tableData.horizontalAlignment = GridData.FILL;
        	newTableComposite.setLayoutData(tableData);
    		
        	
            final Text descriptionText = new Text(newTableComposite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
            descriptionText.setText("Description");
    		
        	int textHeight = 60;
        	GridData descTextData = new GridData();
    		descTextData.grabExcessHorizontalSpace = true;
    		descTextData.grabExcessVerticalSpace = true;
        	descTextData.horizontalAlignment = GridData.FILL;
        	descTextData.horizontalSpan = 2;
        	descTextData.heightHint = textHeight;
           
            
            descriptionText.setLayoutData(descTextData);
            
    		descriptionText.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    /* Nothing to do */
                }

                public void focusLost(FocusEvent e) {
                    new ChangeTextCommand(step, descriptionText.getText(), 1).run();
                    
                    
                }
            });
            
            if (step.getDescriptionPlainText() != null ){
            	descriptionText.setText(step.getDescriptionPlainText().toString());
            }else {
            	descriptionText.setText("Description");
            }          
    		 
            
         

        	
        	
        	
        	
    		Composite inputComposite = new Composite(newTableComposite, SWT.NONE);
    		GridLayout inputLayout = new GridLayout();
        	inputLayout.marginWidth = 0;
        	inputLayout.marginRight = 0;
        	inputLayout.marginBottom = 0;
        	inputLayout.marginHeight = 0;
        	inputLayout.marginTop = 0;
        	inputComposite.setLayout(inputLayout);
        	GridData inputData = new GridData();
        	inputData.grabExcessHorizontalSpace = true;
        	inputData.grabExcessVerticalSpace = true;
        	inputData.horizontalAlignment = GridData.FILL;
    		inputComposite.setLayoutData(inputData);
    	
    		

        	Composite inputButtonComposite = new Composite(inputComposite, SWT.LEFT);
        	GridLayout inButtonLayout = new GridLayout();
        	inButtonLayout.numColumns = 3;
        	inButtonLayout.marginBottom = 0;
        	inputButtonComposite.setLayout(inButtonLayout);
        	GridData inputButtonData = new GridData();
        	inputButtonData.grabExcessHorizontalSpace = true;
        	inputButtonData.horizontalAlignment = GridData.FILL;
        	inputButtonComposite.setLayoutData(inputButtonData);
        	Label inputLabel = new Label(inputButtonComposite, SWT.LEFT);
    	    inputLabel.setText("Input");
    	      		
        	
        	Composite outputComposite = new Composite(newTableComposite,SWT.NONE);
    		GridLayout outputLayout = new GridLayout();
        	outputLayout.marginWidth = 0;
        	outputLayout.marginLeft = 0;
        	outputLayout.marginTop = 0;
        	GridData outputData = new GridData();
        	outputData.grabExcessHorizontalSpace = true;
        	outputData.horizontalAlignment = GridData.FILL;
    		outputComposite.setLayout(outputLayout);
    		outputComposite.setLayoutData(outputData);

        	
        	Composite outComposite = new Composite (outputComposite, SWT.NONE);
        	GridLayout outLayout = new GridLayout();
        	outLayout.numColumns = 2;
        	outComposite.setLayout(outLayout);
    		GridData outData = new GridData();
    		outData.grabExcessHorizontalSpace = true;
    		outData.horizontalAlignment = GridData.FILL;
        	outComposite.setLayoutData(outData);

        	
        	Composite outputButtonComposite = new Composite (outComposite, SWT.LEFT);
        	GridLayout outButtonLayout = new GridLayout();
        	outButtonLayout.numColumns = 3;
        	outButtonLayout.marginHeight = 0;
        	outButtonLayout.marginWidth = 0;
        	outputButtonComposite.setLayout(outButtonLayout);
    		GridData outputButtonData = new GridData();
    		outputButtonData.grabExcessHorizontalSpace = true;
    		outputButtonData.horizontalAlignment = GridData.FILL;
        	outputButtonComposite.setLayoutData(outputButtonData);
        	
        	
    	    Composite deletionComposite = new Composite(outComposite, SWT.RIGHT);
    	    GridLayout deletionLayout = new GridLayout();
    	    deletionLayout.marginHeight = 0;
    	    deletionLayout.marginWidth = 0;
        	deletionComposite.setLayout(deletionLayout);
    		GridData deletionData = new GridData();
    		deletionData.grabExcessHorizontalSpace = true;
    		deletionData.horizontalAlignment = GridData.FILL;
    		deletionComposite.setLayoutData(deletionData);
    	  

    		
    		
    		
        	final ExpandItem item0 = new ExpandItem(bar, SWT.FILL, 0); 
        	
        	createInputTable(inputComposite, step);
        	createInputButtons(inputButtonComposite, step, parameterTable, stepID);
    	  
        	
        	Label outputLabel = new Label(outputButtonComposite, SWT.LEFT);
      	    outputLabel.setText("Expected Output");
      	    
        	createOutputTable(outputComposite, step);
        	createOutputButtons(outputButtonComposite, step, parameterTable, stepID);
    	    
        	final Image deletionImage = bar.getDisplay().getSystemImage(SWT.ICON_ERROR);
           	final Button deleteStepButton = new Button(deletionComposite, SWT.TOGGLE);
        	deleteStepButton.setText("Mark Step for Deletion");
        	deleteStepButton.setLayoutData(deletionData);
        	deleteStepButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                
                	if (deleteStepButton.getSelection() == true) {

                    	item0.setImage(deletionImage);
                	} else {
                		
                		item0.setImage(null);
                
                	}}
            });
           
            if (step.getDescriptionPlainText() != null ){
            	descriptionText.setText(step.getDescriptionPlainText().toString());
            }else {
            	descriptionText.setText("Description");
            }          
    		descriptionText.setLayoutData(descTextData);
    		
            final Text exceptionText = new Text(newTableComposite,  SWT.BORDER | SWT.WRAP | SWT.MULTI);

            
        	GridData excTextData = new GridData();
    		excTextData.grabExcessHorizontalSpace = true;
        	excTextData.horizontalAlignment = GridData.FILL;
        	excTextData.heightHint = textHeight;
        	excTextData.horizontalSpan = 2;
        	exceptionText.setLayoutData(excTextData);

            
            if (step.getException() != null ){
            	exceptionText.setText(step.getException());
            }else {
            	exceptionText.setText("Exception");
            }          
    		exceptionText.setLayoutData(descTextData);
    		
            
    	
    		exceptionText.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    /* Nothing to do */
                }

                public void focusLost(FocusEvent e) {
                    new ChangeTextCommand(step, exceptionText.getText(), 2).run();
                    
                    
                }
            });

        	
        	tableComposite.redraw();
        	
        	item0.setControl(stepComposite);
        	item0.setText(step.getName());
        	
        	itemHeight = newTableComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
        	item0.setHeight(itemHeight);
            
            item0.setControl(stepComposite);
            item0.setExpanded(false);        
            item0.setData(stepID);
            
            
            if (item0.isDisposed()){
            	item0.getControl().setVisible(false);
            	continue;
            	
            }else{
            	itemSet.add(item0);
            }
        }
    	
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
    	String[] stepInfo = (String[]) tableItem.getParent().getData();
    	TestCase testCase = (TestCase) getModelElement();
    	TestStep step = testCase.getTestStepByIdentifier(stepInfo[0]);
    		
        if (stepInfo[1].equals(REFERENCE_INPUT_NAME)) {
        	TestStepInput changedInput = ((TestStepInput) step.getInputByIdentifier(tableItem.getText(COLUMN_ID)));
            /*
             * Was an input parameter with the given ID found?
             */
            if (changedInput != null) {
                new ChangeTestStepParameterCommand(changedInput, tableItem
                        .getText(columnIndex), columnIndex, null).run();
            }
            /* Or an output parameter ? */
        } else if (stepInfo[1].equals(REFERENCE_OUTPUT_NAME)) {
        	TestStepOutput changedOutput = ((TestStepOutput) step.getOutputByIdentifier(tableItem.getText(COLUMN_ID)));
            /*
             * Was an output parameter with the given ID found?
             */
            if (changedOutput != null) {
                new ChangeTestStepParameterCommand(changedOutput, tableItem
                        .getText(columnIndex), columnIndex, null).run();
            }
        }
    }

    private void createInputButtons(Composite comp, final TestStep step, final TableViewer table, final String stepID) {
        final int inputClassifier;
        String toolTipText = "";
        
        inputClassifier = TestspecPackage.TEST_STEP_INPUT;
        toolTipText = TOOLTIP_TEXT_INPUT;
        /* Create add button */
        Button addButton = new Button(comp, SWT.PUSH);
        final Image addButtonImage = createInputButtonImage(ADD_BUTTON);
        addButton.setImage(addButtonImage);
        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new CreateNewTestStepParameterCommand((ModelElement) step,
                        inputClassifier).run();
                		table.refresh();
            }
        });
        
        /* Image has to be explicitly disposed */
        addButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                addButtonImage.dispose();
            }
        });
        addButton.setToolTipText(ADD_BUTTON_BEGINNING_TEXT + toolTipText);

        
        
         /* Image has to be explicitly disposed */
        addButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                addButtonImage.dispose();
            }
        });
        addButton.setToolTipText(ADD_BUTTON_BEGINNING_TEXT + toolTipText);

        /* Create delete button */
        Button deleteButton = new Button(comp, SWT.PUSH);
        final Image deleteButtonImage = createInputButtonImage(DELETE_BUTTON);
        deleteButton.setImage(deleteButtonImage);
        deleteButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (table != null) {
                    /* Get all selected rows */
                    TableItem[] selectedRows = table.getTable()
                            .getSelection();
                    /*
                     * Get the corresponding parameters and save them in an
                     * array list
                     */
                    ArrayList<ModelElement> testStepParameterToDelete = new ArrayList<ModelElement>();
                   
                    TestCase testCase = (TestCase) getModelElement();
                    TestStep testStep = (TestStep) testCase.getTestStepByIdentifier(stepID);
                    
                    for (int i = 0; i < selectedRows.length; i++) {
                        /*
                         * Get the ID of the test step parameter of the current
                         * row
                         */
                        String parameterID = selectedRows[i].getText(COLUMN_ID);
                        /* Get the parameter with this ID */
                        
                        
                        
                        
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
                        }
                    
                    /* Delete all selected input parameters */
                    new DeleteMultipleMECommand(testStepParameterToDelete)
                            .run();
                    table.refresh();
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
    
    
    private void createOutputButtons(Composite comp, final TestStep step, final TableViewer table, final String stepID) {
        final int outputClassifier;
        String toolTipText = "";
        outputClassifier = TestspecPackage.TEST_STEP_OUTPUT;
        toolTipText = TOOLTIP_TEXT_OUTPUT;
        /* Create add button */
        Button addButton = new Button(comp, SWT.PUSH);
        final Image addButtonImage = createOutputButtonImage(ADD_BUTTON);
        addButton.setImage(addButtonImage);
        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new CreateNewTestStepParameterCommand((ModelElement) step,
                        outputClassifier).run();
                		table.refresh();
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
        Button deleteButton = new Button(comp, SWT.PUSH);
        final Image deleteButtonImage = createOutputButtonImage(DELETE_BUTTON);
        deleteButton.setImage(deleteButtonImage);
        deleteButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (table != null) {
                    /* Get all selected rows */
                    TableItem[] selectedRows = table.getTable()
                            .getSelection();
                    /*
                     * Get the corresponding parameters and save them in an
                     * array list
                     */
                    ArrayList<ModelElement> testStepParameterToDelete = new ArrayList<ModelElement>();
                    
                    TestCase testCase = (TestCase) getModelElement();
                    TestStep testStep = (TestStep) testCase.getTestStepByIdentifier(stepID);
                    
                    
                    
                    for (int i = 0; i < selectedRows.length; i++) {
                        /*
                         * Get the ID of the test step parameter of the current
                         * row
                         */
                        String parameterID = selectedRows[i].getText(COLUMN_ID);
                        /* Get the parameter with this ID */
                        
                              /* Or output parameters? */
                        TestStepOutput selectedOutput = testStep
                                   .getOutputByIdentifier(parameterID);
                            /* Was an output parameter with the given ID found? */
                           testStepParameterToDelete
                                        .add((ModelElement) selectedOutput);
                            }
                        
                    
                    /* Delete all selected input parameters */
                    new DeleteMultipleMECommand(testStepParameterToDelete)
                            .run();
                    table.refresh();
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
        if (feature instanceof EReference) {
            if (((EReference) feature).getName().equals("step") ) {
                return PRIORITY;
            }
        }
        return AbstractMEControl.DO_NOT_RENDER;
    }

    private void createExpandButtons(ToolBar toolbar){
    	/* Expand All Button */
        final ToolItem expandAllButton = new ToolItem(toolbar, SWT.PUSH);
        final Image expandAllImage = org.unicase.ui.common.Activator
                .imageDescriptorFromPlugin("org.unicase.model.testspec.ui", "icons/expand_all.gif")
                .createImage();
     	expandAllButton.addSelectionListener(new SelectionAdapter(){
     		@Override
            public void widgetSelected(SelectionEvent e) {
                for (ExpandItem myItem : itemSet){
                	if (myItem.isDisposed()){
                		continue;
                	}else{
                	myItem.setExpanded(true);
                	}
                }
            }
     	});          
        expandAllButton.setImage(expandAllImage);
        /* Image has to be explicitly disposed */
        expandAllButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                expandAllImage.dispose();
            }
        });
        /* Collapse All Button */
        ToolItem collapseAllButton = new ToolItem(toolbar, SWT.PUSH);
        final Image collapseAllImage = org.unicase.ui.common.Activator
                .imageDescriptorFromPlugin("org.unicase.model.testspec.ui", "icons/collapse_all.gif")
                .createImage();
        collapseAllButton.addSelectionListener(new SelectionAdapter(){
     		@Override
            public void widgetSelected(SelectionEvent e) {
     			 for (ExpandItem myItem : itemSet){
                 	if (myItem.isDisposed()){
                 		continue;
                 	}else{
                 	myItem.setExpanded(false);
                 	}
                 }
            }
     	});      
        collapseAllButton.setImage(collapseAllImage);
        collapseAllButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                collapseAllImage.dispose();
            }
        });        
    }
 
    
    
    /*
     * Create Buttons in the toolbar for adding new testSteps and deleting marked teststeps
     * 
     */
    public void createStepButtons(final ToolBar toolbar, 
    		 final Image deletionImage,
    		final ExpandBar bar, final Composite tableComposite, Section section){
    	
    	
    	
    	ToolItem addButton = new ToolItem(toolbar, SWT.PUSH);
        Image buttonImage = org.unicase.ui.common.Activator
        .imageDescriptorFromPlugin("org.unicase.model.testspec.ui", "icons/TestStep.gif")
        .createImage();
        ImageDescriptor overlay = org.unicase.ui.common.Activator
        .getImageDescriptor("icons/add_overlay.png");
        OverlayImageDescriptor overlayImageDescriptor = new OverlayImageDescriptor(
                buttonImage, overlay,
                OverlayImageDescriptor.LOWER_RIGHT);
        final Image addButtonImage = overlayImageDescriptor.createImage();
        addButton.setImage(addButtonImage);
        addButton.setToolTipText("Delete marked TestSteps");
        
        
        addButton.setImage(addButtonImage);
        addButton.setToolTipText("Create a new TestStep");
        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new CreateNewTestStepCommand(getModelElement()).run();
                
                ModelElement test = getModelElement();
                Set<ModelElement> contained = test.getAllContainedModelElements();
                Set<TestStep> containedStepsNew = new HashSet<TestStep>();   
                for(ModelElement element : contained){
                	if (element instanceof TestStep){
                		
                		containedStepsNew.add((TestStep)element);
                	}
                }
                
                
                HashSet<ExpandItem> tempSet = (HashSet<ExpandItem>) itemSet.clone();
                
                for (ExpandItem item : tempSet){
                	for (ExpandItem item2 : itemSet){
                		if (item2.equals(item)){
                			item2.getControl().dispose();
                			item2.dispose();
                		
                		}
                	}
                		
                		itemSet.remove(item);
                }
                itemSet.clear();
                bar.getShell().layout(true);
                
              
                //Get TestSteps in a sorted order
            	
            	TestCase testCase = (TestCase) getModelElement();
          		Set<ModelElement> containedSteps = testCase.getAllContainedModelElements();
             
                Object[] stepArray = containedSteps.toArray(); 
                Arrays.sort(stepArray, new StepComparator());
                ArrayList<TestStep> stepSet = new ArrayList<TestStep>();       
                for (int i=0; i < stepArray.length; i++) {
                  	Object element = stepArray[i];
                	if (element instanceof TestStep){
                  		TestStep step = (TestStep) element;
                  		stepSet.add(step);
                  	}		        		
            	}
            	
                 
                
                createStepItems(bar, stepSet, tableComposite);
                ScrolledComposite scrolledComposite = (ScrolledComposite) tableComposite.getParent();
                scrolledComposite.setMinHeight(itemHeight * containedSteps.size() + 150);
         
               
            }
        });
        
        
        addButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                addButtonImage.dispose();
                return;
            }
        });
        
        ToolItem deleteButton = new ToolItem(toolbar, SWT.PUSH);
        buttonImage = org.unicase.ui.common.Activator
        .imageDescriptorFromPlugin("org.unicase.model.testspec.ui", "icons/TestStep.gif")
        .createImage();
        overlay = org.unicase.ui.common.Activator
        .getImageDescriptor("icons/delete_overlay.png");
        overlayImageDescriptor = new OverlayImageDescriptor(
                buttonImage, overlay,
                OverlayImageDescriptor.LOWER_RIGHT);
        final Image deleteButtonImage = overlayImageDescriptor.createImage();
        deleteButton.setImage(deleteButtonImage);
        deleteButton.setToolTipText("Delete marked TestSteps");
      
        
        /*
         * The deletebutton searches for all items that have an image and deletes them, 
         *using their ID
         */
        deleteButton.addSelectionListener(new SelectionAdapter() {
        
        	@Override
            public void widgetSelected(SelectionEvent e) {
            	Set<String> markedItemIDs = new HashSet<String>();
            	Set<ExpandItem> markedItems = new HashSet<ExpandItem>();
            	
            	
            	TestCase testCase = (TestCase) getModelElement();
          		Set<ModelElement> containedSteps = testCase.getAllContainedModelElements();
                Object[] stepArray = containedSteps.toArray(); 
                Arrays.sort(stepArray, new StepComparator());
            			
                ArrayList<TestStep> stepSet = new ArrayList<TestStep>();       
                for (Object element : containedSteps) {
                  	if (element instanceof TestStep){
                  		TestStep step = (TestStep) element;
                  		stepSet.add(step);
                  	}		        		
            	}
            	
                Set<TestStep> markedSteps = new HashSet<TestStep>();
                
                HashSet<ExpandItem> tempSet = (HashSet<ExpandItem>) itemSet.clone();
            	
            	for (ExpandItem item : tempSet){
            		
            		if (item.getImage() != null){
            			Object tableInfo =  item.getData();
            	    	String markedID = (String) tableInfo;
            			String stepIdentifier = markedID;
                		
            			String stepName = item.getText().trim();
            			markedItemIDs.add(stepIdentifier);
            			markedItems.add(item);
            			itemSet.remove(item);
            		}      		    			
            	}
            	
                for (TestStep step : stepSet) {
                	String stepID = step.getIdentifier();
                  	for (String ID : markedItemIDs){
                  	
                  		if (stepID.equals(ID)){
                  			markedSteps.add(step);
                  		}
                  	}
                  	
            	}
           
                ArrayList<ModelElement> deletionList = new ArrayList<ModelElement>();
                for (TestStep step : markedSteps){
                	deletionList.add((ModelElement) step);
                }
                
                
                
                new DeleteMultipleMECommand(deletionList)
                .run();
               
                //itemset and linkedsteps must be created anew
                ModelElement test = getModelElement();
             
                
                Set<ModelElement> contained = test.getAllContainedModelElements();
                Set<TestStep> containedStepsNew = new HashSet<TestStep>();   
                for(ModelElement element : contained){
                	if (element instanceof TestStep){
                		
                		containedStepsNew.add((TestStep)element);
                	}
                }
                for (ExpandItem item : markedItems){
                	item.getControl().setVisible(false);
                	item.getControl().dispose();
                	item.setControl(null);
                	item.dispose();
                }
                bar.getShell().layout(true);
        	}
            }
        
        );
        
        
        deleteButton.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                deleteButtonImage.dispose();
                return;
            }
        });
        
        
    }
    
    
    /**
     * Dispose method.
     */
    @Override
    public void dispose() {
      
        super.dispose();
    }
}

