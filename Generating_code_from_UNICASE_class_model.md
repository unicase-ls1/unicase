This documentation contains five chapter.
  1. [How to create an EMF Model Project with ecore model](#How_to_create_an_EMF_Model_Project_with_ecore_Model.md)
  1. [How to set properties in ecore model](#How_to_set_properties_in_ecore_model.md)
  1. [How to create generator model from ecore model](#How_to_create_generator_model_from_ecore_model.md)
  1. [How to set properties in generator model](#How_to_set_properties_in_generator_model.md)
  1. [How to generate model code](#How_to_generate_model_code.md)


## How to create an EMF Model Project with ecore model ##

**1.** File-> New-> Other -> **Empty EMF Project** and give a name to your project.

<br>

<img src='http://unicase.googlecode.com/files/0.Select_Empty_Emf_Project_Wizard.png' />

<br>

<b>2.</b> Open UNICASE perspective and right click on the package you want to generate ecore model from and select <b>Generate Ecore</b>. (Package from the example can be found here: Analysis and Design Document/Subsystems/Model/codeTrace)<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/2.GenerateEcoreModel.png' />

<br>

<b>3.</b>  Select model-Folder of your EMF Project and give name for your .ecore File.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/2.2.SelectModelFolder.png' />

<br>

<b>4.</b> Change to Java perspective and refresh your EMF Project. You can see your .ecore file. Double click on them to open it in Ecore Editor.<br>
<br>
<b>5.</b>In Ecore Editor right click on your package and select <b>Load Ressource</b>.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/4.Load_Source.png' />

<br>

<b>6.</b> Click on <b>Browse Workspace</b> and select <i>org.unicase.model/model/model.ecore</i>.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/5.Select_Org_Unicase_Model.png' />

<br>

<h2>How to set properties in ecore model</h2>

<b>7.</b> Go to <b>Properties</b> with double click on class of your ecore package.<br>
<br>

<img src='http://unicase.googlecode.com/files/6.Class_Properties_Select_To_Each_Class.png' />

<br>

<b>8.</b> Set to all classes <b>ESuperTypes</b> to <i>UnicaseModelELement</i>.<br>
<br>

<img src='http://unicase.googlecode.com/files/7.Add_ESuper_Type_Unicase_Model_Element.png' />

<br>


<b>9.</b> Set Name to <i>yourPackageName</i>, NS Prefix to <i>org.unicase.model.yourPackageName</i>  and NS URI <i>http://org.unicase.model.yourPackageName</i>.(spaces in names are not allowed)<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/Ecore_Model_Property.png' />

<br>

<b>10.</b> Right click on your package and select <b>Validate</b> from the context menu.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/8.Validate_Ecore_Model.png' />

<br>


If your <b>Validate</b> was successfull you have made a correct ecore model.<br>
<br>
<br>
<h2>How to create generator model from ecore model</h2>

<b>11.</b>Change to Java perspective.<br>
<br>
<b>12.</b> File-> New-> Other -> <b>EMF Generator Model</b>.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/9.Select_EmfGenerator_Model_Wizard.png' />

<br>

<b>13.</b> Select in <b>EMF Generator</b> Window the <i>model</i>-Folder from<br>
your ecore project and set name for your generator model, for example <i>yourEcoreModelName.<b>genmodel</b></i>. Filename must end with .genmodel.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/10.Create_Genmodel.png' />

<br>

<b>14.</b> Select <i>Ecore model</i> by <b>Model Importer</b> window. In next <b>Ecore Import</b> window and click on <b>Browse workspace...</b>.<br>
<br>

<img src='http://unicase.googlecode.com/files/11.Select_Model_Importer.png' />

<br>

<b>15.</b> After clicking on <b>Browse workspace</b> you must select your ecore file.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/12.Select_Your_Own_Ecore_FIle.png' />

<br>

<b>16.</b> Select as <b>Root package</b> only your own package.<br>
<br>
<br>


<img src='http://unicase.googlecode.com/files/13.Package_Selection_Before.png' />

<br>

<b>17</b> Select as <b>Referenced Generator Model</b> all packages you see there.<br>
<br>
<br>


<img src='http://unicase.googlecode.com/files/14.Package_Selection_After.png' />

<br>

<b>18.</b> Finish, your genmodel was created!<br>
<br>
<br>
<b>19.</b>Double click on your generator model (root element of the hierarchy) and you can set the properties on <b>Properties</b> View.<br>
<br>
<br>
<h2>How to set properties in generator model</h2>

<b>20.</b> Set in the <b>Properties</b> <i>All</i> -> <i>Base Package</i> to org.unicase.model and click  save.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/16.Set_Properties_All-_BasePackage.png' />

<br>

<b>21.</b> Double click on package element (child element of the hierarchy) and set in the properties following fields in this way:<br>
<br>
<ul><li>ll<br>
<ul><li><i>Compilance Level</i> - 5.0<br>
</li><li><i>Copyright Fields</i> - true<br>
</li><li><i>Copyright Text</i> - hier you should paste your copyright text</li></ul></li></ul>

<ul><li>Edit<br>
<ul><li><i>Edit Directory</i> - project_name/src</li></ul></li></ul>

<br>

<img src='http://unicase.googlecode.com/files/17.All+Edit_Properties.png' />

<br>

<ul><li>Editor<br>
<ul><li><i>Editor Directory</i> - org.unicase.modelExample/src</li></ul></li></ul>

<ul><li>Model<br>
<ul><li><i>Containment Proxies</i> - true<br>
</li><li><i>Model Directory</i> - /org.unicase.modelExample/src</li></ul></li></ul>

<br>

<img src='http://unicase.googlecode.com/files/18.Editor_and_Model_Properties.png' />

<br>

<ul><li>Template & Merge<br>
<ul><li><i>Code Formatting</i> - true</li></ul></li></ul>

<br>

<img src='http://unicase.googlecode.com/files/19.Template+Merge_Properties.png' />

<br>

<h3>How to generate model code</h3>

<b>22.</b> Generate code from generator model.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/20.Generate_Model_Code.png' />

<br>

<b>22.</b> Finish, the code is generated.<br>
<br>
<br>

<img src='http://unicase.googlecode.com/files/21.Finished_Project.png' />

<br>

Now you have all elements of your unicase model as classes.