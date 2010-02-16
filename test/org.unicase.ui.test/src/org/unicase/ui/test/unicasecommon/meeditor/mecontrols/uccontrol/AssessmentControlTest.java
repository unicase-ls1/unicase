/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.test.unicasecommon.meeditor.mecontrols.uccontrol;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withRegex;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.impl.ProposalImpl;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.ui.test.UITestCommon;
import org.unicase.ui.test.meeditor.mecontrol.MeControlTest;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

public class AssessmentControlTest extends MeControlTest {
	private Issue issue;

	/**
	 * Setup the environment for testing.
	 */
		@Before
		public void setupActionItem() {

			new UnicaseCommand() {

				@Override
				protected void doRun() {
					issue = RationaleFactory.eINSTANCE.createIssue();
					issue.setName("New Issue");
					getLeafSection().getModelElements().add(issue);
				}
			}.run();
		}
		
		@SuppressWarnings("unchecked")
		@Test
		public void createAssessmentTest(){
			UITestCommon.openPerspective(getBot(), "Unicase");
			openModelElement(issue);
			UnicaseCommandWithResult<Matcher> criteriaWidgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
				@Override
				protected Matcher doRun() {
					Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("Create and link new Criteria"));
					return matchwidget;
				}
			};
			Matcher widgetmatcher1 = runAsnc(criteriaWidgetFinderCommand);
			final List widgetcontrol1 = getBot().getFinder().findControls(widgetmatcher1);
			
			
			
			UnicaseCommand widgetActivateCommand1 = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					ToolItem toolItem = ((ToolItem)widgetcontrol1.get(0));
					Event event = new Event();
					event.widget = ((ToolItem)widgetcontrol1.get(0));
					toolItem.notifyListeners(SWT.Selection, event);		
				}
			}; runAsnc(widgetActivateCommand1);
			
			
			final String criteria = "Criterion";
			getBot().text().setText(criteria);
			getBot().button("OK").click();
			
			openModelElement(issue);
			UnicaseCommandWithResult<Matcher> proposalWidgetFinderCommand = new UnicaseCommandWithResult<Matcher>() {
				@Override
				protected Matcher doRun() {
					Matcher matchwidget = allOf(widgetOfType(Widget.class), withTooltip("Create and link new Proposal"));
					return matchwidget;
				}
			};
			Matcher widgetmatcher = runAsnc(proposalWidgetFinderCommand);
			final List widgetcontrol = getBot().getFinder().findControls(widgetmatcher);
			
			
			
			UnicaseCommand widgetActivateCommand = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					ToolItem toolItem = ((ToolItem)widgetcontrol.get(0));
					Event event = new Event();
					event.widget = ((ToolItem)widgetcontrol.get(0));
					toolItem.notifyListeners(SWT.Selection, event);		
				}
			}; runAsnc(widgetActivateCommand);
			
			
			final String participant = "Proposal";
			getBot().text().setText(participant);
			getBot().button("OK").click();
			getBot().sleep(2000);
			getBot().activeEditor().bot().textWithLabel("Name").typeText("Proposal Test",2);
			
			
			
			
			new UnicaseCommand() {
				
				@Override
				protected void doRun() {
				EList<Criterion> list = issue.getCriteria();
				openModelElement(list.get(0).getAssessments().get(0));
				}
			}.run();
			final int value = 20;
			getBot().activeEditor().bot().textWithLabel("Name").typeText("Assessment",2);
			getBot().activeEditor().bot().spinnerWithLabel("Value").setSelection(value);
			getBot().sleep(2000);
			openModelElement(issue);
			
			UnicaseCommandWithResult<Matcher> spinnerWidgetFinder = new UnicaseCommandWithResult<Matcher>() {
				@Override
				protected Matcher doRun() {
					Matcher matchwidget = allOf(widgetOfType(Spinner.class));
					return matchwidget;
				}
			};
			Matcher spinner = runAsnc(spinnerWidgetFinder);
			final List widgetcontrol11 = getBot().getFinder().findControls(spinner);
			getBot().sleep(2000);
			UnicaseCommand some = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					
							
							Spinner spinner = ((Spinner)widgetcontrol11.get(3));
							int valuefromSpinner = spinner.getSelection();
							
							assertEquals(value, valuefromSpinner);
							
					
					
				}
			};runAsnc(some);
			
			
		}
		
		
		@SuppressWarnings("unchecked")
		@Test
		public void createAssessmentUpdate(){
			UITestCommon.openPerspective(getBot(), "Unicase");
			openModelElement(issue);
			final int value = 25;
			
			UnicaseCommand someCommand = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					Criterion criteria = RationaleFactory.eINSTANCE.createCriterion();
					criteria.setName("Test criteria");
					getLeafSection().getModelElements().add(criteria);
					issue.getCriteria().add(criteria);
					Assessment assessment = RationaleFactory.eINSTANCE.createAssessment();
					assessment.setName("Assessment for criteria");
					assessment.setValue(value);
					getLeafSection().getModelElements().add(assessment);
					criteria.getAssessments().add(assessment);
					Proposal proposal = RationaleFactory.eINSTANCE.createProposal();
					proposal.setName("Proposal for assessment test");
					getLeafSection().getModelElements().add(proposal);
					issue.getProposals().add(proposal);
					proposal.getAssessments().get(0).setValue(value);
					
				}
			};runAsnc(someCommand);
			
			UnicaseCommandWithResult<Matcher> spinnerWidgetFinder = new UnicaseCommandWithResult<Matcher>() {
				@Override
				protected Matcher doRun() {
					Matcher matchwidget = allOf(widgetOfType(Spinner.class));
					return matchwidget;
				}
			};
			Matcher spinner = runAsnc(spinnerWidgetFinder);
			final List widgetcontrol = getBot().getFinder().findControls(spinner);
			getBot().sleep(2000);
			UnicaseCommand some = new UnicaseCommand() {
				
				@Override
				protected void doRun() {
					
							
							Spinner spinner = ((Spinner)widgetcontrol.get(3));
							int valuefromSpinner = spinner.getSelection();
							
							assertEquals(value, valuefromSpinner);
							
					
					
				}
			};runAsnc(some);
			
		}

}
