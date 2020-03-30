package uvsq21602357;

import static org.junit.Assert.assertEquals;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uvsq21602357.Appliquer;
import uvsq21602357.Afficher;
import uvsq21602357.Enregistrer;
import uvsq21602357.undo;

public class TestCalculatriceRPN {

	
	
	 MoteurRPN moteurRPN;
	    @Before
	    public void initialise(){
	        moteurRPN = new MoteurRPN();
	    }

	    @Test
	    public void testStack(){
	        moteurRPN.pile.push(28.7);
	        assertEquals(28.7, moteurRPN.pile.pop(),0);
	    }

	    @Test
	    public void testEnregistrer(){
	        Enregistrer Enregistre = new Enregistrer(moteurRPN, 2.0);
	        Enregistre.execution();
	        Enregistre.setOperand(3.5);
	        Enregistre.execution();
	        assertEquals(3.5, moteurRPN.pile.pop(),0);
	        assertEquals(2.0, moteurRPN.pile.pop(),0);
	    }

	    @Test
	    public void testUndo(){
	    	Enregistrer Enregistre = new Enregistrer(moteurRPN, 3.3);
	        undo undo = new undo(moteurRPN);
	        Enregistre.execution();
	        Enregistre.setOperand(2.3);
	        Enregistre.execution();
	        undo.execution();
	        assertEquals(3.3, moteurRPN.pile.pop(),0.0);
	    }

	    @Test
	    public void testAppliquer() {
	        Enregistrer enregistre = new Enregistrer(moteurRPN, 1.2);
	        Appliquer applique = new Appliquer(moteurRPN,Operation.MOINS);
	        enregistre.execution();
	        enregistre.setOperand(4);
	        enregistre.execution();
	        applique.execution();
	        assertEquals(2.8, moteurRPN.pile.pop(), 0);
	    }

	    @Test
	    public void testAfficher(){
	        Stack<Double> tmp = new Stack<Double>();
	        Stack<Double> tmp2 = new Stack<Double>();
	        Enregistrer Enregistre = new Enregistrer(moteurRPN, 2.3);
	        Afficher Aff = new Afficher(moteurRPN);
	        Enregistre.execution();
	        Enregistre.setOperand(2.0);
	        Enregistre.execution();
	        Aff.execution();
	        tmp2.addAll(Aff.getCollection());
	        tmp.push(2.3);
	        tmp.push(2.0);
	        assertEquals(tmp,tmp2);
	    }
}
