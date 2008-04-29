/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.unicase.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ModelElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.ModelElementImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__ID = 2;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__PROJECT = 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.FunctionalRequirementImpl <em>Functional Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.FunctionalRequirementImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getFunctionalRequirement()
	 * @generated
	 */
	int FUNCTIONAL_REQUIREMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__ID = MODEL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__PROJECT = MODEL_ELEMENT__PROJECT;

	/**
	 * The feature id for the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__REVIEWED = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__STORY_POINTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__PRIORITY = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__DATE = MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refining Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS = MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT = MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Functional Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_REQUIREMENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.unicase.model.Section <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.Section
	 * @see org.unicase.model.impl.ModelPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__DESCRIPTION = MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ID = MODEL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__PROJECT = MODEL_ELEMENT__PROJECT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__PARENT = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.LeafSectionImpl <em>Leaf Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.LeafSectionImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getLeafSection()
	 * @generated
	 */
	int LEAF_SECTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SECTION__NAME = SECTION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SECTION__DESCRIPTION = SECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SECTION__ID = SECTION__ID;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SECTION__PROJECT = SECTION__PROJECT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SECTION__PARENT = SECTION__PARENT;

	/**
	 * The feature id for the '<em><b>Element Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SECTION__ELEMENT_CLASS = SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Leaf Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SECTION_FEATURE_COUNT = SECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.CompositeSectionImpl <em>Composite Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.CompositeSectionImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getCompositeSection()
	 * @generated
	 */
	int COMPOSITE_SECTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SECTION__NAME = SECTION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SECTION__DESCRIPTION = SECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SECTION__ID = SECTION__ID;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SECTION__PROJECT = SECTION__PROJECT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SECTION__PARENT = SECTION__PARENT;

	/**
	 * The feature id for the '<em><b>Subsections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SECTION__SUBSECTIONS = SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SECTION_FEATURE_COUNT = SECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.ProjectImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Project Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PROJECT_ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__IDENTIFIER = 3;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link org.unicase.model.impl.ProjectIdImpl <em>Project Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.impl.ProjectIdImpl
	 * @see org.unicase.model.impl.ModelPackageImpl#getProjectId()
	 * @generated
	 */
	int PROJECT_ID = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ID__IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Project Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ID_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.ModelElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.unicase.model.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.ModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.model.ModelElement#getName()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.ModelElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.model.ModelElement#getDescription()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.ModelElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.unicase.model.ModelElement#getId()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Id();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.ModelElement#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.unicase.model.ModelElement#getProject()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_Project();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.FunctionalRequirement <em>Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functional Requirement</em>'.
	 * @see org.unicase.model.FunctionalRequirement
	 * @generated
	 */
	EClass getFunctionalRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.FunctionalRequirement#isReviewed <em>Reviewed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reviewed</em>'.
	 * @see org.unicase.model.FunctionalRequirement#isReviewed()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EAttribute getFunctionalRequirement_Reviewed();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.FunctionalRequirement#getStoryPoints <em>Story Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Story Points</em>'.
	 * @see org.unicase.model.FunctionalRequirement#getStoryPoints()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EAttribute getFunctionalRequirement_StoryPoints();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.FunctionalRequirement#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.unicase.model.FunctionalRequirement#getPriority()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EAttribute getFunctionalRequirement_Priority();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.FunctionalRequirement#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.model.FunctionalRequirement#getDate()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EAttribute getFunctionalRequirement_Date();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.FunctionalRequirement#getRefiningRequirements <em>Refining Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refining Requirements</em>'.
	 * @see org.unicase.model.FunctionalRequirement#getRefiningRequirements()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_RefiningRequirements();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.FunctionalRequirement#getRefinedRequirement <em>Refined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Refined Requirement</em>'.
	 * @see org.unicase.model.FunctionalRequirement#getRefinedRequirement()
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	EReference getFunctionalRequirement_RefinedRequirement();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.LeafSection <em>Leaf Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Section</em>'.
	 * @see org.unicase.model.LeafSection
	 * @generated
	 */
	EClass getLeafSection();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.LeafSection#getElementClass <em>Element Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Class</em>'.
	 * @see org.unicase.model.LeafSection#getElementClass()
	 * @see #getLeafSection()
	 * @generated
	 */
	EAttribute getLeafSection_ElementClass();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.CompositeSection <em>Composite Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Section</em>'.
	 * @see org.unicase.model.CompositeSection
	 * @generated
	 */
	EClass getCompositeSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.model.CompositeSection#getSubsections <em>Subsections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subsections</em>'.
	 * @see org.unicase.model.CompositeSection#getSubsections()
	 * @see #getCompositeSection()
	 * @generated
	 */
	EReference getCompositeSection_Subsections();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see org.unicase.model.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the container reference '{@link org.unicase.model.Section#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.unicase.model.Section#getParent()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Parent();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.unicase.model.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.model.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.Project#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.model.Project#getDescription()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.Project#getProjectElements <em>Project Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Project Elements</em>'.
	 * @see org.unicase.model.Project#getProjectElements()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ProjectElements();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.model.Project#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.unicase.model.Project#getIdentifier()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Identifier();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.ProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Id</em>'.
	 * @see org.unicase.model.ProjectId
	 * @generated
	 */
	EClass getProjectId();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.ProjectId#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.unicase.model.ProjectId#getIdentifier()
	 * @see #getProjectId()
	 * @generated
	 */
	EAttribute getProjectId_Identifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.ModelElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.ModelElementImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__DESCRIPTION = eINSTANCE.getModelElement_Description();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__ID = eINSTANCE.getModelElement_Id();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__PROJECT = eINSTANCE.getModelElement_Project();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.FunctionalRequirementImpl <em>Functional Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.FunctionalRequirementImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getFunctionalRequirement()
		 * @generated
		 */
		EClass FUNCTIONAL_REQUIREMENT = eINSTANCE.getFunctionalRequirement();

		/**
		 * The meta object literal for the '<em><b>Reviewed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_REQUIREMENT__REVIEWED = eINSTANCE.getFunctionalRequirement_Reviewed();

		/**
		 * The meta object literal for the '<em><b>Story Points</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_REQUIREMENT__STORY_POINTS = eINSTANCE.getFunctionalRequirement_StoryPoints();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_REQUIREMENT__PRIORITY = eINSTANCE.getFunctionalRequirement_Priority();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTIONAL_REQUIREMENT__DATE = eINSTANCE.getFunctionalRequirement_Date();

		/**
		 * The meta object literal for the '<em><b>Refining Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__REFINING_REQUIREMENTS = eINSTANCE.getFunctionalRequirement_RefiningRequirements();

		/**
		 * The meta object literal for the '<em><b>Refined Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL_REQUIREMENT__REFINED_REQUIREMENT = eINSTANCE.getFunctionalRequirement_RefinedRequirement();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.LeafSectionImpl <em>Leaf Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.LeafSectionImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getLeafSection()
		 * @generated
		 */
		EClass LEAF_SECTION = eINSTANCE.getLeafSection();

		/**
		 * The meta object literal for the '<em><b>Element Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_SECTION__ELEMENT_CLASS = eINSTANCE.getLeafSection_ElementClass();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.CompositeSectionImpl <em>Composite Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.CompositeSectionImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getCompositeSection()
		 * @generated
		 */
		EClass COMPOSITE_SECTION = eINSTANCE.getCompositeSection();

		/**
		 * The meta object literal for the '<em><b>Subsections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SECTION__SUBSECTIONS = eINSTANCE.getCompositeSection_Subsections();

		/**
		 * The meta object literal for the '{@link org.unicase.model.Section <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.Section
		 * @see org.unicase.model.impl.ModelPackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__PARENT = eINSTANCE.getSection_Parent();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.ProjectImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__DESCRIPTION = eINSTANCE.getProject_Description();

		/**
		 * The meta object literal for the '<em><b>Project Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__PROJECT_ELEMENTS = eINSTANCE.getProject_ProjectElements();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__IDENTIFIER = eINSTANCE.getProject_Identifier();

		/**
		 * The meta object literal for the '{@link org.unicase.model.impl.ProjectIdImpl <em>Project Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.impl.ProjectIdImpl
		 * @see org.unicase.model.impl.ModelPackageImpl#getProjectId()
		 * @generated
		 */
		EClass PROJECT_ID = eINSTANCE.getProjectId();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_ID__IDENTIFIER = eINSTANCE.getProjectId_Identifier();

	}

} //ModelPackage
