package edu.csula.cs460.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.google.common.collect.Lists;

public class ListFile {
    private Map<String, List<String>> adjancencyList;

    @SuppressWarnings("null")
	public ListFile(String filepath) {
        // TODO: read file from filepath ('exercise-1/list-1.txt' for
        // example) and parse line by line to fill out adjancencyList
    	try {
			BufferedReader br = new BufferedReader( new FileReader("src/main/resources/exercise-1/list-1.txt"/*+filepath*/));
			
			String line = br.readLine();
			while(line != null){
				List<String> list = new ArrayList<String>();
				String[] lineChanger = line.replaceAll("\\:", " ").split(" ");
				for(int i = 1; i < lineChanger.length; i++){
					System.out.println(lineChanger[i]);
					System.out.println(lineChanger[0] + " <-- AYE: " + i);
					list.add(lineChanger[i]);
				}
				System.out.println(list.toString() + " LISTO");
				adjancencyList.put(lineChanger[0], list);
				System.out.println(adjancencyList.containsKey("a") + " ZE MAP");
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    public List<String> getList(String key) {
        // TODO: get List of String for specific key
        return adjancencyList.get(key);
    }
}
