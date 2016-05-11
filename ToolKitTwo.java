package models;

public class ToolKitTwo{

	public static final String NULLDATE = "";
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final char SIGNAL = ',';
	public static final char SIGNALPOINT = '.';

	public int getSumNumbers(String text){
		int size = text.length();
		String num = NULLDATE;
		int sum = ZERO;
		for (int i = ZERO; i < size ; i++ ) {
			if(Character.isDigit(text.charAt(i))){
				num += text.charAt(i);
				if(i + ONE == size){
					sum += Integer.parseInt(num);
				}				 	
			}else{
				sum += Integer.parseInt(num);
				num = NULLDATE;
			}
		}
		return sum;
	}
	// alex,4;diego,3;anna,0;evelin,2;
	public String notePerson(String text){
		int size = text.length();
		String name = NULLDATE;
		String nameNote = NULLDATE;
		int note = ZERO;

		for (int i = ZERO; i < size ; i++) {
			if(Character.isLetter(text.charAt(i))){
				name += text.charAt(i);				
			}else if (text.charAt(i) == SIGNAL) {
				int evaluation = Integer.parseInt(String.valueOf(text.charAt(i + ONE)) );
				if(evaluation > note){
					note = evaluation;
					nameNote = name;
					name = NULLDATE;
				}
			}
		}
		return nameNote;
	}
	//______...___........____...___;
	public String damageStreet(String text){
		int size = text.length();
		int firstPosition = 0;
		int finalPosition = 0;
		int fistvar = 0;
		int finalvar = 0;
		for (int i = ZERO; i < size ; i++ ) {
			if (text.charAt(i) == SIGNALPOINT) {
				fistvar = i;
				while(text.charAt(i) == SIGNALPOINT){
					finalvar = i;
					if(i < size - ONE){
						i++;
					}else{
						break;
					} 					
				}
				if((finalvar - fistvar) > (finalPosition - firstPosition)){
					firstPosition = fistvar;
					finalPosition = finalvar;
				} 
			}
		}
		return "(" +firstPosition + "-" + finalPosition + ")";
	}

	public static void main(String[] args) {
		ToolKit ciclos = new ToolKit();
		System.out.println(ciclos.damageStreet("_.............."));
	}
}
