package org.unicase.ui.spellcheck;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;

public class SpellcheckedSourceViewer extends SourceViewer {

	public SpellcheckedSourceViewer(Composite parent, int styles) {
		super(parent, null, styles);

		TextAnnotationModel model = new TextAnnotationModel();
		this.setDocument(new Document(), model);
		configure(new TextSourceViewerConfiguration(this));

		model.setText(getTextWidget());
	}

	/*
	 * public static IReconciler getReconciler(ISourceViewer sourceViewer) { // if
	 * (!Activator.getDefault().getPreferenceStore().getBoolean(SpellingService.PREFERENCE_SPELLING_ENABLED)) // return
	 * null; SpellingService spellingService = EditorsUI.getSpellingService(); if
	 * (spellingService.getActiveSpellingEngineDescriptor(Activator.getDefault().getPreferenceStore()) == null) return
	 * null; IReconcilingStrategy strategy = new TextSpellingReconcileStrategy(sourceViewer, spellingService);
	 * MonoReconciler reconciler = new MonoReconciler(strategy, false); reconciler.setDelay(500); return reconciler; }
	 */

}
