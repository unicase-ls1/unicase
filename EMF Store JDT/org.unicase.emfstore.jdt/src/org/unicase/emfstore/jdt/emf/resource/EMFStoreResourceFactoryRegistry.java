/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.emf.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.StandaloneUtil;
import org.unicase.emfstore.jdt.exception.EMFStoreURIMalformedException;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.operationstore.OperationStore;
import org.unicase.emfstore.jdt.operationstore.OperationstorePackage;
import org.unicase.metamodel.util.ModelUtil;

/**
 * This ResourceFactroy wrapper is used to loaded another resource than the default one. Ecore files have often links to
 * other Ecore files, this liks begin with platform://... so the default ResourceFactory wants to load the Ecore file
 * from the workspace. But if this file is an EMF Store managed file, the content from the EMF Store should be loaded.
 * To handle this issue is this class responsible.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreResourceFactoryRegistry implements Resource.Factory, Resource.Factory.Registry {

	/**
	 * The initial resource factory is kept if a file is not EMF Store managed, so the initial resource factory has to
	 * handle the file.
	 */
	private static Map<String, Object> initialResourceFactory = new HashMap<String, Object>();

	/**
	 * The Resource.Factory.Registry will be manipulated, so that the EMFStoreResourceFactoryWrapper will be responsible
	 * for Ecore files.
	 */
	public static void replaceSupportedFactories() {
		// {
		// Map<String, Object> protocolToFactoryMap = Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap();
		// for (String key : protocolToFactoryMap.keySet()) {
		// Object value = protocolToFactoryMap.get(key);
		//
		// System.out.println(key + "  " + value);
		// }
		// }
		//
		// System.out.println("------------------------------------------");
		//
		// {
		// Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		// for (String key : extensionToFactoryMap.keySet()) {
		// Object value = extensionToFactoryMap.get(key);
		//
		// System.out.println(key + "  " + value);
		// }
		// }
		//
		// System.out.println("------------------------------------------");
		//
		// {
		// Map<String, Object> contentTypeToFactoryMap = Resource.Factory.Registry.INSTANCE
		// .getContentTypeToFactoryMap();
		// for (String key : contentTypeToFactoryMap.keySet()) {
		// Object value = contentTypeToFactoryMap.get(key);
		//
		// System.out.println(key + "  " + value);
		// }
		// }

		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		Object ecoreFactory = extensionToFactoryMap.get("ecore");
		for (String key : extensionToFactoryMap.keySet()) {
			Object currentFactory = extensionToFactoryMap.get(key);
			if (ecoreFactory == currentFactory) {
				// remember initial ResourceFactory
				initialResourceFactory.put(key, currentFactory);

				// replace factory in registry with an EMF Store adapted one.
				extensionToFactoryMap.put(key, new EMFStoreResourceFactoryRegistry());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory#createResource(org.eclipse.emf.common.util.URI)
	 */
	public Resource createResource(URI uri) {
		if (uri != null && uri.scheme() != null && uri.scheme().equals("emfstore")) {
			return createEMFStoreResource(uri);
		}

		if (uri.isPlatformResource()) {
			IWorkspaceRoot iWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = iWorkspaceRoot.getFile(new Path(uri.toPlatformString(true)));

			// check if file is managed by an EMFStore
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file
					.getProject());
				Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
				StructuredEMFStoreURI structuredEMFStoreURI = new StructuredEMFStoreURI(entry.getEObjectLocation());
				URI emfuri = structuredEMFStoreURI.getEMFURI();
				return createEMFStoreResource(emfuri);

			} catch (NoEMFStoreJDTConfigurationException e) {
				// can be ignored
			} catch (EntryNotFoundException e) {
				// can be ignored too
			}
		}

		// file was not a EMFStore Resource - use initial resource factory
		Object object = initialResourceFactory.get("ecore");
		Factory factory = null;
		if (object instanceof Resource.Factory.Registry) {
			Resource.Factory.Registry registry = (Resource.Factory.Registry) object;
			factory = registry.getFactory(uri);

		} else if (object instanceof Resource.Factory.Descriptor) {
			Resource.Factory.Descriptor descriptor = (Resource.Factory.Descriptor) object;
			factory = descriptor.createFactory();
		}

		return factory.createResource(uri);
	}

	/**
	 * Create an EMFStoreResource and adds all necessary objects to track changes on that resource.
	 * 
	 * @param uri
	 * @return
	 */
	/**
	 * @param uri
	 * @return
	 */
	/**
	 * @param uri
	 * @return
	 */
	private EMFStoreResource createEMFStoreResource(URI uri) {
		EMFStoreResource emfStoreResource = new EMFStoreResource(uri);

		// add an OperationConsumer is this is an EMFStore stand-alone URI.
		try {
			StructuredEMFStoreURI structuredEMFStoreURI = new StructuredEMFStoreURI(uri);
			if (structuredEMFStoreURI.isStandaloneURI()) {
				EClass operationStoreEClass = OperationstorePackage.eINSTANCE.getOperationStore();
				IFile originalResourceFile = structuredEMFStoreURI.getRelativeLocationAsFile();

				IPath operationStorePath = StandaloneUtil.handOperationStoreFilePath(originalResourceFile);
				URI operationStoreURI = StandaloneUtil.getOperationStoreURI(operationStorePath, true);
				OperationStore operationStore = ModelUtil.loadEObjectFromResource(operationStoreEClass,
					operationStoreURI, false);

				IPath metadataOperationStorePath = StandaloneUtil
					.handMetadataOperationStoreFilePath(originalResourceFile);
				URI metadataOperationStoreURI = StandaloneUtil.getOperationStoreURI(metadataOperationStorePath, false);
				OperationStore metadataOperationStore = ModelUtil.loadEObjectFromResource(operationStoreEClass,
					metadataOperationStoreURI, false);

				emfStoreResource.load(null);
				EList<EObject> contents = emfStoreResource.getContents();
				for (EObject content : contents) {
					JDTIdProvider idProvider = new JDTIdProvider(content);

					JDTEObjectTracker jdtEObjectTracker = new JDTEObjectTracker(idProvider, content);
					jdtEObjectTracker.startChangeRecording();

					JDTOperationConsumer jdtWorkspaceOperationConsumer = new JDTOperationConsumer(operationStore);
					jdtEObjectTracker.addOperationConsumer(jdtWorkspaceOperationConsumer);
					emfStoreResource.addSaveObserver(jdtWorkspaceOperationConsumer);

					JDTOperationConsumer jdtMetadataOperationConsumer = new JDTOperationConsumer(metadataOperationStore);
					jdtEObjectTracker.addOperationConsumer(jdtMetadataOperationConsumer);
					emfStoreResource.addSaveObserver(jdtMetadataOperationConsumer);
				}
			}

		} catch (EMFStoreURIMalformedException e) {
			ModelUtil.logException(e);
		} catch (IOException e) {
			ModelUtil.logException(e);
			// } catch (CoreException e) {
			// ModelUtil.logException(e);
		}

		return emfStoreResource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getFactory(org.eclipse.emf.common.util.URI)
	 */
	public Factory getFactory(URI uri) {
		return this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getFactory(org.eclipse.emf.common.util.URI,
	 *      java.lang.String)
	 */
	public Factory getFactory(URI uri, String contentType) {
		return this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getProtocolToFactoryMap()
	 */
	public Map<String, Object> getProtocolToFactoryMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getExtensionToFactoryMap()
	 */
	public Map<String, Object> getExtensionToFactoryMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getContentTypeToFactoryMap()
	 */
	public Map<String, Object> getContentTypeToFactoryMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
