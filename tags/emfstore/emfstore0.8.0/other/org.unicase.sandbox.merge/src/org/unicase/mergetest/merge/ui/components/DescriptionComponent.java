package org.unicase.mergetest.merge.ui.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.ui.DecisionBox;
import org.unicase.mergetest.merge.util.DecisionUtil;
import org.unicase.metamodel.ModelElement;

public class DescriptionComponent extends Composite {

	public DescriptionComponent(
			DecisionBox parent,
			Conflict conflict) {
		super(parent,SWT.NONE);
		GridLayout layout = new GridLayout(2,false);
		layout.horizontalSpacing=20;
		setLayout(layout);
		setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label image = new Label(this,SWT.NONE);
		image.setImage(DecisionUtil.getImage(conflict.getConflictDescription().getImage()));
		image.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		image.setBackground(parent.getBackground());
		
		
		
		ArrayList<StyleRange> styleRanges = new ArrayList<StyleRange>();
		String description = "";
		for(String tmp : splitText(conflict.getConflictDescription())) {
			if(tmp.startsWith("::")) {
				styleRanges.add(createStyleRange(description.length(), tmp.length()-2));
				description += tmp.substring(2);
			} else {
				description += tmp;
			}
		}
		
		Group group = new Group(this, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		FillLayout groupLayout = new FillLayout();
		groupLayout.marginHeight=5;
		groupLayout.marginWidth=6;
		group.setLayout(groupLayout);
		group.setBackground(parent.getBackground());
		group.setText("Conflict Description:");
		
		StyledText styledDescription = new StyledText(group, SWT.WRAP | SWT.MULTI | SWT.READ_ONLY);
		styledDescription.setEditable(false);
		styledDescription.setText(description);
		styledDescription.setWordWrap(true);
		styledDescription.setStyleRanges(styleRanges.toArray(new StyleRange[styleRanges.size()]));
		styledDescription.setBackground(parent.getBackground());
	}

	
	private StyleRange createStyleRange(int start, int length) {
		StyleRange styleRange = new StyleRange();
	    styleRange.start = start;
	    styleRange.length = length;
	    styleRange.fontStyle = SWT.BOLD;
	    return styleRange;
	}
	
	private List<String> splitText(ConflictDescription conflict) {
		String description = conflict.getDescription();
//		for(String string : description.split("\\["+"[a-zA-Z]*"+"\\]")) {
		ArrayList<String> result = new ArrayList<String>();
		AdapterFactoryLabelProvider labelProvider = DecisionUtil.getLabelProvider();
		for(String string : description.split("\\[")) {
			String[] split = string.split("\\]");
			if(split.length>1) {
				Object  obj = conflict.getValues().get(split[0]);				
				String tmp = "";
				if(obj instanceof ModelElement) {
					tmp = labelProvider.getText(obj);
				} else if(obj != null) {
					tmp = obj.toString();
				} else {
					tmp = "";
				}
				tmp = DecisionUtil.stripNewLine(tmp);
				tmp = DecisionUtil.cutString(tmp, 50, true);
				split[0] = "::"+tmp; 
			}
			result.addAll(Arrays.asList(split));
		}
		return result;
	}
}
