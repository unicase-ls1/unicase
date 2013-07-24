/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.osgi.framework.Bundle;
import org.unicase.leap.listener.SpeechListener;

import com.leapmotion.leap.Gesture.Type;

import edu.cmu.sphinx.jsgf.JSGFGrammarException;
import edu.cmu.sphinx.jsgf.JSGFGrammarParseException;
import edu.cmu.sphinx.util.props.ConfigurationManager;

/**
 * Utility class for input regarding the leap motion input framework. This class defines constants used by the leap
 * action extension point schema and provides methods that will convert extension point elements to action input
 * objects. These objects are used by the input processor to check if an input sequence is performed by the user.
 * 
 * @author mharut
 */
public final class InputUtil {

	// Input methods:
	/**
	 * Name of the gesture input extension element.
	 */
	private static final String GESTURE_INPUT = "gesture";
	/**
	 * Name of the keyboard input extension element.
	 */
	private static final String KEYBOARD_INPUT = "keystroke";
	/**
	 * Name of the mouse input extension element.
	 */
	private static final String MOUSE_INPUT = "mouseclick";
	/**
	 * Name of the speech input extension element.
	 */
	private static final String SPEECH_INPUT = "speech";

	// Gesture related constants:
	/**
	 * Extension point restriction for the screen tap gesture type.
	 */
	private static final String SCREEN_TAP_GESTURE_TYPE = "screenTap";
	/**
	 * Extension point restriction for the key tap gesture type.
	 */
	private static final String KEY_TAP_GESTURE_TYPE = "keyTap";
	/**
	 * Extension point restriction for the swipe gesture type.
	 */
	private static final String SWIPE_GESTURE_TYPE = "swipe";
	/**
	 * Extension point restriction for the circle gesture type.
	 */
	private static final String CIRCLE_GESTURE_TYPE = "circle";
	/**
	 * Extension point restriction for gesture input with only fingers enabled.
	 */
	private static final String FINGERS_ENABLED = "fingers";
	/**
	 * Extension point restriction for gesture input with only tools enabled.
	 */
	private static final String TOOLS_ENABLED = "tools";
	/**
	 * Extension point restriction for gesture input with fingers and tools enabled.
	 */
	private static final String FINGERS_TOOLS_ENABLED = "fingers+tools";

	// Keyboard related constants:
	/**
	 * Extension point restriction for keyboard input with the "Control" key.
	 */
	private static final String CTRL_KEY = "CTRL";
	/**
	 * Extension point restriction for keyboard input with the "Shift" key.
	 */
	private static final String SHIFT_KEY = "SHIFT";
	/**
	 * Extension point restriction for keyboard input with the "Alt" key.
	 */
	private static final String ALT_KEY = "ALT";
	/**
	 * Extension point restriction for keyboard input with the "Caps Lock" key.
	 */
	private static final String CAPS_LOCK_KEY = "CAPS_LOCK";
	/**
	 * Extension point restriction for keyboard input with the "Space" key.
	 */
	private static final String SPACE_KEY = "SPACE";
	/**
	 * Extension point restriction for keyboard input with the "Enter" key.
	 */
	private static final String ENTER_KEY = "ENTER";
	/**
	 * Extension point restriction for keyboard input with the "Escape" key.
	 */
	private static final String ESC_KEY = "ESC";
	/**
	 * Extension point restriction for keyboard input with the "Break" key.
	 */
	private static final String BREAK_KEY = "BREAK";
	/**
	 * Extension point restriction for keyboard input with the "Insert" key.
	 */
	private static final String INS_KEY = "INS";
	/**
	 * Extension point restriction for keyboard input with the "Delete" key.
	 */
	private static final String DEL_KEY = "DEL";
	/**
	 * Extension point restriction for keyboard input with the "Home" key.
	 */
	private static final String HOME_KEY = "HOME";
	/**
	 * Extension point restriction for keyboard input with the "Page Up" key.
	 */
	private static final String PG_UP_KEY = "PG_UP";
	/**
	 * Extension point restriction for keyboard input with the "Page Down" key.
	 */
	private static final String PG_DOWN_KEY = "PG_DOWN";
	/**
	 * Extension point restriction for keyboard input with the "Up Arrow" key.
	 */
	private static final String ARROW_UP_KEY = "ARROW_UP";
	/**
	 * Extension point restriction for keyboard input with the "Down Arrow" key.
	 */
	private static final String ARROW_DOWN_KEY = "ARROW_DOWN";
	/**
	 * Extension point restriction for keyboard input with the "Left Arrow" key.
	 */
	private static final String ARROW_LEFT_KEY = "ARROW_LEFT";
	/**
	 * Extension point restriction for keyboard input with the "Right Arrow" key.
	 */
	private static final String ARROW_RIGHT_KEY = "ARROW_RIGHT";

