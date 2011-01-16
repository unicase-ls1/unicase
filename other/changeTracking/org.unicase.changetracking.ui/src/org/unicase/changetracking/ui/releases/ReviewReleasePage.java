package org.unicase.changetracking.ui.releases;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.changetracking.ui.ReleaseTreeViewer;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.ui.navigator.ContentProvider;

public class ReviewReleasePage extends WizardPage{

	private ChangeTrackingRelease release;

	protected ReviewReleasePage(String pageName, String title,
			ImageDescriptor titleImage, ChangeTrackingRelease release) {
		super(pageName, title, titleImage);
		this.release = release;
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		ReleaseTreeViewer treeViewer = new ReleaseTreeViewer(composite, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(treeViewer);
		
		treeViewer.setInput(release);
		treeViewer.expandAll();
		setControl(composite);
	}

}
