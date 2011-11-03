package org.unicase.ui.urml.stakeholders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.Project;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public final class StakeholderUtil {

	private StakeholderUtil() {
	}

	/**
	 * Gets the test project.
	 * 
	 * @return the test project
	 * @throws NoWorkspaceException .
	 */
	public static Project getActiveProject() {
		return getActiveProjectSpace().getProject();
	}

	/**
	 * Retrieves all URML model elements in a project
	 * 
	 * @param project
	 *            the project.
	 * @return all URML model elements in that project
	 */
	public static Collection<UrmlModelElement> getUrmlElementsfromProjects(
			Project project) {
		Collection<EObject> elementList = project.getAllModelElementsbyClass(
				UrmlPackage.eINSTANCE.getUrmlModelElement(),
				new BasicEList<EObject>());
		List<UrmlModelElement> list = new ArrayList<UrmlModelElement>();
		for (EObject urmlElment : elementList) {
			list.add((UrmlModelElement) urmlElment);
		}
		return list;
	}

	public static ProjectSpace getActiveProjectSpace() {
		return WorkspaceManager.getInstance().getCurrentWorkspace()
				.getProjectSpaces().get(0);
	}

	public static void resolveAll(final Project project) {
		new UnicaseCommand() {

			@Override
			protected void doRun() {

				EList<StakeholderRole> roles = project
						.getAllModelElementsbyClass(
								UrmlPackage.eINSTANCE.getStakeholderRole(),
								new BasicEList<StakeholderRole>());
				for (StakeholderRole r : roles) {
					resolveStakeholderRole(r);
				}
				EList<Phase> phases = project.getAllModelElementsbyClass(
						UrmlPackage.eINSTANCE.getPhase(),
						new BasicEList<Phase>());
				for (Phase p : phases) {
					resolvePhase(p);
				}
			}

		}.run();

	}

	public static void resolveStakeholderRole(StakeholderRole r) {
		resolveEMap(r.getReviewSet(), r);
		resolveEMap(r.getFilterSet(), r);
	}

	public static void resolvePhase(Phase p) {
		resolveEMap(p.getAllowedAssociations(), p);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void resolveEMap(EMap<?, ?> m, EObject context) {
		ListIterator it = m.listIterator();

		while (it.hasNext()) {
			Entry<?, ?> e = (Entry<?, ?>) it.next();
			EObject obj = EcoreUtil.resolve((EObject) e, context);
			EcoreUtil.resolveAll(obj);
			it.set(obj);
		}

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void resolveMultiMap(EMap<?, ?> m, EObject context) {
		ListIterator it = m.listIterator();

		while (it.hasNext()) {
			Entry<?, List<?>> e = (Entry<?, List<?>>) it.next();
			EObject obj = EcoreUtil.resolve((EObject) e, context);
			EcoreUtil.resolveAll(obj);
			it.set(obj);
		}

	}
}
