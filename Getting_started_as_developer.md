We develop UNICASE for the Eclipse platform with the Eclipse Java IDE.

We currently use the following development tools:

  * [Java 5 SE](http://java.sun.com/javase/downloads/index_jdk5.jsp)
  * [Eclipse Modeling Tools Edition](http://www.eclipse.org/downloads/) (Indigo SR2)
> > o EMF <br>
<blockquote>o Ecore Tools <br></blockquote></li></ul>

  * **Eclipse Plugins (install via Update Manager)**


> o Subclipse: http://subclipse.tigris.org/update_1.6.x<br></li></ul>

<ul><li><b>NOTE: If you are not using Windows 32 Bit you might run into problems with Subclipse because Java is started in 64bit mode by default. Here is a possible solution for the problem <a href='http://subclipse.tigris.org/wiki/JavaHL'>http://subclipse.tigris.org/wiki/JavaHL</a></b> <br></li></ul>


> o Checkstyle (the previously used version 4.4.x is no longer available at the update site. So, download the latest 5.x release.): - http://eclipse-cs.sf.net/update/<br></li></ul>


<blockquote>o UNICASE: http://unicase.googlecode.com/svn/updatesite/internal/ <br></blockquote>

  * **NOTE: Please do not install UNICASE in the same eclipse instance as the one used for development. You might face plugin version conflict.**


> o Findbugs (for static code checking): http://findbugs.cs.umd.edu/eclipse<br></li></ul>

<blockquote>o SWTBOT (for UI testing): Please find [here](http://www.eclipse.org/swtbot/downloads.php) the update site that is compatible with your eclipse version<br></blockquote>




<br><br>

<b>Getting started as developer in 8 easy steps:</b>

1. Download and install <a href='http://java.sun.com/javase/downloads/index_jdk5.jsp'>Java</a>.<br>
<br>
2. Download <a href='http://www.eclipse.org/downloads/'>Eclipse</a> and install the required plugins (see above).<br>
<br>
3. Checkout the UNICASE source code from the <a href='http://code.google.com/p/unicase/wiki/SVN_Repository'>svn repository</a> (see this link: <a href='http://code.google.com/p/unicase/source/checkout'>http://code.google.com/p/unicase/source/checkout</a>) into your Eclipse workspace using Subclipse. Please see also this <a href='CheckoutTutorial.md'>Tutorial</a>

4. Configure Target Platform as described in <a href='http://code.google.com/p/unicase/wiki/Target_Platform'>Target Platform</a>

5. Configure Java and Checkstyle warnings as described in <a href='http://code.google.com/p/unicase/wiki/Coding_Guidelines'>Coding Guidelines</a>.<br>
<br>
6. Start the UNICASE server from Eclipse, see this <a href='http://code.google.com/p/unicase/wiki/RunEMFStoreWithCustomModel'>video tutorial</a>
<a href='http://code.google.com/p/unicase/wiki/RunServerTutorial'>video tutorial</a>.<br>
<br>
7. Start the UNICASE client from Eclipse, see this <a href='http://code.google.com/p/unicase/wiki/RunClientTutorial'>video tutorial</a>.<br>
<br>
8. Register for our <a href='http://code.google.com/p/unicase/wiki/Mailinglist'>mailinglists</a>.<br>
<br>
<br>
If you have any questions please consider the FAQ and Developer FAQ and do not hesitate to use our mailinglist.<br>
<br>
Note: We use UNICASE to model UNICASE, also called boot strapping or eat-your-own-dogfood.See <a href='http://code.google.com/p/unicase/wiki/Unicase_repository_beta_server'>here</a> for details.