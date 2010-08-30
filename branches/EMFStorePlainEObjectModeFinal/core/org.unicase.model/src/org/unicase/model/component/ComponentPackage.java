/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.component;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.component.ComponentFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "component";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/component";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.component";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ComponentPackage eINSTANCE = org.unicase.model.component.impl.ComponentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.component.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.component.impl.ComponentImpl
	 * @see org.unicase.model.component.impl.ComponentPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PACKAGES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offered Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OFFERED_SERVICES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Consumed Services</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CONSUMED_SERVICES = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SUBSYSTEMS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Component</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.model.component.impl.ComponentServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.component.impl.ComponentServiceImpl
	 * @see org.unicase.model.component.impl.ComponentPackageImpl#getComponentService()
	 * @generated
	 */
	int COMPONENT_SERVICE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Offering Component</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__OFFERING_COMPONENT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Consuming Components</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE__CONSUMING_COMPONENTS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SERVICE_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.component.impl.DeploymentNodeImpl <em>Deployment Node</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.component.impl.DeploymentNodeImpl
	 * @see org.unicase.model.component.impl.ComponentPackageImpl#getDeploymentNode()
	 * @generated
	 */
	int DEPLOYMENT_NODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE__COMPONENTS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deployment Node</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_NODE_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class ' {@link org.unicase.model.component.Component <em>Component</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.unicase.model.component.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.component.Component#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Packages</em>'.
	 * @see org.unicase.model.component.Component#getPackages()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.component.Component#getOfferedServices <em>Offered Services</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Offered Services</em>'.
	 * @see org.unicase.model.component.Component#getOfferedServices()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_OfferedServices();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.component.Component#getConsumedServices <em>Consumed Services</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list ' <em>Consumed Services</em>'.
	 * @see org.unicase.model.component.Component#getConsumedServices()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ConsumedServices();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.component.Component#getSubsystems <em>Subsystems</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsystems</em>'.
	 * @see org.unicase.model.component.Component#getSubsystems()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Subsystems();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.component.ComponentService <em>Service</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.unicase.model.component.ComponentService
	 * @generated
	 */
	EClass getComponentService();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.model.component.ComponentService#getOfferingComponent <em>Offering Component</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference ' <em>Offering Component</em>'.
	 * @see org.unicase.model.component.ComponentService#getOfferingComponent()
	 * @see #getComponentService()
	 * @generated
	 */
	EReference getComponentService_OfferingComponent();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.model.component.ComponentService#getConsumingComponents <em>Consuming Components</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Consuming Components</em>'.
	 * @see org.unicase.model.component.ComponentService#getConsumingComponents()
	 * @see #getComponentService()
	 * @generated
	 */
	EReference getComponentService_ConsumingComponents();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.component.DeploymentNode <em>Deployment Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Node</em>'.
	 * @see org.unicase.model.component.DeploymentNode
	 * @generated
	 */
	EClass getDeploymentNode();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.component.DeploymentNode#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see org.unicase.model.component.DeploymentNode#getComponents()
	 * @see #getDeploymentNode()
	 * @generated
	 */
	EReference getDeploymentNode_Components();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentFactory getComponentFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.component.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.component.impl.ComponentImpl
		 * @see org.unicase.model.component.impl.ComponentPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PACKAGES = eINSTANCE.getComponent_Packages();

		/**
		 * The meta object literal for the '<em><b>Offered Services</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPONENT__OFFERED_SERVICES = eINSTANCE.getComponent_OfferedServices();

		/**
		 * The meta object literal for the '<em><b>Consumed Services</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPONENT__CONSUMED_SERVICES = eINSTANCE.getComponent_ConsumedServices();

		/**
		 * The meta object literal for the '<em><b>Subsystems</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__SUBSYSTEMS = eINSTANCE.getComponent_Subsystems();

		/**
		 * The meta object literal for the '{@link org.unicase.model.component.impl.ComponentServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.component.impl.ComponentServiceImpl
		 * @see org.unicase.model.component.impl.ComponentPackageImpl#getComponentService()
		 * @generated
		 */
		EClass COMPONENT_SERVICE = eINSTANCE.getComponentService();

		/**
		 * The meta object literal for the '<em><b>Offering Component</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPONENT_SERVICE__OFFERING_COMPONENT = eINSTANCE.getComponentService_OfferingComponent();

		/**
		 * The meta object literal for the '<em><b>Consuming Components</b></em> ' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPONENT_SERVICE__CONSUMING_COMPONENTS = eINSTANCE.getComponentService_ConsumingComponents();

		/**
		 * The meta object literal for the '{@link org.unicase.model.component.impl.DeploymentNodeImpl <em>Deployment Node</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.component.impl.DeploymentNodeImpl
		 * @see org.unicase.model.component.impl.ComponentPackageImpl#getDeploymentNode()
		 * @generated
		 */
		EClass DEPLOYMENT_NODE = eINSTANCE.getDeploymentNode();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_NODE__COMPONENTS = eINSTANCE.getDeploymentNode_Components();

	}

} // ComponentPackage
