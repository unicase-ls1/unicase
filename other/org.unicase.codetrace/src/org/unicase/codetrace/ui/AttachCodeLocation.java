package org.unicase.codetrace.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.provider.ShortLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class AttachCodeLocation {
	
	
	private static Project getActiveProject(){
		final ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		if(ps.getProject()!= null){
			return ps.getProject();
		}else{
			System.out.println("Project was not found!");
			return null;
		}
		
		
	}
	
public static void showUserDialog(){
		
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		ChooseModelElementDialog cmed = new ChooseModelElementDialog(getActiveProject(),"Choose Model Element for code location!");
		if(cmed.open() == Window.OK){
			Object[] result = cmed.getResult();
			
			if(result.length > 0){
				//If users/groups were selected, flatten them and add them to the selected users.
				//Afterwards update the user interface
				List<ModelElement> list = new ArrayList<ModelElement>(result.length);
				for(Object o: result){
					if(o instanceof ModelElement){
						list.add((ModelElement) o);
					}
				}
			//	list.addAll(selected);
			//	selected = MultiActionGenerator.flattenOrgList(list);
			//	updateUI();
			}
		}
	
}
}
