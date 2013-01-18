package org.derefaz.d4d.user.antenna;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.derefaz.d4d.reader.LineHandler;
import org.derefaz.d4d.time.IntervalTime;
import org.derefaz.d4d.time.PublicHolidays;
import org.derefaz.d4d.time.WeekDay;
import org.derefaz.d4d.type.IntervalTimeType;
import org.derefaz.d4d.type.WeekDayType;

public class Set2Loader implements LineHandler{

	private SimpleDateFormat dateFormatter;
	private Calendar calendar;
	private UserByAntennaDrivenData store;
	private PublicHolidays publicHolidays;
	private AntennaRelationshipManager antManager;

	public Set2Loader() {
												 
		this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		this.calendar = Calendar.getInstance(TimeZone.getTimeZone("Africa/Abidjan"));
		this.publicHolidays = new PublicHolidays();
		this.antManager = new AntennaRelationshipManager();
	}
	
	@Override
	public void load(StringTokenizer _tokenizer) {
		String userId = _tokenizer.nextToken();
		String dateString  = _tokenizer.nextToken()+"_"+_tokenizer.nextToken();
		String antId = _tokenizer.nextToken();
		
		try {
			UserByAntennaDrivenRow row = this.store.exists(userId)? this.store.get(userId) : new UserByAntennaDrivenRow(userId, this.antManager);
			// numCallsMade
			row.incNumCallsMade();
			
			// numAntennas
			row.addAntenna(Integer.valueOf(antId));
			
			// numCallsHolidays and numCallsWorking
			this.calendar.setTime(this.dateFormatter.parse(dateString));
			boolean holiday = this.publicHolidays.isHoliday(this.calendar);
			if (holiday) row.incrNumCallsHolidays(); else row.incrNumCallsWorking();

			// numCallsMorning, numCallsAfternoon and numCallsEvening
			IntervalTimeType time = IntervalTime.get(this.calendar);
			switch (time) {
			case morning:
				row.incrNumCallsMorning();
				break;
			case afternoon:
				row.incrNumCallsAfternoon();	
				break;
			default:
				row.incrNumCallsEvening();
				break;
			}
			
			//numCallsMonday .. numCallSunday
			WeekDayType weekDay = WeekDay.get(this.calendar);
			switch (weekDay) {
			case monday:
				row.incrNumCallsMonday();
				break;
			case tuesday:
				row.incrNumCallsTuesday();
				break;
			case wednesday:
				row.incrNumCallsWednesday();
				break;
			case thrusday:
				row.incrNumCallsThursday();
				break;
			case friday:
				row.incrNumCallsFriday();
				break;
			case saturday:
				row.incrNumCallsSaturday();
				break;
			default:
				row.incrNumCallsSunday();
				break;
			}
			
			this.store.put(row);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setStore(UserByAntennaDrivenData _store){
		this.store = _store;
	}
}
