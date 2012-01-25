/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.organization.OrgUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Fhm Meeting Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class FhmMeetingRendererImpl extends MeetingRendererImpl implements FhmMeetingRenderer {

	private static final double BORDER_WIDTH = 0.8;

	/**
	 * agenda text.
	 */
	public static final String TOPIC_AGENDA = "Agenda ";

	/**
	 * protokoll text.
	 */
	public static final String TOPIC_PROTOKOLL = "Niederschrift / Protokoll ";

	private TextOption textSmall;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FhmMeetingRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.FHM_MEETING_RENDERER;
	}

	@Override
	protected void doRender(EObject eObject, UCompositeSection section) {

		setMeeting((Meeting) eObject);

		textSmall = OptionsFactory.eINSTANCE.createTextOption();
		textSmall.setFontSize(8);

		setWorkItemTextOption(EcoreUtil.copy(getTemplate().getLayoutOptions().getDefaultTextOption()));

		String topic = "";
		if (getMeeting().getStarttime() == null) {
			topic += TOPIC_AGENDA;
		} else if (getMeeting().getStarttime().compareTo(Calendar.getInstance().getTime()) < 0) {
			topic += TOPIC_PROTOKOLL;
		} else {
			topic += TOPIC_AGENDA;
		}

		TextOption headerTextOption = EcoreUtil.copy(getTemplate().getLayoutOptions().getDefaultTextOption());
		headerTextOption.setBold(true);

		UParagraph topicParagraph = new UParagraph(topic + getMeeting().getName(), headerTextOption);

		USection title = new USection(topicParagraph);

		section.add(title);
		title.getSectionOption().setLeaveOutPreviousSectionNumbering(true);
		title.getSectionOption().setSectionNumberingStyle(SectionNumberingStyle.NONE);
		title.getBoxModel().setMarginTop(20);

		if (title.getDepth() > 1 && title.getDepth() < 4) {
			title
				.getTitlParagraph()
				.getOption()
				.setFontSize(
					getTemplate().getLayoutOptions().getSectionTextOption().getFontSize()
						- getTemplate().getLayoutOptions().getSectionFontSizeDecreaseStep() * title.getDepth());
		}

		renderFhmHeader(section);

		USection contentSection = new USection("", OptionsFactory.eINSTANCE.createTextOption());
		section.add(contentSection);
		renderMeetingSections(contentSection);
	}

	private void renderFhmHeader(UCompositeSection section) {
		UTable headerTable = new UTable(2);
		headerTable.setColumnsWidths(new float[] { 70, 30 });
		section.add(headerTable);

		// left header column
		UParagraph leftBlock = new UParagraph("");
		headerTable.add(leftBlock);
		leftBlock.getBoxModel().setBorderTop(BORDER_WIDTH);
		leftBlock.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		leftBlock.getBoxModel().setMarginRight(20);

		UParagraph text_an = new UParagraph("An", textSmall);
		leftBlock.add(text_an);

		UParagraph text_teilnehmer = new UParagraph("Teilnehmer", getTemplate().getLayoutOptions()
			.getDefaultTextOption());
		leftBlock.add(text_teilnehmer);

		// right header column
		UParagraph rightBlock = new UParagraph("");
		headerTable.add(rightBlock);
		rightBlock.getBoxModel().setBorderTop(BORDER_WIDTH);
		rightBlock.getBoxModel().setBorderStyle(UBorderStyle.SOLID);

		UParagraph text_verfasser = new UParagraph("Verfasser, Organisationseinheit", textSmall);
		rightBlock.add(text_verfasser);

		String minuteTaker = "unknown";
		if (getMeeting().getMinutetaker() != null) {
			minuteTaker = getMeeting().getMinutetaker().getName();
			if (getMeeting().getMinutetaker().getEmail() != null) {
				minuteTaker += "\n" + getMeeting().getMinutetaker().getEmail();
			}
		}
		UParagraph verfasser = new UParagraph(minuteTaker, getTemplate().getLayoutOptions().getDefaultTextOption());
		rightBlock.add(verfasser);
		verfasser.getBoxModel().setMarginBottom(20);

		UParagraph text_datum = new UParagraph("Datum", textSmall);
		rightBlock.add(text_datum);
		text_datum.getBoxModel().setBorderTop(BORDER_WIDTH);
		text_datum.getBoxModel().setBorderStyle(UBorderStyle.SOLID);

		String datum;
		if (getMeeting().getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(getMeeting().getStarttime());
			datum = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
		} else {
			datum = "unknown";
		}

		UParagraph datumParagraph = new UParagraph(datum, getTemplate().getLayoutOptions().getDefaultTextOption());
		rightBlock.add(datumParagraph);
		datumParagraph.getBoxModel().setMarginBottom(20);

		UParagraph text_ort = new UParagraph("Beschprechungsort, Datum, Uhrzeit", textSmall);
		rightBlock.add(text_ort);
		text_ort.getBoxModel().setBorderTop(BORDER_WIDTH);
		text_ort.getBoxModel().setBorderStyle(UBorderStyle.SOLID);

		String ort = "";
		if (getMeeting().getLocation() != null) {
			ort += getMeeting().getLocation();
		}
		if (getMeeting().getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(getMeeting().getStarttime());
			String startTime = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);

			String endTime = "";
			if (getMeeting().getEndtime() != null) {
				cal = new GregorianCalendar();
				cal.setTime(getMeeting().getEndtime());
				endTime = " - " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);
			}

			ort += "\n" + startTime + endTime + " Uhr";
		}
		UParagraph ortParagraph = new UParagraph(ort, getTemplate().getLayoutOptions().getDefaultTextOption());
		rightBlock.add(ortParagraph);

		UParagraph text_thema = new UParagraph("Thema", textSmall);
		section.add(text_thema);

		UParagraph name = new UParagraph("Projektsitzung " + getMeeting().getName());
		section.add(name);
		name.getBoxModel().setMarginBottom(10);

		UParagraph text_teilnehmer3 = new UParagraph("Teilnehmer", textSmall);
		section.add(text_teilnehmer3);

		String teilnehmer = "";
		if (getMeeting().getParticipants().size() > 0) {
			for (OrgUnit participant : getMeeting().getParticipants()) {
				teilnehmer += participant.getName() + ", ";
			}

			teilnehmer = teilnehmer.substring(0, teilnehmer.length() - 2);
		}
		UParagraph text_teilnehmer2 = new UParagraph(teilnehmer, getTemplate().getLayoutOptions()
			.getDefaultTextOption());
		section.add(text_teilnehmer2);

	}
} // FhmMeetingRendererImpl
