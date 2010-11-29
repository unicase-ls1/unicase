/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.rework;
 
import java.util.Date;
 
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
 
/**
 * Implements DataBinding feature for the Nebula CDateTime control.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
public class CDateTimeObservableValue extends AbstractObservableValue {

    private Date date;
    private final CDateTime widget;
    private boolean currentlyUpdatingFlag;
 
    private SelectionListener widgetListener = new SelectionListener() {
        public void widgetDefaultSelected(SelectionEvent e) {
            // do nothing
        }
        public void widgetSelected(SelectionEvent e) {
            if (!currentlyUpdatingFlag) {
            	// change from widget not handled right now
                Date newDate = widget.getSelection();
                fireValueChange(Diffs.createValueDiff(date, newDate));
                date = newDate;
            }
        }
    };
    
    /**
     * Constructor.
     * @param widget the control to observe
     */
    public CDateTimeObservableValue(CDateTime widget) {
        this.widget = widget;
        date = widget.getSelection();
        this.widget.addSelectionListener(widgetListener);
    }
 
    /**
	 * {@inheritDoc}
	 */
    @Override
    public synchronized void dispose() {
        widget.removeSelectionListener(widgetListener);
        super.dispose();
    }
 
    /**
	 * {@inheritDoc}
	 */
    @Override
    protected Object doGetValue() {
        if(!widget.isDisposed()) {
            return widget.getSelection();
        }
        return null;
    }
    
    /**
	 * {@inheritDoc}
	 */
    @Override
    protected void doSetValue(Object value) {
        if (value instanceof Date && !widget.isDisposed()) {
            Date oldDate;
            Date newDate;
            try {
                currentlyUpdatingFlag = true;
                oldDate = widget.getSelection();
                newDate = (Date) value;
                widget.setSelection(newDate);
                date = newDate;
                fireValueChange(Diffs.createValueDiff(oldDate, newDate));
            } finally {
                currentlyUpdatingFlag = false;
            }
        }
    }
    
    /**
	 * {@inheritDoc}
	 */
    public Object getValueType() {
        return Date.class;
    }
    
}