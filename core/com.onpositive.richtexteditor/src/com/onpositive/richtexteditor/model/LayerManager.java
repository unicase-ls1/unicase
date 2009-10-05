/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.model;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.onpositive.richtexteditor.io.TextSerializer;
import com.onpositive.richtexteditor.io.html.DefaultHTMLLoader;
import com.onpositive.richtexteditor.io.html.HTMLSerializer;
import com.onpositive.richtexteditor.io.html.IHTMLLoader;
import com.onpositive.richtexteditor.io.html.IHTMLLoaderFactory;
import com.onpositive.richtexteditor.io.html.IHTMLSerializerFactory;
import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.partitions.Change;
import com.onpositive.richtexteditor.model.partitions.HRPartition;
import com.onpositive.richtexteditor.model.partitions.IHandlesSelection;
import com.onpositive.richtexteditor.model.partitions.ILineAttributeModel;
import com.onpositive.richtexteditor.model.partitions.IRegionCompositeWrapperListener;
import com.onpositive.richtexteditor.model.partitions.ImagePartition;
import com.onpositive.richtexteditor.model.partitions.LinkPartition;
import com.onpositive.richtexteditor.model.partitions.ObjectPartition;
import com.onpositive.richtexteditor.model.partitions.PartitionDelta;
import com.onpositive.richtexteditor.model.partitions.PartitionStorage;
import com.onpositive.richtexteditor.model.partitions.RegionCompositeEvent;
import com.onpositive.richtexteditor.model.partitions.RegionPartition;
import com.onpositive.richtexteditor.model.partitions.SetAlignChange;
import com.onpositive.richtexteditor.model.partitions.SetBulletChange;
import com.onpositive.richtexteditor.model.partitions.WorldChange;
import com.onpositive.richtexteditor.model.resources.ColorManager;
import com.onpositive.richtexteditor.model.resources.FontStyleManager;
import com.onpositive.richtexteditor.model.resources.ImageManager;

import com.onpositive.richtexteditor.registry.InnerWidgetRegistry;
import com.onpositive.richtexteditor.viewer.IRichDocumentAutoStylingStrategy;
import com.onpositive.richtexteditor.viewer.IRichDocumentListener;
import com.onpositive.richtexteditor.viewer.undo.RichDocumentChange;

/**
 * @author 32kda
 * This class contains different utility methods 
 * and encapsulates common system interaction 
 */
public class LayerManager implements IPartitionListener, PaintObjectListener, FontStylesChangeListener {

	
	private ArrayList<IRichDocumentAutoStylingStrategy>autoStylers=new ArrayList<IRichDocumentAutoStylingStrategy>();
	
	/**
	 * @return Auto Stylers List
	 */
	public IRichDocumentAutoStylingStrategy[] getAutoStylingStrategies(){
		return autoStylers.toArray(new IRichDocumentAutoStylingStrategy[autoStylers.size()]);		
	}

	/**
	 * @param str new auto styling strategy
	 */
	public void addAutoStylingStrategy(IRichDocumentAutoStylingStrategy str){
		autoStylers.add(str);
	}
	
	/**
	 * @param str auto styling strategy to remove
	 */
	public void removeAutoStylingStrategy(IRichDocumentAutoStylingStrategy str){
		autoStylers.add(str);
	}
	
	
		/**
		 * @author kor
		 * Determines, that text is divided into partitions,
		 * and has lines, which can have aligns and bullets
		 */
		public final static class SimpleRichTextModel implements
			ISimpleRichTextModel {

		private List<Integer> aligns;
		private List<Object> bullets;
		private List<BasePartition> styles;
		private String text;

		/**
		 * Basic constructor 
		 * @param aligns line aligns list
		 * @param bullets line bullets list
		 * @param styles line styles list
		 * @param text Text
		 */
		public SimpleRichTextModel(List<Integer> aligns, List<Object> bullets,
				List<BasePartition> styles, String text) {
			super();
			this.aligns = aligns;
			this.bullets = bullets;
			this.styles = styles;
			this.text = text;
		}

		/** (non-Javadoc)
		 * @see com.onpositive.richtexteditor.model.ISimpleRichTextModel#getAlign(int)
		 */
		public int getAlign(int line) {
			return aligns.get(line);
		}

		/** (non-Javadoc)
		 * @see com.onpositive.richtexteditor.model.ISimpleRichTextModel#getBullet(int)
		 */
		public Object getBullet(int line) {
			return bullets.get(line);
		}

		/** (non-Javadoc)
		 * @see com.onpositive.richtexteditor.model.ISimpleRichTextModel#getLineCount()
		 */
		public int getLineCount() {
			return aligns.size();
		}

		/** (non-Javadoc)
		 * @see com.onpositive.richtexteditor.model.ISimpleRichTextModel#getPartitions()
		 */
		public List<BasePartition> getPartitions() {
			return styles;
		}

		/** (non-Javadoc)
		 * @see com.onpositive.richtexteditor.model.ISimpleRichTextModel#getText()
		 */
		public String getText() {
			return text;
		}

	}
	
	/**
	 * @author kor
	 * Incapsulates change of whole content of model
	 */
	public final class SetContentChange extends WorldChange implements IHandlesSelection{
		private final String oldContent;
		private int oldOffset;

		private SetContentChange(List<BasePartition> clonePartitions,
				List<Integer> oldAligns, List<Object> oldBullets,
				String oldContent,int oldOffset) {
			super(clonePartitions, oldAligns, oldBullets);
			this.oldContent = oldContent;
			this.oldOffset=oldOffset;
		}

