#! /bin/sh
gconftool-2 -t string -s /desktop/gnome/url-handlers/unicase/command "$1"
gconftool-2 -t bool -s /desktop/gnome/url-handlers/unicase/enabled true
gconftool-2 -t bool -s /desktop/gnome/url-handlers/unicase/needs_terminal false 
