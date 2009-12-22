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

public class TextAnnotationModel extends AnnotationModel {

	private StyledText text;

	public TextAnnotationModel() {
	}

	public void setText(StyledText text) {
		this.text = text;
	}

	@Override
	public void addAnnotation(Annotation annotation, Position position) {
		// TODO Auto-generated method stub
		super.addAnnotation(annotation, position);
		System.out.println(annotation.getText());
	}

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

			Display.getDefault().asyncExec(new ReconcileThread(ranges));

		}

		// TODO Auto-generated method stub
		super.replaceAnnotations(annotationsToRemove, annotationsToAdd);

	}

	private class ReconcileThread extends Thread {

		private StyleRange[] ranges;

		public ReconcileThread(StyleRange[] ranges) {
			this.ranges = ranges;
		}

		@Override
		public void run() {
			Color red = Display.getDefault().getSystemColor(SWT.COLOR_RED);
			for (StyleRange r : ranges) {
				if (r.underline)
					r.underlineColor = red;
				text.setStyleRange(r);
			}
		}

	}
}
