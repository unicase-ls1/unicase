package org.unicase.iterationplanner.ui.wizard.output;

import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.iterationplanner.entities.AssigneeExpertise;
import org.unicase.iterationplanner.entities.IIterationPlan;
import org.unicase.iterationplanner.entities.IPlannedTask;
import org.unicase.iterationplanner.planner.Planner;

public class TaskAssigneeEditingSupport extends EditingSupport {

	private Planner planner;
	private ComboBoxCellEditor comboBoxCellEditor;
	private IIterationPlan iterationPlan;
	private EditSelectedIterationPlanPage editingIterPlanWizardPage;

	public TaskAssigneeEditingSupport(ColumnViewer viewer, Planner planner, IIterationPlan iterationPlan, EditSelectedIterationPlanPage editSelectedIterationPlanPage) {
		super(viewer);
		this.planner = planner;
		this.iterationPlan = iterationPlan;
		this.comboBoxCellEditor = new ComboBoxCellEditor((Composite) viewer.getControl(), new String[]{"1"}, SWT.READ_ONLY);
		this.editingIterPlanWizardPage = editSelectedIterationPlanPage;
		
	}

	@Override
	protected boolean canEdit(Object element) {
		if(element instanceof IPlannedTask){
			comboBoxCellEditor.setItems(getAssigneeExpertiseStringArray((IPlannedTask) element));
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
		IPlannedTask pt = (IPlannedTask)element;
		
		return getIndexOf(pt.getAssigneeExpertise().getAssignee().getName() + " (expertise: " + pt.getAssigneeExpertise().getExpertise() + ")");
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

	private String[] getAssigneeExpertiseStringArray(IPlannedTask pt) {
		List<AssigneeExpertise> assigneeExpertiseList = planner.getTaskPotentialAssigneeListMap().get(pt.getTask());
		String[] result = new String[assigneeExpertiseList.size()];
		int i = 0;
		for(AssigneeExpertise ae : assigneeExpertiseList){
			result[i] = ae.getAssignee().getName() + " (expertise: " + ae.getExpertise() + ")";
			i++;
		}
		return result;
	}

	@Override
	protected void setValue(Object element, Object value) {
		IPlannedTask pt = (IPlannedTask)element;
		AssigneeExpertise ae = findAssigneeExpertise(comboBoxCellEditor.getItems()[(Integer)value], pt);
		iterationPlan.setAssigneeFor(pt, ae);
		editingIterPlanWizardPage.update();
		
	}

	private AssigneeExpertise findAssigneeExpertise(String value, IPlannedTask pt) {
		List<AssigneeExpertise> assigneeExpertiseList = planner.getTaskPotentialAssigneeListMap().get(pt.getTask());
		String assigneeName = value.substring(0, value.indexOf("(") - 1);
		for(AssigneeExpertise ae : assigneeExpertiseList){
			if(ae.getAssignee().getName().trim().equalsIgnoreCase(assigneeName.trim())){
				return ae;
			}
		}
		return assigneeExpertiseList.get(0);
	}

}
