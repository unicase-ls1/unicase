package org.unicase.docExport.views;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.unicase.docExport.editors.AttributeOptionFactory;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;

/**
 * @author Sebastian Höcht
 */
public final class GlobalAttributeTypeOptions {

	private static Composite attributeType;
	private static Composite attributeTypeOptions;
	private static Template template;

	private GlobalAttributeTypeOptions() {

	}

	/**
	 * @param parent the SWT parent
	 * @param template the template
	 */
	public static void build(Composite parent, Template template) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gLayout2 = new GridLayout();
		gLayout2.numColumns = 2;
		gLayout2.makeColumnsEqualWidth = false;
		composite.setLayout(gLayout2);
		GridData gdata2 = new GridData();
		composite.setLayoutData(gdata2);

		GlobalAttributeTypeOptions.template = template;

		cleanTabContainers(composite);

		ArrayList<AttributeOption> globalOptions = new ArrayList<AttributeOption>();
		globalOptions.addAll(template.getGlobalRendererOptions());
		createAttributeTypes(globalOptions);

		layoutTabs();
	}

	private static void createAttributeTypes(ArrayList<AttributeOption> globalOptions) {
		List l = new List(attributeType, SWT.BORDER);
		for (int i = 0; i < globalOptions.size(); i++) {
			l.add(globalOptions.get(i).getName(), i);
		}

		l.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

			public void widgetSelected(SelectionEvent arg0) {
				createAttributeTypeOptions(((List) arg0.widget).getSelectionIndices()[0]);
			}
		});

		l.select(0);
		createAttributeTypeOptions(0);

		layoutTabs();
	}

	private static void createAttributeTypeOptions(int index) {
		cleanAttributeTypeOptionsContainer(attributeTypeOptions.getParent());

		AttributeOptionFactory.buildOptionsFormular(attributeTypeOptions, template.getGlobalRendererOptions()
			.get(index));

		layoutTabs();
	}

	private static void cleanTabContainers(Composite parent) {
		cleanAttributeTypeContainer(parent);
		cleanAttributeTypeOptionsContainer(parent);
	}

	private static void cleanAttributeTypeContainer(Composite parent) {
		if (attributeType != null) {
			attributeType.dispose();
		}
		attributeType = new Composite(parent, SWT.FILL | SWT.BORDER);
		attributeType.setLayout(new GridLayout());
		attributeType.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	private static void cleanAttributeTypeOptionsContainer(Composite parent) {
		if (attributeTypeOptions != null) {
			attributeTypeOptions.dispose();
		}
		attributeTypeOptions = new Composite(parent, SWT.FILL | SWT.BORDER);
		attributeTypeOptions.setLayout(new GridLayout(2, false));
		attributeTypeOptions.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	private static void layoutTabs() {
		attributeTypeOptions.pack();
		attributeTypeOptions.getParent().pack();
		attributeTypeOptions.getParent().getParent().pack();
		attributeType.getParent().layout(true, true);
		attributeTypeOptions.getParent().layout(true, true);
	}

}
