package org.unicase.exportwp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.Annotation;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class CreateBBCodeFormatString {
	
	static File file;
	static FileWriter fstream;
	static BufferedWriter outt;
	static boolean firstChild = true;
	static String string;
	
	
	public static String createString(WorkPackage workpackage) {
		string = "";
		try {
			// Create file
			
			
			writeHead(workpackage);
			
			writeWorkPackage(workpackage, false);
			
			if (!firstChild){
				string = string + "\n";
				string = string +("    [/list]");
				string = string + "\n";
			}

			
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		return string;
	}
	
	public static void writeHead( WorkPackage workPackage)
	throws IOException {
		string = string +("[i][size=150]Chair for Applied Software Engineering [/size][/i]");
		string = string + "\n";
		string = string + "\n";
string = string +("[color=#008000][size=125] WorkPackage Name: "
		+ workPackage.getName() + "[/size][/color]");
string = string + "\n";
string = string + "\n";
}

	private static void writeWorkPackage(WorkPackage workPackage, boolean child) throws IOException {
		
		if (child){
			string = string +("  [*] [b]" + workPackage.getName() + "[/b]");
			string = string + "\n";
		}
		
		if (workPackage.getAssignee() != null)
			string = string +("		[b]Asignee[/b]: "
					+ workPackage.getAssignee().getName());
		else
			string = string +("		[b]Asignee[/b]: " + "<not defined>");
		string = string + "\n";
		if (workPackage.getDueDate() != null)
			string = string +("		[b]Deadline[/b]: "
					+ workPackage.getDueDate().getDay() + "."
					+ workPackage.getDueDate().getMonth());
		else
			string = string +("		[b]Deadline[/b]: " + "<not defined>");
		string = string + "\n";

		if (workPackage.getState() != null)
			string = string +("		[b]Status[/b]: " + workPackage.getState());
		else
			string = string +("		[b]Status[/b]: " + "<not defined>" + ", ");
		string = string + "\n";
		if (workPackage.getDescription() !=null)
		string = string +("		[b]Description[/b]: [i]" + workPackage.getDescription()
				+ "[/i]");
		string = string + "\n";
		string = string + "\n";
		
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();

		if (workItems != null && workItems.size() > 0)
		{
			for (WorkItem wi : workItems) {
				if (wi instanceof WorkPackage && workItems.get(0).equals(wi)){
					string=string+("  [list=1]");
					string = string + "\n";
					writeWorkPackage ((WorkPackage) wi, true);
				}
				else if (wi instanceof WorkPackage) {
					writeWorkPackage ((WorkPackage) wi, true);
				}
				else if(wi instanceof ActionItem && workItems.get(0).equals(wi)){
					string=string+("  [list=1]");
					string = string + "\n";
					writeActionItem((ActionItem) wi);
				}
				else if (wi instanceof ActionItem && !workItems.get(0).equals(wi)){
					writeActionItem((ActionItem) wi);
				}
			}
			string=string+("    [/list]");
			string = string + "\n";
			string = string + "\n";
		}
		
		}
	
	private static void writeActionItem(ActionItem ai) throws IOException {
		string = string + "\n";
		string = string + ("      [*] [b]Name[/b]: " + ai.getName());
		string = string + "\n";
		if (ai.getAssignee() != null)
			string = string + ("[b]Asignee[/b]: "
					+ ai.getAssignee().getName());
		else
			string = string + ("[b]Asignee[/b]: " + "<not defined>");
		string = string + "\n";
		if (ai.getDueDate() != null)
			string = string + ("[b]Deadline[/b]: "
					+ ai.getDueDate().getDay() + "."
					+ ai.getDueDate().getMonth());
		else
			string = string + ("[b]Deadline[/b]: " + "<not defined>");
		string = string + "\n";

		if (ai.getState() != null)
			string = string + ("[b]Status[/b]: " + ai.getState());
		else
			string = string + ("[b]Status[/b]: " + "<not defined>" + ", ");
		string = string + "\n";
		if (ai.getDescription() != null && ai.getDescription() != ""){
		string = string + ("         [i]" + ai.getDescription()
				+ "[/i]");
		string = string + "\n";}
		
	}

}
