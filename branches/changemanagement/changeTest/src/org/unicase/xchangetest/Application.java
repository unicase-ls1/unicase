package org.unicase.xchangetest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private ChangeRecorder changeRecorder;

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("EMF Changemanagement test...");

		Project project = ModelFactory.eINSTANCE.createProject();

		startRecording(project);
		
			ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
			project.addModelElement(actionItem);
			
			actionItem.setDescription("description");
			actionItem.setName("name");

		printChanges();
		
		project = ModelFactory.eINSTANCE.createProject();
		
		actionItem = TaskFactory.eINSTANCE.createActionItem();
		project.addModelElement(actionItem);
			
		actionItem.setDescription("description");
		actionItem.setName("name");
		
		startRecording(project);
			
			project.getModelElements().remove(actionItem);
		
		printChanges();

		return IApplication.EXIT_OK;
	}

	
	
	
	
	
	private void printChanges() {
		final Resource res = (new ResourceSetImpl()).createResource(URI.createURI("bla"));
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		res.getContents().add(stopRecording());
		try {
			res.save(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(out.toString());
		System.out.println("\n\n ============= \n\n");

	}

	public void startRecording(EObject e) {
		changeRecorder = new ChangeRecorder();
		changeRecorder.beginRecording(Collections.singleton(e));
	}

	public ChangeDescription stopRecording() {
		ChangeDescription endRecording = changeRecorder.endRecording();
		endRecording.applyAndReverse();
		return endRecording;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
