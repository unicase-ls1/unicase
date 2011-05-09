package org.unicase.ui.diagram.orgchartdiagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.diagram.GDiagram;
import org.unicase.ui.common.ModelElementOpener;
import org.unicase.ui.navigator.NoWorkspaceException;
import org.unicase.ui.navigator.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class OrgchartDiagramOpener implements ModelElementOpener {

	public OrgchartDiagramOpener() {
	}

	@Override
	public int canOpen(EObject modelElement) {
		if (modelElement instanceof GDiagram) {
			return 2;
		}
		return 0;
	}

	@Override
	public void openModelElement(EObject modelElement) {
		final GDiagram gdiagram = (GDiagram) modelElement;
		if (gdiagram.getGraphitiDiagram() == null) {
			final Diagram grDiagram = Graphiti
					.getPeCreateService()
					.createDiagram(
							"org.unicase.ui.diagram.orgchartDiagram.orgchartDiagramType",
							gdiagram.getName(), true);
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					gdiagram.setGraphitiDiagram(grDiagram);
				}
			}.run();
		}

		Diagram graphitiDiagram = gdiagram.getGraphitiDiagram();
		String providerId = GraphitiUi.getExtensionManager()
				.getDiagramTypeProviderId(graphitiDiagram.getDiagramTypeId());
		TransactionalEditingDomain editingDomain;
		try {
			editingDomain = WorkspaceManager.getInstance().getWorkSpace()
					.getEditingDomain();

			DiagramEditorInput editorInput = new DiagramEditorInput(
					EcoreUtil.getURI(graphitiDiagram), editingDomain,
					providerId);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage()
					.openEditor(editorInput, DiagramEditor.DIAGRAM_EDITOR_ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		} catch (NoWorkspaceException e1) {
			e1.printStackTrace();
		}
	}
}
