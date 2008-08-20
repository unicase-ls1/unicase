package org.unicase.ui.stem.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.common.dialogs.METypeSelectionDialog;
import org.unicase.ui.common.util.UnicaseUtil;
import org.unicase.ui.stem.views.Query.QueryRangeType;
import org.unicase.workspace.WorkspaceManager;

public class QueryComosite extends Composite {

	private Button rbtnVer;
	private Button rbtnNumOfDays;
	private Button rbtnDate;

	private Text txtVerFrom;
	private Text txtVerTo;
	private Text txtNumOfDays;

	private CDateTime dtFrom;
	private CDateTime dtTo;

	private Button chkIncludeChildren;
	private Button chkIncludeAnnotations;

	private List<ModelElement> modelElementsList = new ArrayList<ModelElement>();
	private List<ACUser> usersList = new ArrayList<ACUser>();
	private List<EClass> modelElementTypesList = new ArrayList<EClass>();

	private Query query;
	private Project project;

	private enum ListCompositeType {
		ELEMENTS_LIST, USERS_LIST, ELEMENTTYPES_LIST
	};

	public QueryComosite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		// this.project = WorkspaceManager.getInstance().getCurrentWorkspace()
		// .getActiveProjectSpace().getProject();
		createExpandItems();
	}

	private void createExpandItems() {
		ExpandBar expandBar = new ExpandBar(this, SWT.V_SCROLL);
		expandBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createExpandItem(expandBar, "Range", createRangeComposite(expandBar));
		rbtnVer.setSelection(true);
		createExpandItem(expandBar, "Elements", createListComposite(expandBar,
				"Elements", ListCompositeType.ELEMENTS_LIST));
		createExpandItem(expandBar, "Users", createListComposite(expandBar,
				"Users", ListCompositeType.USERS_LIST));
		createExpandItem(expandBar, "Element Types",
				createListComposite(expandBar, "Element Types",
						ListCompositeType.ELEMENTTYPES_LIST));
	}

	private void createExpandItem(ExpandBar expandBar, String title,
			Composite composite) {

		ExpandItem eitemRange = new ExpandItem(expandBar, SWT.NONE);
		eitemRange.setText(title);
		eitemRange.setExpanded(false);
		eitemRange.setControl(composite);
		eitemRange.setHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);

	}

	private Composite createListComposite(Composite parent, String name,
			final ListCompositeType type) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(5, false));

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setText(name);

		Button btnAdd = new Button(composite, SWT.PUSH);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.widthHint = 55;
		gridData.heightHint = SWT.DEFAULT;
		btnAdd.setLayoutData(gridData);
		btnAdd.setText("Add");

		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");
		
		if (type == ListCompositeType.ELEMENTS_LIST) {

			chkIncludeChildren = new Button(composite, SWT.CHECK);
			chkIncludeChildren.setText("Include Children");

			chkIncludeAnnotations = new Button(composite, SWT.CHECK);
			chkIncludeAnnotations.setText("Include Annotations");
		}

		final TableViewer tableViewer = new TableViewer(composite, SWT.V_SCROLL
				| SWT.BORDER  | SWT.MULTI);
		tableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));

		if(type == ListCompositeType.ELEMENTTYPES_LIST){
			MyLabelProvider lp = new MyLabelProvider();
			tableViewer.setLabelProvider(lp);
		}else{
			tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		}
		
