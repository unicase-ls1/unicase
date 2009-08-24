package org.unicase.ui.iterationplanner.paper.machinelearning;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.ujmp.core.stringmatrix.stub.AbstractDenseStringMatrix2D;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;

public class ModelElementMatrix extends AbstractDenseStringMatrix2D {

	
	private static final String MANY_VALUED_ATTRIBUTE_DELIMITER = ",";
	private List<EStructuralFeature> features;
	private List<ModelElement> inputMEs;

	public ModelElementMatrix(List<ModelElement> inputMEs,
			List<EStructuralFeature> outputFeatures) {
		this.inputMEs = inputMEs;
		this.features = outputFeatures;
	}

	public void setFeatures(List<EStructuralFeature> features) {
		this.features = features;
	}

	public List<EStructuralFeature> getFeatures() {
		return features;
	}

	public String getString(long row, long column) {
		String result= "";
		ModelElement me = inputMEs.get((int) row);
		EStructuralFeature feature = features.get((int)column);
		if(feature instanceof EReference){
		result = getText(me, (EReference)feature);	
		}else if(feature instanceof EAttribute){
			result = getText(me, (EAttribute)feature);
		}
		return result;
	}

	public void setString(String value, long row, long column) {

	}

	public long[] getSize() {
	
		return new long[] { inputMEs.size(), features.size() };
		
	}

	public void setInputMEs(List<ModelElement> inputMEs) {
		this.inputMEs = inputMEs;
	}

	public List<ModelElement> getInputMEs() {
		return inputMEs;
	}

	/**
	 * @param wi
	 * @param feature
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getText(ModelElement wi, EReference feature) {
		StringBuilder sb = new StringBuilder("");
		String result = "";
		Object value = wi.eGet(feature);
		if (value == null) {
			return result;
		}

		if (feature.isMany()) {
			List<EObject> list = (List<EObject>) value;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof ModelElement) {
					sb.append(((ModelElement) list.get(i)).getName());
				} else {
					sb.append("");
				}

				if (i != list.size() - 1) {
					sb.append(MANY_VALUED_ATTRIBUTE_DELIMITER);
				}
			}
			result = removeLineBreaks(sb.toString());
			return result;
		} else {
			if (value instanceof ModelElement) {
				sb.append(((ModelElement) value).getName());
			} else {
				sb.append("");
			}

			result = removeLineBreaks(sb.toString());
			return result;
		}

	}

	/**
	 * @param wi
	 * @param attr
	 * @return
	 */
	private String getText(ModelElement wi, EAttribute attr) {
		String result = "";
		Object obj = wi.eGet(attr);
		if (obj != null && !attr.isMany()) {
			result = removeLineBreaks(obj.toString());

		}

		return result;
	}
	
	
	/**
	 * @param string
	 */
	private String removeLineBreaks(String string) {
		string = string.replace("\n", " ");
		string = string.replace("\r", "");
		string = string.replace(";, %BEGINNTEXT%", "");
		string = string.replace(",", " ");
		return string;

	}

}
