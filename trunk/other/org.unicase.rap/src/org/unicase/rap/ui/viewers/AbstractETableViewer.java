package org.unicase.rap.ui.viewers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.rap.ui.labelproviders.DateColumnLabelProvider;
import org.unicase.rap.ui.labelproviders.GenericColumnLabelProvider;
import org.unicase.rap.ui.labelproviders.StatusLabelProvider;
import org.unicase.rap.ui.sorters.TableViewerColumnSorter;

/**
 * 
 * @author Edgar Mueller
 * @author Fatih Ulusoy
 */
public abstract class AbstractETableViewer extends TableViewer {
	
	private final String WIDTH = "width";
	private final String FEATURE = "feature";

	private List<TableViewerColumn> columns;
	private int numColumns;
	private Composite composite;
	private ObservableListContentProvider contentProvider;
	
	/**
	 * 
	 * @param projectSpace
	 * @param composite
	 */
	public AbstractETableViewer(Composite composite) {
		super(composite, SWT.BORDER);
		this.composite = composite;
		contentProvider =  new ObservableListContentProvider();
		setContentProvider(contentProvider);
		init();	
	}
	
	/**
	 * Returns the list of EStructuralFeature one is interested in.
	 * 
	 */
	public abstract ArrayList<EStructuralFeature> getFeaturesList();
		
	/**
	 * 
	 */
	protected void init() {
		getTable().setLinesVisible(true);
		getTable().setHeaderVisible(true);
		
		ArrayList<EStructuralFeature> featureList = getFeaturesList();
		EStructuralFeature[] featureArray = new EStructuralFeature[featureList.size()];
		featureArray = featureList.toArray(featureArray);

		IObservableSet knownElements = contentProvider.getKnownElements();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(knownElements, featureArray);
		ObservableMapLabelProvider labelProvider = new ObservableMapLabelProvider(observeMaps);

		createColumns(featureList, labelProvider);
	}

	/**
	 * Creates table viewer columns from this set of features.
	 * 
	 * @param features
	 *            EStructuralFeatures for each of which a TableViewerColumn is
	 *            created.
	 * @param labelProvider
	 *            LabelProvider for some columns.
	 * @return columns
	 */
	public List<TableViewerColumn> createColumns(Collection<EStructuralFeature> features, ILabelProvider labelProvider) {
		
		// prevent div by 0
		numColumns = features.size() > 0 ? features.size() : 1;
		columns = new ArrayList<TableViewerColumn>(numColumns);
		
		for (EStructuralFeature feature : features) {
			if (feature.getEType().equals(EcorePackage.Literals.EDATE)) {
				columns.add(createDateColumn(feature));
			} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
				columns.add(createGenericColumn(labelProvider,feature));
			} else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE)) {
				columns.add(createStateColumn(feature));
			} else {
				columns.add(createGenericColumn(labelProvider,feature));
			}
		}
		
		return columns;
	}
	
	
	/**
	 * Creates a column.
	 * 
	 * @param labelProvider LabelProvider for column.
	 * @param feature EStructuralFeatures for a TableViewerColumn is created.
	 * @return
	 */
	private TableViewerColumn createGenericColumn(ILabelProvider labelProvider,
			EStructuralFeature feature) {

		int style, width;
		ColumnLabelProvider provider = new GenericColumnLabelProvider(labelProvider, feature);
		
		if (feature.getEType().equals(EcorePackage.Literals.EINT)) {
			style = SWT.CENTER;
			width = 50;
		} else if (feature.getEType().equals(OrganizationPackage.Literals.ORG_UNIT)
			|| feature.getEType().equals(OrganizationPackage.Literals.USER)) {
			style = SWT.CENTER;
			width = 100;
		} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
			width = 50;
			style = SWT.NONE;
		} else if (feature.equals(MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR)) {
			style = SWT.CENTER;
			width = 100;
		} else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME)) {
			width = 300;
			style = SWT.NONE;
		}  else {
			style = SWT.CENTER;
			width = 150;
		}

		TableViewerColumn genericColumn = createColumn(feature, provider, width, style, true, true);
		return genericColumn;
	}
	
	/**
	 * Creates column for state feature.
	 * 
	 * @param feature
	 * @return
	 */
	private TableViewerColumn createStateColumn(EStructuralFeature feature) {
		ColumnLabelProvider labelProvider = new StatusLabelProvider();
		TableViewerColumn stateColumn = createColumn(feature, labelProvider, 35, SWT.CENTER, true, false);
		return stateColumn;
	}
	
	/**
	 * Creates column for date feature.
	 * 
	 * @param feature
	 * @return
	 */
	private TableViewerColumn createDateColumn(EStructuralFeature feature) {
		ColumnLabelProvider provider = new DateColumnLabelProvider(feature);
		TableViewerColumn dateColumn = createColumn(feature, provider, 150, SWT.CENTER, true, true);
		return dateColumn;
	}
	
	/**
	 * All column creation methods should use this method first.
	 * 
	 * @param feature
	 * @param labelProvider
	 * @param width
	 * @param style
	 * @param resizeable
	 * @param setSorter
	 * @return
	 */
	private TableViewerColumn createColumn(EStructuralFeature feature,
			ColumnLabelProvider labelProvider, int width, int style,
			boolean resizeable, boolean setSorter) {
		
		TableViewerColumn column = new TableViewerColumn(this, style);
		
		String columnName = feature.getName();
		columnName = columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
		
		column.getColumn().setText(columnName);
		column.getColumn().setWidth(width);

		column.getColumn().setMoveable(true);
		column.getColumn().setResizable(resizeable);

		column.setLabelProvider(labelProvider);
		
		if (setSorter) {
			ViewerComparator comp = new TableViewerColumnSorter(this, column, labelProvider);
			column.getViewer().setComparator(comp);
		}
		
		column.getColumn().setData(WIDTH, new Integer(width));
		column.getColumn().setData(FEATURE, feature.getName());
		
		TableColumnLayout columnLayout = new TableColumnLayout();
		columnLayout.setColumnData(column.getColumn(), new ColumnWeightData(100/numColumns));
		
		composite.setLayout(columnLayout);
//		this.getTable().setLayout(columnLayout);
		
		return column;
	}
}


