package de.tum.in.oose.bumpers.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import de.tum.in.oose.bumpers.cars.GameBoard;
import de.tum.in.oose.bumpers.control.Referee;

public class Game extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel conent = new JPanel(new BorderLayout(), true);
	public Game() {
		super("Bumpers");
		
		ActionListener exitMenuItemListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.this.close();
			}};
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(exitMenuItemListener);
		
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(exitMenuItem);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		
		
		this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						Game.this.close();
					}});
		
		Referee.getInstance().initGame();
		
		getContentPane().setLayout(new BorderLayout());
		
		
		conent.add(ToolBar.getInstance(), BorderLayout.NORTH);
		conent.add(GameBoard.getInstance(),
				   BorderLayout.CENTER);
		conent.add(GameBoard.getInstance().getDrivenCar().getInstrumentPanel(),
				   BorderLayout.EAST);
		
		
		getContentPane().add(conent, BorderLayout.CENTER);
	}

	
	@Override
	public void setVisible(boolean b) {
		Dimension size = getPreferredSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds
		(
			(screenSize.width - size.width) / 2,
			(screenSize.height - size.height) / 2,
			size.width,
			size.height
		);
		super.setVisible(b);
	}
	
	public void doLayout(){
		super.doLayout();
		conent.doLayout();
		this.getContentPane().doLayout();
	}
	
	private void close() {
		setVisible(false);
		System.exit(0);
	}
}

