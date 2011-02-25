/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.emf.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.StandaloneUtil;
import org.unicase.emfstore.jdt.exception.CannotConvertToEObjectException;
import org.unicase.emfstore.jdt.exception.EMFStoreURIMalformedException;
import org.unicase.emfstore.jdt.exception.EObjectNotFoundException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * An adapted resource implementation to loaded the EObjects from an EMF Store.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreResource extends org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl implements Resource,
	Resource.Internal {

	private boolean isLoaded;

	private EList<EObject> contents = new BasicEList<EObject>();

	private ResourceSet resourceSet;

	private List<SaveObserver> saveObserver = new ArrayList<SaveObserver>();

	/**
	 * Constructor.
	 * 
	 * @param uri The URI where the EObject is located.
	 */
	public EMFStoreResource(URI uri) {
		this.uri = uri;
	}

	// @Override
	// public EList<Adapter> eAdapters() {
	// BasicEList<Adapter> adapters = new BasicEList<Adapter>();
	//
	// return adapters;
	// }
	//
	// @Override
	// public boolean eDeliver() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public void eSetDeliver(boolean deliver) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void eNotify(Notification notification) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	@Override
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	//
	// @Override
	// public URI getURI() {
	// return uri;
	// }
	//
	// @Override
	// public void setURI(URI uri) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public long getTimeStamp() {
	// return new Date().getTime();
	// }
	//
	// @Override
	// public void setTimeStamp(long timeStamp) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	@Override
	public EList<EObject> getContents() {
		return contents;
	}

	@Override
	public TreeIterator<EObject> getAllContents() {
		return new AbstractTreeIterator<EObject>(this, false) {
			private static final long serialVersionUID = 1L;

			@Override
			public Iterator<EObject> getChildren(Object object) {
				return object == EMFStoreResource.this ? EMFStoreResource.this.getContents().iterator()
					: ((EObject) object).eContents().iterator();
			}
		};
	}

	//
	// @Override
	// public String getURIFragment(EObject eObject) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public EObject getEObject(String uriFragment) {
	// EObject eObject = super.getEObject(uriFragment);
	//
	// return eObject;
	// }

	@Override
	public void save(Map<?, ?> options) throws IOException {
		contents.get(0).eResource().save(options);

		for (SaveObserver saveObserver : this.saveObserver) {
			saveObserver.saved();
		}
	}

	@Override
	public void load(final Map<?, ?> options) throws IOException {
		if (isLoaded) {
			return;
		}

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					StructuredEMFStoreURI structuredEMFStoreURI = new StructuredEMFStoreURI(uri);
					if (structuredEMFStoreURI.isStandaloneURI()) {
						try {
							EObject eObject = StandaloneUtil.standaloneEntryToEObject(structuredEMFStoreURI);
							getContents().add(eObject);
							isLoaded = true;

						} catch (CannotConvertToEObjectException e) {
							ModelUtil.logException(e);
						}

					} else {
						try {
							EObject eObject = ProjectSpaceUtil.getEObject(uri);
							getContents().add(eObject);
							isLoaded = true;

						} catch (EObjectNotFoundException e) {
							ModelUtil.logException(e);
						} catch (ProjectSpaceNotFoundException e) {
							ModelUtil.logException(e);
						}
					}

				} catch (EMFStoreURIMalformedException e) {
					ModelUtil.logException(e);
				}
			}
		}.run(true);
	}

	//
	// // public void save(OutputStream outputStream, Map<?, ?> options) throws IOException {
	// // // TODO Auto-generated method stub
	// //
	// // }
	// //
	// // public void load(InputStream inputStream, Map<?, ?> options) throws IOException {
	// // // TODO Auto-generated method stub
	// //
	// // }
	//
	// @Override
	// public boolean isTrackingModification() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public void setTrackingModification(boolean isTrackingModification) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public boolean isModified() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public void setModified(boolean isModified) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public boolean isLoaded() {
		return isLoaded;
	}

	//
	// // public void unload() {
	// // // TODO Auto-generated method stub
	// //
	// // }
	//
	// @Override
	// public void delete(Map<?, ?> options) throws IOException {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public EList<Diagnostic> getErrors() {
	// BasicEList<Diagnostic> errors = new BasicEList<Diagnostic>();
	//
	// return errors;
	// }
	//
	// @Override
	// public EList<Diagnostic> getWarnings() {
	// BasicEList<Diagnostic> warnings = new BasicEList<Diagnostic>();
	//
	// return warnings;
	// }
	//
	// @Override
	// public void attached(EObject eObject) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void detached(EObject eObject) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		this.resourceSet = resourceSet;
		// TODO Auto-generated method stub
		return null;
	}

	public void addSaveObserver(SaveObserver saveObserver) {
		this.saveObserver.add(saveObserver);
	}

	// @Override
	// public boolean isLoading() {
	// // TODO Auto-generated method stub
	// return false;
	// }

}
