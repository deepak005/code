import java.util.ArrayList;
import java.util.List;

public class SentenceState implements ILexState {

	private List<SentenceInternal> sentenses = new ArrayList<>();
	private SentenceInternal currentSentence;

	@Override
	public void process(Character previous, Character current, int index) {
		if (previous == null || previous.equals('.')) {
			currentSentence = new SentenceInternal();
			currentSentence.setStartIndex(index);
			currentSentence.addChar(current);
			return;
		}

		if (current.equals('.')) {
			addToList(index);
			return;
		}

		if (currentSentence.getChars().size() > 0) {
			currentSentence.addChar(current);
			currentSentence.setEndEndex(index);
		}
	}

	private void addToList(int index) {
		currentSentence.setEndEndex(index);
		sentenses.add(new SentenceInternal(currentSentence.startIndex, currentSentence.endEndex, currentSentence.chars));
		currentSentence.reset();
	}

	@Override
	public void printResult() {

		if (currentSentence.getChars().size() > 0) {
			addToList(currentSentence.getEndEndex());
		}

		System.out.println("Number of sentence in the Input: " + sentenses.size());
		for (SentenceInternal sentence : this.sentenses) {
			System.out.println(sentence);
		}

	}

	static class SentenceInternal{
		int startIndex;
		int endEndex;
		String text;
		ArrayList<Character> chars = new ArrayList<>();

		public SentenceInternal() {

		}


		public SentenceInternal(int startIndex, int endEndex, ArrayList<Character> chars) {
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
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}

		public void reset() {
			this.chars = new ArrayList<>();
		}

		public ArrayList<Character> getChars() {
			return chars;
		}

		public String toString() {
			//char[] arr = this.chars.toArray(new char[this.chars.size()]);
			return this.startIndex + " " + this.endEndex + " " + new String(this.chars.toString());
			//return new String(this.chars.toString());
		}
	}

}
