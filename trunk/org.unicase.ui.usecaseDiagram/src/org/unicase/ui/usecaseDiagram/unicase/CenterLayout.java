/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.unicase.ui.usecaseDiagram.unicase;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class CenterLayout extends StackLayout {
		
	Rectangle clientRect=null;
	public CenterLayout(Rectangle clientRect){
		this.clientRect=clientRect;
	}
	public CenterLayout(){
		super();		
	}
	public void layout(IFigure container)
    {   
		if(clientRect==null){
			clientRect=container.getClientArea();
		}
        List children = container.getChildren();
        IFigure child;
        for (int i = 0; i < children.size(); i++)
        {
            child = (IFigure) children.get(i);
            
            // Initialize with r dimension
            Dimension size = child.getPreferredSize(clientRect.width, clientRect.height);

            int x = Math.max(clientRect.x, clientRect.x + clientRect.width / 2 - size.width / 2);
            int y = Math.max(clientRect.y, clientRect.y + clientRect.height / 2 - size.height / 2);
            int width = Math.min(clientRect.width, size.width);
            int height = Math.min(clientRect.height, size.height);            

            child.setBounds(new Rectangle(x, y, width, height));
        }
    }	
}
