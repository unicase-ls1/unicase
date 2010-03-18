package org.unicase.rap.ui.views;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.rwt.RWT;
import org.eclipse.ui.part.ViewPart;

/**
 * Abstract class for adding views to the RAP plugin.
 * Note that a contributing view needs to extend the both extension points <code>org.unicase.rap.ui.view</code>
 * AND <code>org.eclipse.ui.views</code>.
 * 
 * @author emueller
 *
 */
public abstract class AbstractView extends ViewPart {

	/**
	 * The HTTP request is needed in order to determine which information has been requested by the user.
	 */
	private HttpServletRequest httpRequest;
	
	/**
	 * Returns the ID of the view.
	 * 
	 * @return The ID of the view.
	 */
	public abstract String getId();
	
	/**
	 * Initializes a new instance of a contributing view.
	 */
	public AbstractView() {
		// Currently views will be initialized on each request. 
		// This way views can handle additional parameters needed by, e.g. project specific views.
		// This ain't the best solution but it's sufficient for now.
		httpRequest = RWT.getRequest();
	}

	/**
	 * Returns the HTTP request that has been supplied by the user.
	 * 
	 * @return The HTTP request.
	 */
	protected HttpServletRequest getHttpRequest() {
		return httpRequest;
	}
}
