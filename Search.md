## Description ##
This plugin provides search functionality for UNICASE projects and is based on the EMF Query project of Eclipse.

### Contact ###
[Alexander Delater](http://se.ifi.uni-heidelberg.de/people/alexander_delater.html)

### Pre-requisites to install and use plugin ###
EMF Query is pre-installed in Eclipse Modeling Tools. In case EMF Query is not available, please install EMF Query manually, version 1.3.0 at least.
http://www.eclipse.org/modeling/emf/downloads/?project=query

### Link to update-site ###
Please use the following update-site for installing the search plugin: http://unicase.googlecode.com/svn/trunk/other/heidelberg/search/update

## Tutorial for users ##
This short tutorial will explain the search panel and how one can define complex search conditions. Furthermore, it provides an overview about the search results.

### Defining search parameters ###

Once you installed the plugin you can select the search view from the Eclipse menu: Window -> Show View -> Unicase -> Search View.
Furthermore, you have to select a project in the Navigator in order to enable the search view.

The important parts of the search view will be presented in the following.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/search1.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/search1.png)

  1. In the search view you can define a keyword for the search. This keyword will be evaluated for the title and the description of the model elements. You can also enter a regular expression here, e.g. "test[1-5]" to search for model elements having a title or description like "test1", "test2", ..., "test5". Full specification available at http://download.oracle.com/javase/1.5.0/docs/api/java/util/regex/Pattern.html
  1. The selection of the sorting method for the results and the number of results to display per page. If you change these parameters while there are already results the changes will be performed instantly.
  1. This is the pane for the advanced search options. Once you click it you will see the points 4-7.
  1. The tree for the model types lets you select certain types for the search. You can also use the buttons to select all types or none.
  1. Using these buttons you can create a new condition or delete an existing one.
  1. For a condition you can select a field, operator and value. The fields you can use here depend on the type selection. So, if you define a condition and de-select the dependent type, the condition will be removed because the field is not available anymore. Furthermore, the operator can also be "value-set". This means that the conditions checks if there is any value set for the field. Once this operator is active, you cannot set a value since it is not needed.
  1. If this option is selected, the search will only use the defined search conditions. The search will be performed without using the keyword. The text field for the keyword will be disabled.
  1. Here you can save the current search parameters. You can also load previously saved parameters or delete them.


### Browsing the search results ###

After you performed a search the results will show up at the bottom of the parameters.

![http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/search2.png](http://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/search2.png)

  1. The number of model elements found for the search.
  1. The pager depends on the setting for the maximum results per page and the number of found elements. Here you can switch between the pages.
  1. Every search result will show up with several additional information. The path shows where the element is located within the selected project. The defined keyword will be marked as well. Once you double-click the result the editor will open the model element.