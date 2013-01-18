package org.derefaz.d4d;

import java.io.IOException;

import org.derefaz.d4d.position.PositionStore;
import org.derefaz.d4d.reader.TSVReader;
import org.derefaz.d4d.user.comm.CommUserDrivenData;
import org.derefaz.d4d.user.comm.Set4Loader;

public class AntennaLocationLoader {

	static{
		System.setProperty("user.timezone", "Africa/Abidjan");
		System.setProperty("file.encoding", "UTF-8");
	}
	
	public static void main(String[] args) throws IOException {
		
		TSVReader reader = new TSVReader();
		PositionStore store = new PositionStore();
		
		// ANT_POS.TSV
		String path = "/Users/cbadenes/Documents/tedeco/D4D/datasets/ANT_POS.TSV";
		Long start = System.currentTimeMillis();
		reader.read(path, store);
		System.out.println(store);
		System.out.println("Reading Elapsed time: " + (System.currentTimeMillis()-start) + "msecs");
		Long innerStart = System.currentTimeMillis();
		store.generate("/Users/cbadenes/Desktop/antenna_location.arff");
		System.out.println("Generating Elapsed time: " + (System.currentTimeMillis()-innerStart) + "msecs");
		System.out.println("Total Elapsed time: " + (System.currentTimeMillis()-start) + "msecs");
	}
}
