package org.unicase.papyrus.sysml.diagram.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.unicase.papyrus.PapyrusFactory;
import org.unicase.papyrus.SysMLClass;
import org.unicase.papyrus.SysMLModel;
import org.unicase.ui.common.commands.ECPCommand;

public class SysMLInitUtil {
	
	public static void initialize(EObject eObject) {
		if(eObject instanceof SysMLClass) {
			defaultInitialization((SysMLClass) eObject, null, 
					org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ParametricEditPart.MODEL_ID,
					org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		}
	}
	
	private static void defaultInitialization(final SysMLClass clazz,
			final PackageableElement element, 
			final String id, final PreferencesHint hint) {
		
		new ECPCommand(clazz) {
			@Override
			protected void doRun() {
				org.eclipse.uml2.uml.Class myClass = UMLFactory.eINSTANCE.createClass();
				final Diagram diagram = ViewService.createDiagram(myClass, id, hint);
				
				diagram.setElement(clazz);
				clazz.setGmfDiagram(diagram);
			}
		}.run(true);
	}

	private static void initElement(PackageableElement element,
			PreferencesHint hint) {
		
	}
}
