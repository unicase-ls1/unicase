package org.unicase.changetracking.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.unicase.changetracking.release.BranchState;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.model.changetracking.ChangePackage;

public class ChangePackageStateLabelProvider implements ILabelProvider{
	
	private static final ImageData ERROR_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/error.gif").getImageData();
	private static final ImageData MERGED_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/merged.gif").getImageData();
	private static final ImageData UNMERGED_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/unmerged.gif").getImageData();
	private static final ImageData UNCONNECTED_DECORATION_IMAGE = Activator.getImageDescriptor("icons/decorators/error.gif").getImageData();
	private static final Image CHANGE_PACKAGE_IMAGE = Activator.getImageDescriptor("icons/ChangePackage.gif").createImage();
	
	
	private static final Map<BranchState, ImageData> decorationMapping = new HashMap<BranchState, ImageData>();
	static{
		decorationMapping.put(BranchState.ERROR, ERROR_DECORATION_IMAGE);
		decorationMapping.put(BranchState.MERGED, MERGED_DECORATION_IMAGE);
		decorationMapping.put(BranchState.UNMERGED, UNMERGED_DECORATION_IMAGE);
		decorationMapping.put(BranchState.UNCONNECTED, UNCONNECTED_DECORATION_IMAGE);
	}
	
	public Image generateImage(BranchState state){
		return new Image(CHANGE_PACKAGE_IMAGE.getDevice(),new DecorationImageDescriptor(CHANGE_PACKAGE_IMAGE,state).getImageData());
	}
	
	private AdapterFactoryLabelProvider wrappedProvider;
	private ReleaseCheckReport report;

	public ChangePackageStateLabelProvider(ReleaseCheckReport report){
		wrappedProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.report = report;
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof ChangePackage){
			Image img = wrappedProvider.getImage(element);
			BranchState state = report.getChangePackageStates().get(element);
			if(state == null){
				state = BranchState.ERROR;
			}
			img = new Image(img.getDevice(), new DecorationImageDescriptor(img,state).getImageData());
			return img;
		} else {
			return wrappedProvider.getImage(element);
		}
	}

	@Override
	public String getText(Object element) {
		return wrappedProvider.getText(element);
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		wrappedProvider.addListener(listener);
	}

	@Override
	public void dispose() {
		wrappedProvider.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return wrappedProvider.isLabelProperty(element, property);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		wrappedProvider.removeListener(listener);
	}
	
	/**
	 * 
	 * Decorator that adds the decorating image to an image.
	 * @author jfinis
	 *
	 */
	private final class DecorationImageDescriptor extends CompositeImageDescriptor{
		
		private ImageData imageData;
		private BranchState state;

		private DecorationImageDescriptor(Image image, BranchState state){
			this.imageData = image.getImageData();
			this.state = state;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void drawCompositeImage(int width, int height) {
			
			//Draw base image.
			drawImage(imageData, 0, 0);
			
			//Add decoration
			drawImage(decorationMapping.get(state),6,0);
		}
		

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Point getSize() {
			return new Point(imageData.width,imageData.height);
		}
		
	}

}
