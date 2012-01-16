/**
 * CarListElement.java
 *
 * @author Created by Omnicore CodeGuide
 */

package de.tum.in.oose.bumpers.control;

import java.util.Date;

import de.tum.in.oose.bumpers.cars.Car;

public class CarListElement
{
	
	public CarListElement (Car c, CarListElement n){
		car = c;
		next = n;
		for(int i = 0; i < hits.length; i++)
			hits[i] = false;
		lastHit = new Date();
	}
	
	private Car car;
	private CarListElement next;
	
	// Hier leg ich ab wann das Auto zuletzt getroffen wurde
	private Date lastHit;
	
	/*
	 * Im Array hits[] wird gespeichert wo das Auto getroffen wurde
	 * Front = hits[0]
	 * Heck = hits[1]
	 *
	 */
	
	private boolean[] hits = new boolean[2];
	
	public Car getCar(){
		return car;
	}
	
	public void setCar(Car c){
		car = c;
	}
	
	public void setHit(int index){
		checkStateOfCar();
		hits[index] = true;
		lastHit = new Date();
	}
	
	public boolean[] getHits(){
		checkStateOfCar();
		return hits;
	}
	
	public Date getLastHit(){
		return lastHit;
	}
	
	public CarListElement getNext(){
		return next;
	}
	
	public void setNext(CarListElement n){
		next = n;
	}
	
	/*
	 * Sind seit dem letzten Crash mit diesem Auto mehr als 20 Sek
	 * vergangen, ist die Karre wieder fit und muss erneut getroffen werden
	 */
	
	private void checkStateOfCar(){
		Date temp = new Date();
		if(temp.getTime() - lastHit.getTime() >= 20000){
			for(int i = 0; i < hits.length; i++)
				hits[i] = false;
		}
	}
}
