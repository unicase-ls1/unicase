package org.unicase.iterationplanner.ui.wizard.output;

import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;
import org.unicase.iterationplanner.planner.Planner;

public class TaskAssigneeEditingSupport extends EditingSupport {

	private Planner planner;
	private ComboBoxCellEditor comboBoxCellEditor;
	private IterationPlan iterationPlan;

	public TaskAssigneeEditingSupport(ColumnViewer viewer, Planner planner, IterationPlan iterationPlan) {
		super(viewer);
		this.planner = planner;
		this.iterationPlan = iterationPlan;
		this.comboBoxCellEditor = new ComboBoxCellEditor((Composite) viewer.getControl(), new String[]{"1"}, SWT.READ_ONLY);
		
	}

	@Override
	protected boolean canEdit(Object element) {
		if(element instanceof PlannedTask){
			comboBoxCellEditor.setItems(getAssigneeExpertiseStringArray((PlannedTask) element));
			return true;
		}
		return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return comboBoxCellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		PlannedTask pt = (PlannedTask)element;
		
		return getIndexOf(pt.getAssigneeExpertise().getAssignee().getOrgUnit().getName() + " (expertise: " + pt.getAssigneeExpertise().getExpertise() + ")");
	}

	private Integer getIndexOf(String string) {
		int i = 0;
		for(String item : comboBoxCellEditor.getItems()){
			if(item.equals(string)){
				return i;
			}
			i++;
		}
		return 0;
	}

	private String[] getAssigneeExpertiseStringArray(PlannedTask pt) {
		List<AssigneeExpertise> assigneeExpertiseList = planner.getTaskPotentialAssigneeListMap().get(pt.getTask());
		String[] result = new String[assigneeExpertiseList.size()];
		int i = 0;
		for(AssigneeExpertise ae : assigneeExpertiseList){
			result[i] = ae.getAssignee().getOrgUnit().getName() + " (expertise: " + ae.getExpertise() + ")";
			i++;
		}
		return result;
	}

	@Override
	protected void setValue(Object element, Object value) {
		PlannedTask pt = (PlannedTask)element;
		AssigneeExpertise ae = findAssigneeExpertise(comboBoxCellEditor.getItems()[(Integer)value], pt);
		iterationPlan.setAssigneeFor(pt, ae);
		getViewer().refresh();
		
	}

	private AssigneeExpertise findAssigneeExpertise(String value, PlannedTask pt) {
		List<AssigneeExpertise> assigneeExpertiseList = planner.getTaskPotentialAssigneeListMap().get(pt.getTask());
		String assigneeName = value.substring(0, value.indexOf("(") - 1);
		for(AssigneeExpertise ae : assigneeExpertiseList){
			if(ae.getAssignee().getOrgUnit().getName().trim().equalsIgnoreCase(assigneeName.trim())){
				return ae;
			}
		}
		return assigneeExpertiseList.get(0);
	}

}
