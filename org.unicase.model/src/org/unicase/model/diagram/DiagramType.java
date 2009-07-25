/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Type</b></em>', and utility
 * methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.diagram.DiagramPackage#getDiagramType()
 * @model
 * @generated NOT
 */
public enum DiagramType implements Enumerator {
	/**
	 * The '<em><b>CLASS DIAGRAM</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CLASS_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	CLASS_DIAGRAM(0, "CLASS_DIAGRAM", "CLASS_DIAGRAM", "", ""),

	/**
	 * The '<em><b>USECASE DIAGRAM</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #USECASE_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	USECASE_DIAGRAM(1, "USECASE_DIAGRAM", "USECASE_DIAGRAM", "", ""),

	/**
	 * The '<em><b>COMPONENT DIAGRAM</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #COMPONENT_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	COMPONENT_DIAGRAM(2, "COMPONENT_DIAGRAM", "COMPONENT_DIAGRAM", "", ""), /**
	 * The '<em><b>STATE DIAGRAM</b></em>'
	 * literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #STATE_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_DIAGRAM(3, "STATE_DIAGRAM", "STATE_DIAGRAM", "", ""), /**
	 * The '<em><b>ACTIVITY DIAGRAM</b></em>' literal
	 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #ACTIVITY_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVITY_DIAGRAM(4, "ACTIVITY_DIAGRAM", "ACTIVITY_DIAGRAM", "", ""), /**
	 * The '<em><b>WORKITEM DIAGRAM</b></em>'
	 * literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #WORKITEM_DIAGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	WORKITEM_DIAGRAM(5, "WORKITEM_DIAGRAM", "WORKITEM_DIAGRAM", "", ""), ;

	/**
	 * The '<em><b>CLASS DIAGRAM</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLASS DIAGRAM</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CLASS_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_DIAGRAM_VALUE = 0;

	/**
	 * The '<em><b>USECASE DIAGRAM</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USECASE DIAGRAM</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #USECASE_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USECASE_DIAGRAM_VALUE = 1;

	/**
	 * The '<em><b>COMPONENT DIAGRAM</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPONENT DIAGRAM</b></em>' literal object isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #COMPONENT_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT_DIAGRAM_VALUE = 2;

	/**
	 * The '<em><b>STATE DIAGRAM</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATE DIAGRAM</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STATE_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATE_DIAGRAM_VALUE = 3;

	/**
	 * The '<em><b>ACTIVITY DIAGRAM</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIVITY DIAGRAM</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ACTIVITY_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVITY_DIAGRAM_VALUE = 4;

	/**
	 * The '<em><b>WORKITEM DIAGRAM</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WORKITEM DIAGRAM</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #WORKITEM_DIAGRAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WORKITEM_DIAGRAM_VALUE = 5;

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DiagramType[] VALUES_ARRAY = new DiagramType[] { CLASS_DIAGRAM, USECASE_DIAGRAM,
		COMPONENT_DIAGRAM, STATE_DIAGRAM, ACTIVITY_DIAGRAM, WORKITEM_DIAGRAM, };

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public static final List<DiagramType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
	public static List<DiagramType> DYNVALUES;

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static DiagramType get(String literal) {
		INIT();
		for (int i = 0; i < DYNVALUES.size(); ++i) {
			DiagramType result = DYNVALUES.get(i);
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DiagramType getByName(String name) {
		INIT();
		for (int i = 0; i < DYNVALUES.size(); ++i) {
			DiagramType result = DYNVALUES.get(i);
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	static boolean initialized = false;

	@SuppressWarnings("unchecked")
	public static void INIT() {
		if (initialized) {
			return;
		}
		try {
			DiagramType.DYNVALUES = new ArrayList<DiagramType>();
			Constructor con = DiagramType.class.getDeclaredConstructors()[0];
			Method[] methods = con.getClass().getDeclaredMethods();
			for (Method m : methods) {
				if (m.getName().equals("acquireConstructorAccessor")) {
					m.setAccessible(true);
					m.invoke(con, new Object[0]);
				}
			}
			Field[] fields = con.getClass().getDeclaredFields();
			Object ca = null;
			for (Field f : fields) {
				if (f.getName().equals("constructorAccessor")) {
					f.setAccessible(true);
					ca = f.get(con);
				}
			}
			Method m = ca.getClass().getMethod("newInstance", new Class[] { Object[].class });
			m.setAccessible(true);

			IExtensionRegistry reg = Platform.getExtensionRegistry();
			IConfigurationElement[] extensions = reg.getConfigurationElementsFor("org.eclipse.ui.editors");
			int j = 0;
			for (int i = 0; i < extensions.length; i++) {
				IConfigurationElement element = extensions[i];
				String classid = element.getAttribute("id");
				if (classid.contains("ModelDiagramEditor")) {
					String name = element.getAttribute("extensions");
					String literal = name + "Diagram";
					String icon = element.getAttribute("icon");
					DiagramType v = (DiagramType) m.invoke(ca, new Object[] { new Object[] { name, j, j, name, literal,
						classid, icon } });
					DiagramType.DYNVALUES.add(v);
					j++;
				}
			}
			initialized = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static DiagramType get(int value) {
		INIT();
		return DYNVALUES.get(value);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	private final String editorClassID;

	private final String icon;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	private DiagramType(int value, String name, String literal, String editorClassID, String icon) {
		this.value = value;
		this.name = name;
		this.literal = literal;
		this.editorClassID = editorClassID;
		this.icon = icon;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

	/**
	 * @return the editorClassID
	 */
	public String getEditorClassID() {
		return editorClassID;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

} // DiagramType
