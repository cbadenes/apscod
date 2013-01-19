package org.derefaz.d4d.antenna;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;

import org.derefaz.d4d.time.IntervalTime;
import org.derefaz.d4d.time.PublicHolidays;
import org.derefaz.d4d.type.CallDetail;
import org.derefaz.d4d.type.CallType;
import org.derefaz.d4d.type.DayType;
import org.derefaz.d4d.type.IntervalTimeType;
import org.derefaz.d4d.type.WeekDayType;

public class AntennaDrivenRow {

    private final PublicHolidays holidays;
    private final IntervalTime time;

    private final String antId;
    private final int numDays = 140;

    private final CallDetail callsMade;
    private final CallDetail callsReceived;
    private final CallDetail callsMadeHolidays;
    private final CallDetail callsMadeWorking;
    private final CallDetail callsReceivedHolidays;
    private final CallDetail callsReceivedWorking;
    private final CallDetail callsMadeMorning;
    private final CallDetail callsMadeAfternoon;
    private final CallDetail callsMadeEvening;
    private final CallDetail callsReceivedMorning;
    private final CallDetail callsReceivedAfternoon;
    private final CallDetail callsReceivedEvening;
    private final CallDetail callsMadeMonday;
    private final CallDetail callsMadeTuesday;
    private final CallDetail callsMadeWednesday;
    private final CallDetail callsMadeThrusday;
    private final CallDetail callsMadeFriday;
    private final CallDetail callsMadeSaturday;
    private final CallDetail callsMadeSunday;
    private final CallDetail callsReceivedMonday;
    private final CallDetail callsReceivedTuesday;
    private final CallDetail callsReceivedWednesday;
    private final CallDetail callsReceivedThrusday;
    private final CallDetail callsReceivedFriday;
    private final CallDetail callsReceivedSaturday;
    private final CallDetail callsReceivedSunday;
    private final HashMap<String, CallDetail> calledAntennas;
    private final HashMap<String, CallDetail> receivedAntennas;

    public AntennaDrivenRow(String _id) {
        this.antId = _id;
        this.holidays = new PublicHolidays();
        this.time = new IntervalTime();
        this.callsMade = new CallDetail(numDays);
        this.callsReceived = new CallDetail(numDays);
        this.callsMadeHolidays = new CallDetail(numDays);
        this.callsMadeWorking = new CallDetail(numDays);
        this.callsReceivedHolidays = new CallDetail(numDays);
        this.callsReceivedWorking = new CallDetail(numDays);
        this.callsMadeMorning = new CallDetail(numDays);
        this.callsMadeAfternoon = new CallDetail(numDays);
        this.callsMadeEvening = new CallDetail(numDays);
        this.callsReceivedMorning = new CallDetail(numDays);
        this.callsReceivedAfternoon = new CallDetail(numDays);
        this.callsReceivedEvening = new CallDetail(numDays);
        this.callsMadeMonday = new CallDetail(numDays);
        this.callsMadeTuesday = new CallDetail(numDays);
        this.callsMadeWednesday = new CallDetail(numDays);
        this.callsMadeThrusday = new CallDetail(numDays);
        this.callsMadeFriday = new CallDetail(numDays);
        this.callsMadeSaturday = new CallDetail(numDays);
        this.callsMadeSunday = new CallDetail(numDays);
        this.callsReceivedMonday = new CallDetail(numDays);
        this.callsReceivedTuesday = new CallDetail(numDays);
        this.callsReceivedWednesday = new CallDetail(numDays);
        this.callsReceivedThrusday = new CallDetail(numDays);
        this.callsReceivedFriday = new CallDetail(numDays);
        this.callsReceivedSaturday = new CallDetail(numDays);
        this.callsReceivedSunday = new CallDetail(numDays);
        this.calledAntennas = new HashMap<>();
        this.receivedAntennas = new HashMap<>();
    }

