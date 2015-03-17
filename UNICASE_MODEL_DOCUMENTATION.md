**This page describes what the different models are, where they are and how the build upon each other.**

We use EMF and its code generation facilities for generating code for the following models and plugins:

  * **UNICASE model:**
    * **_Purpose:_** Represents the different model elements that are part of the project model of UNICASE. Model elements range from Requirements to Classes, ActionItems, Issues and OrganizationalUnits. Also the superclass "UnicaseModelElement" for all model elements and some helper classes are defined.
    * **_Ecore location:_** org.unicase.model/model/model.ecore
    * **_Dependencies:_** None
    * **_plugins:_**
      * org.unicase.model
      * org.unicase.model.edit

  * **Dashboard model:**
    * **_Purpose:_** Defines the elements required for the UNICASE Dashboard implementation. This includes elements required for the notification process as well as elements to save and present data (e.g. subscriptions).
    * **_Ecore location:_** org.unicase.dashboard/model/dashboard.ecore
    * **_Dependencies:_** None
    * **_plugins:_**
      * org.unicase.dashboard

  * **Diagram model:**
    * **_Purpose:_** Defines the canvas elements for diagrams in UNICASE. These elements are required by the Graphical Modeling Framework (GMF) to allow the user to create diagrams within UNICASE.
    * **_Ecore location:_** org.unicase.diagram/model/diagram.ecore
    * **_Dependencies:_** UNICASE Model
    * **_plugins:_**
      * org.unicase.diagram
      * org.unicase.diagram.edit

  * **Implementation model:**
    * **_Purpose:_** Defines the elements required for the UNICASE code generation process.
    * **_Ecore location:_** org.unicase.implementation/model/operations.ecore
    * **_Dependencies:_** UNICASE Model
    * **_plugins:_**
      * org.unicase.implementation
      * org.unicase.implementation.edit