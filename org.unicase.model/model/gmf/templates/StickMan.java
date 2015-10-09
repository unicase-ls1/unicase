/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.uml2.diagram.usecase.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class StickMan extends ShadowShape {
    public StickMan() {
        this(false, ColorConstants.white, ColorConstants.black);
    }

    public StickMan(boolean is3D, Color backgroundColor, Color foregroundColor) {
        super(is3D, backgroundColor, foregroundColor);
        setKeepingProportions(true);
        setW2HRatio(BASE_W / BASE_H);
    }

    protected void outlineShape( Graphics graphics, Rectangle bounds ) {
        PointList pl = setupPoints( bounds );
        graphics.drawPolygon( pl );
        int add = graphics.getLineWidth() / 2;
        graphics.drawOval( new Rectangle( ovalX, ovalY, ovalD + add, ovalD + add ) );
    }

    protected void fillShape( Graphics graphics, Rectangle bounds ) {
        PointList pl = setupPoints( bounds );
        graphics.fillPolygon( pl );
        int add = graphics.getLineWidth() / 2;
        graphics.fillOval( new Rectangle( ovalX, ovalY, ovalD + add, ovalD + add ) );
    }

    protected PointList setupPoints( Rectangle rect ) {
        int[] xPoints = new int[ P_NUM ];
        int[] yPoints = new int[ P_NUM ];

        PointList pl = new PointList( 10 );
        int W = ( rect.width / 2 ) * 2;
        int H = rect.height;
        int X1 = W / 2;
        int Y1 = ( Math.round( H * FACTOR1 ) / 2 ) * 2;
        int Y2 = Math.round( H * FACTOR2 );
        int Y3 = H - ( X1 - 1 );
        int STEP = Math.round( W / BASE_W );
        if( STEP < 1 ) {
            STEP = 1;
        }

        // set positive points. (0...9)
        xPoints[ 0 ] = STEP;
        yPoints[ 0 ] = Y1;
        xPoints[ 1 ] = STEP;
        yPoints[ 1 ] = Y2 - STEP;
        xPoints[ 2 ] = X1;
        yPoints[ 2 ] = Y2 - STEP;
        xPoints[ 3 ] = X1;
        yPoints[ 3 ] = Y2 + STEP;
        xPoints[ 4 ] = STEP;
        yPoints[ 4 ] = Y2 + STEP;
        xPoints[ 5 ] = STEP;
        yPoints[ 5 ] = Y3 - STEP;
        xPoints[ 6 ] = X1;
        yPoints[ 6 ] = H - STEP;
        xPoints[ 7 ] = X1;
        yPoints[ 7 ] = H;
        xPoints[ 8 ] = X1 - 2 * STEP;
        yPoints[ 8 ] = H;
        xPoints[ 9 ] = 0;
        yPoints[ 9 ] = Y3 + STEP;

        // reflect points 0..8
        for( int i = 0; i <= 8; i++ ) {
            xPoints[ 18 - i ] = -xPoints[ i ];
            yPoints[ 18 - i ] = yPoints[ i ];
        }

        // close polyline.
        xPoints[ 19 ] = xPoints[ 0 ];
        yPoints[ 19 ] = yPoints[ 0 ];

        // shift all points and copy to integer.
        for( int i = 0; i < P_NUM; i++ ) {
            xPoints[ i ] += X1;

            xPoints[ i ] += rect.x;
            yPoints[ i ] += rect.y;
        }

        for( int i = 0; i < xPoints.length; i++ ) {
            pl.addPoint( xPoints[ i ], yPoints[ i ] );
        }

        // head-oval
        ovalD = Y1;
        ovalX = X1 - ovalD / 2 + rect.x;
        ovalY = rect.y;

        return pl;
    }

    private static final float BASE_W = 31 - 1;
    private static final float BASE_H = 50 - 1;
    private static final float FACTOR1 = 16f / BASE_H;
    private static final float FACTOR2 = 22f / BASE_H;

    private static final int P_NUM = 20;

    private int ovalX;
    private int ovalY;
    private int ovalD;
}