	// Mouse related constants:
	/**
	 * Extension point restriction for mouse input with the first mouse button.
	 */
	private static final String BUTTON_1 = "button1";
	/**
	 * Extension point restriction for mouse input with the second mouse button.
	 */
	private static final String BUTTON_2 = "button2";
	/**
	 * Extension point restriction for mouse input with the third mouse button.
	 */
	private static final String BUTTON_3 = "button3";
	/**
	 * Extension point restriction for mouse input with the fourth mouse button.
	 */
	private static final String BUTTON_4 = "button4";
	/**
	 * Extension point restriction for mouse input with the fifth mouse button.
	 */
	private static final String BUTTON_5 = "button5";

	/**
	 * The location of the sphinx4 configuration file.
	 */
	private static final String CONFIGURATION_LOCATION = "/sphinx4/leapSpeech.xml";
	/**
	 * Map mapping grammar locations to speech listeners. By using this map, listeners using the same grammar can be
	 * reused
	 */
	private static final Map<String, SpeechListener> LISTENER_MAP = new HashMap<String, SpeechListener>();
	/**
	 * The speech listener listening to input matched to the default UNICASE grammar.
	 */
	private static SpeechListener defaultSpeechListener;

	/**
	 * Private constructor, as this class should not be instantiated. All methods should be accessed statically.
	 */
	private InputUtil() {
	}

	/**
	 * Converts an extension definition of the leap action extension point to an instance of leap {@link ActionInput}.
	 * 
	 * @param extension the extension to convert
	 * @return the action input as defined by the provided extension or<br/>
	 *         <code>null</code> if the extension is invalid
	 */
	public static ActionInput convertToInput(IConfigurationElement extension) {
		String name = extension.getName();
		if (GESTURE_INPUT.equals(name)) {
			return convertToGestureInput(extension);
		} else if (KEYBOARD_INPUT.equals(name)) {
			return convertToKeyInput(extension);
		} else if (MOUSE_INPUT.equals(name)) {
			return convertToMouseInput(extension);
		} else if (SPEECH_INPUT.equals(name)) {
			return convertToSpeechInput(extension);
		}
		// unknown input type
		return null;
	}

	/**
	 * Converts an extension definition of the leap action extension point to a {@link GestureInput} instance.
	 * 
	 * @param extension the extension to convert
	 * @return the gesture input as defined by the extension or<br />
	 *         <code>null</code> if the extension is invalid
	 */
	private static GestureInput convertToGestureInput(IConfigurationElement extension) {
		try {
			String gestureType = extension.getAttribute("gestureType");
			String enabledInput = extension.getAttribute("enabledInput");
			int timeout = Integer.parseInt(extension.getAttribute("timeout"));

			// retrieve gesture type
			Type type = Type.TYPE_INVALID;
			if (SCREEN_TAP_GESTURE_TYPE.equals(gestureType)) {
				type = Type.TYPE_SCREEN_TAP;
			} else if (KEY_TAP_GESTURE_TYPE.equals(gestureType)) {
				type = Type.TYPE_KEY_TAP;
			} else if (SWIPE_GESTURE_TYPE.equals(gestureType)) {
				type = Type.TYPE_SWIPE;
			} else if (CIRCLE_GESTURE_TYPE.equals(gestureType)) {
				type = Type.TYPE_CIRCLE;
			}

			// retrieve enabled input type
			boolean fingersEnabled = false;
			boolean toolsEnabled = false;
			if (FINGERS_TOOLS_ENABLED.equals(enabledInput)) {
				fingersEnabled = true;
				toolsEnabled = true;
			} else if (FINGERS_ENABLED.equals(enabledInput)) {
				fingersEnabled = true;
				toolsEnabled = false;
			} else if (TOOLS_ENABLED.equals(enabledInput)) {
				fingersEnabled = false;
				toolsEnabled = true;
			}

			// extension is only valid if the gesture type is defined and either fingers or tools (or both) are enabled
			if (!Type.TYPE_INVALID.equals(type) && (fingersEnabled || toolsEnabled)) {
				return new GestureInput(type, fingersEnabled, toolsEnabled, timeout);
			}
		} catch (NumberFormatException e) {
			// fall through
		}
		// invalid extension
		return null;
	}

