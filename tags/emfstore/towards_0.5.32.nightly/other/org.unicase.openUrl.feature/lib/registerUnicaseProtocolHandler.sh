#! /bin/sh

# for unsetting use: gconftool-2 -u <id>

enabled=$(gconftool-2 -g /desktop/gnome/url-handlers/unicase/enabled)
needs_terminal=$(gconftool-2 -g /desktop/gnome/url-handlers/unicase/needs_terminal)
command=$(gconftool-2 -g /desktop/gnome/url-handlers/unicase/command)

registerURLHandler() {
	gconftool-2 -t string -s /desktop/gnome/url-handlers/unicase/command "$1 %s $2"
	gconftool-2 -t bool -s /desktop/gnome/url-handlers/unicase/enabled true
	gconftool-2 -t bool -s /desktop/gnome/url-handlers/unicase/needs_terminal false
}

checkURLHandler() {
	if [ "$enabled" != "true" ]
 		then exit 1
	fi;

	if [ "$needs_terminal" != "false" ]
 		then exit 2
	fi;

	if [ "$command" = "" ]
 		then exit 3
	fi;
	
	exit 0
}

if [ "$1" = "check" ] 
	then checkURLHandler
elif [ "$1" = "register" ]
	then registerURLHandler "$2" "$3"
fi
	 
