//package algorithms-project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class ReadFile {
	// this function to read from file 
	public void read(int n) throws IOException{
	
		String read = null;	
		//this arr used to read line by line;
		ArrayList<String> arr=new ArrayList<String>();
		
		List<String> Persons = null;
		//this array of class Person used to add each person 
		Person [] p =new Person[n];
	
	
		try
		{
			//the path of file 
			Scanner sc=new Scanner(new File("C:/Users/tarek/Desktop/file.txt"));
			//this help to split any comma or space
			sc.useDelimiter(",\\s*");
			//read line by line 
			 
			for(int i=0;i<n*2+2;i++){
				
				if(sc.hasNextLine()){
					read=sc.nextLine();
					
					//In the txt file there is two empty line to seperate between new person and the connections		
					if(!read.isEmpty()){
						arr.add(read);
					}
				}
			}
		 
			sc.close();
			//add persons to the class Person
			for(int a=0;a<n;a++){
				//use split() to remove comma or space 
				Persons=Arrays.asList(arr.get(a).split("\\s*,\\s*"));
				//add each person 
				p[a]=new Person(Persons.get(0),Persons.get(1), Persons.get(2),Persons.get(3));
			}
	
		}
	
		catch(IOException ioe){
		
			ioe.printStackTrace();
		}
		//clear Persons array
		Persons=null;
		
		for(int j=3;j<n*2;j++){
			//add connection to exist persons
			Persons=Arrays.asList(arr.get(j).split("\\s*,\\s*"));
			
			p[j-3].friend.addAll(Persons);
		}
	}

}