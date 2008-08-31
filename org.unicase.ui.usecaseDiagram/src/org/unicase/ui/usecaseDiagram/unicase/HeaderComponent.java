/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.unicase.ui.usecaseDiagram.unicase;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * Create the header figure of the Component. The header will contain a centered label with the text
 * "&lt;&lt;component&gt;&gt;" and a component icon displayed in the right hand corner of the component figure.
 * 
 * Creation 21 juil. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class HeaderComponent extends Figure
{
    /**
     * Constructor
     */
    public HeaderComponent()
    {
        setLayoutManager(new StackLayout());

        add(new WrappingLabel("<<component>>"));

        IFigure iconContainer = new Figure();
        iconContainer.setLayoutManager(new BorderLayout());
        IFigure componentIcon = new ComponentIcon();
        componentIcon.setSize(20, 22);
        iconContainer.add(componentIcon, new Integer(PositionConstants.RIGHT));
        add(iconContainer);
    }

}
