package org.derefaz.d4d;

import java.io.IOException;

import org.derefaz.d4d.reader.TSVReader;
import org.derefaz.d4d.user.comm.CommUserDrivenData;
import org.derefaz.d4d.user.comm.Set4Loader;

public class CommUserDrivenLoader {

	static{
		System.setProperty("user.timezone", "Africa/Abidjan");
	}
	
	public static void main(String[] args) {
		CommUserDrivenData dataStore = new CommUserDrivenData();
		TSVReader reader = new TSVReader();
		String baseDir = "/Users/cbadenes/Documents/tedeco/D4D/datasets";
		
		// SET 4
		Set4Loader set4Loader = new Set4Loader();
		set4Loader.setStore(dataStore);
		
		System.out.println("reading SET4");
		Long start = System.currentTimeMillis();
		String SET4 = "GRAPHS_";
		String path = baseDir+"/"+SET4;
		for (int i=0;i<10;i++){
			try {
				reader.read(path+i+".tsv", set4Loader);
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
