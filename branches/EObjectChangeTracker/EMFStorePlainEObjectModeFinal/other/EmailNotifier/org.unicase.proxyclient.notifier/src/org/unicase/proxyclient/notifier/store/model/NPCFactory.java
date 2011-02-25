/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.proxyclient.notifier.store.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage
 * @generated
 */
public interface NPCFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NPCFactory eINSTANCE = org.unicase.proxyclient.notifier.store.model.impl.NPCFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Notifier Proxy Client Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notifier Proxy Client Store</em>'.
	 * @generated
	 */
	NotifierProxyClientStore createNotifierProxyClientStore();

	/**
	 * Returns a new object of class '<em>Notification Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Project</em>'.
	 * @generated
	 */
	NotificationProject createNotificationProject();

	/**
	 * Returns a new object of class '<em>Notification Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Group</em>'.
	 * @generated
	 */
	NotificationGroup createNotificationGroup();

	/**
	 * Returns a new object of class '<em>Notification Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Entry</em>'.
	 * @generated
	 */
	NotificationEntry createNotificationEntry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NPCPackage getNPCPackage();

} //NPCFactory
