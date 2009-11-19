package org.unicase.mergetest.merge.ui.widgets;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.DecisionManager;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.util.DecisionUtil;
import org.unicase.metamodel.ModelElement;

public class OtherInvolvedWidget extends Composite {

	public OtherInvolvedWidget(Composite client,
			DecisionManager decisionManager, ConflictOption option) {
		super(client, SWT.None);
		setLayout(new RowLayout(SWT.VERTICAL));
		setBackground(client.getBackground());

		AdapterFactoryLabelProvider provider = DecisionUtil.getLabelProvider();

		for (AbstractOperation ao : option.getOperations()) {

			ModelElement modelElement = decisionManager.getModelElement(ao
					.getModelElementId());

			CLabel meLabel = new CLabel(this, SWT.NONE);
			meLabel.setImage(provider.getImage(modelElement));
			meLabel.setText(DecisionUtil.cutString(provider
					.getText(modelElement), 80, true));
			meLabel.setBackground(client.getBackground());
		}
	}
}
