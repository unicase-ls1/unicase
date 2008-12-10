package org.unicase.client;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * Workbench window advisor for unicase.
 * @author naugthon
 *
 */
public class UnicaseWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    /**
     * Default constructor.
     * @param configurer the configurer
     */
    public UnicaseWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    /** 
     * {@inheritDoc}
     * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#createActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)
     */
    @Override
	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new UnicaseActionBarAdvisor(configurer);
    }
    
    /** 
     * {@inheritDoc}
     * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#preWindowOpen()
     */
    @Override
	public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(1024, 768));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(false);
    }
}
