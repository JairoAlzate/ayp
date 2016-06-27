package models;	

public class Anagram{

	public Anagram(){
	}

	public void compareWords(String wordOne,String wordTwo){
		String wordAuxOne = wordOne.toUpperCase();
		String wordAuxTwo = wordTwo.toUpperCase();
		int sumAscOne = getSumAsc(wordAuxOne);
		int sumAscTwo = getSumAsc(wordAuxTwo);
		if (sumAscOne == sumAscTwo){
			System.out.println("Las palabras "+wordOne +" y "+wordTwo+" son anagramas");

		}else{
			System.out.println("Las palabras "+wordOne +" y "+wordTwo+" NO son anagramas");
		}
	}

	public int getSumAsc(String wordEvaluate){
		int sumAsc = 0;
		for (int i =0;i < wordEvaluate.length();i++){
			sumAsc += (int)wordEvaluate.charAt(i);
		}
		System.out.println("Peso ascci "+sumAsc);
		return sumAsc;
	}

	public static void main(String[] args) {
		Anagram t = new Anagram();
		t.compareWords("","");
	}
}
