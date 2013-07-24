/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

import java.net.URL;

/**
 * Class representing Sphinx speech input. Every speech input has a phrase that should be recognized and optionally a
 * location of its JSGF definition. If no grammar is specified, the UNICASE default grammar is used.
 * 
 * @author mharut
 */
public class SpeechInput extends ActionInput {

	/**
	 * The location of this input's JSGF defintion. This may be <code>null</code> if the default grammar should be used.
	 */
	private final URL grammarLocation;
	/**
	 * The expected phrase that should be recognized by the Sphinx speech recognition.
	 */
	private final String phrase;

	/**
	 * Constructs a new speech input instance for an expected phrase, a timeout and optionally a location of the JSGF
	 * definition.
	 * 
	 * @param grammarLocation the location of the JSGF definition - may be <code>null</code> if the UNICASE default
	 *            grammar should be used
	 * @param phrase the expected phrase that should be recognized by the Sphinx speech recognition
	 * @param timeout the timeout in milliseconds, after which this input is discarded - if this is 0 or less, there
	 *            will be no timeout
	 */
	public SpeechInput(URL grammarLocation, String phrase, int timeout) {
		super(timeout);
		this.grammarLocation = grammarLocation;
		this.phrase = phrase;
	}

	/**
	 * Retrieves the expected phrase that should be recognized by the Sphinx speech recognition.
	 * 
	 * @return the expected phrase
	 */
	public String getPhrase() {
		return phrase;
	}

	/**
	 * Retrieves the location of the JSGF definition. This may be <code>null</code>, in which case the default UNICASE
	 * grammar is being used.
	 * 
	 * @return the location of the JSGF definition
	 */
	public URL getGrammarLocation() {
		return grammarLocation;
	}

}
