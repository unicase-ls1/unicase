package org.unicase.ui.stem.views.statusview;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.common.commands.ActionHelper;

public class StatusView extends ViewPart { // implements IShowInTarget

	private ModelElement input;
	private DropTarget dropTarget;
	private ProgressBar pb;
	private MEClassLabelProvider labelProvider;
	private Label lblImage;
	private Label lblName;

	// private FlatTabComposite flatTabComposite = new FlatTabComposite();
	// private HierarchyTabComposite hierarchyTabComposite = new
	// HierarchyTabComposite();
	// private UserTabComposite userTabComposite = new UserTabComposite();

	@Override
	public void createPartControl(Composite parent) {

		SashForm sash = new SashForm(parent, SWT.VERTICAL);
		createTopComposite(sash);
		createTabs(sash);
		sash.setWeights(new int[] { 20, 80 });

	}

	private void createTopComposite(SashForm sash) {
		Composite topComposite = new Composite(sash, SWT.BORDER);
		topComposite.setLayout(new GridLayout(2, false));
		topComposite
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		lblImage = new Label(topComposite, SWT.NONE);
		lblImage.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		lblImage.setSize(new Point(200, 200));
		lblImage.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblImage.setText("");
		lblImage.setImage(getImage());
		
		lblName = new Label(topComposite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lblName.setText(input == null ? "" : input.getName());
		lblName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblName.setFont(new Font(Display.getDefault(),"Tahoma", 24, SWT.BOLD));
		

		pb = new ProgressBar(topComposite, SWT.HORIZONTAL);
		pb.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1));

		pb.setMinimum(0);

		pb.setMaximum(100);
		pb.setSelection(33);

		addDNDSupport(topComposite);
	}

	private Image getImage() {
		labelProvider = new MEClassLabelProvider();
		return labelProvider.getImage(input);

	}

	private void createTabs(SashForm sash) {
		TabFolder tabFolder = new TabFolder(sash, SWT.TOP);

		URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/flatLayout.gif"), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem flatTab = new TabItem(tabFolder, SWT.None);
		flatTab.setText("Flat view");
		flatTab.setImage(imageDescriptor.createImage());
		// flatTab.setControl(flatTabComposite);

		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/hierarchicalLayout.gif"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem hierarchyTab = new TabItem(tabFolder, SWT.None);
		hierarchyTab.setText("Hierachical view");
		hierarchyTab.setImage(imageDescriptor.createImage());
		// hierarchyTab.setControl(hierarchyTabComposite);

		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/User.gif"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem userTab = new TabItem(tabFolder, SWT.None);
		userTab.setText("Users");
		userTab.setImage(imageDescriptor.createImage());
		// userTab.setControl(userTabComposite);

	}

	private void addDNDSupport(Composite composite) {
		dropTarget = new DropTarget(composite, DND.DROP_COPY);
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		dropTarget.setTransfer(transfers);
		dropTarget.addDropListener(new DropTargetListener() {

			public void dragEnter(DropTargetEvent event) {
				event.detail = DND.DROP_COPY;
			}

			public void drop(DropTargetEvent event) {
				setInput(null);
			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dragOperationChanged(DropTargetEvent event) {
			}

			public void dragOver(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}

		});

	}

	public void setInput(ModelElement me) {
		ModelElement newInput = me;
		if (newInput == null) {
			newInput = ActionHelper.getSelectedModelElement();
		}
		if(input == null){
			input = newInput;
			refreshView();

		}
		if (newInput != null ) {
			this.input = newInput;
			System.out.println(input.getName());
			// refresh attributes group and three different views
			refreshView();

		}

	}

	private void refreshView() {
		lblImage.setImage(labelProvider.getImage(input));
		
		lblName.setText(input.getName());
		
		int maximum = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
				.getOpeners(input).size();
		pb.setMaximum(maximum);
		int stillOpens = getStillOpenOpeners(input).size();
		pb.setSelection(maximum - stillOpens);

		// flatTabComposite.setInput(input);
		// hierarchyTabComposite.setInput(input);
		// userTabComposite.setInput(input);

	}

	private Set<ModelElement> getStillOpenOpeners(ModelElement me) {
		Set<ModelElement> result = new HashSet<ModelElement>();
		Set<ModelElement> openers = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpeners(input);
		for(ModelElement opener : openers){
			if(opener.getState().equals(MEState.OPEN) || 
					opener.getState().equals(MEState.BLOCKED)){
				
				result.add(opener);
			}
		}

		return result;
	}

	@Override
	public void setFocus() {

	}

	@Override
	public void dispose() {
		dropTarget.dispose();
		super.dispose();
	}

}
