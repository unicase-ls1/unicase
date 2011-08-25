/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.observer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * This is a universal observer bus. Better documentation will follow... Example code:
 * 
 * <pre>
 * // A is IObserver
 * A a = new A() {
 * 
 * 	public void foo() {
 * 		System.out.println(&quot;A says: go!&quot;);
 * 	}
 * };
 * 
 * // B extends A and is IObserver
 * B b = new B() {
 * 
 * 	public void say(String ja) {
 * 		System.out.println(&quot;B says: &quot; + ja);
 * 	}
 * 
 * 	public void foo() {
 * 		System.out.println(&quot;B says: h??&quot;);
 * 	}
 * };
 * 
 * // B is registered first
 * ObserverBus.register(b);
 * ObserverBus.register(a);
 * 
 * ObserverBus.send(A.class).foo();
 * 
 * ObserverBus.send(B.class).say(&quot;w00t&quot;);
 * 
 * // Output:
 * 
 * // B says: h??
 * // A says: go!
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

	/**
	 * This method allows you to notify all observers.
	 * 
	 * @param <T> class of observer
	 * @param clazz class of observer
	 * @return call object
	 */
	@SuppressWarnings("unchecked")
	public <T extends IObserver> T notify(Class<T> clazz) {
		if (clazz == null) {
			return null;
		}
		return (T) getProxyHandler(clazz, true).getProxy();
	}

	private List<IObserver> getObserver(Class<? extends IObserver> clazz, boolean force) {
		return getProxyHandler(clazz, force).getObservers();
	}

	/**
	 * Registers an observer for all observer interfaces implemented by the object or its super classes.
	 * 
	 * @param observer observer object
	 */
	public void register(IObserver observer) {
		register(observer, getObserverInterfaces(observer));
	}

	/**
	 * Registers an observer for the specified observer interfaces.
	 * 
	 * @param observer observer object
	 * @param classes set of classes
	 */
	public void register(IObserver observer, Class<? extends IObserver>... classes) {
		for (Class<? extends IObserver> iface : classes) {
			if (iface.isInstance(observer)) {
				getObserver(iface, true).add(observer);
			}
		}
	}

	/**
	 * Unregisters an observer for all observer interfaces implemented by the object or its super classes.
	 * 
	 * @param observer observer object
	 */
	public void unregister(IObserver observer) {
		unregister(observer, getObserverInterfaces(observer));
	}

	/**
	 * Unregisters an observer for the specified observer interfaces.
	 * 
	 * @param observer observer object
	 * @param classes set of classes
	 */
	public void unregister(IObserver observer, Class<? extends IObserver>... classes) {
		for (Class<? extends IObserver> iface : classes) {
			if (iface.isInstance(observer)) {
				List<IObserver> observers = getObserver(iface, false);
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

	/**
	 * Proxyobserver which notifies all observers.
	 * 
	 * @author wesendon
	 */
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

		// BEGIN SUPRESS CATCH EXCEPTION
		// TODO: handle exception
		// TODO: handle return values
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Object firstResult = null;
			for (IObserver observer : observers) {
				try {
					if (firstResult == null) {
						firstResult = method.invoke(observer, args);
					} else {
						method.invoke(observer, args);
					}
				} catch (Throwable e) {
				}
			}
			if (method.getReturnType().isPrimitive()) {
				return getDefaultValueForPrimitive(method.getReturnType());
			}

			return firstResult;
		}

		// END SUPRESS CATCH EXCEPTION

		private Object getDefaultValueForPrimitive(Class<?> returnType) {
			String simpleName = returnType.getSimpleName();
			return primitiveToObjectDefaultValueMap.get(simpleName);
		}

	}

	private static final Map<String, Object> primitiveToObjectDefaultValueMap = new HashMap<String, Object>();
	static {
		primitiveToObjectDefaultValueMap.put("int", new Integer(0));
		primitiveToObjectDefaultValueMap.put("boolean", new Boolean(false));
		primitiveToObjectDefaultValueMap.put("long", new Long(0));
		primitiveToObjectDefaultValueMap.put("float", new Float(0));
		primitiveToObjectDefaultValueMap.put("double", new Double(0));
		primitiveToObjectDefaultValueMap.put("byte", Byte.MIN_VALUE);
		primitiveToObjectDefaultValueMap.put("short", Short.MIN_VALUE);
	}

	@SuppressWarnings("unchecked")
	private Class<? extends IObserver>[] getObserverInterfaces(IObserver observer) {
		HashSet<Class<? extends IObserver>> result = new HashSet<Class<? extends IObserver>>();
		getClasses(observer.getClass(), result);
		return result.toArray(new Class[result.size()]);
	}

	@SuppressWarnings("unchecked")
	private boolean getClasses(Class<?> clazz, HashSet<Class<? extends IObserver>> result) {
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
