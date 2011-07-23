package org.unicase.exportbb.utils;

import java.io.BufferedWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.organization.OrgUnit;

public class WriteInfosFromMeeting {

	/**
	 * Writes the participants of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getParticipants(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		BBCodeUtil.newlineString();
		EList<OrgUnit> participants_list = meeting.getParticipants();
		String s = "";
		if (participants_list.size() <= 0) {
			BBCodeUtil.writeInString("[tr][td2 colspan=2;color=FFFFFF]"
					+ BBCodeUtil.bold("Participants:  ")
					+ BBCodeUtil.notDefined() + "[/td2][/tr]");
		} else {
			for (int i = 0; i < participants_list.size(); i++)
				if (i < participants_list.size() - 1) {
					s = s + participants_list.get(i).getName() + ", ";
				} else {
					s = s + participants_list.get(i).getName();
				}
			BBCodeUtil.writeInString("[tr][td2 colspan=2;color=FFFFFF]"
					+ BBCodeUtil.bold("Participants:  ") + s + "[/td2][/tr]");
		}
	}

	/**
	 * Writes the location of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getLocation(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		if (meeting.getLocation() != null && meeting.getLocation() != "")
			BBCodeUtil.writeInString("[tr][td2 colspan=2;color=FFFFFF]"
					+ BBCodeUtil.bold("Location:  ") + meeting.getLocation()
					+ "[/td2][/tr]");
		else {
			BBCodeUtil.writeInString("[tr][td2 colspan=2;color=FFFFFF]"
					+ BBCodeUtil.bold("Location:  ") + BBCodeUtil.notDefined()
					+ "[/td2][/tr]");
		}
	}

	/**
	 * Writes the minute taker of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getMinuteTaker(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		if (meeting.getMinutetaker() != null)
			BBCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil
					.bold("Minute Taker:  ")
					+ meeting.getMinutetaker().getName()) + " [/tr]");
		else {
			BBCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil
					.bold("Minute Taker:  " + BBCodeUtil.notDefined()))
					+ "[/tr]");
		}
	}

	/**
	 * Writes the end time of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getEndTime(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		if (meeting.getEndtime() != null) {
			BBCodeUtil.writeInString("[tr]"
					+ BBCodeUtil.createCellInTable(BBCodeUtil.bold("End:  ")
							+ BBCodeUtil.dateFormat(meeting.getEndtime())));
		} else {
			BBCodeUtil.writeInString("[tr]"
					+ BBCodeUtil.createCellInTable(BBCodeUtil.bold("End:  "
							+ BBCodeUtil.notDefined())));
		}
	}

	/**
	 * Writes the time keeper of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getTimeKeeper(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		if (meeting.getTimekeeper() != null)
			BBCodeUtil
					.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil
							.bold("Time Keeper:  ")
							+ meeting.getTimekeeper().getName()) + " [/tr]");
		else {
			BBCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil
					.bold("Time Keeper:  " + BBCodeUtil.notDefined()))
					+ "[/tr]");
		}
	}

	/**
	 * Writes the start time of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getStartTime(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		if (meeting.getStarttime() != null) {

			BBCodeUtil.writeInString("[tr]"
					+ BBCodeUtil.createCellInTable(BBCodeUtil.bold("Start:  ")
							+ BBCodeUtil.dateFormat(meeting.getStarttime())));
		} else {
			BBCodeUtil.writeInString("[tr]"
					+ BBCodeUtil.createCellInTable(BBCodeUtil.bold("Start: ")
							+ BBCodeUtil.notDefined()));
		}
	}

	/**
	 * Writes the facilitator of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getFacilitator(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		if (meeting.getFacilitator() != null)
			BBCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil
					.bold("Moderator:  ") + meeting.getFacilitator().getName())
					+ " [/tr]");
		else {
			BBCodeUtil.writeInString(BBCodeUtil.createCellInTable(BBCodeUtil
					.bold("Moderator: " + BBCodeUtil.notDefined())) + "[/tr]");
		}
	}

	/**
	 * Writes the creation date of a Meeting in BBCode format in a string.
	 * 
	 * @param meeting
	 * @param bbcodeUtil2
	 */
	public static void getCreationDate(Meeting meeting, BBCodeUtil bbcodeUtil2) {
		if (meeting.getCreationDate() != null)
			BBCodeUtil
					.writeInString("[tr]"
							+ BBCodeUtil.createCellInTable(BBCodeUtil
									.bold("Date:  ")
									+ BBCodeUtil.dateFormat(meeting
											.getCreationDate())));
		else {
			BBCodeUtil.writeInString("[tr]"
					+ BBCodeUtil.createCellInTable(BBCodeUtil.bold("Date:  ")
							+ BBCodeUtil.notDefined()));
		}
	}

