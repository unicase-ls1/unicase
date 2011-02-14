/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.usecase.UseCase#getActorSteps <em>Actor Steps</em>}</li>
 *   <li>{@link org.unicase.model.usecase.UseCase#getSystemSteps <em>System Steps</em>}</li>
 *   <li>{@link org.unicase.model.usecase.UseCase#getPrecon <em>Precon</em>}</li>
 *   <li>{@link org.unicase.model.usecase.UseCase#getPostcon <em>Postcon</em>}</li>
 *   <li>{@link org.unicase.model.usecase.UseCase#getRul <em>Rul</em>}</li>
 *   <li>{@link org.unicase.model.usecase.UseCase#getExc <em>Exc</em>}</li>
 *   <li>{@link org.unicase.model.usecase.UseCase#getSync <em>Sync</em>}</li>
 *   <li>{@link org.unicase.model.usecase.UseCase#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.usecase.UsecasePackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends org.unicase.model.requirement.UseCase {
	/**
	 * Returns the value of the '<em><b>Actor Steps</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.usecase.ActorStep}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.usecase.ActorStep#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Steps</em>' containment reference list.
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_ActorSteps()
	 * @see org.unicase.model.usecase.ActorStep#getUseCase
	 * @model opposite="useCase" containment="true" resolveProxies="true" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='1.0' position='right'"
	 * @generated
	 */
	EList<ActorStep> getActorSteps();

	/**
	 * Returns the value of the '<em><b>System Steps</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.usecase.SystemStep}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.usecase.SystemStep#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Steps</em>' containment reference list.
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_SystemSteps()
	 * @see org.unicase.model.usecase.SystemStep#getUseCase
	 * @model opposite="useCase" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<SystemStep> getSystemSteps();

	/**
	 * Returns the value of the '<em><b>Precon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precon</em>' attribute.
	 * @see #setPrecon(String)
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_Precon()
	 * @model annotation="org.unicase.ui.meeditor priority='1.1' position='left'"
	 * @generated
	 */
	String getPrecon();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.UseCase#getPrecon <em>Precon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precon</em>' attribute.
	 * @see #getPrecon()
	 * @generated
	 */
	void setPrecon(String value);

	/**
	 * Returns the value of the '<em><b>Postcon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcon</em>' attribute.
	 * @see #setPostcon(String)
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_Postcon()
	 * @model annotation="org.unicase.ui.meeditor priority='1.3' position='left'"
	 * @generated
	 */
	String getPostcon();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.UseCase#getPostcon <em>Postcon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postcon</em>' attribute.
	 * @see #getPostcon()
	 * @generated
	 */
	void setPostcon(String value);

	/**
	 * Returns the value of the '<em><b>Rul</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rul</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rul</em>' attribute.
	 * @see #setRul(String)
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_Rul()
	 * @model annotation="org.unicase.ui.meeditor priority='1.2' position='left'"
	 * @generated
	 */
	String getRul();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.UseCase#getRul <em>Rul</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rul</em>' attribute.
	 * @see #getRul()
	 * @generated
	 */
	void setRul(String value);

	/**
	 * Returns the value of the '<em><b>Exc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exc</em>' attribute.
	 * @see #setExc(String)
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_Exc()
	 * @model annotation="org.unicase.ui.meeditor priority='1.4' position='left'"
	 * @generated
	 */
	String getExc();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.UseCase#getExc <em>Exc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exc</em>' attribute.
	 * @see #getExc()
	 * @generated
	 */
	void setExc(String value);

	/**
	 * Returns the value of the '<em><b>Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync</em>' attribute.
	 * @see #setSync(String)
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_Sync()
	 * @model
	 * @generated
	 */
	String getSync();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.UseCase#getSync <em>Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync</em>' attribute.
	 * @see #getSync()
	 * @generated
	 */
	void setSync(String value);

	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.usecase.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cases</em>' reference list.
	 * @see org.unicase.model.usecase.UsecasePackage#getUseCase_UseCases()
	 * @model annotation="org.unicase.ui.meeditor priority='1.1' position='right'"
	 * @generated
	 */
	EList<UseCase> getUseCases();

} // UseCase
