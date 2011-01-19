package org.unicase.changetracking.ui.releases;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.release.BranchState;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.ChangePackageStateLabelProvider;
import org.unicase.changetracking.ui.ImageAndTextLabel;
import org.unicase.changetracking.ui.ReleaseTreeViewer;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class ReleaseOverviewWidget extends Composite {
	
	private static final Image ERROR_IMAGE = Activator.getImageDescriptor("icons/error.gif").createImage();
	private static final Image WARNING_IMAGE = Activator.getImageDescriptor("icons/warning.gif").createImage();
	
	private static final Image TAB_IMAGE_CONTENT = Activator.getImageDescriptor("icons/ChangePackage.gif").createImage();
	private static final Image TAB_IMAGE_PROBLEMS = Activator.getImageDescriptor("icons/warning.gif").createImage();
	private static final Image TAB_IMAGE_CHANGELOG = Activator.getImageDescriptor("icons/changelog.gif").createImage();
	
	private IDialogHead dialogHead;

	public ReleaseOverviewWidget(Composite parent, int style, ChangeTrackingRelease release, IDialogHead dialogHead, ReleaseCheckReport report) {
		super(parent, style);
		this.dialogHead = dialogHead;
		
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(2, 2).numColumns(2).applyTo(this);
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(2, 2).applyTo(tabFolder);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(tabFolder);
		
		ChangePackageStateLabelProvider labelProvider = new ChangePackageStateLabelProvider(report);
		
		TabItem t = new TabItem(tabFolder, SWT.NONE);
		t.setText("Release Content");
		t.setImage(TAB_IMAGE_CONTENT);
		
		
		ReleaseTreeViewer treeViewer = new ReleaseTreeViewer(tabFolder, SWT.NONE);
		t.setControl(treeViewer);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(treeViewer);
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setInput(release);
		treeViewer.expandAll();
		
		//Legend
		Composite legend = new Composite(treeViewer, SWT.NONE);
		GridLayoutFactory.swtDefaults().margins(2,2).spacing(10, 0).numColumns(4).applyTo(legend);
		

		
		ImageAndTextLabel alreadyMergedLabel = new ImageAndTextLabel(legend, SWT.NONE);
		alreadyMergedLabel.setContent(labelProvider.generateImage(BranchState.MERGED), "already merged");
		
		ImageAndTextLabel notMergedLabel = new ImageAndTextLabel(legend, SWT.NONE);
		notMergedLabel.setContent(labelProvider.generateImage(BranchState.UNMERGED), "not merged");
		
		ImageAndTextLabel errorLabel = new ImageAndTextLabel(legend, SWT.NONE);
		errorLabel.setContent(labelProvider.generateImage(BranchState.ERROR), "error");
		
		
		//Messages
		t = new TabItem(tabFolder, SWT.NONE);
		t.setText("Problems");
		t.setImage(TAB_IMAGE_PROBLEMS);
		
		Composite messageGroup = new Composite(tabFolder, SWT.NONE);
		t.setControl(messageGroup);
		GridLayoutFactory.fillDefaults().margins(10,10).spacing(2, 5).numColumns(2).applyTo(messageGroup);
		
		Label problemCaption = new Label(messageGroup,SWT.NONE);
		FontData sysFont = getDisplay().getSystemFont().getFontData()[0];
		Font captFont = new Font(getDisplay(), new FontData(sysFont.getName(), sysFont.getHeight(), SWT.BOLD));
		problemCaption.setFont(captFont);
		GridDataFactory.swtDefaults().span(2, 1).applyTo(problemCaption);
		
		if(report.getProblems().isEmpty()){
			problemCaption.setText("No problems were detected in this release.");
		} else {
			problemCaption.setText("The following problems were detected in this release:");
		}
		
		for(Problem p : report.getProblems()){
			Label l = new Label(messageGroup, SWT.NONE);
			Image i = null;
			switch(p.getSeverity()){
			case ERROR: i = ERROR_IMAGE; break;
			case WARNING: i = WARNING_IMAGE; break;
			}
			l.setImage(i);
			Text text = new Text(messageGroup,SWT.MULTI | SWT.WRAP);
			text.setText(p.getMessage());
		}

		createChangelogTab(tabFolder, report, release);
		
		configureDialogHead(report);
	}

	private void createChangelogTab(TabFolder tabFolder, ReleaseCheckReport report, ChangeTrackingRelease release) {
		TabItem t = new TabItem(tabFolder, SWT.NONE);
		t.setText("Changelog");
		t.setImage(TAB_IMAGE_CHANGELOG);
		Composite composite = new Composite(tabFolder, SWT.NONE);
		t.setControl(composite);
		GridLayoutFactory.fillDefaults().margins(10,10).spacing(2, 5).applyTo(composite);
		
		Label caption = new Label(composite, SWT.NONE);
		caption.setText("Changelog:");
		Text changelogText = new Text(composite, SWT.MULTI | SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(changelogText);
		StringBuilder changelog = new StringBuilder();
		changelog.append(release.getName()).append(":\n");
		for(ChangePackage cp : report.getChangePackages()){
			changelog.append(" - ").append(cp.getShortDescription()).append("\n");
		}
		changelogText.setText(changelog.toString());
	}

	private void configureDialogHead(ReleaseCheckReport report) {
		if(dialogHead == null){
			return;
		}
		
		if(report.hasErrors()){
			dialogHead.setMessage("There are errors in the release. Check the 'problems' tab for details.", IMessageProvider.ERROR);
		} else if(report.hasWarnings()){
			dialogHead.setMessage("There are warnings in the release. Check the 'problems' tab for details.", IMessageProvider.WARNING);
		} else {
			dialogHead.setMessage("No errors were found in this release.", IMessageProvider.INFORMATION);
		}
		
		
	}

}
