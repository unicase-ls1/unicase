package org.unicase.exportwp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
 * 
 * Creates the BBCode format out of the infos from a WorkPackage and puts it into a file.
 * @author Carmen Carlan
 *
 */
public class CreateBBCodeTableFormat {
	static File file;
	static FileWriter fstream;
	static BufferedWriter out;
	static String whiteSpace = "";
	static String string;
	static int nrWorkItems;
	static Calendar cal = Calendar.getInstance();
	static int nrOfChildren = 0;
	static int nrOfClosedChildren = 0;

	/**
	 * Creates the file.
	 * 
	 * @param workpackage
	 * @param fileUrl
	 */
	public static void createFile(WorkPackage workpackage, String fileUrl) {
		try {
			// Create file
			file = new File(fileUrl);
			fstream = new FileWriter(file);
			out = new BufferedWriter(fstream);

			writeGeneralDescription(workpackage);
			createTable(workpackage);

			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());

		}
	}

	private static void writeGeneralDescription(WorkPackage workpackage)
			throws IOException {

		BBCodeUtil.writeInBuffer(out,
				BBCodeUtil.bold(BBCodeUtil.getProjectName(workpackage))
						+ " (chair for applied software engineering)");
		BBCodeUtil.newlineBuffer(out);
		BBCodeUtil.newlineBuffer(out);
		BBCodeUtil
				.writeInBuffer(
						out,
						BBCodeUtil.size(
								" WorkPackage : " + workpackage.getName(), 150));
		BBCodeUtil.newlineBuffer(out);
		BBCodeUtil.newlineBuffer(out);

		WriteInfosFromWP.writeDescriptionBuffer(workpackage, out);

		WriteInfosFromWP.writeStartDateBuffer(workpackage, out);

		WriteInfosFromWP.writeEndDateBuffer(workpackage, out);

		WriteInfosFromWP.writeParticipantsBuffer(workpackage, out);

		WriteInfosFromWP.writePredecessorsBuffer(workpackage, out);

		WriteInfosFromWP.writeSuccessorsBuffer(workpackage, out);

	}

	private static void createTable(WorkPackage workpackage) throws IOException {

		BBCodeUtil.writeInBuffer(out, "[table1 border=1]");
		BBCodeUtil.newlineBuffer(out);
		writeTabelHeader();
		writeWorkPackage(workpackage);
		BBCodeUtil.writeInBuffer(out, "[/table1]");
		BBCodeUtil.newlineBuffer(out);

	}

	private static void writeTabelHeader() throws IOException {
		BBCodeUtil.newlineBuffer(out);
		BBCodeUtil
				.writeInBuffer(
						out,
						"[tr][th]WorkItem[/th][th]Deadline[/th][th]State[/th][th]Assigned to[/th][th]Priority[/th][th]Estimate[/th][th]Effort[/th][th]Estimate (Closed)[/th][th]Closed Items[/th][/tr]");

	}

	/**
	 * @param workPackage
	 * @param child
	 * @throws IOException
	 */
	private static void writeWorkPackage(WorkPackage workPackage)
			throws IOException {

		BBCodeUtil.newlineBuffer(out);
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
			BBCodeUtil.writeInBuffer(
					out,
					"[tr]"
							+ BBCodeUtil.createCellInTable(BBCodeUtil
									.bold(whiteSpace + " WP "
											+ workPackage.getName())));
		} else {
			BBCodeUtil.writeInBuffer(
					out,
					"[tr]"
							+ BBCodeUtil.createCellInTable(BBCodeUtil
									.bold(whiteSpace + "> WP "
											+ workPackage.getName())));
		}

		writeDeadline(workPackage);

		nrOfClosedChildren = getNumberOfClosedChildren(workPackage);
		nrOfChildren = getNumberOfChildren(workPackage);

		writeStatus(workPackage);

		writeAsignee(workPackage);

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

		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(oneDigit
				.format(priority).toString()));

		estimate = getEstimate(workPackage);
		helpString = "" + estimate;
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(helpString));

		effort = getEffort(workPackage);
		helpString = "" + effort;
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(helpString));

		closedEstimate = getClosedEstimate(workPackage);
		helpString = "" + closedEstimate;
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(helpString));

		helpString = "" + nrOfClosedChildren;
		helpString = helpString + "/" + nrOfChildren;
		BBCodeUtil.writeInBuffer(out,
				BBCodeUtil.createCellInTable(helpString + "[/tr]"));

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

	public static void writeAsignee(WorkItem workItem)
			throws IOException {
		if (workItem.getAssignee() != null)
			BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(workItem
					.getAssignee().getName()));
		else
			BBCodeUtil.writeInBuffer(out,
					BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
	}

	public static void writeStatus(WorkItem workItem)
			throws IOException {
		if (workItem.getState() != null) {
			if (workItem.getState() == "Closed") {
				BBCodeUtil.writeInBuffer(out,
						BBCodeUtil.createColoredCellInTable(
								workItem.getState(), "80FF40"));
			} else if (workItem.getState() == "Open"
					&& workItem.getDueDate() != null
					&& workItem.getDueDate().before(cal.getTime())) {
				BBCodeUtil.writeInBuffer(out, BBCodeUtil
						.createColoredCellInTable("Delayed", "FF8080"));
			} else if (workItem.getState() == "Open" && nrOfClosedChildren > 0) {
				BBCodeUtil.writeInBuffer(out, BBCodeUtil
						.createColoredCellInTable("Blocked", "FFBF00"));
			} else if (workItem.getState() == "Open") {
				BBCodeUtil.writeInBuffer(out,
						BBCodeUtil.createColoredCellInTable(
								workItem.getState(), "FFFF80"));
			}
		}

		else {
			BBCodeUtil.writeInBuffer(out,
					BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
		}
	}

	private static void writeDeadline(WorkItem workItem)
			throws IOException {
		if (workItem.getDueDate() != null) {
			BBCodeUtil.writeInBuffer(out, BBCodeUtil
					.createCellInTable(BBCodeUtil.dateFormat(workItem
							.getDueDate())));
		} else {
			BBCodeUtil.writeInBuffer(out,
					BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
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

		BBCodeUtil.newlineBuffer(out);

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

		BBCodeUtil.writeInBuffer(
				out,
				"[tr]"
						+ BBCodeUtil.createCellInTable(whiteSpace + "> AI "
								+ actionItem.getName()));

		writeDeadline(actionItem);

		if (actionItem.getState() != null) {
			if (actionItem.getState() == "Blocked") {
				BBCodeUtil.writeInBuffer(
						out,
						BBCodeUtil.createColoredCellInTable(
								actionItem.getState(), "FFBF00"));
			} else if (actionItem.getState() == "Closed") {
				BBCodeUtil.writeInBuffer(
						out,
						BBCodeUtil.createColoredCellInTable(
								actionItem.getState(), "80FF40"));
			} else if (actionItem.getState() == "Open"
					&& actionItem.getDueDate() != null
					&& actionItem.getDueDate().before(cal.getTime())) {
				BBCodeUtil.writeInBuffer(out, BBCodeUtil
						.createColoredCellInTable("Delayed", "FF8080"));
			} else if (actionItem.getState() == "Open") {
				BBCodeUtil.writeInBuffer(
						out,
						BBCodeUtil.createColoredCellInTable(
								actionItem.getState(), "FFFF80"));
			}
		}

		else {
			BBCodeUtil.writeInBuffer(out,
					BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
		}

		writeAsignee(actionItem);

		String helpString = "";
		helpString = helpString + actionItem.getPriority();
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(helpString));
		helpString = "";
		helpString = helpString + actionItem.getEstimate();
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(helpString));
		helpString = "";
		helpString = helpString + actionItem.getEffort();
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(helpString));
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(""));
		BBCodeUtil.writeInBuffer(out, BBCodeUtil.createCellInTable(""));
		BBCodeUtil.writeInBuffer(out, "[/tr]");
	}

}
