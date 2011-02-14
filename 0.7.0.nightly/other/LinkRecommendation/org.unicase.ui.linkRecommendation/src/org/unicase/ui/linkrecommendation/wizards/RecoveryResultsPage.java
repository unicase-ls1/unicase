/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.linkrecommendation.wizards;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewerFocusCellManager;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.recommendation.ConstantThresholdSelection;
import org.unicase.metamodel.recommendation.RecommendationManager;
import org.unicase.ui.common.util.ActionHelper;

/**
 * @author henning femmer
 */
public class RecoveryResultsPage extends WizardPage implements IDoubleClickListener, ISelectionChangedListener {

	private static final double THRESHOLD = 0.7;
	private static final String TITLE = "Link Creation";
	private static final String DESCRIPTION = "Select the links you want to create.";

	private CheckboxTableViewer tableViewer;
	private Table resultsTable;
	private TableColumn ref, baseElement, targetElement, prob;
	private Project project;

	private Collection<EReference> relevantReferences;
	private Collection<EClass> relevantTargetClasses;

	private TableViewerFocusCellManager cellFocusManager;
	private Collection<ModelElement> baseModelElements;
	private boolean targetClassRestriction;

	private Collection<RecommendationTableElement> tableElements;

	/**
	 * the constructor.
	 * 
	 * @param p the project
	 */
	protected RecoveryResultsPage(Project p) {
		super(TITLE);
		this.setTitle(TITLE);
		this.setDescription(DESCRIPTION);
		this.project = p;
		this.targetClassRestriction = true;

		this.tableElements = new LinkedList<RecommendationTableElement>();
	}

	/**
	 * Returns true if links are selected.
	 * 
	 * @return true if links are selected, false otherwise
	 */
	public boolean isElementsSelected() {
		return this.tableViewer.getCheckedElements().length > 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		resultsTable = new Table(composite, SWT.VIRTUAL | SWT.CHECK | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER
			| SWT.HIDE_SELECTION);
		resultsTable.setBounds(new org.eclipse.swt.graphics.Rectangle(5, 5, 650, 400));
		resultsTable.setLinesVisible(true);
		resultsTable.setHeaderVisible(true);

		tableViewer = new CheckboxTableViewer(resultsTable);
		// tableViewer.
		tableViewer.setLabelProvider(new MyTableLabelProvider());
		tableViewer.setContentProvider(new IStructuredContentProvider() {
			public Object[] getElements(Object inputElement) {
				// return (RecommendationTableElement[]) inputElement;
				return tableElements.toArray();
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});

		cellFocusManager = new TableViewerFocusCellManager(tableViewer, new FocusCellOwnerDrawHighlighter(tableViewer));

		ref = createColumn(0);
		baseElement = createColumn(1);
		targetElement = createColumn(2);
		prob = createColumn(3);

		tableViewer.addDoubleClickListener(this);
		tableViewer.addSelectionChangedListener(this);
		tableViewer.setSorter(new ProbabilitySorter());

		// if elements are added to this list
		tableViewer.setInput(tableElements.toArray());

		setControl(composite);
	}

	private TableColumn createColumn(final int index) {
		String[] title = { "Reference", "Base Element", "Candidate", "Probability" };
		int[] width = { 100, 200, 200, 100 };

		TableColumn column = new TableColumn(resultsTable, SWT.NONE);
		column.setWidth(width[index]);
		column.setText(title[index]);
		return column;
	}

	/**
	 * Calculates the suggestions and presents them in the page.
	 */
	public void calculateSuggestions() {

		if (baseModelElements == null || baseModelElements.size() == 0) {
			MessageDialog.openError(this.getShell(), "Error", "No base elements selected.");
			return;
		}
		if (relevantReferences == null || relevantReferences.size() == 0) {
			MessageDialog.openError(this.getShell(), "Error", "No references selected.");
			return;
		}
		if (targetClassRestriction && (relevantTargetClasses == null || relevantTargetClasses.size() == 0)) {
			MessageDialog.openError(this.getShell(), "Error", "No target classes selected.");
			return;
		}

		tableElements.clear();

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getShell());
		dialog.setCancelable(true);
		dialog.open();

		dialog.getProgressMonitor().beginTask(
			"Calculating suggestions for " + baseModelElements.size() + " ModelElements with "
				+ relevantReferences.size() + " references.", baseModelElements.size());
		int count = baseModelElements.size();

		for (ModelElement modelElement : baseModelElements) {
			dialog.getProgressMonitor().setTaskName("Calculating suggestions for " + (count--) + " ModelElements.");
			dialog.getProgressMonitor().worked(1);

			List<EReference> refs = modelElement.eClass().getEAllReferences();
			for (EReference eReference : refs) {
				// check references
				if (relevantReferences.contains(eReference)) {

					// calc possible elements
					Collection<ModelElement> candidates = getCandidates(modelElement, eReference);

					// make suggestion
					Map<ModelElement, Double> suggestion = RecommendationManager.getInstance().getMatchMap(
						modelElement, eReference, candidates, new ConstantThresholdSelection(THRESHOLD));

					// present suggestion
					for (ModelElement suggestedME : suggestion.keySet()) {
						RecommendationTableElement newRec = new RecommendationTableElement(eReference, modelElement,
							suggestedME, suggestion.get(suggestedME));

						tableElements.add(newRec);
					}

				}
			}

		}

		dialog.getProgressMonitor().done();
		dialog.close();

		if (tableViewer != null) {
			tableViewer.setInput(tableElements.toArray());
		}
	}

