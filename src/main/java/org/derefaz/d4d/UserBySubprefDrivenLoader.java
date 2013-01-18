package org.derefaz.d4d;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.derefaz.d4d.reader.TSVReader;
import org.derefaz.d4d.user.antenna.Set2Loader;
import org.derefaz.d4d.user.antenna.UserByAntennaDrivenData;
import org.derefaz.d4d.user.comm.Set4Loader;
import org.derefaz.d4d.user.subpref.Set3Loader;
import org.derefaz.d4d.user.subpref.UserBySubprefDrivenData;

public class UserBySubprefDrivenLoader {

	static{
		System.setProperty("user.timezone", "Africa/Abidjan");
	}
	
	public static void main(String[] args) {
		TSVReader reader = new TSVReader();
		String baseDir = "/Users/cbadenes/Documents/tedeco/D4D/datasets";
		
		UserBySubprefDrivenData dataStore = new UserBySubprefDrivenData();
		// SET 3
		Set3Loader set3Loader = new Set3Loader();
		set3Loader.setStore(dataStore);

		System.out.println("reading SET3 " + new Date());
		Long start = System.currentTimeMillis();
		String SET3 = "SUBPREF_POS_SAMPLE_";
		String path = baseDir+"/"+SET3;
		List<String> instances = Arrays.asList(new String[]{"A","B","C","D","E","F","G","H","I","J"});
		for (String letter: instances){
			try {
				reader.read(path+letter+".tsv", set3Loader);
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
