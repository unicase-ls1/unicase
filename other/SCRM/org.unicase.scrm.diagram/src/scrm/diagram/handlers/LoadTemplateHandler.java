package scrm.diagram.handlers;

import scrm.diagram.common.SCRMTemplateManager;
import scrm.diagram.common.TemplateManager;

public class LoadTemplateHandler extends AbstractLoadTemplateHandler {

	private static final String[] filterExtensions = new String[] {"*.*", "*.scrm"};

	@Override
	protected TemplateManager getTemplateManager() {
		return new SCRMTemplateManager();
	}

	@Override
	protected String[] getTemplateFileExtensions() {
		return filterExtensions;
	}

}
