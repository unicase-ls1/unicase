package org.unicase.analyzer.questionnaire.actions;



import java.io.IOException;
import java.util.Collections;

import org.eclipse.compare.CompareUI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.MatchResourceSet;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.util.ModelUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.ResourceHelper;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private Project project1;
	private Project project2;
	private LeafSection functionalRequirementsSection;
	private LeafSection nonFunctionalRequirementsSection;
	private ResourceSet resourceSet;
	private Resource resource2;
	private Resource resource1;
	
	private static final String DIR = Configuration.getWorkspaceDirectory();
	/**
	 * The constructor.
	 * @throws IOException 
	 */
	public SampleAction() throws IOException {
//		setup();
		String project1FileName = DIR + "/0/projectstate-13.ups";
		String project2FileName = DIR + "/0/projectstate-14.ups";
		
		project1 = ResourceHelper.getElementFromResource(project1FileName, Project.class, 0);
		project2 = ResourceHelper.getElementFromResource(project2FileName, Project.class, 0);
		
		resourceSet = new ResourceSetImpl();
		resource1 = resourceSet.createResource( URI.createFileURI(project1FileName));
		resource1.getContents().add(project1);
		resource1.save(null);
		
		resource2 = resourceSet.createResource( URI.createFileURI(project2FileName));
		resource2.getContents().add(project2);
		resource2.save(null);
		
		
	}

	public void setup() throws IOException {
		resourceSet = new ResourceSetImpl();
		URI fileURI1 = URI.createFileURI(Configuration.getWorkspaceDirectory() + "projectState1.upf");
		resource1 = resourceSet.createResource(fileURI1);
		project1 = ModelFactory.eINSTANCE.createProject();
		resource1.getContents().add(project1);

		CompositeSection rad = DocumentFactory.eINSTANCE.createCompositeSection();
		rad.setName("Requirements Analysis Document");
		rad.setDescription("This is the Requirements Analysis Document");
		project1.addModelElement(rad);
		CompositeSection requirements = DocumentFactory.eINSTANCE.createCompositeSection();
		requirements.setName("Requirements");
		rad.getSubsections().add(requirements);
		functionalRequirementsSection = DocumentFactory.eINSTANCE.createLeafSection();
		functionalRequirementsSection.setName("Functional Requirements");
		requirements.getSubsections().add(functionalRequirementsSection);
		nonFunctionalRequirementsSection = DocumentFactory.eINSTANCE.createLeafSection();
		nonFunctionalRequirementsSection.setName("Non-Functional Requirements");
		requirements.getSubsections().add(nonFunctionalRequirementsSection);
		FunctionalRequirement fr1 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr1.setName("FR1");
		functionalRequirementsSection.getModelElements().add(fr1);
		FunctionalRequirement fr2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr2.setName("FR2");
		functionalRequirementsSection.getModelElements().add(fr2);
		FunctionalRequirement fr3 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr3.setName("FR3");
		functionalRequirementsSection.getModelElements().add(fr3);
		FunctionalRequirement fr4 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		fr4.setName("FR4");
		functionalRequirementsSection.getModelElements().add(fr4);
		NonFunctionalRequirement nfr = RequirementFactory.eINSTANCE.createNonFunctionalRequirement();
		nfr.setName("NFR");
		nonFunctionalRequirementsSection.getModelElements().add(nfr);
		resource1.save(null);

		URI fileURI2 = URI.createFileURI(Configuration.getWorkspaceDirectory() + "projectState2.upf");
		resource2 = resourceSet.createResource(fileURI2);
		project2 = ModelUtil.clone(project1);
		resource2.getContents().add(project2);
		resource2.save(null);
	}
	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
			
		try {
//			functionalRequirementsSection.getModelElements().get(1).setName("oldFR1");
//			functionalRequirementsSection.getModelElements().remove(2);
//			NonFunctionalRequirement nfr2 = RequirementFactory.eINSTANCE.createNonFunctionalRequirement();
//			nfr2.setName("NFR2");
//			nonFunctionalRequirementsSection.getModelElements().add(nfr2);
//			resource1.save(null);
			MatchModel match = MatchService.doMatch(project1, project2, Collections.<String, Object> emptyMap());
			DiffModel diff = DiffService.doDiff(match, false);
			URI fileURI2 = URI.createFileURI(Configuration.getWorkspaceDirectory() + "diffModel.emfdiff");
			Resource diffResource = resourceSet.createResource(fileURI2);
			DiffResourceSet diffSet = DiffFactory.eINSTANCE.createDiffResourceSet();
			diffSet.getDiffModels().add(diff);
			MatchResourceSet matchSet = MatchFactory.eINSTANCE.createMatchResourceSet();
			matchSet.getMatchModels().add(match);
			ComparisonResourceSetSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSetSnapshot();
			snapshot.setDiffResourceSet(diffSet);
			snapshot.setMatchResourceSet(matchSet);
			ModelUtils.save(snapshot, "diffModel.em1fdiff");

			diffResource.getContents().add(snapshot);
			diffResource.save(null);

			final EObject loadedSnapshot = ModelUtils.load(fileURI2, resourceSet);

			if (loadedSnapshot instanceof ComparisonSnapshot) {
				CompareUI.openCompareEditorOnPage(new ModelCompareEditorInput((ComparisonSnapshot) loadedSnapshot),
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
	}
}