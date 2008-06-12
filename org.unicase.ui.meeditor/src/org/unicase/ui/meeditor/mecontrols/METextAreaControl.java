package org.unicase.ui.meeditor.mecontrols;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.unicase.ui.meeditor.mecontrols.richtext.actions.BackColorAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.BoldAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.BulletListAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.CleanupAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.DeleteColumnAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.DeleteRowAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.ForegroundAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.HrAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.IndentAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertColumnAfterAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertColumnBeforeAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertEditAnchorAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertEditImageAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertEditLinkAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertEditTableAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertLayerAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertNonBreakingWhitespace;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertRowAfterAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.InsertRowBeforeAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.ItalicAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.JustifyCenterAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.JustifyFullAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.JustifyLeftAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.JustifyRightAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.MakeLayerAbsoluteAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.MoveLayerBackwardAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.MoveLayerForwardAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.NumListAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.OutdentAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.RedoAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.RemoveFormatAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.SelectFontAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.SelectFontSizeAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.SelectFormatAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.SetHtmlAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.StrikeThroughAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.SubAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.SupAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.ToggleVisualAidAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.UnderLineAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.UndoAction;
import org.unicase.ui.meeditor.mecontrols.richtext.actions.UnlinkAction;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.HtmlComposer;
import org.unicase.ui.meeditor.mecontrols.richtext.widgets.JavaScriptCommands;

/**
 * RichText editor control.
 * @author shterev
 * @author HTML editor courtesy of SpriritLink.de
 *
 */
public class METextAreaControl extends AbstractMEControl implements MEControl {
	
	private EAttribute attribute;
	
	private Section section;

	/**
	 * Default constructor.
	 * @param attribute the attribute being edited 
	 * @param toolkit the gui toolkit
	 * @param modelElement the ME
	 * @param editingDomain the editing domain
	 */
	public METextAreaControl(EAttribute attribute, FormToolkit toolkit,
			EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
		this.toolkit = toolkit;
		this.modelElement = modelElement;
		this.editingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		section = toolkit.createSection(parent, Section.DESCRIPTION
				| Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText("Toggle editor");
		section.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, true));
		final Composite composite = toolkit.createComposite(section, style);
		composite.setLayout(new GridLayout(1, true));

		String content = (String) modelElement.eGet(attribute);
       
        CoolBar coolbar = new CoolBar(composite, SWT.NONE);
        final HtmlComposer composer = new HtmlComposer(composite, SWT.NONE);
        composer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        composer.execute(JavaScriptCommands.SET_HTML(content));
        
        GridData gd = new GridData(SWT.FILL,SWT.BEGINNING, true, false);
        gd.widthHint = 100;
        coolbar.setLayoutData(gd);

        coolbar.addListener(SWT.Resize, new Listener() {
            public void handleEvent(Event event) {
                composite.getShell().layout();
            }
        });
        final Composite comboComp = new Composite(coolbar, SWT.NONE);
        comboComp.setLayout(new GridLayout(3,false));
        
        final Combo formatCombo = new Combo (comboComp, SWT.SINGLE);
        
