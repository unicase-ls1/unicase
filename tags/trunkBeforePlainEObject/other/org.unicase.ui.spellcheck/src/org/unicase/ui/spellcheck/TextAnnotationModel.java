/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.spellcheck;

import java.util.Map;


import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationMap;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * Annotation model for spellchecking.
 * @author jfinis
 *
 */
public class TextAnnotationModel extends AnnotationModel {

	/**
	 * The text.
	 */
	private StyledText text;

	/**
	 * Sets the text widget for this model.
	 * @param text the text widget
	 */
	public void setText(StyledText text) {
		this.text = text;
	}


	/**
	 * Is called to update the underlined parts of the text.
	 * @param annotationsToRemove annotations to be removed.
	 * @param annotationsToAdd annotations to be added.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void replaceAnnotations(Annotation[] annotationsToRemove, Map annotationsToAdd) {
		IAnnotationMap annotationMap = super.getAnnotationMap();

		if (text != null) {

			// Assemble the style ranges to display the spelling problems
			StyleRange[] ranges = new StyleRange[annotationsToRemove.length + annotationsToAdd.size()];
			int curIndex = 0;

			// Delete old annotations

			for (Annotation a : annotationsToRemove) {
				Position p = (Position) annotationMap.get(a);
				ranges[curIndex++] = new StyleRange(p.offset, p.length, null, null);
			}

			for (Object o : annotationsToAdd.keySet()) {
				Annotation a = (Annotation) o;
				Position p = (Position) annotationsToAdd.get(a);
				StyleRange r = new StyleRange(p.offset, p.length, null, null);
				r.underline = true;
				r.underlineStyle = SWT.UNDERLINE_SQUIGGLE;

				ranges[curIndex++] = r;
			}

			//Do the changes
			Display.getDefault().asyncExec(new ReconcileThread(ranges));

		}

		// Call super
		super.replaceAnnotations(annotationsToRemove, annotationsToAdd);

	}

	/**
	 * Applies the changes to the UI (the underlining of spelling mistakes)
	 * This has to be done in a seperate thread because it is a UI action.
	 * @author jfinis
	 *
	 */
	private class ReconcileThread extends Thread {

		private StyleRange[] ranges;

		public ReconcileThread(StyleRange[] ranges) {
			this.ranges = ranges;
		}

		/**
		 * Does the underlining.
		 */
		@Override
		public void run() {
			Color red = Display.getDefault().getSystemColor(SWT.COLOR_RED);
			for (StyleRange r : ranges) {
				if (r.underline) {
					r.underlineColor = red;
				}
				text.setStyleRange(r);
			}
		}

	}
}
