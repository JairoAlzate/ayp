package models;

public class ToolKit{

	public int getCharacterNumber(String phrase, char symbolUser){
		int numberOfCharacter = 0;
		for(int i = 0; i < phrase.length(); i++){
			char symbol = phrase.charAt(i);
			if(symbol == symbolUser){
				numberOfCharacter++; 
			}
		}
		return numberOfCharacter;
	}

	public int getNumberWordsOfPhase(String phraseTwo) {
    		phraseTwo += " ";
    		int wordsNumber = 0;
    		for (int i = 0; i < phraseTwo.length(); i++) {
        		if (phraseTwo.charAt(i) == ' ') {
            		wordsNumber++;
        		}
    		}	
    		return wordsNumber;
	}

	public boolean getNumberBinary(String number){
		for(int i = 0; i < number.length(); i ++){
			if((number.charAt(i) == '1') || (number.charAt(i) == '0')){
		 		return true;	
			} else {		
		 		return false;
			}
		}
		return false;
	}

	public int getNumbers(String text){
		char asciiOne = 48;
		char asciiTwo = 57;	
		int numberSum = 0;
   		for(int n = 0; n < text.length(); n ++){
			if((text.charAt(n) >= asciiOne) && (text.charAt(n) <= asciiTwo)){
				numberSum += n;
				return numberSum;
			}
		}
		return numberSum;	
	} 
	
	public static void main(String[] args) {
		ToolKit c = new ToolKit();
		System.out.println("Numero de veces que se repite el caracter seleccionado en la frase: " + c.getCharacterNumber("hola como estas.", '.') + " veces"); 
		System.out.println("Numero de palabras que hay en la frase: " + c.getNumberWordsOfPhase("Hola como estas bien o no."));
		System.out.println("El numero es binario: " + c.getNumberBinary("1001001"));
		System.out.println("Suma total de numeros dentro de la cadena: " + c.getNumbers("c5fg6gh4"));
	}
}
