package org.unicase.ui.common.dnd;

public class DragSourcePlaceHolder {

	private static Object dragSource;
	private static DragSourcePlaceHolder instance;
	
	private DragSourcePlaceHolder(){
		
	}
	
	public static DragSourcePlaceHolder getInstance(){
		if(instance == null){
			instance = new DragSourcePlaceHolder();
		}
		return instance;
	}
	
	public static void setDragSource(Object dragSource){
		DragSourcePlaceHolder.dragSource = dragSource;
	}
	
	public static Object getDragSource(){
		return dragSource;
	}
	
}
