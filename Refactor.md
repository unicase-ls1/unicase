## Description ##

This plug-in enables moving and renaming elements in the navigator.

### Contact ###
[Arthur Kuehlwein](mailto:arthur.kuehlwein@informatik.uni-heidelberg.de)

### Link to update-site ###
Please use the following update-site to install the plugin:
http://unicase.googlecode.com/svn/trunk/other/heidelberg/refactor/update/

### Quick Start Guide ###
#### Moving Elements ####
Right-click on the element you want to move and select "Move..." from the "Refactor" submenu. If a move operation is supported for the selected element, you can select its new location by double-clicking on the corresponding node in the location selection dialog. Pleaser refer to the chapter "Supported Elements" for a list of elements for which move or rename operations are not supported.

![https://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/selectLocationDialog.png](https://unicase.googlecode.com/svn/trunk/other/heidelberg/plugin-resources/selectLocationDialog.png)

You can also select mutliple elements for a move operation. All selected elements will then be moved to the given location. Note that the selected elements have to be compatible, i.e. they have to be of the same "type" in the navigator. That means, that you, for example, cannot have some UNICASE elements and a leaf section or composite section in your selection. The basis for the compatibility check will be element you right-click on, so if you right-click on a leaf section in the selection given in the example and select "Move...", the plug-in will check if your selection only contains leaf sections. If the check fails, an error message will appear and you will not be able to move the selected elements.

#### Renaming Elements ####
Right-click on the element you want to rename and select "Rename..." from the "Refactor" submenu. Enter the new name of the selected element in the dialog. Note that multiselection is not supported for the rename operation.

### Supported Elements ###
Move operations are supported for UNICASE model elements, both native and non-native, as well as non-UNICASE model elements. There are some exceptions, however. The following elements are not supported:
  * Project spaces
  * The "Orphans" project
  * Proposals
  * Assessments
  * Solutions
Please note that when moving comments, the comment's reference to the commented element is changed to the element you have selected as the new location.

Rename operations are only supported for UNICASE model elements, both native and non-native.