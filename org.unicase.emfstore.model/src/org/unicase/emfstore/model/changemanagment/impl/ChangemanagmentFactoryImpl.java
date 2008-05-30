/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model.changemanagment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.model.changemanagment.ChangePackage;
import org.unicase.emfstore.model.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.model.changemanagment.ChangemanagmentPackage;
import org.unicase.emfstore.model.changemanagment.DateVersionSpec;
import org.unicase.emfstore.model.changemanagment.HeadVersionSpec;
import org.unicase.emfstore.model.changemanagment.HistoryInfo;
import org.unicase.emfstore.model.changemanagment.LogMessage;
import org.unicase.emfstore.model.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.model.changemanagment.TagVersionSpec;
import org.unicase.emfstore.model.changemanagment.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangemanagmentFactoryImpl extends EFactoryImpl implements ChangemanagmentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ChangemanagmentFactory init() {
		try {
			ChangemanagmentFactory theChangemanagmentFactory = (ChangemanagmentFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/esmodel/changemanagment"); 
			if (theChangemanagmentFactory != null) {
				return theChangemanagmentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ChangemanagmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangemanagmentFactoryImpl() {
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
			case ChangemanagmentPackage.TAG_VERSION_SPEC: return createTagVersionSpec();
			case ChangemanagmentPackage.DATE_VERSION_SPEC: return createDateVersionSpec();
			case ChangemanagmentPackage.PRIMARY_VERSION_SPEC: return createPrimaryVersionSpec();
			case ChangemanagmentPackage.LOG_MESSAGE: return createLogMessage();
			case ChangemanagmentPackage.CHANGE_PACKAGE: return createChangePackage();
			case ChangemanagmentPackage.HISTORY_INFO: return createHistoryInfo();
			case ChangemanagmentPackage.VERSION: return createVersion();
			case ChangemanagmentPackage.HEAD_VERSION_SPEC: return createHeadVersionSpec();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TagVersionSpec createTagVersionSpec() {
		TagVersionSpecImpl tagVersionSpec = new TagVersionSpecImpl();
		return tagVersionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateVersionSpec createDateVersionSpec() {
		DateVersionSpecImpl dateVersionSpec = new DateVersionSpecImpl();
		return dateVersionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec createPrimaryVersionSpec() {
		PrimaryVersionSpecImpl primaryVersionSpec = new PrimaryVersionSpecImpl();
		return primaryVersionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage createLogMessage() {
		LogMessageImpl logMessage = new LogMessageImpl();
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage createChangePackage() {
		ChangePackageImpl changePackage = new ChangePackageImpl();
		return changePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryInfo createHistoryInfo() {
		HistoryInfoImpl historyInfo = new HistoryInfoImpl();
		return historyInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeadVersionSpec createHeadVersionSpec() {
		HeadVersionSpecImpl headVersionSpec = new HeadVersionSpecImpl();
		return headVersionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangemanagmentPackage getChangemanagmentPackage() {
		return (ChangemanagmentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ChangemanagmentPackage getPackage() {
		return ChangemanagmentPackage.eINSTANCE;
	}

} //ChangemanagmentFactoryImpl
