package org.unicase.codegeneration;

import org.unicase.model.UnicaseModelElement;

/**
 * Exception to state that the selected packages are not self contained
 * 
 * @author herrmama
 */
public class NotSelfContainedException extends RuntimeException {

	private static final long serialVersionUID = -3935186247946473183L;

	/**
	 * The element which is not contained
	 */
	private final UnicaseModelElement element;

	/**
	 * Constructor
	 */
	public NotSelfContainedException(UnicaseModelElement element) {
		this.element = element;
	}

	public UnicaseModelElement getElement() {
		return element;
	}
}