    public int getNumCalls() {
        return callsMade.getNum() + callsReceived.getNum();
    }

    public CallType getCallsType() {
        return callsMade.getNum() > callsReceived.getNum() ? CallType.made : CallType.received;
    }

    public CallType getDurationCallsType() {
        return callsMade.getDuration() > callsReceived.getDuration() ? CallType.made : CallType.received;
    }

    public DayType getCallsMadeDay() {
        return callsMadeHolidays.getNum() > callsMadeWorking.getNum() ? DayType.holiday : DayType.working;
    }

    public DayType getDurationCallsMadeDay() {
        return callsMadeHolidays.getDuration() > callsMadeWorking.getDuration() ? DayType.holiday : DayType.working;
    }

    public DayType getCallsReceivedDay() {
        return callsReceivedHolidays.getNum() > callsReceivedWorking.getNum() ? DayType.holiday : DayType.working;
    }

    public DayType getDurationCallsReceivedDay() {
        return callsReceivedHolidays.getDuration() > callsReceivedWorking.getDuration() ? DayType.holiday
                : DayType.working;
    }

    public IntervalTimeType getCallsMadeTime() {
        HashMap<Integer, IntervalTimeType> time = new HashMap<>();
        time.put(callsMadeMorning.getNum(), IntervalTimeType.morning);
        time.put(callsMadeAfternoon.getNum(), IntervalTimeType.afternoon);
        time.put(callsMadeEvening.getNum(), IntervalTimeType.evening);
        return time.get(Collections.max(time.keySet()));
    }

    public IntervalTimeType getDurationCallsMadeTime() {
        HashMap<Long, IntervalTimeType> time = new HashMap<>();
        time.put(callsMadeMorning.getDuration(), IntervalTimeType.morning);
        time.put(callsMadeAfternoon.getDuration(), IntervalTimeType.afternoon);
        time.put(callsMadeEvening.getDuration(), IntervalTimeType.evening);
        return time.get(Collections.max(time.keySet()));
    }

    public IntervalTimeType getCallsReceivedTime() {
        HashMap<Integer, IntervalTimeType> time = new HashMap<>();
        time.put(callsReceivedMorning.getNum(), IntervalTimeType.morning);
        time.put(callsReceivedAfternoon.getNum(), IntervalTimeType.afternoon);
        time.put(callsReceivedEvening.getNum(), IntervalTimeType.evening);
        return time.get(Collections.max(time.keySet()));
    }

    public IntervalTimeType getDurationCallsReceivedTime() {
        HashMap<Long, IntervalTimeType> time = new HashMap<>();
        time.put(callsReceivedMorning.getDuration(), IntervalTimeType.morning);
        time.put(callsReceivedAfternoon.getDuration(), IntervalTimeType.afternoon);
        time.put(callsReceivedEvening.getDuration(), IntervalTimeType.evening);
        return time.get(Collections.max(time.keySet()));
    }

    public WeekDayType getCallsMadeWeekday() {
        HashMap<Integer, WeekDayType> time = new HashMap<>();
        time.put(callsMadeMonday.getNum(), WeekDayType.monday);
        time.put(callsMadeTuesday.getNum(), WeekDayType.tuesday);
        time.put(callsMadeWednesday.getNum(), WeekDayType.wednesday);
        time.put(callsMadeThrusday.getNum(), WeekDayType.thrusday);
        time.put(callsMadeFriday.getNum(), WeekDayType.friday);
        time.put(callsMadeSaturday.getNum(), WeekDayType.saturday);
        time.put(callsMadeSunday.getNum(), WeekDayType.sunday);
        return time.get(Collections.max(time.keySet()));
    }

