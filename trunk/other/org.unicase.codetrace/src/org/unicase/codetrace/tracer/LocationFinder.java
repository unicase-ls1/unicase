/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.codetrace.tracer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.unicase.codetrace.CodetraceUtil;
import org.unicase.codetrace.tracer.algorithms.Algorithm;
import org.unicase.codetrace.tracer.algorithms.AlgorithmBestMatch;
import org.unicase.codetrace.tracer.algorithms.AlgorithmLineContext;
import org.unicase.model.trace.CodeLocation;
import org.unicase.model.trace.TraceFactory;
import java.io.File;


/**
 * This is the main facade class to create source locations and to find
 * source locations.
 * This is a singleton class, use .getInstance() to retrieve the singleton object.
 * @author jfinis
 * @author kterzieva
 * @author snogina
 */
public final class LocationFinder {

	private static LocationFinder theInstance;
	private double thresholdValue;
	private Map<Algorithm, Double> featureSet = new HashMap<Algorithm, Double>();
	private static FoundLocation location;
	private static CodeLocation codeLocation;

	
	private LocationFinder() {
	}

	/**
	 * Returns the singleton object.
	 * @return the singleton object
	 */
	public static LocationFinder getInstance() {
		if (theInstance == null) {
			theInstance = new LocationFinder();
			theInstance.addAlgorithm(new AlgorithmLineContext(4, 0.35, false),
					0.4);
			theInstance.addAlgorithm(new AlgorithmBestMatch(1, 0.5, true), 0.6);
		}
		return theInstance;
	}

	private void addAlgorithm(Algorithm a, double v) {
		featureSet.put(a, v);
	}

	/**
	 * This method search recursive in all contained files for a java source files. 
	 */
	private FoundLocation getContainedFile(File rootFile){		
			File[] containedFiles = rootFile.listFiles();
		
			for(int i = 0; i < containedFiles.length; i++){
				if(!containedFiles[i].isDirectory()){
					if(containedFiles[i].getName().endsWith(".java")){
						String path = containedFiles[i].getPath();
						TracerFile tf = TracerFile.getFileByName(path);						
						IPath filePath = new Path(path);
						location = find(codeLocation.getProjectName(), path, tf, filePath);

						if(location != null){
							return location;
						}
					}
				}
				else{

					location = getContainedFile(containedFiles[i]);
					if(location != null){
						return location;
					}
				}
			}
			
		return null;
	}

	/**
	 * Creates a trackable source location.
	 * @param projectName The name of the project in which the source file which contains the location is
	 * @param pathInProject The path of the file which contains the source location, relative to the project root.
	 * @param line The line number of the source location
	 * @return the code location or null if the handed line or file path was invalid.
	 */
	public CodeLocation createLocation(String projectName,
			String pathInProject, int line) {
		if (projectName == null || pathInProject == null || line < 0) {
			return null;
		}
		TracerFile lf = TracerFile.getFileByName(CodetraceUtil
				.getPathOfFile(projectName, pathInProject));
		if (lf == null) {
			return null;
		}
		CodeLocation out = TraceFactory.eINSTANCE.createCodeLocation();
		out.setPathInProject(pathInProject);
		out.setProjectName(projectName);
		for (Map.Entry<Algorithm, Double> ent : featureSet.entrySet()) {
			Algorithm alg = ent.getKey();
			TracerFacet f = alg.createFacet(lf, line);
			f.addToCodeLocation(out);
		}

		return out;
	}

	/**
	 * Tries to find a previously code location. If it cannot be found, the function returns null.
	 * @param c the code location to find
	 * @return the found code location or null if the location couldn't be found.
	 */
	public synchronized FoundLocation find(CodeLocation c) {
		codeLocation = c;
		
		//search in the previous source file
		TracerFile tf = TracerFile.getFileByName(CodetraceUtil.getPathOfFile(codeLocation.getProjectName(),codeLocation.getPathInProject()));

		location = find(codeLocation.getProjectName(), codeLocation.getPathInProject(), tf, null);
		
		//if no code location found, search in the same project in the other files
		if ( location == null){
			//search in the project for changed file
		
			location = searchInProject(codeLocation.getProjectName());
		
		} 
		//if no location in the previously project found, search in the whole workspace in the other projects
		if (location == null){
			IWorkspace root = ResourcesPlugin.getWorkspace();
		    IProject[] projects = root.getRoot().getProjects();

		    for(IProject project: projects){
		    	String projectName = project.getName();
		    	if(!projectName.equals(codeLocation.getProjectName())){
				location = searchInProject(projectName);
					if(location != null){
					return location;
					}
		    	}
		    }
		}
	return location;	
	}
	
