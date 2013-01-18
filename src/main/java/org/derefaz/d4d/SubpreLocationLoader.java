package org.derefaz.d4d;

import java.io.IOException;

import org.derefaz.d4d.position.PositionStore;
import org.derefaz.d4d.reader.TSVReader;
import org.derefaz.d4d.user.comm.CommUserDrivenData;
import org.derefaz.d4d.user.comm.Set4Loader;

public class SubpreLocationLoader {

	static{
		System.setProperty("user.timezone", "Africa/Abidjan");
	}
	
	public static void main(String[] args) throws IOException {
		
		TSVReader reader = new TSVReader();
		String baseDir = "/Users/cbadenes/Documents/tedeco/D4D/datasets";
		PositionStore store = new PositionStore();
		
		// SUBPREF_POS_LONLAT.TSV
		String path = baseDir+"/SUBPREF_POS_LONLAT.TSV";
		Long start = System.currentTimeMillis();
		reader.read(path, store);
		System.out.println(store);
		System.out.println("Reading Elapsed time: " + (System.currentTimeMillis()-start) + "msecs");
		Long innerStart = System.currentTimeMillis();
		store.generate("/Users/cbadenes/Desktop/subpref_location.arff");
		System.out.println("Generating Elapsed time: " + (System.currentTimeMillis()-innerStart) + "msecs");
		System.out.println("Total Elapsed time: " + (System.currentTimeMillis()-start) + "msecs");
	}
}
