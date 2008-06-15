package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * GUI Control for the ME reference single links.
 * 
 * @author helming
 * 
 */
public class MESingleLinkControl extends AbstractMEControl {

	private Composite composite;

	private final EReference eReference;

	private Composite linkArea;

	private Composite parent;

	private int style;

	private Control control;

	private MELinkControl meControl;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param modelElement
	 *            the ME
	 * @param toolkit
	 *            gui toolkit used for rendering
	 * @param reference
	 *            the reference link
	 */
	public MESingleLinkControl(EditingDomain editingDomain,
			EObject modelElement, FormToolkit toolkit, EReference reference) {
		super(editingDomain, modelElement, toolkit);
		this.eReference = reference;
		modelElement.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature().equals(eReference)) {
					updateLink();
				}
				super.notifyChanged(msg);
			}

		});
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(final Composite parent, int style) {
		composite = toolkit.createComposite(parent, style);
		composite.setLayout(new GridLayout(2, false));
		this.parent = parent;
		this.style = style;
		linkArea = toolkit.createComposite(composite);
		linkArea.setLayout(new FillLayout());
		updateLink();
		Button button = toolkit.createButton(composite, "Select", SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Class<? extends EObject> clazz = (Class<? extends EObject>) eReference
						.getEReferenceType().getInstanceClass();
				ElementListSelectionDialog dlg = new ElementListSelectionDialog(
						parent.getShell(), new AdapterFactoryLabelProvider(
								new ModelItemProviderAdapterFactory()));
				// JH: fill only with right elements
				Collection<ModelElement> allElements = ((ModelElement) modelElement)
						.getProject().getElementsByClass(clazz);
				allElements.remove(modelElement);
				Object object = modelElement.eGet(eReference);
				EList<EObject> list;
				if (object instanceof EObject) {
					allElements.remove(object);
				}
				dlg.setElements(allElements.toArray());
				dlg.setTitle("Select Element");
				dlg.setBlockOnOpen(true);
				if (dlg.open() == Window.OK) {
					Object result = dlg.getFirstResult();
					if (result instanceof EObject) {
						EObject eObject = (EObject) result;
						modelElement.eSet(eReference, eObject);
					}
				}

			}

		});
		return composite;
	}

	private void updateLink() {
		if (meControl != null) {
			meControl.getLinkComposite().dispose();
		}

		Composite linkComposite = toolkit.createComposite(linkArea);

		linkComposite.setLayout(new GridLayout(1, false));
		EObject opposite = (EObject) modelElement.eGet(eReference);
		ModelElement me = (ModelElement) modelElement;
		if (opposite != null) {
			meControl = new MELinkControl(editingDomain, opposite, toolkit, me,
					eReference);
			control = meControl.createControl(linkComposite, style);
		} else {
			Label label = toolkit.createLabel(linkComposite, "(Not Set)");
			label.setForeground(parent.getShell().getDisplay().getSystemColor(
					SWT.COLOR_GRAY));
		}
		linkArea.layout(true);
	}
}
