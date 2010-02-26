package org.unicase.ui.web.views;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.ui.part.ViewPart;

public abstract class AbstractView extends ViewPart {

	protected HttpServletRequest httpRequest;
	
	public abstract String getId();
	
	public abstract void init();
	
	public void setHttpRequest(HttpServletRequest request) {
		httpRequest = request;
		init();
	}
	
	protected HttpServletRequest getHttpRequest() {
		return httpRequest;
	}
}
