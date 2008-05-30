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

import java.util.Properties;

import org.eclipse.swt.widgets.Event;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class EventDataQueue {
    
    private Event currentEvent = null;
    
    public void startSequence(int eventType) {
        this.currentEvent = new Event();
        this.currentEvent.type = eventType;
    }
    
    public void addData(String key, String value) {
        if (this.currentEvent.data == null) {
            Properties newProperties = new Properties();
            this.currentEvent.data = newProperties;
        }
        Properties properties = (Properties) this.currentEvent.data;
        properties.setProperty(key, value);
    }

    /**
     * @return the currentEvent
     */
    public Event getCurrentEvent() {
        return this.currentEvent;
    }
    
    public void clear() {
        this.currentEvent = null;
    }

}
