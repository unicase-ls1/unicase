package org.unicase.ui.tom.classDiagram.part;

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
import org.unicase.model.attachment.provider.AttachmentItemProviderAdapterFactory;
import org.unicase.model.bug.provider.BugItemProviderAdapterFactory;
import org.unicase.model.change.provider.ChangeItemProviderAdapterFactory;
import org.unicase.model.classes.provider.ClassesItemProviderAdapterFactory;
import org.unicase.model.component.provider.ComponentItemProviderAdapterFactory;
import org.unicase.model.diagram.provider.DiagramItemProviderAdapterFactory;
import org.unicase.model.document.provider.DocumentItemProviderAdapterFactory;
import org.unicase.model.meeting.provider.MeetingItemProviderAdapterFactory;
import org.unicase.model.organization.provider.OrganizationItemProviderAdapterFactory;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.model.rationale.provider.RationaleItemProviderAdapterFactory;
import org.unicase.model.requirement.provider.RequirementItemProviderAdapterFactory;
import org.unicase.model.state.provider.StateItemProviderAdapterFactory;
import org.unicase.model.task.provider.TaskItemProviderAdapterFactory;

/**
 * @generated
 */
public class ModelDiagramEditorPlugin extends org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin {

}
