package org.unicase.ui.diagram.urml.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.emfstore.esmodel.accesscontrol.provider.AccesscontrolItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.accesscontrol.roles.provider.RolesItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.notification.provider.NotificationItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.provider.EsmodelItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.url.provider.UrlItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.versioning.events.provider.EventsItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.versioning.events.server.provider.ServerItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.versioning.operations.provider.OperationsItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.provider.SemanticItemProviderAdapterFactory;
import org.unicase.emfstore.esmodel.versioning.provider.VersioningItemProviderAdapterFactory;
import org.unicase.metamodel.provider.MetamodelItemProviderAdapterFactory;
import org.unicase.model.activity.provider.ActivityItemProviderAdapterFactory;
import org.unicase.model.attachment.provider.AttachmentItemProviderAdapterFactory;
import org.unicase.model.bug.provider.BugItemProviderAdapterFactory;
import org.unicase.model.change.provider.ChangeItemProviderAdapterFactory;
import org.unicase.model.classes.provider.ClassesItemProviderAdapterFactory;
import org.unicase.model.component.provider.ComponentItemProviderAdapterFactory;
import org.unicase.model.diagram.provider.DiagramItemProviderAdapterFactory;
import org.unicase.model.document.provider.DocumentItemProviderAdapterFactory;
import org.unicase.model.meeting.provider.MeetingItemProviderAdapterFactory;
import org.unicase.model.organization.provider.OrganizationItemProviderAdapterFactory;
import org.unicase.model.profile.provider.ProfileItemProviderAdapterFactory;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.model.rationale.provider.RationaleItemProviderAdapterFactory;
import org.unicase.model.release.provider.ReleaseItemProviderAdapterFactory;
import org.unicase.model.state.provider.StateItemProviderAdapterFactory;
import org.unicase.model.task.provider.TaskItemProviderAdapterFactory;
import org.unicase.model.urml.danger.provider.DangerItemProviderAdapterFactory;
import org.unicase.model.urml.feature.provider.FeatureItemProviderAdapterFactory;
import org.unicase.model.urml.goal.provider.GoalItemProviderAdapterFactory;
import org.unicase.model.urml.provider.UrmlItemProviderAdapterFactory;
import org.unicase.model.urml.requirement.provider.RequirementItemProviderAdapterFactory;
import org.unicase.model.urml.service.provider.ServiceItemProviderAdapterFactory;
import org.unicase.model.urml.usecase.provider.UsecaseItemProviderAdapterFactory;
import org.unicase.model.util.provider.UtilItemProviderAdapterFactory;

/**
 * @generated
 */
public class UrmlDiagramEditorPlugin extends AbstractUIPlugin {

	/**
	 * @generated
	 */
	public static final String ID = "org.unicase.ui.diagram.urmlDiagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(ID);

	/**
	 * @generated
	 */
	private static UrmlDiagramEditorPlugin instance;

	/**
	 * @generated
	 */
	private ComposedAdapterFactory adapterFactory;

	/**
	 * @generated
	 */
	private UrmlDocumentProvider documentProvider;

	/**
	 * @generated
	 */
	public UrmlDiagramEditorPlugin() {
	}

	/**
	 * @generated
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());
		adapterFactory = createAdapterFactory();
	}

	/**
	 * @generated
	 */
	public void stop(BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		instance = null;
		super.stop(context);
	}

	/**
	 * @generated
	 */
	public static UrmlDiagramEditorPlugin getInstance() {
		return instance;
	}

