# Client deployment #
To deploy a new version please proceed as follows:

**Step 1:**

Before starting the release send an email to the developer mailing list to announce that you are creating a release from a specific branch so no one can commit on the branch until further notice. Check out all the plug-ins in the branch you would like to construct the release from. Make sure that all the plug-ins are checked out directly for example: in org.unicase.developer you should check out **UnicaseFeature** and **UnicaseUpdateSite** directly.

![http://unicase.googlecode.com/files/cd1.png](http://unicase.googlecode.com/files/cd1.png)

**Step 2:**

Change the version number of all the plug-ins to the release number that you are about to upload.  This can be done by the search and replace feature available in eclipse.

![http://unicase.googlecode.com/files/cd1b.png](http://unicase.googlecode.com/files/cd1b.png)

![http://unicase.googlecode.com/files/cd2.png](http://unicase.googlecode.com/files/cd2.png)


  * **Important note:** while using the search/replace option in eclipse you should double check the information that is being replaced by using the preview functionality in order to grantee that the correct files are being modified.

**Step 3:**

Increase the version number in the feature.xml file to match the version number of the new release:
![http://unicase.googlecode.com/files/cd3.png](http://unicase.googlecode.com/files/cd3.png)

**Step 4:**

Configure the plug-ins to be included in the feature. This can be done through first deleting all the plug-ins that were previously added and then add them all again one by one. After adding the plug-ins you need to synchronize them with the release version you’re trying to deploy. Make sure that you choose the option copy versions from plug-in and fragment manifests.
![http://unicase.googlecode.com/files/cd4.png](http://unicase.googlecode.com/files/cd4.png)
![http://unicase.googlecode.com/files/cd4b.png](http://unicase.googlecode.com/files/cd4b.png)

  * **Note that**: you should delete all dependencies and compute them again to make sure that the dependencies list is updated to match with the newly added plug-ins as shown in the next figure.
![http://unicase.googlecode.com/files/cd5.png](http://unicase.googlecode.com/files/cd5.png)

**Step 5:**

In this step you need to build your update site. First you need to delete the content of the update site folder and rebuild it again. Therefore, you need to delete the artifacts.xml , content.xml amd index.html.
![http://unicase.googlecode.com/files/cd5b.png](http://unicase.googlecode.com/files/cd5b.png)

To build your update site you simply open the site.xml and add the new feature you want to publish, i.e. the UNICASE feature and then press the build all button.

![http://unicase.googlecode.com/files/cd5c.png](http://unicase.googlecode.com/files/cd5c.png)


After building your update site, you need to update the name of the repository to UNICASE in the files: artifacts.xml and Content.xml.

![http://unicase.googlecode.com/files/cd5d.png](http://unicase.googlecode.com/files/cd5d.png)

Now the feature is ready to be deployed, but before the deployment we need to commit all the changes to repository and then create a tag for the new release.

  * Notes on how to create a tag for the release:

![http://unicase.googlecode.com/files/1b723.png](http://unicase.googlecode.com/files/1b723.png)

Configure the tag according to the release version number, e.g. in this case set the "To URL" to:  `https://unicase.googlecode.com/svn/tags/XXX` (replace XXX with the your version number).

![http://unicase.googlecode.com/files/Picture%201.png](http://unicase.googlecode.com/files/Picture%201.png)

**Step 6:**

Configure the UnicaseFeature as described in Steps 1-5 above. Then, export your feature using the "Export a deployable feature":

![http://unicase.googlecode.com/files/cd5e.png](http://unicase.googlecode.com/files/cd5e.png)

In the export dialog, for destination enter a suitable directory:

![http://unicase.googlecode.com/files/cd5f.png](http://unicase.googlecode.com/files/cd5f.png)

Press Finish to export the deployable feature.

**Step 7:**

The update site should be tested locally on different instances of eclipse (preferably in different Eclipse releases like Helios, Indigo, ...):
  * New eclipse instances that don’t have UNICASE installed
  * Eclipse instances, which have UNICASE installed
In each instance of eclipse do the following:
Open your update manager in eclipse and add the site `file://<path-to-your-workspace>/<name-of-your-update-site-project>` or use add site -> local and navigate to your update site directory. Your categories and features should now appear in your update manager and you can install them.

![http://unicase.googlecode.com/files/updatesitetesting.png](http://unicase.googlecode.com/files/updatesitetesting.png)

After successfully testing the update site, you can then copy it to
  * http://code.google.com/p/unicase/wiki/UNICASEClientDownloads and
  * https://teambruegge.informatik.tu-muenchen.de/groups/unicase/wiki/50f86/Downloads.html
for final deployment.

  * **Important Note:**
Before copying the newly deployed feature to the server for final deployment, make sure to acquire a backup of the previously deployed feature in order not lose any data.