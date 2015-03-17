This documentation contains three parts.
  1. [How to configure Eclipse to run Rich Ajax Platform (RAP) plugins](#How_to_configure_Eclipse_to_run_Rich_Ajax_Platform_(RAP)_plugins.md)
  1. [Creating Sample RAP Plugin](#Creating_Sample_RAP_Plugin.md)
  1. [How to setup hybrid target platform to run RCP and RAP plugins](#How_to_setup_hybrid_target_platform_to_run_RCP_and_RAP_plugins.md)


## How to configure Eclipse to run Rich Ajax Platform (RAP) plugins ##

The RAP project enables developers to build rich, Ajax-enabled Web applications by using the Eclipse development model, plug-ins with the well known Eclipse workbench extension points and a widget toolkit with SWT API (plus JFace).

This documentation was written for Eclipse versions 3.5 and 3.6. Although the configuration is mostly same for both of them, there are some differences between them if you want to create your own hybrid/cross platform. This issue is explained at the end of this documentation.

The easiest way to install RAP SDK and Tooling is to install it from a software repository. You should follow these steps:

For Eclipse 3.6 (Helios) and Eclipse 3.5 (Galileo):

**1.**Select the **Help > Install New Software ...** menu entry.
<br>
<b>2.</b>Add new Update Site with RAP Update Site URL. The update site is<br>
<blockquote><a href='http://download.eclipse.org/rt/rap/1.3/tooling'>http://download.eclipse.org/rt/rap/1.3/tooling</a></blockquote>

<b>3.</b>After a short while, an entry labelled Rich Ajax Platform (RAP) appears in the list below. Select its check box and click <b>Next</b>.<br>
<br>
<b>4.</b>On the the next page you may review the installation details.<br>
<br>
<b>5.</b>Accept the terms in the license agreement and click the <b>Finish</b> button.<br>
<br>
<b>6.</b>The feature and plug-ins will now be downloaded from the repository and installed<br>
locally. This can take some time according to your internet connection.<br>
<br>
<b>7.</b>After downloading and finishing the installation, you will be prompted to restart Eclipse. Confirm this and restart the Eclipse.<br>
<br>
<b>8.</b>When your Eclipse runs again, a welcome page is displayed. It is shown in the picture below.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/Welcome_Page.png' />

<br>

<b>9.</b>Click on the <b>Rich Ajax Platform (RAP)</b> section and you will see a new view which enables you to install the target platform for RAP.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/Install_Target_Platform.png' />

<br>

<b>10.</b>On this page click <b>Install Target Platform</b>. In the upcoming dialog (shown below) it will ask you to select a directory where target platform should be installed. Change the path to your specific needs, if necessary. After you've set the installation directory the installation process starts (By default your RAP target will be installed under <i>"eclipse/configuration/org.eclipse.rap.target-1.3"</i>). If you have any RCP projects in your workspace, you may get compile errors after switching the target platform.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/Target_Path.png' />

<br>

<b>11.</b>Finally, your Eclipse is ready for running RAP applications.<br>
<br>
<br>

<h2>Creating Sample RAP Plugin</h2>

Let's create sample RAP plugin to see how it works. I have used one of the template projects from Eclipse:<br>
<br>
<b>1.</b>Select <b>File > New > Project > Plug-in Project</b>
<br>
<b>2.</b>Name to your project (e.g. RAP-Mail) Select <b>Next</b>.<br>
<br>
<b>3.</b>Don't change anything. Select <b>Next</b>.<br>
<br>
<b>4.</b>Select <b>RAP Mail Template</b> and select <b>Finish</b>.<br>
<br>
<b>5.</b>Your first RAP plugin has been created.<br>
<br>
<b>6.</b>Select the project and click <b>Run As > RAP Application</b>.<br>
<br>
<b>7.</b>You get this view in your Eclipse.<br>
<br>
<img src='http://unicase.googlecode.com/files/RAP_Mail.png' />

<br>

You can also acces your RAP application with your favourite browser. Copy the URL from Eclipse's internal browser address bar and paste it your favourite browser. Then, enjoy  :)<br>
<br>

<h3>How to switch target platform?</h3>

As I said before, if you have RCP projects in your workspace, you may get compilation errors after switching the target platform. Therefore, you can't run these projects. You need to change your target platform back to the default one of Eclipse. One can do that by:<br>
<br>
<b>1.</b>Selecting <b>Window > Preferences</b> (on Mac OS: Eclipse -> Preferences or use key combination Cmd + ,)<br>
<br>
<b>2.</b>Open <b>Plug-in Development > Target Platform</b>. You will see this view.<br>
<br>
<img src='http://unicase.googlecode.com/files/Install_Target_Platform.png' />

<br>
On the right hand side you will see your target platform definitons. If you haven't  installed any target definitions before the RAP one, there should be only two target definitions. After having installed the <b>RAP</b> target, it will be set active. If you want to run RCP plugins again, you should select <b>"Running Platform"</b> as an active target. After that, you will get compile errors in your RAP plugins.<br>
<br>
<br>

<h3>How to setup hybrid target platform to run RCP and RAP plugins</h3>

If you want to develope RCP and RAP plugins against one target platform, you need to setup your own hybrid/cross target platform which contains both bundles from the Eclipse and the RAP target. If you want to do that, I advice you to use Eclipse 3.6 (Helios). That's because some of bundles exist in both targets and they may have different versions, e.g. example,org.eclipse.core.jobs, org.eclipse.core.runtime, org.eclipse.equinox. When you try to run a plugin, Eclipse may not be able to figure out which bundle should be loaded. Therefore, you may receive an exception, which reads like:  "<i>org.osgi.framework.BundleException. The bundle could not be resolved. Reason: Another singleton version selected:</i>".<br>
In Eclipse 3.6 these exceptions don't occur, since all bundles have the same version numbering within the Eclipse target and the RAP target. Thus, Eclipse is able to figure out which bundles should be added to the run configuration.<br>
<br>
<b>1.</b>Select <b>Window > Preferences</b> in the Eclipse.<br>
<br>
<b>2.</b>Open <b>Plug-in Development > Target Platform</b>.<br>
<br>
<b>3.</b>Click <b>Add</b> Button.<br>
<br>
<img src='http://unicase.googlecode.com/files/Target-1.png' />
<br>
<br>
<b>4.</b>Select <b>"Nothing: Start with an empty target definition"</b>
<br>
<b>5.</b>Give a name to your target definition.<br>
<br>
<b>6.</b>Click <b>Add</b> button to add content to your target.<br>
<br>
<img src='http://unicase.googlecode.com/files/Target-2.png' />
<br>
<br>
<b>7.</b>Select <b>Installation</b> and click <b>Next</b> button.<br>
<br>
<br>
<img src='http://unicase.googlecode.com/files/Target-3.png' />
<br>
<br>
<b>8.</b>First, you add your Eclipse target definition. Click <b>Variables...</b> button. Choose <b>eclipse_home</b> variable and click <b>OK</b> button.<br>
<br>
<br>
<img src='http://unicase.googlecode.com/files/Target-4.png' />
<br>
<br>
<b>9.</b>Click <b>Finish</b> button. You've now added the Eclipse target to your own target definition.<br>
<br>
<b>10.</b>Now we will add the RAP target. Again, click the <b>Add</b> button.<br>
<br>
<b>11.</b>Select <b>Installation</b> and click the <b>Next</b> button.<br>
<br>
<b>12.</b>Click the <b>Browse</b> button and browse to your RAP SDK directory and add it.<br>
<br>
<img src='http://unicase.googlecode.com/files/Target-5.png' />
<br>
<br>
<b>13.</b>Click the <b>Finish</b> button. You've now finished your target definition setup. In the picture below you see an overview of a target definition. If the number of included bundles is different for you, don't confuse, it may differ according to your Eclipse installation.<br>
<br>
<img src='http://unicase.googlecode.com/files/Target-6.png' />
<br>
<br>
<b>14.</b>Click Finish. Your target definition should be in target definition list.<br>
<br>
<img src='http://unicase.googlecode.com/files/Target-7.png' />
<br>

<b>15.</b>Finally, don't forget to select your target definition as an <b>active target</b>. Click the OK button.<br>
<br>
Eclipse will load your new target definition and compile all plugins agains your target.<br>
<br>
I hope, this documentation helps you.