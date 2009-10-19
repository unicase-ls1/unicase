package com.onpositive.richtexteditor.io;

/**
 * 
 * @author 32kda
 * LexEvent with String and type of event
 */
public class TypedLexEvent extends LexEvent
{
	protected int type;
	
	/**
	 * @return tag type constant
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * @param type tag type constant to set
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	
	
	/**
	 * Constructor
	 * @param l lex word
	 * @param type tag type constant
	 */
	public TypedLexEvent(String l, int type)
	{
		super(l);
		this.type = type;
	}
	

}
