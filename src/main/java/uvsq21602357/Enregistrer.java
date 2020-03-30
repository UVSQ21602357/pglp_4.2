package uvsq21602357;

import java.util.Stack;
import uvsq21602357.Command;
import uvsq21602357.MoteurRPN;

public class Enregistrer implements Command {
	 private MoteurRPN moteurRPN;
	 private double operand;

	  /**
	   * Constructeur de la classe enregistrer
	   * @param moteurRPN
	   * @param operand
	   */
	  public Enregistrer(MoteurRPN moteurRPN, double operand){
	    this.moteurRPN = moteurRPN;
	    this.operand = operand;
	  }

	  public void execution() {
	    this.moteurRPN.historique = (Stack<Double>) this.moteurRPN.pile.clone();
	    this.moteurRPN.pile.push(operand);
	  }

	  /**
	   * @param operand
	   */
	  public void setOperand(double operand){
	    this.operand = operand;
	  }
}
