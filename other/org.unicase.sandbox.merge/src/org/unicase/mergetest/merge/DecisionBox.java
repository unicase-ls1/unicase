package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Section;

public class DecisionBox extends Composite {

	private final Conflict conflict;
	private List<Button> optionButtons;

	public DecisionBox(Composite parent, Conflict conflict) {
		super(parent, SWT.BORDER);
		this.conflict = conflict;
		GridLayout gridLayout2 = new GridLayout(4, false);
		this.setLayout(gridLayout2);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Link link = new Link(this, SWT.LEFT);
		link.setText("ModelElement '"+conflict.getName()+"'\n"+conflict.getConflictDescription());
		link.setEnabled(true);
		Text optionDescription = new Text(this, SWT.NONE);
		optionDescription.setEditable(false);
		optionDescription.setText(conflict.getOptionDescription()
				+ " :");
		optionDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				true, true));
		
		
		// Add Option Buttons
		optionButtons = new ArrayList<Button>();
		int index = 0;
		for (String option : conflict.getOptions()) {
			Button optionButton = new Button(this, SWT.NONE);
			optionButton.setText(option);
			final int optionIndex = index; 
			optionButton.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					DecisionBox.this.setSolution(optionIndex);
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					DecisionBox.this.setSolution(optionIndex);
				}
			});
			optionButtons.add(optionButton);
			index++;
		}
		
		//Additional Fields
		Section section = new Section(this, Section.TWISTIE);
		section.setText("Additional Information");
		section.setLayout(new GridLayout(1,false));
		section.addExpansionListener(new IExpansionListener() {
			public void expansionStateChanged(ExpansionEvent e) {
				DecisionBox.this.getParent().layout();
			}
			public void expansionStateChanging(ExpansionEvent e) {
				DecisionBox.this.getParent().getParent().layout();
			}
		});
//		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Composite client = new Composite(section, SWT.BORDER);
		client.setLayout(new GridLayout(1,false));
		client.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Label label = new Label(client,SWT.NONE);
		label.setText("adasdasd");
		
		section.setClient(client);
	}

	protected void setSolution(int optionIndex) {
		conflict.setSolution(optionIndex);
		for(int i = 0; i < optionButtons.size(); i++) {
			Button button = optionButtons.get(i);
			if(i==optionIndex){
				button.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
			} else {
				button.setBackground(null);
			}
		}
	}
	

}
