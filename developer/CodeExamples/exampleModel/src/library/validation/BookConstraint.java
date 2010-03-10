package library.validation;

import library.Book;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.metamodel.provider.ValidationConstraintHelper;

public class BookConstraint extends AbstractModelConstraint {

	

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Book) {
				Book book = (Book) eObj;
				if (book.getTitle()==null||book.getTitle().equals("")) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						book, "title");
					ctx.addResult(errorFeature);

					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ book.getTitle() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}