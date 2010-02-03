package org.unicase.ui.tum.tuio;


public class TuioPoint{
	
	public static final int TUIO_UNDEFINED = -1;
	protected long timestamp;
	
	protected float xpos, ypos;
	
	public TuioPoint(float xpos, float ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
		timestamp = TUIO_UNDEFINED;
	}

	public TuioPoint(TuioPoint tuioPoint) {
		this.xpos = tuioPoint.getX();
		this.ypos = tuioPoint.getY();
		timestamp = TUIO_UNDEFINED;
	}
	
	public void update(float xpos, float ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
		timestamp = TUIO_UNDEFINED;
	}

	public void update(TuioPoint tuioPoint) {
		this.xpos = tuioPoint.getX();
		this.ypos = tuioPoint.getY();
		timestamp = TUIO_UNDEFINED;
	}
	
	public float getX() {
		return xpos;
	}
	
	public float getY() {
		return ypos;
	}
	
	public float getDistance(float x, float y) {
		float dx = xpos-x;
		float dy = ypos-y;
		return (float)Math.sqrt(dx*dx+dy*dy);
	}

	public float getDistance(TuioPoint tuioPoint) {
		float dx = xpos-tuioPoint.getX();
		float dy = ypos-tuioPoint.getY();
		return (float)Math.sqrt(dx*dx+dy*dy);
	}

	public float getAngle(TuioPoint tuioPoint) {
		
		float side = tuioPoint.getX()-xpos;
		float height = tuioPoint.getY()-ypos;
		float distance = tuioPoint.getDistance(xpos,ypos);
		
		float angle = (float)(Math.asin(side/distance)+Math.PI/2);
		if (height<0) angle = 2.0f*(float)Math.PI-angle;
				
		return angle;
	}

	public float getAngleDegrees(TuioPoint tuioPoint) {
		
		return (getAngle(tuioPoint)/(float)Math.PI)*180.0f;
	}
	
	public int getScreenX(int width) {
		return (int)(xpos*width);
	}
	
	public int getScreenY(int height) {
		return (int)(ypos*height);
	}
	
	public long getUpdateTime() {
		return timestamp;
	}
	
	protected void setUpdateTime(long timestamp) {
		this.timestamp = timestamp;
	} 
}
