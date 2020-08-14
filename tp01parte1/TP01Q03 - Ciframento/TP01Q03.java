/*
	Autor Gabriel Lopes Ferreira
	Data de Modificação 04/01/2019
*/
public class TP01Q03{
	public static void main(String[]args){
		String input=MyIO.readLine();
		char[] output;
		do{
			output = convertCesar(input);
			for(int i=0;i<output.length;i++){
				MyIO.print(output[i]);
			}
			MyIO.print("\n");
			input=MyIO.readLine();
		}while(!Equals(input,"FIM"));
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:04/01/2019
		O metodo converte a String em um array de char para a manipulação
		dos caracteres e em seguida converte para cifra de cesar

	*/
	public static char[] convertCesar(String str){
		char[] chars = new char[str.length()];
		int ch;
		char ch2;
		for(int i=0;i<str.length();i++){
			ch=str.charAt(i)+3;
			ch2=(char)ch;
			chars[i]=ch2;
		}
		return chars;
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