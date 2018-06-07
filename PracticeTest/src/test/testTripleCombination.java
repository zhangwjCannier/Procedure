package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.CSVFile;
import util.TripleCombination;

public class testTripleCombination {
	
	public static void main(String[] args){
		TripleCombination tripleCom = new TripleCombination();
		CSVFile csvFile = new CSVFile();
		
		int naturalNumber = 31;
		String fileName="31Combination";
		List<List<Object>>combinationList =  new ArrayList<List<Object>>();
				
		tripleCom.setNaturalNumber(naturalNumber);
		combinationList = tripleCom.getCombinationList();					//获取数字的组合信息
		
		csvFile.createCsvFile(fileName);
		Object[] head = {"数字1", "数字2", "数字3", "平均值", "出现概率" };
        List<Object> headList = Arrays.asList(head);
        csvFile.writeRow(headList);					//写文件
        
        
		for(List<Object> tempList: combinationList ){
			
			csvFile.writeRow(tempList);					//写文件
			
			//System.out.println(tempList.get(0) + "\t" +tempList.get(1)+ "\t" +tempList.get(2)+ "\t" +tempList.get(3)+ "\t" +tempList.get(4));
		}
		
		csvFile.closeCsvFile();     //关闭输入流
		
	}

	 

}
