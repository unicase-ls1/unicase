package org.unicase.projectgenerator2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class ProjectGeneratorImpl implements IProjectGenerator {
	EPackage rootPackage;
	long seed;
	long noOfExampleValues;
	long hierarchyDepth;
	EObject rootObject;
	
	
	public EObject getRootObject() {
		return rootObject;
	}
	
	public void setRoot(EObject root) {
		rootObject = root;
	}

	protected ProjectGeneratorImpl(EPackage rootPackage, long seed, long noOfExampleValues, long hierachyDepth) {
		this.rootPackage = rootPackage;
		this.seed = seed;
		this.noOfExampleValues = noOfExampleValues;
		this.hierarchyDepth = hierachyDepth;
		rootObject = ProjectGeneratorUtil.createRoot();
	}
	
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getRootPackage()
	 */
	public EPackage getRootPackage() {
		return rootPackage;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setRootPackage(org.eclipse.emf.ecore.EPackage)
	 */
	public void setRootPackage(EPackage rootPackage) {
		this.rootPackage = rootPackage;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getSeed()
	 */
	public long getSeed() {
		return seed;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setSeed(long)
	 */
	public void setSeed(long seed) {
		this.seed = seed;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getNoOfExampleValues()
	 */
	public long getNoOfExampleValues() {
		return noOfExampleValues;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setNoOfExampleValues(long)
	 */
	public void setNoOfExampleValues(long noOfExampleValues) {
		this.noOfExampleValues = noOfExampleValues;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getHierachyDepth()
	 */
	public long getHierachyDepth() {
		return hierarchyDepth;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setHierachyDepth(long)
	 */
	public void setHierachyDepth(long hierachyDepth) {
		this.hierarchyDepth = hierachyDepth;
	}
	
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#generateValues()
	 */
	public void generateValues() {
		generateChildren(rootObject, 0);
	}
	
	private void generateChildren(EObject parent, long currentDepth) {
		if(parent.eClass() == null) {
			return;
		}
		List<EClass> elementsToCreate = new ArrayList<EClass>(ProjectGeneratorUtil.getAllEContainments(parent.eClass()));
		if(currentDepth < hierarchyDepth) {
			for(int i = 0; i < noOfExampleValues && elementsToCreate.size() > i; i++) {
				EClass currentChildClass = elementsToCreate.get(i);
				if(currentChildClass.isInterface() || currentChildClass.isAbstract()) {
					elementsToCreate.remove(i);
					i--;
					continue;
				}
				EObject newObject = currentChildClass.getEPackage().getEFactoryInstance().create(currentChildClass);
				setEObjectAttributes(newObject);
				EReference reference = ProjectGeneratorUtil.getPossibleContainingReference(newObject, parent);
				if(parent.eGet(reference) instanceof List) {
					((List<EObject>) parent.eGet(reference)).add(newObject);
				}
				else {
					parent.eSet(reference, newObject);
				}
				generateChildren(newObject, (currentDepth+1));
			}
		}
	}

	private void setEObjectAttributes(EObject newObject) {
		for(EAttribute attribute : ProjectGeneratorUtil.getEAttributes(newObject.eClass())) {
			EClassifier attributeType = attribute.getEType();
			EcorePackage ecoreInstance = EcorePackage.eINSTANCE;	
			if(!attribute.isChangeable())
				continue;
			if(attributeType.getInstanceTypeName().equals(ecoreInstance.getEString().getInstanceTypeName())) {
				newObject.eSet(attribute, "Generated");
			} else if (attributeType == ecoreInstance.getEBoolean()) {
				newObject.eSet(attribute, true);
			} else if (attributeType ==ecoreInstance.getEBigInteger()) {
				newObject.eSet(attribute, new BigInteger("7"));
			} else if (attributeType == ecoreInstance.getEChar()) {
				newObject.eSet(attribute, 'a');
			} else if (attributeType == ecoreInstance.getEInt() || attributeType == ecoreInstance.getEIntegerObject()) {
				newObject.eSet(attribute, 7);
			}
		}
	}
}
