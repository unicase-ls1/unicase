package org.unicase.ui.meeditor.mecontrols;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class MERichTextControl extends AbstractMEControl {

	public MERichTextControl(EAttribute feature, EditingDomain editingDomain,
			EObject modelElement, FormToolkit toolkit) {
		super(editingDomain, modelElement, toolkit);
		// TODO Auto-generated constructor stub
	}

	public Control createControl(Composite parent, int style) {
		composite = new Composite(parent, style);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);
		createToolBar();
		createStyledText();

		return composite;
	}

	Composite composite;

	ToolBar toolBar;

	StyledText text;


	

	private TextViewer viewer;

	private void createStyledText() {

		
		
		viewer = new TextViewer(composite, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL);
		viewer.setDocument(new Document());

		text = viewer.getTextWidget();
		text.setSize(10, 100);
		GridData spec = new GridData();
		spec.horizontalAlignment = GridData.FILL;
		spec.grabExcessHorizontalSpace = true;
		spec.verticalAlignment = GridData.FILL;
		spec.grabExcessVerticalSpace = true;
		spec.heightHint = 200;
		text.setLayoutData(spec);
		
		text.addPaintObjectListener(new PaintObjectListener() {
			public void paintObject(PaintObjectEvent event) {
				Display display = event.display;
				StyleRange style = event.style;
				Font font = style.font;
				if (font == null)
					font = text.getFont();
				TextLayout layout = new TextLayout(display);
				layout.setAscent(event.ascent);
				layout.setDescent(event.descent);
				layout.setFont(font);
				layout.setText("\u2023 1." + event.bulletIndex + ")");
				layout.draw(event.gc, event.x + 10, event.y);
				layout.dispose();
			}
		});
	}

	private void createToolBar() {
		toolBar = new ToolBar(composite, SWT.NULL);
		ToolItem item;
		item = new ToolItem(toolBar, SWT.PUSH);
		item.setText("Bullet");
		item.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Point selectionRange = text.getSelectionRange();
				int x = selectionRange.x;
				int y = selectionRange.y;
				int startLine = text.getLineAtOffset(x);
				int endLine = text.getLineAtOffset(x + y);
				for (int i = startLine; i <= endLine; i++) {
					if (text.getLineBullet(i) == null) {
						bullet(i, 1);
					} else {
						unbullet(i, 1);
					}

				}
			}
		});
		item = new ToolItem(toolBar, SWT.PUSH);
		item.setText("Load");
		item.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				List<Integer> bulletedLines = load();
				for (Integer line : bulletedLines) {
					bullet(line, 1);
				}
			}
		});
		item = new ToolItem(toolBar, SWT.PUSH);
		item.setText("Save");
		item.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				save();
			}
		});
	}

	protected void unbullet(int line, int count) {
		text.setLineBullet(line + count - 1, 1, null);

	}

	private void save() {
		List<Integer> bulletedLines = new ArrayList<Integer>();
		for (int i = 0; i < text.getLineCount(); i++) {
			if (text.getLineBullet(i) != null) {
				bulletedLines.add(i);
			}
		}
		StringBuffer txt = new StringBuffer();
		for (Integer bulletedLine : bulletedLines) {
			txt.append(bulletedLine + ",");
		}
		txt.append(";,");
		txt.append("\n");
		txt.append("%BEGINNTEXT%");
		txt.append(text.getText());
		System.out.println(txt.toString());
		//AS Save to feature txt.toString();
	}

	private List<Integer> load() {
		//AS Load from feature
		String txt = "0,;," + '\n' + "%BEGINNTEXT%" + "Hallo";
		List<Integer> bulletedLines = new ArrayList<Integer>();
		StringTokenizer stringTokenizer = new StringTokenizer(txt, ",");
		while (stringTokenizer.hasMoreElements()) {
			String nextElement = (String) stringTokenizer.nextElement();
			if (nextElement.equals(";")) {
				break;
			} else {
				bulletedLines.add(Integer.parseInt(nextElement));
			}
		}
		String[] split = txt.split("%BEGINNTEXT%");
		viewer.getDocument().set(split[1]);
		return bulletedLines;

	}

	protected void bullet(int line, int count) {

		StyleRange style0 = new StyleRange();
		style0.metrics = new GlyphMetrics(0, 0, 40);
		Bullet bullet0 = new Bullet(style0);
		for (int i = 0; i < count; i++) {

			text.setLineBullet(line + count - 1, 1, bullet0);

		}

	}




}