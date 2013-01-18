package org.derefaz.d4d.user.subpref;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.derefaz.d4d.type.DayType;
import org.derefaz.d4d.type.IntervalTimeType;
import org.derefaz.d4d.type.WeekDayType;

public class UserBySubprefDrivenRow {
	
	private String userId;
	private int	numCallsMade = 0;
	private int numDays = 150;
	private int numCallsHolidays= 0;
	private int numCallsWorking= 0;
	private int numCallsMorning= 0;
	private int numCallsAfternoon= 0;
	private int numCallsEvening= 0;
	private int numCallsMonday= 0;
	private int numCallsTuesday= 0;
	private int numCallsWednesday= 0;
	private int numCallsThursday= 0;
	private int numCallsFriday= 0;
	private int numCallsSaturday= 0;
	private int numCallsSunday= 0;
	private HashMap<Integer, Integer> subprefs;
	private SubprefRelationshipManager relManager;
	
	public UserBySubprefDrivenRow(String _id, SubprefRelationshipManager _relManager) {
		this.userId = _id;
		this.relManager = _relManager;
		this.subprefs = new HashMap<>();
	}

	public String getUserId() {
		return userId;
	}

	public int getNumCallsMade() {
		return numCallsMade;
	}

	public int getMeanCallsMade() {
		return numCallsMade/numDays;
	}

	public int getNumCallsHolidays() {
		return numCallsHolidays;
	}

	public int getNumCallsWorking() {
		return numCallsWorking;
	}

	public DayType getDay() {
		HashMap<Integer, DayType> day = new HashMap<>();
		day.put(this.numCallsHolidays, DayType.holiday);
		day.put(this.numCallsWorking, DayType.working);
		Integer max = Collections.max(day.keySet());
		return day.get(max);
	}

	public int getNumCallsMorning() {
		return numCallsMorning;
	}

	public int getNumCallsAfternoon() {
		return numCallsAfternoon;
	}

	public int getNumCallsEvening() {
		return numCallsEvening;
	}

	public IntervalTimeType getTime() {
		HashMap<Integer, IntervalTimeType> interval = new HashMap<>();
		interval.put(this.numCallsMorning, IntervalTimeType.morning);
		interval.put(this.numCallsAfternoon, IntervalTimeType.afternoon);
		interval.put(this.numCallsEvening, IntervalTimeType.evening);
		Integer max = Collections.max(interval.keySet());
		return interval.get(max);
	}

	public int getNumCallsMonday() {
		return numCallsMonday;
	}

	public int getNumCallsTuesday() {
		return numCallsTuesday;
	}

	public int getNumCallsWednesday() {
		return numCallsWednesday;
	}

	public int getNumCallsThursday() {
		return numCallsThursday;
	}

	public int getNumCallsFriday() {
		return numCallsFriday;
	}

	public int getNumCallsSaturday() {
		return numCallsSaturday;
	}

	public int getNumCallsSunday() {
		return numCallsSunday;
	}

	public WeekDayType getWeekday() {
		HashMap<Integer, WeekDayType> week = new HashMap<>();
		week.put(this.numCallsMonday, WeekDayType.monday);
		week.put(this.numCallsTuesday, WeekDayType.tuesday);
		week.put(this.numCallsWednesday, WeekDayType.wednesday);
		week.put(this.numCallsThursday, WeekDayType.thrusday);
		week.put(this.numCallsFriday, WeekDayType.friday);
		week.put(this.numCallsSaturday, WeekDayType.saturday);
		week.put(this.numCallsSunday, WeekDayType.sunday);
		Integer max = Collections.max(week.keySet());
		return week.get(max);
	}

	public int getNumSubprefs(){
		return this.subprefs.keySet().size();
	}
	
	public boolean isMultiSubprefs(){
		return getNumSubprefs()>0;
	}
	
	public Integer getMostUsedSubpref() {
		Integer subprefId = -1;
		int times = -1;
		for (Integer subpref : this.subprefs.keySet()) {
			Integer subprefTimes = this.subprefs.get(subpref);
			if (subprefTimes>times){
				times = subprefTimes;
				subprefId = subpref;
			}
		}
		return subprefId;
	}

	public String getSubprefRelationship(){
		return this.relManager.get(new ArrayList<Integer>(this.subprefs.keySet()));
	}
	
	public UserBySubprefDrivenRow incNumCallsMade() {
		this.numCallsMade++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsHolidays() {
		this.numCallsHolidays++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsWorking() {
		this.numCallsWorking++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsMorning() {
		this.numCallsMorning++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsAfternoon() {
		this.numCallsAfternoon++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsEvening() {
		this.numCallsEvening++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsMonday() {
		this.numCallsMonday++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsTuesday() {
		this.numCallsTuesday++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsWednesday() {
		this.numCallsWednesday++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsThursday() {
		this.numCallsThursday++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsFriday() {
		this.numCallsFriday++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsSaturday() {
		this.numCallsSaturday++;
		return this;
	}

	public UserBySubprefDrivenRow incrNumCallsSunday() {
		this.numCallsSunday++;
		return this;
	}

	public UserBySubprefDrivenRow addSubpref(Integer _subprefId){
		Integer times = this.subprefs.containsKey(_subprefId)? this.subprefs.get(_subprefId) : 0;
		times++;
		this.subprefs.put(_subprefId, times);
		return this;
	}
}
