public class TP01Q13{
	public static void main(String[]args){
		entradaeSaidaRecursivo();
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param s string para a conversão
		O metodo , converte a string para um vetor de char para a manipulação dos caracteres
		e seguida converte para cifra de cesar
	*/
	public static char[] convertToCesarRecursive(String s){
		char[] chars=new char[s.length()];
		return convertToCesarRecursive(s,0,chars);
	}
	public static char[] convertToCesarRecursive(String s,int i,char[] chars){
		if(i<s.length()){
			int ch=s.charAt(i)+3;
			char ch2=(char)ch;
			chars[i]=ch2;
			convertToCesarRecursive(s,i+1,chars);
		}
		return chars;
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		O metodo faz a leitura a partir da entrada padrão, faz a chamada do metodo contaLetrasMaiusculasRecursivo
		e imprime o resultado pela saida padrão
	*/
	public static void entradaeSaidaRecursivo(){
		String input=MyIO.readLine();
		char[] chars=convertToCesarRecursive(input);
		if(!equalsRecursivo(input,"FIM")){
			printlnCharArray(chars);
			entradaeSaidaRecursivo();
		}
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param chars array de char a ser impresso
		O metodo percorre o array e imprime o array
	*/
	public static void printlnCharArray(char[] chars){
		printlnCharArray(chars,0);
	}
	public static void printlnCharArray(char[] chars,int i){
		if(i < chars.length){
			MyIO.print(chars[i]);
			printlnCharArray(chars,i+1);
		}
		else{
			MyIO.print("\n");
		}
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param str1 primeira string para comparação
		@param str2 segunda string para comparação
		O metodo verifica se duas strings são iguais
	*/
	public static boolean equalsRecursivo(String str1,String str2){
		boolean isEquals=false;
		if(mesmoTamanho(str1,str2)){
			isEquals=equalsRecursivo(str1,str2,0);
		}
		return isEquals;
	}
	public static boolean equalsRecursivo(String str1,String str2,int i){
		boolean isEquals;
		if(i==str1.length()){
			isEquals=true;
		}
		else{
			if(str1.charAt(i)!=str2.charAt(i)){
				isEquals=false;
			}
			else{
				isEquals=equalsRecursivo(str1,str2,i+1);
			}
		}
		return isEquals;
	}
	public static boolean mesmoTamanho(String str1,String str2){
		return (str1.length()==str2.length());
	}
	
}