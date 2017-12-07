import java.util.ArrayList;
import java.util.List;

public class WordState implements ILexState {

	private List<WordInternal> words = new ArrayList<>();
	private WordInternal currentWord;
	private WordInternal maxSizeWord ;

	@Override
	public void process(Character previous, Character current, int index) {
		if (previous == null || previous.equals('.') || previous.equals(' ')) {
			currentWord = new WordInternal();
			currentWord.setStartIndex(index);
			currentWord.setEndEndex(index);
			currentWord.addChar(current);
			return;
		}

		if (current.equals('.') || current.equals(',')  || current.equals(' ')) { // TODO need to include other characters like ','
			addToList(index - 1);
			currentWord.reset();
			return;
		}

		if (currentWord.getChars().size() > 0) {
			currentWord.addChar(current);
			currentWord.setEndEndex(index);
		}
	}

	private void addToList(int index) {
		currentWord.setEndEndex(index);
		WordInternal word = new WordInternal(currentWord.startIndex, currentWord.endEndex, currentWord.chars);
		words.add(word);
		if (maxSizeWord == null ) {
			maxSizeWord = word;
		}
		else if (word.getChars().size() > maxSizeWord.getChars().size()) {
			maxSizeWord = word;
		}
	}

	@Override
	public void printResult() {

		if (currentWord.getChars().size() > 0) {
			addToList(currentWord.getEndEndex());
		}

		System.out.println("Number of Words in the Input: " + words.size());
		if (maxSizeWord != null ) {
			System.out.println("Longest world: " + maxSizeWord.toString());
		}
		for (WordInternal word : this.words) {
			System.out.println(word);
		}

	}

	static class WordInternal  {
		int startIndex;
		int endEndex;
		ArrayList<Character> chars = new ArrayList<>();


		public WordInternal() {
			super();
		}



		public WordInternal(int startIndex, int endEndex, ArrayList<Character> chars) {
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

}
