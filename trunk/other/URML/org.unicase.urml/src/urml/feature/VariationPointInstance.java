/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variation Point Instance</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}</li>
 *   <li>{@link urml.feature.VariationPointInstance#getProduct <em>Product</em>}</li>
 *   <li>{@link urml.feature.VariationPointInstance#getSelectedFeatures <em>Selected Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.feature.FeaturePackage#getVariationPointInstance()
 * @model
 * @generated
 */
public interface VariationPointInstance extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Variation Point</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link urml.feature.VariationPoint#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation Point</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Point</em>' reference.
	 * @see #setVariationPoint(VariationPoint)
	 * @see urml.feature.FeaturePackage#getVariationPointInstance_VariationPoint()
	 * @see urml.feature.VariationPoint#getInstances
	 * @model opposite="instances" keys="identifier"
	 * @generated
	 */
	VariationPoint getVariationPoint();

	/**
	 * Sets the value of the '{@link urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variation Point</em>' reference.
	 * @see #getVariationPoint()
	 * @generated
	 */
	void setVariationPoint(VariationPoint value);

	/**
	 * Returns the value of the '<em><b>Product</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link urml.feature.Product#getVariationPointInstances <em>Variation Point Instances</em>}'.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' reference.
	 * @see #setProduct(Product)
	 * @see urml.feature.FeaturePackage#getVariationPointInstance_Product()
	 * @see urml.feature.Product#getVariationPointInstances
	 * @model opposite="variationPointInstances" keys="identifier"
	 * @generated
	 */
	Product getProduct();

	/**
	 * Sets the value of the '{@link urml.feature.VariationPointInstance#getProduct <em>Product</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Product</em>' reference.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(Product value);

	/**
	 * Returns the value of the '<em><b>Selected Features</b></em>' reference list. The list contents are of type
	 * {@link urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link urml.feature.AbstractFeature#getVariationPointInstances <em>Variation Point Instances</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Selected Features</em>' reference list.
	 * @see urml.feature.FeaturePackage#getVariationPointInstance_SelectedFeatures()
	 * @see urml.feature.AbstractFeature#getVariationPointInstances
	 * @model opposite="variationPointInstances" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getSelectedFeatures();

} // VariationPointInstance
