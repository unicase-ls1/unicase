package org.unicase.workspace.exceptions;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

public class ChangeConflictException extends WorkspaceException {
	public List<ChangePackage> newPackages;
	
	public ChangeConflictException(List<ChangePackage> newPackages) {
		super("Conflict detected on update");
		this.newPackages = newPackages;
	}
}
