//package algorithms-project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
public class ReadFile {
	public Person [] p;
	HashMap<Person, Person> backtrackMap = new HashMap<>();
	public int NumberOfPersons;
	// this function to read from file 
	public void read(int n) throws IOException
	{
		NumberOfPersons = n;
		String read = null;	
		//this arr used to read line by line;
		ArrayList<String> arr=new ArrayList<String>();
		
		List<String> Persons = null;
		//this array of class Person used to add each person 
		p =new Person[n];
	
	
		try
		{
			//the path of file 
<<<<<<< HEAD
			Scanner sc=new Scanner(new File("C:/Users/mohamed/Desktop/file.txt"));
=======
			Scanner sc=new Scanner(new File("C:/Users/Ali/Desktop/file.txt"));
>>>>>>> Korayementality/master
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
		
		for(int j=n;j<n*2;j++){
			//add connection to exist persons
			Persons=Arrays.asList(arr.get(j).split("\\s*,\\s*"));
			//System.out.println(p[j-3]);
<<<<<<< HEAD
			p[j-n].friend.addAll(Persons);
=======
			p[j-n].friend_String.addAll(Persons);
>>>>>>> Korayementality/master
		}
	}
	public void test(){
		p[0].getfriends(p,NumberOfPersons);

		p[1].getfriends(p,NumberOfPersons);

		p[2].getfriends(p,NumberOfPersons);

		p[3].getfriends(p,NumberOfPersons);

		p[4].getfriends(p,NumberOfPersons);
		
		p[0].remove_node(p,0,0);
		System.out.println(p[0].friend_Person);
	}
	//searches for input name
	public boolean search(int s)
	{
		 Scanner sc=new Scanner(System.in);
		 boolean found = false;
	      System.out.println("Enter name to search");
	      String search=null;
	      search=sc.nextLine();
	     for(int i=0;i<s;i++){

	    	 if(search.equals(p[i].name)){
	    		found=true ;
	    	 }
	     }
	     sc.close();
		return found;
	}
	//returns total mutual friend_Strings
	public void mutualfriend_Strings(int s){
		Scanner sc=new Scanner(System.in);
		String first_name=null;
		String second_name=null;
		Person fp=null;
		Person sp=null;
		String friend_String;
		System.out.println("Enter first name to find number of mutual friend_Strings");
		first_name=sc.nextLine();
		System.out.println("Enter second name to find number of mutual friend_Strings");
		second_name=sc.nextLine();
		int sum=0;
		for(int i=0;i<s;i++){

	    	 if(first_name.equals(p[i].name)){
	    		 fp=p[i];
	    	 }
	    	 if(second_name.equals(p[i].name)){
	    		 sp=p[i];
	    	}
		}
		int amr=fp.friend_String.size();
		System.out.println(amr);
		String test_fp=null;
		String test_sp=null;
		for(int x=0;x<fp.friend_String.size();x++){
			
			for(int j=0;j<sp.friend_String.size();j++){
				test_fp=fp.friend_String.get(x);
				test_sp=sp.friend_String.get(j);
			if(fp.friend_String.get(x).equals(sp.friend_String.get(j))){
				
				sum++;
				break;
			}
			}
			
		}
		System.out.println("the mutual friend_Strings = "+sum);
	    
	}
	
	
	public void FindShortestPath(){
		//Find if both names exist, get their Person objects and pass them to BFS();
		Person firt_Person=null;
		Person second_Person=null; 
		Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter first person");
	      String first_String=null;
	      first_String=sc.nextLine();
		     for(int i=0;i<NumberOfPersons;i++){
		    	 if(first_String.equals(p[i].name)){
		    		 firt_Person=p[i];
		    	 }
		    	
		     }
		     if(firt_Person==null){
		    		System.out.println("This Person isn't in the Network");
		     }
		     System.out.println("Enter second person");
		      String second_String=null;
		      first_String=sc.nextLine();
			     for(int i=0;i<NumberOfPersons;i++){
			    	 if(first_String.equals(p[i].name)){
			    		 second_Person=p[i];
			    	 }
			     }
			     if(second_Person==null){
			    		System.out.println("This Person isn't in the Network");
			     }
			     BFS(firt_Person, second_Person);
		 
	}
	
	public void BFS(Person startPerson, Person endPerson)
	{
		Queue mainQ = new LinkedList<Person>();
		Queue updateQ = new LinkedList<Person>();
		LinkedList<Person> finalOutput = new LinkedList<Person>();
		mainQ.add(startPerson);
		Person temp = null;
		while(!mainQ.isEmpty())
		{
			temp = (Person) mainQ.poll();
			if(temp == endPerson)
			{
				finalOutput.add(temp);
				while(temp != startPerson){
					finalOutput.add(backtrackMap.get(temp));
					
					temp = (Person) finalOutput.getLast();
				}
			}
			
			if(temp.visited)
			{
				//temp = (Person) //
				mainQ.poll();
			}
			temp.friend_Person=temp.getfriends(p, 5);
			
			for (int i = 0; i < temp.friend_Person.size(); i++) {
				if(!temp.friend_Person.get(i).visited && !temp.friend_Person.get(i).explored)
				{
					temp.friend_Person.get(i).explored = true;
					mainQ.add(temp.friend_Person.get(i));
					backtrackMap.put(temp.friend_Person.get(i), temp);
				}
			}
		}
		for (int i =finalOutput.size()-2; i >=0; i--) {
			System.out.println(finalOutput.get(i).name);
		}
	}
<<<<<<< HEAD
*/
	
	LinkedList<Person> mincut1=new LinkedList<Person>();
	LinkedList<Person> mincut2=new LinkedList<Person>();
	int mincut=0;
	boolean index_avaliable=true;
	private Person[] persons;
	public void karager(LinkedList a,LinkedList b)
	{
		
		int index1,index2;
		int[] pickedIndexes = null;
		persons=p.clone();
		for (int i=0;i<Math.pow((p.length), 2)*((-Math.log(1-p.length))/p.length);i++)
		{
			//generating random no. between min and max value 
			//p.s i took this formula from internet 
			index1=	0 + (int)(Math.random() * ((p.length - 0) + 1));
			Person temp=p[index1];
			LinkedList temp_friends=temp.MutualFriends();
			//taking a random edge from this persons connnections 
			index2=	0 + (int)(Math.random() * ((temp_friends.size() - 0) + 1));
			
			//break the connection 
			String name_friend=persons[index1].friend.get(index2);
			persons[index1].friend.remove(index2);
			//index 1 is person a
			//index 2 is person b in friend list of a
			//remove conncetion from side of friend 
			for (int j=0;j<persons.length;j++)
			{
				//find friend in the persons list 
				if (persons[j].name.equals(name_friend))
				{
					//iterating inside the friend list of that person b to remove the 
					for (int k=0;k<persons[j].friend.size();k++)
					{
						if (persons[j].friend.get(k).equals(persons[index1].name))
						{
							persons[j].friend.remove(k);
							break;
						}
					}
					
				}
			}
			
			//merge to one of the lists 
			
			
		}
	}
=======
>>>>>>> Korayementality/master
}