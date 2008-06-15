package org.unicase.emfstore.connection.rmi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class RMIUtil {

	public static String eObjectToString(EObject object) throws IOException {
		// TODO Uri
		Resource res = (new ResourceSetImpl()).createResource(URI
				.createURI("eineTolleUri"));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		res.getContents().add(object);
		res.save(out, null);
		return out.toString();
	}

	public static EObject stringToEObject(String object)
			throws UnsupportedEncodingException, IOException {
		// TODO Uri
		Resource res = (new ResourceSetImpl()).createResource(URI
				.createURI("eineNochTollereUri"));
		res.load(new ByteArrayInputStream(object.getBytes("UTF-8")), null);
		return res.getContents().get(0);
	}
}
