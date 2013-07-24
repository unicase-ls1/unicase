/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.listener;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.jsgf.JSGFGrammar;
import edu.cmu.sphinx.jsgf.JSGFGrammarException;
import edu.cmu.sphinx.jsgf.JSGFGrammarParseException;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.Configurable;
import edu.cmu.sphinx.util.props.PropertyException;
import edu.cmu.sphinx.util.props.PropertySheet;
import edu.cmu.sphinx.util.props.S4Component;

/**
 * Listener that is listening to sphinx4 speech recognition. This also implements the {@link Configurable} interface, so
 * this listener can be defined
 * 
 * @author mharut
 */
public class SpeechListener implements Configurable {

	/**
	 * The of the JSGF grammar property as specified in the configuration file.
	 */
	@S4Component(type = JSGFGrammar.class)
	public static final String PROP_JSGF_GRAMMAR = "jsgfGrammar";
	/**
	 * The name of the microphone property as specified in the configuration file.
	 */
	@S4Component(type = Microphone.class)
	public static final String PROP_MICROPHONE = "microphone";
	/**
	 * The name of the speech recognizer property as specified in the configuration file.
	 */
	@S4Component(type = Recognizer.class)
	public static final String PROP_RECOGNIZER = "recognizer";

	/**
	 * The set of listeners that should be notified once a sensible speech input has been recognized.
	 */
	private final Set<LeapInputListener> listeners = new HashSet<LeapInputListener>();
	/**
	 * Flag to indicate whether the speech recognition is currently running or not.
	 */
	private boolean running;
	/**
	 * The JSGF grammar used to recognize speech input.
	 */
	private JSGFGrammar grammar;
	/**
	 * The recognizer used to recognize speech input.
	 */
	private Recognizer recognizer;
	/**
	 * The microphone used to capture speech input.
	 */
	private Microphone microphone;
	/**
	 * The thread used to capture and recognize speech input.
	 */
	private Thread micThread;
	/**
	 * The lock used for thread-safe access to the speech recognizer.
	 */
	private Object lock = new Object();

	@Override
	public void newProperties(PropertySheet ps) throws PropertyException {
		grammar = (JSGFGrammar) ps.getComponent(PROP_JSGF_GRAMMAR);
		microphone = (Microphone) ps.getComponent(PROP_MICROPHONE);
		recognizer = (Recognizer) ps.getComponent(PROP_RECOGNIZER);
	}

	/**
	 * Starts this listener. If the listener is already listening, nothing happens. If the listener was listening
	 * before, the listening process is continued. Otherwise, a new thread is started that will listen to recognized
	 * speech input.
	 */
	public synchronized void startListening() {
		if (!running) {
			running = true;
			if (micThread != null && !microphone.isRecording()) {
				synchronized (lock) {
					lock.notify();
				}
			} else {
				micThread = new Thread(new SpeechListeningRunnable());
				micThread.start();
			}
		}
	}

	/**
	 * Stops listening to speech input.
	 */
	public synchronized void stopListening() {
		running = false;
	}

	/**
	 * Sets the grammar location of this speech listener to a new value. This will attempt to allocate the dictionary
	 * and switch this listener's grammar to the one specified at the new location.
	 * 
	 * @param grammarUrl the location of the JSGF grammar definition
	 * @throws IOException if retrieving the grammar at the specified location fails
	 * @throws JSGFGrammarParseException if parsing the grammar fails
	 * @throws JSGFGrammarException if loading the grammar fails
	 */
	public void setGrammarLocation(URL grammarUrl) throws IOException, JSGFGrammarParseException, JSGFGrammarException {
		grammar.getDictionary().allocate();
		String grammarLocation = grammarUrl.toString();
		int endIndex = grammarLocation.lastIndexOf('/');
		URL baseUrl = new URL(grammarLocation.substring(0, endIndex));
		String grammarName = grammarLocation.substring(endIndex, grammarLocation.lastIndexOf('.'));
		grammar.setBaseURL(baseUrl);
		grammar.loadJSGF(grammarName);
	}

	/**
	 * Adds a new listener that will be notified once a sensible speech input has been recognized.
	 * 
	 * @param listener the listener to add
	 */
	public void addListener(LeapInputListener listener) {
		if (listeners.isEmpty()) {
			startListening();
		}
		listeners.add(listener);
	}

	/**
	 * Removes a listener from the set of listeners to notify on recognized speech input.
	 * 
	 * @param listener the listener to remove
	 */
	public void removeListener(LeapInputListener listener) {
		listeners.remove(listener);
		if (listeners.isEmpty()) {
			stopListening();
		}
	}

	/**
	 * Disposes this speech listener. If there are still specified listeners to notify, this will have no effect.
	 * Otherwise, the microphone capturing thread is being interrupted, which will deallocate all required resources.
	 */
	public void dispose() {
		if (listeners.isEmpty()) {
			micThread.interrupt();
		}
	}

	/**
	 * Implementation of the {@link Runnable} interface, that will capture microphone input and tries to recognize
	 * speech as defined in the specified grammar. The runnable can be paused for a certain time or interrupted
	 * entirely.
	 * 
	 * @author mharut
	 */
	private class SpeechListeningRunnable implements Runnable {

		@Override
		public void run() {
			recognizer.allocate();
			synchronized (lock) {
				while (!Thread.interrupted()) {
					if (microphone.startRecording()) {
						while (running) {
							Result result = recognizer.recognize();
							if (result != null) {
								String bestResult = result.getBestFinalResultNoFiller();
								if (bestResult != null && !bestResult.isEmpty()) {
									for (LeapInputListener listener : listeners) {
										listener.handleSpeechRecognized(result);
									}
								}
							}
						}
						microphone.stopRecording();
					}
					try {
						lock.wait();
					} catch (InterruptedException e) {
						break;
					}
				}
			}
			recognizer.deallocate();
		}

	}
}
