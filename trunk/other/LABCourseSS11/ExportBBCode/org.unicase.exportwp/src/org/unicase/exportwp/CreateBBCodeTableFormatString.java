package org.unicase.exportwp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class CreateBBCodeTableFormatString {
static String string = "";
static String whiteSpace = "";
static int nrWorkItems;
static Calendar cal = Calendar.getInstance();

	/**
	 * Creates the file.
	 * @param workpackage
	 * @param fileUrl
	 * @return 
	 */
	public static String createString(WorkPackage workpackage) {
		try {
			// Create file
			
			string = "";
			string = string +("[table=1]");
			string = string + "\n";
			
			writeTabelHeader ();
			writeWorkPackage(workpackage);
			string = string +("[/table]");
			
			string = string + "\n";
			string = string + "Legend";

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			
		}
		return string;
	}



	private static void writeTabelHeader() throws IOException {
		string = string + "\n";
		string = string +("[tr][td][color=#008000][b]WorkItem[/b][/color][/td][td][color=#008000][b]Deadline[/b][/color][/td][td][color=#008000][b]State[/b][/color][/td][td][color=#008000][b]Assigned to[/b][/color][/td][td][color=#008000][b]Priority[/b][/color][/td][td][color=#008000][b]Estimate[/b][/color][/td][td][color=#008000][b]Effort[/b][/color][/td][/tr]");	
		
	}

	/**
	 * @param workPackage
	 * @param child
	 * @throws IOException
	 */
	private static void writeWorkPackage(WorkPackage workPackage) throws IOException {

		string = string + "\n";
		whiteSpace = "";
		int estimate = 0;
		int effort = 0;
		int priority = 0;
		
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
			
			string = string +("[tr][td][b]"+whiteSpace+"> WP "+workPackage.getName()+"[/b][/td]");
			
			if (workPackage.getDueDate() != null){

				string = string +("[td]"+workPackage.getDueDate()+"[/td]");
			}
			else{
				string = string +("[td]<not defined>[/td]");
			}

			if (workPackage.getState() != null){
				if (workPackage.getState() == "Blocked"){
					string = string +("[td][color=orange]"+workPackage.getState()+"[/color][/td]");
				} else if (workPackage.getState() == "Closed"){
					string = string +("[td][color=green]"+workPackage.getState()+"[/color][/td]");
				} else if (workPackage.getState() == "Open" && workPackage.getDueDate()!= null && workPackage.getDueDate().before(cal.getTime())){
					string = string +("[td][color=red]Delayed[/color][/td]");
				} else if (workPackage.getState() == "Open"){

					string = string +("[td][color=yellow]"+workPackage.getState()+"[/color][/td]");
				}
			}
				
			else
				string = string +("[td]<not defined>[/td]");
				
		if (workPackage.getAssignee() != null)
			string = string +("[td]"+workPackage.getAssignee().getName()+"[/td]");
		else
			string = string +("[td]<not defined>[/td]");
			
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		nrWorkItems = 0;
		
//		string = string +("[td]"+workPackage.getPriority()+"[/td]");
		
		priority = getPriority(workPackage);
		priority = priority / nrWorkItems;
		if (nrWorkItems == 1){
			string = string +("[td][color=red]"+priority+"[/color][/td]");
		} else {
			string = string +("[td]"+priority+"[/td]");
		}
		estimate = getEstimate(workPackage);
		if (nrWorkItems == 1){
			string = string +("[td][color=red]"+estimate+"[/color][/td]");
		} else {
			string = string +("[td]"+estimate+"[/td]");
		}
		effort = getEffort(workPackage);
		if (nrWorkItems == 1){
			string = string +("[td][color=red]"+effort+"[/color][/td][/tr]");
		} else {
			string = string +("[td]"+effort+"[/td][/tr]");
		}
		
		
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
		int effort = 0;
		if (workPackage.getEffort() != 0){
			effort = workPackage.getEffort();
			
			
		}
		else {
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0)
		{
		for (WorkItem wi : workItems) {
			//wi instanceof WorkPackage || 
			if (wi instanceof ActionItem){
				effort = effort + wi.getEffort();
				}
			if (wi instanceof WorkPackage){
					effort = effort + getEffort((WorkPackage) wi);
				
			}
		}}}
		return effort;
	}
	
	private static int getEstimate (WorkPackage workPackage){
		int estimate = 0;
		if (workPackage.getEstimate() != 0){
			estimate = workPackage.getEstimate();
		
			
		}
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0)
		{
		for (WorkItem wi : workItems) {
			//wi instanceof WorkPackage || 
			if (wi instanceof ActionItem){
				estimate = estimate + wi.getEstimate();
			}
			if (wi instanceof WorkPackage){
				estimate = estimate + getEstimate((WorkPackage) wi);
				
			}
		}}
		return estimate;
	}
	
	private static int getPriority (WorkPackage workPackage){
		int priority = 0;
		if (workPackage.getPriority() != 0){
			priority = workPackage.getPriority();
			nrWorkItems++;
		
		}
		
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0)
		{
		for (WorkItem wi : workItems) {
			//wi instanceof WorkPackage || 
			if (wi instanceof ActionItem){
				priority = priority + wi.getPriority();
				nrWorkItems++;
			}
			if (wi instanceof WorkPackage){
				priority = priority + getPriority((WorkPackage) wi);
			}
		}}
		
		return priority;
	}

	private static void writeActionItem(ActionItem actionItem) throws IOException {
		
		
		string = string + "\n";
		
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
			
		string = string +("[tr][td]"+whiteSpace+"> AI "+actionItem.getName()+"[/td]");
		
		if (actionItem.getDueDate() != null){
			string = string +("[td]"+actionItem.getDueDate()+"[/td]");
		}
		else{
			string = string +("[td]<not defined>[/td]");
		}

		if (actionItem.getState() != null){
			if (actionItem.getState() == "Blocked"){
				string = string +("[td][color=orange]"+actionItem.getState()+"[/color][/td]");
			} else if (actionItem.getState() == "Closed"){
				string = string +("[td][color=green]"+actionItem.getState()+"[/color][/td]");
			} else if (actionItem.getState() == "Open" &&  actionItem.getDueDate() != null && actionItem.getDueDate().after(cal.getTime())){
				string = string +("[td][color=red]Delayed[/color][/td]");
			} else if (actionItem.getState() == "Open"){
				string = string +("[td][color=yellow]"+actionItem.getState()+"[/color][/td]");
			} 
		}
			
		else
			string = string +("[td]<not defined>[/td]");
			
	if (actionItem.getAssignee() != null){
		string = string +("[td]"+actionItem.getAssignee().getName()+"[/td]");}
	else{
		string = string +("[td]<not defined>[/td]");}
		
	string = string +("[td]"+actionItem.getPriority()+"[/td]");
	string = string +("[td]"+actionItem.getEstimate()+"[/td]");
	string = string +("[td]"+actionItem.getEffort()+"[/td][/tr]");
}
}

