package org.derefaz.d4d.position;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.derefaz.d4d.google.Address;
import org.derefaz.d4d.google.Coordinates;
import org.derefaz.d4d.google.LocationClient;
import org.derefaz.d4d.google.LocationResponse;
import org.derefaz.d4d.position.PositionRow.Builder;
import org.derefaz.d4d.reader.LineHandler;
import org.derefaz.d4d.user.antenna.UserByAntennaDrivenRow;

public class PositionStore implements LineHandler {

	private List<PositionRow> rows;
	HashMap<String,Integer> byCountry;
	HashMap<String,Integer> byAdminArea1;
	HashMap<String,Integer> byAdminArea2;
	
	public PositionStore() {
		this.rows = new ArrayList<PositionRow>();
		this.byAdminArea1 = new HashMap<>();
		this.byAdminArea2 = new HashMap<>();
		this.byCountry= new HashMap<>();
	}
	
	@Override
	public void load(StringTokenizer _tokenizer) {
		 Builder row = new PositionRow.Builder().
				withId(Integer.valueOf(_tokenizer.nextToken())).
				withLng(Double.valueOf(_tokenizer.nextToken())).
				withLat(Double.valueOf(_tokenizer.nextToken()));
		
		
		try {
			Thread.sleep(200);
			Coordinates coordinates = new Coordinates();
			coordinates.setLat(row.getLat());
			coordinates.setLng(row.getLng());
			LocationResponse location = LocationClient.request(coordinates);
			Address address = location.getMinimun(coordinates);
			row.withAddress(address);
		} catch (Exception e) {
			System.out.println("Request error to google location service");
			e.printStackTrace();
		}
		PositionRow position = row.build();
		this.byCountry.put(position.getCountry(), 0);
		this.byAdminArea2.put(position.getAdminAreaLevel2(), 0);
		this.byAdminArea1.put(position.getAdminAreaLevel1(), 0);
		this.rows.add(position);
		
	}

	public void generate (String _file){
		try {
			System.out.println("creating file: " + _file + "...");
			FileOutputStream outputStream = new FileOutputStream(_file);
			
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));

			writer.write("% 1. Title: Subpref Location Dataset\n");
			writer.write("% \n");
			writer.write("% 2. Sources:\n");
			writer.write("%      (a) Creator: C. Badenes\n");
			writer.write("%      (b) Orange D4D\n");
			writer.write("%      (d) Date: January, 2013\n");
			writer.write("% \n");
			writer.write("@RELATION subpref\n");
			writer.write("\n");
			writer.write("@ATTRIBUTE subpref_id NUMERIC\n");
			writer.write("@ATTRIBUTE lat NUMERIC\n");
			writer.write("@ATTRIBUTE long NUMERIC\n");
			writer.write("@ATTRIBUTE area {"+new ArrayList(this.byAdminArea2.keySet()).toString().replaceAll("\\]", "").replaceAll("\\[", "")   +"}\n");
			writer.write("@ATTRIBUTE region {"+new ArrayList(this.byAdminArea1.keySet()).toString().replaceAll("\\]", "").replaceAll("\\[", "")   +"}\n");
			writer.write("@ATTRIBUTE country {"+new ArrayList(this.byCountry.keySet()).toString().replaceAll("\\]", "").replaceAll("\\[", "")   +"}\n");
			writer.write("\n");
			writer.write("@DATA\n");
			writer.write("\n");
			Integer index = 0;
			Integer limit = this.rows.size();
			for (PositionRow data : this.rows) {
				System.out.println("write record [" + index+++"|"+limit+"]");
				writer.write(data.getId()+",");
				writer.write(data.getLat()+",");
				writer.write(data.getLng()+",");
				writer.write(data.getAdminAreaLevel2()+",");
				writer.write(data.getAdminAreaLevel1()+",");
				writer.write(data.getCountry());
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
