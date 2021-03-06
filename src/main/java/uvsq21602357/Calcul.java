package uvsq21602357;

import java.util.HashMap;
import java.util.Map;
import uvsq21602357.Command;
import uvsq21602357.MoteurRPN;
import uvsq21602357.Operation;

public class Calcul {
	private Map<String, Command> commandes;
	private MoteurRPN MoteurRPN;

	  /**
	   * Constructeur de Calcul
	   */
	  public Calcul(){
	    this.commandes = new HashMap<String, Command>();
	  }

	  /**
	   * Ajoute une commande a HashMap
	   * @param name
	   * @param command
	   */
	  public void addCommand(String name, Command commande){
	    this.commandes.put(name, commande);
	  }

	  /**
	   * @param operand
	   */
	  public void setOperande(Double operande){
	    Enregistrer Enregistre;
	    if(this.commandes.containsKey("Enregistre")){
	      Enregistre = (Enregistrer) this.commandes.get("Enregistre");
	      Enregistre.setOperand(operande);
	    }
	  }

	  /**
	   * @param operator
	   */
	  public void setOperation(Operation operation){
	    Appliquer appliquer;
	    if(this.commandes.containsKey("apply")){
	      appliquer = (Appliquer) this.commandes.get("apply");
	      appliquer.setOperation(operation);
	   }
	  }

	  /**
	   * @param name
	   */
	  public void executerCommande(String name){
	    if(this.commandes.containsKey(name)){
	    	if(name.equals("enregistrer")) {
	    		this.commandes.get(name).execution();
		   	    System.out.println(this.MoteurRPN.returnRPN());
	    	}
	    	else {
	    	  this.commandes.get(name).execution();
	   	      System.out.println(this.MoteurRPN.returnRPN());
	    	}
	    }
	  }

	  /**
	   * Commandes
	   * @param moteurRPN
	   */
	  public void createCommandList(MoteurRPN moteurRPN){
	    this.MoteurRPN = moteurRPN;
	    this.addCommand("undo", new undo(moteurRPN));
	    this.addCommand("quit", new quit(moteurRPN));
	    this.addCommand("afficher", new Afficher(moteurRPN));
	    this.addCommand("appliquer+", new Appliquer(moteurRPN, Operation.PLUS));
	    this.addCommand("appliquer-", new Appliquer(moteurRPN, Operation.MOINS));
	    this.addCommand("appliquer*", new Appliquer(moteurRPN, Operation.MULT));
	    this.addCommand("appliquer/", new Appliquer(moteurRPN, Operation.DIV));
	  }
	  
	  /**
	   * Commandes enregistrer
	   * @param moteurRPN
	   * @param val
	   */
	  public void createCommandEnregistre(MoteurRPN moteurRPN, double val) {
		  this.addCommand("enregistrer", new Enregistrer(moteurRPN, val));
	  }

}
