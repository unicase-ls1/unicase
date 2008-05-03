package org.unicase.emfstore.rmi.clienttest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.unicase.emfstore.rmi.FacadeTest;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;

public class RMIClientTest {
	public RMIClientTest() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry();
		FacadeTest fa = (FacadeTest) registry.lookup("FacadeTest");
		//string
		fa.sendString("Der Client sagt: tesssst");
		//modelelement
		ModelElement me = ModelFactory.eINSTANCE.createFunctionalRequirement();
		me.setName("a functional requirement");
		fa.sendME(me);
	}
}
