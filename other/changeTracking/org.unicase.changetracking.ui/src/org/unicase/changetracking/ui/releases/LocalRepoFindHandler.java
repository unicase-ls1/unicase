package org.unicase.changetracking.ui.releases;

import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.ui.NoLocalRepoFoundDialog;
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
	
	public Repository find(){
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
			int userChoice = NoLocalRepoFoundDialog.openNoLocalRepoFoundDialog(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell());
			switch(userChoice){
			case NoLocalRepoFoundDialog.CHOICE_CANCEL:
				return null;
			case NoLocalRepoFoundDialog.CHOICE_CLONE:
				//FIXME: Implement cloning
				return null;
			case NoLocalRepoFoundDialog.CHOICE_OPEN:
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