		/**
		 * @param model
		 * @param caretOffset
		 */
		public SetContentChange(ISimpleRichTextModel model, int caretOffset)
		{
			super(model);
			this.oldContent=model.getText();
			this.oldOffset=caretOffset;
		}

		
		protected void apply(PartitionDelta delta) {
			try{
			editor.setRedraw(false);
			delta.clearAdded();
			delta.clearChanged(); //We don't need this any more, if we change whole content
			delta.setOptimizeParitions(false);
			layer.disconnectFromDocument();
			ILineAttributeModel lineAttributeModel = delta.getStorage().getLineAttributeModel();
			int lineCount = lineAttributeModel.lineCount();
			ArrayList<Integer> aligns=new ArrayList<Integer>();
			ArrayList<Object> bullets=new ArrayList<Object>();
			for (int a=0;a<lineCount;a++){
				aligns.add(lineAttributeModel.getLineAlign(a));
				bullets.add(lineAttributeModel.getBullet(a));
			}
			int pos=editor.getCaretOffset();
			String old=doc.get();
			try {
				doc.replace(0, doc.getLength(),
						oldContent);

				layer.connectToDocument(doc);
				
				
			} catch (BadLocationException e) {
				throw new IllegalStateException(e);
			}
			PartitionStorage storage = delta.getStorage();
			final List<BasePartition> clonePartitions = storage.clonePartitions();
					
			for (BasePartition p:newPartitions){
				delta.added(p);
			}
			storage.setPartitions(newPartitions);
			for (int a=0;a<this.aligns.length;a++){
				try{
				lineAttributeModel.setLineAlign(a, 0,this.aligns[a]);
				Object bullet = this.bullets[a];
				if (bullet!=null){
					lineAttributeModel.setLineBullet(a, 1,bullet);
				}
				}catch (Exception e) {
					//wrong number of lines
				}
			}
			delta.getUndoChange().add(new SetContentChange(clonePartitions,aligns,bullets,old,pos));
			editor.setSelection(oldOffset);
			}
			catch (Exception e) {
				Logger.log(e);
				
			}
			editor.setRedraw(true);
			editor.redraw();
		}
	}

	
	/**
	 * @author kor
	 * Incapsulates paste change
	 */
	public final class PasteChange extends Change implements IHandlesSelection{

		

		private final ISimpleRichTextModel model;
		private final int offset;

		private PasteChange(ISimpleRichTextModel listener, int offset) {
			this.model = listener;
			this.offset = offset;
		}

		
		protected void apply(PartitionDelta delta) {
			try {
				//delta.setOptimizeParitions(false);
				int lineNumber = doc.getLineOfOffset(offset);
				String insertedText = model.getText();
				List<BasePartition> partitions = layer.getPartitions();
				List<Integer> oldAligns = new ArrayList<Integer>();
				List<Object> oldBullets = new ArrayList<Object>();
				int lineCount = editor.getLineCount();
				for (int a = 0; a < lineCount; a++) {
					oldAligns.add(editor.getLineAlignment(a));
					oldBullets.add(editor.getLineBullet(a));
				}
				List<BasePartition> clonePartitions = layer.getStorage()
						.clonePartitions();
				final String oldContent = doc.get();
				delta.getUndoChange()
						.add(
								new SetContentChange(clonePartitions, oldAligns, oldBullets,
										oldContent,editor.getCaretOffset()));
				layer.disconnectFromDocument();
				doc.replace(offset, 0, insertedText);
				
				layer.connectToDocument(doc);

				List<BasePartition> newPartitions = model.getPartitions();

				for (BasePartition p : newPartitions) {
					p.setOffset(p.getOffset() + offset);
				}
				ArrayList<BasePartition> resultPartitions = new ArrayList<BasePartition>(
						partitions.size() + newPartitions.size());

				int insertionIndex;
				BasePartition partitionTail = null;
				for (insertionIndex = 0; insertionIndex < partitions.size(); insertionIndex++) {
					BasePartition curPartition = (BasePartition) partitions
							.get(insertionIndex);
					if (curPartition.getOffset() < offset) {
						resultPartitions.add(curPartition);
						if (curPartition.getOffset() + curPartition.getLength() > offset) {
							int oldLength = curPartition.getLength();
							curPartition.setLength(offset
									- curPartition.getOffset());
							partitionTail = new BasePartition(layer,
									curPartition.getOffset()
											+ curPartition.getLength()
											+ insertedText.length(), oldLength
											- curPartition.getLength());
							partitionTail.applyAttributes(curPartition);
						}
					} else {
						break;
					}
				}
				for (BasePartition p : newPartitions) {
					resultPartitions.add(p);
				}

				if (partitionTail != null)
					resultPartitions.add(partitionTail);

				for (; insertionIndex < partitions.size(); insertionIndex++) {
					BasePartition p = (BasePartition) partitions
							.get(insertionIndex);
					p.setOffset(p.getOffset() + insertedText.length());
					resultPartitions.add(p);
				}
				layer.storage.setPartitions(resultPartitions);
				for (int i = 0; i < model.getLineCount(); i++) { 
					int align = model.getAlign(i);
					if (align != LayerManager.FIT_ALIGN)
						editor.setLineAlignment(i + lineNumber, 1, align);
					else {
						editor.setLineAlignment(i + lineNumber, 1,
								LayerManager.LEFT_ALIGN);
						editor.setLineJustify(i + lineNumber, 1, true);
					}
					editor.setLineBullet(i + lineNumber, 1, (Bullet) model
							.getBullet(i));
				}
				editor.setStyleRanges(new StyleRange[0]);
				for (BasePartition p : resultPartitions) {
					delta.added(p);
				}
				editor.setCaretOffset(offset + insertedText.length());
				editor.setSelection(offset+insertedText.length());
			} catch (BadLocationException e) {
				throw new IllegalStateException();
			}
		}
	}

	/**
	 * Margin for contents displaying in editor window
	 */
	public static final int MARGIN = 10;

	protected ColorManager colorManager;
	private HashSet<IRichDocumentListener> richDocumentlisteners = new HashSet<IRichDocumentListener>();
	protected FontStyleManager fontStyleManager;
	protected ImageManager imageManager;

	protected StyledText editor;
	protected BasePartitionLayer layer;
	protected int currentAlign = -1;

	protected IDocument doc;

	protected BasePartition linkPrototypePartition;

	protected FontStyle boldFontStyle = new FontStyle(FontStyle.BOLD);
	protected FontStyle italicFontStyle = new FontStyle(FontStyle.ITALIC);
	protected FontStyle underlineFontStyle = new FontStyle(FontStyle.UNDERLINED);
	protected FontStyle strikethroughFontStyle = new FontStyle(
			FontStyle.STRIKETHROUGH);

