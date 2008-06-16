/*******************************************************************************
 * Copyright (c) 2006 Tom Seidel, Spirit Link GmbH
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *     Tom Seidel - initial API and implementation
 *******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.richtext.widgets;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressAdapter;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.mecontrols.richtext.internal.events.EventDataQueue;
import org.unicase.ui.meeditor.mecontrols.richtext.internal.events.EventTable;

/**
 * 
 * @author Tom Seidel <tom.seidel@spiritlink.de>
 * 
 */
public class HtmlComposer {
	/** the embedded browser widget */
	Browser browser = null;

	/** The real path to the tinyMce HTML Page */
	public static final String BASE_PATH = "tiny_mce/base/base.htm"; //$NON-NLS-1$

	/** Indicating a command sequence start from tinyMCE */
	public static final String START = "START"; //$NON-NLS-1$

	/** Indicating a command sequence end from tinyMCE */
	public static final String EOF = "eof"; //$NON-NLS-1$

	/** Seperating command and value from tinyMCE */
	public static final String SEPARATOR = ":"; //$NON-NLS-1$

	EventTable eventTable = new EventTable();

	EventDataQueue eventDataQueue = new EventDataQueue();

	boolean isInTagSequence = false;

	boolean canExecuteCommands = false;

	List<String> pendingCommands = new LinkedList<String>();

	int delayAfterProgressCompleted = 50;

	private StatusTextListener statusListener = new StatusTextListener() {
		public void changed(StatusTextEvent event) {
			Event browserEvent = new Event();
			browserEvent.display = event.display;
			browserEvent.widget = event.widget;
			// System.out.println("STATUS CHANGED:" + event.text);
			if (event.text != null && event.text.split(":").length >= 2) { //$NON-NLS-1$
				String[] splittedEventText = event.text.split(":"); //$NON-NLS-1$
				int eventId = -1;
				try {
					eventId = new Integer(splittedEventText[0]);
				} catch (NumberFormatException e) {
					// do nothing
				}
				if (splittedEventText[1].equals(START)) {
					if (eventId >= 0) {
						if (HtmlComposer.this.eventDataQueue.getCurrentEvent() != null) {
							HtmlComposer.this.eventTable.handleEvent(
									HtmlComposer.this.eventDataQueue
											.getCurrentEvent().type,
									HtmlComposer.this.eventDataQueue
											.getCurrentEvent());
						}
						HtmlComposer.this.eventDataQueue.startSequence(eventId);
					} else {
						HtmlComposer.this.eventDataQueue.addData(
								splittedEventText[0], event.text.replaceFirst(
										splittedEventText[0] + SEPARATOR, "")); //$NON-NLS-1$
					}

				} else if (eventId == 0 && splittedEventText[1].equals(EOF)) {
					if (HtmlComposer.this.eventDataQueue.getCurrentEvent() != null) {
						HtmlComposer.this.eventTable.handleEvent(
								HtmlComposer.this.eventDataQueue
										.getCurrentEvent().type,
								HtmlComposer.this.eventDataQueue
										.getCurrentEvent());
						HtmlComposer.this.eventDataQueue.clear();
					}

				} else if (HtmlComposer.this.eventDataQueue.getCurrentEvent() != null) {
					HtmlComposer.this.eventDataQueue.addData(
							splittedEventText[0], event.text.replaceFirst(
									splittedEventText[0] + SEPARATOR, "")); //$NON-NLS-1$
				}
			}
		}
	};

