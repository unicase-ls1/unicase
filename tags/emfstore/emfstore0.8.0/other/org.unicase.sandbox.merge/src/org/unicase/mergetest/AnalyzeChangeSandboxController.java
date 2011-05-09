package org.unicase.mergetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.Configuration;

public class AnalyzeChangeSandboxController {

	public void run() {
		Resource resource = getResource("dolli");
		
		Result result = new Result();

		ConflictDetector conflictDetector = new ConflictDetector();
		int size = resource.getContents().size();
		for (int i = 1; i < size; i++) {
			ChangePackage object = (ChangePackage) resource.getContents().get(
					i - 1);
			ChangePackage object2 = (ChangePackage) resource.getContents().get(
					i);

			Set<AbstractOperation> conflicting = conflictDetector
					.getConflicting(object.getOperations(), object2
							.getOperations());

			result.add(conflicting, i);

			for (AbstractOperation ao : conflicting) {
				System.out.println(ao);
			}
		}
		
		result.render();

	}

	private Resource getResource(String name) {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(URI.createFileURI(Configuration
				.getWorkspaceDirectory()
				+ name + ".pcpc"), true);
	}

	public class Result {

		private Set<Class<? extends AbstractOperation>> classes;
		private List<Row> rows;

		public Result() {
			classes = new HashSet<Class<? extends AbstractOperation>>();
			rows = new ArrayList<Row>();
		}

		public void add(Set<AbstractOperation> conflicting, int i) {
			if (conflicting.size() == 0) {
				return;
			}
			for (AbstractOperation ao : conflicting) {
				if (!classes.contains(ao.getClass())) {
					classes.add(ao.getClass());
				}
			}
			rows.add(new Row(conflicting, i));
		}
		
		public List<Object> render() {
			ArrayList<Object> result = new ArrayList<Object>();
			String header = "Number;";
			for(Class clz : classes) {
				header += clz.getName()+";";
			}
			result.add(header);
			for(Row row : rows) {
				result.add(row.render(classes));
			}
			return result;
		}

		private class Row {

			private int num;
			private HashMap<Class<? extends AbstractOperation>, List<AbstractOperation>> columns;

			public Row(Set<AbstractOperation> conflicting, int i) {
				num = i;
				columns = new HashMap<Class<? extends AbstractOperation>, List<AbstractOperation>>();

				for (AbstractOperation ao : conflicting) {
					List<AbstractOperation> list = getList(ao.getClass());
					list.add(ao);
				}
			}
			
			public String render(Set<Class<? extends AbstractOperation>> classes) {
				String result = num+";";
				for(Class clz : classes) {
					List<AbstractOperation> ops = getList(clz);
					result += ops.size()+";";
				}
				return result;
			}

			private List<AbstractOperation> getList(
					Class<? extends AbstractOperation> class1) {
				List<AbstractOperation> list = columns.get(class1);
				if (list == null) {
					columns.put(class1, new ArrayList<AbstractOperation>());
				}
				return columns.get(class1);
			}
		}
	}
}
