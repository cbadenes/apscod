package org.derefaz.d4d.user.comm;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;


public class CommUserDrivenData {

	private HashMap<String, CommUserDrivenRow> userData;
	
	public CommUserDrivenData() {
		this.userData = new HashMap<>();
	}
	
	public boolean exists(String _id){
		return this.userData.containsKey(_id);
	}
	
	public CommUserDrivenRow get(String _id){
		return this.userData.get(_id);
	}
	
	public CommUserDrivenData put(CommUserDrivenRow _row){
		this.userData.put(_row.getUserId(), _row);
		return this;
	}
	
	@Override
	public String toString() {
		return this.userData.keySet().size() + " users recorded!!";
	}
	
	public void generate(String _baseDir) {
		try {
			String filePath = _baseDir + "/comm_user_driven_data.arff";
			System.out.println("creating file: " + filePath + "...");
			FileOutputStream outputStream = new FileOutputStream(filePath);
			
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));

			writer.write("% 1. Title: Communication User Driven Dataset\n");
			writer.write("% \n");
			writer.write("% 2. Sources:\n");
			writer.write("%      (a) Creator: C. Badenes\n");
			writer.write("%      (b) Communication Subgraph\n");
			writer.write("%      (c) Orange D4D\n");
			writer.write("%      (d) Date: January, 2013\n");
			writer.write("% \n");
			writer.write("@RELATION comm-user\n");
			writer.write("\n");
			writer.write("@ATTRIBUTE user_id NUMERIC\n");
			writer.write("@ATTRIBUTE num_calls_made NUMERIC\n");
			writer.write("@ATTRIBUTE num_calls_received NUMERIC\n");
			writer.write("@ATTRIBUTE num_called_phonenumber NUMERIC\n");
			writer.write("@ATTRIBUTE num_received_phonenumber NUMERIC\n");
			writer.write("@ATTRIBUTE caller {multiuser, monouser}\n");
			writer.write("@ATTRIBUTE receiver {multiuser, monouser}\n");
			writer.write("@ATTRIBUTE num_called_not_received_phonenumber NUMERIC\n");
			writer.write("@ATTRIBUTE num_received_not_called_phonenumber NUMERIC\n");
			writer.write("@ATTRIBUTE most_called_phonenumber NUMERIC\n");
			writer.write("@ATTRIBUTE most_received_phonenumber NUMERIC\n");
			writer.write("@ATTRIBUTE caller_not_receiver {true, false}\n");
			writer.write("@ATTRIBUTE receiver_not_called {true, false}\n");
			writer.write("\n");
			writer.write("@DATA\n");
			writer.write("\n");
			Integer index = 0;
			Integer limit = this.userData.keySet().size();
			for (String key : this.userData.keySet()) {
				System.out.println("write record [" + index+++"|"+limit+"]");
				CommUserDrivenRow data = this.userData.get(key);
				writer.write(data.getUserId()+",");
				writer.write(data.getNumCallsMade()+",");
				writer.write(data.getNumCallsReceived()+",");
				writer.write(data.getNumCalledPhoneNumber()+",");
				writer.write(data.getNumReceivedPhoneNumber()+",");
				writer.write(data.getCaller()+",");
				writer.write(data.getReceiver().name()+",");
				writer.write(data.getNumCalledNotReceivedPhoneNumber()+",");
				writer.write(data.getNumReceivedNotCalledPhoneNumber()+",");
				writer.write(data.getMostCalledPhoneNumber()+",");
				writer.write(data.getMostReceivedPhoneNumber()+",");
				writer.write(data.isCallerNotReceiver()+",");
				writer.write(data.isReceiverNotCalled()+"");
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
