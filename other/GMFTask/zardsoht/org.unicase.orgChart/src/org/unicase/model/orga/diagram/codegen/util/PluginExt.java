package org.unicase.model.orga.diagram.codegen.util;

import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class PluginExt {

	@Operation(contextual = false, kind = Kind.HELPER)
	public static String removeSquareBarcketsJava(String value) {
		return value.replace("[", "").replace("]", "");
	}
}
