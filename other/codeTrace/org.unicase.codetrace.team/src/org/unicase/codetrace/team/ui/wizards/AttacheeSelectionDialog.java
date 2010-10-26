package org.unicase.codetrace.team.ui.wizards;

import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.ECPModelelementContext;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;
import org.unicase.ui.navigator.WorkspaceManager;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.eclipse.emf.ecore.EObject;

public class AttacheeSelectionDialog extends ModelElementSelectionDialog{

	public AttacheeSelectionDialog(Project root) {
		super(false);
		EList<UnicaseModelElement> e = root.getAllModelElementsbyClass(ModelPackage.Literals.UNICASE_MODEL_ELEMENT,new BasicEList<UnicaseModelElement>());
		BasicEList<EObject> el = new BasicEList<EObject>();
		for(UnicaseModelElement elem: e){
			el.add(elem);
		}
		
		setModelElements(el);
	}

	
}
