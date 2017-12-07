
public class SpecificCharState implements ILexState {

	private int charCount;
	private Character character;

	public SpecificCharState(Character character) {
		this.character = character;
	}

	@Override
	public void process(Character previous, Character current, int index) {
		if (this.character.equals(current)) {
			this.charCount++;
		}

	}

	@Override
	public void printResult() {
		System.out.println("Count of character " + this.character + " = " + this.charCount);

	}


}
