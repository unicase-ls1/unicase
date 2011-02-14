package org.unicase.changetracking.ui.releases;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.git.GitNameUtil;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.ui.ReleaseTreeViewer;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.ui.navigator.ContentProvider;

public class BuildSettingsPage extends WizardPage implements IDialogHead{

	private ChangeTrackingRelease release;
	private ReleaseCheckReport report;
	private Repository repository;
	private Text tagNameText;

	protected BuildSettingsPage(String pageName, String title,
			ImageDescriptor titleImage, ChangeTrackingRelease release, ReleaseCheckReport report, Repository repository) {
		super(pageName, title, titleImage);
		this.release = release;
		this.report = report;
		this.repository = repository;
	}

	@Override
	public void createControl(Composite parent) {
		Composite c = new Composite(parent, SWT.NONE);
		GridDataFactory.swtDefaults().grab(true, true).applyTo(c);
		GridDataFactory leftGridFactory = GridDataFactory.swtDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER);
		GridDataFactory rightGridFactory = GridDataFactory.swtDefaults().grab(true, false).align(SWT.LEFT, SWT.CENTER);
		
		GridLayoutFactory.swtDefaults().margins(20, 20).numColumns(2).applyTo(c);
		
		
		setMessage("Choose a name for the tag to be created.", INFORMATION);
		
		Label textLabel = new Label(c, SWT.NONE);
		textLabel.setText("Tag name:");
		leftGridFactory.applyTo(textLabel);
		
		tagNameText = new Text(c, SWT.SINGLE);
		tagNameText.setText(GitNameUtil.cleanName(release.getName()));
		tagNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				refreshStatus();
			}
		});
		rightGridFactory.applyTo(tagNameText);
		
		
		refreshStatus();
		setControl(c);
	}


	private void refreshStatus() {
		String error = GitNameUtil.isNewTagNameValid(tagNameText.getText(), repository);
		setErrorMessage(error);
		if(error != null){
			((BuildReleaseWizard) getWizard()).setFinishable(false);
		} else {
			((BuildReleaseWizard) getWizard()).setFinishable(true);
		}
	}

	public String getTagName() {
		return tagNameText.getText();
	}

}