	/**
	 * Converts an extension definition of the leap action extension point to a {@link KeyInput} instance.
	 * 
	 * @param extension the extension to convert
	 * @return the key input as defined by the extension or<br />
	 *         <code>null</code> if the extension is invalid
	 */
	private static KeyInput convertToKeyInput(IConfigurationElement extension) {
		try {
			String key = extension.getAttribute("key");
			boolean hold = Boolean.parseBoolean(extension.getAttribute("hold"));
			int timeout = Integer.parseInt(extension.getAttribute("timeout"));

			// determine proper key code as defined by the SWT constants
			int keyCode = -1;
			if (CTRL_KEY.equals(key)) {
				keyCode = SWT.CTRL;
			} else if (ALT_KEY.equals(key)) {
				keyCode = SWT.ALT;
			} else if (SHIFT_KEY.equals(key)) {
				keyCode = SWT.SHIFT;
			} else if (CAPS_LOCK_KEY.equals(key)) {
				keyCode = SWT.CAPS_LOCK;
			} else if (SPACE_KEY.equals(key)) {
				keyCode = SWT.SPACE;
			} else if (ENTER_KEY.equals(key)) {
				keyCode = SWT.TRAVERSE_RETURN;
			} else if (ESC_KEY.equals(key)) {
				keyCode = SWT.ESC;
			} else if (BREAK_KEY.equals(key)) {
				keyCode = SWT.BREAK;
			} else if (INS_KEY.equals(key)) {
				keyCode = SWT.INSERT;
			} else if (DEL_KEY.equals(key)) {
				keyCode = SWT.DEL;
			} else if (HOME_KEY.equals(key)) {
				keyCode = SWT.HOME;
			} else if (PG_UP_KEY.equals(key)) {
				keyCode = SWT.PAGE_UP;
			} else if (PG_DOWN_KEY.equals(key)) {
				keyCode = SWT.PAGE_DOWN;
			} else if (ARROW_UP_KEY.equals(key)) {
				keyCode = SWT.ARROW_UP;
			} else if (ARROW_DOWN_KEY.equals(key)) {
				keyCode = SWT.ARROW_DOWN;
			} else if (ARROW_LEFT_KEY.equals(key)) {
				keyCode = SWT.ARROW_LEFT;
			} else if (ARROW_RIGHT_KEY.equals(key)) {
				keyCode = SWT.ARROW_RIGHT;
			}

			// extension is only valid, if the defined key code is within the accepted key range
			if (keyCode != -1) {
				return new KeyInput(keyCode, hold, timeout);
			}
		} catch (NumberFormatException e) {
			// fall through
		}
		// invalid extension
		return null;
	}

