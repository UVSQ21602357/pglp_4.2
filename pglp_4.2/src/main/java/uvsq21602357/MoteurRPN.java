package uvsq21602357;

import java.util.Stack;

public class MoteurRPN extends Interpreteur{
private Stack<Double>pile;
    
    public MoteurRPN(){
        this.pile = new Stack();
    }
    
    public void addOperande(double Operande){

       this.pile.push(Operande); 
    }
   
    public double getOperande() {
    	return this.pile.pop();
    }
    public double resOperation(Operation operation) throws DivisionZeroException{
    	
   
    	if(pile.empty()) {
    		System.out.println("Pile vide"); return 0;
    	}
 
    	double x = 0;
    	double y = 0;
    	double z = 0;
    	try {
    	y = this.pile.pop();
    	if(pile.empty()) {
    		System.out.println("Pas assez d'op�randes"); 
    		this.pile.push(y);
    		return 0;
    	}

    	z = this.pile.pop();
    	x = operation.eval(y, z);    
    	}catch(DivisionZeroException d) {
    		this.pile.push(z);
    		this.pile.push(y);
    	return x;
    	}
    	this.pile.push(x);
    	return x;
    }
    
    public void AfficherPileOperandes(){
      Object[] arr=(pile.toArray());
      System.out.print("(");
      for (int j = 0; j < arr.length; j++) 
          System.out.print(arr[j]+" "); 
      System.out.println(")");
    }

}
