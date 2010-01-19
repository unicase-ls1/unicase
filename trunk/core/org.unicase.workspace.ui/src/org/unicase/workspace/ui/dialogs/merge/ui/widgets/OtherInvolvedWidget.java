package org.unicase.workspace.ui.dialogs.merge.ui.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

public class OtherInvolvedWidget extends Composite {

	private static final int COLUMNS = 1;

	public OtherInvolvedWidget(Composite client, DecisionManager decisionManager, ConflictOption option) {
		super(client, SWT.None);
		TableWrapLayout wrapLayout = new TableWrapLayout();
		wrapLayout.numColumns = COLUMNS;
		wrapLayout.makeColumnsEqualWidth = true;
		setLayout(wrapLayout);
		setBackground(client.getBackground());

		Label label = new Label(this, SWT.NONE);
		label.setText("Other Involved Changes: ");
		label.setBackground(client.getBackground());
		TableWrapData wrapData = new TableWrapData();
		wrapData.colspan = COLUMNS;
		label.setLayoutData(wrapData);

		ChangePackageVisualizationHelper visualizationHelper = decisionManager.getChangePackageVisualizationHelper();

		for (AbstractOperation ao : option.getOperations()) {
			Image image = visualizationHelper.getImage(DecisionUtil.getAdapterFactory(), ao);

			CLabel meLabel = new CLabel(this, SWT.WRAP);
			if (image != null) {
				meLabel.setImage(image);
			}
			meLabel.setText(visualizationHelper.getDescription(ao));
			meLabel.setBackground(client.getBackground());
		}
	}
}
