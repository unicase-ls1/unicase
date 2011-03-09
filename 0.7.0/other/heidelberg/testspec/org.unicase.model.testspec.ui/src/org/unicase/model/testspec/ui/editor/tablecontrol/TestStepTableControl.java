package org.unicase.model.testspec.ui.editor.tablecontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
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
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.testspec.TestCase;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecPackage;
import org.unicase.model.testspec.ui.editor.commands.ChangeTextCommand;
import org.unicase.model.testspec.ui.editor.commands.ChangeValueCommand;
import org.unicase.model.testspec.ui.editor.tableprovider.TestProtocolTableContentProvider;
import org.unicase.model.testspec.ui.editor.tableprovider.TestProtocolTableLabelProvider;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * Control for the test steps in the test protocol view.
 * 
 * @author chen
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
 
    /**
     * Column constant titles.
     */
    private static final String COLUMN_TITLE_ID = "ID";
    private static final String[] VISIBLE_COLUMN_TITLES = { "Name", "Type",
            "Range", "Value" };
  
    
    /**
     * Constant table column index.
     */
    private final int COLUMN_VALUE = 3;
    private final int COLUMN_ID = 4;

    /**
     * Column width.
     */
    private static final int[] COLUMN_WIDTH = { 107, 102, 102, 102 };
    /**
     * Button image.
     */
    public static final String PLUGIN_ID = "org.unicase.model.testspec.ui";
    public static final String COLLAPSE_PATH = "icons/collapse_all.gif";
    public static final String EXPAND_PATH = "icons/expand_all.gif";

    private IItemPropertyDescriptor descriptor;
    private ModelElementChangeListener modelElementChangeListener;

    private TableViewer parameterTable;
    private HashSet<ExpandItem> itemSet;
    private Set<TableViewer> tableSet;
    private int itemHeight = 0;
    
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
       
        section.setTextClient(toolbar);
        section.setText(descriptor.getDisplayName(getModelElement()));
        

        /*
         * Create composite which will be scrollable so that only a maximum of
         * 10 items in the tree can be shown and the remaining can be shown by
         * scrolling
         */
        ScrolledComposite scrolledComposite = new ScrolledComposite(section,
                SWT.V_SCROLL | SWT.H_SCROLL);
        
        
        Composite tableComposite = getToolkit().createComposite(
                scrolledComposite);
        tableComposite.setLayout(new FillLayout());
        tableComposite.setBounds(scrolledComposite.getBounds());
        
        Composite test = new Composite(scrolledComposite, SWT.NONE);
        
        scrolledComposite.setBackground(null);

        /*Create an ExpandBar with Tables for every linked TestStep*/
        ExpandBar bar = new ExpandBar(tableComposite, SWT.NONE);
        bar.setBackground(tableComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));


        TestProtocol testProt = (TestProtocol) getModelElement();
  		Set<ModelElement> linkedElements = testProt.getLinkedModelElements();
     
  		TestCase linkedTestCase = null;;
  		/*get the linked TestCase (there can be only one)*/
  		for (ModelElement me : linkedElements){
  			if (me instanceof TestCase){
  				linkedTestCase = (TestCase) me;
  			}
  		}
  		
  		Set<TestStep> containedSteps = new HashSet<TestStep>();   

  		if (linkedTestCase != null){
  			Set<ModelElement> containedInCase = linkedTestCase.getAllContainedModelElements();         
         for(ModelElement element : containedInCase){
         	if (element instanceof TestStep){
         		
         		containedSteps.add((TestStep)element);
         	}
         }
  		}
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
        createExpandButtons(toolbar);       

   
        
   
        scrolledComposite.setContent(tableComposite);
         scrolledComposite.setExpandVertical(true); 
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setMinSize(tableComposite.computeSize(SWT.DEFAULT,
                SWT.DEFAULT));
        
        scrolledComposite.getVerticalBar();
        int minHeight = stepList.size() * itemHeight;
        scrolledComposite.setMinHeight(minHeight + 150);
       
        
        
        section.setClient(scrolledComposite);

        /* Create listener that observes changes in relevant elements */
        createChangeListener(bar, tableComposite);

        
        return section;
    }

    /*
     * Create an ExpandItem for every linked TestStep
     *  
     */
    public void createStepItems(ExpandBar bar, ArrayList<TestStep> linkedSteps,
    		Composite tableComposite ){
    		itemSet = new HashSet<ExpandItem>();
    		tableSet = new HashSet<TableViewer>();
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
    		
        	int textHeight = 60;
        	GridData descTextData = new GridData();
    		descTextData.grabExcessHorizontalSpace = true;
    		descTextData.grabExcessVerticalSpace = true;
        	descTextData.horizontalAlignment = GridData.FILL;
        	descTextData.horizontalSpan = 2;
        	descTextData.heightHint = textHeight;

        	final Text descriptionText = new Text(newTableComposite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
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

            descriptionText.setLayoutData(descTextData);
            descriptionText.setEditable(false);
            descriptionText.setBackground(descriptionText.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        	
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
    		
    		Label inputLabel = new Label(inputComposite, SWT.LEFT);
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
        	
    		
    		final ExpandItem item0 = new ExpandItem(bar, SWT.FILL, 0); 
        	createInputTable(inputComposite, step);
         	Label outputLabel = new Label(outputComposite, SWT.LEFT);
      	    outputLabel.setText("Expected Output");
        	createOutputTable(outputComposite, step);
           

            final Text actOutputText = new Text(newTableComposite,  SWT.BORDER | SWT.WRAP | SWT.MULTI);
    		actOutputText.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    /* Nothing to do */
                }

                public void focusLost(FocusEvent e) {
                    new ChangeTextCommand(step, actOutputText.getText(), 3).run();
                    
                    
                }
            });
            
    		actOutputText.setEditable(false);
    		actOutputText.setBackground(actOutputText.getDisplay().getSystemColor(SWT.COLOR_WHITE));
            if (step.getException()!= null){
            	actOutputText.setText(step.getException().toString());
            
            } else {
            actOutputText.setText("Actual Output");
            }
       
    		GridData actTextData = new GridData();
    		actTextData.grabExcessHorizontalSpace = true;
        	actTextData.horizontalAlignment = GridData.FILL;
        	actTextData.heightHint = textHeight;
        	actTextData.horizontalSpan = 2;
        	actOutputText.setLayoutData(actTextData);
    		
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
                | SWT.FULL_SELECTION | SWT.V_SCROLL);
        Table table = parameterTable.getTable();
        tableSet.add(parameterTable);
        /* Set maximum height of the table to 10 rows */
        
        
        GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
        data.heightHint = 10 * table.getItemHeight() + 10;
        
        
        table.setLayoutData(data);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        createColumns(inputComposite, parameterTable);
        /* Set provider of the table viewer */
        parameterTable
                .setContentProvider(new TestProtocolTableContentProvider());
        parameterTable
                .setLabelProvider(new TestProtocolTableLabelProvider());
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
        tableSet.add(parameterTable);
        /* Set maximum height of the table to 10 rows */
        
        
        GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
        data.heightHint = 10 * table.getItemHeight() + 10;
        
        
        table.setLayoutData(data);
        /* Table header and lines shall be visible */
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        /* Create columns */
        createColumns(outputComposite, parameterTable);
        /* Set provider of the table viewer */
        parameterTable
                .setContentProvider(new TestProtocolTableContentProvider());
        parameterTable
                .setLabelProvider(new TestProtocolTableLabelProvider());
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
                         /* Only the value column is editable */
                        if (tempColumn == COLUMN_VALUE) {
                        	 editor.setEditor(text, tableItem, tempColumn);
                             
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
    		
    	TestCase testCase = ((TestProtocol) getModelElement()).getTestCase();
    	TestStep step = testCase.getTestStepByIdentifier(stepInfo[0]);
    	
    	
    		
        if (stepInfo[1].equals("input")) {
        
        	TestStepInput changedInput = ((TestStepInput) step.getInputByIdentifier(tableItem.getText(COLUMN_ID)));
            /*
             * Was an input parameter with the given ID found?
             */
            if (changedInput != null) {
                new ChangeValueCommand(changedInput, tableItem
                        .getText(columnIndex), null).run();
            }
            /* Or an output parameter ? */
        } else if (stepInfo[1].equals("output")) {
        	TestStepOutput changedOutput = ((TestStepOutput) step.getOutputByIdentifier(tableItem.getText(COLUMN_ID)));
            /*
             * Was an output parameter with the given ID found?
             */
            if (changedOutput != null) {
                new ChangeValueCommand(changedOutput, tableItem
                        .getText(columnIndex), null).run();
            }
        }
    }
    
 
    /**
     * Creates the columns in the dynamic table.
     * 
     */
    private void createColumns(final Composite paramComp, TableViewer parameterTable){
    	
    	final Table table = parameterTable.getTable();
    	final Set<TableViewerColumn> columnSet = new HashSet<TableViewerColumn>();
    	
    	/* Columns for name, type and range */
        for (int i = 0; i < VISIBLE_COLUMN_TITLES.length; i++) {
            TableViewerColumn column = new TableViewerColumn(parameterTable,
                    SWT.NONE);
            column.getColumn().setText(VISIBLE_COLUMN_TITLES[i]);
            column.getColumn().setMoveable(false);
            column.getColumn().setResizable(true);
            column.getColumn().setWidth(COLUMN_WIDTH[i]);
            columnSet.add(column);

        }
        
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
       	    		  column.getColumn().setWidth((width/4));
					}
       	        
       	        
       	        table.setSize(area.width, area.height);
       	      } else {
       	        table.setSize(area.width, area.height);
     	    	  for (TableViewerColumn column : columnSet) {
   	    		  column.getColumn().setWidth((width/4));
				}
       	      }
       	    }
       	  });
        
        /*Hidden column for the ID of the test step parameter */
        TableViewerColumn hiddenColumn = new TableViewerColumn(parameterTable,
                SWT.NONE);
        hiddenColumn.getColumn().setText(COLUMN_TITLE_ID);
        hiddenColumn.getColumn().setMoveable(false);
        hiddenColumn.getColumn().setResizable(false);
        hiddenColumn.getColumn().setWidth(0);
    
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
    
    
    
    
    
    
  

    public void createChangeListener(final ExpandBar bar, final Composite tableComposite) {
       modelElementChangeListener = new ModelElementChangeListener() {
            public void onChange(Notification notification) {
               if ((notification.getNotifier() instanceof TestStepInput || notification
                        .getNotifier() instanceof TestStepOutput)
                        && notification.getEventType() == Notification.SET) {
                 
            	   for (TableViewer table : tableSet){
                	   table.refresh();
                   }
            		   
                }
          
                if (notification.getNotifier() instanceof TestStep) {
                    int eventType = notification.getEventType();
                    if (eventType == Notification.SET) {
                    	
                    	if (notification.getFeatureID(TestStep.class) == TestspecPackage.TEST_STEP__NAME) {
                   
                        	clearStepItems(bar);
                            TestCase testCase = getLinkedTestCase();
                            Set<TestStep> containedSteps = getContainedSteps(testCase);       
                            ArrayList<TestStep> stepList = sortSteps(containedSteps);
                            createStepItems(bar, stepList, tableComposite);
                          
                         }
                    	
                    	
                    	
                    	if (notification.getFeatureID(TestStep.class) == TestspecPackage.TEST_STEP__DESCRIPTION) {
                            
                        	clearStepItems(bar);
                            TestCase testCase = getLinkedTestCase();
                            Set<TestStep> containedSteps = getContainedSteps(testCase);       
                            ArrayList<TestStep> stepList = sortSteps(containedSteps);
                            createStepItems(bar, stepList, tableComposite);
                            
                         }
                    	
                    }
                
                    if (eventType == Notification.ADD) {
                    	 for (TableViewer table : tableSet){
                       	   table.refresh();
                          }
                      	clearStepItems(bar);
                        TestCase testCase = getLinkedTestCase();
                        Set<TestStep> containedSteps = getContainedSteps(testCase);       
                        ArrayList<TestStep> stepList = sortSteps(containedSteps);
                        createStepItems(bar, stepList, tableComposite);
               
                        Object newValue = notification.getNewValue();
                        if (newValue != null
                                && (newValue instanceof TestStepInput || newValue instanceof TestStepOutput)) {
                            ((ModelElement) newValue)
                                    .addModelElementChangeListener(this);
                        }
                    }
                    if (eventType == Notification.REMOVE
                            || eventType == Notification.REMOVE_MANY) {
                     	
                 
                    	 for (TableViewer table : tableSet){
                       	   table.refresh();
                          }
                    	 clearStepItems(bar);
                    	 TestCase testCase = getLinkedTestCase();
                         Set<TestStep> containedSteps = getContainedSteps(testCase);       
                         ArrayList<TestStep> stepList = sortSteps(containedSteps);
                         createStepItems(bar, stepList, tableComposite);
                    	 
                         
                         Object oldValue = notification.getOldValue();
                        if (oldValue != null
                                && (oldValue instanceof TestStepInput || oldValue instanceof TestStepOutput)) {
                            ((ModelElement) oldValue)
                                    .removeModelElementChangeListener(this);
                        }
                    }
                }
                if (notification.getNotifier() instanceof TestCase) {
                    int eventType = notification.getEventType();
                   
                    if (eventType == Notification.ADD
                            || eventType == Notification.ADD_MANY) {
                        for (TableViewer table : tableSet){
                     	   table.refresh();
                        }
                    	clearStepItems(bar);
                        TestCase testCase = getLinkedTestCase();
                        Set<TestStep> containedSteps = getContainedSteps(testCase);       
                        ArrayList<TestStep> stepList = sortSteps(containedSteps);
                        createStepItems(bar, stepList, tableComposite);
                        
                        
                        
                        
                        
                        Object newValue = notification.getNewValue();
                        if (newValue != null && newValue instanceof TestStep) {
                            ((TestStep) newValue)
                                    .addModelElementChangeListener(this);
                     
                            TestStepInput[] testStepInput = (TestStepInput[]) ((TestStep) newValue)
                                    .getInput().toArray();
                            for (int i = 0; i < testStepInput.length; i++) {
                                testStepInput[i]
                                        .addModelElementChangeListener(this);
                            }
                       
                            TestStepOutput[] testStepOutput = (TestStepOutput[]) ((TestStep) newValue)
                                    .getOutput().toArray();
                            for (int j = 0; j < testStepOutput.length; j++) {
                                testStepOutput[j]
                                        .addModelElementChangeListener(this);
                            }
                        }
                     
                    } else if (eventType == Notification.REMOVE
                            || eventType == Notification.REMOVE_MANY) {
                    
                    	for (TableViewer table : tableSet){
                      	   table.refresh();
                    	}
                    	
                      	clearStepItems(bar);
                        TestCase testCase = getLinkedTestCase();
                        Set<TestStep> containedSteps = getContainedSteps(testCase);       
                        ArrayList<TestStep> stepList = sortSteps(containedSteps);
                        createStepItems(bar, stepList, tableComposite);
                            
                    	 
                    	 
                        Object oldValue = notification.getOldValue();
                        if (oldValue != null && oldValue instanceof TestStep) {
                            ((ModelElement) oldValue)
                                    .removeModelElementChangeListener(this);
                               TestStepInput[] testStepInput = (TestStepInput[]) ((TestStep) oldValue)
                                    .getInput().toArray();
                            for (int i = 0; i < testStepInput.length; i++) {
                                testStepInput[i]
                                        .removeModelElementChangeListener(this);
                            }
                             TestStepOutput[] testStepOutput = (TestStepOutput[]) ((TestStep) oldValue)
                                    .getOutput().toArray();
                            for (int j = 0; j < testStepOutput.length; j++) {
                                testStepOutput[j]
                                        .removeModelElementChangeListener(this);
                            }
                        }
                    }
                }
                
                if (notification.getNotifier() instanceof TestProtocol) {
                    switch (notification.getEventType()) {
                    case Notification.SET:
                        if (notification.getFeatureID(TestProtocol.class) == TestspecPackage.TEST_PROTOCOL__TEST_CASE) {
                        	clearStepItems(bar);
                            TestCase testCase = getLinkedTestCase();
                            Set<TestStep> containedSteps = getContainedSteps(testCase);       
                            ArrayList<TestStep> stepList = sortSteps(containedSteps);
                            createStepItems(bar, stepList, tableComposite);
                            ScrolledComposite scrolledComposite = (ScrolledComposite) tableComposite.getParent();
                            scrolledComposite.setMinHeight(itemHeight * stepList.size() + 150);
                           
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
                   }
        };
        getModelElement().addModelElementChangeListener(
                modelElementChangeListener);
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
    
    
    //Get the linked TestCase of a TestProtocol
    public TestCase getLinkedTestCase(){
    	TestProtocol testProt = (TestProtocol) getModelElement();
   		Set<ModelElement> linkedElements = testProt.getLinkedModelElements();
      
   		TestCase linkedTestCase = null;;
   		/*get the linked TestCase (there can be only one)*/
   		for (ModelElement me : linkedElements){
   			if (me instanceof TestCase){
   				linkedTestCase = (TestCase) me;
   			}
   		}
   		
    	return linkedTestCase;
    }
    
    //get the contained TestSteps of a TestCase
    public Set<TestStep> getContainedSteps(TestCase testCase){
    	Set<TestStep> containedSteps = new HashSet<TestStep>();   

   		if (testCase != null){
   			Set<ModelElement> containedInCase = testCase.getAllContainedModelElements();         
          for(ModelElement element : containedInCase){
          	if (element instanceof TestStep){
          		
          		containedSteps.add((TestStep)element);
           	}
          }
   		}
    	
    	
    	return containedSteps;
    }
    
    //sort the Steps
    public ArrayList<TestStep> sortSteps(Set<TestStep> containedSteps){
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
    	return stepList;  
    }
    
    //clears all expandItems in the expandbar
    public void clearStepItems(ExpandBar bar){
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
     * Focus on dynamic table.
     */
    public void setFocus() {
        parameterTable.getControl().setFocus();
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
        super.dispose();
    }
}
