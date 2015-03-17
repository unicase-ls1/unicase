# Release Tutorial #
This tutorial describes how to release plugins.

**Step 1:**

Open the plugin's plugin.xml file. It should have a version number ending with ".qualifier":

![http://unicase.googlecode.com/files/dfb0a.png](http://unicase.googlecode.com/files/dfb0a.png)

Change this old version number to the new one (e.g. 0.1.0) **without** a ".qualifier" ending:

![http://unicase.googlecode.com/files/a531d.png](http://unicase.googlecode.com/files/a531d.png)

**Note:**
  * If you want to release all plugins, you can use search and replace from eclipse.
  * Please note that you have to change the bundle version of the dependencies too, through the search and replace feature of Eclipse.
  * You need to use the preview functionality while doing search and replace to make sure that only required files gets modified!

**Step 2:**

Commit the version change:

![http://unicase.googlecode.com/files/60c2b.png](http://unicase.googlecode.com/files/60c2b.png)

**Step 3:**

Create a tag for the release:

**NOTE:** You can do this step "step 3" before starting with the "step 1" as creating tag at this moment will theoretically make you upload the whole plugin to the SVN server, but if you do it in advance then you only need to commit the changes.

![http://unicase.googlecode.com/files/1b723.png](http://unicase.googlecode.com/files/1b723.png)

Configure the tag according to the release version number, e.g. in this case set the "To URL" to:  `https://unicase.googlecode.com/svn/tags/0.1.0/org.unicase.ui.navigator` (replace org.unicase.ui.navigator with the plugin you are working with and 0.1.0 with your version).
<br>
<br>
<img src='http://unicase.googlecode.com/files/commitapluginintag.PNG' width='70%' height='70%'>

<br>
If you release all plugins, use: <code>https://unicase.googlecode.com/svn/tags/X.X.X</code>



<img src='http://unicase.googlecode.com/files/commitmultiplepluginsintag.PNG' width='70%' height='70%'>

<br>

<b>Step 4:</b>

Deploy features if you want to See the <a href='http://code.google.com/p/unicase/wiki/Deploy'>Deployment page.</a>

<b>Step 5:</b>

Update the version in the plugin.xml to a new ".qualifier" version again. This version must be higher then the released version to avoid version conflicts in the development environment:<br>
<br>
<img src='http://unicase.googlecode.com/files/e5783.png' />

Commit,these steps create a release version of a plugin.