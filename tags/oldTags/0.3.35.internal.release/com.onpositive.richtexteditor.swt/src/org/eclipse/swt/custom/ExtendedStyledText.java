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
package org.eclipse.swt.custom;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.internal.BidiUtil;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

/**
 * 
 * @author kor
 *
 */
public class ExtendedStyledText extends StyledText{

	private static final int BULLET_INDENT = 20;


	int getVisualLineIndex(TextLayout layout, int offsetInLine) {
		int lineIndex = layout.getLineIndex(offsetInLine);
		int[] offsets = layout.getLineOffsets();
		if (lineIndex != 0 && offsetInLine == offsets[lineIndex]) {
			int lineY = layout.getLineBounds(lineIndex).y;
			int caretY = getCaret().getLocation().y - getLinePixel(getCaretLine());
			if (lineY > caretY) lineIndex--;
	 	}
		return lineIndex;
	}

	
	void setCaretLocation() {
		// TODO Auto-generated method stub
		super.setCaretLocation();
	}

	public ExtendedStyledText(Composite parent, int style) {
		super(parent, style);
		renderer = new Renderer(getDisplay(), this);
		renderer.setContent(content);
		renderer.setFont(getFont(), tabLength);
	}
	
	/**
	 * Scrolls text to the right to use new space made available by a resize.
	 */
	void claimRightFreeSpace() {
		int newHorizontalOffset = Math.max(0, renderer.getWidth() - (clientAreaWidth - leftMargin(-1) - rightMargin));
		if (newHorizontalOffset < horizontalScrollOffset) {			
			// item is no longer drawn past the right border of the client area
			// align the right end of the item with the right border of the 
			// client area (window is scrolled right).
			scrollHorizontal(newHorizontalOffset - horizontalScrollOffset, true);					
		}
	}
	
	private int leftMargin(int i) {
		if (i==-1){
			return leftMargin;
		}
		Bullet lineBullet = getLineBullet(i);
		if (lineBullet!=null){
			return leftMargin+BULLET_INDENT;
		}
		return leftMargin;
	}

