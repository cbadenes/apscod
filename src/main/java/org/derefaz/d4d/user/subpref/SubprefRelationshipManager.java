package org.derefaz.d4d.user.subpref;

import java.util.HashMap;
import java.util.List;

public class SubprefRelationshipManager {

	private HashMap<List<Integer>, String> relationship;
	
	private Integer index;
	
	public SubprefRelationshipManager() {
		this.relationship = new HashMap<>();
		this.index = 0;
	}
	
	public String get(List<Integer> _antennas){
		for (List<Integer> antennasKey : this.relationship.keySet()) {
			if (areEqual(antennasKey, _antennas)){
				return this.relationship.get(antennasKey);
			}
		}
		String key = generateKey();
		this.relationship.put(_antennas, key);
		return key;
	}
	
	private String generateKey(){
		return String.valueOf(this.index++);
	}
	
	private boolean areEqual(List<Integer> _list1, List<Integer> _list2){
		return _list1.containsAll(_list2) && _list2.containsAll(_list1);
	}
	
}
