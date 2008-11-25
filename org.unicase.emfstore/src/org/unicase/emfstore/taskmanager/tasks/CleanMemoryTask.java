package org.unicase.emfstore.taskmanager.tasks;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.EmfStoreImpl;
import org.unicase.emfstore.taskmanager.Task;

/**
 * This task is used to clean the memory by proxifying the projectstates.
 * 
 * @author wesendon
 */
public class CleanMemoryTask extends Task {

	//private static final long PERIOD = 1000*60*5;
	
	private static final long PERIOD = 10000;
	
	private EmfStoreImpl emfStoreImpl;
	
	private static final Log LOGGER = LogFactory.getLog(CleanMemoryTask.class);
	
	/**
	 * Default constructor.
	 * 
	 * @param emfStore emfstore interface
	 */
	public CleanMemoryTask(EmfStore emfStore) {
		super(new Date(System.currentTimeMillis()+PERIOD), PERIOD);
		this.emfStoreImpl = (EmfStoreImpl) emfStore;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void executeTask() {
		LOGGER.info("checking whether projectstates have to be unloaded.");
		emfStoreImpl.unloadProjectStates();
	}

}
