package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class CSVFile {

	File csvFile = null;
	BufferedWriter csvWriter = null;

	//创建一个File
	public File createCsvFile(String fileName) {

		if (fileName == null || fileName.isEmpty()) {
			return null;
		}
		String csvFileName = fileName + ".csv";

		csvFile = new File(csvFileName);
		File parent = csvFile.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdirs();
		}

		try {
			csvFile.createNewFile();
			// GB2312使正确读取分隔符","
	        csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
	                csvFile), "GB2312"), 1024);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		return csvFile;
	}

	public void closeCsvFile() {

		if (csvWriter == null) {
			return;
		}

		try {
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeRow(List<Object> dataList){
		
//		if (csvWriter != null){
//			   try {
//	                csvWriter.close();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//		}
//		
		 try {
	
		
        for (Object data : dataList) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\t").append(data).append("\t").toString();
				csvWriter.write(rowStr);
			}
			csvWriter.newLine();

		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	


}
