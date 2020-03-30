package uvsq21602357;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SaisieRPN extends MoteurRPN {
	
	
	public SaisieRPN() 
    {   
		int TMIN=-2147483648;
		int TMAX=2147483647;
		
    	String str = "debut";
		  int i = 0;
		  while(i != 1)
		  {
			  Scanner sc = new Scanner(System.in);
			  System.out.println("**Saisir op�rande/op�ration:");
	
			  
			 str = sc.nextLine();
			  
			  
			  System.out.println("**Vous avez saisi : " + str);
			  if(str.equals("Exit")) {i = 1;}
			  else if(str.equals("+") || str.equals("PLUS")) 
			  { 	try {
			       double x = resOperation(Operation.PLUS);
			       System.out.println(x);
			  		}catch(DivisionZeroException d) {}
			  }
			  else if(str.equals("-") || str.equals("MOINS")) 
			  {
				  try {
				  double x = resOperation(Operation.MOINS);
			       System.out.println(x);
			  		}catch(DivisionZeroException d) {}
			  }
			  else if(str.equals("*") || str.equals("MULT")) 
			  {
				  try {
				  double x = resOperation(Operation.MULT);
			       System.out.println(x);
			  		}catch(DivisionZeroException d) {}
			  }
			  else if(str.equals("/") || str.equals("DIV")) 
			  {
				  try {
				  double x = resOperation(Operation.DIV);
			       System.out.println(x);
			  	}catch(DivisionZeroException d) {}
			  }
			  else if(str.matches("^-?\\d+$")){
				  try {
				  int x = Integer.parseInt(str);
				  addOperande(x);
				  System.out.println(x);
				  }catch (NumberFormatException e) {
					  System.out.println("Taille de l'op�rande incorrecte");
				  }
			  }
			  else System.out.println("Entrez uniquement op�rande/op�ration");
			  
		  }
             
      
    }
  
       
    

}
