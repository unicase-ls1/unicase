0.8.9.M9:
  * Bugfixes

0.8.9.M3:
  * Performance optimization (300k+ elements per project tested)
  * Namespace changed to org.eclipse.emf.emfstore
  * Support for Cross-project and Out-of-project links
  * Removed Java RMI completely (fixes port issues caused by RMI)
  * Cross-References to Elements ouside of a Project are correctly tracked (even if Element is later added to the Project)
  * Added filters to ignore invalid notifications
  * Change Tracking refactored: Operation Recorder can now be used standalone.
  * Containment Proxy flag in genmodel is now optional (only improves performance)
  * Configurable Resource Splitting (improves performance) and Sanity Checks
  * Independent Feature for Model Migration (removed COPE dependency from Core)
  * Updates site now also includes COPE and EMF Client Platform
  * Many bug fixes...

0.7.3.nightly: removed dependency to EMF Transaction, it is now in a sperate non-core feature

0.7.2.nightly:
  * removed dependency to EMF validation

0.7.1.nightly:
  * updated ECP version to avoid bug in previous ECP version when linking elements in the reflective editor

0.7.0.nightly:
  * Plain EObject Support: Custom EObjects no longer need to inherit from ModelElement in the Ecore. Any EMF model now works out of the box with EMFStore.
  * Editing Domain is now by default an AdapterFactoryEditingDomain. No more need to use commands for changing or reading the model. Editing Domain can be configured by an extension point (EditingDomainProvider)
  * Support for complex creates: EObjects are now allowed to have cross-references even before they are added to the containment tree of a project. EMFStore will track these references when and iff the EObject is added.
  * Multi-Attributes: Support for Attributes with multiplicity greater than 1 added.
  * Reference set changes: Support for references set changes added. These can be trigger by List.set().
  * No dependency to Groovy anymore: Model migration is now a sperate feature including the dependency to Groovy. The core plugins therefore no longer need a dependency to Groovy.
  * EMF Client Platform is now a released as seperate features and can be installed in parallel.
  * Performance improvements
  * Many bugfixes!

0.6.2.nightly:
  * fixed issue with registration of editing domain

0.6.1.nightly:
  * Added Supports for EMF Edit Commands:
    * Copy/Paste/Cut/Delete
    * CopyToClipboard/PasteFromClipboard
  * Changed definition of delete:
    * Any element that is still disconnected from the containment tree at the end of a command is considered deleted, if it was not cut to the clipboard.
    * Disconnecting elements with cross references is not allowed since the serialization will be broken otherwise.
    * Deletes do not need to be triggered explicitly by project.deleteModelElement
    * Disconnected Elements are no longer automatically "caught" and added to project root
  * Fixed keystore initialization issue
  * Added support for default configuration providers (extension point in workspace plugin):
    * Provide default certificates
    * Provide default server info and user credentials

(0.6.0.nightly: version was never available at update site, version number skipped)

0.5.31.nightly:
  * EMFStore will ignore (and only log) Exceptions from the package registry when EPackages are loaded
  * New extension point for default server infos and certificates added to workspace plugin

(0.5.30.nightly: version was never available at update site, version number skipped)

0.5.29.nightly:
  * Backchannel Feature split into two features: client and server
  * Added Util Classes for using EMFStore-Metamodel-based models with XMI Resources (EMFStoreXMIResource)
  * Added new and improved EMFStore Browser View
  * Added Model Export
  * Bug Fixes in Login and Logout
  * Improvements and Bug Fixes in Model Import

(0.5.19.nightly - 0.5.28.nightly: version was never available at update site, version number skipped)

0.5.18.nightly:
  * All extension point schemas added to build
  * EMFStore features now include all required features

0.5.17.nightly:
  * removed dependency to apache.commons.logging in backchannel also, replaced by import

0.5.16.nightly:
  * Recovered workspace location extension point (had been disabled)
  * Added robustness against load failure of EPackages

0.5.15.nightly:
  * removed dependency to apache.commons.logging, replaced by import
  * changed default backchannel port to 3000
  * added SDK feature containing source code
  * copy default configuration (es.properties) to default location on first start-up
  * added EMFStoreUtil to ease building EMFStore clients
  * added commit method without log message parameter to project space
  * fixed model import for models with nested root nodes
  * fixed project export for unshared projects