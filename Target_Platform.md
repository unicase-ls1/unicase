#This page descibres how to use a target platform.

# Introduction #

We use target platform for UNICASE development which allows all the developers to have same sets of plugins inspite of different eclipse versions and operating systems.



### Steps to use UNICASE target platform ###


o In order to get the target platform defintion, checkout [targetDefinition](http://unicase.googlecode.com/svn/trunk/deployment/UNICASETargetPlatform/) folder using subclipse in your eclipse workspace.


o In eclipse preferences go to > Plug-in Development > Target Platform. If you are done with step one then you should be able to see a target defintion named "UNICASETargetDefinition.target" within the folder targetDefinition.


o Select the check-box in front on previously mentioned traget defintion, click on apply and finally OK. This will autmoatically resolve the traget defintion and download the plug-ins locally.


o Once the target platform is resolved you can see for yourself and verify if there is any compilation error due to missing dependency.