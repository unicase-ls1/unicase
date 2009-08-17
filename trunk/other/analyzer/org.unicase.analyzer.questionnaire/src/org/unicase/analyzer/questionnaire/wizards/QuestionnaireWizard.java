/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.analyzer.exporters.Exporter;

/**
 * @author liya
 *
 */
public class QuestionnaireWizard extends Wizard implements IWorkbenchWizard {

	private ChooseUserPage chooseUserPage;
	private EvaluatePage evaluatePage;
	private Exporter exporter;
	private Map<Integer, Integer> commitMap;
	private ResourceSet resourceSet;
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void addPages() {
		chooseUserPage = new ChooseUserPage("ChooseUserPage");
		addPage(chooseUserPage);
		evaluatePage = new EvaluatePage("EvaluatePage");
		addPage(evaluatePage);
	}

	/**
	 * @return the exporter
	 */
	public Exporter getExporter() {
		return exporter;
	}

	/**
	 * @param exporter the exporter to set
	 */
	public void setExporter(Exporter exporter) {
		this.exporter = exporter;
	}

	/**
	 * @return the commitMap
	 */
	public Map<Integer, Integer> getCommitMap() {
		return commitMap;
	}

	/**
	 * @param commitMap the commitMap to set
	 */
	public void setCommitMap(Map<Integer, Integer> commitMap) {
		this.commitMap = commitMap;
	}

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * @param resourceSet the resourceSet to set
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

}
