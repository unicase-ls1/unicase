package org.unicase.model.search.widgets;




import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;

public class SearchresultWidget extends Composite implements MouseListener {
	
	private EObject result;
	private Label lblImage;
	private StyledText txtName;
	private Label lblType;
	private Label lblDate;
	private Label lblCreator;
	private StyledText txtDescription;
	private Label lblSeparator;
	private Composite composite;
	private Composite compositeTitle;
	private String searchTerm;

	public SearchresultWidget(Composite parent, int style, EObject result, String searchTerm) {
		super(parent, style);
		this.result = result;
		this.searchTerm = searchTerm;
		
		this.setLayout(new GridLayout(1, true));
		init();
		addDoubleClickListener();
	}	

	private void init() {
		composite = new Composite(this, SWT.BORDER);
		composite.setLayout(new GridLayout(3, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		
		compositeTitle = new Composite(composite, SWT.NONE);
		compositeTitle.setLayout(new GridLayout(2, false));
		compositeTitle.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false, 3, 1));
		
		UnicaseModelElement ucElement = (UnicaseModelElement) result;
		EClass eClass = result.eClass();
		// get the image of the type
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(ucElement, IItemLabelProvider.class);
		Image imageObj = ExtendedImageRegistry.getInstance().getImage(itemLabelProvider.getImage(ucElement));
	    
		lblImage = new Label(compositeTitle, SWT.LEFT);
		lblImage.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false));
		if (imageObj != null) {
			lblImage.setImage(imageObj);
		} else {
			lblImage.setText("");
		}
		
		txtName = new StyledText(compositeTitle, SWT.LEFT | SWT.READ_ONLY);
		txtName.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false));
		String path = buildPath(ucElement);
		if (path != null) {
			txtName.setText(ucElement.getName() + " (" + path + ")");
		} else {
			txtName.setText(ucElement.getName());
		}
		
		lblType = new Label(composite, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));
		lblType.setText("Type: " + eClass.getName());
		
		lblDate = new Label(composite, SWT.NONE);
		lblDate.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));
		SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		lblDate.setText("Creation date: " + df.format(ucElement.getCreationDate()));
		
		lblCreator = new Label(composite, SWT.NONE);
		lblCreator.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));
		lblCreator.setText("Created by user: " + ucElement.getCreator());
		
		lblSeparator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparator.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false, 3, 1));
		
		txtDescription = new StyledText(composite, SWT.WRAP | SWT.READ_ONLY);
		GridData descriptionData = new GridData(SWT.FILL, SWT.NONE, true, false, 3, 1);
		descriptionData.widthHint = composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		txtDescription.setLayoutData(descriptionData);
		if (ucElement.getDescription() != null && ucElement.getDescription().length() > 0) {
			txtDescription.setText(ucElement.getDescription());
		} else {
			txtDescription.setText("No description available!");
		}
		
		markSearchTerm();
		
	}
	
	private void addDoubleClickListener() {
		addMouseListener(this);
		composite.addMouseListener(this);
		compositeTitle.addMouseListener(this);
		
		for (int i = 0; i < composite.getChildren().length; i++) {
			Control c = composite.getChildren()[i];
			c.addMouseListener(this);
		}
		for (int i = 0; i < compositeTitle.getChildren().length; i++) {
			Control c = compositeTitle.getChildren()[i];
			c.addMouseListener(this);
		}
		
	}
	
	private void markSearchTerm() {
		UnicaseModelElement ucElement = (UnicaseModelElement) result;
		String nameValue = ucElement.getName().toUpperCase();
		String descriptionValue = txtDescription.getText().toUpperCase();

		txtName.setStyleRanges(getStyleRanges(nameValue, searchTerm.toUpperCase()));
		txtDescription.setStyleRanges(getStyleRanges(descriptionValue, searchTerm.toUpperCase()));
	}
	
	private StyleRange[] getStyleRanges(String widgetValue, String searchTerm) {
		int index = 0;
		ArrayList<StyleRange> ranges = new ArrayList<StyleRange>();
		while (widgetValue.indexOf(searchTerm, index) != -1) {
			StyleRange styleRange = new StyleRange();
			styleRange.start = widgetValue.indexOf(searchTerm, index);
			styleRange.length = searchTerm.length();
			styleRange.foreground = getDisplay().getSystemColor(SWT.COLOR_RED);
			styleRange.background = getDisplay().getSystemColor(SWT.COLOR_YELLOW);
			
			ranges.add(styleRange);
			index = styleRange.start + styleRange.length;
		}
		StyleRange[] rangesArr = new StyleRange[ranges.size()];
		
		return ranges.toArray(rangesArr);
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// TODO: AbstractMethodException in ActionHelper...
		ModelElement meResult = (ModelElement) result;
		ActionHelper.openModelElement(meResult, this.getClass().getName());
	}

	@Override
	public void mouseDown(MouseEvent e) {
	}

	@Override
	public void mouseUp(MouseEvent e) {
	}
	
	private String buildPath(UnicaseModelElement element) {
		String returnValue = null;
		UnicaseModelElement parent = (UnicaseModelElement) element.eContainer();
		
		ArrayList<String> container = new ArrayList<String>();
		
		while (parent != null) {
			container.add(parent.getName());
			if (parent.eContainer() instanceof UnicaseModelElement) {
				parent = (UnicaseModelElement) parent.eContainer();
			} else {
				parent = null;
			}
		}
		
		if (container.size() > 0) {
			returnValue = "";
		}
		
		for (int i = container.size() - 1; i >= 0; i--) {
			returnValue += container.get(i);
			if (i > 0) {
				returnValue += " -> ";
			}
		}
		
		return returnValue;
	}

}
