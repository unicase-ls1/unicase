package org.unicase.link.handler;

import org.eclipse.swt.graphics.Point;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import it.sauronsoftware.junique.JUnique;


public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(400, 300));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
    }

	@Override
	public void postWindowOpen() {
		super.postWindowOpen();
//		String[] args = Platform.getApplicationArgs();
//		if(args.length>0){
//			StringBuilder strB = new StringBuilder().append(args[0]);
//			JUnique.sendMessage(Platform.getProduct().getId(), strB.toString());	
//		}
		
	}
    
    
}
