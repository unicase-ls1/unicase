package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.unicase.ui.common.commands.ECPCommand;

/**
 * Tool for easily editing EMFCP model elements.
 * <p>
 * The necessary anonymous classes (ECPCommand) are provided in order to
 * make manipulation from everywhere else easier.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 * @param <T>
 * 			The type of the corresponding model element.
 */
public class MultiAttributeController<T> {

	// essential references
	private MultiAttributeControl parentItem;
	private EDataTypeEList<T> data;
	
	MultiAttributeController(MultiAttributeControl parentItem, EDataTypeEList<T> data) {
		this.parentItem = parentItem;
		this.data = data;
	}
	
	private MultiAttributeController() {
		// hide default constructor
	}

	/**
	 * Checks if a value exists in the model attribute.
	 * 
	 * @param value
	 * 			The value.
	 * @return
	 * 			Returns true if it exists, false otherwise.
	 */
	public boolean contains(T value) {
		return data.contains(value);
	}

	/**
	 * Adds a value to the model attribute (nothing happens when duplicates are forbidden
	 * and the value is already stored).
	 * 
	 * @param value
	 * 			The value.
	 */
	public void add(final T value) {
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
	 * @param value
	 * 			The value.
	 * @return
	 * 			Returns true if the value was removed, false otherwise (it didn't exist).
	 */
	@Deprecated
	public boolean remove(final T value) {
		if (!contains(value)) {
			return false;
		}
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
	 * @param index
	 * 			The index of the value to be deleted.
	 * @return
	 * 			Returns true if the value was removed, false otherwise (index didn't exist).
	 */
	public boolean removeElementAt(final int index) {
		if (index >= data.size() || index < 0) {
			return false;
		}
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
	 * @param oldValue
	 * 			The old value.
	 * @param newValue
	 * 			The new value.
	 * @return
	 * 			Returns true if the value was replaced, false otherwise (the old value didn't exist).
	 */
	@Deprecated
	public boolean replace(final T oldValue, final T newValue) {
		if (!contains(oldValue)) {
			return false;
		}
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
	 * @param index
	 * 			The index of the old value.
	 * @param newValue
	 * 			The new value.
	 * @return
	 * 			Returns true if the value was replaced, false otherwise (index didn't exist).
	 */
	public boolean replaceElementAt(final int index, final T newValue) {
		if (index >= data.size() || index < 0) {
			return false;
		}
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
	 * @param index1
	 * 			The index of the first one.
	 * @param index2
	 * 			The index of the second one.
	 * @return
	 * 			Returns true if the elements have been swapped, false otherwise (at least one index didn't exist).
	 */
	@Deprecated
	public boolean swapElementsAt(final int index1, final int index2) {
		if (index1 >= data.size() || index2 >= data.size() || index1 < 0 || index2 < 0) {
			return false;
		}
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
	 * @return
	 * 			Returns the array.
	 */
	public Object[] getAllStoredElements() {
		return data.toArray();
	}

}
