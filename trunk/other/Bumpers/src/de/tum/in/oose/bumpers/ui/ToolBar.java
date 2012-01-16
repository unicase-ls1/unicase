package de.tum.in.oose.bumpers.ui;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import de.tum.in.oose.bumpers.cars.GameBoard;
import de.tum.in.oose.bumpers.control.CollisionStrategy;
import de.tum.in.oose.bumpers.control.Referee;

public class ToolBar extends JToolBar implements ItemListener, ActionListener {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        GameBoard.getInstance().initiate();

    }

    private Action startBumperAction;
    private Action stopBumperAction;

    private JComboBox strategyBox = new JComboBox();
    private JComboBox testBox = new JComboBox();

    private static ToolBar INSTANCE;

    public static ToolBar getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ToolBar();
        }
        return INSTANCE;
    }

    private ToolBar() {
        super();

        ArrayList<Object> strategies = CollisionStrategy.getSTRATEGIES();
        Iterator<Object> iter = strategies.iterator();
        while (iter.hasNext()) {
            strategyBox.addItem(iter.next());
        }
        strategyBox.setSelectedItem(Referee.getInstance()
                .getCollisionStrategy());
        strategyBox.addItemListener(this);

        setFloatable(false);
        initActions();
        add(startBumperAction);
        add(stopBumperAction);
        addSeparator();
        add(new JLabel("Collision Strategy:"));
        add(strategyBox);

        testBox.addItem("Test1");
        testBox.addItem("Test2");
        testBox.addItem("Test3");
        testBox.addActionListener(this);
        add(new Label("Test:"));
        add(testBox);

        enableButtons();
    }

    private void initActions() {
        startBumperAction = new AbstractAction("start") {
            /**
			 * 
			 */
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                Referee.getInstance().startGame();
            }
        };

        stopBumperAction = new AbstractAction("stop") {
            /**
			 * 
			 */
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                Referee.getInstance().stopGame();
                int ret = JOptionPane.showConfirmDialog(null,
                        "Do you really want to stop the game ?",
                        "Stop Game Confirmation", JOptionPane.YES_NO_OPTION);
                if (ret == 0) {
                    Referee.getInstance().initGame();

                } else {
                    Referee.getInstance().startGame();
                }
            }
        };
    }

    public void enableButtons() {
        if (Referee.getInstance().isRunning()) {
            startBumperAction.setEnabled(false);
            stopBumperAction.setEnabled(true);
        } else {
            startBumperAction.setEnabled(true);
            stopBumperAction.setEnabled(false);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        CollisionStrategy selectedCollision = (CollisionStrategy) strategyBox
                .getSelectedItem();
        Referee.getInstance().setCollisionStrategy(selectedCollision);
    }

    public String getTest() {
        return (String) testBox.getSelectedItem();
    }
}
