package org.unicase.meeditor.mecontrols;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
//JH: reimplement
public class METextAreaControl extends AbstractMEControl implements MEControl {
	
	EAttribute attribute;
	
	
	IDocument document;
	Section section;
	FormText formatText; 

	public METextAreaControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
		this.toolkit = toolkit;
		this.modelElement = modelElement;
		this.editingDomain = editingDomain;
	}

	public Control createControl(Composite parent, int style) {
		section = toolkit.createSection(parent, Section.DESCRIPTION
				| Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(attribute.getName());
		Composite composite = toolkit.createComposite(section, style);
		composite.setLayout(new GridLayout(2, true));

		TextViewer viewer = new TextViewer(composite, SWT.V_SCROLL
				| SWT.H_SCROLL | SWT.MULTI);
		document = new Document();
		viewer.setEditable(true);
		document.set((String) modelElement.eGet(attribute));
		viewer.setDocument(document);
		StyledText text = viewer.getTextWidget();

		GridData textGridData = new GridData();
		textGridData.heightHint = Display.getCurrent().getBounds().height / 5;
		textGridData.verticalAlignment = SWT.FILL;
		textGridData.horizontalAlignment = SWT.FILL;
		textGridData.grabExcessHorizontalSpace = true;
		textGridData.grabExcessVerticalSpace = true;
		text.setLayoutData(textGridData);
		text.addFocusListener(new FocusListener() {

			public void focusGained(org.eclipse.swt.events.FocusEvent e) {
				// TODO Auto-generated method stub

			}

			public void focusLost(org.eclipse.swt.events.FocusEvent e) {
				modelElement.eSet(attribute, document.get());

			}

		});

		formatText= toolkit.createFormText(composite, true);
		setFormatText();
		
		document.addDocumentListener(new IDocumentListener(){

			public void documentAboutToBeChanged(DocumentEvent event) {
				// TODO Auto-generated method stub
				
			}

			public void documentChanged(DocumentEvent event) {
				setFormatText();
				
			}
			
		});

		section.setClient(composite);
		return section;
	}

	private void setFormatText() {
		try {
			formatText.setText("<root>" + document.get() + "</root>", true, true);
		} catch (Exception e) {
			// JH catch only right Exception
			formatText.setText("<root>Input not valid</root>", false, false);
		}
	}
}
