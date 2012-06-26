/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultAttributeRendererFactory;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.RenderersFactory;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URef;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.TextAlign;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Element Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl#getRendererOptions <em>Renderer
 * Options</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl#getTemplate <em>Template</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl#getAttributeRendererMapping <em>
 * Attribute Renderer Mapping</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ModelElementRendererImpl extends EObjectImpl implements ModelElementRenderer {

	private static final int DESCRIPTION_MIN_SIZE = 500;
	private static final int SECTION_DESCRIPTION_MARGIN = 10;
	protected static final double SECTION_INITIAL_BORDER_SIZE = 2;
	protected static final int SECTION_LEFT_BORDER_PADDING = 5;
	protected static final int INDENTION_WIDTH = 15;
	protected static final int SECTION_MARGIN_BOTTOM = 15;
	protected static final int SECTION_MARGIN_TOP = 15;
	private static final double PROPERTIES_TABLE_BORDER_SIZE = 0.8;

	private final AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	/**
	 * The cached value of the '{@link #getRendererOptions() <em>Renderer Options</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRendererOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<RendererOption> rendererOptions;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected Template template;

	/**
	 * The cached value of the '{@link #getAttributeRendererMapping() <em>Attribute Renderer Mapping</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributeRendererMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeRendererMapping> attributeRendererMapping;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelElementRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RenderersPackage.Literals.MODEL_ELEMENT_RENDERER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RendererOption> getRendererOptions() {
		if (rendererOptions == null) {
			rendererOptions = new EObjectContainmentEList<RendererOption>(RendererOption.class, this,
				RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS);
		}
		return rendererOptions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Template getTemplate() {
		if (template != null && template.eIsProxy()) {
			InternalEObject oldTemplate = (InternalEObject) template;
			template = (Template) eResolveProxy(oldTemplate);
			if (template != oldTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE, oldTemplate, template));
			}
		}
		return template;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Template basicGetTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTemplate(Template newTemplate) {
		Template oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE,
				oldTemplate, template));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AttributeRendererMapping> getAttributeRendererMapping() {
		if (attributeRendererMapping == null) {
			attributeRendererMapping = new EObjectContainmentEList<AttributeRendererMapping>(
				AttributeRendererMapping.class, this,
				RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING);
		}
		return attributeRendererMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			return ((InternalEList<?>) getRendererOptions()).basicRemove(otherEnd, msgs);
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			return ((InternalEList<?>) getAttributeRendererMapping()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			return getRendererOptions();
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			if (resolve)
				return getTemplate();
			return basicGetTemplate();
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			return getAttributeRendererMapping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			getRendererOptions().clear();
			getRendererOptions().addAll((Collection<? extends RendererOption>) newValue);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			setTemplate((Template) newValue);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			getAttributeRendererMapping().clear();
			getAttributeRendererMapping().addAll((Collection<? extends AttributeRendererMapping>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			getRendererOptions().clear();
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			setTemplate((Template) null);
			return;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			getAttributeRendererMapping().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RenderersPackage.MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS:
			return rendererOptions != null && !rendererOptions.isEmpty();
		case RenderersPackage.MODEL_ELEMENT_RENDERER__TEMPLATE:
			return template != null;
		case RenderersPackage.MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING:
			return attributeRendererMapping != null && !attributeRendererMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	// begin custom code
	public final void render(EObject eObject, UCompositeSection parent) {
		TemplateRegistry.setMeCount(TemplateRegistry.getMeCount() + 1);

		/*
		 * A ModelElement should not be rendered twice with the default renderer, because a recursive call may appear,
		 * which will result in a non-terminating algorithm. If this is the first time, the ModelElement is rendred, add
		 * a reference, so that the ModelElement can be linked.
		 */
		if (DocumentExport.hasAlreadyBeenRendered(eObject)) {
			return;
		}

		DocumentExport.addRenderedModelElement(eObject);
		ModelElementId modelElementId = ModelUtil.getProject(eObject).getModelElementId(eObject);
		parent.add(new URef(modelElementId.getId()));

		if (getModelElementDepth(eObject, 1) <= DocumentExport.getRecursionDepth()) {
			doRender(eObject, parent);
		}
	}

	public class FeatureOrdering {
		public Vector<IItemPropertyDescriptor> singleProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> multiProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> containedProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> specialRendererProperties = new Vector<IItemPropertyDescriptor>();
		public Vector<IItemPropertyDescriptor> multiPropertiesOutsideOfTable = new Vector<IItemPropertyDescriptor>();
	}

	@SuppressWarnings("unchecked")
	protected FeatureOrdering orderFeatures(final EObject eObject) {
		/*
		 * order the features by the following types: singleProperties: EAttribute and single ERference linked
		 * multiProperties: EReference, multi containedProperties: single EReference rendered as contained.
		 */
		Vector<IItemPropertyDescriptor> singleProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> multiProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> containedProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> specialRendererProperties = new Vector<IItemPropertyDescriptor>();
		Vector<IItemPropertyDescriptor> multiPropertiesOutsideOfTable = new Vector<IItemPropertyDescriptor>();

		Vector<IItemPropertyDescriptor> propertyDescriptors = getPropertyDescriptors(eObject);

		Collections.sort(propertyDescriptors, new Comparator() {
			public int compare(Object o1, Object o2) {
				IItemPropertyDescriptor pD1 = (IItemPropertyDescriptor) o1;
				IItemPropertyDescriptor pD2 = (IItemPropertyDescriptor) o2;

				EStructuralFeature feature1 = (EStructuralFeature) pD1.getFeature(eObject);
				EStructuralFeature feature2 = (EStructuralFeature) pD2.getFeature(eObject);

				AttributeRenderer renderer1 = getAttributeRendererNotNull(feature1);
				AttributeOption attributeOption1 = renderer1.getAttributeOption();

				AttributeRenderer renderer2 = getAttributeRendererNotNull(feature2);
				AttributeOption attributeOption2 = renderer2.getAttributeOption();

				if (attributeOption1 == null || attributeOption2 == null) {
					return 0;
				}
				int orderNumber1 = attributeOption1.getOrderNumber();
				int orderNumber2 = attributeOption2.getOrderNumber();

				if (orderNumber1 > orderNumber2) {
					return 1;
				} else if (orderNumber1 == orderNumber2) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		for (IItemPropertyDescriptor propertyDescriptor : propertyDescriptors) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(eObject);

			boolean hide;
			AttributeRenderer renderer = getAttributeRendererNotNull(feature);
			AttributeOption attributeOption = renderer.getAttributeOption();
			if (attributeOption == null) {
				hide = false;
			} else {
				hide = attributeOption.isHide();
			}

			LayoutOptions layoutOptions = getTemplate().getLayoutOptions();

			/*
			 * Don't render a feature (attribute) in the following cases: 1) the feature is annotation,
			 * incomingDocumentReferences or attachments and the layoutOptions say, that they should be hidden. Normally
			 * these features are not relevant. 2) The feature is called name or description. Those features are always
			 * rendered in the title and description of the section. 3) The attributeOption hide is set to true 4) The
			 * content of the feature is empty
			 */
			if ((feature.getName().equals("annotations") && layoutOptions.isHideAnnotations())
				|| (feature.getName().equals("incomingDocumentReferences") && layoutOptions
					.isHideIncomingDocumentReferences())
				|| (feature.getName().equals("attachments") && layoutOptions.isHideAttachments())
				|| feature.getName().equals("description") || feature.getName().equals("name") || hide
				|| eObject.eGet(feature) == null // hide features with no content
				|| (eObject.eGet(feature) instanceof EList && ((EList<Object>) eObject.eGet(feature)).size() < 1)) {
				// do nothing! do not render these features
			} else {
				// do not show features with special renderers in the table
				if (!(getAttributeRendererNotNull(feature) instanceof DefaultAttributeRenderer)) {
					specialRendererProperties.add(propertyDescriptor);
				}
				// simple EAttributes - String, numbers, boolean etc.
				else if (feature.eClass().getInstanceClass().equals(EAttribute.class)) {
					singleProperties.add(propertyDescriptor);
				}
				// EReference
				else {
					ReferenceAttributeOption option = (ReferenceAttributeOption) renderer.getAttributeOption();
					if (option.isContained()) {
						containedProperties.add(propertyDescriptor);
					}
					// Multi references (EList)
					else if (feature.isMany()) {
						if (((MultiReferenceAttributeOption) option).getListOption().getListStyle()
							.equals(ListStyle.TABLE)) {
							multiProperties.add(propertyDescriptor);
						} else {
							multiPropertiesOutsideOfTable.add(propertyDescriptor);
						}
					}
					// a single reference, which is not contained
					else {
						singleProperties.add(propertyDescriptor);
					}
				}
			}
		}

		FeatureOrdering ordering = new FeatureOrdering();
		ordering.singleProperties = singleProperties;
		ordering.multiProperties = multiProperties;
		ordering.containedProperties = containedProperties;
		ordering.specialRendererProperties = specialRendererProperties;
		ordering.multiPropertiesOutsideOfTable = multiPropertiesOutsideOfTable;

		return ordering;
	}

	/**
	 * The name of the ModelElement is the title of the section. The description will always be rendered, and is
	 * connected to the section. So there is no page break direktly after the section's title.
	 * 
	 * @param modelElement the modelElement which shall be rendered
	 * @param modelElementSection the section of the ModelElement
	 */
	protected void renderTitleAndDescription(UnicaseModelElement modelElement, USection modelElementSection,
		boolean hideStructuralLines) {

		/*
		 * String modelElementName; if (modelElement.getName() == null || modelElement.getName().equals("") ||
		 * modelElement.getName().equals("null")) { modelElementName = "(noName)"; } else { modelElementName =
		 * modelElement.getName(); }
		 */

		// ########################## Description ##########################
		UParagraph description = new UParagraph(DocumentExport.cleanFormatedText(modelElement.getDescription()),
			getTemplate().getLayoutOptions().getDefaultTextOption());
		description.getBoxModel().setKeepWithPrevious(true);
		description.getOption().setTextAlign(TextAlign.JUSTIFY);

		modelElementSection.add(description);

		// keep with properties table, if the description is short
		if (description.getText().length() < DESCRIPTION_MIN_SIZE) {
			description.getBoxModel().setKeepWithNext(true);
		}
		description.getBoxModel().setMarginBottom(SECTION_DESCRIPTION_MARGIN);
	}

	/**
	 * Returns a Vector of the propertyDecriptors of a modelElement. Only editable properties are in this Vector.
	 */
	private Vector<IItemPropertyDescriptor> getPropertyDescriptors(EObject eObject) {
		Vector<IItemPropertyDescriptor> ret = new Vector<IItemPropertyDescriptor>();

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator.getPropertyDescriptors(eObject);
		if (propertyDescriptors != null) {
			ret.addAll(propertyDescriptors);
		}

		return ret;
	}

	/**
	 * Structural lines shall be rendered, if any modelElement on the same layer has contained modelElements, or if the
	 * parent modelElement has structural lines, too.
	 * 
	 * @param object the ModelElement, where structural lines shall be rendered
	 * @return true, if structural lines shall be rendered
	 */
	protected boolean mayRenderStructuralLine(EObject object) {
		// if the recursive depth of the Model Element structure is 1, there wonn't be any children.
		// so there won't be any structural line be needed.
		if (DocumentExport.getRecursionDepth() == 1) {
			return false;
		}

		if (object == null || object.eContainer() == null || object instanceof LeafSection
			|| object instanceof CompositeSection) {
			return false;
		}
		if (mayRenderStructuralLine(object.eContainer())) {
			return true;
		}

		for (EObject content : object.eContainer().eContents()) {
			if (content instanceof UnicaseModelElement && !(content instanceof LeafSection)
				&& !(content instanceof CompositeSection)) {
				FeatureOrdering ordering = orderFeatures(content);

				// check if the special attribute renderer has the hideStructuralLines() option activated
				// if it is activated, the attribute wont be counted as a contained property
				// because it is only used to decide whether the structural lines should be drawn or not
				int containedProperties = 0;
				for (IItemPropertyDescriptor property : ordering.containedProperties) {
					EStructuralFeature feature = (EStructuralFeature) property.getFeature(content);
					AttributeRenderer attributeRenderer = getAttributeRendererNotNull(feature);
					if (!attributeRenderer.hideStructuralLines()) {
						containedProperties++;
					}
				}

				if (ordering.containedProperties.size() + containedProperties > 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param singleProperties all properties, which have a single value like an EAttribute or a single ERference.
	 * @param multiProperties all multi EReferences
	 * @param eObject the modelElement containing the values of the properties
	 * @param parent the section of the ModelELement
	 */
	@SuppressWarnings("unchecked")
	protected void renderPropertiesTable(Vector<IItemPropertyDescriptor> singleProperties,
		Vector<IItemPropertyDescriptor> multiProperties, EObject eObject, USection parent) {

		if (singleProperties.size() + multiProperties.size() < 1) {
			return;
		}

		UTable table = new UTable(2);

		// count the rows of the table, to decide, if the table should be shown on one page
		int rowCount = 0;
		table.setColumnsWidths(new float[] { 30, 70 });

		// ############### Single Properties ########################
		for (IItemPropertyDescriptor propertyDescriptor : singleProperties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(eObject);

			Object obj = eObject.eGet(feature);
			if (obj != null) {
				// count the modelElements beeing rendered
				if (!feature.eClass().getInstanceClass().equals(EAttribute.class)) {
					TemplateRegistry.setMeCount(TemplateRegistry.getMeCount() + 1);
				}

				rowCount++;

				UParagraph leftParagraph = new UParagraph(getAttributeName(feature,
					propertyDescriptor.getDisplayName(eObject)), template.getLayoutOptions().getDefaultTextOption());
				UTableCell tableCellLeft = new UTableCell(leftParagraph);
				tableCellLeft.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
				tableCellLeft.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
				table.add(tableCellLeft);

				UTableCell tableCellRight = new UTableCell("");
				tableCellRight.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
				tableCellRight.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
				table.add(tableCellRight);

				if (eObject.eGet(feature) instanceof EObject) {
					EObject featureModelElement = (EObject) eObject.eGet(feature);
					ModelElementId featureModelElementId = ModelUtil.getProject(featureModelElement).getModelElementId(
						featureModelElement);
					ULink link = new ULink(getText(featureModelElement), featureModelElementId.getId());
					link.setOption(template.getLayoutOptions().getDefaultTextOption());
					UParagraph par = new UParagraph("");
					par.add(link);
					tableCellRight.setContent(par);
				} else {
					AttributeRenderer attributeRenderer = getAttributeRendererNotNull(feature);
					UParagraph attributeContainer = new UParagraph("");
					tableCellRight.setContent(attributeContainer);
					attributeRenderer.render(feature, eObject, attributeContainer, template);
				}
			}
		}

		// ############################ Multi Properties ###########################
		for (IItemPropertyDescriptor propertyDescriptor : multiProperties) {
			EStructuralFeature feature = (EStructuralFeature) propertyDescriptor.getFeature(eObject);
			Object attributeValue = eObject.eGet(feature);
			if (attributeValue instanceof EList) {
				EList<EObject> objectList = (EList<EObject>) attributeValue;

				if (objectList.size() > 0) {
					UParagraph par = new UParagraph("");
					for (EObject referencedObject : objectList) {
						// count the modelElements beeing rendered
						TemplateRegistry.setMeCount(TemplateRegistry.getMeCount() + 1);
						UParagraph entryContainer = new UParagraph("");
						entryContainer.getBoxModel().setBorderBottom(0.5);
						entryContainer.getBoxModel().setBorderStyle(UBorderStyle.DOTTED);
						par.add(entryContainer);
						ModelElementId meId = ModelUtil.getProject(referencedObject)
							.getModelElementId(referencedObject);
						ULink entry = new ULink(getText(referencedObject), meId.getId());
						// register the ModelElement as a link, so that it can be rendered in the
						// appendix if wanted and neccessary
						DocumentExport.addLinkedModelElement(referencedObject);
						entry.setOption(template.getLayoutOptions().getDefaultTextOption());
						// entry.getBoxModel().setBorderBottom(0.5);
						// entry.getBoxModel().setBorderStyle(UBorderStyle.DOTTED);
						entryContainer.add(entry);
						rowCount++;
					}
					// The last row has no border bottom.
					par.getChildren().get(par.getChildren().size() - 1).getBoxModel().setBorderBottom(0);

					UTableCell leftTableCell = new UTableCell(getAttributeName(feature,
						propertyDescriptor.getDisplayName(eObject)), template.getLayoutOptions().getDefaultTextOption());
					leftTableCell.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
					leftTableCell.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
					table.add(leftTableCell);

					UTableCell rightTableCell = new UTableCell(par);
					rightTableCell.getBoxModel().setBorderBottom(PROPERTIES_TABLE_BORDER_SIZE);
					rightTableCell.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
					table.add(rightTableCell);
				}
			}
		}

		table.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
		table.getBoxModel().setBorderTop(PROPERTIES_TABLE_BORDER_SIZE);

		if (rowCount < 20) {
			table.getBoxModel().setKeepTogether(true);
		}

		parent.add(table);
	}

	/**
	 * Returns the default display name of the attribute. If there is a text in the attribute option different from the
	 * empty string, it will be used instead of the defaultName.
	 * 
	 * @param feature the feature of the attribute
	 * @param defaultName the default name of the feature
	 * @return the name of the feature how it shall appear in the document
	 */
	private String getAttributeName(EStructuralFeature feature, String defaultName) {
		String attributeName;
		if (getAttributeRendererNotNull(feature).getAttributeOption().getAttributeText().equals("")) {
			attributeName = defaultName;
		} else {
			attributeName = getAttributeRenderer(feature).getAttributeOption().getAttributeText();
		}
		return attributeName;
	}

	/**
	 * Returns the depth of the ModelElement in the nested Unicase tree.
	 * 
	 * @param modelElement the model element
	 * @param depth the depth to start with
	 * @return the depth of the modelElement.
	 */
	public static int getModelElementDepth(EObject eObject, int depth) {
		EObject parent = eObject.eContainer();
		if (parent == null || parent instanceof LeafSection || parent instanceof CompositeSection
			|| parent instanceof Project) {
			return depth;
		} else {
			return getModelElementDepth(parent, depth + 1);
		}
	}

	/**
	 * Renders a modelElement into another element.
	 * 
	 * @param eObject the modelElement to render
	 * @param parent the parent element where the modelElement shall be rendered into.
	 */
	protected abstract void doRender(EObject eObject, UCompositeSection parent);

	/**
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getAttributeRenderer(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public AttributeRenderer getAttributeRenderer(EStructuralFeature feature) {
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName())) {
				return mapping.getAttributeRenderer();
			}
		}
		return null;
	}

	/**
	 * @see #getAttributeRenderer(EStructuralFeature)
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getAttributeRendererNotNull(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public AttributeRenderer getAttributeRendererNotNull(EStructuralFeature feature) {

		AttributeRenderer renderer = getAttributeRenderer(feature);
		if (renderer == null) {
			return DefaultAttributeRendererFactory.build(feature, template);
		} else {
			return renderer;
		}
	}

	/**
	 * @param feature the feature of the attribute
	 * @param renderer the AttributeRenderer to set
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#setAttributeRenderer(org.eclipse.emf.ecore.EStructuralFeature,
	 *      org.unicase.docExport.exportModel.renderers.AttributeRenderer)
	 */
	public void setAttributeRenderer(EStructuralFeature feature, AttributeRenderer renderer) {
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName())) {
				mapping.setAttributeRenderer(renderer);
				return;
			}
		}

		AttributeRendererMapping mapping = RenderersFactory.eINSTANCE.createAttributeRendererMapping();
		mapping.setFeatureName(feature.getName());
		mapping.setAttributeRenderer(renderer);
		getAttributeRendererMapping().add(mapping);

	}

	/**
	 * @see #getAttributeRendererNotNull(EStructuralFeature)
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#removeAttributeRenderer(org.eclipse.emf.ecore.EStructuralFeature)
	 * @param feature the feature of the attribute
	 */
	public void removeAttributeRenderer(EStructuralFeature feature) {
		AttributeRendererMapping mappingToRemove = null;
		for (AttributeRendererMapping mapping : getAttributeRendererMapping()) {
			if (mapping.getFeatureName().equals(feature.getName())) {
				mappingToRemove = mapping;
			}
		}

		if (mappingToRemove != null) {
			getAttributeRendererMapping().remove(mappingToRemove);
		}
	}

	/**
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer#hideStructuralLines()
	 */
	public boolean hideStructuralLines() {
		return false;
	}

	/**
	 * @param featureName the name of the feature
	 * @param modelElement the modelElement where this feature is contained
	 * @return the EStructuralFeature of the feature of the ModelElement.
	 */
	protected EStructuralFeature getFeature(String featureName, UnicaseModelElement modelElement) {
		for (EStructuralFeature feature : modelElement.eClass().getEAllStructuralFeatures()) {
			if (feature.getName().equals(featureName)) {
				return feature;
			}
		}

		return null;
	}

	protected String getText(EObject eObject) {
		return adapterFactoryItemDelegator.getText(eObject);
	}
	// end custom code

} // ModelElementRendererImpl
