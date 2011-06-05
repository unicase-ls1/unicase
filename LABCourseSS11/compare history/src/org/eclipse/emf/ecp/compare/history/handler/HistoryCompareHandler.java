package org.eclipse.emf.ecp.compare.history.handler;

import java.util.Calendar;

import org.eclipse.compare.CompareUI;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchResourceSet;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfstore.bowling.BowlingFactory;
import org.eclipse.emf.emfstore.bowling.League;
import org.eclipse.emf.emfstore.bowling.Player;
import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;

public class HistoryCompareHandler extends AbstractHandler{

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		final ProjectSpace projectSpace1 = ModelPackage.eINSTANCE.getModelFactory().createProjectSpace();
		projectSpace1.setProject(org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE.createProject());
		final ProjectSpace projectSpace2 = ModelPackage.eINSTANCE.getModelFactory().createProjectSpace(); 
		projectSpace2.setProject(org.eclipse.emf.emfstore.common.model.ModelFactory.eINSTANCE.createProject());
		final League league1 = BowlingFactory.eINSTANCE.createLeague();
		projectSpace1.getProject().addModelElement(league1);
		final League league2 = BowlingFactory.eINSTANCE.createLeague();
		projectSpace2.getProject().addModelElement(league2);
		EMFStoreCommand command1 = new EMFStoreCommand() {
			@Override
			protected void doRun() {
				league1.setName("test");
				Player player1 = BowlingFactory.eINSTANCE.createPlayer();
				player1.setName("testName2");
				league1.getPlayers().add(player1);
			}
		};
		
		EMFStoreCommand command2 = new EMFStoreCommand() {
			@Override
			protected void doRun() {
				league2.setName("test");
				Player player1 = BowlingFactory.eINSTANCE.createPlayer();
				player1.setName("testName");
				league2.getPlayers().add(player1);
			}
		};
		
		command1.run();
		command2.run();
		
		ResourceSet set1 = new ResourceSetImpl();
		Resource res1 = set1.createResource(URI.createURI("test"));
		res1.getContents().add(league1);
		
		ResourceSet set2 = new ResourceSetImpl();
		Resource res2 = set2.createResource(URI.createURI("test"));
		res2.getContents().add(league2);
		
		try {
//			MatchModel match = MatchService.doContentMatch(league1, league2, Collections
//			        .<String, Object> emptyMap());
//			DiffModel diff = DiffService.getBestDiffEngine(match).doDiff(match);
			MatchResourceSet match = MatchService.doResourceSetMatch(set1, set2, null);
			DiffResourceSet diff = DiffService.doDiff(match, false);
            ComparisonResourceSetSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSetSnapshot();
            snapshot.setDate(Calendar.getInstance().getTime());
            snapshot.setMatchResourceSet(match);
            snapshot.setDiffResourceSet(diff);

            CompareUI.openCompareEditor(new ModelCompareEditorInput(snapshot), true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}