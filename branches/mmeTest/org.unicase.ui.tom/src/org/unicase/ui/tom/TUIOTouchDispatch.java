package org.unicase.ui.tom;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.unicase.ui.tom.touches.TUIOTouch;
import org.unicase.ui.tom.touches.Touch;
import org.unicase.ui.tum.tuio.TuioClient;
import org.unicase.ui.tum.tuio.TuioCursor;
import org.unicase.ui.tum.tuio.TuioListener;
import org.unicase.ui.tum.tuio.TuioObject;

public class TUIOTouchDispatch extends TouchDispatch implements TuioListener{

	Map<TuioCursor, Touch> touchMap;
	
	private TUIOTouchDispatch() {
		super();
		
		TuioClient client = new TuioClient();
		client.addTuioListener(this);
		client.connect();
		
		touchMap = new Hashtable<TuioCursor, Touch>();
	}

	public void addTuioCursor(TuioCursor tuioCursor) {
		
		TUIOTouch touch = new TUIOTouch(tuioCursor);
		
		System.out.println("x: " + touch.getX() + "y: " + touch.getY());
		addTouch(touch);
		touchMap.put(tuioCursor, touch);
	}

	public void refresh(long timestamp) {
		
	}

	public void removeTuioCursor(TuioCursor tuioCursor) {		
		Touch touch = touchMap.get(tuioCursor);
		touch.setTouchUpDate(new Date(tuioCursor.getUpdateTime()));
		
		removeTouch(touch);
		
		touchMap.remove(tuioCursor);
	}

	public void updateTuioCursor(TuioCursor tuioCursor) {
		Touch touch = touchMap.get(tuioCursor);
		updateTouch(touch);
	}

	public void updateTuioObject(TuioObject tuioObject) {
		//don't do anything
	}

	public void addTuioObject(TuioObject tuioObject) {
		//don't do anything
	}

	public void removeTuioObject(TuioObject tuioObject) {
		//don't do anything
	}

	public static TouchDispatch getInstance() {
		if (instance == null) {
			instance = new TUIOTouchDispatch();
		}
		return instance;
	}	
}