        formatCombo.setItems(SelectFormatAction.formatMappings.values().toArray(new String[0]));
        formatCombo.add("--[Format]--", 0);
        formatCombo.select(0);
        formatCombo.addSelectionListener(new SelectionAdapter() {
            private Action action = new SelectFormatAction(composer, formatCombo);
            /* (non-Javadoc)
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                this.action.run();
            } 
        });
        Point formatTextSize = formatCombo.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        formatTextSize = formatCombo.computeSize(formatTextSize.x, formatTextSize.y);
        
        
        final Combo fontCombo = new Combo (comboComp, SWT.SINGLE);
        
        fontCombo.setItems(getFontList());
        fontCombo.add("--[Font]--", 0);
        fontCombo.select(0);
        fontCombo.addSelectionListener(new SelectionAdapter() {
            private Action action = new SelectFontAction(composer, fontCombo);
            /* (non-Javadoc)
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                this.action.run();
            } 
        });
        Point fontTextSize = fontCombo.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        fontTextSize = fontCombo.computeSize(fontTextSize.x, fontTextSize.y);
        
        
        
        final Combo fontsizeCombo = new Combo (comboComp, SWT.SINGLE);
        fontsizeCombo.setItems(new String[] {"--[Size]--","1","2","3","4","5","6"});
        fontsizeCombo.select(0);
        fontsizeCombo.addSelectionListener(new SelectionAdapter() {
            private Action action = new SelectFontSizeAction(composer, fontsizeCombo);
            /* (non-Javadoc)
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                this.action.run();
            } 
        });
        CoolItem comboItem = new CoolItem (coolbar, SWT.NONE);
        comboItem.setControl (comboComp);
        
        Point fontSizetextSize = fontsizeCombo.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        fontSizetextSize = fontsizeCombo.computeSize(fontSizetextSize.x, fontSizetextSize.y);
        comboItem.setMinimumSize(formatTextSize.x + fontSizetextSize.x + fontTextSize.x, formatTextSize.y + fontSizetextSize.y + fontTextSize.y);
        comboItem.setPreferredSize(formatTextSize.x + fontSizetextSize.x + fontTextSize.x, formatTextSize.y + fontSizetextSize.y + fontTextSize.y);
        comboItem.setSize(formatTextSize.x + fontSizetextSize.x + fontTextSize.x, formatTextSize.y + fontSizetextSize.y + fontTextSize.y);
        
        ToolBar menu = new ToolBar(coolbar, SWT.HORIZONTAL | SWT.FLAT);
        ToolBarManager manager = new ToolBarManager(menu);
        CoolItem item = new CoolItem(coolbar, SWT.NONE);
        item.setControl(menu);
        
        
//        CurrentSelectionListener currentSelectionListener = new CurrentSelectionListener(composer,currentSelectionText);
//        composer.addListener(EventConstants.CURRENT_TEXT_SELECTION, currentSelectionListener);
      
        manager.add(new BoldAction(composer));
        manager.add(new ItalicAction(composer));
        manager.add(new UnderLineAction(composer));
        manager.add(new StrikeThroughAction(composer));
        manager.add(new Separator());
        manager.add(new JustifyLeftAction(composer));
        manager.add(new JustifyCenterAction(composer));
        manager.add(new JustifyRightAction(composer));
        manager.add(new JustifyFullAction(composer));
        manager.add(new Separator());
        manager.add(new BulletListAction(composer));
        manager.add(new NumListAction(composer));
        manager.add(new Separator());
        manager.add(new OutdentAction(composer));
        manager.add(new IndentAction(composer));
        manager.add(new Separator());
        manager.add(new SubAction(composer));
        manager.add(new SupAction(composer));
        manager.update(true);
        
        menu = new ToolBar(coolbar, SWT.HORIZONTAL | SWT.FLAT);
        manager = new ToolBarManager(menu);
        item = new CoolItem(coolbar, SWT.NONE);
        item.setControl(menu);
        
        manager.add(new SetHtmlAction(composer));
        manager.update(true);
        
        menu = new ToolBar(coolbar, SWT.HORIZONTAL | SWT.FLAT);
        manager = new ToolBarManager(menu);
        item = new CoolItem(coolbar, SWT.NONE);
        item.setControl(menu);
        
        manager.add(new InsertEditImageAction(composer));
        manager.add(new InsertEditAnchorAction(composer));
        manager.add(new InsertEditLinkAction(composer));
        manager.add(new UnlinkAction(composer));
        manager.add(new HrAction(composer));
        manager.add(new InsertNonBreakingWhitespace(composer));
        manager.add(new Separator());
        manager.add(new CleanupAction(composer));
        manager.add(new RemoveFormatAction(composer));
        manager.add(new ToggleVisualAidAction(composer));
        manager.add(new Separator());
        manager.add(new UndoAction(composer));
        manager.add(new RedoAction(composer));
        manager.update(true);
        
        menu = new ToolBar(coolbar, SWT.HORIZONTAL | SWT.FLAT);
        manager = new ToolBarManager(menu);
        item = new CoolItem(coolbar, SWT.NONE);
        item.setControl(menu);
        
        manager.add(new ForegroundAction(composer));
        manager.add(new BackColorAction(composer));
        manager.update(true);
        
        menu = new ToolBar(coolbar, SWT.HORIZONTAL | SWT.FLAT);
        manager = new ToolBarManager(menu);
        item = new CoolItem(coolbar, SWT.NONE);
        item.setControl(menu);
        
        manager.add(new InsertLayerAction(composer));
        manager.add(new MoveLayerBackwardAction(composer));
        manager.add(new MoveLayerForwardAction(composer));
        manager.add(new MakeLayerAbsoluteAction(composer));
        manager.update(true);
//        
        menu = new ToolBar(coolbar, SWT.HORIZONTAL | SWT.FLAT);
        manager = new ToolBarManager(menu);
        item = new CoolItem(coolbar, SWT.NONE);
        item.setControl(menu);
        
        manager.add(new InsertEditTableAction(composer));
        manager.add(new Separator());
        manager.add(new InsertRowBeforeAction(composer));
        manager.add(new InsertRowAfterAction(composer));
        manager.add(new DeleteRowAction(composer));
        manager.add(new Separator());
        manager.add(new InsertColumnBeforeAction(composer));
        manager.add(new InsertColumnAfterAction(composer));
        manager.add(new DeleteColumnAction(composer));
        
        manager.update(true);

//        /* Set the sizes after adding all cool items */
        CoolItem[] coolItems = coolbar.getItems();
        for (int i = 0; i < coolItems.length; i++) {
            CoolItem coolItem = coolItems[i];
            Control control = coolItem.getControl();
            Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
            Point coolSize = coolItem.computeSize(size.x, size.y);
            if (control instanceof ToolBar) {
                ToolBar bar = (ToolBar)control;
                for (int j = 0, n = bar.getItemCount(); j <n ; j++){
                    size.x += bar.getSize().x;
                }
            }
            coolItem.setMinimumSize(size);
            coolItem.setPreferredSize(coolSize);
            coolItem.setSize(coolSize);
        }
	
		section.setClient(composite);
		return section;
	}

    private static String[] getFontList() {
        Set<String> s = new HashSet<String>();
        // Add names of all bitmap fonts.
        FontData[] fds = Display.getCurrent().getFontList(null, false);
        for (int i=0; i<fds.length; ++i){
            s.add(fds[i].getName());
        }
        // Add names of all scalable fonts.
        fds = Display.getCurrent().getFontList(null, true);
        for (int i=0; i<fds.length; ++i){
            s.add(fds[i].getName());
        }
        // Sort the result and print it.
        String[] answer = new String[s.size()];
        s.toArray(answer);
        Arrays.sort(answer);
        return answer;
    } 
    
}
