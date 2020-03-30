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
	    if(this.commandes.containsKey("save")){
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
	      this.commandes.get(name).execution();
	      System.out.println(this.MoteurRPN.returnRPN());
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
	    this.addCommand("result", new Afficher(moteurRPN));
	    this.addCommand("save", new Enregistrer(moteurRPN, 0.0));
	    this.addCommand("apply", new Appliquer(moteurRPN, Operation.PLUS));
	  }

}
