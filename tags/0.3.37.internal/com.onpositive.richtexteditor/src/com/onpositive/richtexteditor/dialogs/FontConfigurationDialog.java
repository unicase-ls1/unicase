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

package com.onpositive.richtexteditor.dialogs;

import java.util.Iterator;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.onpositive.richtexteditor.model.FontStyle;
import com.onpositive.richtexteditor.model.resources.ColorManager;
import com.onpositive.richtexteditor.model.resources.DisposableFontRegistry;
import com.onpositive.richtexteditor.model.resources.FontStyleData;
import com.onpositive.richtexteditor.model.resources.FontStyleManager;


/**
 * @author 32kda
 * Dialog for customizing font styles
 */
public class FontConfigurationDialog extends org.eclipse.jface.dialogs.Dialog implements SelectionListener, ISelectionChangedListener, IPropertyChangeListener
{
	protected class ViewerContentProvider implements IStructuredContentProvider
	{

		public Object[] getElements(Object inputElement)
		{			
			return data.getFontStyles().toArray();
		}

		public void dispose()
		{
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
		{
		}
		
	}
	
	protected String dialogTitle = "Customize Font Styles";
	ColorSelector foregroundColorSelector, backgroundColorSelector;
	Label foregroundColorLabel, backgroundColorLabel, fontFaceLabel;
	protected Button ñolorCheckbox, backgroundColorCheckbox, fontFaceCheckBox, fontFaceSelectButton;
	protected ToolItem addButton, deleteButton, renameButton;
	protected ImageRegistry toolImageRegistry;
	StyledText preview;
	FontStyleData data;
	
	protected static final RGB RGB_BLACK = new RGB(0,0,0);
	protected String addImageString = "ADD_IMAGE";
	protected String deleteImageString = "DELETE_IMAGE";
	protected String renameImageString = "RENAME_IMAGE";
	
	DisposableFontRegistry fontRegistry;
	
	ColorManager colorManager;
	protected TableViewer viewer;
	
	/** (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#create()
	 */
	public void create()
	{
		super.create();
		preview.setText("Aa");
		preview.setEditable(false);
	}
	
	protected void fillRegistry()
	{
		for (Iterator<FontStyle> iterator = data.getFontStyles().iterator(); iterator.hasNext();)
		{
			FontStyle style = (FontStyle) iterator.next();
			fontRegistry.put(style.getFontDataName(),data.getParentFontRegistry().get(style.getFontDataName()).getFontData());
		}
	}
	
	/**
	 * Basic constructor
	 * @param parent parent window
	 * @param manager current FontStyleManager
	 */
	public FontConfigurationDialog(Shell parent, FontStyleManager manager)
	{
		super(parent);		
		this.data = new FontStyleData(manager.getFontStylesList(),(DisposableFontRegistry) manager.getFontRegistry());
		colorManager = new ColorManager(parent.getDisplay());	
		fontRegistry = new DisposableFontRegistry(parent.getDisplay());
		fillRegistry();
		toolImageRegistry = new ImageRegistry(this.createShell().getDisplay());
		toolImageRegistry.put(addImageString,new Image(this.createShell().getDisplay(),FontConfigurationDialog.class.getResourceAsStream("add.gif")));
		toolImageRegistry.put(deleteImageString,new Image(this.createShell().getDisplay(),FontConfigurationDialog.class.getResourceAsStream("delete.gif")));
		toolImageRegistry.put(renameImageString,new Image(this.createShell().getDisplay(),FontConfigurationDialog.class.getResourceAsStream("rename.gif")));
	}
	
