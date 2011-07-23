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

public class BBCodeUtil {
	
	public String string;
	
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
	
	public String writeInString (String writeString){
		string = string + writeString;
		return string;
	}
	
	public String newlineString (){
		string = string + "\n";
		return string;
	}
	
	public static void writeInBuffer (BufferedWriter out, String writeString) throws IOException{
		out.write(writeString);
	}
	
	public static void newlineBuffer (BufferedWriter out) throws IOException{
		out.newLine();
	}
	
	public String fontColor (String string, String color){
		return "[color="+color+"]" + string + "[/color]";
		
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
	
	public static String createCellInTable (String string){
		return "[td]"+string+"[/td]";
	}
	
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
