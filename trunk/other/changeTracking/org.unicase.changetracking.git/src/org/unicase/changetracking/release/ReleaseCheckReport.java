package org.unicase.changetracking.release;

import java.util.List;
import java.util.Set;

import org.unicase.model.changetracking.ChangePackage;

public class ReleaseCheckReport {


	private final List<String> errorMessages;	
	private final List<ChangePackage> changePackages;
	private final Set<ChangePackage> appliedChangePackages = null;

	ReleaseCheckReport(List<ChangePackage> changePackages,
			List<String> errorMessages, boolean checkedOut) {
		this.errorMessages = errorMessages;
		this.changePackages = changePackages;
	}



}
