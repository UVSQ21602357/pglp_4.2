package uvsq21602357;

import java.util.Scanner;
import java.util.Stack;
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
		
	 public void getInput(MoteurRPN moteurRPN){
    	String str = "debut";
		  int i = 0;
		  while(i != 1)
		  {
			  Scanner sc = new Scanner(System.in);
			  System.out.println("**Saisir opérande/opération:");
	
			  
			 str = sc.nextLine();
			  
			  
			  System.out.println("**Vous avez saisi : " + str);
			  if(str.equals("Exit")) {i = 1;}
			  else if(str.equals("+") || str.equals("PLUS")) 
			  { 	
				  	this.command.setOperation(Operation.PLUS);
			  		this.command.executerCommande("appliquer+");
			  }
			  else if(str.equals("-") || str.equals("MOINS")) 
			  {
				  this.command.setOperation(Operation.MOINS);
			      this.command.executerCommande("appliquer-");
			  }
			  else if(str.equals("*") || str.equals("MULT")) 
			  {
				  this.command.setOperation(Operation.MULT);
			      this.command.executerCommande("appliquer*");
			  }
			  else if(str.equals("/") || str.equals("DIV")) 
			  {
				  this.command.setOperation(Operation.DIV);
			      this.command.executerCommande("appliquer/");
			  }
			  else if(str.matches("[0-9]")){
				  this.command.setOperande(Double.parseDouble(str));
				  double val = Double.parseDouble(str);
				  this.command.createCommandEnregistre(moteurRPN, val);
			      this.command.executerCommande("enregistrer");
			  }
			  else {
			      this.command.executerCommande(str);
			    }
		  }
             
      
    } 
}
