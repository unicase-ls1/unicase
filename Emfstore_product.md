**Summary:** In this section we describe how you can configure and build stand-alone RCP product for emfstore server, most or all of the procedure is the same in case of building UNICASE stand-alone client, except the plugin selection.


## Requirements: ##

  * [Eclipse for RCP/Plug-in Developers](http://www.eclipse.org/downloads/)
  * [Delta pack for Eclipse 3.6.2 (Helios SR2)](http://download.eclipse.org/eclipse/downloads/drops/R-3.6.2-201102101200/index.php)
  * Java 1.5

### Initial Setup: ###

  * Download eclipse for RCP/Plug-in development from the eclipse project home page.
  * Download delta-pack from the link given above. Note: If you run another version than Helios 3.6.2 you need another matching delta pack. Just google for "eclipse delta pack download ->version<-" and you should be able to find it on the Eclipse project homepage. Using the wrong delta pack for your Eclipse version will lead to errors during deploy!

This is one of the core part in deploying the standalone product and the one which results in subsequent problems and issues if not done correctly.
You have to setup the build environment properly to build the product for different platform, else with the default eclipse configuration you can only build the product for that particular development environment as you are currently working on.

NOTE: please make sure that you have Java 1.5 installed on your system and is set as the default execution environment for the eclipse instance you are using to build the product. This can be confirmed in the preferences of the eclipse and then under "Java -> Installed JREs -> Execution Environment". Please restart your instance if this is the first time you have configured this.

## Adding Delta-pack plugins in eclipse: ##

Once the correct version of Java is configured for the execution environment its time to add delta pack in the target-platform setting in the plug-in development setting within the eclipse instance. Delta pack has required plugin to ship the final product for various platforms like Windows, Mac, Linux etc.

  * Hope you would have already extracted delta-pack by now, if not then its the time to extract it at your favorite location!

Following steps summarize how to add delta-pack in your eclipse instance.
  * Start your eclipse instance(the one you downloaded for RCP/plug-in development) and open the preferences.
  * Look for the plug-in development section and then walk to "Target platform" subsection within the hierarchy.
  * Once you open "Target platform" you can see the target definitions which has "Running platform (Active)" selected as default.
  * Select the Running platform and then click on the edit button available there.
  * A new panel will open with the title "Target content", here click on the Add button available within the Locations tab(default tab).
  * Select "Directory" in the next pop-up and click next.
  * Browse to the root directory where you have extracted "delta-pack" and select it.
  * Either click next or finish, either way it will import the delta-pack plugins in the current eclipse environment.
  * You will be back on "Target Content" panel, just click on "Finish" and then on "Apply" in the subsequent panel.
  * Click "OK" to finish configuring.
  * Better to restart your eclipse instance now!

## Emfstore product: ##

By this point we expect you to have a properly configured version of eclipse with delta-pack. If you still have some problem then we have a pre-configured eclipse instance for "Mac OS" which you can get from [here](http://www1.in.tum.de/static/shared/unicase/products/eclipse_for_rcp.zip), But in this instance you will have to add delta-pack as mentioned above.

  * In next steps we summarize the actual steps involved in building the emfstore product.

  * Checkout the following 6 plugins from the Google code SVN for UNICASE as per your build requirement (from trunk, branch or tag) :

  1. org.eclipse.emf.emfstore.server
  1. org.eclipse.emf.emfstore.server.model
  1. org.eclipse.emf.emfstore.common
  1. the model that you want to include or e.g. org.eclipse.emf.emfstore.examplemodel (which is the "Bowling" model)

  * There is no need to add the corresponding ".edit" plug-ins for your model. These are only needed for ECP.

  * Rename the version number in all 4 plugins to the version you want to release, this you can do in Manifest file for each and every plugin.
  * Expand the hierarchy of "org.eclipse.emf.emfstore" plugin in the package explorer and look for a file named "emfstore.product". It should be right under the root node in the hierarchy along with the "plugin.xml" file.
  * Open the "emfstore.product" file and change the version number here as well as you did for the plugins previously.
  * Below in "Product definition" section make sure that the "Product" and "Application" both have "org.eclipse.emf.emfstore.server.server" selected.
  * The product configuration is based on: plug-ins and not features(It can be based on feature but not in our case at the moment).

Open "Dependencies" tab for the emfstore.product" :

  * Click on the "Add" button and type "org.eclipse"
  * you will get to see all 4 plugins we downloaded previously(you can verify by the version number you gave to them and the one visible currently).
  * Add all 6 of them. Once you add them all you will see that the plugin version is shown as "(0.0.0)" following their name.
  * Select each of the plugin one after another and then click "Properties..." button on the right and change the version to the same version number you had been using so far.
  * Once the previous step is done select the "checkbox" with label "Include optional dependencies when computing required plug-ins".
  * Click on "Add Required Plug-ins" button to do the same as it means.

You can further configure various things within the "Splash", "Branding","Launching" tabs as well. But as per the core functionality, we are done!

  1. Go back to "Overview" tab and click on "Synchronize" link within "Testing" section.
  1. Launch the application in normal or debug mode to see if its working fine.
  1. If its working fine then its time to export it for stand-alone use.
  1. Use the link within "Exporting" section to get to "Eclipse product export wizard".

## Exporting : ##

  * Insert the destination information in the "Eclipse product export wizard".
  * Select "Export for multiple platforms" within "Export Options". (This option won't be available if your eclipse instance is not properly configure with delta-pack)
  * Select the platforms you want to export your product for.
  * Click finish and "wait and watch"..If { the progress dialogue disappears without any message } then { you are done }..else...{ Try to fix the problem based on error message! }
