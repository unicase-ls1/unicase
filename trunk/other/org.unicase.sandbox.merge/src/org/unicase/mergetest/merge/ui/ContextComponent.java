package org.unicase.mergetest.merge.ui;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.mergetest.merge.conflicts.Conflict;
import org.unicase.mergetest.merge.conflicts.ConflictContext;

public class ContextComponent extends Composite {

	public ContextComponent(DecisionBox2 parent, Conflict<? extends AbstractOperation, ? extends AbstractOperation> conflict) {
		super(parent, SWT.NONE);
		
		ConflictContext context = conflict.getContext();

		this.setLayout(new GridLayout(3, false));
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
		this.setLayoutData(layoutData);

//		setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		
		FontRegistry fontRegistry = new FontRegistry(this.getDisplay());
		fontRegistry.put("titleLabel", new FontData[] { new FontData("Arial",
				8, SWT.ITALIC) });
		fontRegistry.put("content", new FontData[] { new FontData("Arial",
				9, SWT.NONE) });
		
		Label meTitle = new Label(this, SWT.NONE);
		meTitle.setText(context.getModelElementTitleLabel());
		meTitle.setFont(fontRegistry.get("titleLabel"));

		Label attTitle = new Label(this, SWT.NONE);
		attTitle.setText(context.getAttributeTitleLabel());
		attTitle.setFont(fontRegistry.get("titleLabel"));

		Label oppTitle = new Label(this, SWT.NONE);
		oppTitle.setText(context.getOpponentTitleLabel());
		oppTitle.setFont(fontRegistry.get("titleLabel"));

		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		CLabel meLabel = new CLabel(this, SWT.NONE);
		meLabel.setImage(provider.getImage(context.getModelElement()));
		meLabel.setText(provider.getText(context.getModelElement()));
		meLabel.setFont(fontRegistry.get("content"));

		Label attLabel = new Label(this, SWT.NONE);
		attLabel.setText(context.getAttribute());
		attLabel.setFont(fontRegistry.get("content"));
		
		Label oppLable = new Label(this, SWT.NONE);
		oppLable.setText(context.getOpponent());
		oppLable.setFont(fontRegistry.get("content"));
	}

}
