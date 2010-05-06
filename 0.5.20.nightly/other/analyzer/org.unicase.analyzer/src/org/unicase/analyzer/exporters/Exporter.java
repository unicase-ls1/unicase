/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.exporters;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Exporter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.analyzer.exporters.Exporter#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.unicase.analyzer.exporters.Exporter#isOverwrite <em>Overwrite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.analyzer.exporters.ExportersPackage#getExporter()
 * @model abstract="true"
 * @generated
 */
public interface Exporter extends EObject {
	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.unicase.analyzer.exporters.ExportersPackage#getExporter_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.exporters.Exporter#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Overwrite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overwrite</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overwrite</em>' attribute.
	 * @see #setOverwrite(boolean)
	 * @see org.unicase.analyzer.exporters.ExportersPackage#getExporter_Overwrite()
	 * @model
	 * @generated
	 */
	boolean isOverwrite();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.exporters.Exporter#isOverwrite <em>Overwrite</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overwrite</em>' attribute.
	 * @see #isOverwrite()
	 * @generated
	 */
	void setOverwrite(boolean value);

	/**
	 * Write 2 dimensional object data into the targetFile, first column by column, then line by line.
	 * 
	 * @param lines 2 dimensional object data, each line including columns, i.e. inner list are columns, outer list are
	 *            lines
	 * @throws IOException @see {@link IOException}
	 */
	void export(List<List<Object>> lines) throws IOException;

	/**
	 * Write a line of object data into targetFile, column by column.
	 * 
	 * @param columns columns of a line
	 * @throws IOException @see {@link IOException}
	 */
	void writeLine(List<Object> columns) throws IOException;

} // Exporter
