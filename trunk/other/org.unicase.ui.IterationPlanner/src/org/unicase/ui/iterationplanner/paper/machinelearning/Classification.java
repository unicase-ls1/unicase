package org.unicase.ui.iterationplanner.paper.machinelearning;

import org.jdmp.core.algorithm.classification.Classifier;
import org.jdmp.core.dataset.ClassificationDataSet;
import org.jdmp.core.dataset.CrossValidation;
import org.jdmp.core.dataset.DataSetFactory;
import org.jdmp.liblinear.LibLinearClassifier;
import org.ujmp.core.Matrix;
import org.ujmp.core.MatrixFactory;
import org.ujmp.core.calculation.Calculation.Ret;
import org.ujmp.mtj.MTJDenseDoubleMatrix2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classification {

	private Matrix m;

	public static final String PATH = System.getProperty("user.home") + "/";

	public static final String FILENAME = "workitems-1.csv";

	public static final boolean USESTEMMING = false;

	public static final boolean CALCULATETF = true;

	public static final boolean CALCULATEIDF = true;

	public static final boolean USESVD = false;

	public static final boolean PRUNEMATRIX = false;

	public static final double MINVARIANCE = 0.0001;

	public static final boolean USENAME = true;

	public static final boolean USEDESCRIPTION = true;

	public static final boolean USEANNOTATED = true;

	public static final int CVRUNS = 10;

	public static final int CVFOLDS = 10;

	public static final long SEED = System.currentTimeMillis();

	public static final String[] ENGLISH_STOP_WORDS1 = { "a", "an", "and", "are", "as", "at", "be", "but", "by", "for",
		"if", "in", "into", "is", "it", "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there",
		"these", "they", "this", "to", "was", "will", "with" };

	public static final String[] ENGLISH_STOP_WORDS2 = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "000", "$",
		"about", "after", "all", "also", "an", "and", "another", "any", "are", "as", "at", "be", "because", "been",
		"before", "being", "between", "both", "but", "by", "came", "can", "come", "could", "did", "do", "does", "each",
		"else", "for", "from", "get", "got", "has", "had", "he", "have", "her", "here", "him", "himself", "his", "how",
		"if", "in", "into", "is", "it", "its", "just", "like", "make", "many", "me", "might", "more", "most", "much",
		"must", "my", "never", "now", "of", "on", "only", "or", "other", "our", "out", "over", "re", "said", "same",
		"see", "should", "since", "so", "some", "still", "such", "take", "than", "that", "the", "their", "them",
		"then", "there", "these", "they", "this", "those", "through", "to", "too", "under", "up", "use", "very",
		"want", "was", "way", "we", "well", "were", "what", "when", "where", "which", "while", "who", "will", "with",
		"would", "you", "your", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
		"r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static final String[] ENGLISH_STOP_WORDS = ENGLISH_STOP_WORDS2;

	private static final long NAME_INDEX = 0;
	private static final long DESCRIPTION_INDEX = 1;
	private static final long ANNOTATED_MES_INDEX = 2;
	private static final long ASSIGNEE_INDEX = 5;

	
	public Classification(Matrix m) {
		this.m = m;
	}

	public void printStats(Matrix m) throws Exception {
		// some stats
		System.out.println(m.getRowCount() + " records");
		Matrix assignees = m.selectColumns(Ret.LINK, 5).unique(Ret.NEW);
		System.out.println(assignees.getRowCount() + " different assignees:");
		System.out.println(assignees.sort(Ret.NEW));
	}

	public void run() throws Exception {

		System.out.println("preprocessing data...");

		// delete all records with unknown assignee
		List<Long> rowsToDelete = new ArrayList<Long>();
		for (long row = 0; row < m.getRowCount(); row++) {
			String assignee = m.getAsString(row, ASSIGNEE_INDEX);
			if (assignee == null || assignee.length() == 0) {
				rowsToDelete.add(row);
			}
		}

		// delete
		m = m.deleteRows(Ret.NEW, rowsToDelete);

		// some stats
		// printStats(m);

		// filter out unwanted characters
		m = m.removePunctuation(Ret.NEW);

		// use only lowercase characters
		m = m.lowerCase(Ret.NEW);

		// remove stopwords
		m = m.removeWords(Ret.NEW, Arrays.asList(ENGLISH_STOP_WORDS));

		// create features for assignee
		Matrix assignee = m.selectColumns(Ret.LINK, ASSIGNEE_INDEX).tfIdf(false, false, false);
		assignee.setLabel("assignee");

		// use PorterStemmer on the data
		if (USESTEMMING) {
			System.out.println("stemming data...");
			m = m.stem(Ret.NEW);
		}

		System.out.println("creating features...");

		// create features for name
		Matrix name = m.selectColumns(Ret.LINK, NAME_INDEX).tfIdf(CALCULATETF, CALCULATEIDF, false);
		name.setLabel("name");

		// create features for description
		Matrix description = m.selectColumns(Ret.LINK, DESCRIPTION_INDEX).tfIdf(CALCULATETF, CALCULATEIDF, false);
		description.setLabel("description");

		// create features for annotated
		Matrix annotated = m.selectColumns(Ret.LINK, ANNOTATED_MES_INDEX).tfIdf(CALCULATETF, CALCULATEIDF, false);
		annotated.setLabel("annotated");

		// create feature vector for training
		Matrix input = MatrixFactory.sparse(name.getRowCount(), 0);
		if (USENAME) {
			input = input.appendHorizontally(name);
		}
		if (USEDESCRIPTION) {
			input = input.appendHorizontally(description);
		}
		if (USEANNOTATED) {
			input = input.appendHorizontally(annotated);
		}

		// apply SVD
		if (USESVD) {
			System.out.println("calculating SVD...");
			input = new MTJDenseDoubleMatrix2D(input).princomp();
		}

		//input.showGUI();

		// delete columns with variance < MINVARIANCE
		if (PRUNEMATRIX) {
			List<Long> columnsToDelete = new ArrayList<Long>();
			Matrix var = input.var(Ret.NEW, Matrix.ROW, true);
			for (long i = 0; i < input.getColumnCount(); i++) {
				if (var.getAsDouble(0, i) < MINVARIANCE) {
					columnsToDelete.add(i);
				}
			}
			input = input.deleteColumns(Ret.NEW, columnsToDelete);
		}

		System.out.println("building dataset...");

		// create the dataset
		ClassificationDataSet ds = DataSetFactory.importFromMatrix(input, assignee);

		System.out.println("training classifier...");

		Classifier classifier = new LibLinearClassifier();

		// test classifier on the whole data set
		classifier.train(ds);
		classifier.predict(ds);
		ds.showGUI();

		// // 10 times 10 fold cross-validation
		CrossValidation.run(classifier, ds, CVFOLDS, CVRUNS, SEED);
		System.out.println("SEED: " + SEED);
		System.out.println("CVFOLDS: " + CVFOLDS);
		System.out.println("CVRUNS: " + CVRUNS);
		System.out.println("FILENAME: " + FILENAME);
		System.out.println("USENAME: " + USENAME);
		System.out.println("USEDESCRIPTION: " + USEDESCRIPTION);
		System.out.println("USEANNOTATED: " + USEANNOTATED);
		System.out.println("USESTEMMING: " + USESTEMMING);
		System.out.println("USESVD: " + USESVD);
		System.out.println("PRUNESVD: " + PRUNEMATRIX);
		System.out.println("MINVARIANCE: " + MINVARIANCE);
	}
}
