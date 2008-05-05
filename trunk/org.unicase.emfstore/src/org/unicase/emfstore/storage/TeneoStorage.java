package org.unicase.emfstore.storage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.hibernate.cfg.Environment;

public class TeneoStorage implements ResourceStorage {
	
	private final static String MODEL_PREFIX="org.unicase.model";

	public URI init(Properties properties) {
		// Set the hibernate properties
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.PASS, "pass");
		props.setProperty(Environment.URL, "jdbc:mysql://localhost/"
				+ "model");
		props.setProperty(Environment.DIALECT,
				org.hibernate.dialect.MySQLInnoDBDialect.class.getName());
		String hbStoreName = "modelStore";
		HbDataStore dataStore = HbHelper.INSTANCE
				.createRegisterDataStore(hbStoreName);
		dataStore.setEPackages(getUnicaseModelPackages());
		dataStore.setHibernateProperties(props);
		dataStore.initialize();
		String uriStr = "hibernate://?" + HibernateResource.DS_NAME_PARAM + "="
				+ hbStoreName;
		return URI.createURI(uriStr);
	}
	
	
	private EPackage[] getUnicaseModelPackages() {
		ArrayList<EPackage> packages = new ArrayList<EPackage>();
		
		for (Map.Entry<String, Object> entry: EPackage.Registry.INSTANCE.entrySet()) {
			if (entry.getKey().startsWith(MODEL_PREFIX)) {
				packages.add((EPackage)entry.getValue());
			}
		}
		return packages.toArray(new EPackageImpl[packages.size()]);
	}
}