	@SuppressWarnings("unchecked")
	private Collection<ModelElement> getCandidates(ModelElement modelElement, EReference eReference) {
		EClass clazz = eReference.getEReferenceType();
		Collection<ModelElement> allCandidates = modelElement.getProject().getAllModelElementsbyClass(clazz,
			new BasicEList<ModelElement>());
		Collection<ModelElement> candidates = new LinkedList<ModelElement>();
		Object existing = modelElement.eGet(eReference);

		// remove candidates we don't want to check
		if (targetClassRestriction) {
			for (ModelElement me : allCandidates) {
				if (relevantTargetClasses.contains(me.eClass())) {
					candidates.add(me);
				}
			}
		} else {
			candidates = allCandidates;
		}

		EList<EObject> eList = null;
		// don't add the instances that are already linked
		if (eReference.isMany() && existing instanceof EList<?>) {
			eList = (EList<EObject>) existing;
			for (EObject ref : eList) {
				candidates.remove(ref);
			}
		} else if (!eReference.isMany() && existing instanceof EObject) {
			candidates.remove(existing);
		}

		// remove the items themselves
		candidates.remove(modelElement);

		// don't show contained elements for inverse containment references
		if (eReference.isContainer()) {
			candidates.removeAll(modelElement.eContents());
		}

		// take care of circular references
		if (eReference.isContainment()) {
			Iterator<ModelElement> iter = candidates.iterator();
			while (iter.hasNext()) {
				ModelElement me = iter.next();
				if (EcoreUtil.isAncestor(me, modelElement)) {
					iter.remove();
				}
			}
		}

		return candidates;
	}

	/**
	 * sets the project.
	 * 
	 * @param p the project
	 */
	public void setProject(Project p) {
		this.project = p;
	}

	/**
	 * Sets the base elements.
	 * 
	 * @param elements the base elements.
	 */
	public void setBaseElements(Collection<ModelElement> elements) {
		baseModelElements = new LinkedList<ModelElement>();
		this.baseModelElements = elements;
	}

	/**
	 * sets the base elements according to the classes.
	 * 
	 * @param relevants the relevants
	 */
	public void setRelevantBaseClasses(Collection<EClass> relevants) {
		baseModelElements = new LinkedList<ModelElement>();
		for (EClass baseClass : relevants) {
			baseModelElements.addAll(project.getAllModelElementsbyClass(baseClass, new BasicEList<ModelElement>()));
		}
	}

	/**
	 * Sets the references.
	 * 
	 * @param relevants the references
	 */
	public void setRelevantReferences(Collection<EReference> relevants) {
		this.relevantReferences = relevants;
	}

	/**
	 * Set the target classes.
	 * 
	 * @param relevants the relevants
	 */
	public void setRelevantTargetClasses(Collection<EClass> relevants) {
		this.relevantTargetClasses = relevants;
	}

	/**
	 * Sets no restriction to target classes, if false is given as parameter.
	 * 
	 * @param restriction true if enabled (default), false otherwise
	 */
	public void setTargetClassRestrictionEnabled(boolean restriction) {
		targetClassRestriction = restriction;
	}

