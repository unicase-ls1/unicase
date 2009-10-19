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

package com.onpositive.richtexteditor.viewer;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.ToolBar;

import com.onpositive.richtexteditor.actions.ActionFactory;
import com.onpositive.richtexteditor.model.IPartition;
import com.onpositive.richtexteditor.model.ISimpleRichTextModel;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.model.Logger;
import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.registry.InnerWidgetRegistry;

/**
 * @author kor
 * Source viewer subclass with some features like toolbar
 * auto styling strategy ant etc.
 */
public class RichTextViewer extends SourceViewer {

	private static final String EXTENDED_STYLED_TEXT_CLASS = "org.eclipse.swt.custom.ExtendedStyledText";

	protected IContributionManager toolbarManager;

	private MenuManager menuManager = new MenuManager();

	private ArrayList<IRichDocumentListener> listeners = new ArrayList<IRichDocumentListener>();

	private ArrayList<IRichDocumentAutoStylingStrategy> autoStyling = new ArrayList<IRichDocumentAutoStylingStrategy>();

	protected RichTextViewerControlConfiguration configuration;

	private Composite viewerArea;
	protected LayerManager manager;
	protected ActionFactory factory;
	private int style;
	
	private boolean initToolbarManager = true; //Should we fill tollbar with initial contents?
	//We need this, if we want to use external toolbar manager, for example, from some configuration

	/**
	 * @return menu manager object
	 */
	public final MenuManager getMenuManager() {
		return menuManager;
	}
	

	/**
	 * Simple constructor
	 * @param parent parent component
	 * @param style style bitmask
	 */
	public RichTextViewer(Composite parent, int style) {
		super(parent, new VerticalRuler(16), SWT.WRAP | SWT.V_SCROLL
				| SWT.H_SCROLL|SWT.BORDER);
		this.style = style;
	}
	
	

	/**
	 * Tells this viewer whether the registered auto edit strategies should be ignored.
	 * @param ignore <code>true</code> if the strategies should be ignored.
	 * @since 2.1
	 */
	public void ignoreAutoEditStrategies(boolean ignore) {
		super.ignoreAutoEditStrategies(ignore);
	}

