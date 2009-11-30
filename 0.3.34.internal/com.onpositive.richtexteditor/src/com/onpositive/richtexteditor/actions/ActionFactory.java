/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributors: OnPositive
 * Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/
package com.onpositive.richtexteditor.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;

import com.onpositive.richtexteditor.dialogs.FontConfigurationDialog;
import com.onpositive.richtexteditor.dialogs.HyperlinkDialog;
import com.onpositive.richtexteditor.model.FontStyle;
import com.onpositive.richtexteditor.model.FontStylesChangeListener;
import com.onpositive.richtexteditor.model.LayerManager;
import com.onpositive.richtexteditor.model.RichSelectionState;
import com.onpositive.richtexteditor.model.partitions.BasePartition;
import com.onpositive.richtexteditor.model.resources.FontStyleData;
import com.onpositive.richtexteditor.viewer.IRichDocumentListener;
import com.onpositive.richtexteditor.viewer.undo.RichDocumentChange;

/**
 * @author 32kda & kor Class, which manages interface actions and their states
 */
public class ActionFactory implements ISelectionChangedListener, IRichDocumentListener {

	private final class AlignAction extends Action {

		private int style;

		public AlignAction(int style) {
			super("", Action.AS_RADIO_BUTTON);
			this.style = style;
		}

		public void run() {
			disableAllOther();
			manager.setIntervalAlign(viewer.getSelectedRange().x, viewer.getSelectedRange().y, style);
			// setLineIdentation(viewer.getSelectedRange().x,
			// viewer.getSelectedRange().y);
		}

		protected void disableAllOther() {
			if (centerAlignAction != null && centerAlignAction != this)
				centerAlignAction.setChecked(false);
			if (leftAlignAction != null && leftAlignAction != this)
				leftAlignAction.setChecked(false);
			if (rightAlignAction != null && rightAlignAction != this)
				rightAlignAction.setChecked(false);
			if (fillAlignAction != null && fillAlignAction != this)
				fillAlignAction.setChecked(false);
		}
	}

	private final class ListAction extends Action {

		protected int style;

		public ListAction(int style) {
			super("", Action.AS_CHECK_BOX);
			this.style = style;
		}

		public void run() {
			disableAllOtherListButtons();
			if (isChecked()) {
				manager.setIntervalList(viewer.getSelectedRange().x, viewer.getSelectedRange().y, style);
				enableProhibitedAligns(false);
			} else {
				manager.setIntervalList(viewer.getSelectedRange().x, viewer.getSelectedRange().y,
					LayerManager.NONE_LIST);
				enableProhibitedAligns(true);
			}
		}

		protected void disableAllOtherListButtons() {
			if (bulletedListAction != null && bulletedListAction != this)
				bulletedListAction.setChecked(false);
			if (numberedListAction != null && numberedListAction != this)
				numberedListAction.setChecked(false);
		}
	}

	private static final String FULL_JUSTIFY_IMAGE = "full-justify";

	private static final String RIGHT_JUSTIFY_IMAGE = "right-justify";

	private static final String CENTER_JUSTIFY_IMAGE = "center-justify";

	private static final String LEFT_JUSTIFY_IMAGE = "left-justify";

	private static final String LINK_IMAGE = "link";

	private static final String UNDERLINE_IMAGE = "underline";

	private static final String ITALIC_IMAGE = "italic";

	private static final String BOLD_IMAGE = "bold";

	private static final String BULLETS_IMAGE = "bullets";

	private static final String NUMBERS_IMAGE = "numbers";

	private static final String STRIKE_IMAGE = "strike";

	private static final String ADD_IMAGE_IMAGE = "image";

	private static final String ADD_REGION_IMAGE = "region";

	private static final String ADD_JAVA_REGION_IMAGE = "java_region";

	private static final String OPEN_IMAGE_IMAGE = "open";

	private static final String ADD_HR_IMAGE = "hr";

	private static final String CUSTOMIZE_FONT_STYLES_IMAGE = "customize_font";

	private IAction boldAction;

	private IAction italicAction;

