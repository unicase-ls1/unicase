package org.unicase.changetracking.test.cases;

import java.io.IOException;

import org.junit.Test;
import org.unicase.changetracking.git.common.GitCloneOperation;
import org.unicase.changetracking.test.GitTestCase;


public class CloneTest extends GitTestCase{

	@Test
	public void test() throws IOException{
		deleteAll();
		GitCloneOperation op = new GitCloneOperation(getRemoteURI(), true, null, getWorkingCopyDir() , "refs/heads/1", "origin", 0, getCredentialsProvider());
		
		op.run(getProgressMonitor());
	
		assertEquals("1",getLocalRepo().getBranch());
		
	}
}
