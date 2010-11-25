package org.unicase.ui.meeditor.mecontrols.rework;
 
import java.util.Date;
 
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
 
/**
 * An implementation of the DataBindings IObservableValue interface for the Nebula
 * CDateTime control.
 * 
 * originally: package org.eclipse.nebula.jface.cdatetime;
 * 
 * @author pcentgraf
 * @since Mar 8, 2007
 */
public class CDateTimeObservableValue extends AbstractObservableValue {
    
    /**
     * The Control being observed here.
     */
    protected final CDateTime dateTime;
    
    /**
     * Flag to prevent infinite recursion in {@link #doSetValue(Object)}.
     */
    protected boolean updating = false;
    
    /**
     * The "old" selection before a selection event is fired.
     */
    protected Date currentSelection;
 
    private SelectionListener listener = new SelectionListener() {
        public void widgetDefaultSelected(SelectionEvent e) {
            //Skip
        }
        public void widgetSelected(SelectionEvent e) {
            if (!updating) {
                Date newSelection = CDateTimeObservableValue.this.dateTime.getSelection();
                fireValueChange(Diffs.createValueDiff(currentSelection, newSelection));
                currentSelection = newSelection;
            }
        }
    };
    
    /**
     * Observe the selection property of the provided CDateTime control.
     * @param dateTime the control to observe
     */
    public CDateTimeObservableValue(CDateTime dateTime) {
        this.dateTime = dateTime;
        currentSelection = dateTime.getSelection();
        this.dateTime.addSelectionListener(listener);
    }
 
    @Override
    public synchronized void dispose() {
        dateTime.removeSelectionListener(listener);
        super.dispose();
    }
 
    protected Object doGetValue() {
        if(!dateTime.isDisposed()) {
            return dateTime.getSelection();
        }
        return null;
    }
    
    protected void doSetValue(Object value) {
        if(value instanceof Date && !dateTime.isDisposed()) {
            Date oldValue;
            Date newValue;
            try {
                updating = true;
                oldValue = dateTime.getSelection();
                newValue = (Date) value;
                dateTime.setSelection(newValue);
                currentSelection = newValue;
                fireValueChange(Diffs.createValueDiff(oldValue, newValue));
            } finally {
                updating = false;
            }
        }
    }
 
    public Object getValueType() {
        return Date.class;
    }
    
}