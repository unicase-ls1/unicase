package org.unicase.mergetest.merge.ui;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class DecisionUtil {

	public static Image getImage(String path) {
		final String key = path;
		ImageDescriptor regImage = JFaceResources.getImageRegistry()
				.getDescriptor(key);
		if (regImage == null) {
			regImage = ImageDescriptor.createFromImageData(new ImageData(
					DecisionUtil.class.getResourceAsStream("../../../../../icons/" + path)));
			JFaceResources.getImageRegistry().put(key, regImage);
		}
		return regImage.createImage();
	}
	
	public static String cutString(String result, int length, boolean addPoints) {
		if(result.length() > length) {
			result = result.substring(0, length);
			if(addPoints) {
				result += "...";
			}
			return result;
		} else {
			return result;
		}
	}
	
	public static AdapterFactoryLabelProvider getLabelProvider() {
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return provider;
	}
}
