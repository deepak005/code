import java.util.ArrayList;
import java.util.List;

public class IntegerState implements ILexState {

	private List<IntegerInternal> integers = new ArrayList<>();
	private IntegerInternal currentInteger = new IntegerInternal();

	private static final Character SPCAE = ' '; // extend to all white space
	private static final Character DOT = '.';


	@Override
	public void process(Character previous, Character current, int index) {

		boolean isInt = checkInteger(current);

		if (isInt) {
			if (previous == null
					|| (checkInteger(previous) &&  (currentInteger.getChars().size() > 0) )
					|| previous.equals(SPCAE)
					|| previous.equals(DOT)) {
				if (currentInteger.getStartIndex() == 0) {
					currentInteger.setStartIndex(index);
				}
				currentInteger.setEndEndex(index+1);
				currentInteger.addChar(current);
			}
		} else {
			if (currentInteger.getChars().size() > 0) {
				if (current.equals(SPCAE) || current.equals(DOT)) {
					integers.add(new IntegerInternal(currentInteger.getStartIndex(), currentInteger.getEndEndex(), currentInteger.getChars()));
				}
				currentInteger.reset();
			}
		}
	}

	@Override
	public void printResult() {
		System.out.println("Number of Integers in the Input: " + integers.size());
		for (IntegerInternal integer : this.integers) {
			System.out.println(integer);
		}
	}

	private boolean checkInteger(Character c) {

		return Character.isDigit(c);

		/*try {
			Integer.parseInt(c.toString()); // or check 0-9
		} */
	}

	static class IntegerInternal {
		int startIndex;
		int endEndex;
		ArrayList<Character> chars = new ArrayList<>();


		public IntegerInternal() {
			super();
		}



		public IntegerInternal(int startIndex, int endEndex, ArrayList<Character> chars) {
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
		System.out.println(Character.isDigit('.'));
	}
}
