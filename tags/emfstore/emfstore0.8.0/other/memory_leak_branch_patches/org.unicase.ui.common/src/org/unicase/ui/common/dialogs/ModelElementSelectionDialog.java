/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.dialogs;

import java.util.Collection;
import java.util.Comparator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ModelElementContext;
import org.unicase.ui.common.Activator;

/**
 * Abstract Dialog as pattern for all dialogs which show ModelElements for selection.
 * 
 * @author mkagel
 */
public abstract class ModelElementSelectionDialog extends FilteredItemsSelectionDialog {

	private static final String DIALOG_SETTINGS = "STANDARD_DIALOG_SETTING";
	private static final String DIALOG_MESSAGE = "Enter model element name prefix or pattern (e.g. *Trun?)";
	private static final String DIALOG_TITLE = "Search Model Element";
	private static final String DIALOG_INITIAL_PATTERN = "**";

	private ILabelProvider labelProvider;
	private Collection<EObject> modelElements;

	/**
	 * Constructor which calls another constructor with parameter false for multiple selection of elements.
	 */
	public ModelElementSelectionDialog() {
		this(false);
	}

	/**
	 * Contructor which calls another constructor with project parameter and false for multiple selection of elements.
	 * 
	 * @param context the context
	 */
	public ModelElementSelectionDialog(ECPModelelementContext context) {
		this(context, false);
	}

	/**
	 * Constructor which calls another constructor with null for project paramter (modelelemnts will be set from
	 * outside) and the given multiSelection behaviour.
	 * 
	 * @param multiSelection indicates whether dialog allows to select more than one item
	 */
	public ModelElementSelectionDialog(boolean multiSelection) {
		this(null, multiSelection);
	}

	/**
	 * Creates a new label provider to be used for this dialog.
	 * 
	 * @return a label provider for the dialog
	 */
	protected ILabelProvider createLabelProvider() {
		// hkq: done
		return new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * Main-Constructor, here will be done the main work.
	 * 
	 * @param context The context from where the modelelements come from, is null if no context is set an the
	 *            modelelements come from outside the dialog
	 * @param multiSelection indicates whether dialog allows to select more than one item
	 */
	public ModelElementSelectionDialog(ECPModelelementContext context, boolean multiSelection) {
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), multiSelection);

		if (context != null) {
			modelElements = context.getAllModelElements();
		}

		setLabelProvider(createLabelProvider());
		this.setListLabelProvider(getLabelProvider());
		this.setDetailsLabelProvider(getLabelProvider());

		this.setBlockOnOpen(true);
		this.setTitle(DIALOG_TITLE);
		this.setMessage(DIALOG_MESSAGE);
		this.setInitialPattern(DIALOG_INITIAL_PATTERN);
	}

	/**
	 * Constructor which calls another constructor and sets the modelElements-Collection of the dialog only to a
	 * specified class type.
	 * 
	 * @param context from where the modelelements come from
	 * @param classType which should be shown in the dialog
	 * @param multiSelection indicates whether dialog allows to select more than one item
	 */
	public ModelElementSelectionDialog(ModelElementContext context, EClass classType, boolean multiSelection) {
		this(multiSelection);
		modelElements = context.getAllModelElementsbyClass(classType);
	}

	/**
	 * Constructor which calls another constructor.
	 * 
	 * @param context from where the modelelements come from
	 * @param classType of the modelelements which should be shown in the dialog
	 */
	public ModelElementSelectionDialog(ModelElementContext context, EClass classType) {
		this(context, classType, false);
	}

	/**
	 * Sets the labelProvider. LabelProvider and containing adapterFactory will be disposed when closing this dialog
	 * (means do not set a labelprovider or adapterfactory which is referenced by more than one object).
	 * 
	 * @param labelProvider is the labelProvider for this class
	 */
	protected void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	/**
	 * Returns the LabelProvider for this class.
	 * 
	 * @return labelProvider
	 */
	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * Returns the ModelElement-Collection which contains the modelelements shown in the dialog.
	 * 
	 * @return Collection of modelelements for the dialog
	 */
	public Collection<EObject> getModelElements() {
		return modelElements;
	}

	/**
	 * Set the ModelElement-Collection from outside. Necessary if the collection is not set by the dialog but coms from
	 * the caller.
	 * 
	 * @param modelElements Collection which modelelements which will be shown in the dialog
	 */
	public void setModelElements(Collection<EObject> modelElements) {
		this.modelElements = modelElements;
	}

	/**
	 * Does nothing.
	 * 
	 * @param parent the parent
	 * @return null
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/**
	 * Returns a new instance of class ModelElementFilter.
	 * 
	 * @return new instance of class ModelElementFilter
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new ModelElementFilter();
	}

	/**
	 * Fills the content provider with all elements matching the items filter.
	 * 
	 * @param contentProvider the content provider which gets added the items
	 * @param itemsFilter the used items filter
	 * @param progressMonitor a progress monitor stating the progress
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
		IProgressMonitor progressMonitor) {

		progressMonitor.beginTask("Searching", modelElements.size());
		for (EObject modelElement : modelElements) {
			contentProvider.add(modelElement, itemsFilter);
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

	/**
	 * Gets the dialog settings.
	 * 
	 * @return the dialog settings
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
		}
		return settings;
	}

	/**
	 * Gets the name of an element by asking the labelProvider.
	 * 
	 * @return the name as provided by the labelProvider
	 * @param item the element to get the name from
	 */
	@Override
	public String getElementName(Object item) {
		if (item instanceof EObject) {
			return getLabelProvider().getText(item);
		} else {
			return item.toString();
		}
	}

	/**
	 * Returns an alphabetical comparator.
	 * 
	 * @return an alphabetical comparator
	 */
	@Override
	protected Comparator<EObject> getItemsComparator() {
		return new Comparator<EObject>() {
			public int compare(EObject arg0, EObject arg1) {
				return arg0.toString().compareTo(arg1.toString());
			}
		};
	}

	/**
	 * Always returns Status.OK_STATUS.
	 * 
	 * @return Status.OK_STATUS
	 * @param item an item
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#close()
	 */
	@Override
	public boolean close() {
		if (labelProvider != null) {
			if (labelProvider instanceof AdapterFactoryLabelProvider) {
				AdapterFactory adapterFactory = ((AdapterFactoryLabelProvider) labelProvider).getAdapterFactory();
				if (adapterFactory != null && adapterFactory instanceof IDisposable) {
					((IDisposable) adapterFactory).dispose();
				}
			}
		}
		labelProvider.dispose();
		return super.close();
	}

	/**
	 * A filter class for model elements.
	 * 
	 * @author mkagel
	 */
	public class ModelElementFilter extends ItemsFilter {

		/**
		 * @param item the item
		 * @return true
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#isConsistentItem(java.lang.Object)
		 */
		@Override
		public boolean isConsistentItem(Object item) {
			return true;
		}

		/**
		 * Matches ModelElement's toString Methods.
		 * 
		 * @param item an WorkPackage
		 * @return bool
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#matchItem(java.lang.Object)
		 */
		@Override
		public boolean matchItem(Object item) {
			String label = getLabelProvider().getText(item);

			if (!patternMatcher.getPattern().startsWith("*")) {
				this.patternMatcher.setPattern("*" + patternMatcher.getPattern() + "*");
			}

			return matches(label);
		}

	}

}
