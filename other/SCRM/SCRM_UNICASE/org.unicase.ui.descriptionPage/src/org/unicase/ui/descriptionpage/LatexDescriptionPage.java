package org.unicase.ui.descriptionpage;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.docExport.docWriter.FopPngWriter;
import org.unicase.docExport.exceptions.DocumentExportException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateFactory;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URef;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.mecontrols.MERichTextControl;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.WorkspaceUtil;
import org.w3c.dom.Document;

/**
 * Adds a new page to the meEditor which shows a latex preview of the
 * description text box.
 * 
 * @author davidfu
 */
public class LatexDescriptionPage extends AbstractMEEditorPage {

	private static final String ID = "org.unicase.ui.descriptionpage.latexDescriptionPage";
	private static final String NAME = "LatexPreview";
	private String imagePath = "testTempExport.png";

	private UnicaseModelElement modelElement;
	private FormToolkit toolkit;
	private ScrolledForm form;
	private Composite body;
	private MERichTextControl textControl;
	private Control textWidget;
	private Composite buttonPanel;
	private Canvas previewWidget;
	private Image previewImage;
	private final Point origin = new Point(0, 0);

	public LatexDescriptionPage() {
	}

	@Override
	public FormPage createPage(MEEditor editor, EditingDomain editingDomain,
			EObject modelElement) {
		if (modelElement instanceof UnicaseModelElement) {
			this.modelElement = (UnicaseModelElement) modelElement;
		} else {
			throw new IllegalArgumentException(
					"This page is valid only for UnicaseModelElements");
		}
		FormPage page = new FormPageExtension(editor, ID, NAME);
		return page;
	}

	/**
	 * Creates the "left half" of the view.
	 */
	private void createDescriptionWidget() {
		TransactionalEditingDomain domain = (TransactionalEditingDomain) Configuration.getEditingDomain();
		if (textControl == null) {
			textControl = new MERichTextControl();
		}
		(textControl).setShowExpand(false);
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IItemPropertyDescriptor propertyDescriptor = adapterFactoryItemDelegator
				.getPropertyDescriptor(modelElement, "description");
		textWidget = textControl.createControl(body, SWT.NONE, propertyDescriptor, modelElement,
				UnicaseActionHelper.getContext(modelElement), toolkit);

		GridDataFactory.fillDefaults().hint(200, -1).grab(true, true)
				.applyTo(textWidget);
	}

	private void createBody() {
		if (body != null) {
			body.dispose();
		}
		body = new Composite(form.getBody(), SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).spacing(5, 0)
				.applyTo(body);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(body);
	}

