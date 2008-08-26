package org.unicase.ui.meeditor.specialswtwidgets;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.AbstractVetoableValue;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.internal.databinding.provisional.swt.AbstractSWTVetoableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.unicase.ui.meeditor.mecontrols.MEControl;

public class RichTextAreaObserver extends AbstractVetoableValue implements ISWTObservableValue {

	RichTextArea richTextArea;
	
	/**
	 * Flag to track when the model is updating the widget. When
	 * <code>true</code> the handlers for the SWT events should not process
	 * the event as this would cause an infinite loop.
	 */
	private boolean updating = false;	

	/**
	 * Previous value of the Text.
	 */
	private String oldValue;
	
	
	
	private Listener updateListener = new Listener() {
		public void handleEvent(Event event) {
			System.out.println(event.toString() + "\n");
			System.out.println("updating: " + String.valueOf(updating) + "\n newValue: " + richTextArea.getText() + "\n oldValue: " + oldValue);
			if (!updating) {
				String newValue = richTextArea.getText();

				if (!newValue.equals(oldValue)) {
					fireValueChange(Diffs.createValueDiff(oldValue, newValue));					
					oldValue = newValue;
				}
			}
		}
	};	
	
	public RichTextAreaObserver(RichTextArea textControl) {
		this(SWTObservables.getRealm(textControl.getDisplay()), textControl);

		
	}
	
	
	
	public RichTextAreaObserver(Realm realm, RichTextArea textControl) {
		super(realm);

		this.richTextArea = textControl;
		if (richTextArea == null) {
			throw new IllegalArgumentException("The widget parameter is null."); //$NON-NLS-1$
		}
		
		System.out.println("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST");
		
		richTextArea.addListener(SWT.FocusOut, updateListener);
		richTextArea.addListener(SWT.KeyUp, updateListener);
		richTextArea.browser.addListener(SWT.FocusOut, updateListener);
		richTextArea.browser.addListener(SWT.KeyUp, updateListener);
		richTextArea.browser.addListener(SWT.FOCUSED, updateListener);
		richTextArea.browser.addListener(SWT.FocusIn, updateListener);
		
		richTextArea.notifyListeners(SWT.FocusOut, new Event());

		oldValue = richTextArea.getText();
	}



	/**
	 * Sets the bound {@link Text Text's} text to the passed <code>value</code>.
	 * 
	 * @param value
	 *            new value, String expected
	 * @see org.eclipse.core.databinding.observable.value.AbstractVetoableValue#doSetApprovedValue(java.lang.Object)
	 * @throws ClassCastException
	 *             if the value is anything other than a String
	 */
	protected void doSetApprovedValue(final Object value) {
		try {
			updating = true;
			richTextArea.setText(value == null ? "" : value.toString()); //$NON-NLS-1$
			System.out.println("doSetApprovedValue " + value.toString());
			oldValue = richTextArea.getText();
		} finally {
			updating = false;
		}
	}
	
	
	@Override
	protected Object doGetValue() {
		return oldValue = richTextArea.getText();
	}

	public Object getValueType() {
		return String.class;
	}
	



	public Widget getWidget() {
		return richTextArea;
	}


}
