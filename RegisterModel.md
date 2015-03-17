<a href='http://www.youtube.com/watch?feature=player_embedded&v=tqQhB2L0cno' target='_blank'><img src='http://img.youtube.com/vi/tqQhB2L0cno/0.jpg' width='425' height=344 /></a>


The only information required by the EMF Client Platform, is which model shall be used. Usually there are several EMF models registered in an Eclipse instance, for example GMF. As you probably only want to see your own model in the application, in our example the library model. The EMF Client Platform will try to guess the right model, once you launch it with your own model. A better way is to register your model and explicitly tell EMF Client Platform which modle to use. This is done with the following extension point. The example shows the registration of the library example model, please replace the model package with your model URI. The URI can be found in your Ecore: Open the Properties View on the root node of your model.
```
<extension point="org.unicase.ui.common.ecpModelPackage">
      <modelPackage
            modelPackage="http:///org/eclipse/example/library.ecore">
      </modelPackage>
<extension>
```