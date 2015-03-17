The Scientific Computing Requirements Model (SCRM) is a tool that allows requirements modeling for scientific computing projects by making use of core features of EMF, GMF, EMFCP and EMFStore.
To use SCRM, you will first have to install the following software:

  1. Eclipse (Helios), Modeling Tools Edition
  1. GMF from this update site: http://download.eclipse.org/releases/helios (expand "Modeling" category and select" Graphical Modeling Framework (GMF) Runtime"
  1. EMFCP and EMFStore from this update site: http://unicase.googlecode.com/svn/updatesite/emfstoreNightly (release version 0.7.3. select all features from the first three categories)
  1. SCRM from this update site: http://unicase.googlecode.com/svn/trunk/other/SCRM/updatesite (select the SCRM feature)

After you're done installing and have restarted Eclipse, go to the Navigator View by selecting "Window -> Show View -> Other -> Unicase -> Navigator" from the menu bar. First, we need to create a project that will contain our requirements model. Open the context menu by right-clicking in the Navigator View and select "Other -> New Project...". Enter a name and description and finish the wizard.

From the project's context menu (right-click it) you can create SCRM elements when selecting "New Model Element". To enable graphical modeling, you simply have to choose "SCRMDiagram" in the "New Model Element"-wizard. This will open up a graphical editor.

Coming soon: Screenshots and more details on the modeling parts.