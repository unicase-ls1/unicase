/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.emfstore.esmodel.notification.impl.NotificationPackageImpl;
import org.unicase.emfstore.esmodel.url.UrlPackage;
import org.unicase.emfstore.esmodel.url.impl.UrlPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerPackage;
import org.unicase.emfstore.esmodel.versioning.events.server.impl.ServerPackageImpl;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ContainmentType;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ModelElementGroup;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceSetOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationGroup;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class OperationsPackageImpl extends EPackageImpl implements OperationsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createDeleteOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiAttributeOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiAttributeSetOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiAttributeMoveOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleReferenceOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiReferenceOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiReferenceSetOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiReferenceMoveOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramLayoutOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationIdEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectToModelElementIdMapEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum containmentTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OperationsPackageImpl() {
		super(eNS_URI, OperationsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OperationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OperationsPackage init() {
		if (isInited) return (OperationsPackage)EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI);

		// Obtain or create and register package
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperationsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MetamodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) : EsmodelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) : VersioningPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		ServerPackageImpl theServerPackage = (ServerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) instanceof ServerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) : ServerPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);
		UrlPackageImpl theUrlPackage = (UrlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) : UrlPackage.eINSTANCE);

		// Create package meta-data objects
		theOperationsPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theServerPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();
		theNotificationPackage.createPackageContents();
		theUrlPackage.createPackageContents();

		// Initialize created meta-data
		theOperationsPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theServerPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();
		theUrlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOperationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI, theOperationsPackage);
		return theOperationsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractOperation() {
		return abstractOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOperation_Name() {
		return (EAttribute)abstractOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOperation_Description() {
		return (EAttribute)abstractOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractOperation_ModelElementId() {
		return (EReference)abstractOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOperation_Accepted() {
		return (EAttribute)abstractOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOperation_ClientDate() {
		return (EAttribute)abstractOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeOperation() {
		return compositeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeOperation_SubOperations() {
		return (EReference)compositeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeOperation_MainOperation() {
		return (EReference)compositeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeOperation_CompositeName() {
		return (EAttribute)compositeOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeOperation_CompositeDescription() {
		return (EAttribute)compositeOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeOperation_Reversed() {
		return (EAttribute)compositeOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureOperation() {
		return featureOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureOperation_FeatureName() {
		return (EAttribute)featureOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateDeleteOperation() {
		return createDeleteOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateDeleteOperation_Delete() {
		return (EAttribute)createDeleteOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateDeleteOperation_ModelElement() {
		return (EReference)createDeleteOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateDeleteOperation_SubOperations() {
		return (EReference)createDeleteOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateDeleteOperation_EObjectToIdMap() {
		return (EReference)createDeleteOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeOperation() {
		return attributeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOperation_OldValue() {
		return (EAttribute)attributeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOperation_NewValue() {
		return (EAttribute)attributeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiAttributeOperation() {
		return multiAttributeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeOperation_Add() {
		return (EAttribute)multiAttributeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeOperation_Indexes() {
		return (EAttribute)multiAttributeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeOperation_ReferencedValues() {
		return (EAttribute)multiAttributeOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiAttributeSetOperation() {
		return multiAttributeSetOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeSetOperation_Index() {
		return (EAttribute)multiAttributeSetOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeSetOperation_OldValue() {
		return (EAttribute)multiAttributeSetOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeSetOperation_NewValue() {
		return (EAttribute)multiAttributeSetOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiAttributeMoveOperation() {
		return multiAttributeMoveOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeMoveOperation_OldIndex() {
		return (EAttribute)multiAttributeMoveOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeMoveOperation_NewIndex() {
		return (EAttribute)multiAttributeMoveOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeMoveOperation_ReferencedValue() {
		return (EAttribute)multiAttributeMoveOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleReferenceOperation() {
		return singleReferenceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceOperation_OldValue() {
		return (EReference)singleReferenceOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceOperation_NewValue() {
		return (EReference)singleReferenceOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiReferenceOperation() {
		return multiReferenceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceOperation_Add() {
		return (EAttribute)multiReferenceOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceOperation_Index() {
		return (EAttribute)multiReferenceOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceOperation_ReferencedModelElements() {
		return (EReference)multiReferenceOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiReferenceSetOperation() {
		return multiReferenceSetOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceSetOperation_Index() {
		return (EAttribute)multiReferenceSetOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceSetOperation_OldValue() {
		return (EReference)multiReferenceSetOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceSetOperation_NewValue() {
		return (EReference)multiReferenceSetOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiReferenceMoveOperation() {
		return multiReferenceMoveOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceMoveOperation_OldIndex() {
		return (EAttribute)multiReferenceMoveOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceMoveOperation_NewIndex() {
		return (EAttribute)multiReferenceMoveOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceMoveOperation_ReferencedModelElementId() {
		return (EReference)multiReferenceMoveOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceOperation() {
		return referenceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceOperation_Bidirectional() {
		return (EAttribute)referenceOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceOperation_OppositeFeatureName() {
		return (EAttribute)referenceOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceOperation_ContainmentType() {
		return (EAttribute)referenceOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagramLayoutOperation() {
		return diagramLayoutOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationId() {
		return operationIdEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationGroup() {
		return operationGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationGroup_Name() {
		return (EAttribute)operationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationGroup_Operations() {
		return (EReference)operationGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementGroup() {
		return modelElementGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementGroup_Name() {
		return (EAttribute)modelElementGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementGroup_ModelElements() {
		return (EReference)modelElementGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectToModelElementIdMap() {
		return eObjectToModelElementIdMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectToModelElementIdMap_Key() {
		return (EReference)eObjectToModelElementIdMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectToModelElementIdMap_Value() {
		return (EReference)eObjectToModelElementIdMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContainmentType() {
		return containmentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactory getOperationsFactory() {
		return (OperationsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractOperationEClass = createEClass(ABSTRACT_OPERATION);
		createEAttribute(abstractOperationEClass, ABSTRACT_OPERATION__NAME);
		createEAttribute(abstractOperationEClass, ABSTRACT_OPERATION__DESCRIPTION);
		createEReference(abstractOperationEClass, ABSTRACT_OPERATION__MODEL_ELEMENT_ID);
		createEAttribute(abstractOperationEClass, ABSTRACT_OPERATION__ACCEPTED);
		createEAttribute(abstractOperationEClass, ABSTRACT_OPERATION__CLIENT_DATE);

		compositeOperationEClass = createEClass(COMPOSITE_OPERATION);
		createEReference(compositeOperationEClass, COMPOSITE_OPERATION__SUB_OPERATIONS);
		createEReference(compositeOperationEClass, COMPOSITE_OPERATION__MAIN_OPERATION);
		createEAttribute(compositeOperationEClass, COMPOSITE_OPERATION__COMPOSITE_NAME);
		createEAttribute(compositeOperationEClass, COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION);
		createEAttribute(compositeOperationEClass, COMPOSITE_OPERATION__REVERSED);

		featureOperationEClass = createEClass(FEATURE_OPERATION);
		createEAttribute(featureOperationEClass, FEATURE_OPERATION__FEATURE_NAME);

		createDeleteOperationEClass = createEClass(CREATE_DELETE_OPERATION);
		createEAttribute(createDeleteOperationEClass, CREATE_DELETE_OPERATION__DELETE);
		createEReference(createDeleteOperationEClass, CREATE_DELETE_OPERATION__MODEL_ELEMENT);
		createEReference(createDeleteOperationEClass, CREATE_DELETE_OPERATION__SUB_OPERATIONS);
		createEReference(createDeleteOperationEClass, CREATE_DELETE_OPERATION__EOBJECT_TO_ID_MAP);

		attributeOperationEClass = createEClass(ATTRIBUTE_OPERATION);
		createEAttribute(attributeOperationEClass, ATTRIBUTE_OPERATION__OLD_VALUE);
		createEAttribute(attributeOperationEClass, ATTRIBUTE_OPERATION__NEW_VALUE);

		multiAttributeOperationEClass = createEClass(MULTI_ATTRIBUTE_OPERATION);
		createEAttribute(multiAttributeOperationEClass, MULTI_ATTRIBUTE_OPERATION__ADD);
		createEAttribute(multiAttributeOperationEClass, MULTI_ATTRIBUTE_OPERATION__INDEXES);
		createEAttribute(multiAttributeOperationEClass, MULTI_ATTRIBUTE_OPERATION__REFERENCED_VALUES);

		multiAttributeSetOperationEClass = createEClass(MULTI_ATTRIBUTE_SET_OPERATION);
		createEAttribute(multiAttributeSetOperationEClass, MULTI_ATTRIBUTE_SET_OPERATION__INDEX);
		createEAttribute(multiAttributeSetOperationEClass, MULTI_ATTRIBUTE_SET_OPERATION__OLD_VALUE);
		createEAttribute(multiAttributeSetOperationEClass, MULTI_ATTRIBUTE_SET_OPERATION__NEW_VALUE);

		multiAttributeMoveOperationEClass = createEClass(MULTI_ATTRIBUTE_MOVE_OPERATION);
		createEAttribute(multiAttributeMoveOperationEClass, MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX);
		createEAttribute(multiAttributeMoveOperationEClass, MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX);
		createEAttribute(multiAttributeMoveOperationEClass, MULTI_ATTRIBUTE_MOVE_OPERATION__REFERENCED_VALUE);

		singleReferenceOperationEClass = createEClass(SINGLE_REFERENCE_OPERATION);
		createEReference(singleReferenceOperationEClass, SINGLE_REFERENCE_OPERATION__OLD_VALUE);
		createEReference(singleReferenceOperationEClass, SINGLE_REFERENCE_OPERATION__NEW_VALUE);

		multiReferenceSetOperationEClass = createEClass(MULTI_REFERENCE_SET_OPERATION);
		createEAttribute(multiReferenceSetOperationEClass, MULTI_REFERENCE_SET_OPERATION__INDEX);
		createEReference(multiReferenceSetOperationEClass, MULTI_REFERENCE_SET_OPERATION__OLD_VALUE);
		createEReference(multiReferenceSetOperationEClass, MULTI_REFERENCE_SET_OPERATION__NEW_VALUE);

		multiReferenceOperationEClass = createEClass(MULTI_REFERENCE_OPERATION);
		createEAttribute(multiReferenceOperationEClass, MULTI_REFERENCE_OPERATION__ADD);
		createEAttribute(multiReferenceOperationEClass, MULTI_REFERENCE_OPERATION__INDEX);
		createEReference(multiReferenceOperationEClass, MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS);

		multiReferenceMoveOperationEClass = createEClass(MULTI_REFERENCE_MOVE_OPERATION);
		createEAttribute(multiReferenceMoveOperationEClass, MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX);
		createEAttribute(multiReferenceMoveOperationEClass, MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX);
		createEReference(multiReferenceMoveOperationEClass, MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID);

		referenceOperationEClass = createEClass(REFERENCE_OPERATION);
		createEAttribute(referenceOperationEClass, REFERENCE_OPERATION__BIDIRECTIONAL);
		createEAttribute(referenceOperationEClass, REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME);
		createEAttribute(referenceOperationEClass, REFERENCE_OPERATION__CONTAINMENT_TYPE);

		diagramLayoutOperationEClass = createEClass(DIAGRAM_LAYOUT_OPERATION);

		operationIdEClass = createEClass(OPERATION_ID);

		operationGroupEClass = createEClass(OPERATION_GROUP);
		createEAttribute(operationGroupEClass, OPERATION_GROUP__NAME);
		createEReference(operationGroupEClass, OPERATION_GROUP__OPERATIONS);

		modelElementGroupEClass = createEClass(MODEL_ELEMENT_GROUP);
		createEAttribute(modelElementGroupEClass, MODEL_ELEMENT_GROUP__NAME);
		createEReference(modelElementGroupEClass, MODEL_ELEMENT_GROUP__MODEL_ELEMENTS);

		eObjectToModelElementIdMapEClass = createEClass(EOBJECT_TO_MODEL_ELEMENT_ID_MAP);
		createEReference(eObjectToModelElementIdMapEClass, EOBJECT_TO_MODEL_ELEMENT_ID_MAP__KEY);
		createEReference(eObjectToModelElementIdMapEClass, EOBJECT_TO_MODEL_ELEMENT_ID_MAP__VALUE);

		// Create enums
		containmentTypeEEnum = createEEnum(CONTAINMENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SemanticPackage theSemanticPackage = (SemanticPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSemanticPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractOperationEClass.getESuperTypes().add(theMetamodelPackage.getIdentifiableElement());
		compositeOperationEClass.getESuperTypes().add(this.getAbstractOperation());
		featureOperationEClass.getESuperTypes().add(this.getAbstractOperation());
		createDeleteOperationEClass.getESuperTypes().add(this.getAbstractOperation());
		attributeOperationEClass.getESuperTypes().add(this.getFeatureOperation());
		multiAttributeOperationEClass.getESuperTypes().add(this.getFeatureOperation());
		multiAttributeSetOperationEClass.getESuperTypes().add(this.getFeatureOperation());
		multiAttributeMoveOperationEClass.getESuperTypes().add(this.getFeatureOperation());
		singleReferenceOperationEClass.getESuperTypes().add(this.getReferenceOperation());
		multiReferenceSetOperationEClass.getESuperTypes().add(this.getReferenceOperation());
		multiReferenceOperationEClass.getESuperTypes().add(this.getReferenceOperation());
		multiReferenceMoveOperationEClass.getESuperTypes().add(this.getFeatureOperation());
		referenceOperationEClass.getESuperTypes().add(this.getFeatureOperation());
		diagramLayoutOperationEClass.getESuperTypes().add(this.getAttributeOperation());
		operationIdEClass.getESuperTypes().add(theMetamodelPackage.getUniqueIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractOperationEClass, AbstractOperation.class, "AbstractOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractOperation_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractOperation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOperation_Description(), ecorePackage.getEString(), "description", "", 0, 1, AbstractOperation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractOperation_ModelElementId(), theMetamodelPackage.getModelElementId(), null, "modelElementId", null, 0, 1, AbstractOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOperation_Accepted(), ecorePackage.getEBoolean(), "accepted", null, 0, 1, AbstractOperation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOperation_ClientDate(), ecorePackage.getEDate(), "clientDate", null, 0, 1, AbstractOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeOperationEClass, CompositeOperation.class, "CompositeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeOperation_SubOperations(), this.getAbstractOperation(), null, "subOperations", null, 0, -1, CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeOperation_MainOperation(), this.getAbstractOperation(), null, "mainOperation", null, 0, 1, CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeOperation_CompositeName(), ecorePackage.getEString(), "compositeName", null, 0, 1, CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeOperation_CompositeDescription(), ecorePackage.getEString(), "compositeDescription", null, 0, 1, CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeOperation_Reversed(), ecorePackage.getEBoolean(), "reversed", null, 0, 1, CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureOperationEClass, FeatureOperation.class, "FeatureOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureOperation_FeatureName(), ecorePackage.getEString(), "featureName", "", 0, 1, FeatureOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createDeleteOperationEClass, CreateDeleteOperation.class, "CreateDeleteOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateDeleteOperation_Delete(), ecorePackage.getEBoolean(), "delete", null, 0, 1, CreateDeleteOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateDeleteOperation_ModelElement(), ecorePackage.getEObject(), null, "modelElement", null, 0, 1, CreateDeleteOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateDeleteOperation_SubOperations(), this.getReferenceOperation(), null, "subOperations", null, 0, -1, CreateDeleteOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateDeleteOperation_EObjectToIdMap(), this.getEObjectToModelElementIdMap(), null, "eObjectToIdMap", null, 0, -1, CreateDeleteOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeOperationEClass, AttributeOperation.class, "AttributeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeOperation_OldValue(), ecorePackage.getEJavaObject(), "oldValue", null, 0, 1, AttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeOperation_NewValue(), ecorePackage.getEJavaObject(), "newValue", null, 0, 1, AttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiAttributeOperationEClass, MultiAttributeOperation.class, "MultiAttributeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiAttributeOperation_Add(), ecorePackage.getEBoolean(), "add", null, 0, 1, MultiAttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiAttributeOperation_Indexes(), ecorePackage.getEInt(), "indexes", null, 0, -1, MultiAttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiAttributeOperation_ReferencedValues(), ecorePackage.getEJavaObject(), "referencedValues", null, 0, -1, MultiAttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiAttributeSetOperationEClass, MultiAttributeSetOperation.class, "MultiAttributeSetOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiAttributeSetOperation_Index(), ecorePackage.getEInt(), "index", null, 0, 1, MultiAttributeSetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiAttributeSetOperation_OldValue(), ecorePackage.getEJavaObject(), "oldValue", null, 0, 1, MultiAttributeSetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiAttributeSetOperation_NewValue(), ecorePackage.getEJavaObject(), "newValue", null, 0, 1, MultiAttributeSetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiAttributeMoveOperationEClass, MultiAttributeMoveOperation.class, "MultiAttributeMoveOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiAttributeMoveOperation_OldIndex(), ecorePackage.getEInt(), "oldIndex", null, 0, 1, MultiAttributeMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiAttributeMoveOperation_NewIndex(), ecorePackage.getEInt(), "newIndex", null, 0, 1, MultiAttributeMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiAttributeMoveOperation_ReferencedValue(), ecorePackage.getEJavaObject(), "referencedValue", null, 0, 1, MultiAttributeMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleReferenceOperationEClass, SingleReferenceOperation.class, "SingleReferenceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleReferenceOperation_OldValue(), theMetamodelPackage.getModelElementId(), null, "oldValue", null, 0, 1, SingleReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferenceOperation_NewValue(), theMetamodelPackage.getModelElementId(), null, "newValue", null, 0, 1, SingleReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiReferenceSetOperationEClass, MultiReferenceSetOperation.class, "MultiReferenceSetOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiReferenceSetOperation_Index(), ecorePackage.getEInt(), "index", null, 0, 1, MultiReferenceSetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiReferenceSetOperation_OldValue(), theMetamodelPackage.getModelElementId(), null, "oldValue", null, 0, 1, MultiReferenceSetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiReferenceSetOperation_NewValue(), theMetamodelPackage.getModelElementId(), null, "newValue", null, 0, 1, MultiReferenceSetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiReferenceOperationEClass, MultiReferenceOperation.class, "MultiReferenceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiReferenceOperation_Add(), ecorePackage.getEBoolean(), "add", null, 0, 1, MultiReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiReferenceOperation_Index(), ecorePackage.getEInt(), "index", null, 0, 1, MultiReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiReferenceOperation_ReferencedModelElements(), theMetamodelPackage.getModelElementId(), null, "referencedModelElements", null, 0, -1, MultiReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiReferenceMoveOperationEClass, MultiReferenceMoveOperation.class, "MultiReferenceMoveOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiReferenceMoveOperation_OldIndex(), ecorePackage.getEInt(), "oldIndex", null, 0, 1, MultiReferenceMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiReferenceMoveOperation_NewIndex(), ecorePackage.getEInt(), "newIndex", null, 0, 1, MultiReferenceMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiReferenceMoveOperation_ReferencedModelElementId(), theMetamodelPackage.getModelElementId(), null, "referencedModelElementId", null, 0, 1, MultiReferenceMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceOperationEClass, ReferenceOperation.class, "ReferenceOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceOperation_Bidirectional(), ecorePackage.getEBoolean(), "bidirectional", null, 0, 1, ReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceOperation_OppositeFeatureName(), ecorePackage.getEString(), "oppositeFeatureName", null, 0, 1, ReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceOperation_ContainmentType(), this.getContainmentType(), "containmentType", null, 0, 1, ReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagramLayoutOperationEClass, DiagramLayoutOperation.class, "DiagramLayoutOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationIdEClass, OperationId.class, "OperationId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationGroupEClass, OperationGroup.class, "OperationGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, OperationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationGroup_Operations(), this.getAbstractOperation(), null, "operations", null, 0, -1, OperationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementGroupEClass, ModelElementGroup.class, "ModelElementGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElementGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementGroup_ModelElements(), theMetamodelPackage.getModelElementId(), null, "modelElements", null, 0, -1, ModelElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectToModelElementIdMapEClass, Map.Entry.class, "EObjectToModelElementIdMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectToModelElementIdMap_Key(), ecorePackage.getEObject(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectToModelElementIdMap_Value(), theMetamodelPackage.getModelElementId(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(containmentTypeEEnum, ContainmentType.class, "ContainmentType");
		addEEnumLiteral(containmentTypeEEnum, ContainmentType.NONE);
		addEEnumLiteral(containmentTypeEEnum, ContainmentType.CONTAINER);
		addEEnumLiteral(containmentTypeEEnum, ContainmentType.CONTAINMENT);
	}

} // OperationsPackageImpl
