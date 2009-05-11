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
			if (version.getProjectState() != null && version(version) >= 1300) {
				for (ModelElement modelElement : version.getProjectState().getAllModelElements()) {
					if (modelElement instanceof UseCase) {
						Iterator<UseCase> iterator = ((UseCase) modelElement).getIncludedUseCases().iterator();
						HashSet<String> result = new HashSet<String>();
						while (iterator.hasNext()) {
							UseCase useCase = iterator.next();
							if (!result.contains(useCase.getIdentifier())) {
								result.add(useCase.getIdentifier());
							} else {
								iterator.remove();
							}
						}
					}

				}
				save(version.getProjectState());
			}
		}
	}

	@Override
	String getFixName() {
		return "Duplicate Attribute fix";
	}

}
