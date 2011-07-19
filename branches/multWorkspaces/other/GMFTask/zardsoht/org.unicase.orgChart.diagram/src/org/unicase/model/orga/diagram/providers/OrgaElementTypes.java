package org.unicase.model.orga.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.orga.OrgaPackage;
import org.unicase.model.orga.diagram.edit.parts.EmployeeEditPart;
import org.unicase.model.orga.diagram.edit.parts.OrgDiagramEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamEditPart;
import org.unicase.model.orga.diagram.edit.parts.TeamHasOrgUnitEditPart;
import org.unicase.model.orga.diagram.part.OrgaDiagramEditorPlugin;

/**
 * @generated
 */
public class OrgaElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private OrgaElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType OrgDiagram_1000 = getElementType("org.unicase.orgChart.diagram.OrgDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Employee_2001 = getElementType("org.unicase.orgChart.diagram.Employee_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Team_2002 = getElementType("org.unicase.orgChart.diagram.Team_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TeamHasOrgUnit_4001 = getElementType("org.unicase.orgChart.diagram.TeamHasOrgUnit_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return OrgaDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements
					.put(OrgDiagram_1000, OrgaPackage.eINSTANCE.getOrgDiagram());

			elements.put(Employee_2001, OrgaPackage.eINSTANCE.getEmployee());

			elements.put(Team_2002, OrgaPackage.eINSTANCE.getTeam());

			elements.put(TeamHasOrgUnit_4001, OrgaPackage.eINSTANCE
					.getTeam_HasOrgUnit());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(OrgDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Employee_2001);
			KNOWN_ELEMENT_TYPES.add(Team_2002);
			KNOWN_ELEMENT_TYPES.add(TeamHasOrgUnit_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case OrgDiagramEditPart.VISUAL_ID:
			return OrgDiagram_1000;
		case EmployeeEditPart.VISUAL_ID:
			return Employee_2001;
		case TeamEditPart.VISUAL_ID:
			return Team_2002;
		case TeamHasOrgUnitEditPart.VISUAL_ID:
			return TeamHasOrgUnit_4001;
		}
		return null;
	}

}
