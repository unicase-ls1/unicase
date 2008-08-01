/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.dnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.widgets.Widget;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;

/**
 * . Drop adaptor for navigator's tree viewer
 * 
 * @author Hodaie
 * 
 */
public class UCDropAdapter extends EditingDomainViewerDropAdapter {

	/**
	 * . Constructor
	 * 
	 * @param domain
	 *            EditingDomain
	 * @param viewer
	 *            Viewer
	 */
	public UCDropAdapter(EditingDomain domain, Viewer viewer) {
		super(domain, viewer);

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void dragEnter(DropTargetEvent event) {
		// TODO Auto-generated method stub
		super.dragEnter(event);

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void dragOver(DropTargetEvent event) {
		super.dragOver(event);
		if (event.item.getData() instanceof LeafSection) {
			Collection<?> dragSource = getDragSource(event);
			// for(Object obj : dragSource){
			// if(obj instanceof Section){
			// ZH: Test under MAC
			// event.detail= DND.DROP_NONE;
			// break;
			// }
			// }
		}
		if (!(event.item.getData() instanceof Section)) {
			// event.detail= DND.DROP_NONE;
		}
	}

	/**
	 * . {@inheritDoc}
	 * 
	 */
	@Override
	public void drop(DropTargetEvent event) {

		// Object obj = event.data;
		// event.data return a TreeSelection containing
		// the MEs which are draged. (DragSource)

		Widget item = event.item;
		final Object target = item.getData();
		final Collection<?> dragSource = getDragSource(event);
		if (target instanceof LeafSection) {

			dropOnLeafSection(dragSource, ((LeafSection) target));

		} else if (target instanceof CompositeSection) {

			dropOnCompositeSection(dragSource, (CompositeSection) target);

		} else { // target is a ME but not a Section

			dropOnME(dragSource, (ModelElement) target);

		}

	}

	private void dropOnME(final Collection<?> dragSource, final ModelElement target) {

		EObject dropee = (EObject) dragSource.toArray()[0];
		EClass dropeeEClass = dropee.eClass();
		for (final EReference ref : target.eClass().getEAllContainments()) {

			if (ref.getEReferenceType().equals(dropeeEClass)) {
				domain.getCommandStack().execute(
						new RecordingCommand((TransactionalEditingDomain) domain) {
							protected void doExecute() {
								if(target.eIsSet(ref) && ref.isMany()){
									
									List<Object> list = new ArrayList<Object>(); 
									list.addAll((Collection<?>)target.eGet(ref));
									for(Iterator<?> i = dragSource.iterator(); i.hasNext();){
										list.add((Object)i.next());
									}
									target.eSet(ref, list);
									
								}else{
									target.eSet(ref, dragSource);
								}
								
							}
						});
			}
		}
		
		
		EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
	
		if(annotation.isSuperTypeOf(dropeeEClass)){
			Annotation[] arr = dragSource.toArray(new Annotation[dragSource.size()]);
			final List<Annotation> newAnnotations = Arrays.asList(arr);
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						protected void doExecute() {
							target.getAnnotations().addAll(newAnnotations);
						}
					});
			
			
		}
		
		
		
		
	}

	
	private void dropOnCompositeSection(final Collection<?> dragSource,
			final CompositeSection compositeSection) {

		domain.getCommandStack().execute(
				new RecordingCommand((TransactionalEditingDomain) domain) {
					protected void doExecute() {
						for (Object object : dragSource) {
							if (object instanceof Section) {
								addSectionToCompositeSection((Section) object,
										compositeSection);
							}
						}
					}
				});

	}

	private void dropOnLeafSection(final Collection<?> dragSource,
			final LeafSection leafSection) {

		domain.getCommandStack().execute(
				new RecordingCommand((TransactionalEditingDomain) domain) {
					protected void doExecute() {
						for (Object object : dragSource) {
							if (object instanceof ModelElement) {
								addMEtoLeafSection((ModelElement) object,
										leafSection);
							}
						}
					}
				});

	}

	private void addSectionToCompositeSection(Section section,
			CompositeSection compositeSection) {
		if (section.equals(compositeSection)) {
			return;
		}
		compositeSection.getSubsections().add(section);
		this.viewer.refresh();

	}

	private void addMEtoLeafSection(ModelElement me, LeafSection leafSection) {
		if (me instanceof Section) {
			return;
		}
		leafSection.getModelElements().add(me);

		// domain.getCommandStack().undo();
		this.viewer.refresh();

	}

}
