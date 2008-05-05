/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getProject <em>Project</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getLocalChanges <em>Local Changes</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getUsersession <em>Usersession</em>}</li>
 *   <li>{@link org.unicase.workspace.ProjectSpace#getLastUpdated <em>Last Updated</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace()
 * @model
 * @generated
 */
public interface ProjectSpace extends EObject {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(Project)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Project()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProject <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' containment reference.
	 * @see #setBaseVersion(PrimaryVersionSpec)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_BaseVersion()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getBaseVersion();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getBaseVersion <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' containment reference.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Local Changes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Changes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Changes</em>' containment reference.
	 * @see #setLocalChanges(ChangePackage)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_LocalChanges()
	 * @model containment="true"
	 * @generated
	 */
	ChangePackage getLocalChanges();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getLocalChanges <em>Local Changes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Changes</em>' containment reference.
	 * @see #getLocalChanges()
	 * @generated
	 */
	void setLocalChanges(ChangePackage value);

	/**
	 * Returns the value of the '<em><b>Usersession</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usersession</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usersession</em>' containment reference.
	 * @see #setUsersession(Usersession)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Usersession()
	 * @model containment="true"
	 * @generated
	 */
	Usersession getUsersession();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getUsersession <em>Usersession</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usersession</em>' containment reference.
	 * @see #getUsersession()
	 * @generated
	 */
	void setUsersession(Usersession value);

	/**
	 * Returns the value of the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Updated</em>' attribute.
	 * @see #setLastUpdated(Date)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_LastUpdated()
	 * @model
	 * @generated
	 */
	Date getLastUpdated();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getLastUpdated <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Updated</em>' attribute.
	 * @see #getLastUpdated()
	 * @generated
	 */
	void setLastUpdated(Date value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	PrimaryVersionSpec commit();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void update();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void update(VersionSpec version);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void revert();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void save();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init();

} // ProjectContainer
