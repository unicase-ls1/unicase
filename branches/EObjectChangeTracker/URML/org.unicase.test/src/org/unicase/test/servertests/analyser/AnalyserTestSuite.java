package org.unicase.test.servertests.analyser;

import org.unicase.test.servertests.ServerTestSuite;

public class AnalyserTestSuite extends ServerTestSuite {

	@Override
	protected void initTestCases() {
		if (getLogIn() != null) {
			getTestCases().add(new AnalyserTest("Analyser Test", getLogIn()));
		}
	}

}
