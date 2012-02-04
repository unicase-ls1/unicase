package edu.tum.in.bruegge.epd.kinect.game;

import java.util.Iterator;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.IParameterValues;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

public class GameHelper {

	@SuppressWarnings("rawtypes")
	public static void openProblemsView() {
		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);
		ICommandService commandService = (ICommandService) PlatformUI
				.getWorkbench().getService(ICommandService.class);
		Command showView = commandService
				.getCommand("org.eclipse.ui.views.showView");
		IParameter viewIdParm;
		try {
			viewIdParm = showView
					.getParameter("org.eclipse.ui.views.showView.viewId");
			IParameterValues parmValues = viewIdParm.getValues();
			String viewId = null;
			Iterator i = parmValues.getParameterValues().values().iterator();
			while (i.hasNext()) {
				String id = (String) i.next();
				if (id.indexOf("ProblemView") != -1) {
					viewId = id;
					break;
				}
			}
			Parameterization parm = new Parameterization(viewIdParm, viewId);
			ParameterizedCommand parmCommand = new ParameterizedCommand(
					showView, new Parameterization[] { parm });

			handlerService.executeCommand(parmCommand, null);
		} catch (NotDefinedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (NotEnabledException e) {
			e.printStackTrace();
		} catch (NotHandledException e) {
			e.printStackTrace();
		} catch (ParameterValuesException e) {
			e.printStackTrace();
		}
	}

	public static void runCommand(String command) {
		System.out.println("Executing command " + command);
		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);
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
