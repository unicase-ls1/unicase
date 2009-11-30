/*******************************************************************************
* Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.io.html;

import com.onpositive.richtexteditor.io.TextSerializer;
import com.onpositive.richtexteditor.model.LayerManager;

/**
 * @author kor
 * Factory for HTML serializers
 */
public interface IHTMLSerializerFactory {

	/**
	 * @param manager
	 * @return new instance of serializer
	 */
	TextSerializer getNewSerializer(LayerManager manager);
}
