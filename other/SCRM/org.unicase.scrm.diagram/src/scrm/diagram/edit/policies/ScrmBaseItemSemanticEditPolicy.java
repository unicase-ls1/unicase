package scrm.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.helpers.ScrmBaseEditHelper;
import scrm.diagram.part.ScrmDiagramEditorPlugin;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;
import scrm.knowledge.Assumption;
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;
import scrm.requirements.Constraint;
import scrm.requirements.DataDefinition;
import scrm.requirements.DataFlow;
import scrm.requirements.Feature;
import scrm.requirements.Hardware;
import scrm.requirements.Interface;
import scrm.requirements.Performance;
import scrm.requirements.Requirement;

/**
 * @generated
 */
public class ScrmBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * Extended request data key to hold editpart visual id.
	 * @generated
	 */
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final IElementType myElementType;

	/**
	 * @generated
	 */
	protected ScrmBaseItemSemanticEditPolicy(IElementType elementType) {
		myElementType = elementType;
	}

	/**
	 * Extended request data key to hold editpart visual id.
	 * Add visual id of edited editpart to extended data of the request
	 * so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram
	 * element kind from domain element.
	 * 
	 * @generated
	 */
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart()
					.getModel();
			if (view instanceof View) {
				Integer id = new Integer(
						ScrmVisualIDRegistry.getVisualID((View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest,
				semanticCommand);
		if (completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(
					semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand,
			DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(
				getEditingDomain(), (View) getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand
				.chain(deleteViewCommand);
	}

	/**
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request,
			Command editPolicyCommand) {
		if (editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand)
					.getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(ScrmBaseEditHelper.EDIT_POLICY_COMMAND,
					command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(ScrmBaseEditHelper.CONTEXT_ELEMENT_TYPE,
				requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(ScrmBaseEditHelper.EDIT_POLICY_COMMAND, null);
		request.setParameter(ScrmBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
		if (command != null) {
			if (!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(),
						command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * @generated
	 */
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = ScrmElementTypes
				.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType
				: myElementType;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(MoveRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * Returns editing domain from the host edit part.
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram
	 * @generated
	 */
	protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
		assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
		for (Iterator it = view.getDiagram().getChildren().iterator(); it
				.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			cmd.add(new DeleteCommand(getEditingDomain(), nextView));
		}
	}

	/**
	 * @generated
	 */
	public static LinkConstraints getLinkConstraints() {
		LinkConstraints cached = ScrmDiagramEditorPlugin.getInstance()
				.getLinkConstraints();
		if (cached == null) {
			ScrmDiagramEditorPlugin.getInstance().setLinkConstraints(
					cached = new LinkConstraints());
		}
		return cached;
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		LinkConstraints() {
			// use static method #getLinkConstraints() to access instance
		}

		/**
		 * @generated
		 */
		public boolean canCreateScientificProblemInfluencedFeature_4008(
				ScientificProblem source, Feature target) {
			if (source != null) {
				if (source.getInfluencedFeature() != null) {
					return false;
				}
			}
			if (target != null && (target.getInfluencingProblem() != null)) {
				return false;
			}

			return canExistScientificProblemInfluencedFeature_4008(source,
					target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMathematicalModelRefinedModel_4058(
				MathematicalModel source, MathematicalModel target) {
			if (source != null) {
				if (source.getRefinedModel() != null) {
					return false;
				}
			}
			if (target != null && (target.getRefinements().contains(target))) {
				return false;
			}

			return canExistMathematicalModelRefinedModel_4058(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMathematicalModelRepresentedProblem_4048(
				MathematicalModel source, ScientificProblem target) {
			if (source != null) {
				if (source.getRepresentedProblem() != null) {
					return false;
				}
			}
			if (target != null && (target.getRepresentingModel() != null)) {
				return false;
			}

			return canExistMathematicalModelRepresentedProblem_4048(source,
					target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateNumericalMethodSolvedProblem_4057(
				NumericalMethod source, ScientificProblem target) {
			if (source != null) {
				if (source.getSolvedProblem() != null) {
					return false;
				}
			}
			if (target != null && (target.getSolvingMethods().contains(target))) {
				return false;
			}

			return canExistNumericalMethodSolvedProblem_4057(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMathematicalModelNumericalMethods_4011(
				MathematicalModel source, NumericalMethod target) {
			if (source != null) {
				if (source.getNumericalMethods().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getMathematicalModel() != null)) {
				return false;
			}

			return canExistMathematicalModelNumericalMethods_4011(source,
					target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMathematicalModelDependencies_4012(
				MathematicalModel source, Assumption target) {
			if (source != null) {
				if (source.getDependencies().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getDependingModel() != null)) {
				return false;
			}

			return canExistMathematicalModelDependencies_4012(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateNumericalMethodDependencies_4015(
				NumericalMethod source, Assumption target) {
			if (source != null) {
				if (source.getDependencies().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getDependingMethod() != null)) {
				return false;
			}

			return canExistNumericalMethodDependencies_4015(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRequirementRealizedMethod_4050(
				Requirement source, NumericalMethod target) {
			if (source != null) {
				if (source.getRealizedMethod() != null) {
					return false;
				}
			}
			if (target != null && (target.getRealizingRequirement() != null)) {
				return false;
			}

			return canExistRequirementRealizedMethod_4050(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateNumericalMethodPerformance_4017(
				NumericalMethod source, Performance target) {
			if (source != null) {
				if (source.getPerformance() != null) {
					return false;
				}
			}

			return canExistNumericalMethodPerformance_4017(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFeatureRequiredInterfaces_4023(Feature source,
				Interface target) {
			if (source != null) {
				if (source.getRequiredInterfaces().contains(target)) {
					return false;
				}
			}
			if (target != null
					&& (target.getRequiringFeatures().contains(target))) {
				return false;
			}

			return canExistFeatureRequiredInterfaces_4023(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFeatureProvidedInterfaces_4024(Feature source,
				Interface target) {
			if (source != null) {
				if (source.getProvidedInterfaces().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getProvidingFeature() != null)) {
				return false;
			}

			return canExistFeatureProvidedInterfaces_4024(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateConstraintRestrictedFeature_4051(
				Constraint source, Feature target) {
			if (source != null) {
				if (source.getRestrictedFeature() != null) {
					return false;
				}
			}
			if (target != null && (target.getConstraints().contains(target))) {
				return false;
			}

			return canExistConstraintRestrictedFeature_4051(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFeatureDependencies_4026(Feature source,
				Hardware target) {
			if (source != null) {
				if (source.getDependencies().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getDependingFeature() != null)) {
				return false;
			}

			return canExistFeatureDependencies_4026(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRequirementSpecifiedFeature_4052(
				Requirement source, Feature target) {
			if (source != null) {
				if (source.getSpecifiedFeature() != null) {
					return false;
				}
			}
			if (target != null
					&& (target.getDetailedRequirements().contains(target))) {
				return false;
			}

			return canExistRequirementSpecifiedFeature_4052(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFeatureSuperFeature_4053(Feature source,
				Feature target) {
			if (source != null) {
				if (source.getSuperFeature() != null) {
					return false;
				}
			}
			if (target != null && (target.getSubFeatures().contains(target))) {
				return false;
			}

			return canExistFeatureSuperFeature_4053(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFeatureRequiredFeatures_4030(Feature source,
				Feature target) {
			if (source != null) {
				if (source.getRequiredFeatures().contains(target)) {
					return false;
				}
			}
			if (target != null
					&& (target.getRequiringFeatures().contains(target))) {
				return false;
			}

			return canExistFeatureRequiredFeatures_4030(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFeatureExcludedFeatures_4032(Feature source,
				Feature target) {
			if (source != null) {
				if (source.getExcludedFeatures().contains(target)) {
					return false;
				}
			}
			if (target != null
					&& (target.getExcludingFeatures().contains(target))) {
				return false;
			}

			return canExistFeatureExcludedFeatures_4032(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRequirementRefinedRequirement_4054(
				Requirement source, Requirement target) {
			if (source != null) {
				if (source.getRefinedRequirement() != null) {
					return false;
				}
			}
			if (target != null && (target.getRefinements().contains(target))) {
				return false;
			}

			return canExistRequirementRefinedRequirement_4054(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateDataDefinitionDefinedRequirement_4055(
				DataDefinition source, Requirement target) {
			if (source != null) {
				if (source.getDefinedRequirement() != null) {
					return false;
				}
			}
			if (target != null && (target.getDefiningData().contains(target))) {
				return false;
			}

			return canExistDataDefinitionDefinedRequirement_4055(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateDataFlowSpecifiedProcess_4056(DataFlow source,
				scrm.requirements.dataProcess.Process target) {
			if (source != null) {
				if (source.getSpecifiedProcess() != null) {
					return false;
				}
			}
			if (target != null && (target.getDataFlow() != null)) {
				return false;
			}

			return canExistDataFlowSpecifiedProcess_4056(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateProcessSuccessor_4047(
				scrm.requirements.dataProcess.Process source,
				scrm.requirements.dataProcess.Process target) {
			if (source != null) {
				if (source.getSuccessor() != null) {
					return false;
				}
			}
			if (target != null && (target.getPredecessor() != null)) {
				return false;
			}

			return canExistProcessSuccessor_4047(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canExistScientificProblemInfluencedFeature_4008(
				ScientificProblem source, Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMathematicalModelRefinedModel_4058(
				MathematicalModel source, MathematicalModel target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMathematicalModelRepresentedProblem_4048(
				MathematicalModel source, ScientificProblem target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistNumericalMethodSolvedProblem_4057(
				NumericalMethod source, ScientificProblem target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMathematicalModelNumericalMethods_4011(
				MathematicalModel source, NumericalMethod target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMathematicalModelDependencies_4012(
				MathematicalModel source, Assumption target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistNumericalMethodDependencies_4015(
				NumericalMethod source, Assumption target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRequirementRealizedMethod_4050(
				Requirement source, NumericalMethod target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistNumericalMethodPerformance_4017(
				NumericalMethod source, Performance target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFeatureRequiredInterfaces_4023(Feature source,
				Interface target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFeatureProvidedInterfaces_4024(Feature source,
				Interface target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistConstraintRestrictedFeature_4051(
				Constraint source, Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFeatureDependencies_4026(Feature source,
				Hardware target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRequirementSpecifiedFeature_4052(
				Requirement source, Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFeatureSuperFeature_4053(Feature source,
				Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFeatureRequiredFeatures_4030(Feature source,
				Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFeatureExcludedFeatures_4032(Feature source,
				Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRequirementRefinedRequirement_4054(
				Requirement source, Requirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistDataDefinitionDefinedRequirement_4055(
				DataDefinition source, Requirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistDataFlowSpecifiedProcess_4056(DataFlow source,
				scrm.requirements.dataProcess.Process target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistProcessSuccessor_4047(
				scrm.requirements.dataProcess.Process source,
				scrm.requirements.dataProcess.Process target) {
			return true;
		}
	}

}
