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
package org.eclipse.emf.emfstore.server.backchannel.connection.server;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;

/**
 * This SecurityManager will make no restrictions at all to get RMI running.
 * 
 * @author koegel
 */
// MK: make some restrictions
public class EMFStoreSecurityManager extends SecurityManager {

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkAccept(java.lang.String, int)
	 */
	@Override
	public void checkAccept(String host, int port) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkAccess(java.lang.Thread)
	 */
	@Override
	public void checkAccess(Thread t) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkAccess(java.lang.ThreadGroup)
	 */
	@Override
	public void checkAccess(ThreadGroup g) {
		// do nothing
	}

	/**
	 * @see java.lang.SecurityManager#checkAwtEventQueueAccess()
	 * @generated NOT
	 */

	@Override
	public void checkAwtEventQueueAccess() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkConnect(java.lang.String, int, java.lang.Object)
	 */
	@Override
	public void checkConnect(String host, int port, Object context) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkConnect(java.lang.String, int)
	 */
	@Override
	public void checkConnect(String host, int port) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkCreateClassLoader()
	 */
	@Override
	public void checkCreateClassLoader() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkDelete(java.lang.String)
	 */
	@Override
	public void checkDelete(String file) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkExec(java.lang.String)
	 */
	@Override
	public void checkExec(String cmd) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkExit(int)
	 */
	@Override
	public void checkExit(int status) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkLink(java.lang.String)
	 */
	@Override
	public void checkLink(String lib) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkListen(int)
	 */
	@Override
	public void checkListen(int port) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkMemberAccess(java.lang.Class, int)
	 */
	@Override
	public void checkMemberAccess(Class<?> clazz, int which) {
		// do nothing;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkMulticast(java.net.InetAddress, byte)
	 */
	@Override
	public void checkMulticast(InetAddress maddr, byte ttl) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkMulticast(java.net.InetAddress)
	 */
	@Override
	public void checkMulticast(InetAddress maddr) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkPackageAccess(java.lang.String)
	 */
	@Override
	public void checkPackageAccess(String pkg) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkPackageDefinition(java.lang.String)
	 */
	@Override
	public void checkPackageDefinition(String pkg) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkPermission(java.security.Permission, java.lang.Object)
	 */
	@Override
	public void checkPermission(Permission perm, Object context) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkPermission(java.security.Permission)
	 */
	@Override
	public void checkPermission(Permission perm) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkPrintJobAccess()
	 */
	@Override
	public void checkPrintJobAccess() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkPropertiesAccess()
	 */
	@Override
	public void checkPropertiesAccess() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 */
	@Override
	public void checkPropertyAccess(String key) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkRead(java.io.FileDescriptor)
	 */
	@Override
	public void checkRead(FileDescriptor fd) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkRead(java.lang.String, java.lang.Object)
	 */
	@Override
	public void checkRead(String file, Object context) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkRead(java.lang.String)
	 */
	@Override
	public void checkRead(String file) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkSecurityAccess(java.lang.String)
	 */
	@Override
	public void checkSecurityAccess(String target) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkSetFactory()
	 */
	@Override
	public void checkSetFactory() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkSystemClipboardAccess()
	 */
	@Override
	public void checkSystemClipboardAccess() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkWrite(java.io.FileDescriptor)
	 */
	@Override
	public void checkWrite(FileDescriptor fd) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.SecurityManager#checkWrite(java.lang.String)
	 */
	@Override
	public void checkWrite(String file) {
		// do nothing
	}

}