	protected int hrWidth = 2;

	private IHTMLSerializerFactory serializerFactory;
	private IHTMLLoaderFactory loaderFactory;
	
	/**
	 * Left Text Align constant
	 */
	public static final int LEFT_ALIGN = SWT.LEFT;
	/**
	 * Right Text Align constant
	 */
	public static final int RIGHT_ALIGN = SWT.RIGHT;
	
	/**
	 * Center Text Align constant
	 */
	public static final int CENTER_ALIGN = SWT.CENTER;
	/**
	 * Fit Left Text Align/Justify constant
	 */
	public static final int FIT_ALIGN = 4;
	/**
	 * No list
	 */
	public static final int NONE_LIST = 0;
	/**
	 * Simple bulleted list
	 */
	public static final int BULLETED_LIST = 5;
	/**
	 * Numbered list
	 */
	public static final int NUMBERED_LIST = 6;
	/**
	 * Default line indent
	 */
	public static final int DEFAULT_INDENT = 0;

	protected Listener paintListener, repaintListener;
	protected KeyListener editorKeyListener;
	protected MouseListener editorMouseListener;

	protected InnerWidgetRegistry innerWidgetRegistry;
	
	/**
	 * @return Loader Factory
	 */
	public final IHTMLLoaderFactory getLoaderFactory() {
		return loaderFactory;
	}

	/**
	 * @param loaderFactory Loader Factory to set
	 */
	public final void setLoaderFactory(IHTMLLoaderFactory loaderFactory) {
		this.loaderFactory = loaderFactory;
	}

	/**
	 * @return Serializer factory
	 */
	public IHTMLSerializerFactory getSerializerFactory() {
		return serializerFactory;
	}

	/**
	 * @param serializerFactory Serializer factory to set
	 */
	public void setSerializerFactory(IHTMLSerializerFactory serializerFactory) {
		this.serializerFactory = serializerFactory;
	}

	protected void setLineIdentation(int offset, int length) {
		if (length > 0)
			return;
		int firstLine = editor.getLineAtOffset(offset);
		int lineIndent = editor.getLineIndent(firstLine);
		int alignment = editor.getLineAlignment(firstLine);
		if (editor.getCharCount() == 0) {
			alignment = currentAlign;
		}

		String str = editor.getContent().getLine(firstLine);
		if (str.equals("")) {
			if (alignment == LayerManager.CENTER_ALIGN) {
				int indent = editor.getClientArea().width / 2 - MARGIN + 1;
				if (lineIndent != indent)
					editor.setLineIndent(firstLine, 1, indent);
			} else if (alignment == LayerManager.RIGHT_ALIGN) {
				int indent = editor.getClientArea().width - MARGIN - 1;
				if (lineIndent != indent)
					editor.setLineIndent(firstLine, 1, indent);
			} else if (lineIndent != DEFAULT_INDENT)
				editor.setLineIndent(firstLine, 1, DEFAULT_INDENT);

		} else if (lineIndent != DEFAULT_INDENT)
			editor.setLineIndent(firstLine, 1, DEFAULT_INDENT);
	}

	/**
	 * Basic constructor
	 * @param newEditor StyledText widget
	 * @param newDoc Document to associate with
	 */
	public LayerManager(StyledText newEditor, IDocument newDoc) {
		editor = newEditor;
		innerWidgetRegistry = InnerWidgetRegistry.getInstanceFor(editor);
		doc = newDoc;
		
		paintListener = new Listener() {

			public void handleEvent(Event event) {
				setLineIdentation(editor.getCaretOffset(), 0);
			}

		};
		newEditor.addListener(SWT.Paint, paintListener);

		editorMouseListener = new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
					validateCaretPos(0);
			}

