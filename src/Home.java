import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class Home {
   // public void search(){
   public static void main (String args[]) throws FileNotFoundException, IOException {
	   //new Class from readFile
      ReadFile readFromFile = new ReadFile();
      String search=null;
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter number of persons");
      int x=sc.nextInt();
      
      try {
    	// this function to read from file
        readFromFile.read(x);
          
        readFromFile.search(x);
          
         // readFromFile.mutualFriends(x);
         // readFromFile.returnfriendlist(name)
          
          
       } catch (IOException e) {
           e.printStackTrace();
       }   
   }
}
