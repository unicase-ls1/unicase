## Description ##
This plugin provides (semi-) automatic creation and usage of traceability links between requirements, work items and source code during development. Trace Client integrates itself seamlessly into the Eclipse IDE and Subversive (plug-in for Subversion). The main features of Trace Client are: (semi-) automatic creation of traceability links, requirements impact analysis, traceability between requirements and code, progress of requirements implementation, graph visualization.

UNICASE integrates system modeling (e.g. requirements) with project management (e.g. work items). Thus, UNICASE consists of a **system model** and a **project model** unified in a single model. Trace Client adds a third model called **code model** to UNICASE, which allows linking project management activities (work items) to the resulting implementation (code) during development. Using sophisticated algorithms, traceability links between requirements and code can automatically be created using inter-linked work items. Thus, Trace Client can achieve automated traceability between requirements and code during development. These traceability links are the basis for advanced features like requirements impact analysis and the identification of the progress of requirements implementation.

### Contact ###
[Alexander Delater](http://se.ifi.uni-heidelberg.de/people/alexander_delater.html)

### Pre-requisites to install and use plugin ###
Subversive in required for accessing the developed code in a Subversion repository. Please install Subversive using the following update site:
http://download.eclipse.org/technology/subversive/0.7/update-site/

Subversive Connectors are usually installed automatically after installing Subversive and restarting Eclipse. In case the connectors are not installed automatically, please install them manually using this update site: http://community.polarion.com/projects/subversive/download/eclipse/2.0/update-site/

ZEST Framework is required for visualizing graphs. Please install ZEST using this update site:
http://download.eclipse.org/tools/gef/updates/ Please select only these two ZEST plug-ins: Toolkit, Toolkit SDK. All other required plug-ins are identified/installed automatically.

### Link to update-site ###
Please use the following update-site to install the plugin:
http://unicase.googlecode.com/svn/trunk/other/heidelberg/trace/update/

<font color='red'>Please follow the <a href='TraceClientSetup.md'>Setup Guide</a> to setup Trace Client property.</font>

### Tutorial for users ###

Open context-menu on UNICASE Project and select **Open Traceability Center**.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceability-center-menu.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceability-center-menu.png)

The Traceability Center provides access to all features of Trace Client. A pie chart shows an overview about the requirements, work items and code files in the project as well as all other elements.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceability-center.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceability-center.png)

In the following, an overview about all features and elements of Trace Client (as well as common features of UNICASE like Navigator and Element Editor) is provided:

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceclient.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/traceclient.png)

## Basic Features ##

Trace Client offers basic features to create the necessary data, which means linking project management activities (work items) to the resulting implementation (code).

There are basically three ways to link work items and code:
  1. before a **Commit** operation
  1. after **Capturing Requirements** and before a Commit operation
  1. any time using **Copy Revision** from SVN History view.

### 1. Commit ###
Before each Commit operation, the user can **add one or more work items** related to the current Commit. If no work items are related, the user can select **No Work Items**.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/addworkitemstocommit.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/addworkitemstocommit.png)

This feature is only available if the user is currently not capturing requirements (see below). The option to add work items to each Commit can be enabled/disabled in the Preferences under Unicase: TraceSVN.

### 2. Capturing Requirements ###

Capturing Requirements is based on a process. First, the developer selects a work item from his/her list of assigned work items and starts implementing source code. While working on the work item, all requirements the developer looks at during implementation are automatically captured, meaning that these types of artifacts are logged while a developer opens them during implementation.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/capture.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/capture.png)

After finishing the implementation of a work item in the source code, the developer does not immediately commit the changes to Subversion. Instead, before the commit, s/he has to validate two lists of artifacts: one list of all changed code files in the source code, and another list of all captured  requirements that s/he looked at during implementation. While the former is standard in software development and already supported by any version control system, the latter represents additional work for the developers. This validation is necessary to only create relevant traceability links between the work item and these artifacts. For example, a developer can look at a requirement during development, which is not directly involved in the implementation, but related to the work item. During validation, a developer removes unrelated artifacts from the list. Furthermore, an optional activity for the developer is to select additional requirements that are related to the work item, but that s/he has not had a look at during implementation. Two other optional activities are to enter a commit message for the new revisions or add additional information to the description of the work item.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/verification.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/verification.png)

After validating all artifacts and optionally adding further requirements, the developer selects to commit all information to Subversion. The system then creates a new revision containing only the selected code files. The work item is linked to the newly created revision. Moreover, the system links all validated and selected requirements to the work item.

### 3. Copy Revision ###

In case one has not linked work items to a revision before, existing revisions on a SVN server can be copied to UNICASE. However, the projects of the files to be copied have to be available in the workspace of the user. Open the view "History" on a project or file and select "Show History". In the opened view "History", right-click on a revision and select "Copy Revision to UNICASE" from the context menu.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/copyrevisiontounicase.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/copyrevisiontounicase.png)

After that, a dialog is opened where the user can select work items the revision shall be linked to.

## Advanced Features ##

Using the data gathered by the basic features, Trace Client offers advanded features for analysis and usage of traceability links.

### Inferring Traceability Links ###

The traceability links between requirements and work items as well as betwen work items and revisions (which contain changed code files) are used to **infer direct links between requirements and code**. The algorithm creates automatically elements of type **Code File** (see below).

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/infertraces.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/infertraces.png)

The inference algorithm for creating traceability links between requirements and code is executed when the status **Resolved** of a work item is changed by the developer is set to **true**. Optionally, the inference algorithm can be triggered using the context menu **Infer Traces** on a Work Item. The algorithm connects in a brute force manner all linked requirements of a work item with all the code files in the linked revisions of the work item. If the algorithm identifies already existing links, it does not create them again. If a code file was modified, its information is updated for each linked requirement. If a code file is deleted, the link to the requirement is removed.

### Requirements Validation ###

For each requirement, the number of assigned/resolved work items, the linked revisions and the progress of realization is shown. Requirements Validation can also identify not realized requirements.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirementsvalidation.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirementsvalidation.png)

### Requirements and Code ###

For each requirement, the linked code files are shown. Double-clicking on a code file opes them in the code editor.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirementsandcode.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirementsandcode.png)

### Requirements Impact Analysis ###

What artifacts might be affected if a given requirement changes? The potential impact ratio on the project is also shown.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/impact.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/impact.png)

### Graph Visualization ###

Visualize single elements, all elements of a section or all elements of a project in a graph. Searching within all elements in the graph is supported. Various layout algorithms can be applied to the graph.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/graph.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/graph.png)

### Requirements Context ###

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirementscontext.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirementscontext.png)

### Icon Assistant ###

The icon assistant provides an overview about all important icons used in [Trace Client](Trace_Client.md)

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/iconassist.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/iconassist.png)


## Elements ##

### Code File ###

Code Files are links to local files in the current Eclipse workspace, e.g. Java files. They are automatically created during the **inference of traceability links** (see above)

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/codefile.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/codefile.png)

### Revision ###

The element Revision stores information about a revision on a Subversion Server. It contains information about all changed code files.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/revision.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/revision.png)

### Versioned Project ###

A Versioned Project is a container for all Code Files that belong to a common project in the current Eclipse Workspace. It is also automatically created during the **inference of traceability links** (see above). Versioned Projects are used to keep number of elements in the UNICASE project at a minimum.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/versionedproject.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/versionedproject.png)

### Requirement ###

A Requirement is not a particular element of Trace Client. However, requirements are automatically linked to Code Files.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirement.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/trace/requirement.png)