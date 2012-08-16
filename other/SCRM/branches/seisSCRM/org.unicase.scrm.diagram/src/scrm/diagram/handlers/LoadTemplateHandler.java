package scrm.diagram.handlers;

import scrm.diagram.common.SCRMTemplateManager;

public class LoadTemplateHandler extends AbstractLoadTemplateHandler {

	private static final String[] templateFileExtensions = new String[] {"*.*", "*.scrm"};

	@Override
	protected SCRMTemplateManager getTemplateManager() {
		return new SCRMTemplateManager();
	}

	@Override
	protected String[] getTemplateFileExtensions() {
		return templateFileExtensions;
	}

}
