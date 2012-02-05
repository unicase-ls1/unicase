// CPPLib.cpp : Defines the exported functions for the DLL application.
//

#include "stdafx.h"
#include "JavaInclude.h"
#include <iostream>

#using <mscorlib.dll>
#using "CSBackend.netmodule"

using namespace std;
using namespace System;

static JavaVM *vm = NULL;
jobject callBackObject = NULL;

JNIEnv *getJNIEnv(){
    JNIEnv *env;
	vm->AttachCurrentThread((void **) &env, NULL);
	return env;
}
 
bool init(JNIEnv *env) {
   if (!(env->GetJavaVM(&vm) < 0)) return false;
   return true;
}

void CSomeClass::MemberFunction(LPSTR str)
{
	cout<<"[C++] Invoke Java callback function"<<endl;
	JNIEnv *env = getJNIEnv();
	jclass jc = env->GetObjectClass(callBackObject);
	jmethodID mid = env->GetMethodID(jc, "callBack","(Ljava/lang/String;)V");
	env->CallVoidMethod(callBackObject, mid, env->NewStringUTF(str));
}

void __stdcall SomeFunction(void* someObject, void* someParam, LPSTR str)
{
	CSomeClass* o = (CSomeClass*)someObject;
	cout<<"[C++] Callback from C# and String value passed is "<<str<<endl;

	// when SomeFunction is called , invoke the callback function
	o->MemberFunction("Reply string from C++");
}

JNIEXPORT void JNICALL Java_de_tum_kinect_api_poc_JNiCallBackExample_initConfig
  (JNIEnv *env, jobject thisObj, jobject passedObj, jobjectArray stringArray)
{
	if(NULL == callBackObject)
	{
		callBackObject = passedObj;	
	}

	bool flag = init(env);
	cout<<"[C++] Initializing Java, C# Callbacks"<<endl;
	int stringCount = env->GetArrayLength(stringArray);

	cout<<"[C++] Parsing string array passed from Java and convert to C# format"<<endl;
	array<String^>^ strarray = gcnew array<String^>(stringCount);
	for (int i=0; i<stringCount; i++) {
        jstring string = (jstring) env->GetObjectArrayElement(stringArray, i);
        const char *rawString =env->GetStringUTFChars(string, 0);
        strarray[i] =  gcnew String(rawString);
		env->ReleaseStringUTFChars(string, rawString);
    }

	cout<<"[C++] Invoke the C# Function and register the callback function"<<endl;
	CSomeClass o;
	void* p = 0;
	CSharp::Function(System::IntPtr(SomeFunction), System::IntPtr(&o), System::IntPtr(p), strarray);
	
}