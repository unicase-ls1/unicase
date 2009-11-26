package org.unicase.link.commands;

import java.util.Set;

import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Command to duplicate model elements.
 * 
 * @author fxulusoy
 */
public class DuplicateModelElementCommand extends UnicaseCommand {

	private final ModelElement me;

	/**
	 * Default constructor.
	 * 
	 * @param me the {@link ModelElement} to be copied.
	 */
	public DuplicateModelElementCommand(ModelElement me) {
		this.me = me;
	}
	
	@Override
	protected void doRun() {

		final ModelElement clone = ModelUtil.copy(me);
		UnicaseModelElement ume = (UnicaseModelElement) clone;
		ume.setLeafSection(((UnicaseModelElement)me).getLeafSection());
		
		ModelElement cME = ((UnicaseModelElement)me).getContainerModelElement();
		Set<ModelElement> elements = cME.getContainedElements();
		elements.add(ume);
		
		final ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ps.getProject().addModelElement(clone);
			}
		}.run();
		
		
	}

}
