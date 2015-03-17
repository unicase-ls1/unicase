## Trace Client Setup Guide ##

Before using [Trace Client](TraceClient.md), it needs to be configured properly. Using Subversive, a user has to enter username/password to access a SVN server. This data is stored encrypted in the **Secure Storage** of Eclipse. Because each plugin can only access its own Secure Storage, Trace Client cannot use the already stored SVN repositories and usernames/passwords of Subversive. Therefore, the user has to first perform **Register Repositories** (context menu on a project) and enter username/password for each SVN repository (see repository list in view **SVN Repositories** in Subversive). In case one is only accessing a repository anonymously, the option "Anonymous" can be enabled.

For example, http://unicase.googlecode.com/svn would be Anonymous since one cannot commit to this repository. Only https://unicase.googlecode.com/svn (note the https) allows committing files.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/registerrepositories-menu.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/registerrepositories-menu.png)

Please perform Register Repositories **only** after you added a new Repository to SVN. You can skip already existing repositories by just selecting **Cancel**.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/registerrepositories.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/registerrepositories.png)

An information dialog is shown in case the registration was successful or not.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/registerrepositories-info.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/registerrepositories-info.png)

All repositories with the usernames/passwords are saved in the Secure Storage of Eclipse under "org.unicase.trace". The Secure Storage can also be deleted. This requires a restart of Eclipse and again registering all repositories.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/securepreferences.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/securepreferences.png)

## Trace Client Preferences ##

[Trace Client](TraceClient.md) provides various preferences that can be configured in Eclipse > Preferences > Unicase.

### SVN Preferences ###
Trace Client needs to query SVN information after each Commit operation from SVN Server. This query is delayed to wait until SVN Server created new Revision by a pre-defined query delay of **5 seconds**. This query delay can be changed in case large Commit operations not finished in 5 seconds will be performed.

Additionally, adding work items before Commit can be enabled/disabled. This option is **enabled by default**.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/tracesvnpreferences.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/tracesvnpreferences.png)

### UI Preferences ###

It can be enabled/disabled whether file resources shall be decorated with blue dots to indicate that they are linked to requirements. This option is **enabled by default**. These requirements are shown in the view **Requirements Context**

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceuipreferences.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceuipreferences.png)

Furthermore, it can be enabled/disabled whether project statistics shall be saved. This option is **disabled by default**. The project statistics are stored inside a UNICASE project in a document called "Statistics". These statistics are **automatically managed and are stored anonymously**. Only people who have access to the project **AND** have the proper plugin to analyse these statistics can access them. Please contact [Alexander Delater](http://se.ifi.uni-heidelberg.de/people/alexander_delater.html) if you want access to the analysis plugin.