/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * GUI Control for the ME reference single links.
 * 
 * @author helming
 */
public class MESingleLinkControl extends AbstractMEControl {

	private Composite composite;

	private EReference eReference;

	private Composite linkArea;

	private Composite parent;

	private int style;

	private MELinkControl meControl;

	private Label labelWidget;

	private static final int PRIORITY = 1;

	private ModelElementChangeListener modelElementChangeListener;

	/**
	 * Standard Constructor.
	 */
	public MESingleLinkControl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(final Composite parent, int style) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		this.eReference = (EReference) feature;
		composite = getToolkit().createComposite(parent, style);
		composite.setLayout(new GridLayout(3, false));
		GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(3).equalWidth(false).applyTo(composite);
		this.parent = parent;
		this.style = style;
		linkArea = getToolkit().createComposite(composite);
		linkArea.setLayout(new FillLayout());
		updateLink();

		final AddReferenceAction addAction = new AddReferenceAction(getModelElement(), eReference,
			getItemPropertyDescriptor());
		final NewReferenceAction newAction = new NewReferenceAction(getModelElement(), eReference,
			getItemPropertyDescriptor());

		Button selectButton = getToolkit().createButton(composite, "", SWT.PUSH);
		selectButton.setImage(addAction.getImageDescriptor().createImage());
		selectButton.setToolTipText(addAction.getToolTipText());
		selectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addAction.run();
			}

		});
		Button newButton = getToolkit().createButton(composite, "", SWT.PUSH);
		newButton.setImage(newAction.getImageDescriptor().createImage());
		newButton.setToolTipText(newAction.getToolTipText());
		newButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newAction.run();
			}
		});

		modelElementChangeListener = new ModelElementChangeListener() {

			public void onChange(Notification notification) {
				updateLink();
			}

			public void onRuntimeExceptionInListener(RuntimeException exception) {
				// Do nothing.

			}
		};

		getModelElement().addModelElementChangeListener(modelElementChangeListener);

		return composite;
	}

	private void updateLink() {
		if (meControl != null) {
			meControl.dispose();
		}
		if (labelWidget != null) {
			labelWidget.dispose();
		}
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				EObject opposite = (EObject) getModelElement().eGet(eReference);
				if (opposite != null && opposite instanceof ModelElement) {
					MELinkControlFactory meLinkControlFactory = new MELinkControlFactory();
					meControl = meLinkControlFactory.createMELinkControl(getItemPropertyDescriptor(),
						(ModelElement) opposite, getModelElement());
					meControl.createControl(linkArea, style, getItemPropertyDescriptor(), (ModelElement) opposite,
						getModelElement(), getToolkit());
				} else {
					labelWidget = getToolkit().createLabel(linkArea, "(Not Set)");
					labelWidget.setBackground(parent.getBackground());
					labelWidget.setForeground(parent.getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
				}
				linkArea.layout(true);
				composite.layout(true);

			}
		}.run();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		getModelElement().removeModelElementChangeListener(modelElementChangeListener);
		if (meControl != null) {
			meControl.dispose();
		}

	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EReference && !((EReference) feature).isMany()
			&& ModelElement.class.isAssignableFrom(((EReference) feature).getEType().getInstanceClass())) {
			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}
