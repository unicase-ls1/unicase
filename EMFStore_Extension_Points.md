# Introduction #

At this point all extension points of the EMFStore shall be documented. At the moment the number of extension points is not big, but it is quite likely to rise in the time to come.
The extension points are defined in the following packages:

  * org.unicase.emfstore
  * org.unicase.metamodel

## EMFStore: org.unicase.emfstore ##

The main component of the EMFStore offers two extension points which allow to add plugins and register additional connection handler. Both extension points use a java interface which has to be implemented by the user of the extension point.

### org.unicase.emfstore.startuplistener ###
Through this extension point you register yourself as listener before the interfaces and connection manager of the emfstore are initialized.
```
public interface StartupListener {

	void startedUp(List<ProjectHistory> projects);
}
```
Every StartupListener gets access on the lists of projects and is able to modify the list. This **list is no copy** and therefore you have to handle it with **caution**.

This extension point was introduced to clean up the project states and do migration and model fixing. It should be less interesting for other purposes


### org.unicase.emfstore.poststartuplistener ###
This extension point works similar to the startuplistener, but it is called after all components of the server have been started. To use the extension point you have to implement and register an interface.
```
public interface PostStartupListener {
	void postStartUp(ServerSpace serverspace, AccessControlImpl accessControl,
		Set<ConnectionHandler<? extends EmfStoreInterface>> connectionHandlers);

}
```
You have access to accesscontrol, the connectionHandlers and the complete serverSpace. This enables the developper to add or remove connection technologies or change the access control.
At the moment this extension is used by the **backchannel feature** which is a plugin of unicase that allows the server to push messages to the client.

## Meta Model: org.unicase.metamodel ##
Currently the meta model has two extension points.

  * modelversion
  * recommendationstrategy

### modelversion ###
If you extend the meta model with your own domain model, you must use this extension point to identify the version of your model. This is used for the model migrartor, included in EMFStore. If the version of the persistent instance of the model and the value from the extension point differs, the migrator tries to migrate the persistent model.


### recommendationstrategy ###
This extension point allows you to register a recommendation strategy for your model.

In order to use it, you have to offer a strategy by implementing this interface:
```
public interface RecommendationStrategy {

	/**
	 * This method returns value pairs (ModelElement, Double) which indicate how probable a certain element might be
	 * linked. The Double values should be in (0,1) to support combination of methods.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base, also referred as candidates.
	 * @return a Map (ModelElement,Double)
	 */
	Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements);

	/**
	 * Returns the name of this strategy for output reasons.
	 * 
	 * @return the name
	 */
	String getName();
}
```

You have to define the **eReferenceName**:

This value determines for which references this recommendation should be used. (e.g only for annotatedModelElements). Write ALL if you want to use it with all references.  Specialized references will be preferred before generalized references. Take care that only one strategy is registered for each reference.
For special references enter the result from the eReference.getName() method.

And specify a **baseElementClass**:

This class determines for which base classes this strategy is used.
The combination of base class type and reference determines which strategy is used for recommendation. Use class 'org.unicase.model.ModelElement' for no restriction.

