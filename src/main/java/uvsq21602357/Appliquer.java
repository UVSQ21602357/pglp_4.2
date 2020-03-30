package uvsq21602357;

import java.util.Stack;
import uvsq21602357.Command;
import uvsq21602357.MoteurRPN;
import uvsq21602357.Operation;

public class Appliquer implements Command {

	private MoteurRPN moteurRPN;
	  private Operation operation;

	  /**
	   * Apply constructor.
	   * @param moteurRPN
	   * @param operator
	   */
	  public Appliquer(MoteurRPN moteurRPN, Operation operation){
	    this.moteurRPN = moteurRPN;
	    this.operation = operation;
	  }

	  /**
	   * Operator setter.
	   * @param operator
	   */
	  public void setOperation(Operation operation){
	    this.operation = operation;
	  }


	  public void execution() {
	    double val = 0.0;
	    if(this.moteurRPN.pile.size() > 1) {
	      this.moteurRPN.historique = (Stack<Double>) this.moteurRPN.pile.clone();
	      try {
			val = operation.eval(this.moteurRPN.pile.pop(),this.moteurRPN.pile.pop());
		} catch (DivisionZeroException e) {
			e.printStackTrace();
		}
	    }
	    this.moteurRPN.pile.push(val);
	  }
}
