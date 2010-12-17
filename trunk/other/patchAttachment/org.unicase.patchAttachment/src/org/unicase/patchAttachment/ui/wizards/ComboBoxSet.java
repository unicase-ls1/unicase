package org.unicase.patchAttachment.ui.wizards;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;

/**
 * A combo box set is a wrapper around a graphical SWT Combo element.
 * It provides type-safe retrieval of the selected element and allows
 * to easily track selection changes.
 * 
 * While a combo only allows String values, this set allows arbitrary
 * values. The getLabel method is used to get a displayable name from
 * an contained object.
 * 
 * @author jfinis
 *
 * @param <T> the type of elements in the Combo.
 */
public abstract class ComboBoxSet<T extends EObject> {

	/**
	 * The SWT Combo element wrapped by this class
	 */
	private final Combo combo;
	
	/**
	 * The index map, that associates indices with the objects behind them.
	 */
	private HashMap<Integer,T> map = new HashMap<Integer, T>();
	
	/**
	 * The element that was selected last
	 */
	private T lastSelection;
	
	/**
	 * Selection listener for convenient selection change listening.
	 */
	private SelectionListener listener;
	

	public ComboBoxSet(Combo combo){
		this.combo = combo;
		combo.addSelectionListener(listener = new SelectionListener() {
			
			/**
			 * saves the selection and fires an onSelectionChange event.
			 */
			public void widgetSelected(SelectionEvent e) {
				T newSelection = map.get(ComboBoxSet.this.combo.getSelectionIndex());
				if(newSelection != lastSelection){
					lastSelection = newSelection;
					onSelectionChange(newSelection);
				}
			}
			
			/**
			 * Does nothing.
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}
	
	/**
	 * Rebuilds the combo box.
	 * @param entries entries in the box
	 * @param defaultEntry the default selected entry
	 * @param fireSelectionChangeEvents if a selection change event should be fired
	 */
	public void rebuild(Collection<T> entries, T defaultEntry, boolean fireSelectionChangeEvents){
		String[] labels = new String[entries.size()];
		int selection = 0;
		int i = 0;
		for(T e : entries){
			String label = getLabel(e);
			map.put(i, e);
			labels[i] = label;
			if(e.equals(defaultEntry)){
				selection = i;
			}
			i++;
		}
		
		//If we do not want to fire selection change events, we make sure that the
		//selection does not change by setting it to the new value
		if(!fireSelectionChangeEvents){
			lastSelection = map.get(selection);
		}
		combo.setItems(labels);
		combo.select(selection);
		listener.widgetSelected(null); // fire selection events
	
	}
	
	/**
	 * Returns the currently selected element
	 * @return the current selection
	 */
	public T getSelection(){
		//If the combo element is already disposed we return the last selection
		if(combo.isDisposed()) return lastSelection;
		int index = combo.getSelectionIndex();
		if(index == -1) return null;
		return map.get(index);
	}
	

	/**
	 * Returns the text that should be displayed for a contained element.
	 * @param element the element to display
	 * @return a string to be displayed for the input element
	 */
	protected abstract String getLabel(T element);
	
	/**
	 * Callback method which is called whenever the selection changes.
	 * @param newSelection the new selection.
	 */
	protected abstract void onSelectionChange(T newSelection);

}
