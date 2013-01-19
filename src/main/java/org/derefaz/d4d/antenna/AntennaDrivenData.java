package org.derefaz.d4d.antenna;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class AntennaDrivenData {

    private final HashMap<String, AntennaDrivenRow> antennaData;

    public AntennaDrivenData() {
        this.antennaData = new HashMap<>();
    }

    public boolean exists(String _id) {
        return this.antennaData.containsKey(_id);
    }

    public AntennaDrivenRow get(String _id) {
        return this.antennaData.get(_id);
    }

    public AntennaDrivenData put(AntennaDrivenRow _row) {
        this.antennaData.put(_row.getAntId(), _row);
        return this;
    }

    @Override
    public String toString() {
        return this.antennaData.keySet().size() + " antennas recorded!!";
    }

    public void generate(String _baseDir) {
        try {
            String filePath = _baseDir + "/antenna_driven_data.arff";
            System.out.println("creating file: " + filePath + "...");
            FileOutputStream outputStream = new FileOutputStream(filePath);

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));

            writer.write("% 1. Title: Antenna Driven Dataset\n");
            writer.write("% \n");
            writer.write("% 2. Sources:\n");
            writer.write("%      (a) Creator: C. Badenes\n");
            writer.write("%      (b) Antenna to Antenna Data\n");
            writer.write("%      (c) Orange D4D\n");
            writer.write("%      (d) Date: January, 2013\n");
            writer.write("% \n");
            writer.write("@RELATION antenna\n");
            writer.write("\n");
            writer.write("@ATTRIBUTE ant_id NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv NUMERIC\n");
            writer.write("@ATTRIBUTE calls_type {made, received}\n");
            writer.write("@ATTRIBUTE mean_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE mean_calls_recv NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_type {made, received}\n");
            writer.write("@ATTRIBUTE mean_dur_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE mean_dur_calls_recv NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_holiday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_working NUMERIC\n");
            writer.write("@ATTRIBUTE day_of_calls_made {holiday, working}\n");
            writer.write("@ATTRIBUTE dur_calls_made_holiday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_working NUMERIC\n");
            writer.write("@ATTRIBUTE day_longer_calls_made {holiday, working}\n");
            writer.write("@ATTRIBUTE num_calls_recv_holiday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_working NUMERIC\n");
            writer.write("@ATTRIBUTE day_of_calls_recv {holiday, working}\n");
            writer.write("@ATTRIBUTE dur_calls_recv_holidays NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_working NUMERIC\n");
            writer.write("@ATTRIBUTE day_longer_calls_recv {holiday, working}\n");
            writer.write("@ATTRIBUTE num_calls_made_morning NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_afternoon NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_evening NUMERIC\n");
            writer.write("@ATTRIBUTE time_of_calls_made {morning, afternoon, evening}\n");
            writer.write("@ATTRIBUTE dur_calls_made_morning NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_afternoon NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_evening NUMERIC\n");
            writer.write("@ATTRIBUTE time_longer_calls_made {morning, afternoon, evening}\n");
            writer.write("@ATTRIBUTE num_calls_recv_morning NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_afternoon NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_evening NUMERIC\n");
            writer.write("@ATTRIBUTE time_of_calls_recv {morning, afternoon, evening}\n");
            writer.write("@ATTRIBUTE dur_calls_recv_morning NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_afternoon NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_evening NUMERIC\n");
            writer.write("@ATTRIBUTE time_longer_calls_recv {morning, afternoon, evening}\n");
            writer.write("@ATTRIBUTE num_calls_made_monday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_tuesday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_wednesday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_thrusday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_friday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_saturday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_sunday NUMERIC\n");
            writer.write("@ATTRIBUTE weekday_of_calls_made {monday, tuesday, wednesday, thrusday, friday, saturday, sunday}\n");
            writer.write("@ATTRIBUTE dur_calls_made_monday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_tuesday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_wednesday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_thrusday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_friday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_saturday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_made_sunday NUMERIC\n");
            writer.write("@ATTRIBUTE weekday_longer_calls_made {monday, tuesday, wednesday, thrusday, friday, saturday, sunday}\n");
            writer.write("@ATTRIBUTE num_calls_recv_monday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_tuesday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_wednesday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_thrusday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_friday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_saturday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv_sunday NUMERIC\n");
            writer.write("@ATTRIBUTE weekday_of_calls_recv {monday, tuesday, wednesday, thrusday, friday, saturday, sunday}\n");
            writer.write("@ATTRIBUTE dur_calls_recv_monday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_tuesday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_wednesday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_thrusday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_friday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_saturday NUMERIC\n");
            writer.write("@ATTRIBUTE dur_calls_recv_sunday NUMERIC\n");
            writer.write("@ATTRIBUTE weekday_longer_calls_recv {monday, tuesday, wednesday, thrusday, friday, saturday, sunday}\n");
            writer.write("@ATTRIBUTE num_antennas_called NUMERIC\n");
            writer.write("@ATTRIBUTE num_antennas_recv NUMERIC\n");
            writer.write("@ATTRIBUTE most_called_antenna NUMERIC\n");
            writer.write("@ATTRIBUTE most_recv_antenna NUMERIC\n");
            writer.write("@ATTRIBUTE multi_caller {true, false}\n");
            writer.write("@ATTRIBUTE multi_receiver {true, false}\n");
            writer.write("\n");
            writer.write("@DATA\n");
            writer.write("\n");
            Integer index = 0;
            Integer limit = this.antennaData.keySet().size();
            for (String key : this.antennaData.keySet()) {
                System.out.println("write record [" + index++ + "|" + limit + "]");
                AntennaDrivenRow data = this.antennaData.get(key);
                writer.write(data.getAntId() + ",");
                writer.write(data.getNumCalls() + ",");
                writer.write(data.getCallsMade().getNum() + ",");
                writer.write(data.getCallsReceived().getNum() + ",");
                writer.write(data.getCallsType() + ",");
                writer.write(data.getCallsMade().getMeanNum() + ",");
                writer.write(data.getCallsReceived().getMeanNum() + ",");
                writer.write(data.getCallsMade().getDuration() + ",");
                writer.write(data.getCallsReceived().getDuration() + ",");
                writer.write(data.getDurationCallsType() + ",");
                writer.write(data.getCallsMade().getMeanDuration() + ",");
                writer.write(data.getCallsReceived().getMeanDuration() + ",");
                writer.write(data.getCallsMadeHolidays().getNum() + ",");
                writer.write(data.getCallsMadeWorking().getNum() + ",");
                writer.write(data.getCallsMadeDay() + ",");
                writer.write(data.getCallsMadeHolidays().getDuration() + ",");
                writer.write(data.getCallsMadeWorking().getDuration() + ",");
                writer.write(data.getDurationCallsMadeDay() + ",");
                writer.write(data.getCallsReceivedHolidays().getNum() + ",");
                writer.write(data.getCallsReceivedWorking().getNum() + ",");
                writer.write(data.getCallsReceivedDay() + ",");
                writer.write(data.getCallsReceivedHolidays().getDuration() + ",");
                writer.write(data.getCallsReceivedWorking().getDuration() + ",");
                writer.write(data.getDurationCallsReceivedDay() + ",");
                writer.write(data.getCallsMadeMorning().getNum() + ",");
                writer.write(data.getCallsMadeAfternoon().getNum() + ",");
                writer.write(data.getCallsMadeEvening().getNum() + ",");
                writer.write(data.getCallsMadeTime() + ",");
                writer.write(data.getCallsMadeMorning().getDuration() + ",");
                writer.write(data.getCallsMadeAfternoon().getDuration() + ",");
                writer.write(data.getCallsMadeEvening().getDuration() + ",");
                writer.write(data.getDurationCallsMadeTime() + ",");
                writer.write(data.getCallsReceivedMorning().getNum() + ",");
                writer.write(data.getCallsReceivedAfternoon().getNum() + ",");
                writer.write(data.getCallsReceivedEvening().getNum() + ",");
                writer.write(data.getCallsReceivedTime() + ",");
                writer.write(data.getCallsReceivedMorning().getDuration() + ",");
                writer.write(data.getCallsReceivedAfternoon().getDuration() + ",");
                writer.write(data.getCallsReceivedEvening().getDuration() + ",");
                writer.write(data.getDurationCallsReceivedTime() + ",");
                writer.write(data.getCallsMadeMonday().getNum() + ",");
                writer.write(data.getCallsMadeTuesday().getNum() + ",");
                writer.write(data.getCallsMadeWednesday().getNum() + ",");
                writer.write(data.getCallsMadeThrusday().getNum() + ",");
                writer.write(data.getCallsMadeFriday().getNum() + ",");
                writer.write(data.getCallsMadeSaturday().getNum() + ",");
                writer.write(data.getCallsMadeSunday().getNum() + ",");
                writer.write(data.getCallsMadeWeekday() + ",");
                writer.write(data.getCallsMadeMonday().getDuration() + ",");
                writer.write(data.getCallsMadeTuesday().getDuration() + ",");
                writer.write(data.getCallsMadeWednesday().getDuration() + ",");
                writer.write(data.getCallsMadeThrusday().getDuration() + ",");
                writer.write(data.getCallsMadeFriday().getDuration() + ",");
                writer.write(data.getCallsMadeSaturday().getDuration() + ",");
                writer.write(data.getCallsMadeSunday().getDuration() + ",");
                writer.write(data.getDurationCallsMadeWeekday() + ",");
                writer.write(data.getCallsReceivedMonday().getNum() + ",");
                writer.write(data.getCallsReceivedTuesday().getNum() + ",");
                writer.write(data.getCallsReceivedWednesday().getNum() + ",");
                writer.write(data.getCallsReceivedThrusday().getNum() + ",");
                writer.write(data.getCallsReceivedFriday().getNum() + ",");
                writer.write(data.getCallsReceivedSaturday().getNum() + ",");
                writer.write(data.getCallsReceivedSunday().getNum() + ",");
                writer.write(data.getCallsReceivedWeekday() + ",");
                writer.write(data.getCallsReceivedMonday().getDuration() + ",");
                writer.write(data.getCallsReceivedTuesday().getDuration() + ",");
                writer.write(data.getCallsReceivedWednesday().getDuration() + ",");
                writer.write(data.getCallsReceivedThrusday().getDuration() + ",");
                writer.write(data.getCallsReceivedFriday().getDuration() + ",");
                writer.write(data.getCallsReceivedSaturday().getDuration() + ",");
                writer.write(data.getCallsReceivedSunday().getDuration() + ",");
                writer.write(data.getDurationCallsReceivedWeekday() + ",");
                writer.write(data.getCalledAntennas().keySet().size() + ",");
                writer.write(data.getReceivedAntennas().keySet().size() + ",");
                writer.write(data.getMostCalledAntenna() + ",");
                writer.write(data.getMostReceivedAntenna() + ",");
                writer.write(data.isMultiCaller() + ",");
                writer.write(String.valueOf(data.isMultiReceiver()));
                writer.write("\n");
            }
            writer.flush();
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
