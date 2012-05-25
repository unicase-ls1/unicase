package edu.tum.in.bruegge.epd.kinect.debug;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

public class DebugHelper {

	public static void runLastDebug() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				runCommand("org.eclipse.debug.ui.commands.DebugLast");
			}
		});
	}

	public static void stepOver() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				runCommand("org.eclipse.debug.ui.commands.StepOver");
			}
		});
	}

	public static void stepInto() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				runCommand("org.eclipse.debug.ui.commands.StepInto");
			}
		});
	}

	public static void stepReturn() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				runCommand("org.eclipse.debug.ui.commands.StepReturn");
			}
		});
	}

	public static void resume() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				runCommand("org.eclipse.debug.ui.commands.Resume");
			}
		});
	}

	private static void runCommand(String command) {
		System.out.println("Executing command " + command);
		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
		try {
			handlerService.executeCommand(command, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (NotDefinedException e) {
			e.printStackTrace();
		} catch (NotEnabledException e) {
			e.printStackTrace();
		} catch (NotHandledException e) {
			e.printStackTrace();
		}

	}

}
