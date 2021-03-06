package org.unicase.bowlingexample.navigatorcustomization;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.common.dnd.MEDropAdapter;

import bowling.BowlingPackage;
import bowling.Game;
import bowling.Player;

public class MEDropAdaptorPlayer extends MEDropAdapter {

	@Override
	public EClass isDropAdapterfor() {
		return BowlingPackage.eINSTANCE.getPlayer();
	}
	
	public void drop(DropTargetEvent event, EObject target, List<EObject> source){
		if(source.get(0) instanceof Game && target instanceof Player){
			((Game)source.get(0)).setPlayer((Player)target);
		}
	}

}