	private CCombo combo;

	protected LayerManager manager;

	protected ITextViewer viewer;

	private IAction underlineAction;

	private IAction strikeThroughAction;

	private IAction linkAction;

	private IAction leftAlignAction;

	private AlignAction rightAlignAction;

	private IAction centerAlignAction;

	private IAction fillAlignAction;

	private IAction bulletedListAction;

	private IAction numberedListAction;

	private IAction foregroundColorAction;

	private IAction backgroundColorAction;

	private IAction addImageAction;

	private IAction addRegionAction;

	private IAction addJavaRegionAction;

	private IAction openFileAction;

	private IAction addHRAction;

	private IAction customizeFontStyleAction;

	/**
	 * @return Foreground Color Action
	 */
	public IAction getForegroundColorAction() {
		if (foregroundColorAction == null)
			foregroundColorAction = new ForeGroundColorAction(manager);
		return foregroundColorAction;
	}

	/**
	 * @return Backround Color Action
	 */
	public IAction getBackgroundColorAction() {
		if (backgroundColorAction == null)
			backgroundColorAction = new BackGroundColorAction(manager);
		return backgroundColorAction;
	}

	private ControlContribution controlContribution;

	{
		// images.put(ITALIC_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("text_italic.png")));
		// images.put(BOLD_IMAGE,
		// ImageDescriptor.createFromURL(ActionFactory.class
		// .getResource("text_bold.png")));
		// images.put(UNDERLINE_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("text_underline.png")));
		// images.put(LINK_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class.getResource("link.png")));
		// images.put(LEFT_JUSTIFY_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("JustifyLeft.gif")));
		// images.put(CENTER_JUSTIFY_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("JustifyCenter.gif")));
		// images.put(RIGHT_JUSTIFY_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("JustifyRight.gif")));
		// images.put(FULL_JUSTIFY_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("JustifyFull.gif")));
		// images.put(BULLETS_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("text_list_bullets.png")));
		// images.put(NUMBERS_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("text_list_numbers.png")));
		// images.put(STRIKE_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("StrikeThrough.gif")));
		// images.put(ADD_IMAGE_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("image.gif")));
		// images.put(ADD_REGION_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("textarea_obj.gif")));
		// images.put(ADD_JAVA_REGION_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("java_app.gif")));
		// images.put(OPEN_IMAGE_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("html_tag_obj.png")));
		// images.put(ADD_HR_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("hr.gif")));
		// images.put(CUSTOMIZE_FONT_STYLES_IMAGE, ImageDescriptor
		// .createFromURL(ActionFactory.class
		// .getResource("alphab_sort_co.gif")));
	}

	/**
	 * Basic constructor
	 * 
	 * @param manager LayerManager instance
	 * @param viewer ITextViewer instance
	 */
	public ActionFactory(LayerManager manager, ITextViewer viewer) {
		this.manager = manager;
		this.viewer = viewer;
		TextViewer tv = (TextViewer) viewer;
		tv.addPostSelectionChangedListener(this);
	}

	/**
	 * This must be used <b>only</b> when we need to configure action bar in custom style, and later, with the help of
	 * <i>delayedConfigure</i> method, add all needed links.
	 */
	public ActionFactory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Used for delayed basic links configuring - for customized ActionFactory
	 * 
	 * @param manager LayerManager instance
	 * @param viewer ITextViewer instance
	 */
	public void delayedConfigure(LayerManager manager, ITextViewer viewer) {
		this.manager = manager;
		this.viewer = viewer;
		TextViewer tv = (TextViewer) viewer;
		tv.addPostSelectionChangedListener(this);
	}

	/**
	 * @return LayerManager instance
	 */
	public LayerManager getManager() {
		return manager;
	}

	/**
	 * @param manager LayerManager instance
	 */
	public void setManager(LayerManager manager) {
		this.manager = manager;
	}

