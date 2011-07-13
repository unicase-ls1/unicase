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

/**
 * Selects all important information from a Workpackage and writes them into a file.
 * @author Carmen Carlan
 *
 */
public class CreateBBCodeFormat {

	static File file;
	static FileWriter fstream;
	static BufferedWriter out;
	static boolean firstChild = true;


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
			writeHead(workpackage);

			writeWorkPackage(workpackage, false);

			if (!firstChild){
				out.newLine();
				out.write("    [/list]");
				out.newLine();
			}

			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			
		}
	}



	public static void writeHead(WorkPackage workPackage)
	throws IOException {
		out.write("[i][size=150]Chair for Applied Software Engineering [/size][/i]");
		out.newLine();
		out.newLine();
		out.write("[color=#008000][size=70] WorkPackage Name: "
				+ workPackage.getName() + "[/size][/color]");
		out.newLine();
		out.newLine();
	}

	/**
	 * @param workPackage
	 * @param child
	 * @throws IOException
	 */
	private static void writeWorkPackage(WorkPackage workPackage, boolean child) throws IOException {

		if (child){
			out.write("  [*] [b]" + workPackage.getName() + "[/b] ");
			out.newLine();
		}

		if (workPackage.getAssignee() != null)
			out.write("		[b]Asignee[/b]: "
					+ workPackage.getAssignee().getName());
		else
			out.write("		[b]Asignee[/b]: " + "<not defined>");
		out.newLine();
		if (workPackage.getDueDate() != null)
			out.write("		[b]Deadline[/b]: "
					+ workPackage.getDueDate().getDay() + "."
					+ workPackage.getDueDate().getMonth());
		else
			out.write("		[b]Deadline[/b]: " + "<not defined>");
		out.newLine();

		if (workPackage.getState() != null)
			out.write("		[b]Status[/b]: " + workPackage.getState());
		else
			out.write("		[b]Status[/b]: " + "<not defined>" + ", ");
		out.newLine();
		if (workPackage.getDescription() !=null)
			out.write("         [i]" + workPackage.getDescription()
					+ "[/i]");
		out.newLine();
		out.newLine();

		EList<WorkItem> workItems = workPackage.getContainedWorkItems();

		if (workItems != null && workItems.size() > 0)
		{
			for (WorkItem wi : workItems) {
				if (wi instanceof WorkPackage && workItems.get(0).equals(wi)){
					out.write("  [list=1]");
					out.newLine();
					writeWorkPackage ((WorkPackage) wi, true);
				}
				else if (wi instanceof WorkPackage) {
					writeWorkPackage ((WorkPackage) wi, true);
				}
				else if(wi instanceof ActionItem && workItems.get(0).equals(wi)){
					out.write("  [list=1]");
					out.newLine();
					writeActionItem((ActionItem) wi);
				}
				else if (wi instanceof ActionItem){
					writeActionItem((ActionItem) wi);
				}
			}
			out.write("    [/list]");
			out.newLine();
			out.newLine();
		}
	}



	private static void writeActionItem(ActionItem ai) throws IOException {
		out.newLine();
		out.write("      [*] [b]Name[/b]: " + ai.getName());
		out.newLine();
		if (ai.getAssignee() != null)
			out.write("[b]Asignee[/b]: "
					+ ai.getAssignee().getName());
		else
			out.write("[b]Asignee[/b]: " + "<not defined>");
		out.newLine();
		if (ai.getDueDate() != null)
			out.write("[b]Deadline[/b]: "
					+ ai.getDueDate().getDay() + "."
					+ ai.getDueDate().getMonth());
		else
			out.write("[b]Deadline[/b]: " + "<not defined>");
		out.newLine();

		if (ai.getState() != null)
			out.write("[b]Status[/b]: " + ai.getState());
		else
			out.write("[b]Status[/b]: " + "<not defined>" + ", ");
		out.newLine();
		if (ai.getDescription() != null && ai.getDescription() != ""){
		out.write("         [i]" + ai.getDescription()
				+ "[/i]");
		out.newLine();}
		
	}

}