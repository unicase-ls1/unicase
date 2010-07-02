/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols.uccontrol;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractUnicaseMEControl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class creates a widget that displays all use case steps of a use case.
 * 
 * @author lars
 */
public class UseCaseStepsControl extends AbstractUnicaseMEControl {

	private static final int PRIORITY = 2;

	/**
	 * HyperLink listener class for add step hyperlink.
	 */
	private final class IHyperlinkListenerImplementation implements IHyperlinkListener {
		private final int position;

		private IHyperlinkListenerImplementation(int position) {
			this.position = position;
		}

		public void linkActivated(HyperlinkEvent e) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					RequirementFactory rFactory = RequirementFactoryImpl.init();
					Step p = rFactory.createStep();
					UseCase uc = (UseCase) getModelElement();
					ModelUtil.getProject(uc).addModelElement(p);
					p.setName("New System Step");
					p.setUserStep(false);
					EList<Step> allSteps = uc.getUseCaseSteps();
					if (position == -1) {
						allSteps.add(p);
					} else {
						allSteps.add(position, p);
					}
				}
			}.run();
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * Listener for the new step command.
	 * 
	 * @author helming
	 */
	private final class NewStepListener implements IHyperlinkListener {
		private final int position;

		private NewStepListener(int position) {
			this.position = position;
		}

		public void linkActivated(HyperlinkEvent e) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					RequirementFactory rFactory = RequirementFactoryImpl.init();
					Step p = rFactory.createStep();
					p.setName("New Actor Step");
					p.setUserStep(true);
					UseCase uc = (UseCase) getModelElement();
					EList<Step> allSteps = uc.getUseCaseSteps();
					ModelUtil.getProject(uc).addModelElement(p);
					if (position == -1) {
						allSteps.add(p);
					} else {
						allSteps.add(position, p);
					}
				}
			}.run();
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	private EReference eReference;
	private IItemPropertyDescriptor descriptor;
	private AdapterImpl eAdapter;

	private Composite mainComposite;

	private int parentStyle;
	private Section section;

	private Composite stepArea;
	private Step focusedStep;
	private ArrayList<Step> currentStepList = new ArrayList<Step>();

	private ArrayList<SingleUseCaseStepControl> stepControls = new ArrayList<SingleUseCaseStepControl>();

	private void setFocusedStep(Notification msg) {
		if (msg.getNewValue() != null && msg.getOldValue() == null) {
			focusedStep = (Step) msg.getNewValue();
		}
		if (msg.getNewValue() == null && msg.getOldValue() != null) {
			UseCase uc = (UseCase) msg.getNotifier();
			int stepNumber = currentStepList.indexOf(msg.getOldValue());
			if (uc.getUseCaseSteps().size() > 0) {
				if (stepNumber > 1) {
					focusedStep = uc.getUseCaseSteps().get(stepNumber - 1);
				} else {
					focusedStep = uc.getUseCaseSteps().get(0);
				}
			} else {
				focusedStep = null;
			}
		}
	}

	/**
	 * Method creates the specific widget and the containing display elements.
	 * 
	 * @param parent surrounding widget or container
	 * @param style represents the style that should be used
	 * @return the control containing all use case steps
	 */
	@Override
	public Control createControl(final Composite parent, final int style) {
		descriptor = getItemPropertyDescriptor();
		this.eReference = (EReference) descriptor.getFeature(getModelElement());

		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(eReference)) {
					setFocusedStep(msg);
					currentStepList = new ArrayList<Step>(((UseCase) msg.getNotifier()).getUseCaseSteps());
					rebuildStepList();
				}
				super.notifyChanged(msg);
			}
		};
		getModelElement().eAdapters().add(eAdapter);
		this.parentStyle = style;
		section = getToolkit().createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(descriptor.getDisplayName(getModelElement()));
		mainComposite = getToolkit().createComposite(section);
		mainComposite.setLayout(new GridLayout());
		stepArea = getToolkit().createComposite(mainComposite);
		stepArea.setLayout(new GridLayout(2, true));

		rebuildStepList();

		section.setClient(mainComposite);

		return section;
	}

	@SuppressWarnings("unchecked")
	private void rebuildStepList() {
		SingleUseCaseStepControl focusedStepControl = null;
		stepArea.dispose();
		for (SingleUseCaseStepControl step : stepControls) {
			step.dispose();
		}

		stepArea = getToolkit().createComposite(mainComposite);
		stepArea.setLayout(new GridLayout(2, true));
		GridData stepAreaGridData = new GridData(GridData.FILL_HORIZONTAL);
		stepArea.setLayoutData(stepAreaGridData);

		for (SingleUseCaseStepControl step : stepControls) {
			step.dispose();
		}
		stepControls.clear();

		Object objectList = getModelElement().eGet(eReference);
		if (objectList instanceof EList) {
			EList<EObject> eList = (EList<EObject>) objectList;
			int currentPosition = 0;
			for (EObject object : eList) {
				if (object instanceof Step) {

					Step me = (Step) object;
					GridData gdEmpty = GridDataFactory.fillDefaults().grab(true, false).indent(0, 0).create();
					GridData gdUserStep = GridDataFactory.fillDefaults().grab(true, false).indent(0, 0).create();

					SingleUseCaseStepControl stepControl = new SingleUseCaseStepControl(getEditingDomain(), me,
						getToolkit(), getModelElement(), eReference);

					if (me.isUserStep()) {
						Control c = stepControl.createControl(stepArea, parentStyle, getItemPropertyDescriptor(), me,
							UnicaseActionHelper.getContext(me), getToolkit());
						c.setLayoutData(gdUserStep);
						Control empty2 = getToolkit().createComposite(stepArea, parentStyle);
						empty2.setLayoutData(gdEmpty);
					} else {
						Control empty2 = getToolkit().createComposite(stepArea, parentStyle);
						empty2.setLayoutData(gdEmpty);
						Control c = stepControl.createControl(stepArea, parentStyle, getItemPropertyDescriptor(), me,
							UnicaseActionHelper.getContext(me), getToolkit());
						c.setLayoutData(gdUserStep);
					}

					if (focusedStep != null && me.equals(focusedStep)) {
						focusedStepControl = stepControl;
						focusedStep = null;
					}

					stepControls.add(stepControl);
				}
				currentPosition++;
			}
		}

		GridData gdButtonPanel = new GridData(GridData.GRAB_HORIZONTAL);
		gdButtonPanel.verticalIndent = 0;
		gdButtonPanel.horizontalSpan = 2;
		createAddStepButtons(-1, stepArea).setLayoutData(gdButtonPanel);
		mainComposite.layout(true);
		section.setExpanded(false);
		section.setExpanded(true);
		if (focusedStepControl != null) {
			focusedStepControl.setFocus();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		for (SingleUseCaseStepControl step : stepControls) {
			step.dispose();
		}
		stepControls.clear();
		getModelElement().eAdapters().remove(eAdapter);
	}

	private Composite createAddStepButtons(final int position, Composite parent) {
		Composite buttonControl = getToolkit().createComposite(parent);
		buttonControl.setLayout(new GridLayout(2, false));
		buttonControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridData gdActorLink = new GridData(GridData.FILL_HORIZONTAL);
		gdActorLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		gdActorLink.horizontalSpan = 1;

		Hyperlink addActorStepLink = getToolkit().createHyperlink(buttonControl, "Insert Actor Step",
			GridData.HORIZONTAL_ALIGN_BEGINNING);
		addActorStepLink.addHyperlinkListener(new NewStepListener(position));

		addActorStepLink.setLayoutData(gdActorLink);

		GridData gdSystemLink = new GridData(GridData.FILL_HORIZONTAL);
		gdSystemLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		gdSystemLink.horizontalSpan = 1;

		Hyperlink addSystemStepLink = getToolkit().createHyperlink(buttonControl, "Insert System Step",
			GridData.HORIZONTAL_ALIGN_END);
		addSystemStepLink.addHyperlinkListener(new IHyperlinkListenerImplementation(position));
		addSystemStepLink.setLayoutData(gdSystemLink);

		return buttonControl;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EReference && !((EReference) feature).getName().equals("useCaseSteps")) {
			return DO_NOT_RENDER;
		}
		return PRIORITY;
	}

}
