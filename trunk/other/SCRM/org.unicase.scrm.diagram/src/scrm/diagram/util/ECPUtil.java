package scrm.diagram.util;

import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.util.ModelUtil;

public final class ECPUtil {
	
	private ECPUtil() {
		
	}
	
	public static ECPModelelementContext getModelElementContext() {
		try {
			return ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
		} catch (NoWorkspaceException e) {
			ModelUtil.logException(e);
			return null;
		}
	}

}
