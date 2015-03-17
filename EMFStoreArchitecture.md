This page describes the EMFStore features and their plugins and dependencies to external frameworks.

### EMFStore Features and Plugins ###

The EMFStore framework consists of five features:

  * EMFStore Metamodel Feature (org.unicase.emfstore.metamodel) - contains plugins required to build a model that can be stored in the EMFStore:
    * org.unicase.metamodel: contains the common metamodel including a model element base class with a unique id.

  * EMFStore Server Feature (org.unicase.emfstore.server) - contains the plugins required for running the EMFStore server:
    * org.unicase.emfstore: contains the business logic of the server
    * org.unicase.emfstore.esmodel: versioning data model of the server

  * EMFStore Client Feature (org.unicase.emfstore.client) - contains the plugins required to contact the EMFStore server from an EMFStore client:
    * org.unicase.workspace: contains the EMFStore API for client applications, the client data model and an API for remote calls to the server

  * EMFStore Client User Interface Feature (org.unicase.emfstore.client.ui) - contains views for EMFStore clients:
    * org.unicase.workspace.ui: contains views for update/commit/merge, a repository browser and a history browser.
    * org.unicase.ui.navigator: contains a reflective view for showing the local models and their structure in a tree view.
    * org.unicase.ui.meeditor: contains a reflective form-based editor to view single model elements.
    * org.unicase.metamodel.edit: contains the label and item providers for the meta model
    * org.unicase.emfstore.esmodel.edit: Edit plugin for versioning model
    * org.unicase.workspace.edit: Edit plugin for the workspace model

  * EMFStore Backchannel Feature (org.unicase.emfstore.backchannel) - contains plugins to establish a communication channel from server to client, can be used to update client models on new versions automatically:
    * org.unicase.backchannel: contains an API to send events from server to client and to register for events from the server on the client.

In a typical deployment scenario consists of an EMFStore Server node and an EMFStore client node. While the server node contains only the EMFStore Server Feature, the client node contains all features. In contrast a headless client does not contain the EMFStore Client User Interface Feature since it does not need to display the models or interaction on the models.

![http://unicase.googlecode.com/svn/trunk/documentation/images/EMFStoreArchitecture.png](http://unicase.googlecode.com/svn/trunk/documentation/images/EMFStoreArchitecture.png)

To support sending events from server to client there is the backchannel feature. This feature supplies an API to create events for distribution to the clients on the server and an API for registering for server events on the clients. The feature already sends events if the model in the repository is changed due to a commit. Thereby an automatic update of models on the clients (online mode) is supported.

![http://unicase.googlecode.com/svn/trunk/documentation/images/EMFStoreArchitectureWithBackchannel.png](http://unicase.googlecode.com/svn/trunk/documentation/images/EMFStoreArchitectureWithBackchannel.png)


### External Dependencies ###

The EMFStore features depend on the following external bundles and libraries. While the external bundles need to be present in the runtime environment, libraries are included in the respective bundles as jars.

Metamodel Feature:
  * Required Plugins:
    * org.eclipse.core.runtime
    * org.eclipse.emf.ecore

Server Feature:
  * Required Plugins:
    * org.eclipse.emf.ecore.xmi
    * org.apache.commons.logging
    * org.apache.commons.codec
  * Included Features:
    * org.unicase.emfstore.metamodel
    * edu.tum.cs.cope.runtime.feature
  * Includes Libraries:
    * commons-logging-1.1.jar
    * ws-commons-util-1.0.2.jar
    * xmlrpc-client-3.1.2.jar
    * xmlrpc-common-3.1.2.jar
    * xmlrpc-server-3.1.2.jar

Client Feature:
  * Required Plugins:
    * org.eclipse.emf.transaction
  * Included Features:
    * org.unicase.emfstore.server
  * Included Libraries:
    * dmp.jar: google-diff-match-patch

Client UI Feature:
  * Required Plugins:
    * org.eclipse.core.expressions
    * org.eclipse.emf.databinding.edit
    * org.eclipse.emf.edit
    * org.eclipse.emf.edit.ui
    * org.eclipse.emf.transaction
    * org.eclipse.emf.transaction.ui
    * org.eclipse.jface.databinding
    * org.eclipse.jface.text
    * org.eclipse.ui
    * org.eclipse.ui.forms
    * org.eclipse.ui.ide
  * Included Features:
    * org.unicase.emfstore.client
  * Included Libraries:
    * dmp.jar: google-diff-match-patch

Backchannel Feature:
  * Required Plugins:
    * org.apache.commons.logging
    * org.unicase.workspace