package org.derefaz.d4d;

import java.io.IOException;

import org.derefaz.d4d.reader.TSVReader;
import org.derefaz.d4d.user.antenna.Set2Loader;
import org.derefaz.d4d.user.antenna.UserByAntennaDrivenData;

public class UserByAntennaDrivenLoader {

	static{
		System.setProperty("user.timezone", "Africa/Abidjan");
	}
	
	public static void main(String[] args) {
		UserByAntennaDrivenData dataStore = new UserByAntennaDrivenData();
		TSVReader reader = new TSVReader();
		String baseDir = "/Users/cbadenes/Documents/tedeco/D4D/datasets";
		
		// SET2
		Set2Loader set2Loader = new Set2Loader();
		set2Loader.setStore(dataStore);
		
		System.out.println("reading SET2");
		Long start = System.currentTimeMillis();
		String SET2 = "POS_SAMPLE_";
		String path = baseDir+"/"+SET2;
		for (int i=0;i<10;i++){
			try {
				reader.read(path+i+".tsv", set2Loader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(dataStore);
		System.out.println("Reading Elapsed time: " + (System.currentTimeMillis()-start) + "msecs");
		Long innerStart = System.currentTimeMillis();
		dataStore.generate("/Users/cbadenes/Desktop");
		System.out.println("Generating Elapsed time: " + (System.currentTimeMillis()-innerStart) + "msecs");
		System.out.println("Total Elapsed time: " + (System.currentTimeMillis()-start) + "msecs");
	}
}
