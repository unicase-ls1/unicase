/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.acimport;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;

/**
 * @author deser
 */
public class LdapOrgUnitImport extends ImportSource {

	private static final String DEFAULT_CTX = "com.sun.jndi.ldap.LdapCtxFactory";

	/**
	 * A constant for setting the LDAP base property.
	 */
	public static final String LDAP_BASE = "ldapbase";

	private DirContext dirContext;
	private String[] attrSet = new String[] { "objectclass", "cn", "uid" };

	// This strings decide whether an ldap-entry is a person, a group or none of both.
	// Maybe we should change the access to public and implement a setter, because in this way
	// one could easily let the user define what has to be considered as a person and what as a group.
	private String personObjectClass = "inetOrgPerson";
	private String groupObjectClass = "posixGroup";

	private Properties properties;

	/**
	 * Simple class for a LDAP-connection to import users and groups.
	 */
	public LdapOrgUnitImport() {
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportSource#init(org.eclipse.swt.widgets.Shell)
	 * @param shell the shell
	 * @return whether the initialization was successful or not (e.g. pressing cancel on choosing the source)
	 */
	@Override
	public boolean init(Shell shell) {
		LdapSourceDialog dialog = new LdapSourceDialog(shell, this);
		dialog.setBlockOnOpen(true);
		dialog.create();
		dialog.open();
		return dialog.getIsInitFinished();
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportSource#getLabel()
	 * @return a small label which indicates that this is an import from an LDAP server.
	 */
	@Override
	public String getLabel() {
		return "LDAP Import";
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportSource#getChildren(java.lang.Object)
	 * @param arg0 the object to get the children from.
	 * @return the children, which have the correct references to their parent (the given object).
	 */
	@Override
	public Object[] getChildren(Object arg0) {
		return setChildOrgUnits(arg0).getChildOrgUnits().toArray();
	}

	private ImportWrapper setChildOrgUnits(Object arg0) {
		try {
			ImportWrapper wrappedObject = (ImportWrapper) arg0;
			String str = (String) wrappedObject.getSourceObj();
			NamingEnumeration<NameClassPair> list = dirContext.list(str);

			ArrayList<ImportWrapper> arrayList = new ArrayList<ImportWrapper>();

			while (list.hasMore()) {

				String nameInNamespace = list.next().getNameInNamespace();

				Attributes attr = new BasicAttributes();
				try {
					attr = this.dirContext.getAttributes(nameInNamespace, attrSet);
				} catch (NamingException exc) {
					// do nothing at all, attributes couldn't be fetched
				}

				ACOrgUnit orgUnit;

				Attribute objectclasses = attr.get("objectclass");

				if (isGroup(objectclasses)) {
					orgUnit = AccesscontrolFactory.eINSTANCE.createACGroup();
					orgUnit.setName((String) attr.get("cn").get());
				} else if (isPerson(objectclasses)) {
					orgUnit = AccesscontrolFactory.eINSTANCE.createACUser();
					// if we can't get "uid", we take "cn" instead.
					String username = attr.get("uid") != null ? (String) attr.get("uid").get() : (String) attr
						.get("cn").get();
					orgUnit.setName(username);
				} else {
					orgUnit = AccesscontrolFactory.eINSTANCE.createACOrgUnit();
					if (attr.get("cn") != null) {
						orgUnit.setName((String) attr.get("cn").get());
					} else {
						orgUnit.setName(nameInNamespace);
					}
				}

				arrayList.add(new ImportWrapper(nameInNamespace, orgUnit, wrappedObject));
			}

			wrappedObject.setChildOrgUnits(arrayList);
			return wrappedObject;
		} catch (NamingException e) {
			e.printStackTrace();
			// DialogHandler.showErrorDialog("");
		}
		return null;
	}

	/**
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportSource#getElements(java.lang.Object)
	 * @param arg0 object to get the basic elements from.
	 * @return the root elements.
	 */
	@Override
	public Object[] getElements(Object arg0) {
		try {
			NamingEnumeration<NameClassPair> list = dirContext
				.list(properties.getProperty(LdapOrgUnitImport.LDAP_BASE));

			ArrayList<ImportWrapper> arrayList = new ArrayList<ImportWrapper>();

			while (list.hasMore()) {

				String nameInNamespace = list.next().getNameInNamespace();
				Attributes attr = this.dirContext.getAttributes(nameInNamespace, attrSet);

				ACOrgUnit orgUnit;

				Attribute objectclasses = attr.get("objectclass");

				if (isGroup(objectclasses)) {
					orgUnit = AccesscontrolFactory.eINSTANCE.createACGroup();
					orgUnit.setName((String) attr.get("cn").get());
				} else if (isPerson(objectclasses)) { // if we got a user
					orgUnit = AccesscontrolFactory.eINSTANCE.createACUser();
					// if we can't get "uid", we take "cn" instead.
					String username = attr.get("uid") != null ? (String) attr.get("uid").get() : (String) attr
						.get("cn").get();
					orgUnit.setName(username);
				} else {
					orgUnit = AccesscontrolFactory.eINSTANCE.createACOrgUnit();
					if (attr.get("cn") != null) {
						orgUnit.setName((String) attr.get("cn").get());
					} else {
						orgUnit.setName(nameInNamespace);
					}
				}

				arrayList.add(new ImportWrapper(nameInNamespace, orgUnit));

			}

			return arrayList.toArray();

		} catch (NamingException e) {
			e.printStackTrace();
			// DialogHandler.showExceptionDialog("");
		}
		return null;
	}

	private boolean isGroup(Attribute objectclasses) throws NamingException {
		if (objectclasses == null) {
			return false;
		}
		for (int i = 0; i < objectclasses.size(); i++) {
			if (((String) objectclasses.get(i)).equals(this.groupObjectClass)) {
				return true;
			}
		}
		return false;
	}

	private boolean isPerson(Attribute objectclasses) throws NamingException {
		if (objectclasses == null) {
			return false;
		}
		for (int i = 0; i < objectclasses.size(); i++) {
			if (((String) objectclasses.get(i)).equals(this.personObjectClass)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param list a NamingEnumeration, that should be converted into an ArrayList
	 * @return an ArrayList of the given NamingEnumeration
	 * @throws NamingException throws an exception
	 */
	public ArrayList<NameClassPair> namingEnumerationToArrayList(NamingEnumeration<NameClassPair> list)
		throws NamingException {
		ArrayList<NameClassPair> arrayList = new ArrayList<NameClassPair>();
		while (list.hasMore()) {
			arrayList.add(list.next());
		}
		return arrayList;
	}

	/**
	 * @param serverProperties The properties of the LDAP server.
	 */
	public void setProperties(Properties serverProperties) {
		this.properties = serverProperties;
	}

	/**
	 * Initializes the connection to the LDAP server, using the properties field.
	 * 
	 * @throws CorruptedSourceException if no connection could be established to the given server.
	 */
	public void connect() throws CorruptedSourceException {
		properties.put("java.naming.ldap.version", "3");
		properties.put(Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CTX);

		// Create the connection to the LDAP-server
		// (Each time an initial context is created, a new LDAP connection is created)
		try {
			dirContext = new InitialDirContext(properties);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new CorruptedSourceException("Couldn't connect to server!");
		}

	}

	/**
	 * @return a small description of the LDAP import source (server, base)
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportSource#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Import from " + properties.getProperty(Context.PROVIDER_URL) + " with base: "
			+ properties.getProperty(LDAP_BASE);
	}

}