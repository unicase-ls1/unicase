/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import java.awt.Color;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This element represents a basic table.
 * 
 * @see UTableCell
 * @author Sebastian Hoecht
 */
public class UTable extends UCompositeSection {

	private BoxModelOption defaultCellBoxModel = OptionsFactory.eINSTANCE.createBoxModelOption();
	private int widthPercentage = 90;
	private TextOption defaultTextOption = OptionsFactory.eINSTANCE.createTextOption();

	private float[] columnsWidths;

	private int columnsCount;
	private ArrayList<UTableCell> entries = new ArrayList<UTableCell>();

	/**
	 * @param columnCount the amount of columns of this table
	 */
	public UTable(int columnCount) {
		this.setColumnsCount(columnCount);
		this.getBoxModel().setBackgroundColor(new Color(255, 255, 255));
		defaultCellBoxModel.setBackgroundColor(new Color(255, 255, 255));
	}

	/**
	 * @param entry the entry (cell) which shall be added to the table
	 */
	public void add(UTableCell entry) {
		entries.add(entry);
	}

	/**
	 * Adds an UEntry containing the text.
	 * 
	 * @param text the content of the UEntry
	 */
	public void add(String text) {
		UTableCell uEntry = new UTableCell(text, defaultTextOption);
		uEntry.setBoxModel(defaultCellBoxModel);
		entries.add(uEntry);
	}

	/**
	 * Adds an UEntry containing the text.
	 * 
	 * @param text the content of the UEntry
	 * @param option the TextOption which decorates the Text
	 */
	public void add(String text, TextOption option) {
		UTableCell uEntry = new UTableCell(text, option);
		uEntry.setBoxModel(defaultCellBoxModel);
		entries.add(uEntry);
	}

	/**
	 * @param doc the document you want to add to the table into a table cell. Only UParagraphs can be added.
	 * @see org.unicase.docExport.exportModel.renderers.elements.UCompositeSection#add(org.unicase.docExport.exportModel.renderers.elements.UDocument)
	 */
	@Override
	public void add(UDocument doc) {
		if (!(doc instanceof UParagraph)) {
			WorkspaceUtil.log("You can only add UParagraphs to a table", new Exception(), IStatus.ERROR);
		} else {
			UTableCell uEntry = new UTableCell(doc);
			entries.add(uEntry);
		}
	}

	/**
	 * @return all entries in this table
	 */
	public ArrayList<UTableCell> getEntries() {
		return entries;
	}

	/**
	 * @param columnsCount the columnsCount to set
	 */
	public void setColumnsCount(int columnsCount) {
		this.columnsCount = columnsCount;
	}

	/**
	 * @return the columnsCount
	 */
	public int getColumnsCount() {
		return columnsCount;
	}

	/**
	 * @return the widthPercentage
	 */
	public int getWidthPercentage() {
		return widthPercentage;
	}

	/**
	 * @param widthPercentage the widthPercentage to set
	 */
	public void setWidthPercentage(int widthPercentage) {
		this.widthPercentage = widthPercentage;
	}

	/**
	 * @return the columnsWidths
	 */
	public float[] getColumnsWidths() {
		if (columnsWidths == null) {
			return new float[] {};
		}
		return columnsWidths;
	}

	/**
	 * @param columnsWidths the columnsWidths to set
	 */
	public void setColumnsWidths(float[] columnsWidths) {
		if (columnsWidths.length != columnsCount) {
			WorkspaceUtil.log("the widths array must contain " + columnsCount + " entires", new Exception(),
				IStatus.WARNING);
			return;
		}
		this.columnsWidths = columnsWidths;
	}

	/**
	 * @param defaultCellBoxModel the defaultCellBoxModel to set
	 */
	public void setDefaultCellBoxModel(BoxModelOption defaultCellBoxModel) {
		this.defaultCellBoxModel = defaultCellBoxModel;
	}

	/**
	 * @return the defaultCellBoxModel
	 */
	public BoxModelOption getDefaultCellBoxModel() {
		return defaultCellBoxModel;
	}

	/**
	 * @param defaultTextOption the defaultTextOption to set
	 */
	public void setDefaultTextOption(TextOption defaultTextOption) {
		this.defaultTextOption = (TextOption) EcoreUtil.copy(defaultTextOption);
	}

	/**
	 * @return the defaultTextOption
	 */
	public TextOption getDefaultTextOption() {
		return defaultTextOption;
	}

}
