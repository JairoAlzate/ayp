package models;

public class Game{

	private int numberPc;
	private int numberUser;
	private String word;
	private String originalWord;

	public static final char CHAR_HIDDEN = '_';

	public Game(String word){
		this.originalWord = word;
		this.word = word;
	}

	public void generateNumberPc(){
		numberPc = (int) (Math.random() * 6 + 1);
	}

	public void generateNumberUser(){
		numberUser = (int) (Math.random() * 6 + 1);
	}

	public void compareNumbers(){
		generateNumberPc();
		generateNumberUser();
		if(numberPc > numberUser){
			System.out.println("Gano Pc.");
			hiddenChar();
		} else if(numberUser > numberPc){
			System.out.println("Gano Usuario.");
			unHiddenChar();
		}else{
			System.out.println("Empate.");
		}
	}

	public void hiddenChar(){
		int position = (int) (Math.random() * word.length());
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			if (i == position) {
				newWord += CHAR_HIDDEN;
			}else{
				newWord += word.charAt(i);
			}
		}
		word = newWord;
		System.out.println(word);
	}

	public void unHiddenChar(){
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			if (i == '_') {
				newWord += originalWord.charAt(i);
			}else{
				newWord += word.charAt(i);
			}
		}
		word = newWord;
		System.out.println(word);
	}

	public static void main(String[] args) {
		Game t = new Game("Ganador");
		t.compareNumbers();
	}
}
