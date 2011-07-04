package org.eclipse.emf.ecp.compare.history.handler;

import java.util.Calendar;

import org.eclipse.compare.CompareUI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.ICompare;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.exceptions.InvalidCompareException;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.exceptions.NoComparisonException;

public class EMFCompareComparator implements ICompare{

	private ComparisonResourceSnapshot snapshot;

	public void compare(EObject e1, EObject e2) throws InvalidCompareException {
		try {

			ProjectSpace p1 = (ProjectSpace) e1;
			ProjectSpace p2 = (ProjectSpace) e2;

			MatchModel match = MatchService.doContentMatch(p1, p2, null);
			DiffModel diff = DiffService.doDiff(match, false);
			snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();
			snapshot.setDate(Calendar.getInstance().getTime());
			snapshot.setMatch(match);
			snapshot.setDiff(diff);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void display() throws NoComparisonException {
		CompareUI.openCompareEditor(new ModelCompareEditorInput(snapshot), true);		
	}

}