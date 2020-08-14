import java.util.Random;
public class TP01Q14{
	public static void main(String[]args){
		Random generator = new Random(4);
		entradaeSaidaRecursivo(generator);
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		O metodo faz a leitura a partir da entrada padrão, faz a chamada do metodo contaLetrasMaiusculasRecursivo
		e imprime o resultado pela saida padrão
	*/
	public static void entradaeSaidaRecursivo(Random generator){
		String input=MyIO.readLine();
		char ch1=(char)('a'+(Math.abs(generator.nextInt())%26));
		char ch2=(char)('a'+(Math.abs(generator.nextInt())%26));
		char[] chars=algebraBooleanRecursive(input,ch1,ch2);
		if(!equalsRecursivo(input,"FIM")){
			printlnCharArray(chars);
			entradaeSaidaRecursivo(generator);
		}
	}
	/*
		
	*/
	public static char[] algebraBooleanRecursive(String s,char ch1,char ch2){
		char[] chars=new char[s.length()];
		return algebraBooleanRecursive(s,0,chars,ch1,ch2);
	}
	public static char[] algebraBooleanRecursive(String s,int i,char[] chars,char ch1,char ch2){
		if(i<s.length()){
			int c=s.charAt(i);
			char c1=(char)c;
			if(c1==ch1){
				chars[i]=ch2;
			}
			else{
				chars[i]=c1;
			}
			algebraBooleanRecursive(s,i+1,chars,ch1,ch2);
		}
		return chars;
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