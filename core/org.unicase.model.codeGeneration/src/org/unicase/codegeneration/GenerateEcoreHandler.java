package org.unicase.codegeneration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.implementation.IPackage;


public class GenerateEcoreHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			List<IPackage> packages = getPackages(structuredSelection);
			reduce(packages);

			try {
				generateEcore(packages);
			} catch (NotSelfContainedException e) {
				MessageDialog.openError(Display.getDefault().getActiveShell(),
						"Error",
						"The selected packages are not self contained.");
			}
		}

		return null;
	}

	private List<IPackage> getPackages(IStructuredSelection structuredSelection) {
		List<IPackage> packages = new ArrayList<IPackage>();
		for (Iterator i = structuredSelection.iterator(); i.hasNext();) {
			packages.add((IPackage) i.next());
		}
		return packages;
	}

	private void generateEcore(List<IPackage> packages) {
		EcoreGenerator generator = new EcoreGenerator();
		List<EPackage> ePackages = generator.generate(packages);

		FileDialog dialog = new FileDialog(Display.getDefault()
				.getActiveShell());
		dialog.setFilterExtensions(new String[] { "*.ecore" });
		String path = dialog.open();
		if (path != null) {
			ResourceSet resourceSet = new ResourceSetImpl();
			URI uri = URI.createFileURI(new File(path).getAbsolutePath());
			Resource resource = resourceSet.createResource(uri);
			resource.getContents().addAll(ePackages);
			try {
				resource.save(null);
			} catch (IOException e) {
				// ignore
			}
		}
	}

	private void reduce(List<IPackage> packages) {
		for (Iterator<IPackage> i = packages.iterator(); i.hasNext();) {
			IPackage p = i.next();
			if (contains(p.getParentPackage(), packages)) {
				i.remove();
			}
		}
	}

	private boolean contains(IPackage p, List<IPackage> packages) {
		while (p != null) {
			if (packages.contains(p)) {
				return true;
			}
			p = p.getParentPackage();
		}
		return false;
	}
}
