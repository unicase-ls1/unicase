package org.unicase.changetracking.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.git.common.SayYesCredentialsProvider;

public abstract class GitTestCase extends TestCase{
	
	private static final String PASS = "git2day";
	private static final String USER = "gexicide";
	private File workingCopyDir;
	private File gitDir;

	protected GitTestCase(){
		workingCopyDir = new File("./test/git");
		gitDir = new File(workingCopyDir,".git");
	}
	
	protected CredentialsProvider getCredentialsProvider(){
		return new SayYesCredentialsProvider(USER, PASS);
	}
	
	protected File getWorkingCopyDir(){
		return workingCopyDir;
	}
	
	protected File getGitDir(){
		return gitDir;
	}
	
	private void deleteRecursive(File f, boolean deleteSelf){
		if(f.isDirectory()){
			for(File f2 : f.listFiles()){
				deleteRecursive(f2,true);
			}	
		}
		if(deleteSelf){
			if(!f.delete()){
				throw new UnexpectedException("Could not delete " + f.getAbsolutePath());
			}
		}
		
	}
	
	protected URIish getRemoteURI(){
		try {
			return new URIish("https://github.com/gexicide/testor.git")/*.setUser(USER).setPass(PASS)*/;
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void deleteAll(){
		deleteRecursive(workingCopyDir,false);
	}
	
	protected IProgressMonitor getProgressMonitor(){
//		ProgressMonitorDialog dialog = new ProgressMonitorDialog(new Shell());
//		dialog.open();
//		return dialog.getProgressMonitor();
		return new ConsoleProgressMonitor();
	}

	private class UnexpectedException extends RuntimeException{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public UnexpectedException(Throwable t) {
			super(t);
		}

		public UnexpectedException(String string) {
			super(string);
		}
		
	}
	protected void error(Throwable t){
		throw new UnexpectedException(t);
	}
	
	protected Repository getLocalRepo(){
		try {
			return new FileRepository(gitDir);
		} catch (IOException e) {
			throw new UnexpectedException(e);
		}
	}
	
	protected FileRepository createLocalRepo(boolean bare) throws IOException {
		deleteAll();
		FileRepository db = new FileRepository(gitDir);

		assertFalse(gitDir.exists());
		db.create();
		assertTrue(gitDir.exists());
		return db;
	}
	
	
	protected void write(final File f, final String body) throws IOException {
		f.getParentFile().mkdirs();
		Writer w = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
		try {
			w.write(body);
		} finally {
			w.close();
		}
	}
	
	protected void writeTestFile(String name, String body){
		try {
			write(new File(workingCopyDir,name),body);
		} catch (IOException e) {
			error(e);
		}
	}
}
