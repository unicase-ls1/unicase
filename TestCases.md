## Description ##
This plugin provides support for specifying test cases with included test steps. Results of test cases can be documents in test protocols. Test Cases can be linked to Use Cases.

### Contact ###
[Alexander Delater](http://se.ifi.uni-heidelberg.de/people/alexander_delater.html)

### Link to update-site ###
Please use the following update-site to install the plugin:
http://unicase.googlecode.com/svn/trunk/other/heidelberg/usecasetestcase/update/

The plugin is integrated with the [Use Cases](UseCases.md) plugin, which means that these plugins are installed together.

### Tutorial for users ###
Create a new element "TestCase" from the package "testcase" in UNICASE. The element has several attributes, e.g. pre- and post condition and infrastructure. Navigate to the new page "Test Steps". Test Steps can have input- and output parameters, a short description and exception. For each parameter, the name, type and range can be specified.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/teststep.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/teststep.png)

An element "TestProtocol" can be created. This new element can be linked to a TestCase. In the TestProtocol, the concrete values of the TestCase can be specified and the results can be documented, e.g. setting the "Test State" to passed/failed and provide free-text documentation in "Test Report". Setting the "Test State" to passed/failed changes the icon of the TestProtocol to indicate test results without opening the element.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/testprotocol.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/testprotocol.png)