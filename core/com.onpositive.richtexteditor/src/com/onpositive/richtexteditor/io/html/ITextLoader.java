package com.onpositive.richtexteditor.io.html;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import com.onpositive.richtexteditor.model.ISimpleRichTextModel;

/**
 * @author kor
 * Basic interface of Text loader
 */
public interface ITextLoader
{
	/**
	 * Wraps parse process
	 * @param text String with html content to parse
	 * @return ISimpleRichTextModel
	 */
	ISimpleRichTextModel parse(String text);
	
	/**
	 * Wraps parse process
	 * @param reader Contents reader
	 * @return ISimpleRichTextModel
	 * @throws IOException in case of reading error
	 */
	ISimpleRichTextModel parse(Reader reader) throws IOException;
	
	/**
	 * Wraps parse process
	 * @param stream Contents input stream
	 * @return ISimpleRichTextModel
	 * @throws IOException in case of reading error
	 */
	ISimpleRichTextModel parse(InputStream stream) throws IOException;
}
