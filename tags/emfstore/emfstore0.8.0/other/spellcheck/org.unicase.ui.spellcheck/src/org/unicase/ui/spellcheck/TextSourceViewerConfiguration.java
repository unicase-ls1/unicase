/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.spellcheck;

import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.spelling.SpellingReconcileStrategy;
import org.eclipse.ui.texteditor.spelling.SpellingService;

/**
 * Source viewer configuration for spellchecking.
 * The only difference is that it comes with a spelling reconciler.
 * @author jfinis
 */
public class TextSourceViewerConfiguration extends SourceViewerConfiguration {

	private IReconciler reconsiler;

	/**
	 * Gets the spelling reconciler.
	 * @param sourceViewer sourceViewer for which to get the reconciler.
	 * @return the reconciler.
	 */
	public static IReconciler getDefaultReconciler(ISourceViewer sourceViewer) {

		//Get spelling service
		SpellingService spellingService = EditorsUI.getSpellingService();
		if (spellingService.getActiveSpellingEngineDescriptor(Activator.getDefault().getPreferenceStore()) == null) {
			return null;
		}

		//Create reconcile strategy and reconciler
		IReconcilingStrategy strategy = new SpellingReconcileStrategy(sourceViewer, spellingService);
		MonoReconciler reconciler = new MonoReconciler(strategy, false);
		reconciler.setDelay(500);
		return reconciler;
	}

	/**
	 * Default constructor.
	 * @param s the source viewer for which to create the configuration.
	 */
	public TextSourceViewerConfiguration(ISourceViewer s) {
		super();
		this.reconsiler = getDefaultReconciler(s);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return reconsiler;
	}

}
