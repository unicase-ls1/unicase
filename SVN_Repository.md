**_Our SVN is hosted on googlecode. To check out the code please look at this page for the details:_**

> http://code.google.com/p/unicase/source/checkout

As a regular developer you will only need to check out all plugins in trunk/core and trunk/developer.

Repository layout:

  * Root Level:
    * /trunk: the current state of development.
    * /tags: used to create tags to special revisions, like releases.
    * /branches: used to branch of from trunk to develop new features in isolation from trunk.
  * Below root level (in trunk, tags and branches):
    * /core: contains all core plugins that are part of the release.
    * /developer: contains resources for developers, such as scripts, configurations
    * /deployment: contains plugins, features and the update site for release and deployment.
    * /test: contains plugins for testing.
    * /other: contains other plugins and features that are not released with the UNICASE client feature.



### Repository rules: ###

  * **Always update before commit.**
  * **Only commit code without compilation problems.**
  * **If you add a new new plugin to the trunk, announce this to the mailinglist.**