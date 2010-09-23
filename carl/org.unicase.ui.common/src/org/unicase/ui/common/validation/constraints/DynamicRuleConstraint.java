/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.validation.constraints;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;

/**
 * The dynamic rules constraint checks {@link EObject}s based on dynamically defined field constraints.
 * 
 * @author pfeifferc
 */
public class DynamicRuleConstraint extends AbstractModelConstraint implements IModelConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext context) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.model.IModelConstraint#getDescriptor()
	 */
	public IConstraintDescriptor getDescriptor() {
		return new IConstraintDescriptorImplementation();
	}

	/**
	 * @author pfeifferc
	 */
	private final class IConstraintDescriptorImplementation implements IConstraintDescriptor {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#targetsTypeOf(org.eclipse.emf.ecore.EObject)
		 */
		public boolean targetsTypeOf(EObject eObject) {
			return true;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#targetsEvent(org.eclipse.emf.common.notify.Notification)
		 */
		public boolean targetsEvent(Notification notification) {
			return true;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#setError(java.lang.Throwable)
		 */
		public void setError(Throwable exception) {
			// TODO Auto-generated method stub
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#setEnabled(boolean)
		 */
		public void setEnabled(boolean enabled) {
			// TODO Auto-generated method stub
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#removeCategory(org.eclipse.emf.validation.model.Category)
		 */
		public void removeCategory(Category category) {
			// TODO Auto-generated method stub
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#isLive()
		 */
		public boolean isLive() {
			return false;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#isError()
		 */
		public boolean isError() {
			return false;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#isEnabled()
		 */
		public boolean isEnabled() {
			return true;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#isBatch()
		 */
		public boolean isBatch() {
			return true;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getStatusCode()
		 */
		public int getStatusCode() {
			return 0;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getSeverity()
		 */
		public ConstraintSeverity getSeverity() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getPluginId()
		 */
		public String getPluginId() {
			return "org.unicase.validation";
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getName()
		 */
		public String getName() {
			return "Dynamic Rules Constraint";
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getMessagePattern()
		 */
		public String getMessagePattern() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getId()
		 */
		public String getId() {
			return "org.unicase.validation.DynamicRulesConstraint";
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getException()
		 */
		public Throwable getException() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getEvaluationMode()
		 */
		public EvaluationMode<?> getEvaluationMode() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getDescription()
		 */
		public String getDescription() {
			return "Dynamic Rules Constraint";
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getCategories()
		 */
		public Set<Category> getCategories() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#getBody()
		 */
		public String getBody() {
			return null;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.validation.service.IConstraintDescriptor#addCategory(org.eclipse.emf.validation.model.Category)
		 */
		public void addCategory(Category category) {
		}
	}
}