	public Point computeSize (int wHint, int hHint, boolean changed) {
		checkWidget();
		int lineCount = (getStyle() & SWT.SINGLE) != 0 ? 1 : content.getLineCount();
		int width = 0;
		int height = 0;
		if (wHint == SWT.DEFAULT || hHint == SWT.DEFAULT) {
			Display display = getDisplay();
			int maxHeight = display.getClientArea().height;
			for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
				TextLayout layout = renderer.getTextLayout(lineIndex);
				int wrapWidth = layout.getWidth();
				if (wordWrap) layout.setWidth(wHint == 0 ? 1 : wHint);
				Rectangle rect = layout.getBounds();
				height += rect.height;
				width = Math.max(width, rect.width);
				layout.setWidth(wrapWidth);
				renderer.disposeTextLayout(layout);
				if (isFixedLineHeight() && height > maxHeight) break;
			}
			if (isFixedLineHeight()) {
				height = lineCount * renderer.getLineHeight();
			}
		}
		// Use default values if no text is defined.
		if (width == 0) width = DEFAULT_WIDTH;
		if (height == 0) height = DEFAULT_HEIGHT;
		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;
		int wTrim = leftMargin(-1) + rightMargin + getCaretWidth();
		int hTrim = topMargin + bottomMargin;
		Rectangle rect = computeTrim(0, 0, width + wTrim, height + hTrim);
		return new Point (rect.width, rect.height);
	}
	
	/** 
	 * A mouse move event has occurred.  See if we should start autoscrolling.  If
	 * the move position is outside of the client area, initiate autoscrolling.  
	 * Otherwise, we've moved back into the widget so end autoscrolling.
	 */
	void doAutoScroll(Event event) {
		if (event.y > clientAreaHeight) {
			doAutoScroll(SWT.DOWN, event.y - clientAreaHeight);
		} else if (event.y < 0) {
			doAutoScroll(SWT.UP, -event.y);
		} else if (event.x < leftMargin(-1) && !wordWrap) {
			doAutoScroll(ST.COLUMN_PREVIOUS, leftMargin(-1) - event.x);
		} else if (event.x > clientAreaWidth - leftMargin(-1) - rightMargin && !wordWrap) {
			doAutoScroll(ST.COLUMN_NEXT, event.x - (clientAreaWidth - leftMargin(-1) - rightMargin));
		} else {
			endAutoScroll();
		}
	}
	
	Rectangle getBoundsAtOffset(int offset) {
		int lineIndex = content.getLineAtOffset(offset);
		int lineOffset = content.getOffsetAtLine(lineIndex);
		String line = content.getLine(lineIndex);
		Rectangle bounds;
		if (line.length() != 0) {
			int offsetInLine = offset - lineOffset;
			TextLayout layout = renderer.getTextLayout(lineIndex);
			bounds = layout.getBounds(offsetInLine, offsetInLine);
			renderer.disposeTextLayout(layout);
		} else {
			bounds = new Rectangle (0, 0, 0, renderer.getLineHeight());
		}
		if (offset == caretOffset) {
			int lineEnd = lineOffset + line.length();
			if (offset == lineEnd && caretAlignment == PREVIOUS_OFFSET_TRAILING) {
				bounds.width += getCaretWidth();
			}
		}
		bounds.x += -leftMargin(lineIndex) - horizontalScrollOffset;
		bounds.y += getLinePixel(lineIndex);
		return bounds;
	}
	
	void setCaretLocation(Point location, int direction) {
		Caret caret = getCaret();
		if (caret != null) {
			boolean isDefaultCaret = caret == defaultCaret;
			int lineHeight = renderer.getLineHeight();
			int caretHeight = lineHeight;
			int ps=caretHeight;
			if (!isFixedLineHeight() && isDefaultCaret) {
				Rectangle boundsAtOffset = getBoundsAtOffset(caretOffset);
				caretHeight = boundsAtOffset.height;
				ps=caretHeight;
				if (getCharCount()>0){
					StyleRange styleRangeAtOffset = getStyleRangeAtOffset(Math.max(caretOffset-1,0));
					TextLayout la=new TextLayout(getDisplay());	
					if (caretOffset>0){
						la.setText(getText(caretOffset-1,caretOffset-1));
					}
					else{
						la.setText(getText(caretOffset,caretOffset));
					}
					if (styleRangeAtOffset!=null){
					la.setStyle(styleRangeAtOffset, 0, 1);
					}					
					caretHeight= la.getLineMetrics(0).getHeight();
					int descent = la.getDescent();
					int asceent = la.getAscent();
					la.dispose();					
					if (ps!=caretHeight){
						location.y=boundsAtOffset.y+ps-caretHeight+descent+asceent-4;//caretHeight);
					}
				}
				
				if (caretHeight != lineHeight) {
					direction = SWT.DEFAULT;
				}
			}
			int imageDirection = direction;
			if (isMirrored()) {
				if (imageDirection == SWT.LEFT) {
					imageDirection = SWT.RIGHT;
				} else if (imageDirection == SWT.RIGHT) {
					imageDirection = SWT.LEFT;
				}
			}
			if (isDefaultCaret && imageDirection == SWT.RIGHT) {
				location.x -= (caret.getSize().x - 1);
			}
			if (isDefaultCaret) {
				caret.setBounds(location.x, location.y, caretWidth, caretHeight);
			} else {
				caret.setLocation(location);
			}
			getAccessible().textCaretMoved(getCaretOffset());
			if (direction != caretDirection) {
				caretDirection = direction;
				if (isDefaultCaret) {
					if (imageDirection == SWT.DEFAULT) {
						defaultCaret.setImage(null);
					} else if (imageDirection == SWT.LEFT) {
						defaultCaret.setImage(leftCaretBitmap);
					} else if (imageDirection == SWT.RIGHT) {
						defaultCaret.setImage(rightCaretBitmap);
					}
				}
				if (caretDirection == SWT.LEFT) {
					BidiUtil.setKeyboardLanguage(BidiUtil.KEYBOARD_NON_BIDI);
				} else if (caretDirection == SWT.RIGHT) {
					BidiUtil.setKeyboardLanguage(BidiUtil.KEYBOARD_BIDI);
				}
			}
		}
		columnX = location.x;
	}
	
	/**
	 * Returns the offset at the specified x location in the specified line.
	 *
	 * @param x	x location of the mouse location
	 * @param line	line the mouse location is in
	 * @return the offset at the specified x location in the specified line,
	 * 	relative to the beginning of the document
	 */
	int getOffsetAtPoint(int x, int y, int lineIndex) {
		TextLayout layout = renderer.getTextLayout(lineIndex);
		x += horizontalScrollOffset - leftMargin(lineIndex);
		int[] trailing = new int[1];	
		int offsetInLine = layout.getOffset(x, y, trailing);
		caretAlignment = OFFSET_LEADING;
		if (trailing[0] != 0) {
			int lineInParagraph = layout.getLineIndex(offsetInLine + trailing[0]);
			int lineStart = layout.getLineOffsets()[lineInParagraph];
			if (offsetInLine + trailing[0] == lineStart) {
				offsetInLine += trailing[0];
				caretAlignment = PREVIOUS_OFFSET_TRAILING;
			} else {
				String line = content.getLine(lineIndex);			
				int level;
				int offset = offsetInLine;
				while (offset > 0 && Character.isDigit(line.charAt(offset))) offset--;
				if (offset == 0 && Character.isDigit(line.charAt(offset))) {
					level = isMirrored() ? 1 : 0;
				} else {
					level = layout.getLevel(offset) & 0x1;
				}
				offsetInLine += trailing[0];
				int trailingLevel = layout.getLevel(offsetInLine) & 0x1;
				if ((level ^ trailingLevel) != 0) {
					caretAlignment = PREVIOUS_OFFSET_TRAILING;
				} else {
					caretAlignment = OFFSET_LEADING;
				}
			}
		}
		renderer.disposeTextLayout(layout);
		return offsetInLine + content.getOffsetAtLine(lineIndex);
	}
	
	int getOffsetAtPoint(int x, int y, int[] trailing, boolean inTextOnly) {
		if (inTextOnly && y + getVerticalScrollOffset() < 0 || x + horizontalScrollOffset < 0) {
			return -1;
		}
		int bottomIndex = getPartialBottomIndex();
		int height = getLinePixel(bottomIndex + 1);
		if (inTextOnly && y > height) {
			return -1;
		}
		int lineIndex = getLineIndex(y);
		int lineOffset = content.getOffsetAtLine(lineIndex);
		TextLayout layout = renderer.getTextLayout(lineIndex);	
		x += horizontalScrollOffset - leftMargin(lineIndex) ;
		y -= getLinePixel(lineIndex);
		int offset = layout.getOffset(x, y, trailing);
		Rectangle rect = layout.getLineBounds(layout.getLineIndex(offset));
		renderer.disposeTextLayout(layout);
		if (inTextOnly && !(rect.x  <= x && x <=  rect.x + rect.width)) {
			return -1;
		}
		return offset + lineOffset;
	}
	
	Point getPointAtOffset(int offset) {
		int lineIndex = content.getLineAtOffset(offset);
		String line = content.getLine(lineIndex);
		int lineOffset = content.getOffsetAtLine(lineIndex);
		int offsetInLine = offset - lineOffset;
		int lineLength = line.length();
		if (lineIndex < content.getLineCount() - 1) {
			int endLineOffset = content.getOffsetAtLine(lineIndex + 1) - 1;
			if (lineLength < offsetInLine && offsetInLine <= endLineOffset) {
				offsetInLine = lineLength;
			}
		}
		Point point;
		TextLayout layout = renderer.getTextLayout(lineIndex);
		if (lineLength != 0  && offsetInLine <= lineLength) {
			if (offsetInLine == lineLength) {
				point = layout.getLocation(offsetInLine - 1, true);
			} else {
				switch (caretAlignment) {
					case OFFSET_LEADING:
						point = layout.getLocation(offsetInLine, false);
						break;
					case PREVIOUS_OFFSET_TRAILING:
					default:
						if (offsetInLine == 0) {
							point = layout.getLocation(offsetInLine, false);
						} else {
							point = layout.getLocation(offsetInLine - 1, true);
						}
						break;
				}
			}
		} else {
			point = new Point(layout.getIndent(), 0);
		}
		renderer.disposeTextLayout(layout);
		point.x += leftMargin(lineIndex) - horizontalScrollOffset;
		
		point.y += getLinePixel(lineIndex);
		return point;
	}

	
	



	/**
	 * Renders the invalidated area specified in the paint event.
	 *
	 * @param event paint event
	 */
	void handlePaint(Event event) {
		if (event.width == 0 || event.height == 0) return;
		if (clientAreaWidth == 0 || clientAreaHeight == 0) return;

		int startLine = getLineIndex(event.y);
		int y = getLinePixel(startLine);
		int endY = event.y + event.height;
		GC gc = event.gc;
		Color background = getBackground();
		Color foreground = getForeground();
		int lm=leftMargin(-1);
		if (endY > 0) {
			int lineCount = isSingleLine() ? 1 : content.getLineCount();
			
			for (int i = startLine; y < endY && i < lineCount; i++) {
				int x = leftMargin(i) - horizontalScrollOffset;
				
				y += renderer.drawLine(i, x, y, gc, background, foreground);
			}
			if (y < endY) {
				gc.setBackground(background);
				drawBackground(gc, 0, y, clientAreaWidth, endY - y);
			}
		}
		// fill the margin background
		gc.setBackground(background);
		if (topMargin > 0) {
			drawBackground(gc, 0, 0, clientAreaWidth, topMargin);
		}
		if (bottomMargin > 0) {
			drawBackground(gc, 0, clientAreaHeight - bottomMargin, clientAreaWidth, bottomMargin);
		}
		if (lm > 0) {
			drawBackground(gc, 0, 0, lm, clientAreaHeight);
		}
		if (rightMargin > 0) {
			drawBackground(gc, clientAreaWidth - rightMargin, 0, rightMargin, clientAreaHeight);
		}
	}

	
	/**
	 * Returns the smallest bounding rectangle that includes the characters between two offsets.
	 *
	 * @param start offset of the first character included in the bounding box
	 * @param end offset of the last character included in the bounding box 
	 * @return bounding box of the text between start and end
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 * @exception IllegalArgumentException <ul>
	 *   <li>ERROR_INVALID_RANGE when start and/or end are outside the widget content</li> 
	 * </ul>
	 * @since 3.1
	 */
	public Rectangle getTextBounds(int start, int end) {
		checkWidget();	
		int contentLength = getCharCount();	
		if (start < 0 || start >= contentLength || end < 0 || end >= contentLength || start > end) {
			SWT.error(SWT.ERROR_INVALID_RANGE);
		}
		int lineStart = content.getLineAtOffset(start);
		int lineEnd = content.getLineAtOffset(end);
		Rectangle rect;
		int y = getLinePixel(lineStart);
		int height = 0;
		int left = 0x7fffffff, right = 0;
		for (int i = lineStart; i <= lineEnd; i++) {
			int lineOffset = content.getOffsetAtLine(i);		
			TextLayout layout = renderer.getTextLayout(i);
			int length = layout.getText().length();
			if (length > 0) {
				if (i == lineStart) {
					if (i == lineEnd) {
						rect = layout.getBounds(start - lineOffset, end - lineOffset);
					} else {
						rect = layout.getBounds(start - lineOffset, length);
					}
					y += rect.y;
				} else if (i == lineEnd) {
					rect = layout.getBounds(0, end - lineOffset);
				} else {
					rect = layout.getBounds();
				}
				left = Math.min(left, rect.x);
				right = Math.max(right, rect.x + rect.width);
				height += rect.height;
			} else {
				height += renderer.getLineHeight();
			}
			renderer.disposeTextLayout(layout);
		}
		rect = new Rectangle (left, y, right-left, height);
		rect.x += leftMargin(lineStart) - horizontalScrollOffset;
		return rect;
	}
	
	
	
	int getWrapWidth (int i) {
		if (wordWrap && !isSingleLine()) {
			int width = clientAreaWidth - leftMargin(i)-5 - rightMargin - getCaretWidth();
			return width > 0 ? width : 1;
		}
		return -1;
	}
	
	void internalRedrawRange(int start, int length) {
		if (length <= 0) return;
		int end = start + length;
		int startLine = content.getLineAtOffset(start);
		int endLine = content.getLineAtOffset(end);
		int partialBottomIndex = getPartialBottomIndex();
		int partialTopIndex = getPartialTopIndex();
		if (startLine > partialBottomIndex || endLine < partialTopIndex) {
			return;
		}
		if (partialTopIndex > startLine) {
			startLine = partialTopIndex;
			start = 0;
		} else {
			start -= content.getOffsetAtLine(startLine);
		}
		if (partialBottomIndex < endLine) {
			endLine = partialBottomIndex + 1;
			end = 0;
		} else {
			end -= content.getOffsetAtLine(endLine);
		}

		TextLayout layout = renderer.getTextLayout(startLine);
		int lineX = leftMargin(startLine) - horizontalScrollOffset, startLineY = getLinePixel(startLine);
		int[] offsets = layout.getLineOffsets();
		int startIndex = layout.getLineIndex(Math.min(start, layout.getText().length()));
		
		/* Redraw end of line before start line if wrapped and start offset is first char */
		if (wordWrap && startIndex > 0 && offsets[startIndex] == start) {
			Rectangle rect = layout.getLineBounds(startIndex - 1);
			rect.x = rect.width;
			rect.width = clientAreaWidth - rightMargin - rect.x;
			rect.x += lineX;
			rect.y += startLineY;
			super.redraw(rect.x, rect.y, rect.width+BULLET_INDENT, rect.height, false);
		}
		
		if (startLine == endLine) {
			int endIndex = layout.getLineIndex(Math.min(end, layout.getText().length()));
			if (startIndex == endIndex) {
				/* Redraw rect between start and end offset if start and end offsets are in same wrapped line */
				Rectangle rect = layout.getBounds(start, end - 1);
				rect.x += lineX;
				rect.y += startLineY;
				super.redraw(rect.x, rect.y, rect.width+BULLET_INDENT, rect.height, false);
				renderer.disposeTextLayout(layout);
				return;
			}
		}

		/* Redraw start line from the start offset to the end of client area */
		Rectangle startRect = layout.getBounds(start, offsets[startIndex + 1] - 1);
		if (startRect.height == 0) {
			Rectangle bounds = layout.getLineBounds(startIndex);
			startRect.x = bounds.width;
			startRect.y = bounds.y;
			startRect.height = bounds.height;
		}
		startRect.x += lineX;
		startRect.y += startLineY;
		startRect.width = clientAreaWidth - rightMargin - startRect.x;
		super.redraw(startRect.x, startRect.y, startRect.width+BULLET_INDENT, startRect.height, false);

		/* Redraw end line from the beginning of the line to the end offset */
		if (startLine != endLine) {
			renderer.disposeTextLayout(layout);
			layout = renderer.getTextLayout(endLine);
			offsets = layout.getLineOffsets();
		}
		int endIndex = layout.getLineIndex(Math.min(end, layout.getText().length()));
		Rectangle endRect = layout.getBounds(offsets[endIndex], end - 1);
		if (endRect.height == 0) {
			Rectangle bounds = layout.getLineBounds(endIndex);
			endRect.y = bounds.y;
			endRect.height = bounds.height;
		}
		endRect.x += lineX;
		endRect.y += getLinePixel(endLine);
		super.redraw(endRect.x, endRect.y, endRect.width+BULLET_INDENT, endRect.height, false);
		renderer.disposeTextLayout(layout);

		/* Redraw all lines in between start and end line */
		int y = startRect.y + startRect.height;
		if (endRect.y > y) {
			super.redraw(leftMargin(-1), y, clientAreaWidth - rightMargin - leftMargin(-1)+BULLET_INDENT, endRect.y - y, false);
		}
	}


	private int adjustMargin(int startLine, int lm) {
		return lm+BULLET_INDENT;
	}



	private boolean hasBullet(int startLine) {
		return getLineBullet(startLine)!=null;
	}
}
