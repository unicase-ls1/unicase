package org.unicase.changetracking.release;

import java.util.ArrayList;
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
	
	public void build(String baseBranch, List<String> branches){
	}
	
	public void build(RevCommit baseHead, List<RevCommit> branchHeads){
		Map<String, RevCommit> trunkSet = buildTrunkSet(baseHead);
		for(RevCommit c: branchHeads){
			//If the commit is contained in the trunk set, it is already merged in.
			if(trunkSet.containsKey(c.getName())){
				HIER WEITER
			}
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
			for(RevCommit parent : cur.getParents()){
				queue.add(parent);
			}
		}
		return result;
	}
	
}
