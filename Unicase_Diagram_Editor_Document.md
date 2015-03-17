## GMF ##
**Links:**

  * **_Basics_** - http://www-128.ibm.com/developerworks/opensource/library/os-ecl-gmf/
  * **_Creating two (or more) diagrams of the same domain model_** - http://wiki.eclipse.org/index.php/GMF_Tips#Sharing_single_EditingDomain_instance_across_several_diagrams
  * **_GMF Tips_** - http://wiki.eclipse.org/index.php/GMF_GenModel_Hints



### The 1001 steps to a integrated gmf editor: ###



We want to implement our own resource as in our case diagrams and corresponding model elements are not directly saved in files.We are currently trying to do this and these are the steps we have already done:


  * We need to open the diagram editor on double click:


```
if (object instanceof MEDiagram) {
ModelElement modelElement = (ModelElement)object; 
URIEditorInput input = new URIEditorInput(URI.createURI(modelElement.getName()));
try { PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, "org.unicase.model.diagram.part.ModelDiagramEditorID", true); 
}catch (PartInitException e) 
{ // TODO Auto-generated catch block e.printStackTrace(); }
} 

```


  * We need to tell the diagram editor to use our EditingDomian by manipulating the genmodel:

<br>
<br>
<img src='http://unicase.googlecode.com/files/1973e.png' />
<br>
<br>
<ul><li>We need to implement our own resource. In our case it is: MEDiagramResource in org.unicase.diagram.part <br>
</li><li>We need a Resource Factory to create the Resource. It´s also MEDiagramResource itself<br>
</li><li>We need to register this ResourceFactory with an ID:<br></li></ul>

<pre><code>&lt;extension<br>
point="org.eclipse.emf.ecore.content_parser"&gt;<br>
&lt;parser<br>
class="org.unicase.model.diagram.part.MEDiagramResource"<br>
contentTypeIdentifier="MEDiagram"&gt;<br>
&lt;/parser&gt;<br>
&lt;/extension&gt;<br>
</code></pre>

<ul><li>Now we have to modify the ModelDocumentProvider in setDocumentContent() to load our resource:</li></ul>

<pre><code><br>
/**<br>
* @generated NOT<br>
*/<br>
protected void setDocumentContent(IDocument document, IEditorInput element)<br>
throws CoreException {<br>
IDiagramDocument diagramDocument = (IDiagramDocument) document;<br>
TransactionalEditingDomain domain = diagramDocument.getEditingDomain();<br>
if (element instanceof FileEditorInput) {<br>
IStorage storage = ((FileEditorInput) element).getStorage();<br>
Diagram diagram = DiagramIOUtil.load(domain, storage, true,<br>
getProgressMonitor());<br>
document.setContent(diagram);<br>
} else if (element instanceof URIEditorInput) {<br>
URI uri = ((URIEditorInput) element).getURI();<br>
Resource resource = null;<br>
try {<br>
// resource = domain.getResourceSet().getResource(<br>
// uri.trimFragment(), false);<br>
if (resource == null) {<br>
resource = domain.getResourceSet().createResource(<br>
uri, "MEDiagram");<br>
}<br>
if (!resource.isLoaded()) {<br>
try {<br>
Map options = new HashMap(GMFResourceFactory<br>
.getDefaultLoadOptions());<br>
// @see 171060<br>
// options.put(org.eclipse.emf.ecore.xmi.XMLResource.<br>
// OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);<br>
resource.load(options);<br>
} catch (IOException e) {<br>
resource.unload();<br>
throw e;<br>
}<br>
}<br>
// if (uri.fragment() != null) {<br>
// EObject rootElement = resource.getEObject(uri.fragment());<br>
// if (rootElement instanceof Diagram) {<br>
// document.setContent((Diagram) rootElement);<br>
// return;<br>
// }<br>
// } else {<br>
for (Iterator it = resource.getContents().iterator(); it<br>
.hasNext();) {<br>
Object rootElement = it.next();<br>
if (rootElement instanceof Diagram) {<br>
document.setContent((Diagram) rootElement);<br>
return;<br>
}<br>
// }<br>
}<br>
<br>
</code></pre>

<ul><li>We need to override the method createEmptyDocument like this:</li></ul>

<pre><code><br>
/**<br>
<br>
* @generated NOT<br>
<br>
*/<br>
<br>
protected IDocument createEmptyDocument() {<br>
<br>
DiagramDocument document = new DiagramDocument();<br>
<br>
document.setEditingDomain(TransactionalEditingDomain.Registry.INSTANCE<br>
<br>
.getEditingDomain("org.unicase.EditingDomain"));<br>
<br>
return document;<br>
<br>
}<br>
<br>
</code></pre>


<ul><li>We need to override the method dispose in ModelDocumentProvider, otherwise the editor disposes our editingDomain<br>
</li><li>If we use an Association Class, we have to modify the XXXCreatCommand Constructor like this (you have to modify all callers, too): <br>
</li><li>We have to centralize entries to the following extensionpoint in org.unicase.common:<br></li></ul>

<blockquote>

<extension point="org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings">

<i></blockquote></i>

That means we have to copy all entries under "<binding context>" to the corresponding extension point<br> in org.unicase.common and then delete the extension point in the diagram.<br>
<br>
<br>
<pre><code><br>
<br>
public XXXCreateCommand(CreateRelationshipRequest request,EObject source, EObject target) {<br>
		super(request);<br>
		this.source = source;<br>
		this.target = target;<br>
		if (request.getContainmentFeature() == null) {<br>
			setContainmentFeature(DiagramPackage.eINSTANCE<br>
					.getMEDiagram_NewElements());<br>
		}<br>
<br>
		// Find container element for the new link.<br>
		// Climb up by containment hierarchy starting from the source<br>
		// and return the first element that is instance of the container class.<br>
		for (EObject element = source; element != null; element = element<br>
				.eContainer()) {<br>
			if (element instanceof MEDiagram) {<br>
				container = (MEDiagram) element;<br>
				super.setElementToEdit(container);<br>
				break;<br>
			}<br>
		}<br>
	}<br>
<br>
</code></pre>

<ul><li>Forbid save as in Editor:</li></ul>

<pre><code>/**<br>
* @generated NOT<br>
*/<br>
public boolean isSaveAsAllowed() {<br>
return false;<br>
}<br>
<br>
</code></pre>

<ul><li>Dont forget to mark all modified methods as Generated NOT