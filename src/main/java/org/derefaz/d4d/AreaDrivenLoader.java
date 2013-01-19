package org.derefaz.d4d;

import java.io.IOException;

import org.derefaz.d4d.antenna.AntennaPositions;
import org.derefaz.d4d.area.AreaDrivenData;

public class AreaDrivenLoader {

    static {
        System.setProperty("user.timezone", "Africa/Abidjan");
    }

    public static void main(String[] args) throws IOException {
        AntennaPositions antennaPositions = new AntennaPositions();
        antennaPositions.read("/Users/cbadenes/Desktop/antenna_location.arff");
        String antennaDrivenDataPath = "/Users/cbadenes/Desktop/antenna_driven_data.arff";
        Long start = System.currentTimeMillis();
        AreaDrivenData dataStore = new AreaDrivenData(antennaDrivenDataPath, antennaPositions);
        System.out.println(dataStore);
        System.out.println("Reading Elapsed time: " + (System.currentTimeMillis() - start) + "msecs");
        Long innerStart = System.currentTimeMillis();
        dataStore.generate("/Users/cbadenes/Desktop");
        System.out.println("Generating Elapsed time: " + (System.currentTimeMillis() - innerStart) + "msecs");
        System.out.println("Total Elapsed time: " + (System.currentTimeMillis() - start) + "msecs");
    }
}
