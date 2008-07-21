package org.unicase.emfstore.storage;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;

public class SkipValidationValidator extends EObjectValidator
{
	/** 
	* Overrides the method from the superclass to prevent this check because it
 	* is not required in the context of a hibernate store. Note that this assumes that 
 	* an object and its references are all stored in the same hibernate database. 
 	*/
	public boolean validate_EveryReferenceIsContained(EObject eObject, DiagnosticChain diagnostics, Map context) 
	{
		return true;
	}
}

