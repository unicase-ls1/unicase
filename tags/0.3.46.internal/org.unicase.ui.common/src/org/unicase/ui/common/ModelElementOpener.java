package org.unicase.ui.common;

import org.unicase.metamodel.ModelElement;

public interface ModelElementOpener {
	public int canOpen(ModelElement modelElement);
	public void openModelElement(ModelElement modelElement);
}
