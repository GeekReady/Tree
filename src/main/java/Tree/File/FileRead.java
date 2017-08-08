/**
 * 
 */
package Tree.File;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {
	private StringBuffer storeRecords;

	public void setRecordsOfFile(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			StringBuffer records = new StringBuffer("");
			while (line != null) {
				records.append(line).append(System.getProperty("line.separator"));
				line = br.readLine();
			}
			setStoreRecords(records.toString());
		} catch (Exception ex) {
			setStoreRecords("");
		}
	}
	public String getStoreRecords() {
		return storeRecords.toString();
	}

	public void setStoreRecords(String storeRecords) {
		this.storeRecords = new StringBuffer(storeRecords);
	}
	
}
