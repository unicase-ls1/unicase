/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import java.text.SimpleDateFormat;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsDescriptionProvider;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

/**
 * Label provider for the scm views.
 * 
 * @author Shterev
 */
public class SCMLabelProvider extends ColumnLabelProvider {

	private OperationsDescriptionProvider operationsDescriptionProvider;
	private Project project;
	private static final String ELEMENT_NOT_FOUND = "There is no sufficient information to display this element";

	/**
	 * Default constructor.
	 * 
	 * @param project the project.
	 */
	public SCMLabelProvider(Project project) {
		super();
		this.operationsDescriptionProvider = new OperationsDescriptionProvider(project);
		this.project = project;
	}

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	private ChangePackageVisualizationHelper changePackageVisualizationHelper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
		if (element instanceof TreeNode) {
			Object value = ((TreeNode) element).getValue();
			if (value instanceof HistoryInfo) {
				HistoryInfo historyInfo = (HistoryInfo) value;
				String baseVersion = "";
				if (historyInfo.getPrimerySpec().getIdentifier() == WorkspaceManager.getProjectSpace(project)
					.getBaseVersion().getIdentifier()) {
					baseVersion = "*";
				}
				StringBuilder builder = new StringBuilder();
				builder.append(baseVersion);
				builder.append("Version ");
				builder.append(historyInfo.getPrimerySpec().getIdentifier());
				LogMessage logMessage = null;

				if (historyInfo.getLogMessage() != null) {
					logMessage = historyInfo.getLogMessage();
				} else if (historyInfo.getChangePackage()!=null && historyInfo.getChangePackage().getLogMessage() != null) {
					logMessage = historyInfo.getChangePackage().getLogMessage();
				}
				if (logMessage != null) {
					builder.append(" [");
					builder.append(logMessage.getAuthor());
					builder.append(" @ ");
					builder.append(dateFormat.format(logMessage.getClientDate()));
					builder.append("] ");
					builder.append(logMessage.getMessage());
				}
				return builder.toString();

			} else if (value instanceof AbstractOperation) {
				return operationsDescriptionProvider.getDescription((AbstractOperation) value);
			} else if (value instanceof ModelElement) {
				return ((ModelElement) value).getName();
			} else if (value instanceof ModelElementId) {
				ModelElement modelElement = changePackageVisualizationHelper.getModelElement((ModelElementId)value);
				if(modelElement!=null){
					return modelElement.getName();
				}else{
					return ELEMENT_NOT_FOUND;
				}
			} else if (value instanceof EObject) {
				return ((EObject) value).eClass().getName();
			}
		}
		return super.getText(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Font getFont(Object element) {
		if(!(element instanceof TreeNode)){
			return null;
		}
		Object value = ((TreeNode)element).getValue();
		if (value instanceof HistoryInfo) {
			HistoryInfo historyInfo = (HistoryInfo) value;
			if (historyInfo.getPrimerySpec().getIdentifier() == WorkspaceManager.getProjectSpace(project)
				.getBaseVersion().getIdentifier()) {
				return JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT);
			}
		} else if(value instanceof ModelElementId) {
			if(getText(element).equals(ELEMENT_NOT_FOUND)){
				return JFaceResources.getFontRegistry().getItalic(JFaceResources.DIALOG_FONT);
			}
		} 
		if(((TreeNode)element).getParent()!=null && ((TreeNode)element).getParent().getValue() instanceof AbstractOperation){
			AbstractOperation op = (AbstractOperation) ((TreeNode)element).getParent().getValue();
			if((value instanceof ModelElementId && value.equals(op.getModelElementId()))
				|| (value instanceof ModelElement && ((ModelElement)value).getModelElementId().equals(op.getModelElementId()))){
				return JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {

		if (element instanceof TreeNode) {
			Object value = ((TreeNode) element).getValue();
			if(value instanceof ModelElementId){
				return adapterFactoryLabelProvider.getImage(changePackageVisualizationHelper.getModelElement((ModelElementId)value));
			}
			return adapterFactoryLabelProvider.getImage(value);
		}

		return super.getImage(element);
	}
	
	/**
	 * @param changePackageVisualizationHelper the changePackageVisualizationHelper to set
	 */
	public void setChangePackageVisualizationHelper(ChangePackageVisualizationHelper changePackageVisualizationHelper) {
		this.changePackageVisualizationHelper = changePackageVisualizationHelper;
	}

	/**
	 * @return the changePackageVisualizationHelper
	 */
	public ChangePackageVisualizationHelper getChangePackageVisualizationHelper() {
		return changePackageVisualizationHelper;
	}
}
