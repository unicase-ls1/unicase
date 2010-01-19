package org.unicase.codetrace.tracer;

import java.util.List;

public class CodeLocation {
	public List<LineHash> linesBefore;
	public List<LineHash> linesAfter;
	public String lineContent;
	public String projectName;
	public String pathInProject;
}
