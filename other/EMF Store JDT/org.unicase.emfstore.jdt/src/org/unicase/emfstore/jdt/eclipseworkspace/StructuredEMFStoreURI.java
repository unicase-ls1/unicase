/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.eclipseworkspace;

import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.jdt.configuration.EMFStoreLocation;
import org.unicase.emfstore.jdt.configuration.EObjectLocation;
import org.unicase.emfstore.jdt.exception.EMFStoreURIMalformedException;
import org.unicase.workspace.ServerInfo;

/**
 * Parses an URI to an structured URI, so that it is possible to access the several parts directly by invoking a method
 * call.
 * 
 * @author Adrian Staudt
 */
public class StructuredEMFStoreURI {

	private String host;
	private int port;
	private String certificate;
	private String projectID;
	private String eObjectID;

	/**
	 * Constructor.
	 * 
	 * @param uri A general URI.
	 * @throws EMFStoreURIMalformedException Will be thrown if the URI is not an EMF Store URI:
	 */
	public StructuredEMFStoreURI(org.eclipse.emf.common.util.URI uri) throws EMFStoreURIMalformedException {
		String schema = uri.scheme();
		String specificPath = uri.devicePath();

		resolveURI(schema, specificPath);
	}

	/**
	 * Constructor.
	 * 
	 * @param uri A general URI.
	 * @throws EMFStoreURIMalformedException Will be thrown if the URI is not an EMF Store URI:
	 */
	public StructuredEMFStoreURI(java.net.URI uri) throws EMFStoreURIMalformedException {
		String schema = uri.getScheme();
		String specificPath = uri.getSchemeSpecificPart();

		resolveURI(schema, specificPath);
	}

	/**
	 * Constructor. Build a structured EMF Store URI by its individual parts.
	 * 
	 * @param host The host.
	 * @param port The port.
	 * @param certificate The certificate.
	 * @param projectID The project id.
	 * @param eObjectID The EObject id.
	 */
	public StructuredEMFStoreURI(String host, int port, String certificate, String projectID, String eObjectID) {
		this.host = host;
		this.port = port;
		this.certificate = certificate;
		this.projectID = projectID;
		this.eObjectID = eObjectID;
	}

	/**
	 * Constructor. A structured EMF Store URI can be also created from an EObjectLocation.
	 * 
	 * @param eObjectLocation An EObject location. This file is defined within the EMF Store JDT configuration.
	 */
	public StructuredEMFStoreURI(EObjectLocation eObjectLocation) {
		EMFStoreLocation emfStoreLocation = eObjectLocation.getEMFStoreLocation();
		this.host = emfStoreLocation.getHost();
		this.port = emfStoreLocation.getPort();
		this.certificate = emfStoreLocation.getCertificate();
		this.projectID = emfStoreLocation.getProjectID();
		this.eObjectID = eObjectLocation.getEObjectID();
	}

	private void resolveURI(String schema, String specificPath) throws EMFStoreURIMalformedException {
		if (schema.equals("emfstore")) {
			String[] specificParts = specificPath.split("/");
			if (specificParts.length == 6) {
				String location = specificParts[2];
				String[] locationParts = location.split(":");
				host = locationParts[0];
				port = Integer.parseInt(locationParts[1]);
				certificate = specificParts[3];
				projectID = specificParts[4];
				eObjectID = specificParts[5];
			}

		} else {
			throw new EMFStoreURIMalformedException(schema, specificPath);
		}
	}

	/**
	 * Returns an URI that will be used by the EMF classes.
	 * 
	 * @return An EMF URI.
	 */
	public org.eclipse.emf.common.util.URI getEMFURI() {
		org.eclipse.emf.common.util.URI emfURI = org.eclipse.emf.common.util.URI.createURI("emfstore://" + host + ":"
			+ port + "/" + certificate + "/" + projectID + "/" + eObjectID);
		return emfURI;
	}

	/**
	 * Returns the host.
	 * 
	 * @return The host.
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Returns the port.
	 * 
	 * @return The port.
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Returns the certificate.
	 * 
	 * @return The certificate.
	 */
	public String getCertificate() {
		return certificate;
	}

	/**
	 * Returns the project id.
	 * 
	 * @return The project id.
	 */
	public String getProjectID() {
		return projectID;
	}

	/**
	 * Returns the EObject id.
	 * 
	 * @return The EObject id.
	 */
	public String getEObjectID() {
		return eObjectID;
	}

	/**
	 * Returns an ProjectInfo from the structured EMF Store URI.
	 * 
	 * @return An ProjectInfo.
	 */
	public ProjectInfo getProjectInfo() {
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		projectId.setId(this.projectID);

		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setProjectId(projectId);

		return projectInfo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ServerInfo) {
			ServerInfo serverInfo = (ServerInfo) obj;
			boolean eqHost = serverInfo.getUrl().equals(host);
			boolean eqPort = serverInfo.getPort() == port;
			boolean eqCertificate = serverInfo.getCertificateAlias().equals(certificate);

			return eqHost && eqPort && eqCertificate;

		} else if (obj instanceof EObjectLocation) {
			EObjectLocation eObjectLocation = (EObjectLocation) obj;
			EMFStoreLocation emfStoreLocation = eObjectLocation.getEMFStoreLocation();
			boolean eqHost = emfStoreLocation.getHost().equals(host);
			boolean eqPort = emfStoreLocation.getPort() == port;
			boolean eqCertificate = emfStoreLocation.getCertificate().equals(certificate);
			boolean eqProjectID = emfStoreLocation.getProjectID().equals(projectID);
			boolean eqEObjectID = eObjectLocation.getEObjectID().equals(eObjectID);

			return eqHost && eqPort && eqCertificate && eqProjectID && eqEObjectID;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
