package org.unicase.model.codegeneration;

import org.unicase.model.UnicaseModelElement;

public class NotSelfContainedException extends RuntimeException {

	private final UnicaseModelElement element;

	public NotSelfContainedException(UnicaseModelElement element) {
		this.element = element;
	}

	public UnicaseModelElement getElement() {
		return element;
	}
}
