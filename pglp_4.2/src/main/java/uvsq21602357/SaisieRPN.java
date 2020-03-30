package uvsq21602357;

import java.util.Scanner;
import java.util.regex.Pattern;
import uvsq21602357.Calcul;

public class SaisieRPN extends MoteurRPN {
	private Calcul command;
	private Scanner scanner;
	
	public SaisieRPN(MoteurRPN moteurRPN) 
    {   
		this.scanner = new Scanner(System.in,"UTF-8");
		this.command = new Calcul();
    	this.command.createCommandList(moteurRPN);
    }
		
	 public void getInput(){
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
			  { 	
				  	this.command.setOperation(Operation.PLUS);
			  		this.command.executerCommande("Calcul");
			  }
			  else if(str.equals("-") || str.equals("MOINS")) 
			  {
				  this.command.setOperation(Operation.MOINS);
			      this.command.executerCommande("Calcul");
			  }
			  else if(str.equals("*") || str.equals("MULT")) 
			  {
				  this.command.setOperation(Operation.MULT);
			      this.command.executerCommande("Calcul");
			  }
			  else if(str.equals("/") || str.equals("DIV")) 
			  {
				  this.command.setOperation(Operation.DIV);
			      this.command.executerCommande("Calcul");
			  }
			  else if(str.matches("^-?\\d+$")){
				  this.command.setOperande(Double.parseDouble(str));
			      this.command.executerCommande("Enregistre");
			  }
			  else {
			      this.command.executerCommande(str);
			    }
			  
		  }
             
      
    } 
}
