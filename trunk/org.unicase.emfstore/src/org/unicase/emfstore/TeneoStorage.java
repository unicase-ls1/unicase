package org.unicase.emfstore;

import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.hibernate.cfg.Environment;
import org.unicase.model.ModelPackage;

public class TeneoStorage implements ResourceStorage {

	public URI getURI() {
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
		dataStore.setEPackages(new EPackage[] { ModelPackage.eINSTANCE });
		dataStore.setHibernateProperties(props);
		dataStore.initialize();
		String uriStr = "hibernate://?" + HibernateResource.DS_NAME_PARAM + "="
				+ hbStoreName;
		return URI.createURI(uriStr);
	}
}
