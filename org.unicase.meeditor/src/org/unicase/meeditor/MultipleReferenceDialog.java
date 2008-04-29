package org.unicase.meeditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class MultipleReferenceDialog extends Dialog {
	FormToolkit toolkit;
	EList<EObject> oldValue;
	Project project;
	Class<? extends EObject> type;
	TableViewer rightViewer;
	Table rightTable;
	EObject modelelement;
	List<EObject> result = new ArrayList<EObject>();

	public MultipleReferenceDialog(Shell parent, FormToolkit toolkit,
			EList<EObject> oldValue, Project project,
			Class<? extends EObject> type, EObject modelelement) {
		super(parent);
		this.toolkit = toolkit;
		this.oldValue = oldValue;
		this.project = project;
		this.type = type;
		this.modelelement= modelelement;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = toolkit.createComposite(parent);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayout(new GridLayout(3, false));
		composite.setLayoutData(gridData);

		final Table leftTable = toolkit.createTable(composite, SWT.MULTI
				| SWT.BORDER);

		GridData choiceTableGridData = new GridData();
		choiceTableGridData.widthHint = Display.getCurrent().getBounds().width / 7;
		choiceTableGridData.heightHint = Display.getCurrent().getBounds().height / 3;
		choiceTableGridData.verticalAlignment = SWT.FILL;
		choiceTableGridData.horizontalAlignment = SWT.FILL;
		choiceTableGridData.grabExcessHorizontalSpace = true;
		choiceTableGridData.grabExcessVerticalSpace = true;
		leftTable.setLayoutData(choiceTableGridData);

		final TableViewer leftViewer = new TableViewer(leftTable);
		Collection<ModelElement> possibleValues = project.getElementsByClass(type);
		//JH add access to stub
		if(possibleValues.contains(modelelement)){
			possibleValues.remove(modelelement);
		}
		for (EObject object : oldValue) {
			if (possibleValues.contains(object)) {
				possibleValues.remove(object);
			}
		}
		//JH Use Contenprovider instead of array and use a ArrayList
		leftViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ModelItemProviderAdapterFactory()));
		leftViewer.add(possibleValues.toArray());

		Composite buttonArea = toolkit.createComposite(composite);
		buttonArea.setLayout(new GridLayout(1,false));
		Button addButton = toolkit.createButton(buttonArea, "Add", SWT.WRAP);
		Button removeButton = toolkit.createButton(buttonArea, "Remove", SWT.WRAP);

		rightTable = toolkit.createTable(composite, SWT.MULTI
				| SWT.BORDER);
		rightTable.setLayoutData(choiceTableGridData);
		rightViewer = new TableViewer(rightTable);
		rightViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ModelItemProviderAdapterFactory()));
		rightViewer.add(oldValue.toArray());
		

		addButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) leftViewer
						.getSelection();
				for (Iterator<?> i = selection.iterator(); i.hasNext();) {
					Object value = i.next();
					rightViewer.add(value);
					leftViewer.remove(value);
					rightViewer.setSelection(selection);
				}

			}

		});
		
		removeButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) rightViewer
						.getSelection();
				for (Iterator<?> i = selection.iterator(); i.hasNext();) {
					Object value = i.next();
					leftViewer.add(value);
					rightViewer.remove(value);
					leftViewer.setSelection(selection);
				}

			}

		});

		return composite;
	}

	public List<EObject> getResult() {
		return result;
	}

	@Override
	protected void okPressed() {
		result.removeAll(result);
		int length = rightTable.getItems().length;
		for(int i=0;i<length;i++){
			result.add((EObject)rightViewer.getElementAt(i));
		};
		super.okPressed();
	}
	

}
