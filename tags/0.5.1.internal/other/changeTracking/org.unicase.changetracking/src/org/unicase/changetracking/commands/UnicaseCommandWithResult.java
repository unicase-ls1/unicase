/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.commands;

import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Recording command that can buffer a result for later retrieval.
 *
 * @author koegel
 * @param <T> result type
 */
public abstract class UnicaseCommandWithResult<T> extends RecordingCommand {

        private T result;

        /**
         * Constructor. The editing domain needs to be initialized by the workspace manager before using this constructor.
         */
        public UnicaseCommandWithResult() {
                super((TransactionalEditingDomain) Configuration.getEditingDomain());
        }

        /**
         * {@inheritDoc}
         *
         * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
         */
        @Override
        protected final void doExecute() {
                this.result = doRun();
        }

        /**
         * The actual action that is being executed.
         *
         * @return the result
         */
        protected abstract T doRun();

        /**
         * Executes the command on the workspaces editing domain.
         *
         * @return the result
         */
        public T run() {
                // this.execute();
                Configuration.getEditingDomain().getCommandStack().execute(this);
                return this.result;
        }

		protected void commandBody() {
			result = doRun();			
		}

		public void aRun(boolean ignoreExceptions) {
			this.run();			
		}

}

