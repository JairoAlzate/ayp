package models;

public class Game{

	private int numberPc;
	private int numberUser;
	private String word;
	public static String WINNER = "GANADOR";
	private int pos;
	private boolean endGame;

	public Game(String word){
		pos = 0;
		endGame = false;
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
			if (! (pos == 0)){
				pos--;
				System.out.println("Punto para Pc.");
				System.out.println(numberPc+ " > "+ numberUser);
				word = WINNER.substring(0,pos);
				System.out.println(word);
			}
		} else if(numberUser > numberPc){
			pos++;
			if (pos > WINNER.length()){
				word = WINNER;
				endGame = true;
				System.out.println("*****GANADOR EL USUARIO*****");
			}else{
				System.out.println("Punto para Usuario.");
				System.out.println(numberPc+ " < "+ numberUser);
				word = WINNER.substring(0,pos);
				System.out.println(word);
			}
		}else{
			System.out.println("Empate.");
			System.out.println(numberPc+ " = "+ numberUser);
			System.out.println(word);
		}
	}

	public static void main(String[] args) {
		Game t = new Game("Ganador");
		while (!t.endGame){
			t.compareNumbers();
		}
		
	}
}