	private FoundLocation searchInProject(String projectName){
		IWorkspace root = ResourcesPlugin.getWorkspace();
		IProject eclipseProject = root.getRoot().getProject(projectName);
		IPath projectPath = eclipseProject.getLocation();
		File rootFile = new File(projectPath.toOSString());
		location = getContainedFile(rootFile);
		return location;
	}
	
	/**
	 * 
	 * @param projectName
	 * @param pathInProject
	 * @param tf
	 * @param filePath
	 * @return
	 */
	// BEGIN COMPLEX CODE
	private FoundLocation find(String projectName, String pathInProject, TracerFile tf, IPath filePath){	
				
		//Build facet map
		Map<TracerFacet,Double> facets = new LinkedHashMap<TracerFacet,Double>();
		for (Entry<Algorithm, Double> ent : featureSet.entrySet()) {
			double vx = ent.getValue();
			if (vx == 0) {
				continue;
			}
			Algorithm a = ent.getKey();
			TracerFacet facet = a.createFacetFromCodeLocation(codeLocation);
			facets.put(facet, vx);
		
		}
		Map<Integer, Double> values = new LinkedHashMap<Integer, Double>();

		for (Entry<TracerFacet,Double> ent : facets.entrySet()) {
			
			Map<Integer, Double> fvs = ent.getKey().getLines(tf);
			if (fvs != null) {
				// normalize(fvs);
				for (Map.Entry<Integer, Double> e1 : fvs.entrySet()) {
					double v0 = ent.getValue();
					double v1 = e1.getValue();
					if (v0 < 0) {
						v0 = -v0;
					}
					v0 *= v1;
					Double v = values.get(e1.getKey());
					if (v != null) {
						v0 += v;
					}
					if (v0 > 0) {
						values.put(e1.getKey(), v0);
					}
				}
			}
		}

		for (Map.Entry<TracerFacet, Double> ent : facets.entrySet()) {
			double vx = ent.getValue();
			if (vx > 0) {
				continue;
			}
			Map<Integer, Double> fvs = ent.getKey().getLines(tf);
			for (Iterator<Map.Entry<Integer, Double>> it = values.entrySet()
					.iterator(); it.hasNext();) {
				Map.Entry<Integer, Double> e1 = it.next();
				int ln = e1.getKey();
				if (!fvs.containsKey(ln) || fvs.get(ln).doubleValue() == 0) {
					it.remove();
				}
			}
		}

		if (values.isEmpty()) {
			return null;
		}

		// normalize(values);

		double bestv = -1;
		int bestln = -1;
		for (Map.Entry<Integer, Double> ent : values.entrySet()) {
			if (ent.getValue() > bestv) {
				bestv = ent.getValue();
				bestln = ent.getKey();
			}
		}

		if (bestln < 0) {
			return null;
		}
		if (bestv < thresholdValue) {
			return null;
		}
		IFile f = null;
		if(filePath != null){
			f = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(filePath);
		}
		else{
			f = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getFile(pathInProject);

		}
		return new FoundLocation(f, bestln);
	}
	// END COMPLEX CODE

	@SuppressWarnings("unused")
	/**
	 * Not used at the moment.
	 */
	private void normalize(Map<Integer, Double> vals) {
		double tot = 0;
		double totsq = 0;
		for (Double d : vals.values()) {
			double v = d.doubleValue();
			if (v > 0) {
				tot += v;
				totsq += v * v;
			}
		}

		if (tot == 0) {
			return;
		}

		totsq = Math.sqrt(totsq);
		for (Map.Entry<Integer, Double> ent : vals.entrySet()) {
			double v = ent.getValue();
			if (v > 0) {
				ent.setValue(v / totsq);
			}
		}
	}

}
