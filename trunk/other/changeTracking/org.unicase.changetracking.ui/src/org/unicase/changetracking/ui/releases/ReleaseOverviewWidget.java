/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.releases;

import java.text.DateFormat;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.release.ChangePackageState;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.WorkItemStatistics;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.ChangePackageStateLabelProvider;
import org.unicase.changetracking.ui.ImageAndTextLabel;
import org.unicase.changetracking.ui.ReleaseTreeViewer;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.Release;

/**
 * 
 * Main widget for displaying the result of a release check.
 * 
 * Is used by the CheckReleaseDialog and by the BuildReleaseWizard (since
 * building also includes the checking of the release).
 * 
 * Contains four tabs which state all important information. The first tab
 * contains an overview of the relase and its build status The second page shows
 * a tree view of all packages and work items which are included in the release,
 * depicting their status with decorations. The third page displays a list of
 * problems and erros which were found during the checking. The last page
 * contains a change log assembled from the change packages.
 * 
 * @author jfinis
 * 
 */
public class ReleaseOverviewWidget extends Composite {

	private static final int MAX_HEIGHT = 300;

	/* Images */
	private static final Image ERROR_IMAGE = Activator.getImageDescriptor("icons/error.gif").createImage();
	private static final Image WARNING_IMAGE = Activator.getImageDescriptor("icons/warning.gif").createImage();
	private static final Image TAB_IMAGE_OVERVIEW = Activator.getImageDescriptor("icons/full/obj16/ChangeTrackingRelease.gif").createImage();
	private static final Image TAB_IMAGE_CONTENT = Activator.getImageDescriptor("icons/ChangePackage.gif").createImage();
	private static final Image TAB_IMAGE_PROBLEMS = Activator.getImageDescriptor("icons/warning.gif").createImage();
	private static final Image TAB_IMAGE_CHANGELOG = Activator.getImageDescriptor("icons/changelog.gif").createImage();
	private static final Image ALREADY_BUILT_IMAGE = Activator.getImageDescriptor("icons/ReleaseBuilt.gif").createImage();;
	private static final Image READY_TO_BUILD_IMAGE = Activator.getImageDescriptor("icons/play.gif").createImage();

	private ChangePackageStateLabelProvider labelProvider;
	private Image alreadyMergedImage;
	private Image unmergedImage;
	private Image errorImage;

	/**
	 * Default constructor.
	 * 
	 * @param parent parent widget
	 * @param style style constants
	 * @param release release to be displayed
	 * @param report checking report to be displayed
	 */
	public ReleaseOverviewWidget(Composite parent, int style, Release release, ReleaseCheckReport report) {
		super(parent, style);

		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(2, 2).numColumns(2).applyTo(this);

		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(2, 2).applyTo(tabFolder);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(tabFolder);

		createImages(report);

		// Overview
		createOverviewTab(release, report, tabFolder);

		// Content
		createContentTab(release, tabFolder);

		// Messages
		createProblemsTab(report, tabFolder);

		createChangelogTab(tabFolder, report, release);

	}

	private void createImages(ReleaseCheckReport report) {

		labelProvider = new ChangePackageStateLabelProvider(report);

		alreadyMergedImage = labelProvider.generateImage(ChangePackageState.MERGED);
		unmergedImage = labelProvider.generateImage(ChangePackageState.UNMERGED);
		errorImage = labelProvider.generateImage(ChangePackageState.ERROR);
	}

	private void createOverviewTab(Release release, ReleaseCheckReport report, TabFolder tabFolder) {
		TabItem t = new TabItem(tabFolder, SWT.NONE);
		t.setText("Overview");
		t.setImage(TAB_IMAGE_OVERVIEW);

		Composite overviewComposite = new Composite(tabFolder, SWT.NONE);
		t.setControl(overviewComposite);
		GridLayoutFactory.fillDefaults().margins(10, 10).spacing(5, 15).numColumns(3).applyTo(overviewComposite);

		ImageAndTextLabel caption = new ImageAndTextLabel(overviewComposite, SWT.NONE, labelProvider);
		GridDataFactory.swtDefaults().span(3, 1).applyTo(caption);
		caption.setInput(release);

		Label label = new Label(overviewComposite, SWT.NONE);
		label.setText("Release progress:");
		WorkItemStatistics wiStats = report.getWorkItemStats();
		ProgressBar releaseProgress = new ProgressBar(overviewComposite, SWT.HORIZONTAL);
		releaseProgress.setMinimum(0);
		releaseProgress.setMaximum(wiStats.getNumWorkItems());
		releaseProgress.setState(SWT.PAUSED);
		releaseProgress.setSelection(wiStats.getNumResolved());
		label = new Label(overviewComposite, SWT.NONE);
		label.setText(wiStats.getNumResolved() + " of " + wiStats.getNumWorkItems() + " work items resolved (" + wiStats.getPercentage() + "%).");

		Label buildProgress = new Label(overviewComposite, SWT.NONE);
		buildProgress.setText("Build progress:");
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.TOP).applyTo(buildProgress);

