package org.unicase.exportwp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class CreateBBCodeTableFormat {
	static File file;
	static FileWriter fstream;
	static BufferedWriter out;
	static String whiteSpace = "";


	/**
	 * Creates the file.
	 * @param workpackage
	 * @param fileUrl
	 */
	public static void createFile(WorkPackage workpackage, String fileUrl) {
		try {
			// Create file
			file = new File(fileUrl);
			fstream = new FileWriter(file);
			out = new BufferedWriter(fstream);
			
			out.write("[table=1]");
			out.newLine();
			
			writeTabelHeader ();
			writeWorkPackage(workpackage);
			out.write("[/table]");
out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			
		}
	}



	private static void writeTabelHeader() throws IOException {
		out.newLine();
		out.write("[tr][td][color=#008000][b]WorkItem[/b][/color][/td][td][color=#008000][b]State[/b][/color][/td][td][color=#008000][b]Assigned to[/b][/color][/td][td][color=#008000][b]Priority[/b][/color][/td][td][color=#008000][b]Estimate[/b][/color][/td][td][color=#008000][b]Effort[/b][/color][/td][/tr]");	
		
	}

	/**
	 * @param workPackage
	 * @param child
	 * @throws IOException
	 */
	private static void writeWorkPackage(WorkPackage workPackage) throws IOException {

whiteSpace = "";
		
		int level=0;
			WorkPackage wpAuxiliar;
			wpAuxiliar=workPackage;
			while (wpAuxiliar.getContainingWorkpackage() != null){
				level++;
				wpAuxiliar=wpAuxiliar.getContainingWorkpackage();
			}
			
			for (int i = 0; i<level;i++){
				whiteSpace = whiteSpace + "--";
			}
			
			out.write("[tr][td][b]"+whiteSpace+"> WP "+workPackage.getName()+"[/b][/td]");
			

			if (workPackage.getState() != null)
				out.write("[td]"+workPackage.getState()+"[/td]");
			else
				out.write("[td]<not defined>[/td]");
				
		if (workPackage.getAssignee() != null)
			out.write("[td]"+workPackage.getAssignee().getName()+"[/td]");
		else
			out.write("[td]<not defined>[/td]");
			
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		int nrWorkItems = 0;
		
		out.write("[td]"+workPackage.getPriority()+"[/td]");
		out.write("[td]"+getEstimate(workPackage)+"[/td]");
		out.write("[td]"+getEffort(workPackage)+"[/td][/tr]");
		
			if (workItems != null && workItems.size() > 0)
			{
				for (WorkItem wi : workItems) {
					if (wi instanceof WorkPackage){
						writeWorkPackage((WorkPackage) wi);
					}
					else if (wi instanceof ActionItem){
						writeActionItem((ActionItem) wi);
					}
				}
	
			}
	}
	
	private static int getEffort (WorkPackage workPackage){
		int effort = workPackage.getEffort();
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0)
		{
		for (WorkItem wi : workItems) {
			//wi instanceof WorkPackage || 
			if (wi instanceof ActionItem)//{
				effort = effort + wi.getEffort();
			if (wi instanceof WorkPackage)
					effort = effort + getEffort((WorkPackage) wi);
			//}
		}}
		return effort;
	}
	
	private static int getEstimate (WorkPackage workPackage){
		int estimate = workPackage.getEstimate();
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0)
		{
		for (WorkItem wi : workItems) {
			//wi instanceof WorkPackage || 
			if (wi instanceof ActionItem)//{
				estimate = estimate + wi.getEstimate();
			if (wi instanceof WorkPackage)
					estimate = estimate + getEstimate((WorkPackage) wi);
			//}
		}}
		return estimate;
	}



	private static void writeActionItem(ActionItem actionItem) throws IOException {
		out.newLine();
whiteSpace = "";
		
		int level=0;
			WorkPackage wpAuxiliar;
			wpAuxiliar=actionItem.getContainingWorkpackage();
			level++;
			while (wpAuxiliar.getContainingWorkpackage() != null){
				level++;
				wpAuxiliar=wpAuxiliar.getContainingWorkpackage();
			}
			
			for (int i = 0; i<level;i++){
				whiteSpace = whiteSpace + "--";
			}
			
		out.write("[tr][td]"+whiteSpace+"> AI "+actionItem.getName()+"[/td]");
		

		if (actionItem.getState() != null){
			out.write("[td]"+actionItem.getState()+"[/td]");}
		else{
			out.write("[td]<not defined>[/td]");}
			
	if (actionItem.getAssignee() != null){
		out.write("[td]"+actionItem.getAssignee().getName()+"[/td]");}
	else{
		out.write("[td]<not defined>[/td]");}
		
	out.write("[td]"+actionItem.getPriority()+"[/td]");
	out.write("[td]"+actionItem.getEstimate()+"[/td]");
	out.write("[td]"+actionItem.getEffort()+"[/td][/tr]");
}
}
