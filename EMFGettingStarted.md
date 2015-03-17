**This site is currently under construction**

The Eclipse Modeling Framework (EMF) allows generating the entity classes of an application based on a model. Such entity-centric applications follow a common template. They provide a tree-based view for navigation and for browsing all entities, a detailed editor for one entity of the model and a number of additional customized views. Additionally the entities have to be persisted, versioned and shared among multiple clients. In this tutorial we show step by step how to build this kind of application. As an example we build an application to manage a conference, including authors and submissions. We start with creating the underlying model and generating the entity classes using EMF. In the second step we show how to build a custom UI using the EMF Client platform. In the third step we connect our application to the EMFStore allowing to share model instances over distributed clients.

# Introduction #
The tutorial is organized in 3 parts:
  * EMF Modeling (1 hour)
  * Customizing the UI (1 hour)
  * Distributing the Model (1 hour)

Additionally we plan 1 hour for preparation and as puffer. All parts are organized in steps. Later steps can be skipped to stay in time. For each part, we provide a sample solution, the following part builds on. Therefore you can step in coding at the beginning of each part. We kindly ask you to prepare your laptop, if you plan to join coding to keep the set-up time as short as possible. Please have a look at the following website for the latest updates:

http://code.google.com/p/unicase/w/edit/EMFGettingStarted
# Preparation #

Download Eclipse Helios Modeling Edition:

http://www.eclipse.org/downloads/packages/eclipse-modeling-tools-includes-incubating-components/heliosr

Install all components from the latest EMFStore Release (including EMF Client Platform):

http://unicase.googlecode.com/svn/updatesite/emfstoreNightly
