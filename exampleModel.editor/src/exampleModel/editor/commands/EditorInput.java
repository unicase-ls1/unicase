package exampleModel.editor.commands;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.unicase.metamodel.Project;

public class EditorInput extends URIEditorInput {

	private final Project project;

	public EditorInput(URI uri, Project project) {
		super(uri);
		// TODO Auto-generated constructor stub
		this.project = project;
	}

	public Project getProject() {
		return project;
	}


}
