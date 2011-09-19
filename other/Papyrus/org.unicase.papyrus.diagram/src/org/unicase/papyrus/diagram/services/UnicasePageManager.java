package org.unicase.papyrus.diagram.services;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.swt.widgets.Display;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.metamodel.Project;
import org.unicase.papyrus.UMLModel;
import org.unicase.ui.common.commands.DeleteModelElementCommand;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class UnicasePageManager implements IPageMngr {
	
	private Project project;
	
	public UnicasePageManager(Project project) {
		this.project = project;
	}

	public void addPage(Object pageIdentifier) {
		throw new UnsupportedOperationException();
	}

	public void removePage(Object pageIdentifier) {
		EObject elementToDelete = null;
		if(pageIdentifier instanceof Diagram) {
			// delete the corresponding UMLModel instead of only the diagram
			elementToDelete = ((Diagram) pageIdentifier).getElement();
		} else if(pageIdentifier instanceof EObject) {
			elementToDelete = (EObject) pageIdentifier;
			// EObject is not contained by project -> can't be deleted
			if(!project.containsInstance(elementToDelete)) {
				return;
			}
		}
		if(elementToDelete == null) {
			return;
		}
		// delete the element from the project
		new DeleteModelElementCommand(elementToDelete, 
				ECPWorkspaceManager.getECPProject(elementToDelete)).run();
	}

	public void closePage(Object pageIdentifier) {
		throw new UnsupportedOperationException();
	}

	public void closeAllOpenedPages() {
		throw new UnsupportedOperationException();
	}

	public void closeOtherPages(Object pageIdentifier) {
		throw new UnsupportedOperationException();
	}

	public void openPage(Object pageIdentifier) {
		if(pageIdentifier instanceof Diagram) {
			ActionHelper.openModelElement(
					((Diagram) pageIdentifier).getElement(), "");
		} else if(pageIdentifier instanceof EObject) {
			EObject eObject = (EObject) pageIdentifier;
			if(project.containsInstance(eObject)) {
				ActionHelper.openModelElement(eObject, "");
			}
		}
	}

	public List<Object> allPages() {
		final List<Object> result = new LinkedList<Object>();
		for(EObject me : project.getAllModelElements()) {
			if(me instanceof UMLModel) {
				final UMLModel model = (UMLModel) me;
				Diagram diagram = model.getGmfDiagram();
				if(diagram == null) {
						new UnicaseCommand() {

							@Override
							protected void doRun() {
								try {
									model.loadDiagramLayout();
									result.add(model.getGmfDiagram());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						}.run(true);
				} else {
					result.add(diagram);
				}
				
			}

		}
		return result;
	}

	public boolean isOpen(Object pageIdentifier) {
		return false;
	}

}
