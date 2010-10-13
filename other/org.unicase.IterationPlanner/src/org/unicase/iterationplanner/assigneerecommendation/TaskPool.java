package org.unicase.iterationplanner.assigneerecommendation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class TaskPool {

	private static TaskPool instance;
	private List<Task> tasksToPlan;
	@SuppressWarnings("unused")
	private Project project;
	private EList<WorkItem> allWorkItems;

	public static TaskPool getInstance() {
		if (instance == null) {
			instance = new TaskPool();
		}
		return instance;
	}

	private TaskPool() {
		initTaskPool();
	}

	private void initTaskPool() {

	}

	public List<Task> getTasksToPlan() {
		if (tasksToPlan == null) {
			tasksToPlan = new ArrayList<Task>();
		}
		return tasksToPlan;
	}

	public void setTasksToPlan(List<WorkItem> workItems) {
		tasksToPlan = new ArrayList<Task>();
		for (WorkItem wi : workItems) {
			if (wi instanceof Checkable) {
				try {
					tasksToPlan.add(new Task(wi));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setRequirements(List<FunctionalRequirement> reqirements) {

	}

	/**
	 * all done tasksToPlan in project done tasksToPlan are those that are resolved or checked
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<WorkItem> getAllDoneWorkItems() {
		List<WorkItem> doneWorkItems = new ArrayList<WorkItem>();
		for (WorkItem workItem : allWorkItems) {
			if (workItem instanceof Checkable) {
				if (((Checkable) workItem).isChecked() || workItem.isResolved()) {
					doneWorkItems.add(workItem);
				}
			}
		}
		return doneWorkItems;
	}

	/**
	 * get related tasksToPlan (using all done tasksToPlan, predecessors, successors, requirements, refining
	 * requirements, refined requirements) this is used for Model Based Assignee Recommendation
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Task> getRelatedTasks(Task task) throws Exception {
		WorkItem workItem = task.getWorkItem();
		// find model elements annotated with this task
		List<UnicaseModelElement> relatedMEs = new ArrayList<UnicaseModelElement>();
		relatedMEs.addAll(workItem.getAnnotatedModelElements());

		// if you found a requirement in related MEs then take its parent
		// and add all refinig requirements of parenet requiremnt to related MEs
		for (UnicaseModelElement me : workItem.getAnnotatedModelElements()) {
			if (me instanceof FunctionalRequirement) {
				FunctionalRequirement parentRequirement = ((FunctionalRequirement) me).getRefinedRequirement();
				if (parentRequirement == null) {
					parentRequirement = (FunctionalRequirement) me;
				}
				relatedMEs.addAll(getAllRefiningRequirements(parentRequirement));
			}

		}

		// all work items annotating related model elements are relevant
		List<Task> relatedTasks = new ArrayList<Task>();
		for (UnicaseModelElement me : relatedMEs) {
			for (Annotation annotation : me.getAnnotations()) {
				if (annotation instanceof WorkItem) {
					if (annotation instanceof Checkable) {
						relatedTasks.add(new Task((WorkItem) annotation));
					} else if (annotation instanceof WorkPackage) {
						relatedTasks.addAll(getTasks((WorkPackage) annotation));
					}
				}
			}
		}

		return relatedTasks;

		// List<Task> relatedTasks = new ArrayList<Task>();
		// List<WorkItem> doneWorkItems = getAllDoneWorkItems();
		// for (WorkItem workItem : doneWorkItems) {
		// if (areRelated(task, workItem)) {
		// relatedTasks.add(new Task(workItem));
		// }
		// }
		// return relatedTasks;
	}

	private List<Task> getTasks(WorkPackage wp) {
		List<Task> result = new ArrayList<Task>();
		for (ModelElement me : wp.getAllContainedModelElements()) {
			if (me instanceof WorkItem && me instanceof Checkable) {
				try {
					result.add(new Task((WorkItem) me));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * getAllRefiningRequirements recursive.
	 * 
	 * @param req req.
	 * @return getAllRefiningRequirements recursive.
	 */
	public List<FunctionalRequirement> getAllRefiningRequirements(FunctionalRequirement req) {
		List<FunctionalRequirement> result = new ArrayList<FunctionalRequirement>();
		for (FunctionalRequirement fr : req.getRefiningRequirements()) {
			result.add(fr);
			result.addAll(getAllRefiningRequirements(fr));
		}
		return result;
	}

	@SuppressWarnings("unused")
	private boolean areRelated(Task task, WorkItem workItem) {
		WorkItem myWorkItem = task.getWorkItem();

		workItem.getAnnotatedModelElements();
		workItem.getPredecessors();
		workItem.getSuccessors();

		return false;
	}

	public void setProject(Project project) {
		this.project = project;
		allWorkItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<WorkItem>());
	}

}
