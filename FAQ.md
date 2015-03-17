**Q: How should I configure a new plugin?**
<br>
A: Create a new folder at the repository root (e.g. unicase/trunk). You can do this using the repo browser for example. Name the folder like the package the plugin is going to provide (e.g. org.unicase. workspace). Package names are always prefixed with org.unicase. Checkout the new folder with svn in eclipse as a new Project. Select PluginProject in Plugin Development. Set the plugin id to the package name. Set version to 0.0.1. The plugin name must be prefixed with "unicase". The plugin provider is unicase.org. The remaining settings can be left to default, so just click on finish.<br>
<br>
<b>Q: How do I add an interface or superclass to a generated EMF class?</b><br>
A: add @implements <code>&lt;interfacename&gt;</code> or @extends <code>&lt;superclassname&gt;</code> to the user doc block in the javadoc of the class declaration. Do not add @generated NOT to the class declaration since this will stop emf from ever regenerating the class.<br>
<br>
<b>Q: How should I configure my plugin's dependencies?</b><br>
A: Double click on your Manifest.MF and switch to the dependency tab. Here you can add dependecies you need, e.g. org.unicase.model. Unless you know why do not add a minimum or maximum version number. If it is added by default if you add a dependency remove it please.<br>
<br>
<b>Q: How can I get access to the UNICASE Workspace from a plugin?</b><br>
A: Import org.unicase.workspace as a dependency. Call<br>
WorkspaceManager.getInstance().getCurrentWorkspace().<br>
<br>
<b>Q: Which Content or LabelProvider should I use?</b><br>
A: e.g. for a LabelProvider only for Model:<br>
<br>
<pre><code>new AdapterFactoryLabelProvider(new ModelItemProviderAdapterFactory());<br>
for a ContentProvider only for Workspace: new AdapterFactoryContentProvider(new WorkspaceItemProviderAdapterFactory());<br>
</code></pre>

for a LabelProvider for all Models:<br>
<pre><code><br>
new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));<br>
</code></pre>

<b>Q: How do I listen for change events of a model element or a certain feature?</b><br>

A: Add an adapter to the model element overriding the notifyChanged() method:<br>
<br>
<pre><code><br>
modelElement.eAdapters().add(new AdapterImpl() {<br>
   @Override<br>
   public void notifyChanged(Notification msg) {<br>
      if(msg.getFeature().equals(certainFeature)){<br>
         doSomething();<br>
      }<br>
      super.notifyChanged(msg);<br>
   }<br>
});<br>
<br>
</code></pre>

<b>Q: How do I use standard icons/images from eclipse?</b><br>
A:<br>
<pre><code>PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.XXX)<br>
</code></pre>
<blockquote><b><i>Hint: Many other free icons can be found on <a href='http://www.famfamfam.com/'>FamFamFam</a>.</i></b></blockquote>

<b>Q: I add sth. in a Composite, but it wont show up. What am I doing wrong?</b><br>
A. You probably forgot to set a LayoutManager for the Composite.<br>
<br>
<b>Q: What is the difference between a command and an action?</b><br>
A: <a href='http://wiki.eclipse.org/FAQ_What_is_the_difference_between_a_command_and_an_action%3F'>http://wiki.eclipse.org/FAQ_What_is_the_difference_between_a_command_and_an_action%3F</a>

