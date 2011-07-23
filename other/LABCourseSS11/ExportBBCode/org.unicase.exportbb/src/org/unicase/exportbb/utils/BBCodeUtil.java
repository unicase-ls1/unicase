package org.unicase.exportbb.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BBCodeUtil {
	
	public static String string;
	
	public BBCodeUtil(String string){
		this.string = string;
	}
	
	public static String dateFormat (Date date){
		final String DATE_FORMAT_NOW = "MM-dd-yyyy, HH:mm";
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    return sdf.format(calendar.getTime());
	}
	
	public static String writeInString (String writeString){
		string = string + writeString;
		return string;
	}
	
	public static String newlineString (){
		string = string + "\n";
		return string;
	}
	
	public static String fontColor (String string, String color){
		string = string + ("[color=#"+color+"]" + string + "[/color]");
		return string;
	}
	
	public static String bold (String string){
		string = "[b]"+string+"[/b]";
		return string;
	}
	
	public static String italic (String string){
		string = "[i]"+string+"[/i]";
		return string;
	}
	
	public static String size (String string, int size){
		return "[size="+size+"]"+string+"[/size]";
	}
	
	public static String notDefined (){
		return "[b][color=red]<not defined>[/color][/b]";
	}
	
	public static void createCellInTable (String string){
		string = "[td]"+string+"[/td]";
	}
	
	public static void createColoredCellInTable (String string, String color){
		string = "[td bgcolor="+color+"]"+string+"[/td]";
	}

}
