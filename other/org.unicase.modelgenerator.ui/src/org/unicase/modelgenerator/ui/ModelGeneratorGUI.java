package org.unicase.modelgenerator.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.unicase.modelgenerator.ModelGenerator;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;

public class ModelGeneratorGUI extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1870695207208799938L;

	private IGUIListener listener;
	
	private FirstDialog firstDialog;
	private SecondDialog secondDialog;

	private EObject project;

	public void setListener(IGUIListener listener) {
		this.listener = listener;
	}

	public IGUIListener getListener() {
		return listener;
	}
	
	public ModelGeneratorGUI() {
		init();
	}

	public ModelGeneratorGUI(EObject project) {
		this.project=project;
		init();
	}

	private void init() {
		firstDialog = new FirstDialog();
		secondDialog = new SecondDialog();
		showFirstDialog();
	}
	
	
	private class FirstDialog extends JPanel{
		/**
		 * 
		 */
		private EPackage[] models;
		private static final long serialVersionUID = 1L;

		//TODO: Hier die Models einfügen, die zur Auswahl stehen.
		private JPanel mainPanel = new JPanel();
		
		
		private JPanel buttonPanel = new JPanel();
		private JPanel container = new JPanel();
		private JButton forwardButton = new JButton("Forward");
	    
	    private JList modelList;
	    private JList rootObjectList=new JList(new DefaultListModel());

	    private EClass[] allModelElementEClasses;
		private JList ignoredObjectsList;
		
		
		public FirstDialog() {
			init();
		}

		private void init() {
			container.setLayout(new BorderLayout());
			container.add(mainPanel, BorderLayout.NORTH);
			container.add(buttonPanel, BorderLayout.SOUTH);		
			
			//models = new EPackage[]{ModelGeneratorUtil.getEPackage("http://unicase.org/model")};
			models = ModelGeneratorUtil.getAllRootEPackages().toArray(new EPackage[0]);
			String[] modelsString = getModelNames(models);
			modelList = new JList(modelsString);
			ignoredObjectsList = new JList(modelsString);
			ignoredObjectsList.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			mainPanel.setLayout(new BorderLayout());
		    mainPanel.add(new JScrollPane(modelList), BorderLayout.NORTH);
		    JPanel objectsPanel=new JPanel();
		    objectsPanel.add(new JScrollPane(ignoredObjectsList));
		    objectsPanel.add(new JScrollPane(rootObjectList));
		    mainPanel.add(objectsPanel, BorderLayout.SOUTH);
		    buttonPanel.add(forwardButton);
		    
		    modelList.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		EPackage model = getSelectedPackage();
		    		((DefaultListModel)rootObjectList.getModel()).clear();
		    		if(model!=null){
		    			allModelElementEClasses = ModelGeneratorUtil.getAllEClasses(model).toArray(new EClass[0]);
		    			DefaultListModel defaultModel = (DefaultListModel)rootObjectList.getModel();
		    			DefaultListModel ignoredModel = (DefaultListModel)ignoredObjectsList.getModel();
		    			for (int i = 0; i < allModelElementEClasses.length; i++) {
		    				EClass eClass = allModelElementEClasses[i];
							defaultModel.addElement(eClass.getName());
							ignoredModel.addElement(eClass.getName());
		    			}
						
		    		}
		    	}
			});
		    

		    
		    
			forwardButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					showSecondDialog();
				}
			});
			
			this.add(container);		
		}

		private String[] getModelNames(EPackage[] models) {
			String[] modelNames = new String[models.length];
			for (int i = 0; i < models.length; i++) {
				modelNames[i] = models[i].getName();
			}
			return modelNames;
		}
		
		private EPackage getSelectedPackage(){
			return models[modelList.getSelectedIndex()];
		}
		
		private EClass getRootClass(){
			return (allModelElementEClasses[rootObjectList.getSelectedIndex()]);
		}
		
		private List<EClass> getIgnoredObjectsAsClass(){
			int[] selectedIndices = ignoredObjectsList.getSelectedIndices();
			List<EClass> eClasses = new ArrayList<EClass>();
			for (int i : selectedIndices) {
				eClasses.add(allModelElementEClasses[i]);
			}
			return eClasses;
		}
	}
	
	private class SecondDialog extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//TODO: Hier die Textboxen für die Breite, Höhe des Projekts einfügen.
		private JPanel mainPanel = new JPanel();
		
		
		private JPanel buttonPanel = new JPanel();
		private JPanel container = new JPanel();
		private JButton okButton = new JButton("Ok");
		private JButton backButton = new JButton("Backward");
	
		private JTextField widthField = new JTextField(5);
		private JLabel widthLabel = new JLabel("Breite:");
	
		private JTextField heightField = new JTextField(5);
		private JLabel heightLabel = new JLabel("Höhe:");
		
		private JTextField seedField = new JTextField(5);
		private JLabel seedLabel = new JLabel("Seed:");

		private JCheckBox checkLogging = new JCheckBox("Enable Logging");
		public SecondDialog() {
			init();
		}
		
		private boolean isLoggingEnabled(){
			return checkLogging.isSelected();
		}
		
		private int getProjectHeight(){
			return new Integer(heightField.getText());
		}
		
		private int getProjectWidth(){
			return new Integer(widthField.getText());
		}
		
		private int getSeed(){
			return new Integer(seedField.getText());
		}

		private void init() {
			container.setLayout(new BorderLayout());
			container.add(mainPanel, BorderLayout.NORTH);
			container.add(buttonPanel, BorderLayout.SOUTH);		

//			widthField.setSize(100,100);
			mainPanel.add(widthLabel);
			mainPanel.add(widthField);
			
//			heightField.setSize(100,100);
			mainPanel.add(heightLabel);
			mainPanel.add(heightField);
			
			mainPanel.add(seedLabel);
			mainPanel.add(seedField);

			buttonPanel.add(okButton);
			buttonPanel.add(backButton);
			mainPanel.add(checkLogging);
			okButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					callListener();
					ModelGeneratorGUI.this.dispose();
				}

			});

			backButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent e) {
					showFirstDialog();
				}
			});
			
			this.add(container);		
		}
	}
	
	private void showFirstDialog() {
		this.remove(secondDialog);
		this.add(firstDialog);
		this.pack();
		this.setSize(new Dimension(600,600));
	}
	
	private void showSecondDialog() {
		this.remove(firstDialog);
		this.add(secondDialog);
		this.pack();
		this.setSize(new Dimension(600,600));
	}

	
	private void callListener() {
		ProgressMonitorDialog progressDialog;
		if(Display.getCurrent()!=null){
			progressDialog = new ProgressMonitorDialog(new Shell(Display.getCurrent()));
		}
		else{
			progressDialog = new ProgressMonitorDialog(new Shell(new Display()));
		}
		try {
			progressDialog.run(true, true, new IRunnableWithProgress(){
			    public void run(IProgressMonitor monitor) {
			    	IHandlerService service=(IHandlerService)PlatformUI.getWorkbench().getService(IHandlerService.class);
	//		    	service.executeCommand(arg0, arg1)
					listener.runInCommand(ModelGeneratorGUI.this, monitor);
			    }
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//just for testing
	public static void main(String[] args) {
		ModelGeneratorGUI projectGeneratorGUI = new ModelGeneratorGUI();
		projectGeneratorGUI.setSize(new Dimension(600,600));
		projectGeneratorGUI.setVisible(true);
	}

	public void generateModel(IProgressMonitor monitor) {
		final ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(firstDialog.getSelectedPackage(), project, firstDialog.getIgnoredObjectsAsClass(), secondDialog.getProjectWidth(), secondDialog.getProjectHeight(), secondDialog.getSeed(), secondDialog.isLoggingEnabled());
		ModelGenerator.generateModel(config, monitor);

						
		
//		listener.setHierachyDepth(secondDialog.getProjectHeight());
//		listener.setNoOfExampleValues(secondDialog.getProjectWidth());
//		listener.setRootPackage();
//		EClass clazz = firstDialog.getRootClass();
//		listener.setRootObject(EcoreUtil.create(clazz));
//		listener.generateModel();		
	}
}
