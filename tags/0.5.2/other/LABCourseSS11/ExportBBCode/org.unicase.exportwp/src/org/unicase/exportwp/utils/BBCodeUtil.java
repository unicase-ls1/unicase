package org.unicase.exportwp.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.unicase.model.UnicaseModelElement;

/**
 * Help class for the writing in BBCode format.
 * @author Carmen Carlan
 *
 */
public class BBCodeUtil {
	
	public String string;
	
	/**
	 * Constructor.
	 * @param string
	 */
	public BBCodeUtil(String string){
		this.string = string;
	}
	
	/**
	 * Writes a given date into a personalized format.
	 * @param date
	 * @return
	 */
	public static String dateFormat (Date date){
		final String DATE_FORMAT_NOW = "MM-dd-yyyy, HH:mm";
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    return sdf.format(calendar.getTime());
	}
	
	/**
	 * Adds a given string to the big string.
	 * @param writeString
	 * @return
	 */
	public String writeInString (String writeString){
		string = string + writeString;
		return string;
	}
	
	/**
	 * Adds a new line in the big string.
	 * @return
	 */
	public String newlineString (){
		string = string + "\n";
		return string;
	}
	
	/**
	 * Writes a given string into the buffer.
	 * @param out
	 * @param writeString
	 * @throws IOException
	 */
	public static void writeInBuffer (BufferedWriter out, String writeString) throws IOException{
		out.write(writeString);
	}
	
	/**
	 * Adds a new line into the buffer.
	 * @param out
	 * @throws IOException
	 */
	public static void newlineBuffer (BufferedWriter out) throws IOException{
		out.newLine();
	}
	
	/**
	 * Formats the text, giving it a certain font color.
	 * @param string
	 * @param color
	 * @return
	 */
	public String fontColor (String string, String color){
		return "[color="+color+"]" + string + "[/color]";
		
	}
	
	/**
	 * Formats the text, making it bold.
	 * @param string
	 * @return
	 */
	public static String bold (String string){
		string = "[b]"+string+"[/b]";
		return string;
	}
	
	/**
	 * Formats the text, making it italic.
	 * @param string
	 * @return
	 */
	public static String italic (String string){
		string = "[i]"+string+"[/i]";
		return string;
	}
	
	
	/**
	 * Formats the text, giving it a certain size.
	 * @param string
	 * @param size
	 * @return
	 */
	public static String size (String string, int size){
		return "[size="+size+"]"+string+"[/size]";
	}
	
	/**
	 * Writes not defined with bold and red font color.
	 * @return
	 */
	public static String notDefined (){
		return "[b][color=red]<not defined>[/color][/b]";
	}
	
	/**
	 *  Creates a cell in a table.
	 * @param string
	 * @return
	 */
	public static String createCellInTable (String string){
		return "[td]"+string+"[/td]";
	}
	
	/**
	 * Creates a cell in a table with a given background color.
	 * @param string
	 * @param color
	 * @return
	 */
	public static String createColoredCellInTable (String string, String color){
		return "[td1 bgcolor="+color+"]"+string+"[/td1]";
	}
	
	public static String getProjectName(UnicaseModelElement ume) {

		// get eobject of project and convert it to string
		String project = ume.getProject().eContainer().toString();

		// defining pattern
		Pattern pattern = Pattern
				.compile("(\\bprojectName\\b)(.*?)(\\bprojectDescription\\b)");
		Matcher match = pattern.matcher(project);
		List<String> matches = new ArrayList<String>();
		match.find();
		matches.add(match.group(2));

		// get first match which is only match in our case
		String projectName = matches.get(0);

		projectName = projectName.replace(':', ' ');
		projectName = projectName.replace(',', ' ');
		projectName = projectName.trim();

		return projectName;
	}

}
