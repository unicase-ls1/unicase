/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.svn;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.team.svn.core.connector.SVNChangeStatus;
import org.eclipse.team.svn.core.connector.SVNEntryInfo;
import org.eclipse.team.svn.core.connector.SVNEntryStatus;
import org.eclipse.team.svn.core.operation.CompositeOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.core.operation.IRevisionProvider;
import org.eclipse.team.svn.core.operation.local.AbstractWorkingCopyOperation;
import org.eclipse.team.svn.core.operation.local.CommitOperation;
import org.eclipse.team.svn.core.operation.local.InfoOperation;
import org.eclipse.team.svn.core.operation.local.RefreshResourcesOperation;
import org.eclipse.team.svn.core.operation.local.RemoteStatusOperation;
import org.eclipse.team.svn.core.operation.local.RevertOperation;
import org.eclipse.team.svn.core.operation.local.UpdateOperation;
import org.eclipse.team.svn.ui.dialog.DefaultDialog;
import org.eclipse.team.svn.ui.extension.factory.ICommentDialogPanel;
import org.eclipse.team.svn.ui.extension.factory.ICommitActionFactory;
import org.eclipse.team.svn.ui.extension.factory.ICommitDialog;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.emfstore.jdt.CommitHelper;
import org.unicase.emfstore.jdt.configuration.ConfigurationFactory;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMapping;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry;
import org.unicase.emfstore.jdt.configuration.VersionMapping;
import org.unicase.emfstore.jdt.eclipseworkspace.IFileEntryTuple;
import org.unicase.emfstore.jdt.eclipseworkspace.ResourceCommitHolder;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreCommit;
import org.unicase.emfstore.jdt.exception.CommitCannotCompleteException;
import org.unicase.emfstore.jdt.ui.decorator.EMFStoreJDTEntryDecorator;

/**
 * Implementation of the Subversive commit action factory. With this it is possible to hook into the commit process.
 * 
 * @author Adrian Staudt
 */
public class SVNCommitActionFactory implements ICommitActionFactory {

	private ICommentDialogPanel commentPanel;

	/**
	 * The method provide abilities in extending of the standard Subversive Commit Dialog to more powerful.
	 * 
	 * @param shell Shell instance which will be used to interact with user
	 * @param allFilesToCommit full set of files which will be committed
	 * @param commentPanel the default Subversive Commit Panel implementation
	 * @return default Commit Dialog
	 */
	@SuppressWarnings( { "unchecked" })
	public ICommitDialog getCommitDialog(final Shell shell, Collection allFilesToCommit,
		final ICommentDialogPanel commentPanel) {
		this.commentPanel = commentPanel;

		return new ICommitDialog() {
			public String getMessage() {
				return commentPanel.getMessage();
			}

			public int open() {
				DefaultDialog dialog = new DefaultDialog(shell, commentPanel);
				int openReturnCode = dialog.open();
				return openReturnCode;
			}

		};
	}

