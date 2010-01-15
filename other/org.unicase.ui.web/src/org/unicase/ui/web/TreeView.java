package org.unicase.ui.web;

import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

public class TreeView extends ViewPart {

	public static final String ID = "org.unicase.ui.web.TreeView";
	
	private TreeViewer viewer;
	
	private Image projectImage;
	private Image itemImage;
	
	
	@Override
	public void createPartControl(Composite parent) {
		initImages();
		viewer = new TreeViewer(parent);
	
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		ProjectSpace projectSpace = workspace.getProjectSpaces().get(0); 
		Project project = projectSpace.getProject();
		
		List<? extends UnicaseModelElement> taskItems = project.getAllModelElementsbyClass(
				TaskPackage.eINSTANCE.getCheckable(), new BasicEList<UnicaseModelElement>());
		
		// The content provider is responsible to handle add and
		// remove notification for the Person#address EList
		ObservableListTreeContentProvider provider = new ObservableListTreeContentProvider(
				new TreeFactoryImpl(), new TreeStructureAdvisorImpl());
		viewer.setContentProvider(provider);

		// The label provider in turn handles the addresses
		// The EStructuralFeature[] defines which fields get shown
		// in the TableViewer columns
		IObservableSet knownElements = provider.getKnownElements();
		
		IObservableMap[] map = new IObservableMap[3];
		map[0] = EMFProperties.value(
				WorkspacePackage.Literals.PROJECT_SPACE__PROJECT_NAME)
				.observeDetail(knownElements);
		map[1] = EMFProperties.value(
				MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS)
				.observeDetail(knownElements);		
		map[2] = EMFProperties.value(
				FeaturePath.fromList(
						MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS,
						ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME))
				.observeDetail(knownElements);
		
		
		viewer.setLabelProvider(new TreeLabelProviderImpl(map));

		IEMFListProperty projects = EMFProperties
			.list(WorkspacePackage.Literals.PROJECT_SPACE__PROJECT);
		viewer.setInput(projects.observe(projectSpace));
		
	}
	
	private void initImages() {
		ImageDescriptor desc = Activator.imageDescriptorFromPlugin(
				"org.eclipse.ui", "icons/full/obj16/generic_elements.gif");
		if (desc != null) {
			projectImage = desc.createImage();
		} else {
			projectImage = null;
		}

		desc = Activator.imageDescriptorFromPlugin("org.eclipse.ui",
				"icons/full/obj16/signed_yes_tbl.gif");
		if (desc != null) {
			itemImage = desc.createImage();
		} else {
			itemImage = null;
		}		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	
	private static class TreeFactoryImpl implements IObservableFactory {
		
		private IEMFListProperty multi = EMFProperties.multiList(
				WorkspacePackage.Literals.PROJECT_SPACE__PROJECT,
				MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS);

		public IObservable createObservable(final Object target) {
			if (target instanceof IObservableList) {
				return (IObservable) target;
			} else if (target instanceof ProjectSpace) {
				return multi.observe(target);
			} else if (target instanceof Project) {
				return multi.observe(target);
			}

			return null;
		}
	}
	
	
	private static class TreeStructureAdvisorImpl extends TreeStructureAdvisor {
		
		@Override
		public Object getParent(Object element) {
			if (element instanceof ModelElement) {
				return ((ModelElement) element).getProject();
			} else if (element instanceof ProjectSpace) {
				return WorkspaceManager.getInstance().getCurrentWorkspace();
			} else if (element instanceof Project) {
				Project p = (Project) element;
				WorkspaceManager.getInstance();
				return WorkspaceManager.getProjectSpace(p);
			}
			
			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {
			if (element instanceof ProjectSpace 
					|| element instanceof Project
					|| element instanceof Workspace) {
				return true;
			}
			
			return false;
		}
	}
	
	/**
	 * Label provider for tree view.
	 * 
	 * @author fxulusoy
	 */
	private class TreeLabelProviderImpl extends CellLabelProvider {

		private IMapChangeListener mapChangeListener = new IMapChangeListener() {
			
			public void handleMapChange(MapChangeEvent event) {
				Set<?> affectedElements = event.diff.getChangedKeys();
				if (!affectedElements.isEmpty()) {
					LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
							TreeLabelProviderImpl.this, affectedElements.toArray());
					fireLabelProviderChanged(newEvent);
				}
			}
		};

		public TreeLabelProviderImpl(IObservableMap... attributeMaps) {
			for (int i = 0; i < attributeMaps.length; i++) {
				attributeMaps[i].addMapChangeListener(mapChangeListener);
			}
		}

		@Override
		public String getToolTipText(Object element) {
			return "#dummy#";
		}

		@SuppressWarnings("static-access")
		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof Project) {
				Project p = (Project) cell.getElement();
				
				String styledString = "P:"
						+ WorkspaceManager.getInstance().getProjectSpace(p)
								.getProjectName();
				
				cell.setText(styledString);
				cell.setImage(projectImage);
			} else if (cell.getElement() instanceof UnicaseModelElement) {
				String itemName = ((UnicaseModelElement) cell.getElement()).getName();
				 
				cell.setText(itemName);
				cell.setForeground(cell.getControl().getDisplay()
						.getSystemColor(SWT.COLOR_DARK_GRAY));
				cell.setImage(itemImage);
			}
		}
	}

}
