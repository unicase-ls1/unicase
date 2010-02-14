package org.unicase.mergetest.analysis;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.conflictDetection.ByDocumentConflictDetectionStrategy;
import org.unicase.emfstore.conflictDetection.ByModelElementConflictDetectionStrategy;
import org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.conflictDetection.IndexSensitiveConflictDetectionStrategy;
import org.unicase.emfstore.conflictDetection.NonIndexSensitiveConflictDetectionStrategy;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.proxyclient.ProxyClient;

public class AnalyseConflictsController extends ProxyClient {

	public void run() throws EmfStoreException, Exception {
		loginServer("super", "super", "unicase-internal.informatik.tu-muenchen.de", null, "unicase.org 2010#1");

		List<Row> rows = new ArrayList<Row>();

		List<ConflictDetectionStrategy> strategies = new ArrayList<ConflictDetectionStrategy>();
		strategies.add(new IndexSensitiveConflictDetectionStrategy());
		strategies.add(new NonIndexSensitiveConflictDetectionStrategy());
		strategies.add(new ByDocumentConflictDetectionStrategy());
		strategies.add(new ByModelElementConflictDetectionStrategy());

		for (ProjectInfo info : getProjectList()) {
			if (!info.getName().equals("DOLLI2")) {
				continue;
			}
			for (ConflictDetectionStrategy strategy : strategies) {
				rows.addAll(analyse(info, strategy));
			}
		}

		String[] columns = new String[] { "projectName", "version", "author",
				"seperator", "updateEvent count", "updateEvent lowerBound",
				"updateEvent upperBound", "updateEvent range", "seperator",
				"topOperation count", "leafOperation count",
				"referenceOperation count", "attributeOperation count",
				"createOperation count", "deleteOperation count",
				"compositeOperation count", "otherOperation count",
				"seperator", "conflictDetectorStrategy", "hasConflict",
				"seperator", "myTopOperations count", "myLeafOperations count",
				"theirTopOperations count", "theirLeafOperations count",
				"seperator", "myConflictingTopOperations count",
				"theirConflictingTopOperations count",
				"myConflictingLeafOperations count",
				"theirConflictingLeafOperations count", "seperator",
				"myAttTheirAttConflict count", "myAttTheirCrDeConflict count",
				"myCrDeTheirAttConflict count",
				"myCrDeTheirCrDeConflict count",
				"myCrDeTheirRefConflict count", "myRefTheirCrDeConflict count",
				"myRefTheirRefConflict count", "myCompTheirCompConflict count",
				"myCompTheirCrDelConflict count",
				"myCrDelTheirCompConflict count",
				"myCompTheirRefConflict count", "myRefTheirCompConflict count",
				"otherConflict count" };

		FileWriter fileWriter = new FileWriter(
				"C:/Users/Otto/Desktop/analyse.csv");

		String tmp = printTop(columns);
		fileWriter.write(tmp);
		fileWriter.write(System.getProperty("line.separator"));
		System.out.println(tmp);
		for (Row row : rows) {
			tmp = printRow(columns, row);
			fileWriter.write(tmp);
			fileWriter.write(System.getProperty("line.separator"));
			System.out.println(tmp);
		}
		fileWriter.close();
	}

	private String printTop(String[] columns) {
		StringBuffer result = new StringBuffer();
		for (String column : columns) {
			if (!column.equals("seperator")) {
				result.append(column);
			}
			result.append(";");
		}
		return result.toString();
	}

	private String printRow(String[] columns, Row row) {
		StringBuffer result = new StringBuffer();
		for (String column : columns) {
			if (!column.equals("seperator")) {
				Object object = row.get(column);
				if (object == null) {
					object = 0;
				}
				if (object instanceof Boolean) {
					object = ((Boolean) (object)) ? 1 : 0;
				}
				result.append(object.toString());
			}
			result.append(";");
		}
		return result.toString();
	}

	private List<Row> analyse(ProjectInfo info,
			ConflictDetectionStrategy strategy) throws EmfStoreException {
		ArrayList<Row> rows = new ArrayList<Row>();
		for (int i = 1; i <= info.getVersion().getIdentifier(); i++) {
			Row row = new Row(i, info.getName());
			System.out.println("row: "+i);
			ChangePackage changePackage = getChangePackage(info, i);

			LogMessage logMessage = changePackage.getLogMessage();
			if (logMessage != null) {
				row.put("author", logMessage.getAuthor());
			}

			analyseUpdateEvents(row, changePackage);

			analyseChangePackage(row, changePackage);

			analyseConflicts(row, info, changePackage, strategy);

			rows.add(row);
		}
		return rows;
	}

