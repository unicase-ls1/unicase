package org.unicase.ui.usecaseDiagram.unicase;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.unicase.ui.usecaseDiagram.unicase.CenterLayout;

/**
 * @generated
 */
public class ComponentFigure extends RectangleFigure {

	/**
	 * @generated
	 */
	private org.unicase.ui.usecaseDiagram.unicase.Label fFigureComponentFigure_name;

	/**
	 * @generated
	 */
	public ComponentFigure() {

		/*ToolbarLayout layoutThis = new ToolbarLayout();

		layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

		layoutThis.setSpacing(10);

		this.setLayoutManager(layoutThis);*/
		this.setLayoutManager(new BorderLayout());

		this.setForegroundColor(ColorConstants.black);
		this.setBorder(new MarginBorder(5));
		createContents();
	}

	/**
	 * @generated
	 */
	private void createContents() {

		Figure header0 = new Figure();

		this.add(header0, BorderLayout.TOP);
		header0.setLayoutManager(new StackLayout());

		org.unicase.ui.usecaseDiagram.unicase.Label componentText1 = new org.unicase.ui.usecaseDiagram.unicase.Label();

		componentText1.setText("\u00ABcomponent\u00BB");

		header0.add(componentText1);

		Figure iconContainer1 = new Figure();

		header0.add(iconContainer1);

		BorderLayout layoutIconContainer1 = new BorderLayout();
		iconContainer1.setLayoutManager(layoutIconContainer1);

		org.unicase.ui.usecaseDiagram.unicase.ComponentIcon componentIcon2 = new org.unicase.ui.usecaseDiagram.unicase.ComponentIcon();

		componentIcon2.setSize(20,22);
		iconContainer1.add(componentIcon2, BorderLayout.RIGHT);
		
		Figure header1=new Figure();
		header1.setLayoutManager(new CenterLayout());
		
		fFigureComponentFigure_name = new org.unicase.ui.usecaseDiagram.unicase.Label();

		header1.add(fFigureComponentFigure_name);
		this.add(header1,BorderLayout.CENTER);

		
	}

	/**
	 * @generated
	 */
	private boolean myUseLocalCoordinates = false;

	/**
	 * @generated
	 */
	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	/**
	 * @generated
	 */
	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	/**
	 * @generated
	 */
	public org.unicase.ui.usecaseDiagram.unicase.Label getFigureComponentFigure_name() {
		return fFigureComponentFigure_name;
	}

}