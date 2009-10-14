package com.onpositive.richtexteditor.io;

import com.onpositive.richtexteditor.io.html.ITextLoader;
import com.onpositive.richtexteditor.model.LayerManager;


public interface IFormatFactory
{
	public abstract ITextLoader getLoader(LayerManager manager);
	public abstract TextSerializer getSerializer(LayerManager manager);

}
