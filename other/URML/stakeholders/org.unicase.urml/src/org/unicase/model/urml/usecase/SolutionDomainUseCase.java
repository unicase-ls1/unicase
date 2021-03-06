/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase;

import org.unicase.model.urml.feature.AbstractFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Solution Domain Use Case</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.usecase.SolutionDomainUseCase#getDetailedFeature <em>Detailed Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.usecase.UsecasePackage#getSolutionDomainUseCase()
 * @model
 * @generated
 */
public interface SolutionDomainUseCase extends UseCase {
	/**
	 * Returns the value of the '<em><b>Detailed Feature</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getDetailingUseCases <em>Detailing Use Cases</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed Feature</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Detailed Feature</em>' reference.
	 * @see #setDetailedFeature(AbstractFeature)
	 * @see org.unicase.model.urml.usecase.UsecasePackage#getSolutionDomainUseCase_DetailedFeature()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getDetailingUseCases
	 * @model opposite="detailingUseCases" keys="identifier"
	 * @generated
	 */
	AbstractFeature getDetailedFeature();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.usecase.SolutionDomainUseCase#getDetailedFeature <em>Detailed Feature</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detailed Feature</em>' reference.
	 * @see #getDetailedFeature()
	 * @generated
	 */
	void setDetailedFeature(AbstractFeature value);

} // SolutionDomainUseCase
