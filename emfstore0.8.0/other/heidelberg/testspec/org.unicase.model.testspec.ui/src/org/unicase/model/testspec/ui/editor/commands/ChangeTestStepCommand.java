package org.unicase.model.testspec.ui.editor.commands;

import org.unicase.metamodel.ModelElement;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Change description or exception parameter of a given test step.
 * 
 * @author Chen
 * 
 */
public class ChangeTestStepCommand extends UnicaseCommand {
	/**
	 * Constant table column index.
	 */
	private static final int COLUMN_NAME = 0;
	private static final int COLUMN_TYPE = 1;
	private static final int COLUMN_RANGE = 2;
	private static final int COLUMN_VALUE = 3;

	private ModelElement modelElement;
	private String changedValue = "";
	private int columnIndex = -1;
	private TestProtocol testProtocol;


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
	public ChangeTestStepCommand(final ModelElement modelElement,
			final String changedValue, final int columnIndex, final TestProtocol testProtocol) {
		this.modelElement = modelElement;
		this.changedValue = changedValue;
		this.columnIndex = columnIndex;
		this.testProtocol = testProtocol;
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
					switch (columnIndex) {
					case COLUMN_NAME:
						((TestStepInput) modelElement).setName(changedValue);
						break;
					case COLUMN_TYPE:
						((TestStepInput) modelElement).setType(changedValue);
						break;
					case COLUMN_RANGE:
						((TestStepInput) modelElement).setRange(changedValue);
						break;
					case COLUMN_VALUE:
						if(testProtocol != null) {
						    ((TestStepInput) modelElement).getValues().put(testProtocol, changedValue);
						}
						break;
					}
					/* Or output parameter? */
				} else if (modelElement instanceof TestStepOutput) {
					switch (columnIndex) {
					case COLUMN_NAME:
						((TestStepOutput) modelElement).setName(changedValue);
						break;
					case COLUMN_TYPE:
						((TestStepOutput) modelElement).setType(changedValue);
						break;
					case COLUMN_RANGE:
						((TestStepOutput) modelElement).setRange(changedValue);
						break;
					case COLUMN_VALUE:
						((TestStepOutput) modelElement).getValues().put(testProtocol, changedValue);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
