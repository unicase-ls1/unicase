package org.unicase.ui.descriptionpage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
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
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.AbstractMEEditorPage;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.mecontrols.MERichTextControl;
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
			ModelElement modelElement) {
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
		TransactionalEditingDomain domain = Configuration.getEditingDomain();
		if (textControl == null) {
			textControl = new MERichTextControl();
		}
		(textControl).setShowExpand(false);
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IItemPropertyDescriptor propertyDescriptor = adapterFactoryItemDelegator
				.getPropertyDescriptor(modelElement, "description");
		textWidget = textControl.createControl(body, SWT.NONE,
				propertyDescriptor, modelElement, domain, toolkit);

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
		buttonPanel = new Composite(body, SWT.NONE);
		buttonPanel.setLayout(new GridLayout());
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.BEGINNING;
		buttonPanel.setLayoutData(gridData);
		final Button button = new Button(buttonPanel, SWT.PUSH);
		button.setText("Preview");

		Listener buttonListener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == button) {
					body.setFocus();
					Image newImg = createImage(exportToPng());
					previewImage = newImg;
					previewWidget.redraw();
				}
			}
		};
		button.addListener(SWT.Selection, buttonListener);
	}

	private void createResizeButtons() {
		final Button zoomIn = new Button(buttonPanel, SWT.PUSH);
		zoomIn.setText("Zoom in");
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.BEGINNING;
		zoomIn.setLayoutData(gridData);
		zoomIn.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == zoomIn) {
					ImageData imgData = previewImage.getImageData();
					previewImage = resize(previewImage, imgData.width * 2,
							imgData.height * 2);
					previewWidget.redraw();
				}
			}
		});

		final Button zoomOut = new Button(buttonPanel, SWT.PUSH);
		zoomOut.setText("Zoom out");
		zoomOut.setLayoutData(gridData);
		zoomOut.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == zoomOut) {
					ImageData imgData = previewImage.getImageData();
					previewImage = resize(previewImage, imgData.width / 2,
							imgData.height / 2);
					previewWidget.redraw();
				}
			}
		});
	}

	private Image resize(Image image, int newWidth, int newHeight) {
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
		ByteArrayOutputStream stream = exportToPng();
		createBufferedImage(stream);
		previewImage = createImage(stream);

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
	private Image createImage(ByteArrayOutputStream outputStream) {

//		TeXFormula formula = new TeXFormula(modelElement.getDescription());
//		TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
//		icon.setInsets(new Insets(5, 5, 5, 5));
//
//		BufferedImage image = new BufferedImage(icon.getIconWidth(),
//				icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g2 = image.createGraphics();
//		g2.setColor(Color.white);
//		g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
//		File file = new File("Example1.png");
//		try {
//			ImageIO.write(image, "png", file.getAbsoluteFile());
//		} catch (IOException ex) {
//		}
//		Image swtImage = new Image(toolkit.getColors().getDisplay(),
//				"Example1.png");
//		return swtImage;
//		BufferedImage bufImg = createBufferedImage(outputStream);
//		ImageData imgData = convertToSWTImage(bufImg);
//		Image img = new Image(toolkit.getColors().getDisplay(), imgData);
//		return img;

		// FIXME Use relative file path!
		 return new Image(toolkit.getColors().getDisplay(),
		 "testTempExport.png");
	}
	

	/**
	 * Creates a buffered image out of an outputStream.
	 * 
	 * @param outputStream
	 * @return
	 */
	private BufferedImage createBufferedImage(ByteArrayOutputStream outputStream) {
		InputStream inputStream = new ByteArrayInputStream(
				outputStream.toByteArray());
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Convert bufferedImage into a new BufferedImage with a ColorModel
		 * different to ComponentColorModel.
		 */
		BufferedImage newImg = new BufferedImage(bufferedImage.getWidth(),
				bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
		newImg.setData(bufferedImage.getData());
		return newImg;
	}

	/**
	 * Convert a BufferedImage into SWT ImageData
	 */
	private ImageData convertToSWTImage(BufferedImage bufferedImage) {
		if (bufferedImage.getColorModel() instanceof DirectColorModel) {
			DirectColorModel colorModel = (DirectColorModel) bufferedImage
					.getColorModel();
			PaletteData palette = new PaletteData(colorModel.getRedMask(),
					colorModel.getGreenMask(), colorModel.getBlueMask());
			ImageData data = new ImageData(bufferedImage.getWidth(),
					bufferedImage.getHeight(), colorModel.getPixelSize(),
					palette);
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[3];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					int pixel = palette.getPixel(new RGB(pixelArray[0],
							pixelArray[1], pixelArray[2]));
					data.setPixel(x, y, pixel);
				}
			}
			return data;
		} else if (bufferedImage.getColorModel() instanceof IndexColorModel) {
			IndexColorModel colorModel = (IndexColorModel) bufferedImage
					.getColorModel();
			int size = colorModel.getMapSize();
			byte[] reds = new byte[size];
			byte[] greens = new byte[size];
			byte[] blues = new byte[size];
			colorModel.getReds(reds);
			colorModel.getGreens(greens);
			colorModel.getBlues(blues);
			RGB[] rgbs = new RGB[size];
			for (int i = 0; i < rgbs.length; i++) {
				rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF,
						blues[i] & 0xFF);
			}
			PaletteData palette = new PaletteData(rgbs);
			ImageData data = new ImageData(bufferedImage.getWidth(),
					bufferedImage.getHeight(), colorModel.getPixelSize(),
					palette);
			data.transparentPixel = colorModel.getTransparentPixel();
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[1];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					data.setPixel(x, y, pixelArray[0]);
				}
			}
			return data;
		}
		return null;
	}

	/**
	 * Returns an output stream containing the data created by a FopPngWriter
	 */
	private ByteArrayOutputStream writeXslFile(URootCompositeSection root) {
		FopPngWriter writer = new FopPngWriter();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			Document doc = parser.newDocument();
			writer.setDoc(doc);
			File temp = new File("testTempExport.png");
			System.out.println(temp.getAbsolutePath());
			// uncomment next line if export to a local file is wanted.
			// FIXME Use relative file path!
			 writer.export(temp.getAbsolutePath(), root);
			return writer.exportToStream(root);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (DocumentExportException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Export the description text to a png output stream
	 */
	private ByteArrayOutputStream exportToPng() {
		/*
		 * Put description text into a UParagraph (see ModelElementRenderer
		 * 508ff).
		 */
		Template newTemplate = DefaultDocumentTemplateFactory.build();
		UParagraph description = new UParagraph(
				WorkspaceUtil.cleanFormatedText(modelElement.getDescription()),
				newTemplate.getLayoutOptions().getDefaultTextOption());
		description.getBoxModel().setKeepWithPrevious(true);
		description.getOption().setTextAlign(TextAlign.JUSTIFY);

		/*
		 * Put UParagraph into a USection and then into a URootCompositeSection
		 * (see DefaultDocumentRenderer 91ff).
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
		return writeXslFile(root);
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