	/**
	 * @return bold style action
	 */
	public IAction getBoldAction() {
		if (boldAction == null) {
			boldAction = new Action("", Action.AS_CHECK_BOX) {
				public void run() {
					if (viewer.getSelectedRange().y > 0)
						manager.boldCommand(viewer.getSelectedRange().x, viewer.getSelectedRange().y, isChecked());
					else
						setCurrentBasePartitionState();
				}
			};
			boldAction.setText("Bold");
			boldAction.setImageDescriptor(getImageDescriptor(BOLD_IMAGE));
		}
		return boldAction;
	}

	/**
	 * @return italic style action
	 */
	public IAction getItalicAction() {
		if (italicAction == null) {
			italicAction = new Action("", Action.AS_CHECK_BOX) {
				public void run() {
					if (viewer.getSelectedRange().y > 0)
						manager.italicCommand(viewer.getSelectedRange().x, viewer.getSelectedRange().y, isChecked());
					else
						setCurrentBasePartitionState();
				}
			};
			italicAction.setText("Italic");
			italicAction.setImageDescriptor(getImageDescriptor(ITALIC_IMAGE));
		}
		return italicAction;
	}

	/**
	 * @return underline style action
	 */
	public IAction getUnderlineAction() {
		if (underlineAction == null) {
			underlineAction = new Action("", Action.AS_CHECK_BOX) {
				public void run() {
					if (viewer.getSelectedRange().y > 0)
						manager.underlineCommand(viewer.getSelectedRange().x, viewer.getSelectedRange().y, isChecked());
					else
						setCurrentBasePartitionState();
				}
			};
			underlineAction.setText("Underline");
			underlineAction.setImageDescriptor(getImageDescriptor(UNDERLINE_IMAGE));
		}
		return underlineAction;
	}

	/**
	 * @return insert image action
	 */
	public IAction getAddImageAction() {
		if (addImageAction == null) {
			addImageAction = new Action() {
				public void run() {
					FileDialog dialog = new FileDialog(viewer.getTextWidget().getShell());
					dialog.setFilterExtensions(new String[] { "*.gif", "*.jpg", "*.png", "*.bmp" });
					String filename = dialog.open();
					if (filename != null)
						manager.addNewImage(filename);
				}
			};
			addImageAction.setText("insert image");
			addImageAction.setImageDescriptor(getImageDescriptor(ADD_IMAGE_IMAGE));
		}
		return addImageAction;
	}

	/**
	 * @return insert range action
	 */
	public IAction getAddRegionAction() {
		if (addRegionAction == null) {
			addRegionAction = new Action() {
				public void run() {
					manager.addNewRegion();
				}
			};
			addRegionAction.setText("insert text region");
			addRegionAction.setImageDescriptor(getImageDescriptor(ADD_REGION_IMAGE));
		}
		return addRegionAction;
	}

	// /**
	// * @return insert java source code region action
	// */
	// public IAction getAddJavaRegionAction()
	// {
	// if (addJavaRegionAction == null)
	// {
	// addJavaRegionAction = new Action()
	// {
	// public void run()
	// {
	//
	// FileDialog dialog = new FileDialog(viewer
	// .getTextWidget().getShell());
	// String filename = dialog.open();
	// if (filename != null) manager.addNewSourceCodeRegion(filename);
	// }
	// };
	// addJavaRegionAction.setText("insert source code region");
	// addJavaRegionAction.setImageDescriptor(getImageDescriptor(ADD_JAVA_REGION_IMAGE));
	// }
	// return addJavaRegionAction;
	// }

	/**
	 * @return insert hr line action
	 */
	public IAction getAddHRAction() {
		if (addHRAction == null) {
			addHRAction = new Action() {
				public void run() {
					manager.addNewHR();
				}
			};
			addHRAction.setText("insert hr");
			addHRAction.setImageDescriptor(getImageDescriptor(ADD_HR_IMAGE));
		}
		return addHRAction;
	}

