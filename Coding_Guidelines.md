**_NOTE: Generally coding guidelines apply only for the code that was not generated._**

  * It is always a good practice to add "// begin of custom code" before (including the javadoc) and a "// end of custom code" after your custom code in generated emf classes.<br> This helps checkstyle to exactly match generated and custom code and it also helps a reviewer to identify custom code.<br>
<ul><li>Please add comments wherever you feel might be useful for you, and others.<br>
</li><li>Always give valid description about any significant modification in the code while committing the project in the repository.</li></ul>


We use checkstyle to check code against our coding guidelines and for code formatting, we use default Eclipse formatter (Eclipse (built-in)).Please install the Eclipse checkstyle plugin from the update site given in <a href='http://code.google.com/p/unicase/wiki/Getting_started_as_developer'>Getting started</a> section of this wiki. Please also checkout the developer folder from our repository (trunk/developer), since it contains the coding guidelines.<br>
<br>
<br>
<b>Please configure checkstyle as follows (also see screenshot below):</b>

<ol><li>Open preferences.<br>
</li><li>Select "Checkstyle".<br>
</li><li>Select "New..."<br>
</li><li>Choose "Project Relative Configuration" as type.<br>
</li><li>Enter "unicaseStyle" as name. (Caution: Be sure to use exactly this name!)<br>
</li><li>If you have installed the 5.x release of checkstyle (default, if you just downloaded it from the update site), select developer/coding.guidelines/unicaseStyle5.x.xml. Otherwise (version 4.4.x) select developer/coding.guidelines/unicaseStyle.xml as location (You need to checkout the developer folder from svn, see above).<br>
</li><li>Click OK.<br>
</li><li>Set unicaseStyle as default checkstyle configuration.</li></ol>



<b><i>NOTE: Checkstyle should now be activated for all UNICASE projects since it is configured so in the .project file you received during checkout. If it is not active right click all projects and select Checkstyle -> Activate Checkstyle</i></b>

How to set up the Javadoc warnings in Eclipse: <a href='http://unicase.googlecode.com/files/UnicaseEclipseWarnings.mov.qt'>Video tutorial</a> (This is now only necessary for newly created plugins, since it is now also configured in the .project file)<br>
<br>
The UNICASE project also uses specific Java formatting settings to avoid whitespace conflicts. All existing plugins are configured to use these settings by default, but you have to import the UNICASE formatter file into Eclipse as follows:<br>
<br>
<br>
<br>
<ol><li>Open preferences<br>
</li><li>Select Java/Code Style/Formatter<br>
</li><li>Select "Import..."<br>
</li><li>Choose the UNICASE formatter file found in the org.unicase.developer plugin under formatting/unicaseFormatter.xml or here:<br>
<blockquote>Download file <a href='http://unicase.googlecode.com/files/unicaseFormatter.xml'>"unicaseFormatter.xml"</a>
</blockquote></li><li>Confirm with ok</li></ol>


Now the UNICASE specific autoformatting rules should be applied everytime format is called.<br>
<br>
The coding guidelines may not be very sensible in some situations, please discuss them with us on the <a href='http://code.google.com/p/unicase/wiki/Mailinglist'>mailing list</a> if you feel the guidelines should be changed. However this is no excuse unless the guidelines are changed... ;)<br>
<br>
Please note that both the Eclipse java guidelines and the Checkstyle settings are workspace specific and not global for your Eclipse installation.<br>
<br>
<img src='http://unicase.googlecode.com/files/checkstyle.png' />


UNICASE uses project specific code template for which the template can be download from here <a href='http://unicase.googlecode.com/files/codetemplates.xml'>codetemplates.xml</a>. To set-up UNICASE specific Code Templates go to : Project Context Menu -> Properties -> Java Code Style -> Code Templates -> Import<br>
<br>
<img src='http://unicase.googlecode.com/files/unicasecodetemplate.png' />

<br>


and then select the template downloaded from the link mentioned above. Now click on "apply" button for changes to take effect and then "OK" to finish the setup.<br>
<br>
<br>