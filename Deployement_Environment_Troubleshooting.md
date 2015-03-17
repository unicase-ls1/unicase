If you have trouble starting UNICASE (server or client), you get an unexpected exception or similar, it is best practice to bring your development environment to a well-defined state. Situations in which this might be necessary include:

  * changes to the .ecore model
  * a server crash where the database was rolled back
  * a client crash where the workspace was damaged


Follow this procedure to fix your development environment

  1. Stop the UNICASE client or server if still running
  1. Update all plugins to the latest revision in the svn repository
  1. Check if you have obsolete plugins or missing plugins in your workspace (use svn repo browser to get a list of plugins)
  1. Delete the eclipse runtime workspace
    * Go to your default workspace location
    * Delete the folder named runtime-EclipseApplication
  1. Delete the UNICASE workspace: Delete the folder ~/.emfstore/ or ~/.unicase/
  1. Restart Eclipse