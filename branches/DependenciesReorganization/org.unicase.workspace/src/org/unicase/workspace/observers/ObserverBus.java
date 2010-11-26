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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * This is a universel observer bus. Better documentation will follow...
 * 
 * <pre>
 * // A is AbstractObserver
 * A a = new A() {
 * 	public void blub() {
 * 		System.out.println(&quot;go!&quot;);
 * 	}
 * };
 * 
 * // B extends A and is abstractObserver
 * B b = new B() {
 * 
 * 	public void say(String ja) {
 * 		System.out.println(&quot;b says: &quot; + ja);
 * 	}
 * 
 * 	public void blub() {
 * 		System.out.println(&quot;hö?&quot;);
 * 	}
 * };
 * 
 * // B is registered first
 * ObserverBus.registerObserver(b);
 * ObserverBus.registerObserver(a);
 * 
 * // notify observers
 * ObserverBus.send(A.class).blub();
 * 
 * System.out.println(&quot;\n === \n&quot;);
 * 
 * ObserverBus.send(B.class).say(&quot;w00t&quot;);
 * 
 * // Ausgabe: 
 * 
 * // hö?
 * // go!
 * //
 * // ===
 * //
 * // b says: w00t
 * 
 * </pre>
 * 
 * @author wesendon
 */
public class ObserverBus {

	private static ObserverBus instance;
	private HashMap<Class<? extends AbstractObserver>, Object> observerProxies;
	private HashMap<Class<? extends AbstractObserver>, List<AbstractObserver>> observerList;

	private ObserverBus() {
		observerProxies = new HashMap<Class<? extends AbstractObserver>, Object>();
		observerList = new HashMap<Class<? extends AbstractObserver>, List<AbstractObserver>>();
	}

	private static ObserverBus getInstance() {
		if (instance == null) {
			instance = new ObserverBus();
		}
		return instance;
	}

	/**
	 * This method allows you to notify all observers.
	 * 
	 * @param <T> class of observer
	 * @param clazz class of observer
	 * @return call object
	 */
	@SuppressWarnings("unchecked")
	public static <T extends AbstractObserver> T send(Class<T> clazz) {
		if (clazz == null) {
			return null;
		}
		ObserverBus i = getInstance();
		Object observer = i.observerProxies.get(clazz);
		if (observer == null) {
			observer = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, i.new Invocator(clazz));
			i.observerProxies.put(clazz, observer);
		}
		return (T) observer;
	}

	private List<AbstractObserver> getObserver(Class<? extends AbstractObserver> clazz) {
		List<AbstractObserver> observer = observerList.get(clazz);
		if (observer == null) {
			observer = new ArrayList<AbstractObserver>();
			observerList.put(clazz, observer);
		}
		return observer;
	}

	/**
	 * Register an observer.
	 * 
	 * @param observer
	 */
	public static void register(AbstractObserver observer) {
		ObserverBus i = getInstance();
		for (Class<? extends AbstractObserver> iface : getObserverInterfaces(observer)) {
			i.getObserver(iface).add(observer);
		}
	}

	/**
	 * Unregister an observer.
	 * 
	 * @param observer
	 */
	public static void unregister(AbstractObserver observer) {
		ObserverBus i = getInstance();
		for (Class<? extends AbstractObserver> iface : getObserverInterfaces(observer)) {
			i.getObserver(iface).remove(observer);
		}
	}

	private final class Invocator implements InvocationHandler {
		private Class<? extends AbstractObserver> clazz;

		public Invocator(Class<? extends AbstractObserver> clazz) {
			this.clazz = clazz;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			for (AbstractObserver observer : getObserver(clazz)) {
				method.invoke(observer, args);
			}
			// TODO: handle return values
			return null;
		}
	}

	private static Collection<Class<? extends AbstractObserver>> getObserverInterfaces(AbstractObserver observer) {
		HashSet<Class<? extends AbstractObserver>> result = new HashSet<Class<? extends AbstractObserver>>();
		getClasses(observer.getClass(), result);
		return result;
	}

	// TODO: double check this method, i think to many interfaces are added
	@SuppressWarnings("unchecked")
	private static boolean getClasses(Class<?> clazz, HashSet<Class<? extends AbstractObserver>> result) {
		for (Class<?> iface : clazz.getInterfaces()) {
			if (iface.equals(AbstractObserver.class)) {
				result.add((Class<? extends AbstractObserver>) clazz);
				return true;
			} else {
				if (getClasses(iface, result)) {
					result.add((Class<? extends AbstractObserver>) clazz);
				}
			}
		}
		return false;
	}
}
