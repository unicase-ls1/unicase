### Server Request Guidelines ###

If you are building a view or a widget of some kind and you want to request data form the server, you'll have to check if you are already logged in, if you have the right credentials, if any exceptions are thrown on the way, etc.

All of this is handled by the ServerRequestHandler and ServerRequestCommandHandler (the latter meaning that everything is executed within a RecordingCommand). If you are implementing an UI handler, you only need to extend one of these request handlers instead of the AbstractHandler.

In case you want just to execute something within your view, you can create an anonymous or a nested instance of one of the handlers. In 99.9% of the !usecases you will already need a transactional command to access the model, so your code should look like this:


```
TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
          .getEditingDomain("org.unicase.EditingDomain");
       domain.getCommandStack().execute(new RecordingCommand(domain) {
          @Override
          protected void doExecute() {
             // myCustomMethod();
          }
       });

```


> You only need to replace it with this:


```
ServerRequestCommandHandler handler = new ServerRequestCommandHandler(){      
          @Override
          protected Object run() throws EmfStoreException {
             // return myCustomMethod(params);
             // 
             // or if you are using field references and don't need a return object
             // 
             // myCustomMethod(params);
             // return null;
          }
       };
       try {
          handler.execute(new ExecutionEvent());
       } catch (ExecutionException e) {
          DialogHandler.showErrorDialog(e.getMessage());

}
```