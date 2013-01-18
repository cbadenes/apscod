package org.derefaz.d4d.antenna;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.derefaz.d4d.reader.ARFFReader;
import org.derefaz.d4d.reader.LineHandler;

public class AntennaPositions implements LineHandler {
	
	HashMap<String,AntennaInfo> byAntenna;
	HashMap<String,Integer> byCountry;
	HashMap<String,Integer> byAdminArea1;
	HashMap<String,Integer> byAdminArea2;
	
	public AntennaPositions() {
		this.byAdminArea1 	= new HashMap<>();
		this.byAdminArea2 	= new HashMap<>();
		this.byCountry		= new HashMap<>();
		this.byAntenna		= new HashMap<>();
	}
	
	public void read(String _filePath) throws IOException{
		ARFFReader reader = new ARFFReader();
		reader.read(_filePath, this);
	}

	@Override
	public void load(StringTokenizer _tokenizer) {
		String id 	= _tokenizer.nextToken();
		String lat	= _tokenizer.nextToken();
		String lng	= _tokenizer.nextToken();
		String adminArea2	= _tokenizer.nextToken();
		String adminArea1	= _tokenizer.nextToken();
		String country		= _tokenizer.nextToken();
		
		AntennaInfo antennaInfo = new AntennaInfo.Builder().withId(id).withLat(lat).
				withLng(lng).withAdminArea1(adminArea1).withAdminArea2(adminArea2).withCountry(country).build();
		this.byAntenna.put(id, antennaInfo);
		this.byAdminArea2.put(adminArea2, this.byAdminArea2.containsKey(adminArea2)? this.byAdminArea2.get(adminArea2)+1 : 1);
		this.byAdminArea1.put(adminArea1, this.byAdminArea1.containsKey(adminArea1)? this.byAdminArea1.get(adminArea1)+1 : 1);
		this.byCountry.put(country, this.byCountry.containsKey(country)? this.byCountry.get(country)+1 : 1);
	}
	
	public void summary(){
		System.out.println(new ArrayList(this.byAdminArea2.keySet()));
		System.out.println(new ArrayList(this.byAdminArea1.keySet()));
		System.out.println(new ArrayList(this.byCountry.keySet()));
	}
	
	public AntennaInfo	getInfo(String _id){
		return this.byAntenna.get(_id);
	}
	
	public static void main(String[] args) throws IOException {
		AntennaPositions positions = new AntennaPositions();
		positions.read("/Users/cbadenes/Desktop/antenna_location.arff");
		positions.summary();
	}
	
}
