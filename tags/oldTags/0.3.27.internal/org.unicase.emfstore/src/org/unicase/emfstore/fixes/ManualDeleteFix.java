package org.unicase.emfstore.fixes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.RMISerializationException;

public class ManualDeleteFix extends AbstractFix {

	List<String> deleteList;

	/**
	 * User :::: as seperator.
	 */
	private void initDeletes() {
		deleteList = new ArrayList<String>();
		// unused meeting
		deleteList.add("_pAJQtaNxEd27Cexe4CVt1Q");
		deleteList.add("_pAJQsaNxEd27Cexe4CVt1Q");
		deleteList.add("_pAJQtqNxEd27Cexe4CVt1Q");
		deleteList.add("_pAJQsqNxEd27Cexe4CVt1Q");
		deleteList.add("_pAJQtKNxEd27Cexe4CVt1Q");
		deleteList.add("_pAJQsKNxEd27Cexe4CVt1Q");

		// identified workitemsection not existant in next project state
		deleteList.add("featureName=\"identifiedWorkItemsSection\"::::modelElementId id=\"_Y1BF4KNxEd27Cexe4CVt1Q\"");
		deleteList.add("featureName=\"identifiedWorkItemsSection\"::::modelElementId id=\"_hLQMsKOgEd2xnr7_LdISjQ\"");
		deleteList.add("featureName=\"identifiedWorkItemsSection\"::::modelElementId id=\"_Xj9m0KmJEd21aq8Ci5Agaw\"");
		deleteList.add("featureName=\"identifiedWorkItemsSection\"::::modelElementId id=\"_4ebowKGyEd2pEeemQvTNiA\"");
		deleteList.add("featureName=\"identifiedWorkItemsSection\"::::modelElementId id=\"_1_zhgLHJEd2OwabdFUT-uQ\"");

		// fixing description=";,&#xA;%BEGINNTEXT%"
		deleteList.add("featureName=\"description\"::::modelElementId id=\"_clQM5ql9Ed26h6_QY5e1mw\"");
		deleteList.add("featureName=\"description\"::::modelElementId id=\"_clQM5al9Ed26h6_QY5e1mw\"");

		// reviewer set, but not in the projecstate (operation didnt work in past?)
		deleteList
			.add("featureName=\"reviewer\"::::modelElementId id=\"_dywScP9LEd2-D-gfFWiodg::::2009-03-02T13:56:31");
	}

	@Override
	void fix() {
		initDeletes();
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() == null) {
				System.out.println("no changes in version " + version.getPrimarySpec().getIdentifier());
				continue;
			}
			for (Iterator<AbstractOperation> iter = version.getChanges().getOperations().iterator(); iter.hasNext();) {
				AbstractOperation operation = iter.next();
				try {
					String operationAsString = SerializationUtil.eObjectToString(operation);
					for (String delete : deleteList) {
						String[] deleteParts = delete.split("::::");
						boolean found = true;
						for (String part : deleteParts) {
							part = part.trim();
							found = found && (!part.equals("") && operationAsString.contains(part));
						}
						if (found && deleteParts.length > 0) {
							System.out.println("delete from version " + version.getPrimarySpec().getIdentifier());
							iter.remove();
							break;
						}
					}
				} catch (RMISerializationException e) {
					e.printStackTrace();
				}
			}
			save(version);
			save(version.getChanges());
		}
	}

	@Override
	String getFixName() {
		return "Manual Delete Fix";
	}

}
