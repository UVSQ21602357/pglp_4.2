package uvsq21602357;

import uvsq21602357.Command;
import uvsq21602357.Interpreteur;

public class undo implements Command {

  private Interpreteur interpreteur;

  /**
   * Constructeur de la classe undo
   * @param interpreteur
   */
  public undo(Interpreteur interpreteur){
    this.interpreteur = interpreteur;
  }


  public void execution() {
    this.interpreteur.undo();
  }

}