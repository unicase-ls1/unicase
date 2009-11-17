/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.text.SimpleDateFormat;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.ui.common.util.UiUtil;

/**
 * Label provider for the model element column in the viewer.
 * 
 * @author Shterev
 */
public class MENameLabelProvider extends ColumnLabelProvider {

	private ILabelProvider emfProvider;
	private ChangePackageVisualizationHelper visualizationHelper;
	private OperationColorLabelProvider opBackgroundLabelProvider;

	/**
	 * Default constructor.
	 * 
	 * @param emfProvider
	 *            the default label provider.
	 * @param visualizationHelper
	 *            the visualizationHelper
	 */
	public MENameLabelProvider(ILabelProvider emfProvider,
			ChangePackageVisualizationHelper visualizationHelper) {
		this.emfProvider = emfProvider;
		this.visualizationHelper = visualizationHelper;
	}

	/**
	 * Default constructor.
	 * 
	 * @param emfProvider
	 *            the default label provider.
	 * @param visualizationHelper
	 *            the visualizationHelper
	 * @param opBackgroundLabelProvider
	 *            the visualizationHelper
	 */
	public MENameLabelProvider(ILabelProvider emfProvider,
			ChangePackageVisualizationHelper visualizationHelper,
			OperationColorLabelProvider opBackgroundLabelProvider) {
		this(emfProvider, visualizationHelper);
		this.opBackgroundLabelProvider = opBackgroundLabelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		final String deleted = "(Deleted Element)";
		if (element == null || element instanceof ModelElementId) {
			cell.setText(deleted);
			return;
		}
		if (element instanceof AbstractOperation) {
			AbstractOperation operation = (AbstractOperation) element;
			ModelElement me = visualizationHelper.getModelElement(operation
					.getModelElementId());
			// hack for missing model elements
			if (me != null) {
				cell.setText(UiUtil.getNameForModelElement(me));
				cell.setImage(emfProvider.getImage(me));
			} else {
				cell.setText(deleted);
			}
			if (opBackgroundLabelProvider != null) {
				cell.setForeground(opBackgroundLabelProvider
						.getColor(operation));
			}
		} else if (element instanceof ChangePackage) {
			ChangePackage cPackage = (ChangePackage) element;
			LogMessage logMessage = cPackage.getLogMessage();
			if (logMessage != null) {
				StringBuffer log = new StringBuffer();
				log.append("Change Package");
				log.append(" ");
				log.append("[");
				log.append(logMessage.getAuthor());
				log.append("@");
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm");
				log.append(format.format(logMessage.getDate()));
				log.append("]");
				cell.setText(log.toString());
			} else {
				cell.setText("Change Package");
			}
		} else if (element instanceof ModelElement) {
			cell.setText(emfProvider.getText(element));
			cell.setImage(emfProvider.getImage(element));
		}
	}

	/**
	 * @param opBackgroundLabelProvider
	 *            the opBackgroundLabelProvider to set
	 */
	public void setOpBackgroundLabelProvider(
			OperationColorLabelProvider opBackgroundLabelProvider) {
		this.opBackgroundLabelProvider = opBackgroundLabelProvider;
	}

	/**
	 * @return the opBackgroundLabelProvider
	 */
	public OperationColorLabelProvider getOpBackgroundLabelProvider() {
		return opBackgroundLabelProvider;
	}
}