    public WeekDayType getDurationCallsMadeWeekday() {
        HashMap<Long, WeekDayType> time = new HashMap<>();
        time.put(callsMadeMonday.getDuration(), WeekDayType.monday);
        time.put(callsMadeTuesday.getDuration(), WeekDayType.tuesday);
        time.put(callsMadeWednesday.getDuration(), WeekDayType.wednesday);
        time.put(callsMadeThrusday.getDuration(), WeekDayType.thrusday);
        time.put(callsMadeFriday.getDuration(), WeekDayType.friday);
        time.put(callsMadeSaturday.getDuration(), WeekDayType.saturday);
        time.put(callsMadeSunday.getDuration(), WeekDayType.sunday);
        return time.get(Collections.max(time.keySet()));
    }

    public WeekDayType getCallsReceivedWeekday() {
        HashMap<Integer, WeekDayType> time = new HashMap<>();
        time.put(callsReceivedMonday.getNum(), WeekDayType.monday);
        time.put(callsReceivedTuesday.getNum(), WeekDayType.tuesday);
        time.put(callsReceivedWednesday.getNum(), WeekDayType.wednesday);
        time.put(callsReceivedThrusday.getNum(), WeekDayType.thrusday);
        time.put(callsReceivedFriday.getNum(), WeekDayType.friday);
        time.put(callsReceivedSaturday.getNum(), WeekDayType.saturday);
        time.put(callsReceivedSunday.getNum(), WeekDayType.sunday);
        return time.get(Collections.max(time.keySet()));
    }

    public WeekDayType getDurationCallsReceivedWeekday() {
        HashMap<Long, WeekDayType> time = new HashMap<>();
        time.put(callsReceivedMonday.getDuration(), WeekDayType.monday);
        time.put(callsReceivedTuesday.getDuration(), WeekDayType.tuesday);
        time.put(callsReceivedWednesday.getDuration(), WeekDayType.wednesday);
        time.put(callsReceivedThrusday.getDuration(), WeekDayType.thrusday);
        time.put(callsReceivedFriday.getDuration(), WeekDayType.friday);
        time.put(callsReceivedSaturday.getDuration(), WeekDayType.saturday);
        time.put(callsReceivedSunday.getDuration(), WeekDayType.sunday);
        return time.get(Collections.max(time.keySet()));
    }

    public boolean isMultiCaller() {
        return calledAntennas.keySet().size() > 1;
    }

    public boolean isMultiReceiver() {
        return receivedAntennas.keySet().size() > 1;
    }

    public String getMostCalledAntenna() {
        String id = "";
        Integer times = Integer.MIN_VALUE;
        for (String antenna : calledAntennas.keySet()) {
            Integer num = calledAntennas.get(antenna).getNum();
            if (num > times) {
                times = num;
                id = antenna;
            }
        }
        return id;
    }

    public String getMostReceivedAntenna() {
        String id = "";
        Integer times = Integer.MIN_VALUE;
        for (String antenna : receivedAntennas.keySet()) {
            Integer num = receivedAntennas.get(antenna).getNum();
            if (num > times) {
                times = num;
                id = antenna;
            }
        }
        return id;
    }

    /**
     * @return the antId
     */
    public String getAntId() {
        return this.antId;
    }

    /**
     * @return the numDays
     */
    public int getNumDays() {
        return this.numDays;
    }

    /**
     * @return the callsMade
     */
    public CallDetail getCallsMade() {
        return this.callsMade;
    }

    /**
     * @return the callsReceived
     */
    public CallDetail getCallsReceived() {
        return this.callsReceived;
    }

    /**
     * @return the callsMadeHolidays
     */
    public CallDetail getCallsMadeHolidays() {
        return this.callsMadeHolidays;
    }

    /**
     * @return the callsMadeWorking
     */
    public CallDetail getCallsMadeWorking() {
        return this.callsMadeWorking;
    }

    /**
     * @return the callsReceivedHolidays
     */
    public CallDetail getCallsReceivedHolidays() {
        return this.callsReceivedHolidays;
    }

    /**
     * @return the callsReceivedWorking
     */
    public CallDetail getCallsReceivedWorking() {
        return this.callsReceivedWorking;
    }

