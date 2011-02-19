import org.eclipse.emf.ecore.*

for(def i = model.eAllContents(); i.hasNext(); ) {
	def element = i.next();
	if(element instanceof EReference) {
		element.eKeys.clear()
	}
}