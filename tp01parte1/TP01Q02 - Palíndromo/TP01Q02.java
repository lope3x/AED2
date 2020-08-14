/*
	Autor Gabriel Lopes Ferreira
	Data de Modificação: 04/01/2019

*/
public class TP01Q02{
	public static void main(String[]args){
		String input=MyIO.readLine();
		do{
			
			if(isPalindromo(input)){
				MyIO.println("SIM");
			}
			else{
				MyIO.println("NAO");
			}
			input=MyIO.readLine();

		}while(!Equals(input,"FIM"));
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação: 04/01/2019
		O metodo recebe uma String e verifica se a mesma é um palimdromo
		retornando um valor em boolean com a resposta
	*/
	public static boolean isPalindromo(String str){
		char ch;
		char ch2;
		boolean resp=true;
		int j=str.length()-1;
		for(int i=0;i<str.length()/2;i++){
			ch=str.charAt(i);
			ch2=str.charAt(j);
			if(ch!=ch2){
				resp=false;
				i=str.length();
			}
			j--;
		}
		return resp;
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