		Composite legend = new Composite(overviewComposite, SWT.NONE);
		GridLayoutFactory.swtDefaults().margins(2, 2).spacing(10, 0).numColumns(1).applyTo(legend);
		GridDataFactory.swtDefaults().span(2, 1).applyTo(legend);

		ImageAndTextLabel alreadyMergedLabel = new ImageAndTextLabel(legend, SWT.NONE);
		alreadyMergedLabel.setContent(alreadyMergedImage, report.getNumChangePackagesOfState(ChangePackageState.MERGED) + " change packages already merged");

		ImageAndTextLabel notMergedLabel = new ImageAndTextLabel(legend, SWT.NONE);
		notMergedLabel.setContent(unmergedImage, report.getNumChangePackagesOfState(ChangePackageState.UNMERGED) + " change packages not merged");

		ImageAndTextLabel errorLabel = new ImageAndTextLabel(legend, SWT.NONE);
		errorLabel.setContent(errorImage, (report.getNumChangePackagesOfState(ChangePackageState.ERROR)) + " change packages erroneous");

		Label releaseStatus = new Label(overviewComposite, SWT.NONE);
		releaseStatus.setText("Release status:");
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.TOP).applyTo(buildProgress);

		ImageAndTextLabel releaseStatusLabel = new ImageAndTextLabel(overviewComposite, SWT.NONE);
		if (release.isBuilt()) {
			String buildStr;
			if (release.getBuildDate() != null) {
				buildStr = " at " + DateFormat.getDateTimeInstance().format(release.getBuildDate());
			} else {
				buildStr = "";
			}
			releaseStatusLabel.setContent(ALREADY_BUILT_IMAGE, "The release has already been built " + buildStr);
		} else if (report.hasErrors()) {
			releaseStatusLabel.setContent(ERROR_IMAGE, "The release cannot can be built due to errors");
		} else if (report.hasWarnings()) {
			releaseStatusLabel.setContent(WARNING_IMAGE, "The release can be built, but has warnings");
		} else {
			releaseStatusLabel.setContent(READY_TO_BUILD_IMAGE, "The release is ready to get built");
		}

	}

	private void createContentTab(Release release, TabFolder tabFolder) {
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

		// Legend
		Composite legend = new Composite(treeViewer, SWT.NONE);
		GridLayoutFactory.swtDefaults().margins(2, 2).spacing(10, 0).numColumns(4).applyTo(legend);

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
		GridLayoutFactory.fillDefaults().margins(10, 10).spacing(2, 5).numColumns(2).applyTo(messageGroup);

		Label problemCaption = new Label(messageGroup, SWT.NONE);
		FontData sysFont = getDisplay().getSystemFont().getFontData()[0];
		Font captFont = new Font(getDisplay(), new FontData(sysFont.getName(), sysFont.getHeight(), SWT.BOLD));
		problemCaption.setFont(captFont);
		GridDataFactory.swtDefaults().span(2, 1).applyTo(problemCaption);

		if (report.getProblems().isEmpty()) {
			problemCaption.setText("No problems were detected in this release.");
		} else {
			problemCaption.setText("The following problems were detected in this release:");
		}

		for (Problem p : report.getProblems()) {
			Label l = new Label(messageGroup, SWT.NONE);
			Image i = null;
			switch (p.getSeverity()) {
			case ERROR:
				i = ERROR_IMAGE;
				break;
			case WARNING:
				i = WARNING_IMAGE;
				break;
			default:
				break;
			}
			l.setImage(i);
			Text text = new Text(messageGroup, SWT.MULTI | SWT.WRAP);
			text.setText(p.getMessage());
		}
	}

	private void createChangelogTab(TabFolder tabFolder, ReleaseCheckReport report, Release release) {
		TabItem t = new TabItem(tabFolder, SWT.NONE);
		t.setText("Changelog");
		t.setImage(TAB_IMAGE_CHANGELOG);
		Composite composite = new Composite(tabFolder, SWT.NONE);
		t.setControl(composite);
		GridLayoutFactory.fillDefaults().margins(10, 10).spacing(2, 5).applyTo(composite);

		Label caption = new Label(composite, SWT.NONE);
		caption.setText("This changelog is assembled by taking\nthe short description of all change packages:");
		Text changelogText = new Text(composite, SWT.MULTI | SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(changelogText);
		StringBuilder changelog = new StringBuilder();
		changelog.append(release.getName()).append(":\n");
		for (ChangePackage cp : report.getChangePackageResults().keySet()) {
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

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		Point size = super.computeSize(wHint, hHint, changed);
		if (size.y > MAX_HEIGHT) {
			size.y = MAX_HEIGHT;
		}
		return size;
	}

}
