package org.unicase.emfstore.fixes;

import java.util.HashSet;
import java.util.Iterator;

import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.UseCase;

public class DuplicateUseCaseFix extends AbstractFix {

	//
	// !!!! REWRITE AFTER REMODELING OF STEPIMPL
	//

	@Override
	void fix() {
		for (Version version : projectHistory.getVersions()) {
			if (version.getProjectState() != null) {
				for (ModelElement modelElement : version.getProjectState().getAllModelElements()) {
					if (modelElement instanceof UseCase) {
						Iterator<UseCase> iterator = ((UseCase) modelElement).getIncludedUseCases().iterator();
						HashSet<String> ids = new HashSet<String>();
						while (iterator.hasNext()) {
							UseCase useCase = iterator.next();
							if (ids.contains(useCase.getIdentifier())) {
								iterator.remove();
								System.out.println("deleted use case in version "
									+ version.getPrimarySpec().getIdentifier() + " : " + useCase.getName());
							} else {
								ids.add(useCase.getIdentifier());
							}
						}
					}

				}
				save(version);
			}
		}
	}

	@Override
	String getFixName() {
		return "Duplicate Attribute fix";
	}

}
