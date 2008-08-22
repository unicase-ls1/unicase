package org.unicase.ui.stem.views.historybrowserview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.Version;

public class HistoryTableLabelProvider extends AdapterFactoryLabelProvider {

	private static final int REVISION_COLUMN = 0;
	private static final int TAG_COLUMN = 1;
	private static final int DATE_COLUMN = 2;
	private static final int AUTHOR_COLUMN = 3;
	private static final int LOGMSG_COLUMN = 4;
	
	
	public HistoryTableLabelProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}


	@Override
	public String getColumnText(Object object, int columnIndex) {
		if(object instanceof Version){
			Version version = (Version)object;
			switch (columnIndex){
			case REVISION_COLUMN :
				return Integer.toString(version.getPrimarySpec().getIdentifier());
			case TAG_COLUMN :
				return version.getTagSpecs().get(0).getName();
			case DATE_COLUMN :
				return version.getLogMessage().getDate().toString();
			case AUTHOR_COLUMN :
				return version.getLogMessage().getAuthor();
			case LOGMSG_COLUMN :
				return version.getLogMessage().getMessage();
			default :
				return "";
			}
		}else{
			return super.getColumnText(object, columnIndex);
	
		}
	}
	
	
	

}