			public void mouseUp(MouseEvent e) {
			}

		};
		
		newEditor.addMouseListener(editorMouseListener);
		repaintListener = new Listener(){

			public void handleEvent(Event event) {
				editor.redraw();
			}
			
		};
		newEditor.addListener(SWT.Selection, repaintListener);
		newEditor.getVerticalBar().addListener(SWT.Selection, repaintListener);
		editorKeyListener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
					validateCaretPos(e.keyCode);
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		newEditor.addKeyListener(editorKeyListener);

		editor.setLineSpacing(8);
		newEditor.addPaintObjectListener(this);
		layer = createBasePartitionLayer();
		layer.connectToDocument(doc);
		layer.setManager(this);
		layer.addPartitionListener(this);
		colorManager = new ColorManager(editor.getDisplay());
		imageManager = new ImageManager(editor.getDisplay());
		fontStyleManager = createFontStyleManager();
		fontStyleManager.addFontStyleChangeListener(this);

		try {
			Method declaredMethod = StyledText.class.getDeclaredMethod(
					"setMargins", new Class[] { int.class, int.class,
							int.class, int.class, });
			declaredMethod.setAccessible(true);
			declaredMethod.invoke(editor, 10, 10, 10, 10);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		linkPrototypePartition = new BasePartition(layer, 0, 0);
		linkPrototypePartition.setStyleMask(FontStyle.UNDERLINED);
		linkPrototypePartition.setColorRGB(editor.getDisplay().getSystemColor(
				SWT.COLOR_BLUE).getRGB());
	}
	
	protected BasePartitionLayer createBasePartitionLayer()
	{
		return new BasePartitionLayer();
	}

	protected FontStyleManager createFontStyleManager()
	{
		return new FontStyleManager(editor.getDisplay());
	}

	/**
	 * Disposes all used resources
	 */
	public void dispose() 
	{
		editor.removeListener(SWT.Paint, paintListener);
		editor.removeListener(SWT.Selection, repaintListener);
		editor.getVerticalBar().removeListener(SWT.Selection, repaintListener);
		editor.removeKeyListener(editorKeyListener);
		editor.removeMouseListener(editorMouseListener);
		layer.disposeSpecialPartitionsData();
		layer.disconnectFromDocument();
		
		imageManager.dispose();
		colorManager.dispose();
		fontStyleManager.dispose();
	}	

	/**
	 * @return {@link FontRegistry} of {@link FontStyleManager} used by this class
	 */
	public FontRegistry getFontRegistry() {
		return fontStyleManager.getFontRegistry();
	}

	/**
	 * Current Font Partition is used for "delayed" applying of some
	 * partition style.
	 * This is needed in case, when user has selected some font style without 
	 * current selection and expects newly typed text will have selected style
	 * Current Font Partition is a dummy partition representing selected style
	 * @return Current Font Partition
	 */
	public BasePartition getCurrentFontPartition() {
		return layer.getCurrentFontPartition();
	}

	/**
	 * Current Font Partition is used for "delayed" applying of some
	 * partition style.
	 * This is needed in case, when user has selected some font style without 
	 * current selection and expects newly typed text will have selected style
	 * Current Font Partition is a dummy partition representing selected style
	 * @param currentFontPartition  Current Font Partition 
	 */
	public void setCurrentFontPartition(BasePartition currentFontPartition) {
		layer.setCurrentFontPartition(currentFontPartition);
	}

	/**
	 * Make some text bold/not bold
	 * @param offset Text offset
	 * @param length Text length
	 * @param apply Apply or remove bold attribute
	 */
	public void boldCommand(int offset, int length, boolean apply) {
		layer.fontStyleCommand(boldFontStyle, offset, length, apply);
	}

	/**
	 * Make some text italic/not italic
	 * @param offset Text offset
	 * @param length Text length
	 * @param apply Apply or remove italic attribute
	 */
	public void italicCommand(int offset, int length, boolean apply) {
		layer.fontStyleCommand(italicFontStyle, offset, length, apply);
	}

	/**
	 * Make some text strikethrough/not strikethrough
	 * @param offset Text offset
	 * @param length Text length
	 * @param apply Apply or remove strikethrough attribute
	 */
	public void strikethroughCommand(int offset, int length, boolean apply) {
		layer.fontStyleCommand(strikethroughFontStyle, offset, length, apply);
	}

	/**
	 * Make some text underlined/not underlined
	 * @param offset Text offset
	 * @param length Text length
	 * @param apply Apply or remove underlined attribute
	 */
	public void underlineCommand(int offset, int length, boolean apply) {
		layer.fontStyleCommand(underlineFontStyle, offset, length, apply);
	}
	
	/**
	 * Change some text's font
	 * @param fontStyleDisplayName name of font style selected in combo
	 * @param offset Text offset
	 * @param length Text length
	 */
	public void changeFontCommand(String fontStyleDisplayName, int offset,
			int length) {
		if (length != 0) {
			FontStyle style = fontStyleManager
					.getFontStyle(fontStyleDisplayName);
			layer.changeFontCommand(style, offset, length);
		}
	}

	
	/**
	 * Indicates, that data layer changed, and it's visualization nedd also be updated
	 * @param event Layer Event holding data about changes performed
	 */
	public void layerChanged(LayerEvent event) {
		
		Collection<IPartition> partitions = event.getChangedPartitions();
		for (Iterator<IPartition> iterator = partitions.iterator(); iterator
				.hasNext();) {
			IPartition part = iterator.next();
			// Logger.log(part);
			if (part instanceof BasePartition) {
				BasePartition fpartition = (BasePartition) part;
				if (fpartition.getPosition() == -1) {
					continue;
				}
				if (part instanceof ImagePartition) {
					ImagePartition partition = (ImagePartition) part;
					StyleRange styleRange = partition.getStyleRange(this);
					try {
						editor.setStyleRange(styleRange);
					} catch (Exception e) {
						Logger.log(e);
					}
				}
				if (part instanceof HRPartition) {
					HRPartition partition = (HRPartition) part;
					StyleRange styleRange = partition.getStyleRange(this);
					try {
						editor.setStyleRange(styleRange);
					} catch (Exception e) {
						Logger.log(e);
					}
				} else {
					StyleRange styleRange = fpartition.getStyleRange(this);
					styleRange.font = fontStyleManager.getFontForPartition(fpartition);
					try {
						editor.setStyleRange(styleRange);
					} catch (Exception e) {
						Logger.log(e);
					}
				}
			}
		}
		if (currentAlign > -1) {
			editor.setLineAlignment(0, 1, currentAlign);
			currentAlign = -1;
		}
		editor.redraw();
	}

	/**
	 * Indicates, that partition changed, and it's visualization nedd also be updated
	 * @param event Layer Event holding data about changes performed
	 */
	public void partitionChanged(PartitionEvent event) {
		BasePartition partition = (BasePartition) event.getPartition();
		StyleRange styleRange = partition.getStyleRange(this);
		styleRange.font = fontStyleManager.getFontForPartition(partition);
		try {
			editor.setStyleRange(styleRange);
		} catch (Exception e) {
			Logger.log(e);
		}
		editor.redraw();
	}

	

	/**
	 * Sets selected interval align
	 * @param offset Text offset
	 * @param length Text align
	 * @param align Align constant to set
	 */
	public void setIntervalAlign(int offset, int length, int align) {
		int firstLineNum = 0;
		int lastLineNum = 0;
		if (editor.getCharCount() == 0) {
			currentAlign = align;
			editor.redraw();
			return;
		}
		try {
			firstLineNum = doc.getLineOfOffset(offset);
			if (length == 0)
				lastLineNum = firstLineNum;
			else
				lastLineNum = doc.getLineOfOffset(offset + length - 1);
		} catch (BadLocationException e) {
			Logger.log(e);
		}
		int count = lastLineNum - firstLineNum;
		layer.execute(new SetAlignChange(align, count, firstLineNum));
	}

	/**
	 * Sets selected interval list style
	 * @param offset Text offset
	 * @param length Text align
	 * @param listStyle List style constant to set
	 */
	public void setIntervalList(int offset, int length, int listStyle) {
		int firstLineNum = 0;
		int lastLineNum = 0;
		try {
			firstLineNum = doc.getLineOfOffset(offset);
			if (length == 0)
				lastLineNum = firstLineNum;
			else
				lastLineNum = doc.getLineOfOffset(offset + length - 1);
		} catch (BadLocationException e) {
			Logger.log(e);
		}

		Bullet bullet = null;

		if (listStyle == BULLETED_LIST)
			bullet = BulletFactory.getNewBulletedListBulletInstance();
		else if (listStyle == NUMBERED_LIST)
			bullet = BulletFactory.getNewNumberedListBulletInstance();
		layer.execute(new SetBulletChange(firstLineNum, lastLineNum
				- firstLineNum + 1, bullet));

	}

	/**
	 * Sets selected interval foreground color
	 * @param color RGB color to set
	 */
	public void setSelectedIntervalForegroundColor(RGB color) {
		int offset = editor.getSelectionRange().x;
		int length = editor.getSelectionRange().y;

		FontStyle colorStyle = new FontStyle(0, color);
		if (length == 0)
			colorStyle.applyStyle(layer.getCurrentFontPartition());
		else
			layer.fontStyleCommand(colorStyle, offset, length, true);
	}

	/**
	 * Sets selected interval background color
	 * @param color RGB color to set
	 */
	public void setSelectedIntervalBackgroundColor(RGB color) {
		int offset = editor.getSelectionRange().x;
		int length = editor.getSelectionRange().y;
		FontStyle colorStyle = new FontStyle(0);
		colorStyle.setBgColor(color);
		if (length == 0)
			colorStyle.applyStyle(layer.getCurrentFontPartition());
		else
			layer.fontStyleCommand(colorStyle, offset, length, true);
	}

	/**
	 * @return Partition associated with manager
	 */
	public BasePartitionLayer getLayer() {
		return layer;
	}

	/**
	 * Inserts new link partition
	 * @param point point to insert this partition at
	 * @param name name of link
	 * @param url URL of link
	 */
	public void insertLinkPartititon(Point point, String name, String url) {
		LinkPartition partition = new LinkPartition(layer, point.x, name
				.length(), url, linkPrototypePartition);
		layer.replacePartitions(point.x, point.y, name, partition);
	}

	/**
	 * Used to manage control states and get information about
	 * selected text fragment
	 * @param offset Text offset
	 * @param length Text align
	 * @return Selection state
	 */
	public RichSelectionState defineSumStylePartition(int offset, int length) {
		List<BasePartition> parts = layer.getPartitions();
		BasePartition startPartition = (BasePartition) layer
				.getPartitionAtOffset(offset);
		if (startPartition == null)
			startPartition = (BasePartition) layer
					.getPartitionAtOffset(offset - 1);
		if (startPartition==null){
			startPartition=layer.storage.newPartition();
		}
		if (length == 0) {
			if (offset == startPartition.getOffset() && offset > 0) {
				BasePartition basePartition = (BasePartition) layer
						.getPartitions().get(startPartition.getPosition() - 1);
				return new RichSelectionState(Collections
						.singletonList(basePartition), basePartition);
			} else
				return new RichSelectionState(Collections
						.singletonList(startPartition), startPartition);
		}
		BasePartition endPartition = (BasePartition) layer
				.getPartitionAtOffset(offset + length - 1);
		List<BasePartition> ps = new ArrayList<BasePartition>();
		while (startPartition instanceof ObjectPartition
				&& startPartition != endPartition) {
			offset++;
			length--;
			startPartition = (BasePartition) layer.getPartitionAtOffset(offset);
		}
		if (startPartition == endPartition) {
			return new RichSelectionState(Collections
					.singletonList(startPartition), startPartition);
		}
		String sumFontName = startPartition.getFontDataName();
		boolean isBold = startPartition.isBold();
		boolean isItalic = startPartition.isItalic();
		boolean isUnderlined = startPartition.isUnderlined();
		boolean isStrikeThrough = startPartition.isStrikethrough();
		RGB color = startPartition.getColorRGB();
		RGB bgColor = startPartition.getColorRGB();

		int startIdx = layer.getPartitions().indexOf(startPartition);
		int endIdx = layer.getPartitions().indexOf(endPartition);
		for (int i = startIdx + 1; i <= endIdx; i++) {
			BasePartition partition = (BasePartition) parts.get(i);
			ps.add(partition);
			if (!sumFontName.equals(partition.getFontDataName()))
				sumFontName = "";
			if (!(partition instanceof ObjectPartition))
			{
				if (!partition.isBold())
					isBold = isBold & partition.isBold();
				if (!partition.isItalic())
					isItalic = false;
				if (!partition.isUnderlined())
					isUnderlined = false;
				if (!partition.isStrikethrough())
					isStrikeThrough = false;
			}
			boolean b = color != null && partition.getColorRGB() != null
					&& color.equals(partition.getColorRGB());
			if (!b) {
				color = null;
			}
			b = bgColor != null && partition.getBgColorRGB() != null
					&& bgColor.equals(partition.getBgColorRGB());
			if (!b) {
				bgColor = null;
			}
		}
		if (bgColor == null) {
			bgColor = new RGB(255, 255, 255);
		}
		BasePartition res = new BasePartition(layer, 0, 0);
		res.setFontDataName(sumFontName);
		res.setBold(isBold);
		res.setItalic(isItalic);
		res.setUnderlined(isUnderlined);
		res.setStrikethrough(isStrikeThrough);
		res.setColorRGB(color);
		res.setBgColorRGB(bgColor);
		return new RichSelectionState(ps, res);
	}

	/**
	 * Used to define several lines align style
	 * @param startLineNum starting line index
	 * @param endLineNum finishing line index
	 * @return one of align constant values, if all lines of interval
	 * have same align, 0 otherwise
	 */
	public int defineSumAlignStyle(int startLineNum, int endLineNum) {
		int align = editor.getLineAlignment(startLineNum);
		boolean justify = editor.getLineJustify(startLineNum);
		for (int i = startLineNum + 1; i <= endLineNum; i++) {
			if (editor.getLineAlignment(i) != align
					|| editor.getLineJustify(i) != justify)
				return 0;
		}
		if (justify)
			return LayerManager.FIT_ALIGN;
		return align;
	}

	/**
	 * Used to define several lines list style
	 * @param startLineNum starting line index
	 * @param endLineNum finishing line index
	 * @return one of list constant values, if all lines of interval
	 * have same list style, NONE_LIST otherwise
	 */
	public int defineSumListStyle(int startLineNum, int endLineNum) {
		Bullet bullet = editor.getLineBullet(startLineNum);
		for (int i = startLineNum + 1; i <= endLineNum; i++) {
			if (editor.getLineBullet(i) != bullet)
				return NONE_LIST;
		}
		if (bullet != null) {
			if (bullet.type == ST.BULLET_DOT)
				return BULLETED_LIST;
			if ((bullet.type & ST.BULLET_NUMBER) != 0)
				return NUMBERED_LIST;
		}
		return NONE_LIST;
	}

	/**
	 * @return {@link StyledText} associated with LayerManager
	 */
	public StyledText getEditor() {
		return editor;
	}

	/**
	 * Loads image from file and inserts it into text
	 * @param filename image file name
	 */
	public void addNewImage(String filename) {
		// check if key already exists
		Image image2 = imageManager.checkImage(filename);
		if (image2 == null) {
			try {
				image2 = new Image(editor.getDisplay(), filename);
				imageManager.registerImage(filename, image2);
			} catch (Exception e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(),
						"Error during attempt to insert image", e.getMessage());
				return;
			}
		}
		int offset = editor.getCaretOffset();
		ImagePartition pa = new ImagePartition(layer, offset, 1, image2,filename);
		layer.replacePartitions(offset, 0, "?", pa);
	}
	
	/**
	 * Adds new inner StyledText control, representing inner region
	 */
	public void addNewRegion() {
		StyledText widget = new StyledText(editor, SWT.BORDER);
		addWidgetPartition(widget);
	}
	
	public void addWidgetPartition(Composite widget)
	{		
		int offset = editor.getCaretOffset();
		char prevChar = 0;
		try
		{
			prevChar = doc.get(offset - 1, 1).charAt(0);
		} catch (BadLocationException e)
		{}
		if (offset > 0 && prevChar != '\r' && prevChar != '\n')
		{
			BasePartition part = new BasePartition(layer, offset, 1); // Add a new line first
			layer.replacePartitions(offset, 0, "\n", part);
			offset++;
		}

		String regionStr = "?\n"; // And here add new HR partition


		final RegionPartition partition = new RegionPartition(layer, offset, regionStr.length(), widget);
		partition.getWrapper().addRegionCompositeWrapperListener(new IRegionCompositeWrapperListener(){

			public void handleEvent(RegionCompositeEvent event)
			{
				if (event.getType() == RegionCompositeEvent.LINE_COUNT_CHANGE)
					editor.setStyleRange(partition.getStyleRange(LayerManager.this));
				else if (event.getType() == RegionCompositeEvent.CARET_MOVE)
				{
					int y = ((Caret)event.getObject()).getLocation().y;
					int globalY = partition.getTopLevelObject().getLocation().y + y;
					if (globalY < 0)
					{
						editor.setTopPixel(editor.getTopPixel() + globalY);						
					}
					else if (globalY > editor.getSize().y)
					{
						editor.setTopPixel(editor.getTopPixel() + globalY - editor.getSize().y + editor.getLineHeight() + MARGIN);	
					}
					
				}
			}});
		editor.setRedraw(false);
		layer.replacePartitions(offset, 0, regionStr, partition);
		partition.setSize(editor.getClientArea().width - MARGIN * 2, partition.getInitialHeight() + MARGIN);		
		editor.setStyleRange(partition.getStyleRange(LayerManager.this));
		innerWidgetRegistry.addRedrawedControl((Control) partition.getObject());
		editor.setRedraw(true);
		editor.redraw();
		validateCaretPos(0);
	}
	
