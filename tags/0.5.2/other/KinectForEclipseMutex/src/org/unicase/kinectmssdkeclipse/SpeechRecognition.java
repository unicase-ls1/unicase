package org.unicase.kinectmssdkeclipse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.ui.JavaUIMessages;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.unicase.kinectmssdkeclipse.game.SpeechListener;
import org.unicase.kinectmssdkeclipse.handlers.EclipseActions;

public class SpeechRecognition {

	// private KinectConnection kconHandler;
	private Map<String, IPath> refreshedCommands;
	private IResourceChangeListener listener;
	private static boolean isOpenTypeDialogOpen = false;
	private SpeechListener speechListener;

	public void setSpeechListener(SpeechListener speechListener) {
		this.speechListener = speechListener;
	}

	public SpeechRecognition(/* KinectConnection kconHandler */) {
		// this.kconHandler = kconHandler;
	}

	public String getCommands(String subscribtion) {
		String words = subscribtion.toString();
		words += "Hello Eclipse, ";
		words += "Start debug mode, ";
		words += "Step over, ";
		words += "Step into, ";
		words += "Step return, ";
		words += "Resume, ";
		words += "Open Java perspective, ";
		words += "Bye Bye Eclipse, ";
		words += "Stop speech recognition, ";
		words += "Open Presentation, ";
		words += "Open Type, ";
		words += "Open Type Test";
		words += "Fix Bug";
		return words;
	}

	public void startSpeechRecognition() {

		// final SpeechRecognition speechRecoginition = this;
		// IWorkspace workspace = ResourcesPlugin.getWorkspace();
		// listener = new IResourceChangeListener() {
		// public void resourceChanged(IResourceChangeEvent event) {
		// speechRecoginition.refreshVocabulary(event);
		// }
		// };
		// workspace.addResourceChangeListener(listener);

	}

	public void fireSpeechEvent(final String recogWord) {
		System.out.println("Recog:" + recogWord);
		speechListener.speechDetected(recogWord);
		// if(recogWord.equals("Hello Eclipse")){
		// showText("Welcome back. What would you like to do?");
		// }
		// else if (recogWord.equals("Fix Bug"))
		//
		// else if(recogWord.equals("Bye Bye Eclipse")){
		// showText("See you soon!");
		// }
		// //put matching of command here
		// else if(recogWord.equals("Start debug mode")){
		// Display.getDefault().syncExec(new Runnable() {
		// public void run() {
		// EclipseActions.runCommand("org.eclipse.debug.ui.commands.DebugLast");
		// }
		// });
		// }
	}

	/*
	 * else if(recogWord.equals("Step over")){ Display.getDefault().syncExec(new
	 * Runnable() { public void run() {
	 * EclipseActions.runCommand("org.eclipse.debug.ui.commands.StepOver"); }
	 * }); } else if(recogWord.equals("Step into")){
	 * Display.getDefault().syncExec(new Runnable() { public void run() {
	 * EclipseActions.runCommand("org.eclipse.debug.ui.commands.StepInto"); }
	 * }); } else if(recogWord.equals("Step return")){
	 * Display.getDefault().syncExec(new Runnable() { public void run() {
	 * EclipseActions.runCommand("org.eclipse.debug.ui.commands.StepReturn"); }
	 * }); } else if(recogWord.equals("Resume")){
	 * Display.getDefault().syncExec(new Runnable() { public void run() {
	 * EclipseActions.runCommand("org.eclipse.debug.ui.commands.Resume"); } });
	 * } else if(recogWord.equals("Stop speech recognition")){
	 * //this.kconHandler.startSpeechRecog();
	 * ResourcesPlugin.getWorkspace().removeResourceChangeListener(listener); }
	 * else if(recogWord.equals("Open Java perspective")){
	 * Display.getDefault().syncExec(new Runnable() { public void run() {
	 * IHandlerService handlerService = (IHandlerService)
	 * PlatformUI.getWorkbench().getService(IHandlerService.class);
	 * ICommandService commandService = (ICommandService)
	 * PlatformUI.getWorkbench().getService(ICommandService.class); Command
	 * showView = commandService
	 * .getCommand("org.eclipse.ui.perspectives.showPerspective"); IParameter
	 * persIdParm; try { persIdParm = showView
	 * .getParameter("org.eclipse.ui.perspectives.showPerspective.perspectiveId"
	 * );
	 * 
	 * Parameterization parm = new Parameterization(persIdParm,
	 * "org.eclipse.jdt.ui.JavaPerspective"); ParameterizedCommand parmCommand =
	 * new ParameterizedCommand( showView, new Parameterization[] { parm });
	 * 
	 * handlerService.executeCommand(parmCommand, null); } catch (Exception e) {
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //EclipseActions.runCommand(
	 * "org.eclipse.ui.perspectives.showPerspective(org.eclipse.ui.perspectives.showPerspective.perspectiveId=org.eclipse.jdt.ui.JavaPerspective)"
	 * ); } }); } else if (recogWord.equals("Open Presentation")) {
	 * Program.launch("C:/Users/Edgar/Documents/Kinect_Presentation.pdf"); }
	 * else if (recogWord.equals("Open Type")) { openTypeDialog(); } else if
	 * (recogWord.equals("Open Type Test")) { openType(); // } else if
	 * (this.refreshedCommands != null) { // for (Map.Entry<String, IPath> entry
	 * : this.refreshedCommands.entrySet()) { // String command =
	 * entry.getKey(); // IPath path = entry.getValue(); // // if
	 * (recogWord.equals(command)) { // String type =
	 * command.replaceAll("Open type ", ""); // openType(type, path); // } // }
	 * } }
	 */

