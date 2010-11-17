/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.multiattribute;

import java.util.ArrayList;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.unicase.ui.common.commands.ECPCommand;

/**
 * Tool for easily editing EMFCP model elements.
 * <p>
 * The necessary anonymous classes (ECPCommand) are provided in order to make manipulation from everywhere else easier.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 * @param <T> The type of the corresponding model element
 */
public class MultiAttributeController<T> implements IChangeListener {

	// essential references
	private MultiAttributeControl parentItem;
	private EDataTypeEList<T> data;
	private ArrayList<T> localData; // for identifying external changes
	private IObservableValue model;

	/**
	 * Constructor.
	 * 
	 * @param parentItem the corresponding MultiAttributeWidget
	 * @param data a reference to the data manipulated by this controller
	 */
	MultiAttributeController(MultiAttributeControl parentItem, EDataTypeEList<T> data) {
		this.parentItem = parentItem;
		this.data = data;
		localData = new ArrayList<T>();
		localData.addAll(this.data);

		// create listener for external changes
		Object feature = parentItem.getItemPropertyDescriptor().getFeature(parentItem.getModelElement());
		EAttribute attribute = (EAttribute) feature;
		model = EMFEditObservables.observeValue(parentItem.getEditingDomain(), parentItem.getModelElement(), attribute);
		model.addChangeListener(this);
	}

	/**
	 * Hidden default constructor.
	 */
	@SuppressWarnings("unused")
	private MultiAttributeController() {
		// nothing
	}

	/**
	 * Checks if a value exists in the model attribute.
	 * 
	 * @param value the value
	 * @return true if it exists, false otherwise
	 */
	public boolean contains(T value) {
		return data.contains(value);
	}

	/**
	 * Adds a value to the model attribute (nothing happens when duplicates are forbidden and the value is already
	 * stored).
	 * 
	 * @param value the value
	 */
	public void add(final T value) {
		/*
		 * wrong result for forbidden duplicates when a duplicated entry is added it will be added here, but not in the
		 * model; this should be no problem as every control should check for duplicates before adding
		 */
		localData.add(value);
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.add(value);
			};
		}.run();
	}

	/**
	 * Removes a value from the model attribute. Causes trouble for duplicated entries.
	 * 
	 * @param value the value
	 * @return true if the value was removed, false otherwise (it didn't exist)
	 */
	@Deprecated
	public boolean remove(final T value) {
		if (!contains(value)) {
			return false;
		}
		localData.remove(value);
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.remove(value);
			};
		}.run();
		return true;
	}

	/**
	 * Removes the element with a certain index from the model attribute.
	 * 
	 * @param index the index of the value to be deleted
	 * @return true if the value was removed, false otherwise (index didn't exist)
	 */
	public boolean removeElementAt(final int index) {
		if (index >= data.size() || index < 0) {
			return false;
		}
		localData.remove(index);
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.remove(index);
			};
		}.run();
		return true;
	}

	/**
	 * Replaces a value of the model attribute with an other one. Causes trouble for duplicated entries.
	 * 
	 * @param oldValue the old value
	 * @param newValue the new value
	 * @return true if the value was replaced, false otherwise (the old value didn't exist)
	 */
	@Deprecated
	public boolean replace(final T oldValue, final T newValue) {
		if (!contains(oldValue)) {
			return false;
		}
		localData.set(data.indexOf(oldValue), newValue);
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.set(data.indexOf(oldValue), newValue);
			};
		}.run();
		return true;
	}

	/**
	 * Replaces the element with a certain index of the model attribute with an other one.
	 * 
	 * @param index the index of the old value
	 * @param newValue the new value
	 * @return true if the value was replaced, false otherwise (index didn't exist)
	 */
	public boolean replaceElementAt(final int index, final T newValue) {
		if (index >= data.size() || index < 0) {
			return false;
		}
		localData.set(index, newValue);
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				data.set(index, newValue);
			};
		}.run();
		return true;
	}

	/**
	 * Swaps the position of two elements within the list. (never tested!)
	 * 
	 * @param index1 the index of the first one
	 * @param index2 the index of the second one
	 * @return true if the elements have been swapped, false otherwise (at least one index didn't exist)
	 */
	@Deprecated
	public boolean swapElementsAt(final int index1, final int index2) {
		if (index1 >= data.size() || index2 >= data.size() || index1 < 0 || index2 < 0) {
			return false;
		}
		T tmp = localData.get(index1);
		localData.set(index1, localData.get(index2));
		localData.set(index2, tmp);
		new ECPCommand(parentItem.getModelElement()) {
			@Override
			protected void doRun() {
				T tmp = data.get(index1);
				data.set(index1, data.get(index2));
				data.set(index2, tmp);
			};
		}.run();
		return true;
	}

	/**
	 * Returns all elements of this attribute as Object array.
	 * 
	 * @return Returns the array.
	 */
	public Object[] getAllStoredElements() {
		return data.toArray();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.IChangeListener#handleChange(org.eclipse.core.databinding.observable.ChangeEvent)
	 */
	public void handleChange(ChangeEvent event) {
		if (event.getSource() == model && !dataEqualsLocalData()) {
			// this should only happen for external changes!
			parentItem.reInitializeWidget();
			localData.clear();
			localData.addAll(data);
		}
	}

	/**
	 * Checks whether localData and data are out of sync.
	 * 
	 * @return true if they are in sync, false otherwise
	 */
	private boolean dataEqualsLocalData() {
		return localData.equals(data);
	}

}
