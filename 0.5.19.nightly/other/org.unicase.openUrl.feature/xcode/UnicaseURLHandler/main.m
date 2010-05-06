//  Copyright (c) 2008-2010 Jonas Helming, Maximilian Koegel. All rights 
//  reserved. This program and the accompanying materials are made available
//  under the terms of the Eclipse Public License v1.0 which accompanies this
//  distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
//
//  main.m
//
//  Author: Mueller Edgar  
//
//  This file is part of the UNICASE Link project.
// 
//  Note: I'm completly new to Cocoa programming, so if this code is complelty
//        messed up, bear with me..

#import <Cocoa/Cocoa.h>

int main(int argc, const char *argv[]) {
	// we don't use NSApplicationMain, instead we replace it with the following
	// which is inspired by http://www.omnigroup.com/mailman/archive/macosx-dev/2000-November/019039.html
	// The problem with NSApplicationMain is that it cannot be terminated 
	// programatically, only the user is able to do so. 
    NSEvent            *event            = NULL;
    NSDate            *distantPast;
    unsigned int    eventMask;
	
    [[NSAutoreleasePool alloc] init];
    NSApp = [NSApplication sharedApplication];
	// don't load the nib file, such that no window appears
    //[NSBundle loadNibNamed:@"MainMenu" owner:NSApp];
    distantPast    = [[NSDate distantPast] retain];
    eventMask    = (NSAnyEventMask);

	// event loop has been commented out
	//    while (1) {
	event = [NSApp nextEventMatchingMask: eventMask
							   untilDate: distantPast
								  inMode: NSDefaultRunLoopMode
								 dequeue: 1];
	if (event) [NSApp sendEvent:event];
	//    }
	
    [NSApp release];
    return (0);
}

