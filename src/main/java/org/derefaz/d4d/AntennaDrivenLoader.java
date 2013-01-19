package org.derefaz.d4d;

import java.io.IOException;

import org.derefaz.d4d.antenna.AntennaDrivenData;
import org.derefaz.d4d.antenna.Set1Loader;
import org.derefaz.d4d.reader.TSVReader;

public class AntennaDrivenLoader {

    static {
        System.setProperty("user.timezone", "Africa/Abidjan");
    }

    public static void main(String[] args) {
        AntennaDrivenData dataStore = new AntennaDrivenData();
        TSVReader reader = new TSVReader();
        String baseDir = "/Users/cbadenes/Documents/tedeco/D4D/datasets";

        // SET1
        Set1Loader set1Loader = new Set1Loader();
        set1Loader.setStore(dataStore);

        System.out.println("reading SET1");
        Long start = System.currentTimeMillis();
        String SET1 = "SET1TSV_";
        String path = baseDir + "/" + SET1;
        for (int i = 0; i < 10; i++) {
            try {
                reader.read(path + i + ".tsv", set1Loader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(dataStore);
        System.out.println("Reading Elapsed time: " + (System.currentTimeMillis() - start) + "msecs");
        Long innerStart = System.currentTimeMillis();
        dataStore.generate("/Users/cbadenes/Desktop");
        System.out.println("Generating Elapsed time: " + (System.currentTimeMillis() - innerStart) + "msecs");
        System.out.println("Total Elapsed time: " + (System.currentTimeMillis() - start) + "msecs");
    }
}
