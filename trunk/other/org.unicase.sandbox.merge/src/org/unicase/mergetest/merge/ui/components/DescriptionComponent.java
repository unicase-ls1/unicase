package org.unicase.mergetest.merge.ui.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.conflict.ConflictDescription;
import org.unicase.mergetest.merge.ui.DecisionBox;
import org.unicase.mergetest.merge.ui.DecisionUtil;
import org.unicase.metamodel.ModelElement;

public class DescriptionComponent extends Composite {

	public DescriptionComponent(
			DecisionBox parent,
			Conflict<? extends AbstractOperation, ? extends AbstractOperation> conflict) {
		super(parent,SWT.NONE);
		setLayout(new GridLayout(2,false));
		setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label image = new Label(this,SWT.NONE);
		image.setImage(DecisionUtil.getImage("attribute.gif"));
//		image.setText("XX");
		
		
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
		
		
		StyledText styledDescription = new StyledText(this, SWT.WRAP | SWT.MULTI | SWT.READ_ONLY);
		styledDescription.setLayoutData(new GridData(GridData.FILL_BOTH));
		styledDescription.setEditable(false);
		styledDescription.setJustify(true);
		styledDescription.setText(description);
		styledDescription.setStyleRanges(styleRanges.toArray(new StyleRange[styleRanges.size()]));
	}

	
	private StyleRange createStyleRange(int start, int length) {
		StyleRange styleRange = new StyleRange();
	    styleRange.start = start;
	    styleRange.length = length;
	    styleRange.fontStyle = SWT.BOLD;
//	    styleRange.background = this.getDisplay().getSystemColor(SWT.COLOR_BLUE);
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
				String tmp = (obj instanceof ModelElement)?labelProvider.getText(obj):obj.toString();
				tmp = DecisionUtil.cutString(tmp, 30, true);
				split[0] = "::"+tmp; 
			}
			result.addAll(Arrays.asList(split));
		}
		return result;
	}
}
