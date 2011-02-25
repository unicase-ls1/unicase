package org.unicase.experiments.commands;

import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
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

		final ModelElement cloneME = ModelUtil.copy(me);

		if (me instanceof UnicaseModelElement) {
			UnicaseModelElement unicaseME = (UnicaseModelElement) cloneME;
			unicaseME.setLeafSection(((UnicaseModelElement) me).getLeafSection());
		}

	}

}
