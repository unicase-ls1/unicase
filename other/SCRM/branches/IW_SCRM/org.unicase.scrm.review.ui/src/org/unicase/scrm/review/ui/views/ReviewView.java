package org.unicase.scrm.review.ui.views;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.Configuration;

import review.Metrics;
import review.Review;
import review.ReviewFactory;
import review.ReviewPackage;
import scrm.SCRMModelElement;
import scrm.knowledge.KnowledgePackage;
import scrm.requirements.RequirementsPackage;
import au.com.bytecode.opencsv.CSVWriter;









/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class ReviewView extends ViewPart implements ISelectionListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.unicase.scrm.review.ui.views.ReviewView";

	private CheckboxTableViewer viewer;
	private ExportWizard wizard;
	private Action exportAction;
	private Action doubleClickAction;
	
    /**
     * the modelElement.
     */
    private SCRMModelElement modelElement;
    /**
     * the editingDomain.
     */
    private TransactionalEditingDomain editingDomain;

	private Review review;
    
    private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.scrm.review.EditingDomain";
    /**
     * default path for the configuration file.
     */
    public static final String DEFAULT_PATH = Configuration.getWorkspaceDirectory();

	private Metrics measurement;

	private TableColumn tableHeaderColumn;


    public void initReview(){
    	ResourceSet resourceSet = new ResourceSetImpl();

        // register an editing domain on the resource
    	editingDomain = TransactionalEditingDomain.Factory.INSTANCE
        .createEditingDomain(resourceSet);
    	TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, editingDomain);

    	URI fileURI = URI.createFileURI(DEFAULT_PATH + "review.xml");
    	File reviewFile = new File(DEFAULT_PATH + "review.xml");
    	if(!reviewFile.exists()){
	    	final Resource resource = editingDomain.getResourceSet().createResource(fileURI);
	    	resourceSet.getResources().add(resource);
	        editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				
				@Override
				protected void doExecute() {
					review = ReviewFactory.eINSTANCE.createReview();
					resource.getContents().add(review);
					try {
						review.eResource().save(null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
    	}else{
    		
    		review = (Review) editingDomain.getResourceSet().getResource(fileURI, true).getContents().get(0);
    	}

    }

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			
			List<String> content = new ArrayList<String>();

			
			AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
	                new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			
			List<IItemPropertyDescriptor> attributes = adapterFactoryItemDelegator
	        .getPropertyDescriptors(measurement);
			
			
			tableHeaderColumn.setText("You are reviewing: ' " + modelElement.getName() + " '. This requirement is:");			
					
			for (IItemPropertyDescriptor itemPropertyDescriptor : attributes) {
				final Object feature = itemPropertyDescriptor.getFeature(measurement);
                if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(boolean.class)) {

					content.add(((EAttribute) feature).getName());
					
                }
			}
			
			return content.toArray();
		}
	}
	
	

	
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public ReviewView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		
		initReview();
		//get the ME (requirement) of the active MEEditor
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addSelectionListener(this);
		MEEditorInput editorInput = (MEEditorInput) activeEditor.getEditorInput();
		modelElement = (SCRMModelElement) editorInput.getModelElement();
		
		//create measurement for the current requirement
		measurement = ReviewFactory.eINSTANCE.createMetrics();
		measurement.setMeasuredRequirement(modelElement);
		
//		viewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		viewer = CheckboxTableViewer.newCheckList(
		        parent, SWT.BORDER);
		viewer.getTable().setHeaderVisible(true);
		tableHeaderColumn = new TableColumn(viewer.getTable(), SWT.BOLD);
		tableHeaderColumn.setWidth(GridData.FILL_HORIZONTAL);
		
		viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.setContentProvider(new ViewContentProvider());
//		viewer.setLabelProvider(new ViewLabelProvider());
//		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
                new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> attributes = adapterFactoryItemDelegator
        .getPropertyDescriptors(measurement);
		for (IItemPropertyDescriptor itemPropertyDescriptor : attributes) {
			final Object feature = itemPropertyDescriptor.getFeature(measurement);
            if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(boolean.class)) {
				
				viewer.addCheckStateListener(new ICheckStateListener() {
					
					@Override
					public void checkStateChanged(final CheckStateChangedEvent event) {
						if(event.getElement().toString().contains(((EStructuralFeature)feature).getName())){
						editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
							
							@Override
							protected void doExecute() {
								measurement.eSet((EStructuralFeature) feature, event.getChecked());
								
								try {
									review.eResource().save(null);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}					
						});
						}
					}         
					});
	                }
				}
		

		
