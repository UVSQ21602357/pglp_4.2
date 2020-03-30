package uvsq21602357;

import uvsq21602357.Command;
import uvsq21602357.Interpreteur;

public class quit implements Command {
  private Interpreteur interpreteur;

  /**
   * Constructeur de la classe quit
   * @param interpreteur
   */
  quit(Interpreteur interpreteur){
    this.interpreteur = interpreteur;
  }


  public void execution(){
    this.interpreteur.quit();
  }

}
