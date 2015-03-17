The [Software Engineering Group](http://se.ifi.uni-heidelberg.de/) at the Institute of Computer Science, [University of Heidelberg](http://www.uni-heidelberg.de) has developed several plugins for UNICASE.

If you have any questions, please contact [Tom-Michael Hesse](http://se.ifi.uni-heidelberg.de/people/tom_michael_hesse.html),
[Paul Huebner](http://se.ifi.uni-heidelberg.de/people/paul_huebner.html)
or [Marcus Seiler](http://se.ifi.uni-heidelberg.de/people/marcus_seiler). They are maintaining all plugins and provide support for installing and using them.

### Independent plugins ###

The following plugins can be installed individually. This means that they can be used separately from any other plugins. For each plugin, an individual update site exists.

  * [Trace Client](TraceClient.md): Provides (semi-) automatic creation and usage of traceability links between requirements, work items and source code during development. The Trace Client integrates itself seamlessly into the Eclipse IDE and Subversive (plug-in for Subversion). The main features are: (semi-) automatic creation of traceability links, requirements impact analysis, traceability between requirements and code, progress of requirements implementation, graph visualization.

  * [Search](Search.md): Provides search functionality for UNICASE projects and is based on the EMF Query project of Eclipse. Enables searching for names and descriptions of model elements. Searches can be restricted by element type and regular expressions for search string.

  * [Glossary](Glossary.md): Provides the element 'GlossaryEntry'. The element 'GlossaryEntry' can be linked to any other element.

  * [UserTasks](UserTasks.md): Provides advanced support for specifying use tasks as user requirements, especially new sub tasks.

  * [Views](Views.md): Provides fully customizable views on the overview tree of the navigator.

  * [Refactor](Refactor.md): Enables moving and renaming elements in the navigator tree for Unicase 0.5.2

### Depending plugins ###

The following plugins have a **depencendy to the integrated plugins (see below)**. This means that the integrated plugins are required to run one of the following plugins.

  * [Business Process Editor](BusinessProcessEditor.md): Enables the modeling of BPMN process models and the linking of BPMN model elements to UNICASE model elements. The editor also provides functionality for a comprehensive modelling of quality information within the process model.

  * [Metrics](Metrics.md): Provides various metrics for UNICASE projects. For example, user metrics (elements per user, action items per user etc.), element metrics (number of elements, elements per development phase etc.) and time frame metrics (elements created between two dates). Queries for metrics can be saved for later usage and results can be exported to Excel.

  * [Context Completeness](ContextCompleteness.md): Provides support for identifying incomplete elements, e.g. isolated elements or elements missing certain mandatory links to other elements. Results can be saved for later usage and exported to Excel. The context of a particular element can be shown, which means all linked elements of the originating element with the ability to directly navigate the linked elements.

### Integrated plugins ###

The following plugins can only be installed together. This means that they have dependencies between each other and cannot be used separately. For these plugins, one update site exists.

  * [Use Cases](UseCases.md): Provides advanced support for specifying use cases, especially new visualization of Flow of Events.

  * [Test Cases](TestCases.md): Provides support for specifying test cases with included test steps. Results of test cases can be documents in test protocols. Test Cases can be linked to Use Cases.