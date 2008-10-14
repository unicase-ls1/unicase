package org.unicase.documentexport.renderers.modelElement;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.documentexport.documentTemplate.DefaultModelElementRendererBuilder;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.ModelElementRenderer;
import org.unicase.model.meeting.Meeting;

public class ModelElementRendererRegistry {

	public static ArrayList<ModelElementRenderer> getSupportedModelElementRenderers(
			EClass eClass, 
			DocumentTemplate template
		) {
		ArrayList<ModelElementRenderer> ret = new ArrayList<ModelElementRenderer>();
		DefaultModelElementRendererBuilder builder = new DefaultModelElementRendererBuilder();
		ret.add(builder.build(eClass, template));
		
		if (eClass.getInstanceClass().equals(Meeting.class)) {
			ret.add(new MeetingRenderer(TemplateSaveHelper.getTemplate()));
		}
		
		return ret;
	}
}
