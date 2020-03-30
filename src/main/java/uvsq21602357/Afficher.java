package uvsq21602357;

import java.util.Collection;
import uvsq21602357.Command;
import uvsq21602357.MoteurRPN;

public class Afficher implements Command {
	 private MoteurRPN moteurRPN;

	  /**
	   * constructeur de la classe affichage
	   * @param moteurRPN
	   */
	  public Afficher(MoteurRPN moteurRPN){
	    this.moteurRPN = moteurRPN;
	  }

	  /**
	   * @return Collection de MoteurRPN
	   */
	  public Collection<Double> getCollection(){
		  System.out.println("test");
		    return this.moteurRPN.returnRPN();
	 }

	  public void execution() {
	  }
}