    /**
     * @return the callsMadeMorning
     */
    public CallDetail getCallsMadeMorning() {
        return this.callsMadeMorning;
    }

    /**
     * @return the callsMadeAfternoon
     */
    public CallDetail getCallsMadeAfternoon() {
        return this.callsMadeAfternoon;
    }

    /**
     * @return the callsMadeEvening
     */
    public CallDetail getCallsMadeEvening() {
        return this.callsMadeEvening;
    }

    /**
     * @return the callsReceivedMorning
     */
    public CallDetail getCallsReceivedMorning() {
        return this.callsReceivedMorning;
    }

    /**
     * @return the callsReceivedAfternoon
     */
    public CallDetail getCallsReceivedAfternoon() {
        return this.callsReceivedAfternoon;
    }

    /**
     * @return the callsReceivedEvening
     */
    public CallDetail getCallsReceivedEvening() {
        return this.callsReceivedEvening;
    }

    /**
     * @return the callsMadeMonday
     */
    public CallDetail getCallsMadeMonday() {
        return this.callsMadeMonday;
    }

    /**
     * @return the callsMadeTuesday
     */
    public CallDetail getCallsMadeTuesday() {
        return this.callsMadeTuesday;
    }

    /**
     * @return the callsMadeWednesday
     */
    public CallDetail getCallsMadeWednesday() {
        return this.callsMadeWednesday;
    }

    /**
     * @return the callsMadeThrusday
     */
    public CallDetail getCallsMadeThrusday() {
        return this.callsMadeThrusday;
    }

    /**
     * @return the callsMadeFriday
     */
    public CallDetail getCallsMadeFriday() {
        return this.callsMadeFriday;
    }

    /**
     * @return the callsMadeSaturday
     */
    public CallDetail getCallsMadeSaturday() {
        return this.callsMadeSaturday;
    }

    /**
     * @return the callsMadeSunday
     */
    public CallDetail getCallsMadeSunday() {
        return this.callsMadeSunday;
    }

    /**
     * @return the callsReceivedMonday
     */
    public CallDetail getCallsReceivedMonday() {
        return this.callsReceivedMonday;
    }

    /**
     * @return the callsReceivedTuesday
     */
    public CallDetail getCallsReceivedTuesday() {
        return this.callsReceivedTuesday;
    }

    /**
     * @return the callsReceivedWednesday
     */
    public CallDetail getCallsReceivedWednesday() {
        return this.callsReceivedWednesday;
    }

    /**
     * @return the callsReceivedThrusday
     */
    public CallDetail getCallsReceivedThrusday() {
        return this.callsReceivedThrusday;
    }

    /**
     * @return the callsReceivedFriday
     */
    public CallDetail getCallsReceivedFriday() {
        return this.callsReceivedFriday;
    }

    /**
     * @return the callsReceivedSaturday
     */
    public CallDetail getCallsReceivedSaturday() {
        return this.callsReceivedSaturday;
    }

    /**
     * @return the callsReceivedSunday
     */
    public CallDetail getCallsReceivedSunday() {
        return this.callsReceivedSunday;
    }

    /**
     * @return the calledAntennas
     */
    public HashMap<String, CallDetail> getCalledAntennas() {
        return this.calledAntennas;
    }

    /**
     * @return the receivedAntennas
     */
    public HashMap<String, CallDetail> getReceivedAntennas() {
        return this.receivedAntennas;
    }

    public AntennaDrivenRow incrCallsMade(Calendar _calendar, int _num, long _dur, String _antennaId) {
        callsMade.incr(_num, _dur);
        incr(_calendar, _num, _dur, CallType.made);
        CallDetail detail = calledAntennas.containsKey(_antennaId) ? calledAntennas.get(_antennaId) : new CallDetail(
                numDays);
        calledAntennas.put(_antennaId, detail.incr(_num, _dur));
        return this;
    }

