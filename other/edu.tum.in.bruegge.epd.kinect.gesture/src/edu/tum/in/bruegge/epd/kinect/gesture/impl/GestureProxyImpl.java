package edu.tum.in.bruegge.epd.kinect.gesture.impl;

import humanbodymodel.HumanContainer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.tum.in.bruegge.epd.kinect.KinectManager;
import edu.tum.in.bruegge.epd.kinect.gesture.Gesture;
import edu.tum.in.bruegge.epd.kinect.gesture.GestureListener;
import edu.tum.in.bruegge.epd.kinect.gesture.GestureProxy;

public class GestureProxyImpl implements GestureProxyCallback, GestureProxy{

	private static final GestureProxy INSTANCE = new GestureProxyImpl();
	
	public static GestureProxy getInstance() {
		return INSTANCE;
	}
	
	private KinectManager kinectManager=KinectManager.INSTANCE;

	private Map<Gesture, Set<GestureListener>> filteredGestureListeners = new HashMap<Gesture, Set<GestureListener>>();
	private Set<GestureListener> unfilteredGestureListeners = new HashSet<GestureListener>();

	
	@Override
	public void notifyGestureDetected(Class<? extends Gesture> gesture) {
		Set<GestureListener> listeners=new HashSet<GestureListener>(unfilteredGestureListeners);
		if(filteredGestureListeners.containsKey(gesture))
			listeners.addAll(filteredGestureListeners.get(gesture));
		for (GestureListener listener : listeners) {
			listener.notifyGestureDetected(gesture);
		}
	}

	/* (non-Javadoc)
	 * @see edu.tum.in.bruegge.epd.kinect.gesture.impl.GestureProxy#addGestureListener(edu.tum.in.bruegge.epd.kinect.gesture.GestureListener)
	 */
	@Override
	public void addGestureListener(GestureListener gestureListener) {
		if(!gestureListener.isFiltered())
			unfilteredGestureListeners.add(gestureListener);
		else{
			for(Gesture gesture:gestureListener.getGestures()){
				if(!filteredGestureListeners.containsKey(gesture)){
					filteredGestureListeners.put(gesture, new HashSet<GestureListener>());
				}
				filteredGestureListeners.get(gesture).add(gestureListener);
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.tum.in.bruegge.epd.kinect.gesture.impl.GestureProxy#removeGestureListener(edu.tum.in.bruegge.epd.kinect.gesture.GestureListener)
	 */
	@Override
	public void removeGestureListener(GestureListener gestureListener) {
		unfilteredGestureListeners.remove(gestureListener);
		if(gestureListener.isFiltered()){
			for(Gesture gesture:gestureListener.getGestures()){
				if(filteredGestureListeners.containsKey(gesture)){
					filteredGestureListeners.get(gesture).remove(gestureListener);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.tum.in.bruegge.epd.kinect.gesture.impl.GestureProxy#addGestureDetector(edu.tum.in.bruegge.epd.kinect.gesture.Gesture)
	 */
	@Override
	public void addGestureDetector(Gesture gestureDetector) {
		gestureDetector.setGestureProxy(this);
		HumanContainer humanContainer = kinectManager.getSkeletonModel();
		humanContainer.eAdapters().add(gestureDetector);
	}

	/* (non-Javadoc)
	 * @see edu.tum.in.bruegge.epd.kinect.gesture.impl.GestureProxy#removeGestureDetector(edu.tum.in.bruegge.epd.kinect.gesture.Gesture)
	 */
	@Override
	public void removeGestureDetector(Gesture gestureDetector) {
		gestureDetector.setGestureProxy(null);
		HumanContainer humanContainer = kinectManager.getSkeletonModel();
		humanContainer.eAdapters().remove(gestureDetector);
	}
	
}
