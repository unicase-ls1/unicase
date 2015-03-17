The editor allows to register new widgets to display specific attributes. In the [example model](SetupEMFCP.md), the E-Mail attribute could be rendered by an E-Mail widget, which offers an additional button to send mails. New widgets are registered via the extension points **org.unicase.ui.meeditor.attributecontrols** for attributes and **org.unicase.ui.meeditor.referencecontrols** for references.

The following example registers the E-Mail control included in the example plugins. Besides the control itself, one have to specify the type of the attribute and whether the editor shows a label with the name of the attribute next to the widget.

```
   <extension
         point="org.unicase.ui.meeditor.attributecontrols">
      <widget
            class="examplemodel.editorcustomizations.EMailMEControl"
            name="exampleModel.editorCustomizations.widget1"
            showLabel="true"
            type="java.lang.String">
      </widget>
   </extension>
```

A widget implements two methods. 'canRender()' determines, whether the widget will render a specific attribute. The widget with the highest priority will be rendered in the editor. A return of DO\_NOT\_RENDER will affect the editor to ignore the widget. The second method actually creates the custom widget. There is a code example for a E-Mail widget in the example plugins.

```
@Override
	public int canRender(IItemPropertyDescriptor arg0, EObject arg1) {
		Object feature = arg0.getFeature(arg1);
		if (feature.equals(LibraryPackage.eINSTANCE.getWriter_EMail())) {
			return 2;
		}
		return DO_NOT_RENDER;
	}

	@Override
	public Control createControl(Composite parent, int style) {

		//Create control here

		return composite;
	}
```