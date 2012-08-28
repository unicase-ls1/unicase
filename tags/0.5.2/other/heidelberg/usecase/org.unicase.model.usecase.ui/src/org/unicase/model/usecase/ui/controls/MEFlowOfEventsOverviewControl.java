package org.unicase.model.usecase.ui.controls;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.usecase.UseCase;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * @author phil
 * @brief Renders the overview control for the flow of events on the overview tab of a Use Case
 */
public class MEFlowOfEventsOverviewControl extends AbstractMEControl {

	private static final String ID = "org.unicase.model.usecase.ui.controls.meflowofeventsoverviewcontrol";
	private static final String NAME = "Flow of Events Overview";

	private Composite mainComposite;
	private Label actor;
	private Label system;

	private AdapterImpl eAdapter;

	private Section section;

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {

		if (UseCase.class.isInstance(modelElement)
			&& ((EReference) itemPropertyDescriptor.getFeature(modelElement)).getName() == "actorSteps") {
			return 2;
		}
		return -1;
	}

	@Override
	protected Control createControl(Composite parent, int style) {

		section = getToolkit().createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText("Flow of Events");
		mainComposite = getToolkit().createComposite(section, style);
		mainComposite.setLayout(new GridLayout(1, true));

		actor = getToolkit().createLabel(mainComposite,
			"Actor Steps: " + String.valueOf(((UseCase) getModelElement()).getActorSteps().size()));
		system = getToolkit().createLabel(mainComposite,
			"System Steps: " + String.valueOf(((UseCase) getModelElement()).getSystemSteps().size()));

		// eAdapter has the control updated on changes in the flow of events
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getPosition() != -1)
					updateControl();
			}
		};
		((UseCase) getModelElement()).eAdapters().add(eAdapter);

		section.setClient(mainComposite);
		return section;
	}

	/**
	 * Updates the control if the number of actor or system steps has changed
	 */
	public void updateControl() {
		if (!actor.isDisposed())
			actor.setText("Actor Steps: " + String.valueOf(((UseCase) getModelElement()).getActorSteps().size()));
		if (!system.isDisposed())
			system.setText("System Steps: " + String.valueOf(((UseCase) getModelElement()).getSystemSteps().size()));
		if (!mainComposite.isDisposed())
			mainComposite.layout();
	}

	@Override
	public void dispose() {
		((UseCase) getModelElement()).eAdapters().remove(eAdapter);
		actor.dispose();
		system.dispose();
		if (!mainComposite.isDisposed())
			mainComposite.dispose();
	}

}
