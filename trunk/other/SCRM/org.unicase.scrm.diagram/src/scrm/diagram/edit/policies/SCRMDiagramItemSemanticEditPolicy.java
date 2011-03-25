package scrm.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import scrm.diagram.edit.commands.AssumptionCreateCommand;
import scrm.diagram.edit.commands.ConstraintCreateCommand;
import scrm.diagram.edit.commands.DataDefinitionCreateCommand;
import scrm.diagram.edit.commands.DataFlowCreateCommand;
import scrm.diagram.edit.commands.DataHandlingCreateCommand;
import scrm.diagram.edit.commands.ErrorHandlingCreateCommand;
import scrm.diagram.edit.commands.FeatureCreateCommand;
import scrm.diagram.edit.commands.HardwareCreateCommand;
import scrm.diagram.edit.commands.InputDataReadingCreateCommand;
import scrm.diagram.edit.commands.MathematicalModelCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodCreateCommand;
import scrm.diagram.edit.commands.PerformanceCreateCommand;
import scrm.diagram.edit.commands.ProcessCreateCommand;
import scrm.diagram.edit.commands.ResultsOutputCreateCommand;
import scrm.diagram.edit.commands.ScientificProblemCreateCommand;
import scrm.diagram.edit.commands.SoftwareInterfaceCreateCommand;
import scrm.diagram.edit.commands.StatusMonitoringCreateCommand;
import scrm.diagram.edit.commands.UserInterfaceCreateCommand;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class SCRMDiagramItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SCRMDiagramItemSemanticEditPolicy() {
		super(ScrmElementTypes.SCRMDiagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ScrmElementTypes.ScientificProblem_2007 == req.getElementType()) {
			return getGEFWrapper(new ScientificProblemCreateCommand(req));
		}
		if (ScrmElementTypes.MathematicalModel_2005 == req.getElementType()) {
			return getGEFWrapper(new MathematicalModelCreateCommand(req));
		}
		if (ScrmElementTypes.NumericalMethod_2006 == req.getElementType()) {
			return getGEFWrapper(new NumericalMethodCreateCommand(req));
		}
		if (ScrmElementTypes.Assumption_2008 == req.getElementType()) {
			return getGEFWrapper(new AssumptionCreateCommand(req));
		}
		if (ScrmElementTypes.Feature_2009 == req.getElementType()) {
			return getGEFWrapper(new FeatureCreateCommand(req));
		}
		if (ScrmElementTypes.Hardware_2010 == req.getElementType()) {
			return getGEFWrapper(new HardwareCreateCommand(req));
		}
		if (ScrmElementTypes.Constraint_2011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if (ScrmElementTypes.UserInterface_2012 == req.getElementType()) {
			return getGEFWrapper(new UserInterfaceCreateCommand(req));
		}
		if (ScrmElementTypes.SoftwareInterface_2013 == req.getElementType()) {
			return getGEFWrapper(new SoftwareInterfaceCreateCommand(req));
		}
		if (ScrmElementTypes.Process_2014 == req.getElementType()) {
			return getGEFWrapper(new ProcessCreateCommand(req));
		}
		if (ScrmElementTypes.Performance_2015 == req.getElementType()) {
			return getGEFWrapper(new PerformanceCreateCommand(req));
		}
		if (ScrmElementTypes.DataFlow_2016 == req.getElementType()) {
			return getGEFWrapper(new DataFlowCreateCommand(req));
		}
		if (ScrmElementTypes.DataDefinition_2017 == req.getElementType()) {
			return getGEFWrapper(new DataDefinitionCreateCommand(req));
		}
		if (ScrmElementTypes.InputDataReading_2018 == req.getElementType()) {
			return getGEFWrapper(new InputDataReadingCreateCommand(req));
		}
		if (ScrmElementTypes.DataHandling_2019 == req.getElementType()) {
			return getGEFWrapper(new DataHandlingCreateCommand(req));
		}
		if (ScrmElementTypes.ResultsOutput_2020 == req.getElementType()) {
			return getGEFWrapper(new ResultsOutputCreateCommand(req));
		}
		if (ScrmElementTypes.ErrorHandling_2021 == req.getElementType()) {
			return getGEFWrapper(new ErrorHandlingCreateCommand(req));
		}
		if (ScrmElementTypes.StatusMonitoring_2022 == req.getElementType()) {
			return getGEFWrapper(new StatusMonitoringCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
