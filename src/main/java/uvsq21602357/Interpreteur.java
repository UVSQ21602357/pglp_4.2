package uvsq21602357;

import java.util.Stack;

public class Interpreteur {
	public Stack<Double> historique = new Stack<Double>();
	public Stack<Double> pile;
	Interpreteur(){
	    this.pile = new Stack<Double>();
	  }

	  public void undo(){
	    pile=historique;
	  }

	  public void quit(){
	    System.out.println("Fin");
	    Runtime.getRuntime().exit(0);
	  }
}
