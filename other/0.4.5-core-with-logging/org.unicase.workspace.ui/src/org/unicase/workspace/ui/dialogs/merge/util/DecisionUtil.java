/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.util;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;

/**
 * Class offering common methods for the merge dialog.
 * 
 * @author wesendon
 */
public final class DecisionUtil {

	private DecisionUtil() {
	}

	private static FontRegistry fontRegistry;

	/**
	 * Fetches image by path.
	 * 
	 * @param path
	 *            path
	 * @return image
	 */
	public static Image getImage(String path) {
		return getImageDescriptor(path).createImage();
	}

	/**
	 * Fetches image descriptor by path.
	 * 
	 * @param path
	 *            path
	 * @return {@link ImageDescriptor}
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		final String key = path;
		ImageDescriptor regImage = JFaceResources.getImageRegistry()
				.getDescriptor(key);
		if (regImage == null) {
			regImage = Activator.getImageDescriptor("icons/merge/" + path);
			JFaceResources.getImageRegistry().put(key, regImage);
		}
		return regImage;
	}

	/**
	 * Cuts a text to certain length and adds "..." at the end if needed.
	 * 
	 * @param str
	 *            text
	 * @param length
	 *            length
	 * @param addPoints
	 *            true, if ending dotts
	 * @return shortened string
	 */
	public static String cutString(String str, int length, boolean addPoints) {
		if (str == null) {
			return "";
		}
		if (str.length() > length) {
			str = str.substring(0, length);
			if (addPoints) {
				str += "...";
			}
			return str;
		} else {
			return str;
		}
	}

	/**
	 * Strips line breaking characters from text.
	 * 
	 * @param text
	 *            text
	 * @return linf of text
	 */
	public static String stripNewLine(String text) {
		if (text == null) {
			return "";
		}
		return text.replaceAll("\n\r|\r\n|\n \r|\r \n|\n|\r", " ");
	}

	/**
	 * Returns label provider.
	 * 
	 * @return provider
	 */
	public static AdapterFactoryLabelProvider getLabelProvider() {
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return provider;
	}

	/**
	 * Returns FontRegistry.
	 * 
	 * @return fonts
	 */
	public static FontRegistry getFontRegistry() {
		if (fontRegistry == null) {
			fontRegistry = new FontRegistry(Display.getCurrent());
			DecisionConfig.initFonts(fontRegistry);
		}
		return fontRegistry;
	}

	/**
	 * Get Option by is type.
	 * 
	 * @param options
	 *            list of options
	 * @param type
	 *            type
	 * @return resulting option or null
	 */
	public static ConflictOption getConflictOptionByType(
			List<ConflictOption> options, OptionType type) {
		for (ConflictOption option : options) {
			if (option.getType().equals(type)) {
				return option;
			}
		}
		return null;
	}

	/**
	 * Checks whether given operation is a composite op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isComposite(AbstractOperation operation) {
		return operation instanceof CompositeOperation
				&& ((CompositeOperation) operation).getMainOperation() == null;
	}

	/**
	 * Checks whether given operation is a reference op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isReference(AbstractOperation operation) {
		return isSingleRef(operation) || isMultiRef(operation)
				|| isCompositeRef(operation);
	}

	/**
	 * Checks whether given operation is a reference composite.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isCompositeRef(AbstractOperation operation) {
		return operation instanceof CompositeOperation
				&& ((CompositeOperation) operation).getMainOperation() != null;
	}

	/**
	 * Checks whether given operation is singleref op .
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isSingleRef(AbstractOperation operation) {
		return operation instanceof SingleReferenceOperation;
	}

	/**
	 * Checks whether given operation is a multiref op .
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isMultiRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceOperation;
	}

	/**
	 * Checks whether given operation is multimove op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isMultiMoveRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceMoveOperation;
	}

	/**
	 * Checks whether given operation is attribute op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isAttribute(AbstractOperation operation) {
		return operation instanceof AttributeOperation;
	}

	/**
	 * Checks whether given operation is diagram op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isDiagramLayout(AbstractOperation operation) {
		return operation instanceof DiagramLayoutOperation;
	}

	/**
	 * Checks whether given operation is a creating op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isCreate(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& !((CreateDeleteOperation) operation).isDelete();
	}

	/**
	 * Checks whether given operation is a deleting op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isDelete(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& ((CreateDeleteOperation) operation).isDelete();
	}

	/**
	 * Checks whether given operation is a createDelete op.
	 * 
	 * @param operation
	 *            operation
	 * @return true if correct
	 */
	public static boolean isCreateDelete(AbstractOperation operation) {
		return operation instanceof CreateDeleteOperation;
	}

	/**
	 * Checks whether a conflict needs details.
	 * 
	 * @param conflict
	 *            conflict
	 * @return true, if so
	 */
	public static boolean detailsNeeded(Conflict conflict) {
		if (!conflict.hasDetails()) {
			return false;
		}
		for (ConflictOption option : conflict.getOptions()) {
			if (!option.isDetailsProvider()) {
				continue;
			}
			if (option.getDetailProvider().startsWith(
					DecisionConfig.WIDGET_MULTILINE)) {
				if (option.getOptionLabel().length() > DecisionConfig.OPTION_LENGTH) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns Class and Name of {@link ModelElement}.
	 * 
	 * @param modelElement
	 *            modelelement
	 * @return string
	 */
	public static String getClassAndName(ModelElement modelElement) {
		if (modelElement == null) {
			return "";
		}
		String name = getAdapterFactory().getText(modelElement);
		return modelElement.eClass().getName() + " \"" + name + "\"";
	}

	/**
	 * Returns label provider.
	 * 
	 * @return label proivder
	 */
	public static AdapterFactoryLabelProvider getAdapterFactory() {
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return adapterFactoryLabelProvider;
	}
}
