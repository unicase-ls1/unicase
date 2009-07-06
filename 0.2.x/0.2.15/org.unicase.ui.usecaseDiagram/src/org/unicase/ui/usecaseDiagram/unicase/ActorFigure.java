package org.unicase.ui.usecaseDiagram.unicase;

/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *   Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware Technologies),
 *   Nicolas Lalevée (Anyware Technologies) - initial API and implementation 
 ******************************************************************************/

import org.eclipse.draw2d.IFigure;


public class ActorFigure extends GraphicWithLabelFigure
{

    public ActorFigure()
    {
        super();
    }

    /**
     * The label is a composed label
     * 
     * @see org.topcased.draw2d.figures.GraphicWithBottomLabelFigure#createLabel()
     */
    protected ILabel createLabel()
    {
        return new Label("Actora");
    }
    
    /**
     * @see org.topcased.draw2d.figures.GraphicWithBottomLabelFigure#createBody()
     */
    protected IFigure createBodyFigure()
    {
        return new StickMan();
    }

}
