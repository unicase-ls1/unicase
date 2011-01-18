package org.unicase.modelgenerator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.modelgenerator.util.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.util.ModelGeneratorUtil;

public class ModelGeneratorGUI extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1870695207208799938L;

	private IModelGenerator listener;
	
	private FirstDialog firstDialog;
	private SecondDialog secondDialog;
	

	public void setListener(IModelGenerator listener) {
		this.listener = listener;
	}

	public IModelGenerator getListener() {
		return listener;
	}
	
	public ModelGeneratorGUI() {
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
	    
	    private Vector<String> list = new Vector<String>();
	    private JList modelList;
	    private JList rootObjectList=new JList(new DefaultListModel());

	    private EClass[] allModelElementEClasses;
		
		
		public FirstDialog() {
			init();
		}

		private void init() {
			container.setLayout(new BorderLayout());
			container.add(mainPanel, BorderLayout.NORTH);
			container.add(buttonPanel, BorderLayout.SOUTH);		
			
			models = new EPackage[]{ModelGeneratorUtil.getModelPackage("http://unicase.org/model")};
			String[] modelsString = getModelNames(models);
		    modelList = new JList(modelsString);
		    mainPanel.add(new JScrollPane(modelList));
		    mainPanel.add(new JScrollPane(rootObjectList));
		    buttonPanel.add(forwardButton);
		    
		    modelList.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		EPackage model = getSelectedPackage();
		    		((DefaultListModel)rootObjectList.getModel()).clear();
		    		if(model!=null){
		    			allModelElementEClasses = ModelGeneratorUtil.getAllModelElementEClasses(model).toArray(new EClass[0]);
		    			DefaultListModel defaultModel = (DefaultListModel)rootObjectList.getModel();
		    			for (int i = 0; i < allModelElementEClasses.length; i++) {
		    				EClass eClass = allModelElementEClasses[i];
							defaultModel.addElement(eClass.getName());
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

		public SecondDialog() {
			init();
		}
		
		private int getProjectHeight(){
			return new Integer(heightField.getText());
		}
		
		private int getProjectWidth(){
			return new Integer(widthField.getText());
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

			buttonPanel.add(okButton);
			buttonPanel.add(backButton);
			
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
		ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(firstDialog.getSelectedPackage(), firstDialog.getRootClass(), secondDialog.getProjectWidth(), secondDialog.getProjectHeight());
		ModelGenerator.generateModel(config);
//		listener.setHierachyDepth(secondDialog.getProjectHeight());
//		listener.setNoOfExampleValues(secondDialog.getProjectWidth());
//		listener.setRootPackage();
//		EClass clazz = firstDialog.getRootClass();
//		listener.setRootObject(EcoreUtil.create(clazz));
//		listener.generateModel();
	}

	//just for testing
	public static void main(String[] args) {
		ModelGeneratorGUI projectGeneratorGUI = new ModelGeneratorGUI();
		projectGeneratorGUI.setSize(new Dimension(600,600));
		projectGeneratorGUI.setVisible(true);
	}
}