	/**
	 * The method allows customizing of the Commit Operation.
	 * 
	 * @param compositeOperation prepared Commit operation
	 * @param revisionProvider committed revision provider
	 * @param dependsOn dependencies which can prevent commit operation execution in case of failure
	 * @param part workbench part which will be used to interact with user
	 */
	public void performAfterCommitTasks(CompositeOperation compositeOperation, IRevisionProvider revisionProvider,
		IActionOperation[] dependsOn, IWorkbenchPart part) {

		String commitMessage = commentPanel.getMessage();
		SVNCommitHelper svnCommitHelper = new SVNCommitHelper();
		SVNTeamSynchronizer svnTeamSynchronizer = new SVNTeamSynchronizer();

		IResource[] resourcesToCommit = svnCommitHelper.getResourcesToCommit(compositeOperation, revisionProvider);
		ResourceCommitHolder resourceCommitHolder = new ResourceCommitHolder(resourcesToCommit);

		Set<IProject> releatedProjects = resourceCommitHolder.getReleatedProjects();
		if (!CommitHelper.isEMFStoreJDTInvolved(releatedProjects)) {
			// this svn commit is independent from the EMFStoreJDT commit
			return;
		}

		// ensure .emfstoreconf will be a part of the committed resources. Even if the file
		// is currently unmodified, a VersionMapping will be created and at least then the .emfstoreconf file
		// will be dirty and a commit is needed.
		CommitOperation commitOperation = getCommitOperation(compositeOperation);
		replaceResources(commitOperation, resourceCommitHolder.getAllFiles());

		Set<IFileEntryTuple> emfStoreManagedFETuples = resourceCommitHolder.getEMFStoreManagedFETuples();

		Set<IFile> emfStoreManagedFiles = new HashSet<IFile>();
		for (IFileEntryTuple emfStoreManagedIFileEntryTuple : emfStoreManagedFETuples) {
			emfStoreManagedFiles.add(emfStoreManagedIFileEntryTuple.getFile());
		}

		Set<IFile> emfStoreManagedButSVNOutdatedFiles = svnCommitHelper.getOutdatedFiles(emfStoreManagedFiles);
		svnCommitHelper.revertSVNFiles(emfStoreManagedButSVNOutdatedFiles);
		svnCommitHelper.updateSVNFiles(emfStoreManagedButSVNOutdatedFiles);

		EMFStoreCommit.updateLocalContent(emfStoreManagedButSVNOutdatedFiles);
		EMFStoreCommit emfStoreCommit = new EMFStoreCommit(resourceCommitHolder, commitMessage);
		boolean overallPreparedCommit = emfStoreCommit.prepareCommit();

		if (overallPreparedCommit) {
			// at this point it is expected that the commit will not fail.
			// well this is in fact not true. intermediate commits can happen.

			// Create VersionMapping
			for (IFileEntryTuple emfStoreManagedFETuple : emfStoreManagedFETuples) {
				try {
					SVNVersionMappingCreator versionMappingCreator = new SVNVersionMappingCreator(
						emfStoreManagedFETuple, svnTeamSynchronizer);
					HistoryVersionMappingEntry hvmEntry = versionMappingCreator.getExpected();

					Entry entry = emfStoreManagedFETuple.getEntry();
					VersionMapping versionMapping = entry.getVersionMapping();
					if (versionMapping == null || !(versionMapping instanceof HistoryVersionMapping)) {
						HistoryVersionMapping historyVersionMapping = ConfigurationFactory.eINSTANCE
							.createHistoryVersionMapping();
						entry.setVersionMapping(historyVersionMapping);
						versionMapping = historyVersionMapping;
					}

					HistoryVersionMapping historyVersionMapping = (HistoryVersionMapping) versionMapping;
					historyVersionMapping.getHvmEntry().add(hvmEntry);
					entry.getConfiguration().save();

				} catch (CommitCannotCompleteException e) {
					ModelUtil.logException(e);

					// cancel svn
					removeAllOperations(compositeOperation);

					// EMFStore do not need to be canceled
					return;
				}
			}

			// remove unpushed entries
			resourceCommitHolder.removeEntriesThatAreMarkedForDeletion();

			// remove committed forced files
			resourceCommitHolder.cleanForcedEMFStoresToCommit();

			// Execute SVN Commit
			IActionOperation run = compositeOperation.run(new NullProgressMonitor());
			// TODO, falls wenn der commit nicht erfolgen konnte
			if (run.getStatus().getSeverity() == IStatus.OK) {
				// remove SNV-Operations, they have already been committed successfully
				removeAllOperations(compositeOperation);

				// Two-Phase-Commit for EMFStore
				emfStoreCommit.finaliceCommit();
			}

			// refresh UI
			EMFStoreJDTEntryDecorator.refreshDecorator();

		} else {
			// EMFStore-Commit was canceled, cancel also SNVCommit
			removeAllOperations(compositeOperation);
		}

	}

	private static CommitOperation getCommitOperation(CompositeOperation compositeOperation) {
		CommitOperation commitOperation = null;

		try {
			// get operations from CompositeOperation class through reflection
			Field declaredFieldOperationList = CompositeOperation.class.getDeclaredField("operations");
			declaredFieldOperationList.setAccessible(true);
			@SuppressWarnings("unchecked")
			List<Object> operationPairList = (List<Object>) declaredFieldOperationList.get(compositeOperation);
			for (Object operationPair : operationPairList) {
				Field operationField = operationPair.getClass().getField("operation");
				IActionOperation operation = (IActionOperation) operationField.get(operationPair);
				if (operation instanceof CommitOperation) {
					commitOperation = (CommitOperation) operation;
				}
			}

		} catch (NoSuchFieldException e) {
			ModelUtil.logException(e);
		} catch (IllegalArgumentException e) {
			ModelUtil.logException(e);
		} catch (IllegalAccessException e) {
			ModelUtil.logException(e);
		}

		return commitOperation;
	}

	private void replaceResources(CommitOperation commitOperation, Set<IFile> allFiles) {
		try {
			// get operations from CompositeOperation class through reflection
			Field declaredFieldResources = AbstractWorkingCopyOperation.class.getDeclaredField("resources");
			declaredFieldResources.setAccessible(true);
			declaredFieldResources.set(commitOperation, allFiles.toArray(new IResource[0]));

		} catch (NoSuchFieldException e) {
			ModelUtil.logException(e);
		} catch (IllegalArgumentException e) {
			ModelUtil.logException(e);
		} catch (IllegalAccessException e) {
			ModelUtil.logException(e);
		}

	}

