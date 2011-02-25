/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.AnalyzerFactory;
import org.unicase.analyzer.AnalyzerModelController;
import org.unicase.analyzer.AnalyzerPackage;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author liya
 */
public class ProjectAnalyzerWizard extends Wizard implements IWorkbenchWizard {

	private static final String PATH = Configuration.getPluginDataBaseDirectory() + "analyzerProfile.conf";
	private static final String DOMAIN_ID = "org.unicase.EditingDomain";
	private TransactionalEditingDomain domain;
	private Resource resource;
	private boolean canFinish;
	private boolean loggedIn;
	private IteratorPage iteratorPage;
	private ExporterPage exporterPage;
	private AnalyzerPage analyzerPage;
	private VersionIteratorPage versionIteratorPage;
	private TimeIteratorPage timeIteratorPage;

	private VersionIterator versionIterator;
	private ArrayList<DataAnalyzer> analyzers;
	private AnalyzerConfiguration analyzerConfig;
	private Usersession selectedUsersession;
	private ProjectId selectedProjectID;
	private LoadPage loadPage;
	private ProjectSpace selectedProject;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (analyzers == null) {
			if (ProjectAnalyzerWizardHelper.isTextNonEmpty(loadPage.getConfigurationPath())) {
				loadPage.initConfig(loadPage.getConfigurationPath().getText());
			} else {
				loadPage.initConfig(LoadPage.DEFAULT_PATH);
			}

			analyzers = new ArrayList<DataAnalyzer>();
			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = registry.getExtensionPoint("org.unicase.analyzer.analyzer");
			IExtension[] extensions = extensionPoint.getExtensions();

			boolean notExisting = false;
			// For each extension ...
			for (int i = 0; i < extensions.length; i++) {
				IExtension extension = extensions[i];
				IConfigurationElement[] elements = extension.getConfigurationElements();
				// For each member of the extension ...
				for (int j = 0; j < elements.length; j++) {
					final IConfigurationElement element = elements[j];
					for (String name : analyzerConfig.getAnalyzerNames()) {
						if (name.equals(element.getAttribute("class"))) {
							try {
								analyzers.add((DataAnalyzer) element.createExecutableExtension("class"));
							} catch (CoreException e) {
								WorkspaceUtil.logException("Problems occur when creating the analyzer!", e);
							}
						} else {
							notExisting = true;
						}
					}
				}
			}
			if (notExisting) {
				MessageDialog
					.openWarning(
						Display.getCurrent().getActiveShell(),
						"",
						"Some of the analyers does not exist. You analysis result might not be complete. Please check the .conf file and the extended cliend analyzers again!");
			}
		}

		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					analyzerConfig.getIterator().init(selectedUsersession);
					((CSVExporter) analyzerConfig.getExporter()).init();
					setMoniter();
				} catch (IteratorException e) {
					WorkspaceUtil.logException("Problems occur when creating the iterator!", e);
				} catch (IOException e) {
					WorkspaceUtil.logException("Problems occur when creating the exporter!", e);
				}
			}
		});
		try {
			analyzerConfig.eResource().save(null);
		} catch (IOException e) {
			WorkspaceUtil.log("Could not save the resource!", e, IStatus.WARNING);
		}
		return true;
	}

	private void setMoniter() {
		setNeedsProgressMonitor(true);
		try {
			getContainer().run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					AnalyzerModelController analyzerController = new AnalyzerModelController(analyzerConfig
						.getIterator(), analyzers, analyzerConfig.getExporter());
					analyzerController.setMonitor(monitor);
					int totalSteps = analyzerConfig.getIterator().getTotalSteps();
					monitor.beginTask("Analyzing...", totalSteps);
					try {
						analyzerController.runAnalysis(analyzerConfig.getExporter());

					} catch (IOException e) {
						WorkspaceUtil.logException("Analysis is encountering problems!", e);
					}
					System.out.println("Finished Analysis");

					monitor.done();
				}
			});
		} catch (InvocationTargetException e) {
			WorkspaceUtil.logException("Problems occur when setting the progress moniter!", e);
		} catch (InterruptedException e) {
			WorkspaceUtil.logException("Problems occur when setting the progress moniter!", e);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {

		Object firstElement;
		if (!selection.isEmpty()) {
			firstElement = selection.getFirstElement();
			if (firstElement instanceof ProjectSpace) {
				selectedProject = (ProjectSpace) firstElement;
				selectedProjectID = (ProjectId) EcoreUtil.copy(selectedProject.getProjectId());
				selectedUsersession = ((ProjectSpace) firstElement).getUsersession();
				if (!selectedUsersession.isLoggedIn()) {
					loggedIn = false;
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Login required", "Log in first!");
				} else {
					loggedIn = true;
				}
			} else {
				throw new IllegalArgumentException("No Project selected!");
			}
		} else {
			throw new IllegalArgumentException("Nothing selected!");
		}
		setCanFinish(false);
		// analyzerConfig = AnalyzerFactory.eINSTANCE.createAnalyzerConfiguration();
		// initConfig();
	}

	@SuppressWarnings("unused")
	private void initConfig() {

		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(DOMAIN_ID);

		URI fileURI = URI.createFileURI(PATH);
		File analyzerFile = new File(PATH);

		AnalyzerPackage analyzePackage = AnalyzerPackage.eINSTANCE;

		if (!analyzerFile.exists()) {

			resource = domain.getResourceSet().createResource(fileURI);
			analyzerConfig = AnalyzerFactory.eINSTANCE.createAnalyzerConfiguration();
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					resource.getContents().add(analyzerConfig);
				}
			});
		} else {

			resource = domain.getResourceSet().getResource(fileURI, true);
			EList<EObject> directContents = resource.getContents();
			// MK cast
			analyzerConfig = (AnalyzerConfiguration) directContents.get(0);
			canFinish = true;
		}
		// }
		// });
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {

		loadPage = new LoadPage("LoadPage");
		addPage(loadPage);
		analyzerPage = new AnalyzerPage("AnalyzerPage");
		addPage(analyzerPage);
		iteratorPage = new IteratorPage("IteratorPage");
		addPage(iteratorPage);
		versionIteratorPage = new VersionIteratorPage("");
		addPage(versionIteratorPage);
		timeIteratorPage = new TimeIteratorPage("");
		addPage(timeIteratorPage);
		exporterPage = new ExporterPage("ExporterPage");
		addPage(exporterPage);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return canFinish;
	}

	/**
	 * @param canFinish the canFinish to set
	 */
	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * @return the versionIteratorPage
	 */
	public VersionIteratorPage getVersionIteratorPage() {
		return versionIteratorPage;
	}

	/**
	 * @return the timeIteratorPage
	 */
	public TimeIteratorPage getTimeIteratorPage() {
		return timeIteratorPage;
	}

	/**
	 * @return the iteratorPage
	 */
	public IteratorPage getIteratorPage() {
		return iteratorPage;
	}

	/**
	 * @return the exporterPage
	 */
	public ExporterPage getExporterPage() {
		return exporterPage;
	}

	/**
	 * @return the analyzerPage
	 */
	public AnalyzerPage getAnalyzerPage() {
		return analyzerPage;
	}

	/**
	 * @return the versionIterator
	 */
	public VersionIterator getVersionIterator() {
		return versionIterator;
	}

	/**
	 * @param versionIterator the versionIterator to set
	 */
	public void setVersionIterator(VersionIterator versionIterator) {
		this.versionIterator = versionIterator;
	}

	/**
	 * @return the analyzerConfig
	 */
	public AnalyzerConfiguration getAnalyzerConfig() {
		return analyzerConfig;
	}

	/**
	 * @param analyzerConfig the analyzerConfig to set
	 */
	public void setAnalyzerConfig(AnalyzerConfiguration analyzerConfig) {
		this.analyzerConfig = analyzerConfig;
	}

	/**
	 * @return the analyzers
	 */
	public ArrayList<DataAnalyzer> getAnalyzers() {
		return analyzers;
	}

	/**
	 * @param analyzers the analyzers to set
	 */
	public void setAnalyzers(ArrayList<DataAnalyzer> analyzers) {
		this.analyzers = analyzers;
	}

	/**
	 * @return the selectedProjectID
	 */
	public ProjectId getSelectedProjectID() {
		return selectedProjectID;
	}

	/**
	 * @param selectedProjectID the selectedProjectID to set
	 */
	public void setSelectedProjectID(ProjectId selectedProjectID) {
		this.selectedProjectID = selectedProjectID;
	}

	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * @param resource the resource to set
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * @return the domain
	 */
	public TransactionalEditingDomain getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(TransactionalEditingDomain domain) {
		this.domain = domain;
	}

	/**
	 * @return the selectedProject
	 */
	public ProjectSpace getSelectedProject() {
		return selectedProject;
	}

	/**
	 * @param selectedProject the selectedProject to set
	 */
	public void setSelectedProject(ProjectSpace selectedProject) {
		this.selectedProject = selectedProject;
	}

}