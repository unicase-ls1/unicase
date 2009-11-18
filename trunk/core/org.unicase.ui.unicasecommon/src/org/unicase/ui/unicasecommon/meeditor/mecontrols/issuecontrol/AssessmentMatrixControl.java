/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols.issuecontrol;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.impl.RationaleFactoryImpl;
import org.unicase.ui.unicasecommon.meeditor.ControlFactory;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.MEControl;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.melinkcontrol.MEHyperLinkAdapter;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Class displays assessment matrix for issues.
 * 
 * @author lars
 */
public class AssessmentMatrixControl extends AbstractMEControl {

	private static final int MAX_LENGTH_CRITERIA_NAME = 20;

	private AdapterImpl eAdapter;

	private Composite mainComposite;

	private int parentStyle;
	private Section section;

	private Composite matrixSection;

	private Issue issue;

	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	private ArrayList<MEControl> assessmentControls = new ArrayList<MEControl>();

	private HashMap<Proposal, Label> allSumLabels = new HashMap<Proposal, Label>();
	private HashMap<Proposal, Composite> allSumLabelContainer = new HashMap<Proposal, Composite>();

	/**
	 * Public constructor to create the assessment matrix control.
	 * 
	 * @param modelElement represents the corresponding issue
	 * @param toolkit the used toolkit
	 * @param editingDomain the used editingDomain
	 */
	public AssessmentMatrixControl(EObject modelElement, FormToolkit toolkit, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		issue = (Issue) modelElement;

		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				handleMessage(msg);
				super.notifyChanged(msg);
			}
		};

		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		modelElement.eAdapters().add(eAdapter);

		if (issue != null) {
			EList<Proposal> props = issue.getProposals();
			for (Proposal p : props) {
				p.eAdapters().add(eAdapter);
			}

			EList<Criterion> criteria = issue.getCriteria();
			for (Criterion c : criteria) {
				c.eAdapters().add(eAdapter);
			}

			for (Proposal p : props) {
				EList<Assessment> currentAssessments = p.getAssessments();
				for (Assessment a : currentAssessments) {
					if (criteria.contains(a.getCriterion())) {
						a.eAdapters().add(eAdapter);
					}
				}
			}
		}

	}

	/**
	 * Method is responsible to create the assessment matrix control.
	 * 
	 * @param parent containing parent composite
	 * @param style used style
	 * @return the corresponding control
	 */
	public Control createControl(Composite parent, int style) {
		int numberOfCriteria = 0;
		mainComposite = parent;
		parentStyle = style;
		section = getToolkit().createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText("Assessment Matrix");
		mainComposite = getToolkit().createComposite(section);
		mainComposite.setLayout(new GridLayout(1, true));
		mainComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		if (issue != null) {
			numberOfCriteria = issue.getCriteria().size();
		}

		if (numberOfCriteria > 0) {
			matrixSection = getToolkit().createComposite(mainComposite);
			matrixSection.setLayout(new GridLayout(numberOfCriteria + 1, true));
		} else {
			matrixSection = getToolkit().createComposite(mainComposite);
			matrixSection.setLayout(new GridLayout(1, true));
		}

		rebuildMatrix();

		section.setClient(mainComposite);

		return section;
	}

	/**
	 * used to close the control. removes all listener and closes all containing controls.
	 */
	@Override
	public void dispose() {
		matrixSection.dispose();
		for (MEControl assessmentControl : this.assessmentControls) {
			assessmentControl.dispose();
		}
		assessmentControls.clear();

		if (issue != null) {
			EList<Proposal> props = issue.getProposals();
			for (Proposal p : props) {
				p.eAdapters().remove(eAdapter);
			}

			EList<Criterion> criteria = issue.getCriteria();
			for (Criterion c : criteria) {
				c.eAdapters().remove(eAdapter);
			}

			for (Proposal p : props) {
				EList<Assessment> currentAssessments = p.getAssessments();
				for (Assessment a : currentAssessments) {
					if (criteria.contains(a.getCriterion())) {
						a.eAdapters().remove(eAdapter);
					}
				}
			}
		}

		getModelElement().eAdapters().remove(eAdapter);
	}

	private void rebuildMatrix() {
		matrixSection.dispose();
		for (MEControl assessmentControl : this.assessmentControls) {
			assessmentControl.dispose();
		}
		assessmentControls.clear();

		int numberOfCriteria = 0;
		EList<Proposal> proposals = issue.getProposals();
		EList<Criterion> criteria = issue.getCriteria();

		if (issue != null) {
			numberOfCriteria = criteria.size();
		}

		if (numberOfCriteria > 0 && proposals.size() > 0) {
			matrixSection = getToolkit().createComposite(mainComposite);
			matrixSection.setLayout(new GridLayout(numberOfCriteria + 4, false));

		} else {
			mainComposite.layout(true);
			section.setExpanded(false);
			return;
		}

		GridData matrixAreaGridData = new GridData(GridData.FILL_HORIZONTAL);
		matrixAreaGridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		matrixSection.setLayoutData(matrixAreaGridData);

		// Building Headline
		getToolkit().createLabel(matrixSection, "");
		getToolkit().createLabel(matrixSection, "          ");
		for (int i = 0; i < criteria.size(); i++) {
			final Hyperlink hyperlink = getToolkit().createHyperlink(matrixSection,
				cutStringName(criteria.get(i).getName()), parentStyle);
			GridData hyperLinkGridData = new GridData(GridData.FILL_HORIZONTAL);
			hyperLinkGridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
			hyperlink.setLayoutData(hyperLinkGridData);
			hyperlink.layout();
			IHyperlinkListener listener = new MEHyperLinkAdapter(criteria.get(i), issue, RationalePackage.eINSTANCE
				.getIssue_Criteria().getName());
			hyperlink.addHyperlinkListener(listener);
		}

		if (proposals.size() > 0) {
			getToolkit().createLabel(matrixSection, "          ");
			getToolkit().createLabel(matrixSection, " SUM ");
		}

		for (int p = 0; p < proposals.size(); p++) {
			Proposal currentProposal = proposals.get(p);
			final Hyperlink hyperlink = getToolkit().createHyperlink(matrixSection, currentProposal.getName(),
				parentStyle);
			IHyperlinkListener listener = new MEHyperLinkAdapter(currentProposal, issue, RationalePackage.eINSTANCE
				.getIssue_Proposals().getName());
			hyperlink.addHyperlinkListener(listener);
			getToolkit().createLabel(matrixSection, "     ");
			for (int i = 0; i < criteria.size(); i++) {
				Criterion criterion = criteria.get(i);
				Assessment assessment = getAssessment(currentProposal, criterion);
				if (assessment != null) {
					ControlFactory cFactory = new ControlFactory(getEditingDomain(), assessment, getToolkit());
					final IItemPropertyDescriptor pDescriptorAssessmentValue = adapterFactoryItemDelegator
						.getPropertyDescriptor(assessment, "value");
					MEControl assessmentControlDescription = cFactory.createControl(pDescriptorAssessmentValue);
					this.assessmentControls.add(assessmentControlDescription);

					Composite comp = getToolkit().createComposite(matrixSection);
					assessmentControlDescription.createControl(comp, parentStyle);
					comp.setLayout(new GridLayout(1, true));
					GridData gridData = new GridData();
					gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
					comp.setLayoutData(gridData);
				}
			}
			getToolkit().createLabel(matrixSection, "          ");
			Composite sumLabelComposite = getToolkit().createComposite(matrixSection);
			sumLabelComposite.setLayout(new GridLayout(1, true));
			allSumLabels.put(currentProposal, getToolkit().createLabel(sumLabelComposite,
				" " + computeAssessmentSum(currentProposal) + " "));
			sumLabelComposite.layout();
			allSumLabelContainer.put(currentProposal, sumLabelComposite);
		}

		matrixSection.layout();

		mainComposite.layout(true);
		section.setExpanded(false);
		section.setExpanded(true);
	}

	private String cutStringName(String inputString) {
		if (inputString.length() <= (MAX_LENGTH_CRITERIA_NAME - 3)) {
			int diff = (MAX_LENGTH_CRITERIA_NAME - inputString.length()) / 2;
			for (int i = 0; i < diff; i++) {
				inputString = " " + inputString + " ";
			}
			return inputString;
		}
		String retValue = inputString.substring(0, MAX_LENGTH_CRITERIA_NAME - 3);
		retValue = retValue + "...";
		return retValue;
	}

	private Assessment getAssessment(final Proposal p, final Criterion c) {
		if (p == null || c == null) {
			return null;
		}

		EList<Assessment> assessmentsOfProposal = p.getAssessments();
		for (int i = 0; i < assessmentsOfProposal.size(); i++) {
			Assessment currentAssessment = assessmentsOfProposal.get(i);
			if (currentAssessment.getCriterion() != null) {
				if (currentAssessment.getCriterion().equals(c)) {
					return assessmentsOfProposal.get(i);
				}
			}
		}
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				RationaleFactory rFactory = RationaleFactoryImpl.init();
				Assessment assessment = rFactory.createAssessment();
				assessment.setName("new Assessment");
				assessment.setProposal(p);
				assessment.setCriterion(c);
				assessment.eAdapters().add(eAdapter);
			}
		}.run();

		assessmentsOfProposal = p.getAssessments();
		for (int i = 0; i < assessmentsOfProposal.size(); i++) {
			if (assessmentsOfProposal.get(i).getCriterion() != null
				&& assessmentsOfProposal.get(i).getCriterion().equals(c)) {
				return assessmentsOfProposal.get(i);
			}
		}
		return null;
	}

	private int computeAssessmentSum(Proposal p) {
		int retValue = 0;

		if (p == null) {
			return retValue;
		}
		EList<Criterion> criteria = issue.getCriteria();
		EList<Assessment> assessments = p.getAssessments();
		for (Assessment assessment : assessments) {
			if (criteria.contains(assessment.getCriterion())) {
				retValue = retValue + assessment.getValue();
			}
		}

		return retValue;
	}

	private void updateAssessmentSum(Proposal p) {
		Label l = allSumLabels.get(p);
		l.dispose();
		Composite c = allSumLabelContainer.get(p);
		l = getToolkit().createLabel(c, " " + computeAssessmentSum(p) + " ");
		allSumLabels.put(p, l);
		c.layout();
	}

	private void handleMessage(Notification msg) {
		if (msg.getNotifier().equals(issue)) {
			if (msg.getFeature() instanceof EReference) {
				handleReferencesMessage(msg);
			}
		}

		if (msg.getNotifier() instanceof Criterion) {
			handleCriterionMessage(msg);
		}

		if (msg.getNotifier() instanceof Proposal) {
			handleProposalMessage(msg);
		}

		if ((msg.getNotifier() instanceof Assessment)) {
			handleAssessmentMessage(msg);
		}
	}

	private void handleReferencesMessage(Notification msg) {
		EReference reference = (EReference) msg.getFeature();
		Object oldValue = msg.getOldValue();
		Object newValue = msg.getNewValue();
		if (reference.getName().equals("criteria")) {
			handleCriteria(oldValue, newValue);
			rebuildMatrix();
		} else if (reference.getName().equals("proposals")) {
			handleProposals(oldValue, newValue);
			rebuildMatrix();
		}
	}

	@SuppressWarnings("unchecked")
	private void handleProposals(Object oldValue, Object newValue) {
		if (oldValue == null && newValue != null) {
			if (newValue instanceof EList) {
				EList<Proposal> proposals = (EList<Proposal>) newValue;
				for (Proposal p : proposals) {
					addAssessmentEAdapter(p);
				}
			} else {
				addAssessmentEAdapter((Proposal) newValue);
			}
		} else if (oldValue != null && newValue == null) {
			if (oldValue instanceof EList) {
				EList<Proposal> proposals = (EList<Proposal>) oldValue;
				for (Proposal p : proposals) {
					removeAssessmentEAdapter(p);
				}
			} else {
				removeAssessmentEAdapter((Proposal) oldValue);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void handleCriteria(Object oldValue, Object newValue) {
		if (oldValue == null && newValue != null) {
			if (newValue instanceof EList) {
				EList<Criterion> criteria = (EList<Criterion>) newValue;
				for (Criterion c : criteria) {
					addAssessmentEAdapter(c);
				}
			} else {
				addAssessmentEAdapter((Criterion) newValue);
			}
		} else if (oldValue != null && newValue == null) {
			if (oldValue instanceof EList) {
				EList<Criterion> criteria = (EList<Criterion>) oldValue;
				for (Criterion c : criteria) {
					removeAssessmentEAdapter(c);
				}
			} else {
				removeAssessmentEAdapter((Criterion) oldValue);
			}
		}
	}

	private void handleCriterionMessage(Notification msg) {
		if (msg.getFeature() instanceof EAttribute && ((EAttribute) msg.getFeature()).getName().equals("name")) {
			Criterion c = (Criterion) msg.getNotifier();
			if (issue != null && issue.getCriteria().contains(c)) {
				rebuildMatrix();
			}
		}
	}

	private void handleProposalMessage(Notification msg) {
		if (msg.getFeature() instanceof EAttribute && ((EAttribute) msg.getFeature()).getName().equals("name")) {
			Proposal p = (Proposal) msg.getNotifier();
			if (issue != null && issue.getProposals().contains(p)) {
				rebuildMatrix();
			}
		}
	}

	private void handleAssessmentMessage(Notification msg) {
		if (msg.getFeature() instanceof EAttribute && ((EAttribute) msg.getFeature()).getName().equals("value")) {
			Assessment a = (Assessment) msg.getNotifier();
			if (a.getProposal().getIssue().equals(issue)) {
				updateAssessmentSum(a.getProposal());
			}
		}
	}

	private void removeAssessmentEAdapter(Proposal p) {
		p.eAdapters().remove((eAdapter));
		EList<Criterion> criteria = issue.getCriteria();
		EList<Assessment> assessments = p.getAssessments();
		for (Assessment a : assessments) {
			if (criteria.contains(a.getCriterion())) {
				a.eAdapters().remove(eAdapter);
			}
		}
	}

	private void removeAssessmentEAdapter(Criterion c) {
		c.eAdapters().remove((eAdapter));
		EList<Proposal> proposals = issue.getProposals();
		EList<Assessment> assessments = c.getAssessments();
		for (Assessment a : assessments) {
			if (proposals.contains(a.getProposal())) {
				a.eAdapters().remove(eAdapter);
			}
		}

	}

	private void addAssessmentEAdapter(Proposal p) {
		p.eAdapters().add((eAdapter));
		EList<Criterion> criteria = issue.getCriteria();
		EList<Assessment> assessments = p.getAssessments();
		for (Assessment a : assessments) {
			if (criteria.contains(a.getCriterion())) {
				a.eAdapters().add(eAdapter);
			}
		}
	}

	private void addAssessmentEAdapter(Criterion c) {
		c.eAdapters().add((eAdapter));
		EList<Proposal> proposals = issue.getProposals();
		EList<Assessment> assessments = c.getAssessments();
		for (Assessment a : assessments) {
			if (proposals.contains(a.getProposal())) {
				a.eAdapters().add(eAdapter);
			}
		}

	}

}
