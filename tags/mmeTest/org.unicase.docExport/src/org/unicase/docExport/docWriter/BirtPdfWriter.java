package org.unicase.docExport.docWriter;

// Java
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class BirtPdfWriter implements DocWriter {


		/**
		 * {@inheritDoc}
		 */
		public void export(String fileName, UCompositeSection doc) {
//			try {
//				SessionHandle session = DesignEngine.newSession( null ); 
//
//				ReportDesignHandle design = session.createDesign( ); 
//
//				ElementFactory factory = design.getElementFactory( ); 
//
//				DesignElementHandle element = factory.newSimpleMasterPage( "Page Master" );
//				design.getMasterPages( ).add( element ); 
//
//				GridHandle grid = factory.newGridItem( null, 2 /* cols */, 1 /* row */ );
//				design.getBody( ).add( grid );
//				grid.setWidth( "100%" ); 
//
//				RowHandle row = (RowHandle) grid.getRows( ).get( 0 );
//				ImageHandle image = factory.newImage( null );
//				CellHandle cell = (CellHandle) row.getCells( ).get( 0 );
//				cell.getContent( ).add( image );
//				image.setURI( "http://www.eclipse.org/birt/phoenix/tutorial/multichip-4.jpg"); 
//
//				LabelHandle label = factory.newLabel( null );
//				cell = (CellHandle) row.getCells( ).get( 1 );
//				cell.getContent( ).add( label );
//				label.setText( "Hello, world!" );
//
//				design.saveAs( "sample.rptdesign" );
//				design.close( );
//			
//			// We're done!
//			} catch (ContentException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NameException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SemanticException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}


		/**
		 * {@inheritDoc}
		 */
		public String getFileType() {
			return "pdf";
		}
	
}
