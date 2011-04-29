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
		public boolean canCreateScientificProblemRepresentingModel_4006(
				ScientificProblem source, MathematicalModel target) {
			if (source != null) {
				if (source.getRepresentingModel() != null) {
					return false;
				}
			}
			if (target != null && (target.getRepresentedProblem() != null)) {
				return false;
			}

			return canExistScientificProblemRepresentingModel_4006(source,
					target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateScientificProblemSolvingMethods_4041(
				ScientificProblem source, NumericalMethod target) {
			if (source != null) {
				if (source.getSolvingMethods().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getSolvedProblem() != null)) {
				return false;
			}

			return canExistScientificProblemSolvingMethods_4041(source, target);
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
		public boolean canCreateMathematicalModel_4004(
				MathematicalModel container, MathematicalModel source,
				MathematicalModel target) {
			return canExistMathematicalModel_4004(container, null, source,
					target);
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
		public boolean canCreateNumericalMethodRealizingRequirement_4016(
				NumericalMethod source, Requirement target) {
			if (source != null) {
				if (source.getRealizingRequirement() != null) {
					return false;
				}
			}
			if (target != null && (target.getRealizedMethod() != null)) {
				return false;
			}

			return canExistNumericalMethodRealizingRequirement_4016(source,
					target);
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
		public boolean canCreateFeatureConstraints_4025(Feature source,
				Constraint target) {
			if (source != null) {
				if (source.getConstraints().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getRestrictedFeature() != null)) {
				return false;
			}

			return canExistFeatureConstraints_4025(source, target);
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
		public boolean canCreateFeatureDetailedRequirements_4027(
				Feature source, Requirement target) {
			if (source != null) {
				if (source.getDetailedRequirements().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getSpecifiedFeature() != null)) {
				return false;
			}

			return canExistFeatureDetailedRequirements_4027(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFeature_4029(Feature container, Feature source,
				Feature target) {
			return canExistFeature_4029(container, null, source, target);
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
		public boolean canCreateRequirement_4036(Requirement container,
				Requirement source, Requirement target) {
			return canExistRequirement_4036(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRequirementDefiningData_4038(
				Requirement source, DataDefinition target) {
			if (source != null) {
				if (source.getDefiningData().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getDefinedRequirement() != null)) {
				return false;
			}

			return canExistRequirementDefiningData_4038(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateProcessDataFlow_4045(
				scrm.requirements.dataProcess.Process source, DataFlow target) {
			if (source != null) {
				if (source.getDataFlow() != null) {
					return false;
				}
			}
			if (target != null && (target.getSpecifiedProcess() != null)) {
				return false;
			}

			return canExistProcessDataFlow_4045(source, target);
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
		public boolean canExistScientificProblemRepresentingModel_4006(
				ScientificProblem source, MathematicalModel target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistScientificProblemSolvingMethods_4041(
				ScientificProblem source, NumericalMethod target) {
			return true;
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
		public boolean canExistMathematicalModel_4004(
				MathematicalModel container, MathematicalModel linkInstance,
				MathematicalModel source, MathematicalModel target) {
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
		public boolean canExistNumericalMethodRealizingRequirement_4016(
				NumericalMethod source, Requirement target) {
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
		public boolean canExistFeatureConstraints_4025(Feature source,
				Constraint target) {
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
		public boolean canExistFeatureDetailedRequirements_4027(Feature source,
				Requirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFeature_4029(Feature container,
				Feature linkInstance, Feature source, Feature target) {
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
		public boolean canExistRequirement_4036(Requirement container,
				Requirement linkInstance, Requirement source, Requirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRequirementDefiningData_4038(Requirement source,
				DataDefinition target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistProcessDataFlow_4045(
				scrm.requirements.dataProcess.Process source, DataFlow target) {
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
