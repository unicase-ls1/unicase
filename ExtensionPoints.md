**This page is currently under construction**

# UI #
  * org.unicase.ui.common.modelelementopener
> You can register new ModelElementOpener, which are responsible to open a signle ModelElement. The default is the MEEditor. Other examples are the diagram editors. Whenever you want to provide a custom view for a certain type of ModelElement, register a new ModelElementOpener at the Navigator.

  * org.unicase.ui.meeditor.pages
> You can register new pages for the MEEditor (Tabs). By the attributes "after" and "replace" you can add them relativly to existing pages and replace them.

  * org.unicase.ui.meeditor.attributecontrols
> You can register new attribute controls for the MEEditor, displaying a single attribute (no reference)

  * org.unicase.ui.meeditor.referencecontrols
> You can register new reference controls for the MEEditor, displaying a reference attribute

  * org.unicase.ui.meeditor.melinkcontrols
> You can replace the standard link widget inside the MELinkControl for specific ModelLinks