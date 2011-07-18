package org.eclipse.emf.emfstore.client.test.server;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.client.test.SetupHelper;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.junit.Test;

public class PropertiesTest extends ServerTests {

	private static ProjectSpace projectSpace1;
	private static PropertyManager propertyManager1;
	private static ProjectSpace projectSpace2;
	private static PropertyManager propertyManager2;
	private static Usersession usersession1;
	private static Usersession usersession2;
	private static ServerInfo severInfo;

	private void setUpUsersession() {

		usersession1 = org.eclipse.emf.emfstore.client.model.ModelFactory.eINSTANCE.createUsersession();
		usersession1.setServerInfo(severInfo);
		usersession1.setUsername("writer1");
		usersession1.setPassword("foo");

		usersession2 = org.eclipse.emf.emfstore.client.model.ModelFactory.eINSTANCE.createUsersession();
		usersession2.setServerInfo(severInfo);
		usersession2.setUsername("writer2");
		usersession2.setPassword("foo");

	}

	@Test
	public void sharedPropertiesTest() throws EmfStoreException {
		severInfo = SetupHelper.getServerInfo();

		setUpUsersession();

		new EMFStoreCommand() {

			@Override
			protected void doRun() {
				WorkspaceManager.getInstance().getCurrentWorkspace().getServerInfos().add(severInfo);
				WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(usersession1);
				WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(usersession2);
				WorkspaceManager.getInstance().getCurrentWorkspace().save();

				try {
					usersession1.logIn();
					usersession2.logIn();
					projectSpace1 = usersession1.checkout(getProjectInfo());
					projectSpace2 = usersession2.checkout(getProjectInfo());
				} catch (AccessControlException e) {
					throw new RuntimeException(e);
				} catch (EmfStoreException e) {
					throw new RuntimeException(e);
				}
			}
		}.run(false);

		propertyManager1 = projectSpace1.getPropertyManager();
		propertyManager2 = projectSpace2.getPropertyManager();

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				EMFStoreProperty prop1 = propertyManager1.setSharedStringProperty("FirstPropKey", "test");
				// EMFStoreProperty prop2 = propertyManager1.setSharedStringProperty("SecondPropKey", null);

				try {
					// projectSpace1.commit();
					propertyManager1.transmit();
					projectSpace2.update();
				} catch (EmfStoreException e) {
					throw new RuntimeException(e);
				}

				EObject tt = propertyManager1.getSharedProperty("FirstPropKey");

			}
		}.run(false);

	}
}
