package com.bxn769;

import java.io.*;
import java.util.*;

public class Model{
	
	public void rankedEncryption(File frequencyFile, File cipherFile) throws FileNotFoundException, IOException{
		System.out.println(frequencyFile.getAbsolutePath());
		System.out.println(cipherFile.getAbsolutePath());
		
		ArrayList<String> letterFrequencyList = new ArrayList<String>();
		Map<Character, Float> cipherFrequencyMap = new HashMap<Character, Float>();
        
		try(BufferedReader br = new BufferedReader(new FileReader(frequencyFile))){
			String line;
			while ((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				String letter = parts[0];
				
				letterFrequencyList.add(letter);
			}
		}
	
		
		LetterFrequency cipherFrequency = new LetterFrequency(cipherFile);
		cipherFrequencyMap = cipherFrequency.getMap();
		
		List<Character> indexes = new ArrayList<Character>(cipherFrequencyMap.keySet());
		Collections.reverse(indexes);
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(cipherFile));
			PrintWriter out = new PrintWriter(("output.txt"),"utf-8");
			
			String line;
			while ((line = in.readLine()) != null){
				String[] parts = line.split("");
				for (String s : parts){
					Character c = s.charAt(0);
					Character plaintext;
					if (cipherFrequencyMap.containsKey(c)){
						int cipherPos = indexes.indexOf(c);
						plaintext = (letterFrequencyList.get(cipherPos)).charAt(0);
					}else{
						plaintext = c;
					}
					out.println(plaintext);
					
				}
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
						
	}
	
	public void nearestEncryption(File frequencyFile, File cipherFile) throws FileNotFoundException, IOException{
		System.out.println(frequencyFile.getAbsolutePath());
		System.out.println(cipherFile.getAbsolutePath());
		
		Map<Character, Float> letterFrequencyMap = new HashMap<Character, Float>();
		Map<Character, Float> cipherFrequencyMap = new HashMap<Character, Float>();
        
		try(BufferedReader br = new BufferedReader(new FileReader(frequencyFile))){
			String line;
			while ((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				Character letter = (parts[0]).charAt(0);
				Float num = Float.valueOf(parts[1]);
				
				letterFrequencyMap.put(letter, num);
			}
		}
	
		
		LetterFrequency cipherFrequency = new LetterFrequency(cipherFile);
		cipherFrequencyMap = cipherFrequency.getMap();
		
		List<Character> indexes = new ArrayList<Character>(cipherFrequencyMap.keySet());
		Collections.reverse(indexes);
		
		List<Character> letterIndexes = new ArrayList<Character>(letterFrequencyMap.keySet());
		Collections.reverse(letterIndexes);
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(cipherFile));
			PrintWriter out = new PrintWriter(("output.txt"),"utf-8");
			
			String line;
			while ((line = in.readLine()) != null){
				String[] parts = line.split("");
				for (String s : parts){
					Character c = s.charAt(0);
					Character plaintext;
					if (cipherFrequencyMap.containsKey(c)){
						int cipherPos = indexes.indexOf(c);
						plaintext = (letterIndexes.get(cipherPos));
					}else{
						plaintext = c;
					}
					out.println(plaintext);
					
				}
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}