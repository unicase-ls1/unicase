package org.unicase.ui.meeditor.specialswtwidgets;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.unicase.ui.meeditor.Activator;

public class RichTextArea extends Composite {
	final Browser browser;
	String PATH_TO_TNYMCE = "html/full.html";
	
	private Boolean scriptLoaded = false;
	
	public static final int NORMAL = 1;
	public static final int SIMPLE = 2;
	public static final int FULL = 3;
	public static final int WORD = 4;
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 270;
	
	/**
	 * create a new Browser Widget containing a TnyMCE rich text editor in a Browser widget.
	 * @param parent
	 */
	public RichTextArea(Composite parent) {
		super(parent, SWT.FILL);
		
		//Text text = new Text(parent, SWT.NONE);
		//TableWrapData data = new TableWrapData(TableWrapData.FILL_GRAB);
		//text.setLayoutData(data);
		
		TableWrapData data1 = new TableWrapData(TableWrapData.FILL_GRAB);
		data1.grabHorizontal = true;
		data1.grabVertical = true;
		data1.align = TableWrapData.FILL;
		this.setLayoutData(data1);
		
		browser = new Browser(this, SWT.NONE | SWT.FILL | Window.getDefaultOrientation());
//		TableWrapData data = new TableWrapData(TableWrapData.FILL_GRAB);
//		data.grabHorizontal = true;
//		data.grabVertical = true;
//		browser.setLayoutData(data);
		
		
		//GridData data1 = new GridData(GridData.FILL_HORIZONTAL);
		//data1.horizontalAlignment = GridData.FILL;
		//data1.verticalAlignment = GridData.FILL;
		//data1.horizontalSpan = 3;
		//data1.grabExcessHorizontalSpace = true;
		//data1.grabExcessVerticalSpace = true;
		
		//this.setLayoutData(data1);
		
		browser.setData("htmlcontent", "preLoad stub");
		browser.addProgressListener(new ProgressListener() {
			public void changed(ProgressEvent event) {
			}
			
			public void completed(ProgressEvent event) {
				_loadHTMLText((String)browser.getData("htmlcontent"));
				scriptLoaded = true;
			}
					
			private void _loadHTMLText(String htmlText) {
				String jscript = " setHTMLText('" + htmlText + "');";
				System.out.println(jscript);
				//String jscript = " setHTMLText('test');";
				boolean result = browser.execute(jscript);
				if (!result) {
					/* Script may fail or may not be supported on certain platforms. */
					System.out.println("Script ProgressListener: _loadHtmlText was not executed.");
				}
			}
		});
		
		
		browser.addStatusTextListener(new StatusTextListener() {
		   public void changed(StatusTextEvent event) {
			     browser.setData("query", event.text);
		   }
		});
		
		this.setMode(NORMAL);
		//this.setHtmlEditorPath("html/full.html");

		//browser.setSize(browser.computeSize(SWT.DEFAULT, 500));
		browser.setSize(browser.computeSize(DEFAULT_WIDTH, DEFAULT_HEIGHT, false));
		//browser.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
	}
	
	
	/**
	 * set the relative path to the html file of the editor. i.e html/simple.html
	 */
	private void setHtmlEditorPath(String path) {
		URL url = FileLocator.find(
				Activator.getDefault().getBundle(), 
				new Path(path), 
				Collections.EMPTY_MAP
			);
		
		try {
			browser.setUrl(FileLocator.resolve(url).toExternalForm());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	/**
	 * use mode RichTextArea.NORMAL, SIMPLE, FULL or WORD
	 * @param mode
	 */
	public void setMode(int mode) {
		if (mode == 1)
			this.setHtmlEditorPath("html/normal.html");
		else if (mode == 2)
			this.setHtmlEditorPath("html/simple.html");
		else if (mode == 3)
			this.setHtmlEditorPath("html/full.html");
		else if (mode == 4)
			this.setHtmlEditorPath("html/word.html");
		else
			this.setHtmlEditorPath("html/normal.html");
	}
	
	public void setSize(int width, int height) {
		browser.setSize(browser.computeSize(width, height));
	}
	
	public void setBrowserLayoutData(LayoutData data) {
		browser.setLayoutData(data);
	}
	
	/**
	 * fetch the current value of the textarea
	 * @return
	 */
	public String getText() {
		if (!scriptLoaded) {
			System.out.println("getText(): html pagen hasnt been loaded completely. " + (String)browser.getData("htmlcontent"));
			return (String)browser.getData("htmlcontent");
		} else {
			String tnyGetHTMLScript = "window.status=getHTMLText();";
			
			boolean result = browser.execute(tnyGetHTMLScript);
			if (!result) {
				/* Script may fail or may not be supported on certain platforms. */
				System.out.println("Script getText was not executed.");
			}
			String res = (String)browser.getData("query");
		
			System.out.println("trying to get text.");
			
			return res;			
		}
	}
	
	public void setText(String htmlText) {
		if (!scriptLoaded) {
			System.out.println("setText(): html pagen hasnt been loaded completely. " + htmlText);
			browser.setData("htmlcontent", htmlText);
			
		} else {
			String jscript = " setHTMLText('" + htmlText + "');";
			boolean result = browser.execute(jscript);
			if (!result) {
				/* Script may fail or may not be supported on certain platforms. */
				System.out.println("Script setText: setHtmlText was not executed.");
			}	
		}
	}
	
	

	
}
