/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

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
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.UseCase;

/**
 * @generated
 */
public class ModelBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * Extended request data key to hold editpart visual id.
	 * 
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
	protected ModelBaseItemSemanticEditPolicy(IElementType elementType) {
		myElementType = elementType;
	}

	/**
	 * Extended request data key to hold editpart visual id. Add visual id of edited editpart to extended data of the
	 * request so command switch can decide what kind of diagram element is being edited. It is done in those cases when
	 * it's not possible to deduce diagram element kind from domain element.
	 * 
	 * @generated
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
			if (view instanceof View) {
				Integer id = new Integer(org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID((View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * 
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	@Override
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
			request.setParameter(
				org.unicase.ui.diagram.usecaseDiagram.edit.helpers.ModelBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(
			org.unicase.ui.diagram.usecaseDiagram.edit.helpers.ModelBaseEditHelper.CONTEXT_ELEMENT_TYPE,
			requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(
			org.unicase.ui.diagram.usecaseDiagram.edit.helpers.ModelBaseEditHelper.EDIT_POLICY_COMMAND, null);
		request.setParameter(
			org.unicase.ui.diagram.usecaseDiagram.edit.helpers.ModelBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
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
		IElementType requestContextElementType = org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes
			.getElementType(getVisualID(request));
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
	 * 
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram
	 * 
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
		private static org.unicase.ui.diagram.usecaseDiagram.expressions.ModelAbstractExpression ActorInitiatedUseCases_4002_TargetExpression;
		/**
		 * @generated
		 */
		private static org.unicase.ui.diagram.usecaseDiagram.expressions.ModelAbstractExpression UseCaseIncludedUseCases_4003_TargetExpression;
		/**
		 * @generated
		 */
		private static org.unicase.ui.diagram.usecaseDiagram.expressions.ModelAbstractExpression UseCaseExtendedUseCases_4004_SourceExpression;

		/**
		 * @generated
		 */
		public static boolean canCreateActorParticipatedUseCases_4001(Actor source, UseCase target) {
			if (source != null) {
				if (source.getParticipatedUseCases().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getParticipatingActors().contains(target))) {
				return false;
			}

			return canExistActorParticipatedUseCases_4001(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateActorInitiatedUseCases_4002(Actor source, UseCase target) {
			if (source != null) {
				if (source.getInitiatedUseCases().contains(target)) {
					return false;
				}
			}
			if (target != null && (target.getInitiatingActor() != null)) {
				return false;
			}

			return canExistActorInitiatedUseCases_4002(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateUseCaseIncludedUseCases_4003(UseCase source, UseCase target) {
			if (source != null) {
				if (source.getIncludedUseCases().contains(target)) {
					return false;
				}
			}

			return canExistUseCaseIncludedUseCases_4003(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canCreateUseCaseExtendedUseCases_4004(UseCase source, UseCase target) {
			if (source != null) {
				if (source.getExtendedUseCases().contains(target)) {
					return false;
				}
			}

			return canExistUseCaseExtendedUseCases_4004(source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canExistActorParticipatedUseCases_4001(Actor source, UseCase target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canExistActorInitiatedUseCases_4002(Actor source, UseCase target) {
			try {
				if (target == null) {
					return true;
				}
				if (ActorInitiatedUseCases_4002_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, RequirementPackage.eINSTANCE.getActor());
					ActorInitiatedUseCases_4002_TargetExpression = org.unicase.ui.diagram.usecaseDiagram.expressions.ModelOCLFactory
						.getExpression("self <> oppositeEnd", RequirementPackage.eINSTANCE.getUseCase(), env); //$NON-NLS-1$
				}
				Object targetVal = ActorInitiatedUseCases_4002_TargetExpression.evaluate(target, Collections
					.singletonMap(OPPOSITE_END_VAR, source));
				if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
					"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistUseCaseIncludedUseCases_4003(UseCase source, UseCase target) {
			try {
				if (target == null) {
					return true;
				}
				if (UseCaseIncludedUseCases_4003_TargetExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, RequirementPackage.eINSTANCE.getUseCase());
					UseCaseIncludedUseCases_4003_TargetExpression = org.unicase.ui.diagram.usecaseDiagram.expressions.ModelOCLFactory
						.getExpression("self <> oppositeEnd", RequirementPackage.eINSTANCE.getUseCase(), env); //$NON-NLS-1$
				}
				Object targetVal = UseCaseIncludedUseCases_4003_TargetExpression.evaluate(target, Collections
					.singletonMap(OPPOSITE_END_VAR, source));
				if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
					"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public static boolean canExistUseCaseExtendedUseCases_4004(UseCase source, UseCase target) {
			try {
				if (source == null) {
					return true;
				}
				if (UseCaseExtendedUseCases_4004_SourceExpression == null) {
					Map env = Collections.singletonMap(OPPOSITE_END_VAR, RequirementPackage.eINSTANCE.getUseCase());
					UseCaseExtendedUseCases_4004_SourceExpression = org.unicase.ui.diagram.usecaseDiagram.expressions.ModelOCLFactory
						.getExpression("self <> oppositeEnd", RequirementPackage.eINSTANCE.getUseCase(), env); //$NON-NLS-1$
				}
				Object sourceVal = UseCaseExtendedUseCases_4004_SourceExpression.evaluate(source, Collections
					.singletonMap(OPPOSITE_END_VAR, target));
				if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
					return false;
				} // else fall-through
				return true;
			} catch (Exception e) {
				org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
					"Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}
	}

}
