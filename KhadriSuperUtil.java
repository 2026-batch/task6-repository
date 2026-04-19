import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class KhadriSuperUtil{
	public static final String DIR = "customers/";

	private KhadriSuperUtil(){
		System.out.println("private constructor");
	}

	public static boolean isDecision(Scanner sc, boolean decision){

	     System.out.println("Do you want purchase items?(yes/no)");
  		 String isContinue = sc.next(); 

  		 if(isContinue.equalsIgnoreCase("yes")){
  		 	decision = true;
  		 }else if(isContinue.equalsIgnoreCase("no")){
  		 	decision = false;
  		 }

  		 return decision;
 	}
   public static boolean isExistsCustomer(long idenityity){
          Path path = Paths.get(DIR + idenityity + ".txt");//customers/8247053036.txt
          boolean isExists = Files.exists(path); 
          return isExists;
 	}
}