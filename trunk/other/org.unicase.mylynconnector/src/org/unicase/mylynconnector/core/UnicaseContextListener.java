package org.unicase.mylynconnector.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.eclipse.mylyn.context.core.AbstractContextListener;
import org.eclipse.mylyn.context.core.IInteractionContext;
import org.eclipse.mylyn.context.core.IInteractionElement;
import org.eclipse.mylyn.internal.context.core.ContextCorePlugin;
import org.eclipse.mylyn.internal.context.core.InteractionContextManager;
import org.eclipse.mylyn.internal.context.core.SaxContextWriter;

@SuppressWarnings("restriction")
public class UnicaseContextListener extends AbstractContextListener {

	private InteractionContextManager contextManager;

	public UnicaseContextListener() {
		contextManager = ContextCorePlugin.getContextManager();
		contextManager.addListener(this);
	}

	@Override
	public void contextActivated(IInteractionContext activeContext) {
		if (activeContext != null) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			SaxContextWriter saxContextWriter = new SaxContextWriter();
			saxContextWriter.setOutputStream(byteArrayOutputStream);
			try {
				saxContextWriter.writeContextToStream(activeContext);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(new String(byteArrayOutputStream.toByteArray()));
		}
	}

	@Override
	public void contextPreActivated(IInteractionContext context) {
		System.out.println("contextPreActivated");
	}

	@Override
	public void contextCleared(IInteractionContext context) {
		System.out.println("contextCleared");
	}

	@Override
	public void contextDeactivated(IInteractionContext context) {
		System.out.println("contextDeactivated");
	}

	@Override
	public void elementsDeleted(List<IInteractionElement> elements) {
		System.out.println("elementsDeleted");
	}

	@Override
	public void interestChanged(List<IInteractionElement> elements) {
		System.out.println("interestChanged");
	}

	@Override
	public void landmarkAdded(IInteractionElement element) {
		System.out.println("landmarkAdded");
	}

	@Override
	public void landmarkRemoved(IInteractionElement element) {
		System.out.println("landmarkRemoved");
	}
}
