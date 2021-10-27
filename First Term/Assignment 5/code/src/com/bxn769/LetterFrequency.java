package com.bxn769;

import java.io.*;
import java.util.*;

public class LetterFrequency{
	
	Map<Character, Float> frequencyMap = new HashMap<Character, Float>();
	HashMap sortedHashMap = new LinkedHashMap();
	
	public LetterFrequency(File cipherFile) throws FileNotFoundException, IOException{

		//map letter to frequency
        File file = cipherFile;
        Scanner scanner = new Scanner(file,"utf-8");
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toLowerCase().toCharArray();
            for (Character c : chars) {
                if(!Character.isLetter(c)){
                    continue;
                }
                else if (frequencyMap.containsKey(c)) {
                    frequencyMap.put(c, frequencyMap.get(c) + 1.0f);
                } else {
                    frequencyMap.put(c, 1.0f);
                }
            }
        }
        
		//convert frequency to percentage
		Float charCount = 0.0f;
		for (Map.Entry<Character, Float> entry : frequencyMap.entrySet()){
			charCount += entry.getValue();
		}
		for (Map.Entry<Character, Float> entry : frequencyMap.entrySet()){
			Character key = entry.getKey();
			Float value = entry.getValue();
			value = (value / charCount) *100.0f;
			frequencyMap.put(key, value);
		}
		
		//sort hashMap in order

        List list = new LinkedList(frequencyMap.entrySet());
       
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o1)).getValue())
                  .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        
        for (Iterator it = list.iterator(); it.hasNext();) {
              Map.Entry entry = (Map.Entry) it.next();
              sortedHashMap.put(entry.getKey(), entry.getValue());
        } 
        
	}
	
	public Map getMap(){
		return sortedHashMap;
	}
	
}