	/**
	 * @generated
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		List factories = new ArrayList();
		fillItemProviderFactories(factories);
		return new ComposedAdapterFactory(factories);
	}

	/**
	 * @generated
	 */
	protected void fillItemProviderFactories(List factories) {
		factories.add(new UrmlItemProviderAdapterFactory());
		factories.add(new GoalItemProviderAdapterFactory());
		factories.add(new RequirementItemProviderAdapterFactory());
		factories.add(new UsecaseItemProviderAdapterFactory());
		factories.add(new ServiceItemProviderAdapterFactory());
		factories.add(new DangerItemProviderAdapterFactory());
		factories.add(new FeatureItemProviderAdapterFactory());
		factories.add(new DiagramItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new EsmodelItemProviderAdapterFactory());
		factories.add(new VersioningItemProviderAdapterFactory());
		factories.add(new OperationsItemProviderAdapterFactory());
		factories.add(new SemanticItemProviderAdapterFactory());
		factories.add(new EventsItemProviderAdapterFactory());
		factories.add(new ServerItemProviderAdapterFactory());
		factories.add(new AccesscontrolItemProviderAdapterFactory());
		factories.add(new RolesItemProviderAdapterFactory());
		factories.add(new NotificationItemProviderAdapterFactory());
		factories.add(new UrlItemProviderAdapterFactory());
		factories.add(new MetamodelItemProviderAdapterFactory());
		factories.add(new ModelItemProviderAdapterFactory());
		factories.add(new OrganizationItemProviderAdapterFactory());
		factories.add(new TaskItemProviderAdapterFactory());
		factories.add(new ClassesItemProviderAdapterFactory());
		factories.add(new DocumentItemProviderAdapterFactory());
		factories.add(new org.unicase.model.requirement.provider.RequirementItemProviderAdapterFactory());
		factories.add(new RationaleItemProviderAdapterFactory());
		factories.add(new ChangeItemProviderAdapterFactory());
		factories.add(new BugItemProviderAdapterFactory());
		factories.add(new ComponentItemProviderAdapterFactory());
		factories.add(new MeetingItemProviderAdapterFactory());
		factories.add(new StateItemProviderAdapterFactory());
		factories.add(new AttachmentItemProviderAdapterFactory());
		factories.add(new ProfileItemProviderAdapterFactory());
		factories.add(new UtilItemProviderAdapterFactory());
		factories.add(new ActivityItemProviderAdapterFactory());
		factories.add(new ReleaseItemProviderAdapterFactory());
		factories.add(new NotationItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	 * @generated
	 */
	public AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @generated
	 */
	public ImageDescriptor getItemImageDescriptor(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item, IItemLabelProvider.class);
		if (labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(item));
		}
		return null;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @generated
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

	/**
	 * Respects images residing in any plug-in. If path is relative, then this bundle is looked up for the image,
	 * otherwise, for absolute path, first segment is taken as id of plug-in with image
	 * 
	 * @generated
	 * @param path the path to image, either absolute (with plug-in id as first segment), or relative for bundled images
	 * @return the image descriptor
	 */
	public static ImageDescriptor findImageDescriptor(String path) {
		final IPath p = new Path(path);
		if (p.isAbsolute() && p.segmentCount() > 1) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(p.segment(0), p.removeFirstSegments(1).makeAbsolute()
				.toString());
		} else {
			return getBundledImageDescriptor(p.makeAbsolute().toString());
		}
	}

	/**
	 * Returns an image for the image file at the given plug-in relative path. Client do not need to dispose this image.
	 * Images will be disposed automatically.
	 * 
	 * @generated
	 * @param path the path
	 * @return image instance
	 */
	public Image getBundledImage(String path) {
		Image image = getImageRegistry().get(path);
		if (image == null) {
			getImageRegistry().put(path, getBundledImageDescriptor(path));
			image = getImageRegistry().get(path);
		}
		return image;
	}

	/**
	 * Returns string from plug-in's resource bundle
	 * 
	 * @generated
	 */
	public static String getString(String key) {
		return Platform.getResourceString(getInstance().getBundle(), "%" + key); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public UrmlDocumentProvider getDocumentProvider() {
		if (documentProvider == null) {
			documentProvider = new UrmlDocumentProvider();
		}
		return documentProvider;
	}

	/**
	 * @generated
	 */
	public void logError(String error) {
		logError(error, null);
	}

	/**
	 * @generated
	 */
	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(new Status(IStatus.ERROR, UrmlDiagramEditorPlugin.ID, IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	/**
	 * @generated
	 */
	public void logInfo(String message) {
		logInfo(message, null);
	}

	/**
	 * @generated
	 */
	public void logInfo(String message, Throwable throwable) {
		if (message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getLog().log(new Status(IStatus.INFO, UrmlDiagramEditorPlugin.ID, IStatus.OK, message, throwable));
		debug(message, throwable);
	}

	/**
	 * @generated
	 */
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
}
