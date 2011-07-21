package scrm.diagram.edit.policies;

import java.util.Iterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.ScientificKnowledge;
import scrm.requirements.IRequirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;
import scrm.requirements.dataProcess.Process;

public class SCRMSpaceChildCreationEditPolicy extends CreationEditPolicy {

    /**
     * {@inheritDoc}
     * @generated NOT: this command only adds to the correct EReference now
     */
    protected ICommand getReparentGroupCommand(GroupEditPart groupEP) {
        CompositeCommand cc = new CompositeCommand(
            DiagramUIMessages.AddCommand_Label);
        View container = (View) getHost().getModel();
        EObject context = ViewUtil.resolveSemanticElement(container);

        // semantic
        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
            .getEditingDomain();
        for (Iterator iter = groupEP.getShapeChildren().iterator(); iter
            .hasNext();) {
            IGraphicalEditPart childEP = (IGraphicalEditPart) iter.next();
            EObject element = ViewUtil.resolveSemanticElement((View) childEP
                .getModel());
            if (element != null) {
                Command moveSemanticCmd = getHost().getCommand(
                    new EditCommandRequestWrapper(new MoveRequest(
                        editingDomain, context, getContainingReference(context, element), element)));

                if (moveSemanticCmd == null) {
                    return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
                }

                cc.compose(new CommandProxy(moveSemanticCmd));
            }
        }

        // notation
        cc.compose(getReparentViewCommand(groupEP));
        return cc;
    }
    
	/**
	 * {@inheritDoc}
	 * @generated NOT: this command only adds to the correct EReference now
	 */
	protected ICommand getReparentCommand( IGraphicalEditPart gep ) {
        CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label); 
		View container = (View)getHost().getModel();
		EObject context = ViewUtil.resolveSemanticElement(container);
		View view = (View)gep.getModel();
		EObject element = ViewUtil.resolveSemanticElement(view);

        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
            .getEditingDomain();
        
        //
		// semantic
		if ( element != null ) {
			Command moveSemanticCmd =
				getHost().getCommand(
					new EditCommandRequestWrapper(
						new MoveRequest(editingDomain, context,
								getContainingReference(context, element), element)));
            
              if (moveSemanticCmd == null) {
                  return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
              }
			
			cc.compose ( new CommandProxy(moveSemanticCmd) );
		}
		return cc;
	}
	
	private EReference getContainingReference(EObject parent, EObject child) {
		if(parent instanceof KnowledgeSpace
				&& child instanceof ScientificKnowledge) {
			return KnowledgePackage.eINSTANCE.
					getKnowledgeSpace_ContainedScientificKnowledge();
		} else if(parent instanceof RequirementSpace
				&& child instanceof IRequirement) {
			return RequirementsPackage.eINSTANCE.
					getRequirementSpace_ContainedInformationofRequirements();
		} else if(parent instanceof DataProcessSpace
				&& child instanceof Process) {
			return DataProcessPackage.eINSTANCE.
					getDataProcessSpace_ContainedDataProcessSteps();
		} else {
			return null;
		}
	}
	
}
