/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.TwoDDataAnalyzer;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Analyze the potential conflict.
 * 
 * @author liya
 */
public class PotentialConflictAnalyzer implements TwoDDataAnalyzer {

	/**
	 * @see org.unicase.analyzer.dataanalyzer.TwoDDataAnalyzer#get2DValue(org.unicase.analyzer.ProjectAnalysisData,
	 *      org.unicase.analyzer.VersionIterator)
	 * @param data {@link ProjectAnalysisData}
	 * @param it {@link VersionIterator}
	 * @return 2D list
	 */

	public List<List<Object>> get2DValue(ProjectAnalysisData data, VersionIterator it) {
		List<List<Object>> values = new ArrayList<List<Object>>();
		PrimaryVersionSpec base;
		PrimaryVersionSpec target;

		PrimaryVersionSpec commitVersion = data.getPrimaryVersionSpec();

		ConflictDetector conflictDetector = new ConflictDetector();

		for (ChangePackage changePackage : data.getChangePackages()) {
			for (Event event : changePackage.getEvents()) {
				if (event instanceof UpdateEvent) {
					base = ((UpdateEvent) event).getBaseVersion();
					target = ((UpdateEvent) event).getTargetVersion();
					if (target.getIdentifier() + 1 != commitVersion.getIdentifier()) {
						continue;
					}
					try {
						ArrayList<ChangePackage> updateChanges = (ArrayList<ChangePackage>) it.getConnectionManager()
							.getChanges(it.getUsersession().getSessionId(), it.getProjectId(), base, target);
						if (conflictDetector.doConflict(changePackage, updateChanges)) {
							List<AbstractOperation> operationListA = changePackage.getOperations();
							List<AbstractOperation> operationListB = new ArrayList<AbstractOperation>();
							for (ChangePackage updateChange : updateChanges) {
								operationListB.addAll(updateChange.getOperations());
							}
							Set<AbstractOperation> conflictOpSet = conflictDetector.getAllConflictInvolvedOperations(
								operationListA, operationListB);
							List<Object> line = addLine(conflictOpSet, commitVersion, base, target);
							values.add(line);
						}
					} catch (EmfStoreException e) {
						String message = "Could not get changes from server";
						WorkspaceUtil.logException(message, e);
						throw new NoSuchElementException(message + ":\n" + e);
					}
				}
			}
		}

		return values;
	}

	private List<Object> addLine(Set<AbstractOperation> conflictOpSet, PrimaryVersionSpec commitVersion,
		PrimaryVersionSpec base, PrimaryVersionSpec target) {
		List<Object> line = new ArrayList<Object>();

		line.add(commitVersion.getIdentifier());
		line.add(base.getIdentifier());
		line.add(target.getIdentifier());

		int abstractOp = conflictOpSet.size();
		int composite = 0;
		int createDelete = 0;
		int feature = 0;
		int attribute = 0;
		int diagramLayout = 0;
		int multiAttributeMove = 0;
		int multiAttribute = 0;
		int multiReferenceMove = 0;
		int reference = 0;
		int multiReference = 0;
		int singleReference = 0;

		for (AbstractOperation op : conflictOpSet) {
			if (op instanceof CompositeOperation) {
				composite++;
				continue;
			} else if (op instanceof CreateDeleteOperation) {
				createDelete++;
				continue;
			} else if (op instanceof FeatureOperation) {
				feature++;
				if (op instanceof AttributeOperation) {
					attribute++;
					if (op instanceof DiagramLayoutOperation) {
						diagramLayout++;
					}
					continue;
				} else if (op instanceof MultiReferenceMoveOperation) {
					multiReferenceMove++;
					continue;
				} else if (op instanceof ReferenceOperation) {
					reference++;
					if (op instanceof MultiReferenceOperation) {
						multiReference++;
					} else if (op instanceof SingleReferenceOperation) {
						singleReference++;
					}
				}
			}
		}
		line.add(abstractOp);
		line.add(composite);
		line.add(createDelete);
		line.add(feature);
		line.add(attribute);
		line.add(diagramLayout);
		line.add(multiAttributeMove);
		line.add(multiAttribute);
		line.add(multiReferenceMove);
		line.add(reference);
		line.add(multiReference);
		line.add(singleReference);

		return line;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getName()
	 */

	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Commit Version");
		names.add("Updated source Version");
		names.add("Updated target Version");
		names.add("AbstractOperation #");
		names.add("CompositeOperation #");
		names.add("CreateDeleteOperation #");
		names.add("FeatureOperation #");
		names.add("AttributeOperation #");
		names.add("DiagramLayoutOperation #");
		names.add("MultiAttributeMoveOperation #");
		names.add("MultiAttributeOperation #");
		names.add("MultiReferenceMoveOperation #");
		names.add("ReferenceOperation #");
		names.add("MultiReferenceOperation #");
		names.add("SingleReferenceOperation #");
		return names;
	}

	/**
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 * @param data {@link ProjectAnalysisData}
	 * @return list
	 * @throws UnsupportedOperationException
	 */

	public List<Object> getValue(ProjectAnalysisData data) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.TwoDDataAnalyzer#analyzeData(org.unicase.analyzer.ProjectAnalysisData,
	 *      org.unicase.analyzer.iterator.VersionIterator)
	 */

	public void analyzeData(ProjectAnalysisData data, VersionIterator it) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#isGlobal()
	 */

	public boolean isGlobal() {
		return false;
	}
}
