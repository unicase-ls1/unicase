package org.unicase.model.testspec.ui.test.tablecontrol;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.unicase.model.testspec.ui.test.tablecontrol.TestStepParameterControl;

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

public class TestTestStepParameterControl {
    TestStepParameterControl testStepParameterControl;
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
    public void testCreateControlInput() {
        System.out.println("Test createControl with input parameter");
        this.testStepParameterControl = new TestStepParameterControl("input");
        this.control = this.testStepParameterControl.createControl(parent,
                style);
        assertNotNull(this.control);
        assertNotNull(((Section)this.control).getTextClient());
        assertTrue(((Section)this.control).isExpanded());
        assertEquals(this.testStepParameterControl.getItemPropertyDescriptor()
                .getDisplayName(this.testStepParameterControl.getModelElement()), 
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
    public void testCreateControlOutput() {
        System.out.println("Test createControl with output parameter");
        this.testStepParameterControl = new TestStepParameterControl("output");
        this.control = this.testStepParameterControl.createControl(parent,
                style);
        assertNotNull(this.control);
        assertNotNull(((Section)this.control).getTextClient());
        assertTrue(((Section)this.control).isExpanded());
        assertEquals(this.testStepParameterControl.getItemPropertyDescriptor()
                .getDisplayName(this.testStepParameterControl.getModelElement()), 
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
    public void testCanRenderInput() {
        System.out.println("Test canRender with input parameter");
        this.testStepParameterControl = new TestStepParameterControl("input");
        int priority = this.testStepParameterControl.canRender(this.testStepParameterControl
                .getItemPropertyDescriptor(), this.testStepParameterControl.getModelElement());
        assertTrue (priority == 2);
        System.out.println("PASSED");
    }
    
    @Test
    public void testCanRenderOutput() {
        System.out.println("Test canRender with output parameter");
        this.testStepParameterControl = new TestStepParameterControl("output");
        int priority = this.testStepParameterControl.canRender(this.testStepParameterControl
                .getItemPropertyDescriptor(), this.testStepParameterControl.getModelElement());
        assertTrue (priority == 2);
        System.out.println("PASSED");
    }
    
    @Test
    public void testCanRenderNotInputOutput() {
        System.out.println("Test canRender not with input/output parameter");
        this.testStepParameterControl = new TestStepParameterControl("");
        AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
                new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
        List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
                .getPropertyDescriptors(this.testStepParameterControl.getModelElement());
        IItemPropertyDescriptor itemPropertyDescriptor;
        if (propertyDescriptors != null) {
            for (IItemPropertyDescriptor itemPropertyDescriptor2 : propertyDescriptors) {
                Object feature = itemPropertyDescriptor2.getFeature(this.testStepParameterControl.getModelElement());
                if(feature instanceof EReference) {
                    if (((EReference) feature).getName().equals("exception")) {
                    itemPropertyDescriptor =  itemPropertyDescriptor2;
                    int priority = this.testStepParameterControl.canRender(itemPropertyDescriptor, 
                            this.testStepParameterControl.getModelElement());
                    assertTrue (priority == -1);
                    break;
                    }
                }
            }
        }
        System.out.println("PASSED");
    }
}
