package org.unicase.documentexport.renderers.modelElement;

import java.util.ArrayList;

import org.unicase.documentexport.TemplateSaveHelper;
import org.unicase.documentexport.renderers.ModelElementRenderer;
import org.unicase.model.ModelElement;
import org.unicase.model.meeting.Meeting;

public class ModelElementRendererRegistry {

	public static ArrayList<ModelElementRenderer> getSupportedModelElementRenderers(Class<ModelElement> clazz) {
		ArrayList<ModelElementRenderer> ret = new ArrayList<ModelElementRenderer>();
		//DefaultModelElementRendererBuilder builder = new DefaultModelElementRendererBuilder();
		//ret.add(builder.build(me, template));
		
		if (clazz.equals(Meeting.class)) {
			ret.add(new MeetingRenderer(TemplateSaveHelper.getTemplate()));
		}
		
		return ret;
	}
}
