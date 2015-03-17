The Model API allows you to view, create, delete and modify model elements in a project. This page will list best practices and dos and donts in using this API:
<p>
<ul><li><b>Deletion</b>: A model element will be considered as deleted if it is removed from the containment tree of the project and if this is the case at the end of any command.</li></ul>

<ul><li><b>Containment Tree Preservation</b>: Do not create cross references to elements outside of the project. This would cause dangling references.</li></ul>

<ul><li><b>Intention Preservation:</b> Apply the changes on the model in the same way the user intended them in the user interface. E.g. the user opens a model element and clicks on "add comment": Add the comment to the model element by calling getComments().add(comment) on the model element. Do not call comment.setModelElement() on the comment. The way you modify the model reflects in the recorded operations.</li></ul>

<ul><li><b>Composite Preservation:</b> If you perform several changes to the model that are triggered by only one intention (e.g. click) of the user, use the composite operation support in ProjectSpace. You can call beginCompositeOperation() on the project space to announce a composite operation, you will receive a handle for the composite as a result (CompositeOperationHandle). With the handle you can control the composite. Calling abort() on the handle will rollback the operation, this is usefull in dialogs where the user may cancel the changes at any time. Calling end() on the handle will complete the composite and preserve the changes.<br>
</p></li></ul>

  * **Commands:** To read from or change something in the model you need to run a command on the transactional editing domain the model is controlled by. Otherwise the editing domain will reject your read or your changes.
This only applies if you use a transactional editing domain and is not specific to EMFStore but to TransactionalEditingDomain.
A transactional editing domain is necessary to synchronize different threads working on the model. You can use the code below to run a command on the model. There is also two additional Class for handling Parameters and return results with a command - **`UnicaseCommandWithResult`** and **`UnicaseCommandWithParameterAndResults`**.
```
new UnicaseCommand() {
   @Override 
      protected void doRun() {
        //your code in here
      }
   }.run(false); 
```