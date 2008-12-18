package org.unicase.docExport.views;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.unicase.docExport.editors.TemplateEditor;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class TemplatesView extends ViewPart {
	
	/**
	 * the ID of this view.
	 */
	public static final String ID = "org.unicase.templatesView";

	private TreeViewer viewer;
	
	/**
	 * The constructor.
	 */
	public TemplatesView() {
		
	}
	
	/**
	 * @param parent the SWT parent object.
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent);
		viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setLabelProvider(new TreeLabelProvider());
		viewer.setInput("the TemplateRegistry will deal with this..");
		
		
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(viewer.getTree());
		// Set the MenuManager
		viewer.getTree().setMenu(menu);
		getSite().registerContextMenu(menuManager, viewer);
		// Make the selection available
		getSite().setSelectionProvider(viewer);
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {

				IHandlerService handlerService = (IHandlerService) getSite()
				.getService(IHandlerService.class);
				
					try {
						handlerService
							.executeCommand(TemplateEditor.COMMAND_ID, null);
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NotDefinedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NotEnabledException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NotHandledException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		getSite().setSelectionProvider(viewer);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	}

}
