package org.unicase.changetracking.git.release;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.release.ChangePackageState;

public class GitMergeHistoryBuilder {

	
	private RevWalk revWalk;

	public GitMergeHistoryBuilder(Repository repo){
		this.revWalk = new RevWalk(repo);
	}
	
	
	public Map<RevCommit,ChangePackageState> build(RevCommit baseHead, Collection<RevCommit> set){
		Map<RevCommit,ChangePackageState> result = new HashMap<RevCommit, ChangePackageState>();
		Set<String> trunkSet = buildTrunkSet(baseHead);
		
		for (RevCommit c: set){
			//If the commit is contained in the trunk set, it is already merged in.
			if (trunkSet.contains(c.getName())){
				result.put(c, ChangePackageState.MERGED);
			
			//Otherwise, check if it is connected with the trunk set
			} else if (checkConnection(trunkSet, c)){
				result.put(c, ChangePackageState.UNMERGED);
			} else {
				result.put(c, ChangePackageState.ERROR);
			}
		}
		
		return result;
	}

	private boolean checkConnection(Set<String> trunkSet, RevCommit c) {
		if(trunkSet.contains(c.getName())){
			//This node is in the trunk set, so it is obviously connected to it
			return true;
		} else {
			//Resolve parents
			c = resolveParentsIfNecessary(c);
			if (c.getParentCount() > 0){
				int count = c.getParentCount();
				for ( int i=0 ; i < count ; i++ ){
					if(checkConnection(trunkSet, c.getParent(i))){
						//Parent is connected, so this commit is, too
						return true;
					}
				}
				//No parent is connected? Then this is not connected, too
				return false;
			} else {
				//Still not connected and has no more parents? => Not connected
				return false;
			}
		}
	}

	private RevCommit resolveParentsIfNecessary(RevCommit c){
		if(c.getParents() == null){
			try {
				c = revWalk.parseCommit(c.getId());
				if(c.getParents()==null){
					throw new UnexpectedGitException("Parents array is null after parsing");
				}
			} catch (MissingObjectException e) {
				throw new UnexpectedGitException(e);
			} catch (IncorrectObjectTypeException e) {
				throw new UnexpectedGitException(e);
			} catch (IOException e) {
				throw new UnexpectedGitException(e);
			}
		}
		return c;
		
	}
	
	private Set<String> buildTrunkSet(RevCommit baseHead) {
		ArrayList<RevCommit> queue = new ArrayList<RevCommit>();
		Set<String> result = new HashSet<String>();
		
		queue.add(baseHead);
		result.add(baseHead.getName());
		int i = 0;
		while(!queue.isEmpty()){
			i++;
			
			//Unqueue current node and add to result
			RevCommit cur = resolveParentsIfNecessary(queue.remove(queue.size()-1));
				
			//Add all parents into queue
			if(cur.getParents() != null){
				for(RevCommit parent : cur.getParents()){
					if(!result.contains(parent.getName())){
						result.add(parent.getName());
						queue.add(parent);
					}
				}
			}
		}
		return result;
	}
	
}