<b>Q: How do I change the dummy project?</b><br>
A: It's created in createDummyProject() in EmfStoreStub and it is returned if you check out a project with the esbrowser.<br>
<br>
<b>Q: How can I rename a plugin?</b><br>
A: Rename the plugin with Refactor -> Rename (this will also change the plugin.xml and co. Rename the packages with Refactor -> Rename. Use hierarchical view to rename the base package and check "Rename subpackages". Possibly also change the name in menu entries or view extension points (use global text search). Commit your changes. Delete the plugin from your local workspace (include contents). Open SVN repo browser (Show View ->SVN -> Repository Browser). Goto the plugin folder and select "Rename..." from context menu and rename to the new plugin name. Checkout plugin again.<br>
<br>
<b>Q: I have compiled my GUI plugin and there are no compile errors but I can't find it later in my runtime Eclipse instance. What should I do?</b><br>

A: Check if your plugin is depending on another one that has compile errors. In case you have just set up a new workspace the cause might be a missing(s) dependency(ies) or just an old version of the same.<br>
<br>
<b>Q: I have and EClass for my model element type. How can I create an instance of this model element type?</b><br>
A:<br>
<pre><code>    EPackage ePackage = modelElementType.getEPackage();<br>
    modelElementInstance = (ModelElement) ePackage.getEFactoryInstance().create(modelElementType);<br>
<br>
</code></pre>

<b>Q: What does the checkstyle warning about header mean?</b><br>
A: Every file is expected to have the following header for licensing reasons:<br>
<pre><code>/**<br>
 * &lt;copyright&gt; Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the<br>
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this<br>
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html &lt;/copyright&gt;<br>
 */<br>
<br>
</code></pre>

<b>Q: How can I format source code in the wiki in a way that whitespace is preserved and a mono spaced font is used?</b><br>
A: Open the page in question for editing, select "Edit HTML" and add the following to the code to html:<br>
<br>
<code>&lt;pre&gt;</code> your source code here <code>&lt;/pre&gt;</code>

Remove all tabs from the code and replace them by spaces (use TextEdit, Search&Replace). Note: After adding the above mentioned tags to html, you can also edit the code in the normal wiki edit mode.<br>
Update: An easier way to add code is to write "begin end" into a line, format the line as monospace (click on the paragraph symbol) and then paste your code in between "begin" and "end". You can then safely remove begin and end. Still it is sometimes better to replace the tabs with whitespace beforehand since the Wiki wastes quite some space for a single tab.<br>
<br>
<b>Q: Can I use third party libraries, what about licensing?</b> <br>
A: Libraries distributed under the EPL can be used without a problem. However any other license is subject to closer inspection. Please discuss with project lead and consult the Eclipse foundation at license@eclipse.org. A good FAQ on licensing and the EPL is available on <a href='http://www.eclipse.org/legal/eplfaq.php'>Eclipse.org</a>

<b>Q: I am getting a ClassNotFoundException when trying to run the MEEditor?</b> <br>
A: The editor is using an external library in the form of an Eclipse plugin. Please install it manually in your Eclipse environment - see <a href='http://code.google.com/p/unicase/wiki/Getting_started_as_developer'>Getting started as developer</a>
When the Update Site for UNICASE is set up, all needed dependencies will be deployed there.<br>
<br>
<b>Q: I am trying to manually deploy a plugin, but I am getting a strange <code>java.lang.IllegalArgumentException</code>?</b> <br>
A: Please read this blog entry: <a href='http://code.google.com/p/unicase/wiki/Build_Deployable_Product'>Build Process</a>

<b>Q: How to increase the default memory heap size used by the VM?</b> <br>
A: Changing the heap size for Eclipse:<br>
Locate the eclipse.ini in your Eclipse installation (the location depends on the package/OS) and edit the following parameters --Xms40m and --Xmx512m. The first one specifies the starting heap size and the other - the largest allowed heap size.<br>
Changing the heap size for your Runtime Eclipse: Edit the same parameters under "VM args" in your Run/Debug configuration.<br>
<br>
<b>Q: What can I do if I experience troubles running UNICASE, if I get an Exception when running UNICASE or if UNICASE won´t start?</b> <br>
A: Follow this <a href='http://code.google.com/p/unicase/wiki/Deployement_Environment_Troubleshooting'>howto</a> to return to a well-defined state with your UNICASE development environment.<br>
<br>
<b>Q: How can I report bugs via the UNICASE server?</b> <br>
A: First of all, you need an account at our chair. Without that you won't be able to login. For a short howto see: <a href='Report.md'>bugs screenshot tour</a>

<b>Q: How do I use a ProgressBar?</b> <br>

A:<br>
<pre><code><br>
ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()<br>
       .getActiveWorkbenchWindow().getShell());<br>
<br>
dialog.open();<br>
<br>
dialog.getProgressMonitor().beginTask("MyTask", 100);<br>
<br>
for(int i=1;i&lt;10;i++){<br>
<br>
dialog.getProgressMonitor().worked(10);<br>
<br>
//Do sth.<br>
<br>
}<br>
<br>
dialog.getProgressMonitor().done();<br>
<br>
dialog.close();<br>
</code></pre>

