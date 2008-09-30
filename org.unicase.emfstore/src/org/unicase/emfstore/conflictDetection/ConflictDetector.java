package org.unicase.emfstore.conflictDetection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Detects conflicts with a given {@link ConflictDetectionStrategy}.
 * 
 * @author koegel
 *
 */
public class ConflictDetector {

	private ConflictDetectionStrategy conflictDetectionStrategy;
	
	public ConflictDetector() {
		this(new AlwaysFalseConflictDetectionStrategy());
	}
	
	public ConflictDetector(ConflictDetectionStrategy conflictDetectionStrategy) {
		this.conflictDetectionStrategy=conflictDetectionStrategy;
	}
	
	public boolean doConflict(ChangePackage a, ChangePackage b) {
		for (AbstractOperation operation : a.getOperations()) {
			for (AbstractOperation otherOperation : b.getOperations()) {
				if (conflictDetectionStrategy.doConflict(operation, otherOperation));
			}
		}
		return false;
	}
	
	public ChangePackage doConflict(ChangePackage a, ArrayList<ChangePackage> list) {
		for(ChangePackage b : list){
			if(doConflict(a, b)){
				return b;
			}
		}
		return null;
	}
	
	/**
	 * Retrieve all operations in other ops that are conflicting with operations
	 * in ops. If any operation is in both lists, it is not considered to be
	 * conflicting.
	 * 
	 * @param ops
	 *            A list of operations.
	 * @param otherOps
	 *            A list of the other operations.
	 * @return A set of conflicting operations which is a subset of otherOps.
	 */
	public Set<AbstractOperation> getConflicting(List<AbstractOperation> ops,
			List<AbstractOperation> otherOps) {
		// the operations that are conflicting
		Set<AbstractOperation> conflicting = new HashSet<AbstractOperation>();

		// check each operation in ops against otherOps
		for (AbstractOperation position : ops) {
			for (AbstractOperation other : otherOps) {
				if (conflicting.contains(other)) {
					// a conflict has already been registered
					continue;
				}
				// if there is a conflict, add the other op to the
				// list of conflicting ops along with all ops that
				// require other ops
				if (conflictDetectionStrategy.doConflict(position, other)) {
					conflicting.addAll(getRequiring(otherOps, other));
					conflicting.add(other);
				}
			}

		}

		// return the set of conflicting operations in other ops
		return conflicting;
	}

	/**
	 * Retrieve all operations in ops that are required by op. The operation
	 * <code>op</code> must be part of <code>ops</code>.
	 * 
	 * @param ops
	 *            A time ordered (ascending) list of operations containing op.
	 * @param op
	 *            The operation for which the requirements should be determined.
	 * @return A list of operations that are required for op which is a subset
	 *         of ops. <code>op</code> will not be part of the returned list.
	 * @throws IllegalArgumentException
	 *             If op is not in ops.
	 */
	public List<AbstractOperation> getRequired(List<AbstractOperation> ops, AbstractOperation op)
			throws IllegalArgumentException {
		// sanity check
		if (!ops.contains(op)) {
			throw new IllegalArgumentException(
					"the ops list dos not contain op");
		}

		// Check all operations if they are (transitively) required by op.
		// We make use of the fact here that an operation can only require
		// operations that are before it in time.
		int opIdx = ops.indexOf(op);
		List<AbstractOperation> required = new ArrayList<AbstractOperation>();
		required.add(op);

		for (int i = ops.size() - 1; i >= 0; i--) {
			AbstractOperation current = ops.get(i);
			// if the current op is after op, it can not be required by it
			if (ops.indexOf(current) >= opIdx) {
				continue;
			}
			// else check if it is required by any of the already required ops
			for (AbstractOperation req : required) {
				if (conflictDetectionStrategy.isRequired(req, current)) {
					required.add(0, current);
					break;
				}
			}
		}
		required.remove(op);

		// return the sub list of operations required by op
		return required;
	}

	/**
	 * Retrieve all operations in ops that require op.
	 * 
	 * @param ops
	 *            A time ordered (ascending) list of operations containing op.
	 * @param op
	 *            The operation for which the dependants should be determined.
	 * @return A list of operations that require op which is a subset of ops.
	 */
	public List<AbstractOperation> getRequiring(List<AbstractOperation> ops, AbstractOperation op) {
		// sanity check
		if (!ops.contains(op)) {
			throw new IllegalArgumentException(
					"the ops list dos not contain op");
		}

		// Check all operations if they (transitively) require op.
		// We make use of the fact here that an operation can only
		// possibly require an operation that is before it in time.
		int opIdx = ops.indexOf(op);
		List<AbstractOperation> requiring = new ArrayList<AbstractOperation>();
		requiring.add(op);
		for (AbstractOperation current : ops) {
			// if the current op is before op, it can not require it
			if (ops.indexOf(current) <= opIdx) {
				continue;
			}
			// else check if it requires any of the already requiring ops
			for (AbstractOperation req : requiring) {
				if (conflictDetectionStrategy.isRequired(req, current)) {
					requiring.add(current);
					break;
				}
			}
		}
		requiring.remove(op);
		// return the sub list of operations requiring op
		return requiring;
	}
	
	/**
	 * Return all conflicting
	 * @param operationListA
	 * @param operationListB
	 * @return
	 */
	public Set<AbstractOperation> getAllConflictInvolvedOperations(List<AbstractOperation> operationListA, List<AbstractOperation> operationListB) {
		Set<AbstractOperation> result = new HashSet<AbstractOperation>();
		for (AbstractOperation operationA : operationListA) {
			if (result.contains(operationA)) {
				continue;
			}
			List<AbstractOperation> reqAoperations = getRequiring(operationListA, operationA);
			Set<AbstractOperation> conflicting = getConflicting(reqAoperations, operationListB);
			if (conflicting.size()>0) {
				result.addAll(conflicting);
				result.add(operationA);
			}
		}
		for (AbstractOperation operationB : operationListB) {
			if (result.contains(operationB)) {
				continue;
			}
			List<AbstractOperation> reqAoperations = getRequiring(operationListB, operationB);
			Set<AbstractOperation> conflicting = getConflicting(reqAoperations, operationListA);
			if (conflicting.size()>0) {
				result.addAll(conflicting);
				result.add(operationB);
			}			
		}
		return result;
	}
}
