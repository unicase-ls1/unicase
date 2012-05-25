package de.tum.in.oose.bumpers.cars;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import de.tum.in.oose.bumpers.ui.ToolBar;

public class GameBoard extends Canvas {

    private static final long serialVersionUID = 1L;
    private static GameBoard INSTANCE;
    public static int NUMBER_OF_FAST_CARS = 0;
    public static int NUMBER_OF_SLOW_CARS = 1;

    private static Dimension DEFAULT_SIZE = new Dimension(500, 300);
    private static Color backgroundColor = Color.WHITE;

    private UserCar theDrivenCar;
    private ArrayList<Car> robotCars = new ArrayList<Car>();

    public String test = "None";

    private Image backgroundImage;
    private Graphics backgroundGraphics;
    private Dimension theSize;

    public static GameBoard getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameBoard();
        }
        return INSTANCE;
    }

    private GameBoard() {
        setSize(getPreferredSize());
        theDrivenCar = new UserCar();
        theDrivenCar.position = new Point(250, 30);

        new MouseSteering(this, theDrivenCar);

    }

    public Dimension getPreferredSize() {
        return DEFAULT_SIZE;
    }

    public Car[] getRobotCars() {
        return (Car[]) robotCars.toArray(new Car[robotCars.size()]);
    }

    public UserCar getDrivenCar() {
        return this.theDrivenCar;
    }

    public void update(Graphics g) {
        if (theSize == null || theSize.width != getSize().width
                || theSize.height != getSize().height) {
            theSize = getSize();

            backgroundImage = createImage(theSize.width, theSize.height);
            backgroundGraphics = backgroundImage.getGraphics();
        }
        paint(backgroundGraphics);
        g.drawImage(backgroundImage, 0, 0, null);
    }

    public void paint(Graphics g) {

        g.setColor(backgroundColor);

        g.fillRect(0, 0, getSize().width, getSize().height);

        Car[] carArray = getRobotCars();
        int num = carArray.length;
        for (int i = 0; i < num; i++) {
            paintCar(carArray[i], g);

        }
        paintCar(theDrivenCar, g);
    }

    private void paintCar(Car car, Graphics g) {
        Point carPosition = car.getPosition();
        Point canvasPosition = convertPosition(carPosition);
        g.drawImage(car.getBody(), canvasPosition.x, canvasPosition.y, car
                .getSize().width, car.getSize().height, null);
    }

    public void initiate() {
        theDrivenCar.initiate(getSize().width, getSize().height);
        SlowCar car = new SlowCar(getSize().width, getSize().height);
        SlowCar car2 = new SlowCar(getSize().width, getSize().height);
        this.robotCars.clear();
        car2.position = new Point(0, 0);
        car2.setDirection(90);
        theDrivenCar.speed = 4;
        robotCars.add(car);
        robotCars.add(car2);
        ToolBar toolBar = ToolBar.getInstance();
        String test = toolBar.getTest();

        if (test.equals("Test1")) {
            theDrivenCar.position = new Point(0, 150);
            car.position = new Point(400, 150);
            car.setDirection(270);
        }
        if (test.equals("Test2")) {
            theDrivenCar.position = new Point(100, 250);
            theDrivenCar.setDirection(135);
            theDrivenCar.speed = 7;
            car.position = new Point(200, 150);
            car.setDirection(135);
        }
        if (test.equals("Test3")) {
            theDrivenCar.position = new Point(400, 150);
            theDrivenCar.setDirection(270);
            car.position = new Point(0, 150);
            car.setDirection(90);
        }

        repaint();
    }

    public Point convertPosition(Point toConvert) {
        return new Point(toConvert.x, getSize().height - toConvert.y);
    }
}
