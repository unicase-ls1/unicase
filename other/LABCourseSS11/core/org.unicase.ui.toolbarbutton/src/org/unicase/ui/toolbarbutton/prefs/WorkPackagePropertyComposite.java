package org.unicase.ui.toolbarbutton.prefs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.toolbarbutton.ModelIdDoesNotExistException;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.workpackagetransfer.TreeHandler;
import org.unicase.workpackagetransfer.navigator.wizards.ChooseWorkPackagePage;

public class WorkPackagePropertyComposite extends Composite {

	public TreeHandler treeHandler;
	private Tree tree;
	public Project project;
	private AdapterFactoryLabelProvider labelProvider;
	private WorkPackage targetWorkPackage;
	private Button browseButton;
	private CLabel workPackageLabel;
	private String labelText;

	private static final String CLABEL_INIT_TEXT = ">> Select target Workpackage <<";
	private static final String BROWSE_BUTTON_TEXT = "Browse Workpackages";

	public WorkPackagePropertyComposite(Composite parent, int style,
			Project project, String desc, WorkPackage defaultTargetWorkPackage) {
		super(parent, style);
		this.project = project;
		this.labelText = desc;
		this.targetWorkPackage = defaultTargetWorkPackage;
		this.labelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		createContent();
	}

	public WorkPackagePropertyComposite(Composite parent, int style,
			Project project, String desc) {
		this(parent, style, project, desc, null);
	}

	private void createContent() {
		// Composite (Container)
		// final Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gridLayout = new GridLayout(4, false);
		this.setLayout(gridLayout);

		Label label1 = new Label(this, SWT.LEFT);
		label1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
		label1.setText(labelText);

		workPackageLabel = new CLabel(this, SWT.BORDER);
		workPackageLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1));
		workPackageLabel.setAlignment(SWT.CENTER);
		if (targetWorkPackage == null) {
			workPackageLabel.setText(CLABEL_INIT_TEXT);
		} else {
			workPackageLabel
					.setImage(labelProvider.getImage(targetWorkPackage));
			workPackageLabel.setText(labelProvider.getText(targetWorkPackage));
		}

		browseButton = new Button(this, SWT.PUSH);
		browseButton.setText(BROWSE_BUTTON_TEXT);
		browseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 2, 1));
		ChooseWorkItemPageListener choiceListener = new ChooseWorkItemPageListener();
		browseButton.addListener(SWT.Selection, choiceListener);
	}

	public WorkPackage getTargetWorkPackage() {
		return targetWorkPackage;
	}

	public void setTargetWorkPackage(ModelElementId id) throws ModelIdDoesNotExistException {
		EObject parentPackage = project.getModelElement(id);
		if (parentPackage == null) {
			throw new ModelIdDoesNotExistException(id);
		}

		if (parentPackage instanceof WorkPackage) {
			targetWorkPackage = (WorkPackage) parentPackage;

			workPackageLabel.setImage(labelProvider.getImage(targetWorkPackage));
			workPackageLabel.setText(labelProvider.getText(targetWorkPackage));
		}

	}

	/**
	 * Listener handling button pressed events and selection events in the
	 * table.
	 * 
	 * @author mkagel
	 */
	private class ChooseWorkItemPageListener implements Listener,
			SelectionListener {

		public void handleEvent(Event event) {
			Widget widget = event.widget;

			if (widget == browseButton) {
				showChooseWorkPackageDialog();
			}

			else if (widget == tree && event.detail == SWT.CHECK) {

				TreeItem treeItem = (TreeItem) event.item;

				manageSelection(treeItem);
			}

		}

		/**
		 * shows the dialog for choosing the target workPackage
		 */
		private void showChooseWorkPackageDialog() {
			ECPModelelementContext context;

			try {

				context = ECPWorkspaceManager.getInstance().getWorkSpace()
						.getActiveProject();
				ChooseWorkPackagePage dialog = new ChooseWorkPackagePage(
						context, project);

				if (dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();

					if (result.length == 1) {
						if (result[0] instanceof WorkPackage) {
							targetWorkPackage = (WorkPackage) result[0];

							workPackageLabel.setImage(labelProvider
									.getImage(targetWorkPackage));
							workPackageLabel.setText(labelProvider
									.getText(targetWorkPackage));
						}
					}
				}
			} catch (NoWorkspaceException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}

		/**
		 * Managing the Selection-Event, new checked treeItems have to check
		 * their children treeItems and newly unchecked treeItems have to
		 * uncheck their parent and children treeItems.
		 * 
		 * @param treeItem
		 *            whose checking has been changed
		 */
		private void manageSelection(TreeItem treeItem) {

			if (treeItem.getChecked()) {
				treeHandler.checkTreeItem(treeItem, true);
			} else {
				treeHandler.uncheckTreeItem(treeItem, true, true);
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
		}

	}
}
