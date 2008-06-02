package org.unicase.ui.navigator.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.meeditor.MEEditorInput;


/**
 * 
 * @author Hodaie
 * This is implementation of New Model Element wizard.
 * This wizard is show through "Add new model element..." command 
 * in context menu of Navigator (only on right click on LeafSection).
 * The wizard shows a tree of model packages and their classes.  
 * The user can select a Model Element type in this tree and on finish
 * the model element is created, added to Leaf- or CompositeSection and 
 * opend for editing.
 *
 */
public class NewModelElementWizard extends Wizard implements IWorkbenchWizard {

	private static final String MEEDITOR_PLUGIN_ID = "org.unicase.ui.meeditor";
	private ModelElement selectedME;
	/**.
	 * Through this field, the ModelTreePage tells the wizard which 
	 * model element type is selected
	 */
	private EClass newMEType;
	
	/**
	 * Through this field, the ModelTreePage tells the wizard if it's ready
	 * to finish, i.e. if the selection a model element is and not a package. 
	 */
	private boolean treePageCompleted;
	
	

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {
		
		ModelTreePage treePage = new ModelTreePage("ModelTreePage");
		addPage(treePage);
		
	}

	/**.
	 * ({@inheritDoc})
	 * This method creates a model element instance from selected type, 
	 * adds it to Leaf- or CompositeSection, 
	 * and opens it.
	 */
	@Override
	public boolean performFinish() {
		ModelElement newMEInstance;
		if (selectedME != null && newMEType != null){
			//1.create ME
			EPackage ePackage = newMEType.getEPackage();
			newMEInstance = (ModelElement)
				ePackage.getEFactoryInstance().create(newMEType);
			newMEInstance.setName("new " + newMEType.getName());
			
			//2.add newly created ME to ME that was selected in navigator
			if (selectedME instanceof LeafSection){
				((LeafSection)selectedME).getModelElements().add(newMEInstance);

			}
			//3.open the newly created ME
			openNewME(newMEInstance);
		}
				
		return true;
	}

	
	private void openNewME(ModelElement me) {
		MEEditorInput input = new MEEditorInput((ModelElement) me);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(input,
							MEEDITOR_PLUGIN_ID, true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**.
	 * ({@inheritDoc})
	 * 
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		//get the in navigator selected ME
		Object o;
		if (!selection.isEmpty()){
			o = selection.getFirstElement();
			if (o instanceof ModelElement){
				selectedME = (ModelElement) o;
			}
		}
	
	}
	
	/**.
	 * ({@inheritDoc})
	 */
	@Override
	public boolean canFinish() {
		return treePageCompleted;

	}

	/**
	 * @see newMEType 
	 * @param newMEType The ME type that was in ModelTreePage selected.
	 */
	public void setNewMEType(EClass newMEType) {
		this.newMEType = newMEType;
	}

	/**
	 * @see treePageCompeleted 
	 * @param treePageCompleted If ModelTreePage is complete (i.e. its selection is a ME)
	 */
	public void setTreePageCompleted(boolean treePageCompleted) {
		this.treePageCompleted = treePageCompleted;
	}

}