<b>more infos: <a href='http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/JFacesProgressMonitorDialog.htm'>ProgressMonitorDialog</a></b>


<b>Q: How do I copy a file contained in a bundle?</b><br>

A: Do the following:<br>
<br>
<pre><code>InputStream inputStream = getClass().getResourceAsStream(filename-in-package);<br>
<br>
File clientKeyTarget = new File(/target/file/path/and/name);<br>
<br>
// copy to destination<br>
org.unicase.model.util.FileUtil.copyFile(inputStream, clientKeyTarget);<br>
<br>
</code></pre>

<b>Q: How do i get a file contained in my own bundle?</b><br>

A: do this:<br>
<br>
<pre><code><br>
URL url = FileLocator.find(<br>
    Activator.getDefault().getBundle(), <br>
    new Path("myFolder/"), <br>
    Collections.EMPTY_MAP<br>
);<br>
			<br>
File f = new File(FileLocator.resolve(url).getPath() + myFileName);<br>
<br>
</code></pre>
<b>Q: Where is all the UNICASE data (workspace, projectspace, usersessions server infos) stored?</b><br>
A: For the released versions of the UNICASE client it is stored in the <code>&lt;userhome&gt;</code>/.unicase folder. Every subfolder is one project space. For the development version it is stored in <code>&lt;userhome&gt;</code>/.unicase.dev. Whether or not the current client is considered to be a released version depends on the version of the org.unicase.workspace plugin. (Also see Configuration.isReleaseVersion())<br>
<br>
<b>Q: How can I display non-containment references as children (helpful in the navigator)?</b><br>
A: Open model.genmodel and select the reference. In the properties view set the "Children" attribute to "true". EObjects referenced here are now displayed as children.<br>
<br>
<b>Q: Subclipse tells me "JavaHL not found" in linux?</b><br>
A: Usually there is a JavaHL package you can install on your linux. But you have to tell eclipse the path to the JavaHL Library, also. Add the following line to the eclipse.ini:<br>
<pre><code>    -Djava.library.path=/usr/lib/jni<br>
</code></pre>
This very path is used by Ubuntu Linux, of course you have to use the correct path for your system.<br>
<br>
<b>Q: How should I refresh GUI on events triggered from non-GUI threads?</b><br>
A: Trying to refresh UI components from non-UI threads (e.g. on EMF notifications) can lead to InvalidThreadAccess exception.<br>
To avoid this situation you must use following code to access UI using a new UI thread:<br>
<pre><code><br>
Display.getDefault().asyncExec(new Runnable() {<br>
<br>
public void run() {<br>
<br>
//access to GUI here. For example: viewer.refresh();<br>
<br>
}<br>
});<br>
<br>
</code></pre>
<b>Q: How can i contribute help contents?</b><br>
A: The easiest way to do this is to proceed as follows:<br>
<ul><li>Add the following in an existing contexts.xml: or create an appropriate file if necessary.</li></ul>

<code>&lt;context id="my_help_id" &gt;</code>
<blockquote><code>&lt;description&gt;This is the description for the help i'm giving.{{{&lt;/description&gt;</code>
<code>&lt;/context&gt;</code></blockquote>

<ul><li>Reference this file in the plugin.xml (if not already done)</li></ul>

<code>&lt;extension point="org.eclipse.help.contexts"&gt;</code>
<blockquote><code>&lt;contexts file="contexts.xml"&gt;</code><code>&lt;/contexts&gt;</code>
<code>&lt;/extension&gt;</code></blockquote>

<ul><li>Change build.properties if necessary, to include contexts.xml in the build.<br>
</li><li>Set the specific help control, e.g. in createPartControl in a dialog:<br>
<pre><code>PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, Activator.PLUGIN_ID + ".my_help_id");<br>
</code></pre></li></ul>

<b>Also see:</b>
<a href='http://stackoverflow.com/questions/1012929/eclipse-contextual-help/1021718'>http://stackoverflow.com/questions/1012929/eclipse-contextual-help/1021718</a> <br>
<a href='http://dev.eclipse.org/newslists/news.eclipse.platform.ua/msg00359.html'>http://dev.eclipse.org/newslists/news.eclipse.platform.ua/msg00359.html</a>