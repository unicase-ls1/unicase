package org.unicase.rap.ui.views;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.rwt.RWT;
import org.eclipse.ui.part.ViewPart;

public abstract class AbstractView extends ViewPart {

	protected HttpServletRequest httpRequest;
	
	public abstract String getId();
	
	public abstract void init();
	
	public AbstractView() {
		setHttpRequest(RWT.getRequest());
	}
	
	public void setHttpRequest(HttpServletRequest request) {
		httpRequest = request;
		init();
	}
	
	protected HttpServletRequest getHttpRequest() {
		return httpRequest;
	}
}
