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
				//FIXME JH: causes following exception:
//				java.lang.IllegalStateException: Cannot modify resource set without a write transaction
//				at org.eclipse.emf.transaction.impl.TransactionChangeRecorder.assertWriting(TransactionChangeRecorder.java:338)
//				at org.eclipse.emf.transaction.impl.TransactionChangeRecorder.appendNotification(TransactionChangeRecorder.java:300)
//				at org.eclipse.emf.transaction.impl.TransactionChangeRecorder.processObjectNotification(TransactionChangeRecorder.java:282)
//				at org.eclipse.emf.transaction.impl.TransactionChangeRecorder.notifyChanged(TransactionChangeRecorder.java:238)
//				at org.eclipse.emf.common.notify.impl.BasicNotifierImpl.eNotify(BasicNotifierImpl.java:247)
//				at org.unicase.model.task.util.MEStateImpl.recursivlyUpdateStatus(MEStateImpl.java:151)
//				at org.unicase.model.task.util.MEStateImpl.access$0(MEStateImpl.java:150)
//				at org.unicase.model.task.util.MEStateImpl$1.notifyChanged(MEStateImpl.java:39)
//				at org.eclipse.emf.common.notify.impl.BasicNotifierImpl.eNotify(BasicNotifierImpl.java:247)
//				at org.eclipse.emf.ecore.impl.BasicEObjectImpl.eContainer(BasicEObjectImpl.java:779)
//				at org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.isControlled(AdapterFactoryEditingDomain.java:924)
//				at org.eclipse.emf.edit.provider.ItemProviderAdapter.overlayImage(ItemProviderAdapter.java:640)
//				at org.unicase.model.bug.provider.BugReportItemProvider.getImage(BugReportItemProvider.java:263)
//				at org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider.getImage(AdapterFactoryLabelProvider.java:330)
//				at org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider.access$3(TransactionalAdapterFactoryLabelProvider.java:1)
//				at org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider$4.run(TransactionalAdapterFactoryLabelProvider.java:125)
//				at org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl.runExclusive(TransactionalEditingDomainImpl.java:289)
//				at org.eclipse.emf.transaction.util.TransactionUtil.runExclusive(TransactionUtil.java:327)
//				at org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider.run(TransactionalAdapterFactoryLabelProvider.java:67)
//				at org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider.getImage(TransactionalAdapterFactoryLabelProvider.java:123)
//				at org.eclipse.jface.viewers.DecoratingLabelProvider.getImage(DecoratingLabelProvider.java:85)
//				at org.eclipse.jface.viewers.DecoratingLabelProvider.updateLabel(DecoratingLabelProvider.java:356)
//				at org.eclipse.jface.viewers.WrappedViewerLabelProvider.update(WrappedViewerLabelProvider.java:183)
//				at org.eclipse.jface.viewers.ViewerColumn.refresh(ViewerColumn.java:145)
//				at org.eclipse.jface.viewers.AbstractTreeViewer.doUpdateItem(AbstractTreeViewer.java:932)
//				at org.eclipse.jface.viewers.AbstractTreeViewer$UpdateItemSafeRunnable.run(AbstractTreeViewer.java:102)
//				at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:37)
//				at org.eclipse.core.runtime.Platform.run(Platform.java:880)
//				at org.eclipse.ui.internal.JFaceUtil$1.run(JFaceUtil.java:48)
//				at org.eclipse.jface.util.SafeRunnable.run(SafeRunnable.java:175)
//				at org.eclipse.jface.viewers.AbstractTreeViewer.doUpdateItem(AbstractTreeViewer.java:1012)
//				at org.eclipse.jface.viewers.StructuredViewer$UpdateItemSafeRunnable.run(StructuredViewer.java:466)
//				at org.eclipse.core.runtime.SafeRunner.run(SafeRunner.java:37)
//				at org.eclipse.core.runtime.Platform.run(Platform.java:880)
//				at org.eclipse.ui.internal.JFaceUtil$1.run(JFaceUtil.java:48)
//				at org.eclipse.jface.util.SafeRunnable.run(SafeRunnable.java:175)
//				at org.eclipse.jface.viewers.StructuredViewer.updateItem(StructuredViewer.java:2041)
//				at org.eclipse.jface.viewers.AbstractTreeViewer.createTreeItem(AbstractTreeViewer.java:827)
//				at org.eclipse.jface.viewers.AbstractTreeViewer$1.run(AbstractTreeViewer.java:802)
//				at org.eclipse.swt.custom.BusyIndicator.showWhile(BusyIndicator.java:70)
//				at org.eclipse.jface.viewers.AbstractTreeViewer.createChildren(AbstractTreeViewer.java:776)
//				at org.eclipse.jface.viewers.TreeViewer.createChildren(TreeViewer.java:634)
//				at org.eclipse.jface.viewers.AbstractTreeViewer.handleTreeExpand(AbstractTreeViewer.java:1442)
//				at org.eclipse.jface.viewers.TreeViewer.handleTreeExpand(TreeViewer.java:927)
//				at org.eclipse.jface.viewers.AbstractTreeViewer$4.treeExpanded(AbstractTreeViewer.java:1453)
//				at org.eclipse.swt.widgets.TypedListener.handleEvent(TypedListener.java:126)
//				at org.eclipse.swt.widgets.EventTable.sendEvent(EventTable.java:84)
//				at org.eclipse.swt.widgets.Widget.sendEvent(Widget.java:1561)
//				at org.eclipse.swt.widgets.Widget.sendEvent(Widget.java:1585)
//				at org.eclipse.swt.widgets.Widget.sendEvent(Widget.java:1570)
//				at org.eclipse.swt.widgets.Tree.itemNotificationProc(Tree.java:2427)
//				at org.eclipse.swt.widgets.Display.itemNotificationProc(Display.java:2396)
//				at org.eclipse.swt.internal.carbon.OS.CallNextEventHandler(Native Method)
//				at org.eclipse.swt.widgets.Widget.kEventControlTrack(Widget.java:1106)
//				at org.eclipse.swt.widgets.Control.kEventControlTrack(Control.java:2097)
//				at org.eclipse.swt.widgets.Widget.controlProc(Widget.java:375)
//				at org.eclipse.swt.widgets.Display.controlProc(Display.java:862)
//				at org.eclipse.swt.internal.carbon.OS.CallNextEventHandler(Native Method)
//				at org.eclipse.swt.widgets.Tree.kEventMouseDown(Tree.java:2599)
//				at org.eclipse.swt.widgets.Widget.mouseProc(Widget.java:1326)
//				at org.eclipse.swt.widgets.Display.mouseProc(Display.java:2925)
//				at org.eclipse.swt.internal.carbon.OS.SendEventToEventTarget(Native Method)
//				at org.eclipse.swt.widgets.Display.readAndDispatch(Display.java:3047)
//				at org.eclipse.ui.internal.Workbench.runEventLoop(Workbench.java:2382)
//				at org.eclipse.ui.internal.Workbench.runUI(Workbench.java:2346)
//				at org.eclipse.ui.internal.Workbench.access$4(Workbench.java:2198)
//				at org.eclipse.ui.internal.Workbench$5.run(Workbench.java:493)
//				at org.eclipse.core.databinding.observable.Realm.runWithDefault(Realm.java:288)
//				at org.eclipse.ui.internal.Workbench.createAndRunWorkbench(Workbench.java:488)
//				at org.eclipse.ui.PlatformUI.createAndRunWorkbench(PlatformUI.java:149)
//				at org.eclipse.ui.internal.ide.application.IDEApplication.start(IDEApplication.java:113)
//				at org.eclipse.equinox.internal.app.EclipseAppHandle.run(EclipseAppHandle.java:193)
//				at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.runApplication(EclipseAppLauncher.java:110)
//				at org.eclipse.core.runtime.internal.adaptor.EclipseAppLauncher.start(EclipseAppLauncher.java:79)
//				at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:382)
//				at org.eclipse.core.runtime.adaptor.EclipseStarter.run(EclipseStarter.java:179)
//				at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//				at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
//				at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
//				at java.lang.reflect.Method.invoke(Method.java:585)
//				at org.eclipse.equinox.launcher.Main.invokeFramework(Main.java:549)
//				at org.eclipse.equinox.launcher.Main.basicRun(Main.java:504)
//				at org.eclipse.equinox.launcher.Main.run(Main.java:1236)
//				at org.eclipse.equinox.launcher.Main.main(Main.java:1212)
//				if (!(msg.getFeatureID(ModelElement.class) == ModelPackage.MODEL_ELEMENT__STATE)) {
//					recursivlyUpdateStatus(getStatus());
//				}
//				super.notifyChanged(msg);
			}

		});
	}

	private void updateEffectiveBlockers() {
		// JH Auto-generated method stub

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
		// JH Auto-generated method stub
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
		// JH Auto-generated method stub
		return false;
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
		modelElement.eNotify(new ENotificationImpl(
				(InternalEObject) modelElement, Notification.SET,
				ModelPackage.MODEL_ELEMENT__STATE, OPEN, OPEN));
		ArrayList<ModelElement> opened = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpened(modelElement);
		// ArrayList<ModelElement> blocked = TaxonomyAccess.getInstance()
		// .getBlockingLinkTaxonomy().getBlocked(modelElement);
		try {
			if (status.equals(OPEN) | status.equals(BLOCKED)) {
				for (ModelElement open : opened) {
					open.getMEState().addOpener(modelElement);
				}
				// for (ModelElement modelElement : blocked) {
				// modelElement.getMEState().addBlocker(modelElement);
				// }
			}
			if (status.equals(CLOSED)) {
				for (ModelElement open : opened) {
					open.getMEState().removeOpener(modelElement);
				}
				// for (ModelElement modelElement : blocked) {
				// modelElement.getMEState().removeBlocker(modelElement);
				// }
			}
		} catch (CircularDependencyException e) {
			e.printStackTrace();
		}

	}
}
