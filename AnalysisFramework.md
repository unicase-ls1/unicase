This Wiki page will introduce how to use the Empirical Project Analysis Framework (EPAF), a
data analysis framework using EMFStore as data source for empirical studies.
The Empirical Project Analysis Framework (EPAF) provides
a structured way to analyze projects for different research
purposes. Iterators are used to run through all revisions
of a model in a predefined way. Analyzers analyze and
extract data per revision and exporters write the data to
files. Researchers only need to focus on the implementation
of analyzers for their research questions. Iterators and exporters
as well as building blocks for analyzers are provided. This reduces the eort for empirical studies significantly.

An example of exported results for a empirical study:

| **Version** | **Date** | **Open Tasks** |
|:------------|:---------|:---------------|
| 4  | 01.11.2008 | 7  |
| 17 | 24.11.2008 | 29 |
| 20 | 10.12.2008 | 39 |
| 27 | 21.12.2008 | 36 |
| 32 | 06.01.2009 | 40 |
| ...| ...        |... |

You can easily follow the steps below and start your own empirical studies.



## Step 1: Check out the EPAF source code ##

The EPAF source code are also in the UNICASE svn repository, under the path:
https://unicase.googlecode.com/svn/trunk/other/analyzer

Including the following plug-ins:
  * `org.unicase.analyzer`
  * `org.unicase.analyzer.edit`
  * `org.unicase.analyzer.ui`           _--UI components_
  * `org.unicase.analyzer.unicaseAnalyzers`    _--provided analyzers, example analyzers_
  * `org.unicase.analyzer.test`      _--test cases_

## Step 2: Create a new plug-in project for the empirical study ##

Don't forget to add the dependency on the `org.unicase.analyzer` plug-in. Just go to the dependency tab of the plugin.xml file of your plug-in.

## Step 3: Implement the analyzer for your empirical study ##

In EPAF, there is already a **DataAnalyzer** interface provided, which has two methods getColumnNames() and getValues(). getColumnNames() will return a list of String, i.e. the (header) names of the columns in the result sheet, e.g. Version, Date, Open Tasks in the table above. getValues() will return a list of object lists, i.e. a number of rows containing values for each column for a given project analysis data.

There are two sub abstract classes, **SimpleDataAnalyzer** and **GlobalDataAnalyzer**. For the **SimpleDataAnalyzer**, you only need to implement the method getSimpleValues() which returns only one row of values per iteration. The **GlobalDataAnalyzer** will only return one global result in the end.

Please write your own analyzer in the new plug-in by implementing **DataAnalyzer** (or extending **SimpleDataAnalyzer** or **GlobalDataAnalyzer** if needed). There are already couple of example analyzers under `org.unicase.analyzer.unicaseAnalyzers`.

## Step 4: Add the analyzer extension ##

Go to the Extensions tab of your plugin.xml file, and click **Add**. In the appearing wizard, select the `org.unicase.analyzer.analyzer ` extension-point. Right click on the extension just added, and go to "New -> client\_analyzer". Click **Browse** at the "Extension Element Details" part and choose the class name of the analyzer you just created.

## Step 5: Run your analysis ##

Start the UNICASE server and UNICASE client. Go to **EMFStore Browser** of the UNICASE client and login to the server. Make sure you have the admin authority of the project you are going to analyze. Then go to **Navigator**, you should be able to right click on the project and go to "Other... -> Analyze Project".

A wizard pops up, ask you to load the configuration. You can choose an existing one or create a new configuration profile by pressing **Browse**. Of course you can directly go to **Next** if you are not interested in creating a configuration profile.

The next wizard page asks you to choose the analyzer(s).

Then choose the project iterator type, either a Version Iterator or a Time Iterator.

The next step is to configure the iterator. Specify the range and the step length, as well as the direction of the traversal

In the end, you only need to give the file name of the results to the exporter, and click **Finish**.

Here we go, enjoy! :)