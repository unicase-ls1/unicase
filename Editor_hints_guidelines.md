The formal definition: In general document hints are EAnnotations to the features of a ModelElement that specify the preferred position, priority etc. at which the feature should be displayed in the MEEditor. <br>

<i>A bit clearer:</i> Let's say you want to display the "severity" of the BugReports right after the "description". To do this, you add an EAnnotation in the UNICASE model:<br>
<br>
<br>


<img src='http://unicase.googlecode.com/files/06685.png' />

<br>
<br>

<b><i>The EAnnotation has the following properties:</i></b>

<ul><li>source: org.unicase.ui.meeditor<br>
</li><li>key: priority, value: double value from 0 to 100<br>
</li><li>key: position, value: left, right, bottom, <code>&lt;custom&gt;</code>
</li><li>key: digits, value: int value (only valid for double)</li></ul>

<h2>Digits</h2>
<blockquote>The key "digits" is only valid for attributes of type EDouble and specifies the amount of fractional digits that should be displayed after the separator sign.<br>
<h2>Position</h2>
The key "position" controls in which part of the editor this feature should appear - the left column, the right column or the bottom. You can also specify a custom text, in which case the feature would be displayed in a stand-alone tab with this name.<br>
<h2>Priority</h2>
The key "priority" is a bit tricky and there are a couple guidelines to set this up. The BugReport example is actually most suitable for this, because it has a number of super types - WorkItem, Checkable, ModelElement.<br></blockquote>


<blockquote>As previously mentioned, the priority field should contain a double value from 0.0 to 100.0 (0.0 being the highest priority). Usually if a super type is present, its features are important and should have higher priority that the ones from a subclass. Therefore, the "priority line" is split into intervals of 10 - 0.0 to 10.0, 10.1 to 20.0, .... 90.0 to 100.0 - and every type (from the top down) lies in a specific interval. In the example of the BugReport, the type hierarchy is as follows:<br></blockquote>

<ul><li>ModelElement -> WorkItem -> BugReport (the Checkable type is excluded, as it does not provide us with a visible/editable features).<br>
<br>
</li><li>The ModelElement lies in the interval from (0.0;10.0), WorkItem - (10.1;20.0), BugReport - (20.1;30.0);</li></ul>

<hr />
<h2><b><i>A quick look at the model so far:</i></b></h2>

<b>ModelElement:</b>
<blockquote><img src='http://unicase.googlecode.com/files/1.png' /></blockquote>

<b>WorkItem:</b>

<blockquote><img src='http://unicase.googlecode.com/files/2.png' /></blockquote>

<b>BugReport</b>

<blockquote><img src='http://unicase.googlecode.com/files/3.png' /></blockquote>



<i>(For the sake of time and simplicity, only the left column features are shown)</i>

The current order of these features would be: <br>
<i><b>Name, Description, Containing Workpackage, Assignee, Due Date, Status, Resolution, Resolution Type.</b></i>
<br>
<br>

However, we do want to put the "severity" feature right after "description". Since it is an exception to the rule, it should be placed in the interval where "description" lies in - (0.0;10.0). We can give it a priority 2.0, but since we are not aware of future changes on the model (in which further features may be added to the super type - in this case ModelElement), we give it a priority in the interval (9.0;10.0) - i.e. "the exceptions interval":<br>
<br>
<blockquote><img src='http://unicase.googlecode.com/files/4.png' /></blockquote>



You probably noticed that Name and Description have the same priority - by doing so, you can explicitly specify that these two should not be taken apart and should always be displayed next to each other. As in the case of the rest - you can always define an exception with a value X.5 and put it between X.0 and (X+1).0.<br>
<br>

And once again, for those who fell asleep in all this:<br>
Going through the type hierarchy of the model (from the top down), every type is given a specific interval - starting at (0.0;10.0). If you want to put two elements together and keep it that way - you can specify an equal priority. If you want to define an exception in the hierarchy order of the features - you can put the feature in question in the "exception subinterval" of a former interval (e.g. for (10.1;20.0) this should be (19.1;20.0)); If you are modeling a super type and you are sure that you definitely don't want some features to be on the top - you can put them in the end by setting a priority in the interval after 100.0 (100.0;XXX.X):<br>
<br>
<br>

<blockquote><img src='http://unicase.googlecode.com/files/5.png' />