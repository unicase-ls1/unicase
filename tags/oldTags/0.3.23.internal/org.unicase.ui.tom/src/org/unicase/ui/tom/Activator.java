package org.unicase.ui.tom;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.unicase.ui.touchtable";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		
//		IElementType dropeeType = ElementTypeRegistry.getInstance().getElementType(dropee, cc);
		
//		String extensionPointID = "org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings";
//		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(extensionPointID);
//		
//		IConfigurationElement[] config = extensionPoint.getConfigurationElements();
//		for (IConfigurationElement e : config) {
//			String value = e.getValue();
//			String attribute = e.getAttribute("ref");
//			String name = e.getName();
//			IConfigurationElement[] children = e.getChildren();
//			try {
//				Object o = e.createExecutableExtension("class");
//				if (o instanceof ModelDiagramEditorPlugin) {
//					o.get
//				}
//			} catch (CoreException e1) {
//				e1.printStackTrace();
//			}
//			
//			if (o instanceof IGreeter) {
//				((IGreeter) o).greet();
//			}
//		}
//		System.out.println(config);
	}

	/**
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
