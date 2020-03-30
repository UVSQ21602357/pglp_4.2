package uvsq21602357;

public class DivisionZeroException extends ExceptionNpi {
	public DivisionZeroException()
    {
        super("Division par z�ro non autoris�");
        System.out.println("Division par 0");
    }
}
