## The event loops: ##
Almost every UI actions and events are wrapped in the so called loops, which eventually catch all internal exceptions, so that the application doesn't hang. Since these exceptions are always caught, it is often very hard to debug them using the conventional procedures with the Eclipse Debugger.

  1. One option is to add an explicit Java Exception Breakpoint and to set it for both "caught and uncaught" exceptions. Such exceptions should be (most frequently) the usual NullPointerExceptions as well as the SWTException (the standard UI Exception for SWT).
  1. The other option is to look up the exception in the logs. Surprisingly, they are not shown (afaik) in the Eclipse Workbench, but in the .log file located in the .metadata directory of your runtime application (e.g. /runtime-EclipseApplication/.metadata).


#### Additional here is an experience report of Alex, when debugging a memory overflow in MEEditor: ####
<br>
<b>Testing against memory allocation:</b>
As it turns out, proper memory testing cannot be done due to the unpredictability of the Garbage Collector. In other words - it is impossible to keep track of the memory used by each MEPage, because the GC runs every now and then and resets the amount of used space.<br>
<br>
<b>Testing against MEEditorInput instabillity (no widgets at all):</b>
There are no signs of improvement, which would probably mean an error in the MEEditorInput or the MEEditor itself.<br>
<br>
<b>Testing of MEEditorInput:</b>

<ul><li>removing the ImageDescriptor: the bug persists<br>
</li><li>fixing the equals() method: new bug corrected, but old one still persists<br>
</li><li>replacing various methods with corresponding stubs: no changes</li></ul>

<b>Testing with various breakpoints and stepping into each code fragment:</b>
Everything seems to be working properly.<br>
<br>
<b>Testing if the Editor is not properly initialized:</b>
Trying to use the static method IDE.openEditor() doesn't seem to correct the problem.<br>
<br>
<b>Testing using a profiler:</b>
Since I couldn't connect JProfiler with Eclipse, I decided to try another profiler - YourKit java Profiler. IMHO, this tool is a "must have" when you need to debug performance problems (the installation is staight forward, so I won't bother you with setup steps).<br>
The profiler shows an awful load of object instances (both number of object and total memory load) of type MEEditor$3 (this should mean the third anonymous class instanced in MEEditor). This anonymous declaration stands for a transactional command needed to set the "dirty" flag of the editor. Apparently, the isDirty() method is being execute quite often (even by setting the focus on the editor) which causes an enormous amount of objects to be created. The GC won't delete them as fast as they are generated, so a memory overflow occurs.