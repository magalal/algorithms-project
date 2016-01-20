import java.util.LinkedList;
import java.util.List;


public class Person {
String name;
String job;
String company;
String address;
boolean visited;
boolean explored;
LinkedList<String> friend=new LinkedList<String>();
LinkedList<Person> friends_person=new LinkedList<>();
public Person(String name,String job,String company,String address){
	this.name=name;
	this.job=job;
	this.company=company;
	this.address=address;
}
public void addConnection(String pers){
	friend.add(pers);
}
public String namePerson(){
return name;
}
public LinkedList<Person> getfriends(Person[] p,int n){
	
	for(int i=0;i<this.friend.size();i++){
		for(int j=0;j<n;j++){
			if(friend.get(i).equals(p[j].name)){
				this.friends_person.add(p[j]);
			}	
		}
		
	}
	return friends_person;
	
}
}
