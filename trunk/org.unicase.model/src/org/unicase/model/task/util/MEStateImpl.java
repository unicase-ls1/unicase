package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.BugStatus;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;

public class MEStateImpl implements MEState {

	private ModelElement modelElement;

	private HashSet<ModelElement> modifiedChilds = new HashSet<ModelElement>();

	private HashSet<ModelElement> effectiveOpeners = new HashSet<ModelElement>();

	private HashSet<ModelElement> effectiveBlocker = new HashSet<ModelElement>();

	public MEStateImpl(ModelElement modelElement) {
		this.modelElement = modelElement;
		// Initially fill opener
		updateEffectiveOpeners();
		// Initially fill blocker
		updateEffectiveBlockers();
		modelElement.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if (!(msg.getFeatureID(ModelElement.class) == ModelPackage.MODEL_ELEMENT__STATE)) {
					recursivlyUpdateStatus(getStatus());
				}
				// super.notifyChanged(msg);
			}

		});
	}

	private void updateEffectiveBlockers() {
		Set<ModelElement> blockers = TaxonomyAccess.getInstance()
				.getBlockingLinkTaxonomy().getBlockers(modelElement);

		for (ModelElement blocker : blockers) {
			try {
				if (blocker.getMEState().getStatus().equals(OPEN)
						| blocker.getMEState().getStatus().equals(BLOCKED)) {
					effectiveBlocker.add(blocker);
				}
			} catch (CircularDependencyException e) {
				// JH: handle Exception
			}
		}

	}

	private void updateEffectiveOpeners() {
		Set<ModelElement> openers = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpeners(modelElement);

		for (ModelElement opener : openers) {
			try {
				if (opener.getMEState().getStatus().equals(OPEN)
						| opener.getMEState().getStatus().equals(BLOCKED)) {
					effectiveOpeners.add(opener);
				}
			} catch (CircularDependencyException e) {
				// JH: handle Exception
			}
		}

	}

	public void addBlocker(ModelElement me) {
		if (effectiveBlocker.size() == 1) {
			recursivlyUpdateStatus(getStatus());
		}
	}

	public void addModifiedChild(ModelElement me) {
		// JH Auto-generated method stub

	}

	public void addOpener(ModelElement me) {
		effectiveOpeners.add(me);
		if (effectiveOpeners.size() == 1) {
			recursivlyUpdateStatus(getStatus());
		}
	}

	public String getStatus() {
		// If there is a blocker, every me is blocked
		if (effectiveBlocker.size() > 0) {
			return BLOCKED;
		}
		// If the me is an ActionItem, the isDone Attribute is effective
		if (modelElement instanceof ActionItem) {
			ActionItem actionItem = (ActionItem) modelElement;
			if (!actionItem.isDone()) {
				return OPEN;
			}
		}

		// If the me is an ActionItem, the isDone Attribute is effective
		if (modelElement instanceof BugReport) {
			BugReport bugReport = (BugReport) modelElement;
			if (!bugReport.getStatus().equals(BugStatus.CLOSED)) {
				return OPEN;
			}
		}

		// If the me is a FunctionalRequirement the reviewed attribute is
		// effective.
		if (modelElement instanceof FunctionalRequirement) {
			FunctionalRequirement fr = (FunctionalRequirement) modelElement;
			if (!fr.isReviewed()) {
				return OPEN;
			}
		}
		// For all other Modelelements look if there is an openener
		if (effectiveOpeners.size() > 0) {
			return OPEN;
		}
		// Else the me is closed
		else {
			return CLOSED;
		}
	}

	public boolean isRecursivlyModified() {
		// JH Auto-generated method stub
		return false;
	}

	public boolean removeBlocker(ModelElement me) {
		boolean ret = effectiveBlocker.remove(me);
		if (effectiveBlocker.size() == 0) {
			recursivlyUpdateStatus(getStatus());
		}
		return ret;
	}

	public boolean removeModifiedChild(ModelElement me) {
		// JH Auto-generated method stub
		return false;
	}

	public boolean removeOpener(ModelElement me) {
		boolean ret = effectiveOpeners.remove(me);
		if (effectiveOpeners.size() == 0) {
			recursivlyUpdateStatus(getStatus());
		}
		return ret;
	}

	private void recursivlyUpdateStatus(String status) {
		ENotificationImpl notificationImpl = new ENotificationImpl(
				(InternalEObject) modelElement, Notification.RESOLVE,
				ModelPackage.MODEL_ELEMENT__STATE, OPEN, OPEN);

		modelElement.eNotify(notificationImpl);

		ArrayList<ModelElement> opened = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpened(modelElement);
		ArrayList<ModelElement> blocked = TaxonomyAccess.getInstance()
				.getBlockingLinkTaxonomy().getBlocked(modelElement);
		try {
			if (status.equals(OPEN) | status.equals(BLOCKED)) {
				for (ModelElement open : opened) {
					open.getMEState().addOpener(modelElement);
				}
				for (ModelElement modelElement : blocked) {
					modelElement.getMEState().addBlocker(modelElement);
				}
			}
			if (status.equals(CLOSED)) {
				for (ModelElement open : opened) {
					open.getMEState().removeOpener(modelElement);
				}
				for (ModelElement modelElement : blocked) {
					modelElement.getMEState().removeBlocker(modelElement);
				}
			}
		} catch (CircularDependencyException e) {
			e.printStackTrace();
		}

	}
}
