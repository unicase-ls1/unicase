The Image objects (used for icons, etc.) are heavy weighted object
which consume OS resources like handles. These object are managed
directly by OS and not by JVM and hence are not garbage collected.
Because of that, there are some limitations in creating and using
them.<br>


Most important is how we create them using createImage() method<br>
and use them in LabelProviders.<br>
For exmaple I tested UNICASE with a profiler and as soon as TaskView<br>
is opened, there are about 6000 image objects in memory. This should<br>
not be the case and probably leads to "no more hadles" exception.<br>
I recommend that we read the following article and everyone reviews<br>
his code to match guidelines provided in it:<br>
<br>

<a href='http://www.eclipse.org/articles/Article-Using%20Images%20In%20Eclipse/Using%20Images%20In%20Eclipse.html'>http://www.eclipse.org/articles/Article-Using%20Images%20In%20Eclipse/Using%20Images%20In%20Eclipse.html</a>