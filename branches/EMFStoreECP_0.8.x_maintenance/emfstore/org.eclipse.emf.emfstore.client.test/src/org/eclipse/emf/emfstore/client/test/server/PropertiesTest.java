package org.eclipse.emf.emfstore.client.test.server;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceImpl;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.client.test.SetupHelper;
import org.eclipse.emf.emfstore.client.test.testmodel.TestmodelFactory;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PropertiesTest extends ServerTests {

	private static ProjectSpace projectSpace1;
	private static PropertyManager propertyManager1;
	private static ProjectSpace projectSpace2;
	private static PropertyManager propertyManager2;
	private static Usersession usersession1;
	private static Usersession usersession2;
	private static ServerInfo severInfo;

	@Before
	public void setUpTests() {
		// SetupHelper.removeServerTestProfile();
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
	}

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
	public void testLocalProperties() throws IOException {
		projectSpace1.getPropertyManager().setLocalProperty("foo", TestmodelFactory.eINSTANCE.createTestElement());

		((ProjectSpaceImpl) projectSpace1).saveProjectSpaceOnly();
		ProjectSpace loadedProjectSpace = ModelUtil.loadEObjectFromResource(ModelPackage.eINSTANCE.getProjectSpace(),
			projectSpace1.eResource().getURI(), false);

		assertNotNull(loadedProjectSpace.getPropertyManager().getLocalProperty("foo"));
	}

	@Test
	public void sharedPropertiesTest() throws EmfStoreException {

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				propertyManager1.setSharedStringProperty("FirstPropKey", "test1");
				propertyManager2.setSharedStringProperty("SecondTest", "test2");

				try {
					// projectSpace1.commit();
					propertyManager1.transmit();
					propertyManager2.transmit();
					propertyManager1.transmit();
				} catch (EmfStoreException e) {
					throw new RuntimeException(e);
				}
			}
		}.run(false);

		// 1. Test, ob transmit funktioniert
		Assert.assertEquals(propertyManager1.getSharedStringProperty("FirstPropKey"),
			propertyManager2.getSharedStringProperty("FirstPropKey"));

		Assert.assertEquals(propertyManager2.getSharedStringProperty("SecondTest"),
			propertyManager1.getSharedStringProperty("SecondTest"));

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				propertyManager1.setSharedStringProperty("SecondTest", "test4");
				propertyManager2.setSharedStringProperty("SecondTest", "test5");

				try {
					propertyManager1.transmit();
					propertyManager2.transmit();
					propertyManager1.transmit();
				} catch (EmfStoreException e) {
					throw new RuntimeException(e);
				}
			}
		}.run(false);

		// 2. Funktioniert update
		Assert.assertEquals("test5", propertyManager1.getSharedStringProperty("SecondTest"));
	}
}
