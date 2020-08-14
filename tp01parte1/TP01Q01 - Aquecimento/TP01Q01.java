/*
	Autor: Gabriel Lopes Ferreira
	Data de Modificação:31/01/2019
*/
public class TP01Q01{
	public static void main(String[]args){
		String input=MyIO.readLine();
		do{
			
			MyIO.println(countUpperCase(input));
			input=MyIO.readLine();

		}while(!Equals(input,"FIM"));
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:04/01/2019
		O metodo conta o numero de letras maiusculas na string recebida
		retornando um valor int com o numero de letras maiusculas
	*/
	public static int countUpperCase(String str){
		int numUppercase = 0;
		char ch;
		for(int i=0;i<str.length();i++){
			ch = str.charAt(i);
			if(ch>=65&&ch<=90){
				numUppercase++;
			}
		}
		return numUppercase;
	}
	/*
		@author Gabriel Lopes Ferreira
		@date 04/02/2019
		@version 1.0
		@since 1.0
		@param str1 , str 2
		@return isEquals
		O metodo recebe duas Strings e verifica se as duas são iguais
	*/
	public static boolean Equals(String str1, String str2){
		boolean isEquals=true;
		if(str1.length()==str2.length()){
			for(int i =0;i<str1.length();i++){
				if(str1.charAt(i)!=str2.charAt(i)){
					isEquals=false;
				}
			}
		}
		else{
			isEquals=false;
		}
		return isEquals;
	}
}