	/**
	 * Writes the participants of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getParticipantsBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		BBCodeUtil.newlineString();
		EList<OrgUnit> participants_list = meeting.getParticipants();
		String s = "";
		if (participants_list.size() <= 0) {
			BBCodeUtil.writeInBuffer(
					out,
					"[tr][td2 colspan=2;color=FFFFFF]"
							+ BBCodeUtil.bold("Participants:  ")
							+ BBCodeUtil.notDefined() + "[/td2][/tr]");
		} else {
			for (int i = 0; i < participants_list.size(); i++)
				if (i < participants_list.size() - 1) {
					s = s + participants_list.get(i).getName() + ", ";
				} else {
					s = s + participants_list.get(i).getName();
				}
			BBCodeUtil.writeInBuffer(out, "[tr][td2 colspan=2;color=FFFFFF]"
					+ BBCodeUtil.bold("Participants:  ") + s + "[/td2][/tr]");
		}
	}

	/**
	 * Writes the location of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getLocationBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		if (meeting.getLocation() != null && meeting.getLocation() != "")
			BBCodeUtil.writeInBuffer(out, "[tr][td2 colspan=2;color=FFFFFF]"
					+ BBCodeUtil.bold("Location:  ") + meeting.getLocation()
					+ "[/td2][/tr]");
		else {
			BBCodeUtil.writeInBuffer(out, "[tr][td2 colspan=2;color=FFFFFF]"
					+ BBCodeUtil.bold("Location:  ") + BBCodeUtil.notDefined()
					+ "[/td2][/tr]");
		}
	}

	/**
	 * Writes the minute taker of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getMinuteTakerBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		if (meeting.getMinutetaker() != null)
			BBCodeUtil.writeInBuffer(
					out,
					BBCodeUtil.createCellInTable(BBCodeUtil
							.bold("Minute Taker:  ")
							+ meeting.getMinutetaker().getName()) + " [/tr]");
		else {
			BBCodeUtil.writeInBuffer(
					out,
					BBCodeUtil.createCellInTable(BBCodeUtil
							.bold("Minute Taker:  " + BBCodeUtil.notDefined()))
							+ "[/tr]");
		}
	}

	/**
	 * Writes the end time of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getEndTimeBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		if (meeting.getEndtime() != null) {
			BBCodeUtil.writeInBuffer(
					out,
					"[tr]"
							+ BBCodeUtil.createCellInTable(BBCodeUtil
									.bold("End:  ")
									+ BBCodeUtil.dateFormat(meeting
											.getEndtime())));
		} else {
			BBCodeUtil.writeInBuffer(
					out,
					"[tr]"
							+ BBCodeUtil.createCellInTable(BBCodeUtil
									.bold("End:  " + BBCodeUtil.notDefined())));
		}
	}

	/**
	 * Writes the time keeper of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getTimeKeeperBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		if (meeting.getTimekeeper() != null)
			BBCodeUtil.writeInBuffer(
					out,
					BBCodeUtil.createCellInTable(BBCodeUtil
							.bold("Time Keeper:  ")
							+ meeting.getTimekeeper().getName()) + " [/tr]");
		else {
			BBCodeUtil.writeInBuffer(
					out,
					BBCodeUtil.createCellInTable(BBCodeUtil
							.bold("Time Keeper:  " + BBCodeUtil.notDefined()))
							+ "[/tr]");
		}
	}

	/**
	 * Writes the start time of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getStartTimeBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		if (meeting.getStarttime() != null) {

			BBCodeUtil.writeInBuffer(
					out,
					"[tr]"
							+ BBCodeUtil.createCellInTable(BBCodeUtil
									.bold("Start:  ")
									+ BBCodeUtil.dateFormat(meeting
											.getStarttime())));
		} else {
			BBCodeUtil
					.writeInBuffer(
							out,
							"[tr]"
									+ BBCodeUtil.createCellInTable(BBCodeUtil
											.bold("Start: ")
											+ BBCodeUtil.notDefined()));
		}
	}

	/**
	 * Writes the facilitator of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getFacilitatorBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		if (meeting.getFacilitator() != null)
			BBCodeUtil.writeInBuffer(
					out,
					BBCodeUtil.createCellInTable(BBCodeUtil
							.bold("Moderator:  ")
							+ meeting.getFacilitator().getName()) + " [/tr]");
		else {
			BBCodeUtil.writeInBuffer(
					out,
					BBCodeUtil.createCellInTable(BBCodeUtil.bold("Moderator: "
							+ BBCodeUtil.notDefined()))
							+ "[/tr]");
		}
	}

	/**
	 * Writes the creation date of a Meeting in BBCode format in a buffer.
	 * 
	 * @param meeting
	 * @param out
	 * @throws IOException
	 */
	public static void getCreationDateBuffer(Meeting meeting, BufferedWriter out)
			throws IOException {
		if (meeting.getCreationDate() != null)
			BBCodeUtil.writeInBuffer(
					out,
					"[tr]"
							+ BBCodeUtil.createCellInTable(BBCodeUtil
									.bold("Date:  ")
									+ BBCodeUtil.dateFormat(meeting
											.getCreationDate())));
		else {
			BBCodeUtil
					.writeInBuffer(
							out,
							"[tr]"
									+ BBCodeUtil.createCellInTable(BBCodeUtil
											.bold("Date:  ")
											+ BBCodeUtil.notDefined()));
		}
	}
}
