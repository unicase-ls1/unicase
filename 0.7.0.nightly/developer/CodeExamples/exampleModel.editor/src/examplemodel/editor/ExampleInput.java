package examplemodel.editor;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.ModelElement;

public class ExampleInput extends URIEditorInput {


	private final ModelElement modelelement;

	public ExampleInput(ModelElement modelelement) {
		super(EcoreUtil.getURI(modelelement));
		this.modelelement = modelelement;
		
	}

	public ModelElement getModelelement() {
		// TODO Auto-generated method stub
		return modelelement;
	}

	

}
