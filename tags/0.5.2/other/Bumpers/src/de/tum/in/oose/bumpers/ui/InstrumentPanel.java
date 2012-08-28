package de.tum.in.oose.bumpers.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import de.tum.in.oose.bumpers.cars.UserCar;
import de.tum.in.oose.bumpers.cars.instruments.AnalogSpeedometer;
import de.tum.in.oose.bumpers.cars.instruments.AnalogSpeedometerAdapter;
import de.tum.in.oose.bumpers.cars.instruments.Body;
import de.tum.in.oose.bumpers.cars.instruments.GPS;
import de.tum.in.oose.bumpers.cars.instruments.InstrumentFactory;
import de.tum.in.oose.bumpers.cars.instruments.RotationsPerSecond;
import de.tum.in.oose.bumpers.cars.instruments.SpeedController;
import de.tum.in.oose.bumpers.cars.instruments.Speedometer;
import de.tum.in.oose.bumpers.cars.instruments.eu.EUFactory;
import de.tum.in.oose.bumpers.cars.instruments.us.USFactory;

public class InstrumentPanel extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String GERMAN = new String("GERMAN");
	public static String ENGLISH = new String("ENGLISH");
	
	private String language = ENGLISH;
	private JRadioButton germanSelectButton;
	private JRadioButton englishSelectButton;
	private JToolBar controlToolBar;
	
	private Body bodyView;
	private RotationsPerSecond rotationsPerSecond;
	private Speedometer speedometer;
	private SpeedController speedController;
	private GPS gps;
	private AnalogSpeedometer analogSpeedomer;
	private AnalogSpeedometerAdapter analogSpeedomerAdapter;
	
	private UserCar drivenCar;
	private InstrumentFactory factory;
	
	public InstrumentPanel(UserCar theDrivenCar){
		super(JToolBar.VERTICAL);
		setFloatable(false);
		this.drivenCar = theDrivenCar;
		this.factory = USFactory.getInstance();
		
		
		
		createInstruments(factory, theDrivenCar);
		subscribeInstruments(theDrivenCar);
		addInstruments();
		
		JButton externalInstrumentPanel = new JButton("new Window");
		externalInstrumentPanel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						final JFrame window = new JFrame("Instruments");
						final InstrumentPanel newInstrumentPanel = new InstrumentPanel(drivenCar);
						window.getContentPane().add(newInstrumentPanel);
						
						window.addWindowListener(new WindowAdapter() {
									public void windowClosing(WindowEvent e) {
										window.setVisible(false);
										newInstrumentPanel.unsubscribeInstruments();
									}});
						
						window.pack();
						window.setVisible(true);
					}
				});
		
		germanSelectButton = new JRadioButton("Deutsch");
		englishSelectButton = new JRadioButton("U.S.", true);
		
		ItemListener languageListener = new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				JRadioButton source = (JRadioButton)e.getSource();
				if(source.equals(germanSelectButton) && source.isSelected()){
					setLanguage(InstrumentPanel.GERMAN);
				}else if(source.equals(englishSelectButton) && source.isSelected()){
					setLanguage(InstrumentPanel.ENGLISH);
				}
			}};
		germanSelectButton.addItemListener(languageListener);
		englishSelectButton.addItemListener(languageListener);
		
		ButtonGroup group = new ButtonGroup();
		group.add(englishSelectButton);
		group.add(germanSelectButton);
		controlToolBar = new JToolBar();
		controlToolBar.setFloatable(false);
		
		controlToolBar.add(germanSelectButton);
		controlToolBar.add(englishSelectButton);
		controlToolBar.add(externalInstrumentPanel);
		add(controlToolBar);
	}
	
	private void createInstruments(InstrumentFactory factory, UserCar theDrivenCar) {
		rotationsPerSecond = factory.createRotationsPerSecond(theDrivenCar);
		speedometer = factory.createSpeedometer(theDrivenCar);
		speedController = factory.createSpeedController(theDrivenCar);
		bodyView = factory.createBodyView(theDrivenCar);
		gps = factory.createGPS(theDrivenCar);
		
		analogSpeedomer = new AnalogSpeedometer();
		analogSpeedomerAdapter = new AnalogSpeedometerAdapter(theDrivenCar,
															  analogSpeedomer);
	}
	
	private void addInstruments() {
		add(rotationsPerSecond);
		add(speedometer);
		add(analogSpeedomer);
		add(speedController);
		add(gps);
		add(bodyView);
	}
	
	private void removeInstruments() {
		removeAll();
	}
	
	
	private void subscribeInstruments(UserCar theDrivenCar) {
		theDrivenCar.subscribeInstrument(rotationsPerSecond);
		theDrivenCar.subscribeInstrument(speedometer);
		theDrivenCar.subscribeInstrument(speedController);
		theDrivenCar.subscribeInstrument(gps);
		theDrivenCar.subscribeInstrument(bodyView);
		theDrivenCar.subscribeInstrument(analogSpeedomerAdapter);
		
	}
	
	private void unsubscribeInstruments(){
		this.drivenCar.unsubscribeInstrument(bodyView);
		this.drivenCar.unsubscribeInstrument(rotationsPerSecond);
		this.drivenCar.unsubscribeInstrument(speedometer);
		this.drivenCar.unsubscribeInstrument(speedController);
		this.drivenCar.unsubscribeInstrument(gps);
		this.drivenCar.unsubscribeInstrument(analogSpeedomerAdapter);
	}
	
	
	
	private void setInstrumentFactory(InstrumentFactory factory){
		if(!this.factory.equals(factory)){
			this.factory = factory;
			unsubscribeInstruments();
			removeInstruments();
			createInstruments(this.factory, this.drivenCar);
			subscribeInstruments(this.drivenCar);
			addInstruments();
			add(controlToolBar);
			revalidate();
			doLayout();
			repaint();
		}
	}
	
	public void setLanguage(String newLanguage){
		if(!newLanguage.equals(this.language)){
			this.language = newLanguage;
			if(this.language.equals(GERMAN)){
				setInstrumentFactory(EUFactory.getInstance());
			}else{
				setInstrumentFactory(USFactory.getInstance());
			}
		}
	}
	
	
	
	public Dimension getPreferredSize(){
		Dimension d = super.getPreferredSize();
		return new Dimension(300, d.height);
	}
	
	public Dimension getMinimumSize(){
		Dimension d = super.getMinimumSize();
		return new Dimension(300, d.height);
	}
	
	public Dimension getMaximumSize(){
		Dimension d = super.getMaximumSize();
		return new Dimension(300, d.height);
	}
}

