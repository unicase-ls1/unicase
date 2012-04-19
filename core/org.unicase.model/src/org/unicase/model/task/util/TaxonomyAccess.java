/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.util;

import java.util.HashMap;

/**
 * Singelton to access taxonomies.
 * 
 * @see Taxonomy
 * @author helming
 */
public final class TaxonomyAccess {

	private HashMap<String, Taxonomy> taxonomies = new HashMap<String, Taxonomy>();

	private static TaxonomyAccess instance = new TaxonomyAccess();

	/**
	 * Default constructor.
	 */
	public TaxonomyAccess() {
		addInternalTaxonomies();
	}

	private void addInternalTaxonomies() {
		// taxonomies.put(CheckablesTaxonomy.class.getName(),
		// new CheckablesTaxonomy());
		// taxonomies.put(SystemModelElementTaxonomy.class.getName(),
		// new SystemModelElementTaxonomy());
		// taxonomies.put(COBTaxonomy.class.getName(), new COBTaxonomy());
	}

	/**
	 * Get instace for singelton.
	 * 
	 * @return the instance
	 */
	public static TaxonomyAccess getInstance() {
		return instance;
	}

	/**
	 * Returns a taxonomy.
	 * 
	 * @param name of the taxonomy
	 * @return the taxonomy
	 * @throws TaxonomyNotFoundException if the taxonomy is not found
	 */
	public Taxonomy getTaxonomy(String name) throws TaxonomyNotFoundException {
		Taxonomy taxonomy = taxonomies.get(name);
		if (taxonomy == null) {
			throw new TaxonomyNotFoundException();
		} else {
			return taxonomy;
		}
	}

	/**
	 * Returns the taxonomy which defines which ModelLinks are OpeningDependencies.
	 * 
	 * @return the {@link OpeningLinkTaxonomy}
	 */
	public OpeningLinkTaxonomy getOpeningLinkTaxonomy() {
		return new OpeningLinkTaxonomy();
	}

	/**
	 * Returns the taxonomy which defines which ModelLink are BlockingDependencies.
	 * 
	 * @return the {@link BlockingLinkTaxonomy}
	 */
	public BlockingLinkTaxonomy getBlockingLinkTaxonomy() {
		return new BlockingLinkTaxonomy();
	}
}
