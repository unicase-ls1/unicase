package org.unicase.model.testspec.ui.editor.commands;

import org.unicase.metamodel.ModelElement;
import org.unicase.model.testspec.TestStep;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Change textfields (exception, description, or actual output) of a given test step.
 * 
 * @author chen
 * 
 */
public class ChangeTextCommand extends UnicaseCommand {
	/**
	 * Constant table column index.
	 */

	private ModelElement modelElement;
	private String changedValue = "";
	private int classifier = 0;
	


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
	public ChangeTextCommand(final ModelElement modelElement,
			final String changedValue, int classifier) {
		this.modelElement = modelElement;
		this.changedValue = changedValue;
		this.classifier  = classifier;
	
	}

	/**
	 * Change command.
	 */
	@Override
	protected void doRun() {
		try {
			
			
			if (modelElement != null) {
				

				if (modelElement instanceof TestStep) {
					
					if (classifier == 1){
						((TestStep) modelElement).setDescription(changedValue);
					} 
					else if (classifier == 2) {
						((TestStep) modelElement).setException(changedValue);
					}
					
					
				} 
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
