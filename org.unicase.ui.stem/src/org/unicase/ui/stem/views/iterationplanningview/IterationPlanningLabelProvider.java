package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;

public class IterationPlanningLabelProvider  extends ColumnLabelProvider implements
IColorProvider {
	
	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public Color getBackground(Object element) {
//		Display display = PlatformUI.getWorkbench().getDisplay();
//		if (element instanceof ModelElement) {
//			ModelElement me = (ModelElement) element;
//			if (me.getState().equals(MEState.OPEN)) {
//				return display.getSystemColor(SWT.COLOR_YELLOW);
//			}
//			if (me.getState().equals(MEState.CLOSED)) {
//				return display.getSystemColor(SWT.COLOR_GREEN);
//			}
//
//		}
//		return super.getBackground(element);
		return null;
	}

}
