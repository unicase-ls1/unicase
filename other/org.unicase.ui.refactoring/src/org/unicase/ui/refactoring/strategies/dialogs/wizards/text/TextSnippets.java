/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.text;

/**
 * @author pfeifferc
 */
public final class TextSnippets {

	private TextSnippets() {
	}

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE1INFORMATION = "The action item specified above resembles a functional requirement, "
		+ "however it is not annotated. It might be that the action item is a "
		+ "functional requirement itself, and should be refactored appropriately. "
		+ "If not, it should at least be annotated with an existing or a new functional requirement.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE1INSTRUCTION = "Please specify the information "
		+ "needed to create the functional requirement originally embodied in the action item.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE2INFORMATION = "As the action item contains a functional requirement, this step will guide you "
		+ "through a refactoring which will offer you the creation of new action items belonging "
		+ "to the functional requirement, thereby splitting the action item into tasks that "
		+ "conform to the requirement.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE2INSTRUCTION = "Please enter the details for the new functional requirement to be created.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE3INFORMATION = "You may now choose to create new action items and reference existing ones. "
		+ "The chosen action items annotate the new functional requirement."
		+ "The following page will then allow you to edit the newly created action items.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE3INSTRUCTION1 = "Please enter the names of the new action items that are to be created or linked.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE4INFORMATION = "As the action item contains a functional requirement, this step will guide you "
		+ "through a refactoring which will offer you the creation of new action items belonging "
		+ "to the functional requirement, thereby splitting the action item into tasks that "
		+ "conform to the requirement.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE4INSTRUCTION = "Please edit the action items.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE5INFORMATION = "The refactoring is almost finished. This step offers you the possiblity to "
		+ "review your choices. When you are finished, you may trigger the creation of "
		+ "the new functional requirement and action items.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE5INSTRUCTION = "Please observe that once started, the creation process can not be interrupted.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE6INFORMATION = "The creation process is taking place.";

	/**
	 * Text.
	 */
	public static final String AIEMBODIESFRPAGE6INSTRUCTION = "Please do not close the wizard or try to interrupt it.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE1INFORMATION = "The model element specified above has a long and complex comment thread, "
		+ "therefore it might be necessary to turn the discussion into an issue. An issue is the "
		+ "more appropriate forum for all kinds of things that need to be discussed and where "
		+ "eventually a conclusion has to be reached.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE1INSTRUCTION = "Please review the discussion thread before continuing.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE2INFORMATION = "This step will give you the opportunity to choose, "
		+ "at which point the thread turned into an issue. By choosing the parents, all the child "
		+ "comments will be part of the new issue at top level and removed from the current thread. "
		+ "Please observe that selecting a parent, which itself has another parent you selected, "
		+ "means that a split will happen, and both selections will afterwards be top level comments.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE2INSTRUCTION = "Please choose the parent element(s).";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE3INFORMATION = "The comment thread that will be split "
		+ "and moved needs a new issue. You may now specfiy a new issue, to which the comments will " + "be moved.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE3INSTRUCTION = "Please specify the details needed for the new issue.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE4INFORMATION = "The refactoring is almost finished. This step offers you the possiblity to "
		+ "review your choices. When you are finished, you may trigger the creation of "
		+ "the new issue and the move of the comments to the new issue.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE4INSTRUCTION = "Please observe that once started, the process can not be interrupted.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE5INFORMATION = "The creation process is taking place.";

	/**
	 * Text.
	 */
	public static final String DISCUSSIONINTOISSUE5INSTRUCTION = "Please do not close the wizard or try to interrupt it.";

}