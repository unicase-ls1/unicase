/**
 * 
 */
package org.unicase.ui.common.util;

/**
 * @author stefan.bleibinhaus
 *
 */
public class ExtProgramFactoryFacadeImpl extends ExtProgramFactoryFacade{

	@Override
	boolean useEmailIntern(String mailto) {
		return launch(mailto);
	}

	@Override
	boolean launchURLIntern(String url) {
		return launch(url);
	}
	
	private boolean launch(String url) {
		return false; //TODO: Not supported yet
	}

}
