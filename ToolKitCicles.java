package models;

import java.util.Scanner;

public class ToolKitCicles{

	public static final int TICKET_ONE = 80;
	public static final double VALUE_TICKET_ONE = 50000;
	public static final int TICKET_TWO = 100;
	public static final double VALUE_TICKET_TWO = 75000;
	public static final String NORMAL = "n";
	public static final String AMBULANCE = "a";
	public static final String FIREFIGHTER = "b";
	public static final String SYMBOL_ONE = "?";
	public static final String SYMBOL_TWO = "}";
	public static final String SYMBOL_THREE = "[";
	public static final String SYMBOL_FOUR = "-";
	public static final String SYMBOL_FIVE = "_";
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final String TRACK_ONE = "_ _*_ _*_ _*_*";
	public static final String TRACK_TWO = "_*_ _*_ _*_";
	public static final String TRACK_THREE = "_*_*_*_*_ _*_";
	public static final String ANSWER_TRACK_ONE = "dwdsdwdsdwdsds";
	public static final String ANSWER_TRACK_TWO = "dsdwdsdwdsd";
	public static final String ANSWER_TRACK_THREE = "dsdsdsdsdwdsd";

	private double value;
	private int symbolOne;
	private int symbolTwo;
	private int symbolThree;
	private	String symbols = "";
	private Scanner scanner;
	private String answerUser;
	private char charSymbols;
	private char charUser;
	private int lives;
	private boolean endLives;
	private int numberRandom;
	private String track;
	private String answerUserTwo;
	private String userComands;
	private int livesTwo;
	private boolean endGame;

	public ToolKit(){
		value = 0;
		scanner = new Scanner(System.in);
		lives = 6;
		endLives = true;
		livesTwo = 3;
		endGame = true;
	}

	// Registro de carros

	public double loginInformation(String licensePlate, String speed, String type){
		String newWord = "";
		int numEntero = Integer.parseInt(speed);
		if(type.contains(NORMAL)){
			if(numEntero > TICKET_ONE){
				value += VALUE_TICKET_ONE;
				newWord += licensePlate;
				newWord += speed;
				newWord += type;
				System.out.println(newWord);
				return value;
			} else if(numEntero > TICKET_TWO){
				value += VALUE_TICKET_TWO;
				newWord += licensePlate;
				newWord += speed;
				newWord += type; 
				System.out.println(newWord);
				return value;
			} else {
				return value;
			}
		}
		return value;
	}

	// Clave de seguridad

	public void getNumberRandom(){
		symbolOne = (int)(Math.random() * 5 + 1);
		symbolTwo = (int)(Math.random() * 5 + 1);
		symbolThree = (int)(Math.random() * 5 + 1);
	}

	public void getSymbolOne(){
		getNumberRandom();
		if (symbolOne == ONE) {
			symbols += SYMBOL_ONE; 
		}else if(symbolOne == TWO){
			symbols += SYMBOL_TWO;
		}else if(symbolOne == THREE){
			symbols += SYMBOL_THREE;
		}else if(symbolOne == FOUR){
			symbols += SYMBOL_FOUR;
		}else if(symbolOne == FIVE){
			symbols += SYMBOL_FIVE;
		}
	}

	public void getSymbolTWo(){
		getNumberRandom();
		if (symbolTwo == ONE) {
			symbols += SYMBOL_ONE; 
		}else if(symbolTwo == TWO){
			symbols += SYMBOL_TWO;
		}else if(symbolTwo == THREE){
			symbols += SYMBOL_THREE;
		}else if(symbolTwo == FOUR){
			symbols += SYMBOL_FOUR;
		}else if(symbolTwo == FIVE){
			symbols += SYMBOL_FIVE;
		}
	}

