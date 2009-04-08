/**
 * 
 */
package org.unicase.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author liya
 *
 */
public class TimeIterator implements Iterator<ProjectAnalysisData> {

	private final Usersession usersession;
	private final ProjectId projectId;
	private final int stepLength;
	private ConnectionManager connectionManager;
	private PrimaryVersionSpec targetSpec;
	private DateVersionSpec dateSpec;
	private final String direction;
	private final Date start;
	private final Date end;

	public TimeIterator(Usersession usersession, ProjectId projectId, int stepLength) {
		this.usersession = usersession;
		this.projectId = projectId;
		this.stepLength = stepLength;
		this.connectionManager=WorkspaceManager.getInstance().getConnectionManager();
		this.targetSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		this.dateSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
		this.direction = "forward";
		
		PrimaryVersionSpec resolvedSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		try {
			resolvedSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), 
					projectId, VersioningFactory.eINSTANCE.createHeadVersionSpec());
		} catch (EmfStoreException e1) {
			WorkspaceUtil.logException("Couldn't be resolved", e1);
		}

		HistoryQuery historyQuery = VersioningFactory.eINSTANCE.createHistoryQuery();
		historyQuery.setSource(targetSpec);
		historyQuery.setTarget(resolvedSpec);
		List<HistoryInfo> projectHistory = null;
		try {
			projectHistory = this.connectionManager.getHistoryInfo(usersession.getSessionId(),
					projectId, historyQuery);
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
		this.start = projectHistory.get(0).getLogMessage().getDate();

		this.end = projectHistory.get(projectHistory.size()-1).getLogMessage().getDate();
	}
	
	public TimeIterator(Usersession usersession, ProjectId projectId, int stepLength,
		Date start, Date end, String direction) {
		this.usersession = usersession;
		this.projectId = projectId;
		this.stepLength = stepLength;
		this.connectionManager=WorkspaceManager.getInstance().getConnectionManager();
		this.targetSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		this.dateSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
		this.direction = direction;
		this.start = start;
		this.end = end;
		this.dateSpec.setDate(start);		
		try {
			this.targetSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), projectId, dateSpec);
		} catch (EmfStoreException e) {
			WorkspaceUtil.logException("Couldn't be resolved", e);
		}
	}
	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {

		PrimaryVersionSpec resolvedSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		DateVersionSpec resDateSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
		
		if(direction == "forward"){
			resDateSpec.setDate(end);
			try {
				resolvedSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), 
						projectId, resDateSpec);
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Couldn't be resolved", e);
			}
		
			return targetSpec.compareTo(resolvedSpec)<0;
		}
		else{

			resDateSpec.setDate(end);
			try {
				resolvedSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), projectId, resDateSpec);
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Couldn't be resolved", e);
			}
		
			return targetSpec.compareTo(resolvedSpec)>0;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#next()
	 */
	public ProjectAnalysisData next() {
		ProjectAnalysisData projectdata = AnalyzerFactory.eINSTANCE.createProjectAnalysisData();
		List<ChangePackage> changepackage = new ArrayList<ChangePackage>();
		changepackage = projectdata.getChangePackages();
		
		PrimaryVersionSpec sourceSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		
		int step;
		if(direction == "backward"){
			step = -stepLength;
		}
		else{
			step = stepLength;
		}
		
		if(!hasNext()){
			throw new NoSuchElementException("Has no next");
		}
		else{
			Project project = null;
			try {
				project = connectionManager.getProject(usersession.getSessionId(), projectId, targetSpec);
				projectdata.setProjectState(project);
				
				ProjectId projectIdCopy = (ProjectId)EcoreUtil.copy(projectId);
				projectdata.setProjectId(projectIdCopy);
				
				PrimaryVersionSpec primarSpecCopy = (PrimaryVersionSpec)EcoreUtil.copy(targetSpec);
				projectdata.setPrimaryVersionSpec(primarSpecCopy);
				
				Calendar calendar = Calendar.getInstance();				
				calendar.setTime(dateSpec.getDate());
				
				if(dateSpec.getDate() == start){
					//changepackage.add(null);
					//projectdata.getChangePackages().add(null);
				}
				else{
					
					calendar.add(Calendar.SECOND, -step);
					DateVersionSpec srcDateSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
					srcDateSpec.setDate(calendar.getTime());
					
					try {
						sourceSpec = connectionManager.resolveVersionSpec(usersession.getSessionId(), projectId, srcDateSpec);
					} catch (EmfStoreException e1) {
						WorkspaceUtil.logException("Couldn't be resolved", e1);
					}
					
					try {
						changepackage.addAll(connectionManager.getChanges(usersession.getSessionId(), projectId, sourceSpec, targetSpec));
					} catch (EmfStoreException e) {
							WorkspaceUtil.logException("Couldn't get Changes", e);
							e.printStackTrace();
					}
				}

				calendar.add(Calendar.SECOND, 2*step);
				dateSpec.setDate(calendar.getTime());
				try {
					targetSpec = connectionManager.resolveVersionSpec(usersession.getSessionId(), projectId, dateSpec);
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException("Couldn't be resolved", e);
				}
				
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Couldn't get project", e);
				e.printStackTrace();
			}
		}
		return projectdata;
	}

	/** 
	 * {@inheritDoc}
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		// TODO Auto-generated method stub

	}
}
