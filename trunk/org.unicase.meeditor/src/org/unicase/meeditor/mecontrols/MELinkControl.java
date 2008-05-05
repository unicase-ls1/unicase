package org.unicase.meeditor.mecontrols;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.model.ModelElement;

public class MELinkControl extends AbstractMEControl {

	FormToolkit toolkit;
	EReference reference;
	EObject modelElement;
	Section section;
	Composite composite;
	EList<EObject> value;
	HyperlinkGroup hyperLinkGroup;
	List<Hyperlink> links;
	Composite linkArea;
	int style;

	public MELinkControl(EObject modelElement, EReference reference,
			FormToolkit toolkit) {
		super();
		this.modelElement = modelElement;
		this.reference = reference;
		this.toolkit = toolkit;
		links = new ArrayList<Hyperlink>();
	}

	public Control createControl(final Composite parent, int style) {
		this.style = style;
		section = toolkit.createSection(parent, Section.DESCRIPTION
				| Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(reference.getName());
		composite = toolkit.createComposite(section, style);
		composite.setLayout(new GridLayout());

		linkArea = toolkit.createComposite(composite, style);
		linkArea.setLayout(new GridLayout());

		hyperLinkGroup = new HyperlinkGroup(composite.getDisplay());

		setLinks();

		// TODO: move Button in the titlebar
		Button editButton = toolkit.createButton(composite, "Edit", SWT.PUSH);
		editButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				Class<? extends EObject> clazz = (Class<? extends EObject>) reference.getEReferenceType().getInstanceClass();
				MultipleReferenceDialog dialog = new MultipleReferenceDialog(
						parent.getShell(), toolkit,
						(EList<EObject>) modelElement.eGet(reference),
						((ModelElement) modelElement).getProject(),clazz, modelElement
						);
				dialog.setBlockOnOpen(true);
				if (dialog.open() == Window.OK) {
					modelElement.eSet(reference, dialog.getResult());
					setLinks();
				}

			}

		});

		section.setClient(composite);
		return section;
	}

	public void setLinks() {
		value = (EList<EObject>) modelElement.eGet(reference);
		if (links != null) {
			for (Hyperlink link : links) {
				link.dispose();
			}
		}
		for (EObject object : value) {
			if (object instanceof ModelElement) {
				ModelElement me = (ModelElement) object;
				Hyperlink hyperlink = toolkit.createHyperlink(linkArea, me
						.getName(), style);
				links.add(hyperlink);
				hyperLinkGroup.add(hyperlink);
				hyperlink.addHyperlinkListener(new MEHyperLinkAdapter(me));
			}
		}
		composite.layout();
		section.layout();

	}

}