//		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
//                new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
//
//		List<IItemPropertyDescriptor> attributes = adapterFactoryItemDelegator
//        .getPropertyDescriptors(measurement);
//
//		for (IItemPropertyDescriptor itemPropertyDescriptor : attributes) {
//			Object feature = itemPropertyDescriptor.getFeature(measurement);
//            if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(boolean.class)) {
//				Button check = new Button(viewer.getTable(), SWT.CHECK);
//				check.setText(((EAttribute) feature).getName());
//		        IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), measurement, (EStructuralFeature) feature);
//		        EMFDataBindingContext dbc = new EMFDataBindingContext();
//		        dbc.bindValue(SWTObservables.observeSelection(check), model, null, null);
//		        viewer.add(check);
//			}
//		}

		// Create the help context id for the viewer's control
		
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ReviewView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(exportAction);
		manager.add(new Separator());
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(exportAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(exportAction);
	}

	private void makeActions() {
		exportAction = new Action() {
			

			public void run() {
				try {
					
					wizard = new ExportWizard();
					WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
					wizard.setWindowTitle("Export Review Result");
					dialog.create();
					dialog.open();
					exportResult();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		exportAction.setText("Export");
		exportAction.setToolTipText("Export Review Results");
		exportAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEALL_EDIT));
		

		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void exportResult() throws IOException {
		final CSVWriter writer = new CSVWriter(new FileWriter(wizard.getPath()), '\t');
	     // feed in your array (or convert your data to an array)
	     String[] header = "RequirementID#RequirementName#Correct#EasyToUnderstand#Unambiguous#Incomplete#TotalRequirements".split("#");
	     writer.writeNext(header);
	     editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
				Iterator<Metrics> it = review.getMeasurement().iterator();
				Project project = ModelUtil.getProject(modelElement);
//			    Project project = (Project) review.getMeasurement().get(0).getMeasuredRequirement().eContainer();
			    EList<SCRMModelElement> requirements = new BasicEList<SCRMModelElement>();

			    project.getAllModelElementsbyClass(KnowledgePackage.eINSTANCE.getScientificKnowledge(), requirements);
			    project.getAllModelElementsbyClass(RequirementsPackage.eINSTANCE.getIRequirement(), requirements);
				while(it.hasNext()){
					ArrayList<String> line = new ArrayList<String>();
					Metrics metrics = it.next();
					line.add(metrics.getMeasuredRequirement().toString());
					line.add(metrics.getMeasuredRequirement().getName());
					line.add(Boolean.toString(metrics.isCorrect()));
					line.add(Boolean.toString(metrics.isEasyToUnderstand()));
					line.add(Boolean.toString(metrics.isUnambiguous()));
					line.add(wizard.getIncompleteNumber());
					line.add(Integer.toString(requirements.size()));
					String[] nextLine = Arrays.copyOf(line.toArray(),line.size(),String[].class);
					writer.writeNext(nextLine);
				}
				
			}
		});
		 writer.close();

		
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Review View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * @return the modelElement
	 */
	public EObject getModelElement() {
		return modelElement;
	}

	/**
	 * @param modelElement the modelElement to set
	 */
	public void setModelElement(SCRMModelElement modelElement) {
		this.modelElement = modelElement;
	}

	/**
	 * @param editingDomain the editingDomain to set
	 */
	public void setEditingDomain(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * @return the editingDomain
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		viewer.setAllChecked(false);
//		IEditorPart activeEditor = (IEditorPart) part;
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		MEEditorInput editorInput = (MEEditorInput) activeEditor.getEditorInput();
		modelElement = (SCRMModelElement) editorInput.getModelElement();
		
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
				if(review.getMeasurement().size() > 0){
					int count = 0;
				for(Metrics metrics : review.getMeasurement()){
					count++;

					if(EcoreUtil.equals(metrics.getMeasuredRequirement(),modelElement)){
						measurement = metrics;
						viewer.setChecked("correct", measurement.isCorrect());
						viewer.setChecked("easyToUnderstand", measurement.isEasyToUnderstand());
						viewer.setChecked("unambiguous", measurement.isUnambiguous());
					}else{
						if(count == review.getMeasurement().size()){
							measurement = ReviewFactory.eINSTANCE.createMetrics();
							measurement.setMeasuredRequirement(modelElement);
							review.getMeasurement().add(measurement);
							break;
						}
	
						}
				}
				}else{
					
					measurement = ReviewFactory.eINSTANCE.createMetrics();
					measurement.setMeasuredRequirement(modelElement);
					review.getMeasurement().add(measurement);
					}
				viewer.refresh();
				measurement.eSet(ReviewPackage.eINSTANCE.getMetrics_Correct(), viewer.getChecked("correct"));
				measurement.eSet(ReviewPackage.eINSTANCE.getMetrics_EasyToUnderstand(), viewer.getChecked("easyToUnderstand"));
				measurement.eSet(ReviewPackage.eINSTANCE.getMetrics_Unambiguous(), viewer.getChecked("unambiguous"));
				try {
					review.eResource().save(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
	}
}