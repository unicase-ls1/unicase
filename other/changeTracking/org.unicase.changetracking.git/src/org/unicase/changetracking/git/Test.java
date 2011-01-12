package org.unicase.changetracking.git;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.egit.core.EclipseGitProgressTransformer;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;

public class Test {

	public static void main(String[] args) {
		Repository r = GitRepoFindUtil.findRepository(new File(
						"E:\\Programming\\unicase\\runtime-EclipseApplication\\GitTest"
						//"E:\\Programming\\unicase\\repos\\egit"
						));
		blub(r);
	}
	
	public static void gitPullTest(){
	
	}

	public static void blub(Repository repo) {
		
		GitUtil.getIdentifyingCommitHash(repo);
		
		if(true)
			return;
		
		
		Map<String, Ref> refs = repo.getAllRefs();
		for(Entry<String, Ref> e : refs.entrySet()){
			System.out.println(e.getKey());
			e.getValue();
			
		}
		GitRepository gitRepo = GitFactory.eINSTANCE.createGitRepository();
		gitRepo.setUrl("https://gexicide@github.com/gexicide/testor.git");
		GitRemoteUrlHandler remoteHandler = new GitRemoteUrlHandler(gitRepo, repo);
		
		
		try {
			Shell s = new Shell();
			ProgressMonitorDialog d = new ProgressMonitorDialog(s);
			d.open();
			new Git(repo).push().setRefSpecs(new RefSpec("FoobarBranch")).setRemote(remoteHandler.buildRemoteString()).setProgressMonitor(new EclipseGitProgressTransformer(d.getProgressMonitor())).call();
			s.dispose();
			
		} catch (JGitInternalException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (InvalidRemoteException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		Set<String> sections = repo.getConfig().getSections();
		Set<String> sd = repo.getConfig().getSubsections("branch");
		Set<String> asd = repo.getConfig().getNames("branch", sd.iterator().next());
		RevWalk rw = new RevWalk(repo);
		MutableObjectId mo = GitUtil.stringToObjectId("88fb303a316bab708da45f7864ae1176cb2e36fa");
		RevCommit commit = null;
		try {
			commit = rw.parseCommit(mo);

		} catch (MissingObjectException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IncorrectObjectTypeException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	
		//new GitTeamAdapter().bla(repo, startPoint, branchName)
		System.out.println("Blub");
		Git g = new Git(repo);
		List<Ref> l = g.branchList().call();
		// g.merge().setStrategy(MergeStrategy.)
		
		for (Ref r : l) {
			System.out.println(r.getName());
			System.out.println(r.getLeaf().getName());
			System.out.println(r.getObjectId());
			System.out.println(r.getPeeledObjectId());
		}
		try {		
			try {
				g.checkout().setName("FoobarBranch").call();
			} catch (RefAlreadyExistsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RefNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidRefNameException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//	GitUtil.checkoutCommit(repo,commit);
		} catch (JGitInternalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();

	}
}
