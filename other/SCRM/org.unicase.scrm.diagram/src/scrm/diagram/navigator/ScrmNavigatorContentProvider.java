package scrm.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import scrm.diagram.edit.parts.AssumptionEditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataFlowEditPart;
import scrm.diagram.edit.parts.DataHandlingEditPart;
import scrm.diagram.edit.parts.ErrorHandlingEditPart;
import scrm.diagram.edit.parts.Feature2EditPart;
import scrm.diagram.edit.parts.FeatureConstraintsEditPart;
import scrm.diagram.edit.parts.FeatureDependenciesEditPart;
import scrm.diagram.edit.parts.FeatureDetailedRequirementsEditPart;
import scrm.diagram.edit.parts.FeatureEditPart;
import scrm.diagram.edit.parts.FeatureExcludedFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureProvidedInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredInterfacesEditPart;
import scrm.diagram.edit.parts.HardwareEditPart;
import scrm.diagram.edit.parts.InputDataReadingEditPart;
import scrm.diagram.edit.parts.MathematicalModel2EditPart;
import scrm.diagram.edit.parts.MathematicalModel3EditPart;
import scrm.diagram.edit.parts.MathematicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.MathematicalModelEditPart;
import scrm.diagram.edit.parts.MathematicalModelNumericalMethodsEditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodRealizingRequirementEditPart;
import scrm.diagram.edit.parts.PerformanceEditPart;
import scrm.diagram.edit.parts.ProcessDataFlowEditPart;
import scrm.diagram.edit.parts.ProcessEditPart;
import scrm.diagram.edit.parts.RequirementDefiningDataEditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.ResultsOutputEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.edit.parts.ScientificKnowledgeRequirementsEditPart;
import scrm.diagram.edit.parts.ScientificProblemEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.edit.parts.ScientificProblemRepresentingModelEditPart;
import scrm.diagram.edit.parts.ScientificProblemSolvingMethodEditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
import scrm.diagram.edit.parts.UserInterfaceEditPart;
import scrm.diagram.part.Messages;
import scrm.diagram.part.ScrmVisualIDRegistry;

/**
 * @generated
 */
public class ScrmNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	public ScrmNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), SCRMDiagramEditPart.MODEL_ID),
				file, false));
			return result.toArray();
		}

		if (parentElement instanceof ScrmNavigatorGroup) {
			ScrmNavigatorGroup group = (ScrmNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof ScrmNavigatorItem) {
			ScrmNavigatorItem navigatorItem = (ScrmNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (ScrmVisualIDRegistry.getVisualID(view)) {

		case SCRMDiagramEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup links = new ScrmNavigatorGroup(Messages.NavigatorGroupName_SCRMDiagram_1000_links,
				"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(AssumptionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(HardwareEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ConstraintEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(UserInterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(InputDataReadingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataHandlingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ResultsOutputEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ErrorHandlingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(StatusMonitoringEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemSolvingMethodEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModel2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModel3EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelNumericalMethodsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelDependenciesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureConstraintsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDependenciesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(Feature2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessDataFlowEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case ScientificProblemEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificProblem_2007_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemSolvingMethodEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case MathematicalModelEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModel_2005_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModel_2005_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModel2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModel2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModel3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModel3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelNumericalMethodsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case NumericalMethodEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethod_2006_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethod_2006_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemSolvingMethodEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelNumericalMethodsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AssumptionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Assumption_2008_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Assumption_2008_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case FeatureEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Feature_2009_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Feature_2009_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureConstraintsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(Feature2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(Feature2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case HardwareEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Hardware_2010_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ConstraintEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Constraint_2011_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureConstraintsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case UserInterfaceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_UserInterface_2012_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SoftwareInterfaceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_SoftwareInterface_2013_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ProcessEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Process_2014_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Process_2014_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessDataFlowEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PerformanceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Performance_2015_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_Performance_2015_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DataFlowEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_DataFlow_2016_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_DataFlow_2016_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessDataFlowEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DataDefinitionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_DataDefinition_2017_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_DataDefinition_2017_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InputDataReadingEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_InputDataReading_2018_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_InputDataReading_2018_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DataHandlingEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_DataHandling_2019_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_DataHandling_2019_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ResultsOutputEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ResultsOutput_2020_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ResultsOutput_2020_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ErrorHandlingEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ErrorHandling_2021_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ErrorHandling_2021_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StatusMonitoringEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_StatusMonitoring_2022_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_StatusMonitoring_2022_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificKnowledgeRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureDetailedRequirementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(RequirementDefiningDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ScientificKnowledgeRequirementsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificKnowledgeRequirements_4005_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificKnowledgeRequirements_4005_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(HardwareEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(AssumptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ScientificProblemRepresentingModelEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificProblemRepresentingModel_4006_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificProblemRepresentingModel_4006_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ScientificProblemSolvingMethodEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificProblemSolvingMethod_4007_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificProblemSolvingMethod_4007_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificProblemInfluencedFeature_4008_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_ScientificProblemInfluencedFeature_4008_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ScientificProblemEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case MathematicalModel2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModel_4004_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModel_4004_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case MathematicalModel3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModel_4010_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModel_4010_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case MathematicalModelNumericalMethodsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModelNumericalMethods_4011_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModelNumericalMethods_4011_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case MathematicalModelDependenciesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModelDependencies_4012_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_MathematicalModelDependencies_4012_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(AssumptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(MathematicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case NumericalMethodDependenciesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethodDependencies_4015_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethodDependencies_4015_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(AssumptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethodRealizingRequirement_4016_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethodRealizingRequirement_4016_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case NumericalMethodPerformanceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethodPerformance_4017_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_NumericalMethodPerformance_4017_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureRequiredInterfacesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureRequiredInterfaces_4023_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureRequiredInterfaces_4023_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureProvidedInterfacesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureProvidedInterfaces_4024_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureProvidedInterfaces_4024_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureConstraintsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureConstraints_4025_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureConstraints_4025_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureDependenciesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureDependencies_4026_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureDependencies_4026_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(HardwareEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureDetailedRequirementsEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureDetailedRequirements_4027_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureDetailedRequirements_4027_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case Feature2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(Messages.NavigatorGroupName_Feature_4029_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(Messages.NavigatorGroupName_Feature_4029_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureRequiredFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureRequiredFeatures_4030_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureRequiredFeatures_4030_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureExcludedFeaturesEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureExcludedFeatures_4032_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_FeatureExcludedFeatures_4032_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RequirementEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(Messages.NavigatorGroupName_Requirement_4036_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(Messages.NavigatorGroupName_Requirement_4036_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(InputDataReadingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ResultsOutputEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RequirementDefiningDataEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_RequirementDefiningData_4038_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
				Messages.NavigatorGroupName_RequirementDefiningData_4038_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(PerformanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataDefinitionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(InputDataReadingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ResultsOutputEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ProcessDataFlowEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(Messages.NavigatorGroupName_ProcessDataFlow_4040_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(Messages.NavigatorGroupName_ProcessDataFlow_4040_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(DataFlowEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), ScrmVisualIDRegistry
				.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return SCRMDiagramEditPart.MODEL_ID.equals(ScrmVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent, boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new ScrmNavigatorItem((View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof ScrmAbstractNavigatorItem) {
			ScrmAbstractNavigatorItem abstractNavigatorItem = (ScrmAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}