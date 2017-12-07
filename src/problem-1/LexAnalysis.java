import java.util.ArrayList;
import java.util.List;

public class LexAnalysis {

	public static void main(String[] args) {
		// Instead of this steam the input 1 char at a time.
		final String input = "eeem122 brother 11.11 is taller than me@1233334.2222 I am a short man, but I am smarter than him";
		//final String input = "1.1 1\\.1 1";
		System.out.println("Input = " + input);
		System.out.println();

		List<ILexState> states = new ArrayList<ILexState>();
		states.add(new IntegerState());
		states.add(new SentenceState());
		states.add(new WordState());
		states.add(new SpecificCharState('e'));

		Character charAtI = null;
		Character previous = null;

		// We need to extend this to include other characters.
		System.out.println("Input Without space");

		for (int i = 0 ; i < input.length() ; i ++ ) {

			charAtI = input.charAt(i);

			// Need to use return type in below process method.
			// I think Space state need to have a sink in which it will flush the character if its not space.
			if (charAtI != ' ') {
				System.out.print(charAtI);
			}

			for (ILexState state: states) {
				state.process(previous, charAtI, i);
			}

			previous = charAtI;
		}

		System.out.println("\n");

		for (ILexState state: states) {
			state.printResult();
			System.out.println("\n");
		}

	}
}
