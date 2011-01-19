package org.unicase.changetracking.release;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

public class GitMergeHistoryBuilder {

	
	private Repository repo;

	public GitMergeHistoryBuilder(Repository repo){
		this.repo = repo;
	}
	
	
	public Map<RevCommit,BranchState> build(RevCommit baseHead, Collection<RevCommit> set){
		Map<RevCommit,BranchState> result = new HashMap<RevCommit, BranchState>();
		Map<String, RevCommit> trunkSet = buildTrunkSet(baseHead);
		
		for (RevCommit c: set){
			//If the commit is contained in the trunk set, it is already merged in.
			if (trunkSet.containsKey(c.getName())){
				result.put(c, BranchState.MERGED);
			
			//Otherwise, check if it is connected with the trunk set
			} else if (checkConnection(trunkSet, c)){
				result.put(c, BranchState.UNMERGED);
			} else {
				result.put(c, BranchState.UNCONNECTED);
			}
		}
		
		return result;
	}

	private boolean checkConnection(Map<String, RevCommit> trunkSet, RevCommit c) {
		if(trunkSet.containsKey(c.getName())){
			//This node is in the trunk set, so it is obviously connected to it
			return true;
		} else if (c.getParentCount() > 0){
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


	private Map<String, RevCommit> buildTrunkSet(RevCommit baseHead) {
		Map<String, RevCommit> result = new HashMap<String, RevCommit>();
		ArrayList<RevCommit> queue = new ArrayList<RevCommit>();
		queue.add(baseHead);
		while(!queue.isEmpty()){
			//Unqueue current node and add to result
			RevCommit cur = queue.remove(queue.size()-1);
			result.put(cur.getName(), cur);
			
			//Add all parents into queue
			if(cur.getParents() != null){
				for(RevCommit parent : cur.getParents()){
					queue.add(parent);
				}
			}
		}
		return result;
	}
	
}
