package org.unicase.model.testspec.ui.editor.tablecontrol;

import java.util.Comparator;
import java.util.Date;

import org.unicase.model.testspec.TestStep;

public class StepComparator implements Comparator{

	public int compare(Object step0, Object step1) {
		
		if(step0 instanceof TestStep && step1 instanceof TestStep){
			Date stepDate0 = ((TestStep) step0).getCreationDate();
			Date stepDate1 = ((TestStep) step1).getCreationDate();
		
		
			if (stepDate0.before(stepDate1)){
			return 1;
			}

			else if (stepDate1.before(stepDate0))
				return -1;
		
			else
				return 0;
			}
		else
		return 0;
	}

}
