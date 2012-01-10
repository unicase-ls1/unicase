package org.unicase.model.diagram.impl;

import java.io.Serializable;

import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

public class MERelativeBendpoint extends RelativeBendpoint implements
		Serializable {

	/**
	 * Bendpoint serial ID
	 */
	private static final long serialVersionUID = -6307559151584936745L;

	public MERelativeBendpoint() {
		super();
	}

	public MERelativeBendpoint(int sourceX, int sourceY, int targetX,
			int targetY) {
		super(sourceX, sourceY, targetX, targetY);
	}

//	public MERelativeBendpoint(MEHintPoint hintPoint) {
//		super(hintPoint.getSourceX(), hintPoint.getSourceY(), hintPoint
//				.getTargetX(), hintPoint.getTargetY());
//	}

}
