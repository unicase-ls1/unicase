/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.navigator;

import java.util.Collection;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.Widget;
import org.unicase.model.ModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;

/**.
 * Drop adaptor for navigator's tree viewer
 * @author Hodaie
 *
 */
public class TreeViewerDropAdapter extends EditingDomainViewerDropAdapter
		implements DropTargetListener {

	/**.
	 * Constructor
	 * @param domain EditingDomain
	 * @param viewer Viewer
	 */
	public TreeViewerDropAdapter(EditingDomain domain, Viewer viewer) {
		super(domain, viewer);
	
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void dragEnter(DropTargetEvent event) {
		// TODO Auto-generated method stub
		super.dragEnter(event);
		
			
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void dragOver(DropTargetEvent event) {
		super.dragOver(event);
		if(event.item.getData() instanceof LeafSection){
			Collection<?> dragSource = getDragSource(event);
//			for(Object obj : dragSource){
//				if(obj instanceof Section){
					//ZH: Test under MAC
//					event.detail= DND.DROP_NONE;
//					break;
//				}
//			}
		}
		if(!(event.item.getData() instanceof Section)){
//			event.detail= DND.DROP_NONE;
		}
	}

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void drop(DropTargetEvent event) {
		Widget item = event.item;
		final Object target = item.getData();
		final Collection<?> dragSource = getDragSource(event);
		if (target instanceof LeafSection) {
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						protected void doExecute() {
							for (Object object : dragSource) {
								if (object instanceof ModelElement) {
									addMEtoLeafSection((ModelElement) object, (LeafSection)target);
								}
							}
						}
					});

		}else if(target instanceof CompositeSection){
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						protected void doExecute() {
							for (Object object : dragSource) {
								if (object instanceof Section) {
									addSectionToCompositeSection((Section) object, (CompositeSection)target);
								}
							}
						}
					});
		}
		
	}

	private void addSectionToCompositeSection(Section section, CompositeSection compositeSection) {
		if(section.equals(compositeSection)){
			return;
		}
		compositeSection.getSubsections().add(section);
		this.viewer.refresh();
		
	}

	private void addMEtoLeafSection(ModelElement me, LeafSection leafSection) {
		if(me instanceof Section){
			return;
		}
		leafSection.getModelElements().add(me);
		this.viewer.refresh();
		
	}
	
		
}
