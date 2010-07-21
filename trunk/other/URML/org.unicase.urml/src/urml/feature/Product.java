/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Product</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.feature.Product#getVariationPointInstances <em>Variation Point Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.feature.FeaturePackage#getProduct()
 * @model
 * @generated
 */
public interface Product extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Variation Point Instances</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.VariationPointInstance}.
	 * It is bidirectional and its opposite is '{@link urml.feature.VariationPointInstance#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation Point Instances</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Point Instances</em>' reference list.
	 * @see urml.feature.FeaturePackage#getProduct_VariationPointInstances()
	 * @see urml.feature.VariationPointInstance#getProduct
	 * @model opposite="product" keys="identifier"
	 * @generated
	 */
	EList<VariationPointInstance> getVariationPointInstances();

} // Product
