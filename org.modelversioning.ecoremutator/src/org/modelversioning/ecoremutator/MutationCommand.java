/**
 * <copyright>
 *
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator;

import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.modelversioning.ecoremutator.mutations.Mutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * The command for performing {@link Mutation Mutations}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class MutationCommand extends AbstractOverrideableCommand {

	/**
	 * The mutation to execute.
	 */
	private Mutation mutation;

	/**
	 * The {@link IModelProvider} for invoking the mutation.
	 */
	private IModelProvider modelProvider;

	/**
	 * The {@link IMutationTracker} for tracking the mutation.
	 */
	private IMutationTracker tracker;

	/**
	 * Specifies whether the mutation has been successfully performed.
	 */
	private boolean successful = false;

	/**
	 * Creates a new command for the specified <code>mutation</code> which will
	 * be executed by this command executed in the context of the specified
	 * <code>domain</code> on the model provided by the
	 * <code>modelProvider</code>.
	 * 
	 * @param domain
	 *            within the mutation will be performed.
	 * @param mutation
	 *            the mutation to perform.
	 * @param modelProvider
	 *            the model to perform the mutation on.
	 * @param tracker
	 *            to track the mutation.
	 */
	protected MutationCommand(EditingDomain domain, Mutation mutation,
			IModelProvider modelProvider, IMutationTracker tracker) {
		super(domain);
		this.mutation = mutation;
		this.modelProvider = modelProvider;
		this.tracker = tracker;
	}

	/**
	 * Specifies whether the mutation has been successfully performed yet.
	 * 
	 * @return <code>true</code> if the mutation has been successfully
	 *         performed. <code>false</code> otherwise.
	 */
	protected boolean isSuccessful() {
		return successful;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		successful = mutation.mutate(modelProvider, tracker);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doUndo()
	 */
	@Override
	public void doUndo() {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.command.AbstractOverrideableCommand#doRedo()
	 */
	@Override
	public void doRedo() {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.edit.command.AbstractOverrideableCommand#doCanExecute()
	 */
	@Override
	public boolean doCanExecute() {
		return mutation != null;
	}

}
