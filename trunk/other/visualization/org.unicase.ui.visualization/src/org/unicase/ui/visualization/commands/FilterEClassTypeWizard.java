package org.unicase.ui.visualization.commands;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.ui.visualization.views.VisualizationView;

public class FilterEClassTypeWizard extends Wizard implements IWorkbenchWizard {
	
	private List<EClass> eClassTypes;

	private boolean treePageCompleted;
	
	private VisualizationView view;
	
	public FilterEClassTypeWizard(VisualizationView view){
		this.view = view;
	}

	@Override
	public void addPages() {
		addPage(new FilterEClassPage("SelectEClassPage"));
	}

	@Override
	public boolean performFinish() {
		if (eClassTypes != null) view.showFiltered(eClassTypes);
		return true;
	}
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {}

	@Override
	public boolean canFinish() {
		return treePageCompleted;
	}

	public void setEClassTypes(List<EClass> eClassTypes) {
		this.eClassTypes = eClassTypes;
	}

	public void setTreePageCompleted(boolean treePageCompleted) {
		this.treePageCompleted = treePageCompleted;
	}
}
