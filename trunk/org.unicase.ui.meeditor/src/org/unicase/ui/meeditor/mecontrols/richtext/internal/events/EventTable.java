/*******************************************************************************
 * Copyright (c) 2006 Tom Seidel, Spirit Link GmbH
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *     Tom Seidel - initial API and implementation
 *******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.richtext.internal.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import org.unicase.ui.meeditor.mecontrols.richtext.widgets.EventConstants;

/**
 * 
 * @author Tom Seidel - tom.seidel@spiritlink.de
 */
public class EventTable {

    private Map<Integer,List<Listener>> eventtable = new HashMap<Integer, List<Listener>>();

    /**
     * 
     * @param eventType
     * @param listener
     */
    public void addListener(int eventType, Listener listener) {
        assert(listener != null);
        if (this.eventtable.get(eventType) == null) {
            this.eventtable.put(eventType, new ArrayList<Listener>());
        }
        this.eventtable.get(eventType).add(listener);
        if (eventType != EventConstants.ALL) {
            if (this.eventtable.get(EventConstants.ALL) == null) {
                this.eventtable.put(EventConstants.ALL, new ArrayList<Listener>());
            }
            this.eventtable.get(EventConstants.ALL).add(listener);
        }
    }
    /**
     * Removes a listener for a special event.
     * @param eventType
     * @param listener
     */
    public void removeListener(int eventType, Listener listener) {
        assert(listener != null);
        if (this.eventtable.get(eventType) != null) {
            this.eventtable.get(eventType).remove(listener);
        }
        if (eventType != EventConstants.ALL) {
            if (this.eventtable.get(EventConstants.ALL) != null) {
                this.eventtable.get(EventConstants.ALL).remove(listener);
            }
        }
    }
    /**
     * Iterates through the registered listeners that are assigned
     * to the given eventtype.
     * @param eventType
     * @param event
     */
    public void handleEvent(int eventType, Event event) {
        if (this.eventtable.get(eventType) != null) {
            List<Listener> listenerList = this.eventtable.get(eventType);
            for (Listener listener : listenerList) {
                listener.handleEvent(event);
            }

        }
    }
}
