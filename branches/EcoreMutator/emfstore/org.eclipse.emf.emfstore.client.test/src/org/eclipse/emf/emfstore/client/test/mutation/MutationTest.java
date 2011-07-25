package org.eclipse.emf.emfstore.client.test.mutation;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.test.SetupHelper;
import org.eclipse.emf.emfstore.client.test.server.ServerTests;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.junit.Assert;
import org.junit.Test;
import org.modelversioning.ecoremutator.EcoreMutator;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.ModelProvider;
import org.modelversioning.ecoremutator.mutations.impl.AddObjectMutation;
import org.modelversioning.ecoremutator.tracker.impl.CSVMutationTracker;

/**
 * @author Matthias
 */
public class MutationTest extends ServerTests {
	/**
	 * Constructor.
	 */
	public MutationTest() {
		super();
		// TODO find the bug!
	}

	private static ProjectSpace projectSpace1;
	private static ProjectSpace projectSpace2;
	private static Usersession usersession1;
	private static Usersession usersession2;
	private static ServerInfo severInfo;
	private EcoreMutator mutator;

	private static final long SEED = 1234567890;

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
	public void mutationTest() throws EmfStoreException {
		severInfo = SetupHelper.getServerInfo();

		setUpUsersession();
		// Prepare 2 projects to compare
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
					projectSpace2 = usersession2.checkout(projectSpace1.getProjectInfo());

				} catch (AccessControlException e) {
					ModelUtil.logException("Unable to login to Server: Access denied!", e);
					throw new RuntimeException(e);
				} catch (EmfStoreException e) {
					throw new RuntimeException(e);
				}
			}
		}.run(false);

		// TestCase 1: Compare 2 Empty projects.
		try {
			Assert.assertTrue("Expected 2 Equal Projects but were not!",
				compareProjects(projectSpace1.getProject(), projectSpace2.getProject()));
		} catch (InterruptedException e) {
			ModelUtil.logException("Unable to compare revisions!", e);
			throw new RuntimeException(e);
		}

		// Mutate a Project and commit
		new EMFStoreCommand() {

			@Override
			protected void doRun() {
				try {

					Resource modelResource = getGeneratedProject().eResource();
					// initialize model provider
					IModelProvider modelProvider = new ModelProvider(SEED);
					modelProvider.setModelResource(modelResource);

					mutate(modelProvider);

					// save output model
					modelResource.save(Collections.emptyMap());
					projectSpace1.commit();
				} catch (AccessControlException e) {
					ModelUtil.logException("Unable to login to Server: Access denied!", e);
					throw new RuntimeException(e);
				} catch (EmfStoreException e) {
					throw new RuntimeException(e);
				} catch (IOException e) {
					ModelUtil.logException("Unable to Save Mutations", e);
					throw new RuntimeException(e);
				}
			}
		}.run(false);

		// TestCase 2: Compare Different states of a project
		try {
			boolean a = compareProjects(projectSpace1.getProject(), projectSpace2.getProject());
			Assert.assertFalse("Mutation didn't chnage anything", a);

		} catch (InterruptedException e) {
			ModelUtil.logException("Unable to compare revisions", e);
			throw new RuntimeException(e);
		}

		// update the other project to mutated state
		new EMFStoreCommand() {

			@Override
			protected void doRun() {
				try {
					// projectSpace2 = usersession2.checkout(projectSpace1.getProjectInfo());
					projectSpace2.update();

				} catch (EmfStoreException e) {
					throw new RuntimeException(e);
				}

			}

		}.run(false);

		// TestCase 3: Compare 2 mutated projects.
		try {
			Assert.assertTrue("Expected 2 Equal Projects but were not!",
				compareProjects(projectSpace1.getProject(), projectSpace2.getProject()));
		} catch (InterruptedException e) {
			ModelUtil.logException("Unable to compare revisions", e);
			throw new RuntimeException(e);
		}

	}

	private void mutate(IModelProvider modelProvider) {
		mutator = new EcoreMutator(SEED);
		// configure mutations to apply
		mutator.addMutation(new AddObjectMutation());

		// configure a change tracker
		CSVMutationTracker tracker = new CSVMutationTracker();
		mutator.setTracker(tracker); // changed by MD
		// mutate model by adding 5 elements
		mutator.mutate(modelProvider, 5);
	}

	private boolean compareProjects(Project p1, Project p2) throws InterruptedException {
		if (p1 == null || p2 == null) {
			return false;
		}

		MatchModel match = MatchService.doContentMatch(p1, p2, null);
		DiffModel diff = DiffService.doDiff(match, false);

		// if there are no differences the projects are equal
		return diff.getDifferences().size() == 0 ? true : false;
	}

	private ResourceSet initializeModel() {
		// Initialize the model
		org.eclipse.emf.emfstore.bowling.BowlingPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map m = reg.getExtensionToFactoryMap();
		m.put("bowlingmodel", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		return resSet;
	}
}