	/**
	 * @return load contents from html file action
	 */
	public IAction getOpenFileAction() {
		if (openFileAction == null) {
			openFileAction = new Action() {
				public void run() {
					FileDialog dialog = new FileDialog(viewer.getTextWidget().getShell());
					dialog.setFilterExtensions(new String[] { "*.html", "*.htm" });
					String filename = dialog.open();
					if (filename != null)
						manager.openHTMLFile(filename);
				}
			};
			openFileAction.setImageDescriptor(getImageDescriptor(OPEN_IMAGE_IMAGE));
			openFileAction.setText("Open");
		}
		return openFileAction;
	}

	/**
	 * @return insert new hyperlink action
	 */
	public IAction getNewLinkAction() {
		if (linkAction == null) {
			linkAction = new Action("", Action.AS_CHECK_BOX) {
				public void run() {

					int offset = viewer.getSelectedRange().x;
					int length = viewer.getSelectedRange().y;
					if (viewer.getTextWidget().getText().length() > 0) {
						if (manager.defineSumStylePartition(offset, length).isHasLinks()) {
							setChecked(true);
							return;
						}
					}
					HyperlinkDialog hyperlinkDialog;
					hyperlinkDialog = new HyperlinkDialog(viewer.getTextWidget().getShell());
					hyperlinkDialog.create();
					String name = viewer.getTextWidget().getSelectionText();
					int selOffset = viewer.getTextWidget().getSelection().x;
					String url = manager.getLayer().getSummaryUrl(viewer.getSelectedRange().x,
						viewer.getSelectedRange().y);
					hyperlinkDialog.setName(name);
					hyperlinkDialog.setUrl(url);
					setChecked(false);
					int retCode = hyperlinkDialog.open();
					if (retCode == Window.OK) {
						if (!name.equals(hyperlinkDialog.getName()))
							viewer.getTextWidget().setFocus();
						manager.insertLinkPartititon(viewer.getSelectedRange(), hyperlinkDialog.getName(),
							hyperlinkDialog.getUrl());
						viewer.setSelectedRange(selOffset, hyperlinkDialog.getName().length()); // Selection fixing
						// neede for correct newlink adding
					}
				}
			};
			linkAction.setText("New Hyperlink");
			linkAction.setImageDescriptor(getImageDescriptor(LINK_IMAGE));
		}
		return linkAction;
	}

	/**
	 * @return insert new customize font style dialog action
	 */
	public IAction getCustomizeFontStyleAction() {
		if (customizeFontStyleAction == null) {
			customizeFontStyleAction = new Action("", Action.AS_PUSH_BUTTON) {
				public void run() {
					FontConfigurationDialog configurationDialog;
					configurationDialog = new FontConfigurationDialog(viewer.getTextWidget().getShell(), manager
						.getFontStyleManager());
					configurationDialog.create();
					int retCode = configurationDialog.open();
					if (retCode == Window.OK) {
						FontStyleData data = configurationDialog.getData();
						if (data.getDeletedStyles().size() > 0) {
							ArrayList<FontStyle> usedStyles = new ArrayList<FontStyle>();
							for (Iterator<FontStyle> iterator = data.getDeletedStyles().iterator(); iterator.hasNext();) {
								FontStyle deletedStyle = (FontStyle) iterator.next();
								if (manager.isStyleUsed(deletedStyle))
									usedStyles.add(deletedStyle);
							}
							if (usedStyles.size() > 0) {
								String namesList = "";
								for (Iterator<FontStyle> iterator = usedStyles.iterator(); iterator.hasNext();)
									namesList = namesList + ((FontStyle) iterator.next()).getDisplayName() + ",";
								boolean res = MessageDialog.openQuestion(null, "Styles is in use",
									"Foolowing styles is in use: " + namesList
										+ ". Delete them and replace with default style in text?");
								if (res) {
									for (Iterator<FontStyle> iterator = usedStyles.iterator(); iterator.hasNext();)
										manager.removeStyleFromAllPartitions((FontStyle) iterator.next());
								} else
									data.getFontStyles().addAll(usedStyles);
							}
						}
						ArrayList<FontStyle> changedStylesList = data.validateChangedStyles(manager
							.getFontStyleManager());
						if (changedStylesList.size() > 0 || data.getAddedStyles().size() > 0
							|| data.getDeletedStyles().size() > 0) {
							manager.getFontStyleManager().reinit(data.getFontStyles(), data.getResultFontRegistry(),
								changedStylesList);
							/*
							 * combo.setItems(manager.getFontStyleManager().getFontStyleDisplayNames());
							 * combo.setText(manager.getFontStyleManager().getDefaultStyle().getDisplayName());
							 */
						}
					}
				}
			};
			manager.getFontStyleManager().addFontStyleChangeListener(new FontStylesChangeListener() {
				public void stylesChanged(ArrayList<FontStyle> changedStyles) {
					combo.setItems(manager.getFontStyleManager().getFontStyleDisplayNames());
					combo.setText(manager.getFontStyleManager().getDefaultStyle().getDisplayName());
				}
			});

			customizeFontStyleAction.setText("Customize Font Styles");
			customizeFontStyleAction.setImageDescriptor(getImageDescriptor(CUSTOMIZE_FONT_STYLES_IMAGE));

		}

		return customizeFontStyleAction;
	}

