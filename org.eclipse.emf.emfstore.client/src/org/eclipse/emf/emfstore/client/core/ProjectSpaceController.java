package org.eclipse.emf.emfstore.client.core;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.exceptions.ChangeConflictException;
import org.eclipse.emf.emfstore.client.exceptions.MEUrlResolutionException;
import org.eclipse.emf.emfstore.client.exceptions.PropertyNotFoundException;
import org.eclipse.emf.emfstore.client.filetransfer.FileDownloadStatus;
import org.eclipse.emf.emfstore.client.filetransfer.FileInformation;
import org.eclipse.emf.emfstore.client.model.OperationComposite;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.observers.CommitObserver;
import org.eclipse.emf.emfstore.client.observers.ConflictResolver;
import org.eclipse.emf.emfstore.client.observers.UpdateObserver;
import org.eclipse.emf.emfstore.client.preferences.PropertyKey;
import org.eclipse.emf.emfstore.client.util.ModifiedModelElementsCache;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.exceptions.BaseVersionOutdatedException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;
import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

public interface ProjectSpaceController {

	PrimaryVersionSpec commit() throws EmfStoreException;

	PrimaryVersionSpec commit(LogMessage logMessage) throws EmfStoreException;

	/**
	 * Commit local changes to the server.
	 * 
	 * @param logMessage
	 *            the log message
	 * @param commitObserver
	 *            an observer that is notified about the changes being send to
	 *            the server
	 * @return the new base version
	 * @throws EmfStoreException
	 *             if the commit fails
	 * @throws BaseVersionOutdatedException
	 *             if the project space is not up to date, that is its base
	 *             version is lower then the projects head revision
	 */
	PrimaryVersionSpec commit(LogMessage logMessage,
			CommitObserver commitObserver) throws EmfStoreException,
			BaseVersionOutdatedException;

	PrimaryVersionSpec update() throws EmfStoreException;

	PrimaryVersionSpec update(VersionSpec version) throws EmfStoreException;

	/**
	 * Update the workspace to the given revision.
	 * 
	 * @param version
	 *            the version to update to
	 * @param observer
	 *            an observer that is notified of the changes performed by the
	 *            update, maybe null
	 * @return the new base version
	 * @throws EmfStoreException
	 *             if the update fails
	 * @throws ChangeConflictException
	 *             if a conflict with local changes is detected
	 */
	PrimaryVersionSpec update(VersionSpec version, UpdateObserver observer)
			throws EmfStoreException, ChangeConflictException;

	/**
	 * Share the project of the project space with a given usersession.
	 * 
	 * @param usersession
	 *            the usersession
	 * @throws EmfStoreException
	 *             if sharing fails
	 */
	void shareProject(Usersession usersession) throws EmfStoreException;

	/**
	 * Export a project to a file with the given name.
	 * 
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             if writing to the given file fails
	 */
	void exportProject(String fileName) throws IOException;

	/**
	 * Export all local changes to a file with the given name.
	 * 
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             if writing to the given file fails
	 */
	void exportLocalChanges(String fileName) throws IOException;

	/**
	 * Import changes from a file.
	 * 
	 * @param fileName
	 *            the file name to import from
	 * @throws IOException
	 *             if file access fails
	 */
	void importLocalChanges(String fileName) throws IOException;

	List<AbstractOperation> getOperations();

	/**
	 * Adds a file to this project space. The file will be uploaded to the
	 * EMFStore upon commiting. As long as the file is not committed yet, it can
	 * be removed by calling .getFileInfo(id).removePendingUpload().
	 * 
	 * @param file
	 *            to be added to the projectspace
	 * @return file identifier the file was assigned. This identifier can be
	 *         used to retrieve the file later
	 * @throws FileTransferException
	 *             if any error occurs
	 */
	FileIdentifier addFile(File file) throws FileTransferException;

	/**
	 * Gets a file with a specific identifier. If the file is not cached
	 * locally, it is tried to download the file if a connection to the sever
	 * exists. If the file cannot be found locally and not on the server (or the
	 * server isn't reachable), a FileTransferException is thrown. Such an
	 * exception is also thrown if other errors occur while trying to download
	 * the file. The method returns not the file itself, because it does not
	 * block in case of downloading the file. Instead, it returns a status
	 * object which can be queried for the status of the download. Once the
	 * download is finished ( status.isFinished() ), the file can be retrieved
	 * from this status object by calling status.getTransferredFile().
	 * 
	 * @param fileIdentifier
	 *            file identifier string.
	 * @return a status object that can be used to retrieve various information
	 *         about the file.
	 * @throws FileTransferException
	 *             if any error occurs retrieving the files
	 */
	FileDownloadStatus getFile(FileIdentifier fileIdentifier)
			throws FileTransferException;

