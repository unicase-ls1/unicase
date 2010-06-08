package org.unicase.emailnotifierpreferences.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.internal.RadioMenu;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.Project;
import org.unicase.model.emailbundle.Bundle;
import org.unicase.model.emailbundle.EmailbundleFactory;
import org.unicase.model.emailbundle.EmailbundlePackage;
import org.unicase.model.emailbundle.impl.EmailbundleFactoryImpl;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.preferences.PropertyKey;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * A property page for the E-Mail Notifier Service.
 * 
 * @author fuesescc
 */
public class EMailNotifierPage extends PropertyPage {

	private Project project;
	private ProjectSpace projectSpace;

	private List<Bundle> tempBundles;

	private ListViewer bundleList;
	private Button btnAdd;
	private Button btnRemove;
	private Button btnEdit;
	
	private Composite compositeBundletwo;

	private Composite secondColumn;
	private Label selectNotifier;
	private CheckboxTableViewer notifierTypesList;
	private HashMap<PropertyKey, String[]> providerHints;

	private Composite thirdColumn;
	private Label configLabel;
	private Combo sendOption;
	private Composite aggregated;
	private Combo aggregatedOption;
	private Composite weekdayOptionComp;
	private Combo weekdayOption;
	private Composite daysSpinnerComp;
	private Spinner daysSpinner;

	private Button notificationServiceCheck;

	private Control createMainTab(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);
		GridLayout thisLayout = new GridLayout();
		root.setLayout(thisLayout);

		GridData layoutBeginning = new GridData();
		layoutBeginning.verticalAlignment = SWT.BEGINNING;

		GridData layoutTop = new GridData();
		layoutTop.verticalAlignment = SWT.TOP;

		// Composite TOP
		{
			final Composite compositeTop = new Composite(root, SWT.NONE);
			GridLayout topgrid = new GridLayout(2, false);
			compositeTop.setLayout(topgrid);
			compositeTop.setLayoutData(layoutBeginning);

			// first grid
			{
				Composite compositeBundle = new Composite(compositeTop, SWT.NONE);
				GridLayout compositeBundleLayout = new GridLayout(1, false);
				compositeBundle.setLayout(compositeBundleLayout);

				Label bundleListLabel = new Label(compositeBundle, SWT.PUSH | SWT.TOP);
				bundleListLabel.setText("E-Mail bundles");
				bundleList = new ListViewer(compositeBundle, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
				GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(bundleList.getControl());
				addButtons(compositeBundle);

				bundleList.setContentProvider(new IStructuredContentProvider() {
					public Object[] getElements(Object inputElement) {
						List<Bundle> l = (List<Bundle>) inputElement;
						return l.toArray();
					}
					public void dispose() {
					}
					public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
						System.out.println("Input changed: old=" + oldInput + ", new=" + newInput);
						bundleList.refresh();
					}
				});
				bundleList.setInput(tempBundles);
				bundleList.setLabelProvider(new LabelProvider() {
					public Image getImage(Object element) {
						return null;
					}

					public String getText(Object element) {
						return ((Bundle) element).getBundleName();
					}
				});
				bundleList.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event.getSelection();
						Bundle bndl = (Bundle) selection.getFirstElement();
						String bndlname = bndl.getBundleName();
						disposeProperties();
						createSecondColumn(compositeBundletwo, bndlname);
						createThirdColumn(compositeBundletwo, bndlname);
						loadProviderProperties(tempBundles, tempBundles.indexOf(selection.getFirstElement()));
						loadSendProperties(tempBundles, tempBundles.indexOf(selection.getFirstElement()));
						// bindValues(tempBundles, tempBundles.indexOf(selection.getFirstElement()));
						// if(!tempBundles.get(tempBundles.indexOf(selection.getFirstElement())).isAggregated()){
						// aggregated.setVisible(false);
						// }
						compositeBundletwo.layout();
					}
				});
				bundleList.addFilter(new ViewerFilter() {
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return true;
					}
				});
				bundleList.setSorter(new ViewerSorter() {
					// public int compare(Viewer viewer, Object e1, Object e2) {
					// return ((Bundle) e1).getBundleName().compareTo(((Bundle) e2).getBundleName());
					// }
				});
			}

