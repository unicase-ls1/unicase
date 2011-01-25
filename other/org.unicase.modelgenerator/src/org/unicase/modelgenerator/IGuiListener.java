package org.unicase.modelgenerator;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IGuiListener {
	public void runInCommand(ModelGeneratorGUI gui, IProgressMonitor monitor);
}
