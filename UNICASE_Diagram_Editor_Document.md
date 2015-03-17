## GMF ##
**Links:**
  * **_Basics_** - http://www-128.ibm.com/developerworks/opensource/library/os-ecl-gmf/
  * **_Creating two (or more) diagrams of the same domain model_** - http://wiki.eclipse.org/Graphical_Modeling_Framework/Tips#Sharing_single_EditingDomain_instance_across_several_diagrams
  * **_GMF Tips_** - http://wiki.eclipse.org/Graphical_Modeling_Framework/GenModel/Hints

### Custom UNICASE Diagrams ###

This tutorial will explain how to implement a GMF Editor such that it is integrated in  UNICASE, meaning that the diagram element can be created within a UNICASE project similar to other model elements. The process will be explained from a certain knowledge level. If you have trouble understanding the details, please refer to the other tutorials.

I used Indigo SR2 Eclipse Modeling Tools Edition in this tutorial, along with UNICASE (0.5.2) which uses EMFStore/ECP (0.9.3). In order to properly follow this tutorial, you need to install GMF Tooling from the update site (http://download.eclipse.org/modeling/gmp/gmf-tooling/updates/releases). The required features are "Graphical Modeling Framework (GMF) Tooling", "Graphical Modeling Framework (GMF) Tooling Runtime Extensions" and "Graphical Modeling Framework (GMF) Tooling SDK".

### Ecore Model ###

First of all, the Ecore model for the diagram and its elements need to be defined. To do so we need to create a new Ecore Model (.ecore) from the Eclipse Modeling Framework (EMF).

Assuming you already know how to create an Ecore Model I will just provide a list of elements to create in your model:
  * One `EClass` for the canvas element; `ESuperType` must be `MEDiagram` (from the `diagram.ecore` in the `org.unicase.diagram plug-in`)
  * One `EClass` for each element/node that is supposed to appear in the diagram; `ESuperType` must be `UnicaseModelElement`
  * One `EReference` for each association/edge between elements/nodes

**NOTE:** In this tutorial, we will only have one node. You can, of course, have an alternate model. For more help, see the GMF tutorials above.

Next, we need to generate the "Model Code" and "Edit Code" from the EMF Generator Model (`.genmodel`) which is based on your Ecore Model. If everything worked correctly, there will be a compilation error in your generated model code, namely in your Canvas Element implementation. That is due to the fact, that its superclass, `MEDiagram`, is abstract and defines the abstract method `getType()`, which needs to be implemented. We will take care of this later.

### GMF Modeling ###

The next step is to generate the GMF code. The actual modeling is not part of the tutorial, so if you are unexperienced in this area, please check another tutorial first. The GMFGraph Model and the GMFTool Model can be created in the usual way.

For the GMFMap Model, please make sure:
  * that the "Canvas Mapping" lists your `MEDiagram`-extension as "element"
  * that every "Top Node Reference" has `MEDiagram.elements` as its "Children Feature" and `MEDiagram.newElements` as its "Containment Feature".

In the GMFGen Model, you need to adjust the Visual ID as explained here: http://code.google.com/p/unicase/wiki/MEDiagram_ID_Settings

After you have finished the modeling process, you can generate the diagram code from the `.gmfgen` file.

### UNICASE Integration ###

So far, the process was pretty straightforward, if you are experienced in EMF and GMF, apart from a few minor adjustments. This last part is UNICASE specific and is required to provide a fluent integration into UNICASE.

As a first step, we will add all the required plug-ins to the newly generated diagram plug-in's dependencies. Open the `plug-in.xml` and add the following plug-ins to the dependencies:

  * `org.unicase.ui.unicasecommon`
  * `org.eclipse.emf.ecp.common.util`

Next, we need to create a new class for our own implementation of `ModelElementOpener` to tell the ECP Navigator to open the correct editor when opening the canvas element. By default, this will just show the element as a plain `UnicaseModelElement` in the ECP Editor, allowing to edit the attributes. Create a new class in your diagram plug-in which extends `DiagramOpener` and implements `ModelElementOpener` (see below. By implementing this interface, you need to implement the methods `canOpen(EObject)`, which returns the priority to use this implementation to open a certain `EObject` and `openModelElement(EObject)` which will actually open an `EObject`.

```
public class MyDiagramOpener extends org.unicase.ui.unicasecommon.common.diagram.DiagramOpener
       implements org.eclipse.emf.ecp.common.util.ModelElementOpener {
    ...
}
```

In the first method mentioned, you should do validity checks to make sure the `EObject` is of your canvas element's type (the class which extends `MEDiagram`. If you do not want to open a certain `EObject`, you should return `DONOTOPEN`, otherwise a positive priority.

```
public int canOpen(EObject modelElement) {
    return modelElement instanceof MyDiagram ? 1 : DONOTOPEN;
}
```

The second method should implement the logic to actually open the editor. Luckily, we can just pass this call to the superclass, `DiagramOpener`, which already provides this method. Simply pass the `EObject` and the ID of your diagram's editor to the implementation of `openDiagram(EObject, String)` in your superclass. The ID can be found in the `XXX.diagram.part` package in the `XXXDiagramEditor.java` file as a constant.

```
public void openModelElement(EObject modelElement) {
    if(modelElement instanceof MyDiagram) {
        super.openDiagram((MEDiagram) modelElement, myPackagePath.diagram.part.MyDiagramEditor.ID);
    }
}
```

In order to tell the ECP Navigator to make use of this `ModelElementOpener`, we also need to add an extension. Open the `plug-in.xml` again and add an extension to the extension-point `org.eclipse.emf.ecp.common.modelelementopener`. Enter a name and link to your implementation of the `ModelElementOpener` for the "class" attribute.

```
<extension
      point="org.eclipse.emf.ecp.common.modelelementopener">
   <ModelElementOpener
         class="myPackagePath.diagram.MyDiagramOpener"
         name="org.unicase.ui.mydiagram.diagram.ModelElementOpener1">
   </ModelElementOpener>
</extension>
```

Next, we need to adjust the `XXXDiagramEditor.java` to work correctly within UNICASE. The file is located in the `XXX.diagram.part package` and its class extends `DiagramDocumentEditor`. The adjustments have already been implemented in `ModelDiagramEditor`, so remove `DiagramDocumentEditor` as a superclass and replace it with `ModelDiagramEditor`.

```
public class MyDiagramEditor extends org.unicase.ui.unicasecommon.diagram.part.ModelDiagramEditor
    implements IGotoMarker {
    ...
}
```

We will do the same thing for the `XXXDocumentProvider.java`, which is in the same package as the corresponding editor file. Replace `AbstractDocumentProvider` as a superclass with `ModelDocumentProvider`. This will cause compilation errors in your `XXXDocumentProvider`, thus you need to remove the methods which cannot be overridden (should be 2). Also, you need to implement the `getPreferencesHint()` method, in which you can just return a new `PreferencesHint` with any (unused) ID.

```
public class MyDocumentProvider extends org.unicase.ui.unicasecommon.diagram.part.ModelDocumentProvider
    implements IDiagramDocumentProvider {
    ...
	@Override
	protected PreferencesHint getPreferencesHint() {
		return new PreferencesHint("MyDiagram");
	}
```

Now we are almost done, we just need to fix our generated model code, which still has a compilation error. To implement the `getType()` method in your `MEDiagram` subclass, you need to navigate to the `XXX.diagram.edit.parts package` and open the `XXXDiagramEditPart.java` (which extends `DiagramEditPart`). The constant `MODEL_ID` is the type you need to return in your generated model code. This will link the diagram editor to the correct canvas element and create the elements correctly.

```
package myPackagePath.diagram.edit.parts;

public class MyDiagramEditPart extends DiagramEditPart {

    // this is the ID we need
    public final static String MODEL_ID = "MyDiagram"; //$NON-NLS-1$
    ...
}

/* Take the ID from above (diagram plug-in) and insert it in the method below (model plug-in) */

package myPackagePath.impl;

public class MyDiagramImpl extends MEDiagramImpl implements MyDiagram {
    ...
	@Override
	public String getType() {
		return "MyDiagram";
	}
}
```

Note that we cannot use the `MODEL_ID` constant itself, as it is located in the diagram plug-in and it would cause cyclic dependencies. Additionally, it is considered bad practice for the model plug-in to have dependencies to UI plug-ins.

### Profit ###

Congratulations, you are done! Your diagram can now be created in UNICASE and shared with the EMFStore. Note that the elements will be added as siblings to the diagram instead of children (to the canvas element's parent). Please also note, that this diagram comes with some features like drag & drop.