	private static void removeAllOperations(CompositeOperation compositeOperation) {
		try {
			// get operations from CompositeOperation class through reflection
			Field declaredFieldOperationList = CompositeOperation.class.getDeclaredField("operations");
			declaredFieldOperationList.setAccessible(true);
			@SuppressWarnings("unchecked")
			List<Object> operationPairList = (List<Object>) declaredFieldOperationList.get(compositeOperation);
			List<IActionOperation> operationsToRemove = new ArrayList<IActionOperation>();
			for (Object operationPair : operationPairList) {
				Field operationField = operationPair.getClass().getField("operation");
				IActionOperation operation = (IActionOperation) operationField.get(operationPair);
				operationsToRemove.add(operation);
			}

			// remove now these operations from the CompositeOperation
			Iterator<IActionOperation> operationsToRemoveIterator = operationsToRemove.iterator();
			while (operationsToRemoveIterator.hasNext()) {
				compositeOperation.remove(operationsToRemoveIterator.next());
			}

		} catch (NoSuchFieldException e) {
			ModelUtil.logException(e);
		} catch (IllegalArgumentException e) {
			ModelUtil.logException(e);
		} catch (IllegalAccessException e) {
			ModelUtil.logException(e);
		}
	}

	/**
	 * A commit helper only for Subversive.
	 */
	private static class SVNCommitHelper {
		@SuppressWarnings("unchecked")
		IResource[] getResourcesToCommit(CompositeOperation compositeOperation, IRevisionProvider revisionProvider) {
			try {
				Field declaredFieldOperationList = CompositeOperation.class.getDeclaredField("operations");
				declaredFieldOperationList.setAccessible(true);
				List operationList = (List) declaredFieldOperationList.get(compositeOperation);

				for (Object compositeOperationPair : operationList) {
					Field declaredFieldOperation = compositeOperationPair.getClass().getDeclaredField("operation");
					declaredFieldOperation.setAccessible(true);
					Object operation = declaredFieldOperation.get(compositeOperationPair);

					if (operation instanceof RefreshResourcesOperation) {
						Field declaredFieldResources = AbstractWorkingCopyOperation.class.getDeclaredField("resources");
						declaredFieldResources.setAccessible(true);
						IResource[] resources = (IResource[]) declaredFieldResources.get(operation);
						return resources;
					}
				}

			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return new IResource[0];

		}

		Set<IFile> getOutdatedFiles(Set<IFile> filesToCheck) {
			Set<IFile> outdatedFiles = new HashSet<IFile>();

			// convert to array, SVN operations need this type
			IFile[] filesToCheckArray = filesToCheck.toArray(new IFile[0]);

			// get all remote status information at once - optimizes latency
			RemoteStatusOperation remoteStatusOperation = new RemoteStatusOperation(filesToCheckArray);
			remoteStatusOperation.run(new NullProgressMonitor());
			SVNEntryStatus[] remoteStatuses = remoteStatusOperation.getStatuses();

			// compare now each file with its remote representation
			for (IFile fileToCheck : filesToCheck) {
				// get local revision
				InfoOperation infoOperation = new InfoOperation(fileToCheck);
				infoOperation.run(new NullProgressMonitor());
				SVNEntryInfo info = infoOperation.getInfo();
				if (info == null) {
					// remote info is not available, this means this file is not yet shared on SVN.
					continue;
				}

				// entryURL will be used as identifier to get remote status info equivalent
				String entryURL = info.url;
				long localRevision = info.lastChangedRevision;

				// find from the array remoteStatuses the matching one
				long remoteRevision = -1;
				for (SVNEntryStatus remoteStatus : remoteStatuses) {
					if (remoteStatus instanceof SVNChangeStatus) {
						SVNChangeStatus remoteChangeStatus = (SVNChangeStatus) remoteStatus;
						if (remoteChangeStatus.url != null && remoteChangeStatus.url.equals(entryURL)) {
							remoteRevision = remoteChangeStatus.reposLastCmtRevision;
							break;
						}
					}
				}

				if (remoteRevision > localRevision) {
					outdatedFiles.add(fileToCheck);
				}
			}

			return outdatedFiles;
		}

		void revertSVNFiles(Set<IFile> files) {
			RevertOperation revertOperation = new RevertOperation(files.toArray(new IFile[0]), false);
			revertOperation.run(new NullProgressMonitor());
		}

		void updateSVNFiles(Set<IFile> files) {
			UpdateOperation updateOperation = new UpdateOperation(files.toArray(new IFile[0]), true);
			updateOperation.run(new NullProgressMonitor());
		}
	}

}