	protected Control createDialogArea(Composite parent)
	{
		getShell().setText(dialogTitle);
		Composite composite = new Composite(parent, SWT.NONE);
		
		GridLayout layout = new GridLayout(4, true);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Composite  leftPanel = new Composite(composite, SWT.NONE);
		leftPanel.setLayout(new GridLayout(1,true));
		
		ToolBar bar = new ToolBar(leftPanel,SWT.HORIZONTAL);
		addButton = createToolItem(bar, SWT.PUSH, "",toolImageRegistry.get(addImageString), this);
		deleteButton = createToolItem(bar, SWT.PUSH, "",toolImageRegistry.get(deleteImageString), this);	    
		renameButton = createToolItem(bar, SWT.PUSH, "",toolImageRegistry.get(renameImageString), this);
		
		viewer = new TableViewer(leftPanel, SWT.BORDER);
		viewer.getTable().setLayoutData(new GridData(130,200));
		//viewer.add(data.getFontStyles().toArray());
		viewer.addSelectionChangedListener(this);
		viewer.setContentProvider(new ViewerContentProvider());
	   // viewer.getTable().setLinesVisible(true);
	    viewer.setInput(data.getFontStyles());
	    viewer.refresh(false, true);
	   


		Group rightPanel = new Group(composite, SWT.SHADOW_NONE);
		rightPanel.setText("Current style");
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
	    gridData.horizontalSpan = 3;
	    gridData.verticalAlignment = SWT.BEGINNING;
	    gridData.heightHint = 240;
	    rightPanel.setLayoutData(gridData);
	    rightPanel.setLayout(new GridLayout(6, false));
	    
	    GridData rGridData = new GridData(GridData.FILL_HORIZONTAL);
	    rGridData.horizontalSpan = 4;
	    //rightPanel.setLayoutData(rGridData);
	    
	    
	    createLabel(rightPanel,"Use colors");
        ñolorCheckbox = createCheckBox(rightPanel);
        ñolorCheckbox.addSelectionListener(this);
	    Label stub = new Label(rightPanel, SWT.NONE); //Stub  for correct layout showing	    
	    stub.setLayoutData(getGridDataForHorizontalSpan(4));
        
	    foregroundColorLabel = createLabel(rightPanel,"Foreground Color: ");
	    foregroundColorSelector = new ColorSelector(rightPanel);
	    foregroundColorSelector.getButton().setLayoutData(rGridData);
	    foregroundColorSelector.setColorValue(new RGB(0,0,0));
	    foregroundColorSelector.addListener(this);
	    new Label(rightPanel, SWT.NONE); //Stub  for correct layout showing
	    
	    backgroundColorLabel = createLabel(rightPanel,"Background Color: ");
	    backgroundColorSelector = new ColorSelector(rightPanel);
	    backgroundColorSelector.getButton().setLayoutData(rGridData);
	    backgroundColorSelector.setColorValue(new RGB(255,255,255));
	    backgroundColorSelector.addListener(this);
	    new Label(rightPanel, SWT.NONE); //Stub  for correct layout showing

	    fontFaceLabel = createLabel(rightPanel, "Font Face: ");
	    fontFaceSelectButton = new Button(rightPanel, SWT.PUSH);
	    fontFaceSelectButton.setText("Select...");
	    fontFaceSelectButton.setLayoutData(rGridData);
	    fontFaceSelectButton.addSelectionListener(this);
	    new Label(rightPanel, SWT.NONE); //Stub  for correct layout showing
	    new Label(rightPanel, SWT.NONE); //Stub  for correct layout showing
	  	    
	    Group previewGroup = new Group(rightPanel, SWT.SHADOW_NONE);
	    previewGroup.setLayout(new GridLayout());
	    GridData gd1 = new GridData(470,90);
	    gd1.horizontalSpan = 6;
	    previewGroup.setLayoutData(gd1);
	    previewGroup.setText("Preview");
	    preview = new StyledText(previewGroup, SWT.BORDER);
	    GridData displayData = new GridData(450,70);
	    displayData.horizontalSpan = 6;
	    displayData.horizontalAlignment = SWT.CENTER;
	    preview.setLayoutData(displayData);
	    
	    
		return composite;
	}
	