	private void createPreviewButton() {
		final Button previewButton = new Button(buttonPanel, SWT.PUSH);
		previewButton.setText("Preview");
		previewButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == previewButton) {
					body.setFocus();
					exportToPng();
					Image newImg = createImage();
					previewImage = newImg;
					previewWidget.redraw();
				}
			}
		});
	}

	private void createButtonPanel() {
		buttonPanel = new Composite(body, SWT.NONE);
		buttonPanel.setLayout(new GridLayout());
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.BEGINNING;
		buttonPanel.setLayoutData(gridData);
	}

	private void createResizeButtons() {
		final Button zoomInButton = new Button(buttonPanel, SWT.PUSH);
		zoomInButton.setText("Zoom in");
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.BEGINNING;
		zoomInButton.setLayoutData(gridData);
		zoomInButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == zoomInButton) {
					ImageData imgData = previewImage.getImageData();
					previewImage = resizeImage(previewImage, imgData.width * 2,
							imgData.height * 2);
					previewWidget.redraw();
				}
			}
		});

		final Button zoomOutButton = new Button(buttonPanel, SWT.PUSH);
		zoomOutButton.setText("Zoom out");
		zoomOutButton.setLayoutData(gridData);
		zoomOutButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == zoomOutButton) {
					ImageData imgData = previewImage.getImageData();
					previewImage = resizeImage(previewImage, imgData.width / 2,
							imgData.height / 2);
					previewWidget.redraw();
				}
			}
		});
	}

	private Image resizeImage(Image image, int newWidth, int newHeight) {
		toolkit.getColors().getDisplay();
		Image scaled = new Image(Display.getDefault(), newWidth, newHeight);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width,
				image.getBounds().height, 0, 0, newWidth, newHeight);
		gc.dispose();
		image.dispose();
		return scaled;
	}

	/**
	 * Create the preview here, which is the "right half" of the view.
	 */
	private void createPreviewWidget() {
		exportToPng();
		previewImage = createImage();

		previewWidget = new Canvas(body, SWT.NO_BACKGROUND
				| SWT.NO_REDRAW_RESIZE | SWT.H_SCROLL | SWT.V_SCROLL);
		previewWidget.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(previewImage, origin.x, origin.y);
				Rectangle rect = previewImage.getBounds();
				Rectangle client = previewWidget.getClientArea();
				int marginWidth = client.width - rect.width;
				if (marginWidth > 0) {
					e.gc.fillRectangle(rect.width, 0, marginWidth,
							client.height);
				}
				int marginHeight = client.height - rect.height;
				if (marginHeight > 0) {
					e.gc.fillRectangle(0, rect.height, client.width,
							marginHeight);
				}
			}
		});
		addScrollBars();
		GridDataFactory.fillDefaults().hint(200, -1).grab(true, true)
				.applyTo(previewWidget);
	}

	private void addScrollBars() {
		final ScrollBar hBar = previewWidget.getHorizontalBar();
		hBar.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int hSelection = hBar.getSelection();
				int destX = -hSelection - origin.x;
				Rectangle rect = previewImage.getBounds();
				previewWidget.scroll(destX, 0, 0, 0, rect.width, rect.height,
						false);
				origin.x = -hSelection;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		final ScrollBar vBar = previewWidget.getVerticalBar();
		vBar.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int vSelection = vBar.getSelection();
				int destY = -vSelection - origin.y;
				Rectangle rect = previewImage.getBounds();
				previewWidget.scroll(0, destY, 0, 0, rect.width, rect.height,
						false);
				origin.y = -vSelection;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		/*
		 * Adapt the sizes of the scroll bars upon resizing of the window.
		 */
		previewWidget.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event e) {
				Rectangle rect = previewImage.getBounds();
				Rectangle client = previewWidget.getClientArea();
				hBar.setMaximum(rect.width);
				vBar.setMaximum(rect.height);
				hBar.setThumb(Math.min(rect.width, client.width));
				vBar.setThumb(Math.min(rect.height, client.height));
				int hPage = rect.width - client.width;
				int vPage = rect.height - client.height;
				int hSelection = hBar.getSelection();
				int vSelection = vBar.getSelection();
				if (hSelection >= hPage) {
					if (hPage <= 0)
						hSelection = 0;
					origin.x = -hSelection;
				}
				if (vSelection >= vPage) {
					if (vPage <= 0)
						vSelection = 0;
					origin.y = -vSelection;
				}
				previewWidget.redraw();
			}
		});
	}

	/**
	 * Create an image out of an outputStream. (Or from a file)
	 * 
	 * @param outputStream
	 */
	private Image createImage() {
		 return new Image(toolkit.getColors().getDisplay(),
		 imagePath);
	}

	/**
	 * Writes the given object to a file located at imagePath.
	 */
	private void writeXslFile(URootCompositeSection root) {
		FopPngWriter writer = new FopPngWriter();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			Document doc = parser.newDocument();
			writer.setDoc(doc);
			File temp = new File(imagePath);
			writer.export(temp.getAbsolutePath(), root);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (DocumentExportException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Export the description text to a png output stream
	 */
	private void exportToPng() {
		/*
		 * Put description text into a UParagraph.
		 */
		Template newTemplate = DefaultDocumentTemplateFactory.build();
		UParagraph description = new UParagraph(
				WorkspaceUtil.cleanFormatedText(modelElement.getDescription()),
				newTemplate.getLayoutOptions().getDefaultTextOption());
		description.getBoxModel().setKeepWithPrevious(true);
		description.getOption().setTextAlign(TextAlign.JUSTIFY);

		/*
		 * Put UParagraph into a USection.
		 */
		USection section = new USection();
		UParagraph titleParagraph = new UParagraph("");
		titleParagraph.setOption(newTemplate.getLayoutOptions()
				.getModelElementTextOption());
		section.setTitle(titleParagraph);
		section.add(description);

		/*
		 * Put the USection into a URootCompositeSection.
		 */
		URootCompositeSection root = new URootCompositeSection();
		URef lastPage = new URef("last_page");
		root.add(section);
		root.add(lastPage);
		setHeader(root, newTemplate);
		setFooter(root, modelElement, newTemplate);
		root.setLayoutOptions(newTemplate.getLayoutOptions());
		/*
		 * Pass the whole thing to the fop writer.
		 */
		writeXslFile(root);
	}

	private void setFooter(URootCompositeSection root,
			UnicaseModelElement modelElement, Template template) {

		UTable footerTable = new UTable(3);
		root.setFooter(footerTable);

		UTableCell leftCell = new UTableCell("");
		UTableCell middleCell = new UTableCell("");
		UTableCell rightCell = new UTableCell("");
		footerTable.add(leftCell);
		footerTable.add(middleCell);
		footerTable.add(rightCell);
	}

	private void setHeader(URootCompositeSection root, Template template) {
		UParagraph headerContainer = new UParagraph("");
		root.setHeader(headerContainer);
		UParagraph header2 = new UParagraph("");
		headerContainer.add(header2);
	}

	/**
	 * Nested class to extend the from page.
	 * 
	 */
	private final class FormPageExtension extends FormPage {
		private FormPageExtension(FormEditor editor, String id, String title) {
			super(editor, id, title);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void createFormContent(IManagedForm managedForm) {
			super.createFormContent(managedForm);

			toolkit = this.getEditor().getToolkit();
			form = managedForm.getForm();
			toolkit.decorateFormHeading(form.getForm());
			GridLayoutFactory.fillDefaults().spacing(0, 0)
					.applyTo(form.getBody());
			form.setText(getEditor().getTitle() + ": Description");
			createBody();
			createDescriptionWidget();
			createButtonPanel();
			createPreviewButton();
			createResizeButtons();
			createPreviewWidget();
			form.pack();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void dispose() {
			if (textControl != null) {
				textControl.dispose();
			}
			super.dispose();
		}

		/**
		 * {@inheritDoc} This method is added to solve the focus bug of
		 * navigator. Every time that a ME is opened in editor, navigator has to
		 * lose focus so that its action contributions are set correctly for
		 * next time.
		 */
		@Override
		public void setFocus() {
			textWidget.setFocus();
		}
	}
}
