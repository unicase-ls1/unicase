/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.Activator;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BooleanStyle;
import org.unicase.docExport.exportModel.renderers.options.DateAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.DateStyle;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.ListStyle;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Default Attribute Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class DefaultAttributeRendererImpl extends AttributeRendererImpl implements DefaultAttributeRenderer {

	private LayoutOptions layoutOptions;
	private Template template;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DefaultAttributeRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DefaultRenderersPackage.Literals.DEFAULT_ATTRIBUTE_RENDERER;
	}

	// begin custom code
	/**
	 * renders an attribute (feature) of a modelElement and adds it to the USection parent of the modelELement. The
	 * rendering strongly depends on the type of the attribute: EAttribute, single EReference and multi EReference.
	 */
	public void render(EStructuralFeature feature, UnicaseModelElement modelElement, UCompositeSection parent,
		Template template) {
		this.layoutOptions = template.getLayoutOptions();
		this.template = template;

		if (getAttributeOption().isHide()) {
			return;
		}

		if (feature.isMany()) {
			renderMultiFeature(feature, modelElement, parent);
		} else {
			renderSingleFeature(feature, modelElement, parent);
		}

	}

	private void renderSingleFeature(EStructuralFeature feature, UnicaseModelElement modelElement,
		UCompositeSection parent) {
		Object content = modelElement.eGet(feature);
		if (feature.eClass().getInstanceClass().equals(EAttribute.class)) {
			if (content != null) {
				renderSimpleAttribute(content, parent, feature);
			}
		} else { // EReference
			if (content != null) {
				if (((SingleReferenceAttributeOption) getAttributeOption()).isContained()) {
					renderContainedReference((UnicaseModelElement) content, parent, feature);
					DocumentExport.addRenderedModelElement((UnicaseModelElement) content);
				} else {
					TemplateRegistry.setMeCount(TemplateRegistry.getMeCount());
					renderLinkedReference((UnicaseModelElement) content, parent, feature);
				}
			}
		}
	}

	private void renderSimpleAttribute(Object content, UCompositeSection parent, EStructuralFeature feature) {

		if (getAttributeOption() instanceof BooleanAttributeOption) {
			renderBooleanFeature(parent, feature, content);
		} else if (getAttributeOption() instanceof DateAttributeOption) {
			renderDateFeature(parent, feature, content);
		} else {
			// StringAttributeOption
			UParagraph name = new UParagraph(content.toString(), template.getLayoutOptions().getDefaultTextOption());
			parent.add(name);
		}

	}

	private void renderBooleanFeature(UCompositeSection parent, EStructuralFeature feature, Object content) {
		BooleanAttributeOption option = (BooleanAttributeOption) getAttributeOption();
		Boolean booleanContent = (Boolean) content;

		if (option.getBooleanStyle().equals(BooleanStyle.IMAGE)) {
			try {
				URL templateImageFolder = FileLocator.find(Activator.getDefault().getBundle(), new Path(
					TemplateRegistry.DOCEXPORT_IMAGES + File.separatorChar), Collections.EMPTY_MAP);

				String fileName = "";

				if (content.toString().equals("true")) {
					fileName = "true.svg";
				} else {
					fileName = "false.svg";
				}

				File imageFile = new File(FileLocator.resolve(templateImageFolder).getPath() + fileName);

				UImage booleanImage = new UImage(new Path(imageFile.getAbsolutePath()));
				booleanImage.setWidth(template.getLayoutOptions().getDefaultTextOption().getFontSize());
				booleanImage.setHeight(template.getLayoutOptions().getDefaultTextOption().getFontSize());
				parent.add(booleanImage);
			} catch (IOException e) {
				// fall through: If the image can't be accessed, it just won't be rendered.
			}
		} else if (option.getBooleanStyle().equals(BooleanStyle.NUMBERS)) {
			String text;
			if (booleanContent) {
				text = "1";
			} else {
				text = "0";
			}
			UParagraph number = new UParagraph(text, template.getLayoutOptions().getDefaultTextOption());
			parent.add(number);
		} else if (option.getBooleanStyle().equals(BooleanStyle.TRUE_FALSE)) {
			String text;
			if (booleanContent) {
				text = "true";
			} else {
				text = "false";
			}
			UParagraph number = new UParagraph(text, template.getLayoutOptions().getDefaultTextOption());
			parent.add(number);
		} else if (option.getBooleanStyle().equals(BooleanStyle.YES_NO)) {
			String text;
			if (booleanContent) {
				text = "yes";
			} else {
				text = "no";
			}
			UParagraph number = new UParagraph(text, template.getLayoutOptions().getDefaultTextOption());
			parent.add(number);
		} else {
			WorkspaceUtil.log("unimplemented Boolean Style: " + option.getBooleanStyle(), new Exception(),
				IStatus.WARNING);
		}
	}

	private void renderDateFeature(UCompositeSection parent, EStructuralFeature feature, Object content) {
		DateAttributeOption option = (DateAttributeOption) getAttributeOption();
		Date date = (Date) content;

		UParagraph par = new UParagraph("", template.getLayoutOptions().getDefaultTextOption());
		parent.add(par);
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);

		if (option.getDateStyle().equals(DateStyle.FULL)) {
			par.setText(date.toString());
		} else if (option.getDateStyle().equals(DateStyle.NUMERIC_TIME_WITH_SECONDS)) {
			par.setText(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
		} else if (option.getDateStyle().equals(DateStyle.NUMERIC_TIME)) {
			par.setText(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
		} else if (option.getDateStyle().equals(DateStyle.NUMERIC_DAY)) {
			par.setText(cal.get(Calendar.DATE) + " " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
		} else if (option.getDateStyle().equals(DateStyle.NUMERIC_MONTH)) {
			par.setText(cal.get(Calendar.DATE) + "." + (cal.get(Calendar.MONTH) + 1) + " " + cal.get(Calendar.HOUR)
				+ ":" + cal.get(Calendar.MINUTE));
		} else if (option.getDateStyle().equals(DateStyle.NUMERIC_YEAR)) {
			par.setText(cal.get(Calendar.DATE) + "." + (cal.get(Calendar.MONTH) + 1) + "." + cal.get(Calendar.YEAR)
				+ " " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
		} else if (option.getDateStyle().equals(DateStyle.NICE1)) {
			// TODO create string of day and month instead of integer
			par.setText(cal.get(Calendar.DATE) + "." + (cal.get(Calendar.MONTH) + 1) + "." + cal.get(Calendar.YEAR)
				+ " " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE));
		}
	}

	private void renderLinkedReference(UnicaseModelElement content, UCompositeSection parent, EStructuralFeature feature) {
		String text = "" + feature.getName() + ": " + content.getName();

		if (getAttributeOption() instanceof MultiReferenceAttributeOption) {
			MultiReferenceAttributeOption option2 = (MultiReferenceAttributeOption) getAttributeOption();
			ListOption listOption = option2.getListOption();

			if (listOption.getListStyle() == ListStyle.BULLETED) {
				text = "- " + content.getName();
			} else if (listOption.getListStyle() == ListStyle.SEPERATED_LIST) {
				text = content.getName() + ", ";
			} else if (listOption.getListStyle() == ListStyle.JUST_NEW_LINES) {
				// nothing?!
			}
		}

		UParagraph name = new UParagraph(text, layoutOptions.getDefaultTextOption());
		name.setIndentionLeft(1);
		parent.add(name);

	}

	private void renderContainedReference(UnicaseModelElement content, UCompositeSection attributeSection,
		EStructuralFeature feature) {
		ModelElementRenderer renderer = getModelElementRenderer(content.eClass());
		try {
			renderer.render(content, attributeSection);
		} catch (RuntimeException e) {
			WorkspaceUtil.log("Error in the renderer " + renderer.getClass().getSimpleName(), e, IStatus.ERROR);
		}

	}

	private ModelElementRenderer getModelElementRenderer(EClass eClass) {
		return template.getModelElementRendererNotNull(eClass, template);
	}

	private ReferenceOption getRefenceOption(AttributeOption option) {
		if (option instanceof MultiReferenceAttributeOption) {
			return ((MultiReferenceAttributeOption) option).getReferenceOption();
		} else if (option instanceof SingleReferenceAttributeOption) {
			return ((SingleReferenceAttributeOption) option).getReferenceOption();
		}
		return OptionsFactory.eINSTANCE.createReferenceOption();
	}

	/**
	 * renders an attribute with can have more than one reference to a modelElement.
	 */
	@SuppressWarnings("unchecked")
	private void renderMultiFeature(EStructuralFeature feature, UnicaseModelElement modelElement,
		UCompositeSection parent) {

		MultiReferenceAttributeOption option = (MultiReferenceAttributeOption) getAttributeOption();
		ListOption listOption = option.getListOption();

		ReferenceOption refOption = getRefenceOption(getAttributeOption());

		Object attributeValue = modelElement.eGet(feature);

		if (attributeValue instanceof EList) {
			EList<UnicaseModelElement> objectList = (EList<UnicaseModelElement>) attributeValue;

			if (((ReferenceAttributeOption) getAttributeOption()).isContained()) {
				for (UnicaseModelElement me : objectList) {
					renderContainedReference(me, parent, feature);
				}
			} else {
				renderList(parent, objectList, feature, listOption, refOption);
			}
		}
	}

	private void renderList(UCompositeSection parent, EList<UnicaseModelElement> objectList,
		EStructuralFeature feature, ListOption listOpion, ReferenceOption refOption) {

		UList list = new UList(listOpion, template.getLayoutOptions().getSectionTextOption());
		list.setIndentionLeft(1);

		for (UnicaseModelElement me : objectList) {
			list.add(me.getName());
		}

		UParagraph head = new UParagraph(feature.getName(), template.getLayoutOptions().getSectionTextOption());
		head.setIndentionLeft(1);

		if (objectList.size() > 0) {
			parent.add(head);
			parent.add(list);
		}
	}

} // DefaultAttributeRendererImpl
