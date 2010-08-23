package org.unicase.model.search.widgets;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;

/**
 * Displays information about one result of the search.
 * @author Markus Fischer
 */
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

	/**
	 * Creates a new search result widget.
	 * @param parent the parent composite
	 * @param style the style attributes
	 * @param result a result EObject
	 * @param searchTerm the search term
	 */
	public SearchresultWidget(Composite parent, int style, EObject result, String searchTerm) {
		super(parent, style);
		this.result = result;
		this.searchTerm = searchTerm;
		
		this.setLayout(new GridLayout(1, true));
		init();
		addDoubleClickListener();
	}	

	/**
	 * Initializes the widget.
	 */
	private void init() {
		composite = new Composite(this, SWT.BORDER);
		composite.setLayout(new GridLayout(3, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		
		compositeTitle = new Composite(composite, SWT.NONE);
		compositeTitle.setLayout(new GridLayout(2, false));
		compositeTitle.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false, 3, 1));
		
		UnicaseModelElement ucElement = (UnicaseModelElement) result;
		String name = ucElement.getName();
		String description = ucElement.getDescription();
		Date creationDate = ucElement.getCreationDate();
		String creator = ucElement.getCreator();		
		
		EClass eClass = result.eClass();
		// get the image of the type
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(result, IItemLabelProvider.class);
		Image imageObj = ExtendedImageRegistry.getInstance().getImage(itemLabelProvider.getImage(result));
	    
		lblImage = new Label(compositeTitle, SWT.LEFT);
		lblImage.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false));
		if (imageObj != null) {
			lblImage.setImage(imageObj);
		} else {
			lblImage.setText("");
		}
		
		txtName = new StyledText(compositeTitle, SWT.LEFT | SWT.READ_ONLY);
		txtName.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false));
		txtName.setText(name);
		
		lblType = new Label(composite, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));
		lblType.setText("Type: " + eClass.getName());
		
		lblDate = new Label(composite, SWT.NONE);
		lblDate.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));
		SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		lblDate.setText("Creation date: " + df.format(creationDate));
		
		lblCreator = new Label(composite, SWT.NONE);
		lblCreator.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));
		lblCreator.setText("Created by user: " + creator);
		
		lblSeparator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparator.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false, 3, 1));
		
		txtDescription = new StyledText(composite, SWT.WRAP | SWT.READ_ONLY);
		GridData descriptionData = new GridData(SWT.FILL, SWT.NONE, true, false, 3, 1);
		descriptionData.widthHint = composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		txtDescription.setLayoutData(descriptionData);
		if (description != null && description.length() > 0) {
			txtDescription.setText(description);
		}
		
		markSearchTerm();
		
		String path = buildPath(result);
		if (path != null) {
			StyleRange[] ranges = txtName.getStyleRanges();
			txtName.setText(txtName.getText() + " (" + path + ")");
			txtName.setStyleRanges(ranges);
		}
		
		if (description == null || description.length() == 0) {
			txtDescription.setText("No description available!");
		}
		
	}
	
	/**
	 * Adds a double click listener to the widget.
	 */
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
	
	/**
	 * Marks the search term.
	 */
	private void markSearchTerm() {
		if (searchTerm == null || searchTerm.length() == 0) {
			return;
		}
		String nameValue = txtName.getText();
		txtName.setStyleRanges(findStyleRanges(nameValue, searchTerm));
		String descriptionValue = txtDescription.getText();
		if (descriptionValue != null && descriptionValue.length() > 0) {
			txtDescription.setStyleRanges(findStyleRanges(descriptionValue, searchTerm));
		}
	}
	
	/**
	 * Locates the search term within the widget value and returns the matching style ranges
	 * @param widgetValue the string value of the widget
	 * @param searchTerm the search term
	 * @return the style ranges that were found
	 */
	private StyleRange[] findStyleRanges(String widgetValue, String searchTerm) {
		ArrayList<StyleRange> ranges = new ArrayList<StyleRange>();
		Matcher matcher = Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE).matcher(widgetValue);
		
		while (matcher.find()) {
			StyleRange styleRange = new StyleRange();
			styleRange.start = matcher.start();
			styleRange.length = matcher.end() - matcher.start();
			styleRange.foreground = getDisplay().getSystemColor(SWT.COLOR_RED);
			styleRange.background = getDisplay().getSystemColor(SWT.COLOR_YELLOW);
			
			ranges.add(styleRange);
		}
		StyleRange[] rangesArr = new StyleRange[ranges.size()];
		
		return ranges.toArray(rangesArr);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
	 */
	@Override
	public void mouseDoubleClick(MouseEvent e) {
		ActionHelper.openModelElement(result, this.getClass().getName());
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
	 */
	@Override
	public void mouseDown(MouseEvent e) {
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
	 */
	@Override
	public void mouseUp(MouseEvent e) {
	}

	/**
	 * Returns the String path for the given element.
	 * @param element the result EObject
	 * @return the path
	 */
	private String buildPath(EObject element) {
		String returnValue = null;
		
		if (!(element.eContainer() instanceof UnicaseModelElement)) {
			return null;
		}
		
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
