package org.unicase.exportwp.utils;

import java.io.BufferedWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class WriteInfosFromWP {
	
	public static void writeSuccessors(WorkPackage workpackage, BBCodeUtil bbCodeUtil) {
		bbCodeUtil.writeInString(bbCodeUtil.bold("Successors: "));
		EList<WorkItem> successors = workpackage.getSuccessors();
		if (successors != null && successors.size() > 0) {
			for (int i = 0; i < successors.size(); i++) {
				bbCodeUtil.writeInString(successors.get(i).getName() + " ");
			}
		} else {
			bbCodeUtil.writeInString(bbCodeUtil.notDefined());
		}
		bbCodeUtil.newlineString();
	}

	public static void writePredecessors(WorkPackage workpackage, BBCodeUtil bbCodeUtil) {
		bbCodeUtil.writeInString(bbCodeUtil.bold("Predecessors: "));
		EList<WorkItem> predecessors = workpackage.getPredecessors();
		if (predecessors != null && predecessors.size() > 0) {
			for (int i = 0; i < predecessors.size(); i++) {
				bbCodeUtil.writeInString(predecessors.get(i).getName() + " ");
			}
		} else {
			bbCodeUtil.writeInString(bbCodeUtil.notDefined());
		}
		bbCodeUtil.newlineString();
	}

	public static void writeParticipants(WorkPackage workpackage, BBCodeUtil bbCodeUtil) {
		bbCodeUtil.writeInString(bbCodeUtil.bold("Participants: "));
		EList<OrgUnit> participants = workpackage.getParticipants();
		if (participants != null && participants.size() > 0) {
			for (int i = 0; i < participants.size(); i++) {
				if (i < participants.size() - 1) {
					bbCodeUtil.writeInString(participants.get(i).getName()
							+ ", ");
				} else {
					bbCodeUtil.writeInString(participants.get(i).getName());
				}
			}
		} else {
			bbCodeUtil.writeInString(bbCodeUtil.notDefined());
		}
		bbCodeUtil.newlineString();
	}

	public static void writeEndDate(WorkPackage workpackage, BBCodeUtil bbCodeUtil) {
		bbCodeUtil.writeInString(bbCodeUtil.bold("EndDate: "));
		if (workpackage.getEndDate() != null) {
			bbCodeUtil.writeInString(bbCodeUtil.dateFormat(workpackage
					.getEndDate()));
		} else {
			bbCodeUtil.writeInString(bbCodeUtil.notDefined());
		}
		bbCodeUtil.newlineString();
	}

	public static void writeStartDate(WorkPackage workpackage, BBCodeUtil bbCodeUtil) {
		bbCodeUtil.writeInString(bbCodeUtil.bold("StartDate: "));
		if (workpackage.getStartDate() != null) {
			bbCodeUtil.writeInString(bbCodeUtil.dateFormat(workpackage
					.getStartDate()));
		} else {
			bbCodeUtil.writeInString(bbCodeUtil.notDefined());
		}
		bbCodeUtil.newlineString();
	}

	public static void writeDescription(WorkPackage workpackage, BBCodeUtil bbCodeUtil) {
		bbCodeUtil.writeInString(bbCodeUtil.bold("Description: "));
		if (workpackage.getDescription() != null
				&& workpackage.getDescription() != "") {
			bbCodeUtil.writeInString(bbCodeUtil.italic(workpackage
					.getDescription()));
		} else {
			bbCodeUtil.writeInString(bbCodeUtil.notDefined());
		}
		bbCodeUtil.newlineString();
	}
	
	public static void writeSuccessorsBuffer(WorkPackage workpackage, BufferedWriter out) throws IOException{
		BBCodeUtil.writeInBuffer(out,  BBCodeUtil.bold("Successors: "));
		EList<WorkItem> successors = workpackage.getSuccessors();
		if (successors != null && successors.size() > 0) {
			for (int i = 0; i < successors.size(); i++) {
				BBCodeUtil.writeInBuffer(out,  successors.get(i).getName() + " ");
			}
		} else {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.notDefined());
		}
		BBCodeUtil.newlineBuffer(out);
	}

	public static void writePredecessorsBuffer(WorkPackage workpackage, BufferedWriter out) throws IOException {
		BBCodeUtil.writeInBuffer(out,  BBCodeUtil.bold("Predecessors: "));
		EList<WorkItem> predecessors = workpackage.getPredecessors();
		if (predecessors != null && predecessors.size() > 0) {
			for (int i = 0; i < predecessors.size(); i++) {
				BBCodeUtil.writeInBuffer(out,  predecessors.get(i).getName() + " ");
			}
		} else {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.notDefined());
		}
		BBCodeUtil.newlineBuffer(out);
	}

	public static void writeParticipantsBuffer(WorkPackage workpackage, BufferedWriter out) throws IOException {
		BBCodeUtil.writeInBuffer(out,  BBCodeUtil.bold("Participants: "));
		EList<OrgUnit> participants = workpackage.getParticipants();
		if (participants != null && participants.size() > 0) {
			for (int i = 0; i < participants.size(); i++) {
				if (i < participants.size() - 1) {
					BBCodeUtil.writeInBuffer(out,  participants.get(i).getName()
							+ ", ");
				} else {
					BBCodeUtil.writeInBuffer(out,  participants.get(i).getName());
				}
			}
		} else {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.notDefined());
		}
		BBCodeUtil.newlineBuffer(out);
	}

	public static void writeEndDateBuffer(WorkPackage workpackage, BufferedWriter out) throws IOException {
		BBCodeUtil.writeInBuffer(out,  BBCodeUtil.bold("EndDate: "));
		if (workpackage.getEndDate() != null) {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.dateFormat(workpackage
					.getEndDate()));
		} else {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.notDefined());
		}
		BBCodeUtil.newlineBuffer(out);
	}

	public static void writeStartDateBuffer(WorkPackage workpackage, BufferedWriter out) throws IOException {
		BBCodeUtil.writeInBuffer(out,  BBCodeUtil.bold("StartDate: "));
		if (workpackage.getStartDate() != null) {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.dateFormat(workpackage
					.getStartDate()));
		} else {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.notDefined());
		}
		BBCodeUtil.newlineBuffer(out);
	}

	public static void writeDescriptionBuffer(WorkPackage workpackage, BufferedWriter out) throws IOException {
		BBCodeUtil.writeInBuffer(out,  BBCodeUtil.bold("Description: "));
		if (workpackage.getDescription() != null
				&& workpackage.getDescription() != "") {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.italic(workpackage
					.getDescription()));
		} else {
			BBCodeUtil.writeInBuffer(out,  BBCodeUtil.notDefined());
		}
		BBCodeUtil.newlineBuffer(out);
	}
}