//			 second grid
			 {
					compositeBundletwo = new Composite(compositeTop, SWT.NONE);
					GridLayout compositeBundleLayout = new GridLayout(2, false);
					compositeBundletwo.setLayout(compositeBundleLayout);
			 }

			// third grid
			// {
			//				
			// }
		}

		// Composite Bottom
		{
			Composite compositeBottom = new Composite(root, SWT.NONE);
			GridLayout bottomgrid = new GridLayout();
			bottomgrid.makeColumnsEqualWidth = true;
			compositeBottom.setLayout(bottomgrid);
			compositeBottom.setLayoutData(layoutBeginning);
			{
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 3;
				GridData layout = new GridData();
				compositeBottom.setLayoutData(layout);
				compositeBottom.setLayout(gridLayout);
			}
			// first grid
			{
				Composite compositeBundle = new Composite(compositeBottom, SWT.NONE);
				GridLayout gridLayout = new GridLayout(3, false);
				compositeBundle.setLayout(gridLayout);
				Label notiService = new Label(compositeBundle, SWT.PUSH);
				notiService.setText("Notification Service: ");
				notificationServiceCheck = new Button(compositeBundle, SWT.CHECK | SWT.LEFT);
			}
		}
		return root;
	}

	private Control createDaysSpinnerComp() {
		if (weekdayOptionComp != null) {
			weekdayOptionComp.dispose();
		}
		daysSpinnerComp = new Composite(aggregated, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).margins(10, 0).applyTo(daysSpinnerComp);
		daysSpinner = new Spinner(daysSpinnerComp, SWT.WRAP | SWT.BORDER);
		daysSpinner.setMinimum(1);
		daysSpinner.setMaximum(30);
		Label days = new Label(daysSpinnerComp, SWT.LEFT | SWT.BORDER);
		days.setText("days");
		return daysSpinnerComp;
	}

	private Control createWeekdayOptionComp() {
		if (daysSpinnerComp != null) {
			daysSpinnerComp.dispose();
		}
		weekdayOptionComp = new Composite(aggregated, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).margins(10, 0).applyTo(weekdayOptionComp);
		weekdayOption = new Combo(weekdayOptionComp, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> weekdaylist = ((EEnum) EmailbundlePackage.Literals.WEEKDAYS).getELiterals();
		for (EEnumLiteral literal : weekdaylist) {
			weekdayOption.add(literal.getLiteral());
		}
		return weekdayOptionComp;
	}

	private Control createSecondColumn(Composite compositeTop, String bndlname) {
		secondColumn = new Composite(compositeTop, SWT.NONE);
		secondColumn.setVisible(false);
		GridLayout compositeBundleLayout = new GridLayout(1, false);
		// compositeBundle.setLayoutData(layoutTop);
		secondColumn.setLayout(compositeBundleLayout);

		selectNotifier = new Label(secondColumn, SWT.PUSH | SWT.TOP | SWT.WRAP);
		selectNotifier.setText("Select notification types for group " + bndlname);
		notifierTypesList = CheckboxTableViewer.newCheckList(secondColumn, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.BORDER);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(notifierTypesList.getControl());
		notifierTypesList.setContentProvider(new ArrayContentProvider());
		ArrayList<PropertyKey> providers = new ArrayList<PropertyKey>();
		providers.addAll(providerHints.keySet());
		Collections.sort(providers, new Comparator<PropertyKey>() {
			public int compare(PropertyKey o1, PropertyKey o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		notifierTypesList.setInput(providers);

		final Label hint = new Label(secondColumn, SWT.WRAP);
		// GridDataFactory.fillDefaults().grab(true, false).applyTo(hint);
		GridData labelData = new GridData();
		// labelData.horizontalSpan = 2;
		labelData.horizontalAlignment = SWT.FILL;
		Rectangle rect = secondColumn.getMonitor().getClientArea();
		labelData.widthHint = rect.width / 4;
		hint.setLayoutData(labelData);
		hint.setText("Hint: Select an item to view its description");
		notifierTypesList.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (object instanceof EMailNotifierKey) {
					hint.setText(providerHints.get(object)[1] + "");
					// compositeBundle.getLayout();
				}
			}
		});

		notifierTypesList.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof EMailNotifierKey) {
					return providerHints.get(element)[0];
				}
				return super.getText(element);
			}
		});

		notifierTypesList.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) bundleList.getSelection();
				Bundle bndl = (Bundle) selection.getFirstElement();
				if (event.getChecked()) {
					tempBundles.get(tempBundles.indexOf(bndl)).getProviders().add(event.getElement());
				} else {
					tempBundles.get(tempBundles.indexOf(bndl)).getProviders().remove(event.getElement());
				}
			}
		});
		return secondColumn;
	}

	private Control createThirdColumn(Composite compositeTop, String bndlname) {
		thirdColumn = new Composite(compositeTop, SWT.NONE);
		thirdColumn.setVisible(false);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(thirdColumn);
		// thirdgrid.setLayoutData(layoutTop);

		configLabel = new Label(thirdColumn, SWT.PUSH | SWT.TOP | SWT.WRAP);
		configLabel.setText("Send options for group " + bndlname);
		sendOption = new Combo(thirdColumn, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> sendlist = ((EEnum) EmailbundlePackage.Literals.SEND_SETTINGS).getELiterals();
		for (EEnumLiteral literal : sendlist) {
			sendOption.add(literal.getLiteral());
		}
		{
			aggregated = new Composite(thirdColumn, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(1).margins(10, 0).applyTo(aggregated);
			// GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(aggregated);
			aggregated.setVisible(false);
			aggregatedOption = new Combo(aggregated, SWT.DROP_DOWN | SWT.READ_ONLY);
			EList<EEnumLiteral> aggreegatedlist = ((EEnum) EmailbundlePackage.Literals.AGGREGATED_SETTINGS)
				.getELiterals();
			for (EEnumLiteral literal : aggreegatedlist) {
				aggregatedOption.add(literal.getLiteral());
			}
			Label every = new Label(aggregated, SWT.LEFT | SWT.BORDER);
			every.setText("every");
		}
		sendOption.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (sendOption.getText().equalsIgnoreCase("aggregated")) {
					aggregated.setVisible(true);
				} else {
					aggregated.setVisible(false);
					daysSpinner.setSelection(1);
					weekdayOption.select(0);
				}
			}
		});
		aggregatedOption.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (aggregatedOption.getText().equalsIgnoreCase("weekday")) {
					createWeekdayOptionComp();
					daysSpinner.setSelection(1);
				} else if (aggregatedOption.getText().equalsIgnoreCase("days")) {
					createDaysSpinnerComp();
					weekdayOption.select(0);
				} else {
					weekdayOptionComp.setVisible(false);
					daysSpinnerComp.setVisible(false);
					weekdayOption.select(0);
					daysSpinner.setSelection(1);
				}
			}
		});

		return thirdColumn;
	}

	/**
	 * Constructor for EMailNotifierPage.
	 */
	public EMailNotifierPage() {
		super();
	}

	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		if (!init()) {
			Label label = new Label(parent, SWT.WRAP);
			label.setText("Could not determine the current project!");
			return label;
		}
		TabFolder folder = new TabFolder(parent, SWT.TOP);

		TabItem mainTab = new TabItem(folder, SWT.NONE);
		mainTab.setControl(createMainTab(folder));
		mainTab.setText("Main");

		loadProperties();
		bundleList.refresh();

		// for (int i = 0; i < tempBundles.size(); i++) {
		// bindValues(tempBundles, i);
		// }

		return folder;
	}

	private void loadProperties() {
		try {
			OrgUnitProperty loadedBundles = PreferenceManager.INSTANCE.getProperty(projectSpace,
				EMailNotifierKey.BUNDLES);
			OrgUnitProperty loadedActivation = PreferenceManager.INSTANCE.getProperty(projectSpace,
				EMailNotifierKey.ACTIVATED);
			notificationServiceCheck.setSelection(loadedActivation.getBooleanProperty());
			if (loadedBundles != null) {
				loadedBundles.getEObjectListProperty(tempBundles);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadProviderProperties(List<Bundle> l, int x) {
		notifierTypesList.setCheckedElements(l.get(x).getProviders().toArray());

		// secondColumn.setVisible(true);
	}

	private void loadSendProperties(List<Bundle> l, int x) {
		sendOption.select(l.get(x).getSendOption().getValue());
		if (l.get(x).getSendOption().getName().equalsIgnoreCase("aggregated")) {
			aggregated.setVisible(true);
		}
		aggregatedOption.select(l.get(x).getAggregatedOption().getValue());
//		daysSpinner.setSelection(l.get(x).getDaysCount());
//		weekdayOption.select(l.get(x).getWeekdayOption().getValue());

		// thirdColumn.setVisible(true);
	}

	private void disposeProperties() {
		try {
			secondColumn.dispose();
			thirdColumn.dispose();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// notifierTypesList.setAllChecked(false);
		//
		// sendOption.select(0);
		// aggregatedOption.select(0);
		// aggregated.setVisible(false);
		// daysSpinner.setSelection(1);
		// weekdayOption.select(0);
	}

	private boolean init() {
		if (!(getElement() instanceof Project)) {
			return false;
		}

		tempBundles = new Vector<Bundle>();
		project = (Project) getElement();

		projectSpace = WorkspaceManager.getProjectSpace(project);

		providerHints = new HashMap<PropertyKey, String[]>();

		providerHints.put(EMailNotifierKey.TASK_PROVIDER, new String[] { "Task notifications",
			"Show notifications for tasks that have been assigned to you." });
		providerHints.put(EMailNotifierKey.TASK_CHANGE_PROVIDER, new String[] { "Task changes notifications",
			"Show notifications for changes on tasks you have been assigned to." });
		providerHints.put(EMailNotifierKey.TASK_TRACE_PROVIDER, new String[] { "Task trace notifications",
			"Shows notifications for elements that are related to your tasks." });
		providerHints.put(EMailNotifierKey.TASK_REVIEW_PROVIDER, new String[] { "Reviewer task notifications",
			"Shows notifications for tasks that you have to review." });
		providerHints.put(EMailNotifierKey.SUBSCRIPTION_PROVIDER, new String[] { "Subscriptions",
			"Allows you to subscribe to arbitrary model elements and receive notifications upon their changes." });
		providerHints.put(EMailNotifierKey.COMMENTS_PROVIDER, new String[] { "Comment notifications",
			"Shows notifications for new comments regarding your tasks or a discussion you participate in." });

		return true;
	}

	protected void performDefaults() {
	}

	public boolean performOk() {
		final UnicaseCommandWithResult<Object> command = new SavePropertiesCommand();
		command.run();
		return true;
	}

	private final class SavePropertiesCommand extends UnicaseCommandWithResult<Object> {

		@Override
		protected Object doRun() {
			EObject[] b = new EObject[tempBundles.size()];
			for (int i = 0; i < tempBundles.size(); i++) {
				b[i] = (Bundle) tempBundles.get(i);
			}
			PreferenceManager.INSTANCE.setProperty(projectSpace, EMailNotifierKey.BUNDLES, b);
			PreferenceManager.INSTANCE.setProperty(projectSpace, EMailNotifierKey.ACTIVATED, notificationServiceCheck
				.getSelection());
			return null;
		}
	}

	private void addButtons(Composite composite) {
		// Composite composite = new Composite(root, SWT.NULL);
		// FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
		// fillLayout.spacing = 2;
		// composite.setLayout(fillLayout);
		btnAdd = new Button(composite, SWT.PUSH);
		btnAdd.setText("Add");
		btnEdit = new Button(composite, SWT.PUSH);
		btnEdit.setText("Modify");
		btnRemove = new Button(composite, SWT.PUSH);
		btnRemove.setText("Remove");

		btnAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "New bundle",
					"Enter 1-14 characters", "dummy", new LengthValidator());

				if (dlg.open() == Window.OK) {
					Bundle newbndl = EmailbundleFactoryImpl.eINSTANCE.createBundle();
					newbndl.setBundleName(dlg.getValue());
					tempBundles.add(newbndl);
					disposeProperties();
					((org.eclipse.swt.widgets.List) bundleList.getControl()).select(tempBundles.indexOf(newbndl));
				}
				bundleList.refresh(true);

			}
		});

		btnEdit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) bundleList.getSelection();
				Bundle bndl = (Bundle) selection.getFirstElement();
				if (bndl == null) {
					return;
				}
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Edit bundle",
					"Enter 1-14 characters", bndl.getBundleName(), new LengthValidator());
				if (dlg.open() == Window.OK) {
					bndl.setBundleName(dlg.getValue());
				}
				bundleList.update(bndl, null);
			}
		});

		btnRemove.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) bundleList.getSelection();
				Bundle bndl = (Bundle) selection.getFirstElement();
				if (bndl == null) {
					return;
				}
				tempBundles.remove(bndl);
				bundleList.refresh(true);
			}
		});
	}

	private void bindValues(List<Bundle> l, int i) {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		IObservableValue uiElement;
		IObservableValue modelElement;

		uiElement = SWTObservables.observeSelection(sendOption);
		modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__SEND_OPTION);
		bindingContext.bindValue(uiElement, modelElement, null, null);

		uiElement = SWTObservables.observeSelection(aggregatedOption);
		modelElement = EMFEditObservables.observeValue(null, l.get(i),
			EmailbundlePackage.Literals.BUNDLE__AGGREGATED_OPTION);
		bindingContext.bindValue(uiElement, modelElement, null, null);

		uiElement = SWTObservables.observeSelection(daysSpinner);
		modelElement = EMFEditObservables.observeValue(null, l.get(i), EmailbundlePackage.Literals.BUNDLE__DAYS_COUNT);
		bindingContext.bindValue(uiElement, modelElement, null, null);

		uiElement = SWTObservables.observeSelection(weekdayOption);
		modelElement = EMFEditObservables.observeValue(null, l.get(i),
			EmailbundlePackage.Literals.BUNDLE__WEEKDAY_OPTION);
		bindingContext.bindValue(uiElement, modelElement, null, null);
	}

	/**
	 * This class validates a String. It makes sure that the String is between 5 and 8 characters
	 */
	class LengthValidator implements IInputValidator {
		/**
		 * Validates the String. Returns null for no error, or an error message
		 * 
		 * @param newText the String to validate
		 * @return String
		 */
		public String isValid(String s) {
			int len = s.length();
			if (len < 1)
				return "Bundle name is too short";
			if (len > 14)
				return "Bundle name is too long";
			return null;
		}
	}
}