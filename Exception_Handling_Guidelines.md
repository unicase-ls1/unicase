_**This page is still prelimiary in the client exception handling section.**_

### General exception handling policy: ###

  * **Do NOT** catch Exception or RuntimeException or any subtype of RuntimeException (there is only very very few exceptions to that rule). By catching these you will mask other errors and make debugging much more difficult.

<p><b>There is only two things you can do with an exception:</b> </p>

  * **Handle exception:** If you can do something about the exception, that is resolve the problem that was signaled by it, you should do this a early as possible. Often it is useful to log the problem even if you successfully recovered from the exception. If you are in a method directly triggered by the user providing an appropriate error message to the user is also a way of handling the exception (if the exception is not fatal to the application).

  * **Wrap or declare throws clause:** If you can not do something to resolve the problem flagged by the exception you can either add some descriptive message and wrap the causing exception into a new exception or just declare a throws clause in the method. As mentioned earlier however an exception should be handled as soon as possible since the chance that someone up in the call hierarchy can effectively handle it is decreasing with the call hierarchy depth.

#### There are two levels of severity of exceptions: ####

  1. **Non-fatal exceptions:** The application can continue to run without a great loss in functionality and data. Non-fatal exception should be recovered by the code catching the exception and might result in a warning about possible remaining problems.

  1. **Fatal exceptions:** The application is in an undefined state where data might be lossed or a great loss in functionality occurred and the exception is not recoverable. The handling code should log the exact cause and context of the exception, abort any other operations of the application and trigger a clean but immediate shutdown.

### Client exception handling: ###

  * **Non-fatal exceptions:** Handle the exception and log it if necessary. Please use WorkspaceUtil.logException(). This will log the message to the eclipse .log file and the error log in th UI.

  * **Fatal exceptions:** Currently we have not mechanism to shut down a plugin or all plugins in case a fatal exception occurs, so the only way to deal with it is to shut down the Eclipse instance.

### Server exception handling: ###

  * **Non-fatal exceptions:** Handle the exception and log it. You can get a Logger with LogFactory.getLog(EmfStoreController.class). It is best practice to assign it to a static private variable and log the messages with it.

  * **Fatal exceptions:** Log the exception and its context as exactly as possible, and call shutdown() of EmfStoreControler; this will shut down the server in a clean but immediate way. There is a special Exception subclass to single fatal exceptions: FatalEmfStoreException. Use this exception to tell callers that an unrecoverable condition occured and that the server must be shut down.