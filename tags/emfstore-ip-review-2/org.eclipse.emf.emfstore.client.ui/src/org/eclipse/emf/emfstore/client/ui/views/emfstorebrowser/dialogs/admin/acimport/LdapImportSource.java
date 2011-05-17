/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport;

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

import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolFactory;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;

/**
 * @author deser
 */
public class LdapImportSource extends ImportSource {

	private static final String DEFAULT_CTX = "com.sun.jndi.ldap.LdapCtxFactory";

	/**
	 * A constant for setting the LDAP base property.
	 */
	public static final String LDAP_BASE = "ldapbase";

	private DirContext dirContext;
	private String[] attrSet = new String[] { "objectclass", "cn", "uid" };

	// This strings decide whether an ldap-entry is a person, a group or none of
	// both.
	// Maybe we should change the access to public and implement a setter,
	// because in this way
	// one could easily let the user define what has to be considered as a
	// person and what as a group.
	private String personObjectClass = "inetOrgPerson";
	private String groupObjectClass = "posixGroup";

	private Properties properties;

	/**
	 * Simple class for a LDAP-connection to import users and groups.
	 */
	public LdapImportSource() {
	}

	/**
	 * @see org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#init(org.eclipse.swt.widgets.Shell)
	 * @param shell
	 *            the shell
	 * @return whether the initialization was successful or not (e.g. pressing
	 *         cancel on choosing the source)
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
	 * @see org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getLabel()
	 * @return a small label which indicates that this is an import from an LDAP
	 *         server.
	 */
	@Override
	public String getLabel() {
		return "LDAP Import";
	}

	/**
	 * Returns the children of a given object (which is of the type
	 * ImportItemWrapper in this case). One special thing about this method is,
	 * that it does not only return the children objects, but also sets the
	 * correct reference (the children) of the given object. This is important
	 * as otherwise displaying the items on a TreeViewer correctly would fail,
	 * as the getParent()-method wouldn't return the right result.
	 * 
	 * @see org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getChildren(java.lang.Object)
	 * @param arg0
	 *            the object to get the children from.
	 * @return the children, which have the correct references to their parent
	 *         (the given object).
	 */
	@Override
	public Object[] getChildren(Object arg0) {
		// This method-chaining is necessary! Why? Otherwise the reference to
		// the given object (arg0) wouldn't be
		// available when the ContentProvider (ImportSource in our case) calls
		// his getParent()-method.
		return setChildOrgUnits(arg0).getChildOrgUnits().toArray();
	}

	private ImportItemWrapper setChildOrgUnits(Object arg0) {
		try {
			ImportItemWrapper wrappedObject = (ImportItemWrapper) arg0;
			String str = (String) wrappedObject.getSourceObj();
			NamingEnumeration<NameClassPair> list = dirContext.list(str);

			ArrayList<ImportItemWrapper> arrayList = new ArrayList<ImportItemWrapper>();

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

				// Here we set the parent object of every child we add. We
				// couldn't do this in the getChildren-method,
				// because in this case we would lose the wrappedObject - it
				// would vanish, as it is just a parameter!
				arrayList.add(new ImportItemWrapper(nameInNamespace, orgUnit, wrappedObject));
			}

			wrappedObject.setChildOrgUnits(arrayList);
			// As we return the wrapped object, it still exists, when
			// getParent() of ImportSource is called.
			return wrappedObject;
		} catch (NamingException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * @see org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getElements(java.lang.Object)
	 * @param arg0
	 *            object to get the basic elements from.
	 * @return the root elements.
	 */
	@Override
	public Object[] getElements(Object arg0) {
		try {
			NamingEnumeration<NameClassPair> list = dirContext.list(properties.getProperty(LdapImportSource.LDAP_BASE));

			ArrayList<ImportItemWrapper> arrayList = new ArrayList<ImportItemWrapper>();

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

				arrayList.add(new ImportItemWrapper(nameInNamespace, orgUnit));

			}

			return arrayList.toArray();

		} catch (NamingException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
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
	 * @param list
	 *            a NamingEnumeration, that should be converted into an
	 *            ArrayList
	 * @return an ArrayList of the given NamingEnumeration
	 * @throws NamingException
	 *             throws an exception
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
	 * @param serverProperties
	 *            The properties of the LDAP server.
	 */
	public void setProperties(Properties serverProperties) {
		this.properties = serverProperties;
	}

	/**
	 * Initializes the connection to the LDAP server, using the properties
	 * field.
	 * 
	 * @throws CorruptedSourceException
	 *             if no connection could be established to the given server.
	 */
	public void connect() throws CorruptedSourceException {
		properties.put("java.naming.ldap.version", "3");
		properties.put(Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CTX);

		// Create the connection to the LDAP-server
		// (Each time an initial context is created, a new LDAP connection is
		// created)
		try {
			dirContext = new InitialDirContext(properties);
		} catch (NamingException e) {
			WorkspaceUtil.logWarning(e.getMessage(), e);
			throw new CorruptedSourceException("Couldn't connect to server!");
		}

	}

	/**
	 * @return a small description of the LDAP import source (server, base)
	 * @see org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.acimport.ImportSource#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Import from " + properties.getProperty(Context.PROVIDER_URL) + " with base: "
			+ properties.getProperty(LDAP_BASE);
	}

	/**
	 * Disposes any created resources.
	 */
	public void dispose() {
		// Nothing to dispose
	}

	/**
	 * Called when the input changes.
	 * 
	 * @param arg0
	 *            the viewer
	 * @param arg1
	 *            the old input
	 * @param arg2
	 *            the new input
	 */
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// Nothing to change
	}

}
