#include "org_unicase_link_preferences_URLAssociationFieldEditor.h"
#include <AvailabilityMacros.h>
#include <CoreFoundation/CoreFoundation.h>
   
#if !defined(MAC_OS_X_VERSION_10_5) || MAC_OS_X_VERSION_MAX_ALLOWED < MAC_OS_X_VERSION_10_5 
#include <ApplicationServices/ApplicationServices.h>
#else
#include <CoreServices/CoreServices.h>
#endif

JNIEXPORT jint JNICALL Java_org_unicase_link_preferences_URLAssociationFieldEditor_registerUrl
  (JNIEnv * env, jobject object, jstring string)
{
    LSSetDefaultHandlerForURLScheme(CFSTR("unicase"), CFSTR("org.eclipse.eclipse"));
    return 1;
}
