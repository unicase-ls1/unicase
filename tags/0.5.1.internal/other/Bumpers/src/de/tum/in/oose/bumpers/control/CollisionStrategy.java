package de.tum.in.oose.bumpers.control;

import java.util.ArrayList;

import de.tum.in.oose.bumpers.cars.Car;

public abstract class CollisionStrategy {

    private static ArrayList<Object> STRATEGIES = null;

    /**
     * The method detects if the two given cars collide and returns the crashed
     * car. If they do not collide null is returned.
     * 
     * @param drivenCar
     *            The driven car for collision detection.
     * @param roboCar
     *            The robot car for collision detection.
     * 
     * @return The crashed car, if a collision was detected. Otherwise null.
     * 
     */
    public abstract Car detectCollision(Car drivenCar, Car roboCar);

    /**
     * Returns the name of the collision strategy.
     * 
     * @return The name of the collision strategy.
     * 
     */
    public abstract String getName();

    public String toString() {
        return getName();
    }

    public static ArrayList<Object> getSTRATEGIES() {
        if (STRATEGIES == null) {
            STRATEGIES = RTSI.find(CollisionStrategy.class.getPackage()
                    .getName(), CollisionStrategy.class.getName());
        }
        return STRATEGIES;
    }
}
