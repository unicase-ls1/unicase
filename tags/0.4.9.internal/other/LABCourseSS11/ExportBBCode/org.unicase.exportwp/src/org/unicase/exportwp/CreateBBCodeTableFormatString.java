package org.unicase.exportwp;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.eclipse.emf.common.util.EList;
import org.unicase.exportwp.utils.BBCodeUtil;
import org.unicase.exportwp.utils.WriteInfosFromWP;

import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * Creates the BBCode format out of the infos from a WorkPackage and puts it into a string.
 * @author Carmen Carlan
 *
 */
public class CreateBBCodeTableFormatString {

	static String string;
	static String whiteSpace = "";
	static int nrWorkItems;
	static Calendar cal = Calendar.getInstance();
	static int nrOfChildren = 0;
	static int nrOfClosedChildren = 0;
	static BBCodeUtil bbCodeUtil;

	/**
	 * Creates the string.
	 * 
	 * @param workpackage
	 * @param fileUrl
	 * @return
	 */
	public static String createString(WorkPackage workpackage) {
		try {
			// Initializing the string
			string = "";
			bbCodeUtil = new BBCodeUtil(string);
			writeGeneralDescription(workpackage);
			createTable(workpackage);
			string = bbCodeUtil.string;
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return string;
	}

	private static void writeGeneralDescription(WorkPackage workpackage) {
		
		bbCodeUtil.writeInString(BBCodeUtil.bold(BBCodeUtil
				.getProjectName(workpackage))
				+ " (chair for applied software engineering)");
		bbCodeUtil.newlineString();
		bbCodeUtil.newlineString();
		bbCodeUtil.writeInString(BBCodeUtil.size(" WorkPackage : "
				+ workpackage.getName(), 150));
		bbCodeUtil.newlineString();
		bbCodeUtil.newlineString();
		
		WriteInfosFromWP.writeDescription(workpackage, bbCodeUtil);
		
		WriteInfosFromWP.writeStartDate(workpackage, bbCodeUtil);

		WriteInfosFromWP.writeEndDate(workpackage, bbCodeUtil);
		
		WriteInfosFromWP.writeParticipants(workpackage, bbCodeUtil);
		
		WriteInfosFromWP.writePredecessors(workpackage, bbCodeUtil);
		
		WriteInfosFromWP.writeSuccessors(workpackage, bbCodeUtil);
		

	}

	
	private static void createTable(WorkPackage workpackage) throws IOException {
		
		bbCodeUtil.writeInString("[table1 border=1]");
		bbCodeUtil.newlineString();
		writeTabelHeader();
		writeWorkPackage(workpackage);
		bbCodeUtil.writeInString("[/table1]");
		bbCodeUtil.newlineString();
		
	}

	private static void writeTabelHeader() throws IOException {
		bbCodeUtil.newlineString();
		bbCodeUtil.writeInString
				 ("[tr][th]WorkItem[/th][th]Deadline[/th][th]State[/th][th]Assigned to[/th][th]Priority[/th][th]Estimate[/th][th]Effort[/th][th]Estimate (Closed)[/th][th]Closed Items[/th][/tr]");

	}

	/**
	 * @param workPackage
	 * @param child
	 * @throws IOException
	 */
	private static void writeWorkPackage(WorkPackage workPackage)
			throws IOException {

		bbCodeUtil.newlineString();
		int estimate = 0;
		int closedEstimate = 0;
		int effort = 0;
		int sumOfPriorities = 0;
		int level = 0;
		double priority;
		String helpString = "";
		nrOfChildren = 0;
		nrOfClosedChildren = 0;
		whiteSpace = "";

		WorkPackage wpAuxiliar;
		wpAuxiliar = workPackage;
		while (wpAuxiliar.getContainingWorkpackage() != null) {
			level++;
			wpAuxiliar = wpAuxiliar.getContainingWorkpackage();
		}

		for (int i = 0; i < level; i++) {
			whiteSpace = whiteSpace + "---";
		}

		if (level == 0) {
			bbCodeUtil.writeInString("[tr]"+BBCodeUtil.createCellInTable(BBCodeUtil.bold(whiteSpace + " WP "
							+ workPackage.getName())));
		} else {
			bbCodeUtil.writeInString("[tr]"+BBCodeUtil.createCellInTable(BBCodeUtil.bold(whiteSpace + "> WP "
					+ workPackage.getName())));
		}

		writeDeadline(workPackage, bbCodeUtil);

		nrOfClosedChildren = getNumberOfClosedChildren(workPackage);
		nrOfChildren = getNumberOfChildren(workPackage);

		writeStatus(workPackage, bbCodeUtil);
	
		writeAsignee(workPackage, bbCodeUtil);

		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		nrWorkItems = 0;

		// the priority is the average of the priorities of all ActionItems within the workpackage.
		sumOfPriorities = getPriority(workPackage);
		if (nrWorkItems == 0){
			nrWorkItems = 1;
		}
		priority = ((sumOfPriorities * 1.0) / (nrWorkItems * 1.0));

		DecimalFormat oneDigit = new DecimalFormat("#,##0.0");// format to 1
																// decimal place

		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(oneDigit.format(priority).toString()));

		estimate = getEstimate(workPackage);
		helpString = ""+estimate;
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(helpString));

