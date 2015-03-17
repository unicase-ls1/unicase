## Description ##
This plugin enables the modelling of business processes using BPMN standard model elements. In contrast to other business process modeling editors, this editor also allows documenting quality information in the process model. Thus, information on structure and behavior as well as information on quality can be presented in a single view. As business process models are often a starting point of requirements elicitation, process model elements can be linked to UNICASE model elements.

### Contact ###
[Robert Heinrich](http://se.ifi.uni-heidelberg.de/people/robert_heinrich.html)

### Pre-requisites to install and use plugin ###
The plugins [Use Cases](UseCases.md) and [Test Cases](TestCases.md) are required. Please install these plugins using the following update site:

http://unicase.googlecode.com/svn/trunk/other/heidelberg/usecasetestcase/update/

### Link to update-site ###
Please use the following update-site to install the plugin: http://unicase.googlecode.com/svn/trunk/other/heidelberg/process/update

(Current version is compatible with UNICASE version 0.4.5)

### Tutorial for users ###
The process model is presented in a split screen view together with the corresponding tables of attributes and measures (QI Details). In the process modeling view (Business Process Model) the modeler can capture information on structure and behavior of the business process as a BPMN model and can additionally capture several quality characteristics. The modeler can add quality characteristics to a process model element by dragging and dropping the characteristic icons from the toolbar besides the process model to the corresponding process model element. By clicking a characteristic icon in the process model, the table of attributes and measures related to the selected characteristic appears in the QI Details view below. Here the modeler can capture the attributes, measures and their values.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/process/BusinessProcessEditor.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/process/BusinessProcessEditor.png)