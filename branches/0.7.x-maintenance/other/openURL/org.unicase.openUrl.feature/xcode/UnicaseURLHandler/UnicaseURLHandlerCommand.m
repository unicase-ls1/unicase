//  Copyright (c) 2008-2010 Jonas Helming, Maximilian Koegel. All rights 
//  reserved. This program and the accompanying materials are made available
//  under the terms of the Eclipse Public License v1.0 which accompanies this
//  distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
//
//  UnicaseURLHandlerCommand.m
//
//  Author: Mueller Edgar  
//
//  This file is part of the UNICASE Link project.
//  It's responsibility is to create and launch a task, which executes a the
//  startup jar file, that 
//

#import "UnicaseURLHandlerCommand.h"

@implementation URLHandlerCommand

- (id)performDefaultImplementation {
    NSString *urlString = [[self directParameter] 
						   stringByReplacingPercentEscapesUsingEncoding:
						   NSUTF8StringEncoding];
	NSTask *task;
    task = [[[NSTask alloc] init] autorelease];

	[task setCurrentDirectoryPath:[[[NSBundle mainBundle] bundlePath] 
								   stringByDeletingLastPathComponent]];
	[task setLaunchPath: @"/usr/bin/java"];

	NSString *jarPath = @"org.unicase.openurl.startup.jar";

    NSMutableArray *args = [NSMutableArray array];
	[args addObject: @"-jar"];
	[args addObject: jarPath];
	[args addObject: urlString];

	[task setArguments: args];
	[task launch];

    return nil;
}

@end
