package humandiagramgef;

import humanbodymodel.HumanContainer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.ui.parts.GraphicalEditor;

public class HumanDiagramGraphicalEditor extends GraphicalEditor {

	public HumanDiagramGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}

	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new HumanDiagramEditPartFactory());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		//
	}

	public void setContent(HumanContainer container) {
		getGraphicalViewer().setContents(container);
	}

	@Override
	protected void initializeGraphicalViewer() {
		// TODO Auto-generated method stub

	}
}