	private ProgressListener renderListener = new ProgressAdapter() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.swt.browser.ProgressAdapter#completed(org.eclipse.swt
		 * .browser.ProgressEvent)
		 */
		@Override
		public void completed(ProgressEvent event) {
			HtmlComposer.this.canExecuteCommands = true;
			Collections.reverse(HtmlComposer.this.pendingCommands);
			for (final String commands : HtmlComposer.this.pendingCommands) {
				getShell().getDisplay().timerExec(
						HtmlComposer.this.delayAfterProgressCompleted,
						new Runnable() {
							public void run() {
								HtmlComposer.this.browser.execute(commands);
							}
						});
			}
			HtmlComposer.this.pendingCommands.clear();
		}
	};

	/**
	 * Adds a listener to the widget for
	 * 
	 * @param eventType
	 *            the event. See {@link EventConstants}
	 * @param listener
	 *            a listener.
	 */
	public void addListener(int eventType, Listener listener) {
		this.eventTable.addListener(eventType, listener);
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.browser.Browser#addProgressListener(org.eclipse.swt.browser.ProgressListener)
	 */
	public void addProgressListener(ProgressListener listener) {
		this.browser.addProgressListener(listener);
	}

	/**
	 * Removes the listener for a special event
	 * 
	 * @param eventType
	 *            the event. See {@link EventConstants}
	 * @param listener
	 *            a listener
	 */
	public void removeListener(int eventType, Listener listener) {
		this.eventTable.removeListener(eventType, listener);
	}

	/**
	 * Creates a new Instance of the browser widget.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            the style bits
	 */
	public HtmlComposer(Composite parent, int style) {
		this(parent, style, resolveBaseHtml());
	}

	public HtmlComposer(Composite parent, int style, String absPathToTinyMCE) {
		this.browser = new Browser(parent, style);
		this.browser.setUrl(absPathToTinyMCE);
		this.browser.addStatusTextListener(this.statusListener);
		this.browser.addProgressListener(this.renderListener);
		this.browser.setMenu(new Menu(this.browser));

	}

	private static String resolveBaseHtml() {
		try {
			return FileLocator.resolve(
					Activator.getDefault().getBundle().getEntry(BASE_PATH))
					.toString();
		} catch (IOException e) {
			throw new IllegalStateException("Invalid state", e); //$NON-NLS-1$
		}
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.widgets.Control#addPaintListener(org.eclipse.swt.events.PaintListener)
	 */
	public void addPaintListener(PaintListener listener) {
		this.browser.addPaintListener(listener);
	}

	/**
	 * @param script
	 * @return
	 * @see org.eclipse.swt.browser.Browser#execute(java.lang.String)
	 */
	public boolean execute(String script) {
		boolean returnValue = false;
		if (this.canExecuteCommands) {
			returnValue = this.browser.execute(script);
		} else {
			returnValue = this.pendingCommands.add(script);
		}
		System.out.println(script+" "+returnValue);
		return returnValue;
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.widgets.Control#removePaintListener(org.eclipse.swt.events.PaintListener)
	 */
	public void removePaintListener(PaintListener listener) {
		this.browser.removePaintListener(listener);
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.browser.Browser#removeProgressListener(org.eclipse.swt.browser.ProgressListener)
	 */
	public void removeProgressListener(ProgressListener listener) {
		this.browser.removeProgressListener(listener);
	}

	/**
	 * @param color
	 * @see org.eclipse.swt.widgets.Control#setBackground(org.eclipse.swt.graphics.Color)
	 */
	public void setBackground(Color color) {
		this.browser.setBackground(color);
	}

	/**
	 * @param image
	 * @see org.eclipse.swt.widgets.Control#setBackgroundImage(org.eclipse.swt.graphics.Image)
	 */
	public void setBackgroundImage(Image image) {
		this.browser.setBackgroundImage(image);
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getBackground()
	 */
	public Color getBackground() {
		return this.browser.getBackground();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getBackgroundImage()
	 */
	public Image getBackgroundImage() {
		return this.browser.getBackgroundImage();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getBorderWidth()
	 */
	public int getBorderWidth() {
		return this.browser.getBorderWidth();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getBounds()
	 */
	public Rectangle getBounds() {
		return this.browser.getBounds();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Composite#getChildren()
	 */
	public Control[] getChildren() {
		return this.browser.getChildren();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Scrollable#getClientArea()
	 */
	public Rectangle getClientArea() {
		return this.browser.getClientArea();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getEnabled()
	 */
	public boolean getEnabled() {
		return this.browser.getEnabled();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getForeground()
	 */
	public Color getForeground() {
		return this.browser.getForeground();
	}

	/**
	 * Returns the HTML Content of the widget. Therefore a temporary listener is
	 * registered to the widget that listens for the given html. Other
	 * registered listeners that are listen for html will be also notified.
	 * 
	 * @return the html, <code>null</code> if the widget is not fully rendered.
	 */
	public String getHtml() {
		String returnValue = null;
		if (this.canExecuteCommands) {
			GetHtmlHandler handler = new GetHtmlHandler();
			addListener(EventConstants.ALL, handler);
			execute(JavaScriptCommands.GET_HTML);
			returnValue = handler.getHtml();
			removeListener(EventConstants.ALL, handler);
		}
		return returnValue;
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Composite#getLayout()
	 */
	public Layout getLayout() {
		return this.browser.getLayout();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getLayoutData()
	 */
	public Object getLayoutData() {
		return this.browser.getLayoutData();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getMenu()
	 */
	public Menu getMenu() {
		return this.browser.getMenu();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getParent()
	 */
	public Composite getParent() {
		return this.browser.getParent();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getShell()
	 */
	public Shell getShell() {
		return this.browser.getShell();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getSize()
	 */
	public Point getSize() {
		return this.browser.getSize();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Widget#getStyle()
	 */
	public int getStyle() {
		return this.browser.getStyle();
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Control#getVisible()
	 */
	public boolean getVisible() {
		return this.browser.getVisible();
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @see org.eclipse.swt.widgets.Control#setBounds(int, int, int, int)
	 */
	public void setBounds(int x, int y, int width, int height) {
		this.browser.setBounds(x, y, width, height);
	}

	/**
	 * @param rect
	 * @see org.eclipse.swt.widgets.Control#setBounds(org.eclipse.swt.graphics.Rectangle)
	 */
	public void setBounds(Rectangle rect) {
		this.browser.setBounds(rect);
	}

	/**
	 * @param capture
	 * @see org.eclipse.swt.widgets.Control#setCapture(boolean)
	 */
	public void setCapture(boolean capture) {
		this.browser.setCapture(capture);
	}

	/**
	 * @param cursor
	 * @see org.eclipse.swt.widgets.Control#setCursor(org.eclipse.swt.graphics.Cursor)
	 */
	public void setCursor(Cursor cursor) {
		this.browser.setCursor(cursor);
	}

	/**
	 * @param enabled
	 * @see org.eclipse.swt.widgets.Control#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled) {
		this.browser.setEnabled(enabled);
	}

	/**
	 * @return
	 * @see org.eclipse.swt.widgets.Composite#setFocus()
	 */
	public boolean setFocus() {
		return this.browser.setFocus();
	}

	/**
	 * @param font
	 * @see org.eclipse.swt.widgets.Control#setFont(org.eclipse.swt.graphics.Font)
	 */
	public void setFont(Font font) {
		this.browser.setFont(font);
	}

	/**
	 * @param color
	 * @see org.eclipse.swt.widgets.Control#setForeground(org.eclipse.swt.graphics.Color)
	 */
	public void setForeground(Color color) {
		this.browser.setForeground(color);
	}

	/**
	 * @param layout
	 * @see org.eclipse.swt.widgets.Composite#setLayout(org.eclipse.swt.widgets.Layout)
	 */
	public void setLayout(Layout layout) {
		this.browser.setLayout(layout);
	}

	/**
	 * @param layoutData
	 * @see org.eclipse.swt.widgets.Control#setLayoutData(java.lang.Object)
	 */
	public void setLayoutData(Object layoutData) {
		this.browser.setLayoutData(layoutData);
	}

	/**
	 * @param x
	 * @param y
	 * @see org.eclipse.swt.widgets.Control#setLocation(int, int)
	 */
	public void setLocation(int x, int y) {
		this.browser.setLocation(x, y);
	}

	/**
	 * @param location
	 * @see org.eclipse.swt.widgets.Control#setLocation(org.eclipse.swt.graphics.Point)
	 */
	public void setLocation(Point location) {
		this.browser.setLocation(location);
	}

	/**
	 * @param menu
	 * @see org.eclipse.swt.widgets.Control#setMenu(org.eclipse.swt.widgets.Menu)
	 */
	public void setMenu(Menu menu) {
		this.browser.setMenu(menu);
	}

	/**
	 * @param parent
	 * @return
	 * @see org.eclipse.swt.widgets.Control#setParent(org.eclipse.swt.widgets.Composite)
	 */
	public boolean setParent(Composite parent) {
		return this.browser.setParent(parent);
	}

	/**
	 * @param width
	 * @param height
	 * @see org.eclipse.swt.widgets.Control#setSize(int, int)
	 */
	public void setSize(int width, int height) {
		this.browser.setSize(width, height);
	}

	/**
	 * @param size
	 * @see org.eclipse.swt.widgets.Control#setSize(org.eclipse.swt.graphics.Point)
	 */
	public void setSize(Point size) {
		this.browser.setSize(size);
	}

	/**
	 * @param visible
	 * @see org.eclipse.swt.widgets.Control#setVisible(boolean)
	 */
	public void setVisible(boolean visible) {
		this.browser.setVisible(visible);
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.widgets.Widget#addDisposeListener(org.eclipse.swt.events.DisposeListener)
	 */
	public void addDisposeListener(DisposeListener listener) {
		this.browser.addDisposeListener(listener);
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.widgets.Control#addFocusListener(org.eclipse.swt.events.FocusListener)
	 */
	public void addFocusListener(FocusListener listener) {
		this.browser.addFocusListener(listener);
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.widgets.Widget#removeDisposeListener(org.eclipse.swt.events.DisposeListener)
	 */
	public void removeDisposeListener(DisposeListener listener) {
		this.browser.removeDisposeListener(listener);
	}

	/**
	 * @param listener
	 * @see org.eclipse.swt.widgets.Control#removeFocusListener(org.eclipse.swt.events.FocusListener)
	 */
	public void removeFocusListener(FocusListener listener) {
		this.browser.removeFocusListener(listener);
	}

	/**
	 * @return the delayAfterProgressCompleted
	 */
	public int getDelayAfterProgressCompleted() {
		return this.delayAfterProgressCompleted;
	}

	/**
	 * Sets a manual delay for executing pending commands. Commands can only be
	 * executed if the tinyMCE and its JavaScript includes are fully loaded. The
	 * {@link ProgressListener} throws an event if the page is loaded, but the
	 * includes may not be loaded. Therefore this method can be used if you
	 * executing HTML manipulating commands against the widget and you see no
	 * result. The default is 50ms which was enough in the tests. This fix was
	 * requested in {@link https
	 * ://sourceforge.net/tracker/index.php?func=detail&
	 * aid=1679371&group_id=185136&atid=912061}
	 * 
	 * @param delayAfterProgressCompleted
	 *            the delayAfterProgressCompleted to set
	 */
	public void setDelayAfterProgressCompleted(int delayAfterProgressCompleted) {
		this.delayAfterProgressCompleted = delayAfterProgressCompleted;
	}
	
	public Browser getBrowser(){
		return this.browser;
	}

}
