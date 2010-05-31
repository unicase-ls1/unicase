/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.proxyclient.notifier.store.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.unicase.proxyclient.notifier.store.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NPCFactoryImpl extends EFactoryImpl implements NPCFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NPCFactory init() {
		try {
			NPCFactory theNPCFactory = (NPCFactory)EPackage.Registry.INSTANCE.getEFactory("platform:/plugin/org.unicase.proxyclient.notifier/model/ProxyClientModel.ecore"); 
			if (theNPCFactory != null) {
				return theNPCFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NPCFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NPCFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NPCPackage.NOTIFIER_PROXY_CLIENT_STORE: return createNotifierProxyClientStore();
			case NPCPackage.NOTIFICATION_PROJECT: return createNotificationProject();
			case NPCPackage.NOTIFICATION_GROUP: return createNotificationGroup();
			case NPCPackage.NOTIFICATION_ENTRY: return createNotificationEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotifierProxyClientStore createNotifierProxyClientStore() {
		NotifierProxyClientStoreImpl notifierProxyClientStore = new NotifierProxyClientStoreImpl();
		return notifierProxyClientStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationProject createNotificationProject() {
		NotificationProjectImpl notificationProject = new NotificationProjectImpl();
		return notificationProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationGroup createNotificationGroup() {
		NotificationGroupImpl notificationGroup = new NotificationGroupImpl();
		return notificationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationEntry createNotificationEntry() {
		NotificationEntryImpl notificationEntry = new NotificationEntryImpl();
		return notificationEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NPCPackage getNPCPackage() {
		return (NPCPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NPCPackage getPackage() {
		return NPCPackage.eINSTANCE;
	}

} //NPCFactoryImpl
