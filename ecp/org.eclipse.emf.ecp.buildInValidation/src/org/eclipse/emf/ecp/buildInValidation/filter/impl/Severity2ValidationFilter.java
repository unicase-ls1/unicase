package org.eclipse.emf.ecp.buildInValidation.filter.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecp.buildInValidation.Activator;
import org.eclipse.emf.ecp.buildInValidation.filter.ValidationFilter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

public class Severity2ValidationFilter extends ValidationFilter {

	/**
	 * default constructor.
	 */
	public Severity2ValidationFilter() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "The severity validation filter";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getImageDescriptor("icons/flag_yellow.png").createImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		IStatus constraintStatus = (IStatus) element;
		if (constraintStatus.getSeverity() == 2) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean init() {
		return true;
	}
}
