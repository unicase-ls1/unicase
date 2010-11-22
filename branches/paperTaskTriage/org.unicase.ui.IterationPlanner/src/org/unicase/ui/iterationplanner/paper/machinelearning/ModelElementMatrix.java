package org.unicase.ui.iterationplanner.paper.machinelearning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.ujmp.core.enums.FileFormat;
import org.ujmp.core.exceptions.MatrixException;
import org.ujmp.core.stringmatrix.stub.AbstractDenseStringMatrix2D;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.iterationplanner.Activator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ModelElementMatrix extends AbstractDenseStringMatrix2D {

	private static final String MANY_VALUED_ATTRIBUTE_DELIMITER = ",";
	private List<EStructuralFeature> features;
	private List<UnicaseModelElement> modelElements;

	public ModelElementMatrix(List<UnicaseModelElement> modelElements, List<EStructuralFeature> outputFeatures) {
		this.modelElements = modelElements;
		this.features = outputFeatures;
	}

	public void setFeatures(List<EStructuralFeature> features) {
		this.features = features;
	}

	public List<EStructuralFeature> getFeatures() {
		return features;
	}

	public String getString(long row, long column) {
		String result = "";
		UnicaseModelElement me = modelElements.get((int) row);
		EStructuralFeature feature = features.get((int) column);
		if (feature instanceof EReference) {
			result = getText(me, (EReference) feature);
		} else if (feature instanceof EAttribute) {
			result = getText(me, (EAttribute) feature);
		}
		return result;
	}


	public void setString(String value, long row, long column) {

	}

	public long[] getSize() {

		return new long[] { modelElements.size(), features.size() };

	}

	public void setInputMEs(List<UnicaseModelElement> inputMEs) {
		this.modelElements = inputMEs;
	}

	public List<UnicaseModelElement> getInputMEs() {
		return modelElements;
	}

	/**
	 * @param wi
	 * @param feature
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getText(UnicaseModelElement wi, EReference feature) {
		StringBuilder sb = new StringBuilder("");
		String result = "";
		Object value = wi.eGet(feature);
		if (value == null) {
			return result;
		}

		if (feature.isMany()) {
			List<EObject> list = (List<EObject>) value;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof UnicaseModelElement) {
					sb.append(((UnicaseModelElement) list.get(i)).getName());
				} else {
					sb.append("");
				}

				if (i != list.size() - 1) {
					sb.append(MANY_VALUED_ATTRIBUTE_DELIMITER);
				}
			}
			result = removeSpecialCharacters(sb.toString());
			return result;
		} else {
			if (value instanceof UnicaseModelElement) {
				sb.append(((UnicaseModelElement) value).getName());
			} else {
				sb.append("");
			}

			result = removeSpecialCharacters(sb.toString());
			return result;
		}

	}

	/**
	 * @param wi
	 * @param attr
	 * @return
	 */
	private String getText(UnicaseModelElement wi, EAttribute attr) {
		String result = "";
		Object obj = wi.eGet(attr);
		if (obj != null && !attr.isMany()) {
			result = removeSpecialCharacters(obj.toString());

		}

		return result;
	}

	/**
	 * @param string
	 */
	private String removeSpecialCharacters(String string) {
		string = string.replace("\t", "");
		string = string.replace("\n", " ");
		string = string.replace("\r", "");
		string = string.replace(";, %BEGINNTEXT%", "");
		string = string.replace(",", " ");
		return string;

	}

	public List<UnicaseModelElement> getModelElements() {

		return modelElements;
	}
	
	public void exportToCSV(String fileName){
		String path = Activator.getDefault().getBundle().getLocation().replace("reference:file:", "") + "/datasets/" + fileName;
		File file = new File(path);
		try {
			this.exportToFile(FileFormat.CSV, file, null);
		} catch (MatrixException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
