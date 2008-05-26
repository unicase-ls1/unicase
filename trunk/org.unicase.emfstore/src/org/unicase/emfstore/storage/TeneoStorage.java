package org.unicase.emfstore.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.collections.functors.NOPTransformer;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Descriptor;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.hibernate.cfg.Environment;
import org.unicase.esmodel.EsmodelPackage;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;

public class TeneoStorage implements ResourceStorage {

	private final static String MODEL_PREFIX = "org.unicase.model";

	private final Logger logger = Logger.getLogger(this.getClass());

	public URI init(Properties properties) {
		
		//create hb store
		final String hbStoreName = "modelStore";
		HbDataStore dataStore = HbHelper.INSTANCE
		.createRegisterDataStore(hbStoreName);
		
		// Set the hibernate properties
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.PASS, "pass");
		props.setProperty(Environment.URL, "jdbc:mysql://localhost/" + "model");
		props.setProperty(Environment.DIALECT,
				org.hibernate.dialect.MySQLInnoDBDialect.class.getName());
		
		props.setProperty(PersistenceOptions.INHERITANCE_MAPPING, "JOINED");
		dataStore.setProperties(props);
				
		//set epackages
		dataStore.setEPackages(getUnicaseModelPackages());
		
		dataStore.initialize();
		
		logger.debug("Using hibernate mapping: " + dataStore.getMappingXML());
		
		String uriStr = "hibernate://?" + HibernateResource.DS_NAME_PARAM + "="
				+ hbStoreName;
		return URI.createURI(uriStr);
	}

	private EPackage[] getUnicaseModelPackages() {
		
		List<EPackage> packages = new ArrayList<EPackage>();
		
		//add model and its subpackages
		EPackage modelPackage = ModelPackage.eINSTANCE;
		packages.add(modelPackage);
		packages.addAll(getSubPackages(modelPackage));
		
		//add es model and its subpackages
		EPackage esmodelPackage = EsmodelPackage.eINSTANCE;
		packages.add(esmodelPackage);
		packages.addAll(getSubPackages(esmodelPackage));
		
		//add ecore packages
		EPackage changePackage = ChangePackage.eINSTANCE;
		packages.add(changePackage);
		EPackage ecorePackage = EcorePackage.eINSTANCE;
		packages.add(ecorePackage);
		
		//add gmf packages
		NotationPackage gmfPackage = NotationPackage.eINSTANCE;
		packages.add(gmfPackage);
		
		return packages.toArray(new EPackageImpl[packages.size()]);
	}

	/**
	 * Get all subpackages recursivly
	 * @param package1
	 * @return
	 *
	 * @generated NOT
	 */
	private Set<EPackage> getSubPackages(EPackage package1) {
		Set<EPackage> subPackages = new HashSet<EPackage>();
		for (EPackage subPackage: package1.getESubpackages()) {
			subPackages.add(subPackage);
			subPackages.addAll(getSubPackages(subPackage));
		}
		return subPackages;
	}
}