	/**
	 * Converts an extension definition of the leap action extension point to a {@link MouseInput} instance.
	 * 
	 * @param extension the extension to convert
	 * @return the mouse input as defined by the extension or<br />
	 *         <code>null</code> if the extension is invalid
	 */
	private static MouseInput convertToMouseInput(IConfigurationElement extension) {
		try {
			String button = extension.getAttribute("button");
			boolean doubleClick = Boolean.parseBoolean(extension.getAttribute("doubleClick"));
			int timeout = Integer.parseInt(extension.getAttribute("timeout"));

			// determine proper button code as defined by the SWT events
			int buttonCode = -1;
			if (BUTTON_1.equals(button)) {
				buttonCode = 1;
			} else if (BUTTON_2.equals(button)) {
				buttonCode = 2;
			} else if (BUTTON_3.equals(button)) {
				buttonCode = 3;
			} else if (BUTTON_4.equals(button)) {
				buttonCode = 4;
			} else if (BUTTON_5.equals(button)) {
				buttonCode = 5;
			}

			// extension is only valid if the button code is within the accepted range
			if (buttonCode != -1) {
				return new MouseInput(buttonCode, doubleClick, timeout);
			}
		} catch (NumberFormatException e) {
			// fall through
		}
		// invalid extension
		return null;
	}

	/**
	 * Converts an extension definition of the leap action extension point to a {@link SpeechInput} instance.
	 * 
	 * @param extension the extension to convert
	 * @return the speech input as defined by the extension or<br />
	 *         <code>null</code> if the extension is invalid
	 */
	private static SpeechInput convertToSpeechInput(IConfigurationElement extension) {
		try {
			String phrase = extension.getAttribute("phrase");
			int timeout = Integer.parseInt(extension.getAttribute("timeout"));
			String grammarLocation = extension.getAttribute("grammar");
			Bundle bundle = Platform.getBundle(extension.getContributor().getName());
			URL grammarUrl = grammarLocation == null ? null : bundle.getResource(grammarLocation);

			// extension is only valid if the button code is within the accepted range
			if (phrase != null && !phrase.isEmpty()) {
				return new SpeechInput(grammarUrl, phrase, timeout);
			}
		} catch (NumberFormatException e) {
			// fall through
		}
		// invalid extension
		return null;
	}

	/**
	 * Retrieves a speech listener that will listen to speech input defined by the grammar whose JSGF definition is
	 * located at <code>grammarUrl</code>. If a speech listener for the specified grammar already exists, it is being
	 * reused. Otherwise, a new speech listener is being constructed and cached. If no grammar is specified, i.e. if the
	 * location is set to <code>null</code> the speech listener for the UNICASE default grammar is being used.
	 * 
	 * @param grammarUrl the location of the JSGF definition - may be <code>null</code> if the default UNICASE grammar
	 *            should be used
	 * @return a speech listener recognizing input based on the specified grammar
	 * @throws IOException if retrieving the grammar from the specified location fails
	 * @throws JSGFGrammarParseException if parsing the specified grammar fails
	 * @throws JSGFGrammarException if loading the specified grammar fails
	 */
	public static SpeechListener getSpeechListener(URL grammarUrl) throws IOException, JSGFGrammarParseException,
		JSGFGrammarException {
		SpeechListener result;
		if (grammarUrl == null) {
			result = getDefaultSpeechListener();
		} else {
			String grammarLocation = grammarUrl.toString();
			if (LISTENER_MAP.containsKey(grammarLocation)) {
				result = LISTENER_MAP.get(grammarLocation);
			} else {
				ConfigurationManager configMgr = new ConfigurationManager(
					InputUtil.class.getResource(CONFIGURATION_LOCATION));
				result = (SpeechListener) configMgr.lookup("speechListener");
				result.setGrammarLocation(grammarUrl);
			}
		}
		return result;
	}

	/**
	 * Retrieves the speech listener that is recognizing input for the default UNICASE grammar.
	 * 
	 * @return the default speech listener
	 */
	private static SpeechListener getDefaultSpeechListener() {
		if (defaultSpeechListener == null) {
			ConfigurationManager configMgr = new ConfigurationManager(
				InputUtil.class.getResource(CONFIGURATION_LOCATION));
			defaultSpeechListener = (SpeechListener) configMgr.lookup("speechListener");
		}
		return defaultSpeechListener;
	}
}
