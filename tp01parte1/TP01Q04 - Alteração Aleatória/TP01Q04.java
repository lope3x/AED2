import java.util.Random;
public class TP01Q04{
	public static void main(String[]args){
		String input=MyIO.readLine();
		Random generator = new Random();
		generator.setSeed(4);
		char[] output;
		char ch1;
		char ch2;
		do{
			ch1=(char)('a'+(Math.abs(generator.nextInt())%26));
			ch2=(char)('a'+(Math.abs(generator.nextInt())%26));
			output = randomChange(input,ch1,ch2);
			for(int i=0;i<output.length;i++){
				MyIO.print(output[i]);
			}
			MyIO.print("\n");
			input=MyIO.readLine();
		}while(!Equals(input,"FIM"));
	}
	public static char[] randomChange(String str,char ch1, char ch2){
		char[] chars=convertStringtoChar(str);
		for(int i=0;i<chars.length;i++){
			if(chars[i]==ch1){
				chars[i]=ch2;
			}
		}
		return chars;
	}
	/*
		Autor: Gabriel Lopes Ferreira
		Parametros: str
		Data de Modificação:04/02/2019
		Recebe uma String , e a converte em um array de char , para
		a manipulação do seu conteudo
	*/
	public static char[] convertStringtoChar(String str){
		char[] chars = new char[str.length()];
		char ch;
		for(int i=0;i<str.length();i++){
			ch=str.charAt(i);
			chars[i]=ch;
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
