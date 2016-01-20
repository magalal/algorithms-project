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
	public Person [] p;
	// this function to read from file 
	public void read(int n) throws IOException
	{
	
		String read = null;	
		//this arr used to read line by line;
		ArrayList<String> arr=new ArrayList<String>();
		
		List<String> Persons = null;
		//this array of class Person used to add each person 
		p =new Person[n];
	
	
		try
		{
			//the path of file 
			Scanner sc=new Scanner(new File("C:/Users/mohamed/Desktop/file.txt"));
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
			p[j-n].friend.addAll(Persons);
		}
	}
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
	public void mutualFriends(int s){
		Scanner sc=new Scanner(System.in);
		String first_name=null;
		String second_name=null;
		Person fp=null;
		Person sp=null;
		String friend;
		System.out.println("Enter first name to find number of mutual friends");
		first_name=sc.nextLine();
		System.out.println("Enter second name to find number of mutual friends");
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
		int amr=fp.friend.size();
		System.out.println(amr);
		String test_fp=null;
		String test_sp=null;
		for(int x=0;x<fp.friend.size();x++){
			
			for(int j=0;j<sp.friend.size();j++){
				test_fp=fp.friend.get(x);
				test_sp=sp.friend.get(j);
			if(fp.friend.get(x).equals(sp.friend.get(j))){
				
				sum++;
				break;
			}
			}
			
		}
		System.out.println("the mutual friends = "+sum);
	    
	}
	/*
	public LinkedList returnfriendlist(String name)
	{
		LinkedList x=new LinkedList<Person>();;
		int index=0;
		for (int i=0;i<p.length;i++)
		{
			if (p[i].equals(name))
			{
				index=i;
				break;
			}
		}
		
		for (int i=0;i<p[index].friend.size();i++)
		{
			for (int j=0;j<p.length;j++)
			{
				if (p[j].friend.get(j))
				x.add(p[index].friend.get(i));
			}
			System.out.println(p[index].friend.get(i).);
		}
		
		return x;
	}
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
}