package org.unicase.model.testspec.ui.test.tablecontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Section;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.unicase.metamodel.util.ModelElementChangeListener;

public class TestTestStepTableControl {
    TestStepTableControl testStepTableControl;
    int style;
    Composite parent;
    Control control;

    @Before
    public void setUp() throws Exception {
        System.out.println("------------------Set up test-------------------");
        IWorkbench workbench = PlatformUI.getWorkbench();
        style = SWT.NULL;
        parent = new Composite(workbench.getDisplay().getShells()[0], style);
        System.out.println("--------------FINISHED Set up test--------------");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateControl() {
        System.out.println("Test createControl");
        this.testStepTableControl = new TestStepTableControl("testSteps");
        this.control = this.testStepTableControl.createControl(parent,
                style);
        assertNotNull(this.control);
        assertNotNull(((Section)this.control).getTextClient());
        assertTrue(((Section)this.control).isExpanded());
        assertEquals(this.testStepTableControl.getItemPropertyDescriptor()
                .getDisplayName(this.testStepTableControl.getModelElement()), 
                ((Section)this.control).getText());
        assertTrue(((Section)this.control).getClient() instanceof ScrolledComposite);
        assertTrue(((Composite)((Section)this.control).getClient()).getChildren().length == 1);
        assertTrue(((ScrolledComposite)((Section)this.control).getClient())
                .getContent() instanceof Composite);
        assertTrue(((Composite)((ScrolledComposite)((Section)this.control).getClient())
                .getContent()).getChildren().length == 1);
        System.out.println("PASSED");
    }
    
    @Test
    public void testChangeListener() {
        this.testCreateControl();
        ModelElementChangeListener changeListener = this.testStepTableControl.getChangeListener();
        assertNotNull(changeListener);
    }
    
    @Test
    public void testCanRenderTestStep() {
        System.out.println("Test canRender with test step");
        this.testStepTableControl = new TestStepTableControl("testSteps");
        int priority = this.testStepTableControl.canRender(this.testStepTableControl
                .getItemPropertyDescriptor(), this.testStepTableControl.getModelElement());
        assertTrue (priority == 2);
        System.out.println("PASSED");
    }
    
    @Test
    public void testCanRenderNotTestStep() {
        System.out.println("Test canRender not with testSteps");
        this.testStepTableControl = new TestStepTableControl("");
        AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
                new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
        List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
                .getPropertyDescriptors(this.testStepTableControl.getModelElement());
        IItemPropertyDescriptor itemPropertyDescriptor;
        if (propertyDescriptors != null) {
            for (IItemPropertyDescriptor itemPropertyDescriptor2 : propertyDescriptors) {
                Object feature = itemPropertyDescriptor2.getFeature(this.testStepTableControl.getModelElement());
                if(feature instanceof EReference) {
                    if (((EReference) feature).getName().equals("testCase")) {
                    itemPropertyDescriptor =  itemPropertyDescriptor2;
                    int priority = this.testStepTableControl.canRender(itemPropertyDescriptor, 
                            this.testStepTableControl.getModelElement());
                    assertTrue (priority == -1);
                    break;
                    }
                }
            }
        }
        System.out.println("PASSED");
    }
    
    
}
