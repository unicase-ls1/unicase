/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols.issuecontrol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.view.spi.model.ModelChangeListener;
import org.eclipse.emf.ecp.view.spi.model.ModelChangeNotification;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.impl.RationaleFactoryImpl;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractUnicaseMEControl;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.uccontrol.ControlFactory;

/**
 * Class displays assessment matrix for issues.
 * 
 * @author lars
 */
public class AssessmentMatrixControl extends AbstractUnicaseMEControl {

	private static final int MAX_LENGTH_CRITERIA_NAME = 20;
	private static final int PRIORITY = 2;

	private Composite mainComposite;
	private Composite matrixSection;
	private Section section;
	private int parentStyle;

	private ArrayList<AbstractMEControl> assessmentControls = new ArrayList<AbstractMEControl>();
	private HashMap<Proposal, Label> allSumLabels = new HashMap<Proposal, Label>();
	private HashMap<Proposal, Composite> allSumLabelContainer = new HashMap<Proposal, Composite>();

	private CriterionListener criterionListener;
	private IssueListener issueListener;
	private AssessmentListener assessmentListener;
	private ProposalListener proposalListener;

	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	private Issue issue;

	/**
	 * Method is responsible to create the assessment matrix control.
	 * 
	 * @param parent
	 *            containing parent composite
	 * @param style
	 *            used style
	 * @return the corresponding control
	 */
	@Override
	public Control createControl(Composite parent, int style) {

		// check if null or not an issue
		if (getModelElement() == null || !(getModelElement() instanceof Issue)) {
			throw new IllegalArgumentException("Expected "
					+ Issue.class.getCanonicalName() + ", was "
					+ getModelElement());
		}
		issue = (Issue) getModelElement();

		// adapter factory item delegator

		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		// instantiate listeners

		issueListener = new IssueListener();
		criterionListener = new CriterionListener();
		assessmentListener = new AssessmentListener();
		proposalListener = new ProposalListener();

		issue.addModelElementChangeListener(issueListener);
		for (Criterion criterion : issue.getCriteria()) {
			criterion.addModelElementChangeListener(criterionListener);
		}
		for (Proposal proposal : issue.getProposals()) {
			proposal.addModelElementChangeListener(proposalListener);
			for (Assessment assessment : proposal.getAssessments()) {
				if (issue.getCriteria().contains(assessment.getCriterion())) {
					assessment
							.addModelElementChangeListener(assessmentListener);
				}
			}
		}

		// Layout

		mainComposite = parent;
		parentStyle = style;
		section = getToolkit().createSection(parent,
				Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText("Assessment Matrix");
		mainComposite = getToolkit().createComposite(section);
		mainComposite.setLayout(new GridLayout(1, true));
		mainComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// assessment control area

		int numberOfCriteria = issue.getCriteria().size();

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
	 * used to close the control. removes all listener and closes all containing
	 * controls.
	 */
	@Override
	public void dispose() {

		// dispose controls
		disposeControls();

		if (issue != null) {
			for (Proposal proposal : issue.getProposals()) {
				proposal.removeModelElementChangeListener(proposalListener);
			}
			for (Criterion criterion : issue.getCriteria()) {
				criterion.removeModelElementChangeListener(criterionListener);
			}
			for (Proposal proposal : issue.getProposals()) {
				for (Assessment assessment : proposal.getAssessments()) {
					if (issue.getCriteria().contains(assessment.getCriterion())) {
						assessment
								.removeModelElementChangeListener(assessmentListener);
					}
				}
			}
		}

		issue.removeModelElementChangeListener(issueListener);
	}

	/**
	 * Rebuilds the assessment matrix after changes.
	 */
	private void rebuildMatrix() {
		disposeControls();

		EList<Proposal> proposals = issue.getProposals();
		EList<Criterion> criteria = issue.getCriteria();

		int numberOfCriteria = criteria.size();

		if (numberOfCriteria > 0 && proposals.size() > 0) {
			matrixSection = getToolkit().createComposite(mainComposite);
			matrixSection
					.setLayout(new GridLayout(numberOfCriteria + 4, false));
		} else {
			mainComposite.layout(true);
			section.setExpanded(false);
			return;
		}

		// layout
		GridData matrixAreaGridData = new GridData(GridData.FILL_HORIZONTAL);
		matrixAreaGridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		matrixSection.setLayoutData(matrixAreaGridData);

		// Building Headline
		getToolkit().createLabel(matrixSection, "");
		getToolkit().createLabel(matrixSection, "          ");
		for (int i = 0; i < criteria.size(); i++) {
			final Hyperlink hyperlink = getToolkit().createHyperlink(
					matrixSection, cutStringName(criteria.get(i).getName()),
					parentStyle);
			GridData hyperLinkGridData = new GridData(GridData.FILL_HORIZONTAL);
			hyperLinkGridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
			hyperlink.setLayoutData(hyperLinkGridData);
			hyperlink.layout();
			IHyperlinkListener listener = new MEHyperLinkAdapter(
					criteria.get(i), issue, RationalePackage.eINSTANCE
							.getIssue_Criteria().getName());
			hyperlink.addHyperlinkListener(listener);
		}

		if (proposals.size() > 0) {
			getToolkit().createLabel(matrixSection, "          ");
			getToolkit().createLabel(matrixSection, " SUM ");
		}

		for (int p = 0; p < proposals.size(); p++) {
			Proposal currentProposal = proposals.get(p);
			final Hyperlink hyperlink = getToolkit().createHyperlink(
					matrixSection, currentProposal.getName(), parentStyle);
			IHyperlinkListener listener = new MEHyperLinkAdapter(
					currentProposal, issue, RationalePackage.eINSTANCE
							.getIssue_Proposals().getName());
			hyperlink.addHyperlinkListener(listener);
			getToolkit().createLabel(matrixSection, "     ");
			for (int i = 0; i < criteria.size(); i++) {
				Criterion criterion = criteria.get(i);
				Assessment assessment = getAssessment(currentProposal,
						criterion);
				ControlFactory cFactory = new ControlFactory();
				final IItemPropertyDescriptor pDescriptorAssessmentValue = adapterFactoryItemDelegator
						.getPropertyDescriptor(assessment, "value");
				AbstractMEControl assessmentControlDescription = cFactory
						.createControl(pDescriptorAssessmentValue, assessment);
				this.assessmentControls.add(assessmentControlDescription);

				Composite comp = getToolkit().createComposite(matrixSection);
				assessmentControlDescription.createControl(comp, parentStyle,
						pDescriptorAssessmentValue, assessment, getToolkit());
				comp.setLayout(new GridLayout(1, true));
				GridData gridData = new GridData();
				gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
				comp.setLayoutData(gridData);
			}
			getToolkit().createLabel(matrixSection, "          ");
			Composite sumLabelComposite = getToolkit().createComposite(
					matrixSection);
			sumLabelComposite.setLayout(new GridLayout(1, true));
			allSumLabels.put(
					currentProposal,
					getToolkit().createLabel(sumLabelComposite,
							" " + computeAssessmentSum(currentProposal) + " "));
			sumLabelComposite.layout();
			allSumLabelContainer.put(currentProposal, sumLabelComposite);
		}

		matrixSection.layout();

		mainComposite.layout(true);
		section.setExpanded(false);
		section.setExpanded(true);
	}

	private void disposeControls() {
		matrixSection.dispose();
		for (AbstractMEControl assessmentControl : this.assessmentControls) {
			assessmentControl.dispose();
		}
		assessmentControls.clear();
	}

	private String cutStringName(String inputString) {
		if (inputString.length() <= (MAX_LENGTH_CRITERIA_NAME - 3)) {
			int diff = (MAX_LENGTH_CRITERIA_NAME - inputString.length()) / 2;
			for (int i = 0; i < diff; i++) {
				inputString = " " + inputString + " ";
			}
			return inputString;
		}
		String retValue = inputString
				.substring(0, MAX_LENGTH_CRITERIA_NAME - 3);
		retValue = retValue + "...";
		return retValue;
	}

	private Assessment getAssessment(final Proposal p, final Criterion c) {

		EList<Assessment> assessmentsOfProposal = p.getAssessments();
		for (int i = 0; i < assessmentsOfProposal.size(); i++) {
			Assessment currentAssessment = assessmentsOfProposal.get(i);
			if (currentAssessment.getCriterion() != null) {
				if (currentAssessment.getCriterion().equals(c)) {
					return assessmentsOfProposal.get(i);
				}
			}
		}
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				RationaleFactory rFactory = RationaleFactoryImpl.init();
				Assessment assessment = rFactory.createAssessment();
				assessment.setName("new Assessment");
				assessment.setProposal(p);
				assessment.setCriterion(c);
				assessment.addModelElementChangeListener(assessmentListener);
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

	private void removeAssessmentListener(Proposal proposal) {
		proposal.removeModelElementChangeListener(proposalListener);
		for (Assessment assessment : proposal.getAssessments()) {
			if (issue.getCriteria().contains(assessment.getCriterion())) {
				assessment.removeModelElementChangeListener(assessmentListener);
			}
		}
	}

	private void removeAssessmentListener(Criterion criterion) {
		criterion.removeModelElementChangeListener(criterionListener);
		for (Assessment assessment : criterion.getAssessments()) {
			if (issue.getProposals().contains(assessment.getProposal())) {
				assessment.removeModelElementChangeListener(assessmentListener);
			}
		}
	}

	private void addAssessmentListener(Proposal proposal) {
		proposal.addModelElementChangeListener(proposalListener);
		for (Assessment assessment : proposal.getAssessments()) {
			if (issue.getCriteria().contains(assessment.getCriterion())) {
				assessment.addModelElementChangeListener(assessmentListener);
			}
		}
	}

	private void addAssessmentListener(Criterion criterion) {
		criterion.addModelElementChangeListener(criterionListener);
		for (Assessment assessment : criterion.getAssessments()) {
			if (issue.getProposals().contains(assessment.getProposal())) {
				assessment.addModelElementChangeListener(assessmentListener);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
			EObject modelElement) {
		if (!(modelElement instanceof Issue)) {
			return DO_NOT_RENDER;
		}
		if (!((EReference) (itemPropertyDescriptor.getFeature(modelElement)))
				.getName().equals("assessments")) {
			return DO_NOT_RENDER;
		}

		return PRIORITY;
	}

	/**
	 * Listener for changes on issues.
	 * 
	 * @author borner
	 */
	public class IssueListener implements ModelChangeListener {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onChange(org.eclipse.emf.common.notify.Notification)
		 */
		public void onChange(Notification notification) {
			if (notification.getFeature() instanceof EReference) {
				EReference reference = (EReference) notification.getFeature();
				Object oldValue = notification.getOldValue();
				Object newValue = notification.getNewValue();
				if (reference.getName().equals("criteria")) {
					handleCriteria(oldValue, newValue);
					rebuildMatrix();
				} else if (reference.getName().equals("proposals")) {
					handleProposals(oldValue, newValue);
					rebuildMatrix();
				}
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onRuntimeExceptionInListener(java.lang.RuntimeException)
		 */
		public void onRuntimeExceptionInListener(RuntimeException exception) {
			// do nothing
		}

		@SuppressWarnings("unchecked")
		private void handleCriteria(Object oldValue, Object newValue) {
			if (oldValue == null && newValue != null) {
				if (newValue instanceof EList) {
					EList<Criterion> criteria = (EList<Criterion>) newValue;
					for (Criterion c : criteria) {
						addAssessmentListener(c);
					}
				} else {
					addAssessmentListener((Criterion) newValue);
				}
			} else if (oldValue != null && newValue == null) {
				if (oldValue instanceof EList) {
					EList<Criterion> criteria = (EList<Criterion>) oldValue;
					for (Criterion c : criteria) {
						removeAssessmentListener(c);
					}
				} else if (oldValue != Collections.EMPTY_LIST) {
					removeAssessmentListener((Criterion) oldValue);
				}
			}
		}

		@SuppressWarnings("unchecked")
		private void handleProposals(Object oldValue, Object newValue) {
			if (oldValue == null && newValue != null) {
				if (newValue instanceof EList<?>) {
					EList<Proposal> proposals = (EList<Proposal>) newValue;
					for (Proposal p : proposals) {
						addAssessmentListener(p);
					}
				} else {
					addAssessmentListener((Proposal) newValue);
				}
			} else if (oldValue != null && newValue == null) {
				if (oldValue instanceof EList<?>) {
					EList<Proposal> proposals = (EList<Proposal>) oldValue;
					for (Proposal p : proposals) {
						removeAssessmentListener(p);
					}
				} else if (oldValue != Collections.EMPTY_LIST) {
					removeAssessmentListener((Proposal) oldValue);
				}
			}
		}

		public void notifyChange(ModelChangeNotification notification) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * Listener to listen on changes of issue criterions.
	 * 
	 * @author borner
	 */
	public class CriterionListener implements ModelChangeListener {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onChange(org.eclipse.emf.common.notify.Notification)
		 */
		public void onChange(Notification notification) {
			if (notification.getNotifier() instanceof Criterion) {
				if (notification.getFeature() instanceof EAttribute
						&& ((EAttribute) notification.getFeature()).getName()
								.equals("name")) {
					Criterion c = (Criterion) notification.getNotifier();
					if (issue != null && issue.getCriteria().contains(c)) {
						rebuildMatrix();
					}
				}
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onRuntimeExceptionInListener(java.lang.RuntimeException)
		 */
		public void onRuntimeExceptionInListener(RuntimeException exception) {
			// do nothing
		}

		public void notifyChange(ModelChangeNotification notification) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Listener for changes on proposals.
	 * 
	 * @author koegel
	 */
	public class ProposalListener implements ModelChangeListener {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onChange(org.eclipse.emf.common.notify.Notification)
		 */
		public void onChange(Notification notification) {
			if (notification.getNotifier() instanceof Proposal) {
				if (notification.getFeature() instanceof EAttribute
						&& ((EAttribute) notification.getFeature()).getName()
								.equals("name")) {
					Proposal p = (Proposal) notification.getNotifier();
					if (issue != null && issue.getProposals().contains(p)) {
						rebuildMatrix();
					}
				}
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onRuntimeExceptionInListener(java.lang.RuntimeException)
		 */
		public void onRuntimeExceptionInListener(RuntimeException exception) {
			// do nothing
		}

		public void notifyChange(ModelChangeNotification notification) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * Listener for changes on assessments.
	 * 
	 * @author borner
	 */
	public class AssessmentListener implements ModelChangeListener {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onChange(org.eclipse.emf.common.notify.Notification)
		 */
		public void onChange(Notification notification) {
			if ((notification.getNotifier() instanceof Assessment)) {
				if (notification.getFeature() instanceof EAttribute
						&& ((EAttribute) notification.getFeature()).getName()
								.equals("value")) {
					Assessment assessment = (Assessment) notification
							.getNotifier();
					if (assessment.getProposal().getIssue().equals(issue)) {
						updateAssessmentSum(assessment.getProposal());
					}
				}
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.metamodel.util.ModelElementChangeListener#onRuntimeExceptionInListener(java.lang.RuntimeException)
		 */
		public void onRuntimeExceptionInListener(RuntimeException exception) {
			// do nothing
		}

		public void notifyChange(ModelChangeNotification notification) {
			// TODO Auto-generated method stub

		}

	}
}
