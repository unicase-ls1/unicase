/**
 * CarList.java
 *
 * @author Created by Omnicore CodeGuide
 */

package de.tum.in.oose.bumpers.control;

import de.tum.in.oose.bumpers.cars.Car;

public class CarList
{
	
	public CarList(CarListElement e){
		elements = e;
	}
	
	public CarList(){
		elements = null;
	}
	
	private CarListElement elements;
	
	/*
	 * Autos werden einfach am Anfang in die Liste eingefuegt
	 */
	
	public void insertCar(Car c){
		elements = new CarListElement(c, elements);
	}
	
	public boolean isEmpty(){
		return elements == null;
	}
	
	public CarListElement findCar(Car c){
		CarListElement current = elements;
		while(current != null && current.getCar() != c){
			current = current.getNext();
		}
		return current;
	}
		
}