	/**
	 * This object represents an item in the table.
	 * 
	 * @author henning femmer
	 */
	public class RecommendationTableElement {
		private ModelElement base;
		private ModelElement target;
		private EReference reference;
		private Double prob;

		/**
		 * A class reflecting rows in the table.
		 * 
		 * @param reference the reference
		 * @param base the base
		 * @param target the target
		 * @param prob the probability
		 */
		RecommendationTableElement(EReference reference, ModelElement base, ModelElement target, Double prob) {
			this.base = base;
			this.target = target;
			this.reference = reference;
			this.prob = prob;
		}

		/**
		 * returns the base element.
		 * 
		 * @return the base
		 */
		public ModelElement getBase() {
			return base;
		}

		/**
		 * returns the target element.
		 * 
		 * @return the target
		 */
		public ModelElement getTarget() {
			return target;
		}

		/**
		 * returns the reference.
		 * 
		 * @return the reference
		 */
		public EReference getReference() {
			return reference;
		}

		/**
		 * returns the probability.
		 * 
		 * @return the probability
		 */
		public Double getProb() {
			return prob;
		}
	}

	/**
	 * Return all checked elements.
	 * 
	 * @return the checked elements.
	 */
	public Collection<RecommendationTableElement> getSelected() {

		Object[] selected = this.tableViewer.getCheckedElements();

		Collection<RecommendationTableElement> result = new LinkedList<RecommendationTableElement>();
		for (Object o : selected) {
			if (o instanceof RecommendationTableElement) {
				result.add((RecommendationTableElement) o);
			}
		}

		return result;
	}

	/**
	 * This class provides lables for the table.
	 * 
	 * @author Henning Femmer
	 */
	private class MyTableLabelProvider extends AdapterFactoryLabelProvider {
		public MyTableLabelProvider() {
			super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof RecommendationTableElement) {
				RecommendationTableElement obj = (RecommendationTableElement) element;
				if (columnIndex == resultsTable.indexOf(prob)) {
					return null;
				} else if (columnIndex == resultsTable.indexOf(ref)) {
					return super.getImage(obj.getReference());
				} else if (columnIndex == resultsTable.indexOf(baseElement)) {
					return super.getImage(obj.getBase());
				} else if (columnIndex == resultsTable.indexOf(targetElement)) {
					return super.getImage(obj.getTarget());
				}
			}
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof RecommendationTableElement) {
				RecommendationTableElement obj = (RecommendationTableElement) element;
				if (columnIndex == resultsTable.indexOf(prob)) {
					return obj.getProb().toString();
				} else if (columnIndex == resultsTable.indexOf(ref)) {
					return super.getText(obj.getReference());
				} else if (columnIndex == resultsTable.indexOf(baseElement)) {
					return super.getText(obj.getBase());
				} else if (columnIndex == resultsTable.indexOf(targetElement)) {
					return super.getText(obj.getTarget());
				}
			}
			return "";
		}
	}

	/**
	 * Opens the clicked ModelElements Editor. {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
	 */
	public void doubleClick(DoubleClickEvent event) {
		if (cellFocusManager.getFocusCell().getColumnIndex() == resultsTable.indexOf(baseElement)) {
			ActionHelper.openModelElement(
				((RecommendationTableElement) cellFocusManager.getFocusCell().getElement()).base, this.getClass()
					.getName());
		} else if (cellFocusManager.getFocusCell().getColumnIndex() == resultsTable.indexOf(targetElement)) {
			ActionHelper.openModelElement(
				((RecommendationTableElement) cellFocusManager.getFocusCell().getElement()).target, this.getClass()
					.getName());

		}
	}

	/**
	 * refreshes the buttons.
	 * 
	 * @param event not used.
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		getWizard().getContainer().updateButtons();
	}

	/**
	 * @author henning
	 */
	private class ProbabilitySorter extends ViewerSorter {
		@Override
		public int compare(Viewer viewer, Object obj1, Object obj2) {
			RecommendationTableElement e1 = (RecommendationTableElement) obj1;
			RecommendationTableElement e2 = (RecommendationTableElement) obj2;

			return -e1.prob.compareTo(e2.prob);
		}
	}

}
