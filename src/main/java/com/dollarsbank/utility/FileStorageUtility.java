package com.dollarsbank.utility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorageUtility {

	private int fileCount = 0;
	public boolean saveFile(String userId, String text) {

		++fileCount;

		try {
			String fileName = "BankStub-" + userId + "-" + fileCount + ".txt" ;
			File myObj = new File(fileName);
			if (myObj.createNewFile()) {
				if(!writeFile(fileName,text))
					System.out.println("failed to write to file");
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}

	public boolean writeFile(String fileName, String text) {
		 try {
		      FileWriter fw = new FileWriter(fileName);
		      fw.write(text);
		      fw.close();

		      return true;
		 } catch (IOException e) {
			 return false;
		 }
	}
}
