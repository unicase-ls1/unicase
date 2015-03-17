## Requirements: ##

  * This document assumes that you have already set-up an eclipse instance for making Emfstore product with your custom model. In case if you want to make Emfstore stand-alone product for multiple operating systems then please also configure delta-pack within your eclipse.
  * A detailed doucmentation to configure delta-pack can be found [here](http://code.google.com/p/unicase/wiki/Emfstore_product).
  * This document also assumes that you have already installed the EMFStore Framework, if you did not then you can do it following this [tutorial](http://code.google.com/p/unicase/wiki/InstallEMFStore).

## Source: ##
<br>
<ul><li>All the code for this documentation can be found at our SVN repository using this <a href='http://unicase.googlecode.com/svn/trunk/developer/CodeExamples/'>link</a>.<br>
</li><li>We have used the example model project created in the tutorial <a href='http://code.google.com/p/unicase/wiki/RunEMFStoreWithCustomModel'>Run EMFStore with a custom model</a>.</li></ul>

<h2>Deploy</h2>
Below we describe the complete procedure to create a plugin based Emfstore product with custom model.<br>
<br>
<ul><li>Open your eclipse instance, if not already opened.<br>
</li><li>Make sure that your model plugin is available in your eclipse-workspace.<br>
</li><li>Create a new "Empty EMF Project" with a meaningful name.<br>
</li><li>You can see in the image given below that we have already checked out the example model plugins in the workspace for this tutorial and now creating a project which will hold the product configuration.<br>
<br>
<img src='http://unicase.googlecode.com/files/emptyemfproject.png' width='1000' height='600'>
<br>
</li><li>Once the project is created, create a new "Product Configuration" file within it.<br>
<br>
<img src='http://unicase.googlecode.com/files/newproductfileforemfstore.png' />
<br>
</li><li>Open the newly created "Product Configuration" file and specify the ID, Version and Name in their respective fields.<br>
<br>
<img src='http://unicase.googlecode.com/files/open%20prodcutfile.png' />
<br>
</li><li>Make sure that within the "Product Definition" section "The product configuration is based on:" has value "plug-ins" selected unless you want to make your product based on features(This tutorial strictly follows the plug-ins based approach only).<br>
</li><li>In the "Product Definition" section, for the field "Product" click the associated button with text "New.." to define the new Eclipse product and its default entry point.<br>
<br>
<img src='http://unicase.googlecode.com/files/openentrypointwindow.png' />
<br>
<ul><li>Specify the plugin which holds your product configuration in the "Defining Plug-in" field.<br>
</li><li>Specify a "Product ID".<br>
</li><li>Select "org.unciase.emfstore.server" as the default Product Application.<br>
</li><li>Click on Finish.<br>
<br>
<img src='http://unicase.googlecode.com/files/defineentrypoint.png' />
<br>
</li></ul></li><li>Now its time to add your custom model in the dependencies and the core Emfstore plugins.<br>
</li><li>Open the dependencies tab and click on "Add.." button to add your custom model plugin. Please also make sure to add the newly created Plug-in which holds your product file.<br>
</li><li>Once you have added custom model plugins, add the core Emfstore plug-ins highlighted in the image given below. These plug-ins are :<br>
<ul><li>org.unicase.emfstore<br>
</li><li>org.unicase.emfstore.esmodel<br>
</li><li>org.unicase.metamodel<br>
<br></li></ul></li></ul>

<img src='http://unicase.googlecode.com/files/emfstorepluginscore.png' />

<br>
<ul><li>The final selection of plugins is:</li></ul>

<br>
<img src='http://unicase.googlecode.com/files/selectedplugins.png' />

<br>
<ul><li>Once these plug-ins are added, you can click on the button in the right with text "Add Required Plug-ins" to add the other plugins which might be required for the product to run properly.<br>
</li><li>You can also select the check-box to include optional dependencies to avoid any unwanted trouble. It may increase the size of your final product in terms of storage space by adding additional plug-ins which may not be required.</li></ul>

<br>
<img src='http://unicase.googlecode.com/files/plugineselectedautomatically.png' />

<br>
<ul><li>Once done with adding plug-ins, go back to "Overview" tab and click on "synchronize" link within "Testing" section.<br>
</li><li>Now you can test if your Emfstore server with the custom model is working properly or not, before you export it as a stand-alone product.</li></ul>

<br>
<img src='http://unicase.googlecode.com/files/validate%20the%20product.png' />

<br>
<ul><li>Once the Emfstore server is running without any issue, its time to export it as stand-alone product.<br>
</li><li>Open "Eclipse Product export wizard" from the link given in "Exporting" section of the "Overview" tab.<br>
<ul><li>Specify the path and other details.<br>
</li></ul></li><li>You will be able to see the check-box to export for multiple platforms if your eclipse instance is configured to use delta-pack plugin.<br>
<br></li></ul>

<img src='http://unicase.googlecode.com/files/exporttheproducts.png' />

<br>
<ul><li>If you have delta-pack configured and you have already selected the check-box to export for multiple platforms then you will get a menu like the one shown in image below.  Just select the desired OS platforms and click the finish.<br>
<br></li></ul>

<img src='http://unicase.googlecode.com/files/selectmultipleos.png' />
<br>

<ul><li>Once the export completes your products are ready to be shipped.