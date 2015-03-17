**This page describes what the different models are, where they are and how the build upon each other.**

We use EMF and its code generation facilities for generating code for the following models and plugins:

  * **UNICASE model:**
    * **_Purpose:_** Represents the different model elements that are part of the project model of UNICASE. Model elements range from Requirements to Classes, ActionItems, Issues and OrganizationalUnits. Also the superclass "ModelElement" for all model elements and some helper classes are defined.
    * **_Ecore location:_** org.unicase.model/model/model.ecore
    * **_Dependencies:_** None
    * **_plugins:_**
      * org.unicase.model
      * org.unicase.model.edit

  * **EMF store model:**
    * **_Purpose:_** Defines the model of the server. The server stores additional administrative information about the project models such as versions and access control classes.
    * **_Ecore location:_** org.unicase.emfstore.esmodel/model/esmodel.ecore
    * **_Dependencies:_** Model
    * **_plugins:_**
      * org.unicase.emfstore.esmodel
      * org.unicase.emfstore.esmodel.edit

  * **EMF store model:**
    * **_Purpose:_** Defines the model of the client workspace. The client workspace stores project models and administrative information about them, such as the user, server urls and synchronization related information.
    * **_Ecore location:_** org.unicase.emfstore.workspace/model/workspace.ecore
    * **_Dependencies:_** EMF store model and therefore also UNICASE model
    * **_plugins:_**
      * org.unicase.workspace
      * org.unicase.workspace.edit