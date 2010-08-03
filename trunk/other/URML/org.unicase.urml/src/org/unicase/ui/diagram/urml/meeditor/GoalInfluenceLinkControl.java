package org.unicase.ui.diagram.urml.meeditor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.common.util.ShortLabelProvider;
import org.unicase.ui.meeditor.ModelElementChangeListener;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkAdapter;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkDeleteAdapter;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;

import urml.goal.Goal;
import urml.goal.GoalReference;
import urml.goal.GoalReferenceType;

public class GoalInfluenceLinkControl extends MELinkControl {
	private Composite composite;
	private ILabelProvider goalLabelProvider;
	private Hyperlink goalHyperlink;
	private Combo combobox;
	private Image deleteImage;
	private ModelElementChangeListener goalChangeListener;
	private ModelElementChangeListener refChangeListener;
	private IHyperlinkListener linkToGoalListener;
	private IHyperlinkListener linkToRefListener;
	private MEHyperLinkDeleteAdapter delRefListener;
	private GoalReference goalRef;
	private Goal linkedGoal;

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject link2, EObject contextModelElement2) {
		if (link2 instanceof GoalReference) {
			return PRIORITY;
		} else {
			return -1;
		}
	}

	private static final int PRIORITY = 2;

	public GoalInfluenceLinkControl() {
	}

	@Override
	public Control createControl(final Composite parent, int style, IItemPropertyDescriptor itemPropertyDescriptor,
		final EObject link, EObject contextModelElement, FormToolkit toolkit, ModelElementContext context) {
		if (link instanceof GoalReference) {
			goalRef = (GoalReference) link;
			if (goalRef.getSource().equals(contextModelElement)) {
				linkedGoal = goalRef.getTarget();
			} else if (goalRef.getTarget().equals(contextModelElement)) {
				linkedGoal = goalRef.getSource();
			}
			EReference eReference = (EReference) itemPropertyDescriptor.getFeature(link);
			linkToGoalListener = new MEHyperLinkAdapter(linkedGoal, contextModelElement, eReference.getName(), context);
			linkToRefListener = new MEHyperLinkAdapter(goalRef, contextModelElement, eReference.getName(), context);
			delRefListener = new MEHyperLinkDeleteAdapter(contextModelElement, eReference, link, context);
			this.toolkit = toolkit;
			composite = toolkit.createComposite(parent, style);
			composite.setLayout(new GridLayout(5, false));
			if (eReference.isContainment() && (context.isNonDomainElement(link))) {
				deleteImage = org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif").createImage();
			} else {
				deleteImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
			}
			if (linkedGoal != null) {
				createComponents(parent, style);
			}
			return composite;
		} else {
			return super.createControl(parent, style, itemPropertyDescriptor, link, contextModelElement, toolkit,
				context);
		}
	}

	protected void createComponents(final Composite parent, int style) {
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		goalLabelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider, decoratorManager
			.getLabelDecorator());

		goalChangeListener = new ModelElementChangeListener(linkedGoal) {
			@Override
			public void onChange(Notification notification) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						if (goalHyperlink != null && !goalHyperlink.isDisposed()) {
							ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
							String text = shortLabelProvider.getText(linkedGoal);
							goalHyperlink.setText(text);
							goalHyperlink.setToolTipText(text);
							composite.layout(true);
							parent.getParent().layout(true);
						}
					}
				});
			}
		};
		refChangeListener = new ModelElementChangeListener(goalRef) {
			@Override
			public void onChange(Notification notification) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						if (combobox != null && !combobox.isDisposed()) {
							combobox.select(goalRef.getWeight().getValue());
							composite.layout(true);
							parent.getParent().layout(true);
						}
					}
				});
			}
		};

		ImageHyperlink imgHyperlink = toolkit.createImageHyperlink(composite, style);
		imgHyperlink.setImage(goalLabelProvider.getImage(linkedGoal));
		imgHyperlink.setData(linkedGoal.eClass());
		imgHyperlink.addHyperlinkListener(linkToGoalListener);
		ModelElementClassTooltip.enableFor(imgHyperlink);
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		goalHyperlink = toolkit.createHyperlink(composite, (shortLabelProvider.getText(linkedGoal)), style);
		goalHyperlink.setToolTipText(shortLabelProvider.getText(linkedGoal));
		goalHyperlink.addHyperlinkListener(linkToGoalListener);

		combobox = new Combo(composite, SWT.DROP_DOWN);
		String[] types = new String[GoalReferenceType.values().length];
		for (GoalReferenceType type : GoalReferenceType.values()) {
			types[type.getValue()] = type.getLiteral();
		}
		combobox.setItems(types);
		combobox.select(goalRef.getWeight().getValue());
		combobox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				goalRef.setWeight(GoalReferenceType.get(combobox.getSelectionIndex()));
			}
		});

		Hyperlink refHyperlink = toolkit.createHyperlink(composite, "(Ref)", style);
		refHyperlink.setToolTipText(shortLabelProvider.getText(goalRef));
		refHyperlink.addHyperlinkListener(linkToRefListener);
		ImageHyperlink delHyperlink = toolkit.createImageHyperlink(composite, style);
		delHyperlink.setImage(deleteImage);
		delHyperlink.addMouseListener(delRefListener);
	}

	@Override
	public void dispose() {
		if (goalChangeListener != null) {
			goalChangeListener.remove();
		}
		if (refChangeListener != null) {
			refChangeListener.remove();
		}
		if (goalLabelProvider != null) {
			goalLabelProvider.dispose();
		}
		if (composite != null) {
			composite.dispose();
		}
	}
}