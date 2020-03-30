package uvsq21602357;

public enum CalculatriceRPN {
	;
	public static void main(String[] args) {
	MoteurRPN moteurRPN = new MoteurRPN();
   	SaisieRPN scanner = new SaisieRPN(moteurRPN);
   	scanner.getInput(moteurRPN);
   }
}
