import java.util.LinkedList;
import java.util.List;


public class Person {
String name;
String job;
String company;
String address;
boolean visited=false;
boolean explored=false;
LinkedList<String> friend_String=new LinkedList<String>();
LinkedList<Person> friend_Person=new LinkedList<Person>();
public Person(String name,String job,String company,String address){
	this.name=name;
	this.job=job;
	this.company=company;
	this.address=address;
}
public void addConnection(String pers){
	friend_String.add(pers);
}
public String namePerson(){
return name;
}
public LinkedList<Person> getfriends(Person[] p,int n){
	
	for(int i=0;i<this.friend_String.size();i++){
		for(int j=0;j<n;j++){
			if(friend_String.get(i).equals(p[j].name)){
				this.friend_Person.add(p[j]);
			}	
		}
		
	}
	return friend_Person;
	
}
public void remove_node(Person[] p,int person_Index ,int friend_Index){
	Person friend_Person=p[person_Index].friend_Person.get(friend_Index);
	String friend_name=friend_Person.name;
	p[person_Index].friend_Person.remove(friend_Index);
	for(int j=0;j<p.length;j++){
		if(friend_name.equals(p[j].name)){
			for(int i=0;i<p[j].friend_Person.size();i++){
				if (p[j].friend_Person.get(i).equals(friend_name)) {
					p[j].friend_Person.remove();
				}
			}
		}	
	}
	
}
}
