package org.unicase.model.urml.ui.diagram.edit.policies;

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
import org.unicase.model.urml.Feature;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.ui.diagram.edit.helpers.UrmlBaseEditHelper;
import org.unicase.model.urml.ui.diagram.part.UrmlVisualIDRegistry;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

import urml.danger.Asset;
import urml.danger.Danger;
import urml.danger.Mitigation;
import urml.goal.Goal;
import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;
import urml.requirement.Requirement;
import urml.service.Service;
import urml.service.ServiceProvider;
import urml.usecase.Actor;

/**
 * @generated
 */
public class UrmlBaseItemSemanticEditPolicy extends SemanticEditPolicy {

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
	protected UrmlBaseItemSemanticEditPolicy(IElementType elementType) {
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
			Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
			if (view instanceof View) {
				Integer id = new Integer(UrmlVisualIDRegistry.getVisualID((View) view));
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
		semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
		if (completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
	}

	/**
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
		if (editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand)
				.getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(UrmlBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(UrmlBaseEditHelper.CONTEXT_ELEMENT_TYPE, requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(UrmlBaseEditHelper.EDIT_POLICY_COMMAND, null);
		request.setParameter(UrmlBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
		if (command != null) {
			if (!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * @generated
	 */
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = UrmlElementTypes.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : myElementType;
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
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
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
		for (Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
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
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		public static boolean canCreateStakeholderGoals_4008(Stakeholder source, Goal target) {
			if (source != null) {
				if (source.getGoals() != null) {
					return false;
				}
			}
			if (target != null && (target.getStakeholders().contains(target))) {
				return false;
			}

			return canExistStakeholderGoals_4008(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateFeatureParentFeature_4002(Feature source, Feature target) {
			if (source != null) {
				if (source.getParentFeature() != null) {
					return false;
				}
			}
			if (target != null && (target.getSubFeatures().contains(target))) {
				return false;
			}

			return canExistFeatureParentFeature_4002(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGoalRealizedFeatures_4004(Goal source, Feature target) {
			if (source != null) {
				if (source.getRealizedFeatures().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getGoals().contains(target))) {
				return false;
			}

			return canExistGoalRealizedFeatures_4004(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateRequirementImplementingServices_4005(Requirement source, Service target) {
			if (source != null) {
				if (source.getImplementingServices().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getSatisfiedRequirements().contains(target))) {
				return false;
			}

			return canExistRequirementImplementingServices_4005(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateFeatureDetailingFunctionalRequirements_4006(Feature source,
			FunctionalRequirement target) {
			if (source != null) {
				if (source.getDetailingFunctionalRequirements().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getDetailedFeatures().contains(target))) {
				return false;
			}

			return canExistFeatureDetailingFunctionalRequirements_4006(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGoalSubGoals_4009(Goal source, Goal target) {
			if (source != null) {
				if (source.getSubGoals().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getParentGoal() != null)) {
				return false;
			}

			return canExistGoalSubGoals_4009(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateFeatureConstrainingNonFunctionalRequirements_4010(Feature source,
			NonFunctionalRequirement target) {
			if (source != null) {
				if (source.getConstrainingNonFunctionalRequirements().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getConstrainedFeatures().contains(target))) {
				return false;
			}

			return canExistFeatureConstrainingNonFunctionalRequirements_4010(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateServiceServiceProvider_4011(Service source, ServiceProvider target) {
			if (source != null) {
				if (source.getServiceProvider() != null) {
					return false;
				}
			}
			if (target != null && (target.getProvidedServices().contains(target))) {
				return false;
			}

			return canExistServiceServiceProvider_4011(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateMitigationMitigatedDangers_4012(Mitigation source, Danger target) {
			if (source != null) {
				if (source.getMitigatedDangers().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getMitigations().contains(target))) {
				return false;
			}

			return canExistMitigationMitigatedDangers_4012(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateDangerHarmedAssets_4013(Danger source, Asset target) {
			if (source != null) {
				if (source.getHarmedAssets().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getEndangeredBy().contains(target))) {
				return false;
			}

			return canExistDangerHarmedAssets_4013(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateActorTriggeredDangers_4014(Actor source, Danger target) {
			if (source != null) {
				if (source.getTriggeredDangers().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getTriggeringActors().contains(target))) {
				return false;
			}

			return canExistActorTriggeredDangers_4014(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistStakeholderGoals_4008(Stakeholder source, Goal target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistFeatureParentFeature_4002(Feature source, Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalRealizedFeatures_4004(Goal source, Feature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistRequirementImplementingServices_4005(Requirement source, Service target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistFeatureDetailingFunctionalRequirements_4006(Feature source,
			FunctionalRequirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalSubGoals_4009(Goal source, Goal target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistFeatureConstrainingNonFunctionalRequirements_4010(Feature source,
			NonFunctionalRequirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistServiceServiceProvider_4011(Service source, ServiceProvider target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistMitigationMitigatedDangers_4012(Mitigation source, Danger target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistDangerHarmedAssets_4013(Danger source, Asset target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistActorTriggeredDangers_4014(Actor source, Danger target) {
			return true;
		}
	}

}
