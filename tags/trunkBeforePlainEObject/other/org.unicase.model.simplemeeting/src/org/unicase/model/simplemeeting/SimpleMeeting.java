/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.simplemeeting;

import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Meeting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getLocation <em>Location</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getStarttime <em>Starttime</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getEndtime <em>Endtime</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getFacilitator <em>Facilitator</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getMinutetaker <em>Minutetaker</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getTimekeeper <em>Timekeeper</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getStatusItems <em>Status Items</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getDiscussionItems <em>Discussion Items</em>}</li>
 *   <li>{@link org.unicase.model.simplemeeting.SimpleMeeting#getIdentifiedItems <em>Identified Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting()
 * @model
 * @generated
 */
public interface SimpleMeeting extends UnicaseModelElement {

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_Location()
	 * @model annotation="org.unicase.ui.meeditor priority='10.0' position='left'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.unicase.model.simplemeeting.SimpleMeeting#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Starttime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starttime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starttime</em>' attribute.
	 * @see #setStarttime(Date)
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_Starttime()
	 * @model annotation="org.unicase.ui.meeditor priority='11.0' position='left'"
	 * @generated
	 */
	Date getStarttime();

	/**
	 * Sets the value of the '{@link org.unicase.model.simplemeeting.SimpleMeeting#getStarttime <em>Starttime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starttime</em>' attribute.
	 * @see #getStarttime()
	 * @generated
	 */
	void setStarttime(Date value);

	/**
	 * Returns the value of the '<em><b>Endtime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endtime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endtime</em>' attribute.
	 * @see #setEndtime(Date)
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_Endtime()
	 * @model annotation="org.unicase.ui.meeditor priority='11.0' position='left'"
	 * @generated
	 */
	Date getEndtime();

	/**
	 * Sets the value of the '{@link org.unicase.model.simplemeeting.SimpleMeeting#getEndtime <em>Endtime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endtime</em>' attribute.
	 * @see #getEndtime()
	 * @generated
	 */
	void setEndtime(Date value);

	/**
	 * Returns the value of the '<em><b>Facilitator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facilitator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facilitator</em>' reference.
	 * @see #setFacilitator(User)
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_Facilitator()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='12.0' position='left'"
	 * @generated
	 */
	User getFacilitator();

	/**
	 * Sets the value of the '{@link org.unicase.model.simplemeeting.SimpleMeeting#getFacilitator <em>Facilitator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facilitator</em>' reference.
	 * @see #getFacilitator()
	 * @generated
	 */
	void setFacilitator(User value);

	/**
	 * Returns the value of the '<em><b>Minutetaker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minutetaker</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minutetaker</em>' reference.
	 * @see #setMinutetaker(User)
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_Minutetaker()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='12.0' position='left'"
	 * @generated
	 */
	User getMinutetaker();

	/**
	 * Sets the value of the '{@link org.unicase.model.simplemeeting.SimpleMeeting#getMinutetaker <em>Minutetaker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minutetaker</em>' reference.
	 * @see #getMinutetaker()
	 * @generated
	 */
	void setMinutetaker(User value);

	/**
	 * Returns the value of the '<em><b>Timekeeper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timekeeper</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timekeeper</em>' reference.
	 * @see #setTimekeeper(User)
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_Timekeeper()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='12.0' position='left'"
	 * @generated
	 */
	User getTimekeeper();

	/**
	 * Sets the value of the '{@link org.unicase.model.simplemeeting.SimpleMeeting#getTimekeeper <em>Timekeeper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timekeeper</em>' reference.
	 * @see #getTimekeeper()
	 * @generated
	 */
	void setTimekeeper(User value);

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.organization.OrgUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' reference list.
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_Participants()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<OrgUnit> getParticipants();

	/**
	 * Returns the value of the '<em><b>Status Items</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.task.WorkItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Items</em>' reference list.
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_StatusItems()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='11.0' position='right'"
	 * @generated
	 */
	EList<WorkItem> getStatusItems();

	/**
	 * Returns the value of the '<em><b>Discussion Items</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.task.WorkItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discussion Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discussion Items</em>' reference list.
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_DiscussionItems()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='12.0' position='right'"
	 * @generated
	 */
	EList<WorkItem> getDiscussionItems();

	/**
	 * Returns the value of the '<em><b>Identified Items</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.task.WorkItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identified Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identified Items</em>' reference list.
	 * @see org.unicase.model.simplemeeting.SimplemeetingPackage#getSimpleMeeting_IdentifiedItems()
	 * @model keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='13.0' position='right'"
	 * @generated
	 */
	EList<WorkItem> getIdentifiedItems();
} // SimpleMeeting
