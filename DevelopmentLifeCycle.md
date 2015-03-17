# Developer trunk #
This is the version currently under development. To start it you check out the source code from the SVN repository (trunk) and then run it from your development environment. A second Eclipse instance beside your development environment is started then including the fresh compiled UNICASE "Development Version". You would use the development version while you develop UNICASE itself and want to test the code you wrote..

  * Version: In the trunk the version of all plug-ins and the dependencies between them are set to x.x.x.qualifier. It is important that the version in the trunk is higher than every released version. Otherwise, the released version will be executed, as Eclipse always uses the latest version of plug-ins.

  * UNICASE Workspace Folder: The UNICASE development version stores all its information in the developer home (/HOME) directory in a hidden folder named /.unicase.dev.

  * Server: If you want to connect to EMFStore server with UNICASE development version, you usually want to test something you just developed. It is strictly forbidden to use the UNICASE development version to connect to our running production servers. This could cause instability. In the developer version, the connection settings to Emfstore are pre-configured to connect to your localhost. Therefore, you will need to start your own server manually on your local machine, a detailed description on how to do that is shown in: [here.](http://unicase.googlecode.com/files/StartEmfStore.mov)

# Internal Release #
This is a tagged version of a branch that is obtained from the trunk, which is considered a beta version. The latest version of the internal release is deployed on the internal server: unicase-internal.informatik.tu-muenchen.de (Port 443). The main purpose behind having an internal version is to directly use it for testing the UNICASE itself, i.e. boot strapping. In addition,The UNICASE Project itself is hosted on the internal release, so if you would like to participate in the development process of the UNICASE tool, you are only allowed to use the internal release. Further on during bug fixing the internal release version can be patched into another internal release. This release is not available on our normal update site (external release), but on the beta update site at http://unicase.googlecode.com/svn/updatesite/internal/.

  * Version: In the internal version all the plug-ins and the dependencies between them are set to x.x.x.internal. The version numbers of the internal release are always increased, e.g. 0.3.28.internal, 0.3.29.internal, 0.3.30.internal, 0.3.31.internal.

  * UNICASE Workspace Folder: The UNICASE internal version stores all its information in the developer home (/HOME) directory in a hidden folder named /.unicase.internal.

  * Server: If you want to connect to EMFStore server with UNICASE internal version, note that the connection settings to Emfstore are pre-configured to connect to unicase-internal.informatik.tu-muenchen.de.

# External Release #
This is the final version of UNICASE after development, which is deployed on our main server to be used by UNICASE’s clients. The external version is created out from the latest internal release. This release is available on our normal update site at http://wwwbruegge.in.tum.de/static/unicase.

  * Version: In the external version all the plug-ins and the dependencies between them are set to x.x.x. The version numbers of the external release are always increased, e.g. 0.3.28, 0.3.29, 0.3.30, 0.3.31.

  * UNICASE Workspace Folder: The UNICASE external version stores all its information in the developer home (/HOME) directory in a hidden folder named /.unicase.

  * Server: If you want to connect to EMFStore server with UNICASE external version, note that the connection settings to Emfstore are pre-configured to connect to unicase.in.tum.de.

![http://unicase.googlecode.com/files/45820.jpg](http://unicase.googlecode.com/files/45820.jpg)

Important Notes:

  * The internal release and external release of the UNICASE project cannot be installed into the same eclipse instance therefore, its necessity to have those installed into two different instances of eclipse.

  * There are two read-only tags: latest and latest internal, which basically points to the latest external and internal release respectively. The reason behind creating these read only tags is to make it easier for the developer to read the latest modifications of both the internal and external release, which means that they are not used for bug fixing.