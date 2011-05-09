;NSIS Modern User Interface
;Basic Example Script
;Written by Joost Verburg

;--------------------------------
;Include Modern UI

  !include "MUI2.nsh"

;--------------------------------
;Functions
  Function .onInit
	  InitPluginsDir
  	File /oname=$PLUGINSDIR\splash.bmp "splash.bmp"
	  splash::show 3000 $PLUGINSDIR\splash
	  Pop $0
  FunctionEnd

;--------------------------------
;General

  ;Name and file
  Name "Unicase"
  OutFile "unicase_setup.exe"

  ;Default installation folder
  InstallDir "$LOCALAPPDATA\Unicase"
  
  ;Get installation folder from registry if available
  InstallDirRegKey HKCU "Software\Unicase" "Install Dir"

  ;Request application privileges for Windows Vista
  RequestExecutionLevel user

;--------------------------------
;Variables

  Var StartMenuFolder

;--------------------------------
;Interface Settings

  !define MUI_ICON "unicase.ico"
  !define MUI_HEADERIMAGE
  !define MUI_HEADERIMAGE_BITMAP "header.bmp"
  !define MUI_ABORTWARNING

;--------------------------------
;Pages

  !insertmacro MUI_PAGE_WELCOME
  !insertmacro MUI_PAGE_LICENSE "license.txt"
  !insertmacro MUI_PAGE_COMPONENTS
  !insertmacro MUI_PAGE_DIRECTORY

  ;Start Menu Folder Page Configuration
  !define MUI_STARTMENUPAGE_REGISTRY_ROOT "HKCU" 
  !define MUI_STARTMENUPAGE_REGISTRY_KEY "Software\Unicase" 
  !define MUI_STARTMENUPAGE_REGISTRY_VALUENAME "Start Menu Folder"
  
  !insertmacro MUI_PAGE_STARTMENU Application $StartMenuFolder

  !insertmacro MUI_PAGE_INSTFILES
  !insertmacro MUI_PAGE_FINISH
  
  !insertmacro MUI_UNPAGE_WELCOME
  !insertmacro MUI_UNPAGE_CONFIRM
  !insertmacro MUI_UNPAGE_INSTFILES
  !insertmacro MUI_UNPAGE_FINISH
  
;--------------------------------
;Languages
 
  !insertmacro MUI_LANGUAGE "English"

;--------------------------------
;Installer Sections

  Section "Unicase (required)" unicase
    SectionIn RO
    SetOutPath $INSTDIR
    File /r "unicase\*.*"
    
    ; Write the installation path into the registry
    WriteRegStr HKCU SOFTWARE\UNICASE "Install Dir" "$INSTDIR"
    
    ;Create uninstaller
    WriteUninstaller "uninstall.exe"

    !insertmacro MUI_STARTMENU_WRITE_BEGIN Application
      
      ;Create shortcuts
      CreateDirectory "$SMPROGRAMS\$StartMenuFolder"
      CreateShortCut "$SMPROGRAMS\$StartMenuFolder\Unicase.lnk" "$INSTDIR\unicase.exe"
      CreateShortCut "$SMPROGRAMS\$StartMenuFolder\Uninstall.lnk" "$INSTDIR\Uninstall.exe"
    
    !insertmacro MUI_STARTMENU_WRITE_END
  SectionEnd
  
  Section "Example Project" example
    CreateDirectory "$PROFILE\.unicase"
    SetOutPath "$PROFILE\.unicase"
    File /r ".unicase\*.*"
  SectionEnd

;--------------------------------
;Descriptions

  ;Language strings
  LangString DESC_unicase ${LANG_ENGLISH} "Unicase main program."
  LangString DESC_example ${LANG_ENGLISH} "An example project. It will be located $$USERHOME/.unicase and so automatically used by Unicase."

  ;Assign language strings to sections
  !insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
    !insertmacro MUI_DESCRIPTION_TEXT ${unicase} $(DESC_unicase)
    !insertmacro MUI_DESCRIPTION_TEXT ${example} $(DESC_example)
  !insertmacro MUI_FUNCTION_DESCRIPTION_END

;--------------------------------
;Uninstaller Section

Section "Uninstall"
  !insertmacro MUI_STARTMENU_GETFOLDER Application $StartMenuFolder    
  Delete "$SMPROGRAMS\$StartMenuFolder\Uninstall.lnk"
  RMDir "$SMPROGRAMS\$StartMenuFolder"
  DeleteRegKey HKCU "Software\Microsoft\Windows\CurrentVersion\Uninstall\Unicase"
  DeleteRegKey HKCU SOFTWARE\UNICASE
  RMDir /r "$INSTDIR"
  RMDir /r "$PROFILE\.unicase"
SectionEnd