**The UI test plugins introduced in this wikipage are no longer compatible to the latest unicase plugins.**

We have number of UI test cases to evaluate the run-time behavior of the system on the functional requirement.

### Environment ###

  * Eclipse
  * Any OS, preferably Mac.

### Requirement: ###

  * You will need [SWTBOT](http://www.eclipse.org/swtbot/downloads.php) for UI Testing.
    1. SWTBot for swt Testing.
    1. SWTBot for eclipse Testing.

  * The Test-plugin**(org.unicase.ui.test)** itself, which you can checkout from the repository along with the other plugin **(org.unicase.workspace.test)** on which the "Test-plugin" is dependent.
  * All the core plugins from the trunk or branch of the UNICASE repository.

### Testing ###
<br>
<ul><li>Once the environment for testing is set, you can just run any of the test-packages( like for meeditor, attachments etc.) in debug mode as "SWTBot Test" or the whole test-suite the very same way.<br>
<br></li></ul>

<b>IMPORTANT NOTE:</b> Some or Most of the test cases are based on widgets active currently, so if you move the focus to any other eclipse instance or any other running application, the test-cases may/will fail.<br>
<br>
<b>NOTE:</b> You will have to change the default keyboard layout to "U.S. English" in order for some test cases to run correctly, as some of the test cases are meant to simulate keyboard typing in the "Richtext editor".<br>
<br>
<b>NOTE:</b> The Test-plugin and the additional plugin is available at <a href='http://unicase.googlecode.com/svn/trunk/test/'>UNICASE SVN repository</a>.