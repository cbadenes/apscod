package org.derefaz.d4d.user.antenna;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class UserByAntennaDrivenData {

    private final HashMap<String, UserByAntennaDrivenRow> userData;

    public UserByAntennaDrivenData() {
        this.userData = new HashMap<>();
    }

    public boolean exists(String _id) {
        return this.userData.containsKey(_id);
    }

    public UserByAntennaDrivenRow get(String _id) {
        return this.userData.get(_id);
    }

    public UserByAntennaDrivenData put(UserByAntennaDrivenRow _row) {
        this.userData.put(_row.getUserId(), _row);
        return this;
    }

    @Override
    public String toString() {
        return this.userData.keySet().size() + " users recorded!!";
    }

    public void generate(String _baseDir) {
        try {
            String filePath = _baseDir + "/user_by_antenna_driven_data.arff";
            System.out.println("creating file: " + filePath + "...");
            FileOutputStream outputStream = new FileOutputStream(filePath);

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));

            writer.write("% 1. Title: User By Antenna Driven Dataset\n");
            writer.write("% \n");
            writer.write("% 2. Sources:\n");
            writer.write("%      (a) Creator: C. Badenes\n");
            writer.write("%      (b) Individual Trajectories: High Spatial Resolution Data\n");
            writer.write("%      (c) Orange D4D\n");
            writer.write("%      (d) Date: January, 2013\n");
            writer.write("% \n");
            writer.write("@RELATION user-antenna\n");
            writer.write("\n");
            writer.write("@ATTRIBUTE user_id NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE mean_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_holiday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made_working NUMERIC\n");
            writer.write("@ATTRIBUTE day_of_calls_made {holiday, working}\n");
            writer.write("@ATTRIBUTE num_calls_morning NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_afternoon NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_evening NUMERIC\n");
            writer.write("@ATTRIBUTE time_of_calls_made {morning, afternoon, evening}\n");
            writer.write("@ATTRIBUTE num_calls_monday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_tuesday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_wednesday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_thrusday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_friday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_saturday NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_sunday NUMERIC\n");
            writer.write("@ATTRIBUTE weekday_of_calls_made {monday, tuesday, wednesday, thrusday, friday, saturday, sunday}\n");
            writer.write("@ATTRIBUTE num_antennas NUMERIC\n");
            writer.write("@ATTRIBUTE most_used_antenna NUMERIC\n");
            writer.write("@ATTRIBUTE antenna_relationship NUMERIC\n");
            writer.write("\n");
            writer.write("@DATA\n");
            writer.write("\n");
            Integer index = 0;
            Integer limit = this.userData.keySet().size();
            for (String key : this.userData.keySet()) {
                System.out.println("write record [" + index++ + "|" + limit + "]");
                UserByAntennaDrivenRow data = this.userData.get(key);
                writer.write(data.getUserId() + ",");
                writer.write(data.getNumCallsMade() + ",");
                writer.write(data.getMeanCallsMade() + ",");
                writer.write(data.getNumCallsHolidays() + ",");
                writer.write(data.getNumCallsWorking() + ",");
                writer.write(data.getDay().name() + ",");
                writer.write(data.getNumCallsMorning() + ",");
                writer.write(data.getNumCallsAfternoon() + ",");
                writer.write(data.getNumCallsEvening() + ",");
                writer.write(data.getTime().name() + ",");
                writer.write(data.getNumCallsMonday() + ",");
                writer.write(data.getNumCallsTuesday() + ",");
                writer.write(data.getNumCallsWednesday() + ",");
                writer.write(data.getNumCallsThursday() + ",");
                writer.write(data.getNumCallsFriday() + ",");
                writer.write(data.getNumCallsSaturday() + ",");
                writer.write(data.getNumCallsSunday() + ",");
                writer.write(data.getWeekday().name() + ",");
                writer.write(data.getNumAntennas() + ",");
                writer.write(data.getMostUsedAntenna() + ",");
                writer.write(data.getAntennaRelationship());
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