	public void getSymbolThree(){
		getNumberRandom();
		if (symbolThree == ONE) {
			symbols += SYMBOL_ONE; 
		}else if(symbolThree == TWO){
			symbols += SYMBOL_TWO;
		}else if(symbolThree == THREE){
			symbols += SYMBOL_THREE;
		}else if(symbolThree == FOUR){
			symbols += SYMBOL_FOUR;
		}else if(symbolThree == FIVE){
			symbols += SYMBOL_FIVE;
		}
		System.out.println(symbols);
	}

	public void startIncomeSymbolsUser(){
		while(endLives){
			System.out.println("Hola. ingresa los simbolos de la clave.");
			System.out.println("Recuerda que los simbolos son ?; }; [; -; _  .");
			answerUser = scanner.nextLine();
			if (symbols.equals(answerUser)) {
				lives++;
				endLives = true;
				System.out.println("Ok. La clave esta bien puedes entrar");
				break;
			}else{
				lives--;
				System.out.println("La clave esta mal. Una vida menos.");
				System.out.println(lives);
				if (lives == ZERO) {
					endLives = false;
				}
			}
		}
	}

	// Tarea pistas aleatorias

	public void generateNumberRandom(){
		numberRandom = (int)(Math.random() * 3 + 1);
	}

	public void generateTracksOne(){
		generateNumberRandom();
		if (numberRandom == 1){	
			System.out.println("Ingrese lista de comando correctos segun la pista.");
			userComands = scanner.nextLine();
			track = TRACK_ONE; 
			System.out.println(track); 
			if (userComands.equals(ANSWER_TRACK_ONE)) {
				System.out.println("Gano.");
			} else {
				System.out.println("Perdio. Menos una vida");
				livesTwo--;
				if (livesTwo > ZERO) {
					generateTracksOne();		
				} else {
					System.out.println("Te quedaste sin vidas. Has perdido.");
					endGame = false;
				}
			}
		}
	}

	public void generateTracksTwo(){
		generateNumberRandom();
		if (numberRandom == 2){	
			System.out.println("Ingrese lista de comando correctos segun la pista.");
			userComands = scanner.nextLine();
			track = TRACK_TWO; 
			System.out.println(track); 
			if (userComands.equals(ANSWER_TRACK_TWO)) {
				System.out.println("Gano.");
			} else {
				System.out.println("Perdio. Menos una vida");
				livesTwo--;
				if (livesTwo > ZERO) {
					generateTracksOne();		
				} else {
					System.out.println("Te quedaste sin vidas. Has perdido.");
					endGame = false;
				}
			}
		}
	}

	public void generateTracksThree(){
		generateNumberRandom();
		if (numberRandom == 3){	
			System.out.println("Ingrese lista de comando correctos segun la pista.");
			userComands = scanner.nextLine();
			track = TRACK_THREE;
			System.out.println(track);
			if (userComands.equals(ANSWER_TRACK_THREE)) {
				System.out.println("Gano.");
			} else {
				System.out.println("Perdio. Menos una vida");
				livesTwo--;
				if (livesTwo > ZERO) {
					generateTracksOne();		
				} else {
					System.out.println("Te quedaste sin vidas. Has perdido.");
					endGame = false;
				}
			}
		}
	}

	public void playGame(){
		while(endGame){
			generateTracksOne();
			generateTracksTwo();
			generateTracksThree();
			System.out.println("Quieres jugar?");
			answerUserTwo = scanner.nextLine();
			if (answerUserTwo.contains("si")) {
			System.out.println("Ok. Las reglas son las siguientes:");
			System.out.println("1.Se avanza con d,w,s.");
			System.out.println("2.Cuando te aparesca un guion al piso tienes que darle d.");
			System.out.println("3.Cuando te aparesca un espacio tienes que darle s. ");
			System.out.println("4.Cuando te aparesca una asterisco tienes que darle w.");
			System.out.println("5.Numero de vidas es igual a 3.");
			System.out.println(track);
			}
		}
	}

	public static void main(String[] args) {
		ToolKit t = new ToolKit();
	}
}
