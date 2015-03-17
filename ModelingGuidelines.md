**Please make sure you have COPE installed when doing model changes and that you know how to use it. Otherwise migrations will not work!**
<br>

We have a workflow and a set of rules in place to work with the ecore models in UNICASE. This page describes the workflow for modeling and the modeling rules. Further information about the different models is available <a href='http://code.google.com/p/unicase/wiki/UNICASE_MODEL_DOCUMENTATION'>here</a>.<br>
<br>
<b><i>Modeling Workflow:</i></b>


<ol><li>Make sure you updated to the latest revision<br>
</li><li>Acquire a lock for the ecore and genmodel (ContextMenu: Team -> Lock)<br>
</li><li>Validate the model before generating code (ContextMenu: Validate)<br>
</li><li>Reload the genmodel (ContextMenu: Reload...)<br>
</li><li>Generate model and edit (<a href='http://unicase.googlecode.com/files/unicaseMDD.mov.qt'>see ModelDrivenDevelopment Tutorial</a>)<br>
</li><li>For newly created model packages update the org.unicase.model plugin.xml to export the package, package.impl and package.util packages. Also update the org.unicase.model.edit plugin.xml to export the package.provider package and make sure to register the appropriate itemProviderAdapter factories under extensions.<br>
</li><li>Check for compile problems<br>
</li><li>Reload and check depending models for compile or validation problems<br>
</li><li>Organize imports on model and edit (ContextMenu: Source -> Organize Imports)<br>
</li><li>Format model and edit (ContextMenu: Source -> Format)<br>
</li><li>Update all plugins to detect potential problems<br>
</li><li>Minimum testing:<br>
<ul><li>Delete the existing model database and workspaces and run server and client<br>
</li><li>Run server and client<br>
</li><li>Open navigator and meeditor and perform one workspace commit,<br>
</li></ul></li><li>Commit all changed plugins at once with a descriptive commit message<br>
<ul><li>List all changes you made to the model<br>
</li><li>List all changes you performed on other plugins because of the new model<br>
</li><li>List all plugins you regenerated from the changed ecore</li></ul></li></ol>

<br>
<b><i>Modeling Rules:</i></b>

The general <a href='EMFStoreModelingGuidelines.md'>EMFStore Modeling Guidelines</a> apply, please read them carefully!<br>
<br>
