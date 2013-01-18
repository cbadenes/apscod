package org.derefaz.d4d.user.antenna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.derefaz.d4d.type.DayType;
import org.derefaz.d4d.type.IntervalTimeType;
import org.derefaz.d4d.type.UserType;
import org.derefaz.d4d.type.WeekDayType;

public class UserByAntennaDrivenRow {
	
	private String userId;
	private int	numCallsMade = 0;
	private int numDays = 14;
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
	private HashMap<Integer, Integer> antennas;
	private AntennaRelationshipManager relManager;
	
	public UserByAntennaDrivenRow(String _id, AntennaRelationshipManager _relManager) {
		this.userId = _id;
		this.relManager = _relManager;
		this.antennas = new HashMap<>();
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

	public int getNumAntennas(){
		return this.antennas.keySet().size();
	}
	
	public Integer getMostUsedAntenna() {
		Integer antennaId = -1;
		int times = -1;
		for (Integer antenna : this.antennas.keySet()) {
			Integer antTimes = this.antennas.get(antenna);
			if (antTimes>times){
				times = antTimes;
				antennaId = antenna;
			}
		}
		return antennaId;
	}

	public String getAntennaRelationship(){
		return this.relManager.get(new ArrayList<Integer>(this.antennas.keySet()));
	}
	
	public UserByAntennaDrivenRow incNumCallsMade() {
		this.numCallsMade++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsHolidays() {
		this.numCallsHolidays++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsWorking() {
		this.numCallsWorking++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsMorning() {
		this.numCallsMorning++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsAfternoon() {
		this.numCallsAfternoon++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsEvening() {
		this.numCallsEvening++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsMonday() {
		this.numCallsMonday++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsTuesday() {
		this.numCallsTuesday++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsWednesday() {
		this.numCallsWednesday++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsThursday() {
		this.numCallsThursday++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsFriday() {
		this.numCallsFriday++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsSaturday() {
		this.numCallsSaturday++;
		return this;
	}

	public UserByAntennaDrivenRow incrNumCallsSunday() {
		this.numCallsSunday++;
		return this;
	}

	public UserByAntennaDrivenRow addAntenna(Integer _antennaId){
		Integer times = this.antennas.containsKey(_antennaId)? this.antennas.get(_antennaId) : 0;
		times++;
		this.antennas.put(_antennaId, times);
		return this;
	}
}
