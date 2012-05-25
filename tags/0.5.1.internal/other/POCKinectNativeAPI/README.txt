Steps to build the project :

1. Building the JNI Header file from the Java Project.
-----------------------------------------------------
Compile the java source code using javac (Eclipse will build it by default into the bin folder).
To create the JNI Header file open command prompt and go into the build directory.

Run the below command:

javah <fully_qualified_class_name>

In our case this will be 

javah de.tum.kinect.api.poc.JNiCallBackExample


2. To build the C# Project.
-----------------------------------------------------
Open the Solution file which opens both the C# project and the C++ project.
To build the C# Project, follow the below steps:

a. Open Start->Microsoft Visual Studio 2010 -> Visual Studio Tools -> Visual Studio Command Prompt(2010)
b. Go into the directory where you have the C# project
c. Run the below command
	csc /t:module CSBackend.cs /r:"<path_to_Microsoft.Research.Kinect.dll>" /r:"<path_to_Microsoft.Speech.dll>"
d. This will create the .netmodule file

3. Building the C++ DLL
-----------------------------------------------------
Copy the .netmodule file obtained in the previous step and add it to the root direcotry of the C++ project folder.
In Visual Studio, right click on the C++ Project and click on Build.
The DLL file will be created in the DotNetSolution\Debug folder.

4. Running the Program
-----------------------------------------------------
Copy the .DLL file and .netmodule file created in the previous steps into the root directory of the java project.
Run the java project


