import java.util.LinkedList;
import java.util.List;


public class Person {
String name;
String job;
String company;
String address;
LinkedList<String> friend=new LinkedList<String>();
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
}
