/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmlcreator;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EObject;

/**
 * Abstract class that allows the printing of EObjects to XML. Subclasses should define the behavior how elements are
 * printed.
 * 
 * @author mharut
 */
public abstract class EMFXMLWriter {

	/**
	 * The name of the XML root element.
	 */
	private final String rootName;

	/**
	 * The {@link PrintWriter} that prints to XML.
	 */
	private final PrintWriter out;

	/**
	 * Counter for the current whitespace position. Using {@link #addWhitespace()}, one can indent the current line.
	 */
	private int whitespaceCounter;

	/**
	 * Constructor to assign the {@link #out print writer} and the {@link #rootName root's name}. Subclasses are
	 * supposed to call {@link #init()} after using this constructor.
	 * 
	 * @param out the {@link PrintWriter} that does the printing
	 * @param rootName the name of the XML root element
	 */
	public EMFXMLWriter(PrintWriter out, String rootName) {
		this.out = out;
		this.rootName = rootName;
	}

	/**
	 * This method is supposed to be called once in the constructor. It will print the XML header and the root element,
	 * including its attributes. The {@link #whitespaceCounter} is also initialized in this method.
	 * 
	 * @see #printRootAttributes()
	 */
	protected void init() {
		// header
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<!DOCTYPE " + rootName + ">");
		out.println();

		// begin: root element
		out.print("<" + rootName);
		printRootAttributes();
		out.println(">");

		// initialize white space counter
		whitespaceCounter = 2;
	}

	/**
	 * Prints all of the root element's attributes. Has to be implemented in subclasses. Can be left empty if the root
	 * doesn't have any attributes.<br>
	 * Attributes have to be printed in this way:<br>
	 * <br>
	 * <code>out.print(" attribute-name=\"attribute-value\"");</code><br>
	 * <br>
	 */
	protected abstract void printRootAttributes();

	/**
	 * Prints an {@link EObject} to XML. The specific behavior of how this EObject is printed has to be specified in
	 * subclasses.
	 * 
	 * @param eObject the EObject to print to XML
	 */
	public abstract void print(EObject eObject);

	/**
	 * Adds whitespace to the front of a line using {@link #whitespaceCounter}. This can be used by subclasses to
	 * correctly indent the printing.
	 */
	protected void addWhitespace() {
		for (int i = 0; i < whitespaceCounter; i++) {
			out.print(" ");
		}
	}

	/**
	 * Escapes all characters that mustn't appear in XML like <code>'&lt'</code> or <code>'&gt'</code>.
	 * 
	 * @param string The string in which forbidden characters shall be escaped
	 * @return a new string object that doesn't contain any forbidden characters
	 */
	protected String escape(String string) {
		// don't change the original string
		String result = new String(string);
		return result.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
			.replaceAll("\"", "&quot;").replaceAll("\'", "&apos;");
	}

	/**
	 * Finishes the printing and closes the {@link PrintWriter}. This has to be called to finish the printing process.
	 * 
	 * @see PrintWriter#close()
	 */
	public void close() {
		out.println("</" + rootName + ">");
		out.close();
	}

	/**
	 * Prints a {@link String} using the {@link PrintWriter}.
	 * 
	 * @see PrintWriter#print(String)
	 * @param string the String to print
	 */
	protected void print(String string) {
		out.print(string);
	}

	/**
	 * Prints a {@link String} using the {@link PrintWriter} and terminates the line.
	 * 
	 * @see PrintWriter#println(String)
	 * @param string the String to print
	 */
	protected void println(String string) {
		out.println(string);
	}

	/**
	 * Increases the whitespace counter by two. Should be used whenever new children are added to an XML-element.
	 */
	protected void increaseWhitespaceCounter() {
		whitespaceCounter += 2;
	}

	/**
	 * Decreases the whitespace counter by two. Should be used whenever the listing of children of an XML-element is
	 * finished.
	 */
	protected void decreaseWhitespaceCounter() {
		whitespaceCounter -= 2;
	}

}
