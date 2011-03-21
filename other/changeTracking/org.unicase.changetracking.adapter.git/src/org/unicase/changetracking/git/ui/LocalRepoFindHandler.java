package org.unicase.changetracking.git.ui;

import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.ui.AdvancedMessageDialog;
import org.unicase.changetracking.ui.AdvancedMessageDialog.NoLocalRepoChoices;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;
import org.unicase.model.changetracking.git.GitRepository;

public class LocalRepoFindHandler {

	private ChangeTrackingRelease release;

	public LocalRepoFindHandler(ChangeTrackingRelease release){
		this.release = release;
	}
	
	public Repository find() throws CancelledByUserException{
		Stream stream = release.getStream();
		if(stream == null){
			return null;
		}
		
		RepositoryStream repoStream = stream.getRepositoryStream();
		if(repoStream == null){
			return null;
		}
		
		RepositoryLocation location = repoStream.getLocation();
		if(location == null){
			return null;
		}
		if(!(location instanceof GitRepository)){
			return null;
		}
		
		
		Repository repo = GitRepoFindUtil.findAssociatedLocalRepo((GitRepository) location);
		if(repo == null){
			NoLocalRepoChoices userChoice = AdvancedMessageDialog.openNoLocalRepoFoundDialog(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell());
			switch(userChoice){
			case CANCEL:
				throw new CancelledByUserException();
			case CLONE:
				UIUtil.handleException(new Exception("Cloning is not yet supported"));
				//FIXME: Implement cloning
				return null;
			case OPEN:
				return chooseRepoLocation();
			}
		}
		
		return repo;
	
	}

	private Repository chooseRepoLocation() {
		FileDialog fd = new FileDialog(PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell(), SWT.OPEN);
        fd.setText("Choose .git location");
        String[] filterExt = { ".git" };
        fd.setFilterExtensions(filterExt);
 
        String selected = fd.open();
        if(selected != null){
        	try {
				return new FileRepository(selected);
			} catch (IOException e) {
				ModelUtil.logException(e);
				return null;
			}
        } else {
        	return null;
        }
	}
}
