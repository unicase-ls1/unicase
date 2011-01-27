package org.unicase.bowlingexample.matchupgenerator;

import javax.swing.JOptionPane;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.navigator.TreeView;

import bowling.BowlingFactory;
import bowling.Game;
import bowling.Matchup;
import bowling.Player;
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
		final EList<Player> playerlist = t.getPlayerlist().getPlayer();
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
		//t.getMatchup().clear();
		for (int i=0; i<playerlist.size(); i++) {
			for (int j=i+1; j<playerlist.size(); j++) {
				Player p1 = playerlist.get(i);
				Player p2 = playerlist.get(j);
				Game g1 = BowlingFactory.eINSTANCE.createGame();
				Game g2 = BowlingFactory.eINSTANCE.createGame();
				g1.setPlayer(p1);
				g2.setPlayer(p2);
				Matchup m = BowlingFactory.eINSTANCE.createMatchup();
				g1.setMatchup(m);
				g2.setMatchup(m);
				m.setTournament(t);				
			}
		}
		
		TreeView.getTreeViewer().refresh();
		return null;
	}

}
