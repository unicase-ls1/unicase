README for Kinect API

Due to a problem with the resource-loading in the classes 
* edu.tum.in.bruegge.epd.kinect.impl.connection.jni.ProxySkeletonConnectionProcessor and
* edu.tum.in.bruegge.epd.kinect.impl.connection.jni.ProxySpeechConnectionProcessor,
one has to configure the working directory be the edu.tum.in.bruegge.epd.kinect-Project 
directory. This is a result of connection processors needing access to the lib/ directory 
and the project not to depend on OSGi/Eclipse.

The working directory can be configured in Eclipse via Run Configurations -> Arguments -> 
Working Directory -> Other: "${workspace_loc:edu.tum.in.bruegge.epd.kinect}".
