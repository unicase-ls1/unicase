package org.eclipse.bowlingmodel.navigatorcustomisation;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.common.dnd.MEDropAdapter;

import bowling.BowlingPackage;
import bowling.Game;
import bowling.Player;






public class MEDropAdaptorGame extends MEDropAdapter{

	public MEDropAdaptorGame(){
		
	}
	
	@Override
	public EClass isDropAdapterfor() {
		// TODO Auto-generated method stub
		return BowlingPackage.eINSTANCE.getGame();
	}

	public void drop(DropTargetEvent event, EObject target, List<EObject> source){
		if(source.get(0) instanceof Player | target instanceof Game){
		   Player player = (Player)source.get(0);
			((Game)target).setPlayer(player);
		
		}
	}
}
