package org.derefaz.d4d.user.comm;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.derefaz.d4d.reader.LineHandler;
import org.derefaz.d4d.user.antenna.UserByAntennaDrivenData;

public class Set4Loader implements LineHandler{

	private CommUserDrivenData store;
	

	public Set4Loader() {
		
	}

	@Override
	public void load(StringTokenizer _tokenizer) {
		String userId = _tokenizer.nextToken();
		String destUserId  = _tokenizer.nextToken();
		
		CommUserDrivenRow row = this.store.exists(userId)? this.store.get(userId) : new CommUserDrivenRow(userId);
		row.addCalled(destUserId);
		this.store.put(row);
					
		row = this.store.exists(destUserId)? this.store.get(destUserId) : new CommUserDrivenRow(destUserId);
		row.addReceived(userId);
		this.store.put(row);
	}
	
	public void setStore(CommUserDrivenData _store){
		this.store = _store;
	}
	
}
