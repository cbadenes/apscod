package org.derefaz.d4d.time;

import java.util.Calendar;

import org.derefaz.d4d.type.IntervalTimeType;

public class IntervalTime {

	// morning: 4:00 a.m. 11:59:59 a.m
	// afternoon: 12:00 p.m. 7:59:59 p.m.
	// evening: 8:00 p.m  3:59:59 a.m
	
	public static IntervalTimeType get(Calendar _date){
		int hour = _date.get(Calendar.HOUR_OF_DAY);
		if ((hour >= 4) && (hour <12)) return IntervalTimeType.morning;
		if ((hour >= 12) && (hour < 20)) return IntervalTimeType.afternoon;
		return IntervalTimeType.evening;
	}
}
