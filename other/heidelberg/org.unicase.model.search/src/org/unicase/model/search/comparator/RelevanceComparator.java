package org.unicase.model.search.comparator;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.UnicaseModelElement;

/**
 * Compares two EObjects for the relevance of their name and description attribute 
 * for a given search term.
 * @author Markus Fischer
 *
 */
public class RelevanceComparator implements Comparator<EObject> {
	
	private static final int NOT_RELEVANT = 0;
	private static final int MEDIUM_RELEVANT = 25;
	private static final int VERY_RELEVANT = 100;
	private static final int EXACT_MATCH = 400;
	private static final int MULTIPLIER_TITLE = 2;
	private static final int MULTIPLIER_DESCRIPTION = 1;

	private String searchTerm;
	
	/**
	 * Creates a new comparator.
	 * @param searchTerm needed for the computation of the relevance.
	 */
	public RelevanceComparator(String searchTerm) {
		this.searchTerm = searchTerm.toUpperCase();
	}
	
	@Override
	public int compare(EObject o1, EObject o2) {
		UnicaseModelElement element1 = (UnicaseModelElement) o1;
		UnicaseModelElement element2 = (UnicaseModelElement) o2;
			
		int score1Title = computeScore(element1.getName());
		int score1Description = computeScore(element1.getDescription());
		
		int score2Title = computeScore(element2.getName());
		int score2Description = computeScore(element2.getDescription());
		
		int score1 = MULTIPLIER_TITLE * score1Title + MULTIPLIER_DESCRIPTION * score1Description;
		int score2 = MULTIPLIER_TITLE * score2Title + MULTIPLIER_DESCRIPTION * score2Description;
		
		if (score1 > score2) {
			return -1;
		} else if (score1 < score2) {
			return 1;
		}
		return 0;
		
	}
	
	/**
	 * Computes the relevance score for a given text by using the search term of the comparator.
	 * An exact match (= complete text is equal to the search term) reaches the highest score 
	 * following by a word match and a match as part of any words of the text. If there are multiple 
	 * matches for the given text the score will also rise.
	 * @param text the text to compute the score for.
	 * @return the score for this text.
	 */
	private int computeScore(String text) {
		if (text == null || text.length() == 0) {
			return 0;
		}
		int score = NOT_RELEVANT;
		
		Matcher matcher = Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE).matcher(text);
		
		while (matcher.find()) {
			String beforeChar = null;
			String afterChar = null;
			
			if (matcher.start() != 0) {
				beforeChar = text.substring(matcher.start() - 1, matcher.start());
			}
			if (text.length() > matcher.end() + 1) {
				afterChar = text.substring(matcher.end(), matcher.end() + 1);
			}
			
			if (beforeChar != null && afterChar != null) {
				if (beforeChar.matches("[\\s|\\p{Punct}]|\"|'") && afterChar.matches("[\\s|\\p{Punct}]|\"|'")) {
					score += VERY_RELEVANT;
				} else {
					score += MEDIUM_RELEVANT;
				}
			} else if (beforeChar == null && afterChar != null) {
				if (afterChar.matches("[\\s|\\p{Punct}]")) {
					score += VERY_RELEVANT;
				} else {
					score += MEDIUM_RELEVANT;
				}
			} else if (afterChar == null && beforeChar != null) {
				if (beforeChar.matches("[\\s|\\p{Punct}]")) {
					score += VERY_RELEVANT;
				} else {
					score += MEDIUM_RELEVANT;
				}
			} else {
				// both chars are null => exact match
				score += EXACT_MATCH;
			}
		}
		
		return score;
	}
	
	

}