	private void openType() {
		if (!isOpenTypeDialogOpen) {
			isOpenTypeDialogOpen = true;
			Display.getDefault().syncExec(new Runnable() {
				@SuppressWarnings("restriction")
				public void run() {
					IWorkbench wb = PlatformUI.getWorkbench();
					IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
					@SuppressWarnings("restriction")
					OpenTypeSelectionDialog dialog = new OpenTypeSelectionDialog(
							win.getShell(), true, PlatformUI.getWorkbench()
									.getProgressService(), null,
							IJavaSearchConstants.TYPE);
					dialog.setTitle(JavaUIMessages.OpenTypeAction_dialogTitle);
					dialog.setMessage(JavaUIMessages.OpenTypeAction_dialogMessage);
					dialog.setInitialPattern("Test");
					dialog.setBlockOnOpen(false);
					dialog.open();
					isOpenTypeDialogOpen = false;
				}
			});

			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					IWorkbench wb = PlatformUI.getWorkbench();
					IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
					IWorkbenchPage page = win.getActivePage();
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					IProject project = workspace.getRoot().getProject(
							"MyKinectProject");
					IFile file = project
							.getFile("src/mykinectproject/Test.java");
					IEditorDescriptor desc = PlatformUI.getWorkbench()
							.getEditorRegistry()
							.getDefaultEditor(file.getName());
					try {
						page.openEditor(new FileEditorInput(file), desc.getId());
					} catch (PartInitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

	private void openTypeDialog() {
		if (!isOpenTypeDialogOpen) {
			isOpenTypeDialogOpen = true;
			Display.getDefault().syncExec(new Runnable() {
				@SuppressWarnings("restriction")
				public void run() {
					IWorkbench wb = PlatformUI.getWorkbench();
					IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
					@SuppressWarnings("restriction")
					OpenTypeSelectionDialog dialog = new OpenTypeSelectionDialog(
							win.getShell(), true, PlatformUI.getWorkbench()
									.getProgressService(), null,
							IJavaSearchConstants.TYPE);
					dialog.setTitle(JavaUIMessages.OpenTypeAction_dialogTitle);
					dialog.setMessage(JavaUIMessages.OpenTypeAction_dialogMessage);
					dialog.setBlockOnOpen(false);
					dialog.open();
					isOpenTypeDialogOpen = false;
				}
			});
		}
	}

	private void showText(final String text) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Shell shell = new Shell(Display.getDefault());
				Label label = new Label(shell, SWT.BORDER);
				Menu menu = new Menu(shell, SWT.POP_UP);
				label.setText(text);
				label.setBounds(0, 0, 300, 25);
				menu.setVisible(true);
				shell.setMenu(menu);
				shell.setSize(300, 70);
				shell.open();
			}
		});
	}

	private void refreshVocabulary(IResourceChangeEvent event) {
		// we are only interested in POST_CHANGE events
		if (event.getType() != IResourceChangeEvent.POST_CHANGE)
			return;
		IResourceDelta rootDelta = event.getDelta();

		final ArrayList<IResource> changed = new ArrayList<IResource>();
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) {
				// only interested in added resources (not changed or removed)
				if (delta.getKind() == IResourceDelta.ADDED) {
					IResource resource = delta.getResource();
					// only interested in files with the "java" extension
					if (resource.getType() == IResource.FILE
							&& "java".equalsIgnoreCase(resource
									.getFileExtension())) {
						changed.add(resource);
					}
				}
				return true;
			}
		};
		try {
			rootDelta.accept(visitor);
		} catch (CoreException e) {
			// open error dialog with syncExec or print to plugin log file
		}
		// nothing more to do if there were no changed text files
		if (changed.size() == 0)
			return;

		// newCommands = newCommands.substring(0, newCommands.length()-2);
	}

	private String getAllClasses() {
		final ArrayList<IResource> allJavaFiles = new ArrayList<IResource>();
		IResourceVisitor visitor = new IResourceVisitor() {
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource.getType() == IResource.FILE
						&& "java".equalsIgnoreCase(resource.getFileExtension())) {
					allJavaFiles.add(resource);
				}
				return true;
			}
		};

		try {
			ResourcesPlugin.getWorkspace().getRoot()
					.getProject("MyKinectProject").accept(visitor);

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String newCommands = "";

		if (this.refreshedCommands == null) {
			this.refreshedCommands = new HashMap<String, IPath>();
		}
		for (IResource res : allJavaFiles) {
			String fileName = res.getName();
			String name = fileName.replaceAll(".java", "");
			newCommands += "Open type " + name + ", ";
			this.refreshedCommands.put("Open type " + name, res.getFullPath());
		}

		return newCommands;

	}

}
