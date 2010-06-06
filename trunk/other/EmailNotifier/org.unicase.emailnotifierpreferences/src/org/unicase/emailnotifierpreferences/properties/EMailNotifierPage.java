package org.unicase.emailnotifierpreferences.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
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
	private Composite secondGrid;
	private Label selectNotifier;
	private CheckboxTableViewer notifierTypesList;
	private HashMap<PropertyKey, String[]> providerHints;
	private Label configLabel;
	private Composite thirdgrid;
	private Combo sendSettings;
	private Button immediatelyRadio;
	private Button aggregatedRadio;
	private Spinner daysSpinner;
	private Button notificationServiceCheck;
	private Composite aggregated;
	private Button daysRadio;
	private Button weekdayRadio;
	private Combo weekdayCombo;
	final private String[] weekdaysArray = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
		"Sunday" };

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
			Composite compositeTop = new Composite(root, SWT.NONE);
			GridLayout topgrid = new GridLayout(3, false);
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
						refreshProperties();
						loadProviderProperties(tempBundles, tempBundles.indexOf(selection.getFirstElement()));
						loadSendProperties(tempBundles, tempBundles.indexOf(selection.getFirstElement()));
						Bundle bndl = (Bundle) selection.getFirstElement();
						String bndlname = bndl.getBundleName();
						selectNotifier.setText("Select notifier for Bundle " + bndlname);
						configLabel.setText("Select notifier for Bundle " + bndlname);
						// if(!tempBundles.get(tempBundles.indexOf(selection.getFirstElement())).isAggregated()){
						// aggregated.setVisible(false);
						// }
					}
				});

				bundleList.addFilter(new ViewerFilter() {
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return true;
					}
				});

				bundleList.setSorter(new ViewerSorter() {
					public int compare(Viewer viewer, Object e1, Object e2) {
						return ((Bundle) e1).getBundleName().compareTo(((Bundle) e2).getBundleName());
					}
				});
			}

			// second grid
			{
				secondGrid = new Composite(compositeTop, SWT.NONE);
				secondGrid.setVisible(false);
				GridLayout compositeBundleLayout = new GridLayout(1, false);
				// compositeBundle.setLayoutData(layoutTop);
				secondGrid.setLayout(compositeBundleLayout);

				selectNotifier = new Label(secondGrid, SWT.PUSH | SWT.TOP);
				selectNotifier.setText("Select notifier for Bundle ");
				notifierTypesList = CheckboxTableViewer.newCheckList(secondGrid, SWT.SINGLE | SWT.V_SCROLL
					| SWT.H_SCROLL | SWT.BORDER);
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

				final Label hint = new Label(secondGrid, SWT.WRAP);
				// GridDataFactory.fillDefaults().grab(true, false).applyTo(hint);
				GridData labelData = new GridData();

				// labelData.horizontalSpan = 2;

				labelData.horizontalAlignment = SWT.FILL;

				Rectangle rect = secondGrid.getMonitor().getClientArea();

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
			}

			// third grid
			{
				thirdgrid = new Composite(compositeTop, SWT.NONE);
				thirdgrid.setVisible(false);
				GridLayoutFactory.fillDefaults().numColumns(1).applyTo(thirdgrid);
				// thirdgrid.setLayoutData(layoutTop);

				sendSettings = new Combo(thirdgrid, SWT.DROP_DOWN | SWT.READ_ONLY);
//				EList<EEnumLiteral> list = (EList<EEnumLiteral>) EmailbundlePackage.Literals.SEND_SETTINGS;
				EList<EEnumLiteral> list = ((EEnum)EmailbundlePackage.Literals.SEND_SETTINGS).getELiterals();
				for (EEnumLiteral literal : list) {
					sendSettings.add(literal.getLiteral());
				}
				configLabel = new Label(thirdgrid, SWT.PUSH | SWT.TOP);
				configLabel.setText("Configuration for Bundle");
//				immediatelyRadio = new Button(thirdgrid, SWT.RADIO | SWT.LEFT);
//				immediatelyRadio.setText("immediately");
//				aggregatedRadio = new Button(thirdgrid, SWT.RADIO | SWT.LEFT);
//				aggregatedRadio.setText("aggregated");
				{
					aggregated = new Composite(thirdgrid, SWT.NONE);
					GridLayoutFactory.fillDefaults().numColumns(3).margins(10, 0).applyTo(aggregated);
					GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(aggregated);
					aggregated.setVisible(false);
					daysRadio = new Button(aggregated, SWT.RADIO | SWT.LEFT);
					daysRadio.setText("every");
					daysSpinner = new Spinner(aggregated, SWT.WRAP | SWT.BORDER);
					daysSpinner.setMinimum(1);
					daysSpinner.setMaximum(30);
					Label daysLabel = new Label(aggregated, SWT.LEFT | SWT.BORDER);
					daysLabel.setText("days");
					weekdayRadio = new Button(aggregated, SWT.RADIO | SWT.LEFT);
					weekdayRadio.setText("every");
					weekdayCombo = new Combo(aggregated, SWT.DROP_DOWN | SWT.READ_ONLY);
					weekdayCombo.setItems(weekdaysArray);

					aggregatedRadio.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							aggregated.setVisible(true);
						}
					});
					immediatelyRadio.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							aggregated.setVisible(false);
							daysRadio.setSelection(false);
							daysSpinner.setSelection(1);
							weekdayRadio.setSelection(false);
							weekdayCombo.select(NONE);
						}
					});
					daysRadio.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							weekdayCombo.select(NONE);
						}
					});
					weekdayRadio.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							daysSpinner.setSelection(1);
						}
					});
				}
			}
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
//		if (!tempBundles.isEmpty()) {
//			bundleList.getList().setFocus();
//			bundleList.getList().select(0);
//			for (int i = 0; i < tempBundles.size(); i++) {
//				bindValues(tempBundles, i);
//			}
//		}
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
		secondGrid.setVisible(true);
	}

	private void loadSendProperties(List<Bundle> l, int x) {
		sendSettings.select(l.get(x).getSendOption().getValue());
//		aggregatedRadio.setSelection(l.get(x).isAggregated());
		if (l.get(x).getSendOption().getName().equalsIgnoreCase("aggregated")) {
			aggregated.setVisible(true);
		}
		daysRadio.setSelection(l.get(x).isDays());
		daysSpinner.setSelection(l.get(x).getDaysCount());
		weekdayRadio.setSelection(l.get(x).isWeekday());
		weekdayCombo.select(l.get(x).getWeekdayOption().getValue());
		thirdgrid.setVisible(true);
	}

	private void refreshProperties() {
		notifierTypesList.setAllChecked(false);
		immediatelyRadio.setSelection(false);
		aggregatedRadio.setSelection(false);
		daysRadio.setSelection(false);
		aggregated.setVisible(false);
		daysSpinner.setSelection(1);
		weekdayRadio.setSelection(false);
		weekdayCombo.select(NONE);
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
			PreferenceManager.INSTANCE.setProperty(projectSpace, EMailNotifierKey.ACTIVATED, notificationServiceCheck.getSelection());
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
					refreshProperties();
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
		DataBindingContext bindingContext = new DataBindingContext();
		IObservableValue uiElement;
		IObservableValue modelElement;

		// Initialize the model
		EmailbundlePackage.eINSTANCE.eClass();
		// Retrieve the default factory singleton
		EmailbundleFactory factory = EmailbundleFactory.eINSTANCE;

//		uiElement = SWTObservables.observeSelection(immediatelyRadio);
//		modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__IMMEDIATELY);
//		bindingContext.bindValue(uiElement, modelElement, null, null);
//
//		uiElement = SWTObservables.observeSelection(aggregatedRadio);
//		modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__AGGREGATED);
//		bindingContext.bindValue(uiElement, modelElement, null, null);
//
//		uiElement = SWTObservables.observeSelection(daysRadio);
//		modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__DAYS);
//		bindingContext.bindValue(uiElement, modelElement, null, null);
//
//		uiElement = SWTObservables.observeSelection(daysSpinner);
//		modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__DAYS_COUNT);
//		bindingContext.bindValue(uiElement, modelElement, null, null);
//
//		uiElement = SWTObservables.observeSelection(weekdayRadio);
//		modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__WEEKDAY);
//		bindingContext.bindValue(uiElement, modelElement, null, null);
//
//		uiElement = SWTObservables.observeSelection(weekdayCombo);
//		modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__WEEKDAY_INDEX);
//		bindingContext.bindValue(uiElement, modelElement, null, null);
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