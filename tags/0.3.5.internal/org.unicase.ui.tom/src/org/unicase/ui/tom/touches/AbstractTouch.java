package org.unicase.ui.tom.touches;

import java.util.Date;
import java.util.List;

public abstract class AbstractTouch implements Touch{

	private Date touchUpDate;
	private Date touchDownDate;
	
	private Object touchedObject;
	private List<Object> closeObjects;
	
	public AbstractTouch() {
	}
	
	public abstract void update();
	

	public void setCloseObjects(List<Object> closeObjects) {
		this.closeObjects = closeObjects;
	}


	public List<Object> getCloseObjects() {
		return closeObjects;
	}


	public void setTouchedObject(Object touchedObject) {
		this.touchedObject = touchedObject;
	}


	public Object getTouchedObject() {
		return touchedObject;
	}

	public void setTouchUpDate(Date touchUpDate) {
		this.touchUpDate = touchUpDate;
	}

	public Date getTouchUpDate() {
		return touchUpDate;
	}

	public void setTouchDownDate(Date touchDownDate) {
		this.touchDownDate = touchDownDate;
	}

	public Date getTouchDownDate() {
		return touchDownDate;
	}
	
	public Touch findClosestNeighbor(Touch firstTouch, Touch secondTouch) {
		double distance1 = getPosition().getDistance(firstTouch.getPosition());
		double distance2 = getPosition().getDistance(secondTouch.getPosition());
		
		return ((distance1 < distance2) ? firstTouch : secondTouch);
	}
	
	public long getLifeSpan(){
		long downTime = getTouchDownDate().getTime();
		long upTime = getTouchUpDate().getTime();
		
		return upTime - downTime;
	}

}