//	public void addNewSourceCodeRegion(String fileName) 
//	{
//		/*TextEditor textEditor = new TextEditor(){
//			
//			public boolean isEditable()
//			{
//				return true;
//			}
//			@Override
//			public IWorkbenchPartSite getSite()
//			{
//				
//				return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite();
//			}
//			
//		};
//		Document document = new Document("System.out.println(\"preved!\");");
//		
//		JavaTextTools tools= JavaPlugin.getDefault().getJavaTextTools();		
//		IPreferenceStore store= JavaPlugin.getDefault().getCombinedPreferenceStore();
//		JavaSourceViewer viewer= new JavaSourceViewer(editor, null, null, false, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL, store);
//		viewer.setDocument(document);		
//		tools.setupJavaDocumentPartitioner(document, IJavaPartitions.JAVA_PARTITIONING);
//		
//		SimpleJavaSourceViewerConfiguration configuration= new SimpleJavaSourceViewerConfiguration(tools.getColorManager(), store, null, IJavaPartitions.JAVA_PARTITIONING, false);
//
//		viewer.configure(configuration);*/
//		
//		Composite editorForContentType = ContentTypeEditorProvider.getEditorForContentType(fileName, editor);
//		addWidgetPartition(editorForContentType);
//	}
	
	/**
	 * Inserts new text breaking line (hr)
	 */
	public void addNewHR() {
		int offset = editor.getCaretOffset(); // Add a new line first
/*		BasePartition part = new BasePartition(layer, offset, 1);
		layer.replacePartitions(offset, 0, "\n", part);
		offset++;*/

		String hrStr = "\n?\n"; // And here add new HR partition
		HRPartition hrp = new HRPartition(layer, offset, hrStr.length());
		layer.replacePartitions(offset, 0, hrStr, hrp);
	}

	/**
	 * Is it a  hr line at offset?
	 * @param offset Offset to check
	 * @return true, if partition at that offset is HRPartition
	 */
	public boolean isHRLine(int offset) {
		if (layer.getPartitionAtOffset(offset) instanceof HRPartition)
			return true;
		return false;
		
	}

	/**
	 * responsible for painting "special" objects in editor window,
	 * like images or hr's
	 * @param event Paint Object Event
	 */
	public void paintObject(PaintObjectEvent event) {
		GC gc = event.gc;		
		StyleRange style = event.style;
		int start = style.start;		
		IPartition partitionAtOffset = layer.getPartitionAtOffset(start);
		if (partitionAtOffset instanceof ImagePartition) {
			ImagePartition partition = (ImagePartition) partitionAtOffset;
			Image image = partition.getImage();

			int x = event.x;
			int y = event.y + event.ascent - style.metrics.ascent;
			if (image != null) {
				gc.drawImage(image, x, y);
			} else {
				gc.drawText("?", x, y);
			}
		}
		if (partitionAtOffset instanceof RegionPartition) {			
			RegionPartition partition = (RegionPartition) partitionAtOffset;
			Point pt = partition.getSize();
			int x = event.x + 5;
			int y = event.y;// + event.ascent - 2 * pt.y / 3;
			if (pt.x == 0 || pt.y == 0) 
				partition.setSize(editor.getClientArea().width - MARGIN * 2, partition.getInitialHeight() + MARGIN);
			partition.setLocation(x, y);	
			innerWidgetRegistry.addRedrawedControl((Control) partition.getTopLevelObject());
		}
		if (partitionAtOffset instanceof HRPartition) {
			gc.setLineAttributes(new LineAttributes(hrWidth));
			if (((HRPartition) partitionAtOffset).getColor(this) != null)
				gc.setForeground(((HRPartition) partitionAtOffset)
						.getColor(this));
			if (((HRPartition) partitionAtOffset).getBgColor(this) != null)
				gc.setForeground(((HRPartition) partitionAtOffset)
						.getBgColor(this));
			gc.setLineStyle(SWT.LINE_SOLID);
			gc.drawLine(event.x, event.y, editor.getClientArea().width,
							event.y);
			
			/*BasePartition prevPartition, nextPartition; //TODO This doesn't worx well, having ugly artifacts
			int position = ((HRPartition) partitionAtOffset).getPosition();
			if (position > 0)
			{
				prevPartition = layer.get(position - 1);
				if (!(prevPartition instanceof ObjectPartition))
					editor.redrawRange(prevPartition.getOffset(),prevPartition.getLength(),false);
			}
			if (position < layer.size() - 1)
			{
				nextPartition = layer.get(position + 1);
				if (!(nextPartition instanceof ObjectPartition))
					editor.redrawRange(nextPartition.getOffset(),nextPartition.getLength(),false);
				
			}*/
			
		}
	}

	/**
	 * Opens HTML file and loads it's contents into editor
	 * @param filename HTML file name
	 */
	public void openHTMLFile(String filename) {
		ISimpleRichTextModel z=null;
		try {
			z = getTextHTMLLoader().parse(new FileInputStream(filename));
		} catch (Exception e) {
			MessageDialog.openError(editor.getShell(), "Unable to open file",e.getMessage());
			return;
		}
		int oldLength;
		editor.setRedraw(false);
		try{
		layer.setIgnoreDocumentEvents(true);
		oldLength = doc.getLength();
		doc.set(z.getText());
		layer.setIgnoreDocumentEvents(false);
		List<BasePartition> partitions = z.getPartitions();
		layer.storage.setPartitions(partitions);
		int lineCount = z.getLineCount();
		for (int i = 0; i < lineCount; i++) {
			int align = z.getAlign(i);
			if (align != LayerManager.FIT_ALIGN)
				editor.setLineAlignment(i, 1, align);
			else {
				editor.setLineAlignment(i, 1, LayerManager.LEFT_ALIGN);
				editor.setLineJustify(i, 1, true);
			}
			Bullet bullet = (Bullet) z.getBullet(i);
			editor.setLineBullet(i, 1, bullet);
		}
		layerChanged(new LayerEvent(layer,
				new ArrayList<IPartition>(partitions)));
		}finally{
			editor.setRedraw(true);
		}
		 fireRichDocumentEvent(new DocumentEvent(doc, 0, oldLength, z.getText()), new PartitionDelta(layer.getStorage()));
	}

	/**
	 * Used to paste HTML contained in the clipboard 
	 * @param contents HTML string
	 * @param offset offset, where to paste
	 */
	public void pasteHTML(String contents, int offset) {
		editor.setRedraw(false);
		try{
			ISimpleRichTextModel model = getTextHTMLLoader().parse(contents);
			paste(offset, model);
		} catch (BadLocationException e) {
			throw new RuntimeException();
		} finally {
			editor.setRedraw(true);
		}
	}

	/**
	 * Used to paste some ISimpleRichTextModel contents 
	 * @param offset where to paste
	 * @param model model containing, what to paste
	 * @throws BadLocationException never thrown normally
	 */
	public void paste(final int offset, final ISimpleRichTextModel model)
			throws BadLocationException {
		Change change = new PasteChange(model, offset);
		layer.execute(change);
	}
	
	/**
	 * Used to paste some ISimpleRichTextModel contents 
	 * @param offset where to paste
	 * @param model model containing, what to paste
	 * @throws BadLocationException never thrown normally
	 */
	public void set(final ISimpleRichTextModel model)
			throws BadLocationException {
		Change change = new SetContentChange(model,getEditor().getCaretOffset());
		layer.execute(change);
	}

	/**
	 * Used for content serializing into HTML file
	 * @param fileName fileName, where to serialize
	 */
	public void serializeToFile(String fileName) {
		TextSerializer serializer = getTextSerializer();
		try {
			PrintWriter pw = new PrintWriter(fileName);
			serializer.serializeAll(pw);
			pw.close();
		} catch (Exception e) {
			MessageDialog.openError(editor.getShell(), "Error during HTML serialization", e.getMessage());
		}
	}

	/**
	 * Used for content serializing into single string
	 * @return HTML string
	 */
	public String getSerializedString() {
		TextSerializer serializer = getTextSerializer();
		return serializer.serializeAllToStr();
	}
	
	/**
	 * Used for content serializing into single string
	 * @return HTML string
	 */
	public String getSerializedWikiString() {
		TextSerializer serializer = new HTMLSerializer(this);
		return serializer.serializeAllToStr();
	}
	
	

	protected TextSerializer getTextSerializer() {
		if (serializerFactory!=null){
			return serializerFactory.getNewSerializer(this);
		}
		TextSerializer serializer = new HTMLSerializer(this);		
		return serializer;
	}
	
	protected IHTMLLoader getTextHTMLLoader() {
		if (loaderFactory==null){
			return new DefaultHTMLLoader(this);
		}
		return loaderFactory.getHTMLLoader(this);
	}	
	
	/**
	 * Serializes selected text interval into HTML
	 * @return String with HTML
	 */
	public String getSelectedHTML() {
		TextSerializer serializer = getTextSerializer();
		Point selection = editor.getSelection();		
		if (selection.y - selection.x > 0) {
			try {
				return serializer.serializeToStr(selection);
			} catch (BadLocationException e) {

				Logger.log(e);
			}
		}
		return null;
	}
	
	public String getContentsHTML()
	{
		return getTextSerializer().serializeAllToStr();		
	}
	
	
	/**
	 * @return {@link ImageManager} of this {@link LayerManager}
	 */
	public ImageManager getImageManager() {
		return imageManager;
	}

	/**
	 * @param documentListener new documentListener to add
	 */
	public void addRichDocumentListener(IRichDocumentListener documentListener) {
		richDocumentlisteners.add(documentListener);
	}

	/**
	 * @param documentListener documentListener to remove
	 */
	public void removeRichDocumentListener(
			IRichDocumentListener documentListener) {
		richDocumentlisteners.remove(documentListener);
	}

	/**
	 * Method for event handling
	 * @param event DocumentEvent instance
	 */
	public void fireDocumentGoingToChange(DocumentEvent event) {
		for (IRichDocumentListener l : richDocumentlisteners) {
			l.documentAboutToBeChanged(event);
		}
	}

	/**
	 * Method for event handling
	 * @param event DocumentEvent instance
	 * @param processChange change to perform
	 */
	public void fireRichDocumentEvent(DocumentEvent event,
			PartitionDelta processChange) {
		for (IRichDocumentListener l : richDocumentlisteners) {
			l.documentChanged(event, new RichDocumentChange(processChange));
		}
	}

	/**
	 * @return {@link FontStyleManager} of this {@link LayerManager}
	 */
	public FontStyleManager getFontStyleManager() {
		return fontStyleManager;
	}

	/**
	 * @return {@link ColorRegistry} of this {@link LayerManager}
	 */
	public ColorManager getColorRegistry() {
		return colorManager;
	}

	
	/**
	 * Used to shift caret, if it's situated in "wrong" place,
	 * like hr line
	 * @param keyCode Key pressed code
	 * @throws BadLocationException 
	 */
	public void validateCaretPos(int keyCode){
		int offset = getEditor().getCaretOffset();
		BasePartition curPartition = (BasePartition) getLayer()
				.getPartitionAtOffset(offset);
		if (curPartition != null && curPartition.requiresSingleLine()) {
			if (keyCode == SWT.ARROW_UP || keyCode == SWT.ARROW_LEFT)
				getEditor().setCaretOffset(curPartition.getOffset()/* - 1*/);
			else
			{
				char charAt = 'a'; //Because 'a' is'nt a whitespace char
				try
				{
					charAt = doc.get(offset,1).charAt(0);
				} catch (BadLocationException e)
				{}
				if (curPartition.getOffset() != offset || !Character.isWhitespace(charAt))
				getEditor().setCaretOffset(
						curPartition.getOffset() + curPartition.getLength());
			}
		}
	}

	/**
	 * @return document  associated with this {@link LayerManager}
	 */
	public IDocument getDocument() {
		return doc;
	}

	/**
	 * @return dummy {@link BasePartition}, which have a style same as all {@link LinkPartition}s
	 * must have
	 */
	public BasePartition getLinkPrototype() {
		return linkPrototypePartition;
	}

	/** (non-Javadoc)
	 * @see com.onpositive.richtexteditor.model.FontStylesChangeListener#stylesChanged(java.util.ArrayList)
	 */
	public void stylesChanged(ArrayList<FontStyle> changedStyles)
	{
		LayerEvent event = new LayerEvent(layer);
		List<BasePartition> partitions = layer.getStorage().getPartitions();
		for (Iterator<FontStyle> iterator = changedStyles.iterator(); iterator.hasNext();)
		{
			FontStyle fontStyle = (FontStyle) iterator.next();
			for (Iterator<BasePartition> iterator2 = partitions.iterator(); iterator2
					.hasNext();)
			{
				BasePartition partition = (BasePartition) iterator2.next();
				if (partition.getFontDataName().equals(fontStyle.getFontDataName()))
				{
					fontStyle.applyStyle(partition);
					event.addChangedPartition(partition);
				}
			}
		}
		layerChanged(new LayerEvent(layer,(Collection)partitions));
		
	}
	
	/**
	 * True, if some style is in use by some partition
	 * @param style Style to check
	 * @return True, if style is in use by some partition, false otherwise
	 */
	public boolean isStyleUsed(FontStyle style)
	{
		for (int i = 0; i < layer.getStorage().getPartitions().size(); i++)
		{
			if (layer.getStorage().getPartitions().get(i).getFontDataName().equals(style.getFontDataName()))
				return true;
		}
		return false;
	}
	
	/**
	 * Used to remove specified style from all partitions and replace it by default style
	 * @param style Styl to remove
	 */
	public void removeStyleFromAllPartitions(FontStyle style)
	{
		LayerEvent event = new LayerEvent(layer);
		for (int i = 0; i < layer.getStorage().getPartitions().size(); i++)
		{
			if (layer.getStorage().getPartitions().get(i).getFontDataName().equals(style.getFontDataName()))
			{
				fontStyleManager.getDefaultStyle().setStyle(layer.getStorage().getPartitions().get(i));
				event.addChangedPartition(layer.getStorage().getPartitions().get(i));
			}
		}
		layerChanged(event);
	}

	public void setRefreshVisibleState(boolean refresh)
	{
		editor.setRedraw(refresh);		
	}

	/**
	 * It's a stub, intended to be overrided in subclasses
	 * @param offset 
	 * @param item 
	 */
	public void addNewlinesIfNeeded(int offset, String selectedFontName)
	{
		
	}

	public int getLineDelimiterLength()
	{
		// TODO Auto-generated method stub
		return 2;
	}
  	
}
