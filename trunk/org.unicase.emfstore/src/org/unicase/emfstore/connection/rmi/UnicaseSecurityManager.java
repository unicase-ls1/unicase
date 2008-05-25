package org.unicase.emfstore.connection.rmi;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;

public class UnicaseSecurityManager extends SecurityManager {

	/** 
	 * @see java.lang.SecurityManager#checkAccept(java.lang.String, int)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkAccept(String host, int port) {
		//super.checkAccept(host, port);
	}

	/** 
	 * @see java.lang.SecurityManager#checkAccess(java.lang.Thread)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkAccess(Thread t) {
		// MK Auto-generated method stub
		//super.checkAccess(t);
	}

	/** 
	 * @see java.lang.SecurityManager#checkAccess(java.lang.ThreadGroup)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkAccess(ThreadGroup g) {
		// MK Auto-generated method stub
		//super.checkAccess(g);
	}

	/** 
	 * @see java.lang.SecurityManager#checkAwtEventQueueAccess()
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkAwtEventQueueAccess() {
		// MK Auto-generated method stub
		//super.checkAwtEventQueueAccess();
	}

	/** 
	 * @see java.lang.SecurityManager#checkConnect(java.lang.String, int, java.lang.Object)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkConnect(String host, int port, Object context) {
		// MK Auto-generated method stub
		//super.checkConnect(host, port, context);
	}

	/** 
	 * @see java.lang.SecurityManager#checkConnect(java.lang.String, int)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkConnect(String host, int port) {
		// MK Auto-generated method stub
		//super.checkConnect(host, port);
	}

	/** 
	 * @see java.lang.SecurityManager#checkCreateClassLoader()
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkCreateClassLoader() {
		// MK Auto-generated method stub
		//super.checkCreateClassLoader();
	}

	/** 
	 * @see java.lang.SecurityManager#checkDelete(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkDelete(String file) {
		// MK Auto-generated method stub
		//super.checkDelete(file);
	}

	/** 
	 * @see java.lang.SecurityManager#checkExec(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkExec(String cmd) {
		// MK Auto-generated method stub
		//super.checkExec(cmd);
	}

	/** 
	 * @see java.lang.SecurityManager#checkExit(int)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkExit(int status) {
		// MK Auto-generated method stub
		//super.checkExit(status);
	}

	/** 
	 * @see java.lang.SecurityManager#checkLink(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkLink(String lib) {
		// MK Auto-generated method stub
		//super.checkLink(lib);
	}

	/** 
	 * @see java.lang.SecurityManager#checkListen(int)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkListen(int port) {
		// MK Auto-generated method stub
		//super.checkListen(port);
	}

	/** 
	 * @see java.lang.SecurityManager#checkMemberAccess(java.lang.Class, int)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkMemberAccess(Class<?> clazz, int which) {
		// MK Auto-generated method stub
		//super.checkMemberAccess(clazz, which);
	}

	/** 
	 * @see java.lang.SecurityManager#checkMulticast(java.net.InetAddress, byte)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkMulticast(InetAddress maddr, byte ttl) {
		// MK Auto-generated method stub
		//super.checkMulticast(maddr, ttl);
	}

	/** 
	 * @see java.lang.SecurityManager#checkMulticast(java.net.InetAddress)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkMulticast(InetAddress maddr) {
		// MK Auto-generated method stub
		//super.checkMulticast(maddr);
	}

	/** 
	 * @see java.lang.SecurityManager#checkPackageAccess(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkPackageAccess(String pkg) {
		// MK Auto-generated method stub
		//super.checkPackageAccess(pkg);
	}

	/** 
	 * @see java.lang.SecurityManager#checkPackageDefinition(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkPackageDefinition(String pkg) {
		// MK Auto-generated method stub
		//super.checkPackageDefinition(pkg);
	}

	/** 
	 * @see java.lang.SecurityManager#checkPermission(java.security.Permission, java.lang.Object)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkPermission(Permission perm, Object context) {
		// MK Auto-generated method stub
		//super.checkPermission(perm, context);
	}

	/** 
	 * @see java.lang.SecurityManager#checkPermission(java.security.Permission)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkPermission(Permission perm) {
		// MK Auto-generated method stub
		//super.checkPermission(perm);
	}

	/** 
	 * @see java.lang.SecurityManager#checkPrintJobAccess()
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkPrintJobAccess() {
		// MK Auto-generated method stub
		//super.checkPrintJobAccess();
	}

	/** 
	 * @see java.lang.SecurityManager#checkPropertiesAccess()
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkPropertiesAccess() {
		// MK Auto-generated method stub
		//super.checkPropertiesAccess();
	}

	/** 
	 * @see java.lang.SecurityManager#checkPropertyAccess(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkPropertyAccess(String key) {
		// MK Auto-generated method stub
		//super.checkPropertyAccess(key);
	}

	/** 
	 * @see java.lang.SecurityManager#checkRead(java.io.FileDescriptor)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkRead(FileDescriptor fd) {
		// MK Auto-generated method stub
		//super.checkRead(fd);
	}

	/** 
	 * @see java.lang.SecurityManager#checkRead(java.lang.String, java.lang.Object)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkRead(String file, Object context) {
		// MK Auto-generated method stub
		//super.checkRead(file, context);
	}

	/** 
	 * @see java.lang.SecurityManager#checkRead(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkRead(String file) {
		// MK Auto-generated method stub
		//super.checkRead(file);
	}

	/** 
	 * @see java.lang.SecurityManager#checkSecurityAccess(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkSecurityAccess(String target) {
		// MK Auto-generated method stub
		//super.checkSecurityAccess(target);
	}

	/** 
	 * @see java.lang.SecurityManager#checkSetFactory()
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkSetFactory() {
		// MK Auto-generated method stub
		//super.checkSetFactory();
	}

	/** 
	 * @see java.lang.SecurityManager#checkSystemClipboardAccess()
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkSystemClipboardAccess() {
		// MK Auto-generated method stub
		//super.checkSystemClipboardAccess();
	}

	/** 
	 * @see java.lang.SecurityManager#checkTopLevelWindow(java.lang.Object)
	 *
	 * @generated NOT
	 */
	
	@Override
	public boolean checkTopLevelWindow(Object window) {
		// MK Auto-generated method stub
		return super.checkTopLevelWindow(window);
	}

	/** 
	 * @see java.lang.SecurityManager#checkWrite(java.io.FileDescriptor)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkWrite(FileDescriptor fd) {
		// MK Auto-generated method stub
		//super.checkWrite(fd);
	}

	/** 
	 * @see java.lang.SecurityManager#checkWrite(java.lang.String)
	 *
	 * @generated NOT
	 */
	
	@Override
	public void checkWrite(String file) {
		// MK Auto-generated method stub
		//super.checkWrite(file);
	}

}
