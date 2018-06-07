package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TripleCombination {
	
	private  int naturalNumber;
	private int total;

	private List<List<Object>> combinationList;
	private Map<Object, Object>probablity;

	
	public int getNaturalNumber() {
		return naturalNumber;
	}

	public void setNaturalNumber(int naturalNumber) {
		this.naturalNumber = naturalNumber;
		total = naturalNumber *(naturalNumber - 1) * (naturalNumber-2) / 3 /2;
	}
	
	public List<List<Object>> getCombinationList(){
		if(naturalNumber <= 3){
			return null;    // please input a number bigger than 3
		}
	
		probablity = new HashMap<Object, Object>();
		combinationList = new ArrayList<List<Object>>();
		for(int i = 1; i <= naturalNumber-2; i++){
			
			for(int j=i+1; j <= naturalNumber-1; j++){
				
				for  (int k = j+1; k<=naturalNumber; k++){
					
					double average =(double) (i+j+k)/3;
					List<Object> tempList = new ArrayList<Object>() ;
					tempList.add(i);
					tempList.add(j);
					tempList.add(k);
					tempList.add(average);
					
					if(probablity.containsKey(average)){
						int value = (int)probablity.get(average);
						probablity.put(average, value+1);
					}else{
						probablity.put(average, 1);
					}
					
					combinationList.add(tempList);

				}
			}
		}
		
		for(List<Object> tempList:combinationList){
			
			if(probablity.containsKey(tempList.get(3))){
				int values  =(int)  probablity.get(tempList.get(3));
				double prob =(double) values / (double)total;
				tempList.add(prob);
			}
			
			
		}
		return combinationList;
	}
	
	

}
