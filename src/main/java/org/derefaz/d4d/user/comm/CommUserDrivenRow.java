package org.derefaz.d4d.user.comm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.derefaz.d4d.type.DayType;
import org.derefaz.d4d.type.IntervalTimeType;
import org.derefaz.d4d.type.UserType;
import org.derefaz.d4d.type.WeekDayType;

public class CommUserDrivenRow {
	
	private String userId;
	private int	numCallsMade = 0;
	private int numCallsReceived = 0;
	private int numCalledPhoneNumber= 0;
	private int numReceivedPhoneNumber= 0;
	private int numCalledNotReceivedPhoneNumber= 0;
	private int numReceivedNotCalledPhoneNumber= 0;
	private HashMap<String, Integer> called;
	private HashMap<String, Integer> received;
	
	public CommUserDrivenRow(String _id) {
		this.userId = _id;
		this.called = new HashMap<>();
		this.received = new HashMap<>();
	}

	public String getUserId() {
		return userId;
	}

	public int getNumCallsMade() {
		return numCallsMade;
	}

	public int getNumCallsReceived() {
		return numCallsReceived;
	}

	public int getNumCalledPhoneNumber() {
		return numCalledPhoneNumber;
	}

	public int getNumReceivedPhoneNumber() {
		return numReceivedPhoneNumber;
	}

	public int getNumCalledNotReceivedPhoneNumber() {
		return numCalledNotReceivedPhoneNumber;
	}

	public int getNumReceivedNotCalledPhoneNumber() {
		return numReceivedNotCalledPhoneNumber;
	}

	public String getMostCalledPhoneNumber(){
		String callerId = "";
		Integer times = -1;
		for (String caller : this.called.keySet()) {
			Integer callTimes = this.called.get(caller);
			if (callTimes>times){
				times = callTimes;
				callerId = caller;
			}
		}
		return callerId;
	}
	
	public String getMostReceivedPhoneNumber(){
		String receiverId = "";
		Integer times = -1;
		for (String receiver : this.received.keySet()) {
			Integer recTimes = this.received.get(receiver);
			if (recTimes>times){
				times = recTimes;
				receiverId = receiver;
			}
		}
		return receiverId;
	}
	
	public UserType getCaller(){
		return (this.called.keySet().size()>4)? UserType.multiuser : UserType.monouser;
	}
	
	public UserType getReceiver(){
		return (this.received.keySet().size()>4)? UserType.multiuser : UserType.monouser;
	}
	
	public Boolean isCallerNotReceiver(){
		List<String> calledList = new ArrayList(this.called.keySet());
		List<String> receiverList = new ArrayList(this.received.keySet());
		return !receiverList.containsAll(calledList);
	}
	
	public Boolean isReceiverNotCalled(){
		List<String> calledList = new ArrayList(this.called.keySet());
		List<String> receiverList = new ArrayList(this.received.keySet());
		return !calledList.containsAll(receiverList);
	}
	
	public void addCalled(String _userId){
		this.numCallsMade++;
		int calls = this.called.containsKey(_userId)? this.called.get(_userId):0;
		this.called.put(_userId, ++calls);
	}
	
	public void addReceived(String _userId){
		this.numCallsReceived++;
		int calls = this.received.containsKey(_userId)? this.received.get(_userId):0;
		this.received.put(_userId, ++calls);
	}
}
