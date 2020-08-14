public class TP01Q16{
	public static void main(String[]args){
		entradaeSaidaRecursivo();
	}
	public static void entradaeSaidaRecursivo(){
		String input=MyIO.readLine();
		if(!equalsRecursivo(input,"FIM")){
			if(isVogalRecursive(input))MyIO.print("SIM ");
			else MyIO.print("NAO ");
			if(isConsoantRecursive(input))MyIO.print("SIM ");
			else MyIO.print("NAO ");
			if(isIntRecursive(input))MyIO.print("SIM ");
			else MyIO.print("NAO ");
			if(isRealRecursive(input)||isIntRecursive(input))MyIO.print("SIM");
			else MyIO.print("NAO");
			MyIO.print("\n");
			entradaeSaidaRecursivo();
		}
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param s uma string para verificação
		O metodo percorre a string e verifica se a mesma é um numero real
	*/
	public static boolean isRealRecursive(String s){
		return isRealRecursive(s,0,0);
	}
	public static boolean isRealRecursive(String s, int i,int virgulaouponto){
		boolean resp;
		boolean teste=true;
		if(i<s.length()){
			if(s.charAt(i)==44||s.charAt(i)==46){
				virgulaouponto++;
				teste=false;
			}
			if(teste&&s.charAt(i)<48||s.charAt(i)>57||virgulaouponto>1){
				resp=false;
			}
			else{
				resp=isRealRecursive(s,i+1,virgulaouponto);
			}
			
		}
		else{
			resp=true;
		}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param s uma string para verificação
		O metodo percorre a string e verifica se a mesma é um numero inteiro
	*/
	public static boolean isIntRecursive(String s){
		return isIntRecursive(s,0);
	}
	public static boolean isIntRecursive(String s,int i){
		boolean resp;
		if(i<s.length()){
			if(s.charAt(i)<48||s.charAt(i)>57){
				resp=false;
			}
			else{
				resp=isIntRecursive(s,i+1);
			}
		}
		else{
			resp=true;
		}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param s uma string para verificação
		O metodo percorre a string e verifica se a mesma é composta somente por consoantes
	*/
	public static boolean isConsoantRecursive(String s){
		return isConsoantRecursive(s,0);
	}
	public static boolean isConsoantRecursive(String s ,int i){
		boolean resp;
		if(i<s.length()){
			if(s.charAt(i)<'A'||s.charAt(i)>'Z'&&s.charAt(i)<'a'||s.charAt(i)>'z'){
				resp=false;
			}
			else if(s.charAt(i)=='A'||s.charAt(i)=='a'||s.charAt(i)=='E'||s.charAt(i)=='e'||s.charAt(i)=='I'||s.charAt(i)=='i'||s.charAt(i)=='O'||s.charAt(i)=='o'||s.charAt(i)=='U'||s.charAt(i)=='u'){
				resp=false;
			}
			else{
				resp=isConsoantRecursive(s,i+1);
			}
		}
		else{
			resp=true;
		}
		return resp;
	}
	/*
		@author Gabriel Lopes Ferreira
		@since 1.0
		@version 1.0
		@param s uma string para verificação
		O metodo percorre a string e verifica se a mesma é composta somente por vogais
	*/
	public static boolean isVogalRecursive(String s){
		return isVogalRecursive(s,0);
	}
	public static boolean isVogalRecursive(String s,int i){
		boolean resp;
		if(i<s.length()){
			if(s.charAt(i)!='A'&&s.charAt(i)!='a'&&s.charAt(i)!='E'&&s.charAt(i)!='e'&&s.charAt(i)!='I'&&s.charAt(i)!='i'&&s.charAt(i)!='O'&&s.charAt(i)!='o'&&s.charAt(i)!='U'&&s.charAt(i)!='u'){
				resp=false;
			}
			else{
				resp=isVogalRecursive(s,i+1);
			}
		}
		else{
			resp=true;
		}
		return resp;
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