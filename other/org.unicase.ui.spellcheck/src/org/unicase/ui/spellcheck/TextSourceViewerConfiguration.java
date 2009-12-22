package org.unicase.ui.spellcheck;

import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.spelling.SpellingReconcileStrategy;
import org.eclipse.ui.texteditor.spelling.SpellingService;

public class TextSourceViewerConfiguration extends SourceViewerConfiguration {

	private IReconciler reconsiler;

	public static IReconciler getDefaultReconciler(ISourceViewer sourceViewer) {
		// if (!Activator.getDefault().getPreferenceStore().getBoolean(SpellingService.PREFERENCE_SPELLING_ENABLED))
		// return null;

		SpellingService spellingService = EditorsUI.getSpellingService();
		if (spellingService.getActiveSpellingEngineDescriptor(Activator.getDefault().getPreferenceStore()) == null)
			return null;

		IReconcilingStrategy strategy = new SpellingReconcileStrategy(sourceViewer, spellingService);
		MonoReconciler reconciler = new MonoReconciler(strategy, false);
		reconciler.setDelay(500);
		return reconciler;
	}

	public TextSourceViewerConfiguration(ISourceViewer s) {
		super();
		this.reconsiler = getDefaultReconciler(s);
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return reconsiler;
	}

}
