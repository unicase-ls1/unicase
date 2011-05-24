package org.unicase.changetracking.test.cases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.unicase.changetracking.git.common.GitCloneOperation;
import org.unicase.changetracking.test.GitTestCase;


public class CloneTest extends GitTestCase{

	@Test
	public void test() throws IOException{
		deleteAll();
		GitCloneOperation op = new GitCloneOperation(getRemoteURI(), true, null, getWorkingCopyDir() , "refs/heads/1", "origin", 0, getCredentialsProvider());
		try {
			op.run(getProgressMonitor());
		} catch (InvocationTargetException e) {
			error(e);
		} catch (InterruptedException e) {
			error(e);
		}
		assertEquals("1",getLocalRepo().getBranch());
		
	}
}
