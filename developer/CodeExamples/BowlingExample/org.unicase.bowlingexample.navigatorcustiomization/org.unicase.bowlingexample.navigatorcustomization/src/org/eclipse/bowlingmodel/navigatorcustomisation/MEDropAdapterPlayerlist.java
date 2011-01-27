package org.eclipse.bowlingmodel.navigatorcustomisation;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.ui.common.dnd.MEDropAdapter;

import bowling.BowlingPackage;
import bowling.Playerlist;
import bowling.Tournament;

public class MEDropAdapterPlayerlist extends MEDropAdapter {

	@Override
	public EClass isDropAdapterfor() {
		// TODO Auto-generated method stub
		return BowlingPackage.eINSTANCE.getPlayerlist();
	}

	public void drop(DropTargetEvent event, EObject target, List<EObject> source){
		if(source.get(0) instanceof Tournament | target instanceof Playerlist){
			
		}
			
	}
}
