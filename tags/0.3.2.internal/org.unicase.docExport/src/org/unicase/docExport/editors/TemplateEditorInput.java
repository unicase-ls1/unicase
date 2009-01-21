package org.unicase.docExport.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.unicase.docExport.exportModel.Template;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class TemplateEditorInput implements IEditorInput {

	private Template template;
	
	/**
	 * Default constructor.
	 * @param template the template
	 */
	public TemplateEditorInput(Template template) {
		super();
		this.setTemplate(template);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return getTemplate().getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getToolTipText() {
		return template.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @param template the template to set
	 */
	public void setTemplate(Template template) {
		this.template = template;
	}


	/**
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}	
	
	
	/**
	 * Custom equals() for this class.
	 * @param obj the compared object.
	 * @return the boolean state.
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TemplateEditorInput) {
			TemplateEditorInput other = (TemplateEditorInput) obj;
			boolean ret = template.equals(other.getTemplate());
			return ret;
		}
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return template.hashCode();
	}
}
