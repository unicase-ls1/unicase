package org.unicase.mergetest.merge.ui.widgets;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.util.DecisionUtil;
import org.unicase.metamodel.ModelElement;

public class OtherInvolvedWidget extends Composite {

	private static final int COLUMNS = 4;

	public OtherInvolvedWidget(Composite client,
			DecisionManager decisionManager, ConflictOption option) {
		super(client, SWT.None);
		TableWrapLayout wrapLayout = new TableWrapLayout();
		wrapLayout.numColumns=COLUMNS;
		wrapLayout.makeColumnsEqualWidth=true;
		setLayout(wrapLayout);
		setBackground(client.getBackground());

		AdapterFactoryLabelProvider provider = DecisionUtil.getLabelProvider();

		Label label = new Label(this, SWT.NONE);
		label.setText("Other Involved Elements: ");
		label.setBackground(client.getBackground());
		TableWrapData wrapData = new TableWrapData();
		wrapData.colspan=COLUMNS;
		label.setLayoutData(wrapData);
		
		for (AbstractOperation ao : option.getOperations()) {

			ModelElement modelElement = decisionManager.getModelElement(ao
					.getModelElementId());

			CLabel meLabel = new CLabel(this, SWT.WRAP);
			meLabel.setImage(provider.getImage(modelElement));
			meLabel.setText(DecisionUtil.cutString(provider
					.getText(modelElement), 45, true));
			meLabel.setBackground(client.getBackground());
		}
	}
}
