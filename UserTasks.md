## Description ##
This plugin provides advanced support for specifying use tasks as user requirements, especially new sub tasks. It consist of two views depicted in the images and described in the text below.

### Contact ###
[Paul Huebner](http://se.ifi.uni-heidelberg.de/people/paul_huebner.html)

### Link to update-site ###
Please use the following update-site to install the plugin:
http://unicase.googlecode.com/svn/trunk/other/heidelberg/usertask/update/

### Tutorial for users ###
Create a new element "UserTask" from the package "usertask" in UNICASE.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/UserTaskMain.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/UserTaskMain.png)

This view provides a form to specify standard values for a user requirement. This includes the frequency the user tasks occurs as well as the start and end trigger for the user task. On the upper right corner information is provided about the contained sub tasks.  Sub tasks are more fine grained elements a user task consists of. For example, for the user task “make a pizza” there are sub tasks:“make dough”, “make covering” and “bake pizza”. Sub tasks can be created and edited in a seperate tab called “Sub Tasks”.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/UserTaskSubTasks.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/UserTaskSubTasks.png)

A sub task consists of a unique name and a description. The table provides the capabilities for sub task creation. With the help of the buttons on the upper right, it is possible to create, reorder and remove sub tasks. A sub task can contain Problems and Variants (elements on the 2nd hierarchy level). Problems (yellow symbols) and describe describe typical problems that may occur during the related sub task including an example solution. Variants (blue symbol) describe different options of asub task, e.g. in the “make covering” pizza example from above, a variant could be “make vegetarian covering”. All elements (sub tasks, variants, problems) have 3 editable text fields (Name, Description and Example of Solution).