	/**
	 * Gets the file information for a specific file identifier. This file
	 * information can be used to access further details of a file (if it
	 * exists, is cached, is a pending upload). It can also be used to alter the
	 * file in limited ways (like removing a pending upload). The
	 * FileInformation class is basically a facade to keep the interface in the
	 * project space small (only getFileInfo) while still providing a rich
	 * interface for files.
	 * 
	 * @param fileIdentifier
	 *            the file identifier for which to get the information
	 * @return the information for that identifier.
	 */
	FileInformation getFileInfo(FileIdentifier fileIdentifier);

	/**
	 * Adds a tag to the specified version of this project.
	 * 
	 * @param versionSpec
	 *            the versionSpec
	 * @param tag
	 *            the tag
	 * @throws EmfStoreException
	 *             if exception occurs on the server
	 */
	void addTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException;

	/**
	 * Removes a tag to the specified version of this project.
	 * 
	 * @param versionSpec
	 *            the versionSpec
	 * @param tag
	 *            the tag
	 * @throws EmfStoreException
	 *             if exception occurs on the server
	 */
	void removeTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException;

	/**
	 * Preparation phase of the commit. The user has to deal with eventual
	 * conflicts, that the user has to solve. The result is the conflict solved
	 * change package.
	 * 
	 * @param commitObserver
	 *            an observer that is notified about the changes being send to
	 *            the server
	 * @return a conflict solved change package
	 * @throws EmfStoreException
	 *             if the commit fails
	 */
	ChangePackage prepareCommit(CommitObserver commitObserver)
			throws EmfStoreException;

	/**
	 * A change package will be finally send to the server and a new revision
	 * will be created.
	 * 
	 * @param changePackage
	 *            the change package that should be committed
	 * @param logMessage
	 *            a log message that is associated with this commit
	 * @param commitObserver
	 *            an observer that is notified about the changes being send to
	 *            the server
	 * @return the new base version
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 */
	PrimaryVersionSpec finalizeCommit(ChangePackage changePackage,
			LogMessage logMessage, CommitObserver commitObserver)
			throws EmfStoreException;

	/**
	 * @param name
	 *            the name of the property
	 * @return the string value of the property or null if it doesn't exist
	 * @throws PropertyNotFoundException
	 *             if no property exists for this key
	 * @generated NOT
	 */
	OrgUnitProperty getProperty(PropertyKey name)
			throws PropertyNotFoundException;

	/**
	 * @return if the the property is set.
	 * @param key
	 *            the property key.
	 */
	boolean hasProperty(PropertyKey key);

	/**
	 * Sets a new OrgUnitProperty for the current user.
	 * 
	 * @param property
	 *            the new property
	 * @generated NOT
	 */
	void setProperty(OrgUnitProperty property);

	/**
	 * Revert all local changes in the project space. Returns the state of the
	 * project to that of the project space base version.
	 */
	void revert();

	PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec)
			throws EmfStoreException;

	/**
	 * @return a list of the change packages between two PrimarySpecVersions.
	 * @param sourceVersion
	 *            the source version spec
	 * @param targetVersion
	 *            the target version spec
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	List<ChangePackage> getChanges(VersionSpec sourceVersion,
			VersionSpec targetVersion) throws EmfStoreException;

	/**
	 * Resolve the url to a model element.
	 * 
	 * @param modelElementUrlFragment
	 *            the url
	 * @return the model element
	 * @throws MEUrlResolutionException
	 *             if model element does not exist in project.
	 */
	EObject resolve(ModelElementUrlFragment modelElementUrlFragment)
			throws MEUrlResolutionException;

	/**
	 * Merge the changes from current base version to given target version with
	 * the local operations.
	 * 
	 * @param target
	 *            target version
	 * @param conflictResolver
	 *            a conflict resolver that will actually perform the conflict
	 *            resolution
	 * @throws EmfStoreException
	 *             if the conncection to the server fails
	 */
	void merge(PrimaryVersionSpec target, ConflictResolver conflictResolver)
			throws EmfStoreException;

	/**
	 * Gathers all local operations and canonizes them.
	 * 
	 * @param canonized
	 *            true if the operations should be canonized
	 * @return the list of operations
	 */
	ChangePackage getLocalChangePackage(boolean canonized);

	/**
	 * @return modified model elements cache. This is class clients (e.g. dirty
	 *         decorator) can ask to see if a model element has been modified.
	 */
	ModifiedModelElementsCache getModifiedModelElementsCache();

}
