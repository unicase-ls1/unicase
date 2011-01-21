package org.unicase.changetracking.ui.createChangePackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egit.ui.internal.EgitUiEditorUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.SayYesCredentialsProvider;
import org.unicase.changetracking.git.Test;
import org.unicase.changetracking.git.commands.GitCreateChangePackageCommand;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

public class CreateChangePackageOperation implements IRunnableWithProgress{

	private Repository localRepo;
	private UnicaseModelElement workItem;
	private GitRepository remoteRepo;
	private Project project;
	private String name;
	private String shortDescription;
	private String longDescription;
	private boolean wantCreateWorkItem;

	public CreateChangePackageOperation(Repository localRepository,
			UnicaseModelElement selectedWorkItem, Project selectedProject,
			GitRepository selectedRepository, String selectedName,
			String selectedShortDescription, String selectedLongDescription,
			boolean wantCreateWorkItem) {
		this.localRepo = localRepository;
		this.workItem = selectedWorkItem;
		this.remoteRepo = selectedRepository;
		this.project = selectedProject;
		this.name = selectedName;
		this.shortDescription = selectedShortDescription;
		this.longDescription = selectedLongDescription;
		this.wantCreateWorkItem = wantCreateWorkItem;
	}
	


	@Override
	public void run(IProgressMonitor monitor) {
		
			
		//Retrieve or create selected model element from the dialog
		if(wantCreateWorkItem){
			workItem.setName("new " + workItem.eClass().getName());
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					project.addModelElement(workItem);
				}
			};
		}
		try{
			new GitCreateChangePackageCommand(localRepo, (WorkItem) workItem, remoteRepo, name, shortDescription, longDescription, Test.getTestCredentials() ).run(monitor);
		} catch (Throwable t){
			ModelUtil.logException(t);
			return;
		}
		
		UIUtil.openInformation("Success!",
				"Change package was created successfully.");
		monitor.done();
	}

}
