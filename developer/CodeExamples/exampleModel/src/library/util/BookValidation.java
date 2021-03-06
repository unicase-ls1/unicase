package library.util;

import library.Book;
import library.LibraryPackage;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

public class BookValidation extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();

		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {

			if (eObj instanceof Book) {
				Book book = (Book) eObj;
				if (book.getTitle() == null || book.getTitle().equals("")) {
					ctx.addResult(LibraryPackage.eINSTANCE.getBook_Title());
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() });
				}
			}

		}

		return ctx.createSuccessStatus();

	}

}
