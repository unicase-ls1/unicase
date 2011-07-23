/**
 * <copyright>
 *
 * Copyright (c) 2011 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator.changerecorder;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.IEditorPart;

/**
 * Action for start or stop recording.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class RecordChangesAction extends Action {

	private IEditingDomainProvider editingDomainProvider;

	/**
	 * Creates a new record action for the specified <code>part</code> and the
	 * specified <code>editingDomainProvider</code>.
	 * 
	 * @param part
	 *            to get labels from.
	 * @param editingDomainProvider
	 *            to start or stop record.
	 */
	public RecordChangesAction(final IEditorPart part,
			IEditingDomainProvider editingDomainProvider) {
		this.editingDomainProvider = editingDomainProvider;
		this.setEnabled(true);
		this.setId(part.getEditorSite().getId());
		this.setImageDescriptor(new ImageDescriptor() {
			@Override
			public ImageData getImageData() {
				return part.getTitleImage().getImageData();
			}
		});
		this.setText(part.getTitle() + getStatusMessage());
		this.setToolTipText("Record changes performed in " + this.getText());
	}

	/**
	 * Returns the {@link EditingDomain} from the currently set
	 * {@link #editingDomainProvider}.
	 * 
	 * @return the {@link EditingDomain}
	 */
	private EditingDomain getEditingDomain() {
		return editingDomainProvider.getEditingDomain();
	}

	/**
	 * Returns an instance of the {@link ChangeRecorderPlugin}.
	 * 
	 * @return the instance of the {@link ChangeRecorderPlugin}.
	 */
	private ChangeRecorderPlugin getPlugin() {
		return ChangeRecorderPlugin.getDefault();
	}

	/**
	 * Specifies whether the currently set {@link #getEditingDomain() editing
	 * domain} is currently recorded.
	 * 
	 * @return <code>true</code> if recording, otherwise <code>false</code>.
	 */
	private boolean isRecording() {
		ChangeRecorderPlugin plugin = getPlugin();
		return plugin.isRecording(getEditingDomain());
	}

	/**
	 * Creates a status message depending on the recording state of the
	 * currently set {@link #editingDomainProvider}.
	 * 
	 * @return the status message.
	 */
	private String getStatusMessage() {
		if (isRecording()) {
			return " " + "[Stop recording]";
		} else {
			return " " + "[Start recording]";
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Starts or stops recording the {@link EditingDomain} from the currently
	 * set {@link IEditingDomainProvider}.
	 */
	@Override
	public void run() {
		if (isRecording()) {
			getPlugin().stopRecording(getEditingDomain());
		} else {
			getPlugin().startRecording(getEditingDomain());
		}
		super.run();
	}

}