	/**
	 * @return font style change action
	 */
	public IContributionItem getStyleContributionItem() {
		if (controlContribution == null) {
			controlContribution = new ControlContribution("style") {

				protected Control createControl(Composite parent) {
					combo = new CCombo(parent, SWT.READ_ONLY | SWT.BORDER);
					combo.setItems(manager.getFontStyleManager().getFontStyleDisplayNames());
					combo.setText(manager.getFontStyleManager().getDefaultStyle().getDisplayName());
					combo.addSelectionListener(new SelectionListener() {

						public void widgetDefaultSelected(SelectionEvent e) {

						}

						public void widgetSelected(SelectionEvent e) {
							if (combo.getSelectionIndex() > -1) {
								if (viewer.getSelectedRange().y > 0) {
									manager.changeFontCommand(combo.getItem(combo.getSelectionIndex()), viewer
										.getSelectedRange().x, viewer.getSelectedRange().y);
									viewer.getTextWidget().setFocus();
								} else {
									setCurrentBasePartitionState();
									viewer.getTextWidget().setFocus();
								}
							}
						}

					});
					return combo;
				}

			};
		}
		return controlContribution;
	}

	// alignment actions
	/**
	 * @return left text align action
	 */
	public IAction getAlignLeftAction() {
		if (leftAlignAction == null) {
			leftAlignAction = new AlignAction(SWT.LEFT);
			leftAlignAction.setText("Align Left");
			leftAlignAction.setImageDescriptor(getImageDescriptor(LEFT_JUSTIFY_IMAGE));
		}
		return leftAlignAction;
	}

	/**
	 * @return right text align action
	 */
	public IAction getAlignRightAction() {
		if (rightAlignAction == null) {
			rightAlignAction = new AlignAction(SWT.RIGHT);
			rightAlignAction.setText("Align Right");
			rightAlignAction.setImageDescriptor(getImageDescriptor(RIGHT_JUSTIFY_IMAGE));
		}
		return rightAlignAction;
	}

	/**
	 * @return center text align action
	 */
	public IAction getAlignCenterAction() {
		if (centerAlignAction == null) {
			centerAlignAction = new AlignAction(SWT.CENTER);
			centerAlignAction.setText("Align Center");
			centerAlignAction.setImageDescriptor(getImageDescriptor(CENTER_JUSTIFY_IMAGE));
		}
		return centerAlignAction;
	}

	/**
	 * @return fit text align/justify action
	 */
	public IAction getAlignJustifyAction() {
		if (fillAlignAction == null) {
			fillAlignAction = new AlignAction(LayerManager.FIT_ALIGN);
			fillAlignAction.setText("Align Justify");
			fillAlignAction.setImageDescriptor(getImageDescriptor(FULL_JUSTIFY_IMAGE));
		}
		return fillAlignAction;
	}

