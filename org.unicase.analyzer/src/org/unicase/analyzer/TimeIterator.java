/**
 * 
 */
package org.unicase.analyzer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author liya
 */
public class TimeIterator extends VersionIterator {

	private DateVersionSpec dateSpec;

	private int stepLengthUnit;

	/**
	 * By default, the iterator will go through from version 0 to Head version, and the next() method will return the
	 * copy of ProjectAnalysisData instead of ProjectAnalysisData
	 * 
	 * @param usersession the session id for authentication
	 * @param projectId the project id of the project to get
	 * @param stepLength the step length for the iterator to go through to the next
	 * @param stepLengthUnit the unit of time step length based on Calendar's static field, e.g. Calendar.SECOND
	 * @throws IteratorException if any error occurs
	 * @generated NOT
	 */
	public TimeIterator(Usersession usersession, ProjectId projectId, int stepLength, int stepLengthUnit)
		throws IteratorException {

		this(usersession, projectId, stepLength, stepLengthUnit,
			VersioningFactory.eINSTANCE.createPrimaryVersionSpec(),
			VersioningFactory.eINSTANCE.createHeadVersionSpec(), true, true);
	}

	/**
	 * @param usersession the session id for authentication
	 * @param projectId the project id of the project to get
	 * @param stepLength the step length for the iterator to go through to the next
	 * @param stepLengthUnit the unit of time step length based on Calendar's static field, e.g. Calendar.SECOND
	 * @param start the version for the iterator to start from
	 * @param end the version for the iterator to end with
	 * @param isForward the direction for the iterator go through, either forward(true) or backward(false). However,
	 *            doesn't work for backward currently, will be solved in the near future
	 * @param returnProjectDataCopy the next() method will return the copy of ProjectAnalysisData when it is set to true
	 * @throws IteratorException if any error occurs
	 * @generated NOT
	 */
	public TimeIterator(Usersession usersession, ProjectId projectId, int stepLength, int stepLengthUnit,
		VersionSpec start, VersionSpec end, boolean isForward, boolean returnProjectDataCopy) throws IteratorException {

		super(usersession, projectId, stepLength, start, end, true, isForward, returnProjectDataCopy);
		this.stepLengthUnit = stepLengthUnit;

		this.dateSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
		if (start instanceof DateVersionSpec) {
			this.dateSpec = (DateVersionSpec) start;
		} else {
			HistoryQuery historyQuery = VersioningFactory.eINSTANCE.createHistoryQuery();
			historyQuery.setSource(this.getStart());
			historyQuery.setTarget(this.getEnd());
			List<HistoryInfo> projectHistory = null;
			try {
				projectHistory = this.getConnectionManager().getHistoryInfo(usersession.getSessionId(), projectId,
					historyQuery);
			} catch (InvalidVersionSpecException e) {
				throw new IteratorException("Could not get the history info.", e);
			} catch (EmfStoreException e) {
				throw new IteratorException("Cannot connect to server.", e);
			}
			Date dateStart = projectHistory.get(0).getLogMessage().getDate();
			this.dateSpec.setDate(dateStart);
		}

		updateSpecifier(getSourceSpec(), stepLength, !isForward);

		if (isForward) {
			if (getSourceSpec().getIdentifier() < 0) {
				getSourceSpec().setIdentifier(this.getStart().getIdentifier());
			}
		} else {
			if (getSourceSpec().compareTo(this.getEnd()) > 0) {
				getSourceSpec().setIdentifier(this.getEnd().getIdentifier());
			}
		}

	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.VersionIterator#updateSpecifier(org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec, int, boolean)
	 */
	@Override
	protected void updateSpecifier(PrimaryVersionSpec specifier, int stepLength, boolean isForward) {

		if(dateSpec!=null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateSpec.getDate());
	
			if (isForward) {
				calendar.add(stepLengthUnit, stepLength);
			} else {
				calendar.add(stepLengthUnit, -stepLength);
			}
			dateSpec.setDate(calendar.getTime());
			try {
				PrimaryVersionSpec temp = this.getConnectionManager().resolveVersionSpec(getUsersession().getSessionId(),
					getProjectId(), dateSpec);
				specifier.setIdentifier(temp.getIdentifier());
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Couldn't be resolved", e);
			}
		}
	}
	
	public DateVersionSpec getDateSpec() {
		return dateSpec;
	}

}
