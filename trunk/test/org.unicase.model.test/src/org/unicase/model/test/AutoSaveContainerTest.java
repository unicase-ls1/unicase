/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.util.AutoSaveContainer;
import org.unicase.model.util.AutoSaveContainerExceptionHandler;
import org.unicase.model.util.FileUtil;

/**
 * Tests for the auto save container.
 * 
 * @author koegel
 */
public class AutoSaveContainerTest implements AutoSaveContainerExceptionHandler {

	private static final int MAX_FILE_SIZE = 1000;
	private static final String EXTENSION = ".upf";
	private AutoSaveContainer<Project> container;
	private String path;

	/**
	 * Setup.
	 * 
	 * @throws IOException if test fails
	 */
	@Before
	public void setUp() throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		sb.append(".unicase");
		sb.append(".test");
		path = sb.toString();
		FileUtil.deleteFolder(new File(path));
		container = new AutoSaveContainer<Project>(ModelPackage.eINSTANCE.getProject(), path, EXTENSION, this);
	}

	/**
	 * Test a container with an empty startup.
	 */
	@Test
	public void testEmptyContainer() {
		container.setMaxFileSize(MAX_FILE_SIZE);
		assertEquals(false, fileExists(path + File.separator + AutoSaveContainer.ROOT_FILENAME + EXTENSION));
		Project project = container.init();
		assertEquals(true, fileExists(path + File.separator + AutoSaveContainer.ROOT_FILENAME + EXTENSION));
		assertEquals(1, dirSize(path));
		FunctionalRequirement functionalRequirement = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		project.addModelElement(functionalRequirement);
		functionalRequirement.setDescription("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		assertEquals(1, dirSize(path));
		FunctionalRequirement functionalRequirement2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		functionalRequirement2.setName("fr2");
		functionalRequirement.getRefiningRequirements().add(functionalRequirement2);
		assertEquals(2, dirSize(path));
		assertEquals(true, fileSize(path + File.separator + AutoSaveContainer.ROOT_FILENAME + EXTENSION) >= MAX_FILE_SIZE);
		
		container.destroy();

		container = new AutoSaveContainer<Project>(ModelPackage.eINSTANCE.getProject(), path, EXTENSION, this);
		Project project2 = container.init();
		assertEquals(2, project2.getAllModelElements().size());
		ModelElement modelElement = project2.getModelElement(functionalRequirement.getModelElementId());
		assertEquals(true, modelElement != null);
		assertEquals(1, modelElement.getAllContainedModelElements().size());
		assertEquals(functionalRequirement2.getModelElementId(), modelElement.getAllContainedModelElements().iterator().next().getModelElementId());
		assertEquals("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk", modelElement.getDescription());
		project2.getModelElement(functionalRequirement2.getModelElementId()).delete();
		assertEquals(1, dirSize(path));
		modelElement.delete();
		assertEquals(1, dirSize(path));
		assertEquals(0, project2.getAllModelElements().size());
	}

	/**
	 * Test a tree delete.
	 */
	@Test
	public void testTreeDelete() {
		container.setMaxFileSize(MAX_FILE_SIZE);
		assertEquals(false, fileExists(path + File.separator + AutoSaveContainer.ROOT_FILENAME + EXTENSION));
		Project project = container.init();
		assertEquals(true, fileExists(path + File.separator + AutoSaveContainer.ROOT_FILENAME + EXTENSION));
		assertEquals(1, dirSize(path));
		FunctionalRequirement functionalRequirement = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		project.addModelElement(functionalRequirement);
		functionalRequirement.setDescription("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
			+ "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		assertEquals(1, dirSize(path));
		FunctionalRequirement functionalRequirement2 = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		functionalRequirement2.setName("fr2");
		functionalRequirement.getRefiningRequirements().add(functionalRequirement2);
		assertEquals(2, dirSize(path));
		assertEquals(true, fileSize(path + File.separator + AutoSaveContainer.ROOT_FILENAME + EXTENSION) >= MAX_FILE_SIZE);
		
		assertEquals(2, project.getAllModelElements().size());
		functionalRequirement.delete();
		assertEquals(1, dirSize(path));
		assertEquals(0, project.getAllModelElements().size());
	}
	
	/**
	 * Clean up folder with test files.
	 * 
	 * @throws IOException if test fails
	 */
	@After
	public void tearDown() throws IOException {
		FileUtil.deleteFolder(new File(path));
	}

	private boolean fileExists(String path) {
		return new File(path).exists();
	}

	private int dirSize(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			return file.list().length;
		} else {
			return 0;
		}
	}

	private long fileSize(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			return file.length();
		} else {
			return 0;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.AutoSaveContainerExceptionHandler#handleExceptionOnSave(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.Resource, java.io.IOException)
	 */
	public void handleExceptionOnSave(EObject object, Resource resource, IOException exception) {
		fail(exception.getMessage());
	}

}
