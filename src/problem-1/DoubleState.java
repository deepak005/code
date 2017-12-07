import java.util.ArrayList;
import java.util.List;

public class DoubleState implements ILexState {

	private List<DoubleInternal> doubles = new ArrayList<>();
	private DoubleInternal currentDouble = new DoubleInternal();

	private static final Character SPCAE = ' '; // extend to all white space
	private static final Character DOT = '.';


	@Override
	public void process(Character previous, Character current, int index) {

		boolean isInt = checkInteger(current);

		if (isInt) {
			if (previous == null
					|| (checkInteger(previous) &&  (currentDouble.getChars().size() > 0) )
					|| previous.equals(SPCAE)
					|| previous.equals(DOT)) {
				if (currentDouble.getStartIndex() == 0) {
					currentDouble.setStartIndex(index);
				}
				currentDouble.setEndEndex(index+1);
				currentDouble.addChar(current);
			}
		} else {
			if (currentDouble.getChars().size() > 0) {
				if (current.equals(SPCAE) || current.equals(DOT)) {
					doubles.add(new DoubleInternal(currentDouble.getStartIndex(), currentDouble.getEndEndex(), currentDouble.getChars()));
				}
				currentDouble.reset();
			}
		}
	}

	@Override
	public void printResult() {
		System.out.println("Number of doubles in the Input: " + doubles.size());
		for (DoubleInternal integer : this.doubles) {
			System.out.println(integer);
		}
	}

	private boolean checkInteger(Character c) {

		return Character.isDigit(c);

		/*try {
			Integer.parseInt(c.toString()); // or check 0-9
		} */
	}

	static class DoubleInternal {
		int startIndex;
		int endEndex;
		ArrayList<Character> chars = new ArrayList<>();


		public DoubleInternal() {
			super();
		}



		public DoubleInternal(int startIndex, int endEndex, ArrayList<Character> chars) {
			super();
			this.startIndex = startIndex;
			this.endEndex = endEndex;
			this.chars = chars;
		}



		public void addChar(Character character) {
			chars.add(character);
		}

		public int getStartIndex() {
			return startIndex;
		}
		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}
		public int getEndEndex() {
			return endEndex;
		}
		public void setEndEndex(int endEndex) {
			this.endEndex = endEndex;
		}
		public ArrayList<Character> getChars() {
			return chars;
		}
		public void setChars(ArrayList<Character> chars) {
			this.chars = chars;
		}

		public void reset() {
			this.chars = new ArrayList<>();
			this.startIndex = 0;
			this.endEndex = 0;
		}

		public String toString() {
			return this.startIndex + " " + this.endEndex + " " + new String(this.chars.toString());
		}

	}


	public static void main(String[] args) {
		final String input = "1.1 1\\.1 1";
		for (int i = 0 ; i < input.length() ; i ++ ) {

			//charAtI = input.charAt(i);
			//System.out.println(c);

	}
}