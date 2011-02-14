package org.unicase.bowlingexample.navigatorcustomization;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.common.dnd.MEDropAdapter;

import bowling.BowlingPackage;
import bowling.Playerlist;
import bowling.Tournament;

public class MEDropAdaptorTournament extends MEDropAdapter {

	@Override
	public EClass isDropAdapterfor() {
		// TODO Auto-generated method stub
		return BowlingPackage.eINSTANCE.getTournament();
	}

	public void drop(DropTargetEvent event, EObject target, List<EObject> source){
		if(source.get(0) instanceof Playerlist | target instanceof Tournament){
			Playerlist playerlist = (Playerlist) source.get(0);
			((Tournament) target).setPlayerlist(playerlist);
		}
	}
}
