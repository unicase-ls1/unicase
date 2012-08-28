/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * Implementation of MEState.
 * 
 * @author helming
 */
public class MEStateImpl implements MEState {

	private UnicaseModelElement modelElement;

	private HashSet<UnicaseModelElement> effectiveOpeners = new HashSet<UnicaseModelElement>();

	private HashSet<UnicaseModelElement> effectiveBlocker = new HashSet<UnicaseModelElement>();

	private boolean updating;

	/**
	 * default constructor.
	 * 
	 * @param modelElement The modelelement this state is related to.
	 */
	public MEStateImpl(UnicaseModelElement modelElement) {
		this.modelElement = modelElement;
		// Initially fill opener
		updateEffectiveOpeners();
		// Initially fill blocker
		updateEffectiveBlockers();
		modelElement.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if (!msg.isTouch()
					&& !(msg.getFeatureID(UnicaseModelElement.class) == ModelPackage.UNICASE_MODEL_ELEMENT__STATE)) {
					if (msg.getEventType() == Notification.REMOVE) {
						Object oldValue = msg.getOldValue();
						if (effectiveBlocker.contains(oldValue)) {
							updateEffectiveBlockers();
						}
						if (effectiveOpeners.contains(oldValue)) {
							updateEffectiveOpeners();
						}
					}
					recursivlyUpdateStatus(getStatus());
				}
				// super.notifyChanged(msg);
			}

		});
	}

	private void updateEffectiveBlockers() {
		effectiveBlocker.clear();
		Set<UnicaseModelElement> blockers = TaxonomyAccess.getInstance().getBlockingLinkTaxonomy()
			.getBlockers(modelElement);

		for (UnicaseModelElement blocker : blockers) {
			try {
				if (blocker.getMEState().getStatus().equals(OPEN) || blocker.getMEState().getStatus().equals(BLOCKED)) {
					effectiveBlocker.add(blocker);
				}
			} catch (CircularDependencyException e) {
				// JH: log Exception
			}
		}

	}

	private void updateEffectiveOpeners() {
		effectiveOpeners.clear();
		Set<UnicaseModelElement> openers = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getOpeners(modelElement);

		for (UnicaseModelElement opener : openers) {
			try {
				if (opener.getMEState().getStatus().equals(OPEN) || opener.getMEState().getStatus().equals(BLOCKED)) {
					effectiveOpeners.add(opener);
				}
			} catch (CircularDependencyException e) {
				// JH: log Exception
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void addBlocker(UnicaseModelElement me) {
		if (me == modelElement || effectiveBlocker.contains(me)) {
			return;
		}
		effectiveBlocker.add(me);
		if (effectiveBlocker.size() == 1) {
			// This is fake update
			if (modelElement instanceof WorkPackage) {
				EList<WorkItem> containedWorkItems = ((WorkPackage) modelElement).getContainedWorkItems();
				for (WorkItem workItem : containedWorkItems) {
					try {
						workItem.getMEState().removeBlocker(modelElement);
					} catch (CircularDependencyException e) {
						// JH: Auto-generated catch block
					}
				}
			}
			recursivlyUpdateStatus(getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addModifiedChild(UnicaseModelElement me) {
		throw new UnsupportedOperationException();

	}

	/**
	 * {@inheritDoc}
	 */
	public void addOpener(UnicaseModelElement me) {
		if (me == modelElement || effectiveOpeners.contains(me)) {
			return;
		}
		effectiveOpeners.add(me);
		if (effectiveOpeners.size() == 1) {
			recursivlyUpdateStatus(getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getStatus() {
		if (modelElement instanceof WorkItem) {
			WorkPackage containingWorkpackage = ((WorkItem) modelElement).getContainingWorkpackage();
			if (containingWorkpackage != null) {
				if (containingWorkpackage.getState().equals(MEState.BLOCKED)) {
					return BLOCKED;
				}
			}
		}
		// If there is a blocker, every me is blocked
		if (effectiveBlocker.size() > 0) {
			return BLOCKED;
		}
		// For all other Modelelements look if there is an openener
		if (effectiveOpeners.size() > 0) {
			return OPEN;
		}

		if (modelElement instanceof Checkable) {
			if (((Checkable) modelElement).isChecked()) {
				return CLOSED;
			}
			return OPEN;
		}

		// If the me is a FunctionalRequirement the reviewed attribute is
		// effective.
		if (modelElement instanceof FunctionalRequirement) {
			FunctionalRequirement fr = (FunctionalRequirement) modelElement;
			if (!fr.isReviewed()) {
				return OPEN;
			}
		}

		// Else the me is closed

		return CLOSED;

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isRecursivlyModified() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBlocker(UnicaseModelElement me) {
		effectiveBlocker.remove(me);
		if (effectiveBlocker.size() == 0) {
			// This is a fake update
			if (modelElement instanceof WorkPackage) {
				EList<WorkItem> containedWorkItems = ((WorkPackage) modelElement).getContainedWorkItems();
				for (WorkItem workItem : containedWorkItems) {
					try {
						workItem.getMEState().removeBlocker(modelElement);
					} catch (CircularDependencyException e) {
						// JH: Auto-generated catch block
					}
				}
			}
			recursivlyUpdateStatus(getStatus());
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean removeModifiedChild(UnicaseModelElement me) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeOpener(UnicaseModelElement me) {
		if (!effectiveOpeners.remove(me)) {
			return;
		}
		if (effectiveOpeners.size() == 0) {
			recursivlyUpdateStatus(getStatus());
		}
	}

	private void recursivlyUpdateStatus(String status) {
		if (updating) {
			return;
		}
		updating = true;
		ENotificationImpl notificationImpl = new ENotificationImpl((InternalEObject) modelElement,
			Notification.RESOLVE, ModelPackage.UNICASE_MODEL_ELEMENT__STATE, OPEN, OPEN);

		modelElement.eNotify(notificationImpl);

		ArrayList<UnicaseModelElement> opened = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getOpened(modelElement);
		ArrayList<UnicaseModelElement> blocked = TaxonomyAccess.getInstance().getBlockingLinkTaxonomy()
			.getBlocked(modelElement);
		try {
			if (status.equals(OPEN) || status.equals(BLOCKED)) {
				for (UnicaseModelElement open : opened) {
					open.getMEState().addOpener(modelElement);
				}
				for (UnicaseModelElement block : blocked) {
					block.getMEState().addBlocker(modelElement);
				}
			}
			if (status.equals(CLOSED)) {
				for (UnicaseModelElement open : opened) {
					open.getMEState().removeOpener(modelElement);
				}
				for (UnicaseModelElement block : blocked) {
					block.getMEState().removeBlocker(modelElement);
				}
			}
		} catch (CircularDependencyException e) {
			// JH: insert proper exception handlin
			e.printStackTrace();
		} finally {
			updating = false;
		}

	}
}
