package org.unicase.model.usecase.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.provider.ShortLabelProvider;
import org.unicase.model.requirement.SystemFunction;
import org.unicase.model.usecase.UseCase;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkAdapter;

/**
 * @author phil
 * @brief Renders linked system functions in the standard view
 */
public class CustomSystemLinkControl extends AbstractMEControl {

	private static final String ID = "org.unicase.model.usecase.ui.controls.customlinkcontrol";
	private static final String NAME = "CUSTOM LINK CONTROL";

	private Composite mainComposite;
	private Composite infoComposite;
	private int style;
	private List<Hyperlink> hyperlinks = new ArrayList<Hyperlink>();
	private List<ImageHyperlink> imageHyperlinks = new ArrayList<ImageHyperlink>();
	private ILabelProvider labelProvider;

	private AdapterImpl eAdapter;

	private Section section;

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {

		if (UseCase.class.isInstance(modelElement)
			&& ((EReference) itemPropertyDescriptor.getFeature(modelElement)).getName() == "systemFunctions") {
			return 2;
		}
		return -1;
	}

	@Override
	protected Control createControl(Composite parent, int style) {

		hyperlinks.clear();
		imageHyperlinks.clear();
		this.style = style;
		section = getToolkit().createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText("System Functions");
		mainComposite = getToolkit().createComposite(section, style);
		mainComposite.setLayout(new GridLayout(1, true));

		infoComposite = getToolkit().createComposite(mainComposite);
		infoComposite.setLayout(new GridLayout(2, false));
		infoComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// eAdapter has the control updated on changes in the flow of events
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() instanceof EReference
					&& ((EReference) msg.getFeature()).getName() == "systemFunctions")
					updateControl();
			}
		};
		((UseCase) getModelElement()).eAdapters().add(eAdapter);

		section.setClient(mainComposite);

		updateControl();

		return section;
	}

	/**
	 * Updates the control if a linked system function has changed
	 */
	public void updateControl() {
		if (!mainComposite.isDisposed()) {
			if (!infoComposite.isDisposed())
				infoComposite.dispose();
			for (Hyperlink h : imageHyperlinks)
				if (!h.isDisposed())
					h.dispose();
			for (Hyperlink h : hyperlinks)
				if (!h.isDisposed())
					h.dispose();
			hyperlinks.clear();

			infoComposite = getToolkit().createComposite(mainComposite);
			infoComposite.setLayout(new GridLayout(2, false));
			infoComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
			labelProvider = new DecoratingLabelProvider(adapterFactoryLabelProvider, decoratorManager
				.getLabelDecorator());

			ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
			EList<SystemFunction> systemFunctions = ((UseCase) getModelElement()).getSystemFunctions();
			for (SystemFunction s : systemFunctions) {
				IHyperlinkListener listener = new MEHyperLinkAdapter(s, getModelElement(), "systemFunctions");
				ImageHyperlink h2 = getToolkit().createImageHyperlink(infoComposite, style);
				h2.setImage(labelProvider.getImage(s));
				h2.addHyperlinkListener(listener);
				imageHyperlinks.add(h2);
				Hyperlink h = getToolkit().createHyperlink(infoComposite, shortLabelProvider.getText(s), style);
				h.addHyperlinkListener(listener);
				hyperlinks.add(h);
			}
			infoComposite.layout();
			mainComposite.layout();
			if (!section.isDisposed())
				section.setExpanded(false);
			section.setExpanded(true);

		}
	}

	@Override
	public void dispose() {
		((UseCase) getModelElement()).eAdapters().remove(eAdapter);
		labelProvider.dispose();
		for (Hyperlink h : hyperlinks)
			if (!h.isDisposed())
				h.dispose();
		for (Hyperlink h : imageHyperlinks)
			if (!h.isDisposed())
				h.dispose();
		if (!infoComposite.isDisposed())
			infoComposite.dispose();
		if (!mainComposite.isDisposed())
			mainComposite.dispose();
	}

}
