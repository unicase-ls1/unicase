/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.WorkspaceManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hodaie
 */
public class WorkItemsToCSV {

	private List<EStructuralFeature> features;

	private static final String RECORD_DELIMITER = "[END_OF_RECORD]";
	private static final String ATTRIBUTE_DLIMITER = "#";
	private static final String MANY_VALUED_ATTRIBUTE_DELIMITER = ",";

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception
	 *             exception
	 */
	public void outputWorkItems()  {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("C:\\aa\\workitems.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}

		printCSVHeader(fileWriter);

		List<WorkItem> workItems = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace().getProject()
				.getAllModelElementsbyClass(
						TaskPackage.eINSTANCE.getWorkItem(),
						new BasicEList<WorkItem>());

		printWorkItems(workItems, fileWriter);

		try {
			fileWriter.flush();
				fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	/**
	 * @param workItems
	 * @param writer
	 */
	private void printWorkItems(List<WorkItem> workItems, FileWriter writer) {
		StringBuilder sb = new StringBuilder("");
		for (WorkItem wi : workItems) {
			if ((wi instanceof WorkPackage) || (wi instanceof Milestone)) {
				continue;
			}
			sb.append(wi.eClass().getName());
			sb.append(ATTRIBUTE_DLIMITER);
			for (EStructuralFeature feature : features) {
				if (feature instanceof EAttribute) {

					sb.append(getText(wi, (EAttribute) feature));

				} else {
					sb.append(getText(wi, (EReference) feature));
				}
				sb.append(ATTRIBUTE_DLIMITER);
			}

			sb.replace(sb.length() - 1, sb.length(), "");
			sb.append(RECORD_DELIMITER);
			sb.append("\n");

		}
		try {
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finished writing WIs");
	}

	/**
	 * @param string
	 */
	private String removeLineBreaks(String string) {
		string = string.replace("\n", " ");
		string = string.replace("\r", "");
		string = string.replace(";, %BEGINNTEXT%", "");
		string = string.replace("#", " ");
		string = string.replace(",", " ");
		return string;

	}

	/**
	 * @param wi
	 * @param feature
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Object getText(WorkItem wi, EReference feature) {
		StringBuilder sb = new StringBuilder("");
		String result = "";
		Object value = wi.eGet(feature);
		if (value == null) {
			return result;
		}

		if (feature.isMany()) {
			List<EObject> list = (List<EObject>) value;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof ModelElement) {
					sb.append(((ModelElement) list.get(i)).getName());
				} else {
					sb.append("");
				}

				if (i != list.size() - 1) {
					sb.append(MANY_VALUED_ATTRIBUTE_DELIMITER);
				}
			}
			result = removeLineBreaks(sb.toString());
			return result;
		} else {
			if (value instanceof ModelElement) {
				sb.append(((ModelElement) value).getName());
			} else {
				sb.append("");
			}

			result = removeLineBreaks(sb.toString());
			return result;
		}

	}

	/**
	 * @param wi
	 * @param attr
	 * @return
	 */
	private Object getText(WorkItem wi, EAttribute attr) {
		String result = "";
		Object obj = wi.eGet(attr);
		if (obj != null && !attr.isMany()) {
			result = removeLineBreaks(obj.toString());

		}

		return result;
	}

	/**
	 * 
	 */
	private void printCSVHeader(FileWriter writer) {
		StringBuilder sb = new StringBuilder("");
		sb.append("type");
		sb.append(ATTRIBUTE_DLIMITER);
		features = getOutputFeatures();
		for (EStructuralFeature feature : features) {
			sb.append(feature.getName() + "#");
		}
		sb.replace(sb.length() - 1, sb.length(), "");
		sb.append("[END_OF_RECORD]");
		sb.append("\n");

		try {
			writer.write(sb.toString());
			// writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Header written.");

	}

	/**
	 * @return
	 */
	private List<EStructuralFeature> getOutputFeatures() {
		List<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		result.add(ModelPackage.eINSTANCE.getModelElement_Name());
		result.add(ModelPackage.eINSTANCE.getModelElement_Description());
		result.add(ModelPackage.eINSTANCE
				.getAnnotation_AnnotatedModelElements());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Predecessors());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Successors());
		result.add(TaskPackage.eINSTANCE.getWorkItem_Assignee());
		return result;
	}

	// END SUPRESS CATCH BLOCK
}