	private void analyseConflicts(Row row, ProjectInfo info,
			ChangePackage myChanges, ConflictDetectionStrategy strategy)
			throws EmfStoreException {
		if (!(row.get("updateEvent lowerBound") instanceof Integer && row
				.get("updateEvent upperBound") instanceof Integer)) {
			return;
		}
		int lower = (Integer) row.get("updateEvent lowerBound");
		int upper = (Integer) row.get("updateEvent upperBound");
		row
				.put("conflictDetectorStrategy", strategy.getClass()
						.getSimpleName());

		List<ChangePackage> theirChanges = getConnectionManager().getChanges(
				getSessionId(), info.getProjectId(), createVersionSpec(lower),
				createVersionSpec(upper));

		if (strategy instanceof ByDocumentConflictDetectionStrategy) {
			Project project = getConnectionManager().getProject(getSessionId(),
					info.getProjectId(),
					createVersionSpec((Integer) row.get("version")));
			((ByDocumentConflictDetectionStrategy) strategy)
					.setProject(project);
		}
		ConflictDetector conflictDetector = new ConflictDetector(strategy);

		boolean hasConflict = conflictDetector.doConflict(myChanges,
				theirChanges);
		row.put("hasConflict", hasConflict);

		if (!hasConflict) {
			return;
		}

		row.put("myTopOperations count", myChanges.getOperations().size());
		row.put("myLeafOperations count", myChanges.getLeafOperations().size());
		int top = 0, leaf = 0;
		for (ChangePackage theirCP : theirChanges) {
			top += theirCP.getOperations().size();
			leaf += theirCP.getLeafOperations().size();
		}
		row.put("theirTopOperations count", top);
		row.put("theirLeafOperations count", leaf);

		// Count Conflicting

		HashSet<AbstractOperation> topMy = new HashSet<AbstractOperation>();
		HashSet<AbstractOperation> topTheir = new HashSet<AbstractOperation>();
		for (AbstractOperation myOperation : myChanges.getOperations()) {
			for (ChangePackage theirCP : theirChanges) {
				for (AbstractOperation theirOperation : theirCP.getOperations()) {
					if (conflictDetector
							.doConflict(myOperation, theirOperation)) {
						topMy.add(myOperation);
						topTheir.add(theirOperation);
						count(row, myOperation, theirOperation);
					}
				}
			}
		}
		row.put("myConflictingTopOperations count", topMy.size());
		row.put("theirConflictingTopOperations count", topTheir.size());

		int leafMy = 0, leafTheir = 0;
		for (AbstractOperation op : topMy) {
			leafMy += op.getLeafOperations().size();
		}
		for (AbstractOperation op : topTheir) {
			leafTheir += op.getLeafOperations().size();
		}
		row.put("myConflictingLeafOperations count", leafMy);
		row.put("theirConflictingLeafOperations count", leafTheir);
	}

	private void count(Row row, AbstractOperation myOperation,
			AbstractOperation theirOperation) {

		if (isAttribute(myOperation) && isAttribute(theirOperation)) {
			row.intAdd("myAttTheirAttConflict count");
		} else if (isAttribute(myOperation) && isCreateDelete(theirOperation)) {
			row.intAdd("myAttTheirCrDeConflict count");
		} else if (isCreateDelete(myOperation) && isAttribute(theirOperation)) {
			row.intAdd("myCrDeTheirAttConflict count");
		} else if (isCreateDelete(myOperation)
				&& isCreateDelete(theirOperation)) {
			row.intAdd("myCrDeTheirCrDeConflict count");
		} else if (isCreateDelete(myOperation) && isReference(theirOperation)) {
			row.intAdd("myCrDeTheirRefConflict count");
		} else if (isReference(myOperation) && isCreateDelete(theirOperation)) {
			row.intAdd("myRefTheirCrDeConflict count");
		} else if (isReference(myOperation) && isReference(theirOperation)) {
			row.intAdd("myRefTheirRefConflict count");
		} else if (isComposite(myOperation) && isComposite(theirOperation)) {
			row.intAdd("myCompTheirCompConflict count");
		} else if (isComposite(myOperation) && isCreateDelete(theirOperation)) {
			row.intAdd("myCompTheirCrDelConflict count");
		} else if (isCreateDelete(myOperation) && isComposite(theirOperation)) {
			row.intAdd("myCrDelTheirCompConflict count");
		} else if (isComposite(myOperation) && isReference(theirOperation)) {
			row.intAdd("myCompTheirRefConflict count");
		} else if (isReference(myOperation) && isComposite(theirOperation)) {
			row.intAdd("myRefTheirCompConflict count");
		} else {
			row.intAdd("otherConflict count");
		}

	}