	/**
	 * @return bulleted list action
	 */
	public IAction getBulletedListAction() {
		if (bulletedListAction == null) {
			bulletedListAction = new ListAction(LayerManager.BULLETED_LIST);
			bulletedListAction.setText("Bulleted List");
			bulletedListAction.setImageDescriptor(getImageDescriptor(BULLETS_IMAGE));
		}
		return bulletedListAction;
	}

	/**
	 * @return numbered list action
	 */
	public IAction getNumberedListAction() {
		if (numberedListAction == null) {
			numberedListAction = new ListAction(LayerManager.NUMBERED_LIST);
			numberedListAction.setText("numbered List");
			numberedListAction.setImageDescriptor(getImageDescriptor(NUMBERS_IMAGE));
		}
		return numberedListAction;
	}

	/**
	 * @param toolbarManager ToolbarManager to fill with action buttons
	 */
	public void fillToolbarManager(IContributionManager toolbarManager) {
		List<IContributionItem> itemsList = createActionsList();
		for (Iterator iterator = itemsList.iterator(); iterator.hasNext();) {
			IContributionItem contributionItem = (IContributionItem) iterator.next();
			toolbarManager.add(contributionItem);
		}
		/*
		 * toolbarManager.add(this.getBoldAction()); toolbarManager.add(this.getItalicAction());
		 * toolbarManager.add(this.getUnderlineAction()); //TODO IMPLEMENT IT
		 * toolbarManager.add(this.getStrikeThroughAction()); toolbarManager.add(new Separator());
		 * toolbarManager.add(this.getStyleContributionItem()); toolbarManager.add(new Separator());
		 * toolbarManager.add(this.getAlignLeftAction()); toolbarManager.add(this.getAlignRightAction());
		 * toolbarManager.add(this.getAlignCenterAction()); toolbarManager.add(this.getAlignJustifyAction());
		 * toolbarManager.add(new Separator()); toolbarManager.add(this.getNewLinkAction()); toolbarManager.add(new
		 * Separator()); toolbarManager.add(this.getBulletedListAction());
		 * toolbarManager.add(this.getNumberedListAction()); toolbarManager.add(new Separator()); //fix for Windows
		 * toolbar redrawing issue toolbarManager.add(new ControlContribution(""){ protected Control
		 * createControl(Composite parent) { parent.setLayout(new FillLayout()); ToolBar toolbar = new
		 * ToolBar(parent,SWT.NONE); ToolBarManager ma=new ToolBarManager(toolbar); ma.add(getForegroundColorAction());
		 * ma.add(new Separator()); ma.add(getBackgroundColorAction()); ma.update(true); return ma.getControl(); } });
		 * toolbarManager.add(new Separator()); toolbarManager.add(this.getAddImageAction()); toolbarManager.add(new
		 * Separator()); toolbarManager.add(this.getOpenFileAction()); toolbarManager.add(new Separator());
		 * toolbarManager.add(this.getAddHRAction()); toolbarManager.add(this.getCustomizeFontStyleAction());
		 */}

	public ArrayList<IContributionItem> createActionsList() {
		ArrayList<IContributionItem> resList = new ArrayList<IContributionItem>();
		resList.add(new ActionContributionItem(this.getBoldAction()));

		resList.add(new ActionContributionItem(this.getItalicAction()));
		resList.add(new ActionContributionItem(this.getUnderlineAction()));
		// TODO IMPLEMENT IT
		resList.add(new ActionContributionItem(this.getStrikeThroughAction()));
		resList.add(new Separator());
		resList.add(this.getStyleContributionItem());
		resList.add(new Separator());
		resList.add(new ActionContributionItem(this.getAlignLeftAction()));
		resList.add(new ActionContributionItem(this.getAlignRightAction()));
		resList.add(new ActionContributionItem(this.getAlignCenterAction()));
		resList.add(new ActionContributionItem(this.getAlignJustifyAction()));
		resList.add(new Separator());
		resList.add(new ActionContributionItem(this.getNewLinkAction()));
		resList.add(new Separator());
		resList.add(new ActionContributionItem(this.getBulletedListAction()));
		resList.add(new ActionContributionItem(this.getNumberedListAction()));
		resList.add(new Separator());
		// fix for Windows toolbar redrawing issue
		resList.add(new ControlContribution("") {

			protected Control createControl(Composite parent) {
				// parent.setLayout(new FillLayout());
				ToolBar toolbar = new ToolBar(parent, SWT.NONE);
				ToolBarManager ma = new ToolBarManager(toolbar);
				ma.add(getForegroundColorAction());
				ma.add(new Separator());
				ma.add(getBackgroundColorAction());
				ma.update(true);
				return ma.getControl();
			}

		});
		resList.add(new Separator());
		resList.add(new ActionContributionItem(this.getAddImageAction()));
		resList.add(new ActionContributionItem(this.getAddRegionAction()));
		// TODO OPTIMIZE IT
		// resList.add(new ActionContributionItem(this.getAddJavaRegionAction()));
		resList.add(new Separator());
		resList.add(new ActionContributionItem(this.getOpenFileAction()));
		resList.add(new Separator());
		resList.add(new ActionContributionItem(this.getAddHRAction()));
		resList.add(new ActionContributionItem(this.getCustomizeFontStyleAction()));
		return resList;
	}

