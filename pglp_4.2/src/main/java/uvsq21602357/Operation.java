package uvsq21602357;

import java.lang.Enum;

public enum Operation {
	PLUS("+")
    {public double eval(double x, double y){return x + y;}},
 MOINS("-")
 	{public double eval(double x, double y) {return x - y;}},
 MULT("*")
    {public double eval(double x, double y){return x * y;}},
 DIV("/")
    {public double eval(double x, double y) throws DivisionZeroException
    {
         if(y==0) throw new DivisionZeroException();
         return x/y;
        }};

 private String Symbole;
    
 Operation(String Symbole)
    {
        this.Symbole = Symbole;
    }
    
  public abstract double eval(double op1, double op2) throws DivisionZeroException;
}
