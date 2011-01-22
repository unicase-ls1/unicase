package org.unicase.changetracking.ui.releases;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.release.BranchState;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.WorkItemStatistics;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.ChangePackageStateLabelProvider;
import org.unicase.changetracking.ui.ImageAndTextLabel;
import org.unicase.changetracking.ui.ReleaseTreeViewer;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;

public class ReleaseOverviewWidget extends Composite {
	
	private static final Image ERROR_IMAGE = Activator.getImageDescriptor("icons/error.gif").createImage();
	private static final Image WARNING_IMAGE = Activator.getImageDescriptor("icons/warning.gif").createImage();

	private static final Image TAB_IMAGE_OVERVIEW = Activator.getImageDescriptor("icons/full/obj16/ChangeTrackingRelease.gif").createImage();
	private static final Image TAB_IMAGE_CONTENT = Activator.getImageDescriptor("icons/ChangePackage.gif").createImage();
	private static final Image TAB_IMAGE_PROBLEMS = Activator.getImageDescriptor("icons/warning.gif").createImage();
	private static final Image TAB_IMAGE_CHANGELOG = Activator.getImageDescriptor("icons/changelog.gif").createImage();
	private ChangePackageStateLabelProvider labelProvider;
	private Image alreadyMergedImage;
	private Image unmergedImage;
	private Image errorImage;
	

	public ReleaseOverviewWidget(Composite parent, int style, ChangeTrackingRelease release,  ReleaseCheckReport report) {
		super(parent, style);
		
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(2, 2).numColumns(2).applyTo(this);
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(2, 2).applyTo(tabFolder);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(tabFolder);
		
		
		createImages(report);
		
		//Overview
		createOverviewTab(release, report, tabFolder);
		
		//Content
		createContentTab(release, tabFolder);
		
		
		//Messages
		createProblemsTab(report, tabFolder);

		createChangelogTab(tabFolder, report, release);
		
	}
	
	private void createImages(ReleaseCheckReport report) {

		labelProvider = new ChangePackageStateLabelProvider(report);
		
		alreadyMergedImage = labelProvider.generateImage(BranchState.MERGED);
		unmergedImage = labelProvider.generateImage(BranchState.UNMERGED);
		errorImage = labelProvider.generateImage(BranchState.ERROR);
	}

	private void createOverviewTab(ChangeTrackingRelease release, ReleaseCheckReport report,
			TabFolder tabFolder) {
		TabItem t = new TabItem(tabFolder, SWT.NONE);
		t.setText("Overview");
		t.setImage(TAB_IMAGE_OVERVIEW);
		
		Composite overviewComposite = new Composite(tabFolder, SWT.NONE);
		t.setControl(overviewComposite);
		GridLayoutFactory.fillDefaults().margins(10,10).spacing(5, 15).numColumns(3).applyTo(overviewComposite);
		
		ImageAndTextLabel caption = new ImageAndTextLabel(overviewComposite, SWT.NONE,labelProvider);
		GridDataFactory.swtDefaults().span(3, 1).applyTo(caption);
		caption.setInput(release);
		
		Label label = new Label(overviewComposite,SWT.NONE);
		label.setText("Release progress:");
		WorkItemStatistics wiStats = report.getWorkItemStats();
		ProgressBar releaseProgress = new ProgressBar(overviewComposite, SWT.HORIZONTAL);
		releaseProgress.setMinimum(0);
		releaseProgress.setMaximum(wiStats.getNumWorkItems());
		releaseProgress.setState(SWT.PAUSED);
		releaseProgress.setSelection(wiStats.getNumResolved());
		label = new Label(overviewComposite, SWT.NONE);
		label.setText(wiStats.getNumResolved() + " of " + wiStats.getNumWorkItems() + " work items resolved (" + wiStats.getPercentage() + "%).");
		
		Label buildProgress = new Label(overviewComposite,SWT.NONE);
		buildProgress.setText("Build progress:");
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.TOP).applyTo(buildProgress);
		
		Composite legend = new Composite(overviewComposite, SWT.NONE);
		GridLayoutFactory.swtDefaults().margins(2,2).spacing(10, 0).numColumns(1).applyTo(legend);
		GridDataFactory.swtDefaults().span(2, 1).applyTo(legend);
		
		ImageAndTextLabel alreadyMergedLabel = new ImageAndTextLabel(legend, SWT.NONE);
		alreadyMergedLabel.setContent(alreadyMergedImage, report.getNumChangePackagesOfState(BranchState.MERGED) + " change packages already merged");
		
		ImageAndTextLabel notMergedLabel = new ImageAndTextLabel(legend, SWT.NONE);
		notMergedLabel.setContent(unmergedImage,report.getNumChangePackagesOfState(BranchState.UNMERGED) +  " change packages not merged");
		
		ImageAndTextLabel errorLabel = new ImageAndTextLabel(legend, SWT.NONE);
		errorLabel.setContent(errorImage,(report.getNumChangePackagesOfState(BranchState.ERROR) + report.getNumChangePackagesOfState(BranchState.UNCONNECTED)) +  " change packages erroneous");

	}

	private void createContentTab(ChangeTrackingRelease release,
			TabFolder tabFolder) {
		TabItem t;
		t = new TabItem(tabFolder, SWT.NONE);
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
		alreadyMergedLabel.setContent(alreadyMergedImage, "already merged");
		
		ImageAndTextLabel notMergedLabel = new ImageAndTextLabel(legend, SWT.NONE);
		notMergedLabel.setContent(unmergedImage, "not merged");
		
		ImageAndTextLabel errorLabel = new ImageAndTextLabel(legend, SWT.NONE);
		errorLabel.setContent(errorImage, "error");
	}

	private void createProblemsTab(ReleaseCheckReport report, TabFolder tabFolder) {
		TabItem t;
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
	}



	private void createChangelogTab(TabFolder tabFolder, ReleaseCheckReport report, ChangeTrackingRelease release) {
		TabItem t = new TabItem(tabFolder, SWT.NONE);
		t.setText("Changelog");
		t.setImage(TAB_IMAGE_CHANGELOG);
		Composite composite = new Composite(tabFolder, SWT.NONE);
		t.setControl(composite);
		GridLayoutFactory.fillDefaults().margins(10,10).spacing(2, 5).applyTo(composite);
		
		
		
		Label caption = new Label(composite, SWT.NONE);
		caption.setText("This changelog is assembled by taking\nthe short description of all change packages:");
		Text changelogText = new Text(composite, SWT.MULTI | SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(changelogText);
		StringBuilder changelog = new StringBuilder();
		changelog.append(release.getName()).append(":\n");
		for(ChangePackage cp : report.getChangePackages()){
			changelog.append(" - ").append(cp.getShortDescription()).append("\n");
		}
		changelogText.setText(changelog.toString());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		alreadyMergedImage.dispose();
		errorImage.dispose();
		unmergedImage.dispose();
	}



}
