package org.unicase.workspace.ui.dialogs.merge.conflict;

import org.unicase.metamodel.ModelElement;

public class ConflictContext {

	private final ModelElement modelElement;
	private final String attribute;
	private final String opponent;

	public ConflictContext(ModelElement modelElement, String attribute, String opponent) {
		this.modelElement = modelElement;
		this.attribute = attribute;
		this.opponent = opponent;
	}

	public ConflictContext(ModelElement modelElement, String opponent) {
		this.modelElement = modelElement;
		this.attribute = null;
		this.opponent = opponent;
	}

	public ModelElement getModelElement() {
		return modelElement;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getOpponent() {
		return opponent;
	}

	public String getModelElementTitleLabel() {
		return "ModelElement";
	}

	public String getAttributeTitleLabel() {
		return "Attribute";
	}

	public String getOpponentTitleLabel() {
		return "Opponent";
	}
}
