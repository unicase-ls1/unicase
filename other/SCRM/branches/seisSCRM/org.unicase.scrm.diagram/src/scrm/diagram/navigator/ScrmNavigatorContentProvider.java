package scrm.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import scrm.diagram.edit.parts.Assumption2EditPart;
import scrm.diagram.edit.parts.AssumptionEditPart;
import scrm.diagram.edit.parts.ComputationalMesh2EditPart;
import scrm.diagram.edit.parts.ComputationalMeshEditPart;
import scrm.diagram.edit.parts.Constraint2EditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.ConstraintRestrictedFeatureEditPart;
import scrm.diagram.edit.parts.ControlParameter2EditPart;
import scrm.diagram.edit.parts.ControlParameterControlledProcessEditPart;
import scrm.diagram.edit.parts.ControlParameterEditPart;
import scrm.diagram.edit.parts.DataDefinition2EditPart;
import scrm.diagram.edit.parts.DataDefinitionDefinedRequirementEditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataDefinitionProvidedInterfaceEditPart;
import scrm.diagram.edit.parts.DataDefinitionRequiredInterfaceEditPart;
import scrm.diagram.edit.parts.DataProcessSpace2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.DataProcessSpaceEditPart;
import scrm.diagram.edit.parts.ErrorHandling2EditPart;
import scrm.diagram.edit.parts.ErrorHandlingEditPart;
import scrm.diagram.edit.parts.ErrorHandlingHandledProcessEditPart;
import scrm.diagram.edit.parts.Feature2EditPart;
import scrm.diagram.edit.parts.FeatureDependenciesEditPart;
import scrm.diagram.edit.parts.FeatureEditPart;
import scrm.diagram.edit.parts.FeatureExcludedFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureProvidedInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredFeaturesEditPart;
import scrm.diagram.edit.parts.FeatureRequiredInterfacesEditPart;
import scrm.diagram.edit.parts.FeatureSuperFeatureEditPart;
import scrm.diagram.edit.parts.Hardware2EditPart;
import scrm.diagram.edit.parts.HardwareEditPart;
import scrm.diagram.edit.parts.InputDataReading2EditPart;
import scrm.diagram.edit.parts.InputDataReadingEditPart;
import scrm.diagram.edit.parts.InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart;
import scrm.diagram.edit.parts.InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart;
import scrm.diagram.edit.parts.KnowledgeSpace2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceEditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModel2EditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelDependenciesEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelInvolvedDataEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelRefinementsEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart;
import scrm.diagram.edit.parts.MeshCreation2EditPart;
import scrm.diagram.edit.parts.MeshCreationEditPart;
import scrm.diagram.edit.parts.NumericalMethod2EditPart;
import scrm.diagram.edit.parts.NumericalMethodDependenciesEditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.NumericalMethodPerformanceEditPart;
import scrm.diagram.edit.parts.NumericalMethodRealizingRequirementEditPart;
import scrm.diagram.edit.parts.NumericalMethodSolvedProblemEditPart;
import scrm.diagram.edit.parts.Performance2EditPart;
import scrm.diagram.edit.parts.PerformanceEditPart;
import scrm.diagram.edit.parts.PerformanceHardwareEditPart;
import scrm.diagram.edit.parts.PostProcessing2EditPart;
import scrm.diagram.edit.parts.PostProcessingEditPart;
import scrm.diagram.edit.parts.PreProcessing2EditPart;
import scrm.diagram.edit.parts.PreProcessingEditPart;
import scrm.diagram.edit.parts.Process2EditPart;
import scrm.diagram.edit.parts.ProcessEditPart;
import scrm.diagram.edit.parts.ProcessSuccessorEditPart;
import scrm.diagram.edit.parts.Requirement2EditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.RequirementProvidedInterfaceEditPart;
import scrm.diagram.edit.parts.RequirementRefinedRequirementEditPart;
import scrm.diagram.edit.parts.RequirementRequiredInterfaceEditPart;
import scrm.diagram.edit.parts.RequirementSpace2EditPart;
import scrm.diagram.edit.parts.RequirementSpaceEditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.RequirementSpecifiedFeatureEditPart;
import scrm.diagram.edit.parts.ResultsOutput2EditPart;
import scrm.diagram.edit.parts.ResultsOutputEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.edit.parts.ScientificProblem2EditPart;
import scrm.diagram.edit.parts.ScientificProblemEditPart;
import scrm.diagram.edit.parts.ScientificProblemInfluencedFeatureEditPart;
import scrm.diagram.edit.parts.ScientificProblemRepresentingModelEditPart;
import scrm.diagram.edit.parts.SeismicSource2EditPart;
import scrm.diagram.edit.parts.SeismicSourceEditPart;
import scrm.diagram.edit.parts.SoftwareInterface2EditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.Solver2EditPart;
import scrm.diagram.edit.parts.SolverEditPart;
import scrm.diagram.edit.parts.Station2EditPart;
import scrm.diagram.edit.parts.StationEditPart;
import scrm.diagram.edit.parts.StatusMonitoring2EditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
import scrm.diagram.edit.parts.StatusMonitoringMonitoredProcessEditPart;
import scrm.diagram.edit.parts.SyntheticSeismogram2EditPart;
import scrm.diagram.edit.parts.SyntheticSeismogramEditPart;
import scrm.diagram.edit.parts.UserInterface2EditPart;
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
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public ScrmNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
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
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						unloadAllResources();
						asyncRefresh();
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
		myViewer = null;
		unloadAllResources();
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
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
		}
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<ScrmNavigatorItem> result = new ArrayList<ScrmNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews, SCRMDiagramEditPart.MODEL_ID),
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

		case DataDefinition2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinition_3035_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinition_3035_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case NumericalMethodDependenciesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodDependencies_4015_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodDependencies_4015_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(AssumptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Assumption2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethod2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelDependencies_4066_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelDependencies_4066_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(AssumptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Assumption2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case SyntheticSeismogramEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SyntheticSeismogram_2055_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SyntheticSeismogram_2055_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AssumptionEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Assumption_2008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case DataProcessSpaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataProcessSpace_2046_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataProcessSpace_2046_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FeatureExcludedFeaturesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureExcludedFeatures_4032_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureExcludedFeatures_4032_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case NumericalMethodPerformanceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodPerformance_4069_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodPerformance_4069_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethod2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case Hardware2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Hardware_3010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PerformanceHardwareEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SeismicSourceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SeismicSource_2053_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SeismicSource_2053_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ControlParameterControlledProcessEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ControlParameterControlledProcess_4078_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ControlParameterControlledProcess_4078_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameter2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ScientificProblem2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblem_3001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblem_3001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodSolvedProblemEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ResultsOutput2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ResultsOutput_3024_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ResultsOutput_3024_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Mathematical_GeophysicalModelEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModel_2047_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModel_2047_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DataDefinitionDefinedRequirementEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinitionDefinedRequirement_4075_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinitionDefinedRequirement_4075_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSourceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMeshEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogramEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(StationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinition2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSource2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMesh2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogram2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Station2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case HardwareEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Hardware_2010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PerformanceHardwareEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case StatusMonitoringEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_StatusMonitoring_2040_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_StatusMonitoring_2040_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case KnowledgeSpace2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ScientificProblem2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(NumericalMethod2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(
					connectedViews,
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Assumption2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(KnowledgeSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelRefinements_4064_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelRefinements_4064_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case Station2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Station_3039_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Station_3039_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DataDefinitionProvidedInterfaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinitionProvidedInterface_4076_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinitionProvidedInterface_4076_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSourceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMeshEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogramEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(StationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinition2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSource2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMesh2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogram2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Station2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ConstraintEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Constraint_2011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ConstraintRestrictedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SyntheticSeismogram2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SyntheticSeismogram_3038_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SyntheticSeismogram_3038_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FeatureRequiredInterfacesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureRequiredInterfaces_4023_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureRequiredInterfaces_4023_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case Process2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Process_3025_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Process_3025_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RequirementEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Requirement_2034_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Requirement_2034_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StationEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Station_2056_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Station_2056_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ControlParameter2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ControlParameter_3040_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ScientificProblemRepresentingModelEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblemRepresentingModel_4063_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblemRepresentingModel_4063_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblem2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case SCRMDiagramEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			ScrmNavigatorGroup links = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SCRMDiagram_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(AssumptionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(HardwareEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSourceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMeshEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogramEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(StationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodSolvedProblemEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureSuperFeatureEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureDependenciesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ConstraintRestrictedFeatureEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PerformanceHardwareEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case NumericalMethodEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethod_2006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethod_2006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodSolvedProblemEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Feature2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Feature_3009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Feature_3009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureSuperFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureSuperFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ConstraintRestrictedFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InterfaceDetailsOfRequiringFunctionsAndProperties_4071_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InterfaceDetailsOfRequiringFunctionsAndProperties_4071_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RequirementRequiredInterfaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementRequiredInterface_4073_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementRequiredInterface_4073_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ScientificProblemEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblem_2007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblem_2007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodSolvedProblemEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case StatusMonitoring2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_StatusMonitoring_3023_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_StatusMonitoring_3023_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblemInfluencedFeature_4008_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ScientificProblemInfluencedFeature_4008_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblem2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case InputDataReadingEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InputDataReading_2036_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InputDataReading_2036_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case KnowledgeSpaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ScientificProblem2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(NumericalMethod2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(
					connectedViews,
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Assumption2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(KnowledgeSpaceKnowledgeSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(KnowledgeSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case Performance2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Performance_3011_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Performance_3011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PerformanceHardwareEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InterfaceDetailsOfProvidingFunctionsAndProperties_4070_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InterfaceDetailsOfProvidingFunctionsAndProperties_4070_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case UserInterface2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_UserInterface_3014_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_UserInterface_3014_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case MeshCreation2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_MeshCreation_3032_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_MeshCreation_3032_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ComputationalMesh2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ComputationalMesh_3037_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ComputationalMesh_3037_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ConstraintRestrictedFeatureEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ConstraintRestrictedFeature_4051_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ConstraintRestrictedFeature_4051_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Feature_2009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Feature_2009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemInfluencedFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureSuperFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureSuperFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureExcludedFeaturesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ConstraintRestrictedFeatureEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PerformanceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Performance_2015_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Performance_2015_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PerformanceHardwareEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case DataProcessSpace2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataProcessSpace_3029_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataProcessSpace_3029_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceDataProcessSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case UserInterfaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_UserInterface_2012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_UserInterface_2012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Assumption2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Assumption_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case PreProcessing2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PreProcessing_3033_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PreProcessing_3033_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InputDataReading2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InputDataReading_3026_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_InputDataReading_3026_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SeismicSource2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SeismicSource_3036_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SeismicSource_3036_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FeatureSuperFeatureEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureSuperFeature_4053_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureSuperFeature_4053_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RequirementSpecifiedFeatureEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementSpecifiedFeature_4052_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementSpecifiedFeature_4052_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RequirementRefinedRequirementEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementRefinedRequirement_4054_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementRefinedRequirement_4054_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ProcessSuccessorEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ProcessSuccessor_4047_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ProcessSuccessor_4047_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case DataDefinitionRequiredInterfaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinitionRequiredInterface_4077_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinitionRequiredInterface_4077_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSourceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMeshEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogramEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(StationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinition2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSource2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMesh2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogram2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Station2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ControlParameterEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ControlParameter_2057_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelUsedInNumericalMethods_4065_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelUsedInNumericalMethods_4065_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethod2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case MeshCreationEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_MeshCreation_2049_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_MeshCreation_2049_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case NumericalMethodSolvedProblemEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodSolvedProblem_4057_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodSolvedProblem_4057_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblem2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethod2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PostProcessing2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PostProcessing_3034_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PostProcessing_3034_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RequirementProvidedInterfaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementProvidedInterface_4072_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_RequirementProvidedInterface_4072_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PostProcessingEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PostProcessing_2051_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PostProcessing_2051_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Mathematical_GeophysicalModel2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModel_3030_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModel_3030_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ScientificProblemRepresentingModelEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelRefinementsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelInvolvedData_4067_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Mathematical_GeophysicalModelInvolvedData_4067_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSourceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMeshEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogramEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(StationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinition2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SeismicSource2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ComputationalMesh2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogram2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Station2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModel2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case SoftwareInterfaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SoftwareInterface_2013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SoftwareInterface_2013_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case NumericalMethodRealizingRequirementEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodRealizingRequirement_4068_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethodRealizingRequirement_4068_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(RequirementEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethod2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureRequiredFeaturesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureRequiredFeatures_4030_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureRequiredFeatures_4030_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RequirementSpaceEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Hardware2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Constraint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(DataDefinition2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(SeismicSource2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ComputationalMesh2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogram2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Station2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ControlParameter2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(RequirementSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case SolverEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Solver_2048_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Solver_2048_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case NumericalMethod2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethod_3002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_NumericalMethod_3002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodSolvedProblemEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodDependenciesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodPerformanceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ErrorHandling2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ErrorHandling_3027_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ErrorHandling_3027_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ComputationalMeshEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ComputationalMesh_2054_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ComputationalMesh_2054_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Requirement2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Requirement_3012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Requirement_3012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FeatureDependenciesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureDependencies_4026_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureDependencies_4026_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(HardwareEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Hardware2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PreProcessingEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PreProcessing_2050_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PreProcessing_2050_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case SoftwareInterface2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SoftwareInterface_3013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_SoftwareInterface_3013_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureRequiredInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(FeatureProvidedInterfacesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ResultsOutputEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ResultsOutput_2038_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ResultsOutput_2038_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Constraint2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Constraint_3006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ConstraintRestrictedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case StatusMonitoringMonitoredProcessEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_StatusMonitoringMonitoredProcess_4062_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_StatusMonitoringMonitoredProcess_4062_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case PerformanceHardwareEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PerformanceHardware_4074_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_PerformanceHardware_4074_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(HardwareEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Hardware2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(PerformanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case DataDefinitionEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinition_2052_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_DataDefinition_2052_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(Mathematical_GeophysicalModelInvolvedDataEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Solver2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Solver_3031_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Solver_3031_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RequirementSpace2EditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(Requirement2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Hardware2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Constraint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(Performance2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(DataDefinition2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(SeismicSource2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ComputationalMesh2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(SyntheticSeismogram2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry.getType(Station2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(ControlParameter2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(RequirementSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpaceRequirementSpaceCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case ProcessEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Process_2035_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_Process_2035_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ErrorHandlingEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Node sv = (Node) view;
			ScrmNavigatorGroup incominglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ErrorHandling_2039_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup outgoinglinks = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ErrorHandling_2039_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(NumericalMethodRealizingRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRefinedRequirementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementSpecifiedFeatureEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementProvidedInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(RequirementRequiredInterfaceEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ProcessSuccessorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingHandledProcessEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringMonitoredProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataDefinitionDefinedRequirementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ControlParameterControlledProcessEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ErrorHandlingHandledProcessEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ErrorHandlingHandledProcess_4061_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_ErrorHandlingHandledProcess_4061_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(ProcessEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReadingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutputEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoringEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(SolverEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessingEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Process2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(InputDataReading2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ResultsOutput2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(StatusMonitoring2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Solver2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(MeshCreation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PreProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(PostProcessing2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(DataProcessSpace2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandlingEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(ErrorHandling2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FeatureProvidedInterfacesEditPart.VISUAL_ID: {
			LinkedList<ScrmAbstractNavigatorItem> result = new LinkedList<ScrmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			ScrmNavigatorGroup target = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureProvidedInterfaces_4024_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			ScrmNavigatorGroup source = new ScrmNavigatorGroup(
					Messages.NavigatorGroupName_FeatureProvidedInterfaces_4024_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(UserInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					ScrmVisualIDRegistry
							.getType(SoftwareInterface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(FeatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					ScrmVisualIDRegistry.getType(Feature2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
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
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
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
		return SCRMDiagramEditPart.MODEL_ID.equals(ScrmVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<ScrmNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<ScrmNavigatorItem> result = new ArrayList<ScrmNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new ScrmNavigatorItem(nextView, parent, isLeafs));
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
