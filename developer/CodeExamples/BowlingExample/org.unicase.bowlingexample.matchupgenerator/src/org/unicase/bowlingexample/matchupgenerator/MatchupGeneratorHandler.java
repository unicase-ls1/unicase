package org.unicase.bowlingexample.matchupgenerator;

import javax.swing.JOptionPane;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.navigator.TreeView;

import bowling.BowlingFactory;
import bowling.Matchup;
import bowling.Tournament;

public class MatchupGeneratorHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get EObject
		EObject eObject = ActionHelper.getSelection(event);
		if (!(eObject instanceof Tournament)) {
			return null;
		}
		// cast
		final Tournament t = (Tournament) eObject;
		// check playerlist
		if (t.getPlayerlist() == null) {
			JOptionPane.showMessageDialog(null, "No playerlist available.",
					"Generate Matchups", JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		// check existing matchups
		if (!t.getMatchup().isEmpty()) {
			// ask user if matchups shall be deleted
			int userInput = JOptionPane.showConfirmDialog(null, "Do you really want to delete all existent matchups and create new ones?",
					"Generate Matchups", JOptionPane.YES_NO_OPTION);
			if (userInput == JOptionPane.NO_OPTION) {
				return null;
			}
		}
		// implement - which command?
		t.getMatchup().clear();
		Matchup m = BowlingFactory.eINSTANCE.createMatchup();
		m.setTournament(t);		
		
		TreeView.getTreeViewer().refresh();
		return null;
	}

}