//		listViewer.setContentProvider(new AdapterFactoryContentProvider(
//				new ComposedAdapterFactory(
//						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		
		tableViewer.setContentProvider(new MyContentProvider());


		switch (type) {
		case ELEMENTS_LIST:
			tableViewer.setInput(modelElementsList);
			break;
		case USERS_LIST:
			tableViewer.setInput(usersList);
			break;
		case ELEMENTTYPES_LIST:
			tableViewer.setInput(modelElementTypesList);
			break;
		}

		if (type == ListCompositeType.USERS_LIST) {
			btnAdd.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					ACUser[] users = (ACUser[]) showMESelectionDialog(type);
					if (users.length != 0) {
						usersList.addAll(Arrays.asList(users));
						tableViewer.refresh(true, true);
					}
				}
			});

			btnRemove.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer.getSelection();
					usersList.removeAll(sel.toList());
					tableViewer.refresh(true, true);
				}

			});
		} else if (type == ListCompositeType.ELEMENTS_LIST) {
			btnAdd.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					Object[] result =  showMESelectionDialog(type);
					ModelElement[] elements = new ModelElement[result.length];
					for(int i = 0; i < elements.length; i++ ){
						elements[i] = (ModelElement) result[i];
					}
					
					if (elements.length != 0) {
						modelElementsList.addAll(Arrays.asList(elements));
						tableViewer.refresh(true, true);
					}
				}
			});

			btnRemove.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer.getSelection();
					modelElementsList.removeAll(sel.toList());
					tableViewer.refresh(true, true);
				}

			});
		} else if (type == ListCompositeType.ELEMENTTYPES_LIST) {
			btnAdd.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {

				}

				public void widgetSelected(SelectionEvent e) {
					EClass[] types = showMETypeSelectionDialog();
					if (types != null) {
						modelElementTypesList.addAll(Arrays.asList(types));
						
						tableViewer.refresh(true, true);
						
					}

				}
			});

			btnRemove.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					IStructuredSelection sel = (IStructuredSelection) tableViewer.getSelection();
					modelElementTypesList.removeAll(sel.toList());
					tableViewer.refresh(true, true);
					
				}

			});

		}

		return composite;
	}

	protected EClass[] showMETypeSelectionDialog() {
		EClass[] result = null;

		METypeSelectionDialog dialog = new METypeSelectionDialog(getShell(),
				true);
		if (dialog.open() == Window.OK) {
			result = dialog.getResult();
		}
		return result;
	}

	private Object[] showMESelectionDialog(ListCompositeType type) {
		Object[] result = new Object[0];
		if (type == ListCompositeType.USERS_LIST) {
			// 1. get all users
			// 2. remove those which are currently in usersList
			// 3. show user selection dialog
			// i need a session id to get all user from server.
			// or the users/groups must somehow be cached local.

		} else if (type == ListCompositeType.ELEMENTS_LIST) {

			List<ModelElement> modelElements = new ArrayList<ModelElement>();
			project = WorkspaceManager.getInstance().getCurrentWorkspace()
			 	.getActiveProjectSpace().getProject();
			modelElements.addAll(project.getAllModelElements());
			modelElements.removeAll(modelElementsList);

			result = UnicaseUtil.showMESelectionDialog(getShell(),
					modelElements, "select model element", true);
		}

		return result;
	}

	private Composite createRangeComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(6, false));

		rbtnVer = new Button(composite, SWT.RADIO);
		rbtnVer.setText("Versions");
		Label lblVerFrom = new Label(composite, SWT.NONE);
		lblVerFrom.setText("From:");
		txtVerFrom = new Text(composite, SWT.BORDER);
		Label lblVerTo = new Label(composite, SWT.NONE);
		lblVerTo.setText("To:");
		txtVerTo = new Text(composite, SWT.BORDER);
		Label lblVerTip = new Label(composite, SWT.NONE);
		lblVerTip
				.setText("Enter a positive integer or any tag like BASE, CURRENT, HEAD, etc.");
		rbtnVer.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				txtVerFrom.setEnabled(rbtnVer.getSelection());
				txtVerTo.setEnabled(rbtnVer.getSelection());
			}

		});

		rbtnNumOfDays = new Button(composite, SWT.RADIO);
		rbtnNumOfDays.setText("Number of days:");
		Label filler = new Label(composite, SWT.NONE);
		txtNumOfDays = new Text(composite, SWT.BORDER);
		GridData gridData1 = new GridData(SWT.LEFT, SWT.CENTER, true, true, 4,
				1);
		txtNumOfDays.setLayoutData(gridData1);
		rbtnNumOfDays.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				txtNumOfDays.setEnabled(rbtnNumOfDays.getSelection());
			}

		});

		rbtnDate = new Button(composite, SWT.RADIO);
		rbtnDate.setText("Date");
		Label lblDateFrom = new Label(composite, SWT.NONE);
		lblDateFrom.setText("From:");
		dtFrom = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN
				| CDT.COMPACT);
		Label lblDateTo = new Label(composite, SWT.NONE);
		lblDateTo.setText("To:");
		dtTo = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN
				| CDT.COMPACT);
		rbtnDate.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				dtFrom.setEnabled(rbtnDate.getSelection());
				dtTo.setEnabled(rbtnDate.getSelection());
			}

		});

		return composite;

	}

	public Query getQuery() {
		if (query == null) {
			query = new Query();
		}

		if (rbtnVer.getSelection()) {
			query.setQueryRangeType(QueryRangeType.VERSION);
		} else if (rbtnNumOfDays.getSelection()) {
			query.setQueryRangeType(QueryRangeType.NUMOFDAYS);
		} else if (rbtnDate.getSelection()) {
			query.setQueryRangeType(QueryRangeType.DATE);
		}

		query.setStartVersion(Integer.parseInt(txtVerFrom.getText()));
		query.setEndVersion(Integer.parseInt(txtVerTo.getText()));
		query.setNumOfDays(Integer.parseInt(txtNumOfDays.getText()));
		query.setStartDate(dtFrom.getSelection());
		query.setEndDate(dtTo.getSelection());
		List<ModelElement> modelElements = new ArrayList<ModelElement>();
		modelElements.addAll(modelElementsList);
		if (chkIncludeChildren.getSelection()) {
			List<ModelElement> children = new ArrayList<ModelElement>();
			for (ModelElement me : modelElements) {
				children.addAll(getChildren(me));
			}
			modelElements.addAll(children);
		}
		if (chkIncludeAnnotations.getSelection()) {
			List<Annotation> annotations = new ArrayList<Annotation>();
			for (ModelElement me : modelElements) {
				annotations.addAll(getAnnotations(me));
			}
			modelElements.addAll(annotations);
		}
		query.setModelElements(modelElements);

		query.setUsers(usersList);
		query.setModelElementTypes(modelElementTypesList);

		return query;

	}

	private Collection<? extends Annotation> getAnnotations(ModelElement me) {
		List<Annotation> result = new ArrayList<Annotation>();
		return result;
	}

	private Collection<? extends ModelElement> getChildren(ModelElement me) {
		List<ModelElement> result = new ArrayList<ModelElement>();
		return result;
	}

	
	private class MyContentProvider implements IStructuredContentProvider {
		
		 public Object[] getElements(Object inputElement) {
			 List list = (List) inputElement;
			 return list.toArray(new Object[list.size()]);
			 
		}

		public void dispose() {
			// TODO Auto-generated method stub

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}
	
	private class MyLabelProvider extends AdapterFactoryLabelProvider {
		public MyLabelProvider() {
			super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		}

		@Override
		public Image getColumnImage(Object object, int columnIndex) {
			if (object instanceof EClass) {
				EClass eClass = (EClass) object;
				EPackage ePackage = eClass.getEPackage();
				ModelElement newMEInstance = (ModelElement) ePackage.getEFactoryInstance().create(eClass);
				return super.getImage(newMEInstance);
			}
			return super.getImage(object);
		}

		@Override
		public String getColumnText(Object object, int columnIndex) {
			String text = "";
			// if argument is instance of EClass and
			// it inherits ModelElement then return its name.
			if (object instanceof EClass) {
				EClass eclass = (EClass) object;
				if (eclass.getEAllSuperTypes().contains(ModelPackage.eINSTANCE.getModelElement())) {
					// TODO: show getDisplayName()
					text = eclass.getName();
				}

			} else {
				// argument is an EPackage
				text = super.getText(object);
			}

			return text;
		}
	}
	
}

// private class MyContentProvider implements IStructuredContentProvider {
//
// public Object[] getElements(Object inputElement) {
//
// }
//
// public void dispose() {
// // TODO Auto-generated method stub
//		
// }
//
// public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
//	
//		
// }
//	
// }

