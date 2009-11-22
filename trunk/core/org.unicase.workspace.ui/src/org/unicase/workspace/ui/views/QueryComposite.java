/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.Annotation;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.common.util.UiUtil;
import org.unicase.ui.unicasecommon.common.dialogs.METypeTreeSelectionDialog;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.views.Query.QueryRangeType;

/**
 * This is the contents of QueryTab in SCMViews (history and change browser
 * views). Using this tab properties of a Query class are set which later will
 * be used by view to update what they show.
 * 
 * @author Hodaie
 */
@Deprecated
public class QueryComposite extends Composite {

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

	// these lists are input to expand item lists (table viewers)
	// and keep track of what is currently shown in lists.
	// they are also used to set the right initial input to selection dialogs.
	private List<ModelElement> modelElementsList = new ArrayList<ModelElement>();
	private List<User> usersList = new ArrayList<User>();
	private List<EClass> modelElementTypesList = new ArrayList<EClass>();

	private Query query;
	private Project project;

	// QueryTab has three list. They have many things in common and are therefor
	// created using a generic method. This enumeration is input to that method.
	/**
	 * Enum for the type of list composite.
	 */
	private enum ListCompositeType {
		ELEMENTS_LIST, USERS_LIST, ELEMENTTYPES_LIST
	};

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public QueryComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createExpandItems();
	}

	// create ExpandItems using a help method.
	// Contents of Range expand item is set using createRangeComposite() method.
	// Contents of expand items containing lists are created using
	// a generic method createListComposite()
	private void createExpandItems() {
		ExpandBar expandBar = new ExpandBar(this, SWT.V_SCROLL);
		expandBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// range expand item
		createExpandItem(expandBar, "Range", createRangeComposite(expandBar));
		rbtnVer.setSelection(true);

		// list expand items
		createExpandItem(expandBar, "Elements", createListComposite(expandBar,
				"Elements", ListCompositeType.ELEMENTS_LIST));
		createExpandItem(expandBar, "Users", createListComposite(expandBar,
				"Users", ListCompositeType.USERS_LIST));
		createExpandItem(expandBar, "Element Types",
				createListComposite(expandBar, "Element Types",
						ListCompositeType.ELEMENTTYPES_LIST));
	}

	// create an expand with given contents composite
	private void createExpandItem(ExpandBar expandBar, String title,
			Composite composite) {

		ExpandItem expandItem = new ExpandItem(expandBar, SWT.NONE);
		expandItem.setText(title);
		expandItem.setExpanded(false);
		expandItem.setControl(composite);
		if (!title.equalsIgnoreCase("Range")) {
			expandItem.setText(expandItem.getText() + " - disabled");
			expandItem.setHeight(0);
		} else {
			expandItem.setHeight(composite
					.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
			expandItem.setExpanded(true);
		}
	}

	/**
	 * Generic method to create three list expand items (elements, users, and
	 * element types).
	 * 
	 * @param parent
	 *            the parent
	 * @param name
	 *            the name
	 * @param type
	 *            the type
	 * @return a composite
	 */
	private Composite createListComposite(Composite parent, String name,
			final ListCompositeType type) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(5, false));

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setText(name);

		// this button shows based on list type either
		// UnicaseUti.showMESelectionDialog()
		// (for elements and users list) or shows METypeSelectionDialog (for
		// element type list)
		Button btnAdd = new Button(composite, SWT.PUSH);
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.widthHint = 55;
		gridData.heightHint = SWT.DEFAULT;
		btnAdd.setLayoutData(gridData);
		btnAdd.setText("Add");

		Button btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");

		// if this the elements list show following two checkboxes
		if (type == ListCompositeType.ELEMENTS_LIST) {
			chkIncludeChildren = new Button(composite, SWT.CHECK);
			chkIncludeChildren.setText("Include Children");

			chkIncludeAnnotations = new Button(composite, SWT.CHECK);
			chkIncludeAnnotations.setText("Include Annotations");
		}

		// the list (a TableViewer)
		final TableViewer tableViewer = new TableViewer(composite, SWT.V_SCROLL
				| SWT.BORDER | SWT.MULTI);
		tableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));

		// org.unicase.ui.common.MEClassLabelProvider
		// This label provider shows appropriate label based on
		// if element is a ModelElement (for elements and users list)
		// or an EClass (for METype list)
		tableViewer.setLabelProvider(new MEClassLabelProvider());
		tableViewer.setContentProvider(new ArrayContentProvider());

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
		default:
			// do nothing
		}

		if (type == ListCompositeType.USERS_LIST) {
			handleUsersList(btnAdd, btnRemove, tableViewer, type);

		} else if (type == ListCompositeType.ELEMENTS_LIST) {
			btnAdd.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					Object[] result = showMESelectionDialog(type);
					ModelElement[] elements = new ModelElement[result.length];
					// cast
					for (int i = 0; i < elements.length; i++) {
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
					IStructuredSelection sel = (IStructuredSelection) tableViewer
							.getSelection();
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
					IStructuredSelection sel = (IStructuredSelection) tableViewer
							.getSelection();
					modelElementTypesList.removeAll(sel.toList());
					tableViewer.refresh(true, true);

				}

			});

		}

		return composite;
	}

	private void handleUsersList(Button btnAdd, Button btnRemove,
			final TableViewer tableViewer, final ListCompositeType type) {
		btnAdd.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {

				Object[] result = showMESelectionDialog(type);
				User[] users = new User[result.length];
				// cast
				for (int i = 0; i < users.length; i++) {
					users[i] = (User) result[i];
				}
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
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				usersList.removeAll(sel.toList());
				tableViewer.refresh(true, true);
			}

		});

	}

	/**
	 * Helper method to show METypeSelectionDialog.
	 * 
	 * @return a list of eclasses
	 */
	protected EClass[] showMETypeSelectionDialog() {
		EClass[] result = null;

		METypeTreeSelectionDialog dialog = new METypeTreeSelectionDialog(
				getShell(), true);
		dialog.open();
		result = dialog.getResult();

		return result;
	}

	// helper method to show MESelectionDialog.
	// the initial input of MESelectionDialog is set using current content
	// of corresponding list (TableViewer)
	private Object[] showMESelectionDialog(ListCompositeType type) {
		this.project = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace().getProject();
		Object[] result = new Object[0];
		if (type == ListCompositeType.USERS_LIST) {
			// 1. get all ACUsers
			// 2. remove those which are currently in usersList
			// 3. show user selection dialog
			// TODO: i need a session id to get all user from server.
			// or the users/groups must somehow be cached local.
			// currently is just a list of User instances shown, not ACUser!!
			// and accordingly the usersList is also of type User !!
			// and Query.users list is also of type User!!
			List<User> users = new ArrayList<User>();
			users.addAll(project.getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getUser(),
					new BasicEList<User>()));
			users.removeAll(usersList);

			result = UiUtil.showMESelectionDialog(getShell(), users,
					"select user", true);

		} else if (type == ListCompositeType.ELEMENTS_LIST) {

			List<ModelElement> modelElements = new ArrayList<ModelElement>();
			modelElements.addAll(project.getAllModelElements());
			modelElements.removeAll(modelElementsList);

			result = UiUtil.showMESelectionDialog(getShell(), modelElements,
					"select model element", true);
		}

		return result;
	}

	private Composite createRangeComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(6, false));

		// version
		rbtnVer = new Button(composite, SWT.RADIO);
		rbtnVer.setText("Versions");
		Label lblVerFrom = new Label(composite, SWT.NONE);
		lblVerFrom.setText("From:");
		txtVerFrom = new Text(composite, SWT.BORDER);
		Label lblVerTo = new Label(composite, SWT.NONE);
		lblVerTo.setText("To:");
		txtVerTo = new Text(composite, SWT.BORDER);
		Label lblVerTip = new Label(composite, SWT.NONE);
		// lblVerTip.setText(
		// "Enter a positive integer or any tag like BASE, CURRENT, HEAD, etc."
		// );
		lblVerTip.setText("");
		rbtnVer.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				txtVerFrom.setEnabled(rbtnVer.getSelection());
				txtVerTo.setEnabled(rbtnVer.getSelection());
			}

		});

		// number of days
		rbtnNumOfDays = new Button(composite, SWT.RADIO);
		rbtnNumOfDays.setEnabled(false);
		rbtnNumOfDays.setText("Number of days:");
		@SuppressWarnings("unused")
		Label filler = new Label(composite, SWT.NONE);
		txtNumOfDays = new Text(composite, SWT.BORDER);
		txtNumOfDays.setEnabled(false);
		GridData gridData1 = new GridData(SWT.LEFT, SWT.CENTER, true, true, 4,
				1);
		txtNumOfDays.setLayoutData(gridData1);
		rbtnNumOfDays.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				// txtNumOfDays.setEnabled(rbtnNumOfDays.getSelection());
			}

		});

		// date
		rbtnDate = new Button(composite, SWT.RADIO);
		rbtnDate.setEnabled(false);
		rbtnDate.setText("Date");
		Label lblDateFrom = new Label(composite, SWT.NONE);
		lblDateFrom.setText("From:");
		dtFrom = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN
				| CDT.COMPACT);
		dtFrom.setEnabled(false);
		Label lblDateTo = new Label(composite, SWT.NONE);
		lblDateTo.setText("To:");
		dtTo = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN
				| CDT.COMPACT);
		dtTo.setEnabled(false);
		rbtnDate.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				// dtFrom.setEnabled(rbtnDate.getSelection());
				// dtTo.setEnabled(rbtnDate.getSelection());
			}

		});

		return composite;

	}

	/**
	 * This will be called by SCMViews to invoke the Query from query tab the
	 * properties of Query are set using values of different controls on query
	 * tab. Currently there are no validations of values (for example for nulls
	 * or invalid numeric values)
	 * 
	 * @return the query
	 */
	public Query getQuery() {
		if (query == null) {
			query = new Query();
		}

		setQueryRange();

		setStartAndEndVersion();

		query.setNumOfDays((txtNumOfDays.getText().length() == 0) ? -1
				: Integer.parseInt(txtNumOfDays.getText()));
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

	private void setStartAndEndVersion() {
		try {
			query.setStartVersion((txtVerFrom.getText().length() == 0) ? -1
					: Integer.parseInt(txtVerFrom.getText()));
		} catch (NumberFormatException e) {
			query.setStartVersion(-1);
		}
		try {
			query.setEndVersion((txtVerTo.getText().length() == 0) ? -1
					: Integer.parseInt(txtVerTo.getText()));
		} catch (NumberFormatException e) {
			query.setEndVersion(-1);
		}
	}

	private void setQueryRange() {
		if (rbtnVer.getSelection()) {
			query.setQueryRangeType(QueryRangeType.VERSION);
		} else if (rbtnNumOfDays.getSelection()) {
			query.setQueryRangeType(QueryRangeType.NUMOFDAYS);
		} else if (rbtnDate.getSelection()) {
			query.setQueryRangeType(QueryRangeType.DATE);
		}
	}

	private Collection<? extends Annotation> getAnnotations(ModelElement me) {
		// TODO: final implementation
		List<Annotation> result = new ArrayList<Annotation>();
		return result;
	}

	private Collection<? extends ModelElement> getChildren(ModelElement me) {
		// TODO: final implementation
		List<ModelElement> result = new ArrayList<ModelElement>();
		return result;
	}

}
