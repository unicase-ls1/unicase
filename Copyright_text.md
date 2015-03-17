# Observed Problem #

If code is generated from an EMF Model and a copyright text is set in the genmodel then the code generator inserts a `$Id$` at the end of the copyright text.

**NOTE:** This problem has been fixed in later versions of EMF. Hence, this article is obsolete. The solution presented here should be applied when using older versions of EMF.

# Solution #

The following steps have to be taken to get rid of the `$Id$`:
  * Open the Plug-ins view (_Window -> Show View -> Other..._)
  * Right click the plug-in `org.eclipse.emf.codegen.ecore` and import it as a Binary Project
  * Open the Package Explorer view
  * Copy the templates folder from the imported project to the project where you wish to generate the EMF Code
  * In the copied templates folder open the file `Header.javajetinc` and delete the following line: _` * <%="$"%>Id<%="$"%>`_
  * Select the genmodel file you wish to generate code from
  * Select the root node in your genmodel and open the Properties view
  * Set in _Templates & Merge -> Dynamic Templates_ to true and in _Templates & Merge -> Template Directory_ to **/YOUR\_PROJECTNAME/templates** where **YOUR\_PROJECTNAME** is the name of your project
  * Set in _All -> Copyright Fields_ to false

  * Now you can generate your code as usual and there will be no `$Id$` in the copyright text

**NOTE:** Java Code that has already been generated before the above described steps were taken has to be deleted possibly because javadoc code will not be overwritten in the generation process.