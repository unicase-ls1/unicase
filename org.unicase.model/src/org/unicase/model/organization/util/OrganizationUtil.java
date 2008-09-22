/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */
package org.unicase.model.organization.util;

import java.util.ArrayList;
import java.util.List;

import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
/**
 * Util class for the organization Package.
 * @author helming
 *
 */
public class OrganizationUtil {
/**
 * Get the team of a user.
 * @param user The user
 * @return A List of all users which are in any group together with the user and of the groups he is member of and conatining himself.
 */
	public static List<OrgUnit> getTeam(User user){
		List<OrgUnit> ret = new  ArrayList<OrgUnit>();
		
		return ret;
		
	}
}
