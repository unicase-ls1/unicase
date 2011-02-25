package org.unicase.emfstore.jdt.eclipseworkspace.emfstore;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.exception.CannotConvertToEObjectException;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.operationstore.OperationStore;
import org.unicase.emfstore.jdt.operationstore.OperationstoreFactory;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.WorkspaceManager;

public final class StandaloneUtil {

	private StandaloneUtil() {
	}

	public static EObject standaloneEntryToEObject(StructuredEMFStoreURI structuredEMFStoreURI)
		throws CannotConvertToEObjectException {

		TransactionalEditingDomain unicaseEditingDomain = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getEditingDomain();
		Resource modelResource = unicaseEditingDomain.createResource(structuredEMFStoreURI.getRelativeLocation());

		try {
			modelResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = modelResource.getContents();
			EObject eObject = contents.get(0);
			return eObject;

		} catch (IOException e) {
			throw new CannotConvertToEObjectException(e);
		}
	}

	public static IPath handOperationStoreFilePath(IFile originalResourceFile) throws IOException {
		IProject project = originalResourceFile.getProject();

		IFile operationsFile = project.getFile(originalResourceFile.getProjectRelativePath().addFileExtension("off"));
		URI operationStoreURI = getOperationStoreURI(operationsFile.getFullPath(), true);

		// check if file exists
		if (!operationsFile.exists()) {
			OperationStore operationStore = OperationstoreFactory.eINSTANCE.createOperationStore();
			ModelUtil.saveEObjectToResource(operationStore, operationStoreURI);
		}

		return operationsFile.getFullPath();
	}

	public static IPath handMetadataOperationStoreFilePath(IFile originalResourceFile) throws IOException {
		IPath path = org.unicase.emfstore.jdt.Activator.getDefault().getStateLocation();
		IPath metaPath = path.append(originalResourceFile.getFullPath()).addFileExtension("off");
		URI metadataOperationStoreURI = getOperationStoreURI(metaPath, false);

		// check if file exists
		File metadataOperationStoreFile = new File(metadataOperationStoreURI.toFileString());
		if (!metadataOperationStoreFile.exists()) {
			OperationStore operationStore = OperationstoreFactory.eINSTANCE.createOperationStore();
			ModelUtil.saveEObjectToResource(operationStore, metadataOperationStoreURI);
		}

		return metaPath;
	}

	public static URI getOperationStoreURI(IPath operationsPath, boolean makePlatformURI) {
		URI operationStoreURI;
		if (makePlatformURI) {
			operationStoreURI = URI.createPlatformResourceURI(operationsPath.toString(), true);
		} else {
			operationStoreURI = URI.createFileURI(operationsPath.toOSString());
		}

		return operationStoreURI;
	}

	public static boolean isStandaloneEntry(IFile file) {
		try {
			EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager
				.getConfiguration(file.getProject());
			ConfigurationManager.getStandaloneEntry(emfStoreJDTConfiguration, file);
			return true;

		} catch (NoEMFStoreJDTConfigurationException e) {
			return false;
		} catch (EntryNotFoundException e) {
			return false;
		}

	}

}
