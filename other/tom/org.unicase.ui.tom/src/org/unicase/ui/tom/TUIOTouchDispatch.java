package org.unicase.ui.tom;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.TUIOTouch;
import org.unicase.ui.tum.tuio.TuioClient;
import org.unicase.ui.tum.tuio.TuioCursor;
import org.unicase.ui.tum.tuio.TuioListener;
import org.unicase.ui.tum.tuio.TuioObject;

public class TUIOTouchDispatch extends TouchDispatch implements TuioListener{

	Map<TuioCursor, SingleTouch> touchMap;
	
	private TUIOTouchDispatch() {
		super();
		
		TuioClient client = new TuioClient();
		client.addTuioListener(this);
		client.connect();
		
		touchMap = new Hashtable<TuioCursor, SingleTouch>();
	}

	public void addTuioCursor(TuioCursor tuioCursor) {
		if (getActiveEditor() == null) {
			return;
		}
		if (tuioCursor.getX() < 0
			|| tuioCursor.getY() < 0){
			//discard the cursor
		}
		
		TUIOTouch touch = new TUIOTouch(tuioCursor, getScreenSize());
		
		try {
			addTouch(touch);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		touchMap.put(tuioCursor, touch);
	}

	public void refresh(long timestamp) {
		
	}

	public void removeTuioCursor(TuioCursor tuioCursor) {		
		if (getActiveEditor() == null) {
			return;
		}
		SingleTouch touch = touchMap.get(tuioCursor);
		if (touch != null) {
			touch.setTouchUpDate(new Date(tuioCursor.getUpdateTime()));
			try {
				removeTouch(touch);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			touchMap.remove(tuioCursor);			
		}
	}

	public void updateTuioCursor(TuioCursor tuioCursor) {
		if (getActiveEditor() == null) {
			return;
		}
		SingleTouch touch = touchMap.get(tuioCursor);
		if (touch != null) {
			try {
				updateTouch(touch);	
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
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