	protected void createControl(Composite parent, int styles) 
	{
		configuration = getConfiguration();
		viewerArea = new Composite(parent, style);
		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 0;
		layout.marginHeight = 2;
		viewerArea.setLayout(layout);

		if (configuration.isCreateToolbar()) {
			toolbarManager = createToolbarManager();			
			Label la=new Label(viewerArea,SWT.SEPARATOR|SWT.HORIZONTAL);
			la.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		super.createControl(viewerArea, styles);
		Control control = super.getControl();
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		IDocument doc = new Document();
		setDocument(doc, new AnnotationModel());		
		final StyledText textWidget = getTextWidget();		
				
		textWidget.addPaintListener(new PaintListener()
		{

			public void paintControl(PaintEvent e)
			{
				final InnerWidgetRegistry registry = InnerWidgetRegistry.getInstanceFor(textWidget);				
				final Control[] children = textWidget.getChildren();
				final Point globalWidgetSize = textWidget.getSize();
				for (int i = 0; i < children.length; i++)
				{
					if (!registry.wasRedrawed(children[i]))
					{						
						children[i].setLocation(globalWidgetSize.x + 10, globalWidgetSize.y + 10);
					}
				}
				registry.clear();
			}
			
		});
		
		
		manager = createLayerManager(textWidget, doc);
		factory = createActionFactory();
		manager.addRichDocumentListener(factory);
		
		initActions();
		if (toolbarManager != null) {
			toolbarManager.update(true);
		}
		menuManager = new MenuManager();
		menuManager.createContextMenu(textWidget);
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				fillPopupMenu(menuManager);
			}

		});
		hookListeners();
	}

	protected LayerManager createLayerManager(StyledText textWidget, IDocument doc)
	{
		return new LayerManager(textWidget, doc);
	}


	protected void fillPopupMenu(MenuManager menuManager) {

	}

	protected ActionFactory createActionFactory() {
		return new ActionFactory(manager, this);
	}
	
	protected void delayedConfigureActionFactory(ActionFactory factory)
	{
		factory.delayedConfigure(manager, this);
	}
	
	protected IContributionManager createToolbarManager() 
	{		
		ToolBar toolBar = new ToolBar(viewerArea, SWT.HORIZONTAL|SWT.FLAT);
		toolBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return new ToolBarManager(toolBar);
	}
	
	/**
	 * @param model
	 */
	public void changeDocument(ISimpleRichTextModel model)
	{
		
		manager.getLayer().setFireEvents(false);
		try
		{			
			manager.set(model);
		} catch (BadLocationException e)
		{}
		manager.getLayer().setFireEvents(true);
	}
	
	
	/**
	 * @return the initToolbarManager
	 */
	public boolean isInitToolbarManager()
	{
		return initToolbarManager;
	}


	
	/**
	 * @param initToolbarManager the initToolbarManager to set
	 */
	public void setInitToolbarManager(boolean initToolbarManager)
	{
		this.initToolbarManager = initToolbarManager;
	}


	public String getContentsHTML()
	{
		if (manager != null) return manager.getContentsHTML();
		return "";
	}

	private void hookListeners() {
		addTextInputListener(new ITextInputListener() {
			public void inputDocumentAboutToBeChanged(IDocument oldInput,
					IDocument newInput) {
			}

			public void inputDocumentChanged(IDocument oldInput,
					IDocument newInput) {
				manager.dispose();
				if (newInput != null)
				{
					manager = new LayerManager(getTextWidget(), newInput);
					configureManager();
					factory.setManager(manager);
					manager.addRichDocumentListener(factory);
				}
			}
		});
		getTextWidget().addVerifyKeyListener(new VerifyKeyListener() {

			public void verifyKey(VerifyEvent e) {
				handleKey(e);
			}

		});
	}

	protected void initActions() {
		if (configuration.isCreateToolbar()) {
			factory.fillToolbarManager(toolbarManager);
		}
	}

	

	
	protected void customizeDocumentCommand(DocumentCommand command) {
		int offset = command.offset;
		int length = command.length;
		if (length == 0) {
			super.customizeDocumentCommand(command);
			return;
		}
		IPartition part1 = manager.getLayer().getPartitionAtOffset(offset);
		IPartition part2 = manager.getLayer().getPartitionAtOffset(
				offset + length - 1);
		if (part1 instanceof BasePartition
				&& ((BasePartition) part1).requiresFullDeletion()) {
			int diff = part1.getOffset() - command.offset;
			command.offset = part1.getOffset();
			command.length += diff;
		}
		if (part2 instanceof BasePartition
				&& ((BasePartition) part2).requiresFullDeletion())
			command.length = part2.getLength() + part2.getOffset()
					- command.offset;
		super.customizeDocumentCommand(command);
	}

	
	protected StyledText createTextWidget(Composite parent, int styles) {
		try {
			Class<?> forName = Class.forName(EXTENDED_STYLED_TEXT_CLASS);
			Constructor<?> constructor = forName.getConstructor(new Class[] {
					Composite.class, int.class });
			final StyledText control = (StyledText) constructor.newInstance(parent, styles);			
			return control;
		} catch (Exception e) {

		}
		return super.createTextWidget(parent, styles);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.jface.text.source.SourceViewer#getControl()
	 */
	public Control getControl() {
		return viewerArea;
	}

	/**
	 * @return Toolbar manager
	 */
	public IContributionManager getToolbarManager() {
		return toolbarManager;
	}

	/**
	 * @return LayerManager instance
	 */
	public LayerManager getLayerManager() {
		return manager;
	}

	// TODO Refactor it later
	protected void handleKey(VerifyEvent e) {
		if ((e.keyCode == 'v' || e.keyCode == 'v')
				&& ((e.stateMask & SWT.MOD1) != 0)
				|| ((e.keyCode == SWT.INSERT) && (e.stateMask & SWT.MOD2) != 0)) {
			pasteOperation(e);
		}
		else if ((e.keyCode == SWT.DEL&& (e.stateMask & SWT.MOD2) != 0)){
			cutOperation();
		}
		else if ((e.keyCode == 'a' || e.keyCode == 'A')
				&& (((e.stateMask & SWT.MOD1) != 0))) {
			selectAllOperation(e);
		}
		else if ((e.keyCode == 'c' || e.keyCode == 'C')
				&& (((e.stateMask & SWT.MOD1) != 0))) {
			copyOperation(e);
		}
		else if ((e.keyCode == 'b' || e.keyCode == 'B')
				&& (((e.stateMask & SWT.MOD1) != 0))) {
			boldOperation(e);
		}
		else if ((e.keyCode == 'i' || e.keyCode == 'I')
				&& (((e.stateMask & SWT.MOD1) != 0))) {
			italicOperation(e);
		}
		else if ((e.keyCode == 'u' || e.keyCode == 'U')
				&& (((e.stateMask & SWT.MOD1) != 0))) {
			underlineOperation(e);
		}
		else if ((e.keyCode == 'z' || e.keyCode == 'Z')
				&& (((e.stateMask & SWT.MOD1) != 0))) {
			doOperation(TextViewer.UNDO);
		}
		else if ((e.keyCode == 'y' || e.keyCode == 'Y')
				&& (((e.stateMask & SWT.MOD1) != 0))) {
			doOperation(TextViewer.REDO);
		}
	}

	private void pasteOperation(VerifyEvent e) {
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		HTMLTransfer instance = HTMLTransfer.getInstance();
		TransferData[] availableTypes = clipboard.getAvailableTypes();
		for (TransferData d : availableTypes) {
			boolean supportedType = instance.isSupportedType(d);
			if (supportedType) {
				String contents = (String) clipboard.getContents(instance);
				manager.pasteHTML(contents, getTextWidget()
						.getCaretOffset());
				e.doit = false;
			}
		}
	}

	private void cutOperation() {
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		HTMLTransfer instance = HTMLTransfer.getInstance();
		String selectedHTML = manager.getSelectedHTML();
		TextTransfer textTransfer = TextTransfer.getInstance();
		if (selectedHTML != null) {
			clipboard.setContents(new Object[] { selectedHTML ,manager.getEditor().getSelectionText()},
					new Transfer[] { instance ,textTransfer});
		}
		Point selectedRange = getSelectedRange();
		try {
			getDocument().replace(selectedRange.x, selectedRange.y,"");
		} catch (BadLocationException e1) {
			Logger.log(e1);			
		}
	}

	private void selectAllOperation(VerifyEvent e) {
		manager.getEditor().setSelection(0, manager.getEditor().getCharCount());
		e.doit=false;
	}

	private void copyOperation(VerifyEvent e) {
		Clipboard clipboard = new Clipboard(Display.getCurrent());
		HTMLTransfer instance = HTMLTransfer.getInstance();
		String selectedHTML = manager.getSelectedHTML();
		TextTransfer textTransfer = TextTransfer.getInstance();
		if (selectedHTML != null) {
			clipboard.setContents(new Object[] { selectedHTML ,manager.getEditor().getSelectionText()},
					new Transfer[] { instance ,textTransfer});
		}
		e.doit=false;
	}

	private void boldOperation(VerifyEvent e) {
		IAction boldAction = factory.getBoldAction();
		boolean checked = boldAction.isChecked();
		boldAction.setChecked(!checked);
		boldAction.run();
		boldAction.setChecked(!checked);
		if (toolbarManager != null) {
			toolbarManager.update(true);
		}
		e.doit = false;
	}

	private void italicOperation(VerifyEvent e) {
		IAction italicAction = factory.getItalicAction();
		boolean checked = italicAction.isChecked();
		italicAction.setChecked(!checked);
		italicAction.run();
		italicAction.setChecked(!checked);
		if (toolbarManager != null) {
			toolbarManager.update(true);
		}
		e.doit = false;
	}

	private void underlineOperation(VerifyEvent e) {
		IAction underlineAction = factory.getUnderlineAction();
		boolean checked = underlineAction.isChecked();
		underlineAction.setChecked(!checked);
		underlineAction.run();
		underlineAction.setChecked(!checked);
		if (toolbarManager != null) {
			toolbarManager.update(true);
		}
		e.doit = false;
	}

	/**
	 * @param richDocumentListener {@link IRichDocumentListener} to add
	 */
	public void addRichDocumentListener(
			IRichDocumentListener richDocumentListener) {
		listeners.add(richDocumentListener);
		getLayerManager().addRichDocumentListener(richDocumentListener);
	}

	/**
	 * @param strategy {@link IRichDocumentAutoStylingStrategy} to remove
	 */
	public void removeRichDocumentAutoStylingStrategy(
			IRichDocumentAutoStylingStrategy strategy) {
		autoStyling.remove(strategy);
		getLayerManager().removeAutoStylingStrategy(strategy);
	}

	/**
	 * @param strategy {@link IRichDocumentAutoStylingStrategy} to add
	 */
	public void addRichDocumentAutoStylingStrategy(
			IRichDocumentAutoStylingStrategy strategy) {
		autoStyling.add(strategy);
		getLayerManager().addAutoStylingStrategy(strategy);
	}

	/**
	 * @param richDocumentListener {@link IRichDocumentListener} to remove
	 */
	public void removeRichDocumentListener(
			IRichDocumentListener richDocumentListener) {
		listeners.remove(richDocumentListener);
		getLayerManager().removeRichDocumentListener(richDocumentListener);
	}

	protected void configureManager() {
		for (IRichDocumentListener l : listeners) {
			manager.addRichDocumentListener(l);
		}
		for (IRichDocumentAutoStylingStrategy l : autoStyling) {
			manager.addAutoStylingStrategy(l);
		}
		configuration.configureLayerManager(manager);
	}

	
	/**
	 * @return the autoStylingStrtegies
	 */
	public ArrayList<IRichDocumentAutoStylingStrategy> getAutoStylingStrategies()
	{
		return autoStyling;
	}

	
	/**
	 * @param autoStyling the autoStylingStrtegies to set
	 */
	public void setAutoStylingStrategies(
			ArrayList<IRichDocumentAutoStylingStrategy> autoStyling)
	{
		this.autoStyling = autoStyling;
	}
	
	/**
	 * @param toolbarManager the toolbarManager to set
	 */
	public void setToolbarManager(IContributionManager toolbarManager)
	{
		this.toolbarManager = toolbarManager;
	}
	
	public RichTextViewerControlConfiguration getConfiguration()
	{
		if (configuration == null) 
			configuration = new RichTextViewerControlConfiguration();
		return configuration;		
	}


}
