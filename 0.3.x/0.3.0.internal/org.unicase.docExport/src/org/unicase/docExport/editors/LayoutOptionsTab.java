package org.unicase.docExport.editors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class LayoutOptionsTab extends TemplateEditorTab {

	private CTabFolder subTabFolder;
	
	private Composite generalOptions;
	private Composite sectionOptions;
	private Composite logoOptions;
	
	private AttributeOptionFactory factory = new AttributeOptionFactory();

	/**
	 * 
	 * @param parent the parent SWT composite
	 * @param style the SWT style
	 * @param tabFolder the tabItem is contained
	 * @param template the Template containing some LayoutOptions
	 */
	public LayoutOptionsTab(Composite parent, int style, CTabFolder tabFolder, Template template) {
		super(parent, style, tabFolder, template);
		
		setContainerTab(new Composite(parent, SWT.FILL));
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		getContainerTab().setLayout(gLayout);
		getContainerTab().setLayoutData(gData);

		subTabFolder = new CTabFolder(getContainerTab(), SWT.NONE | SWT.BORDER);
		GridLayout layout = new GridLayout();
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.grabExcessHorizontalSpace = true;
		subTabFolder.setLayout(layout);
		subTabFolder.setLayoutData(layoutData);
		
		generalOptions = createTab("General");
		sectionOptions = createTab("Sections");
		logoOptions = createTab("Logo");
		
		buildLogoOptions(template);
		buildSectionOptions(template.getLayoutOptions());

		factory.buildOptionsFormular(generalOptions, template.getLayoutOptions());	
		
		setFocus();
		
		layoutAndPack();
	}

	private void buildLogoOptions(final Template template) {
		final Browser browser = new Browser(logoOptions, SWT.NONE);
		browser.setSize(400, 400);
		
		if (template.getLogoImage() != null && !template.getLogoImage().equals("")) {
			browser.setText("<img src=\"" + TemplateRegistry.TEMPLATE_IMAGE_FOLDER + template.getLogoImage() + "\" />");
		}
		Button selectImage = new Button(logoOptions, SWT.PUSH);
		selectImage.setText("select logo");
		selectImage.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.OPEN);
				dialog.setText("select a logo image");
				dialog.setFilterExtensions(new String[]{"*.*", "*.jpg", "*.gif", "*.png", "*.svg"});
				String image = dialog.open();
				
				if (image != null) {
					Path imagePath = new Path(image);
					File imageFile = new File(image);
					File targetFile = new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER + template.getName() + "." + imagePath.getFileExtension());
					File imageFolder = new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER);
					imageFolder.mkdirs();
					copyFile(imageFile, targetFile);
					template.setLogoImage(template.getName() + "." + imagePath.getFileExtension());
					
					browser.setText("<img src=\"" + TemplateRegistry.TEMPLATE_IMAGE_FOLDER + template.getLogoImage() + "\" />");
				}
			}
		});
		

	}

	private void buildSectionOptions(final LayoutOptions layoutOptions) {
//		layoutOptions.getSectionOption().setName("test");
		factory.buildOptionsFormular(sectionOptions, layoutOptions.getSectionOption());
		
		Composite container2 = createContainer(sectionOptions);
		new Label(container2, SWT.NONE).setText("font size step");
		Combo fontSizeStep = new Combo(container2, SWT.READ_ONLY);
		for (int i = 0; i < 5; i++) {
			fontSizeStep.add(String.valueOf(i), i);
		}
		fontSizeStep.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				layoutOptions.setSectionFontSizeDecreaseStep(((Combo) e.widget).getSelectionIndex());
			}	
		});
		fontSizeStep.select(layoutOptions.getSectionFontSizeDecreaseStep());
		
	}

	private Composite createTab(String text) {
		CTabItem tabItem1 = new CTabItem(subTabFolder, SWT.BOTTOM);
		tabItem1.setText(text);
		Composite composite = new Composite(subTabFolder, SWT.FILL);
		GridLayout layout1 = new GridLayout();
		GridData data1 = new GridData(GridData.FILL_HORIZONTAL);
		data1.grabExcessHorizontalSpace = true;
		composite.setLayout(layout1);
		composite.setLayoutData(data1);
		tabItem1.setControl(composite);	 
		
		return composite;
	}
	
	private Composite createContainer(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gLayout = new GridLayout();
		GridData gData = new GridData();
		container.setLayout(gLayout);
		container.setLayoutData(gData);
		gLayout.numColumns = 2;
		
		return container;
	}
	
	/**
	 * Java File handling is bad...
	 * @param in File which shall be copied
	 * @param out target file
	 */
	public static void copyFile(File in, File out) {
		try {
			FileInputStream fis = new FileInputStream(in);
			FileOutputStream fos = new FileOutputStream(out);
			try {
				byte[] buf = new byte[1024];
				int i = 0;
				while ((i = fis.read(buf)) != -1) {
					fos.write(buf, 0, i);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			finally {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
