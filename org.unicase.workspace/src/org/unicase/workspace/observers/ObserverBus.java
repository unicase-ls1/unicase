/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.unicase.workspace.WorkspaceManager;

/**
 * This is a universal observer bus. Better documentation will follow...
 * 
 * <pre>
 * // A is AbstractObserver
 * A a = new A() {
 * 
 * 	public void blub() {
 * 		System.out.println(&quot;A says: go!&quot;);
 * 	}
 * };
 * 
 * // B extends A and is abstractObserver
 * B b = new B() {
 * 
 * 	public void say(String ja) {
 * 		System.out.println(&quot;B says: &quot; + ja);
 * 	}
 * 
 * 	public void blub() {
 * 		System.out.println(&quot;B says: hö?&quot;);
 * 	}
 * };
 * 
 * // B is registered first
 * ObserverBus.register(b);
 * ObserverBus.register(a);
 * 
 * ObserverBus.send(A.class).blub();
 * 
 * System.out.println(&quot;\n === \n&quot;);
 * 
 * ObserverBus.send(B.class).say(&quot;w00t&quot;);
 * 
 * // Output: 
 * 
 * // B says: hö?
 * // A says: go!
 * //
 * // ===
 * //
 * // B says: w00t
 * 
 * </pre>
 * 
 * @author wesendon
 */
public class ObserverBus {

	private HashMap<Class<? extends IObserver>, ProxyHandler> observerProxies;

	/**
	 * Default constructor.
	 */
	public ObserverBus() {
		observerProxies = new HashMap<Class<? extends IObserver>, ProxyHandler>();
	}

	private static ObserverBus getInstance() {
		return WorkspaceManager.getInstance().getObserverBus();
	}

	/**
	 * This method allows you to notify all observers.
	 * 
	 * @param <T> class of observer
	 * @param clazz class of observer
	 * @return call object
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IObserver> T send(Class<T> clazz) {
		if (clazz == null) {
			return null;
		}
		ObserverBus i = getInstance();
		return (T) i.getProxyHandler(clazz, true).getProxy();
	}

	private List<IObserver> getObserver(Class<? extends IObserver> clazz, boolean force) {
		return getProxyHandler(clazz, force).getObservers();
	}

	/**
	 * Registers an observer for all observer interfaces implemented by the object or its super classes.
	 * 
	 * @param observer observer object
	 */
	public static void register(IObserver observer) {
		register(observer, getObserverInterfaces(observer));
	}

	/**
	 * Registers an observer for the specified observer interfaces.
	 * 
	 * @param observer observer object
	 * @param classes set of classes
	 */
	public static void register(IObserver observer, Class<? extends IObserver>... classes) {
		ObserverBus i = getInstance();
		for (Class<? extends IObserver> iface : classes) {
			if (iface.isInstance(observer)) {
				i.getObserver(iface, true).add(observer);
			}
		}
	}

	/**
	 * Unregisters an observer for all observer interfaces implemented by the object or its super classes.
	 * 
	 * @param observer observer object
	 */
	public static void unregister(IObserver observer) {
		unregister(observer, getObserverInterfaces(observer));
	}

	/**
	 * Unregisters an observer for the specified observer interfaces.
	 * 
	 * @param observer observer object
	 * @param classes set of classes
	 */
	public static void unregister(IObserver observer, Class<? extends IObserver>... classes) {
		ObserverBus i = getInstance();
		for (Class<? extends IObserver> iface : classes) {
			if (iface.isInstance(observer)) {
				List<IObserver> observers = i.getObserver(iface, false);
				if (observers != null) {
					observers.remove(observer);
				}
			}
		}
	}

	private ProxyHandler getProxyHandler(Class<? extends IObserver> clazz, boolean force) {
		ProxyHandler handler = observerProxies.get(clazz);
		if (handler == null && force) {
			handler = new ProxyHandler();
			Object observer = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, handler);
			handler.setProxy(observer);
			observerProxies.put(clazz, handler);
			return handler;
		}
		return handler;
	}

	private final class ProxyHandler implements InvocationHandler {

		private Object proxy;
		private ArrayList<IObserver> observers;

		public ProxyHandler() {
			observers = new ArrayList<IObserver>();
		}

		public List<IObserver> getObservers() {
			return observers;
		}

		public void setProxy(Object proxy) {
			this.proxy = proxy;
		}

		public Object getProxy() {
			return proxy;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			for (IObserver observer : observers) {
				method.invoke(observer, args);
			}
			// TODO: handle return values
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static Class<? extends IObserver>[] getObserverInterfaces(IObserver observer) {
		HashSet<Class<? extends IObserver>> result = new HashSet<Class<? extends IObserver>>();
		getClasses(observer.getClass(), result);
		return result.toArray(new Class[result.size()]);
	}

	// TODO: double check this method, i think to many interfaces are added
	@SuppressWarnings("unchecked")
	private static boolean getClasses(Class<?> clazz, HashSet<Class<? extends IObserver>> result) {
		for (Class<?> iface : clazz.getInterfaces()) {
			if (iface.equals(IObserver.class) && clazz.isInterface()) {
				result.add((Class<? extends IObserver>) clazz);
				return true;
			} else {
				if (getClasses(iface, result) && clazz.isInterface()) {
					result.add((Class<? extends IObserver>) clazz);
				}
			}
		}
		return false;
	}
}