	/**
	 * Used to fill toolbar manager with custom actions
	 * 
	 * @param toolbarManager manager to fill
	 * @param items list of actions to fill with
	 */
	public void customFillToolbarManager(IContributionManager toolbarManager, List<IContributionItem> items) {
		for (Iterator<IContributionItem> iterator = items.iterator(); iterator.hasNext();) {
			IContributionItem item = (IContributionItem) iterator.next();
			toolbarManager.add(item);
		}
	}

	/**
	 * @return strikethrough style action
	 */
	public IAction getStrikeThroughAction() {
		if (strikeThroughAction == null) {
			strikeThroughAction = new Action("", Action.AS_CHECK_BOX) {
				public void run() {
					if (viewer.getSelectedRange().y > 0)
						manager.strikethroughCommand(viewer.getSelectedRange().x, viewer.getSelectedRange().y,
							isChecked());
					else
						setCurrentBasePartitionState();
				}
			};
			strikeThroughAction.setText("Strike through");
			// boldAction.setAccelerator(SWT.CTRL | 'I');
			strikeThroughAction.setImageDescriptor(getImageDescriptor(STRIKE_IMAGE));
		}
		return strikeThroughAction;
	}

	protected ImageDescriptor getImageDescriptor(String strikeImage) {
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		int offset = manager.getEditor().getCaretOffset();
		BasePartition curPartition = (BasePartition) manager.getLayer().getPartitionAtOffset(offset);
		if (curPartition != null && curPartition.requiresSingleLine() && offset > curPartition.getOffset())
			manager.getEditor().setCaretOffset(curPartition.getOffset() + curPartition.getLength());
		manager.setCurrentFontPartition(null);
		update();
	}

	private void update() {
		if (viewer.getTextWidget().getText().length() < 1)
			return;
		int offset = viewer.getSelectedRange().x;
		int length = viewer.getSelectedRange().y;

		int firstLine = viewer.getTextWidget().getLineAtOffset(offset);
		int lastLine;
		if (length == 0)
			lastLine = firstLine;
		else
			lastLine = viewer.getTextWidget().getLineAtOffset(offset + length - 1);

		// if (length == 0)
		// setLineIdentation(offset, length);
		RichSelectionState sumPartition = manager.defineSumStylePartition(offset, length);
		setFontStyleControlsStates(sumPartition);

		int align = manager.defineSumAlignStyle(firstLine, lastLine);
		setAlignButtonsStates(align);
		setListButtonsStates(manager.defineSumListStyle(firstLine, lastLine));
	}

