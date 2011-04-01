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

import org.eclipse.emf.ecp.common.util.ExtProgramFactoryFacade;
import org.eclipse.swt.program.Program;

/**
 * @author stefan.bleibinhaus
 *
 */
public class ExtProgramFactoryFacadeImpl extends ExtProgramFactoryFacade{

	@Override
	boolean useEmailIntern(String mailto) {
		return launch(mailto);
	}

	@Override
	boolean launchURLIntern(String url) {
		return launch(url);
	}
	
	private boolean launch(String url) {
		return Program.launch(url);
	}

}
