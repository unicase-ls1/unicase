package org.unicase.mergetest.merge.util;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;

public class DecisionUtil {

	private static FontRegistry fontRegistry;

	public static Image getImage(String path) {
		return getImageDescriptor(path).createImage();
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		final String key = path;
		ImageDescriptor regImage = JFaceResources.getImageRegistry()
				.getDescriptor(key);
		if (regImage == null) {
			regImage = ImageDescriptor
					.createFromImageData(new ImageData(
							DecisionUtil.class
									.getResourceAsStream("../../../../../icons/"
											+ path)));
			JFaceResources.getImageRegistry().put(key, regImage);
		}
		return regImage;
	}

	public static String cutString(String result, int length, boolean addPoints) {
		if (result == null) {
			return "";
		}
		if (result.length() > length) {
			result = result.substring(0, length);
			if (addPoints) {
				result += "...";
			}
			return result;
		} else {
			return result;
		}
	}

	public static String stripNewLine(String text) {
		return text.replaceAll("\n\r|\r\n|\n \r|\r \n|\n|\r", " ");
	}
	
	public static AdapterFactoryLabelProvider getLabelProvider() {
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return provider;
	}

	public static FontRegistry getFontRegistry() {
		if (fontRegistry == null) {
			fontRegistry = new FontRegistry(Display.getCurrent());
			DecisionConfig.initFonts(fontRegistry);
		}
		return fontRegistry;
	}

	public static boolean isComposite(AbstractOperation operation) {
		return operation instanceof CompositeOperation
				&& ((CompositeOperation) operation).getMainOperation() == null;
	}

	public static boolean isReference(AbstractOperation operation) {
		return isSingleRef(operation) || isMultiRef(operation)
				|| isCompositeRef(operation);
	}

	public static boolean isCompositeRef(AbstractOperation operation) {
		return operation instanceof CompositeOperation
				&& ((CompositeOperation) operation).getMainOperation() != null;
	}

	public static boolean isSingleRef(AbstractOperation operation) {
		return operation instanceof SingleReferenceOperation;
	}

	public static boolean isMultiRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceOperation;
	}

	public static boolean isMultiMoveRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceMoveOperation;
	}

	public static boolean isAttribute(AbstractOperation operation) {
		return operation instanceof AttributeOperation;
	}

	public static boolean isCreate(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& !((CreateDeleteOperation) operation).isDelete();
	}

	public static boolean isDelete(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& ((CreateDeleteOperation) operation).isDelete();
	}

	public static boolean isCreateDelete(AbstractOperation operation) {
		return operation instanceof CreateDeleteOperation;
	}
}
