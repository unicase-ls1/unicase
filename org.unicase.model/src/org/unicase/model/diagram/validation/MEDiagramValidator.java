/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.diagram.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramType;

/*
 * A sample validator interface for {@link org.unicase.model.diagram.MEDiagram}. This doesn't really do anything, and
 * it's not a real EMF artifact. It was generated by the org.eclipse.emf.examples.generator.validator plug-in to
 * illustrate how EMF's code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MEDiagramValidator {
	boolean validate();

	boolean validateElements(EList<ModelElement> value);

	boolean validateGmfdiagram(Diagram value);

	boolean validateNewElements(EList<ModelElement> value);

	boolean validateType(DiagramType value);

	boolean validateDiagramLayout(String value);
}