	private void analyseChangePackage(Row row, ChangePackage changePackage) {
		row.put("commitSize root", changePackage.getOperations().size());
		row.put("commitSize leaf", changePackage.getLeafOperations().size());

		int ref = 0, att = 0, cre = 0, del = 0, oth = 0, comp = 0;
		for (AbstractOperation operation : changePackage.getOperations()) {
			if (isReference(operation)) {
				ref++;
			} else if (isAttribute(operation)) {
				att++;
			} else if (isCreate(operation)) {
				cre++;
			} else if (isDelete(operation)) {
				del++;
			} else if (isComposite(operation)) {
				comp++;
			} else {
				oth++;
			}
		}

		row.put("topOperation count", changePackage.getOperations().size());
		row
				.put("leafOperation count", changePackage.getLeafOperations()
						.size());
		row.put("referenceOperation count", ref);
		row.put("attributeOperation count", att);
		row.put("createOperation count", cre);
		row.put("deleteOperation count", del);
		row.put("compositeOperation count", del);
		row.put("otherOperation count", oth);
	}

	private void analyseUpdateEvents(Row row, ChangePackage changePackage) {
		EList<Event> events = changePackage.getEvents();
		List<UpdateEvent> updateEvents = new ArrayList<UpdateEvent>();
		for (Event event : events) {
			if (event instanceof UpdateEvent) {
				updateEvents.add((UpdateEvent) event);
			}
		}

		row.put("updateEvent count", updateEvents.size());
		int range = 0;
		if (updateEvents.size() > 0) {
			int lower = updateEvents.get(0).getBaseVersion().getIdentifier();
			int upper = updateEvents.get(updateEvents.size() - 1)
					.getTargetVersion().getIdentifier();

			row.put("updateEvent lowerBound", lower);
			row.put("updateEvent upperBound", upper);
			range = upper - lower;
		}
		row.put("updateEvent range", range);
	}

	//
	// Helper Methods
	//	

	public static boolean isComposite(AbstractOperation operation) {
		return operation instanceof CompositeOperation
				&& ((CompositeOperation) operation).getMainOperation() == null;
	}

	public static boolean isReference(AbstractOperation operation) {
		return isSingleRef(operation) || isMultiRef(operation)
				|| isCompositeRef(operation);
	}

	public static boolean isCompositeRef(AbstractOperation operation) {
		return operation instanceof CompositeOperation
				&& ((CompositeOperation) operation).getMainOperation() != null;
	}

	public static boolean isSingleRef(AbstractOperation operation) {
		return operation instanceof SingleReferenceOperation;
	}

	public static boolean isMultiRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceOperation;
	}

	public static boolean isMultiMoveRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceMoveOperation;
	}

	public static boolean isAttribute(AbstractOperation operation) {
		return operation instanceof AttributeOperation;
	}

	public static boolean isDiagramLayout(AbstractOperation operation) {
		return operation instanceof DiagramLayoutOperation;
	}

	public static boolean isCreate(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& !((CreateDeleteOperation) operation).isDelete();
	}

	public static boolean isDelete(AbstractOperation operation) {
		return isCreateDelete(operation)
				&& ((CreateDeleteOperation) operation).isDelete();
	}

	public static boolean isCreateDelete(AbstractOperation operation) {
		return operation instanceof CreateDeleteOperation;
	}

	private ChangePackage getChangePackage(ProjectInfo info, int i)
			throws EmfStoreException {
		List<ChangePackage> changes = getConnectionManager().getChanges(
				getSessionId(), info.getProjectId(), createVersionSpec(i - 1),
				createVersionSpec(i));
		if (changes.size() != 1) {
			throw new IllegalStateException();
		}
		return changes.get(0);
	}

	public class Row {
		HashMap<String, Object> map;

		public Row(int version, String projectName) {
			map = new HashMap<String, Object>(30);
			put("version", version);
			put("projectName", projectName);
		}

		public void put(String key, Object value) {
			map.put(key, value);
		}

		public void intAdd(String key) {
			Object object = get(key);
			int newValue = 0;
			if (object == null) {
				newValue = 1;
			} else if (object instanceof Integer) {
				newValue = ((Integer) object) + 1;
			} else {
				throw new IllegalStateException("No number");
			}
			put(key, newValue);
		}

		public Object get(String key) {
			return map.get(key);
		}

	}
}
