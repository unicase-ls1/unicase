package org.unicase.emfstore.storage;

import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

public interface ResourceStorage {

	URI init(Properties properties) throws FatalEmfStoreException;

}
