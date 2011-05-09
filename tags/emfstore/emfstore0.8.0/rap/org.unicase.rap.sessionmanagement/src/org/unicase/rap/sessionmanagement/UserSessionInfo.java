/**
 * 
 */
package org.unicase.rap.sessionmanagement;

import org.eclipse.rwt.SessionSingletonBase;

/**
 * @author stefan
 *
 */
public class UserSessionInfo {
	
	private String username;
	
	private static UserSessionInfo userSessionInfo;
	
	public static UserSessionInfo getInstance() {
		if(userSessionInfo == null) {
			userSessionInfo = (UserSessionInfo)SessionSingletonBase.getInstance(UserSessionInfo.class);
		}
		return userSessionInfo;
	}
	
	private UserSessionInfo() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
