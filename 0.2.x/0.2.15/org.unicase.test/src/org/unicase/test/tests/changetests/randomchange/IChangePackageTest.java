package org.unicase.test.tests.changetests.randomchange;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;


public interface IChangePackageTest {

	
	public int getExpectedNumOfChanges();
	public boolean isSuccessful();
	public ChangePackage getChangePackage();
	
}
