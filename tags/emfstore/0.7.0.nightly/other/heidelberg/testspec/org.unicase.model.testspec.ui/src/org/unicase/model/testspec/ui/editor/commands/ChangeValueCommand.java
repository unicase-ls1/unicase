package org.unicase.model.testspec.ui.editor.commands;

import org.unicase.metamodel.ModelElement;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Change the value of a teststep input/output.
 * 
 * @author chen
 * 
 */
public class ChangeValueCommand extends UnicaseCommand {
	/**
	 * Constant table column index.
	 */

	private ModelElement modelElement;
	private String changedValue = "";


	/**
	 * Default constructor.
	 * 
	 * @param modelElement
	 *            - input or output parameter that shall be changed
	 * @param changedValue
	 *            - changed value of one of the properties
	 * @param columnIndex
	 *            - index of column that holds changed value
	 */
	public ChangeValueCommand(final ModelElement modelElement,
			final String changedValue, final TestProtocol testProtocol) {
		this.modelElement = modelElement;
		this.changedValue = changedValue;
	}

	/**
	 * Change command.
	 */
	@Override
	protected void doRun() {
		try {
			
			
			if (modelElement != null) {
				

				/* Is the changed element an input parameter? */
				if (modelElement instanceof TestStepInput) {
					((TestStepInput) modelElement).setValue(changedValue);
					
					/* Or output parameter? */
				} else if (modelElement instanceof TestStepOutput) {
					((TestStepOutput) modelElement).setValue(changedValue);
					}
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
