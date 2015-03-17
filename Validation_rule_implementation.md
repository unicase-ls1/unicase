**Quick how-to**

If you prefer a simple how-to to the full length explanation, just read the following bullet points and the section "Defining rules" and be enlightened.

  * The validation framework consists of three "indirections" (I, II, III). You will need a constraint binding with a context (I), which specifies a ValidationClientSelector.
  * You will then bind the context to a category (II), and the category will be used when registering constraints (III)
  * Steps I and II are already accomplished within the project, so all you need to do is to register your own constraints, for example for your own model.
  * To register a new constraint, take a look at the section "Defining rules" below. Don't forget to specfiy the correct package URI, in case you add a new constraint provider for a specific package. It is recommended to take a look at the existing implementations, which can be found in the org.unicase.model plugin.
  * The current context is `context` and the category for model-specific constraints is `org.unicase.model`. The binding of context to selector can be found in `org.unicase.ui.common`.

**Overview**

This document describes how the automatic validation is implemented in UNICASE and how new validation rules in Java as well as in OCL can be defined. Validation is the automatic verification of model constraints. For the implementation of validation in UNICASE, the Eclipse Modeling Framework (EMF) Validation Framework (http://www.eclipse.org/modeling/emf/?project=validation) was used. The framework supports the definition of validation rules initially from Java and OCL. In addition, other validation language can be integrated. Validation can take place on both static and dynamic way, i.e. as a batch job or live. This means that the validation is triggered either by the user, or continuously executed.

A validation rule always refers to a particular type of model element as well as a specific attribute. The rule is violated by an instance of this type, the editor uses this information to the corresponding attribute in the interface visible to the user to mark. In addition, the framework can be about one level of injury (e.g. "Warning" or "Error"), which is connected to the model element itself, the creator of the model element and a description of the violation appear in the validation view set.

**Integration of the Validation Framework**

To be able to use the EMF Validation Framework, as the first step the `org.eclipse.emf.validation.constraintBindings` extension point will be used to create a client context and define a binding. The binding is definied in `org.unicase.ui.common`. Extracted from the `plugin.xml`:
```
    <extension
         point="org.eclipse.emf.validation.constraintBindings">
      <clientContext
            id="context">
         <selector
               class="org.unicase.ui.common.util.ValidationClientSelector">
         </selector>
      </clientContext>
   </extension>
```

The context for model-specific constraints is defined in `org.unicase.model`.
Extracted from the `plugin.xml`:

```
  <extension
        point="org.eclipse.emf.validation.constraintBindings">
     <binding
           category="org.unicase.model"
           context="context">
     </binding>
  </extension>
```

The binding here is to the model plug-in itself, the client is bound to the class ValidationClientSelector, which controls the checking of model elements. Setting this extension points is performed only once and after that can be used by all the validation rules.

**Defining rules**

After setting up this extension, in the second step, rules can be defined. Adding new rules for this uses the `org.eclipse.emf.validation.constraintProviders` extension point of the Validation Framework. The category means pertaining to the category of the above-defined binding contexts. To include a new validation rule, a constraintProvider must be created for each model package. Here we are taking the package which the rules should be used for the model package, and the style is as described above, shall determine whether the validation should be static or dynamic. The rule itself will be created under constraints as a new constraint.
See the following example on how to define a model-specific constraint, extracted from the `plugin.xml`:

```
<extension
        point="org.eclipse.emf.validation.constraintProviders">
     <category
           id="org.unicase.model"
           name="Unicase">
     </category>
     <constraintProvider
           cache="true"
           mode="Batch">
        <package
              namespaceUri="http://unicase.org/model/task">
        </package>
        <constraints
              categories="org.unicase.model">
           <constraint
             ....see below   >
           </constraint>
        </constraints>
     </constraintProvider>
</extension>
```

A constraint places other than name and id, the language (language - OCL or Java), the degree (severity), the validation mode (mode - batch or live), and (for Java constraints), the class which implements the constraint set. As the sub entry message, the message template is shown what the user is given.

```
           <constraint
                 class="org.unicase.model.task.validation.ActionItemAssigneeConstraint"
                 id="org.unicase.model.task.ActionItemAssignee"
                 lang="Java"
                 mode="Batch"
                 name="ActionItem Assignee Constraint"
                 severity="INFO"
                 statusCode="1">
              <message>
                 {0} has no Assignee.
              </message>
           </constraint>
```

**Java Validation**

As shown in Figure 1: Java Constraint classes seen to derive from all the Java classes of constraint AbstractModelConstraint. To implement the validate () method uses the passed IValidationContext to review the rule. The rule is violated, we pass the feature itself affected the error status as an additional argument, as described above in order to enable the identification of the error in the editor. Furthermore, the error status by default contains the affected model element itself and inserts into the constraint set for this message template.

A simple validation class for example, is as follows:

```

 /**

 *CheckswhetheraactivityissetforthisActionItem.

 */

public class ActionItemActivityConstraint extends AbstractModelConstraint {

 

@Override

 public IStatus validate(IValidationContext ctx) {

   EObject eObj = ctx.getTarget();

   EMFEventType eType = ctx.getEventType();

 

   if (eType == EMFEventType.NULL) {

     if (eObj instanceof ActionItem) {

         ActivityType activity = ((ActionItem) eObj).getActivity();

        if (activity.getValue() == ActivityType.NONE_VALUE) {

            EStructuralFeature errorFeature = ValidationConstraintHelper

               .getErrorFeatureForModelElement((ModelElement) eObj, "activity");

            ctx.addResult(errorFeature);

           return ctx.createFailureStatus(new Object[] { eObj.eClass()

               .getName() + ": '" + ((ActionItem) eObj).getName() + "'" });

         }

      }

   }

   return ctx.createSuccessStatus();

 }

}
```

The corresponding message template has the form "(0) does not have an activity assigned." So that the user with a message such as "ActionItem: 'Do Task A' does not have an assigned activity." appears in the Validationview . By double-clicking the entry, the model element will be chosen and opened from the Status. It bestowed upon the status feature is passed to the editor, it provides an hint of a ControlDecoration.

**OCL Validation**

For OCL rules, the rule is specified directly in the constraint. The following rule ensures, for example, that every UML actor must be assigned to a use case, either as initiator or as a participant:

```
<constraint lang="OCL"

   severity="WARNING"

   mode="Batch"

   name="Actor Usecase Constraint"

   id="org.unicase.model.requirement.ActorUsecase"

   statusCode="1">

   <message>{0} has no usecases</message>

   <targetclass="Actor"/>

   <![CDATA[

      self.initiatedUseCases->size() + self.participatedUseCases->size() > 0

   ]]>

</constraint>
```

Through these OCL rules, however, can only put relatively simple constraints, since for example no global variables can be defined. You can also pass in this way is not the affected feature to the editor.

**Execution of the Validation**

The so-defined rules can now be run in a third step of the client validation selector. In the following example, it will run as a batch job.

```
ValidationClientSelector.setRunning(true);

IBatchValidator validator = (IBatchValidator)

   ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);

validator.setIncludeLiveConstraints(true);

IStatus status = validator.validate(projectSpace);

ValidationClientSelector.setRunning(false);
```

The IStatus represents the result of the validation and to generate the IMarker which is used to be displayed in the Validation view. It contains, for each rule violation of the message and the degree, a link to model element or feature which led to the violation. These will be presented to the user in tabular form. Double-clicking a table entry will open the affected model element and mark the corresponding feature.