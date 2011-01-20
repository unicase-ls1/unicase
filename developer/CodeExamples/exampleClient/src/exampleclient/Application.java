package exampleclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import library.Book;
import library.Library;
import library.LibraryFactory;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.observers.ConflictResolver;
import org.unicase.workspace.util.EMFStoreClientUtil;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithParameterAndResult;
import org.unicase.workspace.util.UnicaseCommandWithResult;

public class Application implements IApplication {

	public Object start(IApplicationContext context) throws Exception {

		WorkspaceManager.init();

		// run a client that commits to the first project it can find on the
		// server
		runClient();

		// run a client that creates a project if there is no project on the
		// server
		// and then checks out the project twice. Finally it starts committing and
		// updating the different project copies
		// and produces a merge conflict which is automatically resolved by a
		// conflict resolver.
		//runClient2();

		return IApplication.EXIT_OK;
	}

	private void runClient() throws AccessControlException, EmfStoreException {
		System.out.println("Client starting...");

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					Usersession usersession = EMFStoreClientUtil
							.createUsersession();
					usersession.logIn();
					List<ProjectInfo> projectList;
					projectList = usersession.getRemoteProjectList();
					ProjectInfo projectInfo = projectList.iterator().next();
					ProjectSpace projectSpace = usersession
							.checkout(projectInfo);

					Project project = projectSpace.getProject();
					Book book = LibraryFactory.eINSTANCE.createBook();
					book.setTitle("NEW TITLE");
					project.addModelElement(book);

					projectSpace.commit();
					Library library = LibraryFactory.eINSTANCE.createLibrary();
					project.addModelElement(library);
					library.getBooks().add(book);

					projectSpace.commit();

					System.out.println("Client run completed.");
				} catch (AccessControlException e) {
					ModelUtil.logException(e);
				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
				}
			}
		}.run(false);
	}

	private void runClient2() throws AccessControlException, EmfStoreException {
		System.out.println("Client starting...");
		final Workspace currentWorkspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		final ProjectSpace projectSpace1 = new UnicaseCommandWithResult<ProjectSpace>() {

			@Override
			protected ProjectSpace doRun() {
				try {

					ProjectSpace projectSpace1;
					if (currentWorkspace.getProjectSpaces().size() > 0) {
						// delete existing projectspace
						for (ProjectSpace projectSpace : new ArrayList<ProjectSpace>(
								currentWorkspace.getProjectSpaces())) {
							try {
								currentWorkspace
										.deleteProjectSpace(projectSpace);
							} catch (IOException e) {
								ModelUtil.logException(e);
							}
						}
					}
					
					
					Usersession usersession = EMFStoreClientUtil
							.createUsersession();
					usersession.logIn();
					
					// get a project one from the server
					List<ProjectInfo> projectList = usersession
							.getRemoteProjectList();
					if (projectList.size() == 0) {
						// there are no remote projects, create one
						usersession.createProject("Test ("
								+ new Date().toString() + ")", "Test from "
								+ new Date().toString());
						projectList = usersession.getRemoteProjectList();
					}
					// checkout project from the server
					ProjectInfo projectInfo = projectList.iterator().next();
					projectSpace1 = usersession.checkout(projectInfo);

					return projectSpace1;
				} catch (AccessControlException e) {
					ModelUtil.logException(e);
					throw new IllegalStateException();
				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
					throw new IllegalStateException();
				}
			}
		}.run(false);

		final ProjectSpace projectSpace2 = new UnicaseCommandWithParameterAndResult<ProjectSpace, ProjectSpace>() {
			@Override
			protected ProjectSpace doRun(ProjectSpace projectSpace1) {
				// checkout a second copy of the same project
				ProjectInfo projectInfo = EsmodelFactory.eINSTANCE
						.createProjectInfo();
				projectInfo.setProjectId(ModelUtil.clone(projectSpace1
						.getProjectId()));
				projectInfo.setVersion(ModelUtil.clone(projectSpace1
						.getBaseVersion()));
				ProjectSpace projectSpace2;
				try {
					projectSpace2 = projectSpace1.getUsersession().checkout(
							projectInfo);
				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
					throw new IllegalStateException();
				}
				return projectSpace2;
			}
		}.run(projectSpace1, false);

		final Book book = new UnicaseCommandWithParameterAndResult<Book, ProjectSpace>() {
			@Override
			protected Book doRun(ProjectSpace projectSpace1) {
				Project project = projectSpace1.getProject();
				Book book = LibraryFactory.eINSTANCE.createBook();
				book.setTitle("NEW TITLE");
				Library library = LibraryFactory.eINSTANCE.createLibrary();
				project.addModelElement(library);
				library.getBooks().add(book);
				return book;
			}
		}.run(projectSpace1, false);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					System.out.println("Commit ProjectSpace 1");
					projectSpace1.commit();
					System.out.println("Update ProjectSpace 2");
					projectSpace2.update();
				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
				}
			}
		}.run(false);

		final Book book2 = new UnicaseCommandWithResult<Book>() {
			@Override
			protected Book doRun() {
				//get the same book (same id) from the second ProjectSpace
				Book book2 = (Book) projectSpace2.getProject()
				.getModelElement(projectSpace1.getProject().getModelElementId(book));
				System.out.println("Title of library in ProjectSpace 1: "
						+ book.getTitle());
				System.out.println("Title of library in ProjectSpace 2: "
						+ book2.getTitle());
				book2.setTitle("Other new title");
				System.out.println("Title of library in ProjectSpace 1: "
						+ book.getTitle());
				System.out.println("Title of library in ProjectSpace 2: "
						+ book2.getTitle());
				return book2;
			}
		}.run(false);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					projectSpace2.commit();
					System.out.println("Commit ProjectSpace 2");
					projectSpace1.update();
					System.out.println("Update ProjectSpace 1");
					System.out.println("Title of library in ProjectSpace 1: "
							+ book.getTitle());
					System.out.println("Title of library in ProjectSpace 2: "
							+ book2.getTitle());
				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
				}
			}
		}.run(false);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				book.setTitle("TITLE A");
				book2.setTitle("TITLE B");
				System.out.println("Title of library in ProjectSpace 1: "
						+ book.getTitle());
				System.out.println("Title of library in ProjectSpace 2: "
						+ book2.getTitle());
			}
		}.run(false);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					System.out.println("Commit ProjectSpace 1");
					projectSpace1.commit();
				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
				}
				try {
					System.out.println("Commit ProjectSpace 2");
					projectSpace2.commit();
				} catch (BaseVersionOutdatedException e) {
					// second commit failed because we have a conflict on the
					// title => merge
					try {
						PrimaryVersionSpec headVersion = projectSpace2
								.resolveVersionSpec(VersionSpec.HEAD_VERSION);
						projectSpace2.merge(headVersion,
								new ConflictResolver() {
									private ChangePackage myChangePackage;
									private List<ChangePackage> theirChangePackages;

									public boolean resolveConflicts(
											Project project,
											List<ChangePackage> theirChangePackages,
											ChangePackage myChangePackage,
											PrimaryVersionSpec baseVersion,
											PrimaryVersionSpec targetVersion) {
										this.theirChangePackages = theirChangePackages;
										this.myChangePackage = ModelUtil
												.clone(myChangePackage);
										return true;
									}

									public List<AbstractOperation> getRejectedTheirs() {
										List<AbstractOperation> result = new LinkedList<AbstractOperation>();
										for (ChangePackage changePackage : theirChangePackages) {
											result.addAll(changePackage
													.getOperations());
										}
										return result;
									}

									public List<AbstractOperation> getAcceptedMine() {
										return myChangePackage.getOperations();
									}
								});
						projectSpace2.commit();
						projectSpace1.update();
						System.out
								.println("Title of library in ProjectSpace 1: "
										+ book.getTitle());
						System.out
								.println("Title of library in ProjectSpace 2: "
										+ book2.getTitle());
					} catch (EmfStoreException e1) {
						ModelUtil.logException(e1);
					}

				} catch (EmfStoreException e) {
					ModelUtil.logException(e);
				}

			}
		}.run(false);

		System.out.println("Client run completed.");
	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
