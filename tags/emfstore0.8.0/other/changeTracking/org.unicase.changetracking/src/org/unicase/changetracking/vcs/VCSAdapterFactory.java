package org.unicase.changetracking.vcs;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;

public class VCSAdapterFactory {
	
	private List<VCSAdapterProvider> getProviders(){
		return VCSAdapterRegistry.INSTANCE.getProviders();
	}
	
	private MisuseException createProviderMissingException(String s){
		return new MisuseException("No version control adapter matching this " + s + " could be found. You need to install the appropriate adapter first.");
	}

	public VCSAdapter createFromProject(IProject p) throws MisuseException{
		for(VCSAdapterProvider v : getProviders()){
			if(v.providesForProject(p)){
				return v.create();
			}
		}
		throw createProviderMissingException("project");
	}
	
	public VCSAdapter createFromChangePackage(ChangePackage cp) throws MisuseException{
		for(VCSAdapterProvider v : getProviders()){
			if(v.providesForChangePackage(cp)){
				return v.create();
			}
		}
		throw createProviderMissingException("change package");
	}
	
	public VCSAdapter createFromRelease(ChangeTrackingRelease r){
		Stream s = r.getStream();
		if(s == null){
			throw new MisuseException("The release has no stream attached.");
		}
		RepositoryStream rs = s.getRepositoryStream();
		if(rs == null){
			throw new MisuseException("The stream of the release has no repository stream attached");
		}
		for(VCSAdapterProvider v : getProviders()){
			if(v.providesForStream(rs)){
				return v.create();
			}
		}
		throw createProviderMissingException("release");
	}
}
