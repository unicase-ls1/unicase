package org.unicase.docExport.docWriter;

// Java
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class FopPdfWriter implements DocWriter {

	private Element root;
	private Document doc;
	private Element pageSequence;
	
	// configure fopFactory as desired
	private FopFactory fopFactory = FopFactory.newInstance();

		/**
		 * {@inheritDoc}
		 */
		public void export(String fileName, UCompositeSection doc) {

			File fo = createFOFile(doc);
		       
	        OutputStream out = null;
	        
	        try {
	            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
	            // configure foUserAgent as desired
	    
	            // Setup output stream.  Note: Using BufferedOutputStream
	            // for performance reasons (helpful with FileOutputStreams).
	            out = new FileOutputStream(fileName);
	            out = new BufferedOutputStream(out);

	            // Construct fop with desired output format
	            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

	            // Setup JAXP using identity transformer
	            TransformerFactory factory = TransformerFactory.newInstance();
	            Transformer transformer = factory.newTransformer(); // identity transformer
	            
	            // Setup input stream
	            Source src = new StreamSource(fo);

	            // Resulting SAX events (the generated FO) must be piped through to FOP
	            Result res = new SAXResult(fop.getDefaultHandler());
	            
	            // Start XSLT transformation and FOP processing
	            transformer.transform(src, res);
	            

	        } catch (IOException e) {
	            e.printStackTrace(System.err);
	        } catch (FOPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
			

		}


		private File createFOFile(UCompositeSection uDoc) {
			
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder parser = factory.newDocumentBuilder();
				
				doc = parser.newDocument();
				
				
				root = doc.createElement("fo:root");
				doc.appendChild(root);
				root.setAttribute("xmlns:fo", "http://www.w3.org/1999/XSL/Format");
				createLayoutMasterSet();
	
				pageSequence = doc.createElement("fo:page-sequence");
				root.appendChild(pageSequence);
				pageSequence.setAttribute("master-reference", "pageLayout");
				
				insertHeaderAndFooter();
				
				Element flow = doc.createElement("fo:flow");
				pageSequence.appendChild(flow);
				flow.setAttribute("flow-name", "xsl-region-body");
				
				writeUDocument(flow, uDoc);
				

				StringBuffer sb = new StringBuffer();
				sb.append(System.getProperty("user.home"));
				sb.append(File.separatorChar);
				sb.append(".exportTmp.fo");
			
				String pathName = sb.toString();
				

		        Transformer tFormer = TransformerFactory.newInstance().newTransformer();
//		        Output Types (text/xml/html)
		        tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
//		        Write the document to a file
		        Source source = new DOMSource(doc);
//		       Create File  to view your xml data as       vk.txt/vk.doc/vk.xls/vk.shtml/vk.html)
		        Result result = new StreamResult(new File(pathName));
		        tFormer.transform(source, result);
		        System.out.println("File creation successfully!");
		        
		        return new File(pathName);
				
			    
//		        Source src = new DOMSource(doc2); 
//		        Result dest = new StreamResult(System.out); 
//		        aTransformer.transform(src, dest); 

			    } catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerFactoryConfigurationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return null;
		}


		private void writeUDocument(Element parent, UDocument uDoc) {
			if (uDoc instanceof USection) {
				writeSection(parent, (USection) uDoc);
			}
			else if (uDoc instanceof UParagraph){
				writeUParagraph(parent, (UParagraph) uDoc);
			} 
			else if (uDoc instanceof UCompositeSection) {
				writeUCompositeSection(parent, (UCompositeSection) uDoc);
			} 
			else if (uDoc instanceof UList) {
				writeUList(parent, (UList) uDoc);
			} 
			else {
				System.out.println(uDoc.getClass().getSimpleName() + "not implemented yet");
			}
		}


		private void writeUList(Element parent, UList list) {
			Element listBlock = doc.createElement("fo:list-block");
			parent.appendChild(listBlock);
			
			for (String entry :list.getContents()) {
				Element listItem = doc.createElement("fo:list-item");
				listBlock.appendChild(listItem);
				
				Element listItemLabel = doc.createElement("fo:list-item-label");
				listItem.appendChild(listItemLabel);
				listItemLabel.setAttribute("end-indent", "label-end()");
				
				Element bulletBlock = doc.createElement("fo:block");
				listItemLabel.appendChild(bulletBlock);
				
				Element bulletSymbol = doc.createElement("fo:inline");
				bulletBlock.appendChild(bulletSymbol);
//				bulletSymbol.setAttribute("font-family", "Symbol");
				bulletSymbol.setTextContent("-");
				
				
				Element listItemBody = doc.createElement("fo:list-item-body");
				listItem.appendChild(listItemBody);
				listItemBody.setAttribute("start-indent", "body-start()");
				
				Element textBlock = doc.createElement("fo:block");
				listItemBody.appendChild(textBlock);
				textBlock.setTextContent(entry);
			}
		}


		private void writeUCompositeSection(Element parent,
				UCompositeSection uDoc) {
			
			for (UDocument child : uDoc.getChildren()) {
				writeUDocument(parent, child);
			}
		}


		private void writeUParagraph(Element parent, UParagraph child) {
			Element text = doc.createElement("fo:block");
			parent.appendChild(text);
			text.setAttribute("font-size", "12pt");
			text.setAttribute("font-family", "sans-serif");
			text.setAttribute("color", "black");
			setTextOption(text, child.getOption());
			text.setTextContent(child.getText());
			
			for (UDocument subChild : child.getChildren()) {
//				System.out.println("writing a sections child " + subChild.getClass().getSimpleName());
//				
//				if (subChild instanceof UParagraph) {
//					System.out.println(((UParagraph) subChild).getText());
//				}
				System.out.println(subChild.getClass().getSimpleName());
				writeUDocument(text, subChild);
			}
		}


		private void writeSection(Element parent, USection child) {
			Element section = doc.createElement("fo:block");
			parent.appendChild(section);
			section.setAttribute("font-size", "18pt");
			section.setAttribute("font-family", "sans-serif");
			section.setAttribute("color", "black");
			section.setAttribute("padding-top", "12pt");
			child.getOption().setFontSize(16);
			setTextOption(section, child.getTitlParagraph().getOption());
			section.setTextContent("- " + child.getTitlParagraph().getText());
			
			
			for (UDocument subChild : child.getChildren()) {
//				System.out.println("writing a sections child " + subChild.getClass().getSimpleName());
//				
//				if (subChild instanceof UParagraph) {
//					System.out.println(((UParagraph) subChild).getText());
//				}
				
				writeUDocument(section, subChild);
			}
		}


		private void insertHeaderAndFooter() {
			//header
			Element header = doc.createElement("fo:static-content");
			pageSequence.appendChild(header);
			header.setAttribute("flow-name", "xsl-region-before");
			
			Element page = doc.createElement("fo:block");
			header.appendChild(page);
			page.setAttribute("text-align", "center");
			page.setAttribute("font-size", "10pt");
			page.setAttribute("font-family", "serif");
			page.setAttribute("line-height", "14pt");
			page.setTextContent("page");
			
			Element pageNumber = doc.createElement("fo:page-number");
			page.appendChild(pageNumber);
			
			//footer
			//TODO
			
		}


		private void createLayoutMasterSet() {
			Element layoutMasterSet = doc.createElement("fo:layout-master-set");
			root.appendChild(layoutMasterSet);
			
			//master page
			Element simplePageMaster = doc.createElement("fo:simple-page-master");
			layoutMasterSet.appendChild(simplePageMaster);
			simplePageMaster.setAttribute("master-name", "pageLayout");
			
			//body
			Element regionBody = doc.createElement("fo:region-body");
			simplePageMaster.appendChild(regionBody);
			regionBody.setAttribute("margin-top", "50pt");
			regionBody.setAttribute("margin-bottom", "50pt");
			regionBody.setAttribute("margin-left", "100pt");
			regionBody.setAttribute("margin-right", "100pt");
			
			//header
			Element regionBefore = doc.createElement("fo:region-before");
			simplePageMaster.appendChild(regionBefore);
			regionBefore.setAttribute("extent", "15pt");
			
			//footer
			Element regionAfter = doc.createElement("fo:region-after");
			simplePageMaster.appendChild(regionAfter);
			regionAfter.setAttribute("extent", "15pt");	
			
			//master for all pages
//			Element pageSequenceMaster = doc.createElement("fo:page-sequence-master");
//			layoutMasterSet.appendChild(pageSequenceMaster);
//			pageSequenceMaster.setAttribute("master-name", "pageLayout");
		}

		private void setTextOption(Element element, TextOption option) {
			element.setAttribute("font-size", option.getFontSize() + "pt");
		}

		/**
		 * {@inheritDoc}
		 */
		public String getFileType() {
			return "pdf";
		}
	
}
