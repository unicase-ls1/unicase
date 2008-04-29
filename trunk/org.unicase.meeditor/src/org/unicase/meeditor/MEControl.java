package org.unicase.meeditor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface MEControl {

	public Control createControl(Composite parent, int style);

}