    public AntennaDrivenRow incrCallsReceived(Calendar _calendar, int _num, long _dur, String _antennaId) {
        callsReceived.incr(_num, _dur);
        incr(_calendar, _num, _dur, CallType.received);
        CallDetail detail = receivedAntennas.containsKey(_antennaId) ? receivedAntennas.get(_antennaId)
                : new CallDetail(numDays);
        receivedAntennas.put(_antennaId, detail.incr(_num, _dur));
        return this;
    }

    private void incr(Calendar _calendar, int _num, long _dur, CallType _type) {
        incrCallsByHolidays(_calendar, _num, _dur, _type);
        incrCallsByIntervalTime(_calendar, _num, _dur, _type);
        incrWeekday(_calendar, _num, _dur, _type);
    }

    private void incrCallsByHolidays(Calendar _calendar, int _num, long _dur, CallType _type) {
        if (this.holidays.isHoliday(_calendar)) {
            switch (_type) {
            case made:
                callsMadeHolidays.incr(_num, _dur);
                break;
            case received:
                callsReceivedHolidays.incr(_num, _dur);
                break;
            }
        } else {
            switch (_type) {
            case made:
                callsMadeWorking.incr(_num, _dur);
                break;
            case received:
                callsReceivedWorking.incr(_num, _dur);
                break;
            }
        }
    }

    private void incrCallsByIntervalTime(Calendar _calendar, int _num, long _dur, CallType _type) {
        switch (IntervalTime.get(_calendar)) {
        case morning:
            switch (_type) {
            case made:
                callsMadeMorning.incr(_num, _dur);
                break;
            case received:
                callsReceivedMorning.incr(_num, _dur);
                break;
            }
            break;
        case afternoon:
            switch (_type) {
            case made:
                callsMadeAfternoon.incr(_num, _dur);
                break;
            case received:
                callsReceivedAfternoon.incr(_num, _dur);
                break;
            }
            break;
        case evening:
            switch (_type) {
            case made:
                callsMadeEvening.incr(_num, _dur);
                break;
            case received:
                callsReceivedEvening.incr(_num, _dur);
                break;
            }
            break;
        }
    }

    private void incrWeekday(Calendar _calendar, int _num, long _dur, CallType _type) {
        switch (_calendar.get(Calendar.DAY_OF_WEEK)) {
        case Calendar.MONDAY:
            switch (_type) {
            case made:
                callsMadeMonday.incr(_num, _dur);
                break;
            case received:
                callsReceivedMonday.incr(_num, _dur);
                break;
            }
            break;
        case Calendar.TUESDAY:
            switch (_type) {
            case made:
                callsMadeTuesday.incr(_num, _dur);
                break;
            case received:
                callsReceivedTuesday.incr(_num, _dur);
                break;
            }
            break;
        case Calendar.WEDNESDAY:
            switch (_type) {
            case made:
                callsMadeWednesday.incr(_num, _dur);
                break;
            case received:
                callsReceivedWednesday.incr(_num, _dur);
                break;
            }
            break;
        case Calendar.THURSDAY:
            switch (_type) {
            case made:
                callsMadeThrusday.incr(_num, _dur);
                break;
            case received:
                callsReceivedThrusday.incr(_num, _dur);
                break;
            }
            break;
        case Calendar.FRIDAY:
            switch (_type) {
            case made:
                callsMadeFriday.incr(_num, _dur);
                break;
            case received:
                callsReceivedFriday.incr(_num, _dur);
                break;
            }
            break;
        case Calendar.SATURDAY:
            switch (_type) {
            case made:
                callsMadeSaturday.incr(_num, _dur);
                break;
            case received:
                callsReceivedSaturday.incr(_num, _dur);
                break;
            }
            break;
        case Calendar.SUNDAY:
            switch (_type) {
            case made:
                callsMadeSunday.incr(_num, _dur);
                break;
            case received:
                callsReceivedSunday.incr(_num, _dur);
                break;
            }
            break;
        }
    }

}
