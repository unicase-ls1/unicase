# Work Item Life Cycle #
This page describes the lifecycle of a Work Item in UNICASE.
## Adding new Work Items ##
Work Items in UNICASE can be Bug Reports, Feature Requests, Issues or simply Action Items.
New Work Items can be added by every project participant. This is also the preferred way for project participants to report bugs. Please see [Reporting Bugs](ReportingBugs.md).
## Confirmation ##
Once new Work Items are confirmed to be valid and understandable the are moved in the work package "Unprioritized". Also you should make sure the work item is not a duplicate of an existing item or is in conflict with an existing work item.
This step is performed once a week.
## Triaging Work Items ##
Confirmed Work Items are triaged by the project leads. If there are decided to be postponed, they are moved to the Work Package "Postponed". If they are decided to be currently relevant, they are further triaged:

  * A priority is set (1-10), approved by both project leads
  * An estimate is set
  * All non-management Work Items are annotated to the corresponding Functional Requirement
  * For Issues and Action Items the activity is set
  * For Bug Reports the severity is checked
  * An initial suggestion for an assignee can be made _(optional)_

Once the Work Item is triaged it is moved to the Work Package "High Priority" (priority 6-10) or "Medium Priority" (priority 1-5).

This step is performed once per Sprint, one day before its end date.
## Planning Sprints ##
For every new Sprint, Work Items are selected to be worked on from the Work Package "High Priority". The decision is based on the priority and criteria like the work load of certain developer.
This step is performed once at the beginning of every sprint.

## Re-Prioritizing ##
Every two month all items for the Work Packages "High Priority", "Medium Priority" and "Postponed" are reviewed and re-prioritized.

