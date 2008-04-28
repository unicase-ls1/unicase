package org.unicase.emfstore;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.hibernate.cfg.Environment;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;

public class EmfStore {
	
	public EmfStore() {
		URI teneoUri = initTeneo();
		
		 ResourceSet resourceSet = new ResourceSetImpl();
		 final Resource res = resourceSet.createResource(teneoUri);
		 
		 Project project = ModelPackage.eINSTANCE.getModelFactory().createProject();
		 project.setName("neuer test");
		 res.getContents().add(project);
		 
		 try {
			res.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private URI initTeneo() {
		//Set the hibernate properties
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.PASS, "pass");
		props.setProperty(Environment.URL, "jdbc:mysql://macbruegge46/"
				+ "model");
		props.setProperty(Environment.DIALECT,
				org.hibernate.dialect.MySQLInnoDBDialect.class.getName());
		String hbStoreName="modelStore";
		HbDataStore dataStore = HbHelper.INSTANCE.createRegisterDataStore(hbStoreName);
		dataStore.setEPackages(new EPackage[] { ModelPackage.eINSTANCE});
		dataStore.setHibernateProperties(props);
		dataStore.initialize();
		String uriStr = "hibernate://?" + HibernateResource.DS_NAME_PARAM +"="+ hbStoreName;
		return URI.createURI(uriStr);
	}

}
