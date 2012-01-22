package humandiagramgef;

import humanbodymodel.HumanContainer;
import humanbodymodel.HumanbodymodelFactory;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.ui.PlatformUI;

public class HumanDiagramGraphicalEditor extends
		GraphicalEditorWithFlyoutPalette {

	public HumanDiagramGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		
	} 
		 
	protected void configureGraphicalViewer() {
	    super.configureGraphicalViewer();
	    getGraphicalViewer().setEditPartFactory(new HumanDiagramEditPartFactory());
	  } 
		  
	@Override
	protected PaletteRoot getPaletteRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		//
	}
	

	public void setContent(HumanContainer container) {
		getGraphicalViewer().setContents(container);
		
	}
	

}
