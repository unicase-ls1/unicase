/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgeFactory;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.Mathematical_GeophysicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KnowledgeFactoryImpl extends EFactoryImpl implements
		KnowledgeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KnowledgeFactory init() {
		try {
			KnowledgeFactory theKnowledgeFactory = (KnowledgeFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/scrm/knowledge");
			if (theKnowledgeFactory != null) {
				return theKnowledgeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KnowledgeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeFactoryImpl() {
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
		case KnowledgePackage.KNOWLEDGE_SPACE:
			return createKnowledgeSpace();
		case KnowledgePackage.SCIENTIFIC_PROBLEM:
			return createScientificProblem();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL:
			return createMathematical_GeophysicalModel();
		case KnowledgePackage.NUMERICAL_METHOD:
			return createNumericalMethod();
		case KnowledgePackage.ASSUMPTION:
			return createAssumption();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem createScientificProblem() {
		ScientificProblemImpl scientificProblem = new ScientificProblemImpl();
		return scientificProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mathematical_GeophysicalModel createMathematical_GeophysicalModel() {
		Mathematical_GeophysicalModelImpl mathematical_GeophysicalModel = new Mathematical_GeophysicalModelImpl();
		return mathematical_GeophysicalModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod createNumericalMethod() {
		NumericalMethodImpl numericalMethod = new NumericalMethodImpl();
		return numericalMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assumption createAssumption() {
		AssumptionImpl assumption = new AssumptionImpl();
		return assumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace createKnowledgeSpace() {
		KnowledgeSpaceImpl knowledgeSpace = new KnowledgeSpaceImpl();
		return knowledgeSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgePackage getKnowledgePackage() {
		return (KnowledgePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static KnowledgePackage getPackage() {
		return KnowledgePackage.eINSTANCE;
	}

} //KnowledgeFactoryImpl
