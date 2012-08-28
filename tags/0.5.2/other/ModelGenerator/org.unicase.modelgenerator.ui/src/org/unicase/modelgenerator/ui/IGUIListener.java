package org.unicase.modelgenerator.ui;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IGUIListener {
	public void runInCommand(ModelGeneratorGUI gui, IProgressMonitor monitor);
}