	protected GridData getGridDataForHorizontalSpan(int span)
	{
		GridData gd = new GridData();
		gd.horizontalSpan = span;
		return gd;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#close()
	 */
	
	public boolean close()
	{
		colorManager.dispose();
		fontRegistry.dispose();
		return super.close();
	}
	
	/**
	 * Incapsulates button adding process
	 * @param parent Parent, on which button will be placed
	 * @param style Style of new button
	 * @param text Text label for button
	 * @param listener SelectionListener for button
	 * @return created button link
	 */
	public Button addContentsButton(Composite parent, int style, String text, SelectionListener listener)	
	{
		Button button = new Button(parent,style);
		button.setText(text);
		if (listener != null) button.addSelectionListener(listener);
		return button;
	}
	
	protected ToolItem createToolItem(ToolBar bar, int style, String text, Image image, SelectionListener listener)
	{
		ToolItem item = new ToolItem(bar, style);
		item.setText(text);
		if (image != null) item.setImage(image);
		if (listener != null) item.addSelectionListener(listener);
		return item;
	}
	
	protected Label createLabel(Composite parent, String text)
	{
		 Label label = new Label(parent, SWT.NULL);
		 label.setText(text);
		 return label;
	}
	
	protected Button createCheckBox(Composite parent)
	{
		Button checkBox = new Button(parent, SWT.CHECK);
		return checkBox;
	}

	
	/**
	 * @return the data
	 */
	public FontStyleData getData()
	{
		return data;
	}

	/** (non-Javadoc)
	 * Used for processing button events
	 * @param event the Event 
	 */
	public void selectionChanged(SelectionChangedEvent event)
	{
		if (event.getSource() == viewer)
		{
			int idx = viewer.getTable().getSelectionIndex();
			if (idx == -1 && viewer.getTable().getItemCount() > 0)
			{
				idx = 0;
				viewer.getTable().select(idx);
			}
			String selectedName = data.getFontStyles().get(idx).getFontDataName();			
			fontFaceSelectButton.setText(fontRegistry.get(selectedName).getFontData()[0].getName());
			
			FontStyle selectedStyle = getSelectedStyle();
			ñolorCheckbox.setSelection(false);
			if (selectedStyle.getColor() != null)
			{
				ñolorCheckbox.setSelection(true);
				foregroundColorSelector.setColorValue(selectedStyle.getColor());
				colorManager.getColor(selectedStyle.getColor());
			}
			else
				foregroundColorSelector.setColorValue(new RGB(0,0,0));
			if (selectedStyle.getBgColor() != null)
			{
				ñolorCheckbox.setSelection(true);
				backgroundColorSelector.setColorValue(selectedStyle.getBgColor());
				colorManager.getColor(selectedStyle.getBgColor());
			}
			else
				backgroundColorSelector.setColorValue(new RGB(255,255,255));
			foregroundColorSelector.setEnabled(ñolorCheckbox.getSelection());
			backgroundColorSelector.setEnabled(ñolorCheckbox.getSelection());
			updatePreview();
		}
			
	}
	
	protected FontStyle getSelectedStyle()
	{
		int idx = viewer.getTable().getSelectionIndex();
		return data.getFontStyles().get(idx);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	/** (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e)
	{
		if (e.getSource() == ñolorCheckbox)
		{
			foregroundColorSelector.setEnabled(ñolorCheckbox.getSelection());
			backgroundColorSelector.setEnabled(ñolorCheckbox.getSelection());
			if (!ñolorCheckbox.getSelection())
			{
				getSelectedStyle().setColor(null);
				getSelectedStyle().setBgColor(null);
				updatePreview();
			}
		}
		else if (e.getSource() == fontFaceSelectButton)
		{			
			FontDialog dialog = new FontDialog(this.createShell());
			dialog.setFontList(fontRegistry.getFontData(getSelectedStyle().getFontDataName()));
			dialog.setRGB(getSelectedStyle().getColor());
			dialog.open();
			if (dialog.getFontList() != null &&
				!fontRegistry.getFontData(getSelectedStyle().getFontDataName()).equals(dialog.getFontList()))
			{
				fontRegistry.put(getSelectedStyle().getFontDataName(), dialog.getFontList());
				fontFaceSelectButton.setText(dialog.getFontList()[0].getName());
				data.addChangedStyle(getSelectedStyle());
			}
			if (dialog.getRGB() != null && !dialog.getRGB().equals(getSelectedStyle().getColor()))
			{
				ñolorCheckbox.setSelection(true);
				foregroundColorSelector.setEnabled(true);
				foregroundColorSelector.setColorValue(dialog.getRGB());
				backgroundColorSelector.setEnabled(true);
				getSelectedStyle().setColor(dialog.getRGB());
				data.addChangedStyle(getSelectedStyle());
			}
			updatePreview();
		}
		else if (e.getSource() == addButton)
		{
			String str = NameDialog.openNameDialog("New style name:","New style",this.createShell(),null);
			if (str != null)
			{
				String newIdent = getCorrectStyleName(str);
				FontStyle fs = new FontStyle(0,newIdent,str);
				data.getFontStyles().add(fs);
				fontRegistry.put(newIdent,new FontData[]{new FontData("Times New Roman",12,SWT.NORMAL)});
				viewer.setInput(data.getFontStyles());
				viewer.getTable().select(viewer.getTable().getItemCount()-1);
				data.getAddedStyles().add(fs);
				updatePreview();
			}
		}
		else if (e.getSource() == deleteButton)
		{
			if (getSelectedStyle().getFontDataName().equals(FontStyleManager.NORMAL_FONT_NAME))
			{
				ErrorDialog.openError(this.createShell(),"Cant delete this style", "Cant delete this style.", new Status(Status.INFO,"richtexteditor","Default style cannot be deleted."));
				return;
			}
			data.getDeletedStyles().add(getSelectedStyle());
			data.getFontStyles().remove(getSelectedStyle());
			viewer.setInput(data.getFontStyles());
			viewer.getTable().select(viewer.getTable().getItemCount()-1);
			updatePreview();
		}
		else if (e.getSource() == renameButton)
		{
			String newName = NameDialog.openNameDialog("New style name:","Rename style",this.createShell(),getSelectedStyle().getDisplayName());
			if (newName != null && !newName.trim().equals(""))
			{
				getSelectedStyle().setDisplayName(newName.trim());
				data.getAddedStyles().add(getSelectedStyle()); //Need this only for FontStyle combo updating
				viewer.setInput(data.getFontStyles());
			}
		}
	}

	/** (non-Javadoc)
	 * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event)
	{
		if (event.getSource() == foregroundColorSelector  && foregroundColorSelector.getColorValue() != null 
			&& !foregroundColorSelector.getColorValue().equals(getSelectedStyle().getColor()))
		{
			RGB color = foregroundColorSelector.getColorValue();
			ñolorCheckbox.setSelection(true);
			getSelectedStyle().setColor(color);
			data.addChangedStyle(getSelectedStyle());
			updatePreview();
		}
		else if (event.getSource() == backgroundColorSelector  && backgroundColorSelector.getColorValue() != null 
				&& !backgroundColorSelector.getColorValue().equals(getSelectedStyle().getBgColor()))
		{
			RGB color = backgroundColorSelector.getColorValue();
			ñolorCheckbox.setSelection(true);
			getSelectedStyle().setBgColor(color);
			data.addChangedStyle(getSelectedStyle());
			updatePreview();
		}		
	}
	
	protected void updatePreview()
	{
		preview.setLineAlignment(0,1,SWT.CENTER);
		FontStyle selectedStyle = getSelectedStyle();
		Color fgColor = null, bgColor = null;
		if (selectedStyle.getColor() != null) fgColor = colorManager.getColor(selectedStyle.getColor());
		if (selectedStyle.getBgColor() != null) bgColor = colorManager.getColor(selectedStyle.getBgColor());
		StyleRange range = new StyleRange(0,2,fgColor,bgColor);
		range.font = fontRegistry.get(selectedStyle.getFontDataName());
		preview.setStyleRange(range);
		preview.redraw();
	}
	
	protected String getCorrectStyleName(String displayName)
	{
		String resStr = "";
		displayName = displayName.trim();
		if (Character.isJavaIdentifierStart(displayName.charAt(0))) resStr += displayName.charAt(0);
			else resStr += "_";
		for (int i = 1; i < displayName.length(); i++)
		{
			if (Character.isJavaIdentifierPart(displayName.charAt(i)))
				resStr += displayName.charAt(i);		
		}
		if (resStr.length() < 2) resStr = resStr + "style";
		return checkForEqualStyleNames(resStr);
	}
	
	protected String checkForEqualStyleNames(String resStr)
	{
		boolean needToBeChanged = false;
		do
		{
			needToBeChanged = false;
			for (Iterator<FontStyle> iterator = data.getFontStyles().iterator(); iterator.hasNext();)
			{
				String name = ((FontStyle)iterator.next()).getFontDataName();
				if (name.equals(resStr)) needToBeChanged = true;			
			}
			if (needToBeChanged) resStr = resStr + "1";
		}
		while (needToBeChanged);
		return resStr;
	}

	
	protected void okPressed()
	{
		data.setResultFontRegistry(fontRegistry);
		super.okPressed();
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#open()
	 */
	
	public int open()
	{
		selectionChanged(new SelectionChangedEvent(viewer,new ISelection (){
			public boolean isEmpty()
			{				
				return true;
			}}));
		return super.open();
	}
}
