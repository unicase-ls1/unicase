# How to create an eclipse feature and an update site #

In order to publish your plug-ins you have to create an eclipse feature containing them. Therefore choose File -> New -> Project, then choose Plug-in-Development -> Feature plug-in. In the feature creation wizard type in the feature's name and complete the other fields as you wish and select the Next button.

On the following page you have to choose all plug-ins you want to integrate into your new feature: In our case choose all available plugins starting with org.unicase. and press Finish.

![http://unicase.googlecode.com/files/eeb5c.jpg](http://unicase.googlecode.com/files/eeb5c.jpg)

When you've finished, you can open the feature.xml in your feature project to add additional information:
  * Choose Information **(A)** to add a description, copyright notice or license agreement.
  * Choose Plug-ins **(B)** to look at the plug-ins integrated into this feature and the set options concerning the version number of the plug-ins. E.g. you can force all plug-ins to adopt the features version.
  * To allow auto-update you have to specify a default update site **(C)** for this feature (e.g. `http://unicase.org/update/`).
  * Now the feature is complete and we'll continue creating an update site for it: Therefore select the update site wizard **(D)**, enter a name and select finish.
Open site.xml in the update site project and add a category (e.g. "unicase plugin", "unicase RCP", "Emfstore standalone"), then add the feature you just created to this category and choose build or build all.

**Notice:** These informations aren't necessary to create the feature or the update site for test reasons.

If you want to test whether the deployment was successful open your update manager in eclipse and add the site `file://<path-to-your-workspace>/<name-of-your-update-site-project>` or use add site -> local and navigate to your update site directory. Your categories and features should now appear in your update manager and you can install them.

The last step of deployment is to copy the files from your update site project to your webserver.