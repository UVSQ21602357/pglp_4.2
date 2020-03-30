package uvsq21602357;

import org.junit.*;
import static org.junit.Assert.* ;

import java.util.Stack;

public class TestCalculatriceRPN {

	
	
	@Test
	public void OperationPLUSTest() {
		double y = 5;
		double delta = 0;
		double x = 0;
		try {
			x = Operation.PLUS.eval(3, 2);
		}catch(DivisionZeroException d) {}
		assertEquals(x , y, delta);
	}
	
	@Test
	public void OperationMOINSTest() {
		double y = 5;
		double delta = 0;
		double x = 0;
		try {
			x = Operation.MOINS.eval(7, 2);
		}catch(DivisionZeroException d) {}
		assertEquals(x , y, delta);
	}
	
	@Test
	public void OperationMULTTest() {
		double y = 15;
		double delta = 0;
		double x = 0;
		try {
			x = Operation.MULT.eval(3, 5);
		}catch(DivisionZeroException d) {}
		assertEquals(x , y, delta);
	}
	
	@Test
	public void OperationDIVTest() {
		double y = 2;
		double delta = 0;
		double x = 0;
		try {
			x = Operation.DIV.eval(4, 2);
		}catch(DivisionZeroException d) {}
		assertEquals(x , y, delta);
	}
	
	@Test
	public void RetourPileTest() {
		double y = 2;
		double delta = 0;
		double x = 0;
		MoteurRPN m = new MoteurRPN();
		m.addOperande(y);
		x = m.getOperande();
		assertEquals(x , y, delta);
	}
	
	
	
	
}
