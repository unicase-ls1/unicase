package org.unicase.docExport.editors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * 
 * @author Sebastian Höcht
 * 
 */
public class TemplateSaveAsDialog extends TitleAreaDialog {

	
	private Text templateName;
	private Template template;
	
	/**
	 * the constructor.
	 * @param parentShell the parent shell object
	 * @param template the template to save
	 */
	public TemplateSaveAsDialog(Shell parentShell, Template template) {
		super(parentShell);
		setHelpAvailable(false);
		setTitle("Enter the name of the new Template");
		this.template = template;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// return super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		parent.setLayout(layout);
		Label label1 = new Label(parent, SWT.None);
		label1.setText("New Template Name");
		templateName = new Text(parent, SWT.BORDER);
		return parent;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(Text templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the templateName
	 */
	public Text getTemplateName() {
		return templateName;
	}	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// Set the title
		setTitle("This is my first own dialog");
		// Set the message
		setMessage("This is a TitleAreaDialog", IMessageProvider.INFORMATION);
		return contents;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		((GridLayout) parent.getLayout()).numColumns++;
		Button button = new Button(parent, SWT.PUSH);
		button.setText("OK");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (templateName.getText().length() != 0) {
					template.setName(templateName.getText());
					try {
						TemplateRegistry.saveTemplate(template);
					} catch (TemplateSaveException e1) {
						WorkspaceUtil.log(
								"could not save the Template",
								e1,
								IStatus.ERROR
							);
					}
					close();
				} else {
					setErrorMessage("Please maintain the last name");
				}
			}
		});
	}

	/**
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}


}
