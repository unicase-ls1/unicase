package com.onpositive.richtexteditor.io;

import com.onpositive.richtexteditor.io.html.DefaultHTMLLoader;
import com.onpositive.richtexteditor.io.html.HTMLSerializer;
import com.onpositive.richtexteditor.io.html.ITextLoader;
import com.onpositive.richtexteditor.model.LayerManager;


public class DefaultFormatFactory implements IFormatFactory
{
	ITextLoader loader = null;
	TextSerializer serializer = null;
	LayerManager lastLoaderManager = null, lastSerializerManager = null;
	
	public ITextLoader getLoader(LayerManager manager)
	{
		if (loader == null || lastLoaderManager != manager)
		{
			loader = new DefaultHTMLLoader(manager);
			lastLoaderManager = manager;
		}
		return loader;
	}

	public TextSerializer getSerializer(LayerManager manager)
	{
		if (serializer == null || lastSerializerManager != manager)
		{
			serializer = new HTMLSerializer(manager);
			lastSerializerManager = manager;
		}
		return serializer;
	}

}
