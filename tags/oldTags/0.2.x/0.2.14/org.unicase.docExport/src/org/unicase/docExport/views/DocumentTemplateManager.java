package org.unicase.docExport.views;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exceptions.TemplateNotFoundException;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.Template;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class DocumentTemplateManager extends ViewPart {
	private TabFolder tabFolder;
	private Combo templateSelect;
	private Composite tabContainer1;
	private Composite tabContainer2;
	private Composite tabContainer3;
	private Composite tabContainer;
	private Composite container;
	private ScrolledComposite sc1;
	
	private Template template;
	private ArrayList<Template> templateList = new ArrayList<Template>();

	
	/**.
	 * constructor
	 */
	public DocumentTemplateManager() {
		 template = TemplateRegistry.getTemplate();
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		this.template = TemplateRegistry.getTemplate();
		getPossibleTemplates();
		
	    sc1 = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
	    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
	    sc1.setLayoutData(gridData);
	    
	    //Container for everything!
	    container = new Composite(sc1, SWT.FILL);
		GridLayout gLayout1 = new GridLayout();
		container.setLayout(gLayout1);
		GridData gdata1 = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gdata1);
		
		//container for the template selector and some buttons
		Composite composite = new Composite(container, SWT.FILL);
		GridLayout gLayout2 = new GridLayout();
		gLayout2.numColumns = 5;
		composite.setLayout(gLayout2);
		GridData gdata2 = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(gdata2);
	
		
		new Label(composite, SWT.LEFT).setText("Template");
		templateSelect = new Combo(composite, SWT.READ_ONLY);
		setTemplates();

		
		
		Button saveButton = new Button(composite, SWT.PUSH);
		saveButton.setText("save");
		
		saveButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent arg0) {	
				try {
					TemplateRegistry.saveTemplate(template);
				} catch (TemplateSaveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		Button saveAsButton = new Button(composite, SWT.PUSH);
		saveAsButton.setText("save as");
		saveAsButton.addSelectionListener(new SaveAsButtonSelectionListener());
		
		final Button refreshButton = new Button(composite, SWT.PUSH);
		refreshButton.setText("refresh");
		refreshButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent e) {
				setTemplates();
			}
		});
		
		//container f�r all tabs
		tabContainer = new Composite(container, SWT.FILL);
		GridLayout gLayout3 = new GridLayout();
		gLayout3.numColumns = 1;
		GridData gData3 = new GridData(GridData.FILL_HORIZONTAL);
		gData3.grabExcessHorizontalSpace = true;
		tabContainer.setLayout(gLayout3);
		tabContainer.setLayoutData(gData3);	
		
		createTabs(tabContainer);
		
		templateSelect.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent event) {
				Combo combo = (Combo)event.widget;

				String templateName = templateList.get(combo.getSelectionIndex()).getName();
				try {
					template = TemplateRegistry.loadTemplate(templateName);
					
					createTemplateOptions(template);
					createAttributeTypeOptions(template);
					createLayoutOptions(template);
				} catch (TemplateNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		});
		templateSelect.select(0);
		
		createTemplateOptions(template);
		createAttributeTypeOptions(template);
		createLayoutOptions(template);
		
		
		
		sc1.setContent(container);
		sc1.setExpandHorizontal(true);
		sc1.setExpandVertical(true);
		sc1.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	}
	
	
	
	private void setTemplates() {
		for (int i = 0; i < templateSelect.getItemCount(); i++) {
			templateSelect.remove(i);
		}
		
		
		int i = 0;
		while (i < templateList.size()) {
			templateSelect.add(templateList.get(i).getName(), i);
			i++;
		}

		templateSelect.select(0);
	}

	private void getPossibleTemplates()  {
		try {
			for (Template template : TemplateRegistry.getAllTemplates()) {
				templateList .add(template);
			}
		} catch (TemplateSaveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createTabs(Composite parent) {
		tabFolder = new TabFolder(parent, SWT.LEAD);
		GridLayout gLayout3 = new GridLayout();
		gLayout3.numColumns = 1;
		GridData gData3 = new GridData(GridData.FILL_HORIZONTAL);
		gData3.grabExcessHorizontalSpace = true;
		tabFolder.setLayout(gLayout3);
		tabFolder.setLayoutData(gData3);	
		
		cleanTabContainers(
				createTabItem("Renderer Options"),
				createTabItem("Global attribute type options"),
				createTabItem("Layout options")
		);
		createTabItem("Preview");
	}
	
	private Composite createTabItem(String text) {
		TabItem tabItem = new TabItem(tabFolder, SWT.None);
		tabItem.setText(text);
		Composite composite = new Composite(tabFolder, SWT.FILL);
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.grabExcessHorizontalSpace = true;
		composite.setLayout(gLayout);
		composite.setLayoutData(gData);
		tabItem.setControl(composite);	
		
		return composite;
	}
	
	private void createTemplateOptions(Template template) {
		cleanTab1(tabContainer1.getParent());
		new RendererOptionsTab(tabContainer1, template);
		layoutTabs();
	}
	
	private void createAttributeTypeOptions(Template template)  {
		cleanTab2(tabContainer2.getParent());
		new GlobalAttributeTypeOptions(tabContainer2, template);
		layoutTabs();	
	}
	
	private void createLayoutOptions(Template template) {
		cleanTab3(tabContainer3.getParent());
		new LayoutOptionsTab(tabContainer3, template);
		layoutTabs();	
	}

	private void cleanTab1(Composite parent) {
		if (tabContainer1 != null) {
			tabContainer1.dispose();
		}
		tabContainer1 = new Composite(parent, SWT.FILL);
		tabContainer1.setLayout(new GridLayout());
		tabContainer1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}
	
	private void cleanTab2(Composite parent) {
		if (tabContainer2!= null) {
			tabContainer2.dispose();
		}
		tabContainer2 = new Composite(parent, SWT.FILL);
		tabContainer2.setLayout(new GridLayout());
		tabContainer2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}
	
	private void cleanTab3(Composite parent) {
		if (tabContainer3 != null) {
			tabContainer3.dispose();
		}
		tabContainer3 = new Composite(parent, SWT.FILL);
		tabContainer3.setLayout(new GridLayout());
		tabContainer3.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}
	
	private void cleanTabContainers(Composite parent1, Composite parent2, Composite parent3) {		
		cleanTab1(parent1);
		cleanTab2(parent2);
		cleanTab3(parent3);
	}
	
	private void layoutTabs() {
		tabContainer1.getParent().layout(true, true);
		tabContainer2.getParent().layout(true, true);
		tabContainer3.getParent().layout(true, true);
		
		tabFolder.layout(true, true);
		tabContainer.layout(true, true);
		container.layout(true, true);
		sc1.layout(true, true);
	}
	

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		sc1.setFocus();
	}
	
	
	/**
	 *
	 */
	class SaveAsButtonSelectionListener implements SelectionListener {
		
		/**
		 * unused.
		 * @param event the selection event
		 */
		public void widgetDefaultSelected(SelectionEvent event) {
		}

		/**
		 * default selection event.
		 * @param event the selection event
		 */
		public void widgetSelected(SelectionEvent event) {
			Button button = (Button)event.widget;	
			
			final Shell child = new Shell(button.getShell());
			child.setText("new template name");
			
		    final Text name = new Text(child, SWT.CENTER);
		    name.setText("newTemplateName");
		    name.setBounds(10, 10, 100, 20);
			
			
			Button okButton = new Button(child, SWT.PUSH);
			okButton.setText("ok");
			okButton.setBounds(40, 30, 20, 20);
			okButton.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					template.setName(name.getText());
					try {
						TemplateRegistry.saveTemplate(template);
					} catch (TemplateSaveException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					child.dispose();
				}
			});
			
			child.open();
		}
	}
}