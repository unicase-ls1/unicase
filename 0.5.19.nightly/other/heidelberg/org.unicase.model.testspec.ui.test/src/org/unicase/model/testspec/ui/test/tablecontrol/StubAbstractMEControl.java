package org.unicase.model.testspec.ui.test.tablecontrol;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.testspec.TestspecFactory;

public abstract class StubAbstractMEControl {
    private FormToolkit toolkit;
    private ModelElement modelElement;
    private EditingDomain editingDomain;
    private boolean showLabel;
    private IItemPropertyDescriptor itemPropertyDescriptor;
    
    public StubAbstractMEControl(String featureName) {
        if(featureName.equals("testSteps")) {
            this.modelElement = TestspecFactory.eINSTANCE.createTestProtocol();
        } else {
            this.modelElement = TestspecFactory.eINSTANCE.createTestStep();
        }
        ResourceSet resourceSet = new ResourceSetImpl();
        this.editingDomain = TransactionalEditingDomain.Factory.INSTANCE
            .createEditingDomain(resourceSet);
        this.toolkit = new FormToolkit(PlatformUI.getWorkbench().getDisplay());
        AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
                new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
        List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
                .getPropertyDescriptors(modelElement);
        if (propertyDescriptors != null) {
            for (IItemPropertyDescriptor itemPropertyDescriptor2 : propertyDescriptors) {
                Object feature = itemPropertyDescriptor2.getFeature(modelElement);
                if(feature instanceof EReference) {
                    if (((EReference) feature).getName().equals(featureName)) {
                    this.itemPropertyDescriptor =  itemPropertyDescriptor2;
                    break;
                    }
                }
            }
        }
    }

    public FormToolkit getToolkit() {
        return toolkit;
    }
    public ModelElement getModelElement() {
        return modelElement;
    }
    public EditingDomain getEditingDomain() {
        return editingDomain;
    }
    public boolean getShowLabel() {
        return this.showLabel;
    }
    public void setShowLabel(boolean show) {
        this.showLabel = show;
    }
    public IItemPropertyDescriptor getItemPropertyDescriptor() {
        return itemPropertyDescriptor;
    }
    public void dispose() {

    }
    public abstract int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement);
}