	protected void setCurrentBasePartitionState() {
		BasePartition partition = manager.getCurrentFontPartition();
		partition.setBold(getBoldAction().isChecked());
		partition.setItalic(getItalicAction().isChecked());
		partition.setUnderlined(getUnderlineAction().isChecked());
		partition.setStrikethrough(getStrikeThroughAction().isChecked());
		// String fontDataName = FontStyle.NORMAL_FONT_NAME; //by default
		final int selectionIndex = combo.getSelectionIndex();
		if (selectionIndex > -1) {
			final String item = combo.getItem(selectionIndex);
			manager.addNewlinesIfNeeded(viewer.getTextWidget().getCaretOffset(), item);
			manager.getFontStyleManager().getFontStyleByFontDataName(partition.getFontDataName())
				.removeStyle(partition);
			manager.getFontStyleManager().getFontStyle(item).applyStyle(partition);
			combo.select(selectionIndex);
		}
		// update();
	}

	protected void setCurrentBasePartitionFontStyleState() { // TODO

	}

	protected void setAlignButtonsStates(int align) {
		if (this.centerAlignAction != null)
			this.getAlignCenterAction().setChecked(align == LayerManager.CENTER_ALIGN);
		if (this.leftAlignAction != null)
			this.getAlignLeftAction().setChecked(align == LayerManager.LEFT_ALIGN);
		if (this.rightAlignAction != null)
			this.getAlignRightAction().setChecked(align == LayerManager.RIGHT_ALIGN);
		if (this.fillAlignAction != null)
			this.getAlignJustifyAction().setChecked(align == LayerManager.FIT_ALIGN);
	}

	protected void setListButtonsStates(int style) {
		boolean wasChecked = false;
		if (this.bulletedListAction != null) {
			this.bulletedListAction.setChecked(style == LayerManager.BULLETED_LIST);
			if (this.bulletedListAction.isChecked())
				wasChecked = true;
		}
		if (this.numberedListAction != null) {
			this.numberedListAction.setChecked(style == LayerManager.NUMBERED_LIST);
			if (this.numberedListAction.isChecked())
				wasChecked = true;
		}
		enableProhibitedAligns(!wasChecked);
	}

	protected void setFontStyleControlsStates(RichSelectionState state) {
		BasePartition sumPartition = state.getSumPartition();
		if (this.boldAction != null)
			this.getBoldAction().setChecked(sumPartition.isBold());
		if (this.italicAction != null)
			this.getItalicAction().setChecked(sumPartition.isItalic());
		if (this.underlineAction != null)
			this.getUnderlineAction().setChecked(sumPartition.isUnderlined());
		if (this.strikeThroughAction != null)
			this.getStrikeThroughAction().setChecked(sumPartition.isStrikethrough());
		if (this.foregroundColorAction != null)
			((ForeGroundColorAction) this.getForegroundColorAction()).setColor(sumPartition.getColorRGB());
		if (this.backgroundColorAction != null)
			((BackGroundColorAction) this.getBackgroundColorAction()).setColor(sumPartition.getBgColorRGB());
		if (this.linkAction != null) {
			linkAction.setChecked(state.isHasLinks());
		}
		if (this.controlContribution != null) {
			if (sumPartition.getFontDataName().length() > 0) {
				String[] fontStyleNames = manager.getFontStyleManager().getFontStyleDataNames();
				boolean wasSelected = false;
				for (int i = 0; i < fontStyleNames.length; i++) {
					if (fontStyleNames[i].equals(sumPartition.getFontDataName())) {
						combo.select(i);
						i = fontStyleNames.length; // For loop interrupting
						wasSelected = true;
					}
				}
				if (!wasSelected)
					combo.select(-1);
			} else
				combo.select(-1);
		}
	}

	/**
	 * enables or disable special aligns< like right or center Needed when endling/disabling lists, to display list
	 * bullets correctly
	 * 
	 * @param enable <b>true</b> enable this actions, <b>false</b> - disable them
	 */
	protected void enableProhibitedAligns(boolean enable) {

		if (this.centerAlignAction != null)
			this.centerAlignAction.setEnabled(enable);
		if (this.rightAlignAction != null)
			this.rightAlignAction.setEnabled(enable);
	}

	public void documentAboutToBeChanged(DocumentEvent event) {

	}

	/**
	 * only for updating
	 */
	public void documentChanged(DocumentEvent event, RichDocumentChange change) {
		update();
	}

}
