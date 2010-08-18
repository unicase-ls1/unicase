package org.unicase.ui.urml.meeditor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
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
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.goal.GoalReference;
import org.unicase.model.urml.goal.GoalReferenceType;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.common.util.ShortLabelProvider;
import org.unicase.ui.meeditor.ModelElementChangeListener;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkAdapter;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkDeleteAdapter;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;

public class GoalInfluenceLinkControl extends MELinkControl {
	private Composite composite;
	private ILabelProvider goalLabelProvider;
	private ImageHyperlink imgHyperlink;
	private Hyperlink goalHyperlink;
	private Combo combobox;
	private Hyperlink refHyperlink;
	private Image deleteImage;
	private ModelElementChangeListener goalChangeListener;
	private ModelElementChangeListener refChangeListener;
	private IHyperlinkListener linkToGoalListener;
	private IHyperlinkListener linkToRefListener;
	private MEHyperLinkDeleteAdapter delRefListener;
	private GoalReference goalRef;
	private Goal thisGoal;
	private Goal linkedGoal;
	private EAttribute eAttribute;
	private ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
	private EReference eReference;
	private ModelElementContext context;
	private Composite parent;

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
			thisGoal = (Goal) contextModelElement;
			eReference = (EReference) itemPropertyDescriptor.getFeature(goalRef);
			eAttribute = (EAttribute) goalRef.eClass().getEStructuralFeature("weight");
			this.toolkit = toolkit;
			this.context = context;
			this.parent = parent;
			// create components
			createComponents(parent, style);
			// set all values that depends on other elements
			setupComponents();
			return composite;
		} else {
			return super.createControl(parent, style, itemPropertyDescriptor, link, contextModelElement, toolkit,
				context);
		}
	}

	private boolean setupComponents() {
		boolean changed = false;
		if (composite != null && !composite.isDisposed()) {
			Goal newLinkedGoal = null;
			// get linked goal
			if (thisGoal.equals(goalRef.getSource())) {
				newLinkedGoal = goalRef.getTarget();
			} else if (thisGoal.equals(goalRef.getTarget())) {
				newLinkedGoal = goalRef.getSource();
			}
			// check whether it is a new linked goal
			if (newLinkedGoal != null && !newLinkedGoal.equals(linkedGoal)) {
				// new goal
				linkedGoal = newLinkedGoal;
				// remove old listeners
				if (linkToGoalListener != null) {
					imgHyperlink.removeHyperlinkListener(linkToGoalListener);
					goalHyperlink.removeHyperlinkListener(linkToGoalListener);
				}
				// add new listeners
				linkToGoalListener = new MEHyperLinkAdapter(linkedGoal, thisGoal, eReference.getName(), context);
				imgHyperlink.addHyperlinkListener(linkToGoalListener);
				goalHyperlink.addHyperlinkListener(linkToGoalListener);
				if (goalChangeListener != null) {
					goalChangeListener.remove();
				}
				goalChangeListener = new GoalRefChangeListener(linkedGoal);
			} else if (newLinkedGoal == null && linkedGoal != null) {
				// link to goal is removed so remove listener
				linkedGoal = newLinkedGoal;
				imgHyperlink.removeHyperlinkListener(linkToGoalListener);
				goalHyperlink.removeHyperlinkListener(linkToGoalListener);
			}
			if (linkedGoal != null) {
				// create components for linked goal
				imgHyperlink.setData(linkedGoal.eClass());
				String text = shortLabelProvider.getText(linkedGoal);
				goalHyperlink.setText(text);
				goalHyperlink.setToolTipText(text);
			} else {
				imgHyperlink.setData(null);
				goalHyperlink.setToolTipText("NULL");
				goalHyperlink.setText("NULL");
			}
			imgHyperlink.setImage(goalLabelProvider.getImage(linkedGoal));
			combobox.select(goalRef.getWeight().getValue());
			refHyperlink.setToolTipText(shortLabelProvider.getText(goalRef));
			changed = true;
		}
		return changed;
	}

	private void createComponents(final Composite parent, int style) {
		composite = toolkit.createComposite(parent, style);
		composite.setLayout(new GridLayout(5, false));
		// handle element creation
		linkToRefListener = new MEHyperLinkAdapter(goalRef, thisGoal, eReference.getName(), context);
		// handle element deletion
		delRefListener = new MEHyperLinkDeleteAdapter(thisGoal, eReference, goalRef, context);
		// listen for changes of the goal reference instance
		refChangeListener = new GoalRefChangeListener(goalRef);
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		goalLabelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider, decoratorManager
			.getLabelDecorator());
		imgHyperlink = toolkit.createImageHyperlink(composite, style);
		ModelElementClassTooltip.enableFor(imgHyperlink);
		goalHyperlink = toolkit.createHyperlink(composite, "", style);
		combobox = new Combo(composite, SWT.DROP_DOWN);
		String[] types = new String[GoalReferenceType.values().length];
		// add types of goal reference to the combobox
		// TODO: could enums have not a from zero increasing number?
		for (GoalReferenceType type : GoalReferenceType.values()) {
			types[type.getValue()] = type.getLiteral();
		}
		combobox.setItems(types);
		combobox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// update the reference as command so that changes would be published to listeners
				new ECPCommand(goalRef) {
					@Override
					protected void doRun() {
						goalRef.eSet(eAttribute, GoalReferenceType.get(combobox.getSelectionIndex()));
					}
				}.run();
			}
		});
		if (eReference.isContainment() && (context.isNonDomainElement(goalRef))) {
			deleteImage = org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif").createImage();
		} else {
			deleteImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
		}
		// creates a link to the reference instance
		refHyperlink = toolkit.createHyperlink(composite, "(Ref)", style);
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

	private class GoalRefChangeListener extends ModelElementChangeListener {
		public GoalRefChangeListener(EObject modelelement) {
			super(modelelement);
		}

		@Override
		public void onChange(Notification notification) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// if something changes do layouts again
					if (setupComponents()) {
						composite.pack();
						composite.layout(true);
						parent.getParent().layout(true);
					}
				}
			});
		}
	}
}