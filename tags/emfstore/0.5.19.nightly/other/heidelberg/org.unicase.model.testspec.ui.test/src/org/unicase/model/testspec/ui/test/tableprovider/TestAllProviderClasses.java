package org.unicase.model.testspec.ui.test.tableprovider;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { TestTestStepParameterTableContentProvider.class,
        TestTestStepParameterTableLabelProvider.class,
        TestTestStepTreeContentProvider.class,
        TestTestStepTreeLabelProvider.class })
public class TestAllProviderClasses {
}