		effort = getEffort(workPackage);
		helpString = ""+effort;
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(helpString));

		closedEstimate = getClosedEstimate(workPackage);
		helpString = ""+closedEstimate;
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(helpString));

		helpString = ""+nrOfClosedChildren;
		helpString = helpString+"/"+nrOfChildren;
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(helpString+"[/tr]"));

		if (workItems != null && workItems.size() > 0) {
			for (WorkItem wi : workItems) {
				if (wi instanceof WorkPackage) {
					writeWorkPackage((WorkPackage) wi);
				} else if (wi instanceof ActionItem) {
					writeActionItem((ActionItem) wi);
				}
			}

		}

	}

	private static void writeAsignee(WorkItem workItem, BBCodeUtil bbCodeUtil2) {
		if (workItem.getAssignee() != null)
			bbCodeUtil.writeInString
					(BBCodeUtil.createCellInTable(workItem.getAssignee().getName()));
		else
			bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
	}

	private static void writeStatus(WorkItem workItem, BBCodeUtil bbCodeUtil2) {
		if (workItem.getState() != null) {
			if (workItem.getState() == "Closed") {
				bbCodeUtil.writeInString
						(BBCodeUtil.createColoredCellInTable(workItem.getState(), "80FF40"));
			} else if (workItem.getState() == "Open"
					&& workItem.getDueDate() != null
					&& workItem.getDueDate().before(cal.getTime())) {
				bbCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable("Delayed", "FF8080"));
			} else if (workItem.getState() == "Open"
					&& nrOfClosedChildren > 0) {
				bbCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable("Blocked", "FFBF00"));
			} else if (workItem.getState() == "Open") {
				bbCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable(workItem.getState(), "FFFF80"));
			}
		}

		else {
			bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
		}
	}

	private static void writeDeadline(WorkItem workItem, BBCodeUtil bbCodeUtil) {
		if (workItem.getDueDate() != null) {
			bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil.dateFormat(workItem.getDueDate()) ));
		} else {
			bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
		}
	}

	/**
	 * Computes the number of all the ActionItems within the workpackage.
	 * @param workPackage
	 * @return
	 */
	private static int getNumberOfChildren(WorkPackage workPackage) {
		int nr = 0;
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0) {
			for (WorkItem wi : workItems) {
				if (wi instanceof ActionItem) {
					nr++;
				}
				if (wi instanceof WorkPackage) {
					nr = nr + getNumberOfChildren((WorkPackage) wi);

				}
			}
		}
		return nr;
	}

	/**
	 * Computes the number of all closed ActionItems within the workpackage.
	 * @param workPackage
	 * @return
	 */
	private static int getNumberOfClosedChildren(WorkPackage workPackage) {
		int nr = 0;
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0) {
			for (WorkItem wi : workItems) {
				if (wi instanceof WorkPackage) {
					nr = nr + getNumberOfClosedChildren((WorkPackage) wi);
				}
				if (wi instanceof ActionItem) {
					if (((ActionItem) wi).getState() == "Closed") {
						nr++;
					}
				}
			}
		}
		return nr;
	}

	/**
	 * Computes the sum of the effort of all ActionItems within the workpackage.
	 * @param workPackage
	 * @return
	 */
	private static int getEffort(WorkPackage workPackage) {
		int effort = 0;
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0) {
			for (WorkItem wi : workItems) {
				if (wi instanceof ActionItem) {
					effort = effort + wi.getEffort();
				}
				if (wi instanceof WorkPackage) {
					effort = effort + getEffort((WorkPackage) wi);

				}
			}
		}
		return effort;
	}

	/**
	 * Computes the sum of the estimate of all ActionItems within the workpackage.
	 * @param workPackage
	 * @return
	 */
	private static int getEstimate(WorkPackage workPackage) {
		int estimate = 0;
		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0) {

			for (WorkItem wi : workItems) {
				if (wi instanceof ActionItem) {
					estimate = estimate + wi.getEstimate();
				}
				if (wi instanceof WorkPackage) {
					estimate = estimate + getEstimate((WorkPackage) wi);

				}
			}
		}
		return estimate;
	}

	/**
	 * Computes the sum of the estimate of all closed ActionItems within the workpackage.
	 * @param workPackage
	 * @return
	 */
	private static int getClosedEstimate(WorkPackage workPackage) {
		int estimate = 0;

		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0) {
			for (WorkItem wi : workItems) {
				if (wi instanceof WorkPackage) {
					if (((WorkPackage) wi).getState() == "Closed"
							&& ((WorkPackage) wi).getEstimate() != 0) {
						estimate = estimate + getEstimate((WorkPackage) wi);
					}
					estimate = estimate + getClosedEstimate((WorkPackage) wi);

				}
			}
		}
		return estimate;
	}

	/**
	 * Computes the sum of the priority of all ActionItems within the workpackage.
	 * @param workPackage
	 * @return
	 */
	private static int getPriority(WorkPackage workPackage) {
		int priority = 0;

		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		if (workItems != null && workItems.size() > 0) {

			for (WorkItem wi : workItems) {
				if (wi instanceof ActionItem) {
					priority = priority + wi.getPriority();
					nrWorkItems++;
				}
				if (wi instanceof WorkPackage) {
					priority = priority + getPriority((WorkPackage) wi);
				}
			}
		}
		return priority;
	}

	private static void writeActionItem(ActionItem actionItem)
			throws IOException {

		bbCodeUtil.newlineString();

		whiteSpace = "";

		int level = 0;
		WorkPackage wpAuxiliar;
		wpAuxiliar = actionItem.getContainingWorkpackage();
		level++;
		while (wpAuxiliar.getContainingWorkpackage() != null) {
			level++;
			wpAuxiliar = wpAuxiliar.getContainingWorkpackage();
		}

		for (int i = 0; i < level; i++) {
			whiteSpace = whiteSpace + "---";
		}

		bbCodeUtil.writeInString
				("[tr]" + BBCodeUtil.createCellInTable(whiteSpace + "> AI " + actionItem.getName()));

		writeDeadline(actionItem, bbCodeUtil);

		if (actionItem.getState() != null) {
			if (actionItem.getState() == "Blocked") {
				bbCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable(actionItem.getState(), "FFBF00"));
			} else if (actionItem.getState() == "Closed") {
				bbCodeUtil.writeInString
				(BBCodeUtil.createColoredCellInTable(actionItem.getState(), "80FF40"));
			} else if (actionItem.getState() == "Open"
					&& actionItem.getDueDate() != null
					&& actionItem.getDueDate().before(cal.getTime())) {
				bbCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable("Delayed", "FF8080"));
			} else if (actionItem.getState() == "Open") {
				bbCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable(actionItem.getState(), "FFFF80"));
			}
		}

		else{
			bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
		}

		writeAsignee(actionItem, bbCodeUtil);

		String helpString = "";
		helpString = helpString + actionItem.getPriority();
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(helpString));
		helpString = "";
		helpString = helpString + actionItem.getEstimate();
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(helpString));
		helpString = "";
		helpString = helpString + actionItem.getEffort();
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(helpString));
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(""));
		bbCodeUtil.writeInString(BBCodeUtil.createCellInTable(""));
		bbCodeUtil.writeInString("[/tr]");
	}

}
