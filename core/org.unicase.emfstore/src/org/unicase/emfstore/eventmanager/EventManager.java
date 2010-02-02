/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.eventmanager;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;

/**
 * EventManager accepts events and distributes them to the listeners. EventManger runs in it's own thread. -TODO: Enable
 * listener to listen to specified events only. - TODO: Don't allow listeners to block eventmanager (e.g. connection
 * timeout)
 * 
 * @author wesendon
 */
public final class EventManager extends Thread {

	private static EventManager instance;
	private LinkedBlockingQueue<ServerEvent> queue;
	private ArrayList<EMFStoreEventListener> listeners;

	private EventManager() {
		super("EventManager");
		queue = new LinkedBlockingQueue<ServerEvent>();
		listeners = new ArrayList<EMFStoreEventListener>();
		start();
	}

	/**
	 * Returns the instance of {@link EventManager}.
	 * 
	 * @return instance
	 */
	public static EventManager getInstance() {
		if (instance == null) {
			instance = new EventManager();
		}
		return instance;
	}

	/**
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		ArrayList<EMFStoreEventListener> tmp = new ArrayList<EMFStoreEventListener>();
		while (!isInterrupted()) {
			try {
				ServerEvent event = queue.take();
				if (event != null) {
					synchronized (this) {
						for (EMFStoreEventListener e : listeners) {
							boolean successful = e.handleEvent((ServerEvent) EcoreUtil.copy(event));
							if (!successful) {
								tmp.add(e);
							}
						}
						listeners.removeAll(tmp);
						tmp.clear();
					}
				}
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Register a listener. Listen to specific type of event isn't implemented yet.
	 * 
	 * @param listener the listener
	 * @param clazz not implemented yet
	 */
	public void registerListener(EMFStoreEventListener listener, EClass clazz) {
		if (listener == null) {
			return;
		}
		synchronized (this) {
			listeners.add(listener);
		}
	}

	/**
	 * Removes a listener.
	 * 
	 * @param listener a listener
	 */
	public void unregisterListener(EMFStoreEventListener listener) {
		if (listener == null) {
			return;
		}
		synchronized (this) {
			listeners.remove(listener);
		}
	}

	/**
	 * Use this method to distribute your event.
	 * 
	 * @param event the event
	 */
	public void sendEvent(ServerEvent event) {
		if (event != null) {
			try {
				// queue is thread safe
				queue.put(event);
			} catch (InterruptedException e) {
				// fail silently
			}
		}
	}

}
