**_Easy general RMI tutorial:_** <br>
<blockquote><a href='http://www.galileocomputing.de/openbook/javainsel7/javainsel_18_003.htm'>http://www.galileocomputing.de/openbook/javainsel7/javainsel_18_003.htm</a>
<br></blockquote>


<b><i>RMI in PDE:</i></b>
<ul><li>Set security policies in java runtime and set the rmisecuritymanager<br>
</li><li>Handle classloader issue - until now, a little hack: (from <a href='http://www.tutorials.de/forum/java/269599-rmi-als-eclipse-plug.html'>http://www.tutorials.de/forum/java/269599-rmi-als-eclipse-plug.html</a>)<br>
<pre><code>URL url = FileLocator.find(Activator.getDefault().getBundle(),new Path("/bin/"),null);<br>
System.setProperty("java.rmi.server.codebase", url.toExternalForm());<br>
</code></pre></li></ul>

<blockquote><a href='http://www.martinlippert.com/publications/JS-Classloading-in-Eclipse-final-web.pdf'>http://www.martinlippert.com/publications/JS-Classloading-in-Eclipse-final-web.pdf</a>