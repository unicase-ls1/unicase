/**
 * <copyright>
 *
 * Copyright (c) 2010 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator.mutations.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.AbstractMutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * Applies a {@link ChangeDescription}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ChangeDescriptionMutation extends AbstractMutation {

	/**
	 * The change description to perform.
	 */
	private ChangeDescription changeDescription;

	/**
	 * Creates a new mutation with the specified <code>changeDescription</code>.
	 * 
	 * @param changeDescription
	 *            to apply.
	 */
	public ChangeDescriptionMutation(ChangeDescription changeDescription) {
		super();
		this.changeDescription = changeDescription;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Applies the currently set change description.
	 */
	@Override
	public boolean mutate(IModelProvider modelProvider, IMutationTracker tracker) {
		boolean success = false;

		if (changeDescription == null) {
			log(IStatus.ERROR, "Change description is null");
			tracker.track(this.getId(), "Change description is null", false,
					toEObjectList(null), toFeatureList(null));
		} else {
			try {
				changeDescription.apply();
				log(IStatus.INFO, "Applied change description "
						+ changeDescription.eResource().getURI());
				// track mutation
				tracker.track(this.getId(), "Applied change description "
						+ changeDescription.eResource().getURI(), true,
						toEObjectList(null), toFeatureList(null));
				success = true;
			} catch (RuntimeException e) {
				log(IStatus.ERROR,
						"Change description caused error: " + e.getMessage());
				tracker.track(this.getId(), "Change description caused error: "
						+ e.getMessage(), false, toEObjectList(null),
						toFeatureList(null));
				success = false;
			}
		}

		return success;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return "mutation.changeDescription";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canHandleEditingDomain() {
		return false;
	}
}
