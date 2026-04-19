import java.util.Scanner;

public class KhadriSuperUtil{
	

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

}