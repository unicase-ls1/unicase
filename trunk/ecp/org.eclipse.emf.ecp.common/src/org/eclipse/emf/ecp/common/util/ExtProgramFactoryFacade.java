/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.util;

/**
 * Provides the option to open URLs or send emails with an extern program.
 * 
 * @author stefan.bleibinhaus
 */
public abstract class ExtProgramFactoryFacade {
	private static final ExtProgramFactoryFacade IMPL;

	static {
		IMPL = (ExtProgramFactoryFacade) ImplementationLoader.newInstance(ExtProgramFactoryFacade.class);
	}

	/**
	 * @param mailto the mailto-message
	 * @return success as boolean
	 */
	public static boolean useEmail(String mailto) {
		return IMPL.useEmailIntern(mailto);
	}

	/**
	 * @param mailto the mailto-message
	 * @return success as boolean
	 */
	abstract boolean useEmailIntern(String mailto);

	/**
	 * @param url the url as string
	 * @return success as boolean
	 */
	abstract boolean launchURLIntern(String url);

	/**
	 * @param url the url as string
	 * @return success as boolean
	 */
	public static boolean launchURL(String url) {
		return IMPL.launchURLIntern(url);
	}
}
