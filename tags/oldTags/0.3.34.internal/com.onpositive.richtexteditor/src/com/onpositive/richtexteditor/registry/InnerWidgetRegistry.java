package com.onpositive.richtexteditor.registry;

import java.util.HashMap;
import java.util.HashSet;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * @author 32kda
 * (c) made in USSR
 */
public class InnerWidgetRegistry
{
	protected static HashMap<Composite, InnerWidgetRegistry> registry = new HashMap<Composite, InnerWidgetRegistry>();
	
	public static InnerWidgetRegistry getInstanceFor(Composite control)
	{
		InnerWidgetRegistry innerRegistry = registry.get(control); 
		if (innerRegistry == null)
		{
			innerRegistry = new InnerWidgetRegistry(control);
			registry.put(control, innerRegistry);
		}
		return innerRegistry;
	}
	
	//------------------Static part end---------------------------------------
	
	protected Composite composite;
	protected HashSet<Control> redrawedControls; //TODO right disposal of deleted controls
	
	protected InnerWidgetRegistry(Composite composite)
	{
		this.composite = composite;
		redrawedControls = new HashSet<Control>();
	}
	
	public void addRedrawedControl(Control control)
	{
		redrawedControls.add(control);
	}
		
	public void clear()
	{
		redrawedControls.clear();
	}
	
	public boolean wasRedrawed(Control control)
	{
		if (redrawedControls.contains(control) || control.isDisposed())
			return true;
		return false;
		
	}
	
}
