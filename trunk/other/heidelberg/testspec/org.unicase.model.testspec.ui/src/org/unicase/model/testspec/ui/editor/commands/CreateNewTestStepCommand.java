package org.unicase.model.testspec.ui.editor.commands;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.testspec.TestCase;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestspecFactory;
import org.unicase.workspace.util.UnicaseCommand;

public final class CreateNewTestStepCommand extends UnicaseCommand {
	
	    private TestCase testCase;
	  
	
	    /**
	     * Default constructor.
	     * 
	     * @param modelElement
	     *            - test case for which teststeps will be created
	     * @param classifierID
	     *            - classifierID of TestCase
	     */
	    public CreateNewTestStepCommand(final ModelElement modelElement) {
	        this.testCase = (TestCase) modelElement;
	   
	    }

	    /**
	     * Creation command.
	     */
	    @Override
	    protected void doRun() {
	    	int maximum = 0;
	    	
	    	if (this.testCase != null) {
	        	
	    		//get all linked testSteps and check their numbers
	    	
	    		
	    		//this.testCase.getLinkedModelElements();
	    		Set<ModelElement> contained = this.testCase.getAllContainedModelElements();
                Set<TestStep> steps = new HashSet<TestStep>();   
                for(ModelElement element : contained){
                	if (element instanceof TestStep){
                		
                		steps.add((TestStep)element);
                	
                	}
                }
                
              if (steps.size() > 0){ 
                	for (TestStep step : steps){
                		String stepName = step.getName();
                		String[] nameSplit = stepName.split(" ");
                		String number = nameSplit[1];
                		//Get all numbers that can be converted to int
                		try{
                			int stepNumber = Integer.parseInt(number);
                		if (stepNumber > maximum){
                    		maximum = stepNumber;
                    	}
                		}catch (NumberFormatException nfe){
                			continue;
                		}
              
                	
                	}
                	maximum = maximum + 1;
              }
	    		
	        	Project project = this.testCase.getProject();
	            TestspecFactory factory = TestspecFactory.eINSTANCE;
                TestStep testStep = factory.createTestStep();
                
                
                 
                project.addModelElement(testStep);
                
                String name = "TestStep " + maximum;
                	
                testStep.setName(name);  
                testStep.setCreationDate(new Date());
                testStep.setDescription("Description");
           
                
                EList<TestStep> allTestSteps = testCase.getStep();
                allTestSteps.add(testStep);
          
	        }
	       
	    }
	}

