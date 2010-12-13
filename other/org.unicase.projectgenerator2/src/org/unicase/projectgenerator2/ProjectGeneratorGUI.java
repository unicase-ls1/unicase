package org.unicase.projectgenerator2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.eclipse.emf.ecore.EPackage;

public class ProjectGeneratorGUI extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1870695207208799938L;

	private IProjectGenerator listener;
	
	private FirstDialog firstDialog;
	private SecondDialog secondDialog;
	

	public void setListener(IProjectGenerator listener) {
		this.listener = listener;
	}

	public IProjectGenerator getListener() {
		return listener;
	}
	
	public ProjectGeneratorGUI() {
		init();
	}

	private void init() {
		firstDialog = new FirstDialog();
		secondDialog = new SecondDialog();
		showFirstDialog();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private class FirstDialog extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//TODO: Hier die Models einfügen, die zur Auswahl stehen.
		private JPanel mainPanel = new JPanel();
		
		
		private JPanel buttonPanel = new JPanel();
		private JPanel container = new JPanel();
		private JButton forwardButton = new JButton("Forward");
	    
	    private Vector<String> list = new Vector<String>();
	    private JList modelList;

		
		
		public FirstDialog() {
			init();
		}

		private void init() {
			container.setLayout(new BorderLayout());
			container.add(mainPanel, BorderLayout.NORTH);
			container.add(buttonPanel, BorderLayout.SOUTH);		

			
		    //TODO: hier brauchen wir dann die Methode getAllEPackages

		    modelList = new JList(ProjectGeneratorUtil.getAllRootModelPackages().toArray(new EPackage[0]));
		    mainPanel.add(new JScrollPane(modelList));
		    
		    buttonPanel.add(forwardButton);
		    

		    
		    
			forwardButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					showSecondDialog();
				}
			});
			
			this.add(container);		
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
		this.setSize(new Dimension(400,600));
	}
	
	private void showSecondDialog() {
		this.remove(firstDialog);
		this.add(secondDialog);
		this.pack();
		this.setSize(new Dimension(400,600));
	}
	
	private void callListener() {
		listener.setHierachyDepth(secondDialog.getProjectHeight());
		listener.setNoOfExampleValues(secondDialog.getProjectWidth());
		listener.setRootPackage((EPackage)firstDialog.modelList.getSelectedValue());
		listener.generateValues();
	}

	//just for testing
	public static void main(String[] args) {
		ProjectGeneratorGUI projectGeneratorGUI = new ProjectGeneratorGUI();
		projectGeneratorGUI.setSize(new Dimension(400,600));
		projectGeneratorGUI.setVisible(true);
	}
}
