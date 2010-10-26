package org.unicase.ui.diagram.urml.edit.policies;

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
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.danger.Asset;
import org.unicase.model.urml.danger.Danger;
import org.unicase.model.urml.danger.Mitigation;
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.feature.Feature;
import org.unicase.model.urml.feature.Product;
import org.unicase.model.urml.feature.VariationPoint;
import org.unicase.model.urml.feature.VariationPointInstance;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.requirement.FunctionalRequirement;
import org.unicase.model.urml.requirement.NonFunctionalRequirement;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.model.urml.service.Service;
import org.unicase.ui.diagram.urml.edit.helpers.UrmlBaseEditHelper;
import org.unicase.ui.diagram.urml.part.UrmlVisualIDRegistry;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;

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
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$

		/**
		 * @generated
		 */
		public static boolean canCreateStakeholderGoals_4008(Stakeholder source, Goal target) {
			if (source != null) {
				if (source.getGoals().contains(target)) {
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
		public static boolean canCreateAbstractFeatureSubFeatures_4034(AbstractFeature source, AbstractFeature target) {
			if (source != null) {
				if (source.getSubFeatures().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getParentFeature() != null)) {
				return false;
			}

			return canExistAbstractFeatureSubFeatures_4034(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAbstractFeatureDetailingFunctionalRequirements_4035(AbstractFeature source,
			FunctionalRequirement target) {
			if (source != null) {
				if (source.getDetailingFunctionalRequirements().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getDetailedFeatures().contains(target))) {
				return false;
			}

			return canExistAbstractFeatureDetailingFunctionalRequirements_4035(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAbstractFeatureConstrainingNonFunctionalRequirements_4036(
			AbstractFeature source, NonFunctionalRequirement target) {
			if (source != null) {
				if (source.getConstrainingNonFunctionalRequirements().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getConstrainedFeatures().contains(target))) {
				return false;
			}

			return canExistAbstractFeatureConstrainingNonFunctionalRequirements_4036(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAbstractFeatureRequiredFeatures_4045(AbstractFeature source,
			AbstractFeature target) {
			if (source != null) {
				if (source.getRequiredFeatures().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getRequiringFeatures().contains(target))) {
				return false;
			}

			return canExistAbstractFeatureRequiredFeatures_4045(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAbstractFeatureExcludedFeatures_4038(AbstractFeature source,
			AbstractFeature target) {
			if (source != null) {
				if (source.getExcludedFeatures().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getExcludingFeatures().contains(target))) {
				return false;
			}

			return canExistAbstractFeatureExcludedFeatures_4038(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGoalRealizedFeatures_4004(Goal source, AbstractFeature target) {
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
		public static boolean canCreateGoalSubGoals_4018(Goal source, Goal target) {
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

			return canExistGoalSubGoals_4018(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGoalReference_4016(MEDiagram container, Goal source, Goal target) {
			return canExistGoalReference_4016(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGoalReference_4023(MEDiagram container, Goal source, Goal target) {
			return canExistGoalReference_4023(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGoalReference_4024(MEDiagram container, Goal source, Goal target) {
			return canExistGoalReference_4024(container, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateGoalReference_4025(MEDiagram container, Goal source, Goal target) {
			return canExistGoalReference_4025(container, source, target);
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
		public static boolean canCreateNonFunctionalRequirementSubNonFunctionalRequirements_4043(
			NonFunctionalRequirement source, NonFunctionalRequirement target) {
			if (source != null) {
				if (source.getSubNonFunctionalRequirements().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getParentNonFunctionalRequirement() != null)) {
				return false;
			}

			return canExistNonFunctionalRequirementSubNonFunctionalRequirements_4043(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateFunctionalRequirementSubFunctionalRequirements_4044(
			FunctionalRequirement source, FunctionalRequirement target) {
			if (source != null) {
				if (source.getSubFunctionalRequirements().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getParentFunctionalRequirement() != null)) {
				return false;
			}

			return canExistFunctionalRequirementSubFunctionalRequirements_4044(source, target);
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
			if (target != null && (target.getHarmingDangers().contains(target))) {
				return false;
			}

			return canExistDangerHarmedAssets_4013(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateAssetTriggeredDangers_4017(Asset source, Danger target) {
			if (source != null) {
				if (source.getTriggeredDangers().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getTriggeringAssets().contains(target))) {
				return false;
			}

			return canExistAssetTriggeredDangers_4017(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateServiceSubServices_4022(Service source, Service target) {
			if (source != null) {
				if (source.getSubServices().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getParentService() != null)) {
				return false;
			}

			return canExistServiceSubServices_4022(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateVariationPointOptionalSubFeatures_4046(VariationPoint source,
			AbstractFeature target) {
			if (source != null) {
				if (source.getOptionalSubFeatures().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}
			if (target != null && (target.getOptionalParentVariationPoint() != null)) {
				return false;
			}

			return canExistVariationPointOptionalSubFeatures_4046(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateVariationPointInstanceVariationPoint_4033(VariationPointInstance source,
			VariationPoint target) {
			if (source != null) {
				if (source.getVariationPoint() != null) {
					return false;
				}
			}
			if (target != null && (target.getInstances().contains(target))) {
				return false;
			}

			return canExistVariationPointInstanceVariationPoint_4033(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateVariationPointInstanceSelectedFeatures_4040(VariationPointInstance source,
			AbstractFeature target) {
			if (source != null) {
				if (source.getSelectedFeatures().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getVariationPointInstances().contains(target))) {
				return false;
			}

			return canExistVariationPointInstanceSelectedFeatures_4040(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateProductVariationPointInstances_4032(Product source, VariationPointInstance target) {
			if (source != null) {
				if (source.getVariationPointInstances().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getProducts().contains(target))) {
				return false;
			}

			return canExistProductVariationPointInstances_4032(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateProductFeatures_4047(Product source, Feature target) {
			if (source != null) {
				if (source.getFeatures().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getProducts().contains(target))) {
				return false;
			}

			return canExistProductFeatures_4047(source, target);
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
		public static boolean canExistAbstractFeatureSubFeatures_4034(AbstractFeature source, AbstractFeature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistAbstractFeatureDetailingFunctionalRequirements_4035(AbstractFeature source,
			FunctionalRequirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistAbstractFeatureConstrainingNonFunctionalRequirements_4036(AbstractFeature source,
			NonFunctionalRequirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistAbstractFeatureRequiredFeatures_4045(AbstractFeature source,
			AbstractFeature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistAbstractFeatureExcludedFeatures_4038(AbstractFeature source,
			AbstractFeature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalRealizedFeatures_4004(Goal source, AbstractFeature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalSubGoals_4018(Goal source, Goal target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalReference_4016(MEDiagram container, Goal source, Goal target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalReference_4023(MEDiagram container, Goal source, Goal target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalReference_4024(MEDiagram container, Goal source, Goal target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistGoalReference_4025(MEDiagram container, Goal source, Goal target) {
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
		public static boolean canExistNonFunctionalRequirementSubNonFunctionalRequirements_4043(
			NonFunctionalRequirement source, NonFunctionalRequirement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistFunctionalRequirementSubFunctionalRequirements_4044(FunctionalRequirement source,
			FunctionalRequirement target) {
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
		public static boolean canExistAssetTriggeredDangers_4017(Asset source, Danger target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistServiceSubServices_4022(Service source, Service target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistVariationPointOptionalSubFeatures_4046(VariationPoint source,
			AbstractFeature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistVariationPointInstanceVariationPoint_4033(VariationPointInstance source,
			VariationPoint target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistVariationPointInstanceSelectedFeatures_4040(VariationPointInstance source,
			AbstractFeature target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistProductVariationPointInstances_4032(Product source, VariationPointInstance target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistProductFeatures_4047(Product source, Feature target) {
			return true;
		}
	}

}
