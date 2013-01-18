package org.derefaz.d4d.time;

import java.util.Calendar;
import java.util.HashMap;

import org.derefaz.d4d.type.WeekDayType;

public class WeekDay {

	static HashMap<Integer, WeekDayType> days;
	
	static{
		 days = new HashMap<>();
		 days.put(Calendar.MONDAY, WeekDayType.monday);
		 days.put(Calendar.TUESDAY, WeekDayType.tuesday);
		 days.put(Calendar.WEDNESDAY, WeekDayType.wednesday);
		 days.put(Calendar.THURSDAY, WeekDayType.thrusday);
		 days.put(Calendar.FRIDAY, WeekDayType.friday);
		 days.put(Calendar.SATURDAY, WeekDayType.saturday);
		 days.put(Calendar.SUNDAY, WeekDayType.sunday);
	}
	
	
	public static WeekDayType get(Calendar _date){
		return days.get(_date.get(Calendar.DAY_OF_WEEK));
	}
	
}
